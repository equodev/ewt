package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class StretchingOverscrollIndicator extends StatefulWidget implements StretchingOverscrollIndicatorI {
  protected StretchingOverscrollIndicator() {}
  StretchingOverscrollIndicator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget StretchingOverscrollIndicator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static StretchingOverscrollIndicator stretchingOverscrollIndicatorStretchingOverscrollIndicator(@Builder.Parameter AxisDirection axisDirection, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.stretchingOverscrollIndicatorStretchingOverscrollIndicator(axisDirection,
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget StretchingOverscrollIndicator");
    return new StretchingOverscrollIndicator(id);
  }
  public static StretchingOverscrollIndicatorStretchingOverscrollIndicatorBuilder stretchingOverscrollIndicator(AxisDirection axisDirection) {
    return StretchingOverscrollIndicatorStretchingOverscrollIndicatorBuilder.stretchingOverscrollIndicatorStretchingOverscrollIndicator(axisDirection);
  }
  public AxisDirection axisDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorAxisDirection not supported on web");
    return factories.StretchingOverscrollIndicator_readBack_axisDirection(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorClipBehavior not supported on web");
    return factories.StretchingOverscrollIndicator_readBack_clipBehavior(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorChild not supported on web");
    return factories.StretchingOverscrollIndicator_readBack_child(nativeStruct);
  }
  public Axis axis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorAxis not supported on web");
    return factories.StretchingOverscrollIndicator_readBack_axis(nativeStruct);
  }
  @Override
  public StretchingOverscrollIndicator build() {
    return this;
  }
}
