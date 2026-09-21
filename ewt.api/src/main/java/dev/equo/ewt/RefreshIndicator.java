package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RefreshIndicatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RefreshIndicator extends StatefulWidget implements RefreshIndicatorI {
  private MemorySegment st;
  protected RefreshIndicator() {}
  RefreshIndicator(MemorySegment st) {
    this.id = RefreshIndicatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshIndicator");
    System.out.println("New RefreshIndicator id:"+id);
  }
  RefreshIndicator(int id) { this.id = id; }
  @Builder.Factory
  static RefreshIndicator refreshIndicatorRefreshIndicator(OptionalDouble displacement, OptionalDouble edgeOffset, Supplier<Future<Void>> onRefresh, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<String> semanticsLabel, Optional<String> semanticsValue, OptionalDouble strokeWidth, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, WidgetI child) {
    var st = factories.refreshIndicatorRefreshIndicator(displacement,
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
    if (st == null) throw new RuntimeException("Failed to created widget RefreshIndicator");
    return new RefreshIndicator(st);
  }
  public static RefreshIndicatorRefreshIndicatorBuilder refreshIndicator() {
    return RefreshIndicatorRefreshIndicatorBuilder.refreshIndicatorRefreshIndicator();
  }
  @Builder.Factory
  static RefreshIndicator refreshIndicatorAdaptive(OptionalDouble displacement, OptionalDouble edgeOffset, Supplier<Future<Void>> onRefresh, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<String> semanticsLabel, Optional<String> semanticsValue, OptionalDouble strokeWidth, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, WidgetI child) {
    var st = factories.refreshIndicatorAdaptive(displacement,
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
    if (st == null) throw new RuntimeException("Failed to created widget RefreshIndicator");
    return new RefreshIndicator(st);
  }
  public static RefreshIndicatorAdaptiveBuilder adaptive() {
    return RefreshIndicatorAdaptiveBuilder.refreshIndicatorAdaptive();
  }
  @Builder.Factory
  static RefreshIndicator refreshIndicatorNoSpinner(@Builder.Parameter Supplier<Future<Void>> onRefresh, Optional<Consumer<RefreshIndicatorStatus>> onStatusChange, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, WidgetI child) {
    var st = factories.refreshIndicatorNoSpinner(onRefresh,
      onStatusChange,
      semanticsLabel,
      semanticsValue,
      triggerMode,
      elevation,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget RefreshIndicator");
    return new RefreshIndicator(st);
  }
  public static RefreshIndicatorNoSpinnerBuilder noSpinner(Supplier<Future<Void>> onRefresh) {
    return RefreshIndicatorNoSpinnerBuilder.refreshIndicatorNoSpinner(onRefresh);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorChild not supported on web");
    return new Widget(RefreshIndicatorObjSt.child(st)) {};
  }
  public double displacement() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorDisplacement not supported on web");
    return RefreshIndicatorObjSt.displacement(st);
  }
  public double edgeOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorEdgeOffset not supported on web");
    return RefreshIndicatorObjSt.edgeOffset(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("refreshIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(RefreshIndicatorObjSt.color(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("refreshIndicatorBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(RefreshIndicatorObjSt.backgroundColor(st));
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorSemanticsLabel not supported on web");
    return RefreshIndicatorObjSt.semanticsLabel(st).getString(0);
  }
  public String semanticsValue() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorSemanticsValue not supported on web");
    return RefreshIndicatorObjSt.semanticsValue(st).getString(0);
  }
  public double strokeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorStrokeWidth not supported on web");
    return RefreshIndicatorObjSt.strokeWidth(st);
  }
  public RefreshIndicatorTriggerMode triggerMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorTriggerMode not supported on web");
    return RefreshIndicatorTriggerMode.values()[RefreshIndicatorObjSt.triggerMode(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshIndicatorElevation not supported on web");
    return RefreshIndicatorObjSt.elevation(st);
  }
  @Override
  public RefreshIndicator build() {
    return this;
  }
}
