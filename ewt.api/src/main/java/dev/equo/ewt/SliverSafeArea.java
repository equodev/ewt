package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverSafeAreaObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverSafeArea extends StatelessWidget implements SliverSafeAreaI {
  private MemorySegment st;
  protected SliverSafeArea() {}
  SliverSafeArea(MemorySegment st) {
    this.id = SliverSafeAreaObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverSafeArea");
    System.out.println("New SliverSafeArea id:"+id);
  }
  SliverSafeArea(int id) { this.id = id; }
  @Builder.Factory
  static SliverSafeArea sliverSafeAreaSliverSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsetsI> minimum, WidgetI sliver) {
    var st = factories.sliverSafeAreaSliverSafeArea(left,
      top,
      right,
      bottom,
      minimum.map(EdgeInsetsI::build),
      sliver.build());
    if (st == null) throw new RuntimeException("Failed to created widget SliverSafeArea");
    return new SliverSafeArea(st);
  }
  public static SliverSafeAreaSliverSafeAreaBuilder sliverSafeArea() {
    return SliverSafeAreaSliverSafeAreaBuilder.sliverSafeAreaSliverSafeArea();
  }
  public boolean left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaLeft not supported on web");
    return intToBool(SliverSafeAreaObjSt.left(st));
  }
  public boolean top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaTop not supported on web");
    return intToBool(SliverSafeAreaObjSt.top(st));
  }
  public boolean right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaRight not supported on web");
    return intToBool(SliverSafeAreaObjSt.right(st));
  }
  public boolean bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaBottom not supported on web");
    return intToBool(SliverSafeAreaObjSt.bottom(st));
  }
  public EdgeInsets minimum() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverSafeAreaMinimum", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(SliverSafeAreaObjSt.minimum(st));
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaSliver not supported on web");
    return new Widget(SliverSafeAreaObjSt.sliver(st)) {};
  }
  @Override
  public SliverSafeArea build() {
    return this;
  }
}
