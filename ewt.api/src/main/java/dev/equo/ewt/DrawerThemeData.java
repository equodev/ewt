package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DrawerThemeData extends NativeObj.Base implements DrawerThemeDataI {
  protected DrawerThemeData() {}
  DrawerThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DrawerThemeData drawerThemeDataDrawerThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> scrimColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<ShapeBorderI> endShape, OptionalDouble width, Optional<Clip> clipBehavior) {
    int id = factories.drawerThemeDataDrawerThemeData(backgroundColor.map(ColorI::build),
      scrimColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      endShape.map(ShapeBorderI::build),
      width,
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerThemeData");
    return new DrawerThemeData(id);
  }
  public static DrawerThemeDataDrawerThemeDataBuilder drawerThemeData() {
    return DrawerThemeDataDrawerThemeDataBuilder.drawerThemeDataDrawerThemeData();
  }
  public static DrawerThemeData lerp(DrawerThemeDataI a, DrawerThemeDataI b, double t) {
    int id = factories.drawerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerThemeData");
    return new DrawerThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DrawerThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color scrimColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataScrimColor", getId());
      return new Color(__nid);
    }
    return factories.DrawerThemeData_readBack_scrimColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataElevation not supported on web");
    return factories.DrawerThemeData_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.DrawerThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.DrawerThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataShape not supported on web");
    return factories.DrawerThemeData_readBack_shape(nativeStruct);
  }
  public ShapeBorder endShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataEndShape not supported on web");
    return factories.DrawerThemeData_readBack_endShape(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataWidth not supported on web");
    return factories.DrawerThemeData_readBack_width(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerThemeDataClipBehavior not supported on web");
    return factories.DrawerThemeData_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public DrawerThemeData build() {
    return this;
  }
}
