package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuThemeData extends NativeObj.Base implements MenuThemeDataI {
  protected MenuThemeData() {}
  MenuThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuThemeData menuThemeDataMenuThemeData(Optional<WidgetI> submenuIcon) {
    int id = factories.menuThemeDataMenuThemeData(submenuIcon.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuThemeData");
    return new MenuThemeData(id);
  }
  public static MenuThemeDataMenuThemeDataBuilder menuThemeData() {
    return MenuThemeDataMenuThemeDataBuilder.menuThemeDataMenuThemeData();
  }
  public static MenuThemeData lerp(MenuThemeDataI a, MenuThemeDataI b, double t) {
    int id = factories.menuThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuThemeData");
    return new MenuThemeData(id);
  }
  @Override
  public MenuThemeData build() {
    return this;
  }
}
