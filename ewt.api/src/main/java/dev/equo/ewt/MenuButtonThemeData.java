package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuButtonThemeData extends NativeObj.Base implements MenuButtonThemeDataI {
  private MemorySegment st;
  protected MenuButtonThemeData() {}
  MenuButtonThemeData(MemorySegment st) {
    this.id = MenuButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    System.out.println("New MenuButtonThemeData id:"+id);
  }
  MenuButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static MenuButtonThemeData menuButtonThemeDataMenuButtonThemeData() {
    var st = factories.menuButtonThemeDataMenuButtonThemeData();
    if (st == null) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    return new MenuButtonThemeData(st);
  }
  public static MenuButtonThemeDataMenuButtonThemeDataBuilder menuButtonThemeData() {
    return MenuButtonThemeDataMenuButtonThemeDataBuilder.menuButtonThemeDataMenuButtonThemeData();
  }
  public static MenuButtonThemeData lerp(MenuButtonThemeDataI a, MenuButtonThemeDataI b, double t) {
    var st = factories.menuButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    return new MenuButtonThemeData(st);
  }
  @Override
  public MenuButtonThemeData build() {
    return this;
  }
}
