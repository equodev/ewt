package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CalendarDatePickerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CalendarDatePicker extends StatefulWidget implements CalendarDatePickerI {
  private MemorySegment st;
  protected CalendarDatePicker() {}
  CalendarDatePicker(MemorySegment st) {
    this.id = CalendarDatePickerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CalendarDatePicker");
    System.out.println("New CalendarDatePicker id:"+id);
  }
  CalendarDatePicker(int id) { this.id = id; }
  @Builder.Factory
  static CalendarDatePicker calendarDatePickerCalendarDatePicker(Optional<DateTimeI> initialDate, DateTimeI firstDate, DateTimeI lastDate, Optional<DateTimeI> currentDate, Consumer<DateTime> onDateChanged, Optional<Consumer<DateTime>> onDisplayedMonthChanged, Optional<DatePickerMode> initialCalendarMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate) {
    var st = factories.calendarDatePickerCalendarDatePicker(initialDate.map(DateTimeI::build),
      firstDate.build(),
      lastDate.build(),
      currentDate.map(DateTimeI::build),
      onDateChanged,
      onDisplayedMonthChanged,
      initialCalendarMode,
      selectableDayPredicate);
    if (st == null) throw new RuntimeException("Failed to created widget CalendarDatePicker");
    return new CalendarDatePicker(st);
  }
  public static CalendarDatePickerCalendarDatePickerBuilder calendarDatePicker() {
    return CalendarDatePickerCalendarDatePickerBuilder.calendarDatePickerCalendarDatePicker();
  }
  public DateTime initialDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("calendarDatePickerInitialDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(CalendarDatePickerObjSt.initialDate(st));
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("calendarDatePickerFirstDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(CalendarDatePickerObjSt.firstDate(st));
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("calendarDatePickerLastDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(CalendarDatePickerObjSt.lastDate(st));
  }
  public DateTime currentDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("calendarDatePickerCurrentDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(CalendarDatePickerObjSt.currentDate(st));
  }
  public DatePickerMode initialCalendarMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("calendarDatePickerInitialCalendarMode not supported on web");
    return DatePickerMode.values()[CalendarDatePickerObjSt.initialCalendarMode(st)];
  }
  @Override
  public CalendarDatePicker build() {
    return this;
  }
}
