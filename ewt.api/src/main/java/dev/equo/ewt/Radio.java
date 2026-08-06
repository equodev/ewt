package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RadioObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Radio<T> extends StatefulWidget implements RadioI {
  private MemorySegment st;
  protected Radio() {}
  Radio(MemorySegment st) {
    this.id = RadioObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Radio");
    System.out.println("New Radio id:"+id);
  }
  Radio(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> Radio<T> radioRadio(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> enabled, Optional<BorderSideI> side) {
    var st = factories.radioRadio(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      enabled,
      side.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Radio");
    return new Radio(st);
  }
  public static <T extends NativeObj> RadioRadioBuilder<T> radio(NativeObj value) {
    return RadioRadioBuilder.radioRadio(value);
  }
  @Builder.Factory
  static <T extends NativeObj> Radio<T> radioAdaptive(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<Boolean> enabled, Optional<BorderSideI> side) {
    var st = factories.radioAdaptive(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      useCupertinoCheckmarkStyle,
      enabled,
      side.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Radio");
    return new Radio(st);
  }
  public static <T extends NativeObj> RadioAdaptiveBuilder<T> adaptive(NativeObj value) {
    return RadioAdaptiveBuilder.radioAdaptive(value);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioToggleable not supported on web");
    return intToBool(RadioObjSt.toggleable(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(RadioObjSt.activeColor(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[RadioObjSt.materialTapTargetSize(st)];
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(RadioObjSt.visualDensity(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(RadioObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(RadioObjSt.hoverColor(st));
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioSplashRadius not supported on web");
    return RadioObjSt.splashRadius(st);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioAutofocus not supported on web");
    return intToBool(RadioObjSt.autofocus(st));
  }
  public boolean useCupertinoCheckmarkStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioUseCupertinoCheckmarkStyle not supported on web");
    return intToBool(RadioObjSt.useCupertinoCheckmarkStyle(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioEnabled not supported on web");
    return intToBool(RadioObjSt.enabled(st));
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(RadioObjSt.side(st));
  }
  @Override
  public Radio build() {
    return this;
  }
}
