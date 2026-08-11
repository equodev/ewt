part of '../../gen.dart';

class WidgetGen implements AGen {
  Types types;
  ClassElement dartClass;
  String widgetClass;
  String widgetField;
  final EmitContext ctx = EmitContext();

  bool hasMembers = false;

  bool _isInterface = false;

  /// Optional companion class (named `<TargetClass>Methods` in generation_index.dart).
  /// Its public static methods whose first parameter is typed as the target class are
  /// emitted as instance methods on this widget's Java file — first param becomes the
  /// implicit receiver via `this.id`.
  ClassElement? methodsCompanion;

  WidgetGen(this.types, this.dartClass):
        widgetClass = dartClass.name,
        widgetField = escapeReserved('${dartClass.name[0].toLowerCase()}${dartClass.name.substring(1)}');

  String objType() => 'DartObj';

  @override
  String dartToC(String theVar) => '_addWidget($theVar)';

  bool _isSupportedFactory(FunctionTypedElement n) =>
      !n.parameters.any((p) => p.isRequired && !types.supportedType(p.type)) &&
      types.supportedType(n.returnType);

  /// True for abstract *classes* (not interfaces) that expose Dart `factory`
  /// constructors we can generate — currently `ImageFilter` and `ColorFilter`
  /// (see emit/special/image_filter_gen.dart / color_filter_gen.dart).
  ///
  /// Skips (a) abstract classes that Java would emit as interfaces (Animation,
  /// Future, EdgeInsetsGeometry) since interfaces can't hold `static factories`
  /// nor Immutables `@Builder.Factory`; and (b) abstract classes that already
  /// have a concrete subclass in the widget set (e.g. `BorderRadiusGeometry`
  /// has `BorderRadius` — emitting factories on both would produce
  /// Java-illegal covariant static-hiding). The membership decision lives on
  /// each generator subclass via [isAbstractFactoryHost] — no scattered
  /// allowlist to keep in sync.
  bool get _hasAbstractFactoryCtors {
    if (!dartClass.isAbstract) return false;
    if (!isAbstractFactoryHost) return false;
    return dartClass.constructors.where((f) => f.isPublic && f.isFactory)
        .any(_isSupportedFactory);
  }

  /// Java rejects `<T extends Object?>`; strip nullable / Object bounds so
  /// generic widgets (Draggable, TweenAnimationBuilder, etc.) emit valid Java.
  /// Kept naked on the class declaration to preserve compatibility with existing
  /// consumers (e.g. `AnimationController extends Animation<Double>`, which
  /// would not satisfy a `T extends NativeObj` constraint).
  String _sanitizeTypeParam(TypeParameterElement tp) {
    final bound = tp.bound;
    if (bound == null || bound.isDartCoreObject) return tp.name;
    return '${tp.name} extends ${types.type4J(bound)}';
  }

  /// Type-parameter prefix for static factory methods on generic widgets.
  /// Constrains unbounded params to `T extends NativeObj` so marshaling through
  /// `ptrObj(Optional<T>)` compiles at the call site.
  String get _factoryTypeParamPrefix {
    if (dartClass.typeParameters.isEmpty) return '';
    final decl = dartClass.typeParameters.map((tp) {
      final bound = tp.bound;
      if (bound == null || bound.isDartCoreObject) return '${tp.name} extends NativeObj';
      return '${tp.name} extends ${types.type4J(bound)}';
    }).join(', ');
    return '<$decl>';
  }

  /// Naked type parameters (no bound), used when emitting the `<T>` prefix on
  /// static factory methods that must propagate the containing class's generics.
  String get _typeParamPrefix =>
      dartClass.typeParameters.isEmpty ? '' : '<${dartClass.typeParameters.map((t) => t.name).join(', ')}>';

  // ---------- Subclass extension points (see emit/special/*) ----------
  //
  // Widgets whose emitted shape diverges from the default flow subclass
  // WidgetGen (via Types.getGen) and override one of these hooks instead of
  // being handled with `if (widgetClass == 'X')` branches scattered across
  // emitters. Add a hook rather than inlining a check.

  /// Extra Java class body written before the synthetic `build()` method.
  /// Default: no-op. Overridden by widgets that need extra Java members
  /// (e.g. AnimationController's web-command routing infrastructure).
  void writeExtraJavaClassBody() {}

  /// Emitted at the start of the void-return branch in the Java instance
  /// method wrapper, before the FFM call. Lets a widget short-circuit or
  /// preroute the call in web mode. Default: no-op.
  void writeVoidMethodWebPrelude(String factory) {}

  /// Hook for the non-void return branch of the Java instance method wrapper.
  /// Return true to indicate the return statement was emitted by the
  /// override; return false to fall back to the standard
  /// `return types.paramValueFFMtoJ(...)`. Default: false.
  bool tryWriteCustomInstanceMethodReturn(String factory, DartType returnType) => false;

  /// Whether to skip emitting a @Override into javaSerializer for this
  /// factory. Used by widgets whose serializer form is hand-maintained
  /// downstream (e.g. SubAnimatedState.animationController is threaded
  /// through EwtWebCapture). Default: false.
  bool skipJavaSerializer(String factory) => false;

  /// The Dart-side constructor name emitted by writeDFactory for
  /// `new $ctor(...)`. Default: [widgetClass]. Overridden by SubclassGen
  /// (to `node.displayName`) and SubStateful/SubStatelessWidgetGen
  /// (prefix with `_Tracked` — see factories.dart for the tracked variant).
  String dartFactoryCtorClass(FunctionTypedElement node) => widgetClass;

  /// Custom writer for the whole `@Override ... $factoryName(...)` body in
  /// [EmitContext.javaSerializer]. Return true to short-circuit the default
  /// emission. Default: false. Used by widgets whose serializer body is not
  /// a plain node record (e.g. ListView.builder eager-expands children).
  bool tryEmitCustomJavaSerializer(
    FunctionTypedElement node,
    String factoryName,
    String factory,
    Params jParamsFFM,
    String jtp,
    String? objStClass,
  ) => false;

  /// Extra fields written into the just-allocated *ObjSt struct inside the
  /// Java serializer. Called after `$objStClass.id(st, id)` and before
  /// `return st`. Default: no-op. MaterialColorGen uses this to populate
  /// the shadeXXX color-id fields from the swatch.
  void emitExtraJavaSerializerFields(String factoryName, String objStClass) {}

  /// Custom writer for the web decoder entry in
  /// [EmitContext.dartWebDecoders]. Return true to short-circuit the default
  /// emission (either because a bespoke entry was written or because the
  /// factory has no useful web decoder). Default: false.
  bool tryEmitCustomWebDecoder(String factory, String factoryName, FunctionTypedElement node) => false;

  /// Whether to skip the "web mode" branch in [ObjStGen.writeJavaFieldAccessor].
  /// True for widgets whose field accessors are pre-resolved at serialize
  /// time (MaterialColor's shade fields). Default: false.
  bool get skipWebFieldAccessor => false;

  /// Whether this abstract class should emit factory constructors as static
  /// Java factories (see [_hasAbstractFactoryCtors]). Default: false.
  /// ImageFilterGen / ColorFilterGen override to true.
  bool get isAbstractFactoryHost => false;

  @override
  void gen() {
    var constructors = dartClass.constructors.where((f) => f.isPublic);
    var staticMethods = dartClass.methods.where((m) => m.isStatic && m.isPublic && !m.returnType.isDartCoreList);
    var consts = dartClass.fields.where((f) => f.isStatic && f.isConst).whereType<ConstFieldElementImpl>();
    var companionMethods = methodsCompanion?.methods.where((m) => m.isStatic && m.isPublic && _isCompanionInstanceMethod(m)) ?? const <MethodElement>[];
    // Abstract classes can still expose Dart `factory` constructors (e.g.
    // `ImageFilter.blur(...)` is a factory on the abstract `ImageFilter`);
    // treat those as generatable so callers get concrete instances.
    var abstractFactoryConstructors = _hasAbstractFactoryCtors
        ? constructors.where((c) => c.isFactory)
        : const <ConstructorElement>[];
    var hasSupportedFactory = (!dartClass.isAbstract && (constructors.any(_isSupportedFactory) || staticMethods.any(_isSupportedFactory)))
        || abstractFactoryConstructors.any(_isSupportedFactory);
    var hasPrivateConsts = consts.where(isPrivateConst).isNotEmpty;
    var hasCompanionMethods = companionMethods.any(_isSupportedFactory);
    hasMembers = hasSupportedFactory || hasPrivateConsts || hasCompanionMethods;
    writeHeaders(hasMembers);
    if (hasMembers) {
      ctx.dartAssigns.writeln('void _setup$widgetClass(WidgetFactories f) {');
    }
    writeJavaConstructors();
    if (!dartClass.isAbstract) {
      for (var constr in constructors) {
        writeFactory(constr);
      }
      for (var constr in dartClass.methods.where((m) => m.isStatic && m.isPublic && !m.returnType.isDartCoreList /*&& m.returnType == dartClass.thisType*/)) {
        writeFactory(constr);
      }
      for (var method in companionMethods) {
        writeInstanceMethod(method, methodsCompanion!.name);
      }
    } else {
      for (var constr in abstractFactoryConstructors) {
        writeFactory(constr);
      }
    }
    writeMembers();
    if (consts.isNotEmpty) {
      var c=1;
      for (var constr in consts) {
        writeConst(constr, c++);
      }
    }
    if (hasMembers) {
      ctx.dartAssigns.writeln('}');
    }
    writeFooter(hasMembers);
    if (dartClass.supertype != null) {
      types.addRequiredType(dartClass.supertype as DartType);
    }
  }

  void writeJavaConstructors() {
    if (!_isInterface) {
      ctx.javaFile
          .writeln('  protected $widgetClass() {}');
      ctx.javaFile..writeln('  $widgetClass(int id) {')..writeln(
          '    this.id = id;')..writeln('  }');
      if (!dartClass.isAbstract) {
        ctx.javaFile.writeln('  public static $widgetClass byId(int id) { return new $widgetClass(id); }');
      }
    }
  }

  String genJavaClass() {
    return ctx.javaFile.toString();
  }

  String genDartFactories() {
    return '${ctx.dartAssigns}${ctx.dartFns}';
  }

  void write() {
    _writeJ(widgetClass, ctx.javaFile.toString());
    _writeJ('${widgetClass}I', ctx.builderFile.toString());
  }

  void writeHeaders(bool hasMembers) {
    ctx.javaFile
        .writeln('package dev.equo.ewt;');
    _isInterface = isInterface(dartClass);
    // Abstract classes with factory ctors we plan to emit must NOT be Java
    // interfaces (interfaces can't hold @Builder.Factory static methods that
    // reference `factories`). See _hasAbstractFactoryCtors.
    if (_isInterface && _hasAbstractFactoryCtors) _isInterface = false;
    // var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.map(_sanitizeTypeParam).join(', ')}>' : '';
    List<String> builderExtend = [];
    List<InterfaceType> trulyInterfaces = [];
    if (dartClass.supertype != null && !dartClass.supertype!.isDartCoreObject) {
      if (!_isInterface && isInterface(dartClass.supertype!.element)) {
        extend += ' extends NativeObj.Base';
        trulyInterfaces = [dartClass.supertype!];
        // builderExtend = ' extends ';
      } else {
        extend += ' extends ${toJavaClass(dartClass.supertype!)}';
        // builderExtend = ' extends ${toJavaClassUngeneric(dartClass.supertype!)}I';
        builderExtend = ['${toJavaClassUngeneric(dartClass.supertype!)}I'];
      }
      // extend += ' extends ${dartClass.supertype!.element.name}${dartClass.supertype!.typeArguments.isNotEmpty ? '<${dartClass.typeParameters.map((p) => p.name).join(', ')}>' : ''}';
      // builderExtend = ' extends ${toJavaClassUngeneric(dartClass.supertype!)}I';
    }
    else {
      extend += ' extends ${!_isInterface ? 'NativeObj.Base' : 'NativeObj, ${widgetClass}I'}';
      builderExtend = ['NativeObj.I'];
    }
    trulyInterfaces += dartClass.interfaces.where((i) =>
        i.interfaces.any((i) => i.element is ClassElement)).toList();
    if (_isInterface) {
      // A Java interface lists every supertype after a single `extends` — it
      // never uses `implements`. Fold the interface list into the extends
      // clause, keeping NativeObj and the `I` marker present exactly once.
      final iName = '${widgetClass}I';
      final supers = <String>[];
      if (!extend.contains(' extends ')) supers.add('NativeObj');
      supers.addAll(trulyInterfaces.map((i) => toJavaClass(i)));
      if (extend.contains(' extends ')) {
        if (supers.isNotEmpty) extend += ', ${supers.join(', ')}';
        if (!RegExp('\\b$iName\\b').hasMatch(extend)) extend += ', $iName';
      } else {
        supers.add(iName);
        extend += ' extends ${supers.join(', ')}';
      }
      builderExtend += trulyInterfaces.map((i) => '${toJavaClassUngeneric(i)}I').toList();
    } else if (trulyInterfaces.isNotEmpty) {
      extend += ' implements ${trulyInterfaces.map((i) => toJavaClass(i)).join(', ')}, ${widgetClass}I';
      builderExtend += trulyInterfaces.map((i) => '${toJavaClassUngeneric(i)}I').toList();
    } else {
      extend += ' implements ${widgetClass}I';
    } if (!dartClass.isAbstract || _hasAbstractFactoryCtors) {
      // Abstract classes that expose Dart `factory` constructors emit Immutables
      // @Builder.Factory methods too, so they need the same imports.
      ctx.javaFile
        ..writeln('import java.util.*;')
        ..writeln('import java.util.function.*;')
        ..writeln('import dev.equo.ewt.util.*;')
        ..writeln('import org.immutables.builder.Builder;');
    } else {
      ctx.javaFile
        .writeln('import java.util.*;');
    }
    writeJavaDecl(extend, _isInterface);
    if (hasMembers) {
      ctx.pendingStructHeader = '  struct ${widgetClass}St {';
    }

    ctx.builderFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('public interface ${widgetClass}I extends ${builderExtend.join(', ')} {\n'
          '  @Override\n'
          '  $widgetClass build();\n'
          '}');
  }

  void writeJavaDecl(String extend, bool isInterface) {
    if (!dartClass.isAbstract) {
      ctx.javaFile
          .writeln('public class $widgetClass$extend {');
      // ..writeln('  static final WidgetConstructors factories = WidgetConstructors.instance;');
    } else {
      ctx.javaFile
          .writeln('public ${isInterface ? 'interface' : 'abstract class'} $widgetClass$extend {');
    }
  }

  void writeFooter(bool hasMembers) {
    writeExtraJavaClassBody();
    // Note: return type is intentionally raw for generic widgets. Parametrizing
    // it (e.g. `State<T> build()`) breaks `SubclassGen`'s hand-emitted
    // `createState(...).build()` chain in `SubStatefulWidget.createStateFn`
    // (S from the enclosing method vs T inferred from State — Java refuses to
    // unify). The raw-type warning on Draggable.build()/DragTarget.build() is
    // the tolerable cost.
    ctx.javaFile.writeln('  @Override\n'
        '  ${_isInterface ? 'default' : 'public'} $widgetClass build() {\n'
        '    return this;\n'
        '  }');
    ctx.javaFile.writeln('}');
    if (hasMembers && ctx.pendingStructHeader == null) {
      ctx.headerFile.writeln('  } $widgetField;');
    }
    ctx.pendingStructHeader = null;
  }

  void writeFactory(FunctionTypedElement node) {
    if (node.parameters.any((p) => p.isRequired && !types.supportedType(p.type)) || !types.supportedType(node.returnType)) {
      return;
    }
    String factory = (node.name!.isEmpty) ? widgetField : node.name!;
    String factoryName = '$widgetField${factory.firstUpper()}';
    // Immutables derives the builder name from the @Builder.Factory method, so
    // it has to be built from factoryName rather than from widgetClass. The two
    // only agree while widgetField.firstUpper() == widgetClass, which stops
    // holding once widgetField is escaped (Switch -> switch_).
    String builderClass = '${factoryName.firstUpper()}Builder';
    if (node is ConstructorElement) {
      writeJavaFactory(node, factoryName, builderClass, factory);
    } else {
      writeJavaFactoryForStatic(node, factoryName, factory);
    }
    writeJavaSerializer(node, factoryName, factory);
    writeWebDecoder(factory, factoryName, node);
    // ctx.headerFile
    // .writeln("    int (*$factory)(${cParams.decl});");
    // CLang(generation).writeField(ctx.headerFile, factory, 'int', params: node.parameters);
    writeCFactory(factory, node, 'int');
    // var gen = generation.getGen(node.returnType.element!);
    // if (gen is WidgetGen) {
    //   gen.writeDFactory(factory, factoryName, node);
    //   ctx.dartAssigns.write(gen.ctx.dartAssigns);
    //   ctx.dartFns.write(gen.ctx.dartFns);
    // } else {
    writeDFactory(factory, factoryName, node);
    // }
  }

  /// A companion method qualifies as an instance method only if its first parameter
  /// is typed exactly as the target class (the receiver).
  bool _isCompanionInstanceMethod(MethodElement m) =>
      m.parameters.isNotEmpty &&
      m.parameters.first.type.element == dartClass.thisType.element;

  /// Emits a static method from the methods-companion as an instance method on the
  /// target class. First parameter (the receiver) is consumed: it does not appear
  /// in the Java signature and is replaced by `this.id` in the FFM call.
  void writeInstanceMethod(FunctionTypedElement node, String companionClassName) {
    if (!_isCompanionInstanceMethod(node as MethodElement)) return;
    if (node.parameters.any((p) => p.isRequired && !types.supportedType(p.type)) || !types.supportedType(node.returnType)) {
      return;
    }
    String factory = node.name!;
    String factoryName = '$widgetField${factory.firstUpper()}';
    writeJavaInstanceMethod(node, factoryName, factory);
    writeJavaSerializer(node, factoryName, factory);
    writeCFactory(factory, node, 'int');
    writeDInstanceMethod(factory, factoryName, node, companionClassName);
    writeWebInstanceDecoder(factory, factoryName, node);
  }


  void writeDFactory(String factory, String factoryName, FunctionTypedElement node) {
    var gen = node.returnType is! VoidType ? types.getGen(node.returnType.element!) : null;
    final dartParams = Params(types, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    ctx.dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName${gen == null || node.returnType.isDartCoreString || gen.objType().endsWith('ObjSt') ? '' : ', ${exception(node.returnType)}'});');
    // Native callbacks wired through ffi.Pointer.fromFunction must return a
    // NON-nullable type. A nullable factory result (e.g. a static lerp() that
    // returns T?) is absorbed here rather than surfacing as a nullable return:
    // _create*ObjSt(null) yields an empty struct (id 0) and paramValueDtoC
    // falls back to 0 / nullptr for a null value.
    final ctorClass = dartFactoryCtorClass(node);
    ctx.dartFns
      ..writeln('${types.type4DRet(node.returnType)} $factoryName(${dartParams.decl}) {')
      ..writeln('  ${gen == null ? '' : 'final w = '}$ctorClass${node.name!.isEmpty ? '' : '.$factory'}(${dartParams.names});');
    if (gen == null) {
    }
    else if (gen.objType().endsWith('ObjSt')) {
      ctx.dartFns.writeln('  return _create${gen.objType()}(w);');
    }
    else {
      ctx.dartFns.writeln('  return ${Params.paramValueDtoC(types, paramElement('w', node.returnType))};');
    }
    ctx.dartFns .writeln('}');
  }

  void writeJavaFactory(FunctionTypedElement node, String factoryName, String builderClass, String factory) {
    String builderFactory = factoryName;
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsDecl = Params(types, node.parameters, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    final tpp = _factoryTypeParamPrefix.isEmpty ? '' : '${_factoryTypeParamPrefix} ';
    final retTpp = _typeParamPrefix; // <T> for return-type parameterization (raw class name would be a raw type).
    if (node is ConstructorElement) {
      ctx.javaFile
        ..writeln('  @Builder.Factory')
        ..writeln('  static $tpp$widgetClass$retTpp $factoryName(${jParamsDecl.builderDecl}) {');
    }
    var gen = types.getGen(node.returnType.element!);
    if (gen is WidgetGen) {
      gen.writeJavaInstanceBody(factoryName, jParamsDecl, node);
      ctx.javaFile.write(gen.ctx.javaFile);
    } else {
      writeJavaInstanceBody(factoryName, jParamsDecl, node);
    }
    ctx.javaFile
        .writeln('  }');
    if (node is ConstructorElement) {
      ctx.javaFile
        ..writeln('  public static $tpp$builderClass$retTpp $factory(${jParamsDecl.required}) {')
        ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
        ..writeln('  }');
    }
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
    if (node is ConstructorElement) {
      ctx.javaStatics
        ..writeln('  public static $tpp$builderClass$retTpp $widgetClass${node.name.isEmpty ? '' : '_$factory'}(${jParamsDecl.required}) {')
        ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
        ..writeln('  }');
    }
  }



  void writeJavaInstanceBody(String factoryName, Params jParams, FunctionTypedElement node) {
    final retType = types.type4FFMRet(node.returnType);
    if (node.returnType is VoidType) {
      ctx.javaFile.writeln('    factories.$factoryName(${jParams.names});');
    } else {
      ctx.javaFile.writeln('    $retType id = factories.$factoryName(${jParams.names});');
    }
    if (retType == 'int') {
      ctx.javaFile
        .writeln('    if (id <= 0) throw new RuntimeException("Failed to created widget ${node.returnType}");');
    }
    if (node.returnType is! VoidType) {
      ctx.javaFile
        ..writeln('    System.out.println("New ${node.returnType} id:"+id);')
        ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('id', node.returnType))};');
    }
  }



  bool isPrivateConst(ConstFieldElementImpl fld) {
    var initializer = fld.constantInitializer;
    if (initializer is InstanceCreationExpression) {
      var creationExpression = initializer as InstanceCreationExpression;
      return (creationExpression.constructorName.staticElement!.isPrivate ||
          creationExpression.staticType!.element!.isPrivate);
    }
    return false;
  }

  void writeConst(ConstFieldElementImpl fld, int constId) {
    String factory = _escape4D(fld.name);
    var initializer = fld.constantInitializer;
    // Dart `int` is unbounded but Java `int` is 32-bit; large numeric consts
    // (e.g. DateTime._maxMillisecondsSinceEpoch = 8640000000000000) overflow
    // as decimal literals. Java hex literals up to 0xFFFFFFFF do fit in int
    // (with sign wrap), so only skip when the Dart source form is decimal
    // (not hex) AND the value can't fit even with unsigned wrap. Skips only
    // private consts so no public API is dropped.
    if (!fld.isPublic && fld.type.isDartCoreInt) {
      final v = fld.computeConstantValue()?.toIntValue();
      final src = fld.constantInitializer?.toString() ?? '';
      final isHex = src.trimLeft().startsWith('0x') || src.trimLeft().startsWith('0X');
      if (v != null && !isHex && (v > 2147483647 || v < -2147483648)) {
        return;
      }
    }
    // Pre-check: SimpleIdentifier → private class-level field that can't be
    // inlined as a primitive. Skip rather than calling a non-existent Java method.
    if (initializer is SimpleIdentifier) {
      final si = initializer as SimpleIdentifier;
      var el = si.staticElement;
      VariableElement? fieldEl;
      if (el is FieldElement) { fieldEl = el; }
      else if (el is PropertyAccessorElement && el.isGetter && el.variable2 is FieldElement) {
        fieldEl = el.variable2 as FieldElement;
      }
      if (fieldEl != null && fieldEl.isConst && fieldEl.isPrivate) {
        var val = fieldEl.computeConstantValue();
        bool canInline = val?.toIntValue() != null || val?.toDoubleValue() != null ||
            val?.toStringValue() != null || val?.getField('value')?.toIntValue() != null;
        if (!canInline) return;
      }
    }

    // For non-private InstanceCreationExpression and scalar else-branch: pre-evaluate
    // body before writing the method header to avoid empty methods on unresolvable values.
    if (initializer is InstanceCreationExpression && !isPrivateConst(fld)) {
      var body = dartExptrToJava(initializer as Expression);
      if (body.contains(_unresolvable)) return;
      ctx.javaFile.writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
      ctx.javaFile.writeln('    return $body;');
      ctx.javaFile.writeln('  }');
      return;
    }
    if (initializer != null && initializer is! InstanceCreationExpression && initializer is! ListLiteral) {
      var body = dartExptrToJava(initializer);
      if (body.contains(_unresolvable)) return;
      ctx.javaFile.writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
      ctx.javaFile.writeln('    return $body;');
      ctx.javaFile.writeln('  }');
      return;
    }

    ctx.javaFile
        .writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
    if (initializer is InstanceCreationExpression) {
      // isPrivateConst must be true here (non-private was handled above)
      String factoryName = '$widgetField${fld.name.firstUpper()}';
      _ensureStructOpened();
      ctx.headerFile.writeln('    ${CLang(types).field(factory, types.getGen(fld.type.element!).objType())}');
      ctx.dartAssigns
          .writeln('  f.$widgetField.$factory = _addWidget($widgetClass.${fld.name});');
      ctx.javaFile
        ..writeln('    int id = factories.$factoryName();')
        ..writeln('    if (id <= 0) throw new RuntimeException("Failed to create const $factory");')
        ..writeln('    System.out.println("Const $factory id:"+id);')
        ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('id', fld.type))};');
      writeJavaConstMethod(factoryName, factory, fld);
      writeConstSerializerAndDecoder(fld, factoryName);
    }
    else if (initializer is ListLiteral) {
      ctx.javaFile
        .writeln('    return List.of(${(initializer as ListLiteral).elements.map((e) => '$e()').join(', ')});');
    }
    ctx.javaFile
      .writeln('  }');
  }

  /// Strategy for the per-widget "members" block (fields, struct headers,
  /// override scaffolding). Default: emit nothing. Overridden by
  /// [ImmutableGen] (→ [ImmutableMemberEmitter]) and [SubclassGen]
  /// (→ [SubclassMemberEmitter]). See emit/member_emitter.dart.
  MemberEmitter get memberEmitter => const NoneMemberEmitter();

  void writeMembers() => memberEmitter.emit(this);

  static const String _unresolvable = '\x00UNRESOLVABLE\x00';

  String dartExptrToJava(Expression e) {
    if (e is InstanceCreationExpression) {
      var nodeList = e.argumentList.arguments;
      var requiredArgs = nodeList
          .where((a) => a.correspondingParameter!.isRequiredPositional)
          .map((a) => a.unParenthesized)
          .map((e) => dartExptrToJava(e))
          .join(', ');
      var otherArgs = nodeList
          .whereType<NamedExpression>()
          .map((a) => '.${a.name.label}(${dartExptrToJava(a.expression)})')
          .join('');

      // var clazz = dartClass != e.constructorName.type.element ? '.${e.constructorName.toString().firstLower()}' : '';
      // var clazz = '.${e.constructorName.toString().firstLower()}';
      var constructorName = e.constructorName.toString();
      if (e.constructorName.name == null) {
        constructorName += '.${e.constructorName.toString().firstLower()}';
      }
      return '$constructorName($requiredArgs)$otherArgs.build()';
    }
    else if (e is SetOrMapLiteral) {
      return 'Map.ofEntries(${e.elements.whereType<MapLiteralEntry>().map((e) => 'Map.entry(${e.key}, ${dartExptrToJava(e.value)})').join(', ')})';
    }
    else if (e is SimpleIdentifier) {
      var el = e.staticElement;
      TopLevelVariableElement? varEl;
      if (el is TopLevelVariableElement) {
        varEl = el;
      } else if (el is PropertyAccessorElement && el.isGetter && el.variable2 is TopLevelVariableElement) {
        varEl = el.variable2 as TopLevelVariableElement;
      }
      if (varEl != null && varEl.isConst && varEl.isPrivate) {
        var val = varEl.computeConstantValue();
        if (val?.toIntValue() != null) return val!.toIntValue().toString();
        if (val?.toDoubleValue() != null) return val!.toDoubleValue().toString();
        if (val?.toStringValue() != null) return '"${val!.toStringValue()}"';
        // Non-primitive private top-level var (e.g. Color in new Flutter API) — skip.
        return _unresolvable;
      }
      // Class-level private const fields (FieldElement): only inline Color via ARGB int.
      // Primitives (int/double/String) are already emitted as private Java methods by
      // writeConst and are correctly called via _fieldName().
      VariableElement? fieldEl;
      if (el is FieldElement) { fieldEl = el; }
      else if (el is PropertyAccessorElement && el.isGetter && el.variable2 is FieldElement) {
        fieldEl = el.variable2 as FieldElement;
      }
      if (fieldEl != null && fieldEl.isConst && fieldEl.isPrivate) {
        var val = fieldEl.computeConstantValue();
        var colorArgb = val?.getField('value')?.toIntValue();
        if (colorArgb != null) {
          return 'Color.color(0x${colorArgb.toRadixString(16).toUpperCase().padLeft(8, '0')}).build()';
        }
        // Complex non-Color type (List, BoxShadow, etc.) — unresolvable.
        if (val?.toIntValue() == null && val?.toDoubleValue() == null && val?.toStringValue() == null) {
          return _unresolvable;
        }
      }
      return '$e()';
    }
    else if (e is PrefixedIdentifier) {
      // For statics on classes not in the generated set, try to inline the const value.
      // Handles CupertinoColors.systemRed and similar cross-class references.
      var prefixEl = e.prefix.staticElement;
      if (prefixEl is ClassElement && types.widgets.every((w) => w.name != prefixEl.name)) {
        var accessorEl = e.identifier.staticElement;
        VariableElement? varEl;
        if (accessorEl is PropertyAccessorElement && accessorEl.isGetter) {
          varEl = accessorEl.variable2;
        } else if (accessorEl is FieldElement) {
          varEl = accessorEl as VariableElement;
        }
        if (varEl != null && varEl.isConst) {
          var val = varEl.computeConstantValue();
          if (val?.toIntValue() != null) return val!.toIntValue().toString();
          if (val?.toDoubleValue() != null) {
            var d = val!.toDoubleValue()!;
            if (d.isInfinite) return d.isNegative ? 'Double.NEGATIVE_INFINITY' : 'Double.POSITIVE_INFINITY';
            if (d.isNaN) return 'Double.NaN';
            return d.toString();
          }
          if (val?.toStringValue() != null) return '"${val!.toStringValue()}"';
          var colorArgb = val?.getField('value')?.toIntValue();
          if (colorArgb != null) {
            return 'Color.color(0x${colorArgb.toRadixString(16).toUpperCase().padLeft(8, '0')}).build()';
          }
          // Value not resolvable (e.g. new-API Color uses r/g/b/a doubles).
          return _unresolvable;
        }
      }
      if (e.staticType != null && !isPrimitive(e.staticType!) && e.staticType!.element is! EnumElement) {
        return '${e.toString()}()';
      }
      return replace(e.toString());
    }
    else if (e is BinaryExpression) {
      return  '${dartExptrToJava(e.leftOperand)} ${e.operator} ${dartExptrToJava(e.rightOperand)}';
    }
    else if (e is DoubleLiteral || e is IntegerLiteral || e is PrefixExpression) {
      return e.toString();
    } else if (e is StringLiteral) {
      return '"${e.stringValue}"';
    }
    return e.toString();
  }

  String toJavaClassUngeneric(InterfaceType interfaceType) => interfaceType.element.name;
  String toJavaClass(DartType dartType) {
    if (dartType.isDartCoreInt) {
      return 'Integer';
    } else if (dartType.isDartCoreDouble) {
      return 'Double';
    } else if (dartType.isDartCoreBool) {
      return 'Boolean';
    }
    else if (dartType is NeverType) {
      // Dart `Never` (bottom type, used e.g. in PopupMenuDivider extends PopupMenuEntry<Never>)
      // has no Java equivalent — use Object as a safe stand-in.
      return 'Object';
    }
    else if (dartType is TypeParameterType) {
      // Unbound type parameter (e.g. T) — use its name directly so generic class
      // declarations like `class Radio<T> extends StatefulWidget` render correctly.
      return dartType.element.name;
    }
    else if (dartType is InterfaceType) {
      var s = dartType.element.name;
      if (dartType.typeArguments.isNotEmpty) {
        s += '<${dartType.typeArguments.map((t) => toJavaClass(t)).join(', ')}>';
      }
      return s;
    }
    var s = dartType.element!.name;
    return s!;
  }

  String replace(String expr) => switch (expr) {
    'double.infinity' => 'Double.POSITIVE_INFINITY',
    _ => expr
  };
}

String exception(DartType returnType) {
  if (returnType.isDartCoreDouble) {
    return 'exceptionDouble';
  }
  return 'exception';
}
