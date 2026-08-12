package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DragUpdateDetails extends NativeObj.Base implements DragUpdateDetailsI {
  protected DragUpdateDetails() {}
  DragUpdateDetails(int id) {
    this.id = id;
  }
  public static DragUpdateDetails byId(int id) { return new DragUpdateDetails(id); }
  @Builder.Factory
  static DragUpdateDetails dragUpdateDetailsDragUpdateDetails(@Builder.Parameter OffsetI globalPosition, Optional<OffsetI> localPosition, Optional<DurationI> sourceTimeStamp, Optional<OffsetI> delta, OptionalDouble primaryDelta, Optional<PointerDeviceKind> kind) {
    int id = factories.dragUpdateDetailsDragUpdateDetails(globalPosition.build(),
      localPosition.map(OffsetI::build),
      sourceTimeStamp.map(DurationI::build),
      delta.map(OffsetI::build),
      primaryDelta,
      kind);
    if (id <= 0) throw new RuntimeException("Failed to created widget DragUpdateDetails");
    System.out.println("New DragUpdateDetails id:"+id);
    return new DragUpdateDetails(id);
  }
  public static DragUpdateDetailsDragUpdateDetailsBuilder dragUpdateDetails(OffsetI globalPosition) {
    return DragUpdateDetailsDragUpdateDetailsBuilder.dragUpdateDetailsDragUpdateDetails(globalPosition);
  }
  @Override
  public DragUpdateDetails build() {
    return this;
  }
}
