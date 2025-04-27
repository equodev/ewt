package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ElasticInCurveObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ElasticInCurve extends Curve implements ElasticInCurveI {
  private MemorySegment st;
  protected ElasticInCurve() {}
  ElasticInCurve(MemorySegment st) {
    this.id = ElasticInCurveObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticInCurve");
    System.out.println("New ElasticInCurve id:"+id);
  }
  @Builder.Factory
  static ElasticInCurve elasticInCurveElasticInCurve(OptionalDouble period) {
    var st = factories.elasticInCurveElasticInCurve(period);
    if (st == null) throw new RuntimeException("Failed to created widget ElasticInCurve");
    return new ElasticInCurve(st);
  }
  public static ElasticInCurveElasticInCurveBuilder elasticInCurve() {
    return ElasticInCurveElasticInCurveBuilder.elasticInCurveElasticInCurve();
  }
  public double period() {
    return ElasticInCurveObjSt.period(st);
  }
  @Override
  public ElasticInCurve build() {
    return this;
  }
}
