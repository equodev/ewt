package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ElevatedButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ElevatedButtonTheme extends InheritedTheme implements ElevatedButtonThemeI {
  private MemorySegment st;
  protected ElevatedButtonTheme() {}
  ElevatedButtonTheme(MemorySegment st) {
    this.id = ElevatedButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonTheme");
    System.out.println("New ElevatedButtonTheme id:"+id);
  }
  ElevatedButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static ElevatedButtonTheme elevatedButtonThemeElevatedButtonTheme(@Builder.Parameter ElevatedButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.elevatedButtonThemeElevatedButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ElevatedButtonTheme");
    return new ElevatedButtonTheme(st);
  }
  public static ElevatedButtonThemeElevatedButtonThemeBuilder elevatedButtonTheme(ElevatedButtonThemeDataI data, WidgetI child) {
    return ElevatedButtonThemeElevatedButtonThemeBuilder.elevatedButtonThemeElevatedButtonTheme(data, child);
  }
  public static ElevatedButtonThemeData of(BuildContextI context) {
    var st = factories.elevatedButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    return new ElevatedButtonThemeData(st);
  }
  public ElevatedButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("elevatedButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ElevatedButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ElevatedButtonThemeDataObjSt.id(__st, __nid);
      return new ElevatedButtonThemeData(__st);
    }
    return new ElevatedButtonThemeData(ElevatedButtonThemeObjSt.data(st));
  }
  @Override
  public ElevatedButtonTheme build() {
    return this;
  }
}
