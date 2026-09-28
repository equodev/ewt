package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RefreshIndicator extends StatefulWidget implements RefreshIndicatorI {
  protected RefreshIndicator() {}
  RefreshIndicator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshIndicator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RefreshIndicator refreshIndicatorRefreshIndicator(OptionalDouble displacement, OptionalDouble edgeOffset, Supplier<Future<Void>> onRefresh, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<String> semanticsLabel, Optional<String> semanticsValue, OptionalDouble strokeWidth, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, WidgetI child) {
    int id = factories.refreshIndicatorRefreshIndicator(displacement,
      edgeOffset,
      onRefresh,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      semanticsLabel,
      semanticsValue,
      strokeWidth,
      triggerMode,
      elevation,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshIndicator");
    return new RefreshIndicator(id);
  }
  public static RefreshIndicatorRefreshIndicatorBuilder refreshIndicator() {
    return RefreshIndicatorRefreshIndicatorBuilder.refreshIndicatorRefreshIndicator();
  }
  @Builder.Factory
  static RefreshIndicator refreshIndicatorAdaptive(OptionalDouble displacement, OptionalDouble edgeOffset, Supplier<Future<Void>> onRefresh, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<String> semanticsLabel, Optional<String> semanticsValue, OptionalDouble strokeWidth, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, WidgetI child) {
    int id = factories.refreshIndicatorAdaptive(displacement,
      edgeOffset,
      onRefresh,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      semanticsLabel,
      semanticsValue,
      strokeWidth,
      triggerMode,
      elevation,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshIndicator");
    return new RefreshIndicator(id);
  }
  public static RefreshIndicatorAdaptiveBuilder adaptive() {
    return RefreshIndicatorAdaptiveBuilder.refreshIndicatorAdaptive();
  }
  @Builder.Factory
  static RefreshIndicator refreshIndicatorNoSpinner(@Builder.Parameter Supplier<Future<Void>> onRefresh, Optional<Consumer<RefreshIndicatorStatus>> onStatusChange, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, WidgetI child) {
    int id = factories.refreshIndicatorNoSpinner(onRefresh,
      onStatusChange,
      semanticsLabel,
      semanticsValue,
      triggerMode,
      elevation,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshIndicator");
    return new RefreshIndicator(id);
  }
  public static RefreshIndicatorNoSpinnerBuilder noSpinner(Supplier<Future<Void>> onRefresh) {
    return RefreshIndicatorNoSpinnerBuilder.refreshIndicatorNoSpinner(onRefresh);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorChild not supported on web");
    return factories.RefreshIndicator_readBack_child(nativeStruct);
  }
  public double displacement() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorDisplacement not supported on web");
    return factories.RefreshIndicator_readBack_displacement(nativeStruct);
  }
  public double edgeOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorEdgeOffset not supported on web");
    return factories.RefreshIndicator_readBack_edgeOffset(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("refreshIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.RefreshIndicator_readBack_color(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("refreshIndicatorBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.RefreshIndicator_readBack_backgroundColor(nativeStruct);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorSemanticsLabel not supported on web");
    return factories.RefreshIndicator_readBack_semanticsLabel(nativeStruct);
  }
  public String semanticsValue() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorSemanticsValue not supported on web");
    return factories.RefreshIndicator_readBack_semanticsValue(nativeStruct);
  }
  public double strokeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorStrokeWidth not supported on web");
    return factories.RefreshIndicator_readBack_strokeWidth(nativeStruct);
  }
  public RefreshIndicatorTriggerMode triggerMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorTriggerMode not supported on web");
    return factories.RefreshIndicator_readBack_triggerMode(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorElevation not supported on web");
    return factories.RefreshIndicator_readBack_elevation(nativeStruct);
  }
  @Override
  public RefreshIndicator build() {
    return this;
  }
}
