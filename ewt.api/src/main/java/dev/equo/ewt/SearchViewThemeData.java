package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SearchViewThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SearchViewThemeData extends NativeObj.Base implements SearchViewThemeDataI {
  private MemorySegment st;
  protected SearchViewThemeData() {}
  SearchViewThemeData(MemorySegment st) {
    this.id = SearchViewThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    System.out.println("New SearchViewThemeData id:"+id);
  }
  SearchViewThemeData(int id) { this.id = id; }
  @Builder.Factory
  static SearchViewThemeData searchViewThemeDataSearchViewThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> surfaceTintColor, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> barPadding, Optional<Boolean> shrinkWrap, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, OptionalDouble headerHeight, Optional<TextStyleI> headerTextStyle, Optional<TextStyleI> headerHintStyle, Optional<ColorI> dividerColor) {
    var st = factories.searchViewThemeDataSearchViewThemeData(backgroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    return new SearchViewThemeData(st);
  }
  public static SearchViewThemeDataSearchViewThemeDataBuilder searchViewThemeData() {
    return SearchViewThemeDataSearchViewThemeDataBuilder.searchViewThemeDataSearchViewThemeData();
  }
  public static SearchViewThemeData lerp(SearchViewThemeDataI a, SearchViewThemeDataI b, double t) {
    var st = factories.searchViewThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    return new SearchViewThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SearchViewThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataElevation not supported on web");
    return SearchViewThemeDataObjSt.elevation(st);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(SearchViewThemeDataObjSt.surfaceTintColor(st));
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(SearchViewThemeDataObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataShape not supported on web");
    return new OutlinedBorder(SearchViewThemeDataObjSt.shape(st)) {};
  }
  public double headerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataHeaderHeight not supported on web");
    return SearchViewThemeDataObjSt.headerHeight(st);
  }
  public TextStyle headerTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataHeaderTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SearchViewThemeDataObjSt.headerTextStyle(st));
  }
  public TextStyle headerHintStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataHeaderHintStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SearchViewThemeDataObjSt.headerHintStyle(st));
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(SearchViewThemeDataObjSt.constraints(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(SearchViewThemeDataObjSt.padding(st)) {};
  }
  public EdgeInsetsGeometry barPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataBarPadding not supported on web");
    return new EdgeInsetsGeometry(SearchViewThemeDataObjSt.barPadding(st)) {};
  }
  public boolean shrinkWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchViewThemeDataShrinkWrap not supported on web");
    return intToBool(SearchViewThemeDataObjSt.shrinkWrap(st));
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeDataDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(SearchViewThemeDataObjSt.dividerColor(st));
  }
  @Override
  public SearchViewThemeData build() {
    return this;
  }
}
