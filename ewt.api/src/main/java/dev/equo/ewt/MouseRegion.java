package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MouseRegion extends SingleChildRenderObjectWidget implements MouseRegionI {
  protected MouseRegion() {}
  MouseRegion(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MouseRegion");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MouseRegion mouseRegionMouseRegion(Optional<Consumer<PointerEnterEvent>> onEnter, Optional<Consumer<PointerExitEvent>> onExit, Optional<Consumer<PointerHoverEvent>> onHover, Optional<Boolean> opaque, Optional<HitTestBehavior> hitTestBehavior, Optional<WidgetI> child) {
    int id = factories.mouseRegionMouseRegion(onEnter,
      onExit,
      onHover,
      opaque,
      hitTestBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget MouseRegion");
    return new MouseRegion(id);
  }
  public static MouseRegionMouseRegionBuilder mouseRegion() {
    return MouseRegionMouseRegionBuilder.mouseRegionMouseRegion();
  }
  public boolean opaque() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mouseRegionOpaque not supported on web");
    return factories.MouseRegion_readBack_opaque(nativeStruct);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mouseRegionHitTestBehavior not supported on web");
    return factories.MouseRegion_readBack_hitTestBehavior(nativeStruct);
  }
  @Override
  public MouseRegion build() {
    return this;
  }
}
