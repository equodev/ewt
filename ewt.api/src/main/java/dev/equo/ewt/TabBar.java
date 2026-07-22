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
  @Builder.Factory
  static TabBar tabBarTabBar(@Builder.Parameter List<WidgetI> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometryI> indicatorPadding, Optional<DecorationI> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadiusI> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
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
  static TabBar tabBarSecondary(@Builder.Parameter List<WidgetI> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometryI> indicatorPadding, Optional<DecorationI> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadiusI> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
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
    return intToBool(TabBarObjSt.isScrollable(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(TabBarObjSt.padding(st)) {};
  }
  public Color indicatorColor() {
    return new Color(TabBarObjSt.indicatorColor(st));
  }
  public double indicatorWeight() {
    return TabBarObjSt.indicatorWeight(st);
  }
  public EdgeInsetsGeometry indicatorPadding() {
    return new EdgeInsetsGeometry(TabBarObjSt.indicatorPadding(st)) {};
  }
  public Decoration indicator() {
    return new Decoration(TabBarObjSt.indicator(st)) {};
  }
  public boolean automaticIndicatorColorAdjustment() {
    return intToBool(TabBarObjSt.automaticIndicatorColorAdjustment(st));
  }
  public TabBarIndicatorSize indicatorSize() {
    return TabBarIndicatorSize.values()[TabBarObjSt.indicatorSize(st)];
  }
  public Color dividerColor() {
    return new Color(TabBarObjSt.dividerColor(st));
  }
  public double dividerHeight() {
    return TabBarObjSt.dividerHeight(st);
  }
  public Color labelColor() {
    return new Color(TabBarObjSt.labelColor(st));
  }
  public Color unselectedLabelColor() {
    return new Color(TabBarObjSt.unselectedLabelColor(st));
  }
  public TextStyle labelStyle() {
    return new TextStyle(TabBarObjSt.labelStyle(st));
  }
  public TextStyle unselectedLabelStyle() {
    return new TextStyle(TabBarObjSt.unselectedLabelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    return new EdgeInsetsGeometry(TabBarObjSt.labelPadding(st)) {};
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[TabBarObjSt.dragStartBehavior(st)];
  }
  public boolean enableFeedback() {
    return intToBool(TabBarObjSt.enableFeedback(st));
  }
  public BorderRadius splashBorderRadius() {
    return new BorderRadius(TabBarObjSt.splashBorderRadius(st));
  }
  public TabAlignment tabAlignment() {
    return TabAlignment.values()[TabBarObjSt.tabAlignment(st)];
  }
  public TabIndicatorAnimation indicatorAnimation() {
    return TabIndicatorAnimation.values()[TabBarObjSt.indicatorAnimation(st)];
  }
  public boolean tabHasTextAndIcon() {
    return intToBool(TabBarObjSt.tabHasTextAndIcon(st));
  }
  @Override
  public TabBar build() {
    return this;
  }
}
