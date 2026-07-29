package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoSwitchObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoSwitch extends StatefulWidget implements CupertinoSwitchI {
  private MemorySegment st;
  protected CupertinoSwitch() {}
  CupertinoSwitch(MemorySegment st) {
    this.id = CupertinoSwitchObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSwitch");
    System.out.println("New CupertinoSwitch id:"+id);
  }
  CupertinoSwitch(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoSwitch cupertinoSwitchCupertinoSwitch(@Builder.Parameter boolean value, @Builder.Parameter Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> trackColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> thumbColor, Optional<ColorI> inactiveThumbColor, Optional<Boolean> applyTheme, Optional<ColorI> focusColor, Optional<ColorI> onLabelColor, Optional<ColorI> offLabelColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DragStartBehavior> dragStartBehavior) {
    var st = factories.cupertinoSwitchCupertinoSwitch(value,
      onChanged,
      activeColor.map(ColorI::build),
      trackColor.map(ColorI::build),
      activeTrackColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      thumbColor.map(ColorI::build),
      inactiveThumbColor.map(ColorI::build),
      applyTheme,
      focusColor.map(ColorI::build),
      onLabelColor.map(ColorI::build),
      offLabelColor.map(ColorI::build),
      onFocusChange,
      autofocus,
      dragStartBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoSwitch");
    return new CupertinoSwitch(st);
  }
  public static CupertinoSwitchCupertinoSwitchBuilder cupertinoSwitch(boolean value, Consumer<Boolean> onChanged) {
    return CupertinoSwitchCupertinoSwitchBuilder.cupertinoSwitchCupertinoSwitch(value, onChanged);
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchValue not supported on web");
    return intToBool(CupertinoSwitchObjSt.value(st));
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchActiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.activeTrackColor(st));
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.inactiveTrackColor(st));
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.thumbColor(st));
  }
  public Color inactiveThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchInactiveThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.inactiveThumbColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.focusColor(st));
  }
  public Color onLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchOnLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.onLabelColor(st));
  }
  public Color offLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchOffLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.offLabelColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchAutofocus not supported on web");
    return intToBool(CupertinoSwitchObjSt.autofocus(st));
  }
  public boolean applyTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchApplyTheme not supported on web");
    return intToBool(CupertinoSwitchObjSt.applyTheme(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchDragStartBehavior not supported on web");
    return DragStartBehavior.values()[CupertinoSwitchObjSt.dragStartBehavior(st)];
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.activeColor(st));
  }
  public Color trackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSwitchObjSt.trackColor(st));
  }
  @Override
  public CupertinoSwitch build() {
    return this;
  }
}
