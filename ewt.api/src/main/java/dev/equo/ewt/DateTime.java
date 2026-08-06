package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DateTime extends NativeObj.Base implements DateTimeI {
  protected DateTime() {}
  DateTime(int id) {
    this.id = id;
  }
  public static DateTime byId(int id) { return new DateTime(id); }
  @Builder.Factory
  static DateTime dateTimeDateTime(@Builder.Parameter int year, OptionalInt month, OptionalInt day, OptionalInt hour, OptionalInt minute, OptionalInt second, OptionalInt millisecond, OptionalInt microsecond) {
    int id = factories.dateTimeDateTime(year,
      month,
      day,
      hour,
      minute,
      second,
      millisecond,
      microsecond);
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime");
    System.out.println("New DateTime id:"+id);
    return new DateTime(id);
  }
  public static DateTimeDateTimeBuilder dateTime(int year) {
    return DateTimeDateTimeBuilder.dateTimeDateTime(year);
  }
  @Builder.Factory
  static DateTime dateTimeUtc(@Builder.Parameter int year, OptionalInt month, OptionalInt day, OptionalInt hour, OptionalInt minute, OptionalInt second, OptionalInt millisecond, OptionalInt microsecond) {
    int id = factories.dateTimeUtc(year,
      month,
      day,
      hour,
      minute,
      second,
      millisecond,
      microsecond);
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime");
    System.out.println("New DateTime id:"+id);
    return new DateTime(id);
  }
  public static DateTimeUtcBuilder utc(int year) {
    return DateTimeUtcBuilder.dateTimeUtc(year);
  }
  @Builder.Factory
  static DateTime dateTimeNow() {
    int id = factories.dateTimeNow();
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime");
    System.out.println("New DateTime id:"+id);
    return new DateTime(id);
  }
  public static DateTimeNowBuilder now() {
    return DateTimeNowBuilder.dateTimeNow();
  }
  @Builder.Factory
  static DateTime dateTimeTimestamp() {
    int id = factories.dateTimeTimestamp();
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime");
    System.out.println("New DateTime id:"+id);
    return new DateTime(id);
  }
  public static DateTimeTimestampBuilder timestamp() {
    return DateTimeTimestampBuilder.dateTimeTimestamp();
  }
  @Builder.Factory
  static DateTime dateTimeFromMillisecondsSinceEpoch(@Builder.Parameter int millisecondsSinceEpoch, Optional<Boolean> isUtc) {
    int id = factories.dateTimeFromMillisecondsSinceEpoch(millisecondsSinceEpoch,
      isUtc);
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime");
    System.out.println("New DateTime id:"+id);
    return new DateTime(id);
  }
  public static DateTimeFromMillisecondsSinceEpochBuilder fromMillisecondsSinceEpoch(int millisecondsSinceEpoch) {
    return DateTimeFromMillisecondsSinceEpochBuilder.dateTimeFromMillisecondsSinceEpoch(millisecondsSinceEpoch);
  }
  @Builder.Factory
  static DateTime dateTimeFromMicrosecondsSinceEpoch(@Builder.Parameter int microsecondsSinceEpoch, Optional<Boolean> isUtc) {
    int id = factories.dateTimeFromMicrosecondsSinceEpoch(microsecondsSinceEpoch,
      isUtc);
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime");
    System.out.println("New DateTime id:"+id);
    return new DateTime(id);
  }
  public static DateTimeFromMicrosecondsSinceEpochBuilder fromMicrosecondsSinceEpoch(int microsecondsSinceEpoch) {
    return DateTimeFromMicrosecondsSinceEpochBuilder.dateTimeFromMicrosecondsSinceEpoch(microsecondsSinceEpoch);
  }
  public static DateTime parse(String formattedString) {
    int id = factories.dateTimeParse(formattedString);
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime");
    System.out.println("New DateTime id:"+id);
    return new DateTime(id);
  }
  public static DateTime tryParse(String formattedString) {
    int id = factories.dateTimeTryParse(formattedString);
    if (id <= 0) throw new RuntimeException("Failed to created widget DateTime?");
    System.out.println("New DateTime? id:"+id);
    return new DateTime(id);
  }
  public static int monday() {
    return 1;
  }
  public static int tuesday() {
    return 2;
  }
  public static int wednesday() {
    return 3;
  }
  public static int thursday() {
    return 4;
  }
  public static int friday() {
    return 5;
  }
  public static int saturday() {
    return 6;
  }
  public static int sunday() {
    return 7;
  }
  public static int daysPerWeek() {
    return 7;
  }
  public static int january() {
    return 1;
  }
  public static int february() {
    return 2;
  }
  public static int march() {
    return 3;
  }
  public static int april() {
    return 4;
  }
  public static int may() {
    return 5;
  }
  public static int june() {
    return 6;
  }
  public static int july() {
    return 7;
  }
  public static int august() {
    return 8;
  }
  public static int september() {
    return 9;
  }
  public static int october() {
    return 10;
  }
  public static int november() {
    return 11;
  }
  public static int december() {
    return 12;
  }
  public static int monthsPerYear() {
    return 12;
  }
  @Override
  public DateTime build() {
    return this;
  }
}
