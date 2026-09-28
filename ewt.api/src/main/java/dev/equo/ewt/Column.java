package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Column extends Flex implements ColumnI {
  protected Column() {}
  Column(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Column");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Column columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<WidgetI>> children) {
    int id = factories.columnColumn(mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      spacing,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget Column");
    return new Column(id);
  }
  public static ColumnColumnBuilder column() {
    return ColumnColumnBuilder.columnColumn();
  }
  @Override
  public Column build() {
    return this;
  }
}
