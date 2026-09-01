package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverVisibilityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverVisibility extends StatelessWidget implements SliverVisibilityI {
  private MemorySegment st;
  protected SliverVisibility() {}
  SliverVisibility(MemorySegment st) {
    this.id = SliverVisibilityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverVisibility");
    System.out.println("New SliverVisibility id:"+id);
  }
  SliverVisibility(int id) { this.id = id; }
  @Builder.Factory
  static SliverVisibility sliverVisibilitySliverVisibility(@Builder.Parameter WidgetI sliver, Optional<WidgetI> replacementSliver, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity) {
    var st = factories.sliverVisibilitySliverVisibility(sliver.build(),
      replacementSliver.map(WidgetI::build),
      visible,
      maintainState,
      maintainAnimation,
      maintainSize,
      maintainSemantics,
      maintainInteractivity);
    if (st == null) throw new RuntimeException("Failed to created widget SliverVisibility");
    return new SliverVisibility(st);
  }
  public static SliverVisibilitySliverVisibilityBuilder sliverVisibility(WidgetI sliver) {
    return SliverVisibilitySliverVisibilityBuilder.sliverVisibilitySliverVisibility(sliver);
  }
  @Builder.Factory
  static SliverVisibility sliverVisibilityMaintain(@Builder.Parameter WidgetI sliver, Optional<WidgetI> replacementSliver, Optional<Boolean> visible) {
    var st = factories.sliverVisibilityMaintain(sliver.build(),
      replacementSliver.map(WidgetI::build),
      visible);
    if (st == null) throw new RuntimeException("Failed to created widget SliverVisibility");
    return new SliverVisibility(st);
  }
  public static SliverVisibilityMaintainBuilder maintain(WidgetI sliver) {
    return SliverVisibilityMaintainBuilder.sliverVisibilityMaintain(sliver);
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilitySliver not supported on web");
    return new Widget(SliverVisibilityObjSt.sliver(st)) {};
  }
  public Widget replacementSliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityReplacementSliver not supported on web");
    return new Widget(SliverVisibilityObjSt.replacementSliver(st)) {};
  }
  public boolean visible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityVisible not supported on web");
    return intToBool(SliverVisibilityObjSt.visible(st));
  }
  public boolean maintainState() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainState not supported on web");
    return intToBool(SliverVisibilityObjSt.maintainState(st));
  }
  public boolean maintainAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainAnimation not supported on web");
    return intToBool(SliverVisibilityObjSt.maintainAnimation(st));
  }
  public boolean maintainSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainSize not supported on web");
    return intToBool(SliverVisibilityObjSt.maintainSize(st));
  }
  public boolean maintainSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainSemantics not supported on web");
    return intToBool(SliverVisibilityObjSt.maintainSemantics(st));
  }
  public boolean maintainInteractivity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverVisibilityMaintainInteractivity not supported on web");
    return intToBool(SliverVisibilityObjSt.maintainInteractivity(st));
  }
  @Override
  public SliverVisibility build() {
    return this;
  }
}
