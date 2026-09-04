package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoRadioObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoRadio<T> extends StatefulWidget implements CupertinoRadioI {
  private MemorySegment st;
  protected CupertinoRadio() {}
  CupertinoRadio(MemorySegment st) {
    this.id = CupertinoRadioObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoRadio");
    System.out.println("New CupertinoRadio id:"+id);
  }
  CupertinoRadio(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> CupertinoRadio<T> cupertinoRadioCupertinoRadio(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<Boolean> autofocus, Optional<Boolean> useCheckmarkStyle, Optional<Boolean> enabled) {
    var st = factories.cupertinoRadioCupertinoRadio(value,
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoRadio");
    return new CupertinoRadio(st);
  }
  public static <T extends NativeObj> CupertinoRadioCupertinoRadioBuilder<T> cupertinoRadio(NativeObj value) {
    return CupertinoRadioCupertinoRadioBuilder.cupertinoRadioCupertinoRadio(value);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioToggleable not supported on web");
    return intToBool(CupertinoRadioObjSt.toggleable(st));
  }
  public boolean useCheckmarkStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioUseCheckmarkStyle not supported on web");
    return intToBool(CupertinoRadioObjSt.useCheckmarkStyle(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoRadioObjSt.activeColor(st));
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioInactiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoRadioObjSt.inactiveColor(st));
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioFillColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoRadioObjSt.fillColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoRadioFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoRadioObjSt.focusColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioAutofocus not supported on web");
    return intToBool(CupertinoRadioObjSt.autofocus(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoRadioEnabled not supported on web");
    return intToBool(CupertinoRadioObjSt.enabled(st));
  }
  @Override
  public CupertinoRadio build() {
    return this;
  }
}
