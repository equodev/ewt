part of 'gen.dart';

class Params {
  Types types;
  List<ParameterElement> parameters;

  late String names = "";
  late String builderDecl = "";
  late String decl = "";
  late String required = "";
  late String requiredNames = "";
  bool allTypes;

  Params(this.types, this.parameters,
      String Function(Types, ParameterElement, {bool annotated, bool wrap}) paramDef,
      {this.allTypes = false, String Function(Types, ParameterElement) paramValue = _paramName, String Function(Types, ParameterElement) escape = _paramName}) {
    var filtered = (allTypes ? parameters : parameters.where((p) => types.supportedType(p.type)))
        .where((p) => !hasPrivateDefault(p));
    // Empty string is the "skip" sentinel (see paramValueJson / _paramValueJsonRaw); filter out
    // so that optional value-returning fn params are omitted from the constructor call entirely.
    names = filtered.map((p) => paramValue(types, p)).where((v) => v.isNotEmpty).join(',\n      ');
    var mandatory = filtered.takeWhile((p) => p.isRequired);
    builderDecl = filtered.map((p) => '${paramDef(types, p, annotated: mandatory.contains(p), wrap: p.isOptional)} ${escape(types, p)}').join(', ');
    decl = filtered.map((p) => '${paramDef(types, p, wrap: p.isOptional)} ${escape(types, p)}').join(', ');
    // var mandatory = filtered.where((p) => p.isRequired);
    required = mandatory.map((p) => '${paramDef(types, p)} ${escape(types, p)}').join(', ');
    requiredNames = mandatory.map((p) => paramValue(types, p)).join(', ');
  }

  static String paramDef4J(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type)}';
    if (wrap) {
      if (param.type.isDartCoreDouble) {
        t = 'OptionalDouble';
      }
      else if (param.type.isDartCoreInt) {
        t = 'OptionalInt';
      }
      else if (param.type.isDartCoreBool) {
        t = 'Optional<Boolean>';
      }
      else {
        t = 'Optional<$t>';
      }
    }
    return t;
  }

  static String paramDef4JBuilder(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    // var t ='${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type)}';
    var type = param.type;
    if (type is InterfaceType) {
      // if (namedType.isDartCoreList) {
      //   final arrayType = (namedType).typeArguments[0];
      //   return 'List<$arrayType>';
      // }
      // else if (namedType.isDartCoreObject) {
      //   return 'NativeObj';
      // }
      String? t;
      if (type.isDartCoreObject) {
        t = 'NativeObj.I';
      }
      else if (type.isDartCoreList) {
        final arrayType = type.typeArguments[0];
        if (!isPrimitive(arrayType)) {
          t = 'List<${arrayType.element!.name}I>';
        }
      }
      else if (!isPrimitive(type) && type.element is! EnumElement && !type.isDartCoreMap) {
        //   return '${namedType.element.name}Builder';
        // }
        t = '${type.element.name}I';
      }
      if (t != null) {
        if (wrap) {
          t = 'Optional<$t>';
        }
        if (annotated) {
          t = '@Builder.Parameter $t';
        }
        return t;
      }
    }
    return paramDef4J(generation, param, annotated: annotated, wrap: wrap);
  }

  static String paramDef4C(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4C(param.type)}';
    if (t.endsWith('ObjSt')) {
      t = 'DartObj';
    }
    if (wrap && !param.type.isDartCoreString) {
      t = '$t*';
    }
    return t;
  }

  static String paramDef4D(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4D(param.type)}';
    if (wrap && !param.type.isDartCoreString) {
      if (t.endsWith('ObjSt')) {
        t = 'DartObj';
      }
      t = 'ffi.Pointer<$t>';
    } else {
      if (t == 'ffi.Int' || t == 'ffi.Double') {
        t = t.substring(4).toLowerCase();
      }
      else if (t == 'DartObj' || t.endsWith('ObjSt')) {
        t = 'DartDartObj';
      }
    }
    return t;
  }

  static String _paramName(Types types, ParameterElement param) => param.name;

  static String escape4J(Types types, ParameterElement param) => (param.name == 'package') ? '_package' : ensureName(param);

  /// Dart source expression for a factory param on the Dart side of the
  /// bridge. Body lives in the [FfiToDart] strategy
  /// (emit/serialize/to_dart.dart).
  static String paramValue4D(Types types, ParameterElement param) =>
      const FfiToDart().apply(types, param);

  /// Dart source expression that decodes a param from the JSON node map.
  /// Body lives in the [JsonToDart] strategy (emit/serialize/to_json.dart).
  /// Handles the "skip sentinel" for un-crossable optionals and the
  /// named-param prefix; the strategy's apply() returns the bare expression.
  static String paramValueJson(Types types, ParameterElement param) {
    final value = const JsonToDart().apply(types, param);
    // Empty string is the "skip" sentinel (e.g. optional value-returning fn
    // params) — propagate as-is so Params.names can filter it out; avoid
    // emitting "name: " for skipped params.
    if (value.isEmpty) return '';
    return param.isNamed ? '${param.name}: $value' : value;
  }

  /// Dart source expression that marshals a Dart param INTO C.
  /// Body lives in the [DartToC] strategy (emit/serialize/to_c.dart).
  static String paramValueDtoC(Types ctx, ParameterElement param, {bool fromCallback = false}) =>
      DartToC(fromCallback: fromCallback).apply(ctx, param);


  /// The per-element map expression for a List param being serialized (variable {@code e}).
  /// Scalars/Strings are recorded as-is; enums as their ordinal; object-refs/Widgets via the
  /// recorded-node lookup, matching how single object-ref params are serialized.
  /// Serializes a Map param to a Map with String keys: values follow the same scalar/enum/object
  /// rules as list elements. Used e.g. for MaterialColor's swatch (Map&lt;int, Color&gt;).
  static String _mapSerialize(String varName, InterfaceType mapType) {
    final vt = mapType.typeArguments.length > 1 ? mapType.typeArguments[1] : null;
    String valExpr;
    if (vt is InterfaceType && vt.element is EnumElement) {
      valExpr = 'en.getValue().ordinal()';
    } else if (vt == null || isPrimitive(vt) || (vt is InterfaceType && vt.isDartCoreString)) {
      valExpr = 'en.getValue()';
    } else {
      valExpr = 'byId.get(en.getValue().getId())';
    }
    return '$varName.entrySet().stream().collect(java.util.stream.Collectors.toMap(en -> String.valueOf(en.getKey()), en -> $valExpr))';
  }

  static String _listElemSerialize(InterfaceType listType) {
    final elem = listType.typeArguments.isNotEmpty ? listType.typeArguments.first : null;
    if (elem is InterfaceType && elem.element is EnumElement) return 'e.ordinal()';
    if (elem == null || isPrimitive(elem) || (elem is InterfaceType && elem.isDartCoreString)) return 'e';
    return 'byId.get(e.getId())';
  }

  static String paramValueSerialize(Types types, ParameterElement param) {
    final name = Params.escape4J(types, param);
    final key = param.name;
    final t = param.type;
    final h = types.getHandler(t);

    // Callback: reserve a numeric id and optionally store the Runnable.
    if (h != null) {
      if (_isZeroArgCallback(t)) {
        // Wire zero-arg callbacks: reserve the id, record it in the node, and keep the
        // real Runnable so EwtWidget can fire it when the browser reports a click.
        if (param.isOptional) {
          return 'if ($name.isPresent()) { int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); callbacks.put(__cb_$key, $name.get()); }';
        }
        return 'int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); callbacks.put(__cb_$key, $name);';
      }
      final vt = _valueCallbackJavaType(t);
      if (vt != null) {
        // Value callback: store a Consumer<Object> that coerces the JSON arg to the known Java
        // type and calls the real Consumer, so EwtWidget can invoke it with the browser's value.
        final coerce = _valueCallbackCoerce(vt, 'v');
        if (param.isOptional) {
          return 'if ($name.isPresent()) { int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); java.util.function.Consumer<$vt> __h_$key = $name.get(); callbacks.put(__cb_$key, (java.util.function.Consumer<Object>)(v -> __h_$key.accept($coerce))); }';
        }
        return 'int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); callbacks.put(__cb_$key, (java.util.function.Consumer<Object>)(v -> $name.accept($coerce)));';
      }
      // Remaining arg-carrying callbacks stay inert: reserve the id only (future phase).
      if (param.isOptional) {
        return 'if ($name != null) { p.put("$key", nextCallbackId++); }';
      }
      return 'p.put("$key", nextCallbackId++);';
    }

    if (t is InterfaceType) {
      if (param.isOptional) {
        if (t.isDartCoreString || t.isDartCoreBool) {
          // Optional<String> / Optional<Boolean> — use ifPresent lambda
          return '$name.ifPresent(v -> p.put("$key", v));';
        } else if (t.isDartCoreInt) {
          // OptionalInt
          return 'if ($name.isPresent()) { p.put("$key", $name.getAsInt()); }';
        } else if (t.isDartCoreDouble) {
          // OptionalDouble
          return 'if ($name.isPresent()) { p.put("$key", $name.getAsDouble()); }';
        } else if (t.isDartCoreList) {
          return '$name.ifPresent(v -> p.put("$key", v.stream().map(e -> ${_listElemSerialize(t)}).collect(java.util.stream.Collectors.toList())));';
        } else if (t.isDartCoreMap) {
          return '$name.ifPresent(v -> p.put("$key", ${_mapSerialize('v', t)}));';
        } else if (t.element is EnumElement) {
          return '$name.ifPresent(v -> p.put("$key", v.ordinal()));';
        } else {
          // Optional<Widget/object>
          return '$name.ifPresent(v -> p.put("$key", byId.get(v.getId())));';
        }
      } else {
        // Required params
        if (t.isDartCoreString || t.isDartCoreBool || t.isDartCoreInt || t.isDartCoreDouble) {
          return 'p.put("$key", $name);';
        } else if (t.isDartCoreList) {
          return 'p.put("$key", $name.stream().map(e -> ${_listElemSerialize(t)}).collect(java.util.stream.Collectors.toList()));';
        } else if (t.isDartCoreMap) {
          return 'p.put("$key", ${_mapSerialize(name, t)});';
        } else if (t.element is EnumElement) {
          return 'p.put("$key", $name.ordinal());';
        } else {
          // Required object/Widget
          return 'p.put("$key", byId.get($name.getId()));';
        }
      }
    }
    // Fallback for primitives / other types: record as-is
    return 'p.put("$key", $name);';
  }

  static String? defaultEnumCode(ParameterElement param) {
    var defaultValue = param.defaultValueCode!;
    return defaultValue.replaceFirst('ui.', '');
  }

  /// Replaces private identifiers (`_kFoo`) in [defaultValue] with the source
  /// text of their initializer. Returns null if any private identifier can't be
  /// resolved to a const value — the caller should fall back to omitting the
  /// default so the param becomes an unset optional at the Java layer.
  ///
  /// Non-recursive: a replacement's own text (e.g. `_kA` → `_kB + 1`) is not
  /// re-scanned, so nested private refs remain unresolved and either fall
  /// through analyzer const-eval on the caller side or land in the emitted
  /// source verbatim (a latent codegen bug for widgets that hit the pattern).
  /// If this ever becomes recursive, add a `Set<String>` visited guard —
  /// `_kA = _kB; _kB = _kA` would otherwise loop.
  static String? _inlinePrivateRefs(ParameterElement param, String defaultValue) {
    if (!defaultValue.contains('_')) return defaultValue;
    var out = defaultValue;
    var targetParam = (param is SuperFormalParameterElement) ? param.superConstructorParameter! : param;
    var owner = targetParam.thisOrAncestorOfType<ClassElement>();
    // Match private identifiers as whole tokens (`\b_` won't help because `_`
    // is a word char, so use a manual boundary via lookahead/behind on
    // non-identifier chars or start/end). We walk matches once and rebuild the
    // string with a StringBuffer so `_k` doesn't corrupt `_kMore`.
    final pattern = RegExp(r'(?<![A-Za-z0-9_])_[A-Za-z0-9_]+');
    final buf = StringBuffer();
    var lastEnd = 0;
    for (final match in pattern.allMatches(defaultValue)) {
      final name = match.group(0)!;
      String? replacement;
      final field = owner?.getField(name);
      if (field is ConstFieldElementImpl && field.constantInitializer != null) {
        replacement = field.constantInitializer.toString();
      } else {
        final top = targetParam.library2?.getTopLevelVariable(name);
        if (top != null && top.firstFragment is ConstTopLevelVariableElementImpl) {
          final init = (top.firstFragment as ConstTopLevelVariableElementImpl).constantInitializer;
          if (init != null) replacement = init.toString();
        }
      }
      if (replacement == null) return null;
      buf.write(defaultValue.substring(lastEnd, match.start));
      buf.write(replacement);
      lastEnd = match.end;
    }
    buf.write(defaultValue.substring(lastEnd));
    out = buf.toString();
    return out;
  }

  static String? defaultDoubleCode(ParameterElement param) {
    if (param.defaultValueCode == null) {
      // No source default — some factory ctors leave optionals bare; caller
      // handles null by leaving the param unset at the Java layer.
      final val = param.computeConstantValue()?.toDoubleValue();
      return val?.toString();
    }
    var defaultValue = param.defaultValueCode!;
    if (double.tryParse(defaultValue) != null) {
      return param.defaultValueCode;
    }
    if (defaultValue.contains('_')) {
      final inlined = _inlinePrivateRefs(param, defaultValue);
      if (inlined != null) return inlined;
      // Private ref we couldn't resolve — fall through the analyzer const
      // evaluator (may still yield a numeric literal). If that also fails,
      // return null so the caller emits an unset optional rather than pasting
      // an unresolved `_foo` into Dart source.
      final val = param.computeConstantValue()?.toDoubleValue();
      return val?.toString();
    }
    // Bare identifier (top-level from another library, class-scope public const,
    // etc.) — try the analyzer's constant evaluator before falling back to a
    // qualified name that may not be reachable from the widgets library.
    if (!defaultValue.contains('.')) {
      final val = param.computeConstantValue()?.toDoubleValue();
      if (val != null) return val.toString();
    }
    if (defaultValue.contains('.')) {
      return defaultValue;
    }
    return '${param.thisOrAncestorOfType<ClassElement>()!.name}.$defaultValue';
  }

  static String? defaultObjCode(ParameterElement param) {
    if (param.defaultValueCode == null) {
      return null;
    }
    var defaultValue = param.defaultValueCode!;
    if (defaultValue.contains('.')) {
      return defaultValue;
    }
    if (defaultValue.contains('_')) {
      final inlined = _inlinePrivateRefs(param, defaultValue);
      if (inlined != null) return inlined;
      // Unresolved private ref — bail rather than paste `_foo` into Dart.
      return null;
    }
    if (!defaultValue.startsWith('const')) {
      // return '${param.thisOrAncestorOfType<ClassElement>()!.name}.$defaultValue';
    }
    return defaultValue;
  }

  static String paramValue4JCallback(Types types, ParameterElement param) {
    final t = param.type;
    var value = escape4J(types, param);
    if (t is FunctionType) {
      return 'this::$value';
    }
    return value;
  }

  static String paramValue4JOptional(Types types, ParameterElement param) {
    if (param.isOptional) {
      var t = '';
      if (param.type.isDartCoreDouble) {
        t = 'OptionalDouble';
      }
      else if (param.type.isDartCoreInt) {
        t = 'OptionalInt';
      } else {
        t = 'Optional';
      }
      return '$t.empty()';
    } else {
      return paramValue4JBuilder(types, param);
    }
  }

  static String paramValue4JBuilder(Types types, ParameterElement param) {
    final t = param.type;
    var value = escape4J(types, param);
    if (t is InterfaceType) {
      // if (namedType.isDartCoreList) {
      //   final arrayType = (namedType).typeArguments[0];
      //   return 'List<$arrayType>';
      // }
      // else if (namedType.isDartCoreObject) {
      //   return 'NativeObj';
      // }
      String? v;
      if (t.isDartCoreObject) {
        if (param.isOptional) {
          v = '$value.map(NativeObj.I::build)';
        } else {
          v = '$value.build()';
        }
      }
      else if (t.isDartCoreList) {
        final arrayType = t.typeArguments[0];
        if (!isPrimitive(arrayType)) {
          if (param.isOptional) {
            v = '$value.map(i -> i.stream().map(${arrayType.element!.name}I::build).toList())';
          } else {
            v = '$value.stream().map(${arrayType.element!.name}I::build).toList()';
          }
        }
      }
      else if (!isPrimitive(t) && !t.isDartCoreList && !t.isDartCoreMap && t.element is! EnumElement) {
        if (param.isOptional) {
          v = '$value.map(${t.element.name}I::build)';
        } else {
          v = '$value.build()';
        }
      }
      if (v != null) {
        return v;
      }
    }
    return value;
  }

}

extension Case on String {
  firstUpper() => isEmpty ? "" : this[0].toUpperCase() + substring(1);
  firstLower() => isEmpty ? "" : this[0].toLowerCase() + substring(1);
}
