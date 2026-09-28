package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OutlinedButtonTheme extends InheritedTheme implements OutlinedButtonThemeI {
  protected OutlinedButtonTheme() {}
  OutlinedButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static OutlinedButtonTheme outlinedButtonThemeOutlinedButtonTheme(@Builder.Parameter OutlinedButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.outlinedButtonThemeOutlinedButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonTheme");
    return new OutlinedButtonTheme(id);
  }
  public static OutlinedButtonThemeOutlinedButtonThemeBuilder outlinedButtonTheme(OutlinedButtonThemeDataI data, WidgetI child) {
    return OutlinedButtonThemeOutlinedButtonThemeBuilder.outlinedButtonThemeOutlinedButtonTheme(data, child);
  }
  public static OutlinedButtonThemeData of(BuildContextI context) {
    int id = factories.outlinedButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    return new OutlinedButtonThemeData(id);
  }
  public OutlinedButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("outlinedButtonThemeData", getId());
      return new OutlinedButtonThemeData(__nid);
    }
    return factories.OutlinedButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public OutlinedButtonTheme build() {
    return this;
  }
}
