package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Ink extends StatefulWidget implements InkI {
  protected Ink() {}
  Ink(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Ink");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Ink inkInk(Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<DecorationI> decoration, OptionalDouble width, OptionalDouble height, Optional<WidgetI> child) {
    int id = factories.inkInk(padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      decoration.map(DecorationI::build),
      width,
      height,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Ink");
    return new Ink(id);
  }
  public static InkInkBuilder ink() {
    return InkInkBuilder.inkInk();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkChild not supported on web");
    return factories.Ink_readBack_child(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkPadding not supported on web");
    return factories.Ink_readBack_padding(nativeStruct);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkDecoration not supported on web");
    return factories.Ink_readBack_decoration(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkWidth not supported on web");
    return factories.Ink_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkHeight not supported on web");
    return factories.Ink_readBack_height(nativeStruct);
  }
  @Override
  public Ink build() {
    return this;
  }
}
