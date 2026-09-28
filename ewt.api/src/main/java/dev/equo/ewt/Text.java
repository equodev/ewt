package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Text extends StatelessWidget implements TextI {
  protected Text() {}
  Text(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Text");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Text textText(@Builder.Parameter String data, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    int id = factories.textText(data,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Text");
    return new Text(id);
  }
  public static TextTextBuilder text(String data) {
    return TextTextBuilder.textText(data);
  }
  @Builder.Factory
  static Text textRich(@Builder.Parameter InlineSpanI textSpan, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<ColorI> selectionColor) {
    int id = factories.textRich(textSpan.build(),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Text");
    return new Text(id);
  }
  public static TextRichBuilder rich(InlineSpanI textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }
  public String data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textData not supported on web");
    return factories.Text_readBack_data(nativeStruct);
  }
  public InlineSpan textSpan() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextSpan not supported on web");
    return factories.Text_readBack_textSpan(nativeStruct);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.Text_readBack_style(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextAlign not supported on web");
    return factories.Text_readBack_textAlign(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextDirection not supported on web");
    return factories.Text_readBack_textDirection(nativeStruct);
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSoftWrap not supported on web");
    return factories.Text_readBack_softWrap(nativeStruct);
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textOverflow not supported on web");
    return factories.Text_readBack_overflow(nativeStruct);
  }
  public double textScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextScaleFactor not supported on web");
    return factories.Text_readBack_textScaleFactor(nativeStruct);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textMaxLines not supported on web");
    return factories.Text_readBack_maxLines(nativeStruct);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSemanticsLabel not supported on web");
    return factories.Text_readBack_semanticsLabel(nativeStruct);
  }
  public String semanticsIdentifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSemanticsIdentifier not supported on web");
    return factories.Text_readBack_semanticsIdentifier(nativeStruct);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textTextWidthBasis not supported on web");
    return factories.Text_readBack_textWidthBasis(nativeStruct);
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionColor", getId());
      return new Color(__nid);
    }
    return factories.Text_readBack_selectionColor(nativeStruct);
  }
  @Override
  public Text build() {
    return this;
  }
}
