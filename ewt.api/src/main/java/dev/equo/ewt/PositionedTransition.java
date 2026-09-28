package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PositionedTransition extends AnimatedWidget implements PositionedTransitionI {
  protected PositionedTransition() {}
  PositionedTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PositionedTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PositionedTransition positionedTransitionPositionedTransition(@Builder.Parameter AnimationI rect, @Builder.Parameter WidgetI child) {
    int id = factories.positionedTransitionPositionedTransition(rect.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PositionedTransition");
    return new PositionedTransition(id);
  }
  public static PositionedTransitionPositionedTransitionBuilder positionedTransition(AnimationI rect, WidgetI child) {
    return PositionedTransitionPositionedTransitionBuilder.positionedTransitionPositionedTransition(rect, child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedTransitionChild not supported on web");
    return factories.PositionedTransition_readBack_child(nativeStruct);
  }
  public Animation rect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedTransitionRect not supported on web");
    return factories.PositionedTransition_readBack_rect(nativeStruct);
  }
  @Override
  public PositionedTransition build() {
    return this;
  }
}
