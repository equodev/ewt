package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TickerMode extends StatefulWidget implements TickerModeI {
  protected TickerMode() {}
  TickerMode(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TickerMode");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TickerMode tickerModeTickerMode(@Builder.Parameter boolean enabled, @Builder.Parameter WidgetI child, Optional<Boolean> forceFrames) {
    int id = factories.tickerModeTickerMode(enabled,
      child.build(),
      forceFrames);
    if (id <= 0) throw new RuntimeException("Failed to created widget TickerMode");
    return new TickerMode(id);
  }
  public static TickerModeTickerModeBuilder tickerMode(boolean enabled, WidgetI child) {
    return TickerModeTickerModeBuilder.tickerModeTickerMode(enabled, child);
  }
  public static boolean of(BuildContextI context) {
    var id = factories.tickerModeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static ValueListenable getNotifier(BuildContextI context) {
    var id = factories.tickerModeGetNotifier(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ValueListenable<bool>");
    System.out.println("New ValueListenable<bool> id:"+id);
    return new ValueListenable() { public int getId() { return id; } };
  }
  public static ValueListenable getValuesNotifier(BuildContextI context) {
    var id = factories.tickerModeGetValuesNotifier(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ValueListenable<TickerModeData>");
    System.out.println("New ValueListenable<TickerModeData> id:"+id);
    return new ValueListenable() { public int getId() { return id; } };
  }
  public static Widget merge(WidgetI child) {
    var id = factories.tickerModeMerge(Optional.empty(),
      Optional.empty(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tickerModeEnabled not supported on web");
    return factories.TickerMode_readBack_enabled(nativeStruct);
  }
  public boolean forceFrames() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tickerModeForceFrames not supported on web");
    return factories.TickerMode_readBack_forceFrames(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tickerModeChild not supported on web");
    return factories.TickerMode_readBack_child(nativeStruct);
  }
  @Override
  public TickerMode build() {
    return this;
  }
}
