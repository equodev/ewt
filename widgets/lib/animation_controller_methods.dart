part of 'factories.dart';

/// Runtime forwarder consumed by generator-emitted FFI adapters. Mirrors the
/// generator spec `AnimationControllerMethods`. Each static delegates to the
/// matching operation on the real Flutter `AnimationController`.
class AnimationControllerMethods {
  static void forward(AnimationController self) => self.forward();
  static void reverse(AnimationController self) => self.reverse();
  static void stop(AnimationController self) => self.stop();
  static void repeat(AnimationController self) => self.repeat();
  static void reset(AnimationController self) => self.reset();
  static void setDuration(AnimationController self, Duration d) => self.duration = d;
  static void setReverseDuration(AnimationController self, Duration d) => self.reverseDuration = d;
}
