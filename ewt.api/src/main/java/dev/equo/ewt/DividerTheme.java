package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DividerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DividerTheme extends InheritedTheme implements DividerThemeI {
  private MemorySegment st;
  protected DividerTheme() {}
  DividerTheme(MemorySegment st) {
    this.id = DividerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerTheme");
    System.out.println("New DividerTheme id:"+id);
  }
  DividerTheme(int id) { this.id = id; }
  @Builder.Factory
  static DividerTheme dividerThemeDividerTheme(@Builder.Parameter DividerThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.dividerThemeDividerTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DividerTheme");
    return new DividerTheme(st);
  }
  public static DividerThemeDividerThemeBuilder dividerTheme(DividerThemeDataI data, WidgetI child) {
    return DividerThemeDividerThemeBuilder.dividerThemeDividerTheme(data, child);
  }
  public static DividerThemeData of(BuildContextI context) {
    var st = factories.dividerThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DividerThemeData");
    return new DividerThemeData(st);
  }
  public DividerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dividerThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.DividerThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.DividerThemeDataObjSt.id(__st, __nid);
      return new DividerThemeData(__st);
    }
    return new DividerThemeData(DividerThemeObjSt.data(st));
  }
  @Override
  public DividerTheme build() {
    return this;
  }
}
