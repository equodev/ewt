
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

  test('Java Text widget generated', () async {
    var textClass = _testWidget(widgets);
    expect(textClass.constructors, hasLength(2));
    
    var widgetGen = WidgetGen(Generation(), textClass);
    String content = widgetGen.genJavaClass();
    
    expect(content, contains('package dev.equo.ewt;'));
    expect(content, contains('import org.immutables.builder.Builder;'));
    expect(content, contains('public class Text implements Widget {'));
    expect(content, contains('@Builder.Constructor'));
    expect(content, contains('Text(@Builder.Parameter String data,'));
    expect(content, contains('public static TextBuilder of(String data) {'));
    expect(content, contains('return TextBuilder.Text(data);'));
    expect(content, contains('Text(InlineSpan textSpan,'));
    expect(content, contains('@Builder.Factory'));
    expect(content, contains('static Text textRich(@Builder.Parameter InlineSpan textSpan,'));
    expect(content, contains('return new Text(textSpan,'));
    expect(content, contains('public static TextRichBuilder rich(InlineSpan textSpan) {'));
    expect(content, contains('return TextRichBuilder.textRich(textSpan);'));
  });

  test('Text constructor parameters have types', () async {
    var textClass = _testWidget(widgets);
    expect(textClass.constructors, hasLength(2));

    var params = JavaParams(Generation(), textClass, textClass.constructors[0].parameters, allTypes: true);

    var allParams = 'String data, java.util.Optional<Key> key, java.util.Optional<TextStyle> style, java.util.Optional<StrutStyle> strutStyle, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Locale> locale, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.Optional<TextScaler> textScaler, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis, java.util.Optional<TextHeightBehavior> textHeightBehavior, java.util.Optional<Color> selectionColor';
    expect(params.names, equals(allParams.split(', ').map((p) => p.split(' ')[1]).join(', ')));
    expect(params.decl, equals(allParams));
    expect(params.builderDecl, equals('@Builder.Parameter $allParams'));
  });

  test('Text constructor parameters only supported types', () async {
    var textClass = _testWidget(widgets);

    var params = JavaParams(Generation(), textClass, textClass.constructors[0].parameters, allTypes: false);

    var allParams = 'String data, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis';
    expect(params.names, equals(allParams.split(', ').map((p) => p.split(' ')[1]).join(', ')));
    expect(params.decl, equals(allParams));
    expect(params.builderDecl, equals('@Builder.Parameter $allParams'));
  });

  test('Text type dependencies', () async {
    var textClass = _testWidget(widgets);

    var generation = Generation();
    JavaParams(generation, textClass, textClass.constructors[1].parameters, allTypes: false);
    expect(generation.requiredTypes.map((p) => p.element!.name), unorderedEquals(['InlineSpan','TextAlign', 'TextDirection', 'TextOverflow', 'TextWidthBasis']));
  });

  test('Java Enum generated', () async {
    var textClass = _testWidget(widgets);
    var enumType = textClass.getField('textWidthBasis')!.type.element as EnumElement;

    var enumGen = EnumGen(Generation(), enumType);
    String content = enumGen.genJavaClass();

    expect(content, equalsIgnoringWhitespace('''package dev.equo.ewt;
    public enum TextWidthBasis {
      parent,  longestLine
    }'''));
  });
}

ClassElement _testWidget(Iterable<ClassElement> widgets) => widgets.firstWhere((w) => w.name == 'Text');