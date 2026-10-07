package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedSwitcher extends StatefulWidget implements AnimatedSwitcherI {
  protected AnimatedSwitcher() {}
  AnimatedSwitcher(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSwitcher");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedSwitcher animatedSwitcherAnimatedSwitcher(Optional<WidgetI> child, DurationI duration, Optional<DurationI> reverseDuration, Optional<CurveI> switchInCurve, Optional<CurveI> switchOutCurve, Optional<BiFunction<Widget, Animation, Widget>> transitionBuilder, Optional<BiFunction<Widget, List<Widget>, Widget>> layoutBuilder) {
    int id = factories.animatedSwitcherAnimatedSwitcher(child.map(WidgetI::build),
      duration.build(),
      reverseDuration.map(DurationI::build),
      switchInCurve.map(CurveI::build),
      switchOutCurve.map(CurveI::build),
      transitionBuilder,
      layoutBuilder);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSwitcher");
    return new AnimatedSwitcher(id);
  }
  public static AnimatedSwitcherAnimatedSwitcherBuilder animatedSwitcher() {
    return AnimatedSwitcherAnimatedSwitcherBuilder.animatedSwitcherAnimatedSwitcher();
  }
  public static Widget defaultTransitionBuilder(WidgetI child, AnimationI animation) {
    var id = factories.animatedSwitcherDefaultTransitionBuilder(child.build(),
      animation.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    return new Widget(id) {};
  }
  public static Widget defaultLayoutBuilder(WidgetI currentChild, List<WidgetI> previousChildren) {
    var id = factories.animatedSwitcherDefaultLayoutBuilder(currentChild.build(),
      previousChildren.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    return new Widget(id) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSwitcherChild not supported on web");
    return factories.AnimatedSwitcher_readBack_child(nativeStruct);
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSwitcherDuration", getId());
      return new Duration(__nid);
    }
    return factories.AnimatedSwitcher_readBack_duration(nativeStruct);
  }
  public Duration reverseDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedSwitcherReverseDuration", getId());
      return new Duration(__nid);
    }
    return factories.AnimatedSwitcher_readBack_reverseDuration(nativeStruct);
  }
  public Curve switchInCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSwitcherSwitchInCurve not supported on web");
    return factories.AnimatedSwitcher_readBack_switchInCurve(nativeStruct);
  }
  public Curve switchOutCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedSwitcherSwitchOutCurve not supported on web");
    return factories.AnimatedSwitcher_readBack_switchOutCurve(nativeStruct);
  }
  @Override
  public AnimatedSwitcher build() {
    return this;
  }
}
