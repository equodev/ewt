package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverPrototypeExtentList extends SliverMultiBoxAdaptorWidget implements SliverPrototypeExtentListI {
  protected SliverPrototypeExtentList() {}
  SliverPrototypeExtentList(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverPrototypeExtentList");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverPrototypeExtentList sliverPrototypeExtentListBuilder(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, @Builder.Parameter WidgetI prototypeItem, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    int id = factories.sliverPrototypeExtentListBuilder(itemBuilder,
      prototypeItem.build(),
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverPrototypeExtentList");
    return new SliverPrototypeExtentList(id);
  }
  public static SliverPrototypeExtentListBuilderBuilder builder(BiFunction<BuildContext, Integer, Widget> itemBuilder, WidgetI prototypeItem) {
    return SliverPrototypeExtentListBuilderBuilder.sliverPrototypeExtentListBuilder(itemBuilder, prototypeItem);
  }
  @Builder.Factory
  static SliverPrototypeExtentList sliverPrototypeExtentListList(@Builder.Parameter List<WidgetI> children, @Builder.Parameter WidgetI prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    int id = factories.sliverPrototypeExtentListList(children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      prototypeItem.build(),
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverPrototypeExtentList");
    return new SliverPrototypeExtentList(id);
  }
  public static SliverPrototypeExtentListListBuilder list(List<WidgetI> children, WidgetI prototypeItem) {
    return SliverPrototypeExtentListListBuilder.sliverPrototypeExtentListList(children, prototypeItem);
  }
  public Widget prototypeItem() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverPrototypeExtentListPrototypeItem not supported on web");
    return factories.SliverPrototypeExtentList_readBack_prototypeItem(nativeStruct);
  }
  @Override
  public SliverPrototypeExtentList build() {
    return this;
  }
}
