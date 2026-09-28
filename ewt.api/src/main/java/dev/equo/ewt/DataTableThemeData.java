package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DataTableThemeData extends NativeObj.Base implements DataTableThemeDataI {
  protected DataTableThemeData() {}
  DataTableThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DataTableThemeData dataTableThemeDataDataTableThemeData(Optional<DecorationI> decoration, Optional<ColorI> dataRowColor, OptionalDouble dataRowHeight, OptionalDouble dataRowMinHeight, OptionalDouble dataRowMaxHeight, Optional<TextStyleI> dataTextStyle, Optional<ColorI> headingRowColor, OptionalDouble headingRowHeight, Optional<TextStyleI> headingTextStyle, OptionalDouble horizontalMargin, OptionalDouble columnSpacing, OptionalDouble dividerThickness, OptionalDouble checkboxHorizontalMargin, Optional<MainAxisAlignment> headingRowAlignment) {
    int id = factories.dataTableThemeDataDataTableThemeData(decoration.map(DecorationI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableThemeData");
    return new DataTableThemeData(id);
  }
  public static DataTableThemeDataDataTableThemeDataBuilder dataTableThemeData() {
    return DataTableThemeDataDataTableThemeDataBuilder.dataTableThemeDataDataTableThemeData();
  }
  public static DataTableThemeData lerp(DataTableThemeDataI a, DataTableThemeDataI b, double t) {
    int id = factories.dataTableThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableThemeData");
    return new DataTableThemeData(id);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDecoration not supported on web");
    return factories.DataTableThemeData_readBack_decoration(nativeStruct);
  }
  public double dataRowMinHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDataRowMinHeight not supported on web");
    return factories.DataTableThemeData_readBack_dataRowMinHeight(nativeStruct);
  }
  public double dataRowMaxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDataRowMaxHeight not supported on web");
    return factories.DataTableThemeData_readBack_dataRowMaxHeight(nativeStruct);
  }
  public TextStyle dataTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableThemeDataDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DataTableThemeData_readBack_dataTextStyle(nativeStruct);
  }
  public double headingRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataHeadingRowHeight not supported on web");
    return factories.DataTableThemeData_readBack_headingRowHeight(nativeStruct);
  }
  public TextStyle headingTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dataTableThemeDataHeadingTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DataTableThemeData_readBack_headingTextStyle(nativeStruct);
  }
  public double horizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataHorizontalMargin not supported on web");
    return factories.DataTableThemeData_readBack_horizontalMargin(nativeStruct);
  }
  public double columnSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataColumnSpacing not supported on web");
    return factories.DataTableThemeData_readBack_columnSpacing(nativeStruct);
  }
  public double dividerThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDividerThickness not supported on web");
    return factories.DataTableThemeData_readBack_dividerThickness(nativeStruct);
  }
  public double checkboxHorizontalMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataCheckboxHorizontalMargin not supported on web");
    return factories.DataTableThemeData_readBack_checkboxHorizontalMargin(nativeStruct);
  }
  public MainAxisAlignment headingRowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataHeadingRowAlignment not supported on web");
    return factories.DataTableThemeData_readBack_headingRowAlignment(nativeStruct);
  }
  public double dataRowHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dataTableThemeDataDataRowHeight not supported on web");
    return factories.DataTableThemeData_readBack_dataRowHeight(nativeStruct);
  }
  @Override
  public DataTableThemeData build() {
    return this;
  }
}
