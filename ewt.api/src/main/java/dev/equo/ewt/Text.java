package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Text extends StatelessWidget implements TextI {
  private MemorySegment st;
  protected Text() {}
  Text(MemorySegment st) {
    this.id = TextObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Text");
    System.out.println("New Text id:"+id);
  }
  @Builder.Factory
  static Text textText(@Builder.Parameter String data, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    var st = factories.textText(data,
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
    if (st == null) throw new RuntimeException("Failed to created widget Text");
    return new Text(st);
  }
  public static TextTextBuilder text(String data) {
    return TextTextBuilder.textText(data);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpanI textSpan, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    var st = factories.textRich(textSpan.build(),
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
    if (st == null) throw new RuntimeException("Failed to created widget Text");
    return new Text(st);
  }
  public static TextRichBuilder rich(InlineSpanI textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
  public String data() {
    return TextObjSt.data(st).getString(0);
  }
  public InlineSpan textSpan() {
    return new InlineSpan(TextObjSt.textSpan(st)) {};
  }
  public TextStyle style() {
    return new TextStyle(TextObjSt.style(st));
  }
  public TextAlign textAlign() {
    return TextAlign.values()[TextObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    return TextDirection.values()[TextObjSt.textDirection(st)];
  }
  public boolean softWrap() {
    return intToBool(TextObjSt.softWrap(st));
  }
  public TextOverflow overflow() {
    return TextOverflow.values()[TextObjSt.overflow(st)];
  }
  public double textScaleFactor() {
    return TextObjSt.textScaleFactor(st);
  }
  public int maxLines() {
    return TextObjSt.maxLines(st);
  }
  public String semanticsLabel() {
    return TextObjSt.semanticsLabel(st).getString(0);
  }
  public TextWidthBasis textWidthBasis() {
    return TextWidthBasis.values()[TextObjSt.textWidthBasis(st)];
  }
  public Color selectionColor() {
    return new Color(TextObjSt.selectionColor(st));
  }
  @Override
  public Text build() {
    return this;
  }
}
