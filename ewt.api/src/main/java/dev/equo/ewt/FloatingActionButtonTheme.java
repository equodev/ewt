package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FloatingActionButtonTheme extends InheritedTheme implements FloatingActionButtonThemeI {
  protected FloatingActionButtonTheme() {}
  FloatingActionButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FloatingActionButtonTheme floatingActionButtonThemeFloatingActionButtonTheme(@Builder.Parameter FloatingActionButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.floatingActionButtonThemeFloatingActionButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonTheme");
    return new FloatingActionButtonTheme(id);
  }
  public static FloatingActionButtonThemeFloatingActionButtonThemeBuilder floatingActionButtonTheme(FloatingActionButtonThemeDataI data, WidgetI child) {
    return FloatingActionButtonThemeFloatingActionButtonThemeBuilder.floatingActionButtonThemeFloatingActionButtonTheme(data, child);
  }
  public static FloatingActionButtonThemeData of(BuildContextI context) {
    int id = factories.floatingActionButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    return new FloatingActionButtonThemeData(id);
  }
  public FloatingActionButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeData", getId());
      return new FloatingActionButtonThemeData(__nid);
    }
    return factories.FloatingActionButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public FloatingActionButtonTheme build() {
    return this;
  }
}
