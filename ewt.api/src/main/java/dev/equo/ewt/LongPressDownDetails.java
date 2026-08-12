package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
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
  @Override
  public LongPressDownDetails build() {
    return this;
  }
}
