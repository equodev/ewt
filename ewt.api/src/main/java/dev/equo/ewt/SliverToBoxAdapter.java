package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverToBoxAdapterObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverToBoxAdapter extends SingleChildRenderObjectWidget implements SliverToBoxAdapterI {
  private MemorySegment st;
  protected SliverToBoxAdapter() {}
  SliverToBoxAdapter(MemorySegment st) {
    this.id = SliverToBoxAdapterObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverToBoxAdapter");
    System.out.println("New SliverToBoxAdapter id:"+id);
  }
  SliverToBoxAdapter(int id) { this.id = id; }
  @Builder.Factory
  static SliverToBoxAdapter sliverToBoxAdapterSliverToBoxAdapter(Optional<WidgetI> child) {
    var st = factories.sliverToBoxAdapterSliverToBoxAdapter(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SliverToBoxAdapter");
    return new SliverToBoxAdapter(st);
  }
  public static SliverToBoxAdapterSliverToBoxAdapterBuilder sliverToBoxAdapter() {
    return SliverToBoxAdapterSliverToBoxAdapterBuilder.sliverToBoxAdapterSliverToBoxAdapter();
  }
  @Override
  public SliverToBoxAdapter build() {
    return this;
  }
}
