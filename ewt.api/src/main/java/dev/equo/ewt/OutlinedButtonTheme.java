package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OutlinedButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OutlinedButtonTheme extends InheritedTheme implements OutlinedButtonThemeI {
  private MemorySegment st;
  protected OutlinedButtonTheme() {}
  OutlinedButtonTheme(MemorySegment st) {
    this.id = OutlinedButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonTheme");
    System.out.println("New OutlinedButtonTheme id:"+id);
  }
  OutlinedButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static OutlinedButtonTheme outlinedButtonThemeOutlinedButtonTheme(@Builder.Parameter OutlinedButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.outlinedButtonThemeOutlinedButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget OutlinedButtonTheme");
    return new OutlinedButtonTheme(st);
  }
  public static OutlinedButtonThemeOutlinedButtonThemeBuilder outlinedButtonTheme(OutlinedButtonThemeDataI data, WidgetI child) {
    return OutlinedButtonThemeOutlinedButtonThemeBuilder.outlinedButtonThemeOutlinedButtonTheme(data, child);
  }
  public static OutlinedButtonThemeData of(BuildContextI context) {
    var st = factories.outlinedButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    return new OutlinedButtonThemeData(st);
  }
  public OutlinedButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("outlinedButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.OutlinedButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.OutlinedButtonThemeDataObjSt.id(__st, __nid);
      return new OutlinedButtonThemeData(__st);
    }
    return new OutlinedButtonThemeData(OutlinedButtonThemeObjSt.data(st));
  }
  @Override
  public OutlinedButtonTheme build() {
    return this;
  }
}
