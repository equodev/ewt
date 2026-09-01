package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedPositionedObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedPositioned extends ImplicitlyAnimatedWidget implements AnimatedPositionedI {
  private MemorySegment st;
  protected AnimatedPositioned() {}
  AnimatedPositioned(MemorySegment st) {
    this.id = AnimatedPositionedObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPositioned");
    System.out.println("New AnimatedPositioned id:"+id);
  }
  AnimatedPositioned(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedPositioned animatedPositionedAnimatedPositioned(@Builder.Parameter WidgetI child, OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedPositionedAnimatedPositioned(child.build(),
      left,
      top,
      right,
      bottom,
      width,
      height,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedPositioned");
    return new AnimatedPositioned(st);
  }
  public static AnimatedPositionedAnimatedPositionedBuilder animatedPositioned(WidgetI child) {
    return AnimatedPositionedAnimatedPositionedBuilder.animatedPositionedAnimatedPositioned(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedChild not supported on web");
    return new Widget(AnimatedPositionedObjSt.child(st)) {};
  }
  public double left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedLeft not supported on web");
    return AnimatedPositionedObjSt.left(st);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedTop not supported on web");
    return AnimatedPositionedObjSt.top(st);
  }
  public double right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedRight not supported on web");
    return AnimatedPositionedObjSt.right(st);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedBottom not supported on web");
    return AnimatedPositionedObjSt.bottom(st);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedWidth not supported on web");
    return AnimatedPositionedObjSt.width(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedHeight not supported on web");
    return AnimatedPositionedObjSt.height(st);
  }
  @Override
  public AnimatedPositioned build() {
    return this;
  }
}
