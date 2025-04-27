package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BorderRadiusObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BorderRadius extends BorderRadiusGeometry implements BorderRadiusI {
  private MemorySegment st;
  protected BorderRadius() {}
  BorderRadius(MemorySegment st) {
    this.id = BorderRadiusObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderRadius");
    System.out.println("New BorderRadius id:"+id);
  }
  @Builder.Factory
  static BorderRadius borderRadiusAll(@Builder.Parameter RadiusI radius) {
    var st = factories.borderRadiusAll(radius.build());
    if (st == null) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(st);
  }
  public static BorderRadiusAllBuilder all(RadiusI radius) {
    return BorderRadiusAllBuilder.borderRadiusAll(radius);
  }
  @Builder.Factory
  static BorderRadius borderRadiusCircular(@Builder.Parameter double radius) {
    var st = factories.borderRadiusCircular(radius);
    if (st == null) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(st);
  }
  public static BorderRadiusCircularBuilder circular(double radius) {
    return BorderRadiusCircularBuilder.borderRadiusCircular(radius);
  }
  @Builder.Factory
  static BorderRadius borderRadiusVertical(Optional<RadiusI> top, Optional<RadiusI> bottom) {
    var st = factories.borderRadiusVertical(top.map(RadiusI::build),
      bottom.map(RadiusI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(st);
  }
  public static BorderRadiusVerticalBuilder vertical() {
    return BorderRadiusVerticalBuilder.borderRadiusVertical();
  }
  @Builder.Factory
  static BorderRadius borderRadiusHorizontal(Optional<RadiusI> left, Optional<RadiusI> right) {
    var st = factories.borderRadiusHorizontal(left.map(RadiusI::build),
      right.map(RadiusI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(st);
  }
  public static BorderRadiusHorizontalBuilder horizontal() {
    return BorderRadiusHorizontalBuilder.borderRadiusHorizontal();
  }
  @Builder.Factory
  static BorderRadius borderRadiusOnly(Optional<RadiusI> topLeft, Optional<RadiusI> topRight, Optional<RadiusI> bottomLeft, Optional<RadiusI> bottomRight) {
    var st = factories.borderRadiusOnly(topLeft.map(RadiusI::build),
      topRight.map(RadiusI::build),
      bottomLeft.map(RadiusI::build),
      bottomRight.map(RadiusI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(st);
  }
  public static BorderRadiusOnlyBuilder only() {
    return BorderRadiusOnlyBuilder.borderRadiusOnly();
  }
  public static BorderRadius lerp(BorderRadiusI a, BorderRadiusI b, double t) {
    var st = factories.borderRadiusLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BorderRadius");
    return new BorderRadius(st);
  }
  public Radius topLeft() {
    return new Radius(BorderRadiusObjSt.topLeft(st));
  }
  public Radius topRight() {
    return new Radius(BorderRadiusObjSt.topRight(st));
  }
  public Radius bottomLeft() {
    return new Radius(BorderRadiusObjSt.bottomLeft(st));
  }
  public Radius bottomRight() {
    return new Radius(BorderRadiusObjSt.bottomRight(st));
  }
  public static BorderRadius zero() {
    return BorderRadius.all(Radius.zero()).build();
  }
  @Override
  public BorderRadius build() {
    return this;
  }
}
