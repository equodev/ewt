package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SlideTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SlideTransition extends AnimatedWidget implements SlideTransitionI {
  private MemorySegment st;
  protected SlideTransition() {}
  SlideTransition(MemorySegment st) {
    this.id = SlideTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SlideTransition");
    System.out.println("New SlideTransition id:"+id);
  }
  SlideTransition(int id) { this.id = id; }
  @Builder.Factory
  static SlideTransition slideTransitionSlideTransition(@Builder.Parameter AnimationI position, Optional<Boolean> transformHitTests, Optional<TextDirection> textDirection, Optional<WidgetI> child) {
    var st = factories.slideTransitionSlideTransition(position.build(),
      transformHitTests,
      textDirection,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SlideTransition");
    return new SlideTransition(st);
  }
  public static SlideTransitionSlideTransitionBuilder slideTransition(AnimationI position) {
    return SlideTransitionSlideTransitionBuilder.slideTransitionSlideTransition(position);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionTextDirection not supported on web");
    return TextDirection.values()[SlideTransitionObjSt.textDirection(st)];
  }
  public boolean transformHitTests() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionTransformHitTests not supported on web");
    return intToBool(SlideTransitionObjSt.transformHitTests(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionChild not supported on web");
    return new Widget(SlideTransitionObjSt.child(st)) {};
  }
  public Animation position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionPosition not supported on web");
    return new Animation() { public int getId() { return SlideTransitionObjSt.position(st); } };
  }
  @Override
  public SlideTransition build() {
    return this;
  }
}
