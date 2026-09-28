package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExpansionTileTheme extends InheritedTheme implements ExpansionTileThemeI {
  protected ExpansionTileTheme() {}
  ExpansionTileTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExpansionTileTheme expansionTileThemeExpansionTileTheme(@Builder.Parameter ExpansionTileThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.expansionTileThemeExpansionTileTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileTheme");
    return new ExpansionTileTheme(id);
  }
  public static ExpansionTileThemeExpansionTileThemeBuilder expansionTileTheme(ExpansionTileThemeDataI data, WidgetI child) {
    return ExpansionTileThemeExpansionTileThemeBuilder.expansionTileThemeExpansionTileTheme(data, child);
  }
  public static ExpansionTileThemeData of(BuildContextI context) {
    int id = factories.expansionTileThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    return new ExpansionTileThemeData(id);
  }
  public ExpansionTileThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeData", getId());
      return new ExpansionTileThemeData(__nid);
    }
    return factories.ExpansionTileTheme_readBack_data(nativeStruct);
  }
  @Override
  public ExpansionTileTheme build() {
    return this;
  }
}
