package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class DragEndDetails extends NativeObj.Base implements DragEndDetailsI {
  protected DragEndDetails() {}
  DragEndDetails(int id) {
    this.id = id;
  }
  public static DragEndDetails byId(int id) { return new DragEndDetails(id); }
  static { NativeObj.register("DragEndDetails", DragEndDetails::byId); }
  @Builder.Factory
  static DragEndDetails dragEndDetailsDragEndDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<VelocityI> velocity, OptionalDouble primaryVelocity) {
    var id = factories.dragEndDetailsDragEndDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      velocity.map(VelocityI::build),
      primaryVelocity);
    if (id <= 0) throw new RuntimeException("Failed to created widget DragEndDetails");
    return new DragEndDetails(id);
  }
  public static DragEndDetailsDragEndDetailsBuilder dragEndDetails() {
    return DragEndDetailsDragEndDetailsBuilder.dragEndDetailsDragEndDetails();
  }
  public Offset globalPosition() {
    var id = factories.dragEndDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    var id = factories.dragEndDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  public Velocity velocity() {
    var id = factories.dragEndDetailsVelocity(this);
    if (id <= 0) throw new RuntimeException("Failed to call velocity");
    return new Velocity(id);
  }
  @Override
  public DragEndDetails build() {
    return this;
  }
}
