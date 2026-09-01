package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.HeroModeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class HeroMode extends StatelessWidget implements HeroModeI {
  private MemorySegment st;
  protected HeroMode() {}
  HeroMode(MemorySegment st) {
    this.id = HeroModeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget HeroMode");
    System.out.println("New HeroMode id:"+id);
  }
  HeroMode(int id) { this.id = id; }
  @Builder.Factory
  static HeroMode heroModeHeroMode(@Builder.Parameter WidgetI child, Optional<Boolean> enabled) {
    var st = factories.heroModeHeroMode(child.build(),
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget HeroMode");
    return new HeroMode(st);
  }
  public static HeroModeHeroModeBuilder heroMode(WidgetI child) {
    return HeroModeHeroModeBuilder.heroModeHeroMode(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroModeChild not supported on web");
    return new Widget(HeroModeObjSt.child(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroModeEnabled not supported on web");
    return intToBool(HeroModeObjSt.enabled(st));
  }
  @Override
  public HeroMode build() {
    return this;
  }
}
