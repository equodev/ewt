package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerHeaderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DrawerHeader extends StatelessWidget implements DrawerHeaderI {
  private MemorySegment st;
  protected DrawerHeader() {}
  DrawerHeader(MemorySegment st) {
    this.id = DrawerHeaderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerHeader");
    System.out.println("New DrawerHeader id:"+id);
  }
  DrawerHeader(int id) { this.id = id; }
  @Builder.Factory
  static DrawerHeader drawerHeaderDrawerHeader(Optional<DecorationI> decoration, Optional<EdgeInsetsGeometryI> margin, Optional<EdgeInsetsGeometryI> padding, Optional<DurationI> duration, Optional<CurveI> curve, WidgetI child) {
    var st = factories.drawerHeaderDrawerHeader(decoration.map(DecorationI::build),
      margin.map(EdgeInsetsGeometryI::build),
      padding.map(EdgeInsetsGeometryI::build),
      duration.map(DurationI::build),
      curve.map(CurveI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DrawerHeader");
    return new DrawerHeader(st);
  }
  public static DrawerHeaderDrawerHeaderBuilder drawerHeader() {
    return DrawerHeaderDrawerHeaderBuilder.drawerHeaderDrawerHeader();
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderDecoration not supported on web");
    return new Decoration(DrawerHeaderObjSt.decoration(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderPadding not supported on web");
    return new EdgeInsetsGeometry(DrawerHeaderObjSt.padding(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderMargin not supported on web");
    return new EdgeInsetsGeometry(DrawerHeaderObjSt.margin(st)) {};
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerHeaderDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(DrawerHeaderObjSt.duration(st));
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderCurve not supported on web");
    return new Curve(DrawerHeaderObjSt.curve(st)) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderChild not supported on web");
    return new Widget(DrawerHeaderObjSt.child(st)) {};
  }
  @Override
  public DrawerHeader build() {
    return this;
  }
}
