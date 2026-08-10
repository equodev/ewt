part of '../../gen.dart';

/// Dart source expression for a factory param on the Dart side of the FFI
/// bridge. Reads the FFI-typed value the caller pushed into the callback
/// signature and turns it back into something the Flutter constructor
/// accepts:
///
///   * primitives: `.toBool()`, `.cast<Utf8>().toDartString()`, or the raw
///     name for `int`/`double` (Optional wrappers get `.strOr`, `.boolOrNul`,
///     etc. mirroring `defaultXxxCode`).
///   * lists: `.listOrEmpty()` / `.listOrNul()` — the shared wrapper stores
///     both required and optional list-typed slots the same way.
///   * enums: index lookup on `values`.
///   * object refs: `_widgetsMap[id]! as T` (unchecked coerce; the widget
///     registry is single-source-of-truth).
///
/// Handler types (Map<int,T> and FunctionType) delegate to the handler.
///
/// Callers exposed via [Params.paramValue4D].
String ffiToDartParamValue(Types types, ParameterElement param) {
  final t = param.type;
  var value = param.name;
  final h = types.getHandler(t);
  if (h != null) {
    value = h.value4D(param);
  }
  else if (t is InterfaceType) {
    if (param.isOptional) {
      if (t.isDartCoreString) {
        if (t.nullabilitySuffix == NullabilitySuffix.none) {
          value = '${param.name}.strOr(${param.defaultValueCode})';
        } else {
          value = '${param.name}.strOrNul()';
        }
      }
      else if (t.isDartCoreBool) {
        if (t.nullabilitySuffix == NullabilitySuffix.none) {
          value = '${param.name}.boolOr(${param.defaultValueCode ?? 'false'})';
        } else {
          value = '${param.name}.boolOrNul()';
        }
      }
      else if (t.isDartCoreInt) {
        if (t.nullabilitySuffix == NullabilitySuffix.none) {
          value = '${param.name}.intOr(${param.defaultValueCode})';
        } else {
          value = '${param.name}.intOrNul()';
        }
      }
      else if (t.isDartCoreDouble) {
        if (t.nullabilitySuffix == NullabilitySuffix.none) {
          value = '${param.name}.doubleOr(${Params.defaultDoubleCode(param)})';
        } else {
          value = '${param.name}.doubleOrNul()';
        }
      }
      else if (t.isDartCoreList) {
        if (t.nullabilitySuffix == NullabilitySuffix.none) {
          value = '${param.name}.listOrEmpty()';
        } else {
          value = '${param.name}.listOrNul()';
        }
      }
      else if (t.element is EnumElement) {
        if (t.nullabilitySuffix == NullabilitySuffix.none) {
          value = '${param.name}.enumOr(${t.element.name}.values, ${Params.defaultEnumCode(param)})';
        } else {
          value = '${param.name}.enumOrNul(${t.element.name}.values)';
        }
      }
      else if (!isPrimitive(t)) {
        if (t.nullabilitySuffix == NullabilitySuffix.none) {
          value = '${param.name}.objOr(${Params.defaultObjCode(param)})';
        } else {
          value = '${param.name}.objOrNul()';
        }
      }
    } else {
      if (t.isDartCoreBool) {
        value = '${param.name}.toBool()';
      }
      else if (t.isDartCoreString) {
        value = '${param.name}.cast<Utf8>().toDartString()';
      }
      else if (t.isDartCoreList) {
        value = '${param.name}.listOrEmpty()';
      }
      else if (t.element is EnumElement) {
        // A required enum arrives as its raw int index, so decode it from the
        // enum's values. Without this it falls through to the _widgetsMap
        // lookup below and is wrongly treated as a widget id (Flex.direction).
        value = '${t.element.name}.values[${param.name}]';
      }
      else if (!isPrimitive(t)) {
        if (t.typeArguments.isNotEmpty) {
          value = '_widgetsMap[$value]! as ${t.typeArguments.any((p) => p is TypeParameterType) ? t.element.name : t}';
        } else {
          value = '_widgetsMap[$value]! as $t';
        }
      }
    }
  }
  if (param.isNamed) {
    value = '${param.name}: $value';
  }
  return value;
}
