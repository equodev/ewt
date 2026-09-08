package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PositionedTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PositionedTransition extends AnimatedWidget implements PositionedTransitionI {
  private MemorySegment st;
  protected PositionedTransition() {}
  PositionedTransition(MemorySegment st) {
    this.id = PositionedTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PositionedTransition");
    System.out.println("New PositionedTransition id:"+id);
  }
  PositionedTransition(int id) { this.id = id; }
  @Builder.Factory
  static PositionedTransition positionedTransitionPositionedTransition(@Builder.Parameter AnimationI rect, @Builder.Parameter WidgetI child) {
    var st = factories.positionedTransitionPositionedTransition(rect.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget PositionedTransition");
    return new PositionedTransition(st);
  }
  public static PositionedTransitionPositionedTransitionBuilder positionedTransition(AnimationI rect, WidgetI child) {
    return PositionedTransitionPositionedTransitionBuilder.positionedTransitionPositionedTransition(rect, child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedTransitionChild not supported on web");
    return new Widget(PositionedTransitionObjSt.child(st)) {};
  }
  public Animation rect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedTransitionRect not supported on web");
    return new Animation() { public int getId() { return PositionedTransitionObjSt.rect(st); } };
  }
  @Override
  public PositionedTransition build() {
    return this;
  }
}
