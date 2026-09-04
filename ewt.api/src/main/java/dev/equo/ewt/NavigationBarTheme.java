package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationBarTheme extends InheritedTheme implements NavigationBarThemeI {
  private MemorySegment st;
  protected NavigationBarTheme() {}
  NavigationBarTheme(MemorySegment st) {
    this.id = NavigationBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarTheme");
    System.out.println("New NavigationBarTheme id:"+id);
  }
  NavigationBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static NavigationBarTheme navigationBarThemeNavigationBarTheme(@Builder.Parameter NavigationBarThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.navigationBarThemeNavigationBarTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget NavigationBarTheme");
    return new NavigationBarTheme(st);
  }
  public static NavigationBarThemeNavigationBarThemeBuilder navigationBarTheme(NavigationBarThemeDataI data, WidgetI child) {
    return NavigationBarThemeNavigationBarThemeBuilder.navigationBarThemeNavigationBarTheme(data, child);
  }
  public static NavigationBarThemeData of(BuildContextI context) {
    var st = factories.navigationBarThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget NavigationBarThemeData");
    return new NavigationBarThemeData(st);
  }
  public NavigationBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationBarThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.NavigationBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.NavigationBarThemeDataObjSt.id(__st, __nid);
      return new NavigationBarThemeData(__st);
    }
    return new NavigationBarThemeData(NavigationBarThemeObjSt.data(st));
  }
  @Override
  public NavigationBarTheme build() {
    return this;
  }
}
