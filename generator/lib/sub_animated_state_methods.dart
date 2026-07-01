import 'package:flutter/widgets.dart';
import 'sub_animated_state.dart';

/// Companion for `SubAnimatedState`: emits `animationController(...)` as an
/// instance method on the generated SubAnimatedState.java. The first parameter
/// (the receiver) is consumed and replaced by `this` in the FFM call. On the
/// Dart side the receiver is resolved through `_widgetsMap` and the call is
/// forwarded to the runtime `SubAnimatedState.animationController(...)`.
class SubAnimatedStateMethods {
  static AnimationController animationController(SubAnimatedState self, Duration duration) {
    throw UnimplementedError(
      'Generator spec only; the runtime SubAnimatedState provides this method.',
    );
  }
}
