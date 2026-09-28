package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverCrossAxisGroup extends MultiChildRenderObjectWidget implements SliverCrossAxisGroupI {
  protected SliverCrossAxisGroup() {}
  SliverCrossAxisGroup(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverCrossAxisGroup");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverCrossAxisGroup sliverCrossAxisGroupSliverCrossAxisGroup(@Builder.Parameter List<WidgetI> slivers) {
    int id = factories.sliverCrossAxisGroupSliverCrossAxisGroup(slivers.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverCrossAxisGroup");
    return new SliverCrossAxisGroup(id);
  }
  public static SliverCrossAxisGroupSliverCrossAxisGroupBuilder sliverCrossAxisGroup(List<WidgetI> slivers) {
    return SliverCrossAxisGroupSliverCrossAxisGroupBuilder.sliverCrossAxisGroupSliverCrossAxisGroup(slivers);
  }
  @Override
  public SliverCrossAxisGroup build() {
    return this;
  }
}
