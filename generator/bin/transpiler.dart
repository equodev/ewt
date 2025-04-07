import 'dart:convert';
import 'dart:io';
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/ast/token.dart';
import 'package:analyzer/dart/ast/visitor.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/element2.dart';
import 'package:analyzer/dart/element/type.dart';
import 'package:path/path.dart' as path;

// Get the SDK path
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
    print(javaCode);

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
  final translator = FlutterToJavaTranslator(className, package);
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
  final exitCode = await p.exitCode;
  print('format exit code: $exitCode');
  print('Java code written to ${outFile.path}');
  return outFile.readAsString();
}

class FlutterToJavaTranslator extends UnifyingAstVisitor<void> {
  final Set<String> _imports = {};
  final StringBuffer _code = StringBuffer();
  final StringBuffer _toplevel = StringBuffer();
  final String _className;
  final String? _package;

  FlutterToJavaTranslator(this._className, [this._package]);

  StringBuffer target(AstNode node) => node.thisOrAncestorOfType<ClassDeclaration>() == null ? _toplevel : _code;

  @override
  void visitNode(AstNode node) {
    target(node).write(node.toSource());
    print('src: ${node.runtimeType}: $node');
  }

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
  //   if (node.name.lexeme == 'main') {
  //     // We've found the main function, continue traversing it
    var modifiers = 'public static';

    write(node, '$modifiers ');
    // write(node, node.toSource());
    node.visitChildren(this);

    // writeln(node, '}');
    // super.visitFunctionDeclaration(node);
  //   }
  }

  @override
  void visitFunctionExpression(FunctionExpression node) {
    if (node.parent is! FunctionDeclaration) {
      node.typeParameters?.accept(this);
      node.parameters?.accept(this);
      write(node, ' ->');
      node.body.accept(this);
    } else {
      super.visitNode(node);
    }
  }

  @override
  void visitBlockFunctionBody(BlockFunctionBody node) {
    super.visitNode(node);
  }

  @override
  void visitBlock(Block node) {
    writeln(node, ' {');
    for (var stmt in node.statements) {
      stmt.accept(this);
      if (stmt is! IfStatement)
        writeln(node, ';');
    }
    writeln(node, '}');
  }

  @override
  void visitExpressionStatement(ExpressionStatement node) {
    super.visitNode(node);
  }

  @override
  void visitIfStatement(IfStatement node) {
    write(node, 'if (');
    node.expression.accept(this);
    write(node, ')');
    node.thenStatement.accept(this);
    // writeln(node, '}');
    if (node.elseStatement != null) {
      write(node, '${node.elseKeyword}');
      node.elseStatement?.accept(this);
      // writeln(node, '}');
    }
  }

  @override
  void visitVariableDeclarationStatement(VariableDeclarationStatement node) {
    super.visitNode(node);
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
    write(node, node.realTarget.staticType!.isDartCoreList ? '.get(' : node.leftBracket);
    node.index.accept(this);
    write(node, node.realTarget.staticType!.isDartCoreList ? ')' : node.rightBracket);
  }

  @override
  void visitExpressionFunctionBody(ExpressionFunctionBody node) {
    writeln(node, ' {');
    var returns = false;
    if (node.parent is MethodDeclaration) {
      returns = (node.parent as MethodDeclaration).returnType?.type is! VoidType;
    }
    if (node.parent is FunctionDeclaration) {
      returns = (node.parent as FunctionDeclaration).returnType?.type is! VoidType;
    }
    if (returns) {
      write(node, 'return ');
    }
    super.visitNode(node);
    if (returns) {
      write(node, ';');
    }
    writeln(node);
    writeln(node, '}');
  }

  @override
  void visitFunctionDeclarationStatement(FunctionDeclarationStatement node) {
    // TODO: implement visitFunctionDeclarationStatement
    super.visitFunctionDeclarationStatement(node);
  }

  @override
  void visitFormalParameterList(FormalParameterList node) {
    var function = node.thisOrAncestorOfType<FunctionDeclaration>();
    if (function != null) {
      write(node, ' ${function.name}');
      if (function.name.lexeme == 'main') {
        write(node, '(String[] args)');
      } else {
        super.visitNode(node);
      }
      return;
    }
    if (node.parent is FunctionExpression) {
      write(node, '(');
      for (var i = 0; i < node.parameters.length; i++) {
        var param = node.parameters[i];
        if (i != 0) {
          write(node, ', ');
        }
        param.accept(this);
      }
      write(node, ')');
      return;
    }
    var cons = node.thisOrAncestorOfType<ConstructorDeclaration>();
    if (cons != null) {
      write(node, '(');
      for (var i = 0; i < node.parameters.length; i++) {
        var param = node.parameters[i];
        if (i != 0) {
          write(node, ', ');
        }
        param.accept(this);
      }
      write(node, ')');
      return;
    }
    var method = node.thisOrAncestorOfType<MethodDeclaration>();
    if (method != null) {
      write(node, ' ${method.name}');
      write(node, '(');
      for (var i = 0; i < node.parameters.length; i++) {
        var param = node.parameters[i];
        if (i != 0) {
          write(node, ', ');
        }
        param.accept(this);
      }
      write(node, ')');
      return;
    }
    visitNode(node);
  }

  @override
  void visitAnnotation(Annotation node) {
    write(node, node.toSource().replaceFirst('@o', '@O'));
    write(node, ' ');
    if (node.parent is MethodDeclaration) {
      final method = node.parent as MethodDeclaration;
      if (isPrivate(method.name)) {
        write(node, 'private ');
      } else if (method.declaredElement!.hasProtected ||
          method.declaredElement!.hasOverride) {
        write(node, 'protected ');
      }
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
    if (boxed && (type.isDartCoreBool || type.isDartCoreInt || type.isDartCoreDouble)) {
      t = t[0].toUpperCase() + t.substring(1);
    }
    return t;
  }

  @override
  void visitMethodInvocation(MethodInvocation node) {
    if (node.methodName.name == 'runApp') {
      write(node, 'App.');
      super.visitNode(node);
      if (node.thisOrAncestorOfType<Block>() == null) {
        write(node, ';');
      }
    } else {
      node.target?.accept(this);
      if (node.target != null) {
        write(node, '.');
      }
      node.methodName.accept(this);
      node.typeArguments?.accept(this);
      node.argumentList.accept(this);
    }
  }

  @override
  void visitArgumentList(ArgumentList node) {
    var parent = node.parent;
    if (parent is MethodInvocation && parent.methodName.name == 'runApp') {
      write(node, '(() -> ');
      super.visitNode(node);
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
            mandatory = parent.constructorName.element!.formalParameters.takeWhile((p) => p.isRequired).toList(growable: false);
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
      // super.visitNode(node);
      // svisitNode(node);
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
  void visitSimpleIdentifier(SimpleIdentifier node) {
    if (node.parent is NamedExpression && node.element is MethodElement2) {
      write(node, 'this::');
      visitNode(node);
    } else {
      visitNode(node);
    }
  }

  @override
  void visitSimpleStringLiteral(SimpleStringLiteral node) {
    write(node, '"${node.value}"');
  }

  @override
  void visitStringInterpolation(StringInterpolation node) {
    super.visitNode(node);
  }

  @override
  void visitInterpolationExpression(InterpolationExpression node) {
    write(node, '+');
    super.visitNode(node);
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
    super.visitNode(node);
  }

  @override
  void visitAssignmentExpression(AssignmentExpression node) {
    node.leftHandSide.accept(this);
    write(node, ' = ');
    node.rightHandSide.accept(this);
  }

  @override
  void visitConstructorName(ConstructorName node) {
    write(node, javaify(node.type.name2));
    if (node.name != null) {
      write(node, '_${node.name}');
    }
  }

  @override
  void visitClassDeclaration(ClassDeclaration node) {
    if (isPrivate(node.name)) {
      // write(node, 'private ');
    }
    write(node, 'class ${javaify(node.name)}');
    // super.visitChildren(visitor);
    node.typeParameters?.accept(this);
    node.extendsClause?.accept(this);
    node.withClause?.accept(this);
    node.implementsClause?.accept(this);
    node.nativeClause?.accept(this);
    writeln(node, ' {');
    node.members.accept(this);
    writeln(node, '}');
    // super.visitNode(node);
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
    // if (node.declaredElement!.isPrivate) {
    //   write(node, 'private ');
    // } else if (node.declaredElement!.hasProtected) {
    //   write(node, 'protected ');
    // } else {
      write(node, 'public ');
    // }
    super.visitNode(node);
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
          writeln(node, 'this.${param.name} = ${param.name};');
        }
      }
    }
    writeln(node, '}');
  }

  @override
  void visitComment(Comment node) {
    // TODO: implement visitComment
    super.visitComment(node);
  }

  @override
  void visitCommentReference(CommentReference node) {
    // TODO: implement visitCommentReference
    super.visitCommentReference(node);
  }

  @override
  void visitMethodDeclaration(MethodDeclaration node) {
    if (node.metadata.isEmpty) {
      if (isPrivate(node.name)) {
        write(node, 'private ');
      } else if (node.declaredElement!.hasProtected ||
          node.declaredElement!.hasOverride) {
        write(node, 'protected ');
      }
    }
    if (node.isGetter) {
      node.returnType!.accept(this);
      write(node, ' ${node.name}()');
      node.body.accept(this);
    } else {
      super.visitNode(node);
    }
  }

  @override
  void visitReturnStatement(ReturnStatement node) {
    write(node, 'return ');
    super.visitNode(node);
    // write(node, ';');
  }

  @override
  void visitFieldDeclaration(FieldDeclaration node) {
    if (isPrivate(node.fields.variables[0].name)) {
      write(node, 'private ');
    }
    super.visitNode(node);
    writeln(node, ';');
  }

  @override
  void visitVariableDeclarationList(VariableDeclarationList node) {
    if (node.isFinal) {
      write(node, 'final ');
    }
    super.visitNode(node);
  }

  @override
  void visitVariableDeclaration(VariableDeclaration node) {
    write(node, ' ');
    super.visitVariableDeclaration(node);
  }

  @override
  void visitNamedType(NamedType node) {
    write(node, javaType(node.type!));
    // if (node.type!.isDartCoreBool) {
    //   write(node, javaType(node.type!));
    // }
    // else if (node.name2.lexeme == 'VoidCallback') {
    //   write(node, 'Runnable');
    // } else {
    //   super.visitNamedType(node);
    // }
  }

  @override
  void visitPropertyAccess(PropertyAccess node) {
    node.target?.accept(this);
    write(node, '.');
    node.propertyName.accept(this);
    write(node, '()');
  }

  @override
  void visitPrefixedIdentifier(PrefixedIdentifier node) {
    node.prefix.accept(this);
    if (node.prefix.element is! EnumElement2 && node.prefix.element is! ClassElement2 && !isUserLibrary2(node.prefix.element?.library2)) {
      write(node, '()');
    }
    write(node, '.');
    node.identifier.accept(this);
    if (node.staticType?.element is! EnumElement && !isUserLibrary2(node.identifier.element?.library2)) {
      write(node, '()');
    }
  }

  @override
  void visitListLiteral(ListLiteral node) {
    _imports.add('java.util.List');
    write(node, 'List.of(');
    for (var i=0; i < node.elements.length ; i++) {
      if (i>0) {
        write(node, ', ');
      }
      node.elements[i].accept(this);
    }
    write(node, ')');
  }

  bool isPrivate(Token name) =>  name.lexeme.startsWith('_');

  String javaify(Token name) {
    if (isPrivate(name)) {
      return name.lexeme.substring(1);
    }
    return name.lexeme;
  }

  bool isUserClass(Expression node) {
    final lib = node.staticType!.element!.library;
    var isUserClass = isUserLibrary(lib);
    return isUserClass;
  }

  bool isUserLibrary(LibraryElement? lib) => !lib!.isDartCore && isUserLibraryId(lib.identifier);
  bool isUserLibraryId(String id) => !id.startsWith('package:flutter') && !id.startsWith('package:widgets');
  bool isUserLibrary2(LibraryElement2? lib) => lib == null || isUserLibraryId(lib.identifier);

  void writeln(AstNode node, [Object? obj = ""]) {
    target(node).writeln(obj);
    print('cst: ${node.runtimeType}: $obj');
  }

  void write(AstNode node, [Object? obj = ""]) {
    target(node).write(obj);
    print('cst: ${node.runtimeType}: $obj');
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

    if (_toplevel.isNotEmpty) {
      code.writeln('public class $_className {');
      code.writeln(_toplevel);
      code.writeln('}');
    }
    code.write(_code);


    // // Add class declaration
    // code.writeln('public class $_className {');
    // code.writeln('    public static void main(String[] args) {');
    //
    // // Add main method content
    // code.write('        ');
    // code.write(_mainMethod);
    //
    // // Close class
    // code.writeln(';');
    // code.writeln('    }');
    // code.writeln('}');

    return code.toString();
  }

}