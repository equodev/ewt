package dev.equo.ewt;
import org.immutables.builder.Builder;
public class Text extends Widget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  @Builder.Constructor
  Text(@Builder.Parameter String data, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
    id = factories.textOf(data, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  public static TextBuilder of(String data) {
    return TextBuilder.Text(data);
  }
  Text(InlineSpan textSpan, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
    id = factories.textRich(textSpan, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpan textSpan, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
    return new Text(textSpan, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  public static TextRichBuilder rich(InlineSpan textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
}
