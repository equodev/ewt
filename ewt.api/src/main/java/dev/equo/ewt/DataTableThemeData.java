package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DataTableThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DataTableThemeData extends NativeObj.Base implements DataTableThemeDataI {
  private MemorySegment st;
  protected DataTableThemeData() {}
  DataTableThemeData(MemorySegment st) {
    this.id = DataTableThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableThemeData");
    System.out.println("New DataTableThemeData id:"+id);
  }
  DataTableThemeData(int id) { this.id = id; }
  @Builder.Factory
  static DataTableThemeData dataTableThemeDataDataTableThemeData(Optional<DecorationI> decoration, Optional<ColorI> dataRowColor, OptionalDouble dataRowHeight, OptionalDouble dataRowMinHeight, OptionalDouble dataRowMaxHeight, Optional<TextStyleI> dataTextStyle, Optional<ColorI> headingRowColor, OptionalDouble headingRowHeight, Optional<TextStyleI> headingTextStyle, OptionalDouble horizontalMargin, OptionalDouble columnSpacing, OptionalDouble dividerThickness, OptionalDouble checkboxHorizontalMargin, Optional<MainAxisAlignment> headingRowAlignment) {
    var st = factories.dataTableThemeDataDataTableThemeData(decoration.map(DecorationI::build),
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
      dividerThickness,
      checkboxHorizontalMargin,
      headingRowAlignment);
    if (st == null) throw new RuntimeException("Failed to created widget DataTableThemeData");
    return new DataTableThemeData(st);
  }
  public static DataTableThemeDataDataTableThemeDataBuilder dataTableThemeData() {
    return DataTableThemeDataDataTableThemeDataBuilder.dataTableThemeDataDataTableThemeData();
  }
  public static DataTableThemeData lerp(DataTableThemeDataI a, DataTableThemeDataI b, double t) {
    var st = factories.dataTableThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget DataTableThemeData");
    return new DataTableThemeData(st);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDecoration not supported on web");
    return new Decoration(DataTableThemeDataObjSt.decoration(st)) {};
  }
  public double dataRowMinHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDataRowMinHeight not supported on web");
    return DataTableThemeDataObjSt.dataRowMinHeight(st);
  }
  public double dataRowMaxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDataRowMaxHeight not supported on web");
    return DataTableThemeDataObjSt.dataRowMaxHeight(st);
  }
  public TextStyle dataTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableThemeDataDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DataTableThemeDataObjSt.dataTextStyle(st));
  }
  public double headingRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataHeadingRowHeight not supported on web");
    return DataTableThemeDataObjSt.headingRowHeight(st);
  }
  public TextStyle headingTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableThemeDataHeadingTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DataTableThemeDataObjSt.headingTextStyle(st));
  }
  public double horizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataHorizontalMargin not supported on web");
    return DataTableThemeDataObjSt.horizontalMargin(st);
  }
  public double columnSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataColumnSpacing not supported on web");
    return DataTableThemeDataObjSt.columnSpacing(st);
  }
  public double dividerThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDividerThickness not supported on web");
    return DataTableThemeDataObjSt.dividerThickness(st);
  }
  public double checkboxHorizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataCheckboxHorizontalMargin not supported on web");
    return DataTableThemeDataObjSt.checkboxHorizontalMargin(st);
  }
  public MainAxisAlignment headingRowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataHeadingRowAlignment not supported on web");
    return MainAxisAlignment.values()[DataTableThemeDataObjSt.headingRowAlignment(st)];
  }
  public double dataRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDataRowHeight not supported on web");
    return DataTableThemeDataObjSt.dataRowHeight(st);
  }
  @Override
  public DataTableThemeData build() {
    return this;
  }
}
