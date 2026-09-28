package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedAlign extends ImplicitlyAnimatedWidget implements AnimatedAlignI {
  protected AnimatedAlign() {}
  AnimatedAlign(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedAlign");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedAlign animatedAlignAnimatedAlign(@Builder.Parameter AlignmentGeometryI alignment, Optional<WidgetI> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedAlignAnimatedAlign(alignment.build(),
      child.map(WidgetI::build),
      heightFactor,
      widthFactor,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedAlign");
    return new AnimatedAlign(id);
  }
  public static AnimatedAlignAnimatedAlignBuilder animatedAlign(AlignmentGeometryI alignment) {
    return AnimatedAlignAnimatedAlignBuilder.animatedAlignAnimatedAlign(alignment);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedAlignAlignment not supported on web");
    return factories.AnimatedAlign_readBack_alignment(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedAlignChild not supported on web");
    return factories.AnimatedAlign_readBack_child(nativeStruct);
  }
  public double heightFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedAlignHeightFactor not supported on web");
    return factories.AnimatedAlign_readBack_heightFactor(nativeStruct);
  }
  public double widthFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedAlignWidthFactor not supported on web");
    return factories.AnimatedAlign_readBack_widthFactor(nativeStruct);
  }
  @Override
  public AnimatedAlign build() {
    return this;
  }
}
