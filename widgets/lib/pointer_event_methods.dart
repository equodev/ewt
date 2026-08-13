part of 'factories.dart';

/// Fields defined on the PointerEvent superclass — inherited by every
/// `Pointer*Event` subclass on the emitted Java side. Skips nullable-enum
/// / nullable-numeric getters for now (PointerDeviceKind? etc.).
class PointerEventMethods {
  static Offset position(PointerEvent self) => self.position;
  static Offset delta(PointerEvent self) => self.delta;
  static int pointer(PointerEvent self) => self.pointer;
  static int buttons(PointerEvent self) => self.buttons;
  static bool down(PointerEvent self) => self.down;
  static double pressure(PointerEvent self) => self.pressure;
  static double distance(PointerEvent self) => self.distance;
  static double size(PointerEvent self) => self.size;
}
