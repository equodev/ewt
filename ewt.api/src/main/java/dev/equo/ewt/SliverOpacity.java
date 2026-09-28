package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverOpacity extends SingleChildRenderObjectWidget implements SliverOpacityI {
  protected SliverOpacity() {}
  SliverOpacity(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverOpacity");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverOpacity sliverOpacitySliverOpacity(@Builder.Parameter double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> sliver) {
    int id = factories.sliverOpacitySliverOpacity(opacity,
      alwaysIncludeSemantics,
      sliver.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverOpacity");
    return new SliverOpacity(id);
  }
  public static SliverOpacitySliverOpacityBuilder sliverOpacity(double opacity) {
    return SliverOpacitySliverOpacityBuilder.sliverOpacitySliverOpacity(opacity);
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverOpacityOpacity not supported on web");
    return factories.SliverOpacity_readBack_opacity(nativeStruct);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverOpacityAlwaysIncludeSemantics not supported on web");
    return factories.SliverOpacity_readBack_alwaysIncludeSemantics(nativeStruct);
  }
  @Override
  public SliverOpacity build() {
    return this;
  }
}
