package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AspectRatio extends SingleChildRenderObjectWidget implements AspectRatioI {
  protected AspectRatio() {}
  AspectRatio(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AspectRatio");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AspectRatio aspectRatioAspectRatio(@Builder.Parameter double aspectRatio, Optional<WidgetI> child) {
    int id = factories.aspectRatioAspectRatio(aspectRatio,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget AspectRatio");
    return new AspectRatio(id);
  }
  public static AspectRatioAspectRatioBuilder aspectRatio(double aspectRatio) {
    return AspectRatioAspectRatioBuilder.aspectRatioAspectRatio(aspectRatio);
  }
  public double aspectRatio() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aspectRatioAspectRatio not supported on web");
    return factories.AspectRatio_readBack_aspectRatio(nativeStruct);
  }
  @Override
  public AspectRatio build() {
    return this;
  }
}
