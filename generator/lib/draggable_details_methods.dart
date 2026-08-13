import 'package:flutter/widgets.dart';

class DraggableDetailsMethods {
  static bool wasAccepted(DraggableDetails self) => self.wasAccepted;
  static Velocity velocity(DraggableDetails self) => self.velocity;
  static Offset offset(DraggableDetails self) => self.offset;
}
