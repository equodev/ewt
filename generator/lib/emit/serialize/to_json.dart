part of '../../gen.dart';

/// Dart source expression that decodes a param from the JSON node params
/// map (variable `p`) in the pure-Dart web decoder. Mirrors the type
/// dispatch of [ffiToDartParamValue] but reads JSON values instead of FFI
/// pointers. Object refs and list elements recurse through `decodeEwtNode`.
///
/// Callers exposed via [Params.paramValueJson] (which wraps this with the
/// "skip sentinel" + named-param handling).
String jsonToDartParamValueRaw(Types types, ParameterElement param) {
  // Optional un-crossable params are omitted from the constructor call
  // (empty "skip" sentinel, filtered by Params.names); the widget uses its
  // own default. See _webSkippable.
  if (_webSkippable(param)) return '';
  final key = param.name;
  final t = param.type;
  final read = "p['$key']";
  final h = types.getHandler(t);
  // Callbacks are inert in this phase: a void closure that accepts any arity
  // (optional positional Object? params make it assignable to VoidCallback /
  // ValueChanged / etc.).
  if (h != null) {
    if (_isZeroArgCallback(t)) {
      return "ewtWireCallback(p['$key'])";
    }
    if (_valueCallbackJavaType(t) != null) {
      return "ewtWireValueCallback(p['$key'])";
    }
    // Optional value-returning fn params are already omitted above (see
    // _webSkippable); any remaining callback here is inert — a void closure
    // that accepts any arity.
    return '([Object? a, Object? b, Object? c]) {}';
  }
  if (t is InterfaceType && t.element.name == 'BuildContext') {
    return 'ewtActiveBuildContext!';
  }
  if (t is InterfaceType) {
    final elemName = t.element.name;
    if (param.isOptional) {
      // A non-nullable optional param carries a default (mirrors
      // ffiToDartParamValue's .xOr(default)); a nullable one may be left null.
      final nonNull = t.nullabilitySuffix == NullabilitySuffix.none;
      if (t.isDartCoreString) return nonNull ? '($read as String?) ?? ${param.defaultValueCode}' : '$read as String?';
      if (t.isDartCoreBool) return nonNull ? '($read as bool?) ?? ${param.defaultValueCode ?? 'false'}' : '$read as bool?';
      if (t.isDartCoreInt) return nonNull ? '($read as int?) ?? ${param.defaultValueCode}' : '$read as int?';
      if (t.isDartCoreDouble) return nonNull ? '(($read as num?)?.toDouble()) ?? ${Params.defaultDoubleCode(param)}' : '($read as num?)?.toDouble()';
      if (t.isDartCoreList) return _jsonListDecode(read, t);
      if (t.isDartCoreMap) return _jsonMapDecode(read, t);
      if (t.element is EnumElement) return nonNull ? '$read == null ? ${Params.defaultEnumCode(param)} : $elemName.values[$read as int]' : '$read == null ? null : $elemName.values[$read as int]';
      return nonNull ? '$read == null ? ${Params.defaultObjCode(param)} : ${_jsonObjDecode(read, elemName)}' : '$read == null ? null : ${_jsonObjDecode(read, elemName)}';
    } else {
      if (t.isDartCoreString) return '$read as String';
      if (t.isDartCoreBool) return '$read as bool';
      if (t.isDartCoreInt) return '$read as int';
      if (t.isDartCoreDouble) return '($read as num).toDouble()';
      if (t.isDartCoreList) return _jsonListDecode(read, t);
      if (t.isDartCoreMap) return _jsonMapDecode(read, t);
      if (t.element is EnumElement) return '$elemName.values[$read as int]';
      return _jsonObjDecode(read, elemName);
    }
  }
  return read;
}

/// Decodes a List param from JSON: scalars/Strings cast element-wise; enums
/// via values[i]; object-refs/Widgets via decodeEwtNode.
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

/// A single object-ref decode expression from a JSON node. Widget children
/// route through decodeEwtWidget so a missing/failed child decoder degrades
/// to SizedBox.shrink instead of throwing `null as Widget` and taking down
/// the whole parent subtree (per-node fault isolation). Non-widget value
/// objects keep the plain cast — no placeholder of their type exists, and a
/// missing value-object decoder is a genuine break, not a renderable gap.
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
