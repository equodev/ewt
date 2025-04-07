import 'dart:io';
import 'dart:math';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:path/path.dart' as path;
import 'package:test/test.dart';
import 'package:analyzer/dart/analysis/features.dart';
import 'package:analyzer/dart/analysis/utilities.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/ast/visitor.dart';

import '../bin/transpiler.dart';

void main() {
  group('Output Class', () {
    test('filename without second arg', () {
      var output = getOutput('file.dart', null);
      expectOutput(output, 'File', '', 'File.java');
    });

    test('path without second arg', () {
      var output = getOutput('some/relative/file.dart', null);
      expectOutput(output, 'File', '', 'File.java');
    });

    test('path absolute without second arg', () {
      var output = getOutput('/some/abs/a_File.dart', null);
      expectOutput(output, 'A_File', '', 'A_File.java');
    });

    test('filename with class name', () {
      var output = getOutput('file.dart', 'AClass');
      expectOutput(output, 'AClass', '', 'AClass.java');
    });

    test('path with with fqn', () {
      var output = getOutput('some/relative/file.dart', 'a.pack.TheClass');
      expectOutput(output, 'TheClass', 'a.pack', 'a/pack/TheClass.java');
    });

    test('path with with java file', () {
      var output = getOutput('some/relative/file.dart', 'UnaClase.java');
      expectOutput(output, 'UnaClase', '', 'UnaClase.java');
    });

    test('path with with java package', () {
      var output = getOutput('some/file.dart', 'the/pack/UnaClase.java');
      expectOutput(output, 'UnaClase', 'the.pack', 'the/pack/UnaClase.java');
    });

    test('path with with java package', () {
      var output = getOutput('some/file.dart', 'pack/UnaClase');
      expectOutput(output, 'UnaClase', 'pack', 'pack/UnaClase.java');
    });

    test('path with with src folder', () {
      var output = getOutput('some/file.dart', 'src/pack/UnaClase');
      expectOutput(output, 'UnaClase', 'pack', 'src/pack/UnaClase.java');
    });

    test('path with with src main folder', () {
      var output = getOutput('some/file.dart', '../main/java/a/pack/UnaClase');
      expectOutput(
          output, 'UnaClase', 'a.pack', '../main/java/a/pack/UnaClase.java');
    });

    test('override package', () {
      var output = getOutput(
          'some/file.dart', 'src/pack/UnaClase', 'another.pack');
      expectOutput(
          output, 'UnaClase', 'another.pack', 'src/pack/UnaClase.java');
    });
  });

  group('Dart to Java Transpiler', () {
    test('Counter App Test', () async {
      final dartInput = 'test/fixtures/counter.dart';
      final actualOutput = transpile(dartInput, 'build/Counter', overridePackage: '');
      final expectedOutput = File('test/fixtures/counter.java')
          .readAsStringSync();

      expect(actualOutput, completion(equals(expectedOutput)));

      // // Write files for manual verification
      // File('input.dart').writeAsStringSync(dartInput);
      // File('actual_output.java').writeAsStringSync(actualOutput);
      // File('expected_output.java').writeAsStringSync(expectedOutput);
    });

    test('Simple Widget Test', () async {
      final dartInput = 'test/fixtures/hello.dart';
      final actualOutput = transpile(dartInput, 'build/Hello', overridePackage: '');
      final expectedOutput = File('test/fixtures/hello.java')
          .readAsStringSync();

      expect(actualOutput, completion(equals(expectedOutput)));
    });
  });

  group('Dart to Java Fragments', () {
    final imports = '''
        import static dev.equo.ewt.EWT.*;
        import dev.equo.ewt.*;''';
    test('void Function() should be Runnable', () async {
      var dartFile = File('build/voidCallback.dart')..writeAsStringSync('''
        import 'dart:ui' show VoidCallback;
        class Action {
          final VoidCallback onNext;
          final bool isLastSubStep;
          const Action({ required this.onNext, this.isLastSubStep = false});
        }''');
      final actualOutput = await transpile(dartFile.path, 'VoidCallback', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''
        class Action {
          final Runnable onNext;
          final boolean isLastSubStep;
          public Action(Runnable onNext, boolean isLastSubStep) {
            this.onNext = onNext;
            this.isLastSubStep = isLastSubStep;
          }
        }'''));
    });

    test('super() should not be called', () async {
      var dartFile = File('build/super.dart')..writeAsStringSync('''
        class Action {
            const Action({String? key}) : super(key: key);
        }''');
      final actualOutput = await transpile(dartFile.path, 'Super', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''
        class Action {
          public Action(String key) { }
        }'''));
    });

    test('with mixin should be interface', () async {
      var dartFile = File('build/with.dart')..writeAsStringSync('''
        import 'package:flutter/widgets.dart';
        class _ActionPopupState extends State<ActionPopup> with SingleTickerProviderStateMixin { }''');
      final actualOutput = await transpile(dartFile.path, 'With', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''$imports
        class ActionPopupState extends SubState<ActionPopup> implements SingleTickerProviderStateMixin { }'''));
    });

    test('primitive in generic', () async {
      var dartFile = File('build/generic.dart')..writeAsStringSync('''
        import 'package:flutter/widgets.dart';
        class A { 
          late Animation<double> _animation;
        }''');
      final actualOutput = await transpile(dartFile.path, 'Generic', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''$imports
        class A {
          private Animation<Double> _animation;
        }'''));
    });

    test('assignments', () async {
      var dartFile = File('build/assign.dart')..writeAsStringSync('''
        import 'package:flutter/widgets.dart';
        class A { 
          void initState() {
            super.initState();
            _animationController = AnimationController(vsync: this, duration: const Duration(milliseconds: 300),);
            _animation = CurvedAnimation(parent: _animationController, curve: Curves.easeInOut);
          }
        }''');
      final actualOutput = await transpile(dartFile.path, 'Assign', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''$imports
        class A {
          void initState() {
            super.initState();
            _animationController = AnimationController() .vsync(this) .duration(Duration() .milliseconds(300));
            _animation = CurvedAnimation(_animationController, Curves.easeInOut());
          }
        }'''));
    });

    test('getter', () async {
      var dartFile = File('build/getter.dart')..writeAsStringSync('''
        class A { 
          String get buttonText {
            if (widget.currentAction >= widget.actions.length - 1) {
              return widget.isLastSubStep ? 'Finish Step' : 'Next Substep';
            }
            return 'Next';
          }
        }''');
      final actualOutput = await transpile(dartFile.path, 'Getter', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''
        class A {
          String buttonText() {
            if (widget.currentAction >= widget.actions.length() - 1) {
              return widget.isLastSubStep ? "Finish Step" : "Next Substep";
            }
            return "Next";
          }
        }'''));
    });

    test('binary expression with list', () async {
      var dartFile = File('build/list.dart')..writeAsStringSync('''
        class B {
          List<String> actions;
          String expr() => actions[widget.currentAction].split(' ').sublist(0, 2).join(' ') + ' ';
        }''');
      final actualOutput = await transpile(dartFile.path, 'List', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''
        class B {
          List<String> actions;
          String expr() {
            return actions.get(widget.currentAction).split(" ").sublist(0, 2).join(" ") + " ";
          }
        }'''));
    });

    test('cascades', () async {
      var dartFile = File('build/cascade.dart')..writeAsStringSync('''
        class TrianglePainter {
          void paint(Canvas canvas, Size size) {
            final paint = Paint()
              ..color = const Color(0xFF3F51B5)
              ..style = PaintingStyle.fill;
          }
        }''');
      final actualOutput = await transpile(dartFile.path, 'Cascade', skipFormat: true);
      expect(actualOutput, equalsIgnoringWhitespace('''
        class TrianglePainter {
          void paint(Canvas canvas, Size size) {
            final paint = Paint();
            paint.color = Color(0xFF3F51B5);
            paint.style = PaintingStyle.fill;
          }
        }'''));
    });
  });
}

void expectOutput((String, String, String) output, String expectedClass, String expectedPackage, String expectedFile) {
  var (clazz, package, file) = output;
  expect(clazz, equals(expectedClass), reason: 'class does not match');
  expect(package, equals(expectedPackage), reason: 'package does not match');
  expect(file, equals(expectedFile), reason: 'wrong file');
}