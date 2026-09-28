package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AlignTransition extends AnimatedWidget implements AlignTransitionI {
  protected AlignTransition() {}
  AlignTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AlignTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AlignTransition alignTransitionAlignTransition(@Builder.Parameter AnimationI alignment, @Builder.Parameter WidgetI child, OptionalDouble widthFactor, OptionalDouble heightFactor) {
    int id = factories.alignTransitionAlignTransition(alignment.build(),
      child.build(),
      widthFactor,
      heightFactor);
    if (id <= 0) throw new RuntimeException("Failed to created widget AlignTransition");
    return new AlignTransition(id);
  }
  public static AlignTransitionAlignTransitionBuilder alignTransition(AnimationI alignment, WidgetI child) {
    return AlignTransitionAlignTransitionBuilder.alignTransitionAlignTransition(alignment, child);
  }
  public double widthFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionWidthFactor not supported on web");
    return factories.AlignTransition_readBack_widthFactor(nativeStruct);
  }
  public double heightFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionHeightFactor not supported on web");
    return factories.AlignTransition_readBack_heightFactor(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionChild not supported on web");
    return factories.AlignTransition_readBack_child(nativeStruct);
  }
  public Animation alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionAlignment not supported on web");
    return factories.AlignTransition_readBack_alignment(nativeStruct);
  }
  @Override
  public AlignTransition build() {
    return this;
  }
}
