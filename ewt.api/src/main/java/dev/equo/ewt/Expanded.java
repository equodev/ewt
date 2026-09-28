package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Expanded extends Flexible implements ExpandedI {
  protected Expanded() {}
  Expanded(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Expanded");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Expanded expandedExpanded(OptionalInt flex, WidgetI child) {
    int id = factories.expandedExpanded(flex,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Expanded");
    return new Expanded(id);
  }
  public static ExpandedExpandedBuilder expanded() {
    return ExpandedExpandedBuilder.expandedExpanded();
  }
  @Override
  public Expanded build() {
    return this;
  }
}
