package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuButtonTheme extends InheritedTheme implements MenuButtonThemeI {
  private MemorySegment st;
  protected MenuButtonTheme() {}
  MenuButtonTheme(MemorySegment st) {
    this.id = MenuButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonTheme");
    System.out.println("New MenuButtonTheme id:"+id);
  }
  MenuButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static MenuButtonTheme menuButtonThemeMenuButtonTheme(@Builder.Parameter MenuButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.menuButtonThemeMenuButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget MenuButtonTheme");
    return new MenuButtonTheme(st);
  }
  public static MenuButtonThemeMenuButtonThemeBuilder menuButtonTheme(MenuButtonThemeDataI data, WidgetI child) {
    return MenuButtonThemeMenuButtonThemeBuilder.menuButtonThemeMenuButtonTheme(data, child);
  }
  public static MenuButtonThemeData of(BuildContextI context) {
    var st = factories.menuButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget MenuButtonThemeData");
    return new MenuButtonThemeData(st);
  }
  public MenuButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("menuButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.MenuButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.MenuButtonThemeDataObjSt.id(__st, __nid);
      return new MenuButtonThemeData(__st);
    }
    return new MenuButtonThemeData(MenuButtonThemeObjSt.data(st));
  }
  @Override
  public MenuButtonTheme build() {
    return this;
  }
}
