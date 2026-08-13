package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PointerExitEventObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PointerExitEvent extends PointerEvent implements PointerExitEventI {
  private MemorySegment st;
  protected PointerExitEvent() {}
  PointerExitEvent(MemorySegment st) {
    this.id = PointerExitEventObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerExitEvent");
    System.out.println("New PointerExitEvent id:"+id);
  }
  PointerExitEvent(int id) { this.id = id; }
  @Builder.Factory
  static PointerExitEvent pointerExitEventPointerExitEvent(OptionalInt viewId, Optional<DurationI> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<OffsetI> position, Optional<OffsetI> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    var st = factories.pointerExitEventPointerExitEvent(viewId,
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
    if (st == null) throw new RuntimeException("Failed to created widget PointerExitEvent");
    return new PointerExitEvent(st);
  }
  public static PointerExitEventPointerExitEventBuilder pointerExitEvent() {
    return PointerExitEventPointerExitEventBuilder.pointerExitEventPointerExitEvent();
  }
  @Builder.Factory
  static PointerExitEvent pointerExitEventFromMouseEvent(@Builder.Parameter PointerEventI event) {
    var st = factories.pointerExitEventFromMouseEvent(event.build());
    if (st == null) throw new RuntimeException("Failed to created widget PointerExitEvent");
    return new PointerExitEvent(st);
  }
  public static PointerExitEventFromMouseEventBuilder fromMouseEvent(PointerEventI event) {
    return PointerExitEventFromMouseEventBuilder.pointerExitEventFromMouseEvent(event);
  }
  @Override
  public PointerExitEvent build() {
    return this;
  }
}
