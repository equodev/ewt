package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TimePickerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TimePickerTheme extends InheritedTheme implements TimePickerThemeI {
  private MemorySegment st;
  protected TimePickerTheme() {}
  TimePickerTheme(MemorySegment st) {
    this.id = TimePickerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerTheme");
    System.out.println("New TimePickerTheme id:"+id);
  }
  TimePickerTheme(int id) { this.id = id; }
  @Builder.Factory
  static TimePickerTheme timePickerThemeTimePickerTheme(@Builder.Parameter TimePickerThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.timePickerThemeTimePickerTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TimePickerTheme");
    return new TimePickerTheme(st);
  }
  public static TimePickerThemeTimePickerThemeBuilder timePickerTheme(TimePickerThemeDataI data, WidgetI child) {
    return TimePickerThemeTimePickerThemeBuilder.timePickerThemeTimePickerTheme(data, child);
  }
  public static TimePickerThemeData of(BuildContextI context) {
    var st = factories.timePickerThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    return new TimePickerThemeData(st);
  }
  public TimePickerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TimePickerThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TimePickerThemeDataObjSt.id(__st, __nid);
      return new TimePickerThemeData(__st);
    }
    return new TimePickerThemeData(TimePickerThemeObjSt.data(st));
  }
  @Override
  public TimePickerTheme build() {
    return this;
  }
}
