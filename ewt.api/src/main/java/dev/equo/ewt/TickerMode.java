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
  static TickerMode tickerModeTickerMode(@Builder.Parameter boolean enabled, @Builder.Parameter WidgetI child, Optional<Boolean> forceFrames) {
    var st = factories.tickerModeTickerMode(enabled,
      child.build(),
      forceFrames);
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
  public static ValueListenable getValuesNotifier(BuildContextI context) {
    int id = factories.tickerModeGetValuesNotifier(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ValueListenable<TickerModeData>");
    System.out.println("New ValueListenable<TickerModeData> id:"+id);
    return new ValueListenable() { public int getId() { return id; } };
  }
  public static Widget merge(WidgetI child) {
    int id = factories.tickerModeMerge(Optional.empty(),
      Optional.empty(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tickerModeEnabled not supported on web");
    return intToBool(TickerModeObjSt.enabled(st));
  }
  public boolean forceFrames() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tickerModeForceFrames not supported on web");
    return intToBool(TickerModeObjSt.forceFrames(st));
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
