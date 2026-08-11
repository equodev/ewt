part of '../../gen.dart';

/// Emitter for `ColorSwatch<T>` subtypes — currently `MaterialColor`
/// (shades 50, 100, 200, …, 900) and structurally-eligible for
/// `MaterialAccentColor` (shades 100, 200, 400, 700) whenever added to
/// the index.
///
/// Diverges from a stock @Immutable widget in three spots:
///
///   * **Serializer**: the shade accessors (`shade50()`, `shade100()`, …)
///     get pre-populated in the *ObjSt struct from the swatch map at
///     record time, so they return concrete Color nodes off-native.
///   * **Web decoder**: rebuild from `primary` with an empty swatch —
///     the swatch Map can't cross the wire, but is never needed since
///     the shade accessors are pre-resolved above.
///   * **Field accessor**: skip the web branch entirely for shade
///     accessors (they were already pre-resolved at serialize time,
///     so the accessor-node path would produce a null-crash off-native).
///
/// Shade set is discovered structurally from `callableFields()` — for
/// MaterialColor that's 50..900; for MaterialAccentColor it would be
/// {100, 200, 400, 700}. No per-widget hardcoding.
class ColorSwatchGen extends ImmutableGen {
  ColorSwatchGen(super.types, super.dartClass);

  @override
  bool get skipWebFieldAccessor => true;

  @override
  void emitExtraJavaSerializerFields(String factoryName, String objStClass) {
    // Only fill the shade struct fields for the "primary" factory —
    // named factories on ColorSwatch subclasses (if any) don't carry a
    // swatch parameter.
    if (factoryName != '$widgetField$widgetClass') return;
    final shades = callableFields()
        .where((f) => RegExp(r'^shade\d+$').hasMatch(f.name))
        .toList()
      ..sort((a, b) => int.parse(a.name.substring(5)).compareTo(int.parse(b.name.substring(5))));
    for (final field in shades) {
      final key = field.name.substring(5);
      ctx.javaSerializer.writeln('    $objStClass.${field.name}(st, swatch.get($key) != null ? swatch.get($key).getId() : 0);');
    }
  }

  @override
  bool tryEmitCustomWebDecoder(String factory, String factoryName, FunctionTypedElement node) {
    if (factoryName != '$widgetField$widgetClass') return false;
    ctx.dartWebDecoders.writeln("  '$factoryName': (p) => $widgetClass(p['primary'] as int, const <int, Color>{}),");
    return true;
  }
}
