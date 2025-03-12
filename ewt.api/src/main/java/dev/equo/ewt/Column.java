package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Column extends Flex {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Column() {}
  Column(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Column columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    int id = factories.columnColumn(mainAxisAlignment, mainAxisSize, crossAxisAlignment, textDirection, verticalDirection, textBaseline, spacing, children);
    if (id == -1) throw new RuntimeException("Failed to created widget Column");
    System.out.println("New Column id:"+id);
    return new Column(id);
  }
  public static ColumnColumnBuilder column() {
    return ColumnColumnBuilder.columnColumn();
  }
}
