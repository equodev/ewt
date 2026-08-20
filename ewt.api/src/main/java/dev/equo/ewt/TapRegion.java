package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TapRegionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TapRegion extends SingleChildRenderObjectWidget implements TapRegionI {
  private MemorySegment st;
  protected TapRegion() {}
  TapRegion(MemorySegment st) {
    this.id = TapRegionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TapRegion");
    System.out.println("New TapRegion id:"+id);
  }
  TapRegion(int id) { this.id = id; }
  @Builder.Factory
  static TapRegion tapRegionTapRegion(@Builder.Parameter WidgetI child, Optional<Boolean> enabled, Optional<HitTestBehavior> behavior, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<NativeObj.I> groupId, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel) {
    var st = factories.tapRegionTapRegion(child.build(),
      enabled,
      behavior,
      onTapOutside,
      onTapInside,
      onTapUpOutside,
      onTapUpInside,
      groupId.map(NativeObj.I::build),
      consumeOutsideTaps,
      debugLabel);
    if (st == null) throw new RuntimeException("Failed to created widget TapRegion");
    return new TapRegion(st);
  }
  public static TapRegionTapRegionBuilder tapRegion(WidgetI child) {
    return TapRegionTapRegionBuilder.tapRegionTapRegion(child);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionEnabled not supported on web");
    return intToBool(TapRegionObjSt.enabled(st));
  }
  public HitTestBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionBehavior not supported on web");
    return HitTestBehavior.values()[TapRegionObjSt.behavior(st)];
  }
  public boolean consumeOutsideTaps() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionConsumeOutsideTaps not supported on web");
    return intToBool(TapRegionObjSt.consumeOutsideTaps(st));
  }
  public String debugLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionDebugLabel not supported on web");
    return TapRegionObjSt.debugLabel(st).getString(0);
  }
  @Override
  public TapRegion build() {
    return this;
  }
}
