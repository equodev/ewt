package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SafeAreaObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SafeArea extends StatelessWidget implements SafeAreaI {
  private MemorySegment st;
  protected SafeArea() {}
  SafeArea(MemorySegment st) {
    this.id = SafeAreaObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SafeArea");
    System.out.println("New SafeArea id:"+id);
  }
  SafeArea(int id) { this.id = id; }
  @Builder.Factory
  static SafeArea safeAreaSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsetsI> minimum, Optional<Boolean> maintainBottomViewPadding, WidgetI child) {
    var st = factories.safeAreaSafeArea(left,
      top,
      right,
      bottom,
      minimum.map(EdgeInsetsI::build),
      maintainBottomViewPadding,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SafeArea");
    return new SafeArea(st);
  }
  public static SafeAreaSafeAreaBuilder safeArea() {
    return SafeAreaSafeAreaBuilder.safeAreaSafeArea();
  }
  public boolean left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaLeft not supported on web");
    return intToBool(SafeAreaObjSt.left(st));
  }
  public boolean top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaTop not supported on web");
    return intToBool(SafeAreaObjSt.top(st));
  }
  public boolean right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaRight not supported on web");
    return intToBool(SafeAreaObjSt.right(st));
  }
  public boolean bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaBottom not supported on web");
    return intToBool(SafeAreaObjSt.bottom(st));
  }
  public EdgeInsets minimum() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("safeAreaMinimum", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(SafeAreaObjSt.minimum(st));
  }
  public boolean maintainBottomViewPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaMaintainBottomViewPadding not supported on web");
    return intToBool(SafeAreaObjSt.maintainBottomViewPadding(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaChild not supported on web");
    return new Widget(SafeAreaObjSt.child(st)) {};
  }
  @Override
  public SafeArea build() {
    return this;
  }
}
