package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OverflowBox extends SingleChildRenderObjectWidget implements OverflowBoxI {
  protected OverflowBox() {}
  OverflowBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OverflowBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static OverflowBox overflowBoxOverflowBox(Optional<AlignmentGeometryI> alignment, OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight, Optional<OverflowBoxFit> fit, Optional<WidgetI> child) {
    int id = factories.overflowBoxOverflowBox(alignment.map(AlignmentGeometryI::build),
      minWidth,
      maxWidth,
      minHeight,
      maxHeight,
      fit,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget OverflowBox");
    return new OverflowBox(id);
  }
  public static OverflowBoxOverflowBoxBuilder overflowBox() {
    return OverflowBoxOverflowBoxBuilder.overflowBoxOverflowBox();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxAlignment not supported on web");
    return factories.OverflowBox_readBack_alignment(nativeStruct);
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMinWidth not supported on web");
    return factories.OverflowBox_readBack_minWidth(nativeStruct);
  }
  public double maxWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMaxWidth not supported on web");
    return factories.OverflowBox_readBack_maxWidth(nativeStruct);
  }
  public double minHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMinHeight not supported on web");
    return factories.OverflowBox_readBack_minHeight(nativeStruct);
  }
  public double maxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMaxHeight not supported on web");
    return factories.OverflowBox_readBack_maxHeight(nativeStruct);
  }
  public OverflowBoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxFit not supported on web");
    return factories.OverflowBox_readBack_fit(nativeStruct);
  }
  @Override
  public OverflowBox build() {
    return this;
  }
}
