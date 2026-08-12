package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
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
  @Override
  public ScaleUpdateDetails build() {
    return this;
  }
}
