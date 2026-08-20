package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IgnoreBaselineObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IgnoreBaseline extends SingleChildRenderObjectWidget implements IgnoreBaselineI {
  private MemorySegment st;
  protected IgnoreBaseline() {}
  IgnoreBaseline(MemorySegment st) {
    this.id = IgnoreBaselineObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IgnoreBaseline");
    System.out.println("New IgnoreBaseline id:"+id);
  }
  IgnoreBaseline(int id) { this.id = id; }
  @Builder.Factory
  static IgnoreBaseline ignoreBaselineIgnoreBaseline(Optional<WidgetI> child) {
    var st = factories.ignoreBaselineIgnoreBaseline(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget IgnoreBaseline");
    return new IgnoreBaseline(st);
  }
  public static IgnoreBaselineIgnoreBaselineBuilder ignoreBaseline() {
    return IgnoreBaselineIgnoreBaselineBuilder.ignoreBaselineIgnoreBaseline();
  }
  @Override
  public IgnoreBaseline build() {
    return this;
  }
}
