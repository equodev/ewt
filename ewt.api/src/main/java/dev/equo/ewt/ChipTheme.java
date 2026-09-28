package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ChipTheme extends InheritedTheme implements ChipThemeI {
  protected ChipTheme() {}
  ChipTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ChipTheme chipThemeChipTheme(@Builder.Parameter ChipThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.chipThemeChipTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipTheme");
    return new ChipTheme(id);
  }
  public static ChipThemeChipThemeBuilder chipTheme(ChipThemeDataI data, WidgetI child) {
    return ChipThemeChipThemeBuilder.chipThemeChipTheme(data, child);
  }
  public static ChipThemeData of(BuildContextI context) {
    int id = factories.chipThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(id);
  }
  public ChipThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeData", getId());
      return new ChipThemeData(__nid);
    }
    return factories.ChipTheme_readBack_data(nativeStruct);
  }
  @Override
  public ChipTheme build() {
    return this;
  }
}
