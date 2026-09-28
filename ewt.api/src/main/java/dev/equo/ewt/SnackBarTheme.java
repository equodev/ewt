package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SnackBarTheme extends InheritedTheme implements SnackBarThemeI {
  protected SnackBarTheme() {}
  SnackBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SnackBarTheme snackBarThemeSnackBarTheme(@Builder.Parameter SnackBarThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.snackBarThemeSnackBarTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarTheme");
    return new SnackBarTheme(id);
  }
  public static SnackBarThemeSnackBarThemeBuilder snackBarTheme(SnackBarThemeDataI data, WidgetI child) {
    return SnackBarThemeSnackBarThemeBuilder.snackBarThemeSnackBarTheme(data, child);
  }
  public static SnackBarThemeData of(BuildContextI context) {
    int id = factories.snackBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    return new SnackBarThemeData(id);
  }
  public SnackBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeData", getId());
      return new SnackBarThemeData(__nid);
    }
    return factories.SnackBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public SnackBarTheme build() {
    return this;
  }
}
