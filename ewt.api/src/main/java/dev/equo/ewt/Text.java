package dev.equo.ewt;
import org.immutables.builder.Builder;
public class Text {
  @Builder.Constructor
  Text(@Builder.Parameter String data, null key, TextAlign textAlign, TextDirection textDirection, boolean softWrap, TextOverflow overflow, double textScaleFactor, int maxLines, String semanticsLabel, TextWidthBasis textWidthBasis) {
  }
  public static TextBuilder of(String data, null key, TextAlign textAlign, TextDirection textDirection, boolean softWrap, TextOverflow overflow, double textScaleFactor, int maxLines, String semanticsLabel, TextWidthBasis textWidthBasis) {
    return TextBuilder.Text(data, key, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  Text(InlineSpan textSpan, null key, TextAlign textAlign, TextDirection textDirection, boolean softWrap, TextOverflow overflow, double textScaleFactor, int maxLines, String semanticsLabel, TextWidthBasis textWidthBasis) {
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpan textSpan, null key, TextAlign textAlign, TextDirection textDirection, boolean softWrap, TextOverflow overflow, double textScaleFactor, int maxLines, String semanticsLabel, TextWidthBasis textWidthBasis) {
    return new Text(textSpan, key, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  public static TextRichBuilder rich(InlineSpan textSpan, null key, TextAlign textAlign, TextDirection textDirection, boolean softWrap, TextOverflow overflow, double textScaleFactor, int maxLines, String semanticsLabel, TextWidthBasis textWidthBasis) {
    return TextRichBuilder.textRich(textSpan, key, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
}
