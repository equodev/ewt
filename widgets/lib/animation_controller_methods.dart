part of 'factories.dart';

/// Runtime forwarder consumed by generator-emitted FFI adapters. Mirrors the
/// generator spec `AnimationControllerMethods` — every public static declared
/// in `generator/lib/animation_controller_methods.dart` MUST have a matching
/// one here, and vice versa. CI enforces the lockstep via
/// `generator/test/companion_drift_test.dart`.
class AnimationControllerMethods {
  static Future<Object?> forward(AnimationController self) => self.forward().then((_) => null);
  static Future<Object?> reverse(AnimationController self) => self.reverse().then((_) => null);
  static Future<Object?> repeat(AnimationController self) => self.repeat().then((_) => null);
  static Future<Object?> toggle(AnimationController self) => self.toggle().then((_) => null);
  static Future<Object?> fling(AnimationController self, double velocity) =>
      self.fling(velocity: velocity).then((_) => null);
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
