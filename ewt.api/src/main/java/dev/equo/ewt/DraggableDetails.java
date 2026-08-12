package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
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
  @Override
  public DraggableDetails build() {
    return this;
  }
}
