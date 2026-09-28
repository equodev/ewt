package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedContainer extends ImplicitlyAnimatedWidget implements AnimatedContainerI {
  protected AnimatedContainer() {}
  AnimatedContainer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedContainer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedContainer animatedContainerAnimatedContainer(Optional<AlignmentGeometryI> alignment, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<DecorationI> decoration, Optional<DecorationI> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> margin, Optional<AlignmentGeometryI> transformAlignment, Optional<WidgetI> child, Optional<Clip> clipBehavior, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedContainerAnimatedContainer(alignment.map(AlignmentGeometryI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedContainer");
    return new AnimatedContainer(id);
  }
  public static AnimatedContainerAnimatedContainerBuilder animatedContainer() {
    return AnimatedContainerAnimatedContainerBuilder.animatedContainerAnimatedContainer();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerChild not supported on web");
    return factories.AnimatedContainer_readBack_child(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerAlignment not supported on web");
    return factories.AnimatedContainer_readBack_alignment(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerPadding not supported on web");
    return factories.AnimatedContainer_readBack_padding(nativeStruct);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerDecoration not supported on web");
    return factories.AnimatedContainer_readBack_decoration(nativeStruct);
  }
  public Decoration foregroundDecoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerForegroundDecoration not supported on web");
    return factories.AnimatedContainer_readBack_foregroundDecoration(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedContainerConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.AnimatedContainer_readBack_constraints(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerMargin not supported on web");
    return factories.AnimatedContainer_readBack_margin(nativeStruct);
  }
  public AlignmentGeometry transformAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerTransformAlignment not supported on web");
    return factories.AnimatedContainer_readBack_transformAlignment(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedContainerClipBehavior not supported on web");
    return factories.AnimatedContainer_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public AnimatedContainer build() {
    return this;
  }
}
