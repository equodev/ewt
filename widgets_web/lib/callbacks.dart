// EWT web callback wiring. Pure Dart, comm-free: the region injects a sink that
// forwards a callback id over the Evolve comm; generated decoders call ewtWireCallback.
import 'package:flutter/widgets.dart';

typedef EwtCallbackSink = void Function(int callbackId);

// Set by the region immediately before decoding its subtree, cleared after. Decode is
// synchronous, so each wired closure captures its own region's sink.
EwtCallbackSink? ewtActiveCallbackSink;

// Binds the sink active at decode time to the recorded callback id. Always returns a
// non-null VoidCallback (assignable to both VoidCallback and VoidCallback?); a no-op when
// there is no id (e.g. an unprovided optional callback) or no active sink.
VoidCallback ewtWireCallback(Object? id) {
  final sink = ewtActiveCallbackSink;
  if (id is! int || sink == null) return () {};
  return () => sink(id);
}
