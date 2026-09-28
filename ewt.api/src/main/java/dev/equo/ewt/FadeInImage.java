package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FadeInImage extends StatefulWidget implements FadeInImageI {
  protected FadeInImage() {}
  FadeInImage(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FadeInImage");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FadeInImage fadeInImageAssetNetwork(@Builder.Parameter String placeholder, @Builder.Parameter String image, OptionalDouble placeholderScale, OptionalDouble imageScale, Optional<Boolean> excludeFromSemantics, Optional<String> imageSemanticLabel, Optional<DurationI> fadeOutDuration, Optional<CurveI> fadeOutCurve, Optional<DurationI> fadeInDuration, Optional<CurveI> fadeInCurve, OptionalDouble width, OptionalDouble height, Optional<BoxFit> fit, Optional<ColorI> color, Optional<BlendMode> colorBlendMode, Optional<ColorI> placeholderColor, Optional<BlendMode> placeholderColorBlendMode, Optional<BoxFit> placeholderFit, Optional<FilterQuality> filterQuality, Optional<FilterQuality> placeholderFilterQuality, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, OptionalInt placeholderCacheWidth, OptionalInt placeholderCacheHeight, OptionalInt imageCacheWidth, OptionalInt imageCacheHeight) {
    int id = factories.fadeInImageAssetNetwork(placeholder,
      image,
      placeholderScale,
      imageScale,
      excludeFromSemantics,
      imageSemanticLabel,
      fadeOutDuration.map(DurationI::build),
      fadeOutCurve.map(CurveI::build),
      fadeInDuration.map(DurationI::build),
      fadeInCurve.map(CurveI::build),
      width,
      height,
      fit,
      color.map(ColorI::build),
      colorBlendMode,
      placeholderColor.map(ColorI::build),
      placeholderColorBlendMode,
      placeholderFit,
      filterQuality,
      placeholderFilterQuality,
      alignment.map(AlignmentGeometryI::build),
      repeat,
      matchTextDirection,
      placeholderCacheWidth,
      placeholderCacheHeight,
      imageCacheWidth,
      imageCacheHeight);
    if (id <= 0) throw new RuntimeException("Failed to created widget FadeInImage");
    return new FadeInImage(id);
  }
  public static FadeInImageAssetNetworkBuilder assetNetwork(String placeholder, String image) {
    return FadeInImageAssetNetworkBuilder.fadeInImageAssetNetwork(placeholder, image);
  }
  public Duration fadeOutDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fadeInImageFadeOutDuration", getId());
      return new Duration(__nid);
    }
    return factories.FadeInImage_readBack_fadeOutDuration(nativeStruct);
  }
  public Curve fadeOutCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFadeOutCurve not supported on web");
    return factories.FadeInImage_readBack_fadeOutCurve(nativeStruct);
  }
  public Duration fadeInDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fadeInImageFadeInDuration", getId());
      return new Duration(__nid);
    }
    return factories.FadeInImage_readBack_fadeInDuration(nativeStruct);
  }
  public Curve fadeInCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFadeInCurve not supported on web");
    return factories.FadeInImage_readBack_fadeInCurve(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageWidth not supported on web");
    return factories.FadeInImage_readBack_width(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fadeInImageColor", getId());
      return new Color(__nid);
    }
    return factories.FadeInImage_readBack_color(nativeStruct);
  }
  public BlendMode colorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageColorBlendMode not supported on web");
    return factories.FadeInImage_readBack_colorBlendMode(nativeStruct);
  }
  public Color placeholderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fadeInImagePlaceholderColor", getId());
      return new Color(__nid);
    }
    return factories.FadeInImage_readBack_placeholderColor(nativeStruct);
  }
  public BlendMode placeholderColorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImagePlaceholderColorBlendMode not supported on web");
    return factories.FadeInImage_readBack_placeholderColorBlendMode(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageHeight not supported on web");
    return factories.FadeInImage_readBack_height(nativeStruct);
  }
  public BoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFit not supported on web");
    return factories.FadeInImage_readBack_fit(nativeStruct);
  }
  public BoxFit placeholderFit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImagePlaceholderFit not supported on web");
    return factories.FadeInImage_readBack_placeholderFit(nativeStruct);
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFilterQuality not supported on web");
    return factories.FadeInImage_readBack_filterQuality(nativeStruct);
  }
  public FilterQuality placeholderFilterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImagePlaceholderFilterQuality not supported on web");
    return factories.FadeInImage_readBack_placeholderFilterQuality(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageAlignment not supported on web");
    return factories.FadeInImage_readBack_alignment(nativeStruct);
  }
  public ImageRepeat repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageRepeat not supported on web");
    return factories.FadeInImage_readBack_repeat(nativeStruct);
  }
  public boolean matchTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageMatchTextDirection not supported on web");
    return factories.FadeInImage_readBack_matchTextDirection(nativeStruct);
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageExcludeFromSemantics not supported on web");
    return factories.FadeInImage_readBack_excludeFromSemantics(nativeStruct);
  }
  public String imageSemanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageImageSemanticLabel not supported on web");
    return factories.FadeInImage_readBack_imageSemanticLabel(nativeStruct);
  }
  @Override
  public FadeInImage build() {
    return this;
  }
}
