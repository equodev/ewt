package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LongPressMoveUpdateDetails extends NativeObj.Base implements LongPressMoveUpdateDetailsI {
  protected LongPressMoveUpdateDetails() {}
  LongPressMoveUpdateDetails(int id) {
    this.id = id;
  }
  public static LongPressMoveUpdateDetails byId(int id) { return new LongPressMoveUpdateDetails(id); }
  @Builder.Factory
  static LongPressMoveUpdateDetails longPressMoveUpdateDetailsLongPressMoveUpdateDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<OffsetI> offsetFromOrigin, Optional<OffsetI> localOffsetFromOrigin) {
    int id = factories.longPressMoveUpdateDetailsLongPressMoveUpdateDetails(globalPosition.map(OffsetI::build),
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
    int id = factories.longPressMoveUpdateDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    int id = factories.longPressMoveUpdateDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  public Offset offsetFromOrigin() {
    int id = factories.longPressMoveUpdateDetailsOffsetFromOrigin(this);
    if (id <= 0) throw new RuntimeException("Failed to call offsetFromOrigin");
    return new Offset(id);
  }
  public Offset localOffsetFromOrigin() {
    int id = factories.longPressMoveUpdateDetailsLocalOffsetFromOrigin(this);
    if (id <= 0) throw new RuntimeException("Failed to call localOffsetFromOrigin");
    return new Offset(id);
  }
  @Override
  public LongPressMoveUpdateDetails build() {
    return this;
  }
}
