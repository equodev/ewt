part of '../../gen.dart';

/// Dart source expression that marshals a Dart value INTO C. Two entry
/// paths fold into one:
///
///   * "forward" (fromCallback=false): [WidgetGen.writeDInstanceMethod]
///     feeds the Dart factory result back through the C typedef pointer.
///   * "callback" (fromCallback=true): a Dart callback invoked from
///     Flutter runtime pushes its return value back into a C slot.
///     TypeParameterType and nullable bool have distinct shapes on this
///     path (see the `int*` / `DartObj*` typedef notes below).
///
/// Was `Params.paramValueDtoC`.
class DartToC extends SerializeStrategy {
  final bool fromCallback;
  const DartToC({this.fromCallback = false});

  @override
  String apply(Types types, ParameterElement param) {
    var t = param.type;
    if (t is TypeParameterType) {
      final value = ensureName(param);
      if (fromCallback) {
        // TypeParameterType params in callbacks: the C typedef alternates
        // between `DartObj` (int by value) when the source is non-nullable
        // T, and `DartObj*` (pointer) when it is nullable T? (isOptional).
        // Mirrors the Java-side dispatch in paramValueFFMtoJ.
        if (param.isOptional) {
          return '($value != null) ? (calloc<ffi.Int>()..value = _addWidget($value)) : ffi.nullptr';
        }
        return '_addWidget($value)';
      }
      t = t.bound;
    }
    // A nullable bool crossing back through a callback is typed `int*` in
    // C (typedefs.h); marshal as a pointer: allocate an int for a real
    // value, or nullptr for null. The Java side reads it with memToBool.
    if (fromCallback && t.isDartCoreBool && t.nullabilitySuffix == NullabilitySuffix.question) {
      final value = ensureName(param);
      return '($value != null) ? (calloc<ffi.Int>()..value = ($value! ? 1 : 0)) : ffi.nullptr';
    }
    if (t is! InterfaceType) return ensureName(param);
    final inner = dispatchInterface(types, param, t);
    // Non-primitive objects encode their own null-passing — the base
    // dartToC(name) is invoked with the raw param name, no !, no ternary
    // wrap. Only primitives / enums / String / List get the null-check
    // ternary when the source param is optional.
    if (!param.isOptional) return inner;
    if (!isPrimitive(t) && t.element is! EnumElement) return inner;
    final nul = (t.isDartCoreString || t.isDartCoreList) ? 'ffi.nullptr' : '0';
    return '(${param.name} != null) ? $inner : $nul';
  }

  /// Adds `!` to the param name when the source is optional or nullable —
  /// matches the null-safety cast the FFI stub requires.
  String _v(ParameterElement param, InterfaceType t) {
    final value = ensureName(param);
    final needsBang = param.isOptional || t.nullabilitySuffix == NullabilitySuffix.question;
    return needsBang ? '$value!' : value;
  }

  @override
  String onString(Types types, ParameterElement param, InterfaceType t) =>
      '${_v(param, t)}.toNativeUtf8().cast<ffi.Char>()';

  @override
  String onBool(Types types, ParameterElement param, InterfaceType t) =>
      '${_v(param, t)}.toInt()';

  @override
  String onInt(Types types, ParameterElement param, InterfaceType t) => _v(param, t);

  @override
  String onDouble(Types types, ParameterElement param, InterfaceType t) => _v(param, t);

  @override
  String onList(Types types, ParameterElement param, InterfaceType t) {
    final arrayType = t.typeArguments[0];
    return isPrimitive(arrayType)
        ? '${_v(param, t)}.strListToC()'
        : '${_v(param, t)}.toArrayC()';
  }

  @override
  String onEnum(Types types, ParameterElement param, InterfaceType t) =>
      '${_v(param, t)}.index';

  @override
  String onObject(Types types, ParameterElement param, InterfaceType t) {
    // On the callback path, C hands us a plain int id (per the C typedef —
    // see FunctionHandler.type4C which maps everything through DartObj).
    // Emitting `_create<Widget>ObjSt(value)` would push a struct through
    // an int-typed slot; register the widget by id and pass that.
    if (fromCallback) return '_addWidget(${ensureName(param)})';
    return types.getGen(t.element).dartToC(ensureName(param));
  }
}
