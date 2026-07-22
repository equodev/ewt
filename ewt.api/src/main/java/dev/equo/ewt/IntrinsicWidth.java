package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IntrinsicWidthObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IntrinsicWidth extends SingleChildRenderObjectWidget implements IntrinsicWidthI {
  private MemorySegment st;
  protected IntrinsicWidth() {}
  IntrinsicWidth(MemorySegment st) {
    this.id = IntrinsicWidthObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IntrinsicWidth");
    System.out.println("New IntrinsicWidth id:"+id);
  }
  @Builder.Factory
  static IntrinsicWidth intrinsicWidthIntrinsicWidth(OptionalDouble stepWidth, OptionalDouble stepHeight, Optional<WidgetI> child) {
    var st = factories.intrinsicWidthIntrinsicWidth(stepWidth,
      stepHeight,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget IntrinsicWidth");
    return new IntrinsicWidth(st);
  }
  public static IntrinsicWidthIntrinsicWidthBuilder intrinsicWidth() {
    return IntrinsicWidthIntrinsicWidthBuilder.intrinsicWidthIntrinsicWidth();
  }
  public double stepWidth() {
    return IntrinsicWidthObjSt.stepWidth(st);
  }
  public double stepHeight() {
    return IntrinsicWidthObjSt.stepHeight(st);
  }
  @Override
  public IntrinsicWidth build() {
    return this;
  }
}
