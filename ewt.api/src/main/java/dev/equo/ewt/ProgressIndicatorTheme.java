package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ProgressIndicatorTheme extends InheritedTheme implements ProgressIndicatorThemeI {
  protected ProgressIndicatorTheme() {}
  ProgressIndicatorTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ProgressIndicatorTheme progressIndicatorThemeProgressIndicatorTheme(@Builder.Parameter ProgressIndicatorThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.progressIndicatorThemeProgressIndicatorTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorTheme");
    return new ProgressIndicatorTheme(id);
  }
  public static ProgressIndicatorThemeProgressIndicatorThemeBuilder progressIndicatorTheme(ProgressIndicatorThemeDataI data, WidgetI child) {
    return ProgressIndicatorThemeProgressIndicatorThemeBuilder.progressIndicatorThemeProgressIndicatorTheme(data, child);
  }
  public static ProgressIndicatorThemeData of(BuildContextI context) {
    int id = factories.progressIndicatorThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    return new ProgressIndicatorThemeData(id);
  }
  public ProgressIndicatorThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeData", getId());
      return new ProgressIndicatorThemeData(__nid);
    }
    return factories.ProgressIndicatorTheme_readBack_data(nativeStruct);
  }
  @Override
  public ProgressIndicatorTheme build() {
    return this;
  }
}
