package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Drawer extends StatelessWidget implements DrawerI {
  private MemorySegment st;
  protected Drawer() {}
  Drawer(MemorySegment st) {
    this.id = DrawerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Drawer");
    System.out.println("New Drawer id:"+id);
  }
  Drawer(int id) { this.id = id; }
  @Builder.Factory
  static Drawer drawerDrawer(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, OptionalDouble width, Optional<WidgetI> child, Optional<String> semanticLabel, Optional<Clip> clipBehavior) {
    var st = factories.drawerDrawer(backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      width,
      child.map(WidgetI::build),
      semanticLabel,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget Drawer");
    return new Drawer(st);
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
    return new Color(DrawerObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerElevation not supported on web");
    return DrawerObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(DrawerObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(DrawerObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerShape not supported on web");
    return new ShapeBorder(DrawerObjSt.shape(st)) {};
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerWidth not supported on web");
    return DrawerObjSt.width(st);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerChild not supported on web");
    return new Widget(DrawerObjSt.child(st)) {};
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerSemanticLabel not supported on web");
    return DrawerObjSt.semanticLabel(st).getString(0);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerClipBehavior not supported on web");
    return Clip.values()[DrawerObjSt.clipBehavior(st)];
  }
  @Override
  public Drawer build() {
    return this;
  }
}
