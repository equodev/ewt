package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SafeArea extends StatelessWidget implements SafeAreaI {
  protected SafeArea() {}
  SafeArea(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SafeArea");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SafeArea safeAreaSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsetsI> minimum, Optional<Boolean> maintainBottomViewPadding, WidgetI child) {
    int id = factories.safeAreaSafeArea(left,
      top,
      right,
      bottom,
      minimum.map(EdgeInsetsI::build),
      maintainBottomViewPadding,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SafeArea");
    return new SafeArea(id);
  }
  public static SafeAreaSafeAreaBuilder safeArea() {
    return SafeAreaSafeAreaBuilder.safeAreaSafeArea();
  }
  public boolean left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaLeft not supported on web");
    return factories.SafeArea_readBack_left(nativeStruct);
  }
  public boolean top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaTop not supported on web");
    return factories.SafeArea_readBack_top(nativeStruct);
  }
  public boolean right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaRight not supported on web");
    return factories.SafeArea_readBack_right(nativeStruct);
  }
  public boolean bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaBottom not supported on web");
    return factories.SafeArea_readBack_bottom(nativeStruct);
  }
  public EdgeInsets minimum() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("safeAreaMinimum", getId());
      return new EdgeInsets(__nid);
    }
    return factories.SafeArea_readBack_minimum(nativeStruct);
  }
  public boolean maintainBottomViewPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaMaintainBottomViewPadding not supported on web");
    return factories.SafeArea_readBack_maintainBottomViewPadding(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("safeAreaChild not supported on web");
    return factories.SafeArea_readBack_child(nativeStruct);
  }
  @Override
  public SafeArea build() {
    return this;
  }
}
