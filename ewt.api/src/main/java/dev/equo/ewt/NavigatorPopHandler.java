package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigatorPopHandlerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigatorPopHandler<T> extends StatefulWidget implements NavigatorPopHandlerI {
  private MemorySegment st;
  protected NavigatorPopHandler() {}
  NavigatorPopHandler(MemorySegment st) {
    this.id = NavigatorPopHandlerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigatorPopHandler");
    System.out.println("New NavigatorPopHandler id:"+id);
  }
  NavigatorPopHandler(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> NavigatorPopHandler<T> navigatorPopHandlerNavigatorPopHandler(Optional<Runnable> onPop, Optional<Consumer<NativeObj>> onPopWithResult, Optional<Boolean> enabled, WidgetI child) {
    var st = factories.navigatorPopHandlerNavigatorPopHandler(onPop,
      onPopWithResult,
      enabled,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget NavigatorPopHandler");
    return new NavigatorPopHandler(st);
  }
  public static <T extends NativeObj> NavigatorPopHandlerNavigatorPopHandlerBuilder<T> navigatorPopHandler() {
    return NavigatorPopHandlerNavigatorPopHandlerBuilder.navigatorPopHandlerNavigatorPopHandler();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorPopHandlerChild not supported on web");
    return new Widget(NavigatorPopHandlerObjSt.child(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorPopHandlerEnabled not supported on web");
    return intToBool(NavigatorPopHandlerObjSt.enabled(st));
  }
  @Override
  public NavigatorPopHandler build() {
    return this;
  }
}
