package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Row extends Flex implements RowI {
  protected Row() {}
  Row(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Row");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Row rowRow(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<WidgetI>> children) {
    int id = factories.rowRow(mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      spacing,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget Row");
    return new Row(id);
  }
  public static RowRowBuilder row() {
    return RowRowBuilder.rowRow();
  }
  @Override
  public Row build() {
    return this;
  }
}
