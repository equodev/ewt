package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CurvedAnimation extends NativeObj.Base implements Animation<Double>, CurvedAnimationI {
  protected CurvedAnimation() {}
  CurvedAnimation(int id) {
    this.id = id;
  }
  public static CurvedAnimation byId(int id) { return new CurvedAnimation(id); }
  static { NativeObj.register("CurvedAnimation", CurvedAnimation::byId); }
  @Builder.Factory
  static CurvedAnimation curvedAnimationCurvedAnimation(@Builder.Parameter AnimationI parent, @Builder.Parameter CurveI curve, Optional<CurveI> reverseCurve) {
    var id = factories.curvedAnimationCurvedAnimation(parent.build(),
      curve.build(),
      reverseCurve.map(CurveI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CurvedAnimation");
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
