package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ScaleTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ScaleTransition extends MatrixTransition implements ScaleTransitionI {
  private MemorySegment st;
  protected ScaleTransition() {}
  ScaleTransition(MemorySegment st) {
    this.id = ScaleTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleTransition");
    System.out.println("New ScaleTransition id:"+id);
  }
  @Builder.Factory
  static ScaleTransition scaleTransitionScaleTransition(@Builder.Parameter AnimationI scale, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.scaleTransitionScaleTransition(scale.build(),
      alignment.map(AlignmentI::build),
      filterQuality,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ScaleTransition");
    return new ScaleTransition(st);
  }
  public static ScaleTransitionScaleTransitionBuilder scaleTransition(AnimationI scale) {
    return ScaleTransitionScaleTransitionBuilder.scaleTransitionScaleTransition(scale);
  }
  public Animation scale() {
    return new Animation() { public int getId() { return ScaleTransitionObjSt.scale(st); } };
  }
  @Override
  public ScaleTransition build() {
    return this;
  }
}
