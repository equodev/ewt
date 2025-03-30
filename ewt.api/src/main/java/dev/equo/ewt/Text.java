package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Text extends StatelessWidget implements TextI {
  @Override
  public Text build() {
    return this;
  }
  Text() {}
  Text(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Text textText(@Builder.Parameter String data, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    int id = factories.textText(data,
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      semanticsLabel,
      textWidthBasis,
      selectionColor.map(ColorI::build));
    if (id == -1) throw new RuntimeException("Failed to created widget Text");
    System.out.println("New Text id:"+id);
    return new Text(id);
  }
  public static TextTextBuilder text(String data) {
    return TextTextBuilder.textText(data);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpanI textSpan, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    int id = factories.textRich(textSpan.build(),
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      semanticsLabel,
      textWidthBasis,
      selectionColor.map(ColorI::build));
    if (id == -1) throw new RuntimeException("Failed to created widget Text");
    System.out.println("New Text id:"+id);
    return new Text(id);
  }
  public static TextRichBuilder rich(InlineSpanI textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
}
