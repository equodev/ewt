package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IconButtonTheme extends InheritedTheme implements IconButtonThemeI {
  protected IconButtonTheme() {}
  IconButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IconButtonTheme iconButtonThemeIconButtonTheme(@Builder.Parameter IconButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.iconButtonThemeIconButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonTheme");
    return new IconButtonTheme(id);
  }
  public static IconButtonThemeIconButtonThemeBuilder iconButtonTheme(IconButtonThemeDataI data, WidgetI child) {
    return IconButtonThemeIconButtonThemeBuilder.iconButtonThemeIconButtonTheme(data, child);
  }
  public static IconButtonThemeData of(BuildContextI context) {
    int id = factories.iconButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    return new IconButtonThemeData(id);
  }
  public IconButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonThemeData", getId());
      return new IconButtonThemeData(__nid);
    }
    return factories.IconButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public IconButtonTheme build() {
    return this;
  }
}
