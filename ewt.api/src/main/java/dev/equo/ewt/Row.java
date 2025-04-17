package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RowObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Row extends Flex implements RowI {
  private MemorySegment st;
  protected Row() {}
  Row(MemorySegment st) {
    this.id = RowObjSt.id(st);
    this.st = st;
    System.out.println("New Row id:"+id);
  }
  @Builder.Factory
  static Row rowRow(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<WidgetI>> children) {
    var st = factories.rowRow(mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      spacing,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget Row");
    return new Row(st);
  }
  public static RowRowBuilder row() {
    return RowRowBuilder.rowRow();
  }
  @Override
  public Row build() {
    return this;
  }
}
