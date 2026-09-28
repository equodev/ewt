package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Radio<T> extends StatefulWidget implements RadioI {
  protected Radio() {}
  Radio(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Radio");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> Radio<T> radioRadio(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> enabled, Optional<ColorI> backgroundColor, Optional<BorderSideI> side, OptionalDouble innerRadius) {
    int id = factories.radioRadio(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      enabled,
      backgroundColor.map(ColorI::build),
      side.map(BorderSideI::build),
      innerRadius);
    if (id <= 0) throw new RuntimeException("Failed to created widget Radio");
    return new Radio(id);
  }
  public static <T extends NativeObj> RadioRadioBuilder<T> radio(NativeObj value) {
    return RadioRadioBuilder.radioRadio(value);
  }
  @Builder.Factory
  static <T extends NativeObj> Radio<T> radioAdaptive(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<Boolean> enabled, Optional<ColorI> backgroundColor, Optional<BorderSideI> side, OptionalDouble innerRadius) {
    int id = factories.radioAdaptive(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      useCupertinoCheckmarkStyle,
      enabled,
      backgroundColor.map(ColorI::build),
      side.map(BorderSideI::build),
      innerRadius);
    if (id <= 0) throw new RuntimeException("Failed to created widget Radio");
    return new Radio(id);
  }
  public static <T extends NativeObj> RadioAdaptiveBuilder<T> adaptive(NativeObj value) {
    return RadioAdaptiveBuilder.radioAdaptive(value);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioToggleable not supported on web");
    return factories.Radio_readBack_toggleable(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioActiveColor", getId());
      return new Color(__nid);
    }
    return factories.Radio_readBack_activeColor(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMaterialTapTargetSize not supported on web");
    return factories.Radio_readBack_materialTapTargetSize(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.Radio_readBack_visualDensity(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioFocusColor", getId());
      return new Color(__nid);
    }
    return factories.Radio_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioHoverColor", getId());
      return new Color(__nid);
    }
    return factories.Radio_readBack_hoverColor(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioSplashRadius not supported on web");
    return factories.Radio_readBack_splashRadius(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioAutofocus not supported on web");
    return factories.Radio_readBack_autofocus(nativeStruct);
  }
  public boolean useCupertinoCheckmarkStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioUseCupertinoCheckmarkStyle not supported on web");
    return factories.Radio_readBack_useCupertinoCheckmarkStyle(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioEnabled not supported on web");
    return factories.Radio_readBack_enabled(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioSide", getId());
      return new BorderSide(__nid);
    }
    return factories.Radio_readBack_side(nativeStruct);
  }
  @Override
  public Radio build() {
    return this;
  }
}
