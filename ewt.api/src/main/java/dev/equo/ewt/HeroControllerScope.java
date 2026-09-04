package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.HeroControllerScopeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class HeroControllerScope extends InheritedWidget implements HeroControllerScopeI {
  private MemorySegment st;
  protected HeroControllerScope() {}
  HeroControllerScope(MemorySegment st) {
    this.id = HeroControllerScopeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget HeroControllerScope");
    System.out.println("New HeroControllerScope id:"+id);
  }
  HeroControllerScope(int id) { this.id = id; }
  @Builder.Factory
  static HeroControllerScope heroControllerScopeNone(@Builder.Parameter WidgetI child) {
    var st = factories.heroControllerScopeNone(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget HeroControllerScope");
    return new HeroControllerScope(st);
  }
  public static HeroControllerScopeNoneBuilder none(WidgetI child) {
    return HeroControllerScopeNoneBuilder.heroControllerScopeNone(child);
  }
  @Override
  public HeroControllerScope build() {
    return this;
  }
}
