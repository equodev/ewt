import 'dart:io';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

Future<void> main() async {
  var widgets = await widgetsToGenerate();
  var generation = Generation(widgets)
    ..gen()
    ..write();
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

class WidgetGen {
  Generation generation;
  ClassElement dartClass;
  String widgetClass;
  String widgetField;
  StringBuffer javaFile = StringBuffer();
  StringBuffer headerFile = StringBuffer();
  StringBuffer dartAssigns = StringBuffer();
  StringBuffer dartFns = StringBuffer();
  StringBuffer javaFactories = StringBuffer();

  WidgetGen(this.generation, this.dartClass):
        widgetClass = dartClass.name,
        widgetField = '${dartClass.name[0].toLowerCase()}${dartClass.name.substring(1)}' {
    gen();
  }

  void gen() {
    writeHeaders();
    dartAssigns.writeln('void _setup$widgetClass(WidgetFactories f) {');
    for (var constr in dartClass.constructors) {
      writeFactory(constr);
    }
    dartAssigns.writeln('}');
    writeFooter();
  }

  String genJavaClass() {
    return javaFile.toString();
  }

  String genCFactories() {
    return headerFile.toString();
  }

  String genDartFactories() {
    return '$dartAssigns\n$dartFns';
  }

  String genJavaFactories() {
    return javaFactories.toString();
  }

  void write() {
    _writeJ(widgetClass, javaFile.toString());
  }

  void writeHeaders() {
    javaFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('import org.immutables.builder.Builder;')
      ..writeln('public class $widgetClass extends NativeObj implements Widget {')
      ..writeln('  static final WidgetConstructors factories = WidgetConstructors.instance;');
    headerFile
      .writeln('  struct {');
      // .writeln('  struct $widgetClass {');
  }

  void writeFooter() {
    javaFile.writeln('}');
    headerFile.writeln('  } $widgetField;');
  }

  void writeFactory(ConstructorElement node) {
    final jParams = Params(generation, dartClass, node.parameters, Params.paramDef4J);
    final cParams = Params(generation, dartClass, node.parameters, Params.paramDef4C);
    final dartParams = Params(generation, dartClass, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D );
    final jParamsFFM = Params(generation, dartClass, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4FFM );
    if (node.name.isEmpty) { // unnamed constructors
      final builderClass = '${widgetClass}Builder';
      javaFile
        ..writeln('  @Builder.Constructor')
        ..writeln('  $widgetClass(${jParams.builderDecl}) {')
        ..writeln('    id = factories.${widgetField}Of(${jParams.names});')
        ..writeln('  }')
        ..writeln('  public static $builderClass of(${jParams.required}) {')
        ..writeln('    return $builderClass.$widgetClass(${jParams.requiredNames});')
        ..writeln('  }');
      headerFile
        .writeln("    int (*of)(${cParams.decl});");
      dartAssigns
        .writeln('  f.$widgetField.of = ffi.Pointer.fromFunction(${widgetField}Of, exception);');
      dartFns
          ..writeln('int ${widgetField}Of(${dartParams.decl}) {')
          ..writeln('  final w = $widgetClass(${dartParams.names});')
          ..writeln('  return _addWidget(w);')
          ..writeln('}');
      javaFactories
        ..writeln('  int textOf(${jParams.decl}) {')
        ..writeln('    var st = WidgetFactories.$widgetField(factories);')
        ..writeln('    var fn = WidgetFactories.$widgetField.of(st);')
        ..writeln('    return WidgetFactories.$widgetField.of.invoke(fn, ${jParamsFFM.names});')
        ..writeln('  }');
    } else {
      final factoryName = '$widgetField${node.name[0].toUpperCase()}${node.name.substring(1)}';
      final factory = node.name;
      final builderClass = '${factoryName[0].toUpperCase()}${factoryName.substring(1)}Builder';
      javaFile
        ..writeln('  $widgetClass(${jParams.decl}) {')
        ..writeln('    id = factories.$factoryName(${jParams.names});')
        ..writeln('  }')
        ..writeln('  @Builder.Factory')
        ..writeln('  static $widgetClass $factoryName(${jParams.builderDecl}) {')
        ..writeln('    return new $widgetClass(${jParams.names});')
        ..writeln('  }')
        ..writeln('  public static $builderClass ${factory}(${jParams.required}) {')
        ..writeln('    return $builderClass.$factoryName(${jParams.requiredNames});')
        ..writeln('  }');
      headerFile
        .writeln("    int (*$factory)(${cParams.decl});");
      dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName, exception);');
      dartFns
        ..writeln('int $factoryName(${dartParams.decl}) {')
        ..writeln('  final w = $widgetClass.$factory(${dartParams.names});')
        ..writeln('  return _addWidget(w);')
        ..writeln('}');
      javaFactories
        ..writeln('  int $factoryName(${jParams.decl}) {')
        ..writeln('    var st = WidgetFactories.$widgetField(factories);')
        ..writeln('    var fn = WidgetFactories.$widgetField.$factory(st);')
        ..writeln('    return WidgetFactories.$widgetField.$factory.invoke(fn, ${jParamsFFM.names});')
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
    _writeJ(enumType.name, javaFile.toString());
  }
}

class Generation {
  Set<DartType> requiredTypes = {};
  StringBuffer headerFile = StringBuffer();
  StringBuffer dartFactories = StringBuffer();
  StringBuffer javaFactories = StringBuffer();

  Iterable<ClassElement> widgets;

  Generation(this.widgets);

  void gen() {
    headerFile.writeln('typedef int DartObj;');
    headerFile.writeln('typedef struct {');
    dartFactories
      ..writeln("import 'package:flutter/widgets.dart';")
      ..writeln("import 'package:widgets/widgets_bindings_generated.dart';")
      ..writeln("import 'package:ffi/ffi.dart';")
      ..writeln("import 'dart:ffi' as ffi;")
        // ..writeln('class WidgetFactoriesSetup {')
        // ..writeln('  static WidgetFactoriesSetup _instance;')
        // ..writeln('  static WidgetFactoriesSetup _instance;')
        // ..writeln('  static final WidgetFactories f')
      ..writeln('final WidgetFactories factories = _setupFactories();')
      ..writeln('const exception = -1;')
      ..writeln('Map<int, Widget> _widgetsMap = {};')
      ..writeln('WidgetFactories _setupFactories() {')
      ..writeln('  final WidgetFactories f = ffi.Struct.create();');

    for (var dartClass in widgets) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    dartFactories.writeln('  return f;');
    dartFactories.writeln('}');

    javaFactories
      ..writeln('package dev.equo.ewt;')
      ..writeln('import dev.equo.ewt.ffm.*;')
      ..writeln('import java.util.Optional;')
      ..writeln('import java.util.OptionalInt;')
      ..writeln('import java.util.OptionalDouble;')
      ..writeln('import java.lang.foreign.*;')
      ..writeln('class WidgetConstructors {')
      ..writeln('  static WidgetConstructors instance = new WidgetConstructors();')
      ..writeln('  private MemorySegment factories;')
      ..writeln('  private Arena arena = Arena.ofAuto();')
      ..writeln('  public void set(MemorySegment factories) {')
      ..writeln('    this.factories = factories;')
      ..writeln('  }');

    for (var dartClass in widgets) {
      processWidget(dartClass);
      dartFactories.writeln('  ');
    }

    dartFactories.writeln('Widget getWidget(int id) => _widgetsMap[id]!;');
    dartFactories.writeln('int _addWidget(Widget w) {\n'
                          '  final id = w.hashCode;\n'
                          '  _widgetsMap[id] = w;\n'
                          '  print(\'Added widget id: \$id\');\n'
                          '  return id;\n'
                          '}');
    // dartFactories.writeln('T? enumVal<T>(List<T> values, ffi.Pointer<ffi.Int> ptr) => ptr.address == ffi.nullptr.address ? null : values[ptr.value];');
    // dartFactories.writeln('bool? boolVal(ffi.Pointer<ffi.Int> ptr) => ptr.address == ffi.nullptr.address ? null : ptr.value == 1 ? true : false;');
    // dartFactories.writeln('int? intVal(ffi.Pointer<ffi.Int> ptr) => ptr.address == ffi.nullptr.address ? null : ptr.value;');
    // dartFactories.writeln('double? doubVal(ffi.Pointer<ffi.Double> ptr) => ptr.address == ffi.nullptr.address ? null : ptr.value;');
    dartFactories.writeln('extension on ffi.Pointer<ffi.Int> { int? intOrNul() => this == ffi.nullptr ? null : value; }');
    dartFactories.writeln('extension on ffi.Pointer<ffi.Double> { double? doubleOrNul() => this == ffi.nullptr ? null : value; }');
    dartFactories.writeln('extension on ffi.Pointer<ffi.Int> { bool? boolOrNul() => this == ffi.nullptr ? null : value == 1 ? true : false; }');
    dartFactories.writeln('extension on ffi.Pointer<ffi.Pointer<ffi.Char>> { String? strOrNul() => this == ffi.nullptr ? null : value.cast<Utf8>().toDartString(); }');
    dartFactories.writeln('extension EnumPtr<T> on ffi.Pointer<ffi.Int> { T? enumOrNul(List<T> values) => this == ffi.nullptr ? null : values[value]; }');
    dartFactories.writeln('extension ObjPtr<T> on ffi.Pointer<ffi.Int> { T? objOrNul() => this == ffi.nullptr ? null : _widgetsMap[value]! as T; }');

    headerFile.writeln('} WidgetFactories;');

    javaFactories.writeln('  MemorySegment ptr(OptionalInt opt) {\n'
                          '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.getAsInt()) : MemorySegment.NULL;\n'
                          '  }');
    javaFactories.writeln('  MemorySegment ptr(OptionalDouble opt) {\n'
                          '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_DOUBLE, opt.getAsDouble()) : MemorySegment.NULL;\n'
                          '  }');
    javaFactories.writeln('  MemorySegment ptrBool(Optional<Boolean> opt) {\n'
                          '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get() ? 1 : 0) : MemorySegment.NULL;\n'
                          '  }');
    javaFactories.writeln('  MemorySegment ptrStr(Optional<String> opt) {\n'
                          '    return opt.isPresent() ? arena.allocateFrom(opt.get()) : MemorySegment.NULL;\n'
                          '  }');
    javaFactories.writeln('  <T extends Enum<?>> MemorySegment ptrEnum(Optional<T> opt) {\n'
                          '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().ordinal()) : MemorySegment.NULL;\n'
                          '  }');
    javaFactories.writeln('  <T extends NativeObj> MemorySegment ptrObj(Optional<T> opt) {\n'
                          '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().getId()) : MemorySegment.NULL;\n'
                          '  }');
    javaFactories.writeln('}');
  }

  void processWidget(ClassElement dartClass) {
    var widGen = WidgetGen(this, dartClass)
      ..genJavaClass()..write();
    headerFile.writeln(widGen.genCFactories());
    dartFactories.writeln(widGen.genDartFactories());
    javaFactories.writeln(widGen.genJavaFactories());

    for (DartType requiredType in this.requiredTypes.toSet()) {
      processDependency(this, requiredType);
    }
  }

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

  String type4C(DartType namedType) {
    if (namedType is InterfaceType) {
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
      return 'DartObj'; // object are passes as ids
    }
    return namedType.toString();
  }

  String type4D(DartType namedType) {
    if (namedType is InterfaceType) {
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
      return 'int';
    }
    return namedType.toString();
  }

  void write() {
    _writeC('factories.h', headerFile.toString());
    _writeD('factories.dart', dartFactories.toString());
    _writeJ('WidgetConstructors', javaFactories.toString());
  }

  String genCFactories() {
    return headerFile.toString();
  }

  String genDartFactories() {
    return dartFactories.toString();
  }

  String genJavaFactories() {
    return javaFactories.toString();
  }

}

class Params {
  Generation generation;
  ClassElement dartClass;
  List<ParameterElement> parameters;

  late String names = "";
  late String builderDecl = "";
  late String decl = "";
  late String cdecl = "";
  late String required = "";
  late String requiredNames = "";
  bool allTypes;

  Params(this.generation, this.dartClass, this.parameters,
      String Function(Generation, ParameterElement, {bool annotated, bool wrap}) paramDef,
      {this.allTypes = false, String Function(ParameterElement) paramValue = _paramName}) {
    var filtered = allTypes ? parameters : parameters.where((p) => supportedType(p.type));
    names = filtered.map(paramValue).join(', ');
    builderDecl = filtered.map((p) => '${paramDef(generation, p, annotated: p.isRequired, wrap: p.isOptional)} ${_paramName(p)}').join(', ');
    decl = filtered.map((p) => '${paramDef(generation, p, wrap: p.isOptional)} ${_paramName(p)}').join(', ');
    var mandatory = filtered.where((p) => p.isRequired);
    required = mandatory.map((p) => '${paramDef(generation, p)} ${paramValue(p)}').join(', ');
    requiredNames = mandatory.map(paramValue).join(', ');
    // required = filtered.where((p) => p.isRequired).map((p) => '${_paramDef(p)} ${_paramName(p)}').join(', ');
  }

  static String paramDef4J(Generation generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
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

  static String paramDef4C(Generation generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4C(param.type)}';
    if (wrap) {
      t = '$t*';
    }
    return t;
  }

  static String paramDef4D(Generation generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4D(param.type)}';
    if (wrap) {
      t = 'ffi.Pointer<$t>';
    }
    return t;
  }

  static String _paramName(ParameterElement param) => param.name;

  static String paramValue4D(ParameterElement param) {
    final t = param.type;
    var value = param.name;
    if (t is InterfaceType) {
      if (param.isOptional) {
        if (t.isDartCoreString) {
          value = '${param.name}.strOrNul()';
        }
        else if (t.isDartCoreBool) {
          value = '${param.name}.boolOrNul()';
        }
        else if (t.isDartCoreInt) {
          value = '${param.name}.intOrNul()';
        }
        else if (t.isDartCoreDouble) {
          value = '${param.name}.doubleOrNul()';
        }
        else if (t.element is EnumElement) {
          value = '${param.name}.enumOrNul(${t.element.name}.values)';
        }
        else if (!isPrimitive(t)) {
          value = '${param.name}.objOrNul()';
        }
      } else {
        if (t.isDartCoreString) {
          value = '${param.name}.cast<Utf8>().toDartString()';
        }
        else if (!isPrimitive(t)) {
          value = '_widgetsMap[$value]! as $t';
        }
      }
    }
    if (param.isNamed) {
      value = '${param.name}: $value';
    }
    return value;
  }

  static String paramValue4FFM(ParameterElement param) {
    final t = param.type;
    var value = param.name;
    if (t is InterfaceType) {
      // else {
      //   value = '_widgetsMap[$value]! as $t';
      // }
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
      else if (t.element is EnumElement) {
        value = 'ptrEnum($value)';
      }
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
      else if (!isPrimitive(t)) {
        value = '$value.getId()';
      }
    }
    return value;
  }
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

void _writeJ(String clazz, String javaContent) {
  print('Generating $clazz');
  File('../ewt.api/src/main/java/dev/equo/ewt/$clazz.java').writeAsStringSync(javaContent);
}

void _writeC(String file, String content) {
  print('Generating $file');
  File('../widgets/src/$file').writeAsStringSync(content);
}

void _writeD(String file, String content) {
  print('Generating $file');
  File('../widgets/lib/$file').writeAsStringSync(content);
}