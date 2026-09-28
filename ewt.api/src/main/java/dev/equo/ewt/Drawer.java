package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Drawer extends StatelessWidget implements DrawerI {
  protected Drawer() {}
  Drawer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Drawer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Drawer drawerDrawer(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, OptionalDouble width, Optional<WidgetI> child, Optional<String> semanticLabel, Optional<Clip> clipBehavior) {
    int id = factories.drawerDrawer(backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      width,
      child.map(WidgetI::build),
      semanticLabel,
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget Drawer");
    return new Drawer(id);
  }
  public static DrawerDrawerBuilder drawer() {
    return DrawerDrawerBuilder.drawerDrawer();
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.Drawer_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerElevation not supported on web");
    return factories.Drawer_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerShadowColor", getId());
      return new Color(__nid);
    }
    return factories.Drawer_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.Drawer_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerShape not supported on web");
    return factories.Drawer_readBack_shape(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerWidth not supported on web");
    return factories.Drawer_readBack_width(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerChild not supported on web");
    return factories.Drawer_readBack_child(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerSemanticLabel not supported on web");
    return factories.Drawer_readBack_semanticLabel(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerClipBehavior not supported on web");
    return factories.Drawer_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public Drawer build() {
    return this;
  }
}
