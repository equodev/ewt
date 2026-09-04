package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationRailThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationRailThemeData extends NativeObj.Base implements NavigationRailThemeDataI {
  private MemorySegment st;
  protected NavigationRailThemeData() {}
  NavigationRailThemeData(MemorySegment st) {
    this.id = NavigationRailThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    System.out.println("New NavigationRailThemeData id:"+id);
  }
  NavigationRailThemeData(int id) { this.id = id; }
  @Builder.Factory
  static NavigationRailThemeData navigationRailThemeDataNavigationRailThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<TextStyleI> unselectedLabelTextStyle, Optional<TextStyleI> selectedLabelTextStyle, Optional<IconThemeDataI> unselectedIconTheme, Optional<IconThemeDataI> selectedIconTheme, OptionalDouble groupAlignment, Optional<NavigationRailLabelType> labelType, Optional<Boolean> useIndicator, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, OptionalDouble minWidth, OptionalDouble minExtendedWidth) {
    var st = factories.navigationRailThemeDataNavigationRailThemeData(backgroundColor.map(ColorI::build),
      elevation,
      unselectedLabelTextStyle.map(TextStyleI::build),
      selectedLabelTextStyle.map(TextStyleI::build),
      unselectedIconTheme.map(IconThemeDataI::build),
      selectedIconTheme.map(IconThemeDataI::build),
      groupAlignment,
      labelType,
      useIndicator,
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      minWidth,
      minExtendedWidth);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    return new NavigationRailThemeData(st);
  }
  public static NavigationRailThemeDataNavigationRailThemeDataBuilder navigationRailThemeData() {
    return NavigationRailThemeDataNavigationRailThemeDataBuilder.navigationRailThemeDataNavigationRailThemeData();
  }
  public static NavigationRailThemeData lerp(NavigationRailThemeDataI a, NavigationRailThemeDataI b, double t) {
    var st = factories.navigationRailThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    return new NavigationRailThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationRailThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataElevation not supported on web");
    return NavigationRailThemeDataObjSt.elevation(st);
  }
  public TextStyle unselectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataUnselectedLabelTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(NavigationRailThemeDataObjSt.unselectedLabelTextStyle(st));
  }
  public TextStyle selectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataSelectedLabelTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(NavigationRailThemeDataObjSt.selectedLabelTextStyle(st));
  }
  public IconThemeData unselectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataUnselectedIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(NavigationRailThemeDataObjSt.unselectedIconTheme(st));
  }
  public IconThemeData selectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataSelectedIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(NavigationRailThemeDataObjSt.selectedIconTheme(st));
  }
  public double groupAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataGroupAlignment not supported on web");
    return NavigationRailThemeDataObjSt.groupAlignment(st);
  }
  public NavigationRailLabelType labelType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataLabelType not supported on web");
    return NavigationRailLabelType.values()[NavigationRailThemeDataObjSt.labelType(st)];
  }
  public boolean useIndicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataUseIndicator not supported on web");
    return intToBool(NavigationRailThemeDataObjSt.useIndicator(st));
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationRailThemeDataObjSt.indicatorColor(st));
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataIndicatorShape not supported on web");
    return new ShapeBorder(NavigationRailThemeDataObjSt.indicatorShape(st)) {};
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataMinWidth not supported on web");
    return NavigationRailThemeDataObjSt.minWidth(st);
  }
  public double minExtendedWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataMinExtendedWidth not supported on web");
    return NavigationRailThemeDataObjSt.minExtendedWidth(st);
  }
  @Override
  public NavigationRailThemeData build() {
    return this;
  }
}
