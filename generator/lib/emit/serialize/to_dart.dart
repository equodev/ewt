part of '../../gen.dart';

/// Dart source expression for a factory param on the Dart side of the FFI
/// bridge. Reads the FFI-typed value the caller pushed into the callback
/// signature and turns it back into something the Flutter constructor
/// accepts. Was `Params.paramValue4D`.
class FfiToDart extends SerializeStrategy {
  const FfiToDart();

  @override
  String apply(Types types, ParameterElement param) {
    final t = param.type;
    var value = param.name;
    final h = types.getHandler(t);
    if (h != null) {
      value = h.value4D(param);
    } else if (t is InterfaceType) {
      value = dispatchInterface(types, param, t);
    }
    if (param.isNamed) value = '${param.name}: $value';
    return value;
  }

  @override
  String onString(Types types, ParameterElement param, InterfaceType t) {
    if (!param.isOptional) return '${param.name}.cast<Utf8>().toDartString()';
    return t.nullabilitySuffix == NullabilitySuffix.none
        ? '${param.name}.strOr(${param.defaultValueCode})'
        : '${param.name}.strOrNul()';
  }

  @override
  String onBool(Types types, ParameterElement param, InterfaceType t) {
    if (!param.isOptional) return '${param.name}.toBool()';
    return t.nullabilitySuffix == NullabilitySuffix.none
        ? '${param.name}.boolOr(${param.defaultValueCode ?? 'false'})'
        : '${param.name}.boolOrNul()';
  }

  @override
  String onInt(Types types, ParameterElement param, InterfaceType t) {
    if (!param.isOptional) return param.name;
    return t.nullabilitySuffix == NullabilitySuffix.none
        ? '${param.name}.intOr(${param.defaultValueCode})'
        : '${param.name}.intOrNul()';
  }

  @override
  String onDouble(Types types, ParameterElement param, InterfaceType t) {
    if (!param.isOptional) return param.name;
    return t.nullabilitySuffix == NullabilitySuffix.none
        ? '${param.name}.doubleOr(${Params.defaultDoubleCode(param)})'
        : '${param.name}.doubleOrNul()';
  }

  @override
  String onList(Types types, ParameterElement param, InterfaceType t) {
    if (!param.isOptional) return '${param.name}.listOrEmpty()';
    return t.nullabilitySuffix == NullabilitySuffix.none
        ? '${param.name}.listOrEmpty()'
        : '${param.name}.listOrNul()';
  }

  @override
  String onEnum(Types types, ParameterElement param, InterfaceType t) {
    // A required enum arrives as its raw int index, so decode it from the
    // enum's values. Without this it falls through to the _widgetsMap
    // lookup below and is wrongly treated as a widget id (Flex.direction).
    if (!param.isOptional) return '${t.element.name}.values[${param.name}]';
    return t.nullabilitySuffix == NullabilitySuffix.none
        ? '${param.name}.enumOr(${t.element.name}.values, ${Params.defaultEnumCode(param)})'
        : '${param.name}.enumOrNul(${t.element.name}.values)';
  }

  @override
  String onObject(Types types, ParameterElement param, InterfaceType t) {
    if (isPrimitive(t)) return param.name;
    if (!param.isOptional) {
      final targetType = t.typeArguments.isNotEmpty && t.typeArguments.any((p) => p is TypeParameterType)
          ? t.element.name
          : t.toString();
      return '_widgetsMap[${param.name}]! as $targetType';
    }
    return t.nullabilitySuffix == NullabilitySuffix.none
        ? '${param.name}.objOr(${Params.defaultObjCode(param)})'
        : '${param.name}.objOrNul()';
  }
}
