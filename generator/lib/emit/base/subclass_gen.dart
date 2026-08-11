part of '../../gen.dart';

class SubclassGen extends ObjStGen {
  SubclassGen(super.types, super.dartClass);

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    super.writeJavaDecl(extend, isInterface);
    ctx.javaFile.writeln('public abstract class $widgetClass$extend, SubclassedInJava {');
  }

  @override
  void writeJavaConstructors() {
    // Empty implementation as in the original
  }

  // ---------- SubclassGen extension points (see emit/special/sub_*.dart) ----------

  /// Emitted inside the canBeImplInJava method loop when the method is
  /// `setState`. Default: no-op. SubStateGen / SubAnimatedStateGen emit the
  /// EwtWebState web-mode reroute here.
  void emitSetStateWebPrelude() {}

  /// Emitted after the canBeImplInJava method loop and before
  /// [writeStructFooter], to synthesize the `T widget()` accessor and any
  /// matching C struct field. Default: no-op.
  void emitStateWidgetAccessor() {}

  /// Emitted after [writeStructFooter], for extra Java members that hang off
  /// the state (webWidget field, anim command sink, etc.). Default: no-op.
  void emitExtraStateJavaMembers() {}

  @override
  String dartFactoryCtorClass(FunctionTypedElement node) => node.displayName;

  @override
  MemberEmitter get memberEmitter => const SubclassMemberEmitter();

  Iterable<FieldElement> callableFields() {
    final element = dartClass.supertype!.element;
    return element is ClassElement ? getCallableFields(element) : [];
  }

  Iterable<MethodElement> callableMethods() => dartClass.supertype!.element.methods
      .where((m) => !m.isAbstract && m.hasProtected && !m.hasMustCallSuper);

  @override
  void writeJavaFactory(FunctionTypedElement node, String factoryName, String builderClass, String factory) {
    final fnParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4JCallback, escape: Params.escape4J);
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    ctx.javaFile
      ..writeln('  private final MemorySegment st;')
      ..writeln('  protected $widgetClass() {')
      ..writeln('    st = factories.$factoryName(${fnParams.names});')
      ..writeln('    if (st == null) throw new RuntimeException("Failed to created widget $widgetClass");')
      ..writeln('    id = $widgetSt.id(st);')
      ..writeln('    SubclassedInJava.addSubNatObj(this);')
      ..writeln('    System.out.println("New $widgetClass id:"+id);')
      ..writeln('  }');
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
  }

  @override
  void writeDFactory(String factory, String factoryName, FunctionTypedElement node) {
    final dartParams = Params(types, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    ctx.dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName);');
    final ctorClass = dartFactoryCtorClass(node);
    ctx.dartFns
      ..writeln('$widgetSt $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = $ctorClass(${dartParams.names});');

    writeDartStructCreation('w');

    for (var m in callableMethods()) {
      ctx.dartFns
        ..writeln('  final ${m.name}Fn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.listener((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.${m.name}(cb.asFunction()));')
        ..writeln('  stObj.${m.name} = ${m.name}Fn.nativeFunction;');
    }

    for (var m in callableFields()) {
      ctx.dartFns
        ..writeln('  final ${m.name}Fn = ffi.NativeCallable<${types.type4D(m.type)} Function()>.isolateLocal(() => ${Params.paramValueDtoC(types, paramElement('w.${m.name}', m.type))}, exceptionalReturn: exception);')
        ..writeln('  stObj.${m.name} = ${m.name}Fn.nativeFunction;');
    }

    writeDartStructReturn();
  }
}
