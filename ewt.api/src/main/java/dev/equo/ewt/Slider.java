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
  @Builder.Factory
  static Slider sliderSlider(@Builder.Parameter double value, OptionalDouble secondaryTrackValue, Consumer<Double> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> secondaryActiveColor, Optional<ColorI> thumbColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> year2023) {
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
  static Slider sliderAdaptive(@Builder.Parameter double value, OptionalDouble secondaryTrackValue, Consumer<Double> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> secondaryActiveColor, Optional<ColorI> thumbColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<Boolean> year2023) {
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
    return SliderObjSt.value(st);
  }
  public double secondaryTrackValue() {
    return SliderObjSt.secondaryTrackValue(st);
  }
  public double min() {
    return SliderObjSt.min(st);
  }
  public double max() {
    return SliderObjSt.max(st);
  }
  public int divisions() {
    return SliderObjSt.divisions(st);
  }
  public String label() {
    return SliderObjSt.label(st).getString(0);
  }
  public Color activeColor() {
    return new Color(SliderObjSt.activeColor(st));
  }
  public Color inactiveColor() {
    return new Color(SliderObjSt.inactiveColor(st));
  }
  public Color secondaryActiveColor() {
    return new Color(SliderObjSt.secondaryActiveColor(st));
  }
  public Color thumbColor() {
    return new Color(SliderObjSt.thumbColor(st));
  }
  public boolean autofocus() {
    return intToBool(SliderObjSt.autofocus(st));
  }
  public SliderInteraction allowedInteraction() {
    return SliderInteraction.values()[SliderObjSt.allowedInteraction(st)];
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(SliderObjSt.padding(st)) {};
  }
  public boolean year2023() {
    return intToBool(SliderObjSt.year2023(st));
  }
  @Override
  public Slider build() {
    return this;
  }
}
