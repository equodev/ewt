package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PointerUpEvent extends PointerEvent implements PointerUpEventI {
  protected PointerUpEvent() {}
  PointerUpEvent(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerUpEvent");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PointerUpEvent pointerUpEventPointerUpEvent(OptionalInt viewId, Optional<DurationI> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<OffsetI> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    int id = factories.pointerUpEventPointerUpEvent(viewId,
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
      distance,
      distanceMax,
      size,
      radiusMajor,
      radiusMinor,
      radiusMin,
      radiusMax,
      orientation,
      tilt,
      embedderId);
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerUpEvent");
    return new PointerUpEvent(id);
  }
  public static PointerUpEventPointerUpEventBuilder pointerUpEvent() {
    return PointerUpEventPointerUpEventBuilder.pointerUpEventPointerUpEvent();
  }
  @Override
  public PointerUpEvent build() {
    return this;
  }
}
