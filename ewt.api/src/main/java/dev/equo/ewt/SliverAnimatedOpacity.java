package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverAnimatedOpacityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverAnimatedOpacity extends ImplicitlyAnimatedWidget implements SliverAnimatedOpacityI {
  private MemorySegment st;
  protected SliverAnimatedOpacity() {}
  SliverAnimatedOpacity(MemorySegment st) {
    this.id = SliverAnimatedOpacityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAnimatedOpacity");
    System.out.println("New SliverAnimatedOpacity id:"+id);
  }
  SliverAnimatedOpacity(int id) { this.id = id; }
  @Builder.Factory
  static SliverAnimatedOpacity sliverAnimatedOpacitySliverAnimatedOpacity(Optional<WidgetI> sliver, double opacity, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd, Optional<Boolean> alwaysIncludeSemantics) {
    var st = factories.sliverAnimatedOpacitySliverAnimatedOpacity(sliver.map(WidgetI::build),
      opacity,
      curve.map(CurveI::build),
      duration.build(),
      onEnd,
      alwaysIncludeSemantics);
    if (st == null) throw new RuntimeException("Failed to created widget SliverAnimatedOpacity");
    return new SliverAnimatedOpacity(st);
  }
  public static SliverAnimatedOpacitySliverAnimatedOpacityBuilder sliverAnimatedOpacity() {
    return SliverAnimatedOpacitySliverAnimatedOpacityBuilder.sliverAnimatedOpacitySliverAnimatedOpacity();
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAnimatedOpacitySliver not supported on web");
    return new Widget(SliverAnimatedOpacityObjSt.sliver(st)) {};
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAnimatedOpacityOpacity not supported on web");
    return SliverAnimatedOpacityObjSt.opacity(st);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAnimatedOpacityAlwaysIncludeSemantics not supported on web");
    return intToBool(SliverAnimatedOpacityObjSt.alwaysIncludeSemantics(st));
  }
  @Override
  public SliverAnimatedOpacity build() {
    return this;
  }
}
