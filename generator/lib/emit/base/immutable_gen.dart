part of '../../gen.dart';

class ImmutableGen extends ObjStGen {
  ImmutableGen(super.types, super.dartClass);

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    // First call the base ObjStGen implementation for common imports
    super.writeJavaDecl(extend, isInterface);
    // Then complete with the class declaration that would normally be done in WidgetGen
    ctx.javaFile.writeln(
        'public ${!dartClass.isAbstract ? 'class' : _isInterface ? 'interface' : 'abstract class'} $widgetClass$extend {');
  }

  @override
  void writeJavaConstructors() {
    if (!_isInterface) {
      // java-11 split: the builder holds only a foreign-free `int id` (inherited from
      // NativeObj.Base), so the class loads on any JVM >= 11. The FFM struct (MemorySegment)
      // stays inside the FFM WidgetConstructors, never on the builder surface.
      ctx.javaFile
          .writeln('  protected $widgetClass() {}');
      ctx.javaFile
        ..writeln('  $widgetClass(int id) {')
        ..writeln('    this.id = id;')
        ..writeln('    if (id <= 0) throw new RuntimeException("Failed to created widget $widgetClass");')
        // java-11 split: adopt the native struct the FFM factory just built (null on comm / bare-id
        // construction), so read-back getters can hand it back to the FFM impl. GC'd with this widget.
        ..writeln('    this.nativeStruct = factories.takeLastStruct();')
        ..writeln('  }');
    }
  }

  @override
  void writeJavaInstanceBody(String factoryName, Params jParams, FunctionTypedElement node) {
    if (node.returnType.element is EnumElement) {
      super.writeJavaInstanceBody(factoryName, jParams, node);
      return;
    }
    if (node.returnType is VoidType) {
      ctx.javaFile
        .writeln('    factories.$factoryName(${jParams.names});');
    } else {
      // Factory returns a foreign-free int id (see type4FFMRet); build via the int ctor.
      ctx.javaFile
        ..writeln('    int id = factories.$factoryName(${jParams.names});')
        ..writeln(
            '    if (id <= 0) throw new RuntimeException("Failed to created widget $widgetClass");')
        ..writeln(
            '    return new ${types.type4J(node.returnType)}(id);');
    }
  }

  @override
  MemberEmitter get memberEmitter => const ImmutableMemberEmitter();

  Iterable<FieldElement> callableFields() => getCallableFields(dartClass);
}
