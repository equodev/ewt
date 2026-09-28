package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuButtonTheme extends InheritedTheme implements MenuButtonThemeI {
  protected MenuButtonTheme() {}
  MenuButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuButtonTheme menuButtonThemeMenuButtonTheme(@Builder.Parameter MenuButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.menuButtonThemeMenuButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonTheme");
    return new MenuButtonTheme(id);
  }
  public static MenuButtonThemeMenuButtonThemeBuilder menuButtonTheme(MenuButtonThemeDataI data, WidgetI child) {
    return MenuButtonThemeMenuButtonThemeBuilder.menuButtonThemeMenuButtonTheme(data, child);
  }
  public static MenuButtonThemeData of(BuildContextI context) {
    int id = factories.menuButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    return new MenuButtonThemeData(id);
  }
  public MenuButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("menuButtonThemeData", getId());
      return new MenuButtonThemeData(__nid);
    }
    return factories.MenuButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public MenuButtonTheme build() {
    return this;
  }
}
