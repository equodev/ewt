import 'dart:io';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

Future<void> main() async {
  var widgets = await widgetsToGenerate();
  var generation = Generation();
  for (var dartClass in widgets) {
    processWidget(dartClass, generation);
  }
}

Future<Iterable<ClassElement>> widgetsToGenerate() async {
  var index = path.absolute(path.join('tool', 'generation_index.dart'));
  var collection = AnalysisContextCollection (includedPaths: [index], sdkPath: getSdkPath());
  var ctx = collection.contextFor(index);
  var session = ctx.currentSession;
  var unitResult = await session.getResolvedUnit(index);
  if (unitResult is ResolvedUnitResult) {
    var widgetsToGenerate = unitResult.unit.declaredElement!.topLevelVariables;
    var dartClasses = widgetsToGenerate.map((w) => w.type.element as ClassElement);
    return dartClasses;
  }
  return [];
}

String getSdkPath() {
  final executable = path.split(Platform.resolvedExecutable);
  final cache = executable.indexOf('cache');
  return path.join(path.joinAll(executable.sublist(0, cache+1)), 'dart-sdk');
}

void processWidget(ClassElement dartClass, Generation generation) {
  WidgetGen(generation, dartClass)
      ..genJavaClass()..write();
  for (DartType requiredType in generation.requiredTypes.toSet()) {
    processDependency(generation, requiredType);
  }
}

class WidgetGen {
  Generation generation;
  ClassElement dartClass;
  String widgetClass;
  StringBuffer javaFile = StringBuffer();

  WidgetGen(this.generation, this.dartClass):
        widgetClass = dartClass.name;

  String genJavaClass() {
    writeHeaders();
    for (var constr in dartClass.constructors) {
      writeFactory(constr);
    }
    writeFooter();
    return javaFile.toString();
  }

  void write() {
    writeJava(widgetClass, javaFile.toString());
  }

  void writeHeaders() {
    javaFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('import org.immutables.builder.Builder;')
      ..writeln('public class $widgetClass {');
  }

  void writeFooter() {
    javaFile.writeln('}');
  }

  void writeFactory(ConstructorElement node) {
    final params = JavaParams(generation, dartClass, node.parameters);
    if (node.name.isEmpty) { // unnamed constructors
      final builderClass = '${widgetClass}Builder';
      javaFile
        ..writeln('  @Builder.Constructor')
        ..writeln('  $widgetClass(${params.builderDecl}) {')
        ..writeln('  }')
        ..writeln('  public static $builderClass of(${params.required}) {')
        ..writeln('    return $builderClass.$widgetClass(${params.requiredNames});')
        ..writeln('  }');
    } else {
      final factoryName = '${widgetClass[0].toLowerCase()}${widgetClass.substring(1)}${node.name.toString()[0].toUpperCase()}${node.name.toString().substring(1)}';
      final builderClass = '${factoryName[0].toUpperCase()}${factoryName.substring(1)}Builder';
      javaFile
        ..writeln('  $widgetClass(${params.decl}) {')
        ..writeln('  }')
        ..writeln('  @Builder.Factory')
        ..writeln('  static $widgetClass $factoryName(${params.builderDecl}) {')
        ..writeln('    return new $widgetClass(${params.names});')
        ..writeln('  }')
        ..writeln('  public static $builderClass ${node.name}(${params.required}) {')
        ..writeln('    return $builderClass.$factoryName(${params.requiredNames});')
        ..writeln('  }');
    }
  }
}

Future<void> processDependency(Generation generation, DartType requiredType) async {
  if (requiredType.element is EnumElement) {
    EnumGen(generation, requiredType.element as EnumElement)
      ..genJavaClass()..write();
  }
}

class EnumGen {
  Generation generation;
  EnumElement enumType;
  StringBuffer javaFile = StringBuffer();

  EnumGen(this.generation, this.enumType);

  String genJavaClass() {
    javaFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('public enum ${enumType.name} {');
    javaFile.writeln(enumType.fields.map((en) => en.name).where((en) => "values" != en).join(', '));
    javaFile.writeln('}');
    return javaFile.toString();
  }

  void write() {
    writeJava(enumType.name, javaFile.toString());
  }
}

class Generation {
  Set<DartType> requiredTypes = {};

  String type4J(DartType namedType) {
    if (!isPrimitive(namedType) && supportedType(namedType)) {
      requiredTypes.add(namedType);
    }
    if (namedType is InterfaceType) {
      if (namedType.isDartCoreBool) {
        return 'boolean';
      }
      return namedType.element.name;
    }
    return namedType.toString();
  }
}

class JavaParams {
  Generation generation;
  ClassElement dartClass;
  List<ParameterElement> parameters;

  late String names = "";
  late String builderDecl = "";
  late String decl = "";
  late String required = "";
  late String requiredNames = "";
  bool allTypes;

  JavaParams(this.generation, this.dartClass, this.parameters, {this.allTypes = false}) {
    var filtered = allTypes ? parameters : parameters.where((p) => supportedType(p.type));
    names = filtered.map(_paramName).join(', ');
    builderDecl = filtered.map((p) => '${_paramDef(p, annotated: p.isRequired, wrap: p.isOptional)} ${_paramName(p)}').join(', ');
    decl = filtered.map((p) => '${_paramDef(p, wrap: p.isOptional)} ${_paramName(p)}').join(', ');
    var mandatory = filtered.where((p) => p.isRequired);
    required = mandatory.map((p) => '${_paramDef(p)} ${_paramName(p)}').join(', ');
    requiredNames = mandatory.map(_paramName).join(', ');
    // required = filtered.where((p) => p.isRequired).map((p) => '${_paramDef(p)} ${_paramName(p)}').join(', ');
  }

  String _paramDef(ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type)}';
    if (wrap) {
      if (param.type.isDartCoreDouble) {
        t = 'java.util.OptionalDouble';
      }
      else if (param.type.isDartCoreInt) {
        t = 'java.util.OptionalInt';
      }
      else if (param.type.isDartCoreBool) {
        t = 'java.util.Optional<Boolean>';
      }
      else {
        t = 'java.util.Optional<$t>';
      }
    }
    return t;
  }

  String _paramName(ParameterElement param) => param.name;
}

bool supportedType(DartType t) {
  if (t.isDartCoreEnum || isPrimitive(t)) {
    return true;
  }
  if (t.element is EnumElement) {
    return true;
  }
  if (t.getDisplayString() == 'InlineSpan') {
    return true;
  }
  return false;
}

bool isPrimitive(DartType t) => t.isDartCoreString || t.isDartCoreBool || t.isDartCoreDouble || t.isDartCoreInt;

void writeJava(String clazz, String javaContent) {
  print('Generating $clazz');
  File('../ewt.api/src/main/java/dev/equo/ewt/$clazz.java').writeAsStringSync(javaContent);
}