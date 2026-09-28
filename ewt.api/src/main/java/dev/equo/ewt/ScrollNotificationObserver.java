package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ScrollNotificationObserver extends StatefulWidget implements ScrollNotificationObserverI {
  protected ScrollNotificationObserver() {}
  ScrollNotificationObserver(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ScrollNotificationObserver");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ScrollNotificationObserver scrollNotificationObserverScrollNotificationObserver(@Builder.Parameter WidgetI child) {
    int id = factories.scrollNotificationObserverScrollNotificationObserver(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ScrollNotificationObserver");
    return new ScrollNotificationObserver(id);
  }
  public static ScrollNotificationObserverScrollNotificationObserverBuilder scrollNotificationObserver(WidgetI child) {
    return ScrollNotificationObserverScrollNotificationObserverBuilder.scrollNotificationObserverScrollNotificationObserver(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollNotificationObserverChild not supported on web");
    return factories.ScrollNotificationObserver_readBack_child(nativeStruct);
  }
  @Override
  public ScrollNotificationObserver build() {
    return this;
  }
}
