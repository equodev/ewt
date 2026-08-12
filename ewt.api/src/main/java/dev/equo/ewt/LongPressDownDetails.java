package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LongPressDownDetails extends NativeObj.Base implements LongPressDownDetailsI {
  protected LongPressDownDetails() {}
  LongPressDownDetails(int id) {
    this.id = id;
  }
  public static LongPressDownDetails byId(int id) { return new LongPressDownDetails(id); }
  @Builder.Factory
  static LongPressDownDetails longPressDownDetailsLongPressDownDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<PointerDeviceKind> kind) {
    int id = factories.longPressDownDetailsLongPressDownDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      kind);
    if (id <= 0) throw new RuntimeException("Failed to created widget LongPressDownDetails");
    System.out.println("New LongPressDownDetails id:"+id);
    return new LongPressDownDetails(id);
  }
  public static LongPressDownDetailsLongPressDownDetailsBuilder longPressDownDetails() {
    return LongPressDownDetailsLongPressDownDetailsBuilder.longPressDownDetailsLongPressDownDetails();
  }
  public Offset globalPosition() {
    int id = factories.longPressDownDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    int id = factories.longPressDownDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  @Override
  public LongPressDownDetails build() {
    return this;
  }
}
