package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverToBoxAdapter extends SingleChildRenderObjectWidget implements SliverToBoxAdapterI {
  protected SliverToBoxAdapter() {}
  SliverToBoxAdapter(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverToBoxAdapter");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverToBoxAdapter sliverToBoxAdapterSliverToBoxAdapter(Optional<WidgetI> child) {
    int id = factories.sliverToBoxAdapterSliverToBoxAdapter(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverToBoxAdapter");
    return new SliverToBoxAdapter(id);
  }
  public static SliverToBoxAdapterSliverToBoxAdapterBuilder sliverToBoxAdapter() {
    return SliverToBoxAdapterSliverToBoxAdapterBuilder.sliverToBoxAdapterSliverToBoxAdapter();
  }
  @Override
  public SliverToBoxAdapter build() {
    return this;
  }
}
