package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationRail extends StatefulWidget implements NavigationRailI {
  protected NavigationRail() {}
  NavigationRail(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRail");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationRail navigationRailNavigationRail(Optional<ColorI> backgroundColor, Optional<Boolean> extended, Optional<WidgetI> leading, Optional<WidgetI> trailing, List<NavigationRailDestinationI> destinations, OptionalInt selectedIndex, Optional<Consumer<Integer>> onDestinationSelected, OptionalDouble elevation, OptionalDouble groupAlignment, Optional<NavigationRailLabelType> labelType, Optional<TextStyleI> unselectedLabelTextStyle, Optional<TextStyleI> selectedLabelTextStyle, Optional<IconThemeDataI> unselectedIconTheme, Optional<IconThemeDataI> selectedIconTheme, OptionalDouble minWidth, OptionalDouble minExtendedWidth, Optional<Boolean> useIndicator, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<Boolean> leadingAtTop, Optional<Boolean> trailingAtBottom, Optional<Boolean> scrollable, Optional<MainAxisAlignment> mainAxisAlignment) {
    int id = factories.navigationRailNavigationRail(backgroundColor.map(ColorI::build),
      extended,
      leading.map(WidgetI::build),
      trailing.map(WidgetI::build),
      destinations.stream().map(NavigationRailDestinationI::build).collect(java.util.stream.Collectors.toList()),
      selectedIndex,
      onDestinationSelected,
      elevation,
      groupAlignment,
      labelType,
      unselectedLabelTextStyle.map(TextStyleI::build),
      selectedLabelTextStyle.map(TextStyleI::build),
      unselectedIconTheme.map(IconThemeDataI::build),
      selectedIconTheme.map(IconThemeDataI::build),
      minWidth,
      minExtendedWidth,
      useIndicator,
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      leadingAtTop,
      trailingAtBottom,
      scrollable,
      mainAxisAlignment);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRail");
    return new NavigationRail(id);
  }
  public static NavigationRailNavigationRailBuilder navigationRail() {
    return NavigationRailNavigationRailBuilder.navigationRailNavigationRail();
  }
  public static Animation extendedAnimation(BuildContextI context) {
    var id = factories.navigationRailExtendedAnimation(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Animation<double>");
    return new Animation() { public int getId() { return id; } };
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationRail_readBack_backgroundColor(nativeStruct);
  }
  public boolean extended() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailExtended not supported on web");
    return factories.NavigationRail_readBack_extended(nativeStruct);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailLeading not supported on web");
    return factories.NavigationRail_readBack_leading(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailTrailing not supported on web");
    return factories.NavigationRail_readBack_trailing(nativeStruct);
  }
  public int selectedIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailSelectedIndex not supported on web");
    return factories.NavigationRail_readBack_selectedIndex(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailElevation not supported on web");
    return factories.NavigationRail_readBack_elevation(nativeStruct);
  }
  public double groupAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailGroupAlignment not supported on web");
    return factories.NavigationRail_readBack_groupAlignment(nativeStruct);
  }
  public NavigationRailLabelType labelType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailLabelType not supported on web");
    return factories.NavigationRail_readBack_labelType(nativeStruct);
  }
  public TextStyle unselectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailUnselectedLabelTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.NavigationRail_readBack_unselectedLabelTextStyle(nativeStruct);
  }
  public TextStyle selectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailSelectedLabelTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.NavigationRail_readBack_selectedLabelTextStyle(nativeStruct);
  }
  public IconThemeData unselectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailUnselectedIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.NavigationRail_readBack_unselectedIconTheme(nativeStruct);
  }
  public IconThemeData selectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailSelectedIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.NavigationRail_readBack_selectedIconTheme(nativeStruct);
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailMinWidth not supported on web");
    return factories.NavigationRail_readBack_minWidth(nativeStruct);
  }
  public double minExtendedWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailMinExtendedWidth not supported on web");
    return factories.NavigationRail_readBack_minExtendedWidth(nativeStruct);
  }
  public boolean useIndicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailUseIndicator not supported on web");
    return factories.NavigationRail_readBack_useIndicator(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationRail_readBack_indicatorColor(nativeStruct);
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailIndicatorShape not supported on web");
    return factories.NavigationRail_readBack_indicatorShape(nativeStruct);
  }
  public boolean leadingAtTop() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailLeadingAtTop not supported on web");
    return factories.NavigationRail_readBack_leadingAtTop(nativeStruct);
  }
  public boolean trailingAtBottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailTrailingAtBottom not supported on web");
    return factories.NavigationRail_readBack_trailingAtBottom(nativeStruct);
  }
  public boolean scrollable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailScrollable not supported on web");
    return factories.NavigationRail_readBack_scrollable(nativeStruct);
  }
  public MainAxisAlignment mainAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailMainAxisAlignment not supported on web");
    return factories.NavigationRail_readBack_mainAxisAlignment(nativeStruct);
  }
  @Override
  public NavigationRail build() {
    return this;
  }
}
