package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TimePickerTheme extends InheritedTheme implements TimePickerThemeI {
  protected TimePickerTheme() {}
  TimePickerTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TimePickerTheme timePickerThemeTimePickerTheme(@Builder.Parameter TimePickerThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.timePickerThemeTimePickerTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerTheme");
    return new TimePickerTheme(id);
  }
  public static TimePickerThemeTimePickerThemeBuilder timePickerTheme(TimePickerThemeDataI data, WidgetI child) {
    return TimePickerThemeTimePickerThemeBuilder.timePickerThemeTimePickerTheme(data, child);
  }
  public static TimePickerThemeData of(BuildContextI context) {
    int id = factories.timePickerThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    return new TimePickerThemeData(id);
  }
  public TimePickerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeData", getId());
      return new TimePickerThemeData(__nid);
    }
    return factories.TimePickerTheme_readBack_data(nativeStruct);
  }
  @Override
  public TimePickerTheme build() {
    return this;
  }
}
