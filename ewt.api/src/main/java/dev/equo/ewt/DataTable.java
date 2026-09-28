package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DataTable extends StatelessWidget implements DataTableI {
  protected DataTable() {}
  DataTable(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTable");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DataTable dataTableDataTable(@Builder.Parameter List<DataColumnI> columns, OptionalInt sortColumnIndex, Optional<Boolean> sortAscending, Optional<Consumer<Boolean>> onSelectAll, Optional<DecorationI> decoration, Optional<ColorI> dataRowColor, OptionalDouble dataRowHeight, OptionalDouble dataRowMinHeight, OptionalDouble dataRowMaxHeight, Optional<TextStyleI> dataTextStyle, Optional<ColorI> headingRowColor, OptionalDouble headingRowHeight, Optional<TextStyleI> headingTextStyle, OptionalDouble horizontalMargin, OptionalDouble columnSpacing, Optional<Boolean> showCheckboxColumn, Optional<Boolean> showBottomBorder, OptionalDouble dividerThickness, List<DataRowI> rows, OptionalDouble checkboxHorizontalMargin, Optional<Clip> clipBehavior) {
    int id = factories.dataTableDataTable(columns.stream().map(DataColumnI::build).collect(java.util.stream.Collectors.toList()),
      sortColumnIndex,
      sortAscending,
      onSelectAll,
      decoration.map(DecorationI::build),
      dataRowColor.map(ColorI::build),
      dataRowHeight,
      dataRowMinHeight,
      dataRowMaxHeight,
      dataTextStyle.map(TextStyleI::build),
      headingRowColor.map(ColorI::build),
      headingRowHeight,
      headingTextStyle.map(TextStyleI::build),
      horizontalMargin,
      columnSpacing,
      showCheckboxColumn,
      showBottomBorder,
      dividerThickness,
      rows.stream().map(DataRowI::build).collect(java.util.stream.Collectors.toList()),
      checkboxHorizontalMargin,
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTable");
    return new DataTable(id);
  }
  public static DataTableDataTableBuilder dataTable(List<DataColumnI> columns) {
    return DataTableDataTableBuilder.dataTableDataTable(columns);
  }
  public int sortColumnIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableSortColumnIndex not supported on web");
    return factories.DataTable_readBack_sortColumnIndex(nativeStruct);
  }
  public boolean sortAscending() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableSortAscending not supported on web");
    return factories.DataTable_readBack_sortAscending(nativeStruct);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDecoration not supported on web");
    return factories.DataTable_readBack_decoration(nativeStruct);
  }
  public double dataRowMinHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDataRowMinHeight not supported on web");
    return factories.DataTable_readBack_dataRowMinHeight(nativeStruct);
  }
  public double dataRowMaxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDataRowMaxHeight not supported on web");
    return factories.DataTable_readBack_dataRowMaxHeight(nativeStruct);
  }
  public TextStyle dataTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DataTable_readBack_dataTextStyle(nativeStruct);
  }
  public double headingRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableHeadingRowHeight not supported on web");
    return factories.DataTable_readBack_headingRowHeight(nativeStruct);
  }
  public TextStyle headingTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableHeadingTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DataTable_readBack_headingTextStyle(nativeStruct);
  }
  public double horizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableHorizontalMargin not supported on web");
    return factories.DataTable_readBack_horizontalMargin(nativeStruct);
  }
  public double columnSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableColumnSpacing not supported on web");
    return factories.DataTable_readBack_columnSpacing(nativeStruct);
  }
  public boolean showCheckboxColumn() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableShowCheckboxColumn not supported on web");
    return factories.DataTable_readBack_showCheckboxColumn(nativeStruct);
  }
  public double dividerThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDividerThickness not supported on web");
    return factories.DataTable_readBack_dividerThickness(nativeStruct);
  }
  public boolean showBottomBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableShowBottomBorder not supported on web");
    return factories.DataTable_readBack_showBottomBorder(nativeStruct);
  }
  public double checkboxHorizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableCheckboxHorizontalMargin not supported on web");
    return factories.DataTable_readBack_checkboxHorizontalMargin(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableClipBehavior not supported on web");
    return factories.DataTable_readBack_clipBehavior(nativeStruct);
  }
  public double dataRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDataRowHeight not supported on web");
    return factories.DataTable_readBack_dataRowHeight(nativeStruct);
  }
  private static double _headingRowHeight() {
    return 56.0;
  }
  private static double _horizontalMargin() {
    return 24.0;
  }
  private static double _columnSpacing() {
    return 56.0;
  }
  private static double _sortArrowPadding() {
    return 2.0;
  }
  private static double _dividerThickness() {
    return 1.0;
  }
  private static Duration _sortArrowAnimationDuration() {
    return Duration.duration().milliseconds(150).build();
  }
  @Override
  public DataTable build() {
    return this;
  }
}
