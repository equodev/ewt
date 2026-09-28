package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class UnconstrainedBox extends StatelessWidget implements UnconstrainedBoxI {
  protected UnconstrainedBox() {}
  UnconstrainedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget UnconstrainedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static UnconstrainedBox unconstrainedBoxUnconstrainedBox(Optional<WidgetI> child, Optional<TextDirection> textDirection, Optional<AlignmentGeometryI> alignment, Optional<Axis> constrainedAxis, Optional<Clip> clipBehavior) {
    int id = factories.unconstrainedBoxUnconstrainedBox(child.map(WidgetI::build),
      textDirection,
      alignment.map(AlignmentGeometryI::build),
      constrainedAxis,
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget UnconstrainedBox");
    return new UnconstrainedBox(id);
  }
  public static UnconstrainedBoxUnconstrainedBoxBuilder unconstrainedBox() {
    return UnconstrainedBoxUnconstrainedBoxBuilder.unconstrainedBoxUnconstrainedBox();
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxTextDirection not supported on web");
    return factories.UnconstrainedBox_readBack_textDirection(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxAlignment not supported on web");
    return factories.UnconstrainedBox_readBack_alignment(nativeStruct);
  }
  public Axis constrainedAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxConstrainedAxis not supported on web");
    return factories.UnconstrainedBox_readBack_constrainedAxis(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxClipBehavior not supported on web");
    return factories.UnconstrainedBox_readBack_clipBehavior(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxChild not supported on web");
    return factories.UnconstrainedBox_readBack_child(nativeStruct);
  }
  @Override
  public UnconstrainedBox build() {
    return this;
  }
}
