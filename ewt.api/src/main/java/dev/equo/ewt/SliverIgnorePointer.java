package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverIgnorePointer extends SingleChildRenderObjectWidget implements SliverIgnorePointerI {
  protected SliverIgnorePointer() {}
  SliverIgnorePointer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverIgnorePointer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverIgnorePointer sliverIgnorePointerSliverIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<WidgetI> sliver) {
    int id = factories.sliverIgnorePointerSliverIgnorePointer(ignoring,
      ignoringSemantics,
      sliver.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverIgnorePointer");
    return new SliverIgnorePointer(id);
  }
  public static SliverIgnorePointerSliverIgnorePointerBuilder sliverIgnorePointer() {
    return SliverIgnorePointerSliverIgnorePointerBuilder.sliverIgnorePointerSliverIgnorePointer();
  }
  public boolean ignoring() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverIgnorePointerIgnoring not supported on web");
    return factories.SliverIgnorePointer_readBack_ignoring(nativeStruct);
  }
  public boolean ignoringSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverIgnorePointerIgnoringSemantics not supported on web");
    return factories.SliverIgnorePointer_readBack_ignoringSemantics(nativeStruct);
  }
  @Override
  public SliverIgnorePointer build() {
    return this;
  }
}
