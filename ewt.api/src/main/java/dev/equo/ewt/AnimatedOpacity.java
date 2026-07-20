package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedOpacityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedOpacity extends ImplicitlyAnimatedWidget implements AnimatedOpacityI {
  private MemorySegment st;
  protected AnimatedOpacity() {}
  AnimatedOpacity(MemorySegment st) {
    this.id = AnimatedOpacityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedOpacity");
    System.out.println("New AnimatedOpacity id:"+id);
  }
  @Builder.Factory
  static AnimatedOpacity animatedOpacityAnimatedOpacity(Optional<WidgetI> child, double opacity, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd, Optional<Boolean> alwaysIncludeSemantics) {
    var st = factories.animatedOpacityAnimatedOpacity(child.map(WidgetI::build),
      opacity,
      curve.map(CurveI::build),
      duration.build(),
      onEnd,
      alwaysIncludeSemantics);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedOpacity");
    return new AnimatedOpacity(st);
  }
  public static AnimatedOpacityAnimatedOpacityBuilder animatedOpacity() {
    return AnimatedOpacityAnimatedOpacityBuilder.animatedOpacityAnimatedOpacity();
  }
  public Widget child() {
    return new Widget(AnimatedOpacityObjSt.child(st)) {};
  }
  public double opacity() {
    return AnimatedOpacityObjSt.opacity(st);
  }
  public boolean alwaysIncludeSemantics() {
    return intToBool(AnimatedOpacityObjSt.alwaysIncludeSemantics(st));
  }
  @Override
  public AnimatedOpacity build() {
    return this;
  }
}
