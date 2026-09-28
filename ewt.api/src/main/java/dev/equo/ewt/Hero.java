package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Hero extends StatefulWidget implements HeroI {
  protected Hero() {}
  Hero(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Hero");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Hero heroHero(@Builder.Parameter NativeObj.I tag, Optional<PentaFunction<BuildContext, Animation, HeroFlightDirection, BuildContext, BuildContext, Widget>> flightShuttleBuilder, Optional<Boolean> transitionOnUserGestures, Optional<CurveI> curve, Optional<CurveI> reverseCurve, WidgetI child) {
    int id = factories.heroHero(tag.build(),
      flightShuttleBuilder,
      transitionOnUserGestures,
      curve.map(CurveI::build),
      reverseCurve.map(CurveI::build),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Hero");
    return new Hero(id);
  }
  public static HeroHeroBuilder hero(NativeObj.I tag) {
    return HeroHeroBuilder.heroHero(tag);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroChild not supported on web");
    return factories.Hero_readBack_child(nativeStruct);
  }
  public boolean transitionOnUserGestures() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroTransitionOnUserGestures not supported on web");
    return factories.Hero_readBack_transitionOnUserGestures(nativeStruct);
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroCurve not supported on web");
    return factories.Hero_readBack_curve(nativeStruct);
  }
  public Curve reverseCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroReverseCurve not supported on web");
    return factories.Hero_readBack_reverseCurve(nativeStruct);
  }
  @Override
  public Hero build() {
    return this;
  }
}
