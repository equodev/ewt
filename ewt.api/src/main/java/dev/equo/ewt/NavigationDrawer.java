package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationDrawer extends StatelessWidget implements NavigationDrawerI {
  protected NavigationDrawer() {}
  NavigationDrawer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationDrawer navigationDrawerNavigationDrawer(@Builder.Parameter List<WidgetI> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<ColorI> backgroundColor, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<Consumer<Integer>> onDestinationSelected, OptionalInt selectedIndex, Optional<EdgeInsetsGeometryI> tilePadding) {
    int id = factories.navigationDrawerNavigationDrawer(children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawer");
    return new NavigationDrawer(id);
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
    return factories.NavigationDrawer_readBack_backgroundColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerShadowColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawer_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawer_readBack_surfaceTintColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerElevation not supported on web");
    return factories.NavigationDrawer_readBack_elevation(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawer_readBack_indicatorColor(nativeStruct);
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerIndicatorShape not supported on web");
    return factories.NavigationDrawer_readBack_indicatorShape(nativeStruct);
  }
  public Widget header() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerHeader not supported on web");
    return factories.NavigationDrawer_readBack_header(nativeStruct);
  }
  public Widget footer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerFooter not supported on web");
    return factories.NavigationDrawer_readBack_footer(nativeStruct);
  }
  public int selectedIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerSelectedIndex not supported on web");
    return factories.NavigationDrawer_readBack_selectedIndex(nativeStruct);
  }
  public EdgeInsetsGeometry tilePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerTilePadding not supported on web");
    return factories.NavigationDrawer_readBack_tilePadding(nativeStruct);
  }
  @Override
  public NavigationDrawer build() {
    return this;
  }
}
