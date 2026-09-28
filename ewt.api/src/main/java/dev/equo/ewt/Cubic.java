package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Cubic extends Curve implements CubicI {
  protected Cubic() {}
  Cubic(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Cubic");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Cubic cubicCubic(@Builder.Parameter double a, @Builder.Parameter double b, @Builder.Parameter double c, @Builder.Parameter double d) {
    int id = factories.cubicCubic(a,
      b,
      c,
      d);
    if (id <= 0) throw new RuntimeException("Failed to created widget Cubic");
    return new Cubic(id);
  }
  public static CubicCubicBuilder cubic(double a, double b, double c, double d) {
    return CubicCubicBuilder.cubicCubic(a, b, c, d);
  }
  public double a() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cubicA not supported on web");
    return factories.Cubic_readBack_a(nativeStruct);
  }
  public double b() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cubicB not supported on web");
    return factories.Cubic_readBack_b(nativeStruct);
  }
  public double c() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cubicC not supported on web");
    return factories.Cubic_readBack_c(nativeStruct);
  }
  public double d() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cubicD not supported on web");
    return factories.Cubic_readBack_d(nativeStruct);
  }
  private static double _cubicErrorBound() {
    return 0.001;
  }
  @Override
  public Cubic build() {
    return this;
  }
}
