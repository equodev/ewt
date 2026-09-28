package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BorderRadius extends BorderRadiusGeometry implements BorderRadiusI {
  protected BorderRadius() {}
  BorderRadius(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BorderRadius borderRadiusAll(@Builder.Parameter RadiusI radius) {
    int id = factories.borderRadiusAll(radius.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(id);
  }
  public static BorderRadiusAllBuilder all(RadiusI radius) {
    return BorderRadiusAllBuilder.borderRadiusAll(radius);
  }
  @Builder.Factory
  static BorderRadius borderRadiusCircular(@Builder.Parameter double radius) {
    int id = factories.borderRadiusCircular(radius);
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(id);
  }
  public static BorderRadiusCircularBuilder circular(double radius) {
    return BorderRadiusCircularBuilder.borderRadiusCircular(radius);
  }
  @Builder.Factory
  static BorderRadius borderRadiusVertical(Optional<RadiusI> top, Optional<RadiusI> bottom) {
    int id = factories.borderRadiusVertical(top.map(RadiusI::build),
      bottom.map(RadiusI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(id);
  }
  public static BorderRadiusVerticalBuilder vertical() {
    return BorderRadiusVerticalBuilder.borderRadiusVertical();
  }
  @Builder.Factory
  static BorderRadius borderRadiusHorizontal(Optional<RadiusI> left, Optional<RadiusI> right) {
    int id = factories.borderRadiusHorizontal(left.map(RadiusI::build),
      right.map(RadiusI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(id);
  }
  public static BorderRadiusHorizontalBuilder horizontal() {
    return BorderRadiusHorizontalBuilder.borderRadiusHorizontal();
  }
  @Builder.Factory
  static BorderRadius borderRadiusOnly(Optional<RadiusI> topLeft, Optional<RadiusI> topRight, Optional<RadiusI> bottomLeft, Optional<RadiusI> bottomRight) {
    int id = factories.borderRadiusOnly(topLeft.map(RadiusI::build),
      topRight.map(RadiusI::build),
      bottomLeft.map(RadiusI::build),
      bottomRight.map(RadiusI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(id);
  }
  public static BorderRadiusOnlyBuilder only() {
    return BorderRadiusOnlyBuilder.borderRadiusOnly();
  }
  public static BorderRadius lerp(BorderRadiusI a, BorderRadiusI b, double t) {
    int id = factories.borderRadiusLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(id);
  }
  public Radius topLeft() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderRadiusTopLeft", getId());
      return new Radius(__nid);
    }
    return factories.BorderRadius_readBack_topLeft(nativeStruct);
  }
  public Radius topRight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderRadiusTopRight", getId());
      return new Radius(__nid);
    }
    return factories.BorderRadius_readBack_topRight(nativeStruct);
  }
  public Radius bottomLeft() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderRadiusBottomLeft", getId());
      return new Radius(__nid);
    }
    return factories.BorderRadius_readBack_bottomLeft(nativeStruct);
  }
  public Radius bottomRight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderRadiusBottomRight", getId());
      return new Radius(__nid);
    }
    return factories.BorderRadius_readBack_bottomRight(nativeStruct);
  }
  public static BorderRadius zero() {
    return BorderRadius.all(Radius.zero()).build();
  }
  @Override
  public BorderRadius build() {
    return this;
  }
}
