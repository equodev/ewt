package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverList extends SliverMultiBoxAdaptorWidget implements SliverListI {
  protected SliverList() {}
  SliverList(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverList");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverList sliverListBuilder(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalInt semanticIndexOffset) {
    int id = factories.sliverListBuilder(itemBuilder,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      semanticIndexOffset);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverList");
    return new SliverList(id);
  }
  public static SliverListBuilderBuilder builder(BiFunction<BuildContext, Integer, Widget> itemBuilder) {
    return SliverListBuilderBuilder.sliverListBuilder(itemBuilder);
  }
  @Builder.Factory
  static SliverList sliverListSeparated(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, @Builder.Parameter BiFunction<BuildContext, Integer, Widget> separatorBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    int id = factories.sliverListSeparated(itemBuilder,
      separatorBuilder,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverList");
    return new SliverList(id);
  }
  public static SliverListSeparatedBuilder separated(BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder) {
    return SliverListSeparatedBuilder.sliverListSeparated(itemBuilder, separatorBuilder);
  }
  @Builder.Factory
  static SliverList sliverListList(@Builder.Parameter List<WidgetI> children, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    int id = factories.sliverListList(children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverList");
    return new SliverList(id);
  }
  public static SliverListListBuilder list(List<WidgetI> children) {
    return SliverListListBuilder.sliverListList(children);
  }
  @Override
  public SliverList build() {
    return this;
  }
}
