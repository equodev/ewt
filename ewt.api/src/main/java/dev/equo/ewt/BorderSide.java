package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BorderSide extends NativeObj.Base implements BorderSideI {
  protected BorderSide() {}
  BorderSide(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderSide");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BorderSide borderSideBorderSide(Optional<ColorI> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    int id = factories.borderSideBorderSide(color.map(ColorI::build),
      width,
      style,
      strokeAlign);
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(id);
  }
  public static BorderSideBorderSideBuilder borderSide() {
    return BorderSideBorderSideBuilder.borderSideBorderSide();
  }
  public static BorderSide merge(BorderSideI a, BorderSideI b) {
    int id = factories.borderSideMerge(a.build(),
      b.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(id);
  }
  public static boolean canMerge(BorderSideI a, BorderSideI b) {
    var id = factories.borderSideCanMerge(a.build(),
      b.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    return intToBool(id);
  }
  public static BorderSide lerp(BorderSideI a, BorderSideI b, double t) {
    int id = factories.borderSideLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderSideColor", getId());
      return new Color(__nid);
    }
    return factories.BorderSide_readBack_color(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideWidth not supported on web");
    return factories.BorderSide_readBack_width(nativeStruct);
  }
  public BorderStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStyle not supported on web");
    return factories.BorderSide_readBack_style(nativeStruct);
  }
  public double strokeAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeAlign not supported on web");
    return factories.BorderSide_readBack_strokeAlign(nativeStruct);
  }
  public double strokeInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeInset not supported on web");
    return factories.BorderSide_readBack_strokeInset(nativeStruct);
  }
  public double strokeOutset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeOutset not supported on web");
    return factories.BorderSide_readBack_strokeOutset(nativeStruct);
  }
  public double strokeOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeOffset not supported on web");
    return factories.BorderSide_readBack_strokeOffset(nativeStruct);
  }
  public static BorderSide none() {
    return BorderSide.borderSide().width(0.0).style(BorderStyle.none).build();
  }
  public static double strokeAlignInside() {
    return -1.0;
  }
  public static double strokeAlignCenter() {
    return 0.0;
  }
  public static double strokeAlignOutside() {
    return 1.0;
  }
  @Override
  public BorderSide build() {
    return this;
  }
}
