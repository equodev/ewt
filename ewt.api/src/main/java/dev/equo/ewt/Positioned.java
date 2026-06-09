package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PositionedObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Positioned extends ParentDataWidget<StackParentData> implements PositionedI {
  private MemorySegment st;
  protected Positioned() {}
  Positioned(MemorySegment st) {
    this.id = PositionedObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Positioned");
    System.out.println("New Positioned id:"+id);
  }
  @Builder.Factory
  static Positioned positionedPositioned(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, WidgetI child) {
    var st = factories.positionedPositioned(left,
      top,
      right,
      bottom,
      width,
      height,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Positioned");
    return new Positioned(st);
  }
  public static PositionedPositionedBuilder positioned() {
    return PositionedPositionedBuilder.positionedPositioned();
  }
  @Builder.Factory
  static Positioned positionedFill(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, WidgetI child) {
    var st = factories.positionedFill(left,
      top,
      right,
      bottom,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Positioned");
    return new Positioned(st);
  }
  public static PositionedFillBuilder fill() {
    return PositionedFillBuilder.positionedFill();
  }
  @Builder.Factory
  static Positioned positionedDirectional(@Builder.Parameter TextDirection textDirection, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, WidgetI child) {
    var st = factories.positionedDirectional(textDirection,
      start,
      top,
      end,
      bottom,
      width,
      height,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Positioned");
    return new Positioned(st);
  }
  public static PositionedDirectionalBuilder directional(TextDirection textDirection) {
    return PositionedDirectionalBuilder.positionedDirectional(textDirection);
  }
  public double left() {
    return PositionedObjSt.left(st);
  }
  public double top() {
    return PositionedObjSt.top(st);
  }
  public double right() {
    return PositionedObjSt.right(st);
  }
  public double bottom() {
    return PositionedObjSt.bottom(st);
  }
  public double width() {
    return PositionedObjSt.width(st);
  }
  public double height() {
    return PositionedObjSt.height(st);
  }
  @Override
  public Positioned build() {
    return this;
  }
}
