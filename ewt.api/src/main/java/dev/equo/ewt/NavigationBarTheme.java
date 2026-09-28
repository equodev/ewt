package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationBarTheme extends InheritedTheme implements NavigationBarThemeI {
  protected NavigationBarTheme() {}
  NavigationBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationBarTheme navigationBarThemeNavigationBarTheme(@Builder.Parameter NavigationBarThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.navigationBarThemeNavigationBarTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarTheme");
    return new NavigationBarTheme(id);
  }
  public static NavigationBarThemeNavigationBarThemeBuilder navigationBarTheme(NavigationBarThemeDataI data, WidgetI child) {
    return NavigationBarThemeNavigationBarThemeBuilder.navigationBarThemeNavigationBarTheme(data, child);
  }
  public static NavigationBarThemeData of(BuildContextI context) {
    int id = factories.navigationBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    return new NavigationBarThemeData(id);
  }
  public NavigationBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeData", getId());
      return new NavigationBarThemeData(__nid);
    }
    return factories.NavigationBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public NavigationBarTheme build() {
    return this;
  }
}
