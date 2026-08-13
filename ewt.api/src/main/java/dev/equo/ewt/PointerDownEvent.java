package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PointerDownEventObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PointerDownEvent extends PointerEvent implements PointerDownEventI {
  private MemorySegment st;
  protected PointerDownEvent() {}
  PointerDownEvent(MemorySegment st) {
    this.id = PointerDownEventObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PointerDownEvent");
    System.out.println("New PointerDownEvent id:"+id);
  }
  PointerDownEvent(int id) { this.id = id; }
  @Builder.Factory
  static PointerDownEvent pointerDownEventPointerDownEvent(OptionalInt viewId, Optional<DurationI> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<OffsetI> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    var st = factories.pointerDownEventPointerDownEvent(viewId,
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
    if (st == null) throw new RuntimeException("Failed to created widget PointerDownEvent");
    return new PointerDownEvent(st);
  }
  public static PointerDownEventPointerDownEventBuilder pointerDownEvent() {
    return PointerDownEventPointerDownEventBuilder.pointerDownEventPointerDownEvent();
  }
  @Override
  public PointerDownEvent build() {
    return this;
  }
}
