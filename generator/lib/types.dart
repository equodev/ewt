import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

import 'gen.dart';

class Types {
  Set<DartType> unsupportedTypes = {};
  Set<DartType> requiredTypes = {};
  Set<TypeAliasElement> typeDefs = {};
  Iterable<ClassElement> widgets;
  ClassElement? widgetElement;
  List<TypeHandler> handlers;

  Types(Iterable<ClassElement> widgets) :
        widgetElement = widgets.first,
        widgets = widgets.skip(1),
        handlers = [MapHandler()];

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
    throw UnsupportedError('No AGen for $dartClass');
  }

  void addTypeDef(TypeAliasElement element) {
    typeDefs.add(element);
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
    if (t.isDartCoreEnum || isPrimitive(t)) {
      return true;
    }
    if (t.element is EnumElement) {
      return true;
    }
    if (t.isDartCoreList && supportedType((t as InterfaceType).typeArguments[0])) {
      return true;
    }
    if (t is FunctionType) {
      return (t.parameters.isEmpty || t.parameters.every((p) => supportedType(p.type))) && (t.returnType is VoidType || supportedType(t.returnType));
    }
    if (/*['InlineSpan', 'ThemeData', 'Color', 'ColorScheme'].contains(t.getDisplayString(withNullability: false))
        ||*/ isWidget(t.element) || widgets.contains(t.element) || widgets.any((w) => isSubtype(w, t.element))) {
      return true;
    }
    for (var handler in handlers) {
      if (handler.matches(t)) {
        return true;
      }
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
      if (handler.matches(t)) {
        return handler;
      }
    }
    return null;
    // throw 'Wrong type $t not supported by any handler';
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
    else if (namedType is FunctionType) {
      var params = namedType.parameters.map((p) => type4J(p.type).firstUpper()).join(', ');
      if (namedType.returnType is VoidType) {
        if (namedType.parameters.isEmpty) {
          return 'Runnable';
        }
        return 'Consumer<${params}>';
      } else {
        var retType4j = type4J(namedType.returnType);
        if (namedType.parameters.isEmpty) {
          return 'Supplier<${retType4j}>';
        }
        final arity = switch(namedType.parameters.length) {
          1 => '',
          2 => 'Bi',
          var i => throw 'Unsupported $i args function',
        };
        return '${arity}Function<$params, $retType4j>';
      }
    }
    return namedType.toString();
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
    else if (namedType is FunctionType) {
      if (namedType.alias != null) {
        addTypeDef(namedType.alias!.element);
        return '${namedType.alias!.element.name}FFI';
      }
      final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
      return '${cbRet}Callback${namedType.parameters.map((p) => type4C(p.type)).join(', ')}';
    }
    else if (!isPrimitive(namedType)) {
      return getGen(namedType.element!).objType(); //'DartObj'; // object are passes as ids or structs
    }
    return namedType.toString();
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
    else if (namedType is FunctionType) {
      if (namedType.alias != null) {
        return '${namedType.alias!.element.name}FFI';
      }
      final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
      return '${cbRet}Callback${namedType.parameters.map((p) => type4C(p.type)).join(', ')}';
    }
    else if (!isPrimitive(namedType)) {
      return getGen(namedType.element!).objType();// 'DartObj';
    }
    throw UnsupportedError('Unsupported type $namedType');
    // }
  }

}

bool isPrimitive(DartType t) => t.isDartCoreString || t.isDartCoreBool || t.isDartCoreDouble || t.isDartCoreInt;

mixin TypeHandler {
  bool matches(DartType t);
  String type4C(DartType t);
  String type4D(DartType t);
  String type4J(DartType t);
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

}
