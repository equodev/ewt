package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExpandedObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Expanded extends Flexible implements ExpandedI {
  private MemorySegment st;
  protected Expanded() {}
  Expanded(MemorySegment st) {
    this.id = ExpandedObjSt.id(st);
    this.st = st;
    System.out.println("New Expanded id:"+id);
  }
  @Builder.Factory
  static Expanded expandedExpanded(OptionalInt flex, WidgetI child) {
    var st = factories.expandedExpanded(flex,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Expanded");
    return new Expanded(st);
  }
  public static ExpandedExpandedBuilder expanded() {
    return ExpandedExpandedBuilder.expandedExpanded();
  }
  @Override
  public Expanded build() {
    return this;
  }
}
