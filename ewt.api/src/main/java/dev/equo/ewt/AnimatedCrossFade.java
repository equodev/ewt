package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedCrossFadeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedCrossFade extends StatefulWidget implements AnimatedCrossFadeI {
  private MemorySegment st;
  protected AnimatedCrossFade() {}
  AnimatedCrossFade(MemorySegment st) {
    this.id = AnimatedCrossFadeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedCrossFade");
    System.out.println("New AnimatedCrossFade id:"+id);
  }
  AnimatedCrossFade(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedCrossFade animatedCrossFadeAnimatedCrossFade(@Builder.Parameter WidgetI firstChild, @Builder.Parameter WidgetI secondChild, Optional<CurveI> firstCurve, Optional<CurveI> secondCurve, Optional<CurveI> sizeCurve, Optional<AlignmentGeometryI> alignment, CrossFadeState crossFadeState, DurationI duration, Optional<DurationI> reverseDuration, Optional<Boolean> excludeBottomFocus) {
    var st = factories.animatedCrossFadeAnimatedCrossFade(firstChild.build(),
      secondChild.build(),
      firstCurve.map(CurveI::build),
      secondCurve.map(CurveI::build),
      sizeCurve.map(CurveI::build),
      alignment.map(AlignmentGeometryI::build),
      crossFadeState,
      duration.build(),
      reverseDuration.map(DurationI::build),
      excludeBottomFocus);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedCrossFade");
    return new AnimatedCrossFade(st);
  }
  public static AnimatedCrossFadeAnimatedCrossFadeBuilder animatedCrossFade(WidgetI firstChild, WidgetI secondChild) {
    return AnimatedCrossFadeAnimatedCrossFadeBuilder.animatedCrossFadeAnimatedCrossFade(firstChild, secondChild);
  }
  public Widget firstChild() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeFirstChild not supported on web");
    return new Widget(AnimatedCrossFadeObjSt.firstChild(st)) {};
  }
  public Widget secondChild() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeSecondChild not supported on web");
    return new Widget(AnimatedCrossFadeObjSt.secondChild(st)) {};
  }
  public CrossFadeState crossFadeState() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeCrossFadeState not supported on web");
    return CrossFadeState.values()[AnimatedCrossFadeObjSt.crossFadeState(st)];
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedCrossFadeDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(AnimatedCrossFadeObjSt.duration(st));
  }
  public Duration reverseDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedCrossFadeReverseDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(AnimatedCrossFadeObjSt.reverseDuration(st));
  }
  public Curve firstCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeFirstCurve not supported on web");
    return new Curve(AnimatedCrossFadeObjSt.firstCurve(st)) {};
  }
  public Curve secondCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeSecondCurve not supported on web");
    return new Curve(AnimatedCrossFadeObjSt.secondCurve(st)) {};
  }
  public Curve sizeCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeSizeCurve not supported on web");
    return new Curve(AnimatedCrossFadeObjSt.sizeCurve(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeAlignment not supported on web");
    return new AlignmentGeometry(AnimatedCrossFadeObjSt.alignment(st)) {};
  }
  public boolean excludeBottomFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeExcludeBottomFocus not supported on web");
    return intToBool(AnimatedCrossFadeObjSt.excludeBottomFocus(st));
  }
  @Override
  public AnimatedCrossFade build() {
    return this;
  }
}
