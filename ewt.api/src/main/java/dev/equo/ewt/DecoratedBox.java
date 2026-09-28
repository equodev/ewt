package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DecoratedBox extends SingleChildRenderObjectWidget implements DecoratedBoxI {
  protected DecoratedBox() {}
  DecoratedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DecoratedBox decoratedBoxDecoratedBox(@Builder.Parameter DecorationI decoration, Optional<DecorationPosition> position, Optional<WidgetI> child) {
    int id = factories.decoratedBoxDecoratedBox(decoration.build(),
      position,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedBox");
    return new DecoratedBox(id);
  }
  public static DecoratedBoxDecoratedBoxBuilder decoratedBox(DecorationI decoration) {
    return DecoratedBoxDecoratedBoxBuilder.decoratedBoxDecoratedBox(decoration);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxDecoration not supported on web");
    return factories.DecoratedBox_readBack_decoration(nativeStruct);
  }
  public DecorationPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedBoxPosition not supported on web");
    return factories.DecoratedBox_readBack_position(nativeStruct);
  }
  @Override
  public DecoratedBox build() {
    return this;
  }
}
