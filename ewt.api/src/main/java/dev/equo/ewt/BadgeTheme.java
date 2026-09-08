package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BadgeThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BadgeTheme extends InheritedTheme implements BadgeThemeI {
  private MemorySegment st;
  protected BadgeTheme() {}
  BadgeTheme(MemorySegment st) {
    this.id = BadgeThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeTheme");
    System.out.println("New BadgeTheme id:"+id);
  }
  BadgeTheme(int id) { this.id = id; }
  @Builder.Factory
  static BadgeTheme badgeThemeBadgeTheme(@Builder.Parameter BadgeThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.badgeThemeBadgeTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget BadgeTheme");
    return new BadgeTheme(st);
  }
  public static BadgeThemeBadgeThemeBuilder badgeTheme(BadgeThemeDataI data, WidgetI child) {
    return BadgeThemeBadgeThemeBuilder.badgeThemeBadgeTheme(data, child);
  }
  public static BadgeThemeData of(BuildContextI context) {
    var st = factories.badgeThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget BadgeThemeData");
    return new BadgeThemeData(st);
  }
  public BadgeThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BadgeThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BadgeThemeDataObjSt.id(__st, __nid);
      return new BadgeThemeData(__st);
    }
    return new BadgeThemeData(BadgeThemeObjSt.data(st));
  }
  @Override
  public BadgeTheme build() {
    return this;
  }
}
