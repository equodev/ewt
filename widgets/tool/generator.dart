import 'dart:io';
import 'package:analyzer/dart/analysis/features.dart';
import 'package:analyzer/dart/analysis/utilities.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/ast/visitor.dart';

void main() {
  final result = parseFile(path: '/Users/guillez/bin/flutter/packages/flutter/lib/src/widgets/text.dart', featureSet: FeatureSet.latestLanguageVersion());
  // for (var decl in result.unit.declarations) {
  //   print(decl.)
  // }
  result.unit.visitChildren(_PublicVisitor());
}

class _PublicVisitor extends GeneralizingAstVisitor {
  late _JavaWriter java;

  @override
  visitClassDeclaration(ClassDeclaration node) {
    if (node.name.toString()[0] != '_' && isWidget(node)) {
      print(node.name);
      java = _JavaWriter(node);
      java.writeHeaders();
      final r = super.visitClassDeclaration(node);
      java.writeFooter();
      java.writeFile();
      return r;
    } else {
      print('Ignored ${node.name}');
    }
  }
  @override
  visitConstructorDeclaration(ConstructorDeclaration node) {
    print(node);
    java.writeFactory(node);
    return super.visitConstructorDeclaration(node);
  }

  bool isWidget(ClassDeclaration node) {
    if (node.extendsClause != null) {
      return node.extendsClause!.superclass.name2.toString().contains('Widget');
    }
    return false;
  }

}

class _JavaWriter {
  ClassDeclaration classDeclaration;
  StringBuffer javaFile = StringBuffer();
  String widgetClass;

  _JavaWriter(this.classDeclaration):
    widgetClass = '${classDeclaration.name}';

  void writeHeaders() {
    javaFile
      ..writeln('package dev.equo.ewt;')
    // ..writeln('import org.immutables.value.Value;')
      ..writeln('import org.immutables.builder.Builder;')
    // ..writeln('@Value.Immutable')
      ..writeln('public class $widgetClass {')
      // ..writeln('  private $widgetClass() {}')
    ;
  }

  void writeFooter() {
    javaFile.writeln('}');
  }

  void writeFile() {
    writeJava(widgetClass, javaFile);
  }

  void writeFactory(ConstructorDeclaration node) {
    print(node.parameters.parameters);
    final params = _JavaParams(node.parameters.parameters);
    if (node.name == null) { // unnamed constructors
      final builderClass = '${widgetClass}Builder';
      javaFile
        ..writeln('  @Builder.Constructor')
        ..writeln('  $widgetClass(${params.builderDecl}) {')
        ..writeln('  }')
        ..writeln('  public static $builderClass of(${params.decl}) {')
        ..writeln('    return $builderClass.$widgetClass(${params.names});')
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
        ..writeln('  public static $builderClass ${node.name}(${params.decl}) {')
        ..writeln('    return $builderClass.$factoryName(${params.names});')
        ..writeln('  }');
    }
  }



}

class _JavaParams {
  NodeList<FormalParameter> parameters;

  String names;
  String builderDecl;
  String decl;

  _JavaParams(this.parameters):
    names = parameters.map(_paramName).join(', '),
    builderDecl = parameters.map((p) => _paramDef(p, annotated: p.isRequired)).join(', '),
    decl = parameters.map(_paramDef).join(', ');
}

String _paramDef(FormalParameter param, {bool annotated = false}) {
  if (param is FieldFormalParameter) {
    return '${annotated ? '@Builder.Parameter ' : ''}${param.type} ${param.name}';
  }
  return param.name.toString();
}

String _paramName(FormalParameter param) {
  if (param is FieldFormalParameter) {
    return '${param.name}';
  }
  return param.name.toString();
}

void writeJava(String clazz, StringBuffer javaContent) {
  File('../ewt.api/src/main/java/dev/equo/ewt/$clazz.java').writeAsStringSync(javaContent.toString());
}