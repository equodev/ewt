package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverPadding extends SingleChildRenderObjectWidget implements SliverPaddingI {
  protected SliverPadding() {}
  SliverPadding(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverPadding");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverPadding sliverPaddingSliverPadding(@Builder.Parameter EdgeInsetsGeometryI padding, Optional<WidgetI> sliver) {
    int id = factories.sliverPaddingSliverPadding(padding.build(),
      sliver.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverPadding");
    return new SliverPadding(id);
  }
  public static SliverPaddingSliverPaddingBuilder sliverPadding(EdgeInsetsGeometryI padding) {
    return SliverPaddingSliverPaddingBuilder.sliverPaddingSliverPadding(padding);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverPaddingPadding not supported on web");
    return factories.SliverPadding_readBack_padding(nativeStruct);
  }
  @Override
  public SliverPadding build() {
    return this;
  }
}
