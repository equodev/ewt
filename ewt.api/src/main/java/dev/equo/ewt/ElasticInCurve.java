package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ElasticInCurve extends Curve implements ElasticInCurveI {
  protected ElasticInCurve() {}
  ElasticInCurve(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticInCurve");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ElasticInCurve elasticInCurveElasticInCurve(OptionalDouble period) {
    int id = factories.elasticInCurveElasticInCurve(period);
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticInCurve");
    return new ElasticInCurve(id);
  }
  public static ElasticInCurveElasticInCurveBuilder elasticInCurve() {
    return ElasticInCurveElasticInCurveBuilder.elasticInCurveElasticInCurve();
  }
  public double period() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("elasticInCurvePeriod not supported on web");
    return factories.ElasticInCurve_readBack_period(nativeStruct);
  }
  @Override
  public ElasticInCurve build() {
    return this;
  }
}
