package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Offset extends OffsetBase implements OffsetI {
  protected Offset() {}
  Offset(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Offset offsetOffset(@Builder.Parameter double dx, @Builder.Parameter double dy) {
    int id = factories.offsetOffset(dx,
      dy);
    if (id <= 0) throw new RuntimeException("Failed to created widget Offset");
    System.out.println("New Offset id:"+id);
    return new Offset(id);
  }
  public static OffsetOffsetBuilder offset(double dx, double dy) {
    return OffsetOffsetBuilder.offsetOffset(dx, dy);
  }
  @Builder.Factory
  static Offset offsetFromDirection(@Builder.Parameter double direction, OptionalDouble distance) {
    int id = factories.offsetFromDirection(direction,
      distance);
    if (id <= 0) throw new RuntimeException("Failed to created widget Offset");
    System.out.println("New Offset id:"+id);
    return new Offset(id);
  }
  public static OffsetFromDirectionBuilder fromDirection(double direction) {
    return OffsetFromDirectionBuilder.offsetFromDirection(direction);
  }
  public static Offset lerp(OffsetI a, OffsetI b, double t) {
    int id = factories.offsetLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget Offset?");
    System.out.println("New Offset? id:"+id);
    return new Offset(id);
  }
  public static Offset zero() {
    return Offset.offset(0.0, 0.0).build();
  }
  public static Offset infinite() {
    return Offset.offset(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY).build();
  }
  @Override
  public Offset build() {
    return this;
  }
}
