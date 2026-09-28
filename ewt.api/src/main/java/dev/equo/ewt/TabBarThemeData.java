package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TabBarThemeData extends NativeObj.Base implements TabBarThemeDataI {
  protected TabBarThemeData() {}
  TabBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TabBarThemeData tabBarThemeDataTabBarThemeData(Optional<DecorationI> indicator, Optional<ColorI> indicatorColor, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<EdgeInsetsGeometryI> labelPadding, Optional<TextStyleI> labelStyle, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<ColorI> overlayColor, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation, Optional<BorderRadiusI> splashBorderRadius) {
    int id = factories.tabBarThemeDataTabBarThemeData(indicator.map(DecorationI::build),
      indicatorColor.map(ColorI::build),
      indicatorSize,
      dividerColor.map(ColorI::build),
      dividerHeight,
      labelColor.map(ColorI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      labelStyle.map(TextStyleI::build),
      unselectedLabelColor.map(ColorI::build),
      unselectedLabelStyle.map(TextStyleI::build),
      overlayColor.map(ColorI::build),
      tabAlignment,
      indicatorAnimation,
      splashBorderRadius.map(BorderRadiusI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarThemeData");
    return new TabBarThemeData(id);
  }
  public static TabBarThemeDataTabBarThemeDataBuilder tabBarThemeData() {
    return TabBarThemeDataTabBarThemeDataBuilder.tabBarThemeDataTabBarThemeData();
  }
  public static TabBarThemeData lerp(TabBarThemeDataI a, TabBarThemeDataI b, double t) {
    int id = factories.tabBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarThemeData");
    return new TabBarThemeData(id);
  }
  public Decoration indicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataIndicator not supported on web");
    return factories.TabBarThemeData_readBack_indicator(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarThemeData_readBack_indicatorColor(nativeStruct);
  }
  public TabBarIndicatorSize indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataIndicatorSize not supported on web");
    return factories.TabBarThemeData_readBack_indicatorSize(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataDividerColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarThemeData_readBack_dividerColor(nativeStruct);
  }
  public double dividerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataDividerHeight not supported on web");
    return factories.TabBarThemeData_readBack_dividerHeight(nativeStruct);
  }
  public Color labelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataLabelColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarThemeData_readBack_labelColor(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataLabelPadding not supported on web");
    return factories.TabBarThemeData_readBack_labelPadding(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TabBarThemeData_readBack_labelStyle(nativeStruct);
  }
  public Color unselectedLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataUnselectedLabelColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarThemeData_readBack_unselectedLabelColor(nativeStruct);
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataUnselectedLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TabBarThemeData_readBack_unselectedLabelStyle(nativeStruct);
  }
  public TabAlignment tabAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataTabAlignment not supported on web");
    return factories.TabBarThemeData_readBack_tabAlignment(nativeStruct);
  }
  public TabIndicatorAnimation indicatorAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataIndicatorAnimation not supported on web");
    return factories.TabBarThemeData_readBack_indicatorAnimation(nativeStruct);
  }
  public BorderRadius splashBorderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataSplashBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.TabBarThemeData_readBack_splashBorderRadius(nativeStruct);
  }
  @Override
  public TabBarThemeData build() {
    return this;
  }
}
