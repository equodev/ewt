package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FilledButtonTheme extends InheritedTheme implements FilledButtonThemeI {
  protected FilledButtonTheme() {}
  FilledButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FilledButtonTheme filledButtonThemeFilledButtonTheme(@Builder.Parameter FilledButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.filledButtonThemeFilledButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonTheme");
    return new FilledButtonTheme(id);
  }
  public static FilledButtonThemeFilledButtonThemeBuilder filledButtonTheme(FilledButtonThemeDataI data, WidgetI child) {
    return FilledButtonThemeFilledButtonThemeBuilder.filledButtonThemeFilledButtonTheme(data, child);
  }
  public static FilledButtonThemeData of(BuildContextI context) {
    int id = factories.filledButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    return new FilledButtonThemeData(id);
  }
  public FilledButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filledButtonThemeData", getId());
      return new FilledButtonThemeData(__nid);
    }
    return factories.FilledButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public FilledButtonTheme build() {
    return this;
  }
}
