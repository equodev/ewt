package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SizeTransition extends AnimatedWidget implements SizeTransitionI {
  protected SizeTransition() {}
  SizeTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SizeTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SizeTransition sizeTransitionSizeTransition(Optional<Axis> axis, AnimationI sizeFactor, OptionalDouble axisAlignment, Optional<AlignmentGeometryI> alignment, OptionalDouble fixedCrossAxisSizeFactor, Optional<WidgetI> child) {
    int id = factories.sizeTransitionSizeTransition(axis,
      sizeFactor.build(),
      axisAlignment,
      alignment.map(AlignmentGeometryI::build),
      fixedCrossAxisSizeFactor,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SizeTransition");
    return new SizeTransition(id);
  }
  public static SizeTransitionSizeTransitionBuilder sizeTransition() {
    return SizeTransitionSizeTransitionBuilder.sizeTransitionSizeTransition();
  }
  public Axis axis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizeTransitionAxis not supported on web");
    return factories.SizeTransition_readBack_axis(nativeStruct);
  }
  public double axisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizeTransitionAxisAlignment not supported on web");
    return factories.SizeTransition_readBack_axisAlignment(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizeTransitionAlignment not supported on web");
    return factories.SizeTransition_readBack_alignment(nativeStruct);
  }
  public double fixedCrossAxisSizeFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizeTransitionFixedCrossAxisSizeFactor not supported on web");
    return factories.SizeTransition_readBack_fixedCrossAxisSizeFactor(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizeTransitionChild not supported on web");
    return factories.SizeTransition_readBack_child(nativeStruct);
  }
  public Animation sizeFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizeTransitionSizeFactor not supported on web");
    return factories.SizeTransition_readBack_sizeFactor(nativeStruct);
  }
  @Override
  public SizeTransition build() {
    return this;
  }
}
