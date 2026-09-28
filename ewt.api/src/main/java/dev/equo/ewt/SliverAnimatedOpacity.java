package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverAnimatedOpacity extends ImplicitlyAnimatedWidget implements SliverAnimatedOpacityI {
  protected SliverAnimatedOpacity() {}
  SliverAnimatedOpacity(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAnimatedOpacity");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverAnimatedOpacity sliverAnimatedOpacitySliverAnimatedOpacity(Optional<WidgetI> sliver, double opacity, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd, Optional<Boolean> alwaysIncludeSemantics) {
    int id = factories.sliverAnimatedOpacitySliverAnimatedOpacity(sliver.map(WidgetI::build),
      opacity,
      curve.map(CurveI::build),
      duration.build(),
      onEnd,
      alwaysIncludeSemantics);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAnimatedOpacity");
    return new SliverAnimatedOpacity(id);
  }
  public static SliverAnimatedOpacitySliverAnimatedOpacityBuilder sliverAnimatedOpacity() {
    return SliverAnimatedOpacitySliverAnimatedOpacityBuilder.sliverAnimatedOpacitySliverAnimatedOpacity();
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAnimatedOpacitySliver not supported on web");
    return factories.SliverAnimatedOpacity_readBack_sliver(nativeStruct);
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAnimatedOpacityOpacity not supported on web");
    return factories.SliverAnimatedOpacity_readBack_opacity(nativeStruct);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAnimatedOpacityAlwaysIncludeSemantics not supported on web");
    return factories.SliverAnimatedOpacity_readBack_alwaysIncludeSemantics(nativeStruct);
  }
  @Override
  public SliverAnimatedOpacity build() {
    return this;
  }
}
