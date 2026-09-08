package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TableRowObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TableRow extends NativeObj.Base implements TableRowI {
  private MemorySegment st;
  protected TableRow() {}
  TableRow(MemorySegment st) {
    this.id = TableRowObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TableRow");
    System.out.println("New TableRow id:"+id);
  }
  TableRow(int id) { this.id = id; }
  @Builder.Factory
  static TableRow tableRowTableRow(Optional<DecorationI> decoration, Optional<List<WidgetI>> children) {
    var st = factories.tableRowTableRow(decoration.map(DecorationI::build),
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget TableRow");
    return new TableRow(st);
  }
  public static TableRowTableRowBuilder tableRow() {
    return TableRowTableRowBuilder.tableRowTableRow();
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tableRowDecoration not supported on web");
    return new Decoration(TableRowObjSt.decoration(st)) {};
  }
  @Override
  public TableRow build() {
    return this;
  }
}
