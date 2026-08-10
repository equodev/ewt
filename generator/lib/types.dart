import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';
import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
import 'package:analyzer/src/dart/element/element.dart';
import 'package:analyzer/src/dart/element/type.dart';
import 'package:analyzer/src/generated/utilities_dart.dart';
import 'package:analyzer/src/utilities/extensions/string.dart';
import 'package:collection/collection.dart';

import 'gen.dart';
import 'type_mapping.dart';

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
      // Widgets with a divergent emission shape live in emit/special/*
      // and are dispatched here by name. This is the single place where a
      // class name maps to a concrete generator subclass; downstream code
      // uses polymorphism via the returned generator.
      switch (dartClass.name) {
        case 'AnimationController': return AnimationControllerGen(this, dartClass);
        case 'ColorFilter': return ColorFilterGen(this, dartClass);
        case 'ImageFilter': return ImageFilterGen(this, dartClass);
        case 'ListView': return ListViewGen(this, dartClass);
        case 'MaterialColor': return MaterialColorGen(this, dartClass);
        case 'SubState': return SubStateGen(this, dartClass);
        case 'SubStatefulWidget': return SubStatefulWidgetGen(this, dartClass);
        case 'SubStatelessWidget': return SubStatelessWidgetGen(this, dartClass);
        case 'SubAnimatedState': return SubAnimatedStateGen(this, dartClass);
      }
      if ((dartClass.hasImmutable || dartClass.allSupertypes.any((s) => s.element.hasImmutable)) && !dartClass.isAbstract) {
        return ImmutableGen(this, dartClass);
      }
      return WidgetGen(this, dartClass);
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
            (d.element.name == t.element.name && ListEquality().equals(d.typeArguments, t.typeArguments)) ||
            // Two entries with the same element name and same type-argument *names* (e.g. both T→T) are
            // structurally identical even if the TypeParameterElement instances differ across generic widgets.
            (d.element.name == t.element.name &&
                d.typeArguments.length == t.typeArguments.length &&
                _listsEqualByName(d.typeArguments, t.typeArguments));
    if (!typeDefs.any(equals)) {
      typeDefs.add(t);
    }
  }

  static bool _listsEqualByName(List<DartType> a, List<DartType> b) {
    for (var i = 0; i < a.length; i++) {
      if (a[i].getDisplayString(withNullability: true) != b[i].getDisplayString(withNullability: true)) return false;
    }
    return true;
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
    // Treat `dynamic` as `Object` (→ NativeObj) so callback params typed
    // `List<dynamic>` (e.g. DragTarget.builder's rejectedData) are marshalable.
    if (t is DynamicType || t.isDartCoreObject) {
      return true;
    }
    if (t.isDartCoreList && supportedType((t as InterfaceType).typeArguments[0])) {
      // Numeric primitive lists (List<double>, List<int>) have no length prefix
      // on the Dart side to unmarshal them back into a Dart List — so the
      // enclosing factory won't compile. Mark unsupported to skip such factories
      // (e.g. `ColorFilter.matrix(Float64List)`) while keeping the sibling
      // factories (`.mode`, `.linearToSrgbGamma`, …) generatable.
      final at = (t).typeArguments[0];
      if (at.isDartCoreDouble || at.isDartCoreInt) {
        unsupportedTypes.add(t);
        return false;
      }
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

  /// Java surface of a Dart type. Thin shim over [TypeMapping.resolve]; kept
  /// as a member for call-site continuity — every emitter still writes
  /// `types.type4J(t)`.
  String type4J(DartType namedType) => TypeMapping(this).resolve(namedType).java;

  /// C surface of a Dart type. Shim over [TypeMapping.resolve].
  String type4C(DartType namedType) => TypeMapping(this).resolve(namedType).c;

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

  /// FFI-Dart surface of a Dart type. Shim over [TypeMapping.resolve].
  String type4D(DartType namedType) => TypeMapping(this).resolve(namedType).dart;

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
    // C has no bool, so the bridge marshals one as int. Optionals reach the
    // ptrBool branch below, but a required bool is passed by value and has to
    // be widened here (Checkbox.value, Switch.value).
    if (!param.isOptional && t.isDartCoreBool) {
      return '($value ? 1 : 0)';
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
          // Primitive-double / primitive-int lists are filtered out upstream
          // (see supportedType), so `ptrList` here always sees NativeObj Ts.
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
          // Primitive-double / primitive-int lists are filtered out upstream
          // (see supportedType), so `ptrList` here always sees NativeObj Ts.
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

  /// Converts an incoming FFM value to its Java form.
  ///
  /// [fromCallback] marks the upcall path, where a nullable bool is declared as
  /// `int*` in the typedef and so arrives as a pointer. Struct field getters
  /// read the same bool back as a plain int, hence the distinction.
  String paramValueFFMtoJ(Types types, ParameterElement param, {bool fromCallback = false}) {
    var t = param.type;
    // Field getters typed as a type parameter `T` come back as an int id from
    // the struct. We can't marshall arbitrary values so — with `_sanitizeTypeParam`
    // constraining `T extends NativeObj` — the only viable value is a NativeObj
    // wrapper cast to T so Java's return-type check is satisfied.
    String? tpCast;
    if (t is TypeParameterType) {
      tpCast = '(NativeObj) ';
      t = t.bound;
    }
    var value = Params.escape4J(types, param);
    if (tpCast != null) {
      // On the callback upcall path, TypeParameterType params may arrive as either:
      //   - DartObj (int) when non-nullable: wrap=false in paramDef4C → Java int param
      //   - DartObj* (MemorySegment) when nullable/optional: wrap=true → Java MemorySegment param
      // `_dartTypeStr` always widens TypeParameterType to nullable T?, so in practice
      // callback TypeParameterType params are DartObj* (MemorySegment). We detect this
      // by checking param.isOptional (nullable T → optional positional → isOptional=true).
      if (fromCallback && param.isOptional) {
        // `value` is MemorySegment (DartObj* pointer); dereference as C_INT to get the id.
        return '(NativeObj) new NativeObj.Base() {{ this.id = $value.reinterpret(StarterBridge.C_INT.byteSize()).get(StarterBridge.C_INT, 0); }}';
      }
      return '(NativeObj) new NativeObj.Base() {{ this.id = $value; }}';
    }
    if (t.isDartCoreBool) {
      return fromCallback && t.nullabilitySuffix == NullabilitySuffix.question
          ? 'memToBool($value)'
          : 'intToBool($value)';
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
      } else if (types.isWidget(arrayType.element)) {
        // On the callback upcall path, Flutter hands back an ArrayC struct
        // (see WidgetConstructorsBase.memToWidgetList) holding the ids of the
        // widgets. Unmarshal each id back into a Widget wrapper.
        return 'memToWidgetList($value)';
      } else if (arrayType is TypeParameterType || arrayType is DynamicType ||
          arrayType.isDartCoreObject) {
        // `List<T>`, `List<dynamic>`, `List<Object>` — treat as an ArrayC of
        // ids and coerce to the target type (unchecked). Used by e.g.
        // DragTarget.builder's candidateData / rejectedData.
        final targetJava = types.type4J(t);
        return '(($targetJava) (List) memToWidgetList($value))';
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
    return widgets.any((w) => w.name == "Sub${t.element?.name}");
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
    // Nullability is part of the identity: ValueChanged<bool> (Switch.onChanged)
    // and ValueChanged<bool?> (Checkbox.onChanged, which is tristate) are kept as
    // distinct typedefs, so dropping the `?` here would name both
    // ValueChangedForBool and emit the same helper twice.
    return '${alias.element.name}${alias.typeArguments.isEmpty ? '' : 'For${alias.typeArguments.map((t) => '${t.element!.name!.firstUpper()}${t.nullabilitySuffix == NullabilitySuffix.question ? 'Opt' : ''}').join()}'}${withSuffix ? 'FFI' : ''}';
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
      // Consumer only takes one type argument, so the arity has to pick the
      // matching interface the same way the value-returning branch does.
      final arity = switch(fn.parameters.length) {
        1 => '',
        2 => 'Bi',
        3 => 'Tri',
        4 => 'Quad',
        5 => 'Penta',
        var i => throw 'Unsupported $i args function',
      };
      return '${arity}Consumer<$params>';
    } else {
      // Return type also has to be boxed when it sits inside Function<>,
      // otherwise a bool return leaks as `boolean` — invalid inside generics.
      var retType4j = boxedType(types.type4J(fn.returnType).firstUpper());
      if (fn.parameters.isEmpty) {
        return 'Supplier<$retType4j>';
      }
      final arity = switch(fn.parameters.length) {
        1 => '',
        2 => 'Bi',
        3 => 'Tri',
        4 => 'Quad',
        5 => 'Penta',
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
    // Optional params arrive as a nullable pointer, so .toFn() is nullable.
    // When the Flutter parameter type is a NON-nullable function (it carries a
    // default value), fall back to a no-op builder so the value stays
    // assignable. Builder-style callbacks return Widget?/void, so => null fits.
    if (param.isOptional && t.nullabilitySuffix != NullabilitySuffix.question) {
      // Flutter treats these callbacks as non-nullable — it INVOKES them itself
      // (e.g. AnimatedSwitcher.layoutBuilder is called every rebuild, Draggable
      // .dragAnchorStrategy every drag start). If the Java caller didn't supply
      // one, fall back to Flutter's declared default (`param.defaultValueCode`)
      // so behaviour matches what a plain-Flutter user would see. Only if
      // there's no default (rare) do we synthesize a lambda that returns null —
      // acceptable for Widget?-returning builders but wrong for value-returning
      // ones. `throw` would compile as Never but bombs at first invocation.
      final defaultCode = param.defaultValueCode;
      // Skip defaults that reference private identifiers (Flutter's
      // `_defaultBottomSheetScrimBuilder`, etc.) — they aren't visible from our
      // widgets library, so we can't emit them. Fall back to a null-returning
      // lambda; that's safe for Widget?-returning builders (Flutter usually
      // treats null as "use the framework default").
      final usableDefault = defaultCode != null &&
          defaultCode.isNotEmpty &&
          defaultCode != 'null' &&
          !RegExp(r'\b_[A-Za-z]').hasMatch(defaultCode);
      if (usableDefault) {
        value = '($value ?? $defaultCode)';
      } else {
        final lambdaParams = List.generate(t.parameters.length, (i) => 'p$i').join(', ');
        value = '($value ?? ($lambdaParams) => null)';
      }
    }
    return value;
  }
  @override
  String value4FFM(ParameterElement param) {
    var value = Params.escape4J(types, param);
    final t = param.type as FunctionType;
    if (param.isOptional) {
      // Optional callbacks are emitted as ffi.Pointer<FFI> (Type*) in C, so the
      // stub address must be wrapped in an 8-byte holder (see ptrHolder).
      final fn = 'ptrHolder(ptr${getAliasName(t)}Fn($value.get()))';
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
      final arg = typeArguments[tpi];
      // If we'd be substituting T → T (same type-parameter element), skip:
      // the substitution is a no-op that also loses the original param's
      // nullability suffix (e.g. `T?` becomes `T`). Only substitute when arg
      // is a concrete instantiation.
      if (arg is TypeParameterType && arg.element == (parameter.type as TypeParameterType).element) {
        continue;
      }
      newParams[i] = paramElement(parameter.name, arg);
    }
  }
  return newParams;
}
