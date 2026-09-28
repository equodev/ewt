package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedPositioned extends ImplicitlyAnimatedWidget implements AnimatedPositionedI {
  protected AnimatedPositioned() {}
  AnimatedPositioned(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPositioned");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedPositioned animatedPositionedAnimatedPositioned(@Builder.Parameter WidgetI child, OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedPositionedAnimatedPositioned(child.build(),
      left,
      top,
      right,
      bottom,
      width,
      height,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPositioned");
    return new AnimatedPositioned(id);
  }
  public static AnimatedPositionedAnimatedPositionedBuilder animatedPositioned(WidgetI child) {
    return AnimatedPositionedAnimatedPositionedBuilder.animatedPositionedAnimatedPositioned(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedChild not supported on web");
    return factories.AnimatedPositioned_readBack_child(nativeStruct);
  }
  public double left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedLeft not supported on web");
    return factories.AnimatedPositioned_readBack_left(nativeStruct);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedTop not supported on web");
    return factories.AnimatedPositioned_readBack_top(nativeStruct);
  }
  public double right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedRight not supported on web");
    return factories.AnimatedPositioned_readBack_right(nativeStruct);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedBottom not supported on web");
    return factories.AnimatedPositioned_readBack_bottom(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedWidth not supported on web");
    return factories.AnimatedPositioned_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPositionedHeight not supported on web");
    return factories.AnimatedPositioned_readBack_height(nativeStruct);
  }
  @Override
  public AnimatedPositioned build() {
    return this;
  }
}
