package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Slider extends StatefulWidget implements SliderI {
  protected Slider() {}
  Slider(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Slider");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Slider sliderSlider(@Builder.Parameter double value, OptionalDouble secondaryTrackValue, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> secondaryActiveColor, Optional<ColorI> thumbColor, Optional<ColorI> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometryI> padding, Optional<ShowValueIndicator> showValueIndicator, Optional<Boolean> year2023) {
    int id = factories.sliderSlider(value,
      secondaryTrackValue,
      onChanged,
      onChangeStart,
      onChangeEnd,
      min,
      max,
      divisions,
      label,
      activeColor.map(ColorI::build),
      inactiveColor.map(ColorI::build),
      secondaryActiveColor.map(ColorI::build),
      thumbColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      semanticFormatterCallback,
      autofocus,
      allowedInteraction,
      padding.map(EdgeInsetsGeometryI::build),
      showValueIndicator,
      year2023);
    if (id <= 0) throw new RuntimeException("Failed to created widget Slider");
    return new Slider(id);
  }
  public static SliderSliderBuilder slider(double value) {
    return SliderSliderBuilder.sliderSlider(value);
  }
  @Builder.Factory
  static Slider sliderAdaptive(@Builder.Parameter double value, OptionalDouble secondaryTrackValue, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> secondaryActiveColor, Optional<ColorI> thumbColor, Optional<ColorI> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<ShowValueIndicator> showValueIndicator, Optional<Boolean> year2023) {
    int id = factories.sliderAdaptive(value,
      secondaryTrackValue,
      onChanged,
      onChangeStart,
      onChangeEnd,
      min,
      max,
      divisions,
      label,
      activeColor.map(ColorI::build),
      inactiveColor.map(ColorI::build),
      secondaryActiveColor.map(ColorI::build),
      thumbColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      semanticFormatterCallback,
      autofocus,
      allowedInteraction,
      showValueIndicator,
      year2023);
    if (id <= 0) throw new RuntimeException("Failed to created widget Slider");
    return new Slider(id);
  }
  public static SliderAdaptiveBuilder adaptive(double value) {
    return SliderAdaptiveBuilder.sliderAdaptive(value);
  }
  public double value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderValue not supported on web");
    return factories.Slider_readBack_value(nativeStruct);
  }
  public double secondaryTrackValue() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderSecondaryTrackValue not supported on web");
    return factories.Slider_readBack_secondaryTrackValue(nativeStruct);
  }
  public double min() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderMin not supported on web");
    return factories.Slider_readBack_min(nativeStruct);
  }
  public double max() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderMax not supported on web");
    return factories.Slider_readBack_max(nativeStruct);
  }
  public int divisions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderDivisions not supported on web");
    return factories.Slider_readBack_divisions(nativeStruct);
  }
  public String label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderLabel not supported on web");
    return factories.Slider_readBack_label(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderActiveColor", getId());
      return new Color(__nid);
    }
    return factories.Slider_readBack_activeColor(nativeStruct);
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderInactiveColor", getId());
      return new Color(__nid);
    }
    return factories.Slider_readBack_inactiveColor(nativeStruct);
  }
  public Color secondaryActiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderSecondaryActiveColor", getId());
      return new Color(__nid);
    }
    return factories.Slider_readBack_secondaryActiveColor(nativeStruct);
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThumbColor", getId());
      return new Color(__nid);
    }
    return factories.Slider_readBack_thumbColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderAutofocus not supported on web");
    return factories.Slider_readBack_autofocus(nativeStruct);
  }
  public SliderInteraction allowedInteraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderAllowedInteraction not supported on web");
    return factories.Slider_readBack_allowedInteraction(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderPadding not supported on web");
    return factories.Slider_readBack_padding(nativeStruct);
  }
  public ShowValueIndicator showValueIndicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderShowValueIndicator not supported on web");
    return factories.Slider_readBack_showValueIndicator(nativeStruct);
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderYear2023 not supported on web");
    return factories.Slider_readBack_year2023(nativeStruct);
  }
  @Override
  public Slider build() {
    return this;
  }
}
