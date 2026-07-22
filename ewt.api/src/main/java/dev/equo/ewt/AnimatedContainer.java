package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedContainerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedContainer extends ImplicitlyAnimatedWidget implements AnimatedContainerI {
  private MemorySegment st;
  protected AnimatedContainer() {}
  AnimatedContainer(MemorySegment st) {
    this.id = AnimatedContainerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedContainer");
    System.out.println("New AnimatedContainer id:"+id);
  }
  @Builder.Factory
  static AnimatedContainer animatedContainerAnimatedContainer(Optional<AlignmentGeometryI> alignment, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<DecorationI> decoration, Optional<DecorationI> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> margin, Optional<AlignmentGeometryI> transformAlignment, Optional<WidgetI> child, Optional<Clip> clipBehavior, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedContainerAnimatedContainer(alignment.map(AlignmentGeometryI::build),
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      decoration.map(DecorationI::build),
      foregroundDecoration.map(DecorationI::build),
      width,
      height,
      constraints.map(BoxConstraintsI::build),
      margin.map(EdgeInsetsGeometryI::build),
      transformAlignment.map(AlignmentGeometryI::build),
      child.map(WidgetI::build),
      clipBehavior,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedContainer");
    return new AnimatedContainer(st);
  }
  public static AnimatedContainerAnimatedContainerBuilder animatedContainer() {
    return AnimatedContainerAnimatedContainerBuilder.animatedContainerAnimatedContainer();
  }
  public Widget child() {
    return new Widget(AnimatedContainerObjSt.child(st)) {};
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(AnimatedContainerObjSt.alignment(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(AnimatedContainerObjSt.padding(st)) {};
  }
  public Decoration decoration() {
    return new Decoration(AnimatedContainerObjSt.decoration(st)) {};
  }
  public Decoration foregroundDecoration() {
    return new Decoration(AnimatedContainerObjSt.foregroundDecoration(st)) {};
  }
  public BoxConstraints constraints() {
    return new BoxConstraints(AnimatedContainerObjSt.constraints(st));
  }
  public EdgeInsetsGeometry margin() {
    return new EdgeInsetsGeometry(AnimatedContainerObjSt.margin(st)) {};
  }
  public AlignmentGeometry transformAlignment() {
    return new AlignmentGeometry(AnimatedContainerObjSt.transformAlignment(st)) {};
  }
  public Clip clipBehavior() {
    return Clip.values()[AnimatedContainerObjSt.clipBehavior(st)];
  }
  @Override
  public AnimatedContainer build() {
    return this;
  }
}
