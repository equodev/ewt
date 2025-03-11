package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Column extends Widget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  @Builder.Constructor
  Column(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    id = factories.columnOf(mainAxisAlignment, mainAxisSize, crossAxisAlignment, textDirection, verticalDirection, textBaseline, spacing, children);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static ColumnBuilder of() {
    return ColumnBuilder.Column();
  }
}
