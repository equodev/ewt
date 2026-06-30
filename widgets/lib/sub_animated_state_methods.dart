part of 'factories.dart';

/// Runtime forwarder consumed by generator-emitted FFI adapters. Matches the
/// shape of the generator spec `SubAnimatedStateMethods` so generated code can
/// call `SubAnimatedStateMethods.animationController(receiver, ...)` and the
/// real runtime implementation handles it.
class SubAnimatedStateMethods {
  static AnimationController animationController(SubAnimatedState self, Duration duration) =>
      self.animationController(duration);
}
