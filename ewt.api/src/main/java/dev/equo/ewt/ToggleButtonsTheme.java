package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ToggleButtonsTheme extends InheritedTheme implements ToggleButtonsThemeI {
  protected ToggleButtonsTheme() {}
  ToggleButtonsTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ToggleButtonsTheme toggleButtonsThemeToggleButtonsTheme(@Builder.Parameter ToggleButtonsThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.toggleButtonsThemeToggleButtonsTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsTheme");
    return new ToggleButtonsTheme(id);
  }
  public static ToggleButtonsThemeToggleButtonsThemeBuilder toggleButtonsTheme(ToggleButtonsThemeDataI data, WidgetI child) {
    return ToggleButtonsThemeToggleButtonsThemeBuilder.toggleButtonsThemeToggleButtonsTheme(data, child);
  }
  public static ToggleButtonsThemeData of(BuildContextI context) {
    int id = factories.toggleButtonsThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    return new ToggleButtonsThemeData(id);
  }
  public ToggleButtonsThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeData", getId());
      return new ToggleButtonsThemeData(__nid);
    }
    return factories.ToggleButtonsTheme_readBack_data(nativeStruct);
  }
  @Override
  public ToggleButtonsTheme build() {
    return this;
  }
}
