package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.HeroObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Hero extends StatefulWidget implements HeroI {
  private MemorySegment st;
  protected Hero() {}
  Hero(MemorySegment st) {
    this.id = HeroObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Hero");
    System.out.println("New Hero id:"+id);
  }
  Hero(int id) { this.id = id; }
  @Builder.Factory
  static Hero heroHero(@Builder.Parameter NativeObj.I tag, Optional<PentaFunction<BuildContext, Animation, HeroFlightDirection, BuildContext, BuildContext, Widget>> flightShuttleBuilder, Optional<Boolean> transitionOnUserGestures, Optional<CurveI> curve, Optional<CurveI> reverseCurve, WidgetI child) {
    var st = factories.heroHero(tag.build(),
      flightShuttleBuilder,
      transitionOnUserGestures,
      curve.map(CurveI::build),
      reverseCurve.map(CurveI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Hero");
    return new Hero(st);
  }
  public static HeroHeroBuilder hero(NativeObj.I tag) {
    return HeroHeroBuilder.heroHero(tag);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroChild not supported on web");
    return new Widget(HeroObjSt.child(st)) {};
  }
  public boolean transitionOnUserGestures() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroTransitionOnUserGestures not supported on web");
    return intToBool(HeroObjSt.transitionOnUserGestures(st));
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroCurve not supported on web");
    return new Curve(HeroObjSt.curve(st)) {};
  }
  public Curve reverseCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroReverseCurve not supported on web");
    return new Curve(HeroObjSt.reverseCurve(st)) {};
  }
  @Override
  public Hero build() {
    return this;
  }
}
