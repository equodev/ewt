package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BadgeTheme extends InheritedTheme implements BadgeThemeI {
  protected BadgeTheme() {}
  BadgeTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BadgeTheme badgeThemeBadgeTheme(@Builder.Parameter BadgeThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.badgeThemeBadgeTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeTheme");
    return new BadgeTheme(id);
  }
  public static BadgeThemeBadgeThemeBuilder badgeTheme(BadgeThemeDataI data, WidgetI child) {
    return BadgeThemeBadgeThemeBuilder.badgeThemeBadgeTheme(data, child);
  }
  public static BadgeThemeData of(BuildContextI context) {
    int id = factories.badgeThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeThemeData");
    return new BadgeThemeData(id);
  }
  public BadgeThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeData", getId());
      return new BadgeThemeData(__nid);
    }
    return factories.BadgeTheme_readBack_data(nativeStruct);
  }
  @Override
  public BadgeTheme build() {
    return this;
  }
}
