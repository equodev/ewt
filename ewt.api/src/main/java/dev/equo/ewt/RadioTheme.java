package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RadioTheme extends InheritedWidget implements RadioThemeI {
  protected RadioTheme() {}
  RadioTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RadioTheme radioThemeRadioTheme(@Builder.Parameter RadioThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.radioThemeRadioTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioTheme");
    return new RadioTheme(id);
  }
  public static RadioThemeRadioThemeBuilder radioTheme(RadioThemeDataI data, WidgetI child) {
    return RadioThemeRadioThemeBuilder.radioThemeRadioTheme(data, child);
  }
  public static RadioThemeData of(BuildContextI context) {
    int id = factories.radioThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioThemeData");
    return new RadioThemeData(id);
  }
  public RadioThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioThemeData", getId());
      return new RadioThemeData(__nid);
    }
    return factories.RadioTheme_readBack_data(nativeStruct);
  }
  @Override
  public RadioTheme build() {
    return this;
  }
}
