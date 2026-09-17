import 'package:flutter/widgets.dart';

/// Companion for `DateTime`. Exposes the calendar-component getters
/// (`year` / `month` / `day` / `hour` / `minute` / `second` /
/// `millisecondsSinceEpoch`) so Java code that receives a `DateTime` from a
/// callback (e.g. `CalendarDatePicker.onDateChanged`) can convert it into a
/// `java.time.LocalDate` — without these accessors the `DateTime` handle is
/// opaque and the picked value cannot leave the Dart side.
class DateTimeMethods {
  static int year(DateTime self) => self.year;
  static int month(DateTime self) => self.month;
  static int day(DateTime self) => self.day;
  static int hour(DateTime self) => self.hour;
  static int minute(DateTime self) => self.minute;
  static int second(DateTime self) => self.second;
  static int millisecondsSinceEpoch(DateTime self) => self.millisecondsSinceEpoch;
}
