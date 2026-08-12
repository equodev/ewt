package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ScaleStartDetails extends NativeObj.Base implements ScaleStartDetailsI {
  protected ScaleStartDetails() {}
  ScaleStartDetails(int id) {
    this.id = id;
  }
  public static ScaleStartDetails byId(int id) { return new ScaleStartDetails(id); }
  @Builder.Factory
  static ScaleStartDetails scaleStartDetailsScaleStartDetails(Optional<OffsetI> focalPoint, Optional<OffsetI> localFocalPoint, OptionalInt pointerCount, Optional<DurationI> sourceTimeStamp, Optional<PointerDeviceKind> kind) {
    int id = factories.scaleStartDetailsScaleStartDetails(focalPoint.map(OffsetI::build),
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
  @Override
  public ScaleStartDetails build() {
    return this;
  }
}
