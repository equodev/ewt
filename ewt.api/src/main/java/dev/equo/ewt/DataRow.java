package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DataRow extends NativeObj.Base implements DataRowI {
  protected DataRow() {}
  DataRow(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataRow");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DataRow dataRowDataRow(Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<ColorI> color, List<DataCellI> cells) {
    int id = factories.dataRowDataRow(selected,
      onSelectChanged,
      onLongPress,
      onHover,
      color.map(ColorI::build),
      cells.stream().map(DataCellI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget DataRow");
    return new DataRow(id);
  }
  public static DataRowDataRowBuilder dataRow() {
    return DataRowDataRowBuilder.dataRowDataRow();
  }
  @Builder.Factory
  static DataRow dataRowByIndex(OptionalInt index, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<ColorI> color, List<DataCellI> cells) {
    int id = factories.dataRowByIndex(index,
      selected,
      onSelectChanged,
      onLongPress,
      onHover,
      color.map(ColorI::build),
      cells.stream().map(DataCellI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget DataRow");
    return new DataRow(id);
  }
  public static DataRowByIndexBuilder byIndex() {
    return DataRowByIndexBuilder.dataRowByIndex();
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataRowSelected not supported on web");
    return factories.DataRow_readBack_selected(nativeStruct);
  }
  @Override
  public DataRow build() {
    return this;
  }
}
