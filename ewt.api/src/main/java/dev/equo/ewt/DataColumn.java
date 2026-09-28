package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DataColumn extends NativeObj.Base implements DataColumnI {
  protected DataColumn() {}
  DataColumn(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataColumn");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DataColumn dataColumnDataColumn(@Builder.Parameter WidgetI label, Optional<String> tooltip, Optional<Boolean> numeric, Optional<BiConsumer<Integer, Boolean>> onSort, Optional<MainAxisAlignment> headingRowAlignment) {
    int id = factories.dataColumnDataColumn(label.build(),
      tooltip,
      numeric,
      onSort,
      headingRowAlignment);
    if (id <= 0) throw new RuntimeException("Failed to created widget DataColumn");
    return new DataColumn(id);
  }
  public static DataColumnDataColumnBuilder dataColumn(WidgetI label) {
    return DataColumnDataColumnBuilder.dataColumnDataColumn(label);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnLabel not supported on web");
    return factories.DataColumn_readBack_label(nativeStruct);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnTooltip not supported on web");
    return factories.DataColumn_readBack_tooltip(nativeStruct);
  }
  public boolean numeric() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnNumeric not supported on web");
    return factories.DataColumn_readBack_numeric(nativeStruct);
  }
  public MainAxisAlignment headingRowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnHeadingRowAlignment not supported on web");
    return factories.DataColumn_readBack_headingRowAlignment(nativeStruct);
  }
  @Override
  public DataColumn build() {
    return this;
  }
}
