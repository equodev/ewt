package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Flex extends MultiChildRenderObjectWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Flex() {}
  Flex(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Flex flexFlex(@Builder.Parameter Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    int id = factories.flexFlex(direction,
      mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      clipBehavior,
      spacing,
      children);
    if (id == -1) throw new RuntimeException("Failed to created widget Flex");
    System.out.println("New Flex id:"+id);
    return new Flex(id);
  }
  public static FlexFlexBuilder flex(Axis direction) {
    return FlexFlexBuilder.flexFlex(direction);
  }
}
