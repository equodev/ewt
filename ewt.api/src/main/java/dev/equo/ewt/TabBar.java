package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TabBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TabBar extends StatefulWidget implements PreferredSizeWidget, TabBarI {
  private MemorySegment st;
  protected TabBar() {}
  TabBar(MemorySegment st) {
    this.id = TabBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBar");
    System.out.println("New TabBar id:"+id);
  }
  TabBar(int id) { this.id = id; }
  @Builder.Factory
  static TabBar tabBarTabBar(@Builder.Parameter List<WidgetI> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometryI> indicatorPadding, Optional<DecorationI> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadiusI> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    var st = factories.tabBarTabBar(tabs.stream().map(WidgetI::build).toList(),
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
    if (st == null) throw new RuntimeException("Failed to created widget TabBar");
    return new TabBar(st);
  }
  public static TabBarTabBarBuilder tabBar(List<WidgetI> tabs) {
    return TabBarTabBarBuilder.tabBarTabBar(tabs);
  }
  @Builder.Factory
  static TabBar tabBarSecondary(@Builder.Parameter List<WidgetI> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometryI> indicatorPadding, Optional<DecorationI> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadiusI> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    var st = factories.tabBarSecondary(tabs.stream().map(WidgetI::build).toList(),
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
    if (st == null) throw new RuntimeException("Failed to created widget TabBar");
    return new TabBar(st);
  }
  public static TabBarSecondaryBuilder secondary(List<WidgetI> tabs) {
    return TabBarSecondaryBuilder.tabBarSecondary(tabs);
  }
  public boolean isScrollable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIsScrollable not supported on web");
    return intToBool(TabBarObjSt.isScrollable(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarPadding not supported on web");
    return new EdgeInsetsGeometry(TabBarObjSt.padding(st)) {};
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarObjSt.indicatorColor(st));
  }
  public double indicatorWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorWeight not supported on web");
    return TabBarObjSt.indicatorWeight(st);
  }
  public EdgeInsetsGeometry indicatorPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorPadding not supported on web");
    return new EdgeInsetsGeometry(TabBarObjSt.indicatorPadding(st)) {};
  }
  public Decoration indicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicator not supported on web");
    return new Decoration(TabBarObjSt.indicator(st)) {};
  }
  public boolean automaticIndicatorColorAdjustment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarAutomaticIndicatorColorAdjustment not supported on web");
    return intToBool(TabBarObjSt.automaticIndicatorColorAdjustment(st));
  }
  public TabBarIndicatorSize indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorSize not supported on web");
    return TabBarIndicatorSize.values()[TabBarObjSt.indicatorSize(st)];
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarObjSt.dividerColor(st));
  }
  public double dividerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarDividerHeight not supported on web");
    return TabBarObjSt.dividerHeight(st);
  }
  public Color labelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarObjSt.labelColor(st));
  }
  public Color unselectedLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarUnselectedLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarObjSt.unselectedLabelColor(st));
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TabBarObjSt.labelStyle(st));
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarUnselectedLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TabBarObjSt.unselectedLabelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarLabelPadding not supported on web");
    return new EdgeInsetsGeometry(TabBarObjSt.labelPadding(st)) {};
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarDragStartBehavior not supported on web");
    return DragStartBehavior.values()[TabBarObjSt.dragStartBehavior(st)];
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarEnableFeedback not supported on web");
    return intToBool(TabBarObjSt.enableFeedback(st));
  }
  public BorderRadius splashBorderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarSplashBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(TabBarObjSt.splashBorderRadius(st));
  }
  public TabAlignment tabAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarTabAlignment not supported on web");
    return TabAlignment.values()[TabBarObjSt.tabAlignment(st)];
  }
  public TabIndicatorAnimation indicatorAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarIndicatorAnimation not supported on web");
    return TabIndicatorAnimation.values()[TabBarObjSt.indicatorAnimation(st)];
  }
  public boolean tabHasTextAndIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarTabHasTextAndIcon not supported on web");
    return intToBool(TabBarObjSt.tabHasTextAndIcon(st));
  }
  @Override
  public TabBar build() {
    return this;
  }
}
