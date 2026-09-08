package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverPrototypeExtentListObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverPrototypeExtentList extends SliverMultiBoxAdaptorWidget implements SliverPrototypeExtentListI {
  private MemorySegment st;
  protected SliverPrototypeExtentList() {}
  SliverPrototypeExtentList(MemorySegment st) {
    this.id = SliverPrototypeExtentListObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverPrototypeExtentList");
    System.out.println("New SliverPrototypeExtentList id:"+id);
  }
  SliverPrototypeExtentList(int id) { this.id = id; }
  @Builder.Factory
  static SliverPrototypeExtentList sliverPrototypeExtentListBuilder(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, @Builder.Parameter WidgetI prototypeItem, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    var st = factories.sliverPrototypeExtentListBuilder(itemBuilder,
      prototypeItem.build(),
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (st == null) throw new RuntimeException("Failed to created widget SliverPrototypeExtentList");
    return new SliverPrototypeExtentList(st);
  }
  public static SliverPrototypeExtentListBuilderBuilder builder(BiFunction<BuildContext, Integer, Widget> itemBuilder, WidgetI prototypeItem) {
    return SliverPrototypeExtentListBuilderBuilder.sliverPrototypeExtentListBuilder(itemBuilder, prototypeItem);
  }
  @Builder.Factory
  static SliverPrototypeExtentList sliverPrototypeExtentListList(@Builder.Parameter List<WidgetI> children, @Builder.Parameter WidgetI prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    var st = factories.sliverPrototypeExtentListList(children.stream().map(WidgetI::build).toList(),
      prototypeItem.build(),
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (st == null) throw new RuntimeException("Failed to created widget SliverPrototypeExtentList");
    return new SliverPrototypeExtentList(st);
  }
  public static SliverPrototypeExtentListListBuilder list(List<WidgetI> children, WidgetI prototypeItem) {
    return SliverPrototypeExtentListListBuilder.sliverPrototypeExtentListList(children, prototypeItem);
  }
  public Widget prototypeItem() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverPrototypeExtentListPrototypeItem not supported on web");
    return new Widget(SliverPrototypeExtentListObjSt.prototypeItem(st)) {};
  }
  @Override
  public SliverPrototypeExtentList build() {
    return this;
  }
}
