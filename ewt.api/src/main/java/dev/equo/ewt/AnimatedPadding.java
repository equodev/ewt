package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedPadding extends ImplicitlyAnimatedWidget implements AnimatedPaddingI {
  protected AnimatedPadding() {}
  AnimatedPadding(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPadding");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedPadding animatedPaddingAnimatedPadding(@Builder.Parameter EdgeInsetsGeometryI padding, Optional<WidgetI> child, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedPaddingAnimatedPadding(padding.build(),
      child.map(WidgetI::build),
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedPadding");
    return new AnimatedPadding(id);
  }
  public static AnimatedPaddingAnimatedPaddingBuilder animatedPadding(EdgeInsetsGeometryI padding) {
    return AnimatedPaddingAnimatedPaddingBuilder.animatedPaddingAnimatedPadding(padding);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPaddingPadding not supported on web");
    return factories.AnimatedPadding_readBack_padding(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedPaddingChild not supported on web");
    return factories.AnimatedPadding_readBack_child(nativeStruct);
  }
  @Override
  public AnimatedPadding build() {
    return this;
  }
}
