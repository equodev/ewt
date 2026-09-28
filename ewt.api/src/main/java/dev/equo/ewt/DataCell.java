package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DataCell extends NativeObj.Base implements DataCellI {
  protected DataCell() {}
  DataCell(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataCell");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DataCell dataCellDataCell(@Builder.Parameter WidgetI child, Optional<Boolean> placeholder, Optional<Boolean> showEditIcon, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Runnable> onDoubleTap, Optional<Runnable> onTapCancel) {
    int id = factories.dataCellDataCell(child.build(),
      placeholder,
      showEditIcon,
      onTap,
      onLongPress,
      onTapDown,
      onDoubleTap,
      onTapCancel);
    if (id <= 0) throw new RuntimeException("Failed to created widget DataCell");
    return new DataCell(id);
  }
  public static DataCellDataCellBuilder dataCell(WidgetI child) {
    return DataCellDataCellBuilder.dataCellDataCell(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataCellChild not supported on web");
    return factories.DataCell_readBack_child(nativeStruct);
  }
  public boolean placeholder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataCellPlaceholder not supported on web");
    return factories.DataCell_readBack_placeholder(nativeStruct);
  }
  public boolean showEditIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataCellShowEditIcon not supported on web");
    return factories.DataCell_readBack_showEditIcon(nativeStruct);
  }
  public static DataCell empty() {
    return DataCell.dataCell(SizedBox.shrink().build()).build();
  }
  @Override
  public DataCell build() {
    return this;
  }
}
