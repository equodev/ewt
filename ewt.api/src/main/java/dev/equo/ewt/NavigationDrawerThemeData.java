package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationDrawerThemeData extends NativeObj.Base implements NavigationDrawerThemeDataI {
  protected NavigationDrawerThemeData() {}
  NavigationDrawerThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationDrawerThemeData navigationDrawerThemeDataNavigationDrawerThemeData(OptionalDouble tileHeight, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<TextStyleI> labelTextStyle, Optional<IconThemeDataI> iconTheme) {
    int id = factories.navigationDrawerThemeDataNavigationDrawerThemeData(tileHeight,
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      labelTextStyle.map(TextStyleI::build),
      iconTheme.map(IconThemeDataI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    return new NavigationDrawerThemeData(id);
  }
  public static NavigationDrawerThemeDataNavigationDrawerThemeDataBuilder navigationDrawerThemeData() {
    return NavigationDrawerThemeDataNavigationDrawerThemeDataBuilder.navigationDrawerThemeDataNavigationDrawerThemeData();
  }
  public static NavigationDrawerThemeData lerp(NavigationDrawerThemeDataI a, NavigationDrawerThemeDataI b, double t) {
    int id = factories.navigationDrawerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    return new NavigationDrawerThemeData(id);
  }
  public double tileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerThemeDataTileHeight not supported on web");
    return factories.NavigationDrawerThemeData_readBack_tileHeight(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawerThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerThemeDataElevation not supported on web");
    return factories.NavigationDrawerThemeData_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawerThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawerThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawerThemeData_readBack_indicatorColor(nativeStruct);
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerThemeDataIndicatorShape not supported on web");
    return factories.NavigationDrawerThemeData_readBack_indicatorShape(nativeStruct);
  }
  @Override
  public NavigationDrawerThemeData build() {
    return this;
  }
}
