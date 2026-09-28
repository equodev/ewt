package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TapRegion extends SingleChildRenderObjectWidget implements TapRegionI {
  protected TapRegion() {}
  TapRegion(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TapRegion");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TapRegion tapRegionTapRegion(Optional<WidgetI> child, Optional<Boolean> enabled, Optional<HitTestBehavior> behavior, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<NativeObj.I> groupId, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel) {
    int id = factories.tapRegionTapRegion(child.map(WidgetI::build),
      enabled,
      behavior,
      onTapOutside,
      onTapInside,
      onTapUpOutside,
      onTapUpInside,
      groupId.map(NativeObj.I::build),
      consumeOutsideTaps,
      debugLabel);
    if (id <= 0) throw new RuntimeException("Failed to created widget TapRegion");
    return new TapRegion(id);
  }
  public static TapRegionTapRegionBuilder tapRegion() {
    return TapRegionTapRegionBuilder.tapRegionTapRegion();
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionEnabled not supported on web");
    return factories.TapRegion_readBack_enabled(nativeStruct);
  }
  public HitTestBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionBehavior not supported on web");
    return factories.TapRegion_readBack_behavior(nativeStruct);
  }
  public boolean consumeOutsideTaps() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionConsumeOutsideTaps not supported on web");
    return factories.TapRegion_readBack_consumeOutsideTaps(nativeStruct);
  }
  public String debugLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tapRegionDebugLabel not supported on web");
    return factories.TapRegion_readBack_debugLabel(nativeStruct);
  }
  @Override
  public TapRegion build() {
    return this;
  }
}
