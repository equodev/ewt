package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Border extends BoxBorder implements BorderI {
  private MemorySegment st;
  protected Border() {}
  Border(MemorySegment st) {
    this.id = BorderObjSt.id(st);
    this.st = st;
    System.out.println("New Border id:"+id);
  }
  @Builder.Factory
  static Border borderBorder(Optional<BorderSideI> top, Optional<BorderSideI> right, Optional<BorderSideI> bottom, Optional<BorderSideI> left) {
    var st = factories.borderBorder(top.map(BorderSideI::build),
      right.map(BorderSideI::build),
      bottom.map(BorderSideI::build),
      left.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Border");
    return new Border(st);
  }
  public static BorderBorderBuilder border() {
    return BorderBorderBuilder.borderBorder();
  }
  @Builder.Factory
  static Border borderFromBorderSide(@Builder.Parameter BorderSideI side) {
    var st = factories.borderFromBorderSide(side.build());
    if (st == null) throw new RuntimeException("Failed to created widget Border");
    return new Border(st);
  }
  public static BorderFromBorderSideBuilder fromBorderSide(BorderSideI side) {
    return BorderFromBorderSideBuilder.borderFromBorderSide(side);
  }
  @Builder.Factory
  static Border borderSymmetric(Optional<BorderSideI> vertical, Optional<BorderSideI> horizontal) {
    var st = factories.borderSymmetric(vertical.map(BorderSideI::build),
      horizontal.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Border");
    return new Border(st);
  }
  public static BorderSymmetricBuilder symmetric() {
    return BorderSymmetricBuilder.borderSymmetric();
  }
  @Builder.Factory
  static Border borderAll(Optional<ColorI> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    var st = factories.borderAll(color.map(ColorI::build),
      width,
      style,
      strokeAlign);
    if (st == null) throw new RuntimeException("Failed to created widget Border");
    return new Border(st);
  }
  public static BorderAllBuilder all() {
    return BorderAllBuilder.borderAll();
  }
  public static Border merge(BorderI a, BorderI b) {
    var st = factories.borderMerge(a.build(),
      b.build());
    if (st == null) throw new RuntimeException("Failed to created widget Border");
    return new Border(st);
  }
  public static Border lerp(BorderI a, BorderI b, double t) {
    var st = factories.borderLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget Border");
    return new Border(st);
  }
  public BorderSide top() {
    return new BorderSide(BorderObjSt.top(st));
  }
  public BorderSide right() {
    return new BorderSide(BorderObjSt.right(st));
  }
  public BorderSide bottom() {
    return new BorderSide(BorderObjSt.bottom(st));
  }
  public BorderSide left() {
    return new BorderSide(BorderObjSt.left(st));
  }
  @Override
  public Border build() {
    return this;
  }
}
