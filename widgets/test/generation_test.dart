
import 'dart:math';

import 'package:analyzer/dart/element/element.dart';
import 'package:flutter_test/flutter_test.dart';

import '../tool/generator.dart';

Future<void> main() async {
  late Iterable<ClassElement> widgets;
  setUpAll(() async {
    widgets = await widgetsToGenerate();
  });

  test('dart sdk path', () {
    var sdk = getSdkPath();
    expect(sdk, endsWith('bin/cache/dart-sdk'));
    expect(sdk, contains('flutter'));
  });

  test('Index processed', () async {
    expect(widgets.length, greaterThan(0));
    expect(widgets.where((w) => w.name == 'Text'), isNotEmpty);
  });

  group("java generation", () {
    test('Text widget generated', () async {
      var textClass = _testWidget(widgets);
      expect(textClass.constructors, hasLength(2));

      var widgetGen = WidgetGen(Generation([textClass]), textClass);
      String content = widgetGen.genJavaClass();

      expect(content, contains('package dev.equo.ewt;'));
      expect(content, contains('import org.immutables.builder.Builder;'));
      expect(content, contains('public class Text implements Widget {'));
      expect(content, contains('static final WidgetConstructors factories = WidgetConstructors.instance;'));
      expect(content, contains('@Builder.Constructor'));
      expect(content, contains('Text(@Builder.Parameter String data,'));
      expect(content, contains('factories.textOf(data,'));
      expect(content, contains('public static TextBuilder of(String data) {'));
      expect(content, contains('return TextBuilder.Text(data);'));
      expect(content, contains('Text(InlineSpan textSpan,'));
      expect(content, contains('@Builder.Factory'));
      expect(content, contains(
          'static Text textRich(@Builder.Parameter InlineSpan textSpan,'));
      expect(content, contains('factories.textRich(textSpan,'));
      expect(content, contains('return new Text(textSpan,'));
      expect(content, contains(
          'public static TextRichBuilder rich(InlineSpan textSpan) {'));
      expect(content, contains('return TextRichBuilder.textRich(textSpan);'));
    });

    test('Text constructor parameters have types', () async {
      var textClass = _testWidget(widgets);
      expect(textClass.constructors, hasLength(2));

      var params = Params(
          Generation([textClass]), textClass, textClass.constructors[0].parameters, Params.paramDef4J,
          allTypes: true);

      var allParams = 'String data, java.util.Optional<Key> key, java.util.Optional<TextStyle> style, java.util.Optional<StrutStyle> strutStyle, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Locale> locale, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.Optional<TextScaler> textScaler, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis, java.util.Optional<TextHeightBehavior> textHeightBehavior, java.util.Optional<Color> selectionColor';
      expect(params.names,
          equals(allParams.split(', ').map((p) => p.split(' ')[1]).join(', ')));
      expect(params.decl, equals(allParams));
      expect(params.builderDecl, equals('@Builder.Parameter $allParams'));
    });

    test('Text constructor parameters only supported types', () async {
      var textClass = _testWidget(widgets);

      var params = Params(
          Generation([textClass]), textClass, textClass.constructors[0].parameters, Params.paramDef4J,
          allTypes: false);

      var allParams = 'String data, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis';
      expect(params.names,
          equals(allParams.split(', ').map((p) => p.split(' ')[1]).join(', ')));
      expect(params.decl, equals(allParams));
      expect(params.builderDecl, equals('@Builder.Parameter $allParams'));
    });

    test('Text type dependencies', () async {
      var textClass = _testWidget(widgets);

      var generation = Generation([textClass]);
      Params(generation, textClass, textClass.constructors[1].parameters, Params.paramDef4J,
          allTypes: false);
      expect(generation.requiredTypes.map((p) => p.element!.name),
          unorderedEquals([
            'InlineSpan',
            'TextAlign',
            'TextDirection',
            'TextOverflow',
            'TextWidthBasis'
          ]));
    });

    test('Enum generated', () async {
      var textClass = _testWidget(widgets);
      var enumType = textClass
          .getField('textWidthBasis')!
          .type
          .element as EnumElement;

      var enumGen = EnumGen(Generation([textClass]), enumType);
      String content = enumGen.genJavaClass();

      expect(content, equalsIgnoringWhitespace('''package dev.equo.ewt;
      public enum TextWidthBasis {
        parent,  longestLine
      }'''));
    });

    test('factories container', () async {
      var gen = Generation([])..gen();

      String c = gen.genJavaFactories();

      // expect(c, contains('class WidgetFactoriesSetup {'));
      expect(c, contains('class WidgetConstructors {'));
      expect(c, contains('  static WidgetConstructors instance = new WidgetConstructors();'));
      expect(c, contains('  private MemorySegment factories;\n'));
      expect(c, contains('  public void set(MemorySegment factories) {\n'));
      expect(c, contains('    this.factories = factories;'));
    });

    test('factories generated', () async {
      var textClass = _testWidget(widgets);
      var widgetGen = WidgetGen(Generation([textClass]), textClass);

      String c = widgetGen.genJavaFactories();
      var allParams = 'String data, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis';
      expect(c, contains(
          'void textOf($allParams) {\n'
          '  var text = WidgetFactories.text(factories);\n'
          '  var textOf = WidgetFactories.text.of(text);'
          '  textOf.invoke(data.cast<Utf8>().toDartString(), textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.cast<Utf8>().toDartString(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));\n'
          '}'));
      expect(c, contains(
          'void textRich($allParams) {\n'
          '  var text = WidgetFactories.text(factories);\n'
          '  var richOf = WidgetFactories.rich.of(text);'
          '  richOf.invoke(data.cast<Utf8>().toDartString(), textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.cast<Utf8>().toDartString(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));\n'
          '}'));
    });
  });

  group("C generation", () {
    test('factories container', () async {
      var gen = Generation([])..gen();

      String c = gen.genCFactories();

      expect(c, contains('typedef struct {'));
      expect(c, contains('} WidgetFactories;'));
    });

    test('factories generated', () async {
      var textClass = _testWidget(widgets);
      var widgetGen = WidgetGen(Generation([textClass]), textClass);

      String c = widgetGen.genCFactories();
      expect(c, contains(
          '  struct {\n'
          '    int (*of)(char* data, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char** semanticsLabel, int* textWidthBasis);\n'
          '    int (*rich)(DartObj textSpan, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char** semanticsLabel, int* textWidthBasis);\n'
          '  } text;\n'));
    });
  });

  group("Dart generation", () {
    test('factories container', () async {
      var gen = Generation([])..gen();

      String c = gen.genDartFactories();

      // expect(c, contains('class WidgetFactoriesSetup {'));
      expect(c, contains('final WidgetFactories factories = _setupFactories();'));
      expect(c, contains('WidgetFactories _setupFactories() {'));
      expect(c, contains('  final WidgetFactories f = ffi.Struct.create();'));
      expect(c, contains('  return f;'));
      expect(c, contains('}'));
    });

    test('factories generated', () async {
      var textClass = _testWidget(widgets);
      var widgetGen = WidgetGen(Generation([textClass]), textClass);

      String c = widgetGen.genDartFactories();
      expect(c, contains('f.text.of = ffi.Pointer.fromFunction(textOf, exception);\n'));
      expect(c, contains('f.text.rich = ffi.Pointer.fromFunction(textRich, exception);\n'));
      expect(c, contains(
          'int textOf(ffi.Pointer<ffi.Char> data, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Pointer<ffi.Char>> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {\n'
          '  final w = Text(data.cast<Utf8>().toDartString(), textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.cast<Utf8>().toDartString(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));\n'
          '  final hashCode = w.hashCode;\n'
          '  _widgetsMap[hashCode] = w;\n'
          '  return hashCode;\n'
          '}\n'));
      expect(c, contains(
          'int textRich(int textSpan, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Pointer<ffi.Char>> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {\n'
          '  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan, textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.cast<Utf8>().toDartString(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));\n'
          '  final hashCode = w.hashCode;\n'
          '  _widgetsMap[hashCode] = w;\n'
          '  return hashCode;\n'
          '}\n'));
    });
  });

}

ClassElement _testWidget(Iterable<ClassElement> widgets) => widgets.firstWhere((w) => w.name == 'Text');