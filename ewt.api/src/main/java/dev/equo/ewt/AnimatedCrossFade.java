package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedCrossFade extends StatefulWidget implements AnimatedCrossFadeI {
  protected AnimatedCrossFade() {}
  AnimatedCrossFade(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedCrossFade");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedCrossFade animatedCrossFadeAnimatedCrossFade(@Builder.Parameter WidgetI firstChild, @Builder.Parameter WidgetI secondChild, Optional<CurveI> firstCurve, Optional<CurveI> secondCurve, Optional<CurveI> sizeCurve, Optional<AlignmentGeometryI> alignment, CrossFadeState crossFadeState, DurationI duration, Optional<DurationI> reverseDuration, Optional<Boolean> excludeBottomFocus, Optional<Runnable> onEnd) {
    int id = factories.animatedCrossFadeAnimatedCrossFade(firstChild.build(),
      secondChild.build(),
      firstCurve.map(CurveI::build),
      secondCurve.map(CurveI::build),
      sizeCurve.map(CurveI::build),
      alignment.map(AlignmentGeometryI::build),
      crossFadeState,
      duration.build(),
      reverseDuration.map(DurationI::build),
      excludeBottomFocus,
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedCrossFade");
    return new AnimatedCrossFade(id);
  }
  public static AnimatedCrossFadeAnimatedCrossFadeBuilder animatedCrossFade(WidgetI firstChild, WidgetI secondChild) {
    return AnimatedCrossFadeAnimatedCrossFadeBuilder.animatedCrossFadeAnimatedCrossFade(firstChild, secondChild);
  }
  public Widget firstChild() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeFirstChild not supported on web");
    return factories.AnimatedCrossFade_readBack_firstChild(nativeStruct);
  }
  public Widget secondChild() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeSecondChild not supported on web");
    return factories.AnimatedCrossFade_readBack_secondChild(nativeStruct);
  }
  public CrossFadeState crossFadeState() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeCrossFadeState not supported on web");
    return factories.AnimatedCrossFade_readBack_crossFadeState(nativeStruct);
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedCrossFadeDuration", getId());
      return new Duration(__nid);
    }
    return factories.AnimatedCrossFade_readBack_duration(nativeStruct);
  }
  public Duration reverseDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedCrossFadeReverseDuration", getId());
      return new Duration(__nid);
    }
    return factories.AnimatedCrossFade_readBack_reverseDuration(nativeStruct);
  }
  public Curve firstCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeFirstCurve not supported on web");
    return factories.AnimatedCrossFade_readBack_firstCurve(nativeStruct);
  }
  public Curve secondCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeSecondCurve not supported on web");
    return factories.AnimatedCrossFade_readBack_secondCurve(nativeStruct);
  }
  public Curve sizeCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeSizeCurve not supported on web");
    return factories.AnimatedCrossFade_readBack_sizeCurve(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeAlignment not supported on web");
    return factories.AnimatedCrossFade_readBack_alignment(nativeStruct);
  }
  public boolean excludeBottomFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedCrossFadeExcludeBottomFocus not supported on web");
    return factories.AnimatedCrossFade_readBack_excludeBottomFocus(nativeStruct);
  }
  @Override
  public AnimatedCrossFade build() {
    return this;
  }
}
