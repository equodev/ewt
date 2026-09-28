package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DecoratedBoxTransition extends AnimatedWidget implements DecoratedBoxTransitionI {
  protected DecoratedBoxTransition() {}
  DecoratedBoxTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedBoxTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DecoratedBoxTransition decoratedBoxTransitionDecoratedBoxTransition(@Builder.Parameter AnimationI decoration, Optional<DecorationPosition> position, WidgetI child) {
    int id = factories.decoratedBoxTransitionDecoratedBoxTransition(decoration.build(),
      position,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedBoxTransition");
    return new DecoratedBoxTransition(id);
  }
  public static DecoratedBoxTransitionDecoratedBoxTransitionBuilder decoratedBoxTransition(AnimationI decoration) {
    return DecoratedBoxTransitionDecoratedBoxTransitionBuilder.decoratedBoxTransitionDecoratedBoxTransition(decoration);
  }
  public Animation decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxTransitionDecoration not supported on web");
    return factories.DecoratedBoxTransition_readBack_decoration(nativeStruct);
  }
  public DecorationPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxTransitionPosition not supported on web");
    return factories.DecoratedBoxTransition_readBack_position(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxTransitionChild not supported on web");
    return factories.DecoratedBoxTransition_readBack_child(nativeStruct);
  }
  @Override
  public DecoratedBoxTransition build() {
    return this;
  }
}
