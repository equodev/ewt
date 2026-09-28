package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TimeOfDay extends NativeObj.Base implements TimeOfDayI {
  protected TimeOfDay() {}
  TimeOfDay(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimeOfDay");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TimeOfDay timeOfDayTimeOfDay(@Builder.Parameter int hour, @Builder.Parameter int minute) {
    int id = factories.timeOfDayTimeOfDay(hour,
      minute);
    if (id <= 0) throw new RuntimeException("Failed to created widget TimeOfDay");
    return new TimeOfDay(id);
  }
  public static TimeOfDayTimeOfDayBuilder timeOfDay(int hour, int minute) {
    return TimeOfDayTimeOfDayBuilder.timeOfDayTimeOfDay(hour, minute);
  }
  @Builder.Factory
  static TimeOfDay timeOfDayFromDateTime(@Builder.Parameter DateTimeI time) {
    int id = factories.timeOfDayFromDateTime(time.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TimeOfDay");
    return new TimeOfDay(id);
  }
  public static TimeOfDayFromDateTimeBuilder fromDateTime(DateTimeI time) {
    return TimeOfDayFromDateTimeBuilder.timeOfDayFromDateTime(time);
  }
  @Builder.Factory
  static TimeOfDay timeOfDayNow() {
    int id = factories.timeOfDayNow();
    if (id <= 0) throw new RuntimeException("Failed to created widget TimeOfDay");
    return new TimeOfDay(id);
  }
  public static TimeOfDayNowBuilder now() {
    return TimeOfDayNowBuilder.timeOfDayNow();
  }
  public int hour() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayHour not supported on web");
    return factories.TimeOfDay_readBack_hour(nativeStruct);
  }
  public int minute() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayMinute not supported on web");
    return factories.TimeOfDay_readBack_minute(nativeStruct);
  }
  public DayPeriod period() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayPeriod not supported on web");
    return factories.TimeOfDay_readBack_period(nativeStruct);
  }
  public int hourOfPeriod() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayHourOfPeriod not supported on web");
    return factories.TimeOfDay_readBack_hourOfPeriod(nativeStruct);
  }
  public int periodOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timeOfDayPeriodOffset not supported on web");
    return factories.TimeOfDay_readBack_periodOffset(nativeStruct);
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
