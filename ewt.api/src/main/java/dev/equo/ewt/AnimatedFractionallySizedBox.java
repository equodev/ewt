package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedFractionallySizedBox extends ImplicitlyAnimatedWidget implements AnimatedFractionallySizedBoxI {
  protected AnimatedFractionallySizedBox() {}
  AnimatedFractionallySizedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedFractionallySizedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedFractionallySizedBox animatedFractionallySizedBoxAnimatedFractionallySizedBox(Optional<AlignmentGeometryI> alignment, Optional<WidgetI> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedFractionallySizedBoxAnimatedFractionallySizedBox(alignment.map(AlignmentGeometryI::build),
      child.map(WidgetI::build),
      heightFactor,
      widthFactor,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedFractionallySizedBox");
    return new AnimatedFractionallySizedBox(id);
  }
  public static AnimatedFractionallySizedBoxAnimatedFractionallySizedBoxBuilder animatedFractionallySizedBox() {
    return AnimatedFractionallySizedBoxAnimatedFractionallySizedBoxBuilder.animatedFractionallySizedBoxAnimatedFractionallySizedBox();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxChild not supported on web");
    return factories.AnimatedFractionallySizedBox_readBack_child(nativeStruct);
  }
  public double heightFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxHeightFactor not supported on web");
    return factories.AnimatedFractionallySizedBox_readBack_heightFactor(nativeStruct);
  }
  public double widthFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxWidthFactor not supported on web");
    return factories.AnimatedFractionallySizedBox_readBack_widthFactor(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedFractionallySizedBoxAlignment not supported on web");
    return factories.AnimatedFractionallySizedBox_readBack_alignment(nativeStruct);
  }
  @Override
  public AnimatedFractionallySizedBox build() {
    return this;
  }
}
