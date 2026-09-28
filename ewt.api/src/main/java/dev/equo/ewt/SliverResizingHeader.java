package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverResizingHeader extends StatelessWidget implements SliverResizingHeaderI {
  protected SliverResizingHeader() {}
  SliverResizingHeader(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverResizingHeader");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverResizingHeader sliverResizingHeaderSliverResizingHeader(Optional<WidgetI> minExtentPrototype, Optional<WidgetI> maxExtentPrototype, Optional<WidgetI> child) {
    int id = factories.sliverResizingHeaderSliverResizingHeader(minExtentPrototype.map(WidgetI::build),
      maxExtentPrototype.map(WidgetI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverResizingHeader");
    return new SliverResizingHeader(id);
  }
  public static SliverResizingHeaderSliverResizingHeaderBuilder sliverResizingHeader() {
    return SliverResizingHeaderSliverResizingHeaderBuilder.sliverResizingHeaderSliverResizingHeader();
  }
  public Widget minExtentPrototype() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverResizingHeaderMinExtentPrototype not supported on web");
    return factories.SliverResizingHeader_readBack_minExtentPrototype(nativeStruct);
  }
  public Widget maxExtentPrototype() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverResizingHeaderMaxExtentPrototype not supported on web");
    return factories.SliverResizingHeader_readBack_maxExtentPrototype(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverResizingHeaderChild not supported on web");
    return factories.SliverResizingHeader_readBack_child(nativeStruct);
  }
  @Override
  public SliverResizingHeader build() {
    return this;
  }
}
