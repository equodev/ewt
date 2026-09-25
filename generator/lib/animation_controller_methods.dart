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

  // TickerFuture-returning methods are exposed as void — the underlying Future
  // is discarded. Existing shape (ImperativeControllerGen.writeVoidMethodWebPrelude)
  // only routes void methods through the webCommand side-channel; exposing the
  // TickerFuture as Future<Object?> here would break web mode until the shape
  // grows a matching non-void hook. Follow-up: extend the shape and switch the
  // returns.
  static void animateTo(AnimationController self, double target, Duration duration, Curve curve) =>
      self.animateTo(target, duration: duration, curve: curve);
  static void animateBack(AnimationController self, double target, Duration duration, Curve curve) =>
      self.animateBack(target, duration: duration, curve: curve);
  static void toggle(AnimationController self) => self.toggle();
  static void fling(AnimationController self, double velocity) => self.fling(velocity: velocity);

  // .value setter — bypasses any running animation, snapping the controller.
  static void setValue(AnimationController self, double v) => self.value = v;
}
