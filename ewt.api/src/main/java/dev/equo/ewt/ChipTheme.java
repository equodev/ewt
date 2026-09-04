package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ChipThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ChipTheme extends InheritedTheme implements ChipThemeI {
  private MemorySegment st;
  protected ChipTheme() {}
  ChipTheme(MemorySegment st) {
    this.id = ChipThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipTheme");
    System.out.println("New ChipTheme id:"+id);
  }
  ChipTheme(int id) { this.id = id; }
  @Builder.Factory
  static ChipTheme chipThemeChipTheme(@Builder.Parameter ChipThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.chipThemeChipTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ChipTheme");
    return new ChipTheme(st);
  }
  public static ChipThemeChipThemeBuilder chipTheme(ChipThemeDataI data, WidgetI child) {
    return ChipThemeChipThemeBuilder.chipThemeChipTheme(data, child);
  }
  public static ChipThemeData of(BuildContextI context) {
    var st = factories.chipThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(st);
  }
  public ChipThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ChipThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ChipThemeDataObjSt.id(__st, __nid);
      return new ChipThemeData(__st);
    }
    return new ChipThemeData(ChipThemeObjSt.data(st));
  }
  @Override
  public ChipTheme build() {
    return this;
  }
}
