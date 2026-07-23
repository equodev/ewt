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
    return new Widget(AnimatedCrossFadeObjSt.firstChild(st)) {};
  }
  public Widget secondChild() {
    return new Widget(AnimatedCrossFadeObjSt.secondChild(st)) {};
  }
  public CrossFadeState crossFadeState() {
    return CrossFadeState.values()[AnimatedCrossFadeObjSt.crossFadeState(st)];
  }
  public Duration duration() {
    return new Duration(AnimatedCrossFadeObjSt.duration(st));
  }
  public Duration reverseDuration() {
    return new Duration(AnimatedCrossFadeObjSt.reverseDuration(st));
  }
  public Curve firstCurve() {
    return new Curve(AnimatedCrossFadeObjSt.firstCurve(st)) {};
  }
  public Curve secondCurve() {
    return new Curve(AnimatedCrossFadeObjSt.secondCurve(st)) {};
  }
  public Curve sizeCurve() {
    return new Curve(AnimatedCrossFadeObjSt.sizeCurve(st)) {};
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(AnimatedCrossFadeObjSt.alignment(st)) {};
  }
  public boolean excludeBottomFocus() {
    return intToBool(AnimatedCrossFadeObjSt.excludeBottomFocus(st));
  }
  @Override
  public AnimatedCrossFade build() {
    return this;
  }
}
