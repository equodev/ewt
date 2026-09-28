package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SearchBar extends StatefulWidget implements SearchBarI {
  protected SearchBar() {}
  SearchBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SearchBar searchBarSearchBar(Optional<String> hintText, Optional<WidgetI> leading, Optional<List<WidgetI>> trailing, Optional<Runnable> onTap, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<BoxConstraintsI> constraints, OptionalDouble elevation, Optional<ColorI> backgroundColor, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> overlayColor, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<EdgeInsetsGeometryI> padding, Optional<TextStyleI> textStyle, Optional<TextStyleI> hintStyle, Optional<TextCapitalization> textCapitalization, Optional<Boolean> enabled, Optional<Boolean> autoFocus, Optional<TextInputAction> textInputAction, Optional<EdgeInsetsI> scrollPadding, Optional<Boolean> readOnly, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType) {
    int id = factories.searchBarSearchBar(hintText,
      leading.map(WidgetI::build),
      trailing.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      onTap,
      onTapOutside,
      onChanged,
      onSubmitted,
      constraints.map(BoxConstraintsI::build),
      elevation,
      backgroundColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      padding.map(EdgeInsetsGeometryI::build),
      textStyle.map(TextStyleI::build),
      hintStyle.map(TextStyleI::build),
      textCapitalization,
      enabled,
      autoFocus,
      textInputAction,
      scrollPadding.map(EdgeInsetsI::build),
      readOnly,
      smartDashesType,
      smartQuotesType);
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBar");
    return new SearchBar(id);
  }
  public static SearchBarSearchBarBuilder searchBar() {
    return SearchBarSearchBarBuilder.searchBarSearchBar();
  }
  public String hintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarHintText not supported on web");
    return factories.SearchBar_readBack_hintText(nativeStruct);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarLeading not supported on web");
    return factories.SearchBar_readBack_leading(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.SearchBar_readBack_constraints(nativeStruct);
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarTextCapitalization not supported on web");
    return factories.SearchBar_readBack_textCapitalization(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarEnabled not supported on web");
    return factories.SearchBar_readBack_enabled(nativeStruct);
  }
  public boolean autoFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarAutoFocus not supported on web");
    return factories.SearchBar_readBack_autoFocus(nativeStruct);
  }
  public TextInputAction textInputAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarTextInputAction not supported on web");
    return factories.SearchBar_readBack_textInputAction(nativeStruct);
  }
  public EdgeInsets scrollPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarScrollPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.SearchBar_readBack_scrollPadding(nativeStruct);
  }
  public boolean readOnly() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarReadOnly not supported on web");
    return factories.SearchBar_readBack_readOnly(nativeStruct);
  }
  public SmartDashesType smartDashesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarSmartDashesType not supported on web");
    return factories.SearchBar_readBack_smartDashesType(nativeStruct);
  }
  public SmartQuotesType smartQuotesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarSmartQuotesType not supported on web");
    return factories.SearchBar_readBack_smartQuotesType(nativeStruct);
  }
  @Override
  public SearchBar build() {
    return this;
  }
}
