package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomAppBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomAppBarThemeData extends NativeObj.Base implements BottomAppBarThemeDataI {
  private MemorySegment st;
  protected BottomAppBarThemeData() {}
  BottomAppBarThemeData(MemorySegment st) {
    this.id = BottomAppBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    System.out.println("New BottomAppBarThemeData id:"+id);
  }
  BottomAppBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static BottomAppBarThemeData bottomAppBarThemeDataBottomAppBarThemeData(Optional<ColorI> color, OptionalDouble elevation, OptionalDouble height, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, Optional<EdgeInsetsGeometryI> padding) {
    var st = factories.bottomAppBarThemeDataBottomAppBarThemeData(color.map(ColorI::build),
      elevation,
      height,
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    return new BottomAppBarThemeData(st);
  }
  public static BottomAppBarThemeDataBottomAppBarThemeDataBuilder bottomAppBarThemeData() {
    return BottomAppBarThemeDataBottomAppBarThemeDataBuilder.bottomAppBarThemeDataBottomAppBarThemeData();
  }
  public static BottomAppBarThemeData lerp(BottomAppBarThemeDataI a, BottomAppBarThemeDataI b, double t) {
    var st = factories.bottomAppBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    return new BottomAppBarThemeData(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeDataColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarThemeDataObjSt.color(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeDataElevation not supported on web");
    return BottomAppBarThemeDataObjSt.elevation(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeDataHeight not supported on web");
    return BottomAppBarThemeDataObjSt.height(st);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarThemeDataObjSt.surfaceTintColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarThemeDataObjSt.shadowColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(BottomAppBarThemeDataObjSt.padding(st)) {};
  }
  @Override
  public BottomAppBarThemeData build() {
    return this;
  }
}
