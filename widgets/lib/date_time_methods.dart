part of 'factories.dart';

/// Runtime forwarder consumed by generator-emitted FFI adapters. Mirrors
/// the generator spec `DateTimeMethods`.
class DateTimeMethods {
  static int year(DateTime self) => self.year;
  static int month(DateTime self) => self.month;
  static int day(DateTime self) => self.day;
  static int hour(DateTime self) => self.hour;
  static int minute(DateTime self) => self.minute;
  static int second(DateTime self) => self.second;
  static int millisecondsSinceEpoch(DateTime self) => self.millisecondsSinceEpoch;
}
