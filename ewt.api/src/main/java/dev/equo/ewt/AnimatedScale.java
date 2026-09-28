package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedScale extends ImplicitlyAnimatedWidget implements AnimatedScaleI {
  protected AnimatedScale() {}
  AnimatedScale(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedScale");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedScale animatedScaleAnimatedScale(Optional<WidgetI> child, double scale, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedScaleAnimatedScale(child.map(WidgetI::build),
      scale,
      alignment.map(AlignmentI::build),
      filterQuality,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedScale");
    return new AnimatedScale(id);
  }
  public static AnimatedScaleAnimatedScaleBuilder animatedScale() {
    return AnimatedScaleAnimatedScaleBuilder.animatedScaleAnimatedScale();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedScaleChild not supported on web");
    return factories.AnimatedScale_readBack_child(nativeStruct);
  }
  public double scale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedScaleScale not supported on web");
    return factories.AnimatedScale_readBack_scale(nativeStruct);
  }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedScaleAlignment", getId());
      return new Alignment(__nid);
    }
    return factories.AnimatedScale_readBack_alignment(nativeStruct);
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedScaleFilterQuality not supported on web");
    return factories.AnimatedScale_readBack_filterQuality(nativeStruct);
  }
  @Override
  public AnimatedScale build() {
    return this;
  }
}
