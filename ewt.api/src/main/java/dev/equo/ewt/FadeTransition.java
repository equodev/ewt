package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FadeTransition extends SingleChildRenderObjectWidget implements FadeTransitionI {
  protected FadeTransition() {}
  FadeTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FadeTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FadeTransition fadeTransitionFadeTransition(@Builder.Parameter AnimationI opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> child) {
    int id = factories.fadeTransitionFadeTransition(opacity.build(),
      alwaysIncludeSemantics,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FadeTransition");
    return new FadeTransition(id);
  }
  public static FadeTransitionFadeTransitionBuilder fadeTransition(AnimationI opacity) {
    return FadeTransitionFadeTransitionBuilder.fadeTransitionFadeTransition(opacity);
  }
  public Animation opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeTransitionOpacity not supported on web");
    return factories.FadeTransition_readBack_opacity(nativeStruct);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeTransitionAlwaysIncludeSemantics not supported on web");
    return factories.FadeTransition_readBack_alwaysIncludeSemantics(nativeStruct);
  }
  @Override
  public FadeTransition build() {
    return this;
  }
}
