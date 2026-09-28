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
    final restRequired = restParams.where((p) => !p.isOptionalOnSurface).toList();
    final jParamsDecl = Params(types, restRequired, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsValuesOpt = Params(types, restParams, Params.paramDef4JBuilder, paramValue: Params.paramValue4JOptional, escape: Params.escape4J);
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);

    // Java interfaces (`_isInterface == true`) can't hold plain `public`
    // method bodies — they need `default` (or `static`). Companion methods
    // are always instance-level, so pick `default` when the target is an
    // interface. Non-interface targets stay `public`.
    final modifier = _isInterface ? 'public default' : 'public';
    // `factories` (the FFM shim) is a static field on `NativeObj.Base`, so
    // concrete classes that `extend NativeObj.Base` see it as an inherited
    // simple name. Interfaces can't inherit static state, so from an
    // interface body we have to reach it via the fully-qualified path.
    final factoriesRef = _isInterface ? 'NativeObj.Base.factories' : 'factories';
    ctx.javaFile
        .writeln('  $modifier ${types.type4J(node.returnType)} $factory(${jParamsDecl.decl}) {');
    final restCallNames = jParamsValuesOpt.names;
    // Interface target: `this` is `Widget<T>` (where `T` is the interface's
    // own type parameter) but the companion FFM method signature uses the
    // companion's receiver-arg type (e.g. `Future<NativeObj>` for a
    // `Future<Object?> self` companion). Java's invariant generics reject the
    // direct pass, so cast through the raw type — the runtime FFI marshaller
    // reads the id off `NativeObj.getId()`, not the parametric T, so the
    // cast is safe.
    final selfExpr = _isInterface ? '(($widgetClass) this)' : 'this';
    final callArgs = restCallNames.isEmpty ? selfExpr : '$selfExpr,\n      $restCallNames';
    if (node.returnType is VoidType) {
      writeVoidMethodWebPrelude(factory);
      ctx.javaFile.writeln('    $factoriesRef.$factoryName($callArgs);');
    } else {
      writeNonVoidMethodWebPrelude(factory, node.returnType, restCallNames);
      final retType = types.type4FFMRet(node.returnType);
      ctx.javaFile.writeln('    var id = $factoriesRef.$factoryName($callArgs);'); // java-11 split: int handle (or String for niche String-returns)
      if (retType == 'int') {
        ctx.javaFile.writeln('    if (id <= 0) throw new RuntimeException("Failed to call $factory");');
      }
      if (!tryWriteCustomInstanceMethodReturn(factory, node.returnType)) {
        // java-11 split: String-returning factories already yield a Java String (id), so skip the
        // C-string read (getString) the FFM path would otherwise apply.
        ctx.javaFile.writeln('    return ${retType == 'MemorySegment' ? 'id' : types.paramValueFFMtoJ(types, paramElement('id', node.returnType))};');
      }
    }
    ctx.javaFile.writeln('  }');
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
  }

  /// Emits a companion `<Method>(BuildContext ctx, ...)` as a `public static`
  /// on the target Java class. All parameters (including the context) are
  /// user-facing; the FFM factory receives them verbatim. The Dart-side
  /// companion body performs the `Target.of(context).X(...)` dispatch.
  void writeJavaStaticContextMethod(FunctionTypedElement node, String factoryName, String factory) {
    final requiredParams = node.parameters.where((p) => !p.isOptionalOnSurface).toList();
    final jParamsDecl = Params(types, requiredParams, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsCall = Params(types, node.parameters, Params.paramDef4JBuilder, paramValue: Params.paramValue4JOptional, escape: Params.escape4J);
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);

    ctx.javaFile
        .writeln('  public static ${types.type4J(node.returnType)} $factory(${jParamsDecl.decl}) {');
    if (node.returnType is VoidType) {
      ctx.javaFile.writeln('    factories.$factoryName(${jParamsCall.names});');
    } else {
      final retType = types.type4FFMRet(node.returnType);
      ctx.javaFile.writeln('    var id = factories.$factoryName(${jParamsCall.names});'); // java-11 split: int handle (or String for niche String-returns)
      if (retType == 'int') {
        ctx.javaFile.writeln('    if (id <= 0) throw new RuntimeException("Failed to call $factory");');
      }
      ctx.javaFile.writeln('    return ${retType == 'MemorySegment' ? 'id' : types.paramValueFFMtoJ(types, paramElement('id', node.returnType))};');
    }
    ctx.javaFile.writeln('  }');
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
  }

  /// Emits a public static Java method that wraps a Dart static function/factory
  /// whose returned widget/value is threaded through Immutables (via
  /// [writeJavaInstanceBody]).
  void writeJavaFactoryForStatic(FunctionTypedElement node, String factoryName, String factory) {
    var params = node.parameters.where((p) => !p.isOptionalOnSurface).toList();
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
    if (retType == 'void') return;
    // java-11 split: ObjSt widgets/value-objects marshal as a foreign-free int id now (not a
    // MemorySegment struct), so detect ObjSt-ness from the return gen rather than from
    // retType == 'MemorySegment' (which today is true only for String/opaque char* returns). Without
    // this the Sub* deferred registration below is skipped and placeholders never flatten.
    final rt = node.returnType;
    final objStClass = (!isPrimitive(rt) && !rt.isDartCoreString && rt.element != null)
        ? types.getGen(rt.element!).objType() // e.g. TextObjSt, SubStatefulWidgetObjSt, or DartObj
        : null;
    final isObjSt = objStClass != null && objStClass.endsWith('ObjSt');

    // Skip factories that do not produce a serializable node: String (char*) and opaque native
    // returns marshal as a MemorySegment that is not an *ObjSt struct. These stay inherited from
    // WidgetConstructors (FFM); they are never called when rendering a static subtree on web.
    if (retType == 'MemorySegment' && !isObjSt) return;

    // Match the FFM method's own type parameters (e.g. <T extends StatefulWidget>) so the
    // @Override resolves for generic factories.
    final jtp = JLang().methodTypeParameters(node.type);

    // Hand-maintained downstream (EwtWebCapture threads the ctrlId); the
    // widget's generator can opt out via skipJavaSerializer.
    if (skipJavaSerializer(factory)) return;

    // Widgets whose serializer body is not a plain node record (e.g.
    // ListView.builder eager-expands children) emit the whole @Override
    // themselves via this hook.
    if (tryEmitCustomJavaSerializer(node, factoryName, factory, jParamsFFM, jtp, isObjSt ? objStClass : null)) {
      return;
    }

    ctx.javaSerializer
      ..writeln('  @Override')
      ..writeln('  public $jtp$retType $factoryName(${jParamsFFM.decl}) {')
      ..writeln('    int id = nextId++;')
      ..writeln('    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();');

    // Relax `{required T?}` before dispatch so `Params.paramValueSerialize`'s
    // `.isPresent()` / `.ifPresent()` branches match the Optional-wrapped
    // signature emitted by jParamsFFM.decl above (issue #44).
    for (final param in relaxFactoryParams(node.parameters).where((p) => types.supportedType(p.type) && !hasPrivateDefault(p))) {
      final stmt = Params.paramValueSerialize(types, param);
      if (stmt.isNotEmpty) {
        ctx.javaSerializer.writeln('    $stmt');
      }
    }

    ctx.javaSerializer
      ..writeln('    record(id, "$factoryName", p);');

    // java-11 split: the comm serializer is foreign-free (returns the int id, no native struct). Sub*
    // widgets still need their deferred builder registered — id-based, foreign-free — so resolveDeferred
    // can flatten the placeholder node. This was previously emitted by emitExtraJavaSerializerFields in
    // the struct path, which the int return skips. The ColorSwatch variant of that hook writes shade
    // fields into a native struct, so it stays FFM-only and is intentionally not invoked here.
    if (objStClass == 'SubStatefulWidgetObjSt' || objStClass == 'SubStatelessWidgetObjSt') {
      emitExtraJavaSerializerFields(factoryName, objStClass!);
    }
    ctx.javaSerializer.writeln('    return id;');
    ctx.javaSerializer.writeln('  }');
  }

  /// Emits the FFM-facing factory method into [EmitContext.javaFactories]:
  /// resolves the widget's struct + function pointer and invokes it.
  void writeJavaFactoryMethod(String factoryName, Params jParams, String factory, Params jParamsFFM, FunctionTypedElement node) {
    var type4ffmRet = types.type4FFMRet(node.returnType); // java-11 split: 'int' handle for widgets/value-objects
    var useArena = node.returnType is! VoidType && types.getGen(node.returnType.element!).objType().endsWith('ObjSt');
    // For ObjSt returns the native invoke yields a MemorySegment struct; read its id so the FFM
    // impl returns the same foreign-free int handle the serializing impl does. MemorySegment stays
    // internal to this method (WidgetConstructors, FFM layer), never on the core builder surface.
    var objSt = useArena ? types.getGen(node.returnType.element!).objType() : null;
    var invoke = 'WidgetFactories.${widgetClass}St.$factory.invoke(${['fn${useArena ? ', arena' : ''}', jParamsFFM.names.nullIfEmpty].nonNulls.join(', ')})';
    var tp = JLang().methodTypeParameters(node.type);
    // java-11 split: String returns marshal a C-string MemorySegment; keep them off the foreign-free
    // interface by returning the Java type and treating them as a v1 gap (niche: navigatorRestorable*).
    var isStringRet = type4ffmRet == 'MemorySegment';
    var retIface = isStringRet ? types.type4J(node.returnType) : type4ffmRet;
    // States (SubclassGen) keep an id->struct entry so setState/widget can read back the native
    // struct on java 22 without the state holding a MemorySegment.
    var isState = useArena && types.getGen(node.returnType.element!) is SubclassGen;
    ctx.javaFactories..writeln('  public $tp$retIface $factoryName(${jParams.decl}) {');
    if (isStringRet) {
      ctx.javaFactories.writeln('    throw new UnsupportedOperationException("$factoryName (String return) is a java-11 split v1 gap");');
    } else if (isState) {
      ctx.javaFactories
        ..writeln('    var st = WidgetFactories.$widgetField(factories);')
        ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
        ..writeln('    var __nst = $invoke;')
        ..writeln('    int __nid = $objSt.id(__nst);')
        ..writeln('    handles.put(__nid, __nst);')
        ..writeln('    return __nid;');
    } else {
      ctx.javaFactories
        ..writeln('    var st = WidgetFactories.$widgetField(factories);')
        ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
        // java-11 split: retain(...) stashes the built struct for the widget ctor to adopt (read-back)
        // and returns its foreign-free int id.
        ..writeln('    ${node.returnType is VoidType ? '$invoke' : 'return ${useArena ? 'retain($invoke, $objSt::id)' : invoke}'};');
    }
    ctx.javaFactories.writeln('  }');
    // Foreign-free interface signature with a default that throws (overridden by the FFM impl always,
    // and by the serializing impl for factories that render on comm).
    ctx.javaInterface
      ..writeln('  default $tp$retIface $factoryName(${jParams.decl}) {')
      ..writeln('    throw new UnsupportedOperationException("$factoryName has no default (FFM/comm impl required)");')
      ..writeln('  }');
  }

  /// Emits the FFM-facing accessor for a private const value.
  void writeJavaConstMethod(String factoryName, String factory, ConstFieldElementImpl node) {
    var gen = types.getGen(node.type.element!);
    var isObjSt = gen.objType().endsWith('ObjSt');
    var read = 'WidgetFactories.${widgetClass}St.$factory(st)';
    ctx.javaFactories
      ..writeln('  public int $factoryName() {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    return ${isObjSt ? '${gen.objType()}.id($read)' : read};')
      ..writeln('  }');
    // java-11 split: interface entry so the serializing @Override resolves and callers dispatch.
    ctx.javaInterface
      ..writeln('  default int $factoryName() {')
      ..writeln('    throw new UnsupportedOperationException("$factoryName has no default (FFM/comm impl required)");')
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
    // java-11 split: foreign-free int handle; the const node is recorded and its id returned
    // (no ObjSt struct allocation), matching the FFM impl's int return.
    ctx.javaSerializer
      ..writeln('  @Override')
      ..writeln('  public int $factoryName() {')
      ..writeln('    int id = nextId++;')
      ..writeln('    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();')
      ..writeln('    record(id, "$factoryName", p);')
      ..writeln('    return id;')
      ..writeln('  }');

    ctx.dartWebDecoders.writeln("  '$factoryName': (p) => $widgetClass.${fld.name},");
  }
}
