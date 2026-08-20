package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ScrollNotificationObserverObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ScrollNotificationObserver extends StatefulWidget implements ScrollNotificationObserverI {
  private MemorySegment st;
  protected ScrollNotificationObserver() {}
  ScrollNotificationObserver(MemorySegment st) {
    this.id = ScrollNotificationObserverObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ScrollNotificationObserver");
    System.out.println("New ScrollNotificationObserver id:"+id);
  }
  ScrollNotificationObserver(int id) { this.id = id; }
  @Builder.Factory
  static ScrollNotificationObserver scrollNotificationObserverScrollNotificationObserver(@Builder.Parameter WidgetI child) {
    var st = factories.scrollNotificationObserverScrollNotificationObserver(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ScrollNotificationObserver");
    return new ScrollNotificationObserver(st);
  }
  public static ScrollNotificationObserverScrollNotificationObserverBuilder scrollNotificationObserver(WidgetI child) {
    return ScrollNotificationObserverScrollNotificationObserverBuilder.scrollNotificationObserverScrollNotificationObserver(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollNotificationObserverChild not supported on web");
    return new Widget(ScrollNotificationObserverObjSt.child(st)) {};
  }
  @Override
  public ScrollNotificationObserver build() {
    return this;
  }
}
