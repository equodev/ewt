package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SearchViewThemeData extends NativeObj.Base implements SearchViewThemeDataI {
  protected SearchViewThemeData() {}
  SearchViewThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SearchViewThemeData searchViewThemeDataSearchViewThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> surfaceTintColor, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> barPadding, Optional<Boolean> shrinkWrap, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, OptionalDouble headerHeight, Optional<TextStyleI> headerTextStyle, Optional<TextStyleI> headerHintStyle, Optional<ColorI> dividerColor) {
    int id = factories.searchViewThemeDataSearchViewThemeData(backgroundColor.map(ColorI::build),
      elevation,
      surfaceTintColor.map(ColorI::build),
      constraints.map(BoxConstraintsI::build),
      padding.map(EdgeInsetsGeometryI::build),
      barPadding.map(EdgeInsetsGeometryI::build),
      shrinkWrap,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      headerHeight,
      headerTextStyle.map(TextStyleI::build),
      headerHintStyle.map(TextStyleI::build),
      dividerColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    return new SearchViewThemeData(id);
  }
  public static SearchViewThemeDataSearchViewThemeDataBuilder searchViewThemeData() {
    return SearchViewThemeDataSearchViewThemeDataBuilder.searchViewThemeDataSearchViewThemeData();
  }
  public static SearchViewThemeData lerp(SearchViewThemeDataI a, SearchViewThemeDataI b, double t) {
    int id = factories.searchViewThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    return new SearchViewThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SearchViewThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataElevation not supported on web");
    return factories.SearchViewThemeData_readBack_elevation(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.SearchViewThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataSide", getId());
      return new BorderSide(__nid);
    }
    return factories.SearchViewThemeData_readBack_side(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataShape not supported on web");
    return factories.SearchViewThemeData_readBack_shape(nativeStruct);
  }
  public double headerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataHeaderHeight not supported on web");
    return factories.SearchViewThemeData_readBack_headerHeight(nativeStruct);
  }
  public TextStyle headerTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataHeaderTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SearchViewThemeData_readBack_headerTextStyle(nativeStruct);
  }
  public TextStyle headerHintStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataHeaderHintStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SearchViewThemeData_readBack_headerHintStyle(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.SearchViewThemeData_readBack_constraints(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataPadding not supported on web");
    return factories.SearchViewThemeData_readBack_padding(nativeStruct);
  }
  public EdgeInsetsGeometry barPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataBarPadding not supported on web");
    return factories.SearchViewThemeData_readBack_barPadding(nativeStruct);
  }
  public boolean shrinkWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataShrinkWrap not supported on web");
    return factories.SearchViewThemeData_readBack_shrinkWrap(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataDividerColor", getId());
      return new Color(__nid);
    }
    return factories.SearchViewThemeData_readBack_dividerColor(nativeStruct);
  }
  @Override
  public SearchViewThemeData build() {
    return this;
  }
}
