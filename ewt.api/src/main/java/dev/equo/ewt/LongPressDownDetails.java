package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class LongPressDownDetails extends NativeObj.Base implements LongPressDownDetailsI {
  protected LongPressDownDetails() {}
  LongPressDownDetails(int id) {
    this.id = id;
  }
  public static LongPressDownDetails byId(int id) { return new LongPressDownDetails(id); }
  static { NativeObj.register("LongPressDownDetails", LongPressDownDetails::byId); }
  @Builder.Factory
  static LongPressDownDetails longPressDownDetailsLongPressDownDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<PointerDeviceKind> kind) {
    var id = factories.longPressDownDetailsLongPressDownDetails(globalPosition.map(OffsetI::build),
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
    var id = factories.longPressDownDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    var id = factories.longPressDownDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  @Override
  public LongPressDownDetails build() {
    return this;
  }
}
