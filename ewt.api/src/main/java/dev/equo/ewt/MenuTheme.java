package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuTheme extends InheritedTheme implements MenuThemeI {
  private MemorySegment st;
  protected MenuTheme() {}
  MenuTheme(MemorySegment st) {
    this.id = MenuThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuTheme");
    System.out.println("New MenuTheme id:"+id);
  }
  MenuTheme(int id) { this.id = id; }
  @Builder.Factory
  static MenuTheme menuThemeMenuTheme(@Builder.Parameter MenuThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.menuThemeMenuTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget MenuTheme");
    return new MenuTheme(st);
  }
  public static MenuThemeMenuThemeBuilder menuTheme(MenuThemeDataI data, WidgetI child) {
    return MenuThemeMenuThemeBuilder.menuThemeMenuTheme(data, child);
  }
  public static MenuThemeData of(BuildContextI context) {
    var st = factories.menuThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget MenuThemeData");
    return new MenuThemeData(st);
  }
  public MenuThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("menuThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.MenuThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.MenuThemeDataObjSt.id(__st, __nid);
      return new MenuThemeData(__st);
    }
    return new MenuThemeData(MenuThemeObjSt.data(st));
  }
  @Override
  public MenuTheme build() {
    return this;
  }
}
