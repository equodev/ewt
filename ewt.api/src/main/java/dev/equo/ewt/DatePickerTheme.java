package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DatePickerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DatePickerTheme extends InheritedTheme implements DatePickerThemeI {
  private MemorySegment st;
  protected DatePickerTheme() {}
  DatePickerTheme(MemorySegment st) {
    this.id = DatePickerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerTheme");
    System.out.println("New DatePickerTheme id:"+id);
  }
  DatePickerTheme(int id) { this.id = id; }
  @Builder.Factory
  static DatePickerTheme datePickerThemeDatePickerTheme(@Builder.Parameter DatePickerThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.datePickerThemeDatePickerTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DatePickerTheme");
    return new DatePickerTheme(st);
  }
  public static DatePickerThemeDatePickerThemeBuilder datePickerTheme(DatePickerThemeDataI data, WidgetI child) {
    return DatePickerThemeDatePickerThemeBuilder.datePickerThemeDatePickerTheme(data, child);
  }
  public static DatePickerThemeData of(BuildContextI context) {
    var st = factories.datePickerThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(st);
  }
  public static DatePickerThemeData maybeOf(BuildContextI context) {
    var st = factories.datePickerThemeMaybeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(st);
  }
  public static DatePickerThemeData defaults(BuildContextI context) {
    var st = factories.datePickerThemeDefaults(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(st);
  }
  public DatePickerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.DatePickerThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.DatePickerThemeDataObjSt.id(__st, __nid);
      return new DatePickerThemeData(__st);
    }
    return new DatePickerThemeData(DatePickerThemeObjSt.data(st));
  }
  @Override
  public DatePickerTheme build() {
    return this;
  }
}
