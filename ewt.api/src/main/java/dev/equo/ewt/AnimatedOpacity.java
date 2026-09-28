package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedOpacity extends ImplicitlyAnimatedWidget implements AnimatedOpacityI {
  protected AnimatedOpacity() {}
  AnimatedOpacity(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedOpacity");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedOpacity animatedOpacityAnimatedOpacity(Optional<WidgetI> child, double opacity, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd, Optional<Boolean> alwaysIncludeSemantics) {
    int id = factories.animatedOpacityAnimatedOpacity(child.map(WidgetI::build),
      opacity,
      curve.map(CurveI::build),
      duration.build(),
      onEnd,
      alwaysIncludeSemantics);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedOpacity");
    return new AnimatedOpacity(id);
  }
  public static AnimatedOpacityAnimatedOpacityBuilder animatedOpacity() {
    return AnimatedOpacityAnimatedOpacityBuilder.animatedOpacityAnimatedOpacity();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedOpacityChild not supported on web");
    return factories.AnimatedOpacity_readBack_child(nativeStruct);
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedOpacityOpacity not supported on web");
    return factories.AnimatedOpacity_readBack_opacity(nativeStruct);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedOpacityAlwaysIncludeSemantics not supported on web");
    return factories.AnimatedOpacity_readBack_alwaysIncludeSemantics(nativeStruct);
  }
  @Override
  public AnimatedOpacity build() {
    return this;
  }
}
