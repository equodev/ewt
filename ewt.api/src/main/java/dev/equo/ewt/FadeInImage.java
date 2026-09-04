package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FadeInImageObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FadeInImage extends StatefulWidget implements FadeInImageI {
  private MemorySegment st;
  protected FadeInImage() {}
  FadeInImage(MemorySegment st) {
    this.id = FadeInImageObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FadeInImage");
    System.out.println("New FadeInImage id:"+id);
  }
  FadeInImage(int id) { this.id = id; }
  @Builder.Factory
  static FadeInImage fadeInImageAssetNetwork(@Builder.Parameter String placeholder, @Builder.Parameter String image, OptionalDouble placeholderScale, OptionalDouble imageScale, Optional<Boolean> excludeFromSemantics, Optional<String> imageSemanticLabel, Optional<DurationI> fadeOutDuration, Optional<CurveI> fadeOutCurve, Optional<DurationI> fadeInDuration, Optional<CurveI> fadeInCurve, OptionalDouble width, OptionalDouble height, Optional<BoxFit> fit, Optional<ColorI> color, Optional<BlendMode> colorBlendMode, Optional<ColorI> placeholderColor, Optional<BlendMode> placeholderColorBlendMode, Optional<BoxFit> placeholderFit, Optional<FilterQuality> filterQuality, Optional<FilterQuality> placeholderFilterQuality, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, OptionalInt placeholderCacheWidth, OptionalInt placeholderCacheHeight, OptionalInt imageCacheWidth, OptionalInt imageCacheHeight) {
    var st = factories.fadeInImageAssetNetwork(placeholder,
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
    if (st == null) throw new RuntimeException("Failed to created widget FadeInImage");
    return new FadeInImage(st);
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
    return new Duration(FadeInImageObjSt.fadeOutDuration(st));
  }
  public Curve fadeOutCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFadeOutCurve not supported on web");
    return new Curve(FadeInImageObjSt.fadeOutCurve(st)) {};
  }
  public Duration fadeInDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fadeInImageFadeInDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(FadeInImageObjSt.fadeInDuration(st));
  }
  public Curve fadeInCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFadeInCurve not supported on web");
    return new Curve(FadeInImageObjSt.fadeInCurve(st)) {};
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageWidth not supported on web");
    return FadeInImageObjSt.width(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fadeInImageColor", getId());
      return new Color(__nid);
    }
    return new Color(FadeInImageObjSt.color(st));
  }
  public BlendMode colorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageColorBlendMode not supported on web");
    return BlendMode.values()[FadeInImageObjSt.colorBlendMode(st)];
  }
  public Color placeholderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fadeInImagePlaceholderColor", getId());
      return new Color(__nid);
    }
    return new Color(FadeInImageObjSt.placeholderColor(st));
  }
  public BlendMode placeholderColorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImagePlaceholderColorBlendMode not supported on web");
    return BlendMode.values()[FadeInImageObjSt.placeholderColorBlendMode(st)];
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageHeight not supported on web");
    return FadeInImageObjSt.height(st);
  }
  public BoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFit not supported on web");
    return BoxFit.values()[FadeInImageObjSt.fit(st)];
  }
  public BoxFit placeholderFit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImagePlaceholderFit not supported on web");
    return BoxFit.values()[FadeInImageObjSt.placeholderFit(st)];
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageFilterQuality not supported on web");
    return FilterQuality.values()[FadeInImageObjSt.filterQuality(st)];
  }
  public FilterQuality placeholderFilterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImagePlaceholderFilterQuality not supported on web");
    return FilterQuality.values()[FadeInImageObjSt.placeholderFilterQuality(st)];
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageAlignment not supported on web");
    return new AlignmentGeometry(FadeInImageObjSt.alignment(st)) {};
  }
  public ImageRepeat repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageRepeat not supported on web");
    return ImageRepeat.values()[FadeInImageObjSt.repeat(st)];
  }
  public boolean matchTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageMatchTextDirection not supported on web");
    return intToBool(FadeInImageObjSt.matchTextDirection(st));
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageExcludeFromSemantics not supported on web");
    return intToBool(FadeInImageObjSt.excludeFromSemantics(st));
  }
  public String imageSemanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fadeInImageImageSemanticLabel not supported on web");
    return FadeInImageObjSt.imageSemanticLabel(st).getString(0);
  }
  @Override
  public FadeInImage build() {
    return this;
  }
}
