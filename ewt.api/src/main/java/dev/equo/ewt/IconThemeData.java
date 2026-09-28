package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IconThemeData extends NativeObj.Base implements IconThemeDataI {
  protected IconThemeData() {}
  IconThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IconThemeData iconThemeDataIconThemeData(OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, OptionalDouble opacity, Optional<List<ShadowI>> shadows, Optional<Boolean> applyTextScaling) {
    int id = factories.iconThemeDataIconThemeData(size,
      fill,
      weight,
      grade,
      opticalSize,
      color.map(ColorI::build),
      opacity,
      shadows.map(i -> i.stream().map(ShadowI::build).collect(java.util.stream.Collectors.toList())),
      applyTextScaling);
    if (id <= 0) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(id);
  }
  public static IconThemeDataIconThemeDataBuilder iconThemeData() {
    return IconThemeDataIconThemeDataBuilder.iconThemeDataIconThemeData();
  }
  @Builder.Factory
  static IconThemeData iconThemeDataFallback() {
    int id = factories.iconThemeDataFallback();
    if (id <= 0) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(id);
  }
  public static IconThemeDataFallbackBuilder fallback() {
    return IconThemeDataFallbackBuilder.iconThemeDataFallback();
  }
  public static IconThemeData lerp(IconThemeDataI a, IconThemeDataI b, double t) {
    int id = factories.iconThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(id);
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataSize not supported on web");
    return factories.IconThemeData_readBack_size(nativeStruct);
  }
  public double fill() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataFill not supported on web");
    return factories.IconThemeData_readBack_fill(nativeStruct);
  }
  public double weight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataWeight not supported on web");
    return factories.IconThemeData_readBack_weight(nativeStruct);
  }
  public double grade() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataGrade not supported on web");
    return factories.IconThemeData_readBack_grade(nativeStruct);
  }
  public double opticalSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataOpticalSize not supported on web");
    return factories.IconThemeData_readBack_opticalSize(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconThemeDataColor", getId());
      return new Color(__nid);
    }
    return factories.IconThemeData_readBack_color(nativeStruct);
  }
  public boolean applyTextScaling() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataApplyTextScaling not supported on web");
    return factories.IconThemeData_readBack_applyTextScaling(nativeStruct);
  }
  public boolean isConcrete() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataIsConcrete not supported on web");
    return factories.IconThemeData_readBack_isConcrete(nativeStruct);
  }
  public double opacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconThemeDataOpacity not supported on web");
    return factories.IconThemeData_readBack_opacity(nativeStruct);
  }
  @Override
  public IconThemeData build() {
    return this;
  }
}
