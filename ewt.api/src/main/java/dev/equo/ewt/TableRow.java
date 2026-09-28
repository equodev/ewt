package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TableRow extends NativeObj.Base implements TableRowI {
  protected TableRow() {}
  TableRow(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TableRow");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TableRow tableRowTableRow(Optional<DecorationI> decoration, Optional<List<WidgetI>> children) {
    int id = factories.tableRowTableRow(decoration.map(DecorationI::build),
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget TableRow");
    return new TableRow(id);
  }
  public static TableRowTableRowBuilder tableRow() {
    return TableRowTableRowBuilder.tableRowTableRow();
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tableRowDecoration not supported on web");
    return factories.TableRow_readBack_decoration(nativeStruct);
  }
  @Override
  public TableRow build() {
    return this;
  }
}
