import 'package:flutter/widgets.dart';

/// Companion class for `AnimationController`. The generator detects classes named
/// `<TargetClass>Methods` and emits their public static methods as instance methods
/// on the target class's generated Java file. The first parameter (typed as the
/// target class) is the implicit receiver.
class AnimationControllerMethods {
  static void forward(AnimationController self) => self.forward();
  static void reverse(AnimationController self) => self.reverse();
  static void stop(AnimationController self) => self.stop();
  static void repeat(AnimationController self) => self.repeat();
  static void reset(AnimationController self) => self.reset();
  static void setDuration(AnimationController self, Duration d) => self.duration = d;
  static void setReverseDuration(AnimationController self, Duration d) => self.reverseDuration = d;
}
