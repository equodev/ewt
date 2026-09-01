package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TickerModeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TickerMode extends StatefulWidget implements TickerModeI {
  private MemorySegment st;
  protected TickerMode() {}
  TickerMode(MemorySegment st) {
    this.id = TickerModeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TickerMode");
    System.out.println("New TickerMode id:"+id);
  }
  TickerMode(int id) { this.id = id; }
  @Builder.Factory
  static TickerMode tickerModeTickerMode(@Builder.Parameter boolean enabled, @Builder.Parameter WidgetI child) {
    var st = factories.tickerModeTickerMode(enabled,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TickerMode");
    return new TickerMode(st);
  }
  public static TickerModeTickerModeBuilder tickerMode(boolean enabled, WidgetI child) {
    return TickerModeTickerModeBuilder.tickerModeTickerMode(enabled, child);
  }
  public static boolean of(BuildContextI context) {
    int id = factories.tickerModeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static ValueListenable getNotifier(BuildContextI context) {
    int id = factories.tickerModeGetNotifier(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ValueListenable<bool>");
    System.out.println("New ValueListenable<bool> id:"+id);
    return new ValueListenable() { public int getId() { return id; } };
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tickerModeEnabled not supported on web");
    return intToBool(TickerModeObjSt.enabled(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tickerModeChild not supported on web");
    return new Widget(TickerModeObjSt.child(st)) {};
  }
  @Override
  public TickerMode build() {
    return this;
  }
}
