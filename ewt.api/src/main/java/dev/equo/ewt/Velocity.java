package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Velocity extends NativeObj.Base implements VelocityI {
  protected Velocity() {}
  Velocity(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Velocity");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Velocity velocityVelocity(@Builder.Parameter OffsetI pixelsPerSecond) {
    int id = factories.velocityVelocity(pixelsPerSecond.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Velocity");
    return new Velocity(id);
  }
  public static VelocityVelocityBuilder velocity(OffsetI pixelsPerSecond) {
    return VelocityVelocityBuilder.velocityVelocity(pixelsPerSecond);
  }
  public Offset pixelsPerSecond() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("velocityPixelsPerSecond", getId());
      return new Offset(__nid);
    }
    return factories.Velocity_readBack_pixelsPerSecond(nativeStruct);
  }
  public static Velocity zero() {
    return Velocity.velocity(Offset.zero()).build();
  }
  @Override
  public Velocity build() {
    return this;
  }
}
