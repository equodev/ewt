package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationBar extends StatelessWidget implements NavigationBarI {
  private MemorySegment st;
  protected NavigationBar() {}
  NavigationBar(MemorySegment st) {
    this.id = NavigationBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBar");
    System.out.println("New NavigationBar id:"+id);
  }
  NavigationBar(int id) { this.id = id; }
  @Builder.Factory
  static NavigationBar navigationBarNavigationBar(Optional<DurationI> animationDuration, OptionalInt selectedIndex, List<WidgetI> destinations, Optional<Consumer<Integer>> onDestinationSelected, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, OptionalDouble height, Optional<NavigationDestinationLabelBehavior> labelBehavior, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Boolean> maintainBottomViewPadding) {
    var st = factories.navigationBarNavigationBar(animationDuration.map(DurationI::build),
      selectedIndex,
      destinations.stream().map(WidgetI::build).toList(),
      onDestinationSelected,
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      height,
      labelBehavior,
      labelPadding.map(EdgeInsetsGeometryI::build),
      maintainBottomViewPadding);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationBar");
    return new NavigationBar(st);
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
    return new Duration(NavigationBarObjSt.animationDuration(st));
  }
  public int selectedIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarSelectedIndex not supported on web");
    return NavigationBarObjSt.selectedIndex(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarElevation not supported on web");
    return NavigationBarObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarObjSt.surfaceTintColor(st));
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarObjSt.indicatorColor(st));
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarIndicatorShape not supported on web");
    return new ShapeBorder(NavigationBarObjSt.indicatorShape(st)) {};
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarHeight not supported on web");
    return NavigationBarObjSt.height(st);
  }
  public NavigationDestinationLabelBehavior labelBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarLabelBehavior not supported on web");
    return NavigationDestinationLabelBehavior.values()[NavigationBarObjSt.labelBehavior(st)];
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarLabelPadding not supported on web");
    return new EdgeInsetsGeometry(NavigationBarObjSt.labelPadding(st)) {};
  }
  public boolean maintainBottomViewPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarMaintainBottomViewPadding not supported on web");
    return intToBool(NavigationBarObjSt.maintainBottomViewPadding(st));
  }
  @Override
  public NavigationBar build() {
    return this;
  }
}
