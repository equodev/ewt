package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SearchViewThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SearchViewTheme extends InheritedTheme implements SearchViewThemeI {
  private MemorySegment st;
  protected SearchViewTheme() {}
  SearchViewTheme(MemorySegment st) {
    this.id = SearchViewThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewTheme");
    System.out.println("New SearchViewTheme id:"+id);
  }
  SearchViewTheme(int id) { this.id = id; }
  @Builder.Factory
  static SearchViewTheme searchViewThemeSearchViewTheme(@Builder.Parameter SearchViewThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.searchViewThemeSearchViewTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SearchViewTheme");
    return new SearchViewTheme(st);
  }
  public static SearchViewThemeSearchViewThemeBuilder searchViewTheme(SearchViewThemeDataI data, WidgetI child) {
    return SearchViewThemeSearchViewThemeBuilder.searchViewThemeSearchViewTheme(data, child);
  }
  public static SearchViewThemeData of(BuildContextI context) {
    var st = factories.searchViewThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    return new SearchViewThemeData(st);
  }
  public SearchViewThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SearchViewThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SearchViewThemeDataObjSt.id(__st, __nid);
      return new SearchViewThemeData(__st);
    }
    return new SearchViewThemeData(SearchViewThemeObjSt.data(st));
  }
  @Override
  public SearchViewTheme build() {
    return this;
  }
}
