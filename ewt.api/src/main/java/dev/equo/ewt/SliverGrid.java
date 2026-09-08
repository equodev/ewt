package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverGridObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverGrid extends SliverMultiBoxAdaptorWidget implements SliverGridI {
  private MemorySegment st;
  protected SliverGrid() {}
  SliverGrid(MemorySegment st) {
    this.id = SliverGridObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverGrid");
    System.out.println("New SliverGrid id:"+id);
  }
  SliverGrid(int id) { this.id = id; }
  @Builder.Factory
  static SliverGrid sliverGridCount(@Builder.Parameter int crossAxisCount, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<List<WidgetI>> children) {
    var st = factories.sliverGridCount(crossAxisCount,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget SliverGrid");
    return new SliverGrid(st);
  }
  public static SliverGridCountBuilder count(int crossAxisCount) {
    return SliverGridCountBuilder.sliverGridCount(crossAxisCount);
  }
  @Builder.Factory
  static SliverGrid sliverGridExtent(@Builder.Parameter double maxCrossAxisExtent, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<List<WidgetI>> children) {
    var st = factories.sliverGridExtent(maxCrossAxisExtent,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget SliverGrid");
    return new SliverGrid(st);
  }
  public static SliverGridExtentBuilder extent(double maxCrossAxisExtent) {
    return SliverGridExtentBuilder.sliverGridExtent(maxCrossAxisExtent);
  }
  @Override
  public SliverGrid build() {
    return this;
  }
}
