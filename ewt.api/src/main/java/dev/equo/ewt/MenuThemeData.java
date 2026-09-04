package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuThemeData extends NativeObj.Base implements MenuThemeDataI {
  private MemorySegment st;
  protected MenuThemeData() {}
  MenuThemeData(MemorySegment st) {
    this.id = MenuThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuThemeData");
    System.out.println("New MenuThemeData id:"+id);
  }
  MenuThemeData(int id) { this.id = id; }
  @Builder.Factory
  static MenuThemeData menuThemeDataMenuThemeData(Optional<WidgetI> submenuIcon) {
    var st = factories.menuThemeDataMenuThemeData(submenuIcon.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget MenuThemeData");
    return new MenuThemeData(st);
  }
  public static MenuThemeDataMenuThemeDataBuilder menuThemeData() {
    return MenuThemeDataMenuThemeDataBuilder.menuThemeDataMenuThemeData();
  }
  public static MenuThemeData lerp(MenuThemeDataI a, MenuThemeDataI b, double t) {
    var st = factories.menuThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget MenuThemeData");
    return new MenuThemeData(st);
  }
  @Override
  public MenuThemeData build() {
    return this;
  }
}
