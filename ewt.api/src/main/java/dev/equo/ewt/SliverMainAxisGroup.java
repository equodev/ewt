package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverMainAxisGroupObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverMainAxisGroup extends MultiChildRenderObjectWidget implements SliverMainAxisGroupI {
  private MemorySegment st;
  protected SliverMainAxisGroup() {}
  SliverMainAxisGroup(MemorySegment st) {
    this.id = SliverMainAxisGroupObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverMainAxisGroup");
    System.out.println("New SliverMainAxisGroup id:"+id);
  }
  SliverMainAxisGroup(int id) { this.id = id; }
  @Builder.Factory
  static SliverMainAxisGroup sliverMainAxisGroupSliverMainAxisGroup(@Builder.Parameter List<WidgetI> slivers) {
    var st = factories.sliverMainAxisGroupSliverMainAxisGroup(slivers.stream().map(WidgetI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget SliverMainAxisGroup");
    return new SliverMainAxisGroup(st);
  }
  public static SliverMainAxisGroupSliverMainAxisGroupBuilder sliverMainAxisGroup(List<WidgetI> slivers) {
    return SliverMainAxisGroupSliverMainAxisGroupBuilder.sliverMainAxisGroupSliverMainAxisGroup(slivers);
  }
  @Override
  public SliverMainAxisGroup build() {
    return this;
  }
}
