package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverCrossAxisGroupObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverCrossAxisGroup extends MultiChildRenderObjectWidget implements SliverCrossAxisGroupI {
  private MemorySegment st;
  protected SliverCrossAxisGroup() {}
  SliverCrossAxisGroup(MemorySegment st) {
    this.id = SliverCrossAxisGroupObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverCrossAxisGroup");
    System.out.println("New SliverCrossAxisGroup id:"+id);
  }
  SliverCrossAxisGroup(int id) { this.id = id; }
  @Builder.Factory
  static SliverCrossAxisGroup sliverCrossAxisGroupSliverCrossAxisGroup(@Builder.Parameter List<WidgetI> slivers) {
    var st = factories.sliverCrossAxisGroupSliverCrossAxisGroup(slivers.stream().map(WidgetI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget SliverCrossAxisGroup");
    return new SliverCrossAxisGroup(st);
  }
  public static SliverCrossAxisGroupSliverCrossAxisGroupBuilder sliverCrossAxisGroup(List<WidgetI> slivers) {
    return SliverCrossAxisGroupSliverCrossAxisGroupBuilder.sliverCrossAxisGroupSliverCrossAxisGroup(slivers);
  }
  @Override
  public SliverCrossAxisGroup build() {
    return this;
  }
}
