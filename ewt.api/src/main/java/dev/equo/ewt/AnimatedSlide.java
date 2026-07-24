package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedSlideObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedSlide extends ImplicitlyAnimatedWidget implements AnimatedSlideI {
  private MemorySegment st;
  protected AnimatedSlide() {}
  AnimatedSlide(MemorySegment st) {
    this.id = AnimatedSlideObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSlide");
    System.out.println("New AnimatedSlide id:"+id);
  }
  AnimatedSlide(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedSlide animatedSlideAnimatedSlide(Optional<WidgetI> child, OffsetI offset, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedSlideAnimatedSlide(child.map(WidgetI::build),
      offset.build(),
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedSlide");
    return new AnimatedSlide(st);
  }
  public static AnimatedSlideAnimatedSlideBuilder animatedSlide() {
    return AnimatedSlideAnimatedSlideBuilder.animatedSlideAnimatedSlide();
  }
  public Widget child() {
    return new Widget(AnimatedSlideObjSt.child(st)) {};
  }
  public Offset offset() {
    return new Offset(AnimatedSlideObjSt.offset(st));
  }
  @Override
  public AnimatedSlide build() {
    return this;
  }
}
