package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ThreePointCubic extends Curve implements ThreePointCubicI {
  protected ThreePointCubic() {}
  ThreePointCubic(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ThreePointCubic");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ThreePointCubic threePointCubicThreePointCubic(@Builder.Parameter OffsetI a1, @Builder.Parameter OffsetI b1, @Builder.Parameter OffsetI midpoint, @Builder.Parameter OffsetI a2, @Builder.Parameter OffsetI b2) {
    int id = factories.threePointCubicThreePointCubic(a1.build(),
      b1.build(),
      midpoint.build(),
      a2.build(),
      b2.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ThreePointCubic");
    return new ThreePointCubic(id);
  }
  public static ThreePointCubicThreePointCubicBuilder threePointCubic(OffsetI a1, OffsetI b1, OffsetI midpoint, OffsetI a2, OffsetI b2) {
    return ThreePointCubicThreePointCubicBuilder.threePointCubicThreePointCubic(a1, b1, midpoint, a2, b2);
  }
  public Offset a1() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("threePointCubicA1", getId());
      return new Offset(__nid);
    }
    return factories.ThreePointCubic_readBack_a1(nativeStruct);
  }
  public Offset b1() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("threePointCubicB1", getId());
      return new Offset(__nid);
    }
    return factories.ThreePointCubic_readBack_b1(nativeStruct);
  }
  public Offset midpoint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("threePointCubicMidpoint", getId());
      return new Offset(__nid);
    }
    return factories.ThreePointCubic_readBack_midpoint(nativeStruct);
  }
  public Offset a2() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("threePointCubicA2", getId());
      return new Offset(__nid);
    }
    return factories.ThreePointCubic_readBack_a2(nativeStruct);
  }
  public Offset b2() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("threePointCubicB2", getId());
      return new Offset(__nid);
    }
    return factories.ThreePointCubic_readBack_b2(nativeStruct);
  }
  @Override
  public ThreePointCubic build() {
    return this;
  }
}
