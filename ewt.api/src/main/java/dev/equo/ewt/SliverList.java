package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverListObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverList extends SliverMultiBoxAdaptorWidget implements SliverListI {
  private MemorySegment st;
  protected SliverList() {}
  SliverList(MemorySegment st) {
    this.id = SliverListObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverList");
    System.out.println("New SliverList id:"+id);
  }
  SliverList(int id) { this.id = id; }
  @Builder.Factory
  static SliverList sliverListBuilder(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    var st = factories.sliverListBuilder(itemBuilder,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (st == null) throw new RuntimeException("Failed to created widget SliverList");
    return new SliverList(st);
  }
  public static SliverListBuilderBuilder builder(BiFunction<BuildContext, Integer, Widget> itemBuilder) {
    return SliverListBuilderBuilder.sliverListBuilder(itemBuilder);
  }
  @Builder.Factory
  static SliverList sliverListSeparated(@Builder.Parameter BiFunction<BuildContext, Integer, Widget> itemBuilder, @Builder.Parameter BiFunction<BuildContext, Integer, Widget> separatorBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    var st = factories.sliverListSeparated(itemBuilder,
      separatorBuilder,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (st == null) throw new RuntimeException("Failed to created widget SliverList");
    return new SliverList(st);
  }
  public static SliverListSeparatedBuilder separated(BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder) {
    return SliverListSeparatedBuilder.sliverListSeparated(itemBuilder, separatorBuilder);
  }
  @Builder.Factory
  static SliverList sliverListList(@Builder.Parameter List<WidgetI> children, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    var st = factories.sliverListList(children.stream().map(WidgetI::build).toList(),
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes);
    if (st == null) throw new RuntimeException("Failed to created widget SliverList");
    return new SliverList(st);
  }
  public static SliverListListBuilder list(List<WidgetI> children) {
    return SliverListListBuilder.sliverListList(children);
  }
  @Override
  public SliverList build() {
    return this;
  }
}
