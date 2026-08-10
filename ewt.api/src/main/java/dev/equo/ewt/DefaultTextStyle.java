package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DefaultTextStyleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DefaultTextStyle extends InheritedTheme implements DefaultTextStyleI {
  private MemorySegment st;
  protected DefaultTextStyle() {}
  DefaultTextStyle(MemorySegment st) {
    this.id = DefaultTextStyleObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    System.out.println("New DefaultTextStyle id:"+id);
  }
  DefaultTextStyle(int id) { this.id = id; }
  @Builder.Factory
  static DefaultTextStyle defaultTextStyleDefaultTextStyle(@Builder.Parameter TextStyleI style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, WidgetI child) {
    var st = factories.defaultTextStyleDefaultTextStyle(style.build(),
      textAlign,
      softWrap,
      overflow,
      maxLines,
      textWidthBasis,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    return new DefaultTextStyle(st);
  }
  public static DefaultTextStyleDefaultTextStyleBuilder defaultTextStyle(TextStyleI style) {
    return DefaultTextStyleDefaultTextStyleBuilder.defaultTextStyleDefaultTextStyle(style);
  }
  @Builder.Factory
  static DefaultTextStyle defaultTextStyleFallback() {
    var st = factories.defaultTextStyleFallback();
    if (st == null) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    return new DefaultTextStyle(st);
  }
  public static DefaultTextStyleFallbackBuilder fallback() {
    return DefaultTextStyleFallbackBuilder.defaultTextStyleFallback();
  }
  public static Widget merge(WidgetI child) {
    int id = factories.defaultTextStyleMerge(Optional.empty(),
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
    var st = factories.defaultTextStyleOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DefaultTextStyle");
    return new DefaultTextStyle(st);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("defaultTextStyleStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DefaultTextStyleObjSt.style(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleTextAlign not supported on web");
    return TextAlign.values()[DefaultTextStyleObjSt.textAlign(st)];
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleSoftWrap not supported on web");
    return intToBool(DefaultTextStyleObjSt.softWrap(st));
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleOverflow not supported on web");
    return TextOverflow.values()[DefaultTextStyleObjSt.overflow(st)];
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleMaxLines not supported on web");
    return DefaultTextStyleObjSt.maxLines(st);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTextStyleTextWidthBasis not supported on web");
    return TextWidthBasis.values()[DefaultTextStyleObjSt.textWidthBasis(st)];
  }
  @Override
  public DefaultTextStyle build() {
    return this;
  }
}
