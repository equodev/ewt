package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomAppBarThemeData extends NativeObj.Base implements BottomAppBarThemeDataI {
  protected BottomAppBarThemeData() {}
  BottomAppBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BottomAppBarThemeData bottomAppBarThemeDataBottomAppBarThemeData(Optional<ColorI> color, OptionalDouble elevation, OptionalDouble height, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, Optional<EdgeInsetsGeometryI> padding) {
    int id = factories.bottomAppBarThemeDataBottomAppBarThemeData(color.map(ColorI::build),
      elevation,
      height,
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    return new BottomAppBarThemeData(id);
  }
  public static BottomAppBarThemeDataBottomAppBarThemeDataBuilder bottomAppBarThemeData() {
    return BottomAppBarThemeDataBottomAppBarThemeDataBuilder.bottomAppBarThemeDataBottomAppBarThemeData();
  }
  public static BottomAppBarThemeData lerp(BottomAppBarThemeDataI a, BottomAppBarThemeDataI b, double t) {
    int id = factories.bottomAppBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    return new BottomAppBarThemeData(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeDataColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBarThemeData_readBack_color(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeDataElevation not supported on web");
    return factories.BottomAppBarThemeData_readBack_elevation(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeDataHeight not supported on web");
    return factories.BottomAppBarThemeData_readBack_height(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBarThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBarThemeData_readBack_shadowColor(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeDataPadding not supported on web");
    return factories.BottomAppBarThemeData_readBack_padding(nativeStruct);
  }
  @Override
  public BottomAppBarThemeData build() {
    return this;
  }
}
