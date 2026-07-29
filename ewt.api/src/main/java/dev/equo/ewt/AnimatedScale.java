package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedScaleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedScale extends ImplicitlyAnimatedWidget implements AnimatedScaleI {
  private MemorySegment st;
  protected AnimatedScale() {}
  AnimatedScale(MemorySegment st) {
    this.id = AnimatedScaleObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedScale");
    System.out.println("New AnimatedScale id:"+id);
  }
  AnimatedScale(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedScale animatedScaleAnimatedScale(Optional<WidgetI> child, double scale, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedScaleAnimatedScale(child.map(WidgetI::build),
      scale,
      alignment.map(AlignmentI::build),
      filterQuality,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedScale");
    return new AnimatedScale(st);
  }
  public static AnimatedScaleAnimatedScaleBuilder animatedScale() {
    return AnimatedScaleAnimatedScaleBuilder.animatedScaleAnimatedScale();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedScaleChild not supported on web");
    return new Widget(AnimatedScaleObjSt.child(st)) {};
  }
  public double scale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedScaleScale not supported on web");
    return AnimatedScaleObjSt.scale(st);
  }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedScaleAlignment", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentObjSt.id(__st, __nid);
      return new Alignment(__st);
    }
    return new Alignment(AnimatedScaleObjSt.alignment(st));
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedScaleFilterQuality not supported on web");
    return FilterQuality.values()[AnimatedScaleObjSt.filterQuality(st)];
  }
  @Override
  public AnimatedScale build() {
    return this;
  }
}
