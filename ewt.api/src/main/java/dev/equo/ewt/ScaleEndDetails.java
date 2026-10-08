package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class ScaleEndDetails extends NativeObj.Base implements ScaleEndDetailsI {
  protected ScaleEndDetails() {}
  ScaleEndDetails(int id) {
    this.id = id;
  }
  public static ScaleEndDetails byId(int id) { return new ScaleEndDetails(id); }
  static { NativeObj.register("ScaleEndDetails", ScaleEndDetails::byId); }
  @Builder.Factory
  static ScaleEndDetails scaleEndDetailsScaleEndDetails(Optional<VelocityI> velocity, OptionalDouble scaleVelocity, OptionalInt pointerCount) {
    var id = factories.scaleEndDetailsScaleEndDetails(velocity.map(VelocityI::build),
      scaleVelocity,
      pointerCount);
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleEndDetails");
    return new ScaleEndDetails(id);
  }
  public static ScaleEndDetailsScaleEndDetailsBuilder scaleEndDetails() {
    return ScaleEndDetailsScaleEndDetailsBuilder.scaleEndDetailsScaleEndDetails();
  }
  public Velocity velocity() {
    var id = factories.scaleEndDetailsVelocity(this);
    if (id <= 0) throw new RuntimeException("Failed to call velocity");
    return new Velocity(id);
  }
  public double scaleVelocity() {
    var id = factories.scaleEndDetailsScaleVelocity(this);
    return id;
  }
  public int pointerCount() {
    var id = factories.scaleEndDetailsPointerCount(this);
    if (id <= 0) throw new RuntimeException("Failed to call pointerCount");
    return id;
  }
  @Override
  public ScaleEndDetails build() {
    return this;
  }
}
