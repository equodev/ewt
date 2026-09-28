package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AlignmentDirectional extends AlignmentGeometry implements AlignmentDirectionalI {
  protected AlignmentDirectional() {}
  AlignmentDirectional(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AlignmentDirectional");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AlignmentDirectional alignmentDirectionalAlignmentDirectional(@Builder.Parameter double start, @Builder.Parameter double y) {
    int id = factories.alignmentDirectionalAlignmentDirectional(start,
      y);
    if (id <= 0) throw new RuntimeException("Failed to created widget AlignmentDirectional");
    return new AlignmentDirectional(id);
  }
  public static AlignmentDirectionalAlignmentDirectionalBuilder alignmentDirectional(double start, double y) {
    return AlignmentDirectionalAlignmentDirectionalBuilder.alignmentDirectionalAlignmentDirectional(start, y);
  }
  public static AlignmentDirectional lerp(AlignmentDirectionalI a, AlignmentDirectionalI b, double t) {
    int id = factories.alignmentDirectionalLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget AlignmentDirectional");
    return new AlignmentDirectional(id);
  }
  public double start() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignmentDirectionalStart not supported on web");
    return factories.AlignmentDirectional_readBack_start(nativeStruct);
  }
  public double y() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignmentDirectionalY not supported on web");
    return factories.AlignmentDirectional_readBack_y(nativeStruct);
  }
  public static AlignmentDirectional topStart() {
    return AlignmentDirectional.alignmentDirectional(-1.0, -1.0).build();
  }
  public static AlignmentDirectional topCenter() {
    return AlignmentDirectional.alignmentDirectional(0.0, -1.0).build();
  }
  public static AlignmentDirectional topEnd() {
    return AlignmentDirectional.alignmentDirectional(1.0, -1.0).build();
  }
  public static AlignmentDirectional centerStart() {
    return AlignmentDirectional.alignmentDirectional(-1.0, 0.0).build();
  }
  public static AlignmentDirectional center() {
    return AlignmentDirectional.alignmentDirectional(0.0, 0.0).build();
  }
  public static AlignmentDirectional centerEnd() {
    return AlignmentDirectional.alignmentDirectional(1.0, 0.0).build();
  }
  public static AlignmentDirectional bottomStart() {
    return AlignmentDirectional.alignmentDirectional(-1.0, 1.0).build();
  }
  public static AlignmentDirectional bottomCenter() {
    return AlignmentDirectional.alignmentDirectional(0.0, 1.0).build();
  }
  public static AlignmentDirectional bottomEnd() {
    return AlignmentDirectional.alignmentDirectional(1.0, 1.0).build();
  }
  @Override
  public AlignmentDirectional build() {
    return this;
  }
}
