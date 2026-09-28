package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverMainAxisGroup extends MultiChildRenderObjectWidget implements SliverMainAxisGroupI {
  protected SliverMainAxisGroup() {}
  SliverMainAxisGroup(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverMainAxisGroup");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverMainAxisGroup sliverMainAxisGroupSliverMainAxisGroup(@Builder.Parameter List<WidgetI> slivers) {
    int id = factories.sliverMainAxisGroupSliverMainAxisGroup(slivers.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverMainAxisGroup");
    return new SliverMainAxisGroup(id);
  }
  public static SliverMainAxisGroupSliverMainAxisGroupBuilder sliverMainAxisGroup(List<WidgetI> slivers) {
    return SliverMainAxisGroupSliverMainAxisGroupBuilder.sliverMainAxisGroupSliverMainAxisGroup(slivers);
  }
  @Override
  public SliverMainAxisGroup build() {
    return this;
  }
}
