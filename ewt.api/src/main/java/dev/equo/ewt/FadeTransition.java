package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FadeTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FadeTransition extends SingleChildRenderObjectWidget implements FadeTransitionI {
  private MemorySegment st;
  protected FadeTransition() {}
  FadeTransition(MemorySegment st) {
    this.id = FadeTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FadeTransition");
    System.out.println("New FadeTransition id:"+id);
  }
  @Builder.Factory
  static FadeTransition fadeTransitionFadeTransition(@Builder.Parameter AnimationI opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> child) {
    var st = factories.fadeTransitionFadeTransition(opacity.build(),
      alwaysIncludeSemantics,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FadeTransition");
    return new FadeTransition(st);
  }
  public static FadeTransitionFadeTransitionBuilder fadeTransition(AnimationI opacity) {
    return FadeTransitionFadeTransitionBuilder.fadeTransitionFadeTransition(opacity);
  }
  public Animation opacity() {
    return new Animation() { public int getId() { return FadeTransitionObjSt.opacity(st); } };
  }
  public boolean alwaysIncludeSemantics() {
    return intToBool(FadeTransitionObjSt.alwaysIncludeSemantics(st));
  }
  @Override
  public FadeTransition build() {
    return this;
  }
}
