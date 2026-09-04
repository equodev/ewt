package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconThemeData extends NativeObj.Base implements IconThemeDataI {
  private MemorySegment st;
  protected IconThemeData() {}
  IconThemeData(MemorySegment st) {
    this.id = IconThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconThemeData");
    System.out.println("New IconThemeData id:"+id);
  }
  IconThemeData(int id) { this.id = id; }
  @Builder.Factory
  static IconThemeData iconThemeDataIconThemeData(OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, OptionalDouble opacity, Optional<List<ShadowI>> shadows, Optional<Boolean> applyTextScaling) {
    var st = factories.iconThemeDataIconThemeData(size,
      fill,
      weight,
      grade,
      opticalSize,
      color.map(ColorI::build),
      opacity,
      shadows.map(i -> i.stream().map(ShadowI::build).toList()),
      applyTextScaling);
    if (st == null) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(st);
  }
  public static IconThemeDataIconThemeDataBuilder iconThemeData() {
    return IconThemeDataIconThemeDataBuilder.iconThemeDataIconThemeData();
  }
  @Builder.Factory
  static IconThemeData iconThemeDataFallback() {
    var st = factories.iconThemeDataFallback();
    if (st == null) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(st);
  }
  public static IconThemeDataFallbackBuilder fallback() {
    return IconThemeDataFallbackBuilder.iconThemeDataFallback();
  }
  public static IconThemeData lerp(IconThemeDataI a, IconThemeDataI b, double t) {
    var st = factories.iconThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(st);
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataSize not supported on web");
    return IconThemeDataObjSt.size(st);
  }
  public double fill() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataFill not supported on web");
    return IconThemeDataObjSt.fill(st);
  }
  public double weight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataWeight not supported on web");
    return IconThemeDataObjSt.weight(st);
  }
  public double grade() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataGrade not supported on web");
    return IconThemeDataObjSt.grade(st);
  }
  public double opticalSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataOpticalSize not supported on web");
    return IconThemeDataObjSt.opticalSize(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconThemeDataColor", getId());
      return new Color(__nid);
    }
    return new Color(IconThemeDataObjSt.color(st));
  }
  public boolean applyTextScaling() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataApplyTextScaling not supported on web");
    return intToBool(IconThemeDataObjSt.applyTextScaling(st));
  }
  public boolean isConcrete() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataIsConcrete not supported on web");
    return intToBool(IconThemeDataObjSt.isConcrete(st));
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataOpacity not supported on web");
    return IconThemeDataObjSt.opacity(st);
  }
  @Override
  public IconThemeData build() {
    return this;
  }
}
