package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DividerTheme extends InheritedTheme implements DividerThemeI {
  protected DividerTheme() {}
  DividerTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DividerTheme dividerThemeDividerTheme(@Builder.Parameter DividerThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.dividerThemeDividerTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerTheme");
    return new DividerTheme(id);
  }
  public static DividerThemeDividerThemeBuilder dividerTheme(DividerThemeDataI data, WidgetI child) {
    return DividerThemeDividerThemeBuilder.dividerThemeDividerTheme(data, child);
  }
  public static DividerThemeData of(BuildContextI context) {
    int id = factories.dividerThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerThemeData");
    return new DividerThemeData(id);
  }
  public DividerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dividerThemeData", getId());
      return new DividerThemeData(__nid);
    }
    return factories.DividerTheme_readBack_data(nativeStruct);
  }
  @Override
  public DividerTheme build() {
    return this;
  }
}
