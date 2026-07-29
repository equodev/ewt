package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationDrawerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationDrawer extends StatelessWidget implements NavigationDrawerI {
  private MemorySegment st;
  protected NavigationDrawer() {}
  NavigationDrawer(MemorySegment st) {
    this.id = NavigationDrawerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawer");
    System.out.println("New NavigationDrawer id:"+id);
  }
  NavigationDrawer(int id) { this.id = id; }
  @Builder.Factory
  static NavigationDrawer navigationDrawerNavigationDrawer(@Builder.Parameter List<WidgetI> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<ColorI> backgroundColor, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<Consumer<Integer>> onDestinationSelected, OptionalInt selectedIndex, Optional<EdgeInsetsGeometryI> tilePadding) {
    var st = factories.navigationDrawerNavigationDrawer(children.stream().map(WidgetI::build).toList(),
      header.map(WidgetI::build),
      footer.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      onDestinationSelected,
      selectedIndex,
      tilePadding.map(EdgeInsetsGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget NavigationDrawer");
    return new NavigationDrawer(st);
  }
  public static NavigationDrawerNavigationDrawerBuilder navigationDrawer(List<WidgetI> children) {
    return NavigationDrawerNavigationDrawerBuilder.navigationDrawerNavigationDrawer(children);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerObjSt.backgroundColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerObjSt.surfaceTintColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerElevation not supported on web");
    return NavigationDrawerObjSt.elevation(st);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerObjSt.indicatorColor(st));
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerIndicatorShape not supported on web");
    return new ShapeBorder(NavigationDrawerObjSt.indicatorShape(st)) {};
  }
  public Widget header() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerHeader not supported on web");
    return new Widget(NavigationDrawerObjSt.header(st)) {};
  }
  public Widget footer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerFooter not supported on web");
    return new Widget(NavigationDrawerObjSt.footer(st)) {};
  }
  public int selectedIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerSelectedIndex not supported on web");
    return NavigationDrawerObjSt.selectedIndex(st);
  }
  public EdgeInsetsGeometry tilePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerTilePadding not supported on web");
    return new EdgeInsetsGeometry(NavigationDrawerObjSt.tilePadding(st)) {};
  }
  @Override
  public NavigationDrawer build() {
    return this;
  }
}
