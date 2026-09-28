package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverGrid extends SliverMultiBoxAdaptorWidget implements SliverGridI {
  protected SliverGrid() {}
  SliverGrid(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverGrid");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverGrid sliverGridCount(@Builder.Parameter int crossAxisCount, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<List<WidgetI>> children) {
    int id = factories.sliverGridCount(crossAxisCount,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverGrid");
    return new SliverGrid(id);
  }
  public static SliverGridCountBuilder count(int crossAxisCount) {
    return SliverGridCountBuilder.sliverGridCount(crossAxisCount);
  }
  @Builder.Factory
  static SliverGrid sliverGridExtent(@Builder.Parameter double maxCrossAxisExtent, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<List<WidgetI>> children) {
    int id = factories.sliverGridExtent(maxCrossAxisExtent,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverGrid");
    return new SliverGrid(id);
  }
  public static SliverGridExtentBuilder extent(double maxCrossAxisExtent) {
    return SliverGridExtentBuilder.sliverGridExtent(maxCrossAxisExtent);
  }
  @Override
  public SliverGrid build() {
    return this;
  }
}
