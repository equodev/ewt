package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DefaultSelectionStyle extends InheritedTheme implements DefaultSelectionStyleI {
  protected DefaultSelectionStyle() {}
  DefaultSelectionStyle(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DefaultSelectionStyle defaultSelectionStyleDefaultSelectionStyle(Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, WidgetI child) {
    int id = factories.defaultSelectionStyleDefaultSelectionStyle(cursorColor.map(ColorI::build),
      selectionColor.map(ColorI::build),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    return new DefaultSelectionStyle(id);
  }
  public static DefaultSelectionStyleDefaultSelectionStyleBuilder defaultSelectionStyle() {
    return DefaultSelectionStyleDefaultSelectionStyleBuilder.defaultSelectionStyleDefaultSelectionStyle();
  }
  @Builder.Factory
  static DefaultSelectionStyle defaultSelectionStyleFallback() {
    int id = factories.defaultSelectionStyleFallback();
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    return new DefaultSelectionStyle(id);
  }
  public static DefaultSelectionStyleFallbackBuilder fallback() {
    return DefaultSelectionStyleFallbackBuilder.defaultSelectionStyleFallback();
  }
  public static Widget merge(WidgetI child) {
    var id = factories.defaultSelectionStyleMerge(Optional.empty(),
      Optional.empty(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    return new Widget(id) {};
  }
  public static DefaultSelectionStyle of(BuildContextI context) {
    int id = factories.defaultSelectionStyleOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultSelectionStyle");
    return new DefaultSelectionStyle(id);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("defaultSelectionStyleCursorColor", getId());
      return new Color(__nid);
    }
    return factories.DefaultSelectionStyle_readBack_cursorColor(nativeStruct);
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("defaultSelectionStyleSelectionColor", getId());
      return new Color(__nid);
    }
    return factories.DefaultSelectionStyle_readBack_selectionColor(nativeStruct);
  }
  public static Color defaultColor() {
    return Color.color(0x80808080).build();
  }
  @Override
  public DefaultSelectionStyle build() {
    return this;
  }
}
