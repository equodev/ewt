import 'dart:io';
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/ast/visitor.dart';
import 'package:path/path.dart' as path;

// Get the SDK path
String getSdkPath() {
  final executable = path.split(Platform.resolvedExecutable);
  final cache = executable.indexOf('cache');
  return path.join(path.joinAll(executable.sublist(0, cache+1)), 'dart-sdk');
}

void main(List<String> args) async {
  if (args.isEmpty) {
    print('Usage: dart translator.dart path/to/flutter_app.dart [output_class_name]');
    exit(1);
  }

  final inputFilePath = args[0];
  final outputClassName = args.length > 1 ? args[1] : 'HelloWorld';

  try {
    final javaCode = await translateDartToJava(inputFilePath, outputClassName);
    print(javaCode);

    // Optionally write to a file
    final outputFile = File('${outputClassName}.java');
    await outputFile.writeAsString(javaCode);
    print('Java code written to ${outputFile.path}');
  } catch (e) {
    print('Error translating Dart to Java: $e');
    exit(1);
  }
}

Future<String> translateDartToJava(String filePath, String className) async {
  // Convert relative path to absolute path
  filePath = File(filePath).absolute.path;

  // Create an analysis context
  final collection = AnalysisContextCollection(
    includedPaths: [filePath],
    sdkPath: getSdkPath(),
  );

  // Get the context for the file
  final context = collection.contextFor(filePath);
  final session = context.currentSession;

  // Get the resolved unit
  final unitResult = await session.getResolvedUnit(filePath) as ResolvedUnitResult;

  if (unitResult.errors.isNotEmpty) {
    print('Warnings/errors in the Dart file:');
    for (final error in unitResult.errors) {
      print('  ${error.message}');
    }
  }

  // Create a translator visitor to traverse the AST
  final translator = FlutterToJavaTranslator(className);
  unitResult.unit.accept(translator);

  // Generate the Java code
  return translator.generateJavaCode();
}

class FlutterToJavaTranslator extends RecursiveAstVisitor<void> {
  final StringBuffer _imports = StringBuffer();
  final StringBuffer _mainMethod = StringBuffer();
  final String _className;
  bool _hasFoundRunApp = false;

  FlutterToJavaTranslator(this._className);

  @override
  void visitImportDirective(ImportDirective node) {
    if (node.uri.stringValue == 'package:flutter/widgets.dart' ||
        node.uri.stringValue == 'package:flutter/material.dart') {
      _imports.writeln('import dev.equo.ewt.*;');
    }
    super.visitImportDirective(node);
  }

  @override
  void visitFunctionDeclaration(FunctionDeclaration node) {
    if (node.name.lexeme == 'main') {
      // We've found the main function, continue traversing it
      super.visitFunctionDeclaration(node);
    }
  }

  @override
  void visitMethodInvocation(MethodInvocation node) {
    if (node.methodName.name == 'runApp' && !_hasFoundRunApp) {
      _hasFoundRunApp = true;
      _mainMethod.write('App.runApp(() ->\n');

      // Translate the argument to runApp
      final argument = node.argumentList.arguments.first;
      final javaWidget = _translateWidget(argument, 12); // 12 spaces indent
      _mainMethod.write('$javaWidget');

      _mainMethod.write('\n        )');
    } else {
      super.visitMethodInvocation(node);
    }
  }

  String _translateWidget(Expression expression, int indentSpaces) {
    final indent = ' ' * indentSpaces;

    if (expression is InstanceCreationExpression) {
      final className = expression.constructorName.type.element?.name;
      final StringBuffer javaWidget = StringBuffer();

      // Start with the class name
      javaWidget.write('$indent$className.of()');

      // Process the arguments (named parameters in Flutter)
      for (final argument in expression.argumentList.arguments) {
        if (argument is NamedExpression) {
          final paramName = argument.name.label.name;

          // Skip 'key' parameters as they're handled differently in Java
          if (paramName == 'key') continue;

          if (paramName == 'child') {
            // For child widgets, we need to handle nesting
            if (argument.expression is InstanceCreationExpression) {
              final childWidget = _translateWidget(argument.expression, indentSpaces + 4);
              javaWidget.write('\n$indent    .child($childWidget)');
            } else {
              final paramValue = _translateExpression(argument.expression);
              javaWidget.write('\n$indent    .child($paramValue)');
            }
          } else if (paramName == 'children') {
            // Handle List of widgets - would need more complex implementation for real usage
            javaWidget.write('\n$indent    .children(List.of(/*TODO: Implement children list*/))');
          } else {
            final paramValue = _translateExpression(argument.expression);
            javaWidget.write('\n$indent    .$paramName($paramValue)');
          }
        } else {
          // Handle positional arguments if needed
          final paramValue = _translateExpression(argument);
          javaWidget.write('\n$indent    .child($paramValue)');
        }
      }

      // End with build() for the widget
      javaWidget.write('.build()');
      return javaWidget.toString();
    } else if (expression is SimpleStringLiteral) {
      return '"${expression.value}"';
    } else {
      // Handle other expression types
      return expression.toString();
    }
  }

  String _translateExpression(Expression expression) {
    if (expression is InstanceCreationExpression) {
      // For nested widgets in expressions, we use 0 indent since they'll be inline
      return _translateWidget(expression, 0).trim();
    } else if (expression is SimpleStringLiteral) {
      return '"${expression.value}"';
    } else if (expression is PrefixedIdentifier) {
      // Handle enum values like TextDirection.ltr
      return expression.toString();
    } else if (expression is PropertyAccess) {
      return expression.toString();
    } else {
      return expression.toString();
    }
  }

  String generateJavaCode() {
    final code = StringBuffer();

    // Add package declaration
    code.writeln('package dev.equo;');
    code.writeln();

    // Add imports
    code.write(_imports);
    code.writeln();

    // Add class declaration
    code.writeln('public class $_className {');
    code.writeln('    public static void main(String[] args) {');

    // Add main method content
    code.write('        ');
    code.write(_mainMethod);

    // Close class
    code.writeln(';');
    code.writeln('    }');
    code.writeln('}');

    return code.toString();
  }
}