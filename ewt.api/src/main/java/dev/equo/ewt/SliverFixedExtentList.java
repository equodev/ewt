package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverFixedExtentListObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverFixedExtentList extends SliverMultiBoxAdaptorWidget implements SliverFixedExtentListI {
  private MemorySegment st;
  protected SliverFixedExtentList() {}
  SliverFixedExtentList(MemorySegment st) {
    this.id = SliverFixedExtentListObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFixedExtentList");
    System.out.println("New SliverFixedExtentList id:"+id);
  }
  SliverFixedExtentList(int id) { this.id = id; }
  @Builder.Factory
  static SliverFixedExtentList sliverFixedExtentListBuilder(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, @Builder.Parameter double itemExtent, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    var st = factories.sliverFixedExtentListBuilder(itemBuilder,
      itemExtent,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (st == null) throw new RuntimeException("Failed to created widget SliverFixedExtentList");
    return new SliverFixedExtentList(st);
  }
  public static SliverFixedExtentListBuilderBuilder builder(BiFunction<BuildContext, Integer, Widget> itemBuilder, double itemExtent) {
    return SliverFixedExtentListBuilderBuilder.sliverFixedExtentListBuilder(itemBuilder, itemExtent);
  }
  @Builder.Factory
  static SliverFixedExtentList sliverFixedExtentListList(@Builder.Parameter List<WidgetI> children, @Builder.Parameter double itemExtent, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    var st = factories.sliverFixedExtentListList(children.stream().map(WidgetI::build).toList(),
      itemExtent,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (st == null) throw new RuntimeException("Failed to created widget SliverFixedExtentList");
    return new SliverFixedExtentList(st);
  }
  public static SliverFixedExtentListListBuilder list(List<WidgetI> children, double itemExtent) {
    return SliverFixedExtentListListBuilder.sliverFixedExtentListList(children, itemExtent);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFixedExtentListItemExtent not supported on web");
    return SliverFixedExtentListObjSt.itemExtent(st);
  }
  @Override
  public SliverFixedExtentList build() {
    return this;
  }
}
