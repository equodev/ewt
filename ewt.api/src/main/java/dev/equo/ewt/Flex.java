package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Flex extends MultiChildRenderObjectWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Flex() {}
  @Builder.Constructor
  Flex(@Builder.Parameter Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    id = factories.flexFlex(direction, mainAxisAlignment, mainAxisSize, crossAxisAlignment, textDirection, verticalDirection, textBaseline, clipBehavior, spacing, children);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static FlexBuilder flex(Axis direction) {
    return FlexBuilder.Flex(direction);
  }
}
