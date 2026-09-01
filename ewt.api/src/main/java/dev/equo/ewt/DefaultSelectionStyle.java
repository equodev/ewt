package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DefaultSelectionStyleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DefaultSelectionStyle extends InheritedTheme implements DefaultSelectionStyleI {
  private MemorySegment st;
  protected DefaultSelectionStyle() {}
  DefaultSelectionStyle(MemorySegment st) {
    this.id = DefaultSelectionStyleObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    System.out.println("New DefaultSelectionStyle id:"+id);
  }
  DefaultSelectionStyle(int id) { this.id = id; }
  @Builder.Factory
  static DefaultSelectionStyle defaultSelectionStyleDefaultSelectionStyle(Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, WidgetI child) {
    var st = factories.defaultSelectionStyleDefaultSelectionStyle(cursorColor.map(ColorI::build),
      selectionColor.map(ColorI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    return new DefaultSelectionStyle(st);
  }
  public static DefaultSelectionStyleDefaultSelectionStyleBuilder defaultSelectionStyle() {
    return DefaultSelectionStyleDefaultSelectionStyleBuilder.defaultSelectionStyleDefaultSelectionStyle();
  }
  @Builder.Factory
  static DefaultSelectionStyle defaultSelectionStyleFallback() {
    var st = factories.defaultSelectionStyleFallback();
    if (st == null) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    return new DefaultSelectionStyle(st);
  }
  public static DefaultSelectionStyleFallbackBuilder fallback() {
    return DefaultSelectionStyleFallbackBuilder.defaultSelectionStyleFallback();
  }
  public static Widget merge(WidgetI child) {
    int id = factories.defaultSelectionStyleMerge(Optional.empty(),
      Optional.empty(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public static DefaultSelectionStyle of(BuildContextI context) {
    var st = factories.defaultSelectionStyleOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    return new DefaultSelectionStyle(st);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("defaultSelectionStyleCursorColor", getId());
      return new Color(__nid);
    }
    return new Color(DefaultSelectionStyleObjSt.cursorColor(st));
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("defaultSelectionStyleSelectionColor", getId());
      return new Color(__nid);
    }
    return new Color(DefaultSelectionStyleObjSt.selectionColor(st));
  }
  public static Color defaultColor() {
    return Color.color(0x80808080).build();
  }
  @Override
  public DefaultSelectionStyle build() {
    return this;
  }
}
