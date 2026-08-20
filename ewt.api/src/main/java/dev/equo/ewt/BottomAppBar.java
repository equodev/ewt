package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomAppBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomAppBar extends StatefulWidget implements BottomAppBarI {
  private MemorySegment st;
  protected BottomAppBar() {}
  BottomAppBar(MemorySegment st) {
    this.id = BottomAppBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBar");
    System.out.println("New BottomAppBar id:"+id);
  }
  BottomAppBar(int id) { this.id = id; }
  @Builder.Factory
  static BottomAppBar bottomAppBarBottomAppBar(Optional<ColorI> color, OptionalDouble elevation, Optional<Clip> clipBehavior, OptionalDouble notchMargin, Optional<WidgetI> child, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, OptionalDouble height) {
    var st = factories.bottomAppBarBottomAppBar(color.map(ColorI::build),
      elevation,
      clipBehavior,
      notchMargin,
      child.map(WidgetI::build),
      padding.map(EdgeInsetsGeometryI::build),
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      height);
    if (st == null) throw new RuntimeException("Failed to created widget BottomAppBar");
    return new BottomAppBar(st);
  }
  public static BottomAppBarBottomAppBarBuilder bottomAppBar() {
    return BottomAppBarBottomAppBarBuilder.bottomAppBarBottomAppBar();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarChild not supported on web");
    return new Widget(BottomAppBarObjSt.child(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarPadding not supported on web");
    return new EdgeInsetsGeometry(BottomAppBarObjSt.padding(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarObjSt.color(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarElevation not supported on web");
    return BottomAppBarObjSt.elevation(st);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarClipBehavior not supported on web");
    return Clip.values()[BottomAppBarObjSt.clipBehavior(st)];
  }
  public double notchMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarNotchMargin not supported on web");
    return BottomAppBarObjSt.notchMargin(st);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarObjSt.surfaceTintColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomAppBarObjSt.shadowColor(st));
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarHeight not supported on web");
    return BottomAppBarObjSt.height(st);
  }
  @Override
  public BottomAppBar build() {
    return this;
  }
}
