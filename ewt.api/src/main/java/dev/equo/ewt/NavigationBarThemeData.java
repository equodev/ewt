package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationBarThemeData extends NativeObj.Base implements NavigationBarThemeDataI {
  protected NavigationBarThemeData() {}
  NavigationBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationBarThemeData navigationBarThemeDataNavigationBarThemeData(OptionalDouble height, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<TextStyleI> labelTextStyle, Optional<IconThemeDataI> iconTheme, Optional<NavigationDestinationLabelBehavior> labelBehavior, Optional<ColorI> overlayColor, Optional<EdgeInsetsGeometryI> labelPadding) {
    int id = factories.navigationBarThemeDataNavigationBarThemeData(height,
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      labelTextStyle.map(TextStyleI::build),
      iconTheme.map(IconThemeDataI::build),
      labelBehavior,
      overlayColor.map(ColorI::build),
      labelPadding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    return new NavigationBarThemeData(id);
  }
  public static NavigationBarThemeDataNavigationBarThemeDataBuilder navigationBarThemeData() {
    return NavigationBarThemeDataNavigationBarThemeDataBuilder.navigationBarThemeDataNavigationBarThemeData();
  }
  public static NavigationBarThemeData lerp(NavigationBarThemeDataI a, NavigationBarThemeDataI b, double t) {
    int id = factories.navigationBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    return new NavigationBarThemeData(id);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataHeight not supported on web");
    return factories.NavigationBarThemeData_readBack_height(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBarThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataElevation not supported on web");
    return factories.NavigationBarThemeData_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBarThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBarThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBarThemeData_readBack_indicatorColor(nativeStruct);
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataIndicatorShape not supported on web");
    return factories.NavigationBarThemeData_readBack_indicatorShape(nativeStruct);
  }
  public NavigationDestinationLabelBehavior labelBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataLabelBehavior not supported on web");
    return factories.NavigationBarThemeData_readBack_labelBehavior(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataLabelPadding not supported on web");
    return factories.NavigationBarThemeData_readBack_labelPadding(nativeStruct);
  }
  @Override
  public NavigationBarThemeData build() {
    return this;
  }
}
