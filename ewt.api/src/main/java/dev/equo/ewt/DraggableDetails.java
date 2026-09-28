package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class DraggableDetails extends NativeObj.Base implements DraggableDetailsI {
  protected DraggableDetails() {}
  DraggableDetails(int id) {
    this.id = id;
  }
  public static DraggableDetails byId(int id) { return new DraggableDetails(id); }
  static { NativeObj.register("DraggableDetails", DraggableDetails::byId); }
  @Builder.Factory
  static DraggableDetails draggableDetailsDraggableDetails(Optional<Boolean> wasAccepted, VelocityI velocity, OffsetI offset) {
    var id = factories.draggableDetailsDraggableDetails(wasAccepted,
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
    var id = factories.draggableDetailsWasAccepted(this);
    if (id <= 0) throw new RuntimeException("Failed to call wasAccepted");
    return intToBool(id);
  }
  public Velocity velocity() {
    var id = factories.draggableDetailsVelocity(this);
    if (id <= 0) throw new RuntimeException("Failed to call velocity");
    return new Velocity(id);
  }
  public Offset offset() {
    var id = factories.draggableDetailsOffset(this);
    if (id <= 0) throw new RuntimeException("Failed to call offset");
    return new Offset(id);
  }
  @Override
  public DraggableDetails build() {
    return this;
  }
}
