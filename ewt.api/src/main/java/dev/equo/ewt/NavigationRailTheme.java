package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationRailTheme extends InheritedTheme implements NavigationRailThemeI {
  protected NavigationRailTheme() {}
  NavigationRailTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationRailTheme navigationRailThemeNavigationRailTheme(@Builder.Parameter NavigationRailThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.navigationRailThemeNavigationRailTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailTheme");
    return new NavigationRailTheme(id);
  }
  public static NavigationRailThemeNavigationRailThemeBuilder navigationRailTheme(NavigationRailThemeDataI data, WidgetI child) {
    return NavigationRailThemeNavigationRailThemeBuilder.navigationRailThemeNavigationRailTheme(data, child);
  }
  public static NavigationRailThemeData of(BuildContextI context) {
    int id = factories.navigationRailThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    return new NavigationRailThemeData(id);
  }
  public NavigationRailThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeData", getId());
      return new NavigationRailThemeData(__nid);
    }
    return factories.NavigationRailTheme_readBack_data(nativeStruct);
  }
  @Override
  public NavigationRailTheme build() {
    return this;
  }
}
