package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DefaultTextStyle extends InheritedTheme implements DefaultTextStyleI {
  protected DefaultTextStyle() {}
  DefaultTextStyle(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DefaultTextStyle defaultTextStyleDefaultTextStyle(@Builder.Parameter TextStyleI style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, WidgetI child) {
    int id = factories.defaultTextStyleDefaultTextStyle(style.build(),
      textAlign,
      softWrap,
      overflow,
      maxLines,
      textWidthBasis,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    return new DefaultTextStyle(id);
  }
  public static DefaultTextStyleDefaultTextStyleBuilder defaultTextStyle(TextStyleI style) {
    return DefaultTextStyleDefaultTextStyleBuilder.defaultTextStyleDefaultTextStyle(style);
  }
  @Builder.Factory
  static DefaultTextStyle defaultTextStyleFallback() {
    int id = factories.defaultTextStyleFallback();
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    return new DefaultTextStyle(id);
  }
  public static DefaultTextStyleFallbackBuilder fallback() {
    return DefaultTextStyleFallbackBuilder.defaultTextStyleFallback();
  }
  public static Widget merge(WidgetI child) {
    var id = factories.defaultTextStyleMerge(Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      OptionalInt.empty(),
      Optional.empty(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public static DefaultTextStyle of(BuildContextI context) {
    int id = factories.defaultTextStyleOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    return new DefaultTextStyle(id);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("defaultTextStyleStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DefaultTextStyle_readBack_style(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleTextAlign not supported on web");
    return factories.DefaultTextStyle_readBack_textAlign(nativeStruct);
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleSoftWrap not supported on web");
    return factories.DefaultTextStyle_readBack_softWrap(nativeStruct);
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleOverflow not supported on web");
    return factories.DefaultTextStyle_readBack_overflow(nativeStruct);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleMaxLines not supported on web");
    return factories.DefaultTextStyle_readBack_maxLines(nativeStruct);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleTextWidthBasis not supported on web");
    return factories.DefaultTextStyle_readBack_textWidthBasis(nativeStruct);
  }
  @Override
  public DefaultTextStyle build() {
    return this;
  }
}
