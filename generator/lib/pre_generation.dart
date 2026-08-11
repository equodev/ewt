part of 'gen.dart';

class PreGeneration {
  // Set<DartType> requiredTypes = {};
  // Set<Element> processed = {};
  // StringBuffer headerFile = StringBuffer();
  // StringBuffer dartFactories = StringBuffer();
  StringBuffer dartSubclasses = StringBuffer();
  // StringBuffer javaFactories = StringBuffer();
  // StringBuffer javaStatics = StringBuffer();

  Iterable<ClassElement> widgets;

  // ClassElement? widgetElement;


  PreGeneration(this.widgets);

  void gen() {
    dartSubclasses.writeln('import \'package:flutter/widgets.dart\';');
    // dartSubclasses.writeln('typedef CreateStateFn = State<StatefulWidget> Function();');
    for (final widget in widgets) {
      final clazz = DartSubclassGen.forWidget(this, widget)
        ..gen();
      dartSubclasses.writeln(clazz.genDartClass());
    }
  }
  void write() {
    if (dartSubclasses.isNotEmpty) {
      _writeD('subwidgets.dart', dartSubclasses.toString());
      _writeDCopy('subwidgets.dart',
          dartSubclasses.toString()); // this is for the parser/generator
    }
  }

}

class DartSubclassGen {
  PreGeneration generation;
  ClassElement dartClass;
  String widgetClass;
  // String widgetField;
  // StringBuffer javaFile = StringBuffer();
  // StringBuffer headerFile = StringBuffer();
  StringBuffer dartSubclass = StringBuffer();
  // StringBuffer dartFns = StringBuffer();
  // StringBuffer javaFactories = StringBuffer();
  // StringBuffer javaStatics = StringBuffer();

  DartSubclassGen(this.generation, this.dartClass):
        widgetClass = 'Sub${dartClass.name}';

  /// Factory: dispatches by the underlying Flutter base class name to the
  /// concrete subclass. Single point of name → generator mapping for the
  /// pregeneration path (mirrors `Types.getGen` for the main generator).
  factory DartSubclassGen.forWidget(PreGeneration g, ClassElement w) {
    if (w.name == 'StatefulWidget') return UniqueKeyDefaulterGen(g, w);
    return DartSubclassGen(g, w);
  }

  /// Extra ctor customization for the emitted Dart subclass. Mutates
  /// [params] in-place if needed and returns the constructor initializer
  /// clause (empty by default). Overridden by [UniqueKeyDefaulterGen] to
  /// force a UniqueKey default.
  String customizeCtor(List<String> params) => '';

  void gen() {
    final typeParam = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    final superTypeParam = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.map((t) => t.name).join(', ')}>' : '';
    dartSubclass
        .writeln('class $widgetClass$typeParam extends ${dartClass.name}$superTypeParam {');
    final methods = dartClass.methods.where(canBeImplInJava);
    for (final method in methods) {
      dartSubclass.writeln('  final ${method.type} ${method.name}Fn;');
    }
    var params = dartClass.constructors.first.parameters.map((p) => '${p is SuperFormalParameterElement ? 'super.' : 'this.'}${p.name}').toList();
    var overrideable = methods.map((m) => 'required this.${m.name}Fn').toList();
    final initializer = customizeCtor(params);
    dartSubclass
        .writeln('  $widgetClass({${(params+overrideable).join(', ')}})$initializer;');
    for (final method in methods) {
      dartSubclass.writeln('  @override');
      dartSubclass.writeln('  $method { ');
      if (method.hasMustCallSuper) {
        dartSubclass.writeln('    super.${method.name}(${method.parameters.map((p) => p.name).join(', ')});');
      }
      dartSubclass.writeln('    ${method.returnType is VoidType ? '' : 'return '}${method.name}Fn(${method.parameters.map((p) => p.name).join(', ')});');
      dartSubclass.writeln('  }');
    }
    dartSubclass
        .writeln('}');
  }

  String genDartClass() {
    return dartSubclass.toString();
  }
}
