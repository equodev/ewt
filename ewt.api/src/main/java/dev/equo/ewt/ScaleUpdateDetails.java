package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ScaleUpdateDetails extends NativeObj.Base implements ScaleUpdateDetailsI {
  protected ScaleUpdateDetails() {}
  ScaleUpdateDetails(int id) {
    this.id = id;
  }
  public static ScaleUpdateDetails byId(int id) { return new ScaleUpdateDetails(id); }
  @Builder.Factory
  static ScaleUpdateDetails scaleUpdateDetailsScaleUpdateDetails(Optional<OffsetI> focalPoint, Optional<OffsetI> localFocalPoint, OptionalDouble scale, OptionalDouble horizontalScale, OptionalDouble verticalScale, OptionalDouble rotation, OptionalInt pointerCount, Optional<OffsetI> focalPointDelta, Optional<DurationI> sourceTimeStamp) {
    int id = factories.scaleUpdateDetailsScaleUpdateDetails(focalPoint.map(OffsetI::build),
      localFocalPoint.map(OffsetI::build),
      scale,
      horizontalScale,
      verticalScale,
      rotation,
      pointerCount,
      focalPointDelta.map(OffsetI::build),
      sourceTimeStamp.map(DurationI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaleUpdateDetails");
    System.out.println("New ScaleUpdateDetails id:"+id);
    return new ScaleUpdateDetails(id);
  }
  public static ScaleUpdateDetailsScaleUpdateDetailsBuilder scaleUpdateDetails() {
    return ScaleUpdateDetailsScaleUpdateDetailsBuilder.scaleUpdateDetailsScaleUpdateDetails();
  }
  public Offset focalPoint() {
    int id = factories.scaleUpdateDetailsFocalPoint(this);
    if (id <= 0) throw new RuntimeException("Failed to call focalPoint");
    return new Offset(id);
  }
  public Offset localFocalPoint() {
    int id = factories.scaleUpdateDetailsLocalFocalPoint(this);
    if (id <= 0) throw new RuntimeException("Failed to call localFocalPoint");
    return new Offset(id);
  }
  public Offset focalPointDelta() {
    int id = factories.scaleUpdateDetailsFocalPointDelta(this);
    if (id <= 0) throw new RuntimeException("Failed to call focalPointDelta");
    return new Offset(id);
  }
  public double scale() {
    double id = factories.scaleUpdateDetailsScale(this);
    return id;
  }
  public double horizontalScale() {
    double id = factories.scaleUpdateDetailsHorizontalScale(this);
    return id;
  }
  public double verticalScale() {
    double id = factories.scaleUpdateDetailsVerticalScale(this);
    return id;
  }
  public double rotation() {
    double id = factories.scaleUpdateDetailsRotation(this);
    return id;
  }
  public int pointerCount() {
    int id = factories.scaleUpdateDetailsPointerCount(this);
    if (id <= 0) throw new RuntimeException("Failed to call pointerCount");
    return id;
  }
  @Override
  public ScaleUpdateDetails build() {
    return this;
  }
}
