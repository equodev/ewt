package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SearchBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SearchBarThemeData extends NativeObj.Base implements SearchBarThemeDataI {
  private MemorySegment st;
  protected SearchBarThemeData() {}
  SearchBarThemeData(MemorySegment st) {
    this.id = SearchBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    System.out.println("New SearchBarThemeData id:"+id);
  }
  SearchBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static SearchBarThemeData searchBarThemeDataSearchBarThemeData(OptionalDouble elevation, Optional<ColorI> backgroundColor, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> overlayColor, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<EdgeInsetsGeometryI> padding, Optional<TextStyleI> textStyle, Optional<TextStyleI> hintStyle, Optional<BoxConstraintsI> constraints, Optional<TextCapitalization> textCapitalization) {
    var st = factories.searchBarThemeDataSearchBarThemeData(elevation,
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
    if (st == null) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    return new SearchBarThemeData(st);
  }
  public static SearchBarThemeDataSearchBarThemeDataBuilder searchBarThemeData() {
    return SearchBarThemeDataSearchBarThemeDataBuilder.searchBarThemeDataSearchBarThemeData();
  }
  public static SearchBarThemeData lerp(SearchBarThemeDataI a, SearchBarThemeDataI b, double t) {
    var st = factories.searchBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    return new SearchBarThemeData(st);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(SearchBarThemeDataObjSt.constraints(st));
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarThemeDataTextCapitalization not supported on web");
    return TextCapitalization.values()[SearchBarThemeDataObjSt.textCapitalization(st)];
  }
  @Override
  public SearchBarThemeData build() {
    return this;
  }
}
