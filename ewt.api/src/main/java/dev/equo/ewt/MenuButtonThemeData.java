package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuButtonThemeData extends NativeObj.Base implements MenuButtonThemeDataI {
  protected MenuButtonThemeData() {}
  MenuButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuButtonThemeData menuButtonThemeDataMenuButtonThemeData() {
    int id = factories.menuButtonThemeDataMenuButtonThemeData();
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    return new MenuButtonThemeData(id);
  }
  public static MenuButtonThemeDataMenuButtonThemeDataBuilder menuButtonThemeData() {
    return MenuButtonThemeDataMenuButtonThemeDataBuilder.menuButtonThemeDataMenuButtonThemeData();
  }
  public static MenuButtonThemeData lerp(MenuButtonThemeDataI a, MenuButtonThemeDataI b, double t) {
    int id = factories.menuButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    return new MenuButtonThemeData(id);
  }
  @Override
  public MenuButtonThemeData build() {
    return this;
  }
}
