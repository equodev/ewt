package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PointerHoverEvent extends PointerEvent implements PointerHoverEventI {
  protected PointerHoverEvent() {}
  PointerHoverEvent(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerHoverEvent");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PointerHoverEvent pointerHoverEventPointerHoverEvent(OptionalInt viewId, Optional<DurationI> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<OffsetI> position, Optional<OffsetI> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> synthesized, OptionalInt embedderId) {
    int id = factories.pointerHoverEventPointerHoverEvent(viewId,
      timeStamp.map(DurationI::build),
      kind,
      pointer,
      device,
      position.map(OffsetI::build),
      delta.map(OffsetI::build),
      buttons,
      obscured,
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
      synthesized,
      embedderId);
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerHoverEvent");
    return new PointerHoverEvent(id);
  }
  public static PointerHoverEventPointerHoverEventBuilder pointerHoverEvent() {
    return PointerHoverEventPointerHoverEventBuilder.pointerHoverEventPointerHoverEvent();
  }
  @Override
  public PointerHoverEvent build() {
    return this;
  }
}
