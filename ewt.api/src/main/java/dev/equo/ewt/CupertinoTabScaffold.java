package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoTabScaffoldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoTabScaffold extends StatefulWidget implements CupertinoTabScaffoldI {
  private MemorySegment st;
  protected CupertinoTabScaffold() {}
  CupertinoTabScaffold(MemorySegment st) {
    this.id = CupertinoTabScaffoldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabScaffold");
    System.out.println("New CupertinoTabScaffold id:"+id);
  }
  CupertinoTabScaffold(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoTabScaffold cupertinoTabScaffoldCupertinoTabScaffold(@Builder.Parameter CupertinoTabBarI tabBar, @Builder.Parameter BiFunction<BuildContext, Integer, Widget> tabBuilder, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<String> restorationId) {
    var st = factories.cupertinoTabScaffoldCupertinoTabScaffold(tabBar.build(),
      tabBuilder,
      backgroundColor.map(ColorI::build),
      resizeToAvoidBottomInset,
      restorationId);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTabScaffold");
    return new CupertinoTabScaffold(st);
  }
  public static CupertinoTabScaffoldCupertinoTabScaffoldBuilder cupertinoTabScaffold(CupertinoTabBarI tabBar, BiFunction<BuildContext, Integer, Widget> tabBuilder) {
    return CupertinoTabScaffoldCupertinoTabScaffoldBuilder.cupertinoTabScaffoldCupertinoTabScaffold(tabBar, tabBuilder);
  }
  public CupertinoTabBar tabBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabScaffoldTabBar", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.CupertinoTabBarObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.CupertinoTabBarObjSt.id(__st, __nid);
      return new CupertinoTabBar(__st);
    }
    return new CupertinoTabBar(CupertinoTabScaffoldObjSt.tabBar(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoTabScaffoldObjSt.backgroundColor(st));
  }
  public boolean resizeToAvoidBottomInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabScaffoldResizeToAvoidBottomInset not supported on web");
    return intToBool(CupertinoTabScaffoldObjSt.resizeToAvoidBottomInset(st));
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabScaffoldRestorationId not supported on web");
    return CupertinoTabScaffoldObjSt.restorationId(st).getString(0);
  }
  @Override
  public CupertinoTabScaffold build() {
    return this;
  }
}
