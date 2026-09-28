package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PointerDownEvent extends PointerEvent implements PointerDownEventI {
  protected PointerDownEvent() {}
  PointerDownEvent(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerDownEvent");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PointerDownEvent pointerDownEventPointerDownEvent(OptionalInt viewId, Optional<DurationI> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<OffsetI> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    int id = factories.pointerDownEventPointerDownEvent(viewId,
      timeStamp.map(DurationI::build),
      pointer,
      kind,
      device,
      position.map(OffsetI::build),
      buttons,
      obscured,
      pressure,
      pressureMin,
      pressureMax,
      distanceMax,
      size,
      radiusMajor,
      radiusMinor,
      radiusMin,
      radiusMax,
      orientation,
      tilt,
      embedderId);
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerDownEvent");
    return new PointerDownEvent(id);
  }
  public static PointerDownEventPointerDownEventBuilder pointerDownEvent() {
    return PointerDownEventPointerDownEventBuilder.pointerDownEventPointerDownEvent();
  }
  @Override
  public PointerDownEvent build() {
    return this;
  }
}
