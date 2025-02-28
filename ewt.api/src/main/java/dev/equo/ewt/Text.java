package dev.equo.ewt;
import org.immutables.builder.Builder;
public class Text {
  @Builder.Constructor
  Text(@Builder.Parameter String data, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor) {
  }
  public static TextBuilder of(String data, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor) {
    return TextBuilder.Text(data, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor);
  }
  Text(InlineSpan textSpan, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor) {
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpan textSpan, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor) {
    return new Text(textSpan, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor);
  }
  public static TextRichBuilder rich(InlineSpan textSpan, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor) {
    return TextRichBuilder.textRich(textSpan, key, style, strutStyle, textAlign, textDirection, locale, softWrap, overflow, textScaleFactor, textScaler, maxLines, semanticsLabel, textWidthBasis, textHeightBehavior, selectionColor);
  }
}
