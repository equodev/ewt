package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ScaleTransition extends MatrixTransition implements ScaleTransitionI {
  protected ScaleTransition() {}
  ScaleTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ScaleTransition scaleTransitionScaleTransition(@Builder.Parameter AnimationI scale, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    int id = factories.scaleTransitionScaleTransition(scale.build(),
      alignment.map(AlignmentI::build),
      filterQuality,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleTransition");
    return new ScaleTransition(id);
  }
  public static ScaleTransitionScaleTransitionBuilder scaleTransition(AnimationI scale) {
    return ScaleTransitionScaleTransitionBuilder.scaleTransitionScaleTransition(scale);
  }
  public Animation scale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaleTransitionScale not supported on web");
    return factories.ScaleTransition_readBack_scale(nativeStruct);
  }
  @Override
  public ScaleTransition build() {
    return this;
  }
}
