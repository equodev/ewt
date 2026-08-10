part of '../gen.dart';

/// Java-side emitters for a widget: instance methods, static factories,
/// serializer overrides for the web bridge, FFM-facing factory methods, and
/// const accessors. Methods that WidgetGen subclasses override (writeJavaDecl,
/// writeJavaConstructors, writeJavaInstanceBody, writeJavaFactory) stay on the
/// class hierarchy because Dart extensions do not participate in virtual
/// dispatch.
extension _JavaEmit on WidgetGen {
  /// Emits a companion-method as an instance method on the target Java class.
  /// First parameter (the receiver) becomes `this.id` in the FFM call; remaining
  /// params reach the FFM factory as-is. Wired via
  /// [WidgetGen.writeInstanceMethod].
  void writeJavaInstanceMethod(FunctionTypedElement node, String factoryName, String factory) {
    final restParams = node.parameters.skip(1).toList();
    final restRequired = restParams.where((p) => !p.isOptional).toList();
    final jParamsDecl = Params(types, restRequired, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsValuesOpt = Params(types, restParams, Params.paramDef4JBuilder, paramValue: Params.paramValue4JOptional, escape: Params.escape4J);
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);

    ctx.javaFile
        .writeln('  public ${types.type4J(node.returnType)} $factory(${jParamsDecl.decl}) {');
    final restCallNames = jParamsValuesOpt.names;
    final callArgs = restCallNames.isEmpty ? 'this' : 'this,\n      $restCallNames';
    if (node.returnType is VoidType) {
      writeVoidMethodWebPrelude(factory);
      ctx.javaFile.writeln('    factories.$factoryName($callArgs);');
    } else {
      final retType = types.type4FFMRet(node.returnType);
      ctx.javaFile.writeln('    $retType id = factories.$factoryName($callArgs);');
      if (retType == 'int') {
        ctx.javaFile.writeln('    if (id <= 0) throw new RuntimeException("Failed to call $factory");');
      }
      // SubAnimatedState.animationController: wire the controller back to this state for web commands.
      if (widgetClass == 'SubAnimatedState' && factory == 'animationController') {
        ctx.javaFile
          ..writeln('    AnimationController ctrl = new AnimationController(id);')
          ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) ctrl.setWebOwner(this);')
          ..writeln('    return ctrl;');
      } else {
        ctx.javaFile.writeln('    return ${types.paramValueFFMtoJ(types, paramElement('id', node.returnType))};');
      }
    }
    ctx.javaFile.writeln('  }');
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
  }

  /// Emits a public static Java method that wraps a Dart static function/factory
  /// whose returned widget/value is threaded through Immutables (via
  /// [writeJavaInstanceBody]).
  void writeJavaFactoryForStatic(FunctionTypedElement node, String factoryName, String factory) {
    var params = node.parameters.where((p) => !p.isOptional).toList();
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsDecl = Params(types, params, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsValuesOpt = Params(types, node.parameters, Params.paramDef4JBuilder, paramValue: Params.paramValue4JOptional, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    ctx.javaFile
        .writeln('  public static ${types.type4J(node.returnType)} $factory(${jParamsDecl.decl}) {');
    var gen = node.returnType is VoidType ? null : types.getGen(node.returnType.element!);
    if (gen is WidgetGen) {
      gen.writeJavaInstanceBody(factoryName, jParamsValuesOpt, node);
      ctx.javaFile.write(gen.ctx.javaFile);
    } else {
      writeJavaInstanceBody(factoryName, jParamsValuesOpt, node);
    }
    ctx.javaFile
        .writeln('  }');
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
  }

  /// Emits one @Override into [EmitContext.javaSerializer] that records the
  /// factory call as an EwtNode and returns an id-only *ObjSt (or an int id for
  /// plain DartObj returns). The signature matches the WidgetConstructors method
  /// exactly so @Override resolves at compile time.
  void writeJavaSerializer(FunctionTypedElement node, String factoryName, String factory) {
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    final retType = types.type4FFMRet(node.returnType);
    final isObjSt = retType == 'MemorySegment';
    // Build the return ObjSt class name: e.g. MemorySegment textText(...) uses TextObjSt.
    String? objStClass;
    if (isObjSt) {
      var gen = types.getGen(node.returnType.element!);
      objStClass = gen.objType(); // e.g. TextObjSt
    }

    // Skip factories that do not produce a serializable widget/value node: void returns, and
    // opaque native objects (a MemorySegment whose backing type is not an *ObjSt struct we can
    // allocate an id into). These stay inherited from WidgetConstructors (FFM); they are never
    // called when rendering a static subtree on web.
    if (retType == 'void') return;
    if (isObjSt && !(objStClass?.endsWith('ObjSt') ?? false)) return;

    // Match the FFM method's own type parameters (e.g. <T extends StatefulWidget>) so the
    // @Override resolves for generic factories.
    final jtp = JLang().methodTypeParameters(node.type);

    // Hand-maintained in gen.dart with ctrlId tracking — skip auto-generation to avoid duplicate.
    if (factoryName == 'subAnimatedStateAnimationController') return;

    // ListView.builder special-case: eager-expand itemBuilder into a plain listViewListView node.
    // Instead of recording an inert callback id, we call itemBuilder for each index and collect
    // the resulting widget nodes as children, then record a listViewListView node. This lets the
    // browser decode it with the existing plain ListView decoder without any builder callback.
    if (factoryName == 'listViewBuilder') {
      ctx.javaSerializer
        ..writeln('  @Override')
        ..writeln('  $jtp$retType $factoryName(${jParamsFFM.decl}) {')
        ..writeln('    int id = nextId++;')
        ..writeln('    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();');
      // Emit eager children expansion in place of itemBuilder/itemCount serialization.
      ctx.javaSerializer
        ..writeln('    if (itemCount.isPresent()) {')
        ..writeln('      java.util.List<Object> __children = new java.util.ArrayList<>();')
        ..writeln('      BuildContext __ctx = EwtWebCapture.stubContext();')
        ..writeln('      for (int __i = 0; __i < itemCount.getAsInt(); __i++) {')
        ..writeln('        Widget __w = itemBuilder.apply(__ctx, __i);')
        ..writeln('        if (__w == null) break;')
        ..writeln('        __children.add(byId.get(__w.getId()));')
        ..writeln('      }')
        ..writeln('      p.put("children", __children);')
        ..writeln('    }');
      // Serialize every other supported param except itemBuilder and itemCount.
      for (final param in node.parameters.where((p) => types.supportedType(p.type) && !hasPrivateDefault(p))) {
        if (param.name == 'itemBuilder' || param.name == 'itemCount') continue;
        final stmt = Params.paramValueSerialize(types, param);
        if (stmt.isNotEmpty) ctx.javaSerializer.writeln('    $stmt');
      }
      ctx.javaSerializer
        ..writeln('    record(id, "listViewListView", p);')
        ..writeln('    MemorySegment st = ${objStClass!}.allocate(arena);')
        ..writeln('    $objStClass.id(st, id);')
        ..writeln('    return st;')
        ..writeln('  }');
      return;
    }

    ctx.javaSerializer
      ..writeln('  @Override')
      ..writeln('  $jtp$retType $factoryName(${jParamsFFM.decl}) {')
      ..writeln('    int id = nextId++;')
      ..writeln('    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();');

    for (final param in node.parameters.where((p) => types.supportedType(p.type) && !hasPrivateDefault(p))) {
      final stmt = Params.paramValueSerialize(types, param);
      if (stmt.isNotEmpty) {
        ctx.javaSerializer.writeln('    $stmt');
      }
    }

    ctx.javaSerializer
      ..writeln('    record(id, "$factoryName", p);');

    if (isObjSt && objStClass != null) {
      ctx.javaSerializer
        ..writeln('    MemorySegment st = $objStClass.allocate(arena);')
        ..writeln('    $objStClass.id(st, id);');
      // MaterialColor's shadeXXX() getters read native int fields (a color id). Populate them
      // from the swatch so those getters return the right color off-native (each swatch color
      // is itself a recorded node). The struct fields are ints, so we store the color's id.
      if (factoryName == 'materialColorMaterialColor') {
        for (final k in const [50, 100, 200, 300, 400, 500, 600, 700, 800, 900]) {
          ctx.javaSerializer.writeln('    $objStClass.shade$k(st, swatch.get($k) != null ? swatch.get($k).getId() : 0);');
        }
      }
      ctx.javaSerializer.writeln('    return st;');
    } else {
      ctx.javaSerializer.writeln('    return id;');
    }
    ctx.javaSerializer.writeln('  }');
  }

  /// Emits the FFM-facing factory method into [EmitContext.javaFactories]:
  /// resolves the widget's struct + function pointer and invokes it.
  void writeJavaFactoryMethod(String factoryName, Params jParams, String factory, Params jParamsFFM, FunctionTypedElement node) {
    var type4ffmRet = types.type4FFMRet(node.returnType);
    var useArena = node.returnType is! VoidType && types.getGen(node.returnType.element!).objType().endsWith('ObjSt');
    ctx.javaFactories
      ..writeln('  ${JLang().methodTypeParameters(node.type)}$type4ffmRet $factoryName(${jParams.decl}) {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
      ..writeln('    ${node.returnType is VoidType ? '' : 'return '}WidgetFactories.${widgetClass}St.$factory.invoke(${['fn${useArena ? ', arena' : ''}', jParamsFFM.names.nullIfEmpty].nonNulls.join(', ')});')
      ..writeln('  }');
  }

  /// Emits the FFM-facing accessor for a private const value.
  void writeJavaConstMethod(String factoryName, String factory, ConstFieldElementImpl node) {
    var gen = types.getGen(node.type.element!);
    ctx.javaFactories
      ..writeln('  ${gen.objType().endsWith('ObjSt') ? 'MemorySegment' : 'int'} $factoryName() {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    return WidgetFactories.${widgetClass}St.$factory(st);')
      ..writeln('  }');
  }

  /// Web-mode support for a private-const accessor (family B: static const value
  /// objects backed by a native struct field, e.g. FontWeight.w700, Curves.linear,
  /// TextDecoration.underline). The FFM const method reads a native table
  /// (a WidgetFactories struct field) which is null off-native -> NPE. So:
  ///   (a) override it in SerializingWidgetConstructors to record a node keyed by
  ///       factoryName and return the node id (no native call), and
  ///   (b) emit a web decoder mapping factoryName to the matching Flutter const,
  ///       which is exactly `WidgetClass.fieldName` (the field is a public
  ///       const of the Flutter class; only its initializer's constructor is private).
  void writeConstSerializerAndDecoder(ConstFieldElementImpl fld, String factoryName) {
    var gen = types.getGen(fld.type.element!);
    final isObjSt = gen.objType().endsWith('ObjSt');
    final retType = isObjSt ? 'MemorySegment' : 'int';
    ctx.javaSerializer
      ..writeln('  @Override')
      ..writeln('  $retType $factoryName() {')
      ..writeln('    int id = nextId++;')
      ..writeln('    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();')
      ..writeln('    record(id, "$factoryName", p);');
    if (isObjSt) {
      final objStClass = gen.objType();
      ctx.javaSerializer
        ..writeln('    MemorySegment st = $objStClass.allocate(arena);')
        ..writeln('    $objStClass.id(st, id);')
        ..writeln('    return st;');
    } else {
      ctx.javaSerializer.writeln('    return id;');
    }
    ctx.javaSerializer.writeln('  }');

    ctx.dartWebDecoders.writeln("  '$factoryName': (p) => $widgetClass.${fld.name},");
  }
}
