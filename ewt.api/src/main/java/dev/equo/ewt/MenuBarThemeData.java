package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuBarThemeData extends MenuThemeData implements MenuBarThemeDataI {
  private MemorySegment st;
  protected MenuBarThemeData() {}
  MenuBarThemeData(MemorySegment st) {
    this.id = MenuBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    System.out.println("New MenuBarThemeData id:"+id);
  }
  MenuBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static MenuBarThemeData menuBarThemeDataMenuBarThemeData() {
    var st = factories.menuBarThemeDataMenuBarThemeData();
    if (st == null) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    return new MenuBarThemeData(st);
  }
  public static MenuBarThemeDataMenuBarThemeDataBuilder menuBarThemeData() {
    return MenuBarThemeDataMenuBarThemeDataBuilder.menuBarThemeDataMenuBarThemeData();
  }
  public static MenuBarThemeData lerp(MenuBarThemeDataI a, MenuBarThemeDataI b, double t) {
    var st = factories.menuBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    return new MenuBarThemeData(st);
  }
  @Override
  public MenuBarThemeData build() {
    return this;
  }
}
