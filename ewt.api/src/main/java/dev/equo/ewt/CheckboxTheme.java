package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CheckboxTheme extends InheritedWidget implements CheckboxThemeI {
  protected CheckboxTheme() {}
  CheckboxTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CheckboxTheme checkboxThemeCheckboxTheme(@Builder.Parameter CheckboxThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.checkboxThemeCheckboxTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxTheme");
    return new CheckboxTheme(id);
  }
  public static CheckboxThemeCheckboxThemeBuilder checkboxTheme(CheckboxThemeDataI data, WidgetI child) {
    return CheckboxThemeCheckboxThemeBuilder.checkboxThemeCheckboxTheme(data, child);
  }
  public static CheckboxThemeData of(BuildContextI context) {
    int id = factories.checkboxThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    return new CheckboxThemeData(id);
  }
  public CheckboxThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxThemeData", getId());
      return new CheckboxThemeData(__nid);
    }
    return factories.CheckboxTheme_readBack_data(nativeStruct);
  }
  @Override
  public CheckboxTheme build() {
    return this;
  }
}
