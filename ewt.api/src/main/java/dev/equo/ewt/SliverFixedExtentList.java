package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverFixedExtentList extends SliverMultiBoxAdaptorWidget implements SliverFixedExtentListI {
  protected SliverFixedExtentList() {}
  SliverFixedExtentList(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFixedExtentList");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverFixedExtentList sliverFixedExtentListBuilder(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, @Builder.Parameter double itemExtent, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalInt semanticIndexOffset) {
    int id = factories.sliverFixedExtentListBuilder(itemBuilder,
      itemExtent,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      semanticIndexOffset);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFixedExtentList");
    return new SliverFixedExtentList(id);
  }
  public static SliverFixedExtentListBuilderBuilder builder(BiFunction<BuildContext, Integer, Widget> itemBuilder, double itemExtent) {
    return SliverFixedExtentListBuilderBuilder.sliverFixedExtentListBuilder(itemBuilder, itemExtent);
  }
  @Builder.Factory
  static SliverFixedExtentList sliverFixedExtentListList(@Builder.Parameter List<WidgetI> children, @Builder.Parameter double itemExtent, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    int id = factories.sliverFixedExtentListList(children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      itemExtent,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFixedExtentList");
    return new SliverFixedExtentList(id);
  }
  public static SliverFixedExtentListListBuilder list(List<WidgetI> children, double itemExtent) {
    return SliverFixedExtentListListBuilder.sliverFixedExtentListList(children, itemExtent);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFixedExtentListItemExtent not supported on web");
    return factories.SliverFixedExtentList_readBack_itemExtent(nativeStruct);
  }
  @Override
  public SliverFixedExtentList build() {
    return this;
  }
}
