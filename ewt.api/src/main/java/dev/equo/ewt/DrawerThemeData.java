package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DrawerThemeData extends NativeObj.Base implements DrawerThemeDataI {
  private MemorySegment st;
  protected DrawerThemeData() {}
  DrawerThemeData(MemorySegment st) {
    this.id = DrawerThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerThemeData");
    System.out.println("New DrawerThemeData id:"+id);
  }
  DrawerThemeData(int id) { this.id = id; }
  @Builder.Factory
  static DrawerThemeData drawerThemeDataDrawerThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> scrimColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<ShapeBorderI> endShape, OptionalDouble width, Optional<Clip> clipBehavior) {
    var st = factories.drawerThemeDataDrawerThemeData(backgroundColor.map(ColorI::build),
      scrimColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      endShape.map(ShapeBorderI::build),
      width,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget DrawerThemeData");
    return new DrawerThemeData(st);
  }
  public static DrawerThemeDataDrawerThemeDataBuilder drawerThemeData() {
    return DrawerThemeDataDrawerThemeDataBuilder.drawerThemeDataDrawerThemeData();
  }
  public static DrawerThemeData lerp(DrawerThemeDataI a, DrawerThemeDataI b, double t) {
    var st = factories.drawerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget DrawerThemeData");
    return new DrawerThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DrawerThemeDataObjSt.backgroundColor(st));
  }
  public Color scrimColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataScrimColor", getId());
      return new Color(__nid);
    }
    return new Color(DrawerThemeDataObjSt.scrimColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataElevation not supported on web");
    return DrawerThemeDataObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(DrawerThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(DrawerThemeDataObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataShape not supported on web");
    return new ShapeBorder(DrawerThemeDataObjSt.shape(st)) {};
  }
  public ShapeBorder endShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataEndShape not supported on web");
    return new ShapeBorder(DrawerThemeDataObjSt.endShape(st)) {};
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataWidth not supported on web");
    return DrawerThemeDataObjSt.width(st);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataClipBehavior not supported on web");
    return Clip.values()[DrawerThemeDataObjSt.clipBehavior(st)];
  }
  @Override
  public DrawerThemeData build() {
    return this;
  }
}
