package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationDrawerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationDrawerTheme extends InheritedTheme implements NavigationDrawerThemeI {
  private MemorySegment st;
  protected NavigationDrawerTheme() {}
  NavigationDrawerTheme(MemorySegment st) {
    this.id = NavigationDrawerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerTheme");
    System.out.println("New NavigationDrawerTheme id:"+id);
  }
  NavigationDrawerTheme(int id) { this.id = id; }
  @Builder.Factory
  static NavigationDrawerTheme navigationDrawerThemeNavigationDrawerTheme(@Builder.Parameter NavigationDrawerThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.navigationDrawerThemeNavigationDrawerTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget NavigationDrawerTheme");
    return new NavigationDrawerTheme(st);
  }
  public static NavigationDrawerThemeNavigationDrawerThemeBuilder navigationDrawerTheme(NavigationDrawerThemeDataI data, WidgetI child) {
    return NavigationDrawerThemeNavigationDrawerThemeBuilder.navigationDrawerThemeNavigationDrawerTheme(data, child);
  }
  public static NavigationDrawerThemeData of(BuildContextI context) {
    var st = factories.navigationDrawerThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget NavigationDrawerThemeData");
    return new NavigationDrawerThemeData(st);
  }
  public NavigationDrawerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.NavigationDrawerThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.NavigationDrawerThemeDataObjSt.id(__st, __nid);
      return new NavigationDrawerThemeData(__st);
    }
    return new NavigationDrawerThemeData(NavigationDrawerThemeObjSt.data(st));
  }
  @Override
  public NavigationDrawerTheme build() {
    return this;
  }
}
