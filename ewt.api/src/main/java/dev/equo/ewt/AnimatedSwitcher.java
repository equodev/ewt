package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedSwitcherObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedSwitcher extends StatefulWidget implements AnimatedSwitcherI {
  private MemorySegment st;
  protected AnimatedSwitcher() {}
  AnimatedSwitcher(MemorySegment st) {
    this.id = AnimatedSwitcherObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSwitcher");
    System.out.println("New AnimatedSwitcher id:"+id);
  }
  AnimatedSwitcher(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedSwitcher animatedSwitcherAnimatedSwitcher(Optional<WidgetI> child, DurationI duration, Optional<DurationI> reverseDuration, Optional<CurveI> switchInCurve, Optional<CurveI> switchOutCurve, Optional<BiFunction<Widget, Animation, Widget>> transitionBuilder, Optional<BiFunction<Widget, List<Widget>, Widget>> layoutBuilder) {
    var st = factories.animatedSwitcherAnimatedSwitcher(child.map(WidgetI::build),
      duration.build(),
      reverseDuration.map(DurationI::build),
      switchInCurve.map(CurveI::build),
      switchOutCurve.map(CurveI::build),
      transitionBuilder,
      layoutBuilder);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedSwitcher");
    return new AnimatedSwitcher(st);
  }
  public static AnimatedSwitcherAnimatedSwitcherBuilder animatedSwitcher() {
    return AnimatedSwitcherAnimatedSwitcherBuilder.animatedSwitcherAnimatedSwitcher();
  }
  public static Widget defaultTransitionBuilder(WidgetI child, AnimationI animation) {
    int id = factories.animatedSwitcherDefaultTransitionBuilder(child.build(),
      animation.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public static Widget defaultLayoutBuilder(WidgetI currentChild, List<WidgetI> previousChildren) {
    int id = factories.animatedSwitcherDefaultLayoutBuilder(currentChild.build(),
      previousChildren.stream().map(WidgetI::build).toList());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSwitcherChild not supported on web");
    return new Widget(AnimatedSwitcherObjSt.child(st)) {};
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSwitcherDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(AnimatedSwitcherObjSt.duration(st));
  }
  public Duration reverseDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSwitcherReverseDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(AnimatedSwitcherObjSt.reverseDuration(st));
  }
  public Curve switchInCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSwitcherSwitchInCurve not supported on web");
    return new Curve(AnimatedSwitcherObjSt.switchInCurve(st)) {};
  }
  public Curve switchOutCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSwitcherSwitchOutCurve not supported on web");
    return new Curve(AnimatedSwitcherObjSt.switchOutCurve(st)) {};
  }
  @Override
  public AnimatedSwitcher build() {
    return this;
  }
}
