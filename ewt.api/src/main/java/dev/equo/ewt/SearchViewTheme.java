package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SearchViewTheme extends InheritedTheme implements SearchViewThemeI {
  protected SearchViewTheme() {}
  SearchViewTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SearchViewTheme searchViewThemeSearchViewTheme(@Builder.Parameter SearchViewThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.searchViewThemeSearchViewTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewTheme");
    return new SearchViewTheme(id);
  }
  public static SearchViewThemeSearchViewThemeBuilder searchViewTheme(SearchViewThemeDataI data, WidgetI child) {
    return SearchViewThemeSearchViewThemeBuilder.searchViewThemeSearchViewTheme(data, child);
  }
  public static SearchViewThemeData of(BuildContextI context) {
    int id = factories.searchViewThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewThemeData");
    return new SearchViewThemeData(id);
  }
  public SearchViewThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("searchViewThemeData", getId());
      return new SearchViewThemeData(__nid);
    }
    return factories.SearchViewTheme_readBack_data(nativeStruct);
  }
  @Override
  public SearchViewTheme build() {
    return this;
  }
}
