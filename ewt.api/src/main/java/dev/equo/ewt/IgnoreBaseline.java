package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IgnoreBaseline extends SingleChildRenderObjectWidget implements IgnoreBaselineI {
  protected IgnoreBaseline() {}
  IgnoreBaseline(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IgnoreBaseline");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IgnoreBaseline ignoreBaselineIgnoreBaseline(Optional<WidgetI> child) {
    int id = factories.ignoreBaselineIgnoreBaseline(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget IgnoreBaseline");
    return new IgnoreBaseline(id);
  }
  public static IgnoreBaselineIgnoreBaselineBuilder ignoreBaseline() {
    return IgnoreBaselineIgnoreBaselineBuilder.ignoreBaselineIgnoreBaseline();
  }
  @Override
  public IgnoreBaseline build() {
    return this;
  }
}
