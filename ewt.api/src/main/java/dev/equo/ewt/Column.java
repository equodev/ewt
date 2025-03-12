package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Column extends Flex {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Column() {}
  @Builder.Constructor
  Column(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    id = factories.columnColumn(mainAxisAlignment, mainAxisSize, crossAxisAlignment, textDirection, verticalDirection, textBaseline, spacing, children);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static ColumnBuilder column() {
    return ColumnBuilder.Column();
  }
}
