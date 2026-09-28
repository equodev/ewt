package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomNavigationBarTheme extends InheritedWidget implements BottomNavigationBarThemeI {
  protected BottomNavigationBarTheme() {}
  BottomNavigationBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BottomNavigationBarTheme bottomNavigationBarThemeBottomNavigationBarTheme(@Builder.Parameter BottomNavigationBarThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.bottomNavigationBarThemeBottomNavigationBarTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarTheme");
    return new BottomNavigationBarTheme(id);
  }
  public static BottomNavigationBarThemeBottomNavigationBarThemeBuilder bottomNavigationBarTheme(BottomNavigationBarThemeDataI data, WidgetI child) {
    return BottomNavigationBarThemeBottomNavigationBarThemeBuilder.bottomNavigationBarThemeBottomNavigationBarTheme(data, child);
  }
  public static BottomNavigationBarThemeData of(BuildContextI context) {
    int id = factories.bottomNavigationBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    return new BottomNavigationBarThemeData(id);
  }
  public BottomNavigationBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeData", getId());
      return new BottomNavigationBarThemeData(__nid);
    }
    return factories.BottomNavigationBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public BottomNavigationBarTheme build() {
    return this;
  }
}
