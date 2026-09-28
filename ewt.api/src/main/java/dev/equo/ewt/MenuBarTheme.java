package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuBarTheme extends InheritedTheme implements MenuBarThemeI {
  protected MenuBarTheme() {}
  MenuBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuBarTheme menuBarThemeMenuBarTheme(@Builder.Parameter MenuBarThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.menuBarThemeMenuBarTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarTheme");
    return new MenuBarTheme(id);
  }
  public static MenuBarThemeMenuBarThemeBuilder menuBarTheme(MenuBarThemeDataI data, WidgetI child) {
    return MenuBarThemeMenuBarThemeBuilder.menuBarThemeMenuBarTheme(data, child);
  }
  public static MenuBarThemeData of(BuildContextI context) {
    int id = factories.menuBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    return new MenuBarThemeData(id);
  }
  public MenuBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("menuBarThemeData", getId());
      return new MenuBarThemeData(__nid);
    }
    return factories.MenuBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public MenuBarTheme build() {
    return this;
  }
}
