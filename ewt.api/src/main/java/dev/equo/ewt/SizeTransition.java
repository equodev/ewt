package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SizeTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SizeTransition extends AnimatedWidget implements SizeTransitionI {
  private MemorySegment st;
  protected SizeTransition() {}
  SizeTransition(MemorySegment st) {
    this.id = SizeTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SizeTransition");
    System.out.println("New SizeTransition id:"+id);
  }
  @Builder.Factory
  static SizeTransition sizeTransitionSizeTransition(Optional<Axis> axis, AnimationI sizeFactor, OptionalDouble axisAlignment, OptionalDouble fixedCrossAxisSizeFactor, Optional<WidgetI> child) {
    var st = factories.sizeTransitionSizeTransition(axis,
      sizeFactor.build(),
      axisAlignment,
      fixedCrossAxisSizeFactor,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SizeTransition");
    return new SizeTransition(st);
  }
  public static SizeTransitionSizeTransitionBuilder sizeTransition() {
    return SizeTransitionSizeTransitionBuilder.sizeTransitionSizeTransition();
  }
  public Axis axis() {
    return Axis.values()[SizeTransitionObjSt.axis(st)];
  }
  public double axisAlignment() {
    return SizeTransitionObjSt.axisAlignment(st);
  }
  public double fixedCrossAxisSizeFactor() {
    return SizeTransitionObjSt.fixedCrossAxisSizeFactor(st);
  }
  public Widget child() {
    return new Widget(SizeTransitionObjSt.child(st)) {};
  }
  public Animation sizeFactor() {
    return new Animation() { public int getId() { return SizeTransitionObjSt.sizeFactor(st); } };
  }
  @Override
  public SizeTransition build() {
    return this;
  }
}
