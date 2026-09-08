package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TableCellObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TableCell extends StatelessWidget implements TableCellI {
  private MemorySegment st;
  protected TableCell() {}
  TableCell(MemorySegment st) {
    this.id = TableCellObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TableCell");
    System.out.println("New TableCell id:"+id);
  }
  TableCell(int id) { this.id = id; }
  @Builder.Factory
  static TableCell tableCellTableCell(Optional<TableCellVerticalAlignment> verticalAlignment, WidgetI child) {
    var st = factories.tableCellTableCell(verticalAlignment,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TableCell");
    return new TableCell(st);
  }
  public static TableCellTableCellBuilder tableCell() {
    return TableCellTableCellBuilder.tableCellTableCell();
  }
  public TableCellVerticalAlignment verticalAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tableCellVerticalAlignment not supported on web");
    return TableCellVerticalAlignment.values()[TableCellObjSt.verticalAlignment(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tableCellChild not supported on web");
    return new Widget(TableCellObjSt.child(st)) {};
  }
  @Override
  public TableCell build() {
    return this;
  }
}
