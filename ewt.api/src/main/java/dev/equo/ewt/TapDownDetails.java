package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TapDownDetails extends NativeObj.Base implements TapDownDetailsI {
  protected TapDownDetails() {}
  TapDownDetails(int id) {
    this.id = id;
  }
  public static TapDownDetails byId(int id) { return new TapDownDetails(id); }
  @Builder.Factory
  static TapDownDetails tapDownDetailsTapDownDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<PointerDeviceKind> kind) {
    int id = factories.tapDownDetailsTapDownDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      kind);
    if (id <= 0) throw new RuntimeException("Failed to created widget TapDownDetails");
    System.out.println("New TapDownDetails id:"+id);
    return new TapDownDetails(id);
  }
  public static TapDownDetailsTapDownDetailsBuilder tapDownDetails() {
    return TapDownDetailsTapDownDetailsBuilder.tapDownDetailsTapDownDetails();
  }
  @Override
  public TapDownDetails build() {
    return this;
  }
}
