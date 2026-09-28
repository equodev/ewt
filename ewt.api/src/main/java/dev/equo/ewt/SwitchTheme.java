package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SwitchTheme extends InheritedWidget implements SwitchThemeI {
  protected SwitchTheme() {}
  SwitchTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SwitchTheme switchThemeSwitchTheme(@Builder.Parameter SwitchThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.switchThemeSwitchTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchTheme");
    return new SwitchTheme(id);
  }
  public static SwitchThemeSwitchThemeBuilder switchTheme(SwitchThemeDataI data, WidgetI child) {
    return SwitchThemeSwitchThemeBuilder.switchThemeSwitchTheme(data, child);
  }
  public static SwitchThemeData of(BuildContextI context) {
    int id = factories.switchThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchThemeData");
    return new SwitchThemeData(id);
  }
  public SwitchThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchThemeData", getId());
      return new SwitchThemeData(__nid);
    }
    return factories.SwitchTheme_readBack_data(nativeStruct);
  }
  @Override
  public SwitchTheme build() {
    return this;
  }
}
