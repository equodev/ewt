package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TabBarTheme extends InheritedTheme implements TabBarThemeI {
  protected TabBarTheme() {}
  TabBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TabBarTheme tabBarThemeTabBarTheme(Optional<DecorationI> indicator, Optional<ColorI> indicatorColor, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<EdgeInsetsGeometryI> labelPadding, Optional<TextStyleI> labelStyle, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<ColorI> overlayColor, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation, Optional<TabBarThemeDataI> data, Optional<WidgetI> child) {
    int id = factories.tabBarThemeTabBarTheme(indicator.map(DecorationI::build),
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
      data.map(TabBarThemeDataI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarTheme");
    return new TabBarTheme(id);
  }
  public static TabBarThemeTabBarThemeBuilder tabBarTheme() {
    return TabBarThemeTabBarThemeBuilder.tabBarThemeTabBarTheme();
  }
  public static TabBarThemeData of(BuildContextI context) {
    int id = factories.tabBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarThemeData");
    return new TabBarThemeData(id);
  }
  public static TabBarTheme lerp(TabBarThemeI a, TabBarThemeI b, double t) {
    int id = factories.tabBarThemeLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarTheme");
    return new TabBarTheme(id);
  }
  public Decoration indicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeIndicator not supported on web");
    return factories.TabBarTheme_readBack_indicator(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarTheme_readBack_indicatorColor(nativeStruct);
  }
  public TabBarIndicatorSize indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeIndicatorSize not supported on web");
    return factories.TabBarTheme_readBack_indicatorSize(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDividerColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarTheme_readBack_dividerColor(nativeStruct);
  }
  public double dividerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDividerHeight not supported on web");
    return factories.TabBarTheme_readBack_dividerHeight(nativeStruct);
  }
  public Color labelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeLabelColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarTheme_readBack_labelColor(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeLabelPadding not supported on web");
    return factories.TabBarTheme_readBack_labelPadding(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TabBarTheme_readBack_labelStyle(nativeStruct);
  }
  public Color unselectedLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeUnselectedLabelColor", getId());
      return new Color(__nid);
    }
    return factories.TabBarTheme_readBack_unselectedLabelColor(nativeStruct);
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeUnselectedLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TabBarTheme_readBack_unselectedLabelStyle(nativeStruct);
  }
  public TabAlignment tabAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeTabAlignment not supported on web");
    return factories.TabBarTheme_readBack_tabAlignment(nativeStruct);
  }
  public TabIndicatorAnimation indicatorAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeIndicatorAnimation not supported on web");
    return factories.TabBarTheme_readBack_indicatorAnimation(nativeStruct);
  }
  public TabBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeData", getId());
      return new TabBarThemeData(__nid);
    }
    return factories.TabBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public TabBarTheme build() {
    return this;
  }
}
