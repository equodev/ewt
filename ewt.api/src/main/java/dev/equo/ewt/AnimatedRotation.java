package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedRotationObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedRotation extends ImplicitlyAnimatedWidget implements AnimatedRotationI {
  private MemorySegment st;
  protected AnimatedRotation() {}
  AnimatedRotation(MemorySegment st) {
    this.id = AnimatedRotationObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedRotation");
    System.out.println("New AnimatedRotation id:"+id);
  }
  @Builder.Factory
  static AnimatedRotation animatedRotationAnimatedRotation(Optional<WidgetI> child, double turns, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedRotationAnimatedRotation(child.map(WidgetI::build),
      turns,
      alignment.map(AlignmentI::build),
      filterQuality,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedRotation");
    return new AnimatedRotation(st);
  }
  public static AnimatedRotationAnimatedRotationBuilder animatedRotation() {
    return AnimatedRotationAnimatedRotationBuilder.animatedRotationAnimatedRotation();
  }
  public Widget child() {
    return new Widget(AnimatedRotationObjSt.child(st)) {};
  }
  public double turns() {
    return AnimatedRotationObjSt.turns(st);
  }
  public Alignment alignment() {
    return new Alignment(AnimatedRotationObjSt.alignment(st));
  }
  public FilterQuality filterQuality() {
    return FilterQuality.values()[AnimatedRotationObjSt.filterQuality(st)];
  }
  @Override
  public AnimatedRotation build() {
    return this;
  }
}
