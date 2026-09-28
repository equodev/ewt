package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Padding extends SingleChildRenderObjectWidget implements PaddingI {
  protected Padding() {}
  Padding(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Padding");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Padding paddingPadding(@Builder.Parameter EdgeInsetsGeometryI padding, Optional<WidgetI> child) {
    int id = factories.paddingPadding(padding.build(),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Padding");
    return new Padding(id);
  }
  public static PaddingPaddingBuilder padding(EdgeInsetsGeometryI padding) {
    return PaddingPaddingBuilder.paddingPadding(padding);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("paddingPadding not supported on web");
    return factories.Padding_readBack_padding(nativeStruct);
  }
  @Override
  public Padding build() {
    return this;
  }
}
