package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class TapDownDetails extends NativeObj.Base implements TapDownDetailsI {
  protected TapDownDetails() {}
  TapDownDetails(int id) {
    this.id = id;
  }
  public static TapDownDetails byId(int id) { return new TapDownDetails(id); }
  static { NativeObj.register("TapDownDetails", TapDownDetails::byId); }
  @Builder.Factory
  static TapDownDetails tapDownDetailsTapDownDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, Optional<PointerDeviceKind> kind) {
    var id = factories.tapDownDetailsTapDownDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      kind);
    if (id <= 0) throw new RuntimeException("Failed to created widget TapDownDetails");
    return new TapDownDetails(id);
  }
  public static TapDownDetailsTapDownDetailsBuilder tapDownDetails() {
    return TapDownDetailsTapDownDetailsBuilder.tapDownDetailsTapDownDetails();
  }
  public Offset globalPosition() {
    var id = factories.tapDownDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    var id = factories.tapDownDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  @Override
  public TapDownDetails build() {
    return this;
  }
}
