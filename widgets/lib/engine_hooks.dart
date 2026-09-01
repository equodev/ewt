// widgets/lib/engine_hooks.dart
//
// Wires three native callbacks into Flutter's engine:
//
//   1. Post-frame snapshot — depth-first JSON of the Element tree, pushed to
//      native via callPostFrameCallback after every armed rebuild.
//   2. FlutterError forwarding — replaces FlutterError.onError so every
//      framework error reaches native without also printing to CI logs.
//   3. Rebuild handler — a C-callable Dart function that increments the frame
//      id, arms the next snapshot, and triggers a root swap via a ValueNotifier.
//
// Bootstrap decision: the very first persistent frame callback fires
// callPostFrameCallback(_frameId, "[]", 2) regardless of the arm flag so
// that Task 2.3's EngineHandle.firstFrameReady() can complete on that first
// upcall without needing any special Java-side polling.  After the first call
// the bootstrap flag is cleared and subsequent snapshots fire only when armed.

import 'dart:convert';
import 'dart:ffi';

import 'package:ffi/ffi.dart';
import 'package:flutter/widgets.dart';

import 'widgets.dart' as w;

// ──────────────────────────────────────────────────────────────
// Module-level state
// All accessed only from the Flutter UI isolate — no locks needed.
// ──────────────────────────────────────────────────────────────

/// Monotonically increasing frame counter.  Incremented before each armed
/// rebuild so the Java side can correlate snapshots with specific requests.
int _frameId = 0;

/// When true the next persistent-frame callback will capture a snapshot and
/// push it via callPostFrameCallback, then clear itself.
bool _captureNext = false;

/// True only for the very first persistent-frame fire; clears after one call
/// so subsequent callbacks only push on armed rebuilds.
bool _bootstrapPending = true;

/// Holds the currently displayed root widget.  Mutating its value schedules
/// a Flutter rebuild via `ValueListenableBuilder<Widget>` in main.dart.
ValueNotifier<Widget>? _rootHolder;

/// Produces a fresh root widget when a native rebuild is requested.  The
/// callback is expected to call back into Java (callToBuildWidgetTree) and
/// return whatever the Java builder delivers.
Widget Function()? _rebuildRoot;

/// Owns the `NativeCallable.listener` for the rebuild handler.  Kept alive
/// at module scope so the native pointer stays valid for the process lifetime;
/// if this reference is GC'd, C will hold a dangling pointer.
NativeCallable<Void Function()>? _rebuildCallable;

// ──────────────────────────────────────────────────────────────
// Public API
// ──────────────────────────────────────────────────────────────

/// Installs the three native hooks.  Call once, after [WidgetsFlutterBinding]
/// is initialised but before [runApp].
///
/// [rootHolder]   — the ValueNotifier fed to a `ValueListenableBuilder<Widget>`
///                  that sits at the root of runApp.
/// [rebuildRoot]  — called by the native rebuild handler to produce the next
///                  root Widget (typically invokes callToBuildWidgetTree).
void attachEngineHooks({
  required ValueNotifier<Widget> rootHolder,
  required Widget Function() rebuildRoot,
}) {
  _rootHolder = rootHolder;
  _rebuildRoot = rebuildRoot;

  // 1. Persistent post-frame snapshot callback.
  WidgetsBinding.instance.addPersistentFrameCallback(_onPostFrame);

  // 2. FlutterError forwarding — do not delegate to the default handler so
  //    CI output stays quiet (native collector has everything).
  FlutterError.onError = _onFlutterError;

  // 3. Register the C-callable rebuild handler.
  //    Use NativeCallable.listener rather than Pointer.fromFunction: the
  //    Flutter Linux embedder runs the UI/isolate thread separately from the
  //    GTK platform thread, and Starter_requestRebuild hops through
  //    g_main_context_invoke onto the GTK thread.  A raw Pointer.fromFunction
  //    executes on the caller's thread — GTK, which has no isolate — and
  //    trips `Cannot invoke native callback outside an isolate`.  A listener
  //    callable posts a message to the isolate that created it, so
  //    _onRebuildRequested runs on the UI thread regardless of where C
  //    invokes the pointer.
  _rebuildCallable =
      NativeCallable<Void Function()>.listener(_onRebuildRequested);
  w.setRebuildHandler(_rebuildCallable!.nativeFunction);
}

// ──────────────────────────────────────────────────────────────
// Callback implementations (top-level — Dart FFI constraint)
// ──────────────────────────────────────────────────────────────

/// Called by native (via the C rebuild-handler pointer) when Java wants a
/// fresh widget tree.  Must be a top-level function for Pointer.fromFunction.
void _onRebuildRequested() {
  _frameId++;
  _captureNext = true;
  final holder = _rootHolder;
  final builder = _rebuildRoot;
  if (holder != null && builder != null) {
    holder.value = builder();
  }
}

// ──────────────────────────────────────────────────────────────
// Private helpers
// ──────────────────────────────────────────────────────────────

void _onPostFrame(Duration _) {
  if (_bootstrapPending) {
    // Fire once unconditionally so EngineHandle.firstFrameReady() can
    // unblock without requiring any armed rebuild.
    _bootstrapPending = false;
    _pushSnapshot(_frameId, '[]');
    return;
  }
  if (!_captureNext) return;
  _captureNext = false;
  final json = _captureElementTreeSnapshot();
  _pushSnapshot(_frameId, json);
}

void _onFlutterError(FlutterErrorDetails details) {
  final kind = details.exception.runtimeType.toString();
  final msg = details.exceptionAsString();
  final stk = (details.stack ?? StackTrace.empty).toString();

  final pKind = kind.toNativeUtf8();
  final pMsg = msg.toNativeUtf8();
  final pStk = stk.toNativeUtf8();
  try {
    w.callFlutterErrorCallback(
        _frameId, pKind.cast(), pMsg.cast(), pStk.cast());
  } finally {
    calloc.free(pKind);
    calloc.free(pMsg);
    calloc.free(pStk);
  }
}

void _pushSnapshot(int frameId, String json) {
  final bytes = utf8.encode(json);
  // toNativeUtf8 allocates with calloc; we free in finally.
  final ptr = json.toNativeUtf8();
  try {
    w.callPostFrameCallback(frameId, ptr.cast(), bytes.length);
  } finally {
    calloc.free(ptr);
  }
}

/// Depth-first walk of the Element tree starting at
/// [WidgetsBinding.instance.rootElement].
///
/// Each element produces one JSON object:
///   {"t":"WidgetType","d":depth,"r":hasRO[,"s":true,"w":W,"h":H][,"k":"key"]}
///
/// "s"/"w"/"h" are emitted only when the RenderObject is a RenderBox with
/// hasSize == true.  "k" is emitted only when widget.key != null.
String _captureElementTreeSnapshot() {
  final root = WidgetsBinding.instance.rootElement;
  if (root == null) return '[]';

  final sb = StringBuffer('[');
  var first = true;

  void visit(Element element, int depth) {
    if (!first) sb.write(',');
    first = false;

    final ro = element.renderObject;
    final hasRO = ro != null;
    final isBox = ro is RenderBox && ro.hasSize;
    final key = element.widget.key;

    sb.write('{"t":');
    sb.write(jsonEncode(element.widget.runtimeType.toString()));
    sb.write(',"d":');
    sb.write(depth);
    sb.write(',"r":');
    sb.write(hasRO);

    if (isBox) {
      final sz = (ro).size;
      sb.write(',"s":true,"w":');
      sb.write(sz.width);
      sb.write(',"h":');
      sb.write(sz.height);
    }

    if (key != null) {
      sb.write(',"k":');
      sb.write(jsonEncode(key.toString()));
    }

    sb.write('}');

    element.visitChildren((child) => visit(child, depth + 1));
  }

  visit(root, 0);
  sb.write(']');
  return sb.toString();
}
