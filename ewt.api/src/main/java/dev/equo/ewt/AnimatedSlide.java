package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedSlide extends ImplicitlyAnimatedWidget implements AnimatedSlideI {
  protected AnimatedSlide() {}
  AnimatedSlide(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSlide");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedSlide animatedSlideAnimatedSlide(Optional<WidgetI> child, OffsetI offset, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedSlideAnimatedSlide(child.map(WidgetI::build),
      offset.build(),
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSlide");
    return new AnimatedSlide(id);
  }
  public static AnimatedSlideAnimatedSlideBuilder animatedSlide() {
    return AnimatedSlideAnimatedSlideBuilder.animatedSlideAnimatedSlide();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSlideChild not supported on web");
    return factories.AnimatedSlide_readBack_child(nativeStruct);
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSlideOffset", getId());
      return new Offset(__nid);
    }
    return factories.AnimatedSlide_readBack_offset(nativeStruct);
  }
  @Override
  public AnimatedSlide build() {
    return this;
  }
}
