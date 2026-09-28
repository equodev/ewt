package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedRotation extends ImplicitlyAnimatedWidget implements AnimatedRotationI {
  protected AnimatedRotation() {}
  AnimatedRotation(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedRotation");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedRotation animatedRotationAnimatedRotation(Optional<WidgetI> child, double turns, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedRotationAnimatedRotation(child.map(WidgetI::build),
      turns,
      alignment.map(AlignmentI::build),
      filterQuality,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedRotation");
    return new AnimatedRotation(id);
  }
  public static AnimatedRotationAnimatedRotationBuilder animatedRotation() {
    return AnimatedRotationAnimatedRotationBuilder.animatedRotationAnimatedRotation();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedRotationChild not supported on web");
    return factories.AnimatedRotation_readBack_child(nativeStruct);
  }
  public double turns() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedRotationTurns not supported on web");
    return factories.AnimatedRotation_readBack_turns(nativeStruct);
  }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedRotationAlignment", getId());
      return new Alignment(__nid);
    }
    return factories.AnimatedRotation_readBack_alignment(nativeStruct);
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedRotationFilterQuality not supported on web");
    return factories.AnimatedRotation_readBack_filterQuality(nativeStruct);
  }
  @Override
  public AnimatedRotation build() {
    return this;
  }
}
