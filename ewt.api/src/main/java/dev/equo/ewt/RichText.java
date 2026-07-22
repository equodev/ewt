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
    if (id <= 0) throw new RuntimeException("Failed to created widget RichText");
    System.out.println("New RichText id:"+id);
  }
  RichText(int id) { this.id = id; }
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextText not supported on web");
    return new InlineSpan(RichTextObjSt.text(st)) {};
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextAlign not supported on web");
    return TextAlign.values()[RichTextObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextDirection not supported on web");
    return TextDirection.values()[RichTextObjSt.textDirection(st)];
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextSoftWrap not supported on web");
    return intToBool(RichTextObjSt.softWrap(st));
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextOverflow not supported on web");
    return TextOverflow.values()[RichTextObjSt.overflow(st)];
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextMaxLines not supported on web");
    return RichTextObjSt.maxLines(st);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextWidthBasis not supported on web");
    return TextWidthBasis.values()[RichTextObjSt.textWidthBasis(st)];
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("richTextSelectionColor", getId());
      return new Color(__nid);
    }
    return new Color(RichTextObjSt.selectionColor(st));
  }
  public double textScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextScaleFactor not supported on web");
    return RichTextObjSt.textScaleFactor(st);
  }
  @Override
  public RichText build() {
    return this;
  }
}
