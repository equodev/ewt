package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationBar extends StatelessWidget implements NavigationBarI {
  protected NavigationBar() {}
  NavigationBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationBar navigationBarNavigationBar(Optional<DurationI> animationDuration, OptionalInt selectedIndex, List<WidgetI> destinations, Optional<Consumer<Integer>> onDestinationSelected, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, OptionalDouble height, Optional<NavigationDestinationLabelBehavior> labelBehavior, Optional<ColorI> overlayColor, Optional<TextStyleI> labelTextStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Boolean> maintainBottomViewPadding) {
    int id = factories.navigationBarNavigationBar(animationDuration.map(DurationI::build),
      selectedIndex,
      destinations.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      onDestinationSelected,
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      height,
      labelBehavior,
      overlayColor.map(ColorI::build),
      labelTextStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      maintainBottomViewPadding);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBar");
    return new NavigationBar(id);
  }
  public static NavigationBarNavigationBarBuilder navigationBar() {
    return NavigationBarNavigationBarBuilder.navigationBarNavigationBar();
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.NavigationBar_readBack_animationDuration(nativeStruct);
  }
  public int selectedIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarSelectedIndex not supported on web");
    return factories.NavigationBar_readBack_selectedIndex(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBar_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarElevation not supported on web");
    return factories.NavigationBar_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarShadowColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBar_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBar_readBack_surfaceTintColor(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationBar_readBack_indicatorColor(nativeStruct);
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarIndicatorShape not supported on web");
    return factories.NavigationBar_readBack_indicatorShape(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarHeight not supported on web");
    return factories.NavigationBar_readBack_height(nativeStruct);
  }
  public NavigationDestinationLabelBehavior labelBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarLabelBehavior not supported on web");
    return factories.NavigationBar_readBack_labelBehavior(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarLabelPadding not supported on web");
    return factories.NavigationBar_readBack_labelPadding(nativeStruct);
  }
  public boolean maintainBottomViewPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarMaintainBottomViewPadding not supported on web");
    return factories.NavigationBar_readBack_maintainBottomViewPadding(nativeStruct);
  }
  @Override
  public NavigationBar build() {
    return this;
  }
}
