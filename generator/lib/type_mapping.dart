import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

import 'types.dart';

/// A resolved Dart type expressed in the three surfaces the generator emits:
/// Java signatures, C headers, and Dart FFI declarations.
///
/// Every "how do I write this type in X?" decision funnels through
/// [TypeMapping.resolve] so the three surfaces stay consistent by construction.
/// Previously the same DartType was walked three times (`type4J`, `type4C`,
/// `type4D`), each with its own subtly divergent ordering / defaults;
/// discrepancies between them surfaced as opaque widening (NativeObj / DartObj
/// / Object) that downstream code reconstructed with unchecked casts.
class TypeTriple {
  final String java;
  final String c;
  final String dart;

  const TypeTriple(this.java, this.c, this.dart);

  /// Widening for opaque object references (dynamic, unbound type params,
  /// dart:core Object). Same result across all three surfaces.
  static const opaque = TypeTriple('NativeObj', 'DartObj', 'DartObj');
}

/// Single source of truth for Dart → (Java, C, FFI-Dart) type translation.
///
/// Holds a back-reference to [Types] to reach the shared analyzer state
/// (widgets set, handlers, requiredTypes accumulator, and getGen for
/// non-primitive types).
class TypeMapping {
  final Types _t;

  TypeMapping(this._t);

  /// Translates a [DartType] into the three-surface [TypeTriple].
  ///
  /// Also mirrors the side effect [Types.type4J] had at its top: reachable
  /// non-primitive types are recorded via [Types.addRequiredType] so the
  /// generator emits their supporting classes. Callers that only need one
  /// surface (`type4C`, `type4D`) previously did not trigger this recording,
  /// so unifying here can pull in slightly more types than before —
  /// intentional, matches the intent of "single source of truth".
  TypeTriple resolve(DartType t) {
    if (!isPrimitive(t) && _t.supportedType(t)) {
      _t.addRequiredType(t);
    }
    // Custom handlers (Map<int, T>, callbacks) take precedence over the
    // generic branches: they own bespoke type-string logic that would
    // otherwise collide with the InterfaceType / FunctionType fallbacks.
    final h = _t.getHandler(t);
    if (h != null) {
      return TypeTriple(h.type4J(t), h.type4C(t), h.type4D(t));
    }
    // Dynamic / unbound type parameters / dart:core Object: opaque
    // NativeObj+DartObj widening.
    if (t is DynamicType || t is TypeParameterType || t.isDartCoreObject) {
      return TypeTriple.opaque;
    }
    if (t is VoidType) {
      // Only `type4C` handled void at top level; `type4J` and `type4D` were
      // never called with void (return-type helpers filter it upstream).
      // Reporting the same string on all three surfaces keeps the API safe if
      // a caller drifts.
      return const TypeTriple('void', 'void', 'void');
    }
    if (t.isDartCoreString) {
      return const TypeTriple('String', 'char*', 'ffi.Pointer<ffi.Char>');
    }
    if (t.isDartCoreBool) {
      return const TypeTriple('boolean', 'int', 'ffi.Int');
    }
    if (t.isDartCoreInt) {
      return const TypeTriple('int', 'int', 'ffi.Int');
    }
    if (t.isDartCoreDouble) {
      return const TypeTriple('double', 'double', 'ffi.Double');
    }
    if (t.isDartCoreNum) {
      return const TypeTriple('num', 'num', 'ffi.Num');
    }
    if (t.element is EnumElement) {
      // Java carries the enum by its Dart name; C/FFI-Dart marshal it as int.
      return TypeTriple(t.element!.name!, 'int', 'ffi.Int');
    }
    if (t.isDartCoreList) {
      final at = (t as InterfaceType).typeArguments[0];
      final atTriple = resolve(at);
      // Java generics reject primitives — `List<double>` must be `List<Double>`.
      final javaList = 'List<${boxedType(atTriple.java.firstUpper())}>';
      // C/FFI-Dart: primitive-inner lists cross as raw pointers; opaque-inner
      // lists cross as ArrayC (a length-prefixed struct).
      final cList = isPrimitive(at) ? '${atTriple.c}*' : 'ArrayC';
      final dList = isPrimitive(at) ? 'ffi.Pointer<${atTriple.dart}>' : 'ArrayC';
      return TypeTriple(javaList, cList, dList);
    }
    if (t is InterfaceType && !isPrimitive(t)) {
      // Concrete classes: Java uses the element name; C/FFI-Dart use the
      // corresponding *ObjSt struct name (or DartObj for id-passthrough).
      final objType = _t.getGen(t.element).objType();
      return TypeTriple(t.element.name, objType, objType);
    }
    // Fallback: unreachable for supported types, but symmetric across surfaces.
    final display = t.getDisplayString(withNullability: false);
    return TypeTriple(display, display, display);
  }
}

extension _CapitalizeExt on String {
  String firstUpper() => isEmpty ? this : '${this[0].toUpperCase()}${substring(1)}';
}
