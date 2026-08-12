package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
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
  @Override
  public LongPressEndDetails build() {
    return this;
  }
}
