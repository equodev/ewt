package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ColumnObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Column extends Flex implements ColumnI {
  private MemorySegment st;
  protected Column() {}
  Column(MemorySegment st) {
    this.id = ColumnObjSt.id(st);
    this.st = st;
    System.out.println("New Column id:"+id);
  }
  @Builder.Factory
  static Column columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<WidgetI>> children) {
    var st = factories.columnColumn(mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      spacing,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget Column");
    return new Column(st);
  }
  public static ColumnColumnBuilder column() {
    return ColumnColumnBuilder.columnColumn();
  }
  @Override
  public Column build() {
    return this;
  }
}
