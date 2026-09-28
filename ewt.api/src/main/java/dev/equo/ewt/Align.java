package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Align extends SingleChildRenderObjectWidget implements AlignI {
  protected Align() {}
  Align(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Align");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Align alignAlign(Optional<AlignmentGeometryI> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    int id = factories.alignAlign(alignment.map(AlignmentGeometryI::build),
      widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Align");
    return new Align(id);
  }
  public static AlignAlignBuilder align() {
    return AlignAlignBuilder.alignAlign();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignAlignment not supported on web");
    return factories.Align_readBack_alignment(nativeStruct);
  }
  public double widthFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignWidthFactor not supported on web");
    return factories.Align_readBack_widthFactor(nativeStruct);
  }
  public double heightFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignHeightFactor not supported on web");
    return factories.Align_readBack_heightFactor(nativeStruct);
  }
  @Override
  public Align build() {
    return this;
  }
}
