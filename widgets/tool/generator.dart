import 'dart:io';
import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/src/dart/element/element.dart';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

Future<void> main() async {
  var widgets = await widgetsToGenerate();
  Generation(widgets)
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
  StringBuffer javaStatics = StringBuffer();

  WidgetGen(this.generation, this.dartClass):
        widgetClass = dartClass.name,
        widgetField = '${dartClass.name[0].toLowerCase()}${dartClass.name.substring(1)}' {
    gen();
  }

  void gen() {
    var constructors = dartClass.constructors.where((f) => f.isPublic);
    var consts = dartClass.fields.where((f) => f.isStatic && f.isConst && f.isPublic);
    var hasMembers = (!dartClass.isAbstract && constructors.isNotEmpty) /*|| (dartClass.isAbstract && consts.isNotEmpty)*/;
    writeHeaders(hasMembers);
    if (hasMembers) {
      dartAssigns.writeln('void _setup$widgetClass(WidgetFactories f) {');
    }
    if (!dartClass.isAbstract) {
      javaFile
          .writeln('  $widgetClass() {}');
      javaFile
        ..writeln('  $widgetClass(int id) {')
        ..writeln('    this.id = id;')
        ..writeln('  }');
      for (var constr in constructors) {
        writeFactory(constr);
      }
    }
    if (consts.isNotEmpty) {
      // final constFn = '${widgetField}Consts';
      // headerFile
      //     .writeln("    int (*$constFn)(int constId);");
      // dartAssigns
      //     .writeln('  f.$widgetField.$constFn = ffi.Pointer.fromFunction($constFn, exception);');
      // dartFns
        // ..writeln('int $constFn(int constId) {')
        // ..writeln('  var c;');
        // ..writeln('  switch (constId) {');
      var c=1;
      for (var constr in consts.whereType<ConstFieldElementImpl>()) {
        writeConst(constr, c++);
      }
      // dartFns
      //   ..writeln('  else {throw \'Unsupported const \$constId\';}')
        // ..writeln('  }')
        // ..writeln('  return _addWidget(c);')
        // ..writeln('}');
      // javaFactories
      //   ..writeln('  int $constFn(int constId) {')
      //   ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      //   ..writeln('    var fn = WidgetFactories.${widgetClass}St.$constFn(st);')
      //   ..writeln('    return WidgetFactories.${widgetClass}St.$constFn.invoke(fn, constId);')
      //   ..writeln('  }');

    }
    if (hasMembers) {
      dartAssigns.writeln('}');
    }
    writeFooter(hasMembers);
    if (dartClass.supertype != null) {
      generation.addRequiredType(dartClass.supertype as DartType);
    }
  }

  String genJavaClass() {
    return javaFile.toString();
  }

  String genCFactories() {
    return headerFile.toString();
  }

  String genDartFactories() {
    return '$dartAssigns$dartFns';
  }

  String genJavaFactories() {
    return javaFactories.toString();
  }

  String genJavaStatics() {
    return javaStatics.toString();
  }

  void write() {
    _writeJ(widgetClass, javaFile.toString());
  }

  void writeHeaders(bool hasMembers) {
    javaFile
      .writeln('package dev.equo.ewt;');
    var isInterface = dartClass.isInterface || dartClass.isMixinClass || dartClass.interfaces.any((i) => i.element is ClassElement);
    var extend = '';
    if (dartClass.supertype != null && !dartClass.supertype!.isDartCoreObject) {
      extend = ' extends ${dartClass.supertype!.getDisplayString()}';
    }
    else {
      extend = ' extends ${!isInterface ? 'NativeObj.Base' : 'NativeObj'}';
    }
    var trulyInterfaces = dartClass.interfaces.where((i) =>
        i.interfaces.any((i) => i.element is ClassElement));
    if (trulyInterfaces.isNotEmpty) {
      extend += ' implements ${trulyInterfaces.map((i) => i.getDisplayString()).join(', ')}';
    }
    if (!dartClass.isAbstract) {
      javaFile
        ..writeln('import java.util.*;')
        ..writeln('import org.immutables.builder.Builder;')
        ..writeln('public class $widgetClass$extend {');
        // ..writeln('  static final WidgetConstructors factories = WidgetConstructors.instance;');
    } else {
      javaFile
        .writeln('public ${isInterface ? 'interface' : 'abstract class'} $widgetClass$extend {');
    }
    if (hasMembers) {
      headerFile
        .writeln('  struct ${widgetClass}St {');
    }
  }

  void writeFooter(bool hasMembers) {
    javaFile.writeln('}');
    if (hasMembers) {
      headerFile.writeln('  } $widgetField;');
    }
  }

  void writeFactory(ConstructorElement node) {
    if (node.parameters.any((p) => !generation.supportedType(p.type) && p.isRequired)) {
      return;
    }
    final jParams = Params(generation, dartClass, node.parameters, Params.paramDef4J, paramValue: Params._escape4J, escape: Params._escape4J);
    final cParams = Params(generation, dartClass, node.parameters, Params.paramDef4C);
    final dartParams = Params(generation, dartClass, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    final jParamsFFM = Params(generation, dartClass, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4FFM, escape: Params._escape4J);
    String factory = (node.name.isEmpty) ? widgetField : node.name;
    String factoryName = '$widgetField${factory.firstUpper()}';
    String builderFactory;
    String builderClass = '$widgetClass${factory.firstUpper()}Builder';
    builderFactory = factoryName;
    javaFile
      ..writeln('  @Builder.Factory')
      ..writeln('  static $widgetClass $factoryName(${jParams.builderDecl}) {')
      ..writeln('    int id = factories.$factoryName(${jParams.names});')
      ..writeln('    if (id == -1) throw new RuntimeException("Failed to created widget $widgetClass");')
      ..writeln('    System.out.println("New $widgetClass id:"+id);')
      ..writeln('    return new $widgetClass(id);')
      ..writeln('  }');
    javaFile
      ..writeln('  public static $builderClass $factory(${jParams.required}) {')
      ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
      ..writeln('  }');
    headerFile
      .writeln("    int (*$factory)(${cParams.decl});");
    dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName, exception);');
    dartFns
      ..writeln('int $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = ${node.displayName}(${dartParams.names});')
      ..writeln('  return _addWidget(w);')
      ..writeln('}');
    javaFactories
      ..writeln('  int $factoryName(${jParams.decl}) {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
      ..writeln('    return WidgetFactories.${widgetClass}St.$factory.invoke(fn, ${jParamsFFM.names});')
      ..writeln('  }');
    javaStatics
      ..writeln('  public static $builderClass $widgetClass${node.name.isEmpty ? '' : '_$factory'}(${jParams.required}) {')
      ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
      ..writeln('  }');
  }

  void writeConst(ConstFieldElementImpl fld, int constId) {
    final constFn = '${widgetField}Consts';
    String factory = _escape4D(fld.name);
    // String factoryName = '$widgetField${factory.firstUpper()}';
    var nodeList = (fld.constantInitializer as InstanceCreationExpression).argumentList.arguments;
    var requiredArgs = nodeList.where((a) => a.correspondingParameter!.isRequiredPositional).map((a) => a.unParenthesized).join(', ');
    var otherArgs = nodeList
        .whereType<NamedExpression>()
        .map((a) => '.${a.name.label}(${a.expression.toString().replaceAll('\'', '"')})')
        .join('');
    javaFile
      ..writeln('  public static ${fld.type} $factory() {')
      ..writeln('    return ${fld.type}.${fld.type.toString().firstLower()}($requiredArgs)$otherArgs.build();')
      ..writeln('  }');
    // dartFns
    //   .writeln('  if (constId == $constId) {c = $widgetClass.${fld.displayName};}');
    // headerFile
    //     .writeln("    int (*$factory)(void);");
    // dartAssigns
    //     .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName, exception);');
    // dartFns
    //   ..writeln('int $factoryName() {')
    //   ..writeln('  final w = $widgetClass.${fld.displayName};')
    //   ..writeln('  return _addWidget(w);')
    //   ..writeln('}');
    // javaFactories
    //   ..writeln('  int $factoryName() {')
    //   ..writeln('    var st = WidgetFactories.$widgetField(factories);')
    //   ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
    //   ..writeln('    return WidgetFactories.${widgetClass}St.$factory.invoke(fn);')
    //   ..writeln('  }');
  }

}

extension on String {
  firstUpper() => isEmpty ? "" : this[0].toUpperCase() + substring(1);
  firstLower() => isEmpty ? "" : this[0].toLowerCase() + substring(1);
}

Future<void> processDependency(Generation generation, DartType requiredType) async {
  if (requiredType.element is EnumElement) {
    generation.processEnum(requiredType.element as EnumElement);
  }
  else if (requiredType.element is ClassElement) {
    generation.processWidget(requiredType.element as ClassElement);
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
  Set<Element> processed = {};
  StringBuffer headerFile = StringBuffer();
  StringBuffer dartFactories = StringBuffer();
  StringBuffer javaFactories = StringBuffer();
  StringBuffer javaStatics = StringBuffer();

  Iterable<ClassElement> widgets;

  ClassElement? widgetElement;


  Generation(Iterable<ClassElement> widgets):
    widgetElement = widgets.firstOrNull,
    widgets = widgets.skip(1);

  void gen() {
    // headerFile.writeln('typedef int DartObj;');
    headerFile.writeln('typedef struct {');
    dartFactories
      .writeln("part of 'factories.dart';");
    //   ..writeln('WidgetFactories _setupFactories() {')
    //   ..writeln('  final WidgetFactories f = ffi.Struct.create();');
    //
    // for (var dartClass in widgets) {
    //   dartFactories.writeln('  _setup${dartClass.name}(f);');
    // }
    // dartFactories.writeln('  return f;');
    // dartFactories.writeln('}');

    javaFactories
      ..writeln('package dev.equo.ewt;')
      ..writeln('import dev.equo.ewt.ffm.*;')
      ..writeln('import java.util.List;')
      ..writeln('import java.util.Optional;')
      ..writeln('import java.util.OptionalInt;')
      ..writeln('import java.util.OptionalDouble;')
      ..writeln('import java.lang.foreign.*;')
      ..writeln('class WidgetConstructors extends WidgetConstructorsBase {');
      // ..writeln('  static WidgetConstructorsGen instance = new WidgetConstructors();')
      // ..writeln('  private MemorySegment factories;')
      // ..writeln('  private Arena arena = Arena.ofAuto();')
      // ..writeln('  public void set(MemorySegment factories) {')
      // ..writeln('    this.factories = factories;')
      // ..writeln('  }');
    javaStatics
      ..writeln('package dev.equo.ewt;')
      ..writeln('import java.util.List;')
      ..writeln('import java.util.Optional;')
      ..writeln('import java.util.OptionalInt;')
      ..writeln('import java.util.OptionalDouble;')
      ..writeln('public class EWT {');

    for (var dartClass in widgets) {
      processWidget(dartClass);
    }

    dartFactories
      // ..writeln("part of 'factories.dart';")
      ..writeln('WidgetFactories _setupFactories() {')
      ..writeln('  final WidgetFactories f = ffi.Struct.create();');

    for (var dartClass in widgets.where((t) => !t.isAbstract)) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    for (var dartClass in requiredTypes.map((t) => t.element).whereType<ClassElement>().where((t) => !t.isAbstract)) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    requiredTypes.clear();

    dartFactories.writeln('  return f;');
    dartFactories.writeln('}');

    headerFile.writeln('} WidgetFactories;');

    // javaFactories.writeln('  MemorySegment ptr(OptionalInt opt) {\n'
    //                       '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.getAsInt()) : MemorySegment.NULL;\n'
    //                       '  }');
    // javaFactories.writeln('  MemorySegment ptr(OptionalDouble opt) {\n'
    //                       '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_DOUBLE, opt.getAsDouble()) : MemorySegment.NULL;\n'
    //                       '  }');
    // javaFactories.writeln('  MemorySegment ptrBool(Optional<Boolean> opt) {\n'
    //                       '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get() ? 1 : 0) : MemorySegment.NULL;\n'
    //                       '  }');
    // javaFactories.writeln('  MemorySegment ptrStr(Optional<String> opt) {\n'
    //                       '    return opt.isPresent() ? arena.allocateFrom(opt.get()) : MemorySegment.NULL;\n'
    //                       '  }');
    // javaFactories.writeln('  <T extends Enum<?>> MemorySegment ptrEnum(Optional<T> opt) {\n'
    //                       '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().ordinal()) : MemorySegment.NULL;\n'
    //                       '  }');
    // javaFactories.writeln('  <T extends NativeObj> MemorySegment ptrObj(Optional<T> opt) {\n'
    //                       '    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().getId()) : MemorySegment.NULL;\n'
    //                       '  }');
    // javaFactories.writeln('  <T extends NativeObj> MemorySegment ptrList(Optional<List<T>> opt) {\n'
    //                       '    if (opt.isPresent()) {\n'
    //                       '      MemorySegment struct = ArrayC.allocate(arena);\n'
    //                       '      ArrayC.size(struct, opt.get().size());\n'
    //                       '      MemorySegment array = arena.allocateFrom(StarterBridge.C_INT, opt.get().stream().mapToInt(NativeObj::getId).toArray());\n'
    //                       '      ArrayC.list(struct, array);\n'
    //                       '      return struct;\n'
    //                       '    }\n'
    //                       '    return MemorySegment.NULL\n;'
    //                       '  }');
    javaFactories.writeln('}');
    javaStatics.writeln('}');
  }

  bool supportedType(DartType t) {
    if (t.isDartCoreEnum || isPrimitive(t)) {
      return true;
    }
    if (t.element is EnumElement) {
      return true;
    }
    if (['InlineSpan', 'ThemeData', 'Color', 'ColorScheme'].contains(t.getDisplayString(withNullability: false))
        || isWidget(t.element) || widgets.contains(t.element) ) {
      return true;
    }
    if (t.isDartCoreList && supportedType((t as InterfaceType).typeArguments[0])) {
      return true;
    }
    if (t is FunctionType) {
      return (t.parameters.isEmpty);
    }
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

  void processWidget(ClassElement dartClass) {
    processed.add(dartClass.thisType.element);
    var widGen = WidgetGen(this, dartClass)
      ..genJavaClass()..write();
    if (widGen.genCFactories().isNotEmpty) {
      headerFile.writeln(widGen.genCFactories());
    }
    if (widGen.genDartFactories().isNotEmpty) {
      dartFactories.writeln(widGen.genDartFactories());
    }
    if (widGen.genJavaFactories().isNotEmpty) {
      javaFactories.writeln(widGen.genJavaFactories());
    }
    if (widGen.genJavaFactories().isNotEmpty) {
      javaStatics.writeln(widGen.genJavaStatics());
    }

    for (DartType requiredType in requiredTypes.toSet()) {
      if (!processed.contains(requiredType.element)) {
        // requiredTypes.remove(requiredType);
        processDependency(this, requiredType);
      }
    }
  }

  void processEnum(EnumElement dartClass) {
    processed.add(dartClass);
    EnumGen(this, dartClass)
      ..genJavaClass()..write();
  }

  String type4J(DartType namedType) {
    if (!isPrimitive(namedType) && supportedType(namedType)) {
      addRequiredType(namedType);
    }
    if (namedType is InterfaceType) {
      if (namedType.isDartCoreBool) {
        return 'boolean';
      }
      else if (namedType.isDartCoreList) {
        final arrayType = (namedType).typeArguments[0];
        return 'List<$arrayType>';
      }
      return namedType.element.name;
    }
    else if (namedType is FunctionType) {
      return 'java.lang.Runnable';
    }
    return namedType.toString();
  }

  String type4C(DartType namedType) {
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
    else if (namedType.isDartCoreList) {
      final arrayType = (namedType as InterfaceType).typeArguments[0];
      if (isPrimitive(arrayType)) {
        return '${type4C(arrayType)}*';
      } else {
        return 'ArrayC';
      }
    }
    else if (namedType is FunctionType) {
      return 'VoidCallback';
    }
    else if (!isPrimitive(namedType)) {
      return 'DartObj'; // object are passes as ids
    }
    return namedType.toString();
  }

  String type4D(DartType namedType) {
    // if (namedType is InterfaceType) {
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
      else if (namedType.isDartCoreList) {
        final arrayType = (namedType as InterfaceType).typeArguments[0];
        if (isPrimitive(arrayType)) {
          return 'ffi.Pointer<${type4D(arrayType)}>';
        } else {
          return 'ArrayC';
        }
      }
      else if (namedType is FunctionType) {
        return 'VoidCallback';
      }
      else if (!isPrimitive(namedType)) {
        return 'DartObj';
      }
      throw UnsupportedError('Unsupported type $namedType');
    // }
    return namedType.toString();
  }

  void write() {
    _writeC('factories.h', headerFile.toString());
    _writeD('factories_gen.dart', dartFactories.toString());
    _writeJ('WidgetConstructors', javaFactories.toString());
    _writeJ('EWT', javaStatics.toString());
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

  String genJavaStatics() {
    return javaStatics.toString();
  }

  void addRequiredType(DartType requiredType) {
    if (requiredType.isDartCoreObject || requiredType.isDartCoreList || isPrimitive(requiredType)) {
      return;
    }
    if (processed.contains(requiredType.element)) {
      return;
    }
    // if (requiredType.element is EnumElement) {
    //   requiredTypes.add(requiredType);
    // }
    // else if (requiredType.element is ClassElement) {
      requiredTypes.add(requiredType);
    // }
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
      {this.allTypes = false, String Function(ParameterElement) paramValue = _paramName, String Function(ParameterElement) escape = _paramName}) {
    var filtered = allTypes ? parameters : parameters.where((p) => generation.supportedType(p.type));
    names = filtered.map(paramValue).join(',\n      ');
    var mandatory = filtered.takeWhile((p) => p.isRequired);
    builderDecl = filtered.map((p) => '${paramDef(generation, p, annotated: mandatory.contains(p), wrap: p.isOptional)} ${escape(p)}').join(', ');
    decl = filtered.map((p) => '${paramDef(generation, p, wrap: p.isOptional)} ${escape(p)}').join(', ');
    // var mandatory = filtered.where((p) => p.isRequired);
    required = mandatory.map((p) => '${paramDef(generation, p)} ${paramValue(p)}').join(', ');
    requiredNames = mandatory.map(paramValue).join(', ');
  }

  static String paramDef4J(Generation generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type)}';
    if (wrap) {
      if (param.type.isDartCoreDouble) {
        t = 'OptionalDouble';
      }
      else if (param.type.isDartCoreInt) {
        t = 'OptionalInt';
      }
      else if (param.type.isDartCoreBool) {
        t = 'Optional<Boolean>';
      }
      else {
        t = 'Optional<$t>';
      }
    }
    return t;
  }

  static String paramDef4C(Generation generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4C(param.type)}';
    if (wrap && !param.type.isDartCoreString) {
      t = '$t*';
    }
    return t;
  }

  static String paramDef4D(Generation generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4D(param.type)}';
    if (wrap && !param.type.isDartCoreString) {
      t = 'ffi.Pointer<$t>';
    } else {
      if (t == 'ffi.Int' || t == 'ffi.Double') {
        t = t.substring(4).toLowerCase();
      }
      else if (t == 'DartObj') {
        t = 'DartDartObj';
      }
    }
    return t;
  }

  static String _paramName(ParameterElement param) => param.name;

  static String _escape4J(ParameterElement param) => (param.name == 'package') ? '_package' : param.name;

  static String paramValue4D(ParameterElement param) {
    final t = param.type;
    var value = param.name;
    if (t is InterfaceType) {
      if (param.isOptional) {
        if (t.isDartCoreString) {
          value = '${param.name}.strOrNul()';
        }
        else if (t.isDartCoreBool) {
          if (t.nullabilitySuffix == NullabilitySuffix.none) {
            value = '${param.name}.boolOr(${param.defaultValueCode})';
          } else {
            value = '${param.name}.boolOrNul()';
          }
        }
        else if (t.isDartCoreInt) {
          value = '${param.name}.intOrNul()';
        }
        else if (t.isDartCoreDouble) {
          if (t.nullabilitySuffix == NullabilitySuffix.none) {
            value = '${param.name}.doubleOr(${param.defaultValueCode})';
          } else {
            value = '${param.name}.doubleOrNul()';
          }
        }
        else if (t.isDartCoreList) {
          final arrayType = t.typeArguments[0];
          if (isPrimitive(arrayType)) {
            value = '${param.name}.orEmpty()';
          } else {
            value = '${param.name}.orEmpty()';
          }
        }
        else if (t.element is EnumElement) {
          if (t.nullabilitySuffix == NullabilitySuffix.none) {
            value = '${param.name}.enumOr(${t.element.name}.values, ${param.defaultValueCode})';
          } else {
            value = '${param.name}.enumOrNul(${t.element.name}.values)';
          }
        }
        else if (!isPrimitive(t)) {
          value = '${param.name}.objOrNul()';
        }
      } else {
        if (t.isDartCoreBool) {
          value = '${param.name}.toBool()';
        }
        else if (t.isDartCoreString) {
          value = '${param.name}.cast<Utf8>().toDartString()';
        }
        else if (!isPrimitive(t)) {
          value = '_widgetsMap[$value]! as $t';
        }
      }
    }
    else if (t is FunctionType) {
      value = '$value.asFunction()';
    }
    if (param.isNamed) {
      value = '${param.name}: $value';
    }
    return value;
  }

  static String paramValue4FFM(ParameterElement param) {
    final t = param.type;
    var value = _escape4J(param);
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
      else if (t.isDartCoreList) {
        final arrayType = (t as InterfaceType).typeArguments[0];
        if (arrayType.isDartCoreString) {
          value = 'ptrStrList($value)';
        } else {
          value = 'ptrList($value)';
        }
      }
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
      else if (t.element is EnumElement) {
        value = '$value.ordinal()';
      }
      else if (t is FunctionType) {
        return 'ptrFn($value)';
      }
      else if (!isPrimitive(t)) {
        value = '$value.getId()';
      }
    }
    return value;
  }
}

bool isPrimitive(DartType t) => t.isDartCoreString || t.isDartCoreBool || t.isDartCoreDouble || t.isDartCoreInt;

String _escape4J(String id) => switch (id) {
  'package' => 'package_',
  'public' => 'public_',
  _ => id
};

String _escape4D(String id) => switch (id) {
  'extension' => 'extension_',
  'factory' => 'factory_',
  'sync' => 'sync_',
  'package' => 'package_',
  'public' => 'public_',
  _ => id
};

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