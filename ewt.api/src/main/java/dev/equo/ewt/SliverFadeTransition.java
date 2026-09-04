package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverFadeTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverFadeTransition extends SingleChildRenderObjectWidget implements SliverFadeTransitionI {
  private MemorySegment st;
  protected SliverFadeTransition() {}
  SliverFadeTransition(MemorySegment st) {
    this.id = SliverFadeTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFadeTransition");
    System.out.println("New SliverFadeTransition id:"+id);
  }
  SliverFadeTransition(int id) { this.id = id; }
  @Builder.Factory
  static SliverFadeTransition sliverFadeTransitionSliverFadeTransition(@Builder.Parameter AnimationI opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> sliver) {
    var st = factories.sliverFadeTransitionSliverFadeTransition(opacity.build(),
      alwaysIncludeSemantics,
      sliver.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SliverFadeTransition");
    return new SliverFadeTransition(st);
  }
  public static SliverFadeTransitionSliverFadeTransitionBuilder sliverFadeTransition(AnimationI opacity) {
    return SliverFadeTransitionSliverFadeTransitionBuilder.sliverFadeTransitionSliverFadeTransition(opacity);
  }
  public Animation opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFadeTransitionOpacity not supported on web");
    return new Animation() { public int getId() { return SliverFadeTransitionObjSt.opacity(st); } };
  }
  public boolean alwaysIncludeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFadeTransitionAlwaysIncludeSemantics not supported on web");
    return intToBool(SliverFadeTransitionObjSt.alwaysIncludeSemantics(st));
  }
  @Override
  public SliverFadeTransition build() {
    return this;
  }
}
