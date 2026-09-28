package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Baseline extends SingleChildRenderObjectWidget implements BaselineI {
  protected Baseline() {}
  Baseline(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Baseline");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Baseline baselineBaseline(@Builder.Parameter double baseline, @Builder.Parameter TextBaseline baselineType, Optional<WidgetI> child) {
    int id = factories.baselineBaseline(baseline,
      baselineType,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Baseline");
    return new Baseline(id);
  }
  public static BaselineBaselineBuilder baseline(double baseline, TextBaseline baselineType) {
    return BaselineBaselineBuilder.baselineBaseline(baseline, baselineType);
  }
  public double baseline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("baselineBaseline not supported on web");
    return factories.Baseline_readBack_baseline(nativeStruct);
  }
  public TextBaseline baselineType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("baselineBaselineType not supported on web");
    return factories.Baseline_readBack_baselineType(nativeStruct);
  }
  @Override
  public Baseline build() {
    return this;
  }
}
