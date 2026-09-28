package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DatePickerTheme extends InheritedTheme implements DatePickerThemeI {
  protected DatePickerTheme() {}
  DatePickerTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DatePickerTheme datePickerThemeDatePickerTheme(@Builder.Parameter DatePickerThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.datePickerThemeDatePickerTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerTheme");
    return new DatePickerTheme(id);
  }
  public static DatePickerThemeDatePickerThemeBuilder datePickerTheme(DatePickerThemeDataI data, WidgetI child) {
    return DatePickerThemeDatePickerThemeBuilder.datePickerThemeDatePickerTheme(data, child);
  }
  public static DatePickerThemeData of(BuildContextI context) {
    int id = factories.datePickerThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(id);
  }
  public static DatePickerThemeData maybeOf(BuildContextI context) {
    int id = factories.datePickerThemeMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(id);
  }
  public static DatePickerThemeData defaults(BuildContextI context) {
    int id = factories.datePickerThemeDefaults(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(id);
  }
  public DatePickerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeData", getId());
      return new DatePickerThemeData(__nid);
    }
    return factories.DatePickerTheme_readBack_data(nativeStruct);
  }
  @Override
  public DatePickerTheme build() {
    return this;
  }
}
