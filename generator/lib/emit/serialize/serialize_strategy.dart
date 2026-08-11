part of '../../gen.dart';

/// Template Method + Strategy for the "how do I encode a Dart param value
/// on this side of the bridge?" problem.
///
/// Three concrete strategies, one per direction of the bridge:
///
///   * [FfiToDart]  — reads an FFI-typed value coming BACK into a Dart
///                    factory call site (was `Params.paramValue4D`)
///   * [DartToC]    — writes a Dart value INTO a C typedef pointer slot
///                    (was `Params.paramValueDtoC`)
///   * [JsonToDart] — decodes a Dart value from a JSON node's params map
///                    (was `Params._paramValueJsonRaw`)
///
/// Structure:
///
///   * [apply] is the entry point. Each strategy overrides it to handle
///     its own pre-dispatch special cases (TypeParameterType for DartToC,
///     `_webSkippable` for JsonToDart, etc.) and to add post-processing
///     (isNamed prefix, optional wrap).
///
///   * [dispatchInterface] is the shared kind switch — the ~10-line
///     if/else over `t.isDartCoreString`, `t.isDartCoreBool`, … that used
///     to be copy-pasted across all three implementations. It delegates
///     to the abstract `on*` hooks below.
///
///   * Each `on*` hook is small and self-contained. It handles both the
///     required and optional flavor of its kind internally (via
///     `param.isOptional` / `t.nullabilitySuffix`), so the base class
///     doesn't have to split first on optional-ness.
///
/// Adding a new strategy means implementing the 8 `on*` hooks plus the
/// pre/post special cases in `apply` — no more copy-pasting a 100-line
/// function.
abstract class SerializeStrategy {
  const SerializeStrategy();

  /// Emit the Dart expression for [param] under this strategy.
  String apply(Types types, ParameterElement param);

  /// Shared kind switch over an [InterfaceType]. Called by concrete
  /// `apply()` implementations once they've handled their strategy-specific
  /// pre-cases.
  String dispatchInterface(Types types, ParameterElement param, InterfaceType t) {
    if (t.isDartCoreString) return onString(types, param, t);
    if (t.isDartCoreBool) return onBool(types, param, t);
    if (t.isDartCoreInt) return onInt(types, param, t);
    if (t.isDartCoreDouble) return onDouble(types, param, t);
    if (t.isDartCoreList) return onList(types, param, t);
    if (t.isDartCoreMap) return onMap(types, param, t);
    if (t.element is EnumElement) return onEnum(types, param, t);
    return onObject(types, param, t);
  }

  String onString(Types types, ParameterElement param, InterfaceType t);
  String onBool(Types types, ParameterElement param, InterfaceType t);
  String onInt(Types types, ParameterElement param, InterfaceType t);
  String onDouble(Types types, ParameterElement param, InterfaceType t);
  String onList(Types types, ParameterElement param, InterfaceType t);
  String onEnum(Types types, ParameterElement param, InterfaceType t);
  String onObject(Types types, ParameterElement param, InterfaceType t);

  /// Default: strategies that never see a `Map<K, V>` param at runtime
  /// (currently DartToC and FfiToDart — MapHandler intercepts `Map<int, X>`
  /// upstream) can fall through to [onObject]. JsonToDart overrides.
  String onMap(Types types, ParameterElement param, InterfaceType t) =>
      onObject(types, param, t);
}
