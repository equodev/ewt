package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DragStartDetails extends NativeObj.Base implements DragStartDetailsI {
  protected DragStartDetails() {}
  DragStartDetails(int id) {
    this.id = id;
  }
  public static DragStartDetails byId(int id) { return new DragStartDetails(id); }
  @Builder.Factory
  static DragStartDetails dragStartDetailsDragStartDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<DurationI> sourceTimeStamp, Optional<PointerDeviceKind> kind) {
    int id = factories.dragStartDetailsDragStartDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      sourceTimeStamp.map(DurationI::build),
      kind);
    if (id <= 0) throw new RuntimeException("Failed to created widget DragStartDetails");
    System.out.println("New DragStartDetails id:"+id);
    return new DragStartDetails(id);
  }
  public static DragStartDetailsDragStartDetailsBuilder dragStartDetails() {
    return DragStartDetailsDragStartDetailsBuilder.dragStartDetailsDragStartDetails();
  }
  public Offset globalPosition() {
    int id = factories.dragStartDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    int id = factories.dragStartDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  @Override
  public DragStartDetails build() {
    return this;
  }
}
