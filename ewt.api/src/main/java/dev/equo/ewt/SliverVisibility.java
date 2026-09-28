package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverVisibility extends StatelessWidget implements SliverVisibilityI {
  protected SliverVisibility() {}
  SliverVisibility(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverVisibility");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverVisibility sliverVisibilitySliverVisibility(@Builder.Parameter WidgetI sliver, Optional<WidgetI> replacementSliver, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity) {
    int id = factories.sliverVisibilitySliverVisibility(sliver.build(),
      replacementSliver.map(WidgetI::build),
      visible,
      maintainState,
      maintainAnimation,
      maintainSize,
      maintainSemantics,
      maintainInteractivity);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverVisibility");
    return new SliverVisibility(id);
  }
  public static SliverVisibilitySliverVisibilityBuilder sliverVisibility(WidgetI sliver) {
    return SliverVisibilitySliverVisibilityBuilder.sliverVisibilitySliverVisibility(sliver);
  }
  @Builder.Factory
  static SliverVisibility sliverVisibilityMaintain(@Builder.Parameter WidgetI sliver, Optional<WidgetI> replacementSliver, Optional<Boolean> visible) {
    int id = factories.sliverVisibilityMaintain(sliver.build(),
      replacementSliver.map(WidgetI::build),
      visible);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverVisibility");
    return new SliverVisibility(id);
  }
  public static SliverVisibilityMaintainBuilder maintain(WidgetI sliver) {
    return SliverVisibilityMaintainBuilder.sliverVisibilityMaintain(sliver);
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilitySliver not supported on web");
    return factories.SliverVisibility_readBack_sliver(nativeStruct);
  }
  public Widget replacementSliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityReplacementSliver not supported on web");
    return factories.SliverVisibility_readBack_replacementSliver(nativeStruct);
  }
  public boolean visible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityVisible not supported on web");
    return factories.SliverVisibility_readBack_visible(nativeStruct);
  }
  public boolean maintainState() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainState not supported on web");
    return factories.SliverVisibility_readBack_maintainState(nativeStruct);
  }
  public boolean maintainAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainAnimation not supported on web");
    return factories.SliverVisibility_readBack_maintainAnimation(nativeStruct);
  }
  public boolean maintainSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainSize not supported on web");
    return factories.SliverVisibility_readBack_maintainSize(nativeStruct);
  }
  public boolean maintainSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainSemantics not supported on web");
    return factories.SliverVisibility_readBack_maintainSemantics(nativeStruct);
  }
  public boolean maintainInteractivity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainInteractivity not supported on web");
    return factories.SliverVisibility_readBack_maintainInteractivity(nativeStruct);
  }
  @Override
  public SliverVisibility build() {
    return this;
  }
}
