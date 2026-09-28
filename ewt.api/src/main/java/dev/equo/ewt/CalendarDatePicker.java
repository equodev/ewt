package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CalendarDatePicker extends StatefulWidget implements CalendarDatePickerI {
  protected CalendarDatePicker() {}
  CalendarDatePicker(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CalendarDatePicker");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CalendarDatePicker calendarDatePickerCalendarDatePicker(Optional<DateTimeI> initialDate, DateTimeI firstDate, DateTimeI lastDate, Optional<DateTimeI> currentDate, Consumer<DateTime> onDateChanged, Optional<Consumer<DateTime>> onDisplayedMonthChanged, Optional<DatePickerMode> initialCalendarMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate) {
    int id = factories.calendarDatePickerCalendarDatePicker(initialDate.map(DateTimeI::build),
      firstDate.build(),
      lastDate.build(),
      currentDate.map(DateTimeI::build),
      onDateChanged,
      onDisplayedMonthChanged,
      initialCalendarMode,
      selectableDayPredicate);
    if (id <= 0) throw new RuntimeException("Failed to created widget CalendarDatePicker");
    return new CalendarDatePicker(id);
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
    return factories.CalendarDatePicker_readBack_initialDate(nativeStruct);
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("calendarDatePickerFirstDate", getId());
      return new DateTime(__nid);
    }
    return factories.CalendarDatePicker_readBack_firstDate(nativeStruct);
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("calendarDatePickerLastDate", getId());
      return new DateTime(__nid);
    }
    return factories.CalendarDatePicker_readBack_lastDate(nativeStruct);
  }
  public DateTime currentDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("calendarDatePickerCurrentDate", getId());
      return new DateTime(__nid);
    }
    return factories.CalendarDatePicker_readBack_currentDate(nativeStruct);
  }
  public DatePickerMode initialCalendarMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("calendarDatePickerInitialCalendarMode not supported on web");
    return factories.CalendarDatePicker_readBack_initialCalendarMode(nativeStruct);
  }
  @Override
  public CalendarDatePicker build() {
    return this;
  }
}
