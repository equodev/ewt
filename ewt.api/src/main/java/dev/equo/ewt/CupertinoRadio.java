package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoRadio<T> extends StatefulWidget implements CupertinoRadioI {
  protected CupertinoRadio() {}
  CupertinoRadio(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoRadio");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> CupertinoRadio<T> cupertinoRadioCupertinoRadio(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<Boolean> autofocus, Optional<Boolean> useCheckmarkStyle, Optional<Boolean> enabled) {
    int id = factories.cupertinoRadioCupertinoRadio(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      inactiveColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      autofocus,
      useCheckmarkStyle,
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoRadio");
    return new CupertinoRadio(id);
  }
  public static <T extends NativeObj> CupertinoRadioCupertinoRadioBuilder<T> cupertinoRadio(NativeObj value) {
    return CupertinoRadioCupertinoRadioBuilder.cupertinoRadioCupertinoRadio(value);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioToggleable not supported on web");
    return factories.CupertinoRadio_readBack_toggleable(nativeStruct);
  }
  public boolean useCheckmarkStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioUseCheckmarkStyle not supported on web");
    return factories.CupertinoRadio_readBack_useCheckmarkStyle(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioActiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoRadio_readBack_activeColor(nativeStruct);
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioInactiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoRadio_readBack_inactiveColor(nativeStruct);
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioFillColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoRadio_readBack_fillColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioFocusColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoRadio_readBack_focusColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioAutofocus not supported on web");
    return factories.CupertinoRadio_readBack_autofocus(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioEnabled not supported on web");
    return factories.CupertinoRadio_readBack_enabled(nativeStruct);
  }
  @Override
  public CupertinoRadio build() {
    return this;
  }
}
