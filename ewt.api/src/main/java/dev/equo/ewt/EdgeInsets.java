package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class EdgeInsets extends EdgeInsetsGeometry implements EdgeInsetsI {
  protected EdgeInsets() {}
  EdgeInsets(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsets");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsFromLTRB(@Builder.Parameter double left, @Builder.Parameter double top, @Builder.Parameter double right, @Builder.Parameter double bottom) {
    int id = factories.edgeInsetsFromLTRB(left,
      top,
      right,
      bottom);
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(id);
  }
  public static EdgeInsetsFromLTRBBuilder fromLTRB(double left, double top, double right, double bottom) {
    return EdgeInsetsFromLTRBBuilder.edgeInsetsFromLTRB(left, top, right, bottom);
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsAll(@Builder.Parameter double value) {
    int id = factories.edgeInsetsAll(value);
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(id);
  }
  public static EdgeInsetsAllBuilder all(double value) {
    return EdgeInsetsAllBuilder.edgeInsetsAll(value);
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsOnly(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom) {
    int id = factories.edgeInsetsOnly(left,
      top,
      right,
      bottom);
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(id);
  }
  public static EdgeInsetsOnlyBuilder only() {
    return EdgeInsetsOnlyBuilder.edgeInsetsOnly();
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsSymmetric(OptionalDouble vertical, OptionalDouble horizontal) {
    int id = factories.edgeInsetsSymmetric(vertical,
      horizontal);
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(id);
  }
  public static EdgeInsetsSymmetricBuilder symmetric() {
    return EdgeInsetsSymmetricBuilder.edgeInsetsSymmetric();
  }
  public static EdgeInsets lerp(EdgeInsetsI a, EdgeInsetsI b, double t) {
    int id = factories.edgeInsetsLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(id);
  }
  public double left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsLeft not supported on web");
    return factories.EdgeInsets_readBack_left(nativeStruct);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsTop not supported on web");
    return factories.EdgeInsets_readBack_top(nativeStruct);
  }
  public double right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsRight not supported on web");
    return factories.EdgeInsets_readBack_right(nativeStruct);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsBottom not supported on web");
    return factories.EdgeInsets_readBack_bottom(nativeStruct);
  }
  public Offset topLeft() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsTopLeft", getId());
      return new Offset(__nid);
    }
    return factories.EdgeInsets_readBack_topLeft(nativeStruct);
  }
  public Offset topRight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsTopRight", getId());
      return new Offset(__nid);
    }
    return factories.EdgeInsets_readBack_topRight(nativeStruct);
  }
  public Offset bottomLeft() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsBottomLeft", getId());
      return new Offset(__nid);
    }
    return factories.EdgeInsets_readBack_bottomLeft(nativeStruct);
  }
  public Offset bottomRight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsBottomRight", getId());
      return new Offset(__nid);
    }
    return factories.EdgeInsets_readBack_bottomRight(nativeStruct);
  }
  public static EdgeInsets zero() {
    return EdgeInsets.only().build();
  }
  @Override
  public EdgeInsets build() {
    return this;
  }
}
