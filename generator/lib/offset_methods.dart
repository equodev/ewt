import 'package:flutter/widgets.dart';

/// Companion for `Offset`. Exposes `dx`/`dy` (declared on the `OffsetBase`
/// superclass, so not picked up by the generator's own struct emission).
class OffsetMethods {
  static double dx(Offset self) => self.dx;
  static double dy(Offset self) => self.dy;
}
