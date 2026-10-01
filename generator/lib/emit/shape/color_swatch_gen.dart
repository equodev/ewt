part of '../../gen.dart';

/// Emitter for `ColorSwatch<T>` subtypes — currently `MaterialColor`
/// (shades 50, 100, 200, …, 900) and structurally-eligible for
/// `MaterialAccentColor` (shades 100, 200, 400, 700) whenever added to
/// the index.
///
/// Diverges from a stock @Immutable widget in one spot:
///
///   * **Web decoder**: rebuild the swatch from the recorded node-map so
///     the shade accessors (`shade50()`, `shade100()`, …) resolve. The
///     serializer records the full swatch as a `{shade -> Color node}`
///     map on the MaterialColor node (see SerializingWidgetConstructors.
///     materialColorMaterialColor), so the decoder rehydrates it into a
///     `Map<int, Color>` instead of an empty map — otherwise `.shadeNNN`
///     reads a null off an empty swatch and crashes off-native.
///
/// The shade accessors themselves go through the stock value-object
/// comm/web branch (record an accessor node, return a node-backed Color),
/// exactly like any other value-object getter — no FFM read-back, so they
/// work on the comm transport (JVM < 22).
class ColorSwatchGen extends ImmutableGen {
  ColorSwatchGen(super.types, super.dartClass);

  @override
  bool tryEmitCustomWebDecoder(String factory, String factoryName, FunctionTypedElement node) {
    if (factoryName != '$widgetField$widgetClass') return false;
    // Rebuild the swatch from the recorded `{shade -> Color node}` map so the shade accessors
    // resolve. Defensive about shape: older captures recorded `swatch` as a bare int id (not a
    // node map), and nothing guarantees each value is a node — so anything that is not a decodable
    // Color node is skipped, falling back to an empty swatch (the prior behaviour) instead of
    // throwing. An empty swatch only loses `.shadeNNN` reads, which only the new serializer emits
    // (and it always records node-map values), so the two never co-occur.
    ctx.dartWebDecoders.writeln("  '$factoryName': (p) {");
    ctx.dartWebDecoders.writeln("    final __sw = <int, Color>{};");
    ctx.dartWebDecoders.writeln("    final __raw = p['swatch'];");
    ctx.dartWebDecoders.writeln("    if (__raw is Map) { __raw.forEach((k, v) { if (v is Map) { final __c = decodeEwtNode(v.cast<String, dynamic>()); if (__c is Color) __sw[int.parse(k.toString())] = __c; } }); }");
    ctx.dartWebDecoders.writeln("    return $widgetClass(p['primary'] as int, __sw);");
    ctx.dartWebDecoders.writeln("  },");
    return true;
  }
}
