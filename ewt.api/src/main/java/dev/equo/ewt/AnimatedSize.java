package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedSize extends StatefulWidget implements AnimatedSizeI {
  protected AnimatedSize() {}
  AnimatedSize(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSize");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedSize animatedSizeAnimatedSize(Optional<WidgetI> child, Optional<AlignmentGeometryI> alignment, Optional<CurveI> curve, DurationI duration, Optional<DurationI> reverseDuration, Optional<Clip> clipBehavior, Optional<Runnable> onEnd) {
    int id = factories.animatedSizeAnimatedSize(child.map(WidgetI::build),
      alignment.map(AlignmentGeometryI::build),
      curve.map(CurveI::build),
      duration.build(),
      reverseDuration.map(DurationI::build),
      clipBehavior,
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSize");
    return new AnimatedSize(id);
  }
  public static AnimatedSizeAnimatedSizeBuilder animatedSize() {
    return AnimatedSizeAnimatedSizeBuilder.animatedSizeAnimatedSize();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeChild not supported on web");
    return factories.AnimatedSize_readBack_child(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeAlignment not supported on web");
    return factories.AnimatedSize_readBack_alignment(nativeStruct);
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeCurve not supported on web");
    return factories.AnimatedSize_readBack_curve(nativeStruct);
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSizeDuration", getId());
      return new Duration(__nid);
    }
    return factories.AnimatedSize_readBack_duration(nativeStruct);
  }
  public Duration reverseDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSizeReverseDuration", getId());
      return new Duration(__nid);
    }
    return factories.AnimatedSize_readBack_reverseDuration(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeClipBehavior not supported on web");
    return factories.AnimatedSize_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public AnimatedSize build() {
    return this;
  }
}
