package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationDrawerTheme extends InheritedTheme implements NavigationDrawerThemeI {
  protected NavigationDrawerTheme() {}
  NavigationDrawerTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationDrawerTheme navigationDrawerThemeNavigationDrawerTheme(@Builder.Parameter NavigationDrawerThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.navigationDrawerThemeNavigationDrawerTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerTheme");
    return new NavigationDrawerTheme(id);
  }
  public static NavigationDrawerThemeNavigationDrawerThemeBuilder navigationDrawerTheme(NavigationDrawerThemeDataI data, WidgetI child) {
    return NavigationDrawerThemeNavigationDrawerThemeBuilder.navigationDrawerThemeNavigationDrawerTheme(data, child);
  }
  public static NavigationDrawerThemeData of(BuildContextI context) {
    int id = factories.navigationDrawerThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    return new NavigationDrawerThemeData(id);
  }
  public NavigationDrawerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeData", getId());
      return new NavigationDrawerThemeData(__nid);
    }
    return factories.NavigationDrawerTheme_readBack_data(nativeStruct);
  }
  @Override
  public NavigationDrawerTheme build() {
    return this;
  }
}
