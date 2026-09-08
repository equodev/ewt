package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomNavigationBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomNavigationBarTheme extends InheritedWidget implements BottomNavigationBarThemeI {
  private MemorySegment st;
  protected BottomNavigationBarTheme() {}
  BottomNavigationBarTheme(MemorySegment st) {
    this.id = BottomNavigationBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarTheme");
    System.out.println("New BottomNavigationBarTheme id:"+id);
  }
  BottomNavigationBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static BottomNavigationBarTheme bottomNavigationBarThemeBottomNavigationBarTheme(@Builder.Parameter BottomNavigationBarThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.bottomNavigationBarThemeBottomNavigationBarTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget BottomNavigationBarTheme");
    return new BottomNavigationBarTheme(st);
  }
  public static BottomNavigationBarThemeBottomNavigationBarThemeBuilder bottomNavigationBarTheme(BottomNavigationBarThemeDataI data, WidgetI child) {
    return BottomNavigationBarThemeBottomNavigationBarThemeBuilder.bottomNavigationBarThemeBottomNavigationBarTheme(data, child);
  }
  public static BottomNavigationBarThemeData of(BuildContextI context) {
    var st = factories.bottomNavigationBarThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    return new BottomNavigationBarThemeData(st);
  }
  public BottomNavigationBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BottomNavigationBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BottomNavigationBarThemeDataObjSt.id(__st, __nid);
      return new BottomNavigationBarThemeData(__st);
    }
    return new BottomNavigationBarThemeData(BottomNavigationBarThemeObjSt.data(st));
  }
  @Override
  public BottomNavigationBarTheme build() {
    return this;
  }
}
