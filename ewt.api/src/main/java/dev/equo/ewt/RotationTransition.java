package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RotationTransition extends MatrixTransition implements RotationTransitionI {
  protected RotationTransition() {}
  RotationTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RotationTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RotationTransition rotationTransitionRotationTransition(@Builder.Parameter AnimationI turns, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    int id = factories.rotationTransitionRotationTransition(turns.build(),
      alignment.map(AlignmentI::build),
      filterQuality,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RotationTransition");
    return new RotationTransition(id);
  }
  public static RotationTransitionRotationTransitionBuilder rotationTransition(AnimationI turns) {
    return RotationTransitionRotationTransitionBuilder.rotationTransitionRotationTransition(turns);
  }
  public Animation turns() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rotationTransitionTurns not supported on web");
    return factories.RotationTransition_readBack_turns(nativeStruct);
  }
  @Override
  public RotationTransition build() {
    return this;
  }
}
