package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Image extends StatefulWidget implements ImageI {
  protected Image() {}
  Image(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Image");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Image imageNetwork(@Builder.Parameter String src, OptionalDouble scale, Optional<QuadFunction<BuildContext, Widget, Integer, Boolean, Widget>> frameBuilder, Optional<String> semanticLabel, Optional<Boolean> excludeFromSemantics, OptionalDouble width, OptionalDouble height, Optional<ColorI> color, Optional<AnimationI> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> gaplessPlayback, Optional<FilterQuality> filterQuality, Optional<Boolean> isAntiAlias, OptionalInt cacheWidth, OptionalInt cacheHeight, Optional<WebHtmlElementStrategy> webHtmlElementStrategy) {
    int id = factories.imageNetwork(src,
      scale,
      frameBuilder,
      semanticLabel,
      excludeFromSemantics,
      width,
      height,
      color.map(ColorI::build),
      opacity.map(AnimationI::build),
      colorBlendMode,
      fit,
      alignment.map(AlignmentGeometryI::build),
      repeat,
      matchTextDirection,
      gaplessPlayback,
      filterQuality,
      isAntiAlias,
      cacheWidth,
      cacheHeight,
      webHtmlElementStrategy);
    if (id <= 0) throw new RuntimeException("Failed to created widget Image");
    return new Image(id);
  }
  public static ImageNetworkBuilder network(String src) {
    return ImageNetworkBuilder.imageNetwork(src);
  }
  @Builder.Factory
  static Image imageAsset(@Builder.Parameter String name, Optional<QuadFunction<BuildContext, Widget, Integer, Boolean, Widget>> frameBuilder, Optional<String> semanticLabel, Optional<Boolean> excludeFromSemantics, OptionalDouble scale, OptionalDouble width, OptionalDouble height, Optional<ColorI> color, Optional<AnimationI> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> gaplessPlayback, Optional<Boolean> isAntiAlias, Optional<String> _package, Optional<FilterQuality> filterQuality, OptionalInt cacheWidth, OptionalInt cacheHeight) {
    int id = factories.imageAsset(name,
      frameBuilder,
      semanticLabel,
      excludeFromSemantics,
      scale,
      width,
      height,
      color.map(ColorI::build),
      opacity.map(AnimationI::build),
      colorBlendMode,
      fit,
      alignment.map(AlignmentGeometryI::build),
      repeat,
      matchTextDirection,
      gaplessPlayback,
      isAntiAlias,
      _package,
      filterQuality,
      cacheWidth,
      cacheHeight);
    if (id <= 0) throw new RuntimeException("Failed to created widget Image");
    return new Image(id);
  }
  public static ImageAssetBuilder asset(String name) {
    return ImageAssetBuilder.imageAsset(name);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageWidth not supported on web");
    return factories.Image_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageHeight not supported on web");
    return factories.Image_readBack_height(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("imageColor", getId());
      return new Color(__nid);
    }
    return factories.Image_readBack_color(nativeStruct);
  }
  public Animation opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageOpacity not supported on web");
    return factories.Image_readBack_opacity(nativeStruct);
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFilterQuality not supported on web");
    return factories.Image_readBack_filterQuality(nativeStruct);
  }
  public BlendMode colorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageColorBlendMode not supported on web");
    return factories.Image_readBack_colorBlendMode(nativeStruct);
  }
  public BoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFit not supported on web");
    return factories.Image_readBack_fit(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageAlignment not supported on web");
    return factories.Image_readBack_alignment(nativeStruct);
  }
  public ImageRepeat repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageRepeat not supported on web");
    return factories.Image_readBack_repeat(nativeStruct);
  }
  public boolean matchTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageMatchTextDirection not supported on web");
    return factories.Image_readBack_matchTextDirection(nativeStruct);
  }
  public boolean gaplessPlayback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageGaplessPlayback not supported on web");
    return factories.Image_readBack_gaplessPlayback(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageSemanticLabel not supported on web");
    return factories.Image_readBack_semanticLabel(nativeStruct);
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageExcludeFromSemantics not supported on web");
    return factories.Image_readBack_excludeFromSemantics(nativeStruct);
  }
  public boolean isAntiAlias() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageIsAntiAlias not supported on web");
    return factories.Image_readBack_isAntiAlias(nativeStruct);
  }
  @Override
  public Image build() {
    return this;
  }
}
