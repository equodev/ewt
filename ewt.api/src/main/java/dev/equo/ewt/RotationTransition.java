package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RotationTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RotationTransition extends MatrixTransition implements RotationTransitionI {
  private MemorySegment st;
  protected RotationTransition() {}
  RotationTransition(MemorySegment st) {
    this.id = RotationTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RotationTransition");
    System.out.println("New RotationTransition id:"+id);
  }
  @Builder.Factory
  static RotationTransition rotationTransitionRotationTransition(@Builder.Parameter AnimationI turns, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.rotationTransitionRotationTransition(turns.build(),
      alignment.map(AlignmentI::build),
      filterQuality,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RotationTransition");
    return new RotationTransition(st);
  }
  public static RotationTransitionRotationTransitionBuilder rotationTransition(AnimationI turns) {
    return RotationTransitionRotationTransitionBuilder.rotationTransitionRotationTransition(turns);
  }
  public Animation turns() {
    return new Animation() { public int getId() { return RotationTransitionObjSt.turns(st); } };
  }
  @Override
  public RotationTransition build() {
    return this;
  }
}
