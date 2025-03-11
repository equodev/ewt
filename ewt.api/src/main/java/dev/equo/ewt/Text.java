package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Text extends Widget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  @Builder.Constructor
  Text(@Builder.Parameter String data, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    id = factories.textOf(data, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static TextBuilder of(String data) {
    return TextBuilder.Text(data);
  }
  Text(InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    id = factories.textRich(textSpan, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    return new Text(textSpan, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  public static TextRichBuilder rich(InlineSpan textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
}
