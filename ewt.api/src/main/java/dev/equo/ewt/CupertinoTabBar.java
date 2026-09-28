package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoTabBar extends StatelessWidget implements PreferredSizeWidget, CupertinoTabBarI {
  protected CupertinoTabBar() {}
  CupertinoTabBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoTabBar cupertinoTabBarCupertinoTabBar(@Builder.Parameter List<BottomNavigationBarItemI> items, Optional<Consumer<Integer>> onTap, OptionalInt currentIndex, Optional<ColorI> backgroundColor, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, OptionalDouble iconSize, OptionalDouble height, Optional<BorderI> border) {
    int id = factories.cupertinoTabBarCupertinoTabBar(items.stream().map(BottomNavigationBarItemI::build).collect(java.util.stream.Collectors.toList()),
      onTap,
      currentIndex,
      backgroundColor.map(ColorI::build),
      activeColor.map(ColorI::build),
      inactiveColor.map(ColorI::build),
      iconSize,
      height,
      border.map(BorderI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabBar");
    return new CupertinoTabBar(id);
  }
  public static CupertinoTabBarCupertinoTabBarBuilder cupertinoTabBar(List<BottomNavigationBarItemI> items) {
    return CupertinoTabBarCupertinoTabBarBuilder.cupertinoTabBarCupertinoTabBar(items);
  }
  public int currentIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabBarCurrentIndex not supported on web");
    return factories.CupertinoTabBar_readBack_currentIndex(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoTabBar_readBack_backgroundColor(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarActiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoTabBar_readBack_activeColor(nativeStruct);
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarInactiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoTabBar_readBack_inactiveColor(nativeStruct);
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabBarIconSize not supported on web");
    return factories.CupertinoTabBar_readBack_iconSize(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabBarHeight not supported on web");
    return factories.CupertinoTabBar_readBack_height(nativeStruct);
  }
  public Border border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarBorder", getId());
      return new Border(__nid);
    }
    return factories.CupertinoTabBar_readBack_border(nativeStruct);
  }
  @Override
  public CupertinoTabBar build() {
    return this;
  }
}
