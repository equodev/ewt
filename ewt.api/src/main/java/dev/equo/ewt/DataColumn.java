package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DataColumnObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DataColumn extends NativeObj.Base implements DataColumnI {
  private MemorySegment st;
  protected DataColumn() {}
  DataColumn(MemorySegment st) {
    this.id = DataColumnObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataColumn");
    System.out.println("New DataColumn id:"+id);
  }
  DataColumn(int id) { this.id = id; }
  @Builder.Factory
  static DataColumn dataColumnDataColumn(@Builder.Parameter WidgetI label, Optional<String> tooltip, Optional<Boolean> numeric, Optional<BiConsumer<Integer, Boolean>> onSort, Optional<MainAxisAlignment> headingRowAlignment) {
    var st = factories.dataColumnDataColumn(label.build(),
      tooltip,
      numeric,
      onSort,
      headingRowAlignment);
    if (st == null) throw new RuntimeException("Failed to created widget DataColumn");
    return new DataColumn(st);
  }
  public static DataColumnDataColumnBuilder dataColumn(WidgetI label) {
    return DataColumnDataColumnBuilder.dataColumnDataColumn(label);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnLabel not supported on web");
    return new Widget(DataColumnObjSt.label(st)) {};
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnTooltip not supported on web");
    return DataColumnObjSt.tooltip(st).getString(0);
  }
  public boolean numeric() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnNumeric not supported on web");
    return intToBool(DataColumnObjSt.numeric(st));
  }
  public MainAxisAlignment headingRowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataColumnHeadingRowAlignment not supported on web");
    return MainAxisAlignment.values()[DataColumnObjSt.headingRowAlignment(st)];
  }
  @Override
  public DataColumn build() {
    return this;
  }
}
