package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedScaleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedScale extends ImplicitlyAnimatedWidget implements AnimatedScaleI {
  private MemorySegment st;
  protected AnimatedScale() {}
  AnimatedScale(MemorySegment st) {
    this.id = AnimatedScaleObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedScale");
    System.out.println("New AnimatedScale id:"+id);
  }
  AnimatedScale(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedScale animatedScaleAnimatedScale(Optional<WidgetI> child, double scale, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedScaleAnimatedScale(child.map(WidgetI::build),
      scale,
      alignment.map(AlignmentI::build),
      filterQuality,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedScale");
    return new AnimatedScale(st);
  }
  public static AnimatedScaleAnimatedScaleBuilder animatedScale() {
    return AnimatedScaleAnimatedScaleBuilder.animatedScaleAnimatedScale();
  }
  public Widget child() {
    return new Widget(AnimatedScaleObjSt.child(st)) {};
  }
  public double scale() {
    return AnimatedScaleObjSt.scale(st);
  }
  public Alignment alignment() {
    return new Alignment(AnimatedScaleObjSt.alignment(st));
  }
  public FilterQuality filterQuality() {
    return FilterQuality.values()[AnimatedScaleObjSt.filterQuality(st)];
  }
  @Override
  public AnimatedScale build() {
    return this;
  }
}
