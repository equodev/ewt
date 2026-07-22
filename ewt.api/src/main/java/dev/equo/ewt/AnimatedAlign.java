package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedAlignObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedAlign extends ImplicitlyAnimatedWidget implements AnimatedAlignI {
  private MemorySegment st;
  protected AnimatedAlign() {}
  AnimatedAlign(MemorySegment st) {
    this.id = AnimatedAlignObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedAlign");
    System.out.println("New AnimatedAlign id:"+id);
  }
  @Builder.Factory
  static AnimatedAlign animatedAlignAnimatedAlign(@Builder.Parameter AlignmentGeometryI alignment, Optional<WidgetI> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedAlignAnimatedAlign(alignment.build(),
      child.map(WidgetI::build),
      heightFactor,
      widthFactor,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedAlign");
    return new AnimatedAlign(st);
  }
  public static AnimatedAlignAnimatedAlignBuilder animatedAlign(AlignmentGeometryI alignment) {
    return AnimatedAlignAnimatedAlignBuilder.animatedAlignAnimatedAlign(alignment);
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(AnimatedAlignObjSt.alignment(st)) {};
  }
  public Widget child() {
    return new Widget(AnimatedAlignObjSt.child(st)) {};
  }
  public double heightFactor() {
    return AnimatedAlignObjSt.heightFactor(st);
  }
  public double widthFactor() {
    return AnimatedAlignObjSt.widthFactor(st);
  }
  @Override
  public AnimatedAlign build() {
    return this;
  }
}
