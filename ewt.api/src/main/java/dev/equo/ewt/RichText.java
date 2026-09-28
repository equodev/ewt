package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RichText extends MultiChildRenderObjectWidget implements RichTextI {
  protected RichText() {}
  RichText(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RichText");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RichText richTextRichText(@Builder.Parameter InlineSpanI text, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    int id = factories.richTextRichText(text.build(),
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      textWidthBasis,
      selectionColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RichText");
    return new RichText(id);
  }
  public static RichTextRichTextBuilder richText(InlineSpanI text) {
    return RichTextRichTextBuilder.richTextRichText(text);
  }
  public InlineSpan text() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextText not supported on web");
    return factories.RichText_readBack_text(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextAlign not supported on web");
    return factories.RichText_readBack_textAlign(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextDirection not supported on web");
    return factories.RichText_readBack_textDirection(nativeStruct);
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextSoftWrap not supported on web");
    return factories.RichText_readBack_softWrap(nativeStruct);
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextOverflow not supported on web");
    return factories.RichText_readBack_overflow(nativeStruct);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextMaxLines not supported on web");
    return factories.RichText_readBack_maxLines(nativeStruct);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextWidthBasis not supported on web");
    return factories.RichText_readBack_textWidthBasis(nativeStruct);
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("richTextSelectionColor", getId());
      return new Color(__nid);
    }
    return factories.RichText_readBack_selectionColor(nativeStruct);
  }
  public double textScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("richTextTextScaleFactor not supported on web");
    return factories.RichText_readBack_textScaleFactor(nativeStruct);
  }
  @Override
  public RichText build() {
    return this;
  }
}
