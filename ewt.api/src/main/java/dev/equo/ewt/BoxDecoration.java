package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BoxDecoration extends Decoration implements BoxDecorationI {
  protected BoxDecoration() {}
  BoxDecoration(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxDecoration");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BoxDecoration boxDecorationBoxDecoration(Optional<ColorI> color, Optional<BoxBorderI> border, Optional<BorderRadiusGeometryI> borderRadius, Optional<List<BoxShadowI>> boxShadow, Optional<BlendMode> backgroundBlendMode, Optional<BoxShape> shape) {
    int id = factories.boxDecorationBoxDecoration(color.map(ColorI::build),
      border.map(BoxBorderI::build),
      borderRadius.map(BorderRadiusGeometryI::build),
      boxShadow.map(i -> i.stream().map(BoxShadowI::build).collect(java.util.stream.Collectors.toList())),
      backgroundBlendMode,
      shape);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxDecoration");
    return new BoxDecoration(id);
  }
  public static BoxDecorationBoxDecorationBuilder boxDecoration() {
    return BoxDecorationBoxDecorationBuilder.boxDecorationBoxDecoration();
  }
  public static BoxDecoration lerp(BoxDecorationI a, BoxDecorationI b, double t) {
    int id = factories.boxDecorationLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxDecoration");
    return new BoxDecoration(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("boxDecorationColor", getId());
      return new Color(__nid);
    }
    return factories.BoxDecoration_readBack_color(nativeStruct);
  }
  public BoxBorder border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationBorder not supported on web");
    return factories.BoxDecoration_readBack_border(nativeStruct);
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationBorderRadius not supported on web");
    return factories.BoxDecoration_readBack_borderRadius(nativeStruct);
  }
  public BlendMode backgroundBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationBackgroundBlendMode not supported on web");
    return factories.BoxDecoration_readBack_backgroundBlendMode(nativeStruct);
  }
  public BoxShape shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationShape not supported on web");
    return factories.BoxDecoration_readBack_shape(nativeStruct);
  }
  @Override
  public BoxDecoration build() {
    return this;
  }
}
