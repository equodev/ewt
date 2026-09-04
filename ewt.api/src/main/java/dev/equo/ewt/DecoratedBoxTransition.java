package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DecoratedBoxTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DecoratedBoxTransition extends AnimatedWidget implements DecoratedBoxTransitionI {
  private MemorySegment st;
  protected DecoratedBoxTransition() {}
  DecoratedBoxTransition(MemorySegment st) {
    this.id = DecoratedBoxTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedBoxTransition");
    System.out.println("New DecoratedBoxTransition id:"+id);
  }
  DecoratedBoxTransition(int id) { this.id = id; }
  @Builder.Factory
  static DecoratedBoxTransition decoratedBoxTransitionDecoratedBoxTransition(@Builder.Parameter AnimationI decoration, Optional<DecorationPosition> position, WidgetI child) {
    var st = factories.decoratedBoxTransitionDecoratedBoxTransition(decoration.build(),
      position,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DecoratedBoxTransition");
    return new DecoratedBoxTransition(st);
  }
  public static DecoratedBoxTransitionDecoratedBoxTransitionBuilder decoratedBoxTransition(AnimationI decoration) {
    return DecoratedBoxTransitionDecoratedBoxTransitionBuilder.decoratedBoxTransitionDecoratedBoxTransition(decoration);
  }
  public Animation decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxTransitionDecoration not supported on web");
    return new Animation() { public int getId() { return DecoratedBoxTransitionObjSt.decoration(st); } };
  }
  public DecorationPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxTransitionPosition not supported on web");
    return DecorationPosition.values()[DecoratedBoxTransitionObjSt.position(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxTransitionChild not supported on web");
    return new Widget(DecoratedBoxTransitionObjSt.child(st)) {};
  }
  @Override
  public DecoratedBoxTransition build() {
    return this;
  }
}
