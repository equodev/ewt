package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.VelocityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Velocity extends NativeObj.Base implements VelocityI {
  private MemorySegment st;
  protected Velocity() {}
  Velocity(MemorySegment st) {
    this.id = VelocityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Velocity");
    System.out.println("New Velocity id:"+id);
  }
  Velocity(int id) { this.id = id; }
  @Builder.Factory
  static Velocity velocityVelocity(@Builder.Parameter OffsetI pixelsPerSecond) {
    var st = factories.velocityVelocity(pixelsPerSecond.build());
    if (st == null) throw new RuntimeException("Failed to created widget Velocity");
    return new Velocity(st);
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
    return new Offset(VelocityObjSt.pixelsPerSecond(st));
  }
  public static Velocity zero() {
    return Velocity.velocity(Offset.zero()).build();
  }
  @Override
  public Velocity build() {
    return this;
  }
}
