part of '../../gen.dart';

/// Marker interface: the three "how do I encode a Dart param value on this
/// side of the bridge?" strategies. F5a extracts the current implementations
/// as top-level functions in [to_c.dart], [to_dart.dart], and [to_json.dart];
/// F5b will collapse their shared dispatch (primitive → list → enum → object
/// → handler) behind a single visitor.
///
/// Left intentionally empty — the concrete signatures diverge (`fromCallback`
/// only makes sense for the Dart→C direction). Callers currently use the
/// top-level functions directly; the interface is a documentation anchor for
/// the follow-up dedupe pass.
abstract class SerializeStrategy {}
