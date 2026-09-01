package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverOpacityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverOpacity extends SingleChildRenderObjectWidget implements SliverOpacityI {
  private MemorySegment st;
  protected SliverOpacity() {}
  SliverOpacity(MemorySegment st) {
    this.id = SliverOpacityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverOpacity");
    System.out.println("New SliverOpacity id:"+id);
  }
  SliverOpacity(int id) { this.id = id; }
  @Builder.Factory
  static SliverOpacity sliverOpacitySliverOpacity(@Builder.Parameter double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> sliver) {
    var st = factories.sliverOpacitySliverOpacity(opacity,
      alwaysIncludeSemantics,
      sliver.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SliverOpacity");
    return new SliverOpacity(st);
  }
  public static SliverOpacitySliverOpacityBuilder sliverOpacity(double opacity) {
    return SliverOpacitySliverOpacityBuilder.sliverOpacitySliverOpacity(opacity);
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverOpacityOpacity not supported on web");
    return SliverOpacityObjSt.opacity(st);
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverOpacityAlwaysIncludeSemantics not supported on web");
    return intToBool(SliverOpacityObjSt.alwaysIncludeSemantics(st));
  }
  @Override
  public SliverOpacity build() {
    return this;
  }
}
