part of 'factories.dart';

/// Runtime forwarder consumed by generator-emitted FFI adapters. Mirrors the
/// generator spec `TapDownDetailsMethods`. Exposes the value-holder's fields
/// as callable statics so the emitted `TapDownDetails.globalPosition()` etc.
/// on the Java side can round-trip through Dart.
class TapDownDetailsMethods {
  static Offset globalPosition(TapDownDetails self) => self.globalPosition;
  static Offset localPosition(TapDownDetails self) => self.localPosition;
}
