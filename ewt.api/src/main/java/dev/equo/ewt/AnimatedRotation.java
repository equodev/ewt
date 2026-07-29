package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedRotationObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedRotation extends ImplicitlyAnimatedWidget implements AnimatedRotationI {
  private MemorySegment st;
  protected AnimatedRotation() {}
  AnimatedRotation(MemorySegment st) {
    this.id = AnimatedRotationObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedRotation");
    System.out.println("New AnimatedRotation id:"+id);
  }
  AnimatedRotation(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedRotation animatedRotationAnimatedRotation(Optional<WidgetI> child, double turns, Optional<AlignmentI> alignment, Optional<FilterQuality> filterQuality, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedRotationAnimatedRotation(child.map(WidgetI::build),
      turns,
      alignment.map(AlignmentI::build),
      filterQuality,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedRotation");
    return new AnimatedRotation(st);
  }
  public static AnimatedRotationAnimatedRotationBuilder animatedRotation() {
    return AnimatedRotationAnimatedRotationBuilder.animatedRotationAnimatedRotation();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedRotationChild not supported on web");
    return new Widget(AnimatedRotationObjSt.child(st)) {};
  }
  public double turns() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedRotationTurns not supported on web");
    return AnimatedRotationObjSt.turns(st);
  }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedRotationAlignment", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentObjSt.id(__st, __nid);
      return new Alignment(__st);
    }
    return new Alignment(AnimatedRotationObjSt.alignment(st));
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedRotationFilterQuality not supported on web");
    return FilterQuality.values()[AnimatedRotationObjSt.filterQuality(st)];
  }
  @Override
  public AnimatedRotation build() {
    return this;
  }
}
