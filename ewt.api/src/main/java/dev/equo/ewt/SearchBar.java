package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SearchBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SearchBar extends StatefulWidget implements SearchBarI {
  private MemorySegment st;
  protected SearchBar() {}
  SearchBar(MemorySegment st) {
    this.id = SearchBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBar");
    System.out.println("New SearchBar id:"+id);
  }
  SearchBar(int id) { this.id = id; }
  @Builder.Factory
  static SearchBar searchBarSearchBar(Optional<String> hintText, Optional<WidgetI> leading, Optional<Runnable> onTap, Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<BoxConstraintsI> constraints, Optional<TextCapitalization> textCapitalization, Optional<Boolean> enabled, Optional<Boolean> autoFocus, Optional<TextInputAction> textInputAction, Optional<EdgeInsetsI> scrollPadding) {
    var st = factories.searchBarSearchBar(hintText,
      leading.map(WidgetI::build),
      onTap,
      onChanged,
      onSubmitted,
      constraints.map(BoxConstraintsI::build),
      textCapitalization,
      enabled,
      autoFocus,
      textInputAction,
      scrollPadding.map(EdgeInsetsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SearchBar");
    return new SearchBar(st);
  }
  public static SearchBarSearchBarBuilder searchBar() {
    return SearchBarSearchBarBuilder.searchBarSearchBar();
  }
  public String hintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarHintText not supported on web");
    return SearchBarObjSt.hintText(st).getString(0);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarLeading not supported on web");
    return new Widget(SearchBarObjSt.leading(st)) {};
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(SearchBarObjSt.constraints(st));
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarTextCapitalization not supported on web");
    return TextCapitalization.values()[SearchBarObjSt.textCapitalization(st)];
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarEnabled not supported on web");
    return intToBool(SearchBarObjSt.enabled(st));
  }
  public boolean autoFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarAutoFocus not supported on web");
    return intToBool(SearchBarObjSt.autoFocus(st));
  }
  public TextInputAction textInputAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("searchBarTextInputAction not supported on web");
    return TextInputAction.values()[SearchBarObjSt.textInputAction(st)];
  }
  public EdgeInsets scrollPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarScrollPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(SearchBarObjSt.scrollPadding(st));
  }
  @Override
  public SearchBar build() {
    return this;
  }
}
