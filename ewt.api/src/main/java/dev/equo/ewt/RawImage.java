package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RawImage extends LeafRenderObjectWidget implements RawImageI {
  protected RawImage() {}
  RawImage(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawImage");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RawImage rawImageRawImage(Optional<String> debugImageLabel, OptionalDouble width, OptionalDouble height, OptionalDouble scale, Optional<ColorI> color, Optional<AnimationI> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> invertColors, Optional<FilterQuality> filterQuality, Optional<Boolean> isAntiAlias) {
    int id = factories.rawImageRawImage(debugImageLabel,
      width,
      height,
      scale,
      color.map(ColorI::build),
      opacity.map(AnimationI::build),
      colorBlendMode,
      fit,
      alignment.map(AlignmentGeometryI::build),
      repeat,
      matchTextDirection,
      invertColors,
      filterQuality,
      isAntiAlias);
    if (id <= 0) throw new RuntimeException("Failed to created widget RawImage");
    return new RawImage(id);
  }
  public static RawImageRawImageBuilder rawImage() {
    return RawImageRawImageBuilder.rawImageRawImage();
  }
  public String debugImageLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageDebugImageLabel not supported on web");
    return factories.RawImage_readBack_debugImageLabel(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageWidth not supported on web");
    return factories.RawImage_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageHeight not supported on web");
    return factories.RawImage_readBack_height(nativeStruct);
  }
  public double scale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageScale not supported on web");
    return factories.RawImage_readBack_scale(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawImageColor", getId());
      return new Color(__nid);
    }
    return factories.RawImage_readBack_color(nativeStruct);
  }
  public Animation opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageOpacity not supported on web");
    return factories.RawImage_readBack_opacity(nativeStruct);
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageFilterQuality not supported on web");
    return factories.RawImage_readBack_filterQuality(nativeStruct);
  }
  public BlendMode colorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageColorBlendMode not supported on web");
    return factories.RawImage_readBack_colorBlendMode(nativeStruct);
  }
  public BoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageFit not supported on web");
    return factories.RawImage_readBack_fit(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageAlignment not supported on web");
    return factories.RawImage_readBack_alignment(nativeStruct);
  }
  public ImageRepeat repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageRepeat not supported on web");
    return factories.RawImage_readBack_repeat(nativeStruct);
  }
  public boolean matchTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageMatchTextDirection not supported on web");
    return factories.RawImage_readBack_matchTextDirection(nativeStruct);
  }
  public boolean invertColors() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageInvertColors not supported on web");
    return factories.RawImage_readBack_invertColors(nativeStruct);
  }
  public boolean isAntiAlias() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageIsAntiAlias not supported on web");
    return factories.RawImage_readBack_isAntiAlias(nativeStruct);
  }
  @Override
  public RawImage build() {
    return this;
  }
}
