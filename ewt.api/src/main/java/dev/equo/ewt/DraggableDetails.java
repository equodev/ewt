package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DraggableDetails extends NativeObj.Base implements DraggableDetailsI {
  protected DraggableDetails() {}
  DraggableDetails(int id) {
    this.id = id;
  }
  public static DraggableDetails byId(int id) { return new DraggableDetails(id); }
  @Builder.Factory
  static DraggableDetails draggableDetailsDraggableDetails(Optional<Boolean> wasAccepted, VelocityI velocity, OffsetI offset) {
    int id = factories.draggableDetailsDraggableDetails(wasAccepted,
      velocity.build(),
      offset.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DraggableDetails");
    System.out.println("New DraggableDetails id:"+id);
    return new DraggableDetails(id);
  }
  public static DraggableDetailsDraggableDetailsBuilder draggableDetails() {
    return DraggableDetailsDraggableDetailsBuilder.draggableDetailsDraggableDetails();
  }
  public boolean wasAccepted() {
    int id = factories.draggableDetailsWasAccepted(this);
    if (id <= 0) throw new RuntimeException("Failed to call wasAccepted");
    return intToBool(id);
  }
  public Velocity velocity() {
    MemorySegment id = factories.draggableDetailsVelocity(this);
    return new Velocity(id);
  }
  public Offset offset() {
    int id = factories.draggableDetailsOffset(this);
    if (id <= 0) throw new RuntimeException("Failed to call offset");
    return new Offset(id);
  }
  @Override
  public DraggableDetails build() {
    return this;
  }
}
