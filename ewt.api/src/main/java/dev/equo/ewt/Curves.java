package dev.equo.ewt;
import java.util.*;
public abstract class Curves extends NativeObj.Base implements CurvesI {
  protected Curves() {}
  Curves(int id) {
    this.id = id;
  }
  public static Curve linear() {
    int id = factories.curvesLinear();
    if (id == -1) throw new RuntimeException("Failed to create const linear");
    System.out.println("Const linear id:"+id);
    return new Curve(id) {};
  }
  public static Curve decelerate() {
    int id = factories.curvesDecelerate();
    if (id == -1) throw new RuntimeException("Failed to create const decelerate");
    System.out.println("Const decelerate id:"+id);
    return new Curve(id) {};
  }
  public static Cubic fastLinearToSlowEaseIn() {
    return Cubic.cubic(0.18, 1.0, 0.04, 1.0).build();
  }
  public static ThreePointCubic fastEaseInToSlowEaseOut() {
    return ThreePointCubic.threePointCubic(Offset.offset(0.056, 0.024).build(), Offset.offset(0.108, 0.3085).build(), Offset.offset(0.198, 0.541).build(), Offset.offset(0.3655, 1.0).build(), Offset.offset(0.5465, 0.989).build()).build();
  }
  public static Cubic ease() {
    return Cubic.cubic(0.25, 0.1, 0.25, 1.0).build();
  }
  public static Cubic easeIn() {
    return Cubic.cubic(0.42, 0.0, 1.0, 1.0).build();
  }
  public static Cubic easeInToLinear() {
    return Cubic.cubic(0.67, 0.03, 0.65, 0.09).build();
  }
  public static Cubic easeInSine() {
    return Cubic.cubic(0.47, 0.0, 0.745, 0.715).build();
  }
  public static Cubic easeInQuad() {
    return Cubic.cubic(0.55, 0.085, 0.68, 0.53).build();
  }
  public static Cubic easeInCubic() {
    return Cubic.cubic(0.55, 0.055, 0.675, 0.19).build();
  }
  public static Cubic easeInQuart() {
    return Cubic.cubic(0.895, 0.03, 0.685, 0.22).build();
  }
  public static Cubic easeInQuint() {
    return Cubic.cubic(0.755, 0.05, 0.855, 0.06).build();
  }
  public static Cubic easeInExpo() {
    return Cubic.cubic(0.95, 0.05, 0.795, 0.035).build();
  }
  public static Cubic easeInCirc() {
    return Cubic.cubic(0.6, 0.04, 0.98, 0.335).build();
  }
  public static Cubic easeInBack() {
    return Cubic.cubic(0.6, -0.28, 0.735, 0.045).build();
  }
  public static Cubic easeOut() {
    return Cubic.cubic(0.0, 0.0, 0.58, 1.0).build();
  }
  public static Cubic linearToEaseOut() {
    return Cubic.cubic(0.35, 0.91, 0.33, 0.97).build();
  }
  public static Cubic easeOutSine() {
    return Cubic.cubic(0.39, 0.575, 0.565, 1.0).build();
  }
  public static Cubic easeOutQuad() {
    return Cubic.cubic(0.25, 0.46, 0.45, 0.94).build();
  }
  public static Cubic easeOutCubic() {
    return Cubic.cubic(0.215, 0.61, 0.355, 1.0).build();
  }
  public static Cubic easeOutQuart() {
    return Cubic.cubic(0.165, 0.84, 0.44, 1.0).build();
  }
  public static Cubic easeOutQuint() {
    return Cubic.cubic(0.23, 1.0, 0.32, 1.0).build();
  }
  public static Cubic easeOutExpo() {
    return Cubic.cubic(0.19, 1.0, 0.22, 1.0).build();
  }
  public static Cubic easeOutCirc() {
    return Cubic.cubic(0.075, 0.82, 0.165, 1.0).build();
  }
  public static Cubic easeOutBack() {
    return Cubic.cubic(0.175, 0.885, 0.32, 1.275).build();
  }
  public static Cubic easeInOut() {
    return Cubic.cubic(0.42, 0.0, 0.58, 1.0).build();
  }
  public static Cubic easeInOutSine() {
    return Cubic.cubic(0.445, 0.05, 0.55, 0.95).build();
  }
  public static Cubic easeInOutQuad() {
    return Cubic.cubic(0.455, 0.03, 0.515, 0.955).build();
  }
  public static Cubic easeInOutCubic() {
    return Cubic.cubic(0.645, 0.045, 0.355, 1.0).build();
  }
  public static ThreePointCubic easeInOutCubicEmphasized() {
    return ThreePointCubic.threePointCubic(Offset.offset(0.05, 0).build(), Offset.offset(0.133333, 0.06).build(), Offset.offset(0.166666, 0.4).build(), Offset.offset(0.208333, 0.82).build(), Offset.offset(0.25, 1).build()).build();
  }
  public static Cubic easeInOutQuart() {
    return Cubic.cubic(0.77, 0.0, 0.175, 1.0).build();
  }
  public static Cubic easeInOutQuint() {
    return Cubic.cubic(0.86, 0.0, 0.07, 1.0).build();
  }
  public static Cubic easeInOutExpo() {
    return Cubic.cubic(1.0, 0.0, 0.0, 1.0).build();
  }
  public static Cubic easeInOutCirc() {
    return Cubic.cubic(0.785, 0.135, 0.15, 0.86).build();
  }
  public static Cubic easeInOutBack() {
    return Cubic.cubic(0.68, -0.55, 0.265, 1.55).build();
  }
  public static Cubic fastOutSlowIn() {
    return Cubic.cubic(0.4, 0.0, 0.2, 1.0).build();
  }
  public static Cubic slowMiddle() {
    return Cubic.cubic(0.15, 0.85, 0.85, 0.15).build();
  }
  public static Curve bounceIn() {
    int id = factories.curvesBounceIn();
    if (id == -1) throw new RuntimeException("Failed to create const bounceIn");
    System.out.println("Const bounceIn id:"+id);
    return new Curve(id) {};
  }
  public static Curve bounceOut() {
    int id = factories.curvesBounceOut();
    if (id == -1) throw new RuntimeException("Failed to create const bounceOut");
    System.out.println("Const bounceOut id:"+id);
    return new Curve(id) {};
  }
  public static Curve bounceInOut() {
    int id = factories.curvesBounceInOut();
    if (id == -1) throw new RuntimeException("Failed to create const bounceInOut");
    System.out.println("Const bounceInOut id:"+id);
    return new Curve(id) {};
  }
  public static ElasticInCurve elasticIn() {
    return ElasticInCurve.elasticInCurve().build();
  }
  public static ElasticOutCurve elasticOut() {
    return ElasticOutCurve.elasticOutCurve().build();
  }
  public static ElasticInOutCurve elasticInOut() {
    return ElasticInOutCurve.elasticInOutCurve().build();
  }
  @Override
  public Curves build() {
    return this;
  }
}
