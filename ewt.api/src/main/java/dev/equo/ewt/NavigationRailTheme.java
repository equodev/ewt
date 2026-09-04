package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationRailThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationRailTheme extends InheritedTheme implements NavigationRailThemeI {
  private MemorySegment st;
  protected NavigationRailTheme() {}
  NavigationRailTheme(MemorySegment st) {
    this.id = NavigationRailThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailTheme");
    System.out.println("New NavigationRailTheme id:"+id);
  }
  NavigationRailTheme(int id) { this.id = id; }
  @Builder.Factory
  static NavigationRailTheme navigationRailThemeNavigationRailTheme(@Builder.Parameter NavigationRailThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.navigationRailThemeNavigationRailTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget NavigationRailTheme");
    return new NavigationRailTheme(st);
  }
  public static NavigationRailThemeNavigationRailThemeBuilder navigationRailTheme(NavigationRailThemeDataI data, WidgetI child) {
    return NavigationRailThemeNavigationRailThemeBuilder.navigationRailThemeNavigationRailTheme(data, child);
  }
  public static NavigationRailThemeData of(BuildContextI context) {
    var st = factories.navigationRailThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    return new NavigationRailThemeData(st);
  }
  public NavigationRailThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.NavigationRailThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.NavigationRailThemeDataObjSt.id(__st, __nid);
      return new NavigationRailThemeData(__st);
    }
    return new NavigationRailThemeData(NavigationRailThemeObjSt.data(st));
  }
  @Override
  public NavigationRailTheme build() {
    return this;
  }
}
