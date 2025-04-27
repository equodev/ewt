package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ElasticInOutCurveObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ElasticInOutCurve extends Curve implements ElasticInOutCurveI {
  private MemorySegment st;
  protected ElasticInOutCurve() {}
  ElasticInOutCurve(MemorySegment st) {
    this.id = ElasticInOutCurveObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticInOutCurve");
    System.out.println("New ElasticInOutCurve id:"+id);
  }
  @Builder.Factory
  static ElasticInOutCurve elasticInOutCurveElasticInOutCurve(OptionalDouble period) {
    var st = factories.elasticInOutCurveElasticInOutCurve(period);
    if (st == null) throw new RuntimeException("Failed to created widget ElasticInOutCurve");
    return new ElasticInOutCurve(st);
  }
  public static ElasticInOutCurveElasticInOutCurveBuilder elasticInOutCurve() {
    return ElasticInOutCurveElasticInOutCurveBuilder.elasticInOutCurveElasticInOutCurve();
  }
  public double period() {
    return ElasticInOutCurveObjSt.period(st);
  }
  @Override
  public ElasticInOutCurve build() {
    return this;
  }
}
