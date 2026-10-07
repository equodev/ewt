package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class ScaleUpdateDetails extends NativeObj.Base implements ScaleUpdateDetailsI {
  protected ScaleUpdateDetails() {}
  ScaleUpdateDetails(int id) {
    this.id = id;
  }
  public static ScaleUpdateDetails byId(int id) { return new ScaleUpdateDetails(id); }
  static { NativeObj.register("ScaleUpdateDetails", ScaleUpdateDetails::byId); }
  @Builder.Factory
  static ScaleUpdateDetails scaleUpdateDetailsScaleUpdateDetails(Optional<OffsetI> focalPoint, Optional<OffsetI> localFocalPoint, OptionalDouble scale, OptionalDouble horizontalScale, OptionalDouble verticalScale, OptionalDouble rotation, OptionalInt pointerCount, Optional<OffsetI> focalPointDelta, Optional<DurationI> sourceTimeStamp) {
    var id = factories.scaleUpdateDetailsScaleUpdateDetails(focalPoint.map(OffsetI::build),
      localFocalPoint.map(OffsetI::build),
      scale,
      horizontalScale,
      verticalScale,
      rotation,
      pointerCount,
      focalPointDelta.map(OffsetI::build),
      sourceTimeStamp.map(DurationI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleUpdateDetails");
    return new ScaleUpdateDetails(id);
  }
  public static ScaleUpdateDetailsScaleUpdateDetailsBuilder scaleUpdateDetails() {
    return ScaleUpdateDetailsScaleUpdateDetailsBuilder.scaleUpdateDetailsScaleUpdateDetails();
  }
  public Offset focalPoint() {
    var id = factories.scaleUpdateDetailsFocalPoint(this);
    if (id <= 0) throw new RuntimeException("Failed to call focalPoint");
    return new Offset(id);
  }
  public Offset localFocalPoint() {
    var id = factories.scaleUpdateDetailsLocalFocalPoint(this);
    if (id <= 0) throw new RuntimeException("Failed to call localFocalPoint");
    return new Offset(id);
  }
  public Offset focalPointDelta() {
    var id = factories.scaleUpdateDetailsFocalPointDelta(this);
    if (id <= 0) throw new RuntimeException("Failed to call focalPointDelta");
    return new Offset(id);
  }
  public double scale() {
    var id = factories.scaleUpdateDetailsScale(this);
    return id;
  }
  public double horizontalScale() {
    var id = factories.scaleUpdateDetailsHorizontalScale(this);
    return id;
  }
  public double verticalScale() {
    var id = factories.scaleUpdateDetailsVerticalScale(this);
    return id;
  }
  public double rotation() {
    var id = factories.scaleUpdateDetailsRotation(this);
    return id;
  }
  public int pointerCount() {
    var id = factories.scaleUpdateDetailsPointerCount(this);
    if (id <= 0) throw new RuntimeException("Failed to call pointerCount");
    return id;
  }
  @Override
  public ScaleUpdateDetails build() {
    return this;
  }
}
