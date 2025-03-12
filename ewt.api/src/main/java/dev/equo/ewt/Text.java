package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Text extends StatelessWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Text() {}
  @Builder.Constructor
  Text(@Builder.Parameter String data, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    id = factories.textText(data, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static TextBuilder text(String data) {
    return TextBuilder.Text(data);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    return new Text(textSpan, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  Text(InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    id = factories.textRich(textSpan, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static TextRichBuilder rich(InlineSpan textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
}
