package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuBarTheme extends InheritedTheme implements MenuBarThemeI {
  private MemorySegment st;
  protected MenuBarTheme() {}
  MenuBarTheme(MemorySegment st) {
    this.id = MenuBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarTheme");
    System.out.println("New MenuBarTheme id:"+id);
  }
  MenuBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static MenuBarTheme menuBarThemeMenuBarTheme(@Builder.Parameter MenuBarThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.menuBarThemeMenuBarTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget MenuBarTheme");
    return new MenuBarTheme(st);
  }
  public static MenuBarThemeMenuBarThemeBuilder menuBarTheme(MenuBarThemeDataI data, WidgetI child) {
    return MenuBarThemeMenuBarThemeBuilder.menuBarThemeMenuBarTheme(data, child);
  }
  public static MenuBarThemeData of(BuildContextI context) {
    var st = factories.menuBarThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget MenuBarThemeData");
    return new MenuBarThemeData(st);
  }
  public MenuBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("menuBarThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.MenuBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.MenuBarThemeDataObjSt.id(__st, __nid);
      return new MenuBarThemeData(__st);
    }
    return new MenuBarThemeData(MenuBarThemeObjSt.data(st));
  }
  @Override
  public MenuBarTheme build() {
    return this;
  }
}
