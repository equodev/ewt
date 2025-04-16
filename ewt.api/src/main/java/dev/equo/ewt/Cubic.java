package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CubicObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Cubic extends Curve implements CubicI {
  private MemorySegment st;
  protected Cubic() {}
  Cubic(MemorySegment st) {
    this.id = CubicObjSt.id(st);
    this.st = st;
    System.out.println("New Cubic id:"+id);
  }
  @Builder.Factory
  static Cubic cubicCubic(@Builder.Parameter double a, @Builder.Parameter double b, @Builder.Parameter double c, @Builder.Parameter double d) {
    var st = factories.cubicCubic(a,
      b,
      c,
      d);
    if (st == null) throw new RuntimeException("Failed to created widget Cubic");
    return new Cubic(st);
  }
  public static CubicCubicBuilder cubic(double a, double b, double c, double d) {
    return CubicCubicBuilder.cubicCubic(a, b, c, d);
  }
  public double a() {
    return CubicObjSt.a(st);
  }
  public double b() {
    return CubicObjSt.b(st);
  }
  public double c() {
    return CubicObjSt.c(st);
  }
  public double d() {
    return CubicObjSt.d(st);
  }
  private static double _cubicErrorBound() {
    return 0.001;
  }
  @Override
  public Cubic build() {
    return this;
  }
}
