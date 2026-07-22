package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.EdgeInsetsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class EdgeInsets extends EdgeInsetsGeometry implements EdgeInsetsI {
  private MemorySegment st;
  protected EdgeInsets() {}
  EdgeInsets(MemorySegment st) {
    this.id = EdgeInsetsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsets");
    System.out.println("New EdgeInsets id:"+id);
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsFromLTRB(@Builder.Parameter double left, @Builder.Parameter double top, @Builder.Parameter double right, @Builder.Parameter double bottom) {
    var st = factories.edgeInsetsFromLTRB(left,
      top,
      right,
      bottom);
    if (st == null) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(st);
  }
  public static EdgeInsetsFromLTRBBuilder fromLTRB(double left, double top, double right, double bottom) {
    return EdgeInsetsFromLTRBBuilder.edgeInsetsFromLTRB(left, top, right, bottom);
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsAll(@Builder.Parameter double value) {
    var st = factories.edgeInsetsAll(value);
    if (st == null) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(st);
  }
  public static EdgeInsetsAllBuilder all(double value) {
    return EdgeInsetsAllBuilder.edgeInsetsAll(value);
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsOnly(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom) {
    var st = factories.edgeInsetsOnly(left,
      top,
      right,
      bottom);
    if (st == null) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(st);
  }
  public static EdgeInsetsOnlyBuilder only() {
    return EdgeInsetsOnlyBuilder.edgeInsetsOnly();
  }
  @Builder.Factory
  static EdgeInsets edgeInsetsSymmetric(OptionalDouble vertical, OptionalDouble horizontal) {
    var st = factories.edgeInsetsSymmetric(vertical,
      horizontal);
    if (st == null) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(st);
  }
  public static EdgeInsetsSymmetricBuilder symmetric() {
    return EdgeInsetsSymmetricBuilder.edgeInsetsSymmetric();
  }
  public static EdgeInsets lerp(EdgeInsetsI a, EdgeInsetsI b, double t) {
    var st = factories.edgeInsetsLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget EdgeInsets");
    return new EdgeInsets(st);
  }
  public double left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsLeft not supported on web");
    return EdgeInsetsObjSt.left(st);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsTop not supported on web");
    return EdgeInsetsObjSt.top(st);
  }
  public double right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsRight not supported on web");
    return EdgeInsetsObjSt.right(st);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("edgeInsetsBottom not supported on web");
    return EdgeInsetsObjSt.bottom(st);
  }
  public Offset topLeft() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsTopLeft", getId());
      return new Offset(__nid);
    }
    return new Offset(EdgeInsetsObjSt.topLeft(st));
  }
  public Offset topRight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsTopRight", getId());
      return new Offset(__nid);
    }
    return new Offset(EdgeInsetsObjSt.topRight(st));
  }
  public Offset bottomLeft() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsBottomLeft", getId());
      return new Offset(__nid);
    }
    return new Offset(EdgeInsetsObjSt.bottomLeft(st));
  }
  public Offset bottomRight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("edgeInsetsBottomRight", getId());
      return new Offset(__nid);
    }
    return new Offset(EdgeInsetsObjSt.bottomRight(st));
  }
  public static EdgeInsets zero() {
    return EdgeInsets.only().build();
  }
  @Override
  public EdgeInsets build() {
    return this;
  }
}
