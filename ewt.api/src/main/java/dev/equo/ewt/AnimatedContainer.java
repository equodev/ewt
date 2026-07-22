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
  AnimatedContainer(int id) { this.id = id; }
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerChild not supported on web");
    return new Widget(AnimatedContainerObjSt.child(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerAlignment not supported on web");
    return new AlignmentGeometry(AnimatedContainerObjSt.alignment(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerPadding not supported on web");
    return new EdgeInsetsGeometry(AnimatedContainerObjSt.padding(st)) {};
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerDecoration not supported on web");
    return new Decoration(AnimatedContainerObjSt.decoration(st)) {};
  }
  public Decoration foregroundDecoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerForegroundDecoration not supported on web");
    return new Decoration(AnimatedContainerObjSt.foregroundDecoration(st)) {};
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedContainerConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(AnimatedContainerObjSt.constraints(st));
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerMargin not supported on web");
    return new EdgeInsetsGeometry(AnimatedContainerObjSt.margin(st)) {};
  }
  public AlignmentGeometry transformAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerTransformAlignment not supported on web");
    return new AlignmentGeometry(AnimatedContainerObjSt.transformAlignment(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerClipBehavior not supported on web");
    return Clip.values()[AnimatedContainerObjSt.clipBehavior(st)];
  }
  @Override
  public AnimatedContainer build() {
    return this;
  }
}
