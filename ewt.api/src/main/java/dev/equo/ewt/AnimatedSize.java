package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedSizeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedSize extends StatefulWidget implements AnimatedSizeI {
  private MemorySegment st;
  protected AnimatedSize() {}
  AnimatedSize(MemorySegment st) {
    this.id = AnimatedSizeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSize");
    System.out.println("New AnimatedSize id:"+id);
  }
  AnimatedSize(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedSize animatedSizeAnimatedSize(Optional<WidgetI> child, Optional<AlignmentGeometryI> alignment, Optional<CurveI> curve, DurationI duration, Optional<DurationI> reverseDuration, Optional<Clip> clipBehavior, Optional<Runnable> onEnd) {
    var st = factories.animatedSizeAnimatedSize(child.map(WidgetI::build),
      alignment.map(AlignmentGeometryI::build),
      curve.map(CurveI::build),
      duration.build(),
      reverseDuration.map(DurationI::build),
      clipBehavior,
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedSize");
    return new AnimatedSize(st);
  }
  public static AnimatedSizeAnimatedSizeBuilder animatedSize() {
    return AnimatedSizeAnimatedSizeBuilder.animatedSizeAnimatedSize();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeChild not supported on web");
    return new Widget(AnimatedSizeObjSt.child(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeAlignment not supported on web");
    return new AlignmentGeometry(AnimatedSizeObjSt.alignment(st)) {};
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeCurve not supported on web");
    return new Curve(AnimatedSizeObjSt.curve(st)) {};
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSizeDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(AnimatedSizeObjSt.duration(st));
  }
  public Duration reverseDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSizeReverseDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(AnimatedSizeObjSt.reverseDuration(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSizeClipBehavior not supported on web");
    return Clip.values()[AnimatedSizeObjSt.clipBehavior(st)];
  }
  @Override
  public AnimatedSize build() {
    return this;
  }
}
