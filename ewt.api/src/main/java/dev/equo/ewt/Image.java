package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ImageObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Image extends StatefulWidget implements ImageI {
  private MemorySegment st;
  protected Image() {}
  Image(MemorySegment st) {
    this.id = ImageObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Image");
    System.out.println("New Image id:"+id);
  }
  Image(int id) { this.id = id; }
  @Builder.Factory
  static Image imageNetwork(@Builder.Parameter String src, OptionalDouble scale, Optional<QuadFunction<BuildContext, Widget, Integer, Boolean, Widget>> frameBuilder, Optional<String> semanticLabel, Optional<Boolean> excludeFromSemantics, OptionalDouble width, OptionalDouble height, Optional<ColorI> color, Optional<AnimationI> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> gaplessPlayback, Optional<FilterQuality> filterQuality, Optional<Boolean> isAntiAlias, OptionalInt cacheWidth, OptionalInt cacheHeight, Optional<WebHtmlElementStrategy> webHtmlElementStrategy) {
    var st = factories.imageNetwork(src,
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
    if (st == null) throw new RuntimeException("Failed to created widget Image");
    return new Image(st);
  }
  public static ImageNetworkBuilder network(String src) {
    return ImageNetworkBuilder.imageNetwork(src);
  }
  @Builder.Factory
  static Image imageAsset(@Builder.Parameter String name, Optional<QuadFunction<BuildContext, Widget, Integer, Boolean, Widget>> frameBuilder, Optional<String> semanticLabel, Optional<Boolean> excludeFromSemantics, OptionalDouble scale, OptionalDouble width, OptionalDouble height, Optional<ColorI> color, Optional<AnimationI> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> gaplessPlayback, Optional<Boolean> isAntiAlias, Optional<String> _package, Optional<FilterQuality> filterQuality, OptionalInt cacheWidth, OptionalInt cacheHeight) {
    var st = factories.imageAsset(name,
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
    if (st == null) throw new RuntimeException("Failed to created widget Image");
    return new Image(st);
  }
  public static ImageAssetBuilder asset(String name) {
    return ImageAssetBuilder.imageAsset(name);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageWidth not supported on web");
    return ImageObjSt.width(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageHeight not supported on web");
    return ImageObjSt.height(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("imageColor", getId());
      return new Color(__nid);
    }
    return new Color(ImageObjSt.color(st));
  }
  public Animation opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageOpacity not supported on web");
    return new Animation() { public int getId() { return ImageObjSt.opacity(st); } };
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFilterQuality not supported on web");
    return FilterQuality.values()[ImageObjSt.filterQuality(st)];
  }
  public BlendMode colorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageColorBlendMode not supported on web");
    return BlendMode.values()[ImageObjSt.colorBlendMode(st)];
  }
  public BoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFit not supported on web");
    return BoxFit.values()[ImageObjSt.fit(st)];
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageAlignment not supported on web");
    return new AlignmentGeometry(ImageObjSt.alignment(st)) {};
  }
  public ImageRepeat repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageRepeat not supported on web");
    return ImageRepeat.values()[ImageObjSt.repeat(st)];
  }
  public boolean matchTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageMatchTextDirection not supported on web");
    return intToBool(ImageObjSt.matchTextDirection(st));
  }
  public boolean gaplessPlayback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageGaplessPlayback not supported on web");
    return intToBool(ImageObjSt.gaplessPlayback(st));
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageSemanticLabel not supported on web");
    return ImageObjSt.semanticLabel(st).getString(0);
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageExcludeFromSemantics not supported on web");
    return intToBool(ImageObjSt.excludeFromSemantics(st));
  }
  public boolean isAntiAlias() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageIsAntiAlias not supported on web");
    return intToBool(ImageObjSt.isAntiAlias(st));
  }
  @Override
  public Image build() {
    return this;
  }
}
