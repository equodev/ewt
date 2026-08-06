package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DataCellObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DataCell extends NativeObj.Base implements DataCellI {
  private MemorySegment st;
  protected DataCell() {}
  DataCell(MemorySegment st) {
    this.id = DataCellObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataCell");
    System.out.println("New DataCell id:"+id);
  }
  DataCell(int id) { this.id = id; }
  @Builder.Factory
  static DataCell dataCellDataCell(@Builder.Parameter WidgetI child, Optional<Boolean> placeholder, Optional<Boolean> showEditIcon, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Runnable> onDoubleTap, Optional<Runnable> onTapCancel) {
    var st = factories.dataCellDataCell(child.build(),
      placeholder,
      showEditIcon,
      onTap,
      onLongPress,
      onDoubleTap,
      onTapCancel);
    if (st == null) throw new RuntimeException("Failed to created widget DataCell");
    return new DataCell(st);
  }
  public static DataCellDataCellBuilder dataCell(WidgetI child) {
    return DataCellDataCellBuilder.dataCellDataCell(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataCellChild not supported on web");
    return new Widget(DataCellObjSt.child(st)) {};
  }
  public boolean placeholder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataCellPlaceholder not supported on web");
    return intToBool(DataCellObjSt.placeholder(st));
  }
  public boolean showEditIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataCellShowEditIcon not supported on web");
    return intToBool(DataCellObjSt.showEditIcon(st));
  }
  public static DataCell empty() {
    return DataCell.dataCell(SizedBox.shrink().build()).build();
  }
  @Override
  public DataCell build() {
    return this;
  }
}
