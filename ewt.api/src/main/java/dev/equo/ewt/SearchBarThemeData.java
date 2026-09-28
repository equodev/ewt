package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SearchBarThemeData extends NativeObj.Base implements SearchBarThemeDataI {
  protected SearchBarThemeData() {}
  SearchBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SearchBarThemeData searchBarThemeDataSearchBarThemeData(OptionalDouble elevation, Optional<ColorI> backgroundColor, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> overlayColor, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<EdgeInsetsGeometryI> padding, Optional<TextStyleI> textStyle, Optional<TextStyleI> hintStyle, Optional<BoxConstraintsI> constraints, Optional<TextCapitalization> textCapitalization) {
    int id = factories.searchBarThemeDataSearchBarThemeData(elevation,
      backgroundColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      padding.map(EdgeInsetsGeometryI::build),
      textStyle.map(TextStyleI::build),
      hintStyle.map(TextStyleI::build),
      constraints.map(BoxConstraintsI::build),
      textCapitalization);
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    return new SearchBarThemeData(id);
  }
  public static SearchBarThemeDataSearchBarThemeDataBuilder searchBarThemeData() {
    return SearchBarThemeDataSearchBarThemeDataBuilder.searchBarThemeDataSearchBarThemeData();
  }
  public static SearchBarThemeData lerp(SearchBarThemeDataI a, SearchBarThemeDataI b, double t) {
    int id = factories.searchBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    return new SearchBarThemeData(id);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.SearchBarThemeData_readBack_constraints(nativeStruct);
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarThemeDataTextCapitalization not supported on web");
    return factories.SearchBarThemeData_readBack_textCapitalization(nativeStruct);
  }
  @Override
  public SearchBarThemeData build() {
    return this;
  }
}
