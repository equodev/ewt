package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Alignment extends AlignmentGeometry implements AlignmentI {
  protected Alignment() {}
  Alignment(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Alignment");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Alignment alignmentAlignment(@Builder.Parameter double x, @Builder.Parameter double y) {
    int id = factories.alignmentAlignment(x,
      y);
    if (id <= 0) throw new RuntimeException("Failed to created widget Alignment");
    return new Alignment(id);
  }
  public static AlignmentAlignmentBuilder alignment(double x, double y) {
    return AlignmentAlignmentBuilder.alignmentAlignment(x, y);
  }
  public static Alignment lerp(AlignmentI a, AlignmentI b, double t) {
    int id = factories.alignmentLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget Alignment");
    return new Alignment(id);
  }
  public double x() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignmentX not supported on web");
    return factories.Alignment_readBack_x(nativeStruct);
  }
  public double y() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignmentY not supported on web");
    return factories.Alignment_readBack_y(nativeStruct);
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
