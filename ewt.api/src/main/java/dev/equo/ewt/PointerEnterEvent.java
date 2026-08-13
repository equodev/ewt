package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PointerEnterEventObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PointerEnterEvent extends PointerEvent implements PointerEnterEventI {
  private MemorySegment st;
  protected PointerEnterEvent() {}
  PointerEnterEvent(MemorySegment st) {
    this.id = PointerEnterEventObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerEnterEvent");
    System.out.println("New PointerEnterEvent id:"+id);
  }
  PointerEnterEvent(int id) { this.id = id; }
  @Builder.Factory
  static PointerEnterEvent pointerEnterEventPointerEnterEvent(OptionalInt viewId, Optional<DurationI> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<OffsetI> position, Optional<OffsetI> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    var st = factories.pointerEnterEventPointerEnterEvent(viewId,
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
    if (st == null) throw new RuntimeException("Failed to created widget PointerEnterEvent");
    return new PointerEnterEvent(st);
  }
  public static PointerEnterEventPointerEnterEventBuilder pointerEnterEvent() {
    return PointerEnterEventPointerEnterEventBuilder.pointerEnterEventPointerEnterEvent();
  }
  @Builder.Factory
  static PointerEnterEvent pointerEnterEventFromMouseEvent(@Builder.Parameter PointerEventI event) {
    var st = factories.pointerEnterEventFromMouseEvent(event.build());
    if (st == null) throw new RuntimeException("Failed to created widget PointerEnterEvent");
    return new PointerEnterEvent(st);
  }
  public static PointerEnterEventFromMouseEventBuilder fromMouseEvent(PointerEventI event) {
    return PointerEnterEventFromMouseEventBuilder.pointerEnterEventFromMouseEvent(event);
  }
  @Override
  public PointerEnterEvent build() {
    return this;
  }
}
