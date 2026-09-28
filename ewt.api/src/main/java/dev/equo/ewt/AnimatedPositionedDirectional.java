package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedPositionedDirectional extends ImplicitlyAnimatedWidget implements AnimatedPositionedDirectionalI {
  protected AnimatedPositionedDirectional() {}
  AnimatedPositionedDirectional(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPositionedDirectional");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedPositionedDirectional animatedPositionedDirectionalAnimatedPositionedDirectional(@Builder.Parameter WidgetI child, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedPositionedDirectionalAnimatedPositionedDirectional(child.build(),
      start,
      top,
      end,
      bottom,
      width,
      height,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPositionedDirectional");
    return new AnimatedPositionedDirectional(id);
  }
  public static AnimatedPositionedDirectionalAnimatedPositionedDirectionalBuilder animatedPositionedDirectional(WidgetI child) {
    return AnimatedPositionedDirectionalAnimatedPositionedDirectionalBuilder.animatedPositionedDirectionalAnimatedPositionedDirectional(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalChild not supported on web");
    return factories.AnimatedPositionedDirectional_readBack_child(nativeStruct);
  }
  public double start() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalStart not supported on web");
    return factories.AnimatedPositionedDirectional_readBack_start(nativeStruct);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalTop not supported on web");
    return factories.AnimatedPositionedDirectional_readBack_top(nativeStruct);
  }
  public double end() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalEnd not supported on web");
    return factories.AnimatedPositionedDirectional_readBack_end(nativeStruct);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalBottom not supported on web");
    return factories.AnimatedPositionedDirectional_readBack_bottom(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalWidth not supported on web");
    return factories.AnimatedPositionedDirectional_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedDirectionalHeight not supported on web");
    return factories.AnimatedPositionedDirectional_readBack_height(nativeStruct);
  }
  @Override
  public AnimatedPositionedDirectional build() {
    return this;
  }
}
