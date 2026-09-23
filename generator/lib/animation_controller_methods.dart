import 'package:flutter/widgets.dart';

/// Companion class for `AnimationController`. The generator detects classes named
/// `<TargetClass>Methods` and emits their public static methods as instance methods
/// on the target class's generated Java file. The first parameter (typed as the
/// target class) is the implicit receiver.
///
/// **Two return-shape conventions coexist here:**
///
/// * **`void`** — stateful mutators that do not model an "operation completing"
///   (`stop`, `reset`, `setValue`, `setDuration`, `setReverseDuration`). These
///   route through the shape's `writeVoidMethodWebPrelude` in web mode.
///
/// * **`Future<Object?>`** — operations whose Flutter counterpart returns
///   `TickerFuture` (`forward`, `reverse`, `repeat`, `toggle`, `fling`,
///   `animateTo`, `animateBack`). The Java surface returns `Future<Object?>`
///   so callers can `.then(consumer)` on animation completion. The shape's
///   `writeNonVoidMethodWebPrelude` inserts a web-mode branch that ships the
///   call as an async command (see `EwtWebState.sendAsyncAnimCommand`) and
///   the returned future resolves when the web side reports completion.
///
/// The `.then((_) => null)` idiom converts Flutter's `TickerFuture` (which
/// extends `Future<void>`) into a `Future<Object?>` — the wider type that the
/// generator's future-marshalling infrastructure expects.
///
/// Sibling: `widgets/lib/animation_controller_methods.dart` is the runtime
/// forwarder. Every public static declared here MUST have a matching one
/// there — see `generator/test/companion_drift_test.dart` for the CI guard.
class AnimationControllerMethods {
  static Future<Object?> forward(AnimationController self) => self.forward().then((_) => null);
  static Future<Object?> reverse(AnimationController self) => self.reverse().then((_) => null);
  static Future<Object?> repeat(AnimationController self) => self.repeat().then((_) => null);
  static Future<Object?> toggle(AnimationController self) => self.toggle().then((_) => null);
  static Future<Object?> fling(AnimationController self, double velocity) =>
      self.fling(velocity: velocity).then((_) => null);
  // Curve is deliberately absent — its serialization to the web transport is
  // deferred to a follow-up (see docs/gen_structure.md §4). The web path uses
  // the linear default; on desktop we also invoke Flutter's default (linear).
  static Future<Object?> animateTo(AnimationController self, double target, Duration duration) =>
      self.animateTo(target, duration: duration).then((_) => null);
  static Future<Object?> animateBack(AnimationController self, double target, Duration duration) =>
      self.animateBack(target, duration: duration).then((_) => null);

  static void stop(AnimationController self) => self.stop();
  static void reset(AnimationController self) => self.reset();
  static void setValue(AnimationController self, double v) => self.value = v;
  static void setDuration(AnimationController self, Duration d) => self.duration = d;
  static void setReverseDuration(AnimationController self, Duration d) => self.reverseDuration = d;
}
