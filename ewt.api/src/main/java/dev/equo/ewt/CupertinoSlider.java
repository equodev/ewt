package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoSlider extends StatefulWidget implements CupertinoSliderI {
  protected CupertinoSlider() {}
  CupertinoSlider(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSlider");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoSlider cupertinoSliderCupertinoSlider(@Builder.Parameter double value, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<ColorI> activeColor, Optional<ColorI> thumbColor) {
    int id = factories.cupertinoSliderCupertinoSlider(value,
      onChanged,
      onChangeStart,
      onChangeEnd,
      min,
      max,
      divisions,
      activeColor.map(ColorI::build),
      thumbColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSlider");
    return new CupertinoSlider(id);
  }
  public static CupertinoSliderCupertinoSliderBuilder cupertinoSlider(double value) {
    return CupertinoSliderCupertinoSliderBuilder.cupertinoSliderCupertinoSlider(value);
  }
  public double value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliderValue not supported on web");
    return factories.CupertinoSlider_readBack_value(nativeStruct);
  }
  public double min() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliderMin not supported on web");
    return factories.CupertinoSlider_readBack_min(nativeStruct);
  }
  public double max() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliderMax not supported on web");
    return factories.CupertinoSlider_readBack_max(nativeStruct);
  }
  public int divisions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliderDivisions not supported on web");
    return factories.CupertinoSlider_readBack_divisions(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSliderActiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSlider_readBack_activeColor(nativeStruct);
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSliderThumbColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSlider_readBack_thumbColor(nativeStruct);
  }
  @Override
  public CupertinoSlider build() {
    return this;
  }
}
