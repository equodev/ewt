package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DrawerTheme extends InheritedTheme implements DrawerThemeI {
  protected DrawerTheme() {}
  DrawerTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DrawerTheme drawerThemeDrawerTheme(@Builder.Parameter DrawerThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.drawerThemeDrawerTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerTheme");
    return new DrawerTheme(id);
  }
  public static DrawerThemeDrawerThemeBuilder drawerTheme(DrawerThemeDataI data, WidgetI child) {
    return DrawerThemeDrawerThemeBuilder.drawerThemeDrawerTheme(data, child);
  }
  public static DrawerThemeData of(BuildContextI context) {
    int id = factories.drawerThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerThemeData");
    return new DrawerThemeData(id);
  }
  public DrawerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeData", getId());
      return new DrawerThemeData(__nid);
    }
    return factories.DrawerTheme_readBack_data(nativeStruct);
  }
  @Override
  public DrawerTheme build() {
    return this;
  }
}
