package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LongPressStartDetails extends NativeObj.Base implements LongPressStartDetailsI {
  protected LongPressStartDetails() {}
  LongPressStartDetails(int id) {
    this.id = id;
  }
  public static LongPressStartDetails byId(int id) { return new LongPressStartDetails(id); }
  @Builder.Factory
  static LongPressStartDetails longPressStartDetailsLongPressStartDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition) {
    int id = factories.longPressStartDetailsLongPressStartDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget LongPressStartDetails");
    System.out.println("New LongPressStartDetails id:"+id);
    return new LongPressStartDetails(id);
  }
  public static LongPressStartDetailsLongPressStartDetailsBuilder longPressStartDetails() {
    return LongPressStartDetailsLongPressStartDetailsBuilder.longPressStartDetailsLongPressStartDetails();
  }
  public Offset globalPosition() {
    int id = factories.longPressStartDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    int id = factories.longPressStartDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  @Override
  public LongPressStartDetails build() {
    return this;
  }
}
