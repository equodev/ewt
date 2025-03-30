package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Flex extends MultiChildRenderObjectWidget implements FlexI {
  @Override
  public Flex build() {
    return this;
  }
  Flex() {}
  Flex(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Flex flexFlex(@Builder.Parameter Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<WidgetI>> children) {
    int id = factories.flexFlex(direction,
      mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      clipBehavior,
      spacing,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (id == -1) throw new RuntimeException("Failed to created widget Flex");
    System.out.println("New Flex id:"+id);
    return new Flex(id);
  }
  public static FlexFlexBuilder flex(Axis direction) {
    return FlexFlexBuilder.flexFlex(direction);
  }
}
