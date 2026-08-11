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
      ctx.javaFile
          .writeln('  private MemorySegment st;');
      ctx.javaFile
          .writeln('  protected $widgetClass() {}');
      ctx.javaFile
        ..writeln('  $widgetClass(MemorySegment st) {')
        ..writeln('    this.id = $widgetSt.id(st);')
        ..writeln('    this.st = st;')
        ..writeln('    if (id <= 0) throw new RuntimeException("Failed to created widget $widgetClass");')
        ..writeln('    System.out.println("New $widgetClass id:"+id);')
        ..writeln('  }');
      // Shadow int-ctor for the callback path: when this widget appears as a
      // callback parameter, the FFM side only has the id. The struct-backed
      // getters will NPE, but constructing a reference to the widget works.
      ctx.javaFile
        ..writeln('  $widgetClass(int id) { this.id = id; }');
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
      ctx.javaFile
        ..writeln('    var st = factories.$factoryName(${jParams.names});')
        ..writeln(
            '    if (st == null) throw new RuntimeException("Failed to created widget $widgetClass");')
        ..writeln(
            '    return new ${types.type4J(node.returnType)}(st);');
    }
  }

  @override
  MemberEmitter get memberEmitter => const ImmutableMemberEmitter();

  Iterable<FieldElement> callableFields() => getCallableFields(dartClass);
}
