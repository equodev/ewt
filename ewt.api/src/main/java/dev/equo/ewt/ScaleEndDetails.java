package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ScaleEndDetails extends NativeObj.Base implements ScaleEndDetailsI {
  protected ScaleEndDetails() {}
  ScaleEndDetails(int id) {
    this.id = id;
  }
  public static ScaleEndDetails byId(int id) { return new ScaleEndDetails(id); }
  @Builder.Factory
  static ScaleEndDetails scaleEndDetailsScaleEndDetails(Optional<VelocityI> velocity, OptionalDouble scaleVelocity, OptionalInt pointerCount) {
    int id = factories.scaleEndDetailsScaleEndDetails(velocity.map(VelocityI::build),
      scaleVelocity,
      pointerCount);
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleEndDetails");
    System.out.println("New ScaleEndDetails id:"+id);
    return new ScaleEndDetails(id);
  }
  public static ScaleEndDetailsScaleEndDetailsBuilder scaleEndDetails() {
    return ScaleEndDetailsScaleEndDetailsBuilder.scaleEndDetailsScaleEndDetails();
  }
  public Velocity velocity() {
    MemorySegment id = factories.scaleEndDetailsVelocity(this);
    return new Velocity(id);
  }
  public double scaleVelocity() {
    double id = factories.scaleEndDetailsScaleVelocity(this);
    return id;
  }
  public int pointerCount() {
    int id = factories.scaleEndDetailsPointerCount(this);
    if (id <= 0) throw new RuntimeException("Failed to call pointerCount");
    return id;
  }
  @Override
  public ScaleEndDetails build() {
    return this;
  }
}
