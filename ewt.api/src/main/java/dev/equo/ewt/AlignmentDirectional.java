package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AlignmentDirectionalObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AlignmentDirectional extends AlignmentGeometry implements AlignmentDirectionalI {
  private MemorySegment st;
  protected AlignmentDirectional() {}
  AlignmentDirectional(MemorySegment st) {
    this.id = AlignmentDirectionalObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AlignmentDirectional");
    System.out.println("New AlignmentDirectional id:"+id);
  }
  @Builder.Factory
  static AlignmentDirectional alignmentDirectionalAlignmentDirectional(@Builder.Parameter double start, @Builder.Parameter double y) {
    var st = factories.alignmentDirectionalAlignmentDirectional(start,
      y);
    if (st == null) throw new RuntimeException("Failed to created widget AlignmentDirectional");
    return new AlignmentDirectional(st);
  }
  public static AlignmentDirectionalAlignmentDirectionalBuilder alignmentDirectional(double start, double y) {
    return AlignmentDirectionalAlignmentDirectionalBuilder.alignmentDirectionalAlignmentDirectional(start, y);
  }
  public static AlignmentDirectional lerp(AlignmentDirectionalI a, AlignmentDirectionalI b, double t) {
    var st = factories.alignmentDirectionalLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget AlignmentDirectional");
    return new AlignmentDirectional(st);
  }
  public double start() {
    return AlignmentDirectionalObjSt.start(st);
  }
  public double y() {
    return AlignmentDirectionalObjSt.y(st);
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
