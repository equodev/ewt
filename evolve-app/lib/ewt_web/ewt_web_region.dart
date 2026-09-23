// A comm-fed EWT region: subscribes to Evolve's per-region subtree channel and rebuilds
// the EWT subtree from the serialized node tree. Contains failures to this region.
import 'dart:convert';
import 'dart:typed_data';

import 'package:flutter/material.dart';
import 'package:swtflutter/src/comm/comm.dart';
import 'package:widgets_web/widgets_web.dart';

/// Outcome of applying one transport envelope: the new retained root, and whether the region
/// must ask Java for a full resend (patch arrived with no base, or a path failed to resolve).
class EnvelopeOutcome {
  final Map<String, dynamic>? root;
  final bool requestFull;
  const EnvelopeOutcome(this.root, this.requestFull);
}

EnvelopeOutcome applyEnvelope(
    Map<String, dynamic>? root, Map<String, dynamic> env) {
  final kind = env['kind'];
  if (kind == 'full') {
    return EnvelopeOutcome((env['node'] as Map).cast<String, dynamic>(), false);
  }
  if (kind == 'patch') {
    if (root == null) return EnvelopeOutcome(null, true);
    return EnvelopeOutcome(applyPatch(root, env['ops'] as List<dynamic>), false);
  }
  return EnvelopeOutcome(root, true); // unknown kind -> desync, request a full snapshot
}

class EwtWebRegion extends StatefulWidget {
  final int id;
  const EwtWebRegion({super.key, required this.id});

  @override
  State<EwtWebRegion> createState() => _EwtWebRegionState();
}

class _EwtWebRegionState extends State<EwtWebRegion>
    with TickerProviderStateMixin {
  Map<String, dynamic>? _root;
  late final String _subtreeChannel = 'EwtWidget/${widget.id}/subtree';
  late final String _animChannel = 'EwtWidget/${widget.id}/anim';

  /// Persists across rebuilds: maps Java ctrlId → live Dart AnimationController.
  final Map<int, AnimationController> _controllers = {};

  @override
  void initState() {
    super.initState();
    EquoCommService.onBytes(_subtreeChannel, _onSubtree);
    EquoCommService.onBytes(_animChannel, _onAnimCommand);
    // Ask the Java side to (re)send this region's subtree now that our handler is registered,
    // so a first frame flushed from the comm buffer before we subscribed is not lost.
    EquoCommService.send('$_subtreeChannel/request');
  }

  void _onSubtree(Uint8List bytes) {
    try {
      final env = json.decode(utf8.decode(bytes)) as Map<String, dynamic>;
      final outcome = applyEnvelope(_root, env);
      if (outcome.requestFull) {
        EquoCommService.send('$_subtreeChannel/request');
        return;
      }
      setState(() => _root = outcome.root);
    } catch (e, st) {
      debugPrint('EWT web region ${widget.id} subtree failed: $e\n$st');
      EquoCommService.send('$_subtreeChannel/request');
    }
  }

  void _onAnimCommand(Uint8List bytes) {
    try {
      final cmd = json.decode(utf8.decode(bytes)) as Map<String, dynamic>;
      final ctrlId = cmd['ctrlId'] as int;
      final action = cmd['action'] as String;
      final ctrl = _controllers[ctrlId];
      if (ctrl == null) {
        debugPrint('EWT web anim: unknown ctrlId=$ctrlId action=$action');
        _maybeReplyCallback(cmd, ok: false);
        return;
      }

      // Async format: `{"ctrlId":..,"action":"..","callbackId":..,"args":[..]}`.
      // Distinguished from the legacy void format by the presence of `callbackId`.
      // Actions in this branch return a TickerFuture (or a plain Future) that we
      // subscribe to; the callback id round-trips through the callback channel.
      if (cmd.containsKey('callbackId')) {
        final args = (cmd['args'] as List?) ?? const [];
        final fut = _invokeAsyncAction(ctrl, action, args);
        if (fut == null) {
          debugPrint('EWT web anim: unknown async action=$action');
          _maybeReplyCallback(cmd, ok: false);
          return;
        }
        fut.whenComplete(() => _maybeReplyCallback(cmd, ok: true));
        return;
      }

      // Legacy void format — kept for setDuration/setReverseDuration/setValue,
      // plus stop/reset. Encoded as `action:<primitive>` for the setters that
      // need a value payload.
      if (action.startsWith('setDuration:')) {
        ctrl.duration = Duration(milliseconds: int.parse(action.substring('setDuration:'.length)));
      } else if (action.startsWith('setReverseDuration:')) {
        ctrl.reverseDuration = Duration(milliseconds: int.parse(action.substring('setReverseDuration:'.length)));
      } else if (action.startsWith('setValue:')) {
        ctrl.value = double.parse(action.substring('setValue:'.length));
      } else switch (action) {
        case 'stop':   ctrl.stop();
        case 'reset':  ctrl.reset();
        // repeat:reverse remains for the boolean-arg repeat overload injected
        // by ImperativeControllerGen's extraJavaBody; the plain repeat/forward/
        // reverse cases moved to the async branch above.
        case 'repeat:reverse': ctrl.repeat(reverse: true);
        default: debugPrint('EWT web anim: unknown legacy action=$action');
      }
    } catch (e, st) {
      debugPrint('EWT web region ${widget.id} anim command failed: $e\n$st');
    }
  }

  /// Dispatches an async command by name. Returns the resulting Future, or null
  /// if the action name is not recognized. Args come from the JSON payload —
  /// primitives only (double, int for milliseconds, etc.).
  Future<void>? _invokeAsyncAction(AnimationController ctrl, String action, List<dynamic> args) {
    switch (action) {
      case 'forward':
        return ctrl.forward();
      case 'reverse':
        return ctrl.reverse();
      case 'repeat':
        return ctrl.repeat();
      case 'toggle':
        return ctrl.toggle();
      case 'fling':
        final velocity = (args.isNotEmpty ? (args[0] as num).toDouble() : 1.0);
        return ctrl.fling(velocity: velocity);
      case 'animateTo':
        // args: [target: double, durationMs: int]. Curve is deferred (see
        // docs/gen_structure.md §4); default is linear on both sides.
        final target = (args[0] as num).toDouble();
        final ms = (args[1] as num).toInt();
        return ctrl.animateTo(target, duration: Duration(milliseconds: ms));
      case 'animateBack':
        final target = (args[0] as num).toDouble();
        final ms = (args[1] as num).toInt();
        return ctrl.animateBack(target, duration: Duration(milliseconds: ms));
      default:
        return null;
    }
  }

  /// Replies to a callback command via the region's callback channel, matching
  /// what `ewtActiveCallbackSink` sends for regular UI callbacks (button taps,
  /// text changes). Value is always null for animation completion — the Java
  /// side does not care about the return value of TickerFuture-typed methods.
  void _maybeReplyCallback(Map<String, dynamic> cmd, {required bool ok}) {
    final cbId = cmd['callbackId'];
    if (cbId is! int) return;
    // Failure-vs-success is not distinguished on the Java side today (the
    // broker only exposes `complete`, not `completeExceptionally`, over the
    // channel). `ok=false` still resolves the future to unblock the caller,
    // but a stderr trace tells operators what went wrong. Extending the
    // channel with an error variant is a follow-up.
    EquoCommService.sendPayload(
        'EwtWidget/${widget.id}/callback', <Object?>[cbId, null]);
  }

  @override
  void dispose() {
    EquoCommService.remove(_subtreeChannel);
    EquoCommService.remove(_animChannel);
    for (final c in _controllers.values) {
      c.dispose();
    }
    _controllers.clear();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final root = _root;
    if (root == null) return const SizedBox.shrink();
    // Bind region globals for the synchronous decode: callback sink, build context,
    // and the animated-state ticker/registry so controller factories can wire up.
    ewtActiveBuildContext = context;
    ewtActiveCallbackSink = (cid, args) =>
        EquoCommService.sendPayload('EwtWidget/${widget.id}/callback', [cid, ...args]);
    ewtActiveTickerProvider = this;
    ewtActiveControllerRegistry = _controllers;
    final Widget decoded;
    try {
      decoded = decodeEwtWidget(root);
    } finally {
      ewtActiveCallbackSink = null;
      ewtActiveBuildContext = null;
      ewtActiveTickerProvider = null;
      ewtActiveControllerRegistry = null;
    }
    return ClipRect(child: decoded);
  }
}
