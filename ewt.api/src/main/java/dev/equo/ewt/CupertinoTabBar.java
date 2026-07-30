package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoTabBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoTabBar extends StatelessWidget implements PreferredSizeWidget, CupertinoTabBarI {
  private MemorySegment st;
  protected CupertinoTabBar() {}
  CupertinoTabBar(MemorySegment st) {
    this.id = CupertinoTabBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabBar");
    System.out.println("New CupertinoTabBar id:"+id);
  }
  CupertinoTabBar(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoTabBar cupertinoTabBarCupertinoTabBar(@Builder.Parameter List<BottomNavigationBarItemI> items, Optional<Consumer<Integer>> onTap, OptionalInt currentIndex, Optional<ColorI> backgroundColor, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, OptionalDouble iconSize, OptionalDouble height, Optional<BorderI> border) {
    var st = factories.cupertinoTabBarCupertinoTabBar(items.stream().map(BottomNavigationBarItemI::build).toList(),
      onTap,
      currentIndex,
      backgroundColor.map(ColorI::build),
      activeColor.map(ColorI::build),
      inactiveColor.map(ColorI::build),
      iconSize,
      height,
      border.map(BorderI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTabBar");
    return new CupertinoTabBar(st);
  }
  public static CupertinoTabBarCupertinoTabBarBuilder cupertinoTabBar(List<BottomNavigationBarItemI> items) {
    return CupertinoTabBarCupertinoTabBarBuilder.cupertinoTabBarCupertinoTabBar(items);
  }
  public int currentIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabBarCurrentIndex not supported on web");
    return CupertinoTabBarObjSt.currentIndex(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoTabBarObjSt.backgroundColor(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoTabBarObjSt.activeColor(st));
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarInactiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoTabBarObjSt.inactiveColor(st));
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabBarIconSize not supported on web");
    return CupertinoTabBarObjSt.iconSize(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabBarHeight not supported on web");
    return CupertinoTabBarObjSt.height(st);
  }
  public Border border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabBarBorder", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderObjSt.id(__st, __nid);
      return new Border(__st);
    }
    return new Border(CupertinoTabBarObjSt.border(st));
  }
  @Override
  public CupertinoTabBar build() {
    return this;
  }
}
