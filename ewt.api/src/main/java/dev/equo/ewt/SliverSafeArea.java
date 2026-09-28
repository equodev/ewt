package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverSafeArea extends StatelessWidget implements SliverSafeAreaI {
  protected SliverSafeArea() {}
  SliverSafeArea(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverSafeArea");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverSafeArea sliverSafeAreaSliverSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsetsI> minimum, WidgetI sliver) {
    int id = factories.sliverSafeAreaSliverSafeArea(left,
      top,
      right,
      bottom,
      minimum.map(EdgeInsetsI::build),
      sliver.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverSafeArea");
    return new SliverSafeArea(id);
  }
  public static SliverSafeAreaSliverSafeAreaBuilder sliverSafeArea() {
    return SliverSafeAreaSliverSafeAreaBuilder.sliverSafeAreaSliverSafeArea();
  }
  public boolean left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaLeft not supported on web");
    return factories.SliverSafeArea_readBack_left(nativeStruct);
  }
  public boolean top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaTop not supported on web");
    return factories.SliverSafeArea_readBack_top(nativeStruct);
  }
  public boolean right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaRight not supported on web");
    return factories.SliverSafeArea_readBack_right(nativeStruct);
  }
  public boolean bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaBottom not supported on web");
    return factories.SliverSafeArea_readBack_bottom(nativeStruct);
  }
  public EdgeInsets minimum() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverSafeAreaMinimum", getId());
      return new EdgeInsets(__nid);
    }
    return factories.SliverSafeArea_readBack_minimum(nativeStruct);
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverSafeAreaSliver not supported on web");
    return factories.SliverSafeArea_readBack_sliver(nativeStruct);
  }
  @Override
  public SliverSafeArea build() {
    return this;
  }
}
