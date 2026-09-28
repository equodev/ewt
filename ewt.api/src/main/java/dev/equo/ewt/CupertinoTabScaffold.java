package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoTabScaffold extends StatefulWidget implements CupertinoTabScaffoldI {
  protected CupertinoTabScaffold() {}
  CupertinoTabScaffold(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabScaffold");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoTabScaffold cupertinoTabScaffoldCupertinoTabScaffold(@Builder.Parameter CupertinoTabBarI tabBar, @Builder.Parameter BiFunction<BuildContext, Integer, Widget> tabBuilder, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<String> restorationId) {
    int id = factories.cupertinoTabScaffoldCupertinoTabScaffold(tabBar.build(),
      tabBuilder,
      backgroundColor.map(ColorI::build),
      resizeToAvoidBottomInset,
      restorationId);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabScaffold");
    return new CupertinoTabScaffold(id);
  }
  public static CupertinoTabScaffoldCupertinoTabScaffoldBuilder cupertinoTabScaffold(CupertinoTabBarI tabBar, BiFunction<BuildContext, Integer, Widget> tabBuilder) {
    return CupertinoTabScaffoldCupertinoTabScaffoldBuilder.cupertinoTabScaffoldCupertinoTabScaffold(tabBar, tabBuilder);
  }
  public CupertinoTabBar tabBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabScaffoldTabBar", getId());
      return new CupertinoTabBar(__nid);
    }
    return factories.CupertinoTabScaffold_readBack_tabBar(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTabScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoTabScaffold_readBack_backgroundColor(nativeStruct);
  }
  public boolean resizeToAvoidBottomInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabScaffoldResizeToAvoidBottomInset not supported on web");
    return factories.CupertinoTabScaffold_readBack_resizeToAvoidBottomInset(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabScaffoldRestorationId not supported on web");
    return factories.CupertinoTabScaffold_readBack_restorationId(nativeStruct);
  }
  @Override
  public CupertinoTabScaffold build() {
    return this;
  }
}
