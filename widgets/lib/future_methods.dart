part of 'factories.dart';

/// See generator-side spec at `generator/lib/future_methods.dart`.
typedef FutureThenCallback<T> = void Function(T value);

/// Runtime forwarder consumed by generator-emitted FFI adapters. Mirrors
/// the generator spec `FutureMethods`.
class FutureMethods {
  static void then(Future<Object?> self, FutureThenCallback<Object?> onValue) =>
      self.then(onValue);
}
