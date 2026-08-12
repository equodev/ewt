package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ForcePressDetails extends NativeObj.Base implements ForcePressDetailsI {
  protected ForcePressDetails() {}
  ForcePressDetails(int id) {
    this.id = id;
  }
  public static ForcePressDetails byId(int id) { return new ForcePressDetails(id); }
  @Builder.Factory
  static ForcePressDetails forcePressDetailsForcePressDetails(@Builder.Parameter OffsetI globalPosition, Optional<OffsetI> localPosition, double pressure) {
    int id = factories.forcePressDetailsForcePressDetails(globalPosition.build(),
      localPosition.map(OffsetI::build),
      pressure);
    if (id <= 0) throw new RuntimeException("Failed to created widget ForcePressDetails");
    System.out.println("New ForcePressDetails id:"+id);
    return new ForcePressDetails(id);
  }
  public static ForcePressDetailsForcePressDetailsBuilder forcePressDetails(OffsetI globalPosition) {
    return ForcePressDetailsForcePressDetailsBuilder.forcePressDetailsForcePressDetails(globalPosition);
  }
  @Override
  public ForcePressDetails build() {
    return this;
  }
}
