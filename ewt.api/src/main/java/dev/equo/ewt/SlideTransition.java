package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SlideTransition extends AnimatedWidget implements SlideTransitionI {
  protected SlideTransition() {}
  SlideTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SlideTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SlideTransition slideTransitionSlideTransition(@Builder.Parameter AnimationI position, Optional<Boolean> transformHitTests, Optional<TextDirection> textDirection, Optional<WidgetI> child) {
    int id = factories.slideTransitionSlideTransition(position.build(),
      transformHitTests,
      textDirection,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SlideTransition");
    return new SlideTransition(id);
  }
  public static SlideTransitionSlideTransitionBuilder slideTransition(AnimationI position) {
    return SlideTransitionSlideTransitionBuilder.slideTransitionSlideTransition(position);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionTextDirection not supported on web");
    return factories.SlideTransition_readBack_textDirection(nativeStruct);
  }
  public boolean transformHitTests() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionTransformHitTests not supported on web");
    return factories.SlideTransition_readBack_transformHitTests(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionChild not supported on web");
    return factories.SlideTransition_readBack_child(nativeStruct);
  }
  public Animation position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("slideTransitionPosition not supported on web");
    return factories.SlideTransition_readBack_position(nativeStruct);
  }
  @Override
  public SlideTransition build() {
    return this;
  }
}
