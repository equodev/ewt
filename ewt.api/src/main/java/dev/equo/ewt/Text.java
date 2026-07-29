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
  Text(int id) { this.id = id; }
  @Builder.Factory
  static Text textText(@Builder.Parameter String data, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    var st = factories.textText(data,
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      semanticsLabel,
      semanticsIdentifier,
      textWidthBasis,
      selectionColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Text");
    return new Text(st);
  }
  public static TextTextBuilder text(String data) {
    return TextTextBuilder.textText(data);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpanI textSpan, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    var st = factories.textRich(textSpan.build(),
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      softWrap,
      overflow,
      textScaleFactor,
      maxLines,
      semanticsLabel,
      semanticsIdentifier,
      textWidthBasis,
      selectionColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Text");
    return new Text(st);
  }
  public static TextRichBuilder rich(InlineSpanI textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
  public String data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textData not supported on web");
    return TextObjSt.data(st).getString(0);
  }
  public InlineSpan textSpan() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextSpan not supported on web");
    return new InlineSpan(TextObjSt.textSpan(st)) {};
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TextObjSt.style(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextAlign not supported on web");
    return TextAlign.values()[TextObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextDirection not supported on web");
    return TextDirection.values()[TextObjSt.textDirection(st)];
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSoftWrap not supported on web");
    return intToBool(TextObjSt.softWrap(st));
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textOverflow not supported on web");
    return TextOverflow.values()[TextObjSt.overflow(st)];
  }
  public double textScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextScaleFactor not supported on web");
    return TextObjSt.textScaleFactor(st);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textMaxLines not supported on web");
    return TextObjSt.maxLines(st);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSemanticsLabel not supported on web");
    return TextObjSt.semanticsLabel(st).getString(0);
  }
  public String semanticsIdentifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSemanticsIdentifier not supported on web");
    return TextObjSt.semanticsIdentifier(st).getString(0);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextWidthBasis not supported on web");
    return TextWidthBasis.values()[TextObjSt.textWidthBasis(st)];
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionColor", getId());
      return new Color(__nid);
    }
    return new Color(TextObjSt.selectionColor(st));
  }
  @Override
  public Text build() {
    return this;
  }
}
