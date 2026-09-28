package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FittedBox extends SingleChildRenderObjectWidget implements FittedBoxI {
  protected FittedBox() {}
  FittedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FittedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FittedBox fittedBoxFittedBox(Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.fittedBoxFittedBox(fit,
      alignment.map(AlignmentGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FittedBox");
    return new FittedBox(id);
  }
  public static FittedBoxFittedBoxBuilder fittedBox() {
    return FittedBoxFittedBoxBuilder.fittedBoxFittedBox();
  }
  public BoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fittedBoxFit not supported on web");
    return factories.FittedBox_readBack_fit(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fittedBoxAlignment not supported on web");
    return factories.FittedBox_readBack_alignment(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fittedBoxClipBehavior not supported on web");
    return factories.FittedBox_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public FittedBox build() {
    return this;
  }
}
