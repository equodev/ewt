package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BoxConstraintsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BoxConstraints extends Constraints implements BoxConstraintsI {
  private MemorySegment st;
  protected BoxConstraints() {}
  BoxConstraints(MemorySegment st) {
    this.id = BoxConstraintsObjSt.id(st);
    this.st = st;
    System.out.println("New BoxConstraints id:"+id);
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsBoxConstraints(OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight) {
    var st = factories.boxConstraintsBoxConstraints(minWidth,
      maxWidth,
      minHeight,
      maxHeight);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsBoxConstraintsBuilder boxConstraints() {
    return BoxConstraintsBoxConstraintsBuilder.boxConstraintsBoxConstraints();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsTightFor(OptionalDouble width, OptionalDouble height) {
    var st = factories.boxConstraintsTightFor(width,
      height);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsTightForBuilder tightFor() {
    return BoxConstraintsTightForBuilder.boxConstraintsTightFor();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsTightForFinite(OptionalDouble width, OptionalDouble height) {
    var st = factories.boxConstraintsTightForFinite(width,
      height);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsTightForFiniteBuilder tightForFinite() {
    return BoxConstraintsTightForFiniteBuilder.boxConstraintsTightForFinite();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsExpand(OptionalDouble width, OptionalDouble height) {
    var st = factories.boxConstraintsExpand(width,
      height);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsExpandBuilder expand() {
    return BoxConstraintsExpandBuilder.boxConstraintsExpand();
  }
  public static BoxConstraints lerp(BoxConstraintsI a, BoxConstraintsI b, double t) {
    var st = factories.boxConstraintsLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public double minWidth() {
    return BoxConstraintsObjSt.minWidth(st);
  }
  public double maxWidth() {
    return BoxConstraintsObjSt.maxWidth(st);
  }
  public double minHeight() {
    return BoxConstraintsObjSt.minHeight(st);
  }
  public double maxHeight() {
    return BoxConstraintsObjSt.maxHeight(st);
  }
  public boolean hasTightWidth() {
    return intToBool(BoxConstraintsObjSt.hasTightWidth(st));
  }
  public boolean hasTightHeight() {
    return intToBool(BoxConstraintsObjSt.hasTightHeight(st));
  }
  public boolean hasBoundedWidth() {
    return intToBool(BoxConstraintsObjSt.hasBoundedWidth(st));
  }
  public boolean hasBoundedHeight() {
    return intToBool(BoxConstraintsObjSt.hasBoundedHeight(st));
  }
  public boolean hasInfiniteWidth() {
    return intToBool(BoxConstraintsObjSt.hasInfiniteWidth(st));
  }
  public boolean hasInfiniteHeight() {
    return intToBool(BoxConstraintsObjSt.hasInfiniteHeight(st));
  }
  @Override
  public BoxConstraints build() {
    return this;
  }
}
