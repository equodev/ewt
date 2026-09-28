package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Icon extends StatelessWidget implements IconI {
  protected Icon() {}
  Icon(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Icon");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Icon iconIcon(@Builder.Parameter IconDataI icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, Optional<List<ShadowI>> shadows, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode, Optional<FontWeightI> fontWeight) {
    int id = factories.iconIcon(icon.build(),
      size,
      fill,
      weight,
      grade,
      opticalSize,
      color.map(ColorI::build),
      shadows.map(i -> i.stream().map(ShadowI::build).collect(java.util.stream.Collectors.toList())),
      semanticLabel,
      textDirection,
      applyTextScaling,
      blendMode,
      fontWeight.map(FontWeightI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Icon");
    return new Icon(id);
  }
  public static IconIconBuilder icon(IconDataI icon) {
    return IconIconBuilder.iconIcon(icon);
  }
  public IconData icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconIcon", getId());
      return new IconData(__nid);
    }
    return factories.Icon_readBack_icon(nativeStruct);
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconSize not supported on web");
    return factories.Icon_readBack_size(nativeStruct);
  }
  public double fill() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconFill not supported on web");
    return factories.Icon_readBack_fill(nativeStruct);
  }
  public double weight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconWeight not supported on web");
    return factories.Icon_readBack_weight(nativeStruct);
  }
  public double grade() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconGrade not supported on web");
    return factories.Icon_readBack_grade(nativeStruct);
  }
  public double opticalSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconOpticalSize not supported on web");
    return factories.Icon_readBack_opticalSize(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconColor", getId());
      return new Color(__nid);
    }
    return factories.Icon_readBack_color(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconSemanticLabel not supported on web");
    return factories.Icon_readBack_semanticLabel(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconTextDirection not supported on web");
    return factories.Icon_readBack_textDirection(nativeStruct);
  }
  public boolean applyTextScaling() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconApplyTextScaling not supported on web");
    return factories.Icon_readBack_applyTextScaling(nativeStruct);
  }
  public BlendMode blendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconBlendMode not supported on web");
    return factories.Icon_readBack_blendMode(nativeStruct);
  }
  public FontWeight fontWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconFontWeight", getId());
      return new FontWeight(__nid);
    }
    return factories.Icon_readBack_fontWeight(nativeStruct);
  }
  @Override
  public Icon build() {
    return this;
  }
}
