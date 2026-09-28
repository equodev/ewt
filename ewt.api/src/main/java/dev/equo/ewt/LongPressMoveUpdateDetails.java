package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class LongPressMoveUpdateDetails extends NativeObj.Base implements LongPressMoveUpdateDetailsI {
  protected LongPressMoveUpdateDetails() {}
  LongPressMoveUpdateDetails(int id) {
    this.id = id;
  }
  public static LongPressMoveUpdateDetails byId(int id) { return new LongPressMoveUpdateDetails(id); }
  static { NativeObj.register("LongPressMoveUpdateDetails", LongPressMoveUpdateDetails::byId); }
  @Builder.Factory
  static LongPressMoveUpdateDetails longPressMoveUpdateDetailsLongPressMoveUpdateDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<OffsetI> offsetFromOrigin, Optional<OffsetI> localOffsetFromOrigin) {
    var id = factories.longPressMoveUpdateDetailsLongPressMoveUpdateDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      offsetFromOrigin.map(OffsetI::build),
      localOffsetFromOrigin.map(OffsetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget LongPressMoveUpdateDetails");
    System.out.println("New LongPressMoveUpdateDetails id:"+id);
    return new LongPressMoveUpdateDetails(id);
  }
  public static LongPressMoveUpdateDetailsLongPressMoveUpdateDetailsBuilder longPressMoveUpdateDetails() {
    return LongPressMoveUpdateDetailsLongPressMoveUpdateDetailsBuilder.longPressMoveUpdateDetailsLongPressMoveUpdateDetails();
  }
  public Offset globalPosition() {
    var id = factories.longPressMoveUpdateDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    var id = factories.longPressMoveUpdateDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  public Offset offsetFromOrigin() {
    var id = factories.longPressMoveUpdateDetailsOffsetFromOrigin(this);
    if (id <= 0) throw new RuntimeException("Failed to call offsetFromOrigin");
    return new Offset(id);
  }
  public Offset localOffsetFromOrigin() {
    var id = factories.longPressMoveUpdateDetailsLocalOffsetFromOrigin(this);
    if (id <= 0) throw new RuntimeException("Failed to call localOffsetFromOrigin");
    return new Offset(id);
  }
  @Override
  public LongPressMoveUpdateDetails build() {
    return this;
  }
}
