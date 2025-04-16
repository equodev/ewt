package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class CurvedAnimation extends NativeObj.Base implements Animation<Double>, CurvedAnimationI {
  protected CurvedAnimation() {}
  CurvedAnimation(int id) {
    this.id = id;
  }
  @Builder.Factory
  static CurvedAnimation curvedAnimationCurvedAnimation(@Builder.Parameter AnimationI parent, @Builder.Parameter CurveI curve, Optional<CurveI> reverseCurve) {
    int id = factories.curvedAnimationCurvedAnimation(parent.build(),
      curve.build(),
      reverseCurve.map(CurveI::build));
    if (id == -1) throw new RuntimeException("Failed to created widget CurvedAnimation");
    System.out.println("New CurvedAnimation id:"+id);
    return new CurvedAnimation(id);
  }
  public static CurvedAnimationCurvedAnimationBuilder curvedAnimation(AnimationI parent, CurveI curve) {
    return CurvedAnimationCurvedAnimationBuilder.curvedAnimationCurvedAnimation(parent, curve);
  }
  @Override
  public CurvedAnimation build() {
    return this;
  }
}
