package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverConstrainedCrossAxis extends StatelessWidget implements SliverConstrainedCrossAxisI {
  protected SliverConstrainedCrossAxis() {}
  SliverConstrainedCrossAxis(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverConstrainedCrossAxis");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverConstrainedCrossAxis sliverConstrainedCrossAxisSliverConstrainedCrossAxis(@Builder.Parameter double maxExtent, @Builder.Parameter WidgetI sliver) {
    int id = factories.sliverConstrainedCrossAxisSliverConstrainedCrossAxis(maxExtent,
      sliver.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverConstrainedCrossAxis");
    return new SliverConstrainedCrossAxis(id);
  }
  public static SliverConstrainedCrossAxisSliverConstrainedCrossAxisBuilder sliverConstrainedCrossAxis(double maxExtent, WidgetI sliver) {
    return SliverConstrainedCrossAxisSliverConstrainedCrossAxisBuilder.sliverConstrainedCrossAxisSliverConstrainedCrossAxis(maxExtent, sliver);
  }
  public double maxExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverConstrainedCrossAxisMaxExtent not supported on web");
    return factories.SliverConstrainedCrossAxis_readBack_maxExtent(nativeStruct);
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverConstrainedCrossAxisSliver not supported on web");
    return factories.SliverConstrainedCrossAxis_readBack_sliver(nativeStruct);
  }
  @Override
  public SliverConstrainedCrossAxis build() {
    return this;
  }
}
