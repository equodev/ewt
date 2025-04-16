package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Radius extends NativeObj.Base implements RadiusI {
  protected Radius() {}
  Radius(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Radius radiusCircular(@Builder.Parameter double radius) {
    int id = factories.radiusCircular(radius);
    if (id == -1) throw new RuntimeException("Failed to created widget Radius");
    System.out.println("New Radius id:"+id);
    return new Radius(id);
  }
  public static RadiusCircularBuilder circular(double radius) {
    return RadiusCircularBuilder.radiusCircular(radius);
  }
  @Builder.Factory
  static Radius radiusElliptical(@Builder.Parameter double x, @Builder.Parameter double y) {
    int id = factories.radiusElliptical(x,
      y);
    if (id == -1) throw new RuntimeException("Failed to created widget Radius");
    System.out.println("New Radius id:"+id);
    return new Radius(id);
  }
  public static RadiusEllipticalBuilder elliptical(double x, double y) {
    return RadiusEllipticalBuilder.radiusElliptical(x, y);
  }
  public static Radius lerp(RadiusI a, RadiusI b, double t) {
    int id = factories.radiusLerp(a.build(),
      b.build(),
      t);
    if (id == -1) throw new RuntimeException("Failed to created widget Radius?");
    System.out.println("New Radius? id:"+id);
    return new Radius(id);
  }
  public static Radius zero() {
    return Radius.circular(0.0).build();
  }
  @Override
  public Radius build() {
    return this;
  }
}
