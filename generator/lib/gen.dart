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
    _writeDCopy('subwidgets.dart', dartSubclasses.toString()); // this is for the parser/generator
  }

}

class WidgetGen implements AGen {
  Types types;
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

  WidgetGen(this.types, this.dartClass):
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
      for (var constr in dartClass.methods.where((m) => m.isStatic && m.isPublic && !isPrimitive(m.returnType) && !m.returnType.isDartCoreList /*&& m.returnType == dartClass.thisType*/)) {
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
      types.addRequiredType(dartClass.supertype as DartType);
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
    // var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    List<String> builderExtend = [];
    List<InterfaceType> trulyInterfaces = [];
    if (dartClass.supertype != null && !dartClass.supertype!.isDartCoreObject) {
      if (!_isInterface && isInterface(dartClass.supertype!.element)) {
        extend += ' extends NativeObj.Base';
        trulyInterfaces = [dartClass.supertype!];
        // builderExtend = ' extends ';
      } else {
        extend += ' extends ${toJavaClass(dartClass.supertype!)}';
        // builderExtend = ' extends ${toJavaClassUngeneric(dartClass.supertype!)}I';
        builderExtend = ['${toJavaClassUngeneric(dartClass.supertype!)}I'];
      }
      // extend += ' extends ${dartClass.supertype!.element.name}${dartClass.supertype!.typeArguments.isNotEmpty ? '<${dartClass.typeParameters.map((p) => p.name).join(', ')}>' : ''}';
      // builderExtend = ' extends ${toJavaClassUngeneric(dartClass.supertype!)}I';
    }
    else {
      extend += ' extends ${!_isInterface ? 'NativeObj.Base' : 'NativeObj, ${widgetClass}I'}';
      builderExtend = ['NativeObj.I'];
    }
    trulyInterfaces += dartClass.interfaces.where((i) =>
        i.interfaces.any((i) => i.element is ClassElement)).toList();
    if (trulyInterfaces.isNotEmpty) {
      extend += ' implements ${trulyInterfaces.map((i) => toJavaClass(i)).join(', ')}, ${widgetClass}I';
      builderExtend += trulyInterfaces.map((i) => '${toJavaClassUngeneric(i)}I').toList();
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
      ..writeln('public interface ${widgetClass}I extends ${builderExtend.join(', ')} {\n'
          '  @Override\n'
          '  $widgetClass build();\n'
          '}');
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
    javaFile.writeln('  @Override\n'
        '  ${_isInterface ? 'default' : 'public'} $widgetClass build() {\n'
        '    return this;\n'
        '  }');
    javaFile.writeln('}');
    if (hasMembers) {
      headerFile.writeln('  } $widgetField;');
    }
  }

  void writeFactory(FunctionTypedElement node) {
    if (node.parameters.any((p) => p.isRequired && !types.supportedType(p.type)) || !types.supportedType(node.returnType)) {
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
    var gen = types.getGen(node.returnType.element!);
    final dartParams = Params(types, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName${gen.objType().endsWith('ObjSt') ? '' : ', exception'});');
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
    headerFile.writeln('    ${CLang(types).field(factory, types.getGen(node.returnType.element!).objType(), params: node.parameters)}');
  }

  void writeJavaFactory(FunctionTypedElement node, String factoryName, String builderClass, String factory) {
    String builderFactory = factoryName;
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsDecl = Params(types, node.parameters, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    if (node is ConstructorElement) {
      javaFile
        ..writeln('  @Builder.Factory')
        ..writeln('  static $widgetClass $factoryName(${jParamsDecl.builderDecl}) {');
    } else {
      javaFile
          .writeln('  public static ${types.type4J(node.returnType)} $factory(${jParamsDecl.decl}) {');
    }
    var gen = types.getGen(node.returnType.element!);
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
      ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('id', node.returnType))};');
  }

  void writeJavaFactoryMethod(String factoryName, Params jParams, String factory, Params jParamsFFM, FunctionTypedElement node) {
    var gen = types.getGen(node.returnType.element!);
    javaFactories
      ..writeln('  ${JLang().methodTypeParameters(node.type)}${gen.objType().endsWith('ObjSt') ? 'MemorySegment' : 'int'} $factoryName(${jParams.decl}) {')
      ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    var fn = WidgetFactories.${widgetClass}St.$factory(st);')
      ..writeln('    return WidgetFactories.${widgetClass}St.$factory.invoke(${['fn${gen.objType().endsWith('ObjSt') ? ', arena' : ''}', jParamsFFM.names.nullIfEmpty].nonNulls.join(', ')});')
      ..writeln('  }');
  }

  void writeConst(ConstFieldElementImpl fld, int constId) {
    String factory = _escape4D(fld.name);
    var initializer = fld.constantInitializer;
    if (initializer is InstanceCreationExpression) {
      var creationExpression = initializer as InstanceCreationExpression;
      if (creationExpression.constructorName.staticElement!.isPrivate || creationExpression.staticType!.element!.isPrivate) {
        return;
      }
    }
    javaFile
      .writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
    if (initializer is InstanceCreationExpression) {
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

      // var clazz = dartClass != e.constructorName.type.element ? '.${e.constructorName.toString().firstLower()}' : '';
      // var clazz = '.${e.constructorName.toString().firstLower()}';
      var constructorName = e.constructorName.toString();
      if (e.constructorName.name == null) {
        constructorName += '.${e.constructorName.toString().firstLower()}';
      }
      return '$constructorName($requiredArgs)$otherArgs.build()';
    }
    else if (e is SetOrMapLiteral) {
      return 'Map.ofEntries(${e.elements.whereType<MapLiteralEntry>().map((e) => 'Map.entry(${e.key}, ${dartExptrToJava(e.value)})').join(', ')})';
    }
    else if (e is SimpleIdentifier) {
      return '$e()';
    }
    else if (e is PrefixedIdentifier) {
      if (e.staticType != null && !isPrimitive(e.staticType!)) {
        return '${e.toString()}()';
      }
      return replace(e.toString());
    }
    return e.toString();
  }

  String toJavaClassUngeneric(InterfaceType interfaceType) => interfaceType.element.name;
  String toJavaClass(DartType dartType) {
    if (dartType.isDartCoreInt) {
      return 'Integer';
    } else if (dartType.isDartCoreDouble) {
      return 'Double';
    } else if (dartType.isDartCoreBool) {
      return 'Boolean';
    }
    else if (dartType is InterfaceType) {
      var s = dartType.element.name;
      if (dartType.typeArguments.isNotEmpty) {
        s += '<${dartType.typeArguments.map((t) => toJavaClass(t)).join(', ')}>';
      }
      return s;
    }
    var s = dartType.element!.name;
    return s!;
  }

  String boxedType(String name) => switch (name) {
    'int' => 'Integer',
    'double' => 'Double',
    'bool' => 'Boolean',
    _ => name
  };

  String replace(String expr) => switch (expr) {
    'double.infinity' => 'Double.POSITIVE_INFINITY',
    _ => expr
  };
}

abstract class ObjStGen extends WidgetGen {
  String widgetSt;

  ObjStGen(super.types, super.dartClass) :
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
    // Let concrete implementations finish the declaration
  }

  /// Writes the structure header and id field to objectsHFile
  void writeStructHeader() {
    objectsHFile.writeln('typedef struct {');
    objectsHFile.writeln('  ${CLang(types).field('id', 'int')}');
  }

  /// Writes the structure footer to objectsHFile
  void writeStructFooter() {
    objectsHFile.writeln('} $widgetSt;');
  }

  /// Generates a field accessor for java
  void writeJavaFieldAccessor(FieldElement field, {bool useInvoke = false}) {
    javaFile
      ..writeln('  public ${types.type4J(field.type)} ${field.name}() {');
    
    if (useInvoke) {
      javaFile
        ..writeln('    MemorySegment funcPtr = $widgetSt.${field.name}(st);')
        ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('$widgetSt.${field.name}.invoke(funcPtr)', field.type))};');
    } else {
      javaFile
        .writeln('    return ${types.paramValueFFMtoJ(types, paramElement('$widgetSt.${field.name}(st)', field.type))};');
    }
    
    javaFile.writeln('  }');
  }

  /// Generates struct creation code for dart
  void writeDartStructCreation(String widgetVar) {
    dartFns
      ..writeln('  final $widgetSt stObj = ffi.Struct.create();')
      ..writeln('  stObj.id = _addWidget($widgetVar);');
  }

  /// Writes the _create function closing
  void writeDartStructReturn() {
    dartFns
      ..writeln('  return stObj;')
      ..writeln('}');
  }

  /// Shared callable fields filter logic
  Iterable<FieldElement> getCallableFields(ClassElement sourceClass) =>
      sourceClass.fields.where((f) =>
          !f.getter!.hasOverride && f.isPublic && !f.isStatic
          && f.type is! FunctionType && !f.type.isDartCoreList && !f.type.isDartCoreObject
          && !isInterface(f.type.element) && types.supportedType(f.type) && f.type != sourceClass.thisType);
}

class ImmutableGen extends ObjStGen {
  ImmutableGen(super.types, super.dartClass);

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    // First call the base ObjStGen implementation for common imports
    super.writeJavaDecl(extend, isInterface);
    // Then complete with the class declaration that would normally be done in WidgetGen
    javaFile.writeln(
        'public ${!dartClass.isAbstract ? 'class' : _isInterface ? 'interface' : 'abstract class'} $widgetClass$extend {');
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
      ..writeln('    return new ${types.type4J(node.returnType)}(st);');
  }

  @override
  void writeMembers() {
    writeStructHeader();
    
    for (final field in callableFields()) {
      objectsHFile.writeln('  ${CLang(types).field(field.name, types.type4C(field.type))}');
      writeJavaFieldAccessor(field);
    }
    
    writeStructFooter();

    dartFns
      ..writeln('$widgetSt _create$widgetSt($widgetClass? w) {');
      
    writeDartStructCreation('w');
    dartFns.writeln('  if (w == null) return stObj;');
    
    for (var m in callableFields()) {
      dartFns
          .writeln('  stObj.${m.name} = ${Params.paramValueDtoC(types, paramElement('w.${m.name}', m.type))};');
    }
    
    writeDartStructReturn();
  }

  Iterable<FieldElement> callableFields() => getCallableFields(dartClass);
}

class SubclassGen extends ObjStGen {
  SubclassGen(super.types, super.dartClass);

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    super.writeJavaDecl(extend, isInterface);
    javaFile.writeln('public abstract class $widgetClass$extend, SubclassedInJava {');
  }

  @override
  void writeJavaConstructors() {
    // Empty implementation as in the original
  }

  @override
  void writeMembers() {
    for (final method in dartClass.supertype!.element.methods.where(canBeImplInJava)) {
      var returnType = method.returnType;
      var ret = '${method.returnType}';
      // var retBuilder = types.widgets.any((w) => w.name  == 'Sub${returnType.element!.name}') ? ret : '${method.returnType}';
      var retBuilder = ret;
      if (returnType is InterfaceType && returnType.typeArguments.isNotEmpty) {
        ret = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
        retBuilder = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
      }
      final jParams = Params(types, method.parameters, Params.paramDef4J, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
      javaFile.writeln('  protected ${method.isAbstract ? 'abstract ' : ''}$retBuilder ${method.name}(${jParams.decl})${method.isAbstract ? ';' : ' {}'}');
      javaFile.writeln('  ${ret} ${method.name}Fn(${jParams.decl}) {');
      if (returnType is VoidType) {
        javaFile.writeln('    ${method.name}(${jParams.names});');
      } else {
        javaFile.writeln('    return ${method.name}(${jParams.names}).build();');
      }
      javaFile.writeln('  }');
    }
    
    writeStructHeader();
    
    for (final field in callableFields()) {
      objectsHFile.writeln('  ${CLang(types).field(field.name, types.type4C(field.type), params: [])}');
      writeJavaFieldAccessor(field, useInvoke: true);
    }
    
    for (final method in callableMethods()) {
      objectsHFile.writeln('  ${CLang(types).field(method.name, '${method.returnType}', params: method.parameters)}');
      final jParams = Params(types, method.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
      javaFile
        ..writeln('  protected ${method.returnType} ${method.name}(${jParams.decl}) {')
        ..writeln('    MemorySegment funcPtr = $widgetSt.${method.name}(st);')
        ..writeln('    $widgetSt.${method.name}.invoke(funcPtr, factories.${jParams.names});')
        ..writeln('  }');
    }
    
    writeStructFooter();
  }

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
    javaFile
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
    dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName);');
    dartFns
      ..writeln('$widgetSt $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = ${node.displayName}(${dartParams.names});');
    
    writeDartStructCreation('w');
    
    for (var m in callableMethods()) {
      dartFns
        ..writeln('  final ${m.name}Fn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.isolateLocal((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.${m.name}(cb.asFunction()));')
        ..writeln('  stObj.${m.name} = ${m.name}Fn.nativeFunction;');
    }
    
    for (var m in callableFields()) {
      dartFns
        ..writeln('  final ${m.name}Fn = ffi.NativeCallable<${types.type4D(m.type)} Function()>.isolateLocal(() => ${Params.paramValueDtoC(types, paramElement('w.${m.name}', m.type))}, exceptionalReturn: exception);')
        ..writeln('  stObj.${m.name} = ${m.name}Fn.nativeFunction;');
    }
    
    writeDartStructReturn();
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
    final superTypeParam = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.map((t) => t.name).join(', ')}>' : '';
    dartSubclass
        .writeln('class $widgetClass$typeParam extends ${dartClass.name}$superTypeParam {');
    final methods = dartClass.methods.where(canBeImplInJava);
    for (final method in methods) {
      dartSubclass.writeln('  final ${method.type} ${method.name}Fn;');
    }
    var params = dartClass.constructors.first.parameters.map((p) => '${p is SuperFormalParameterElement ? 'super.' : 'this.'}${p.name}').toList();
    var overrideable = methods.map((m) => 'required this.${m.name}Fn').toList();
    dartSubclass
        .writeln('  $widgetClass({${(params+overrideable).join(', ')}});');
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

bool canBeImplInJava(m) => m.isAbstract || (m.hasMustCallSuper && m.hasProtected);

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
      ..writeln('import java.util.function.BiFunction;')
      ..writeln('import java.util.function.Function;')
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

    javaStatics.writeln('}');

    addTypeDefs();
    javaFactories.writeln('}');
  }

  void addTypeDefs() {
    for (var td in types.typeDefs) {
      var fnType = td.element.aliasedType;
      var aliasName = td.element.name;
      var ourName = '${aliasName}FFI';
      if (fnType is FunctionType) {
        final h = types.getHandler(fnType) as FunctionHandler;
        var aliasName = h.getInstantiatedAliasName(td);
        var ourName = h.getInstantiatedAliasName(td, withSuffix: true);
        var boundParams = bindTypeParameters(fnType.parameters, td.typeArguments);
        typedefFile.writeln('typedef ${CLang(types).field(ourName, types.type4C(fnType.returnType), params: boundParams)}');
        // if (!aliasedType.boundParams.any((p) => p.type.isDartCoreBool || !isPrimitive(p.type))) { // we need to wrap from int to bool
        var tp = boundParams.map((p) => p.type).whereType<TypeParameterType>().join(', ');
        var rtp = td.typeArguments.isEmpty ? '' : '<${td.typeArguments.join(', ')}>';
        tp = tp.isEmpty ? '' : '<$tp>';
          var isFlutterAlias = td.element.aliasedElement != null;
          var retType = (isFlutterAlias) ? '${td.element.name}$rtp' : fnType; // custom aliases
          dartFactories.writeln(
                  'extension on $ourName {\n'
                  '  $retType to${aliasName}Fn$tp() {\n'
                  '    return (${boundParams.map((p) => '${p.type} ${ensureName(p)}').join(', ')}) {\n'
                  '      Dart${aliasName}FFIFunction dFn = asFunction();\n'
                  '      ${fnType.returnType is! VoidType ? 'final dFnRet = ' : ''}dFn(${boundParams.map((p) => Params.paramValueDtoC(types, p)).join(', ')});');
          if (fnType.returnType is! VoidType) {
            dartFactories.writeln(
                  '      return ${Params.paramValue4D(types, paramElement('dFnRet', fnType.returnType))};');
          }
          dartFactories.writeln(
                  '    };\n'
                  '  }\n'
                  '}\n'
                  'extension on ffi.Pointer<$ourName> {\n'
                  '  $retType? to${aliasName}Fn$tp() => (this != ffi.nullptr) ? this.value.to${aliasName}Fn() : null;\n'
                  '}\n'
          );
        // }
        String jtp = isFlutterAlias ? '' : JLang().methodTypeParameters(fnType);
        javaFactories.writeln('${jtp}MemorySegment ptr${aliasName}Fn(${h.type4J(fnType, td.typeArguments)} jFn) {\n'
            '  return $ourName.allocate((${boundParams.map((p) => ensureName(p)).join(', ')}) -> {\n'
            '    ${fnType.returnType is! VoidType ? 'final var jFnRet = ' : ''}jFn.${h.functionMethod(fnType)}(${boundParams.map((p) => types.paramValueFFMtoJ(types, p)).join(', ')});');
        if (fnType.returnType is! VoidType) {
          javaFactories.writeln(
            '    return ${types.paramValue4FFM(types, paramElement('jFnRet', fnType.returnType))};');
        }
        javaFactories.writeln(
            '  }, arena);\n'
            '}');
      } else {
        typedefFile.writeln('typedef $fnType $ourName');
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
  Types types;
  List<ParameterElement> parameters;

  late String names = "";
  late String builderDecl = "";
  late String decl = "";
  late String required = "";
  late String requiredNames = "";
  bool allTypes;

  Params(this.types, this.parameters,
      String Function(Types, ParameterElement, {bool annotated, bool wrap}) paramDef,
      {this.allTypes = false, String Function(Types, ParameterElement) paramValue = _paramName, String Function(Types, ParameterElement) escape = _paramName}) {
    var filtered = allTypes ? parameters : parameters.where((p) => types.supportedType(p.type));
    names = filtered.map((p) => paramValue(types, p)).join(',\n      ');
    var mandatory = filtered.takeWhile((p) => p.isRequired);
    builderDecl = filtered.map((p) => '${paramDef(types, p, annotated: mandatory.contains(p), wrap: p.isOptional)} ${escape(types, p)}').join(', ');
    decl = filtered.map((p) => '${paramDef(types, p, wrap: p.isOptional)} ${escape(types, p)}').join(', ');
    // var mandatory = filtered.where((p) => p.isRequired);
    required = mandatory.map((p) => '${paramDef(types, p)} ${escape(types, p)}').join(', ');
    requiredNames = mandatory.map((p) => paramValue(types, p)).join(', ');
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

  static String _paramName(Types types, ParameterElement param) => param.name;

  static String escape4J(Types types, ParameterElement param) => (param.name == 'package') ? '_package' : ensureName(param);

  static String paramValue4D(Types types, ParameterElement param) {
    final t = param.type;
    var value = param.name;
    final h = types.getHandler(t);
    if (h != null) {
      value = h.value4D(param);
    }
    else if (t is InterfaceType) {
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
            value = '${param.name}.doubleOr(${defaultDoubleCode(param)})';
          } else {
            value = '${param.name}.doubleOrNul()';
          }
        }
        else if (t.isDartCoreList) {
          final arrayType = t.typeArguments[0];
          // if (isPrimitive(arrayType)) {
          // if (t.nullabilitySuffix == NullabilitySuffix.none) {
            value = '${param.name}.orEmpty()';
          // } else {
          //   value = '${param.name}.orEmpty()';
          // }
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
        // else if (t.isDartCoreMap) {
        //   value = '${param.name}.toMap()';
        // }
        else if (!isPrimitive(t)) {
          if (t.typeArguments.isNotEmpty) {
            value = '_widgetsMap[$value]! as ${t.typeArguments.any((p) => p is TypeParameterType) ? t.element.name : t}';
          } else {
            value = '_widgetsMap[$value]! as $t';
          }
        }
      }
    }
    // else if (t is FunctionType) {
    //   if (t.alias != null) {
    //     value = '$value.to${t.alias!.element.name}Fn()';
    //   } else {
    //     value = '$value.toFn()';
    //   }
    // }
    if (param.isNamed) {
      value = '${param.name}: $value';
    }
    return value;
  }

  static String? defaultDoubleCode(ParameterElement param) {
    var defaultValue = param.defaultValueCode!;
    if (double.tryParse(defaultValue) != null) {
      return param.defaultValueCode;
    }
    if (defaultValue.contains('.'))
      return defaultValue;
    return '${param.thisOrAncestorOfType<ClassElement>()!.name}.$defaultValue';
  }

  static String paramValueDtoC(Types ctx, ParameterElement param) {
    var t = param.type;
    if (t is TypeParameterType) {
      t = t.bound;
    }
    var value = ensureName(param);
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

  static String paramValue4JCallback(Types types, ParameterElement param) {
    final t = param.type;
    var value = escape4J(types, param);
    if (t is FunctionType) {
      return 'this::$value';
    }
    return value;
  }

  static String paramValue4JBuilder(Types types, ParameterElement param) {
    final t = param.type;
    var value = escape4J(types, param);
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

}

extension Case on String {
  firstUpper() => isEmpty ? "" : this[0].toUpperCase() + substring(1);
  firstLower() => isEmpty ? "" : this[0].toLowerCase() + substring(1);
}

String ensureName(ParameterElement param) => param.name.isNotEmpty ? param.name : param.type.element!.name![0].toLowerCase();

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