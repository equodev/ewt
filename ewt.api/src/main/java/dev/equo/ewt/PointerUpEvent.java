package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PointerUpEventObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PointerUpEvent extends PointerEvent implements PointerUpEventI {
  private MemorySegment st;
  protected PointerUpEvent() {}
  PointerUpEvent(MemorySegment st) {
    this.id = PointerUpEventObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerUpEvent");
    System.out.println("New PointerUpEvent id:"+id);
  }
  PointerUpEvent(int id) { this.id = id; }
  @Builder.Factory
  static PointerUpEvent pointerUpEventPointerUpEvent(OptionalInt viewId, Optional<DurationI> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<OffsetI> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    var st = factories.pointerUpEventPointerUpEvent(viewId,
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
    if (st == null) throw new RuntimeException("Failed to created widget PointerUpEvent");
    return new PointerUpEvent(st);
  }
  public static PointerUpEventPointerUpEventBuilder pointerUpEvent() {
    return PointerUpEventPointerUpEventBuilder.pointerUpEventPointerUpEvent();
  }
  @Override
  public PointerUpEvent build() {
    return this;
  }
}
