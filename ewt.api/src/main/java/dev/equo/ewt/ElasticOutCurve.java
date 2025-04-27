package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ElasticOutCurveObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ElasticOutCurve extends Curve implements ElasticOutCurveI {
  private MemorySegment st;
  protected ElasticOutCurve() {}
  ElasticOutCurve(MemorySegment st) {
    this.id = ElasticOutCurveObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElasticOutCurve");
    System.out.println("New ElasticOutCurve id:"+id);
  }
  @Builder.Factory
  static ElasticOutCurve elasticOutCurveElasticOutCurve(OptionalDouble period) {
    var st = factories.elasticOutCurveElasticOutCurve(period);
    if (st == null) throw new RuntimeException("Failed to created widget ElasticOutCurve");
    return new ElasticOutCurve(st);
  }
  public static ElasticOutCurveElasticOutCurveBuilder elasticOutCurve() {
    return ElasticOutCurveElasticOutCurveBuilder.elasticOutCurveElasticOutCurve();
  }
  public double period() {
    return ElasticOutCurveObjSt.period(st);
  }
  @Override
  public ElasticOutCurve build() {
    return this;
  }
}
