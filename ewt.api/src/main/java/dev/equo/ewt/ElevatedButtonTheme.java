package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ElevatedButtonTheme extends InheritedTheme implements ElevatedButtonThemeI {
  protected ElevatedButtonTheme() {}
  ElevatedButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ElevatedButtonTheme elevatedButtonThemeElevatedButtonTheme(@Builder.Parameter ElevatedButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.elevatedButtonThemeElevatedButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonTheme");
    return new ElevatedButtonTheme(id);
  }
  public static ElevatedButtonThemeElevatedButtonThemeBuilder elevatedButtonTheme(ElevatedButtonThemeDataI data, WidgetI child) {
    return ElevatedButtonThemeElevatedButtonThemeBuilder.elevatedButtonThemeElevatedButtonTheme(data, child);
  }
  public static ElevatedButtonThemeData of(BuildContextI context) {
    int id = factories.elevatedButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    return new ElevatedButtonThemeData(id);
  }
  public ElevatedButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("elevatedButtonThemeData", getId());
      return new ElevatedButtonThemeData(__nid);
    }
    return factories.ElevatedButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public ElevatedButtonTheme build() {
    return this;
  }
}
