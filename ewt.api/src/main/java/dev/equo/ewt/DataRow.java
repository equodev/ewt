package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DataRowObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DataRow extends NativeObj.Base implements DataRowI {
  private MemorySegment st;
  protected DataRow() {}
  DataRow(MemorySegment st) {
    this.id = DataRowObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataRow");
    System.out.println("New DataRow id:"+id);
  }
  DataRow(int id) { this.id = id; }
  @Builder.Factory
  static DataRow dataRowDataRow(Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, List<DataCellI> cells) {
    var st = factories.dataRowDataRow(selected,
      onSelectChanged,
      onLongPress,
      cells.stream().map(DataCellI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget DataRow");
    return new DataRow(st);
  }
  public static DataRowDataRowBuilder dataRow() {
    return DataRowDataRowBuilder.dataRowDataRow();
  }
  @Builder.Factory
  static DataRow dataRowByIndex(OptionalInt index, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, List<DataCellI> cells) {
    var st = factories.dataRowByIndex(index,
      selected,
      onSelectChanged,
      onLongPress,
      cells.stream().map(DataCellI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget DataRow");
    return new DataRow(st);
  }
  public static DataRowByIndexBuilder byIndex() {
    return DataRowByIndexBuilder.dataRowByIndex();
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataRowSelected not supported on web");
    return intToBool(DataRowObjSt.selected(st));
  }
  @Override
  public DataRow build() {
    return this;
  }
}
