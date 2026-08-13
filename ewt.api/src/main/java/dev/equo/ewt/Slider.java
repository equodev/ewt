package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Slider extends StatefulWidget implements SliderI {
  private MemorySegment st;
  protected Slider() {}
  Slider(MemorySegment st) {
    this.id = SliderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Slider");
    System.out.println("New Slider id:"+id);
  }
  Slider(int id) { this.id = id; }
  @Builder.Factory
  static Slider sliderSlider(@Builder.Parameter double value, OptionalDouble secondaryTrackValue, Consumer<Double> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> secondaryActiveColor, Optional<ColorI> thumbColor, Optional<ColorI> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> year2023) {
    var st = factories.sliderSlider(value,
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
      year2023);
    if (st == null) throw new RuntimeException("Failed to created widget Slider");
    return new Slider(st);
  }
  public static SliderSliderBuilder slider(double value) {
    return SliderSliderBuilder.sliderSlider(value);
  }
  @Builder.Factory
  static Slider sliderAdaptive(@Builder.Parameter double value, OptionalDouble secondaryTrackValue, Consumer<Double> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> secondaryActiveColor, Optional<ColorI> thumbColor, Optional<ColorI> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<Boolean> year2023) {
    var st = factories.sliderAdaptive(value,
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
      year2023);
    if (st == null) throw new RuntimeException("Failed to created widget Slider");
    return new Slider(st);
  }
  public static SliderAdaptiveBuilder adaptive(double value) {
    return SliderAdaptiveBuilder.sliderAdaptive(value);
  }
  public double value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderValue not supported on web");
    return SliderObjSt.value(st);
  }
  public double secondaryTrackValue() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderSecondaryTrackValue not supported on web");
    return SliderObjSt.secondaryTrackValue(st);
  }
  public double min() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderMin not supported on web");
    return SliderObjSt.min(st);
  }
  public double max() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderMax not supported on web");
    return SliderObjSt.max(st);
  }
  public int divisions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderDivisions not supported on web");
    return SliderObjSt.divisions(st);
  }
  public String label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderLabel not supported on web");
    return SliderObjSt.label(st).getString(0);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderObjSt.activeColor(st));
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderInactiveColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderObjSt.inactiveColor(st));
  }
  public Color secondaryActiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderSecondaryActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderObjSt.secondaryActiveColor(st));
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderObjSt.thumbColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderAutofocus not supported on web");
    return intToBool(SliderObjSt.autofocus(st));
  }
  public SliderInteraction allowedInteraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderAllowedInteraction not supported on web");
    return SliderInteraction.values()[SliderObjSt.allowedInteraction(st)];
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderPadding not supported on web");
    return new EdgeInsetsGeometry(SliderObjSt.padding(st)) {};
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderYear2023 not supported on web");
    return intToBool(SliderObjSt.year2023(st));
  }
  @Override
  public Slider build() {
    return this;
  }
}
