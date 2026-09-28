package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TableCell extends StatelessWidget implements TableCellI {
  protected TableCell() {}
  TableCell(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TableCell");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TableCell tableCellTableCell(Optional<TableCellVerticalAlignment> verticalAlignment, WidgetI child) {
    int id = factories.tableCellTableCell(verticalAlignment,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TableCell");
    return new TableCell(id);
  }
  public static TableCellTableCellBuilder tableCell() {
    return TableCellTableCellBuilder.tableCellTableCell();
  }
  public TableCellVerticalAlignment verticalAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tableCellVerticalAlignment not supported on web");
    return factories.TableCell_readBack_verticalAlignment(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tableCellChild not supported on web");
    return factories.TableCell_readBack_child(nativeStruct);
  }
  @Override
  public TableCell build() {
    return this;
  }
}
