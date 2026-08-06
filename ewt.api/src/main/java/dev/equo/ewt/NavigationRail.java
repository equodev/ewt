package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationRailObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationRail extends StatefulWidget implements NavigationRailI {
  private MemorySegment st;
  protected NavigationRail() {}
  NavigationRail(MemorySegment st) {
    this.id = NavigationRailObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRail");
    System.out.println("New NavigationRail id:"+id);
  }
  NavigationRail(int id) { this.id = id; }
  @Builder.Factory
  static NavigationRail navigationRailNavigationRail(Optional<ColorI> backgroundColor, Optional<Boolean> extended, Optional<WidgetI> leading, Optional<WidgetI> trailing, List<NavigationRailDestinationI> destinations, int selectedIndex, Optional<Consumer<Integer>> onDestinationSelected, OptionalDouble elevation, OptionalDouble groupAlignment, Optional<NavigationRailLabelType> labelType, Optional<TextStyleI> unselectedLabelTextStyle, Optional<TextStyleI> selectedLabelTextStyle, OptionalDouble minWidth, OptionalDouble minExtendedWidth, Optional<Boolean> useIndicator, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<Boolean> leadingAtTop, Optional<Boolean> trailingAtBottom, Optional<Boolean> scrollable) {
    var st = factories.navigationRailNavigationRail(backgroundColor.map(ColorI::build),
      extended,
      leading.map(WidgetI::build),
      trailing.map(WidgetI::build),
      destinations.stream().map(NavigationRailDestinationI::build).toList(),
      selectedIndex,
      onDestinationSelected,
      elevation,
      groupAlignment,
      labelType,
      unselectedLabelTextStyle.map(TextStyleI::build),
      selectedLabelTextStyle.map(TextStyleI::build),
      minWidth,
      minExtendedWidth,
      useIndicator,
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      leadingAtTop,
      trailingAtBottom,
      scrollable);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationRail");
    return new NavigationRail(st);
  }
  public static NavigationRailNavigationRailBuilder navigationRail() {
    return NavigationRailNavigationRailBuilder.navigationRailNavigationRail();
  }
  public static Animation extendedAnimation(BuildContextI context) {
    int id = factories.navigationRailExtendedAnimation(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Animation<double>");
    System.out.println("New Animation<double> id:"+id);
    return new Animation() { public int getId() { return id; } };
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationRailObjSt.backgroundColor(st));
  }
  public boolean extended() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailExtended not supported on web");
    return intToBool(NavigationRailObjSt.extended(st));
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailLeading not supported on web");
    return new Widget(NavigationRailObjSt.leading(st)) {};
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailTrailing not supported on web");
    return new Widget(NavigationRailObjSt.trailing(st)) {};
  }
  public int selectedIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailSelectedIndex not supported on web");
    return NavigationRailObjSt.selectedIndex(st);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailElevation not supported on web");
    return NavigationRailObjSt.elevation(st);
  }
  public double groupAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailGroupAlignment not supported on web");
    return NavigationRailObjSt.groupAlignment(st);
  }
  public NavigationRailLabelType labelType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailLabelType not supported on web");
    return NavigationRailLabelType.values()[NavigationRailObjSt.labelType(st)];
  }
  public TextStyle unselectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailUnselectedLabelTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(NavigationRailObjSt.unselectedLabelTextStyle(st));
  }
  public TextStyle selectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailSelectedLabelTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(NavigationRailObjSt.selectedLabelTextStyle(st));
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailMinWidth not supported on web");
    return NavigationRailObjSt.minWidth(st);
  }
  public double minExtendedWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailMinExtendedWidth not supported on web");
    return NavigationRailObjSt.minExtendedWidth(st);
  }
  public boolean useIndicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailUseIndicator not supported on web");
    return intToBool(NavigationRailObjSt.useIndicator(st));
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationRailObjSt.indicatorColor(st));
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailIndicatorShape not supported on web");
    return new ShapeBorder(NavigationRailObjSt.indicatorShape(st)) {};
  }
  public boolean leadingAtTop() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailLeadingAtTop not supported on web");
    return intToBool(NavigationRailObjSt.leadingAtTop(st));
  }
  public boolean trailingAtBottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailTrailingAtBottom not supported on web");
    return intToBool(NavigationRailObjSt.trailingAtBottom(st));
  }
  public boolean scrollable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailScrollable not supported on web");
    return intToBool(NavigationRailObjSt.scrollable(st));
  }
  @Override
  public NavigationRail build() {
    return this;
  }
}
