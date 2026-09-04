package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationDrawerThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationDrawerThemeData extends NativeObj.Base implements NavigationDrawerThemeDataI {
  private MemorySegment st;
  protected NavigationDrawerThemeData() {}
  NavigationDrawerThemeData(MemorySegment st) {
    this.id = NavigationDrawerThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    System.out.println("New NavigationDrawerThemeData id:"+id);
  }
  NavigationDrawerThemeData(int id) { this.id = id; }
  @Builder.Factory
  static NavigationDrawerThemeData navigationDrawerThemeDataNavigationDrawerThemeData(OptionalDouble tileHeight, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<TextStyleI> labelTextStyle, Optional<IconThemeDataI> iconTheme) {
    var st = factories.navigationDrawerThemeDataNavigationDrawerThemeData(tileHeight,
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      labelTextStyle.map(TextStyleI::build),
      iconTheme.map(IconThemeDataI::build));
    if (st == null) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    return new NavigationDrawerThemeData(st);
  }
  public static NavigationDrawerThemeDataNavigationDrawerThemeDataBuilder navigationDrawerThemeData() {
    return NavigationDrawerThemeDataNavigationDrawerThemeDataBuilder.navigationDrawerThemeDataNavigationDrawerThemeData();
  }
  public static NavigationDrawerThemeData lerp(NavigationDrawerThemeDataI a, NavigationDrawerThemeDataI b, double t) {
    var st = factories.navigationDrawerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    return new NavigationDrawerThemeData(st);
  }
  public double tileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerThemeDataTileHeight not supported on web");
    return NavigationDrawerThemeDataObjSt.tileHeight(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerThemeDataElevation not supported on web");
    return NavigationDrawerThemeDataObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerThemeDataObjSt.surfaceTintColor(st));
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationDrawerThemeDataObjSt.indicatorColor(st));
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerThemeDataIndicatorShape not supported on web");
    return new ShapeBorder(NavigationDrawerThemeDataObjSt.indicatorShape(st)) {};
  }
  @Override
  public NavigationDrawerThemeData build() {
    return this;
  }
}
