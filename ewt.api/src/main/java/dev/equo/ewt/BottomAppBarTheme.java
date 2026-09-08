package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomAppBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomAppBarTheme extends InheritedTheme implements BottomAppBarThemeI {
  private MemorySegment st;
  protected BottomAppBarTheme() {}
  BottomAppBarTheme(MemorySegment st) {
    this.id = BottomAppBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBarTheme");
    System.out.println("New BottomAppBarTheme id:"+id);
  }
  BottomAppBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static BottomAppBarTheme bottomAppBarThemeBottomAppBarTheme(Optional<ColorI> color, OptionalDouble elevation, OptionalDouble height, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, Optional<EdgeInsetsGeometryI> padding, Optional<BottomAppBarThemeDataI> data, Optional<WidgetI> child) {
    var st = factories.bottomAppBarThemeBottomAppBarTheme(color.map(ColorI::build),
      elevation,
      height,
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      data.map(BottomAppBarThemeDataI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BottomAppBarTheme");
    return new BottomAppBarTheme(st);
  }
  public static BottomAppBarThemeBottomAppBarThemeBuilder bottomAppBarTheme() {
    return BottomAppBarThemeBottomAppBarThemeBuilder.bottomAppBarThemeBottomAppBarTheme();
  }
  public static BottomAppBarThemeData of(BuildContextI context) {
    var st = factories.bottomAppBarThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget BottomAppBarThemeData");
    return new BottomAppBarThemeData(st);
  }
  public static BottomAppBarTheme lerp(BottomAppBarThemeI a, BottomAppBarThemeI b, double t) {
    var st = factories.bottomAppBarThemeLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BottomAppBarTheme");
    return new BottomAppBarTheme(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarThemeObjSt.color(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeElevation not supported on web");
    return BottomAppBarThemeObjSt.elevation(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemeHeight not supported on web");
    return BottomAppBarThemeObjSt.height(st);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarThemeObjSt.surfaceTintColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarThemeObjSt.shadowColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarThemePadding not supported on web");
    return new EdgeInsetsGeometry(BottomAppBarThemeObjSt.padding(st)) {};
  }
  public BottomAppBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BottomAppBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BottomAppBarThemeDataObjSt.id(__st, __nid);
      return new BottomAppBarThemeData(__st);
    }
    return new BottomAppBarThemeData(BottomAppBarThemeObjSt.data(st));
  }
  @Override
  public BottomAppBarTheme build() {
    return this;
  }
}
