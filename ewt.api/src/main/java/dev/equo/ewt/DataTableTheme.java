package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DataTableTheme extends InheritedWidget implements DataTableThemeI {
  protected DataTableTheme() {}
  DataTableTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DataTableTheme dataTableThemeDataTableTheme(@Builder.Parameter DataTableThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.dataTableThemeDataTableTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableTheme");
    return new DataTableTheme(id);
  }
  public static DataTableThemeDataTableThemeBuilder dataTableTheme(DataTableThemeDataI data, WidgetI child) {
    return DataTableThemeDataTableThemeBuilder.dataTableThemeDataTableTheme(data, child);
  }
  public static DataTableThemeData of(BuildContextI context) {
    int id = factories.dataTableThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableThemeData");
    return new DataTableThemeData(id);
  }
  public DataTableThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableThemeData", getId());
      return new DataTableThemeData(__nid);
    }
    return factories.DataTableTheme_readBack_data(nativeStruct);
  }
  @Override
  public DataTableTheme build() {
    return this;
  }
}
