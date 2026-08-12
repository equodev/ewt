package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.WidgetConstructorsBase.*;
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
  public Offset globalPosition() {
    int id = factories.tapUpDetailsGlobalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call globalPosition");
    return new Offset(id);
  }
  public Offset localPosition() {
    int id = factories.tapUpDetailsLocalPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call localPosition");
    return new Offset(id);
  }
  @Override
  public TapUpDetails build() {
    return this;
  }
}
