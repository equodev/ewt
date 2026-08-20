package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedPositionedDirectionalObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedPositionedDirectional extends ImplicitlyAnimatedWidget implements AnimatedPositionedDirectionalI {
  private MemorySegment st;
  protected AnimatedPositionedDirectional() {}
  AnimatedPositionedDirectional(MemorySegment st) {
    this.id = AnimatedPositionedDirectionalObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPositionedDirectional");
    System.out.println("New AnimatedPositionedDirectional id:"+id);
  }
  AnimatedPositionedDirectional(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedPositionedDirectional animatedPositionedDirectionalAnimatedPositionedDirectional(@Builder.Parameter WidgetI child, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedPositionedDirectionalAnimatedPositionedDirectional(child.build(),
      start,
      top,
      end,
      bottom,
      width,
      height,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedPositionedDirectional");
    return new AnimatedPositionedDirectional(st);
  }
  public static AnimatedPositionedDirectionalAnimatedPositionedDirectionalBuilder animatedPositionedDirectional(WidgetI child) {
    return AnimatedPositionedDirectionalAnimatedPositionedDirectionalBuilder.animatedPositionedDirectionalAnimatedPositionedDirectional(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalChild not supported on web");
    return new Widget(AnimatedPositionedDirectionalObjSt.child(st)) {};
  }
  public double start() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalStart not supported on web");
    return AnimatedPositionedDirectionalObjSt.start(st);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalTop not supported on web");
    return AnimatedPositionedDirectionalObjSt.top(st);
  }
  public double end() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalEnd not supported on web");
    return AnimatedPositionedDirectionalObjSt.end(st);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalBottom not supported on web");
    return AnimatedPositionedDirectionalObjSt.bottom(st);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalWidth not supported on web");
    return AnimatedPositionedDirectionalObjSt.width(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalHeight not supported on web");
    return AnimatedPositionedDirectionalObjSt.height(st);
  }
  @Override
  public AnimatedPositionedDirectional build() {
    return this;
  }
}
