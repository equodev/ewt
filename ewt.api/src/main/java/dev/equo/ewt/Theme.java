package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Theme extends StatelessWidget implements ThemeI {
  protected Theme() {}
  Theme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Theme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Theme themeTheme(@Builder.Parameter ThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.themeTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Theme");
    return new Theme(id);
  }
  public static ThemeThemeBuilder theme(ThemeDataI data, WidgetI child) {
    return ThemeThemeBuilder.themeTheme(data, child);
  }
  public static ThemeData of(BuildContextI context) {
    int id = factories.themeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public static Brightness brightnessOf(BuildContextI context) {
    var id = factories.themeBrightnessOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Brightness");
    System.out.println("New Brightness id:"+id);
    return Brightness.values()[id];
  }
  public static Brightness maybeBrightnessOf(BuildContextI context) {
    var id = factories.themeMaybeBrightnessOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Brightness?");
    System.out.println("New Brightness? id:"+id);
    return Brightness.values()[id];
  }
  public ThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeData", getId());
      return new ThemeData(__nid);
    }
    return factories.Theme_readBack_data(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeChild not supported on web");
    return factories.Theme_readBack_child(nativeStruct);
  }
  @Override
  public Theme build() {
    return this;
  }
}
