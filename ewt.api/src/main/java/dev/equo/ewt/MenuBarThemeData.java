package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuBarThemeData extends MenuThemeData implements MenuBarThemeDataI {
  protected MenuBarThemeData() {}
  MenuBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuBarThemeData menuBarThemeDataMenuBarThemeData() {
    int id = factories.menuBarThemeDataMenuBarThemeData();
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    return new MenuBarThemeData(id);
  }
  public static MenuBarThemeDataMenuBarThemeDataBuilder menuBarThemeData() {
    return MenuBarThemeDataMenuBarThemeDataBuilder.menuBarThemeDataMenuBarThemeData();
  }
  public static MenuBarThemeData lerp(MenuBarThemeDataI a, MenuBarThemeDataI b, double t) {
    int id = factories.menuBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    return new MenuBarThemeData(id);
  }
  @Override
  public MenuBarThemeData build() {
    return this;
  }
}
