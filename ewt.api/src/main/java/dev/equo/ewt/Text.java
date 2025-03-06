package dev.equo.ewt;
import dev.equo.ewt.ffm.WidgetFactories;
import org.immutables.builder.Builder;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class Text implements Widget {
  private int hash;
  MemorySegment constructors = WidgetConstructors.get();

  @Builder.Constructor
  Text(@Builder.Parameter String data, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
    var fnPtr = WidgetFactories.text(constructors);
    hash = WidgetFactories.text.invoke(fnPtr, Arena.ofAuto().allocateFrom(data), textDirection.get().ordinal());
  }
  public static TextBuilder of(String data) {
    return TextBuilder.Text(data);
  }
  Text(InlineSpan textSpan, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpan textSpan, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
    return new Text(textSpan, textAlign, textDirection, softWrap, overflow, textScaleFactor, maxLines, semanticsLabel, textWidthBasis);
  }
  public static TextRichBuilder rich(InlineSpan textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }

  @Override
  public int hashCode() {
    return hash;
  }
}
