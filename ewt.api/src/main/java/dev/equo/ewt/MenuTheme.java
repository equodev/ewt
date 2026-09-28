package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuTheme extends InheritedTheme implements MenuThemeI {
  protected MenuTheme() {}
  MenuTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuTheme menuThemeMenuTheme(@Builder.Parameter MenuThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.menuThemeMenuTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuTheme");
    return new MenuTheme(id);
  }
  public static MenuThemeMenuThemeBuilder menuTheme(MenuThemeDataI data, WidgetI child) {
    return MenuThemeMenuThemeBuilder.menuThemeMenuTheme(data, child);
  }
  public static MenuThemeData of(BuildContextI context) {
    int id = factories.menuThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuThemeData");
    return new MenuThemeData(id);
  }
  public MenuThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("menuThemeData", getId());
      return new MenuThemeData(__nid);
    }
    return factories.MenuTheme_readBack_data(nativeStruct);
  }
  @Override
  public MenuTheme build() {
    return this;
  }
}
