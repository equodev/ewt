package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SearchBarTheme extends InheritedWidget implements SearchBarThemeI {
  protected SearchBarTheme() {}
  SearchBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SearchBarTheme searchBarThemeSearchBarTheme(@Builder.Parameter SearchBarThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.searchBarThemeSearchBarTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarTheme");
    return new SearchBarTheme(id);
  }
  public static SearchBarThemeSearchBarThemeBuilder searchBarTheme(SearchBarThemeDataI data, WidgetI child) {
    return SearchBarThemeSearchBarThemeBuilder.searchBarThemeSearchBarTheme(data, child);
  }
  public static SearchBarThemeData of(BuildContextI context) {
    int id = factories.searchBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarThemeData");
    return new SearchBarThemeData(id);
  }
  public SearchBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchBarThemeData", getId());
      return new SearchBarThemeData(__nid);
    }
    return factories.SearchBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public SearchBarTheme build() {
    return this;
  }
}
