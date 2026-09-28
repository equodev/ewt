package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomAppBarTheme extends InheritedTheme implements BottomAppBarThemeI {
  protected BottomAppBarTheme() {}
  BottomAppBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BottomAppBarTheme bottomAppBarThemeBottomAppBarTheme(Optional<ColorI> color, OptionalDouble elevation, OptionalDouble height, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, Optional<EdgeInsetsGeometryI> padding, Optional<BottomAppBarThemeDataI> data, Optional<WidgetI> child) {
    int id = factories.bottomAppBarThemeBottomAppBarTheme(color.map(ColorI::build),
      elevation,
      height,
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      data.map(BottomAppBarThemeDataI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarTheme");
    return new BottomAppBarTheme(id);
  }
  public static BottomAppBarThemeBottomAppBarThemeBuilder bottomAppBarTheme() {
    return BottomAppBarThemeBottomAppBarThemeBuilder.bottomAppBarThemeBottomAppBarTheme();
  }
  public static BottomAppBarThemeData of(BuildContextI context) {
    int id = factories.bottomAppBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    return new BottomAppBarThemeData(id);
  }
  public static BottomAppBarTheme lerp(BottomAppBarThemeI a, BottomAppBarThemeI b, double t) {
    int id = factories.bottomAppBarThemeLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarTheme");
    return new BottomAppBarTheme(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBarTheme_readBack_color(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeElevation not supported on web");
    return factories.BottomAppBarTheme_readBack_elevation(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeHeight not supported on web");
    return factories.BottomAppBarTheme_readBack_height(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBarTheme_readBack_surfaceTintColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeShadowColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBarTheme_readBack_shadowColor(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemePadding not supported on web");
    return factories.BottomAppBarTheme_readBack_padding(nativeStruct);
  }
  public BottomAppBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeData", getId());
      return new BottomAppBarThemeData(__nid);
    }
    return factories.BottomAppBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public BottomAppBarTheme build() {
    return this;
  }
}
