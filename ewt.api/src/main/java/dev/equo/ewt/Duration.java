package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Duration extends NativeObj.Base implements DurationI {
  protected Duration() {}
  Duration(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Duration durationDuration(OptionalInt days, OptionalInt hours, OptionalInt minutes, OptionalInt seconds, OptionalInt milliseconds, OptionalInt microseconds) {
    int id = factories.durationDuration(days,
      hours,
      minutes,
      seconds,
      milliseconds,
      microseconds);
    if (id == -1) throw new RuntimeException("Failed to created widget Duration");
    System.out.println("New Duration id:"+id);
    return new Duration(id);
  }
  public static DurationDurationBuilder duration() {
    return DurationDurationBuilder.durationDuration();
  }
  public static int microsecondsPerMillisecond() {
    return 1000;
  }
  public static int millisecondsPerSecond() {
    return 1000;
  }
  public static int secondsPerMinute() {
    return 60;
  }
  public static int minutesPerHour() {
    return 60;
  }
  public static int hoursPerDay() {
    return 24;
  }
  public static int microsecondsPerSecond() {
    return microsecondsPerMillisecond() * millisecondsPerSecond();
  }
  public static int microsecondsPerMinute() {
    return microsecondsPerSecond() * secondsPerMinute();
  }
  public static int microsecondsPerHour() {
    return microsecondsPerMinute() * minutesPerHour();
  }
  public static int microsecondsPerDay() {
    return microsecondsPerHour() * hoursPerDay();
  }
  public static int millisecondsPerMinute() {
    return millisecondsPerSecond() * secondsPerMinute();
  }
  public static int millisecondsPerHour() {
    return millisecondsPerMinute() * minutesPerHour();
  }
  public static int millisecondsPerDay() {
    return millisecondsPerHour() * hoursPerDay();
  }
  public static int secondsPerHour() {
    return secondsPerMinute() * minutesPerHour();
  }
  public static int secondsPerDay() {
    return secondsPerHour() * hoursPerDay();
  }
  public static int minutesPerDay() {
    return minutesPerHour() * hoursPerDay();
  }
  public static Duration zero() {
    return Duration.duration().seconds(0).build();
  }
  @Override
  public Duration build() {
    return this;
  }
}
