package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Text extends StatelessWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Text() {}
  Text(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Text textText(@Builder.Parameter String data, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    int id = factories.textText(data,
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      semanticsLabel,
      textWidthBasis,
      selectionColor);
    if (id == -1) throw new RuntimeException("Failed to created widget Text");
    System.out.println("New Text id:"+id);
    return new Text(id);
  }
  public static TextTextBuilder text(String data) {
    return TextTextBuilder.textText(data);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    int id = factories.textRich(textSpan,
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      semanticsLabel,
      textWidthBasis,
      selectionColor);
    if (id == -1) throw new RuntimeException("Failed to created widget Text");
    System.out.println("New Text id:"+id);
    return new Text(id);
  }
  public static TextRichBuilder rich(InlineSpan textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
}
