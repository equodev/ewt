package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DataTableThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DataTableTheme extends InheritedWidget implements DataTableThemeI {
  private MemorySegment st;
  protected DataTableTheme() {}
  DataTableTheme(MemorySegment st) {
    this.id = DataTableThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableTheme");
    System.out.println("New DataTableTheme id:"+id);
  }
  DataTableTheme(int id) { this.id = id; }
  @Builder.Factory
  static DataTableTheme dataTableThemeDataTableTheme(@Builder.Parameter DataTableThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.dataTableThemeDataTableTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DataTableTheme");
    return new DataTableTheme(st);
  }
  public static DataTableThemeDataTableThemeBuilder dataTableTheme(DataTableThemeDataI data, WidgetI child) {
    return DataTableThemeDataTableThemeBuilder.dataTableThemeDataTableTheme(data, child);
  }
  public static DataTableThemeData of(BuildContextI context) {
    var st = factories.dataTableThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DataTableThemeData");
    return new DataTableThemeData(st);
  }
  public DataTableThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.DataTableThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.DataTableThemeDataObjSt.id(__st, __nid);
      return new DataTableThemeData(__st);
    }
    return new DataTableThemeData(DataTableThemeObjSt.data(st));
  }
  @Override
  public DataTableTheme build() {
    return this;
  }
}
