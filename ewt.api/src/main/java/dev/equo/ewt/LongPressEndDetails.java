package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LongPressEndDetails extends NativeObj.Base implements LongPressEndDetailsI {
  protected LongPressEndDetails() {}
  LongPressEndDetails(int id) {
    this.id = id;
  }
  public static LongPressEndDetails byId(int id) { return new LongPressEndDetails(id); }
  @Builder.Factory
  static LongPressEndDetails longPressEndDetailsLongPressEndDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<VelocityI> velocity) {
    int id = factories.longPressEndDetailsLongPressEndDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      velocity.map(VelocityI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget LongPressEndDetails");
    System.out.println("New LongPressEndDetails id:"+id);
    return new LongPressEndDetails(id);
  }
  public static LongPressEndDetailsLongPressEndDetailsBuilder longPressEndDetails() {
    return LongPressEndDetailsLongPressEndDetailsBuilder.longPressEndDetailsLongPressEndDetails();
  }
  public Offset globalPosition() {
    int id = factories.longPressEndDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    int id = factories.longPressEndDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  public Velocity velocity() {
    MemorySegment id = factories.longPressEndDetailsVelocity(this);
    return new Velocity(id);
  }
  @Override
  public LongPressEndDetails build() {
    return this;
  }
}
