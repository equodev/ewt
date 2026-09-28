package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ElasticInOutCurve extends Curve implements ElasticInOutCurveI {
  protected ElasticInOutCurve() {}
  ElasticInOutCurve(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticInOutCurve");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ElasticInOutCurve elasticInOutCurveElasticInOutCurve(OptionalDouble period) {
    int id = factories.elasticInOutCurveElasticInOutCurve(period);
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticInOutCurve");
    return new ElasticInOutCurve(id);
  }
  public static ElasticInOutCurveElasticInOutCurveBuilder elasticInOutCurve() {
    return ElasticInOutCurveElasticInOutCurveBuilder.elasticInOutCurveElasticInOutCurve();
  }
  public double period() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("elasticInOutCurvePeriod not supported on web");
    return factories.ElasticInOutCurve_readBack_period(nativeStruct);
  }
  @Override
  public ElasticInOutCurve build() {
    return this;
  }
}
