import 'dart:convert';
import 'dart:io';
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/analysis/utilities.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/ast/token.dart';
import 'package:analyzer/dart/ast/visitor.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/element2.dart';
import 'package:analyzer/dart/element/type.dart';
import 'package:analyzer/src/dart/ast/to_source_visitor.dart';
import 'package:analyzer/src/dart/ast/ast.dart';
import 'package:_fe_analyzer_shared/src/scanner/token_impl.dart';
import 'package:path/path.dart' as path;

// Get theath
String getSdkPath() {
  final executable = path.split(Platform.resolvedExecutable);
  final cache = executable.indexOf('cache');
  return path.join(path.joinAll(executable.sublist(0, cache+1)), 'dart-sdk');
}

void main(List<String> args) async {
  if (args.isEmpty) {
    print('Usage: dart transpiler.dart path/to/flutter_app.dart [output_class_name|package/java_file] [package]');
    exit(1);
  }

  final inputFilePath = args[0];
  String? outputClassName = args.length > 1 ? args[1] : null;
  String? package = args.length > 2 ? args[2] : null;

  try {
    final javaCode = await transpile(inputFilePath, outputClassName, overridePackage: package);
    // print(javaCode);

    // Optionally write to a file
    // final outputFile = File('${outputClassName}.java');
    // await outputFile.writeAsString(javaCode);
    // print('Java code written to ${outputFile.path}');
  } catch (e) {
    print('Error translating Dart to Java: $e');
    rethrow;
    exit(1);
  }
}

(String, String, String) getOutput(String inputPath, String? out, [String? overridePackage]) {
  var newOut = out ?? inputPath;
  var package = '';
  List<String> parts = [''];
  if (newOut.endsWith('.java') || newOut.endsWith(".dart")) {
    newOut = path.withoutExtension(newOut);
  }
  if (out != null) {
    if (out.contains('.') && !out.contains(path.separator)) {
      newOut = newOut.replaceAll('.', path.separator);
    }
    parts = path.split(path.dirname(newOut)).skipWhile((d) => d.isEmpty || d == '.').toList(growable: false);
    int src = parts.indexOf('java');
    if (src == -1) {
      src = parts.indexOf('src');
    }
    if (src == -1) {
      src = parts.indexOf('source');
    }
    package = parts.sublist(src+1).join('.');
  }
  var className = path.basename(newOut);
  if (out == null) {
    className = className[0].toUpperCase() + className.substring(1);
  }

  var outputPath = path.setExtension(path.join(path.joinAll(parts), className), '.java');
  outputPath = path.normalize(outputPath);
  return (className, overridePackage ?? package, outputPath);
}

Future<String> transpile(String filePath, String? classOrPath, {String? overridePackage, bool skipFormat = false}) async {
  var (className, package, output) = getOutput(filePath, classOrPath, overridePackage);

  // Convert relative path to absolute path
  filePath = File(path.canonicalize(filePath)).absolute.path;

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
  // final unitResult = await session.getParsedUnit(filePath) as ParsedUnitResult;

  if (unitResult.errors.isNotEmpty) {
    print('Warnings/errors in the Dart file:');
    for (final error in unitResult.errors) {
      print('  ${error.message}');
    }
  }

  // Create a translator visitor to traverse the AST
  final translator = Dart2JavaVisitor(className, package);
  // unitResult.unit.accept(translator);
  unitResult.unit.accept(translator);

  // Generate the Java code
  String code = translator.generateJavaCode();
  // var output = path.absolute(path.join('build', '$className.java'));
  if (!skipFormat) {
    return format(code, output);
  }
  return code;
}

Future<String> format(String code, String output) async {
  File outFile = File(output);
  outFile.writeAsStringSync(code);

  String home = Platform.environment['HOME'] ?? Platform.environment['USERPROFILE'] ?? '';
  final p = await Process.start('java', ['-jar', '$home/bin/palantir-cli-2.61.0-standalone.jar', '-r', outFile.absolute.path]);
  print('Formatting java code...');
  p.stderr.transform(utf8.decoder).forEach(print);
  final exitCode = await p.exitCode;
  if (exitCode != 0) {
    print('formatting error, exit code: $exitCode');
  }
  print('Java code written to ${outFile.path}');
  return outFile.readAsString();
}

// class FlutterToJavaTranslator extends UnifyingAstVisitor<void> {
class Dart2JavaVisitor extends ToSourceVisitor {
  final Set<String> _imports = {};
  // late StringBuffer _code = StringBuffer();
  final String _className;
  final String? _package;
  int unused = 0;

  Dart2JavaVisitor(this._className, [this._package]) : super(SinkDeco()) {
    // _code = sink as StringBuffer;
  }

  // @override
  // StringSink get sink => (_isTopLevel) ? _toplevel : super.sink;
  //
  // void _toggleTopLevel(FunctionDeclaration node) {
  //   if (node.thisOrAncestorOfType<ClassDeclaration>() == null) {
  //     _isTopLevel = !_isTopLevel;
  //   }
  // }

  // @override
  // StringSink get sink => currentNode!.thisOrAncestorOfType<ClassDeclaration>() == null ? _toplevel : super.sink;

  // StringSink target(AstNode node) => node.thisOrAncestorOfType<ClassDeclaration>() == null ? _toplevel : super.sink;

  // @override
  // void visitNode(AstNode node) {
  //   target(node).write(node.toSource());
  //   print('src: ${node.runtimeType}: $node');
  // }

  SinkDeco get buffer => sink as SinkDeco;

  @override
  void visitCompilationUnit(CompilationUnit node) {
    node.visitChildren(this);
  }

  @override
  void visitImportDirective(ImportDirective node) {
    if (node.uri.stringValue == 'package:flutter/widgets.dart' ||
        node.uri.stringValue == 'package:flutter/material.dart') {
      _imports.add('static dev.equo.ewt.EWT.*');
      _imports.add('dev.equo.ewt.*');
    }
  }

  @override
  void visitFunctionDeclaration(FunctionDeclaration node) {
    buffer.toggleTopLevel(node);

    var modifiers = 'public static';

    write(node, '$modifiers ');
    // node.visitChildren(this);
    _visitNodeList(node.metadata, separator: ' ', suffix: ' ');
    // _visitToken(node.externalKeyword, suffix: ' ');
    _visitNode(node.returnType, suffix: ' ');
    _visitToken(node.propertyKeyword, suffix: ' ');
    _visitToken(node.name);
    // writeln(node, ' {');
    _visitNode(node.functionExpression);
    // writeln(node, '}');

    buffer.toggleTopLevel(node);
  }

  @override
  void visitFunctionExpression(FunctionExpression node) {
    if (node.parent is! FunctionDeclaration) {
      _visitNode(node.typeParameters);
      _visitNode(node.parameters);
      write(node, ' ->');
      _visitFunctionBody(node.body);
    } else {
      // super.visitFunctionExpression(node);
      _visitNode(node.typeParameters);
      _visitNode(node.parameters);
      if (node.body is ExpressionFunctionBody) {
        writeln(node, ' {');
      }
      _visitFunctionBody(node.body);
      if (node.body is ExpressionFunctionBody) {
        writeln(node, '}');
      }

    }
  }

  @override
  void visitFunctionExpressionInvocation(FunctionExpressionInvocation node) {
    _visitNode(node.function);
    _visitNode(node.typeArguments);
    var type = node.function.staticType;
    if (type is FunctionType) {
      var fnMethod = 'apply';
      if (type.parameters.isEmpty && type.returnType is VoidType) {
        fnMethod = 'run';
      // } else if (type.parameters.length == 1) {
      //   fnMethod = 'apply';
      // } else if (type.parameters.length == 2) {
      //   fnMethod = 'apply';
      }
      write(node, '.$fnMethod');
    }
    _visitNode(node.argumentList);
  }

  @override
  void visitBlock(Block node) {
    writeln(node, '{');
    _visitNodeList(node.statements, separator: '\n', suffix: '\n');
    writeln(node, '}');
  }

  @override
  void visitIfStatement(IfStatement node) {
    sink.write('if (');
    _visitNode(node.expression);
    // _visitNode(node.caseClause, prefix: ' ');
    sink.write(') ');
    _visitNode(node.thenStatement);
    _visitNode(node.elseStatement, prefix: ' else ');
  }

  @override
  void visitConditionalExpression(ConditionalExpression node) {
    node.condition.accept(this);
    write(node, ' ${node.question} ');
    node.thenExpression.accept(this);
    write(node, ' ${node.colon} ');
    node.elseExpression.accept(this);
  }

  @override
  void visitBinaryExpression(BinaryExpression node) {
    node.leftOperand.accept(this);
    write(node, ' ${node.operator} ');
    node.rightOperand.accept(this);
  }

  @override
  void visitIndexExpression(IndexExpression node) {
    node.realTarget.accept(this);
    var type = node.realTarget.staticType;
    if (type!.isDartCoreList) {
      write(node, '.get(');
    } else if (type.isDartCoreMap) {
      write(node, '.get(');
    } else {
      write(node, node.leftBracket);
    }
    node.index.accept(this);
    write(node, type.isDartCoreList || type.isDartCoreMap ? ')' : node.rightBracket);
  }

  @override
  void visitExpressionFunctionBody(ExpressionFunctionBody node) {
    // writeln(node, ' {');
    var returns = false;
    var decl = node.parent;
    if (decl is MethodDeclaration) {
      returns = (decl).returnType?.type is! VoidType;
    }
    if (decl is FunctionDeclaration) {
      returns = (decl).returnType?.type is! VoidType;
    }
    // if (returns) {
    //   write(node, 'return ');
    // }
    // node.expression.accept(this);
    // if (returns) {
    //   write(node, ';');
    // }
    // writeln(node);
    // writeln(node, '}');
    // if (decl is MethodDeclaration || decl is FunctionDeclaration) {
      // writeln(node, '{');
      if (returns) {
        write(node, 'return ');
      }
    // }
    _visitNode(node.expression);
    if (node.semicolon != null) {
      sink.writeln(';');
    }
    // if (decl is MethodDeclaration || decl is FunctionDeclaration) {
      // writeln(node, '}');
    // }
  }

  @override
  void visitFormalParameterList(FormalParameterList node) {
    var function = node.thisOrAncestorOfType<FunctionDeclaration>();
    if (function != null) {
      if (function.name.lexeme == 'main') {
        write(node, '(String[] args)');
      } else {
        super.visitFormalParameterList(node);
      }
      return;
    }
    if (node.parent is FunctionExpression) {
      write(node, '(');
      _visitNodeList(node.parameters, separator: ', ');
      write(node, ')');
      return;
    }
    var cons = node.thisOrAncestorOfType<ConstructorDeclaration>();
    if (cons != null) {
      write(node, '(');
      var nodes = isUserClass(cons.returnType) ? node.parameters.where((a) => isRequiredUserParam(a)).toList() : node.parameters;
      _visitNodeList(nodes, separator: ', ');
      write(node, ')');
      return;
    }
    var method = node.thisOrAncestorOfType<MethodDeclaration>();
    if (method != null) {
      write(node, '(');
      _visitNodeList(node.parameters, separator: ', ');
      write(node, ')');
      return;
    }
  }

  bool isRequiredUserParam(FormalParameter a) => a.isRequired || a.isFinal;

  @override
  void visitAnnotation(Annotation node) {
    write(node, node.toSource().replaceFirst('@o', '@O'));
    write(node, ' ');
    if (node.parent is MethodDeclaration) {
      final method = node.parent as MethodDeclaration;
      if (isPrivateToken(method.name)) {
        write(node, 'private ');
      } else if (method.declaredElement!.hasProtected ||
          method.declaredElement!.hasOverride) {
        write(node, 'protected ');
      }
    }
  }

  @override
  void visitAssignmentExpression(AssignmentExpression node) {
    var leftHandSide = node.leftHandSide;
    if (leftHandSide is PropertyAccess && (!isUserClass((leftHandSide).realTarget) /*|| !isUserClass(node.rightHandSide)*/)) {
      // setter
      _visitNode(leftHandSide);
      write(node, '(');
      _visitNode(node.rightHandSide);
      write(node, ')');
    } else if (leftHandSide is IndexExpression && leftHandSide.realTarget.staticType!.isDartCoreMap) {
      leftHandSide.realTarget.accept(this);
      write(node, '.put(');
      leftHandSide.index.accept(this);
      write(node, ', ');
      _visitNode(node.rightHandSide);
      write(node, ')');
    } else {
      _visitNode(leftHandSide);
      sink.write(' ');
      sink.write(node.operator.lexeme);
      sink.write(' ');
      _visitNode(node.rightHandSide);
    }
  }

  @override
  void visitDefaultFormalParameter(DefaultFormalParameter node) {
    writeParameter(node);
  }

  @override
  void visitSuperFormalParameter(SuperFormalParameter node) {
    writeParameter(node);
  }

  @override
  void visitFieldFormalParameter(FieldFormalParameter node) {
    writeParameter(node);
  }

  void writeParameter(FormalParameter node) {
    var type = node.declaredElement!.type;
    String t = javaType(type);
    write(node, '$t ${node.name}');
  }

  String javaType(DartType type, {bool boxed = false}) {
    var t = type.getDisplayString(withNullability: false);
    if (type.isDartCoreBool) {
      t = 'boolean';
    }
    else if (type is ParameterizedType && type.typeArguments.isNotEmpty) {
      t = '${type.name}<${type.typeArguments.map((p) => javaType(p, boxed: true)).join(', ')}>';
    }
    else if (type is FunctionType) {
      if (type.parameters.isEmpty && type.returnType is VoidType) {
        t = 'Runnable';
      } else if (type.parameters.length == 1) {
        t = 'Function<${javaType(type.parameters[0].type)}, ${javaType(type.returnType)}>';
      } else if (type.parameters.length == 2) {
        t = 'BiFunction<${javaType(type.parameters[0].type)}, ${javaType(type.parameters[1].type)}, ${javaType(type.returnType)}>';
      }
    }
    if (boxed) {
      if (type.isDartCoreBool) {
        t = 'Boolean';
      }
      if (type.isDartCoreInt) {
        t = 'Integer';
      }
      if (type.isDartCoreDouble) {
        t = 'Double';
      }
    }
    return javaify(t);
  }

  @override
  void visitMethodInvocation(MethodInvocation node) {
    if (node.methodName.name == 'runApp') {
      write(node, 'App.');
      super.visitMethodInvocation(node);
      // if (node.thisOrAncestorOfType<Block>() == null) {
        // write(node, ';');
      // }
    } else {
      final replace = replacementForMethod(node.realTarget?.staticType, node.methodName.name, node: node);
      if (replace?.$4 != null) {
        _imports.add(replace!.$4!);
      }
      if (replace?.$1 != null) {
        write(node, replace!.$1);
      }
      _visitNode(node.target);
      if (node.realTarget != null) {
        write(node, '.');
      }
      if (replace != null) {
        write(node, replace.$2);
      } else {
        _visitNode(node.methodName);
      }
      _visitNode(node.typeArguments);
      _visitNode(replace?.$5 ?? node.argumentList);
      if (replace?.$3 != null) {
        write(node, replace!.$3);
      }
    }
  }

  @override
  void visitArgumentList(ArgumentList node) {
    var parent = node.parent;
    if (parent is MethodInvocation && parent.methodName.name == 'runApp') {
      write(node, '(() -> ');
      _visitNodeList(node.arguments, separator: ', ');
      write(node, ')');
    } else {
      final isUser = (parent is InstanceCreationExpression && isUserClass(parent));

      write(node, '(');
      int length = node.arguments.length;
      var close = true;
      for (var i = 0; i < length; i++) {
        var argument = node.arguments[i];
        if (!isUser) {
          List<FormalParameterElement> mandatory = [];
          if (parent is InstanceCreationExpression) {
            mandatory = parent.constructorName.element!.formalParameters.where((p) => 'key' != p.name3).takeWhile((p) => p.isRequired).toList(growable: false);
          }
          else if (parent is MethodInvocation) {
            // mandatory = parent.target
            mandatory = (parent.staticInvokeType as FunctionType).formalParameters.where((p) => 'key' != p.name3).where((p) => p.isRequired).toList(growable: false);
          }
          if (argument is NamedExpression && mandatory.contains(argument.correspondingParameter)) {
            if (close && i != 0) {
              write(node, ', ');
            }
            argument.expression.accept(this);
          }
          else if (close && argument is NamedExpression) {
            write(node, ')');
            close = false;
            argument.accept(this);
          }
          else {
            if (close && i != 0) {
              write(node, ', ');
            }
            argument.accept(this);
          }
        } else {
          if (i != 0) {
            write(node, ', ');
          }
          if (argument is NamedExpression) {
            argument.expression.accept(this);
          } else {
            argument.accept(this);
          }
        }
      }
      if (close) {
        write(node, ')');
      }
    }
  }

  @override
  void visitNamedExpression(NamedExpression node) {
    writeln(node);
    write(node, '.${node.name.label}(');
    node.expression.accept(this);
    write(node, ')');
  }

  @override
  void visitSimpleFormalParameter(SimpleFormalParameter node) {
    _visitNodeList(node.metadata, separator: ' ', suffix: ' ');
    _visitToken(node.requiredKeyword, suffix: ' ');
    _visitToken(node.covariantKeyword, suffix: ' ');
    _visitToken(node.keyword, suffix: ' ');
    _visitNode(node.type);
    if (node.type != null && node.name != null) {
      sink.write(' ');
    }
    if (node.name?.lexeme == '_') {
      write(node, '_${unused++}');
    } else {
      _visitToken(node.name);
    }
  }

  @override
  void visitSimpleIdentifier(SimpleIdentifier node) {
    if ((node.parent is NamedExpression || node.parent is ConditionalExpression)) {
      if (node.element is MethodElement2) {
        write(node, 'this::');
      } else if (node.element is TopLevelFunctionElement) {
        write(node, '$_className::');
      }
    }
    super.visitSimpleIdentifier(node);
    if (node.parent is! MethodInvocation && node.parent?.parent is! AssignmentExpression) {
      if (node.element is GetterElement && !(node.element as GetterElement).isSynthetic) {
        write(node, '()');
      }
      else if (node.staticType?.element is! EnumElement && node.element is! EnumElement2 && node.element is! ClassElement2 && !isUserClass(node)) {
        write(node, '()');
      }

    }
  }

  @override
  void visitSimpleStringLiteral(SimpleStringLiteral node) {
    write(node, '"${node.value}"');
  }

  @override
  void visitInterpolationExpression(InterpolationExpression node) {
    write(node, '+');
    _visitNode(node.expression);
    write(node, '+');
  }

  @override
  void visitInterpolationString(InterpolationString node) {
    write(node, '"');
    write(node, node.value);
    write(node, '"');
  }

  @override
  void visitInstanceCreationExpression(InstanceCreationExpression node) {
    if (isUserClass(node)) {
      write(node, 'new ');
    }
    node.constructorName.accept(this);
    node.argumentList.accept(this);
  }

  @override
  void visitConstructorName(ConstructorName node) {
    if (node.name != null) {
      var repl = replacementForConstructor(node.type.type, node.name);
      if (repl != null) {
        write(node, repl);
        return;
      }
    }
    write(node, javaifyToken(node.type.name2));
    if (node.name != null) {
      write(node, '_${node.name}');
    }
  }

  @override
  void visitClassDeclaration(ClassDeclaration node) {
    if (isPrivateToken(node.name)) {
      // write(node, 'private ');
    }
    write(node, 'class ${javaifyToken(node.name)}');
    node.typeParameters?.accept(this);
    node.extendsClause?.accept(this);
    node.withClause?.accept(this);
    node.implementsClause?.accept(this);
    node.nativeClause?.accept(this);
    writeln(node, ' {');
    node.members.accept(this);
    writeln(node, '}');
  }

  @override
  void visitExtendsClause(ExtendsClause node) {
    write(node, ' extends Sub${node.superclass}');
  }

  @override
  void visitWithClause(WithClause node) {
    write(node, ' implements ${node.mixinTypes.map((m) => m.name2).join(', ')}');
  }

  @override
  void visitConstructorDeclaration(ConstructorDeclaration node) {
    _visitNodeList(node.metadata, separator: ' ', suffix: ' ');
    // if (node.declaredElement!.isPrivate) {
    //   write(node, 'private ');
    // } else if (node.declaredElement!.hasProtected) {
    //   write(node, 'protected ');
    // } else {
    // }
    write(node, 'public ');
    // _visitToken(node.factoryKeyword, suffix: ' ');
    _visitNode(node.returnType);
    // _visitToken(node.name, prefix: '.');
    _visitNode(node.parameters);
    // _visitNodeList(node.initializers, prefix: ' : ', separator: ', ');
    // _visitNode(node.redirectedConstructor, prefix: ' = ');
    _visitFunctionBody(node.body);
  }

  @override
  void visitSuperConstructorInvocation(SuperConstructorInvocation node) {
    // do not call super
  }

  @override
  void visitEmptyFunctionBody(EmptyFunctionBody node) {
    writeln(node, ' {');
    final cons = node.thisOrAncestorOfType<ConstructorDeclaration>()!;
    for (final param in cons.parameters.parameters) {
      if (param is DefaultFormalParameter) {
        if (param.parameter is SuperFormalParameter) {
        }
        else if (param.parameter is FieldFormalParameter) {
          if (isRequiredUserParam(param)) {
            writeln(node, 'this.${param.name} = ${param.name};');
          } else {
            writeln(node, 'this.${param.name} = ${param.defaultValue};');
          }
        }
      }
    }
    writeln(node, '}');
  }

  @override
  void visitMethodDeclaration(MethodDeclaration node) {
    if (node.metadata.isEmpty) {
      if (isPrivateToken(node.name)) {
        write(node, 'private ');
      } else if (node.declaredElement!.hasProtected ||
          node.declaredElement!.hasOverride) {
        write(node, 'protected ');
      }
    }
    if (node.isGetter) {
      node.returnType!.accept(this);
      write(node, ' ${node.name}()');
      _visitFunctionBody(node.body);
    } else {
      _visitNodeList(node.metadata, separator: ' ', suffix: ' ');
      _visitToken(node.augmentKeyword, suffix: ' ');
      _visitToken(node.externalKeyword, suffix: ' ');
      _visitToken(node.modifierKeyword, suffix: ' ');
      _visitNode(node.returnType, suffix: ' ');
      _visitToken(node.propertyKeyword, suffix: ' ');
      _visitToken(node.operatorKeyword, suffix: ' ');
      _visitToken(node.name);
      if (!node.isGetter) {
        _visitNode(node.typeParameters);
        _visitNode(node.parameters);
      }
      if (node.body is ExpressionFunctionBody) {
        writeln(node, ' {');
      }
      _visitFunctionBody(node.body);
      if (node.body is ExpressionFunctionBody) {
        writeln(node, '}');
      }
    }
  }

  @override
  void visitFieldDeclaration(FieldDeclaration node) {
    if (isPrivateToken(node.fields.variables[0].name)) {
      write(node, 'private ');
    }
    super.visitFieldDeclaration(node);
    writeln(node);
  }

  @override
  void visitNamedType(NamedType node) {
    write(node, javaType(node.type!));
  }

  @override
  void visitPropertyAccess(PropertyAccess node) {
    if (node.isCascaded) {
      // writeln(node, ';');
      // final variable = node.thisOrAncestorOfType<VariableDeclaration>();
      // sink.write(variable!.name);
      _visitNode(node.target);
      sink.write('.');
      _visitNode(node.propertyName);
    } else {
      _visitNode(node.target);
      var target = node.target;
      // if (target is SimpleIdentifier) {
      //   if (target.element is! EnumElement2 && target.element is! ClassElement2 && !isUserLibrary2(target.element?.library2)) {
      //     write(node, '()');
      //   }
      // }
      sink.write(node.operator.lexeme);
      final replace = replacementForMethod(node.target?.staticType, node.propertyName.name);
      if (replace != null) {
        write(node, replace.$2);
        if (!isUserLibrary2(node.propertyName.element?.library2)) {
          write(node, '()');
        }
      } else {
        _visitNode(node.propertyName);
      }
    }
  }

  @override
  void visitPrefixedIdentifier(PrefixedIdentifier node) {
    node.prefix.accept(this);
    // if (node.prefix.element is! EnumElement2 && node.prefix.element is! ClassElement2 && !isUserLibrary2(node.prefix.element?.library2)) {
    //   write(node, '()');
    // }
    write(node, '.');
    final replace = replacementForMethod(node.prefix.staticType, node.identifier.name);
    if (replace != null) {
      write(node, replace.$2);
      if (node.staticType?.element is! EnumElement && !isUserLibrary2(node.identifier.element?.library2)) {
        write(node, '()');
      }
    } else {
      node.identifier.accept(this);
    }
    // if (node.staticType?.element is! EnumElement && !isUserLibrary2(node.identifier.element?.library2)) {
    //   write(node, '()');
    // }
  }

  @override
  void visitListLiteral(ListLiteral node) {
    final hasIfElement = node.elements.whereType<IfElement>().isNotEmpty;
    if (hasIfElement) {
      _imports.add('java.util.stream.Stream');
      _imports.add('java.util.Objects');
      write(node, 'Stream.of(');
      _visitNodeList(node.elements, separator: ', ');
      sink.write(').filter(Objects::nonNull).toList()');
    } else {
      _imports.add('java.util.List');
      write(node, 'List');
      // _visitToken(node.constKeyword, suffix: ' ');
      // _visitNode(node.typeArguments);
      sink.write('.of(');
      _visitNodeList(node.elements, separator: ', ');
      sink.write(')');
    }
  }

  @override
  void visitSetOrMapLiteral(SetOrMapLiteral node) {
    _imports.add('java.util.Map');
    write(node, 'Map');
    sink.write('.of(');
    _visitNodeList(node.elements, separator: ', ');
    sink.write(')');
  }

  @override
  void visitIfElement(IfElement node) {
    sink.write('(');
    _visitNode(node.expression);
    // _visitNode(node.caseClause, prefix: ' ');
    sink.write(') ? ');
    _visitNode(node.thenElement);
    sink.write(' : ');
    if (node.elseElement != null) {
      _visitNode(node.elseElement);
    } else {
      sink.write('null');
    }
  }

  @override
  void visitVariableDeclarationList(VariableDeclarationList node) {
    _visitNodeList(node.metadata, separator: ' ', suffix: ' ');
    // _visitToken(node.lateKeyword, suffix: ' ');
    _visitToken(node.keyword, suffix: ' ');
    _visitNode(node.type, suffix: ' ');
    if (node.type == null) {
      write(node, 'var ');
    }
    _visitNodeList(node.variables, separator: ', ');
  }

  void _visitFunctionBody(FunctionBody body) {
    if (body is! EmptyFunctionBody) {
      sink.write(' ');
    }
    _visitNode(body);
  }

  void _visitNode(AstNode? node, {String prefix = '', String suffix = ''}) {
    if (node != null) {
      sink.write(prefix);
      node.accept(this);
      sink.write(suffix);
    }
  }

  void _visitNodeList(List<AstNode> nodes,
      {String prefix = '', String separator = '', String suffix = ''}) {
    var length = nodes.length;
    if (length > 0) {
      sink.write(prefix);
      for (int i = 0; i < length; i++) {
        if (i > 0) {
          sink.write(separator);
        }
        nodes[i].accept(this);
      }
      sink.write(suffix);
    }
  }

  void _visitToken(Token? token, {String prefix = '', String suffix = ''}) {
    if (token != null) {
      sink.write(prefix);
      sink.write(token.lexeme);
      sink.write(suffix);
    }
  }

  bool isPrivateToken(Token name) => isPrivate(name.lexeme);
  bool isPrivate(String name) => name.startsWith('_');

  String javaifyToken(Token name) {
    var lexeme = name.lexeme;
    return javaify(lexeme);
  }

  String javaify(String lexeme) {
    if (isPrivate(lexeme)) {
      return lexeme.substring(1);
    }
    return lexeme;
  }

  bool isUserClass(Expression node) {
    if (node is SimpleIdentifier) {
      var lib = node.element?.library2;
      return isUserLibrary2(lib);
    }
    if (node is PropertyAccess) {

    }
    final lib = node.staticType?.element?.library;
    return isUserLibrary(lib);
  }

  bool isUserLibrary(LibraryElement? lib) => lib == null || !lib.isDartCore && isUserLibraryId(lib.identifier);
  bool isUserLibraryId(String id) => !id.startsWith('dart:') && !id.startsWith('package:flutter') && !id.startsWith('package:widgets');
  bool isUserLibrary2(LibraryElement2? lib) => lib == null || isUserLibraryId(lib.identifier);

  void writeln(AstNode node, [Object? obj = ""]) {
    buffer.writeln(obj);
  }

  void write(AstNode node, [Object? obj = ""]) {
    buffer.write(obj);
  }

  String generateJavaCode() {
    final code = StringBuffer();

    // Add package declaration
    if (_package != null && _package.isNotEmpty) {
      code.writeln('package $_package;');
      code.writeln();
    }

    // Add imports
    for (final i in _imports) {
      code.writeln('import $i;');
    }
    code.writeln();

    if (buffer._toplevel.isNotEmpty) {
      code.writeln('public class $_className {');
      code.writeln(buffer._toplevel);
      code.writeln('}');
    }
    code.write(buffer._code);

    return code.toString();
  }

  (String?, String, String?, String?, ArgumentList?)? replacementForMethod(DartType? staticType, String? name, {MethodInvocation? node}) {
    if (staticType == null) {
      return null;
    }

    if (staticType.isDartCoreList) {
      return switch (name) {
        'length' => (null, 'size', null, null, null),
        'sublist' => subListMethod(node!),
        'join' => (null, 'stream().collect(Collectors.joining', ')', 'java.util.stream.Collectors', null),
        _ => null,
      };
    }
    if (staticType.isDartCoreString) {
      return switch (name) {
        'split' => ('Arrays.stream(', 'split', ').toList()', 'java.util.Arrays', null),
        _ => null,
      };
    }
    return null;
  }

  (String?, String, String?, String?, ArgumentList?) subListMethod(
      MethodInvocation node) {
    var argList = (node.argumentList.arguments.length == 1) ?
      ArgumentListImpl(leftParenthesis: node.beginToken, arguments:
        List.of(
            List.castFrom<Expression, ExpressionImpl>(node.argumentList.arguments))
          ..add(PropertyAccessImpl(target: node.target as ExpressionImpl, operator: Token(TokenType.PERIOD, 0), propertyName: SimpleIdentifierImpl(StringTokenImpl.fromString(TokenType.IDENTIFIER, 'size()', 0)))), rightParenthesis: node.beginToken)
      : null;
    return (null, 'subList', null, null, argList);
  }

  String? replacementForConstructor(DartType? staticType, SimpleIdentifier? name) {
    if (staticType != null && staticType.isDartCoreList) {
      var e = switch (name?.token.lexeme) {
        'filled' => 'Collections.nCopies',
        _ => null,
      };
      if (e != null) {
        _imports.add('java.util.Collections');
      }
      return e;
    }
    return null;
  }

}

class SinkDeco implements StringSink {
  final StringBuffer _code = StringBuffer();
  final StringBuffer _toplevel = StringBuffer();
  bool _isTopLevel = false;

  SinkDeco();

  StringSink get sink => (_isTopLevel) ? _toplevel : _code;

  void toggleTopLevel(FunctionDeclaration node) {
    if (node.thisOrAncestorOfType<ClassDeclaration>() == null) {
      _isTopLevel = !_isTopLevel;
    }
  }

  @override
  void write(Object? object) {
    sink.write(object);
    tag(object);
  }

  void tag(Object? object) {
    if (object.toString().isNotEmpty) {
      var caller = StackTrace.current.toString().split('\n').firstWhere((l) => l.contains('.visit'));
      final [className, methodName, filePath, line] = RegExp(r'#\d+\s+([^.]+)\.([^\s]+)\s+\((.+\.dart):(\d+):\d+\)').firstMatch(caller)?.groups([1, 2, 3, 4]) ?? ['', '', '', ''];
      print('${'${className!.replaceFirst('Visitor', '')}:$methodName:'.padRight(45)} ${object.toString().padRight(65)} (${filePath!}:$line)');
    }
  }

  @override
  void writeAll(Iterable objects, [String separator = ""]) {
    sink.writeAll(objects, separator);
    print('src: $objects');
  }

  @override
  void writeCharCode(int charCode) {
    sink.writeCharCode(charCode);
    print('src: $charCode');
  }

  @override
  void writeln([Object? object = ""]) {
    sink.writeln(object);
    tag(object);
  }

}