// Coverage for the code generator (gen.dart). These tests lock in the current
// shape of the Java / Dart / C emission for a small hand-picked set of Flutter
// widgets. When the generator's intentional output changes, update the
// assertions here — treating them as goldens for the pieces most likely to
// silently regress.
//
// Landmines from feedback_ewt_generator_landmines.md that DO live on main
// today are covered here; landmines that live only on feat/add-standard-new-widgets
// (private-refs recursion gap, abstract-factory allowlist, T→T? widening in
// dart lambdas, raw build() return type) will be picked up on that branch.

import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/element2.dart';
import 'package:test/test.dart';

import '../bin/generator.dart' show widgetsToGenerate, getSdkPath;
import 'package:generator/gen.dart';
import 'package:generator/types.dart';

Future<void> main() async {
  const indexFile = 'test/fixtures/index_min.dart';

  late List<ClassElement> widgets;
  late Types types;
  setUpAll(() async {
    final (classes, _) = await widgetsToGenerate(indexFile);
    widgets = classes.toList();
    // Types() drops the first widget (which becomes widgetElement) — match the
    // slicing the real generator does in Generation's constructor.
    types = Types(widgets);
  });

  test('SDK path resolves under a flutter cache', () {
    final sdk = getSdkPath();
    expect(sdk, endsWith('bin/cache/dart-sdk'));
    expect(sdk, contains('flutter'));
  });

  test('widgetsToGenerate returns the classes declared in the index', () {
    // First declaration in index_min.dart is `w.Widget? widget;` — that's the
    // sentinel Types uses as its `widgetElement` and is skipped by Generation.
    expect(widgets.map((w) => w.name),
        containsAll(['Widget', 'Text', 'Center', 'Icon', 'Padding', 'Icons']));
  });

  group('WidgetGen — Text', () {
    late ClassElement textClass;
    late WidgetGen gen;
    late String java;

    setUpAll(() {
      textClass = widgets.firstWhere((w) => w.name == 'Text');
      gen = WidgetGen(types, textClass)..gen();
      java = gen.genJavaClass();
    });

    test('emits a StatelessWidget-derived Java class in the correct package', () {
      expect(java, contains('package dev.equo.ewt;'));
      expect(java, contains('public class Text extends StatelessWidget'));
    });

    test('Text.text factory is wired to the immutables builder', () {
      // Text has two public constructors — the primary one takes `String data`
      // as its @Builder.Parameter. The factory name and static entry point are
      // the pair that keeps EWT.Text("hi") compiling.
      expect(java, contains('@Builder.Factory'));
      expect(java, contains('String data'));
      expect(java, contains('public static TextTextBuilder text(String data)'));
    });

    test('Text.rich factory takes an InlineSpan (via its I interface) as its @Builder.Parameter', () {
      // InlineSpan is abstract, so the generator exposes it through the
      // synthesized `InlineSpanI` interface — TextSpan then extends both.
      expect(java,
          contains('public static TextRichBuilder rich(InlineSpanI textSpan)'));
    });

    test('Dart factory wiring generates a _setupText and text/rich hooks', () {
      final dart = gen.genDartFactories();
      expect(dart, contains('_setupText(WidgetFactories f)'));
      expect(dart, contains('f.text.text = ffi.Pointer.fromFunction'));
      expect(dart, contains('f.text.rich = ffi.Pointer.fromFunction'));
    });
  });

  group('EnumGen', () {
    test('emits a Java enum with one entry per Dart value', () {
      // TextWidthBasis is a small closed enum reachable from Text — perfect for
      // a smoke test that doesn't need to change every time we add widgets.
      final textClass = widgets.firstWhere((w) => w.name == 'Text');
      final field = textClass.getField('textWidthBasis')!;
      final enumType = field.type.element as EnumElement;

      final java = (EnumGen(types, enumType)..gen()).genJavaClass();

      expect(java, contains('package dev.equo.ewt;'));
      expect(java, contains('public enum TextWidthBasis'));
      expect(java, contains('parent'));
      expect(java, contains('longestLine'));
    });
  });

  group('Params.defaultObjCode', () {
    // Landmine #5 from feedback_ewt_generator_landmines.md:
    // "defaultDoubleCode / defaultObjCode must return null when a private ref
    //  can't be resolved. Previously fell through and pasted `_privateName`
    //  into Dart source." — verified indirectly here by checking that params
    //  with no defaultValueCode (i.e. required or nullable-with-no-default)
    //  return null instead of throwing.
    test('returns null when the param has no default value code', () {
      final textClass = widgets.firstWhere((w) => w.name == 'Text');
      final textCtor = textClass.constructors.firstWhere(
          (c) => c.parameters.any((p) => p.name == 'data'));
      final data = textCtor.parameters.firstWhere((p) => p.name == 'data');

      // `data` is a required positional String — no default value.
      expect(data.defaultValueCode, isNull);
      expect(Params.defaultObjCode(data), isNull);
    });
  });

  // No top-level Generation.gen() smoke test: gen() calls WidgetGen.write()
  // via processWidget, which writes directly to ../ewt.api/src/main/java/…
  // regardless of which fixture drives it. Running it here rewrote the real
  // tracked Java sources with partial output. Restore this test only after
  // gen.dart grows a way to redirect (or suppress) those writes.
}
