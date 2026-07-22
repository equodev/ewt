// EWT web callback wiring. Pure Dart, comm-free: the region injects a sink that forwards a
// callback id (and any value arg) over the Evolve comm; generated decoders call these helpers.
import 'package:flutter/widgets.dart';

typedef EwtCallbackSink = void Function(int callbackId, List<Object?> args);

// Set by the region immediately before decoding its subtree, cleared after. Decode is
// synchronous, so each wired closure captures its own region's sink.
EwtCallbackSink? ewtActiveCallbackSink;

// Zero-arg callback: sends [id] (no args). Always non-null; a no-op when there is no id or sink.
VoidCallback ewtWireCallback(Object? id) {
  final sink = ewtActiveCallbackSink;
  if (id is! int || sink == null) return () {};
  return () => sink(id, const []);
}

// Value callback (bool/String): sends [id, value]. Typed as void Function(dynamic) so it is
// assignable to ValueChanged<bool> and ValueChanged<String>. A no-op when there is no id or sink.
void Function(dynamic) ewtWireValueCallback(Object? id) {
  final sink = ewtActiveCallbackSink;
  if (id is! int || sink == null) return (_) {};
  return (v) => sink(id, [v]);
}

// The region's BuildContext, bound during the synchronous decode so context-resolving decoders
// (e.g. themeOf -> Theme.of(context)) resolve against the real widget tree.
BuildContext? ewtActiveBuildContext;
