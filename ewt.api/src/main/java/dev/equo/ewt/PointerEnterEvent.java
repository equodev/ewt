package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PointerEnterEvent extends PointerEvent implements PointerEnterEventI {
  protected PointerEnterEvent() {}
  PointerEnterEvent(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerEnterEvent");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PointerEnterEvent pointerEnterEventPointerEnterEvent(OptionalInt viewId, Optional<DurationI> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<OffsetI> position, Optional<OffsetI> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    int id = factories.pointerEnterEventPointerEnterEvent(viewId,
      timeStamp.map(DurationI::build),
      pointer,
      kind,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerEnterEvent");
    return new PointerEnterEvent(id);
  }
  public static PointerEnterEventPointerEnterEventBuilder pointerEnterEvent() {
    return PointerEnterEventPointerEnterEventBuilder.pointerEnterEventPointerEnterEvent();
  }
  @Builder.Factory
  static PointerEnterEvent pointerEnterEventFromMouseEvent(@Builder.Parameter PointerEventI event) {
    int id = factories.pointerEnterEventFromMouseEvent(event.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerEnterEvent");
    return new PointerEnterEvent(id);
  }
  public static PointerEnterEventFromMouseEventBuilder fromMouseEvent(PointerEventI event) {
    return PointerEnterEventFromMouseEventBuilder.pointerEnterEventFromMouseEvent(event);
  }
  @Override
  public PointerEnterEvent build() {
    return this;
  }
}
