package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AlignmentObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Alignment extends AlignmentGeometry implements AlignmentI {
  private MemorySegment st;
  protected Alignment() {}
  Alignment(MemorySegment st) {
    this.id = AlignmentObjSt.id(st);
    this.st = st;
    System.out.println("New Alignment id:"+id);
  }
  @Builder.Factory
  static Alignment alignmentAlignment(@Builder.Parameter double x, @Builder.Parameter double y) {
    var st = factories.alignmentAlignment(x,
      y);
    if (st == null) throw new RuntimeException("Failed to created widget Alignment");
    return new Alignment(st);
  }
  public static AlignmentAlignmentBuilder alignment(double x, double y) {
    return AlignmentAlignmentBuilder.alignmentAlignment(x, y);
  }
  public static Alignment lerp(AlignmentI a, AlignmentI b, double t) {
    var st = factories.alignmentLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget Alignment");
    return new Alignment(st);
  }
  public double x() {
    return AlignmentObjSt.x(st);
  }
  public double y() {
    return AlignmentObjSt.y(st);
  }
  public static Alignment topLeft() {
    return Alignment.alignment(-1.0, -1.0).build();
  }
  public static Alignment topCenter() {
    return Alignment.alignment(0.0, -1.0).build();
  }
  public static Alignment topRight() {
    return Alignment.alignment(1.0, -1.0).build();
  }
  public static Alignment centerLeft() {
    return Alignment.alignment(-1.0, 0.0).build();
  }
  public static Alignment center() {
    return Alignment.alignment(0.0, 0.0).build();
  }
  public static Alignment centerRight() {
    return Alignment.alignment(1.0, 0.0).build();
  }
  public static Alignment bottomLeft() {
    return Alignment.alignment(-1.0, 1.0).build();
  }
  public static Alignment bottomCenter() {
    return Alignment.alignment(0.0, 1.0).build();
  }
  public static Alignment bottomRight() {
    return Alignment.alignment(1.0, 1.0).build();
  }
  @Override
  public Alignment build() {
    return this;
  }
}
