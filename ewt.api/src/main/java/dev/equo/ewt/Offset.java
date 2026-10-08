package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public class Offset extends OffsetBase implements OffsetI {
  protected Offset() {}
  Offset(int id) {
    this.id = id;
  }
  public static Offset byId(int id) { return new Offset(id); }
  static { NativeObj.register("Offset", Offset::byId); }
  @Builder.Factory
  static Offset offsetOffset(@Builder.Parameter double dx, @Builder.Parameter double dy) {
    var id = factories.offsetOffset(dx,
      dy);
    if (id <= 0) throw new RuntimeException("Failed to created widget Offset");
    return new Offset(id);
  }
  public static OffsetOffsetBuilder offset(double dx, double dy) {
    return OffsetOffsetBuilder.offsetOffset(dx, dy);
  }
  @Builder.Factory
  static Offset offsetFromDirection(@Builder.Parameter double direction, OptionalDouble distance) {
    var id = factories.offsetFromDirection(direction,
      distance);
    if (id <= 0) throw new RuntimeException("Failed to created widget Offset");
    return new Offset(id);
  }
  public static OffsetFromDirectionBuilder fromDirection(double direction) {
    return OffsetFromDirectionBuilder.offsetFromDirection(direction);
  }
  public static Offset lerp(OffsetI a, OffsetI b, double t) {
    var id = factories.offsetLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget Offset?");
    return new Offset(id);
  }
  public double dx() {
    var id = factories.offsetDx(this);
    return id;
  }
  public double dy() {
    var id = factories.offsetDy(this);
    return id;
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
