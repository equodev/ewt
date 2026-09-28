package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FractionallySizedBox extends SingleChildRenderObjectWidget implements FractionallySizedBoxI {
  protected FractionallySizedBox() {}
  FractionallySizedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FractionallySizedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FractionallySizedBox fractionallySizedBoxFractionallySizedBox(Optional<AlignmentGeometryI> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    int id = factories.fractionallySizedBoxFractionallySizedBox(alignment.map(AlignmentGeometryI::build),
      widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FractionallySizedBox");
    return new FractionallySizedBox(id);
  }
  public static FractionallySizedBoxFractionallySizedBoxBuilder fractionallySizedBox() {
    return FractionallySizedBoxFractionallySizedBoxBuilder.fractionallySizedBoxFractionallySizedBox();
  }
  public double widthFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fractionallySizedBoxWidthFactor not supported on web");
    return factories.FractionallySizedBox_readBack_widthFactor(nativeStruct);
  }
  public double heightFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fractionallySizedBoxHeightFactor not supported on web");
    return factories.FractionallySizedBox_readBack_heightFactor(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fractionallySizedBoxAlignment not supported on web");
    return factories.FractionallySizedBox_readBack_alignment(nativeStruct);
  }
  @Override
  public FractionallySizedBox build() {
    return this;
  }
}
