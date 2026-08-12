package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TapUpDetails extends NativeObj.Base implements TapUpDetailsI {
  protected TapUpDetails() {}
  TapUpDetails(int id) {
    this.id = id;
  }
  public static TapUpDetails byId(int id) { return new TapUpDetails(id); }
  @Builder.Factory
  static TapUpDetails tapUpDetailsTapUpDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition, PointerDeviceKind kind) {
    int id = factories.tapUpDetailsTapUpDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build),
      kind);
    if (id <= 0) throw new RuntimeException("Failed to created widget TapUpDetails");
    System.out.println("New TapUpDetails id:"+id);
    return new TapUpDetails(id);
  }
  public static TapUpDetailsTapUpDetailsBuilder tapUpDetails() {
    return TapUpDetailsTapUpDetailsBuilder.tapUpDetailsTapUpDetails();
  }
  @Override
  public TapUpDetails build() {
    return this;
  }
}
