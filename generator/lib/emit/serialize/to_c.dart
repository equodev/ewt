part of '../../gen.dart';

/// Dart source expression that marshals a Dart param value INTO a C value
/// ready to cross the FFI boundary. Two entry points fold into one function:
///
///   * "forward" direction (fromCallback=false): used by
///     [WidgetGen.writeDInstanceMethod] to feed the Dart-side factory result
///     back through the C typedef pointer.
///   * "callback" direction (fromCallback=true): used when a Dart callback
///     is invoked from Flutter runtime and its return value must be pushed
///     back into a C slot. TypeParameterType and nullable bool have distinct
///     shapes on this path — see the `int*`/`DartObj*` typedef notes below.
///
/// Callers exposed via [Params.paramValueDtoC].
String dartToCParamValue(Types ctx, ParameterElement param, {bool fromCallback = false}) {
  var t = param.type;
  if (t is TypeParameterType) {
    final value = ensureName(param);
    if (fromCallback) {
      // TypeParameterType params in callbacks: the C typedef alternates between
      //   - `DartObj` (int by value) when the source param is non-nullable T
      //   - `DartObj*` (pointer) when the source param is nullable T? (isOptional=true)
      // Mirrors the Java-side dispatch in paramValueFFMtoJ (see types.dart).
      if (param.isOptional) {
        return '($value != null) ? (calloc<ffi.Int>()..value = _addWidget($value)) : ffi.nullptr';
      }
      return '_addWidget($value)';
    }
    t = t.bound;
  }
  var value = ensureName(param);
  var nul = '0';
  var exclam = '';
  // A nullable bool crossing back through a callback is typed `int*` in C
  // (typedefs.h), so it must be marshalled as a pointer: allocate an int for
  // a real value, or nullptr for null. The Java side reads it with memToBool.
  // Matches the leak-on-pass convention already used for the string callback.
  if (fromCallback && t.isDartCoreBool && t.nullabilitySuffix == NullabilitySuffix.question) {
    return '($value != null) ? (calloc<ffi.Int>()..value = ($value! ? 1 : 0)) : ffi.nullptr';
  }
  if (t is InterfaceType) {
    if (param.isOptional || t.nullabilitySuffix == NullabilitySuffix.question) {
      exclam = '!';
    }

    if (t.isDartCoreInt) {
      value = '$value$exclam';
    }
    else if (t.isDartCoreBool) {
      value = '$value$exclam.toInt()';
    }
    else if (t.isDartCoreDouble) {
      value = '$value$exclam';
    }
    else if (t.isDartCoreString) {
      value = '$value$exclam.toNativeUtf8().cast<ffi.Char>()';
      nul = 'ffi.nullptr';
    }
    else if (t.isDartCoreList) {
      final arrayType = t.typeArguments[0];
      if (isPrimitive(arrayType)) {
        value = '$value$exclam.strListToC()';
      } else {
        value = '$value$exclam.toArrayC()';
      }
      nul = 'ffi.nullptr';
    }
    else if (t.element is EnumElement) {
      value = '$value$exclam.index';
    }
    else if (!isPrimitive(t)) {
      // On the callback path, C hands us a plain int id (per the C typedef
      // signature — see FunctionHandler.type4C which maps everything through
      // `DartObj`). Emitting `_create<Widget>ObjSt(value)` would push a struct
      // through an int-typed slot; register the widget by id and pass that.
      if (fromCallback) {
        return '_addWidget($value)';
      }
      return ctx.getGen(t.element).dartToC(value);
    }

    if (param.isOptional) {
      value = '(${param.name} != null) ? $value : $nul';
    }
  }
  return value;
}
