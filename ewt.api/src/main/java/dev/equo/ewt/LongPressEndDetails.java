package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class LongPressEndDetails extends NativeObj.Base implements LongPressEndDetailsI {
  protected LongPressEndDetails() {}
  LongPressEndDetails(int id) {
    this.id = id;
  }
  public static LongPressEndDetails byId(int id) { return new LongPressEndDetails(id); }
  static { NativeObj.register("LongPressEndDetails", LongPressEndDetails::byId); }
  @Builder.Factory
  static LongPressEndDetails longPressEndDetailsLongPressEndDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<VelocityI> velocity) {
    var id = factories.longPressEndDetailsLongPressEndDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      velocity.map(VelocityI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget LongPressEndDetails");
    return new LongPressEndDetails(id);
  }
  public static LongPressEndDetailsLongPressEndDetailsBuilder longPressEndDetails() {
    return LongPressEndDetailsLongPressEndDetailsBuilder.longPressEndDetailsLongPressEndDetails();
  }
  public Offset globalPosition() {
    var id = factories.longPressEndDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    var id = factories.longPressEndDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  public Velocity velocity() {
    var id = factories.longPressEndDetailsVelocity(this);
    if (id <= 0) throw new RuntimeException("Failed to call velocity");
    return new Velocity(id);
  }
  @Override
  public LongPressEndDetails build() {
    return this;
  }
}
