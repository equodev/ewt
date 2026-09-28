package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverFadeTransition extends SingleChildRenderObjectWidget implements SliverFadeTransitionI {
  protected SliverFadeTransition() {}
  SliverFadeTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFadeTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverFadeTransition sliverFadeTransitionSliverFadeTransition(@Builder.Parameter AnimationI opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> sliver) {
    int id = factories.sliverFadeTransitionSliverFadeTransition(opacity.build(),
      alwaysIncludeSemantics,
      sliver.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFadeTransition");
    return new SliverFadeTransition(id);
  }
  public static SliverFadeTransitionSliverFadeTransitionBuilder sliverFadeTransition(AnimationI opacity) {
    return SliverFadeTransitionSliverFadeTransitionBuilder.sliverFadeTransitionSliverFadeTransition(opacity);
  }
  public Animation opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFadeTransitionOpacity not supported on web");
    return factories.SliverFadeTransition_readBack_opacity(nativeStruct);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFadeTransitionAlwaysIncludeSemantics not supported on web");
    return factories.SliverFadeTransition_readBack_alwaysIncludeSemantics(nativeStruct);
  }
  @Override
  public SliverFadeTransition build() {
    return this;
  }
}
