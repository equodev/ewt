package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class HeroMode extends StatelessWidget implements HeroModeI {
  protected HeroMode() {}
  HeroMode(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget HeroMode");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static HeroMode heroModeHeroMode(@Builder.Parameter WidgetI child, Optional<Boolean> enabled) {
    int id = factories.heroModeHeroMode(child.build(),
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget HeroMode");
    return new HeroMode(id);
  }
  public static HeroModeHeroModeBuilder heroMode(WidgetI child) {
    return HeroModeHeroModeBuilder.heroModeHeroMode(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroModeChild not supported on web");
    return factories.HeroMode_readBack_child(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("heroModeEnabled not supported on web");
    return factories.HeroMode_readBack_enabled(nativeStruct);
  }
  @Override
  public HeroMode build() {
    return this;
  }
}
