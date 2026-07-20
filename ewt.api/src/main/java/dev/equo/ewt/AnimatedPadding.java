package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedPaddingObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedPadding extends ImplicitlyAnimatedWidget implements AnimatedPaddingI {
  private MemorySegment st;
  protected AnimatedPadding() {}
  AnimatedPadding(MemorySegment st) {
    this.id = AnimatedPaddingObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPadding");
    System.out.println("New AnimatedPadding id:"+id);
  }
  @Builder.Factory
  static AnimatedPadding animatedPaddingAnimatedPadding(@Builder.Parameter EdgeInsetsGeometryI padding, Optional<WidgetI> child, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedPaddingAnimatedPadding(padding.build(),
      child.map(WidgetI::build),
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedPadding");
    return new AnimatedPadding(st);
  }
  public static AnimatedPaddingAnimatedPaddingBuilder animatedPadding(EdgeInsetsGeometryI padding) {
    return AnimatedPaddingAnimatedPaddingBuilder.animatedPaddingAnimatedPadding(padding);
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(AnimatedPaddingObjSt.padding(st)) {};
  }
  public Widget child() {
    return new Widget(AnimatedPaddingObjSt.child(st)) {};
  }
  @Override
  public AnimatedPadding build() {
    return this;
  }
}
