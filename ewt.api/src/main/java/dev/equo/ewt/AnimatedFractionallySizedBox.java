package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedFractionallySizedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedFractionallySizedBox extends ImplicitlyAnimatedWidget implements AnimatedFractionallySizedBoxI {
  private MemorySegment st;
  protected AnimatedFractionallySizedBox() {}
  AnimatedFractionallySizedBox(MemorySegment st) {
    this.id = AnimatedFractionallySizedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedFractionallySizedBox");
    System.out.println("New AnimatedFractionallySizedBox id:"+id);
  }
  AnimatedFractionallySizedBox(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedFractionallySizedBox animatedFractionallySizedBoxAnimatedFractionallySizedBox(Optional<AlignmentGeometryI> alignment, Optional<WidgetI> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedFractionallySizedBoxAnimatedFractionallySizedBox(alignment.map(AlignmentGeometryI::build),
      child.map(WidgetI::build),
      heightFactor,
      widthFactor,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedFractionallySizedBox");
    return new AnimatedFractionallySizedBox(st);
  }
  public static AnimatedFractionallySizedBoxAnimatedFractionallySizedBoxBuilder animatedFractionallySizedBox() {
    return AnimatedFractionallySizedBoxAnimatedFractionallySizedBoxBuilder.animatedFractionallySizedBoxAnimatedFractionallySizedBox();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxChild not supported on web");
    return new Widget(AnimatedFractionallySizedBoxObjSt.child(st)) {};
  }
  public double heightFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxHeightFactor not supported on web");
    return AnimatedFractionallySizedBoxObjSt.heightFactor(st);
  }
  public double widthFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxWidthFactor not supported on web");
    return AnimatedFractionallySizedBoxObjSt.widthFactor(st);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxAlignment not supported on web");
    return new AlignmentGeometry(AnimatedFractionallySizedBoxObjSt.alignment(st)) {};
  }
  @Override
  public AnimatedFractionallySizedBox build() {
    return this;
  }
}
