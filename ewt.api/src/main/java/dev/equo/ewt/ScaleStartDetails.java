package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class ScaleStartDetails extends NativeObj.Base implements ScaleStartDetailsI {
  protected ScaleStartDetails() {}
  ScaleStartDetails(int id) {
    this.id = id;
  }
  public static ScaleStartDetails byId(int id) { return new ScaleStartDetails(id); }
  static { NativeObj.register("ScaleStartDetails", ScaleStartDetails::byId); }
  @Builder.Factory
  static ScaleStartDetails scaleStartDetailsScaleStartDetails(Optional<OffsetI> focalPoint, Optional<OffsetI> localFocalPoint, OptionalInt pointerCount, Optional<DurationI> sourceTimeStamp, Optional<PointerDeviceKind> kind) {
    var id = factories.scaleStartDetailsScaleStartDetails(focalPoint.map(OffsetI::build),
      localFocalPoint.map(OffsetI::build),
      pointerCount,
      sourceTimeStamp.map(DurationI::build),
      kind);
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleStartDetails");
    System.out.println("New ScaleStartDetails id:"+id);
    return new ScaleStartDetails(id);
  }
  public static ScaleStartDetailsScaleStartDetailsBuilder scaleStartDetails() {
    return ScaleStartDetailsScaleStartDetailsBuilder.scaleStartDetailsScaleStartDetails();
  }
  public Offset focalPoint() {
    var id = factories.scaleStartDetailsFocalPoint(this);
    if (id <= 0) throw new RuntimeException("Failed to call focalPoint");
    return new Offset(id);
  }
  public Offset localFocalPoint() {
    var id = factories.scaleStartDetailsLocalFocalPoint(this);
    if (id <= 0) throw new RuntimeException("Failed to call localFocalPoint");
    return new Offset(id);
  }
  public int pointerCount() {
    var id = factories.scaleStartDetailsPointerCount(this);
    if (id <= 0) throw new RuntimeException("Failed to call pointerCount");
    return id;
  }
  @Override
  public ScaleStartDetails build() {
    return this;
  }
}
