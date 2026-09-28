package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IntrinsicWidth extends SingleChildRenderObjectWidget implements IntrinsicWidthI {
  protected IntrinsicWidth() {}
  IntrinsicWidth(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IntrinsicWidth");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IntrinsicWidth intrinsicWidthIntrinsicWidth(OptionalDouble stepWidth, OptionalDouble stepHeight, Optional<WidgetI> child) {
    int id = factories.intrinsicWidthIntrinsicWidth(stepWidth,
      stepHeight,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget IntrinsicWidth");
    return new IntrinsicWidth(id);
  }
  public static IntrinsicWidthIntrinsicWidthBuilder intrinsicWidth() {
    return IntrinsicWidthIntrinsicWidthBuilder.intrinsicWidthIntrinsicWidth();
  }
  public double stepWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("intrinsicWidthStepWidth not supported on web");
    return factories.IntrinsicWidth_readBack_stepWidth(nativeStruct);
  }
  public double stepHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("intrinsicWidthStepHeight not supported on web");
    return factories.IntrinsicWidth_readBack_stepHeight(nativeStruct);
  }
  @Override
  public IntrinsicWidth build() {
    return this;
  }
}
