package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SearchBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SearchBarTheme extends InheritedWidget implements SearchBarThemeI {
  private MemorySegment st;
  protected SearchBarTheme() {}
  SearchBarTheme(MemorySegment st) {
    this.id = SearchBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarTheme");
    System.out.println("New SearchBarTheme id:"+id);
  }
  SearchBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static SearchBarTheme searchBarThemeSearchBarTheme(@Builder.Parameter SearchBarThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.searchBarThemeSearchBarTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SearchBarTheme");
    return new SearchBarTheme(st);
  }
  public static SearchBarThemeSearchBarThemeBuilder searchBarTheme(SearchBarThemeDataI data, WidgetI child) {
    return SearchBarThemeSearchBarThemeBuilder.searchBarThemeSearchBarTheme(data, child);
  }
  public static SearchBarThemeData of(BuildContextI context) {
    var st = factories.searchBarThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    return new SearchBarThemeData(st);
  }
  public SearchBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SearchBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SearchBarThemeDataObjSt.id(__st, __nid);
      return new SearchBarThemeData(__st);
    }
    return new SearchBarThemeData(SearchBarThemeObjSt.data(st));
  }
  @Override
  public SearchBarTheme build() {
    return this;
  }
}
