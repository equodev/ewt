package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class LimitedBox extends SingleChildRenderObjectWidget implements LimitedBoxI {
  protected LimitedBox() {}
  LimitedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget LimitedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static LimitedBox limitedBoxLimitedBox(OptionalDouble maxWidth, OptionalDouble maxHeight, Optional<WidgetI> child) {
    int id = factories.limitedBoxLimitedBox(maxWidth,
      maxHeight,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget LimitedBox");
    return new LimitedBox(id);
  }
  public static LimitedBoxLimitedBoxBuilder limitedBox() {
    return LimitedBoxLimitedBoxBuilder.limitedBoxLimitedBox();
  }
  public double maxWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("limitedBoxMaxWidth not supported on web");
    return factories.LimitedBox_readBack_maxWidth(nativeStruct);
  }
  public double maxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("limitedBoxMaxHeight not supported on web");
    return factories.LimitedBox_readBack_maxHeight(nativeStruct);
  }
  @Override
  public LimitedBox build() {
    return this;
  }
}
