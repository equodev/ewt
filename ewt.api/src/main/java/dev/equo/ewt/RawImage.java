package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RawImageObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RawImage extends LeafRenderObjectWidget implements RawImageI {
  private MemorySegment st;
  protected RawImage() {}
  RawImage(MemorySegment st) {
    this.id = RawImageObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawImage");
    System.out.println("New RawImage id:"+id);
  }
  RawImage(int id) { this.id = id; }
  @Builder.Factory
  static RawImage rawImageRawImage(Optional<String> debugImageLabel, OptionalDouble width, OptionalDouble height, OptionalDouble scale, Optional<ColorI> color, Optional<AnimationI> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> invertColors, Optional<FilterQuality> filterQuality, Optional<Boolean> isAntiAlias) {
    var st = factories.rawImageRawImage(debugImageLabel,
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
    if (st == null) throw new RuntimeException("Failed to created widget RawImage");
    return new RawImage(st);
  }
  public static RawImageRawImageBuilder rawImage() {
    return RawImageRawImageBuilder.rawImageRawImage();
  }
  public String debugImageLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageDebugImageLabel not supported on web");
    return RawImageObjSt.debugImageLabel(st).getString(0);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageWidth not supported on web");
    return RawImageObjSt.width(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageHeight not supported on web");
    return RawImageObjSt.height(st);
  }
  public double scale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageScale not supported on web");
    return RawImageObjSt.scale(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawImageColor", getId());
      return new Color(__nid);
    }
    return new Color(RawImageObjSt.color(st));
  }
  public Animation opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageOpacity not supported on web");
    return new Animation() { public int getId() { return RawImageObjSt.opacity(st); } };
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageFilterQuality not supported on web");
    return FilterQuality.values()[RawImageObjSt.filterQuality(st)];
  }
  public BlendMode colorBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageColorBlendMode not supported on web");
    return BlendMode.values()[RawImageObjSt.colorBlendMode(st)];
  }
  public BoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageFit not supported on web");
    return BoxFit.values()[RawImageObjSt.fit(st)];
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageAlignment not supported on web");
    return new AlignmentGeometry(RawImageObjSt.alignment(st)) {};
  }
  public ImageRepeat repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageRepeat not supported on web");
    return ImageRepeat.values()[RawImageObjSt.repeat(st)];
  }
  public boolean matchTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageMatchTextDirection not supported on web");
    return intToBool(RawImageObjSt.matchTextDirection(st));
  }
  public boolean invertColors() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageInvertColors not supported on web");
    return intToBool(RawImageObjSt.invertColors(st));
  }
  public boolean isAntiAlias() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawImageIsAntiAlias not supported on web");
    return intToBool(RawImageObjSt.isAntiAlias(st));
  }
  @Override
  public RawImage build() {
    return this;
  }
}
