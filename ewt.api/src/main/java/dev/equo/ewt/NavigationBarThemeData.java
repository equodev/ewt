package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationBarThemeData extends NativeObj.Base implements NavigationBarThemeDataI {
  private MemorySegment st;
  protected NavigationBarThemeData() {}
  NavigationBarThemeData(MemorySegment st) {
    this.id = NavigationBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    System.out.println("New NavigationBarThemeData id:"+id);
  }
  NavigationBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static NavigationBarThemeData navigationBarThemeDataNavigationBarThemeData(OptionalDouble height, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, Optional<TextStyleI> labelTextStyle, Optional<IconThemeDataI> iconTheme, Optional<NavigationDestinationLabelBehavior> labelBehavior, Optional<ColorI> overlayColor, Optional<EdgeInsetsGeometryI> labelPadding) {
    var st = factories.navigationBarThemeDataNavigationBarThemeData(height,
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      labelTextStyle.map(TextStyleI::build),
      iconTheme.map(IconThemeDataI::build),
      labelBehavior,
      overlayColor.map(ColorI::build),
      labelPadding.map(EdgeInsetsGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    return new NavigationBarThemeData(st);
  }
  public static NavigationBarThemeDataNavigationBarThemeDataBuilder navigationBarThemeData() {
    return NavigationBarThemeDataNavigationBarThemeDataBuilder.navigationBarThemeDataNavigationBarThemeData();
  }
  public static NavigationBarThemeData lerp(NavigationBarThemeDataI a, NavigationBarThemeDataI b, double t) {
    var st = factories.navigationBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    return new NavigationBarThemeData(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataHeight not supported on web");
    return NavigationBarThemeDataObjSt.height(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataElevation not supported on web");
    return NavigationBarThemeDataObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarThemeDataObjSt.surfaceTintColor(st));
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(NavigationBarThemeDataObjSt.indicatorColor(st));
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataIndicatorShape not supported on web");
    return new ShapeBorder(NavigationBarThemeDataObjSt.indicatorShape(st)) {};
  }
  public NavigationDestinationLabelBehavior labelBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataLabelBehavior not supported on web");
    return NavigationDestinationLabelBehavior.values()[NavigationBarThemeDataObjSt.labelBehavior(st)];
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationBarThemeDataLabelPadding not supported on web");
    return new EdgeInsetsGeometry(NavigationBarThemeDataObjSt.labelPadding(st)) {};
  }
  @Override
  public NavigationBarThemeData build() {
    return this;
  }
}
