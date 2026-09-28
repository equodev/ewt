package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PointerExitEvent extends PointerEvent implements PointerExitEventI {
  protected PointerExitEvent() {}
  PointerExitEvent(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerExitEvent");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PointerExitEvent pointerExitEventPointerExitEvent(OptionalInt viewId, Optional<DurationI> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<OffsetI> position, Optional<OffsetI> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    int id = factories.pointerExitEventPointerExitEvent(viewId,
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
      down,
      synthesized,
      embedderId);
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerExitEvent");
    return new PointerExitEvent(id);
  }
  public static PointerExitEventPointerExitEventBuilder pointerExitEvent() {
    return PointerExitEventPointerExitEventBuilder.pointerExitEventPointerExitEvent();
  }
  @Builder.Factory
  static PointerExitEvent pointerExitEventFromMouseEvent(@Builder.Parameter PointerEventI event) {
    int id = factories.pointerExitEventFromMouseEvent(event.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerExitEvent");
    return new PointerExitEvent(id);
  }
  public static PointerExitEventFromMouseEventBuilder fromMouseEvent(PointerEventI event) {
    return PointerExitEventFromMouseEventBuilder.pointerExitEventFromMouseEvent(event);
  }
  @Override
  public PointerExitEvent build() {
    return this;
  }
}
