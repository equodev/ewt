package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FloatingActionButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FloatingActionButtonTheme extends InheritedTheme implements FloatingActionButtonThemeI {
  private MemorySegment st;
  protected FloatingActionButtonTheme() {}
  FloatingActionButtonTheme(MemorySegment st) {
    this.id = FloatingActionButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonTheme");
    System.out.println("New FloatingActionButtonTheme id:"+id);
  }
  FloatingActionButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static FloatingActionButtonTheme floatingActionButtonThemeFloatingActionButtonTheme(@Builder.Parameter FloatingActionButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.floatingActionButtonThemeFloatingActionButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButtonTheme");
    return new FloatingActionButtonTheme(st);
  }
  public static FloatingActionButtonThemeFloatingActionButtonThemeBuilder floatingActionButtonTheme(FloatingActionButtonThemeDataI data, WidgetI child) {
    return FloatingActionButtonThemeFloatingActionButtonThemeBuilder.floatingActionButtonThemeFloatingActionButtonTheme(data, child);
  }
  public static FloatingActionButtonThemeData of(BuildContextI context) {
    var st = factories.floatingActionButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    return new FloatingActionButtonThemeData(st);
  }
  public FloatingActionButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.FloatingActionButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.FloatingActionButtonThemeDataObjSt.id(__st, __nid);
      return new FloatingActionButtonThemeData(__st);
    }
    return new FloatingActionButtonThemeData(FloatingActionButtonThemeObjSt.data(st));
  }
  @Override
  public FloatingActionButtonTheme build() {
    return this;
  }
}
