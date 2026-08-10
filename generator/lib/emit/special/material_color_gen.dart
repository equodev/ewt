part of '../../gen.dart';

/// Emitter for Flutter's `MaterialColor` — the Color subclass carrying a
/// primary ARGB int plus a swatch `Map<int, Color>`.
///
/// Two divergent shapes vs. a stock ObjSt widget:
///
///   * The Java serializer fills the *ObjSt struct's `shadeXXX` int fields
///     with the swatch color ids so that
///     `MaterialColor.shade50()` etc. return their concrete Color node
///     off-native.
///   * The web decoder rebuilds the MaterialColor from `primary` with an
///     empty swatch — the swatch never crosses the wire, and the shade
///     accessors are pre-resolved at serialize time (previous point).
///     The Map-typed swatch param would otherwise disqualify the widget
///     from the pure-Dart decoder path.
///   * [ObjStGen.writeJavaFieldAccessor] skips its web branch for shade
///     accessors — the materialColorMaterialColor serializer already
///     populated the native struct fields.
class MaterialColorGen extends ImmutableGen {
  MaterialColorGen(super.types, super.dartClass);

  @override
  void emitExtraJavaSerializerFields(String factoryName, String objStClass) {
    if (factoryName != 'materialColorMaterialColor') return;
    for (final k in const [50, 100, 200, 300, 400, 500, 600, 700, 800, 900]) {
      ctx.javaSerializer.writeln('    $objStClass.shade$k(st, swatch.get($k) != null ? swatch.get($k).getId() : 0);');
    }
  }

  @override
  bool tryEmitCustomWebDecoder(String factory, String factoryName, FunctionTypedElement node) {
    if (factoryName != 'materialColorMaterialColor') return false;
    ctx.dartWebDecoders.writeln("  '$factoryName': (p) => MaterialColor(p['primary'] as int, const <int, Color>{}),");
    return true;
  }

  @override
  bool get skipWebFieldAccessor => true;
}
