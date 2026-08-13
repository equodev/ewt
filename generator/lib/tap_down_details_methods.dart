import 'package:flutter/gestures.dart';

/// Companion for `TapDownDetails`. Exposes the value-holder's fields as
/// instance methods on the generated `TapDownDetails.java` — see
/// `animation_controller_methods.dart` for the pattern.
///
/// Smoke test for exposing gesture value-holder data on the Java side.
class TapDownDetailsMethods {
  static Offset globalPosition(TapDownDetails self) => self.globalPosition;
  static Offset localPosition(TapDownDetails self) => self.localPosition;
}
