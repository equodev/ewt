part of '../../gen.dart';

/// Dart source expression that decodes a param from the JSON node params
/// map (variable `p`) in the pure-Dart web decoder. Was
/// `Params._paramValueJsonRaw` (Params.paramValueJson wraps the result
/// with the skip-sentinel + named-param prefix).
class JsonToDart extends SerializeStrategy {
  const JsonToDart();

  @override
  String apply(Types types, ParameterElement param) {
    // Optional un-crossable params are omitted from the constructor call
    // (empty "skip" sentinel, filtered by Params.names); the widget uses
    // its own default. See _webSkippable.
    if (_webSkippable(param)) return '';
    final t = param.type;
    final key = param.name;
    final read = "p['$key']";
    final h = types.getHandler(t);
    // Callbacks are inert in this phase: a void closure accepting any
    // arity (optional positional Object? params make it assignable to
    // VoidCallback / ValueChanged / etc.).
    if (h != null) {
      if (_isZeroArgCallback(t)) return 'ewtWireCallback($read)';
      if (_valueCallbackJavaType(t) != null) return 'ewtWireValueCallback($read)';
      return '([Object? a, Object? b, Object? c]) {}';
    }
    if (t is InterfaceType && t.element.name == 'BuildContext') {
      return 'ewtActiveBuildContext!';
    }
    if (t is! InterfaceType) return read;
    return dispatchInterface(types, param, t);
  }

  /// Reads `p['<name>']`, the JSON slot for this param.
  String _read(ParameterElement param) => "p['${param.name}']";

  /// Whether an optional param is *non-nullable* — i.e. it has a default
  /// value. Governs whether the decoder must emit a `?? default` fallback.
  bool _nonNullableOptional(InterfaceType t, ParameterElement param) =>
      param.isOptional && t.nullabilitySuffix == NullabilitySuffix.none;

  @override
  String onString(Types types, ParameterElement param, InterfaceType t) {
    final read = _read(param);
    if (!param.isOptional) return '$read as String';
    return _nonNullableOptional(t, param)
        ? '($read as String?) ?? ${param.defaultValueCode}'
        : '$read as String?';
  }

  @override
  String onBool(Types types, ParameterElement param, InterfaceType t) {
    final read = _read(param);
    if (!param.isOptional) return '$read as bool';
    return _nonNullableOptional(t, param)
        ? '($read as bool?) ?? ${param.defaultValueCode ?? 'false'}'
        : '$read as bool?';
  }

  @override
  String onInt(Types types, ParameterElement param, InterfaceType t) {
    final read = _read(param);
    if (!param.isOptional) return '$read as int';
    return _nonNullableOptional(t, param)
        ? '($read as int?) ?? ${param.defaultValueCode}'
        : '$read as int?';
  }

  @override
  String onDouble(Types types, ParameterElement param, InterfaceType t) {
    final read = _read(param);
    if (!param.isOptional) return '($read as num).toDouble()';
    return _nonNullableOptional(t, param)
        ? '(($read as num?)?.toDouble()) ?? ${Params.defaultDoubleCode(param)}'
        : '($read as num?)?.toDouble()';
  }

  @override
  String onList(Types types, ParameterElement param, InterfaceType t) =>
      _jsonListDecode(_read(param), t);

  @override
  String onMap(Types types, ParameterElement param, InterfaceType t) =>
      _jsonMapDecode(_read(param), t);

  @override
  String onEnum(Types types, ParameterElement param, InterfaceType t) {
    final read = _read(param);
    final name = t.element.name;
    if (!param.isOptional) return '$name.values[$read as int]';
    return _nonNullableOptional(t, param)
        ? '$read == null ? ${Params.defaultEnumCode(param)} : $name.values[$read as int]'
        : '$read == null ? null : $name.values[$read as int]';
  }

  @override
  String onObject(Types types, ParameterElement param, InterfaceType t) {
    final read = _read(param);
    final name = t.element.name;
    if (!param.isOptional) return _jsonObjDecode(read, name);
    return _nonNullableOptional(t, param)
        ? '$read == null ? ${Params.defaultObjCode(param)} : ${_jsonObjDecode(read, name)}'
        : '$read == null ? null : ${_jsonObjDecode(read, name)}';
  }
}

/// Decodes a List param from JSON: scalars/Strings cast element-wise;
/// enums via values[i]; object-refs/Widgets via decodeEwtNode.
String _jsonListDecode(String read, InterfaceType listType) {
  final elem = listType.typeArguments.isNotEmpty ? listType.typeArguments.first : null;
  final base = "(($read as List?) ?? const [])";
  if (elem is InterfaceType && elem.element is EnumElement) {
    return '$base.map((e) => ${elem.element.name}.values[e as int]).toList()';
  }
  if (elem == null || isPrimitive(elem)) {
    return '$base.cast<${elem?.getDisplayString() ?? 'dynamic'}>().toList()';
  }
  if (elem is InterfaceType && elem.isDartCoreString) {
    return '$base.cast<String>().toList()';
  }
  final elemName = (elem is InterfaceType) ? elem.element.name : 'dynamic';
  return '$base.map((e) => ${_jsonObjDecode('e', elemName)}).toList()';
}

/// Widget children route through decodeEwtWidget so a missing/failed child
/// decoder degrades to SizedBox.shrink instead of throwing `null as Widget`
/// and taking down the whole parent subtree (per-node fault isolation).
/// Non-widget value objects keep the plain cast — no placeholder of their
/// type exists, and a missing value-object decoder is a genuine break, not
/// a renderable gap.
String _jsonObjDecode(String read, String elemName) => elemName == 'Widget'
    ? 'decodeEwtWidget($read as Map<String,dynamic>)'
    : 'decodeEwtNode($read as Map<String,dynamic>) as $elemName';

/// Decodes a Map param from JSON (string keys). Int keys are parsed back;
/// values follow the same scalar/enum/object rules as list elements. Used
/// e.g. for MaterialColor's swatch.
String _jsonMapDecode(String read, InterfaceType mapType) {
  final kt = mapType.typeArguments.isNotEmpty ? mapType.typeArguments.first : null;
  final vt = mapType.typeArguments.length > 1 ? mapType.typeArguments[1] : null;
  final keyName = (kt is InterfaceType) ? kt.element.name : 'dynamic';
  final valName = (vt is InterfaceType) ? vt.element.name : 'dynamic';
  final keyConv = (kt is InterfaceType && kt.isDartCoreInt)
      ? 'int.parse(k as String)'
      : (kt is InterfaceType && kt.isDartCoreString) ? 'k as String' : 'k';
  String valConv;
  if (vt is InterfaceType && vt.element is EnumElement) {
    valConv = '$valName.values[v as int]';
  } else if (vt == null || isPrimitive(vt) || (vt is InterfaceType && vt.isDartCoreString)) {
    valConv = 'v as $valName';
  } else {
    valConv = 'decodeEwtNode(v as Map<String,dynamic>) as $valName';
  }
  return '(($read as Map?) ?? const {}).map((k, v) => MapEntry($keyConv, $valConv)).cast<$keyName, $valName>()';
}
