package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TimeOfDayObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TimeOfDay extends NativeObj.Base implements TimeOfDayI {
  private MemorySegment st;
  protected TimeOfDay() {}
  TimeOfDay(MemorySegment st) {
    this.id = TimeOfDayObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimeOfDay");
    System.out.println("New TimeOfDay id:"+id);
  }
  TimeOfDay(int id) { this.id = id; }
  @Builder.Factory
  static TimeOfDay timeOfDayTimeOfDay(@Builder.Parameter int hour, @Builder.Parameter int minute) {
    var st = factories.timeOfDayTimeOfDay(hour,
      minute);
    if (st == null) throw new RuntimeException("Failed to created widget TimeOfDay");
    return new TimeOfDay(st);
  }
  public static TimeOfDayTimeOfDayBuilder timeOfDay(int hour, int minute) {
    return TimeOfDayTimeOfDayBuilder.timeOfDayTimeOfDay(hour, minute);
  }
  @Builder.Factory
  static TimeOfDay timeOfDayFromDateTime(@Builder.Parameter DateTimeI time) {
    var st = factories.timeOfDayFromDateTime(time.build());
    if (st == null) throw new RuntimeException("Failed to created widget TimeOfDay");
    return new TimeOfDay(st);
  }
  public static TimeOfDayFromDateTimeBuilder fromDateTime(DateTimeI time) {
    return TimeOfDayFromDateTimeBuilder.timeOfDayFromDateTime(time);
  }
  @Builder.Factory
  static TimeOfDay timeOfDayNow() {
    var st = factories.timeOfDayNow();
    if (st == null) throw new RuntimeException("Failed to created widget TimeOfDay");
    return new TimeOfDay(st);
  }
  public static TimeOfDayNowBuilder now() {
    return TimeOfDayNowBuilder.timeOfDayNow();
  }
  public int hour() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayHour not supported on web");
    return TimeOfDayObjSt.hour(st);
  }
  public int minute() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayMinute not supported on web");
    return TimeOfDayObjSt.minute(st);
  }
  public DayPeriod period() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayPeriod not supported on web");
    return DayPeriod.values()[TimeOfDayObjSt.period(st)];
  }
  public int hourOfPeriod() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayHourOfPeriod not supported on web");
    return TimeOfDayObjSt.hourOfPeriod(st);
  }
  public int periodOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayPeriodOffset not supported on web");
    return TimeOfDayObjSt.periodOffset(st);
  }
  public static int hoursPerDay() {
    return 24;
  }
  public static int hoursPerPeriod() {
    return 12;
  }
  public static int minutesPerHour() {
    return 60;
  }
  @Override
  public TimeOfDay build() {
    return this;
  }
}
