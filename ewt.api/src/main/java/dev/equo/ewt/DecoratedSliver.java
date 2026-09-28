package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DecoratedSliver extends SingleChildRenderObjectWidget implements DecoratedSliverI {
  protected DecoratedSliver() {}
  DecoratedSliver(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedSliver");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DecoratedSliver decoratedSliverDecoratedSliver(@Builder.Parameter DecorationI decoration, Optional<DecorationPosition> position, Optional<WidgetI> sliver) {
    int id = factories.decoratedSliverDecoratedSliver(decoration.build(),
      position,
      sliver.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedSliver");
    return new DecoratedSliver(id);
  }
  public static DecoratedSliverDecoratedSliverBuilder decoratedSliver(DecorationI decoration) {
    return DecoratedSliverDecoratedSliverBuilder.decoratedSliverDecoratedSliver(decoration);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedSliverDecoration not supported on web");
    return factories.DecoratedSliver_readBack_decoration(nativeStruct);
  }
  public DecorationPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedSliverPosition not supported on web");
    return factories.DecoratedSliver_readBack_position(nativeStruct);
  }
  @Override
  public DecoratedSliver build() {
    return this;
  }
}
