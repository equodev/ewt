package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TabBar extends StatefulWidget implements PreferredSizeWidget, TabBarI {
  protected TabBar() {}
  TabBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TabBar tabBarTabBar(@Builder.Parameter List<WidgetI> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometryI> indicatorPadding, Optional<DecorationI> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadiusI> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    int id = factories.tabBarTabBar(tabs.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      isScrollable,
      padding.map(EdgeInsetsGeometryI::build),
      indicatorColor.map(ColorI::build),
      automaticIndicatorColorAdjustment,
      indicatorWeight,
      indicatorPadding.map(EdgeInsetsGeometryI::build),
      indicator.map(DecorationI::build),
      indicatorSize,
      dividerColor.map(ColorI::build),
      dividerHeight,
      labelColor.map(ColorI::build),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      unselectedLabelColor.map(ColorI::build),
      unselectedLabelStyle.map(TextStyleI::build),
      dragStartBehavior,
      overlayColor.map(ColorI::build),
      enableFeedback,
      onTap,
      onHover,
      onFocusChange,
      splashBorderRadius.map(BorderRadiusI::build),
      tabAlignment,
      indicatorAnimation);
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBar");
    return new TabBar(id);
  }
  public static TabBarTabBarBuilder tabBar(List<WidgetI> tabs) {
    return TabBarTabBarBuilder.tabBarTabBar(tabs);
  }
  @Builder.Factory
  static TabBar tabBarSecondary(@Builder.Parameter List<WidgetI> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometryI> indicatorPadding, Optional<DecorationI> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadiusI> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    int id = factories.tabBarSecondary(tabs.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      isScrollable,
      padding.map(EdgeInsetsGeometryI::build),
      indicatorColor.map(ColorI::build),
      automaticIndicatorColorAdjustment,
      indicatorWeight,
      indicatorPadding.map(EdgeInsetsGeometryI::build),
      indicator.map(DecorationI::build),
      indicatorSize,
      dividerColor.map(ColorI::build),
      dividerHeight,
      labelColor.map(ColorI::build),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      unselectedLabelColor.map(ColorI::build),
      unselectedLabelStyle.map(TextStyleI::build),
      dragStartBehavior,
      overlayColor.map(ColorI::build),
      enableFeedback,
      onTap,
      onHover,
      onFocusChange,
      splashBorderRadius.map(BorderRadiusI::build),
      tabAlignment,
      indicatorAnimation);
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBar");
    return new TabBar(id);
  }
  public static TabBarSecondaryBuilder secondary(List<WidgetI> tabs) {
    return TabBarSecondaryBuilder.tabBarSecondary(tabs);
  }
  public boolean isScrollable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIsScrollable not supported on web");
    return factories.TabBar_readBack_isScrollable(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarPadding not supported on web");
    return factories.TabBar_readBack_padding(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.TabBar_readBack_indicatorColor(nativeStruct);
  }
  public double indicatorWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorWeight not supported on web");
    return factories.TabBar_readBack_indicatorWeight(nativeStruct);
  }
  public EdgeInsetsGeometry indicatorPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorPadding not supported on web");
    return factories.TabBar_readBack_indicatorPadding(nativeStruct);
  }
  public Decoration indicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicator not supported on web");
    return factories.TabBar_readBack_indicator(nativeStruct);
  }
  public boolean automaticIndicatorColorAdjustment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarAutomaticIndicatorColorAdjustment not supported on web");
    return factories.TabBar_readBack_automaticIndicatorColorAdjustment(nativeStruct);
  }
  public TabBarIndicatorSize indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorSize not supported on web");
    return factories.TabBar_readBack_indicatorSize(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarDividerColor", getId());
      return new Color(__nid);
    }
    return factories.TabBar_readBack_dividerColor(nativeStruct);
  }
  public double dividerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarDividerHeight not supported on web");
    return factories.TabBar_readBack_dividerHeight(nativeStruct);
  }
  public Color labelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarLabelColor", getId());
      return new Color(__nid);
    }
    return factories.TabBar_readBack_labelColor(nativeStruct);
  }
  public Color unselectedLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarUnselectedLabelColor", getId());
      return new Color(__nid);
    }
    return factories.TabBar_readBack_unselectedLabelColor(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TabBar_readBack_labelStyle(nativeStruct);
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarUnselectedLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TabBar_readBack_unselectedLabelStyle(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarLabelPadding not supported on web");
    return factories.TabBar_readBack_labelPadding(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarDragStartBehavior not supported on web");
    return factories.TabBar_readBack_dragStartBehavior(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarEnableFeedback not supported on web");
    return factories.TabBar_readBack_enableFeedback(nativeStruct);
  }
  public BorderRadius splashBorderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarSplashBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.TabBar_readBack_splashBorderRadius(nativeStruct);
  }
  public TabAlignment tabAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarTabAlignment not supported on web");
    return factories.TabBar_readBack_tabAlignment(nativeStruct);
  }
  public TabIndicatorAnimation indicatorAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorAnimation not supported on web");
    return factories.TabBar_readBack_indicatorAnimation(nativeStruct);
  }
  public boolean tabHasTextAndIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarTabHasTextAndIcon not supported on web");
    return factories.TabBar_readBack_tabHasTextAndIcon(nativeStruct);
  }
  @Override
  public TabBar build() {
    return this;
  }
}
