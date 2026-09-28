package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ElasticOutCurve extends Curve implements ElasticOutCurveI {
  protected ElasticOutCurve() {}
  ElasticOutCurve(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticOutCurve");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ElasticOutCurve elasticOutCurveElasticOutCurve(OptionalDouble period) {
    int id = factories.elasticOutCurveElasticOutCurve(period);
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticOutCurve");
    return new ElasticOutCurve(id);
  }
  public static ElasticOutCurveElasticOutCurveBuilder elasticOutCurve() {
    return ElasticOutCurveElasticOutCurveBuilder.elasticOutCurveElasticOutCurve();
  }
  public double period() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("elasticOutCurvePeriod not supported on web");
    return factories.ElasticOutCurve_readBack_period(nativeStruct);
  }
  @Override
  public ElasticOutCurve build() {
    return this;
  }
}
