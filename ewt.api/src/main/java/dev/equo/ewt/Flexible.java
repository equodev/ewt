package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FlexibleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Flexible extends ParentDataWidget<FlexParentData> implements FlexibleI {
  private MemorySegment st;
  protected Flexible() {}
  Flexible(MemorySegment st) {
    this.id = FlexibleObjSt.id(st);
    this.st = st;
    System.out.println("New Flexible id:"+id);
  }
  @Builder.Factory
  static Flexible flexibleFlexible(OptionalInt flex, Optional<FlexFit> fit, WidgetI child) {
    var st = factories.flexibleFlexible(flex,
      fit,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Flexible");
    return new Flexible(st);
  }
  public static FlexibleFlexibleBuilder flexible() {
    return FlexibleFlexibleBuilder.flexibleFlexible();
  }
  public int flex() {
    return FlexibleObjSt.flex(st);
  }
  public FlexFit fit() {
    return FlexFit.values()[FlexibleObjSt.fit(st)];
  }
  @Override
  public Flexible build() {
    return this;
  }
}
