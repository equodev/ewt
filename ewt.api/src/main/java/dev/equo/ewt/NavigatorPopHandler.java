package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigatorPopHandler<T> extends StatefulWidget implements NavigatorPopHandlerI {
  protected NavigatorPopHandler() {}
  NavigatorPopHandler(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigatorPopHandler");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> NavigatorPopHandler<T> navigatorPopHandlerNavigatorPopHandler(Optional<Runnable> onPop, Optional<Consumer<NativeObj>> onPopWithResult, Optional<Boolean> enabled, WidgetI child) {
    int id = factories.navigatorPopHandlerNavigatorPopHandler(onPop,
      onPopWithResult,
      enabled,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigatorPopHandler");
    return new NavigatorPopHandler(id);
  }
  public static <T extends NativeObj> NavigatorPopHandlerNavigatorPopHandlerBuilder<T> navigatorPopHandler() {
    return NavigatorPopHandlerNavigatorPopHandlerBuilder.navigatorPopHandlerNavigatorPopHandler();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorPopHandlerChild not supported on web");
    return factories.NavigatorPopHandler_readBack_child(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorPopHandlerEnabled not supported on web");
    return factories.NavigatorPopHandler_readBack_enabled(nativeStruct);
  }
  @Override
  public NavigatorPopHandler build() {
    return this;
  }
}
