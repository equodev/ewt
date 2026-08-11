/// Per-widget emission state shared across the language emitters.
///
/// Groups the raw output buffers plus the deferred C struct-header token.
/// Splitting this out of `WidgetGen` lets each emitter (Java, C, Dart, Web)
/// operate on `EmitContext` directly instead of the god-object, and lets
/// tests inspect emitted output without instantiating a `WidgetGen`.
class EmitContext {
  final StringBuffer javaFile = StringBuffer();
  final StringBuffer builderFile = StringBuffer();
  final StringBuffer headerFile = StringBuffer();
  final StringBuffer objectsHFile = StringBuffer();
  final StringBuffer dartAssigns = StringBuffer();
  final StringBuffer dartFns = StringBuffer();
  final StringBuffer javaFactories = StringBuffer();
  final StringBuffer javaSerializer = StringBuffer();
  final StringBuffer dartWebDecoders = StringBuffer();
  final StringBuffer javaStatics = StringBuffer();

  /// Header line for a widget's C struct, emitted lazily on the first field
  /// so widgets with no C members skip the empty struct entirely.
  String? pendingStructHeader;
}
