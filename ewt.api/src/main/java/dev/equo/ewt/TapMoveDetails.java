package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TapMoveDetails extends NativeObj.Base implements TapMoveDetailsI {
  protected TapMoveDetails() {}
  TapMoveDetails(int id) {
    this.id = id;
  }
  public static TapMoveDetails byId(int id) { return new TapMoveDetails(id); }
  @Builder.Factory
  static TapMoveDetails tapMoveDetailsTapMoveDetails(@Builder.Parameter PointerDeviceKind kind, Optional<OffsetI> globalPosition, Optional<OffsetI> delta, Optional<OffsetI> localPosition) {
    int id = factories.tapMoveDetailsTapMoveDetails(kind,
      globalPosition.map(OffsetI::build),
      delta.map(OffsetI::build),
      localPosition.map(OffsetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TapMoveDetails");
    System.out.println("New TapMoveDetails id:"+id);
    return new TapMoveDetails(id);
  }
  public static TapMoveDetailsTapMoveDetailsBuilder tapMoveDetails(PointerDeviceKind kind) {
    return TapMoveDetailsTapMoveDetailsBuilder.tapMoveDetailsTapMoveDetails(kind);
  }
  @Override
  public TapMoveDetails build() {
    return this;
  }
}
