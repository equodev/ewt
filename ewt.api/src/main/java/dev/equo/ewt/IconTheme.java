package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IconTheme extends InheritedTheme implements IconThemeI {
  protected IconTheme() {}
  IconTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IconTheme iconThemeIconTheme(@Builder.Parameter IconThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.iconThemeIconTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget IconTheme");
    return new IconTheme(id);
  }
  public static IconThemeIconThemeBuilder iconTheme(IconThemeDataI data, WidgetI child) {
    return IconThemeIconThemeBuilder.iconThemeIconTheme(data, child);
  }
  public static Widget merge(IconThemeDataI data, WidgetI child) {
    var id = factories.iconThemeMerge(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public static IconThemeData of(BuildContextI context) {
    int id = factories.iconThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(id);
  }
  public IconThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconThemeData", getId());
      return new IconThemeData(__nid);
    }
    return factories.IconTheme_readBack_data(nativeStruct);
  }
  @Override
  public IconTheme build() {
    return this;
  }
}
