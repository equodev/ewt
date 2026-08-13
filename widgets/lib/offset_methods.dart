part of 'factories.dart';

/// Runtime forwarder consumed by generator-emitted FFI adapters. Mirrors
/// the generator spec `OffsetMethods`.
class OffsetMethods {
  static double dx(Offset self) => self.dx;
  static double dy(Offset self) => self.dy;
}
