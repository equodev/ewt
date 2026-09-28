package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Opacity extends SingleChildRenderObjectWidget implements OpacityI {
  protected Opacity() {}
  Opacity(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Opacity");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Opacity opacityOpacity(@Builder.Parameter double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> child) {
    int id = factories.opacityOpacity(opacity,
      alwaysIncludeSemantics,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Opacity");
    return new Opacity(id);
  }
  public static OpacityOpacityBuilder opacity(double opacity) {
    return OpacityOpacityBuilder.opacityOpacity(opacity);
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("opacityOpacity not supported on web");
    return factories.Opacity_readBack_opacity(nativeStruct);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("opacityAlwaysIncludeSemantics not supported on web");
    return factories.Opacity_readBack_alwaysIncludeSemantics(nativeStruct);
  }
  @Override
  public Opacity build() {
    return this;
  }
}
