package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BaselineObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Baseline extends SingleChildRenderObjectWidget implements BaselineI {
  private MemorySegment st;
  protected Baseline() {}
  Baseline(MemorySegment st) {
    this.id = BaselineObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Baseline");
    System.out.println("New Baseline id:"+id);
  }
  @Builder.Factory
  static Baseline baselineBaseline(@Builder.Parameter double baseline, @Builder.Parameter TextBaseline baselineType, Optional<WidgetI> child) {
    var st = factories.baselineBaseline(baseline,
      baselineType,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Baseline");
    return new Baseline(st);
  }
  public static BaselineBaselineBuilder baseline(double baseline, TextBaseline baselineType) {
    return BaselineBaselineBuilder.baselineBaseline(baseline, baselineType);
  }
  public double baseline() {
    return BaselineObjSt.baseline(st);
  }
  public TextBaseline baselineType() {
    return TextBaseline.values()[BaselineObjSt.baselineType(st)];
  }
  @Override
  public Baseline build() {
    return this;
  }
}
