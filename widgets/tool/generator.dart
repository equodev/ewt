import 'dart:io';
import 'package:_fe_analyzer_shared/src/scanner/token.dart';
import 'package:analyzer/dart/analysis/analysis_context.dart';
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/features.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/analysis/utilities.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/ast/visitor.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

// final flutterDirectory = '/Users/guillez/bin/flutter/packages/flutter';
final flutterDirectory = '/Users/guillez/bin/flutter/packages/flutter/lib/src';

Future<void> main() async {
  // final result = parseFile(path: '/Users/guillez/bin/flutter/packages/flutter/lib/src/widgets/text.dart', featureSet: FeatureSet.latestLanguageVersion());
  // for (var decl in result.unit.declarations) {
  //   print(decl.)
  // }

  // Initialize a newly created collection of analysis contexts that can
  // analyze the files that are included by the list of included paths.
  // final fileName = 'src/widgets/text.dart';
  var collection = AnalysisContextCollection (includedPaths: [flutterDirectory, '/Users/guillez/bin/flutter/bin/cache/pkg/sky_engine/lib/ui']);

  // A representation of a body of code and the context in which
  // the code is to be analyzed.
  // var context = collection.contextFor('$flutterDirectory');

  // A consistent view of the results of analyzing one or more files
  // var session = context.currentSession;
  //
  // // Start semantic and synctatic analysis
  // var result = await session.getResolvedLibrary('$flutterDirectory/lib/src/widgets');
  //
  // // Iterate through compilation units
  // if (result is ResolvedLibraryResult) {
  //   for (var parsedUnit in result.units) {
  //     parsedUnit.unit.visitChildren(_PublicVisitor());
  //   }
  // }
  analyzeAllFiles(collection);

  // final result = await resolveFile2(path:  '/Users/guillez/bin/flutter/packages/flutter/lib/src/widgets/text.dart');
  // if (result is ResolvedLibraryResult) {
  // for (var parsedUnit in result) {
  //   result. .unit.visitChildren(_PublicVisitor());
  // }
  // }
  // if (result is ResolvedUnitResult) {
  //   result.unit.visitChildren(_PublicVisitor());
  // }
}

Future<void> analyzeAllFiles(AnalysisContextCollection collection) async {
  final generation = _Generation();
  for (AnalysisContext context in collection.contexts) {
    for (String path in context.contextRoot.analyzedFiles()) {
      // print(path);
      if (path.endsWith("widgets/text.dart") /*|| path.endsWith('painting/text_style.dart')*/) {
        await analyzeSingleFile(context, path, generation);
      }
      // else if (path.endsWith('painting/text_painter.dart')) {
      //   analyzeSingleFile(context, path);
      // }
    }
    for (String path in context.contextRoot.analyzedFiles()) {
      // if (path.endsWith("ui/text.dart")) {
      // if (path.endsWith("painting/text_painter.dart") || path.endsWith("painting/text_scaler.dart")) {
      for (String requiredType in generation.requiredTypes) {
        analyzeDependency(requiredType, context, path, generation);
      }
      // }
      // else if (path.endsWith('painting/text_painter.dart')) {
      //   analyzeSingleFile(context, path);
      // }
    }
  }
}

Future<void> analyzeDependency(String requiredType, AnalysisContext context, String path, _Generation generation) async {
  var session = context.currentSession;
  // var result = await session.getResolvedLibrary(path);
  var result = await session.getResolvedUnit(path);
  if (result is ResolvedUnitResult) {
    var enumType = result.unit.declaredElement!.getEnum(requiredType);
    if (enumType != null) {
      generation.requiredTypes.remove(requiredType);
      _EnumWritter(enumType).write();
    }
  }
  // if (result is ResolvedLibraryResult) {
  //   for (var parsedUnit in result.units) {
  //     var enumType = parsedUnit.unit.declaredElement!.getEnum(requiredType);
  //     if (enumType != null) {
  //       generation.requiredTypes.remove(requiredType);
  //       _EnumWritter(enumType).write();
  //     }
  //   }
  // }
}

class _EnumWritter {
  EnumElement enumType;
  StringBuffer javaFile = StringBuffer();

  _EnumWritter(EnumElement this.enumType);

  void write() {
    javaFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('public enum ${enumType.name} {');
    javaFile.writeln(enumType.fields.map((en) => en.name).where((en) => "values" != en).join(', '));
    javaFile.writeln('}');
    writeJava(enumType.name, javaFile.toString());
  }
}

Future<void> analyzeSingleFile(AnalysisContext context, String path, _Generation generation) async {
  var session = context.currentSession;
  var result = await session.getResolvedLibrary(path);

  if (result is ResolvedLibraryResult) {
    for (var parsedUnit in result.units) {
      parsedUnit.unit.visitChildren(_PublicVisitor(generation));
    }
  }
}

class _Generation {
  Set<String> requiredTypes = {};

  String type4J(NamedType namedType) {
    if (namedType.type is InterfaceType) {
      if (namedType.type!.isDartCoreBool) {
        return 'boolean';
      }
    } else {
      requiredTypes.add((namedType).name2.toString());
    }
    return (namedType).name2.toString();
  }
}

class _PublicVisitor extends GeneralizingAstVisitor {
  late _JavaWriter java;

  _Generation generation;

  _PublicVisitor(this.generation);

  @override
  visitClassDeclaration(ClassDeclaration node) {
    if (node.name.toString()[0] != '_' && isWidget(node)) {
      print(node.name);
      java = _JavaWriter(node, generation);
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
    if (node.withClause != null) {
      return node.withClause!.mixinTypes.any((mix) => mix.name2.toString().contains('Diagnosticable'));
    }
    return false;
  }

}

class _JavaWriter {
  ClassDeclaration classDeclaration;
  StringBuffer javaFile = StringBuffer();
  String widgetClass;

  _Generation generation;

  _JavaWriter(this.classDeclaration, this.generation):
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
    writeJava(widgetClass, javaFile.toString());
  }

  void writeFactory(ConstructorDeclaration node) {
    final params = _JavaParams(classDeclaration, node.parameters.parameters, generation);
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
  ClassDeclaration classDeclaration;
  NodeList<FormalParameter> parameters;

  late String names;
  late String builderDecl;
  late String decl;

  _Generation generation;

  _JavaParams(this.classDeclaration, this.parameters, this.generation) {
    var filtered = parameters.where(supportedType);
    names = filtered.map(_paramName).join(', ');
    builderDecl = filtered.map((p) => '${_paramDef(p, annotated: p.isRequired)} ${_paramName(p)}').join(', ');
    decl = filtered.map((p) => '${_paramDef(p)} ${_paramName(p)}').join(', ');
  }

  String _paramDef(FormalParameter param, {bool annotated = false}) {
    if (param is FieldFormalParameter) {
      return '${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type! as NamedType)}';
    }
    else if (param is DefaultFormalParameter) {
      switch (param.parameter) {
        case SuperFormalParameter p:
          VariableDeclarationList fld = findSuperField(classDeclaration, p.name.toString())!;
          var namedType = fld.type as NamedType;
          return '${generation.type4J(namedType)}';
        case FieldFormalParameter p:
          VariableDeclarationList fld = findField(classDeclaration, p.name.toString())!;
          var namedType = fld.type as NamedType;
          return '${generation.type4J(namedType)}';
        default:
          return '${param.declaredElement?.type}';
      }
    }
    return 'NA';
  }

  bool supportedType(FormalParameter element) {
    final t = _paramDef(element);
    return !['Color', 'TextHeightBehavior', 'TextScaler', 'Locale', 'StrutStyle', 'TextStyle'].contains(t);
  }
}

VariableDeclarationList? findSuperField(ClassDeclaration classDeclaration, String name) {
  while (classDeclaration.extendsClause != null && classDeclaration.extendsClause!.superclass.element is ClassElement) {
    final extend = classDeclaration.extendsClause!.superclass.element;
    if (extend is ClassElement) {
      final library = extend.session!.getParsedLibraryByElement(extend.library);
      if (library is ParsedLibraryResult) {
        final superClassDeclResult = library.getElementDeclaration(extend)!;
        final superClassDecl = superClassDeclResult.node as ClassDeclaration;
        final superField = findField(superClassDecl, name);
        if (superField != null) {
          return superField;
        }
        classDeclaration = superClassDecl;
      }
    }
  }
  return null;
}

VariableDeclarationList? findField(ClassDeclaration classDeclaration, String name) {
  final fld = classDeclaration.members.whereType<FieldDeclaration>().map((f) => f.fields)
      .where((f) => f.variables.any((v) => v.name.toString() == name));
  return fld.firstOrNull;
}

// String _paramType(FieldFormalParameter param) {
//   if (param.type != null) {
//     return param.type.toString();
//   } else {
//     param.declaredElement?.name.toString();
//   }
//   return "NA";
// }

String _paramName(FormalParameter param) {
  if (param is FieldFormalParameter) {
    return '${param.name}';
  }
  return param.name.toString();
}

void writeJava(String clazz, String javaContent) {
  print('Generating $clazz');
  File('../ewt.api/src/main/java/dev/equo/ewt/$clazz.java').writeAsStringSync(javaContent);
}