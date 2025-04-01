import 'dart:io';

import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
import 'package:analyzer/src/dart/element/element.dart';
import 'package:analyzer/src/generated/utilities_dart.dart';
import 'package:analyzer/src/utilities/extensions/string.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/element/nullability_suffix.dart';
import 'package:generator/gen.dart';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

import 'lang_writers.dart';
import 'types.dart';

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


  PreGeneration(this.widgets);

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
    _writeDCopy('subwidgets.dart', dartSubclasses.toString());
  }

}

class WidgetGen implements AGen {
  Types generation;
  ClassElement dartClass;
  String widgetClass;
  String widgetField;
  StringBuffer javaFile = StringBuffer();
  StringBuffer builderFile = StringBuffer();
  StringBuffer headerFile = StringBuffer();
  StringBuffer objectsHFile = StringBuffer();
  StringBuffer dartAssigns = StringBuffer();
  StringBuffer dartFns = StringBuffer();
  StringBuffer javaFactories = StringBuffer();
  StringBuffer javaStatics = StringBuffer();

  bool _isInterface = false;

  WidgetGen(this.generation, this.dartClass):
        widgetClass = dartClass.name,
        widgetField = '${dartClass.name[0].toLowerCase()}${dartClass.name.substring(1)}';

  String objType() => 'DartObj';

  @override
  String dartToC(String theVar) => '_addWidget($theVar)';

  @override
  void gen() {
    var constructors = dartClass.constructors.where((f) => f.isPublic);
    var consts = dartClass.fields.where((f) => f.isStatic && f.isConst);
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
      var c=1;
      for (var constr in consts.whereType<ConstFieldElementImpl>()) {
        writeConst(constr, c++);
      }
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
    if (!_isInterface) {
      javaFile
          .writeln('  protected $widgetClass() {}');
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
    _writeJ('${widgetClass}I', builderFile.toString());
  }

  void writeHeaders(bool hasMembers) {
    javaFile
        .writeln('package dev.equo.ewt;');
    _isInterface = isInterface(dartClass);
    var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    var builderExtend = '';
    if (dartClass.supertype != null && !dartClass.supertype!.isDartCoreObject) {
      extend += ' extends ${dartClass.supertype!.element.name}${dartClass.supertype is TypeParameterizedElement && (dartClass.supertype as TypeParameterizedElement).typeParameters.isNotEmpty ? '<${dartClass.typeParameters.map((p) => p.name).join(', ')}>' : ''}';
      builderExtend = ' extends ${dartClass.supertype!.element.name}I';
    }
    else {
      extend += ' extends ${!_isInterface ? 'NativeObj.Base' : 'NativeObj, ${widgetClass}I'}';
      builderExtend = ' extends NativeObj.I';
    }
    var trulyInterfaces = dartClass.interfaces.where((i) =>
        i.interfaces.any((i) => i.element is ClassElement)).toList();
    if (trulyInterfaces.isNotEmpty) {
      extend += ' implements ${trulyInterfaces.map((i) => i.getDisplayString()).join(', ')}, ${widgetClass}I';
      builderExtend += ', ${trulyInterfaces.map((i) => '${i.getDisplayString()}I').join(', ')}';
    } else if (!_isInterface) {
      extend += ' implements ${widgetClass}I';
    } if (!dartClass.isAbstract) {
      javaFile
        ..writeln('import java.util.*;')
        ..writeln('import java.util.function.*;')
        ..writeln('import org.immutables.builder.Builder;');
    } else {
      javaFile
        .writeln('import java.util.*;');
    }
    writeJavaDecl(extend, _isInterface);
    if (hasMembers) {
      headerFile
          .writeln('  struct ${widgetClass}St {');
    }

    builderFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('public interface ${widgetClass}I$builderExtend {\n'
          '  @Override\n'
          '  $widgetClass build();\n'
          '}');
    javaFile
        .writeln('  @Override\n'
        '  ${_isInterface ? 'default' : 'public'} $widgetClass build() {\n'
        '    return this;\n'
        '  }')
    ;
  }

  bool isInterface(Element? dartClass) => dartClass is ClassElement && (dartClass.isInterface || dartClass.isMixinClass || (dartClass.isAbstract && dartClass.interfaces.any((i) => i.element is ClassElement)));

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
    var nullabilitySuffix = node.returnType.nullabilitySuffix == NullabilitySuffix.question ? '?' : '' ;
    dartFns
      ..writeln('${gen.objType() == 'DartObj' ? 'int' : '${gen.objType()}$nullabilitySuffix'} $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = $widgetClass${node.name!.isEmpty ? '' : '.$factory'}(${dartParams.names});');
    if (gen.objType().endsWith('ObjSt')) {
      if (node.returnType.nullabilitySuffix == NullabilitySuffix.question) {
        dartFns.writeln('  return w != null ? _create${gen.objType()}(w) : null;');
      } else {
        dartFns.writeln('  return _create${gen.objType()}(w);');
      }
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
    final jParamsDecl = Params(generation, node.parameters, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params._escape4J);
    final jParamsFFM = Params(generation, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4FFM, escape: Params._escape4J);
    if (node is ConstructorElement) {
      javaFile
        ..writeln('  @Builder.Factory')
        ..writeln('  static $widgetClass $factoryName(${jParamsDecl.builderDecl}) {');
    } else {
      javaFile
          .writeln('  public static ${generation.type4J(node.returnType)} $factory(${jParamsDecl.decl}) {');
    }
    var gen = generation.getGen(node.returnType.element!);
    if (gen is WidgetGen) {
      gen.writeJavaInstanceBody(factoryName, jParamsDecl, node);
      javaFile.write(gen.javaFile);
    } else {
      writeJavaInstanceBody(factoryName, jParamsDecl, node);
    }
    javaFile
        .writeln('  }');
    if (node is ConstructorElement) {
      javaFile
        ..writeln('  public static $builderClass $factory(${jParamsDecl.required}) {')
        ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
        ..writeln('  }');
    }
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
    if (node is ConstructorElement) {
      javaStatics
        ..writeln('  public static $builderClass $widgetClass${node.name.isEmpty ? '' : '_$factory'}(${jParamsDecl.required}) {')
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
    String factory = _escape4D(fld.name);
    var initializer = fld.constantInitializer;
    javaFile
      .writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
    if (initializer is InstanceCreationExpression) {
      // var nodeList = (initializer as InstanceCreationExpression).argumentList.arguments;
      // var requiredArgs = nodeList
      //     .where((a) => a.correspondingParameter!.isRequiredPositional)
      //     .map((a) => a.unParenthesized)
      //     .map((e) => dartExptrToJava(e))
      //     .join(', ');
      // var otherArgs = nodeList
      //     .whereType<NamedExpression>()
      //     .map((a) => '.${a.name.label}(${a.expression.toString().replaceAll('\'', '"')})')
      //     .join('');
      // var widgetInstance = '${fld.type}.${fld.type.toString().firstLower()}($requiredArgs)$otherArgs.build();';

      javaFile
        .writeln('    return ${dartExptrToJava(initializer as Expression)};');
    }
    else if (initializer is ListLiteral) {
      javaFile
        .writeln('    return List.of(${(initializer as ListLiteral).elements.map((e) => '$e()').join(', ')});');
    }
    else {
      javaFile
          .writeln('    return $initializer;');
    }
    javaFile
      .writeln('  }');
  }

  void writeMembers() {}

  String dartExptrToJava(Expression e) {
    if (e is InstanceCreationExpression) {
      var nodeList = e.argumentList.arguments;
      var requiredArgs = nodeList
          .where((a) => a.correspondingParameter!.isRequiredPositional)
          .map((a) => a.unParenthesized)
          .map((e) => dartExptrToJava(e))
          .join(', ');
      var otherArgs = nodeList
          .whereType<NamedExpression>()
          .map((a) => '.${a.name.label}(${a.expression.toString().replaceAll(
          '\'', '"')})')
          .join('');
      return '${e.constructorName}.${e.constructorName.toString().firstLower()}($requiredArgs)$otherArgs.build()';
    }
    else if (e is SetOrMapLiteral) {
      return 'Map.ofEntries(${e.elements.whereType<MapLiteralEntry>().map((e) => 'Map.entry(${e.key}, ${dartExptrToJava(e.value)})').join(', ')})';
    }
    else if (e is SimpleIdentifier) {
      return '$e()';
    }
    return e.toString();
  }

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
    if (!_isInterface) {
      javaFile
          .writeln('  private MemorySegment st;');
      javaFile
          .writeln('  protected $widgetClass() {}');
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
  void writeMembers() {
    objectsHFile.writeln('typedef struct {');
    objectsHFile.writeln('  ${CLang(generation).field('id', 'int')}');
    for (final field in callableFields()) {
      objectsHFile.writeln('  ${CLang(generation).field(field.name, generation.type4C(field.type))}');
      javaFile
        ..writeln('  public ${generation.type4J(field.type)} ${field.name}() {')
        ..writeln('    return ${Params.paramValueFFMtoJ(ParameterElementImpl.synthetic('$widgetSt.${field.name}(st)', field.type, field.type.nullabilitySuffix == NullabilitySuffix.question ? ParameterKind.POSITIONAL : ParameterKind.REQUIRED))};')
        ..writeln('  }');
    }
    objectsHFile.writeln('} $widgetSt;');

    dartFns
      ..writeln('$widgetSt _create$widgetSt($widgetClass? w) {')
      ..writeln('  final $widgetSt stObj = ffi.Struct.create();')
      ..writeln('  stObj.id = _addWidget(w);')
      ..writeln('  if (w == null) return stObj;');
    for (var m in callableFields()) {
      dartFns
          .writeln('  stObj.${m.name} = ${Params.paramValueDtoC(generation, ParameterElementImpl.synthetic('w.${m.name}', m.type, m.type.nullabilitySuffix == NullabilitySuffix.question ? ParameterKind.NAMED : ParameterKind.REQUIRED))};');
    }
    dartFns
      ..writeln('  return stObj;')
      ..writeln('}');
  }

  Iterable<FieldElement> callableFields() =>
      dartClass.fields
          .where((f) =>
      !f.getter!.hasOverride && f.isPublic
          && f.type is! FunctionType && !f.type.isDartCoreList && !f.type.isDartCoreObject
          && !isInterface(f.type.element) && generation.supportedType(f.type));

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
      var retBuilder = generation.widgets.any((w) => w.name  == 'Sub${returnType.element!.name}') ? ret : '${method.returnType}I';
      if (returnType is InterfaceType && returnType.typeArguments.isNotEmpty) {
        ret = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
        retBuilder = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
      }
      final jParams = Params(generation, method.parameters, Params.paramDef4J, paramValue: Params.paramValue4JBuilder, escape: Params._escape4J);
      javaFile.writeln('  protected abstract ${retBuilder} ${method.name}(${jParams.decl});');
      javaFile.writeln('  ${ret} ${method.name}Fn(${jParams.decl}) {\n'
          '    return ${method.name}(${jParams.names}).build();\n'
          '  }');
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

class EnumGen implements AGen {
  Types generation;
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
    javaFile.writeln(enumType.fields.map((en) => _escape4D(en.name)).where((en) => "values" != en).join(', '));
    javaFile.writeln('}');
    return javaFile.toString();
  }

  void write() {
    _writeJ(enumType.name, javaFile.toString());
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
  Set<Element> processed = {};
  StringBuffer headerFile = StringBuffer();
  StringBuffer objectsHFile = StringBuffer();
  StringBuffer typedefFile = StringBuffer();
  StringBuffer dartFactories = StringBuffer();
  StringBuffer javaFactories = StringBuffer();
  StringBuffer javaStatics = StringBuffer();

  Iterable<ClassElement> widgets;
  Types types;

  Generation(Iterable<ClassElement> widgets) :
        widgets = widgets.skip(1),
        types = Types(widgets);

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
      ..writeln('import java.util.Map;')
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
      ..writeln('import java.util.Map;')
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
    for (var dartClass in types.requiredTypes.map((t) => t.element).whereType<ClassElement>().where((t) => !t.isAbstract).where((t) => !widgets.contains(t))) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    types.requiredTypes.clear();

    dartFactories.writeln('  return fp;');
    dartFactories.writeln('}');

    headerFile.writeln('} WidgetFactories;');

    javaFactories.writeln('}');
    javaStatics.writeln('}');

    for (var td in types.typeDefs) {
      var aliasedType = td.aliasedType;
      var name = '${td.name}FFI';
      if (aliasedType is FunctionType) {
        typedefFile.writeln('typedef ${CLang(types).field(name, types.type4C(aliasedType.returnType), params: aliasedType.parameters)}');
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

  void processWidget(ClassElement dartClass) {
    if (processed.contains(dartClass)) {
      return;
    }
    processed.add(dartClass.thisType.element);
    var widGen = (types.getGen(dartClass) as WidgetGen)..gen()
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

    for (DartType requiredType in types.requiredTypes.toSet()) {
      if (!processed.contains(requiredType.element)) {
        // requiredTypes.remove(requiredType);
        processDependency(this, requiredType);
      }
    }
  }

  Future<void> processDependency(Generation generation, DartType requiredType) async {
    if (requiredType.element is EnumElement) {
      processEnum(requiredType.element as EnumElement);
    }
    else if (requiredType.element is ClassElement) {
      processWidget(requiredType.element as ClassElement);
    }
  }

  void processEnum(EnumElement dartClass) {
    processed.add(dartClass);
    EnumGen(types, dartClass)
      ..genJavaClass()..write();
  }

  void write() {
    _writeC('factories.h', headerFile.toString());
    _writeC('objects.h', objectsHFile.toString());
    _writeC('typedefs.h', typedefFile.toString());
    _writeD('factories_gen.dart', dartFactories.toString());
    _writeJ('WidgetConstructors', javaFactories.toString());
    _writeJ('EWT', javaStatics.toString());

    for (var t in types.unsupportedTypes) {
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

}

class Params {
  Types generation;
  List<ParameterElement> parameters;

  late String names = "";
  late String builderDecl = "";
  late String decl = "";
  late String required = "";
  late String requiredNames = "";
  bool allTypes;

  Params(this.generation, this.parameters,
      String Function(Types, ParameterElement, {bool annotated, bool wrap}) paramDef,
      {this.allTypes = false, String Function(ParameterElement) paramValue = _paramName, String Function(ParameterElement) escape = _paramName}) {
    var filtered = allTypes ? parameters : parameters.where((p) => generation.supportedType(p.type));
    names = filtered.map(paramValue).join(',\n      ');
    var mandatory = filtered.takeWhile((p) => p.isRequired);
    builderDecl = filtered.map((p) => '${paramDef(generation, p, annotated: mandatory.contains(p), wrap: p.isOptional)} ${escape(p)}').join(', ');
    decl = filtered.map((p) => '${paramDef(generation, p, wrap: p.isOptional)} ${escape(p)}').join(', ');
    // var mandatory = filtered.where((p) => p.isRequired);
    required = mandatory.map((p) => '${paramDef(generation, p)} ${escape(p)}').join(', ');
    requiredNames = mandatory.map(paramValue).join(', ');
  }

  static String paramDef4J(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
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

  static String paramDef4JBuilder(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    // var t ='${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type)}';
    var type = param.type;
    if (type is InterfaceType) {
      // if (namedType.isDartCoreList) {
      //   final arrayType = (namedType).typeArguments[0];
      //   return 'List<$arrayType>';
      // }
      // else if (namedType.isDartCoreObject) {
      //   return 'NativeObj';
      // }
      String? t;
      if (type.isDartCoreObject) {
        t = 'NativeObj.I';
      }
      else if (type.isDartCoreList) {
        final arrayType = type.typeArguments[0];
        if (!isPrimitive(arrayType)) {
          t = 'List<${arrayType.element!.name}I>';
        }
      }
      else if (!isPrimitive(type) && type.element is! EnumElement && !type.isDartCoreMap) {
        //   return '${namedType.element.name}Builder';
        // }
        t = '${type.element.name}I';
      }
      if (t != null) {
        if (wrap) {
          t = 'Optional<$t>';
        }
        if (annotated) {
          t = '@Builder.Parameter $t';
        }
        return t;
      }
    }
    return paramDef4J(generation, param, annotated: annotated, wrap: wrap);
  }

  static String paramDef4C(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4C(param.type)}';
    if (t.endsWith('ObjSt')) {
      t = 'DartObj';
    }
    if (wrap && !param.type.isDartCoreString) {
      t = '$t*';
    }
    return t;
  }

  static String paramDef4D(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
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
        else if (t.isDartCoreMap) {
          final arrayType = t.typeArguments[0];
          value = '${param.name}.toMap()';
        }
        else if (!isPrimitive(t)) {
          if (t.typeArguments.isNotEmpty) {
            value = '_widgetsMap[$value]! as ${t.typeArguments.any((p) => p is TypeParameterType) ? t.element.name : t}';
          } else {
            value = '_widgetsMap[$value]! as $t';
          }
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

  static String paramValueDtoC(Types ctx, ParameterElement param) {
    final t = param.type;
    var value = param.name;
    var nul = '0';
    var exclam = '';
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
        exclam = '!';
      }

      if (t.isDartCoreInt) {
        value = '$value$exclam';
      }
      else if (t.isDartCoreBool) {
        value = '$value$exclam.toInt()';
      }
      else if (t.isDartCoreDouble) {
        value = '$value$exclam';
      }
      else if (t.isDartCoreString) {
        //   value = '${param.name}.cast<Utf8>().toDartString()';
        value = '$value$exclam.toNativeUtf8().cast<ffi.Char>()';
        nul = 'ffi.nullptr';
      }
      else if (t.isDartCoreList) {
        final arrayType = t.typeArguments[0];
        if (isPrimitive(arrayType)) {
          value = '$value$exclam.strListToC()';
        } else {
          value = '$value$exclam.toArrayC()';
        }
        nul = 'ffi.nullptr';
      }
      else if (t.element is EnumElement) {
        value = '$value$exclam.index';
      }
      else if (!isPrimitive(t)) {
        return ctx.getGen(t.element).dartToC(value);
        // value = '${param.name}.hashCode';
      }

      if (param.isOptional) {
        value = '(${param.name} != null) ? $value : $nul';
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
      else if (t.isDartCoreMap) {
        value = 'ptrMap($value)';
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
      return 'this::$value';
    }
    return value;
  }

  static String paramValue4JBuilder(ParameterElement param) {
    final t = param.type;
    var value = _escape4J(param);
    if (t is InterfaceType) {
      // if (namedType.isDartCoreList) {
      //   final arrayType = (namedType).typeArguments[0];
      //   return 'List<$arrayType>';
      // }
      // else if (namedType.isDartCoreObject) {
      //   return 'NativeObj';
      // }
      String? v;
      if (t.isDartCoreObject) {
        if (param.isOptional) {
          v = '$value.map(NativeObj.I::build)';
        } else {
          v = '$value.build()';
        }
      }
      else if (t.isDartCoreList) {
        final arrayType = t.typeArguments[0];
        if (!isPrimitive(arrayType)) {
          if (param.isOptional) {
            v = '$value.map(i -> i.stream().map(${arrayType.element!.name}I::build).toList())';
          } else {
            v = '$value.stream().map(${arrayType.element!.name}I::build).toList()';
          }
        }
      }
      else if (!isPrimitive(t) && !t.isDartCoreList && !t.isDartCoreMap && t.element is! EnumElement) {
        if (param.isOptional) {
          v = '$value.map(${t.element.name}I::build)';
        } else {
          v = '$value.build()';
        }
      }
      if (v != null) {
        return v;
      }
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

extension Case on String {
  firstUpper() => isEmpty ? "" : this[0].toUpperCase() + substring(1);
  firstLower() => isEmpty ? "" : this[0].toLowerCase() + substring(1);
}

String _escape4D(String id) => switch (id) {
  'extension' => 'extension_',
  'factory' => 'factory_',
  'sync' => 'sync_',
  'package' => 'package_',
  'public' => 'public_',
  'double' => 'double_',
  'build' => 'build_',
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

void _writeDCopy(String file, String content) {
  print('Generating $file');
  File('./lib/$file').writeAsStringSync(content);
}