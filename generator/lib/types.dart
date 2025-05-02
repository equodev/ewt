import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';
import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
import 'package:analyzer/src/dart/element/element.dart';
import 'package:analyzer/src/dart/element/type.dart';
import 'package:analyzer/src/generated/utilities_dart.dart';
import 'package:analyzer/src/utilities/extensions/string.dart';
import 'package:collection/collection.dart';

import 'gen.dart';

class Types {
  Set<DartType> unsupportedTypes = {};
  Set<DartType> requiredTypes = {};
  Set<InstantiatedTypeAliasElement> typeDefs = {};
  Iterable<ClassElement> widgets;
  ClassElement? widgetElement;
  late List<TypeHandler> handlers;

  Types(Iterable<ClassElement> widgets) :
        widgetElement = widgets.first,
        widgets = widgets.skip(1),
        handlers = [MapHandler(), FunctionHandler()];

  AGen getGen(Element dartClass) {
    if (dartClass is ClassElement) {
      if (dartClass.name.startsWith('Sub')) {
        return SubclassGen(this, dartClass);
      }
      else if ((dartClass.hasImmutable || dartClass.allSupertypes.any((s) => s.element.hasImmutable)) && !dartClass.isAbstract) {
        return ImmutableGen(this, dartClass);
      }
      else {
        return WidgetGen(this, dartClass);
      }
    }
    else if (dartClass is EnumElement) {
      return EnumGen(this, dartClass);
    }
    else if (dartClass is TypeParameterElement) {
      return getGen(dartClass.bound!.element!);
    }
    throw UnsupportedError('No AGen for $dartClass');
  }

  void addTypeDef(InstantiatedTypeAliasElement t) {
    equals(InstantiatedTypeAliasElement d) =>
        d == t ||
            (d.element.name == t.element.name && ListEquality().equals(d.typeArguments, t.typeArguments));
    if (!typeDefs.any(equals)) {
      typeDefs.add(t);
    }
  }

  void addRequiredType(DartType requiredType) {
    if (requiredType.isDartCoreObject || requiredType.isDartCoreList || requiredType.isDartCoreMap || isPrimitive(requiredType)) {
      return;
    }
    // if (processed.contains(requiredType.element)) {
    //   return;
    // }
    // if (requiredType.element is EnumElement) {
    //   requiredTypes.add(requiredType);
    // }
    // else if (requiredType.element is ClassElement) {
    requiredTypes.add(requiredType);
    // }
  }

  bool supportedType(DartType t) {
    if (t.isDartCoreEnum || t is VoidType || isPrimitive(t)) {
      return true;
    }
    if (t.element is EnumElement) {
      return true;
    }
    if (t.isDartCoreList && supportedType((t as InterfaceType).typeArguments[0])) {
      return true;
    }
    // if (t is FunctionType) {
    //   return (t.parameters.isEmpty || t.parameters.every((p) => supportedType(p.type))) && (t.returnType is VoidType || supportedType(t.returnType));
    // }
    if (/*['InlineSpan', 'ThemeData', 'Color', 'ColorScheme'].contains(t.getDisplayString(withNullability: false))
        ||*/ isWidget(t.element) || widgets.contains(t.element) || widgets.any((w) => isSubtype(w, t.element))) {
      return true;
    }
    if (t is TypeParameterType) {
      return supportedType(t.bound);
    }
    if (getHandler(t) != null) {
      return true;
    }
    if (t.isDartAsyncFuture) {
      return true;
    }
    unsupportedTypes.add(t);
    return false;
  }

  bool isWidget(Element? element) {
    if (element == widgetElement) {
      return true;
    }
    if (element is InterfaceElement) {
      return element.allSupertypes.contains(widgetElement?.thisType);
    }
    return false;
  }

  bool isSubtype(ClassElement subType, Element? superType) {
    if (subType == superType) {
      return true;
    }
    if (superType is InterfaceElement) {
      return subType.allSupertypes.map((s) => s.element).contains(superType);
    }
    return false;
  }

  TypeHandler? getHandler(DartType t) {
    for (var handler in handlers) {
      handler.types = this;
      if (handler.matches(t)) {
        return handler;
      }
    }
    return null;
    // throw 'Wrong type $t not supported by any handler';
  }

  String type4FFMRet(DartType namedType) {
    if (namedType is VoidType) {
      return 'void';
    }
    if (namedType.isDartCoreBool) {
      return 'int';
    }
    if (namedType.isDartCoreString) {
      return 'MemorySegment';
    }
    if (isPrimitive(namedType)) {
      return type4J(namedType);
    }
    var gen = getGen(namedType.element!);
    return gen.objType().endsWith('ObjSt') ? 'MemorySegment' : 'int';
  }

  String type4J(DartType namedType) {
    if (!isPrimitive(namedType) && supportedType(namedType)) {
      addRequiredType(namedType);
    }
    var h = getHandler(namedType);
    if (h != null) {
      return h.type4J(namedType);
    }
    if (namedType is InterfaceType) {
      if (namedType.isDartCoreBool) {
        return 'boolean';
      }
      else if (namedType.isDartCoreList) {
        final arrayType = (namedType).typeArguments[0];
        return 'List<$arrayType>';
      }
      else if (namedType.isDartCoreObject) {
        return 'NativeObj';
      }
      // else if (!isPrimitive(namedType)) {
      //   return '${namedType.element.name}Builder';
      // }
      return namedType.element.name;
    }
    // else if (namedType is FunctionType) {
    //   var params = namedType.parameters.map((p) => type4J(p.type).firstUpper()).join(', ');
    //   if (namedType.returnType is VoidType) {
    //     if (namedType.parameters.isEmpty) {
    //       return 'Runnable';
    //     }
    //     return 'Consumer<${params}>';
    //   } else {
    //     var retType4j = type4J(namedType.returnType);
    //     if (namedType.parameters.isEmpty) {
    //       return 'Supplier<${retType4j}>';
    //     }
    //     final arity = switch(namedType.parameters.length) {
    //       1 => '',
    //       2 => 'Bi',
    //       var i => throw 'Unsupported $i args function',
    //     };
    //     return '${arity}Function<$params, $retType4j>';
    //   }
    // }
    return namedType.getDisplayString(withNullability: false);
  }

  String type4C(DartType namedType) {
    var h = getHandler(namedType);
    if (h != null) {
      return h.type4C(namedType);
    }
    if (namedType is VoidType) {
      return 'void';
    }
    if (namedType.isDartCoreString) {
      return 'char*';
    }
    else if (namedType.isDartCoreBool) {
      return 'int';
    }
    else if (namedType.isDartCoreInt) {
      return 'int';
    }
    else if (namedType.isDartCoreDouble) {
      return 'double';
    }
    else if (namedType.isDartCoreNum) {
      return 'num';
    }
    else if (namedType.element is EnumElement) {
      return 'int';
    }
    else if (namedType.isDartCoreList) {
      final arrayType = (namedType as InterfaceType).typeArguments[0];
      if (isPrimitive(arrayType)) {
        return '${type4C(arrayType)}*';
      } else {
        return 'ArrayC';
      }
    }
    // else if (namedType is FunctionType) {
    //   if (namedType.alias != null) {
    //     addTypeDef(namedType.alias!.element);
    //     return '${namedType.alias!.element.name}FFI';
    //   }
    //   final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
    //   final aliasName = '${cbRet}Callback${namedType.parameters.map((p) => type4C(p.type)).join(', ')}';
    //   var typeAliasElementImpl = TypeAliasElementImpl(aliasName, 0);
    //   typeAliasElementImpl.aliasedType = namedType;
    //   addTypeDef(typeAliasElementImpl);
    //   return '${aliasName}FFI';
    // }
    else if (!isPrimitive(namedType)) {
      return getGen(namedType.element!).objType(); //'DartObj'; // object are passes as ids or structs
    }
    return namedType.toString();
  }

  String type4DRet(DartType namedType) {
    if (namedType is VoidType) {
      return 'void';
    }
    if (isPrimitive(namedType)) {
      var type4d = type4D(namedType);
      return namedType.isDartCoreString ? type4d : type4d.substring(4).toLowerCase();
    }
    var gen = getGen(namedType.element!);
    return gen.objType() == 'DartObj' ? 'int' : gen.objType();
  }

  String type4D(DartType namedType) {
    var h = getHandler(namedType);
    if (h != null) {
      return h.type4D(namedType);
    }
    // if (namedType is InterfaceType) {
    if (namedType.isDartCoreString) {
      return 'ffi.Pointer<ffi.Char>';
    }
    else if (namedType.isDartCoreInt) {
      return 'ffi.Int';
    }
    else if (namedType.isDartCoreDouble) {
      return 'ffi.Double';
    }
    else if (namedType.isDartCoreBool) {
      return 'ffi.Int';
    }
    else if (namedType.isDartCoreNum) {
      return 'ffi.Num';
    }
    else if (namedType.element is EnumElement) {
      return 'ffi.Int';
    }
    else if (namedType.isDartCoreList) {
      final arrayType = (namedType as InterfaceType).typeArguments[0];
      if (isPrimitive(arrayType)) {
        return 'ffi.Pointer<${type4D(arrayType)}>';
      } else {
        return 'ArrayC';
      }
    }
    // else if (namedType is FunctionType) {
    //   if (namedType.alias != null) {
    //     return '${namedType.alias!.element.name}FFI';
    //   }
    //   final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
    //   return '${cbRet}Callback${namedType.parameters.map((p) => type4C(p.type)).join(', ')}';
    // }
    else if (!isPrimitive(namedType)) {
      return getGen(namedType.element!).objType();// 'DartObj';
    }
    throw UnsupportedError('Unsupported type $namedType');
    // }
  }

  String paramValue4FFM(Types types, ParameterElement param) {
    final t = param.type;
    var value = Params.escape4J(types, param);
    final h = getHandler(t);
    if (h != null) {
      return h.value4FFM(param);
    }
    if (t is InterfaceType) {
      // else {
      //   value = '_widgetsMap[$value]! as $t';
      // }
    }
    if (param.isOptional) {
      if (t.isDartCoreString) {
        value = 'ptrStr($value)';
      }
      else if (t.isDartCoreBool) {
        value = 'ptrBool($value)';
      }
      // else if (t.isDartCoreInt) {
      //   value = 'ptr($value)';
      // }
      // else if (t.isDartCoreDouble) {
      //   value = 'ptr($value)';
      // }
      else if (t.isDartCoreList) {
        final arrayType = (t as InterfaceType).typeArguments[0];
        if (arrayType.isDartCoreString) {
          value = 'ptrStrList($value)';
        } else {
          value = 'ptrList($value)';
        }
      }
      else if (t.element is EnumElement) {
        value = 'ptrEnum($value)';
      }
      // else if (t is FunctionType) {
      //   // final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
      //   if (t.alias != null) {
      //     String functional;
      //     if (t.returnType is VoidType) {
      //       // if (t.parameters.isEmpty) {
      //       //   return '${t.alias!.element.name}.allocate(ptrRun($value)';
      //       // }
      //       functional = t.parameters.isEmpty ? 'run' : 'accept';
      //       // return 'ptrConsumer($value)';
      //     } else {
      //       functional = t.parameters.isEmpty ? 'get' : 'apply';
      //       // return 'ptrSupplier($value)';
      //     }
      //     final parameters = t.parameters;
      //     final names = parameters.map((p) => Params.escape4J(types, p)).join(', ');
      //     final values = parameters.map((p) => paramValueFFMtoJ(types, p)).join(', ');
      //     // final decl = filtered.map((p) => '${paramDef(generation, p, wrap: p.isOptional)} ${escape(p)}').join(', ');
      //     var lambda = '$value.get().$functional($values)';
      //     if (t.returnType is! VoidType) {
      //       lambda = paramValue4FFM(types, paramElement(lambda, t.returnType));
      //     }
      //     final allocateCB = '${t.alias!.element.name}FFI.allocate(($names) -> $lambda, arena)';
      //     value = '$value.isPresent() ? $allocateCB : MemorySegment.NULL';
      //     return value;
      //     // return '$value.isPresent() ? ${t.alias!.element.name}.allocate(() -> $value.get()) : MemorySegment.NULL';
      //   }
      //   return 'ptrFn($value)';
      // }
      else if (!isPrimitive(t)) {
        value = 'ptrObj($value)';
      }
      else {
        value = 'ptr($value)';
      }
    } else {
      if (t.isDartCoreString) {
        value = 'arena.allocateFrom($value)';
      }
      else if (t.isDartCoreList) {
        final arrayType = (t as InterfaceType).typeArguments[0];
        if (arrayType.isDartCoreString) {
          value = 'ptrStrList($value)';
        } else {
          value = 'ptrList($value)';
        }
      }
      else if (t.element is EnumElement) {
        value = '$value.ordinal()';
      }
      // else if (t.isDartCoreMap) {
      //   value = 'ptrMap($value)';
      // }
      // else if (t is FunctionType) {
      //   // final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
      //   return 'ptrFn($value)';
      // }
      else if (!isPrimitive(t)) {
        if (t.nullabilitySuffix == NullabilitySuffix.question) {
          value = '$value != null ? $value.build().getId() : null';
        } else {
          value = '$value.build().getId()';
        }
      }
    }
    return value;
  }

  String paramValueFFMtoJ(Types types, ParameterElement param) {
    var t = param.type;
    if (t is TypeParameterType) {
      t = t.bound;
    }
    var value = Params.escape4J(types, param);
    if (t.isDartCoreBool) {
      return 'intToBool($value)';
    }
    else if (t.isDartCoreString) {
      return '$value.getString(0)';
    }
    else if (t.element is EnumElement) {
      value = '${t.element!.name}.values()[$value]';
    }
    else if (t.isDartCoreList) {
      final arrayType = (t as InterfaceType).typeArguments[0];
      if (arrayType.isDartCoreString) {
        return 'memToStrList($value)';
      } else {
        // value = 'ptrList($value)';
      }
    }
    else if (!isPrimitive(t) && t.element is! EnumElement && t is! FunctionType && !t.isDartCoreList) {
      if (hasSubClassInJava(t)) {
        return 'SubclassedInJava.getSubNatObj($value)';
      } else {
        if (isInterface(t.element)) {
          return 'new ${t.element!.name}() { public int getId() { return $value; } }';
        } else {
          var isAbstract = t.element is ClassElement &&
              (t.element as ClassElement).isAbstract;
          return 'new ${t.element!.name}($value)${isAbstract ? ' {}' : ''}';
        }
      }
    }
    return value;
  }

  bool hasSubClassInJava(DartType t) {
    return widgets.any((w) => w.name == "Sub${t.element!.name}");
  }

}

bool isPrimitive(DartType t) => t.isDartCoreString || t.isDartCoreBool || t.isDartCoreDouble || t.isDartCoreInt;

bool isInterface(Element? dartClass) {
  if (dartClass == null || dartClass is MixinElement) {
    return true;
  }
  if (dartClass is EnumElement)
    return false;
  if (dartClass is TypeParameterElement)
    return isInterface(dartClass.bound?.element);
  if (dartClass is ClassElement) {
    if (isPrimitive(dartClass.thisType))
      return false;
    if (dartClass.thisType.isDartCoreObject)
      return true;
    return (dartClass.isInterface || dartClass.isMixinClass ||
            (dartClass.isAbstract &&
                (dartClass.interfaces.any((i) => i.element is ClassElement) ||
                    (dartClass.methods.every((m) => m.isAbstract) &&
                        (dartClass.fields.isEmpty || dartClass.fields.every((f) => f.getter!.isAbstract))
                        && dartClass.allSupertypes.every((s) => isInterface(s.element))))
                ));
  }
  return false;
}

mixin TypeHandler {
  late Types types;
  bool matches(DartType t);
  String type4C(DartType t);
  String type4D(DartType t);
  String type4J(DartType t);
  String value4D(ParameterElement param);
  String value4FFM(ParameterElement param);
}

class MapHandler with TypeHandler {
  @override
  bool matches(DartType t) => t.isDartCoreMap && (t as ParameterizedType).typeArguments[0].isDartCoreInt;
  @override
  String type4C(DartType t) => 'MapC';
  @override
  String type4D(DartType t) => 'MapC';
  @override
  String type4J(DartType t) => 'Map<Integer, ${(t as ParameterizedType).typeArguments[1]}>';
  @override
  String value4D(ParameterElement param) => '${param.name}.toMap()';
  @override
  String value4FFM(ParameterElement param) => 'ptrMap(${Params.escape4J(types, param)})';
}

class FunctionHandler with TypeHandler {
  @override
  bool matches(DartType t) =>
      t is FunctionType && (t.parameters.isEmpty ||
          t.parameters.every((p) => types.supportedType(p.type) || p.type is TypeParameterType)) &&
          (t.returnType is VoidType || types.supportedType(t.returnType));
  @override
  String type4C(DartType t) {
    var fn = t as FunctionType;
    var alias = fn.alias;
    if (fn.alias == null) {
      String aliasName = getAliasName(fn);
      alias = InstantiatedTypeAliasElementImpl(element: TypeAliasElementImpl(aliasName, 0)..aliasedType = fn, typeArguments: []);
    }
    types.addTypeDef(alias!);
    return getAliasName(fn, withSuffix: true);
  }
  String getAliasName(FunctionType fn, {bool withSuffix = false}) {
    var alias = fn.alias;
    if (alias != null) {
      return getInstantiatedAliasName(alias, withSuffix: withSuffix);
    }
    final cbRet = (fn.returnType is VoidType) ? 'Void' : types.type4C(fn.returnType);
    final aliasName = '${cbRet}Callback${fn.parameters.map((p) => types.type4C(p.type)).join('')}';
    return '$aliasName${withSuffix ? 'FFI' : ''}';
  }
  String getInstantiatedAliasName(InstantiatedTypeAliasElement alias, {bool withSuffix = false}) {
    return '${alias.element.name}${alias.typeArguments.isEmpty ? '' : 'For${alias.typeArguments.map((t) => t.element!.name!.firstUpper()).join()}'}${withSuffix ? 'FFI' : ''}';
  }
  @override
  String type4D(DartType t) {
    var fn = t as FunctionType;
    return getAliasName(fn, withSuffix: true);
  }
  @override
  String type4J(DartType t, [List<DartType>? typeArguments]) {
    var fn = t as FunctionType;
    var params = bindTypeParameters(fn.parameters, typeArguments ?? []).map((p) => boxedType(types.type4J(p.type).firstUpper())).join(', ');
    if (fn.returnType is VoidType) {
      if (fn.parameters.isEmpty) {
        return 'Runnable';
      }
      return 'Consumer<$params>';
    } else {
      var retType4j = types.type4J(fn.returnType);
      if (fn.parameters.isEmpty) {
        return 'Supplier<$retType4j>';
      }
      final arity = switch(fn.parameters.length) {
        1 => '',
        2 => 'Bi',
        3 => 'Tri',
        4 => 'Quad',
        var i => throw 'Unsupported $i args function',
      };
      return '${arity}Function<$params, $retType4j>';
    }
  }
  @override
  String value4D(ParameterElement param) {
    final t = param.type as FunctionType;
    var value = param.name;
    value = '$value.to${getAliasName(t)}Fn()';
    return value;
  }
  @override
  String value4FFM(ParameterElement param) {
    var value = Params.escape4J(types, param);
    final t = param.type as FunctionType;
    if (param.isOptional) {
      final fn = 'ptr${getAliasName(t)}Fn($value.get())';
      value = '$value.isPresent() ? $fn : MemorySegment.NULL';
    } else {
      value = 'ptr${getAliasName(t)}Fn($value)';
    }
    return value;
  }

  String functionMethod(FunctionType t) {
    String functional;
    if (t.returnType is VoidType) {
      functional = t.parameters.isEmpty ? 'run' : 'accept';
    } else {
      functional = t.parameters.isEmpty ? 'get' : 'apply';
    }
    return functional;
  }
}

String boxedType(String name) => switch (name.toLowerCase()) {
  'int' => 'Integer',
  'double' => 'Double',
  'bool' => 'Boolean',
  _ => name
};

ParameterElement paramElement(String name, DartType type, [ParameterKind? kind]) => ParameterElementImpl.synthetic(name, type, kind ?? (type.nullabilitySuffix == NullabilitySuffix.question ? ParameterKind.POSITIONAL : ParameterKind.REQUIRED));

List<ParameterElement> bindTypeParameters(List<ParameterElement> parameters, List<DartType> typeArguments) {
  if (typeArguments.isEmpty) {
    return parameters;
  }
  List<ParameterElement> newParams = List.of(parameters, growable: false);
  var tpi = 0;
  for (var i=0; i < parameters.length; i++) {
    var parameter = parameters[i];
    if (parameter.type is TypeParameterType && tpi < typeArguments.length) {
      newParams[i] = paramElement(parameter.name, typeArguments[tpi]);
    }
  }
  return newParams;
}
