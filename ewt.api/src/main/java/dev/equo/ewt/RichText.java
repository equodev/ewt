package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RichTextObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RichText extends MultiChildRenderObjectWidget implements RichTextI {
  private MemorySegment st;
  protected RichText() {}
  RichText(MemorySegment st) {
    this.id = RichTextObjSt.id(st);
    this.st = st;
    System.out.println("New RichText id:"+id);
  }
  @Builder.Factory
  static RichText richTextRichText(@Builder.Parameter InlineSpanI text, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    var st = factories.richTextRichText(text.build(),
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      textWidthBasis,
      selectionColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RichText");
    return new RichText(st);
  }
  public static RichTextRichTextBuilder richText(InlineSpanI text) {
    return RichTextRichTextBuilder.richTextRichText(text);
  }
  public InlineSpan text() {
    return new InlineSpan(RichTextObjSt.text(st)) {};
  }
  public TextAlign textAlign() {
    return TextAlign.values()[RichTextObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    return TextDirection.values()[RichTextObjSt.textDirection(st)];
  }
  public boolean softWrap() {
    return intToBool(RichTextObjSt.softWrap(st));
  }
  public TextOverflow overflow() {
    return TextOverflow.values()[RichTextObjSt.overflow(st)];
  }
  public int maxLines() {
    return RichTextObjSt.maxLines(st);
  }
  public TextWidthBasis textWidthBasis() {
    return TextWidthBasis.values()[RichTextObjSt.textWidthBasis(st)];
  }
  public Color selectionColor() {
    return new Color(RichTextObjSt.selectionColor(st));
  }
  public double textScaleFactor() {
    return RichTextObjSt.textScaleFactor(st);
  }
  @Override
  public RichText build() {
    return this;
  }
}
