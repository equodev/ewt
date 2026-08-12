package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PointerHoverEventObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PointerHoverEvent extends PointerEvent implements PointerHoverEventI {
  private MemorySegment st;
  protected PointerHoverEvent() {}
  PointerHoverEvent(MemorySegment st) {
    this.id = PointerHoverEventObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerHoverEvent");
    System.out.println("New PointerHoverEvent id:"+id);
  }
  PointerHoverEvent(int id) { this.id = id; }
  @Builder.Factory
  static PointerHoverEvent pointerHoverEventPointerHoverEvent(OptionalInt viewId, Optional<DurationI> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<OffsetI> position, Optional<OffsetI> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> synthesized, OptionalInt embedderId) {
    var st = factories.pointerHoverEventPointerHoverEvent(viewId,
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
    if (st == null) throw new RuntimeException("Failed to created widget PointerHoverEvent");
    return new PointerHoverEvent(st);
  }
  public static PointerHoverEventPointerHoverEventBuilder pointerHoverEvent() {
    return PointerHoverEventPointerHoverEventBuilder.pointerHoverEventPointerHoverEvent();
  }
  @Override
  public PointerHoverEvent build() {
    return this;
  }
}
