import 'dart:async';

/// Named typedef for the futureThen callback. Parametrizing as `<T>` and
/// instantiating with `<Object?>` at the [FutureMethods.then] receiver site
/// is what makes the generator's typedef path emit the `ForObjectOpt` suffix
/// + `DartObj*` C signature — same fix that unblocked
/// `Form.onPopInvokedWithResult`. An anonymous `void Function(Object?)`
/// would produce the raw `VoidCallbackDartObj` alias without nullability
/// info, emitting C `DartObj` (no pointer) and leaving the Java
/// unmarshaller (which dereferences pointer-to-int) trying to
/// `.reinterpret()` a raw int → compile error.
typedef FutureThenCallback<T> = void Function(T value);

/// Companion for `Future`. Exposes `then` — the Java-facing bridge to
/// Dart's `Future.then` — so a `Future<T>` returned by any generator-emitted
/// top-level (`showDatePicker`, `showTimePicker`, `showDateRangePicker`,
/// `showDialog`, plus any future async API) can be observed from Java as
/// `future.then(consumer)` instead of falling back to hand-rolled dialogs.
///
/// The Java surface is `public void then(Consumer<T> onValue)` on the
/// generated `Future.java`, with the callback firing exactly once when the
/// underlying Dart future resolves (`null` for `Future<T?>` that resolved
/// to null — e.g. `showDatePicker` when the user hits Cancel). The T is
/// erased at the FFI (arrives as opaque `NativeObj`); the enclosing
/// `Future<T>` type parameter is what the caller declares — an incompatible
/// declared T will fail at the first typed use of the callback arg, not
/// here.
class FutureMethods {
  static void then(Future<Object?> self, FutureThenCallback<Object?> onValue) =>
      self.then(onValue);
}
