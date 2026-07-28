package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoSliderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoSlider extends StatefulWidget implements CupertinoSliderI {
  private MemorySegment st;
  protected CupertinoSlider() {}
  CupertinoSlider(MemorySegment st) {
    this.id = CupertinoSliderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSlider");
    System.out.println("New CupertinoSlider id:"+id);
  }
  CupertinoSlider(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoSlider cupertinoSliderCupertinoSlider(@Builder.Parameter double value, @Builder.Parameter Consumer<Double> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<ColorI> activeColor, Optional<ColorI> thumbColor) {
    var st = factories.cupertinoSliderCupertinoSlider(value,
      onChanged,
      onChangeStart,
      onChangeEnd,
      min,
      max,
      divisions,
      activeColor.map(ColorI::build),
      thumbColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoSlider");
    return new CupertinoSlider(st);
  }
  public static CupertinoSliderCupertinoSliderBuilder cupertinoSlider(double value, Consumer<Double> onChanged) {
    return CupertinoSliderCupertinoSliderBuilder.cupertinoSliderCupertinoSlider(value, onChanged);
  }
  public double value() {
    return CupertinoSliderObjSt.value(st);
  }
  public double min() {
    return CupertinoSliderObjSt.min(st);
  }
  public double max() {
    return CupertinoSliderObjSt.max(st);
  }
  public int divisions() {
    return CupertinoSliderObjSt.divisions(st);
  }
  public Color activeColor() {
    return new Color(CupertinoSliderObjSt.activeColor(st));
  }
  public Color thumbColor() {
    return new Color(CupertinoSliderObjSt.thumbColor(st));
  }
  @Override
  public CupertinoSlider build() {
    return this;
  }
}
