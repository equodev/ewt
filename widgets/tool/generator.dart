import 'dart:io';
import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/src/dart/element/element.dart';
import 'package:analyzer/src/dart/element/type.dart';
import 'package:analyzer/src/generated/utilities_dart.dart';
import 'package:analyzer/src/utilities/extensions/string.dart';
import 'package:collection/collection.dart';
import 'package:ffi/ffi.dart';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

import 'gen/lang_writers.dart';

Future<void> main() async {
  var sw = Stopwatch()..start();
  var subclasses_widgets = await widgetsToGenerate('pregeneration_index.dart');
  print('-- Parse pregeneration_index.dart ${sw.elapsedReset}');
  PreGeneration(subclasses_widgets)
    ..gen()
    ..write();
  print('-- PreGeneration ${sw.elapsedReset}');

  var widgets = await widgetsToGenerate('generation_index.dart');
  print('-- Parse generation_index.dart ${sw.elapsedReset}');
  Generation(widgets)
    ..gen()
    ..write();
  print('-- Generation ${sw.elapsedReset}');
}

extension on Stopwatch {
  get elapsedReset {
    final e = elapsed;
    reset();
    return e;
  }
}

Future<Iterable<ClassElement>> widgetsToGenerate(String index_file) async {
  var index = path.absolute(path.join('tool', index_file));
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

class WidgetGen implements AGen {
  Generation generation;
  ClassElement dartClass;
  String widgetClass;
  String widgetField;
  StringBuffer javaFile = StringBuffer();
  StringBuffer headerFile = StringBuffer();
  StringBuffer objectsHFile = StringBuffer();
  StringBuffer dartAssigns = StringBuffer();
  StringBuffer dartFns = StringBuffer();
  StringBuffer javaFactories = StringBuffer();
  StringBuffer javaStatics = StringBuffer();

  bool isInterface = false;

  WidgetGen(this.generation, this.dartClass):
        widgetClass = dartClass.name,
        widgetField = '${dartClass.name[0].toLowerCase()}${dartClass.name.substring(1)}';

  String objType() => 'DartObj';

  @override
  String dartToC(String theVar) => '_addWidget($theVar)';

  void gen() {
    var constructors = dartClass.constructors.where((f) => f.isPublic);
    var consts = dartClass.fields.where((f) => f.isStatic && f.isConst && f.isPublic);
    var hasMembers = (!dartClass.isAbstract && constructors.isNotEmpty) /*|| (dartClass.isAbstract && consts.isNotEmpty)*/;
    writeHeaders(hasMembers);
    if (hasMembers) {
      dartAssigns.writeln('void _setup$widgetClass(WidgetFactories f) {');
    }
    writeJavaConstructors();
    if (!dartClass.isAbstract) {
      for (var constr in constructors) {
        writeFactory(constr);
      }
      for (var constr in dartClass.methods.where((m) => m.isStatic && m.isPublic && !isPrimitive(m.returnType) /*&& m.returnType == dartClass.thisType*/)) {
        writeFactory(constr);
      }
    }
    writeMembers();
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

  void writeJavaConstructors() {
    if (!isInterface) {
      javaFile
          .writeln('  $widgetClass() {}');
      javaFile..writeln('  $widgetClass(int id) {')..writeln(
          '    this.id = id;')..writeln('  }');
    }
  }

  String genJavaClass() {
    return javaFile.toString();
  }

  String genCFactories() {
    return headerFile.toString();
  }

  String genCObjects() {
    return objectsHFile.toString();
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
    isInterface = dartClass.isInterface || dartClass.isMixinClass || (dartClass.isAbstract && dartClass.interfaces.any((i) => i.element is ClassElement));
    var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    if (dartClass.supertype != null && !dartClass.supertype!.isDartCoreObject) {
      extend += ' extends ${dartClass.supertype!.element.name}${dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.map((p) => p.name).join(', ')}>' : ''}';
    }
    else {
      extend += ' extends ${!isInterface ? 'NativeObj.Base' : 'NativeObj'}';
    }
    var trulyInterfaces = dartClass.interfaces.where((i) =>
        i.interfaces.any((i) => i.element is ClassElement));
    if (trulyInterfaces.isNotEmpty) {
      extend += ' implements ${trulyInterfaces.map((i) => i.getDisplayString()).join(', ')}';
    }
    if (!dartClass.isAbstract) {
      javaFile
        ..writeln('import java.util.*;')
        ..writeln('import java.util.function.*;')
        ..writeln('import org.immutables.builder.Builder;');
    }
    writeJavaDecl(extend, isInterface);
    if (hasMembers) {
      headerFile
        .writeln('  struct ${widgetClass}St {');
    }
  }

  void writeJavaDecl(String extend, bool isInterface) {
    if (!dartClass.isAbstract) {
      javaFile
        .writeln('public class $widgetClass$extend {');
        // ..writeln('  static final WidgetConstructors factories = WidgetConstructors.instance;');
    } else {
      javaFile
        .writeln('public ${isInterface ? 'interface' : 'abstract class'} $widgetClass$extend {');
    }
  }

  void writeFooter(bool hasMembers) {
    javaFile.writeln('}');
    if (hasMembers) {
      headerFile.writeln('  } $widgetField;');
    }
  }

  void writeFactory(FunctionTypedElement node) {
    if (node.parameters.any((p) => p.isRequired && !generation.supportedType(p.type)) || !generation.supportedType(node.returnType)) {
      return;
    }
    String factory = (node.name!.isEmpty) ? widgetField : node.name!;
    String factoryName = '$widgetField${factory.firstUpper()}';
    String builderClass = '$widgetClass${factory.firstUpper()}Builder';
    writeJavaFactory(node, factoryName, builderClass, factory);
    // headerFile
      // .writeln("    int (*$factory)(${cParams.decl});");
    // CLang(generation).writeField(headerFile, factory, 'int', params: node.parameters);
    writeCFactory(factory, node, 'int');
    // var gen = generation.getGen(node.returnType.element!);
    // if (gen is WidgetGen) {
    //   gen.writeDFactory(factory, factoryName, node);
    //   dartAssigns.write(gen.dartAssigns);
    //   dartFns.write(gen.dartFns);
    // } else {
      writeDFactory(factory, factoryName, node);
    // }
  }

  void writeDFactory(String factory, String factoryName, FunctionTypedElement node) {
    var gen = generation.getGen(node.returnType.element!);
    //if (gen.objType() == 'DartObj')
    final dartParams = Params(generation, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName${gen.objType().endsWith('ObjSt') ? '' : ', exception'});');
    // dartFns
    //   ..writeln('int $factoryName(${dartParams.decl}) {')
    //   ..writeln('  final w = $widgetClass${node.name!.isEmpty ? '' : '.$factory'}(${dartParams.names});')
    //   ..writeln('  return ${node.returnType.element is EnumElement ? 'w.index' : '_addWidget(w)'};')
    //   ..writeln('}');
    dartFns
      ..writeln('${gen.objType() == 'DartObj' ? 'int' : gen.objType()} $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = $widgetClass${node.name!.isEmpty ? '' : '.$factory'}(${dartParams.names});');
    if (gen.objType().endsWith('ObjSt')) {
      dartFns.writeln('  return _create${gen.objType()}(w);');
    }
    else {
      dartFns.writeln('  return ${node.returnType.element is EnumElement ? 'w.index' : '_addWidget(w)'};');
    }
    dartFns .writeln('}');
  }

  void writeCFactory(String factory, FunctionTypedElement node, String retType) {
    headerFile.writeln('    ${CLang(generation).field(factory, generation.getGen(node.returnType.element!).objType(), params: node.parameters)}');
  }

  void writeJavaFactory(FunctionTypedElement node, String factoryName, String builderClass, String factory) {
    String builderFactory = factoryName;
    final jParams = Params(generation, node.parameters, Params.paramDef4J, paramValue: Params._escape4J, escape: Params._escape4J);
    final jParamsFFM = Params(generation, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4FFM, escape: Params._escape4J);
    if (node is ConstructorElement) {
      javaFile
        ..writeln('  @Builder.Factory')
        ..writeln('  static $widgetClass $factoryName(${jParams.builderDecl}) {');
    } else {
      javaFile
        .writeln('  public static ${generation.type4J(node.returnType)} $factory(${jParams.decl}) {');
    }
    var gen = generation.getGen(node.returnType.element!);
    if (gen is WidgetGen) {
      gen.writeJavaInstanceBody(factoryName, jParams, node);
      javaFile.write(gen.javaFile);
    } else {
      writeJavaInstanceBody(factoryName, jParams, node);
    }
    javaFile
      .writeln('  }');
    if (node is ConstructorElement) {
      javaFile
      ..writeln('  public static $builderClass $factory(${jParams.required}) {')
      ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
      ..writeln('  }');
    }
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
    if (node is ConstructorElement) {
      javaStatics
      ..writeln('  public static $builderClass $widgetClass${node.name!.isEmpty ? '' : '_$factory'}(${jParams.required}) {')
      ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
      ..writeln('  }');
    }
  }

  void writeJavaInstanceBody(String factoryName, Params jParams, FunctionTypedElement node) {
    javaFile
      ..writeln('    int id = factories.$factoryName(${jParams.names});')
      ..writeln('    if (id == -1) throw new RuntimeException("Failed to created widget ${node.returnType}");')
      ..writeln('    System.out.println("New ${node.returnType} id:"+id);')
      ..writeln('    return ${node.returnType.element is EnumElement ? '${generation.type4J(node.returnType)}.values()[id]' : 'new ${generation.type4J(node.returnType)}(id)'};');
  }

  void writeJavaFactoryMethod(String factoryName, Params jParams, String factory, Params jParamsFFM, FunctionTypedElement node) {
    var gen = generation.getGen(node.returnType.element!);
    javaFactories
      ..writeln('  ${gen.objType().endsWith('ObjSt') ? 'MemorySegment' : 'int'} $factoryName(${jParams.decl}) {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
      ..writeln('    return WidgetFactories.${widgetClass}St.$factory.invoke(${['fn${gen.objType().endsWith('ObjSt') ? ', arena' : ''}', jParamsFFM.names.nullIfEmpty].nonNulls.join(', ')});')
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
  }

  void writeMembers() {}

}

class ImmutableGen extends WidgetGen {
  String widgetSt;

  ImmutableGen(super.generation, super.dartClass):
    widgetSt = '${dartClass.name}ObjSt';

  @override
  String objType() => widgetSt;

  @override
  String dartToC(String theVar) => '_create$widgetSt($theVar)';

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    javaFile
      ..writeln('import java.lang.foreign.MemorySegment;')
      ..writeln('import dev.equo.ewt.ffm.$widgetSt;')
      ..writeln('import static dev.equo.ewt.WidgetConstructorsBase.*;');
    super.writeJavaDecl(extend, isInterface);
  }

  @override
  void writeJavaConstructors() {
    if (!isInterface) {
      javaFile
        ..writeln('  private MemorySegment st;');
      // javaFile
      //     .writeln('  $widgetClass() {}');
      // javaFile..writeln('  $widgetClass(int id) {')..writeln(
      //     '    this.id = id;')..writeln('  }');
      javaFile
        ..writeln('  $widgetClass(MemorySegment st) {')
        ..writeln('    this.id = $widgetSt.id(st);')
        ..writeln('    this.st = st;')
        ..writeln('    System.out.println("New $widgetClass id:"+id);')
        ..writeln('  }');
    }
  }

  @override
  void writeJavaInstanceBody(String factoryName, Params jParams, FunctionTypedElement node) {
    if (node.returnType.element is EnumElement) {
      super.writeJavaInstanceBody(factoryName, jParams, node);
      return;
    }
    javaFile
      ..writeln('    var st = factories.$factoryName(${jParams.names});')
      ..writeln('    if (st == null) throw new RuntimeException("Failed to created widget $widgetClass");')
      // ..writeln('    id = $widgetSt.id(st);')
      ..writeln('    return new ${generation.type4J(node.returnType)}(st);');
  }

  @override
  void writeJavaFactoryMethod(String factoryName, Params jParams, String factory, Params jParamsFFM, FunctionTypedElement node) {
    if (node.returnType.element is EnumElement) {
      super.writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
      return;
    }
    javaFactories
      ..writeln('  MemorySegment $factoryName(${jParams.decl}) {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
      ..writeln('    return WidgetFactories.${widgetClass}St.$factory.invoke(fn, arena, ${jParamsFFM.names});')
      ..writeln('  }');
  }

  // @override
  // void writeCFactory(String factory, FunctionTypedElement node, String retType) {
  //   super.writeCFactory(factory, node, generation.getGen(node.returnType.element!).objType());
  // }

  // @override
  // void writeDFactory(String factory, String factoryName, FunctionTypedElement node) {
  //   if (node.returnType != dartClass.thisType) {
  //     super.writeDFactory(factory, factoryName, node);
  //     return;
  //   }
  //   final dartParams = Params(generation, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
  //   dartAssigns
  //       .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName);');
  //   dartFns
  //     ..writeln('$widgetSt $factoryName(${dartParams.decl}) {')
  //     ..writeln('  final w = $widgetClass${node.name!.isEmpty ? '' : '.$factory'}(${dartParams.names});')
  //     ..writeln('  return _create$widgetSt(w);')
  //     ..writeln('}');
  // }

  @override
  void writeMembers() {
    objectsHFile.writeln('typedef struct {');
    objectsHFile.writeln('  ${CLang(generation).field('id', 'int')}');
    for (final field in callableFields()) {
      objectsHFile.writeln('  ${CLang(generation).field(field.name, generation.type4C(field.type))}');
      javaFile
        ..writeln('  public ${generation.type4J(field.type)} ${field.name}() {')
        ..writeln('    ${generation.type4J(field.type)} fld = ${Params.paramValueFFMtoJ(ParameterElementImpl.synthetic('$widgetSt.${field.name}(st)', field.type, field.type.nullabilitySuffix == NullabilitySuffix.question ? ParameterKind.POSITIONAL : ParameterKind.REQUIRED))};')
        ..writeln('    return fld;')
        ..writeln('  }');
    }
    objectsHFile.writeln('} $widgetSt;');

    dartFns
      ..writeln('$widgetSt _create$widgetSt($widgetClass w) {')
      ..writeln('  final $widgetSt stObj = ffi.Struct.create();')
      ..writeln('  stObj.id = _addWidget(w);');
    for (var m in callableFields()) {
      dartFns
          .writeln('  stObj.${m.name} = ${Params.paramValueDtoC(generation, ParameterElementImpl.synthetic('w.${m.name}', m.type, m.type.nullabilitySuffix == NullabilitySuffix.question ? ParameterKind.NAMED : ParameterKind.REQUIRED))};');
    }
    dartFns
      ..writeln('  return stObj;')
      ..writeln('}');
  }

  Iterable<FieldElement> callableFields() => dartClass.fields.where((f) => !f.getter!.hasOverride && f.isPublic && generation.supportedType(f.type));
}

class SubclassGen extends WidgetGen {
  String widgetSt;

  SubclassGen(super.generation, super.dartClass) :
    // super.widgetClass = widgetClass.substring(3);
    widgetSt = '${dartClass.name}ObjSt';

  @override
  String objType() => widgetSt;

  @override
  String dartToC(String theVar) => '_create$widgetSt($theVar)';

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    javaFile
        ..writeln('import java.lang.foreign.MemorySegment;')
        ..writeln('import dev.equo.ewt.ffm.$widgetSt;')
        ..writeln('public abstract class $widgetClass$extend {');
  }

  @override
  void writeJavaConstructors() {
  }

  @override
  void writeMembers() {
    for (final method in dartClass.supertype!.element.methods.where((m) => m.isAbstract)) {
      // javaFile.writeln('  protected abstract $method;');
      var returnType = method.returnType;
      var ret = '${method.returnType}';
      if (returnType is InterfaceType && returnType.typeArguments.isNotEmpty) {
        ret = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
      }
      final jParams = Params(generation, method.parameters, Params.paramDef4J, paramValue: Params._escape4J, escape: Params._escape4J);
      javaFile.writeln('  protected abstract ${ret} ${method.name}(${jParams.decl});');
    }
    objectsHFile.writeln('typedef struct {');
    // objectsHFile.writeln('  int id;');
    objectsHFile.writeln('  ${CLang(generation).field('id', 'int')}');
    for (final method in callableMethods()) {
      // final cParams = Params(generation, method.parameters, Params.paramDef4C);
      // objectsHFile.writeln('  ${method.returnType} (*${method.name})(${cParams.decl});');
      objectsHFile.writeln('  ${CLang(generation).field(method.name, '${method.returnType}', params: method.parameters)}');
      // CLang(generation).writeField(objectsHFile, method.name, '${method.returnType}', params: method.parameters);
      final jParams = Params(generation, method.parameters, Params.paramDef4J, paramValue: Params.paramValue4FFM, escape: Params._escape4J);
      javaFile
        ..writeln('  protected ${method.returnType} ${method.name}(${jParams.decl}) {')
        ..writeln('    MemorySegment funcPtr = $widgetSt.${method.name}(st);')
        ..writeln('    $widgetSt.${method.name}.invoke(funcPtr, factories.${jParams.names});')
        ..writeln('  }');
    }
    objectsHFile.writeln('} $widgetSt;');
  }

  Iterable<MethodElement> callableMethods() => dartClass.supertype!.element.methods.where((m) => !m.isAbstract && m.hasProtected && !m.hasMustCallSuper);

  @override
  void writeJavaFactory(FunctionTypedElement node, String factoryName, String builderClass, String factory) {
    final fnParams = Params(generation, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4JCallback, escape: Params._escape4J);
    final jParams = Params(generation, node.parameters, Params.paramDef4J, paramValue: Params._escape4J, escape: Params._escape4J);
    final jParamsFFM = Params(generation, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4FFM, escape: Params._escape4J);
    javaFile
      ..writeln('  private final MemorySegment st;')
      ..writeln('  protected $widgetClass() {')
      ..writeln('    st = factories.$factoryName(${fnParams.names});')
      ..writeln('    if (st == null) throw new RuntimeException("Failed to created widget $widgetClass");')
      ..writeln('    id = $widgetSt.id(st);')
      ..writeln('    System.out.println("New $widgetClass id:"+id);')
      ..writeln('  }');
    javaFactories
      ..writeln('  MemorySegment $factoryName(${jParams.decl}) {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
      ..writeln('    return WidgetFactories.${widgetClass}St.$factory.invoke(fn, arena, ${jParamsFFM.names});')
      ..writeln('  }');
  }

  // @override
  // void writeCFactory(String factory, FunctionTypedElement node, String retType) {
  //   super.writeCFactory(factory, node, widgetSt);
  // }

  @override
  void writeDFactory(String factory, String factoryName, FunctionTypedElement node) {
    final dartParams = Params(generation, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName);');
    dartFns
      ..writeln('$widgetSt $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = ${node.displayName}(${dartParams.names});')
      ..writeln('  final $widgetSt stObj = ffi.Struct.create();')
      ..writeln('  stObj.id = _addWidget(w);');
    for (var m in callableMethods()) {
      dartFns // todo derive types from method
        ..writeln('  final ${m.name}Fn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.isolateLocal((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.${m.name}(cb.asFunction()));')
        ..writeln('  stObj.${m.name} = ${m.name}Fn.nativeFunction;');
    }
    dartFns
      ..writeln('  return stObj;')
      ..writeln('}');
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

class EnumGen implements AGen {
  Generation generation;
  EnumElement enumType;
  StringBuffer javaFile = StringBuffer();

  EnumGen(this.generation, this.enumType);

  @override
  String objType() => 'int';

  @override
  String dartToC(String theVar) => '$theVar.index';

  @override
  void gen() {
    genJavaClass();
  }

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

mixin AGen {
  String objType();
  void gen();

  String dartToC(String value);
}

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


  PreGeneration(Iterable<ClassElement> widgets)
      :
        // widgetElement = widgets.firstOrNull,
        widgets = widgets;

  void gen() {
    dartSubclasses.writeln('import \'package:flutter/widgets.dart\';');
    // dartSubclasses.writeln('typedef CreateStateFn = State<StatefulWidget> Function();');
    for (final widget in widgets) {
      final clazz = DartSubclassGen(this, widget)
          ..gen();
      dartSubclasses.writeln(clazz.genDartClass());
    }
  }
  void write() {
    _writeD('subwidgets.dart', dartSubclasses.toString());
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

  void gen() {
    final typeParam = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    dartSubclass
      .writeln('class $widgetClass$typeParam extends ${dartClass.name} {');
    final methods = dartClass.methods.where((m) => m.isAbstract);
    for (final method in methods) {
      dartSubclass.writeln('  final ${method.type} ${method.name}Fn;');
    }
    var params = dartClass.constructors.first.parameters.map((p) => '${p is SuperFormalParameterElement ? 'super.' : 'this.'}${p.name}').toList();
    var overrideable = methods.map((m) => 'required this.${m.name}Fn').toList();
    dartSubclass
      .writeln('  $widgetClass({${(params+overrideable).join(', ')}});');
    for (final method in methods) {
      dartSubclass.writeln('  @override');
      dartSubclass.writeln('  $method => ${method.name}Fn(${method.parameters.map((p) => p.name).join(', ')});');
    }
    dartSubclass
      .writeln('}');
  }

  String genDartClass() {
    return dartSubclass.toString();
  }
}

class Generation {
  Set<DartType> requiredTypes = {};
  Set<TypeAliasElement> typeDefs = {};
  Set<Element> processed = {};
  StringBuffer headerFile = StringBuffer();
  StringBuffer objectsHFile = StringBuffer();
  StringBuffer typedefFile = StringBuffer();
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
      ..writeln('import java.util.function.*;')
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
      ..writeln('ffi.Pointer<WidgetFactories> _setupFactories() {')
      // ..writeln('  final WidgetFactories f = ffi.Struct.create();');
      ..writeln('  final ffi.Pointer<WidgetFactories> fp = calloc<WidgetFactories>();')
      ..writeln('  final f = fp.ref;');

    for (var dartClass in widgets.where((t) => !t.isAbstract)) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    for (var dartClass in requiredTypes.map((t) => t.element).whereType<ClassElement>().where((t) => !t.isAbstract)) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    requiredTypes.clear();

    dartFactories.writeln('  return fp;');
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

    for (var td in typeDefs) {
      var aliasedType = td.aliasedType;
      var name = '${td.name}FFI';
      if (aliasedType is FunctionType) {
        typedefFile.writeln('typedef ${CLang(this).field(name, type4C(aliasedType.returnType), params: aliasedType.parameters)}');
        if (!aliasedType.parameters.any((p) => p.type.isDartCoreBool || !isPrimitive(p.type))) { // we need to wrap from int to bool
          dartFactories.writeln(
                  'extension on ${name} {\n'
                  '  ${td.name} toFn() {\n'
                  '    return asFunction();\n'
                  '  }\n'
                  '}\n'
                  'extension on ffi.Pointer<${name}> {\n'
                  '  ${td.name}? toFn() {\n'
                  '    if (this != ffi.nullptr) {\n'
                  '      return this.value.toFn();\n'
                  '    }\n'
                  '    return null;\n'
                  '  }\n'
                  '}\n');
        }
      } else {
        typedefFile.writeln('typedef $aliasedType ${name}');
      }
    }
  }

  Set<DartType> unsupportedTypes = {};

  bool supportedType(DartType t) {
    if (t.isDartCoreEnum || isPrimitive(t)) {
      return true;
    }
    if (t.element is EnumElement) {
      return true;
    }
    if (t.isDartCoreList && supportedType((t as InterfaceType).typeArguments[0])) {
      return true;
    }
    if (t is FunctionType) {
      return (t.parameters.isEmpty || t.parameters.every((p) => supportedType(p.type))) && (t.returnType is VoidType || supportedType(t.returnType));
    }
    if (/*['InlineSpan', 'ThemeData', 'Color', 'ColorScheme'].contains(t.getDisplayString(withNullability: false))
        ||*/ isWidget(t.element) || widgets.contains(t.element) || widgets.any((w) => isSubtype(w, t.element))) {
      return true;
    }
    unsupportedTypes.add(t);
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

  bool isSubtype(ClassElement subType, Element? superType) {
    if (subType == superType) {
      return true;
    }
    if (superType is InterfaceElement) {
      return subType.allSupertypes.map((s) => s.element).contains(superType);
    }
    return false;
  }

  void processWidget(ClassElement dartClass) {
    if (processed.contains(dartClass)) {
      return;
    }
    processed.add(dartClass.thisType.element);
    var widGen = (getGen(dartClass) as WidgetGen)..gen()
    // var widGen = WidgetGen(this, dartClass)
      ..genJavaClass()..write();
    if (widGen.genCFactories().isNotEmpty) {
      headerFile.writeln(widGen.genCFactories());
    }
    if (widGen.genCObjects().isNotEmpty) {
      objectsHFile.writeln(widGen.genCObjects());
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

  AGen getGen(Element dartClass) {
    if (dartClass is ClassElement) {
      if (dartClass.name.startsWith('Sub')) {
        return SubclassGen(this, dartClass);
      }
      else if (dartClass.hasImmutable && !dartClass.isAbstract) {
        return ImmutableGen(this, dartClass);
      }
      else {
        return WidgetGen(this, dartClass);
      }
    }
    else if (dartClass is EnumElement) {
      return EnumGen(this, dartClass);
    }
    throw UnsupportedError('No AGen for $dartClass');
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
      else if (namedType.isDartCoreObject) {
        return 'NativeObj';
      }
      return namedType.element.name;
    }
    else if (namedType is FunctionType) {
      var params = namedType.parameters.map((p) => type4J(p.type).firstUpper()).join(', ');
      if (namedType.returnType is VoidType) {
        if (namedType.parameters.isEmpty) {
          return 'Runnable';
        }
        return 'Consumer<${params}>';
      } else {
        var retType4j = type4J(namedType.returnType);
        if (namedType.parameters.isEmpty) {
          return 'Supplier<${retType4j}>';
        }
        final arity = switch(namedType.parameters.length) {
          1 => '',
          2 => 'Bi',
          var i => throw 'Unsupported $i args function',
        };
        return '${arity}Function<$params, $retType4j>';
      }
    }
    return namedType.toString();
  }

  String type4C(DartType namedType) {
    if (namedType is VoidType) {
      return 'void';
    }
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
      if (namedType.alias != null) {
        addTypeDef(namedType.alias!.element);
        return '${namedType.alias!.element.name}FFI';
      }
      final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
      return '${cbRet}Callback${namedType.parameters.map((p) => type4C(p.type)).join(', ')}';
    }
    else if (!isPrimitive(namedType)) {
      return getGen(namedType.element!).objType(); //'DartObj'; // object are passes as ids or structs
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
        if (namedType.alias != null) {
          return '${namedType.alias!.element.name}FFI';
        }
        final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
        return '${cbRet}Callback${namedType.parameters.map((p) => type4C(p.type)).join(', ')}';
      }
      else if (!isPrimitive(namedType)) {
        return getGen(namedType.element!).objType();// 'DartObj';
      }
      throw UnsupportedError('Unsupported type $namedType');
    // }
    return namedType.toString();
  }

  void write() {
    _writeC('factories.h', headerFile.toString());
    _writeC('objects.h', objectsHFile.toString());
    _writeC('typedefs.h', typedefFile.toString());
    _writeD('factories_gen.dart', dartFactories.toString());
    _writeJ('WidgetConstructors', javaFactories.toString());
    _writeJ('EWT', javaStatics.toString());

    for (var t in unsupportedTypes) {
      print('Unsupported type $t');
    }
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

  void addTypeDef(TypeAliasElement element) {
    typeDefs.add(element);
  }

}

class Params {
  Generation generation;
  List<ParameterElement> parameters;

  late String names = "";
  late String builderDecl = "";
  late String decl = "";
  late String required = "";
  late String requiredNames = "";
  bool allTypes;

  Params(this.generation, this.parameters,
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
    if (t.endsWith('ObjSt')) {
      t = 'DartObj';
    }
    if (wrap && !param.type.isDartCoreString) {
      t = '$t*';
    }
    return t;
  }

  static String paramDef4D(Generation generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4D(param.type)}';
    if (wrap && !param.type.isDartCoreString) {
      if (t.endsWith('ObjSt')) {
        t = 'DartObj';
      }
      t = 'ffi.Pointer<$t>';
    } else {
      if (t == 'ffi.Int' || t == 'ffi.Double') {
        t = t.substring(4).toLowerCase();
      }
      else if (t == 'DartObj' || t.endsWith('ObjSt')) {
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
      value = '$value.toFn()';
    }
    if (param.isNamed) {
      value = '${param.name}: $value';
    }
    return value;
  }

  static String paramValueDtoC(Generation ctx, ParameterElement param) {
    final t = param.type;
    var value = param.name;
    if (t is InterfaceType) {
      // if (param.isOptional) {
      //   value = '$value?';
      // }
        // if (t.isDartCoreString) {
        //   value = '${param.name}.strOrNul()';
        // }
        // else if (t.isDartCoreBool) {
        //   if (t.nullabilitySuffix == NullabilitySuffix.none) {
        //     value = '${param.name}.boolOr(${param.defaultValueCode})';
        //   } else {
        //     value = '${param.name}.boolOrNul()';
        //   }
        // }
        // else if (t.isDartCoreInt) {
        //   value = '${param.name}.intOrNul()';
        // }
        // else if (t.isDartCoreDouble) {
        //   if (t.nullabilitySuffix == NullabilitySuffix.none) {
        //     value = '${param.name}.doubleOr(${param.defaultValueCode})';
        //   } else {
        //     value = '${param.name}.doubleOrNul()';
        //   }
        // }
        // else if (t.isDartCoreList) {
        //   final arrayType = t.typeArguments[0];
        //   if (isPrimitive(arrayType)) {
        //     value = '${param.name}.orEmpty()';
        //   } else {
        //     value = '${param.name}.orEmpty()';
        //   }
        // }
        // else if (t.element is EnumElement) {
        //   if (t.nullabilitySuffix == NullabilitySuffix.none) {
        //     value = '${param.name}.enumOr(${t.element.name}.values, ${param.defaultValueCode})';
        //   } else {
        //     value = '${param.name}.enumOrNul(${t.element.name}.values)';
        //   }
        // }
        // else if (!isPrimitive(t)) {
        //   value = '${param.name}.objOrNul()';
        // }
      // } else {
        if (param.isOptional) {
          value = '$value!';
        }

        if (t.isDartCoreBool) {
          value = '$value.toInt()';
        }
        else if (t.isDartCoreString) {
        //   value = '${param.name}.cast<Utf8>().toDartString()';
          value = '$value.toNativeUtf8().cast<ffi.Char>()';
        }
        else if (t.isDartCoreList) {
          final arrayType = t.typeArguments[0];
          if (isPrimitive(arrayType)) {
            value = '$value.strListToC()';
          } else {
            value = '$value.toArrayC()';
          }
        }
        else if (t.element is EnumElement) {
          value = '$value.index';
        }
        else if (!isPrimitive(t)) {
          value = ctx.getGen(t.element).dartToC(value);
          // value = '${param.name}.hashCode';
        }

        if (param.isOptional) {
          value = '(${param.name} != null) ? $value : ffi.nullptr';
        }
      // }
    }
    // else if (t is FunctionType) {
    //   value = '$value.toFn()';
    // }
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
      else if (t is FunctionType) {
        // final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
        if (t.alias != null) {
          String functional;
          if (t.returnType is VoidType) {
            // if (t.parameters.isEmpty) {
            //   return '${t.alias!.element.name}.allocate(ptrRun($value)';
            // }
            functional = t.parameters.isEmpty ? 'run' : 'accept';
            // return 'ptrConsumer($value)';
          } else {
            functional = t.parameters.isEmpty ? 'get' : 'apply';
            // return 'ptrSupplier($value)';
          }
          final parameters = t.parameters;
          final names = parameters.map(_escape4J).join(', ');
          final values = parameters.map((p) => paramValueFFMtoJ(p)).join(', ');
          // final decl = filtered.map((p) => '${paramDef(generation, p, wrap: p.isOptional)} ${escape(p)}').join(', ');
          var lambda = '$value.get().$functional($values)';
          if (t.returnType is! VoidType) {
            lambda = paramValue4FFM(ParameterElementImpl.synthetic(lambda, t.returnType, ParameterKind.REQUIRED));
          }
          final allocateCB = '${t.alias!.element.name}FFI.allocate(($names) -> $lambda, arena)';
          value = '$value.isPresent() ? $allocateCB : MemorySegment.NULL';
          return value;
          // return '$value.isPresent() ? ${t.alias!.element.name}.allocate(() -> $value.get()) : MemorySegment.NULL';
        }
        return 'ptrFn($value)';
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
        // final cbRet = (namedType.returnType is VoidType) ? 'Void' : type4C(namedType.returnType);
        return 'ptrFn($value)';
      }
      else if (!isPrimitive(t)) {
        value = '$value.getId()';
      }
    }
    return value;
  }

  static String paramValue4JCallback(ParameterElement param) {
    final t = param.type;
    var value = _escape4J(param);
    if (t is FunctionType) {
      return 'this::${value.removeSuffix('Fn')}';
    }
    return value;
  }

  static String paramValueFFMtoJ(ParameterElement param) {
    final t = param.type;
    var value = _escape4J(param);
    if (t.isDartCoreBool) {
      return 'intToBool($value)';
    }
    else if (t.isDartCoreString) {
      return '$value.getString(0)';
    }
    else if (t.element is EnumElement) {
      value = '${t.element!.name}.values()[$value]';
    }
    else if (t.isDartCoreList) {
      final arrayType = (t as InterfaceType).typeArguments[0];
      if (arrayType.isDartCoreString) {
        return 'memToStrList($value)';
      } else {
        // value = 'ptrList($value)';
      }
    }
    else if (!isPrimitive(t) && t.element is! EnumElement && t is! FunctionType && !t.isDartCoreList) {
      return 'new ${t.element!.name}($value) {}';
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