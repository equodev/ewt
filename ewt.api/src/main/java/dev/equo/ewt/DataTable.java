package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DataTableObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DataTable extends StatelessWidget implements DataTableI {
  private MemorySegment st;
  protected DataTable() {}
  DataTable(MemorySegment st) {
    this.id = DataTableObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTable");
    System.out.println("New DataTable id:"+id);
  }
  DataTable(int id) { this.id = id; }
  @Builder.Factory
  static DataTable dataTableDataTable(@Builder.Parameter List<DataColumnI> columns, OptionalInt sortColumnIndex, Optional<Boolean> sortAscending, Optional<Consumer<Boolean>> onSelectAll, Optional<DecorationI> decoration, Optional<ColorI> dataRowColor, OptionalDouble dataRowHeight, OptionalDouble dataRowMinHeight, OptionalDouble dataRowMaxHeight, Optional<TextStyleI> dataTextStyle, Optional<ColorI> headingRowColor, OptionalDouble headingRowHeight, Optional<TextStyleI> headingTextStyle, OptionalDouble horizontalMargin, OptionalDouble columnSpacing, Optional<Boolean> showCheckboxColumn, Optional<Boolean> showBottomBorder, OptionalDouble dividerThickness, List<DataRowI> rows, OptionalDouble checkboxHorizontalMargin, Optional<Clip> clipBehavior) {
    var st = factories.dataTableDataTable(columns.stream().map(DataColumnI::build).toList(),
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
      rows.stream().map(DataRowI::build).toList(),
      checkboxHorizontalMargin,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget DataTable");
    return new DataTable(st);
  }
  public static DataTableDataTableBuilder dataTable(List<DataColumnI> columns) {
    return DataTableDataTableBuilder.dataTableDataTable(columns);
  }
  public int sortColumnIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableSortColumnIndex not supported on web");
    return DataTableObjSt.sortColumnIndex(st);
  }
  public boolean sortAscending() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableSortAscending not supported on web");
    return intToBool(DataTableObjSt.sortAscending(st));
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDecoration not supported on web");
    return new Decoration(DataTableObjSt.decoration(st)) {};
  }
  public double dataRowMinHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDataRowMinHeight not supported on web");
    return DataTableObjSt.dataRowMinHeight(st);
  }
  public double dataRowMaxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDataRowMaxHeight not supported on web");
    return DataTableObjSt.dataRowMaxHeight(st);
  }
  public TextStyle dataTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DataTableObjSt.dataTextStyle(st));
  }
  public double headingRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableHeadingRowHeight not supported on web");
    return DataTableObjSt.headingRowHeight(st);
  }
  public TextStyle headingTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableHeadingTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DataTableObjSt.headingTextStyle(st));
  }
  public double horizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableHorizontalMargin not supported on web");
    return DataTableObjSt.horizontalMargin(st);
  }
  public double columnSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableColumnSpacing not supported on web");
    return DataTableObjSt.columnSpacing(st);
  }
  public boolean showCheckboxColumn() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableShowCheckboxColumn not supported on web");
    return intToBool(DataTableObjSt.showCheckboxColumn(st));
  }
  public double dividerThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDividerThickness not supported on web");
    return DataTableObjSt.dividerThickness(st);
  }
  public boolean showBottomBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableShowBottomBorder not supported on web");
    return intToBool(DataTableObjSt.showBottomBorder(st));
  }
  public double checkboxHorizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableCheckboxHorizontalMargin not supported on web");
    return DataTableObjSt.checkboxHorizontalMargin(st);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableClipBehavior not supported on web");
    return Clip.values()[DataTableObjSt.clipBehavior(st)];
  }
  public double dataRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableDataRowHeight not supported on web");
    return DataTableObjSt.dataRowHeight(st);
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
