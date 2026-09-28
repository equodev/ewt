package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class HeroControllerScope extends InheritedWidget implements HeroControllerScopeI {
  protected HeroControllerScope() {}
  HeroControllerScope(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget HeroControllerScope");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static HeroControllerScope heroControllerScopeNone(@Builder.Parameter WidgetI child) {
    int id = factories.heroControllerScopeNone(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget HeroControllerScope");
    return new HeroControllerScope(id);
  }
  public static HeroControllerScopeNoneBuilder none(WidgetI child) {
    return HeroControllerScopeNoneBuilder.heroControllerScopeNone(child);
  }
  @Override
  public HeroControllerScope build() {
    return this;
  }
}
