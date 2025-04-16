package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SizedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SizedBox extends SingleChildRenderObjectWidget implements SizedBoxI {
  private MemorySegment st;
  protected SizedBox() {}
  SizedBox(MemorySegment st) {
    this.id = SizedBoxObjSt.id(st);
    this.st = st;
    System.out.println("New SizedBox id:"+id);
  }
  @Builder.Factory
  static SizedBox sizedBoxSizedBox(OptionalDouble width, OptionalDouble height, Optional<WidgetI> child) {
    var st = factories.sizedBoxSizedBox(width,
      height,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(st);
  }
  public static SizedBoxSizedBoxBuilder sizedBox() {
    return SizedBoxSizedBoxBuilder.sizedBoxSizedBox();
  }
  @Builder.Factory
  static SizedBox sizedBoxExpand(Optional<WidgetI> child) {
    var st = factories.sizedBoxExpand(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(st);
  }
  public static SizedBoxExpandBuilder expand() {
    return SizedBoxExpandBuilder.sizedBoxExpand();
  }
  @Builder.Factory
  static SizedBox sizedBoxShrink(Optional<WidgetI> child) {
    var st = factories.sizedBoxShrink(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(st);
  }
  public static SizedBoxShrinkBuilder shrink() {
    return SizedBoxShrinkBuilder.sizedBoxShrink();
  }
  @Builder.Factory
  static SizedBox sizedBoxFromSize(Optional<WidgetI> child) {
    var st = factories.sizedBoxFromSize(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(st);
  }
  public static SizedBoxFromSizeBuilder fromSize() {
    return SizedBoxFromSizeBuilder.sizedBoxFromSize();
  }
  @Builder.Factory
  static SizedBox sizedBoxSquare(Optional<WidgetI> child, OptionalDouble dimension) {
    var st = factories.sizedBoxSquare(child.map(WidgetI::build),
      dimension);
    if (st == null) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(st);
  }
  public static SizedBoxSquareBuilder square() {
    return SizedBoxSquareBuilder.sizedBoxSquare();
  }
  public double width() {
    return SizedBoxObjSt.width(st);
  }
  public double height() {
    return SizedBoxObjSt.height(st);
  }
  @Override
  public SizedBox build() {
    return this;
  }
}
