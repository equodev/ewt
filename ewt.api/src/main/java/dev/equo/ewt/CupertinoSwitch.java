package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoSwitch extends StatefulWidget implements CupertinoSwitchI {
  protected CupertinoSwitch() {}
  CupertinoSwitch(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSwitch");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoSwitch cupertinoSwitchCupertinoSwitch(@Builder.Parameter boolean value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> trackColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> thumbColor, Optional<ColorI> inactiveThumbColor, Optional<Boolean> applyTheme, Optional<ColorI> focusColor, Optional<ColorI> onLabelColor, Optional<ColorI> offLabelColor, Optional<ColorI> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<IconI> thumbIcon, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DragStartBehavior> dragStartBehavior) {
    int id = factories.cupertinoSwitchCupertinoSwitch(value,
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
      trackOutlineColor.map(ColorI::build),
      trackOutlineWidth,
      thumbIcon.map(IconI::build),
      onFocusChange,
      autofocus,
      dragStartBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSwitch");
    return new CupertinoSwitch(id);
  }
  public static CupertinoSwitchCupertinoSwitchBuilder cupertinoSwitch(boolean value) {
    return CupertinoSwitchCupertinoSwitchBuilder.cupertinoSwitchCupertinoSwitch(value);
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchValue not supported on web");
    return factories.CupertinoSwitch_readBack_value(nativeStruct);
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchActiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_activeTrackColor(nativeStruct);
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_inactiveTrackColor(nativeStruct);
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchThumbColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_thumbColor(nativeStruct);
  }
  public Color inactiveThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchInactiveThumbColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_inactiveThumbColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchFocusColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_focusColor(nativeStruct);
  }
  public Color onLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchOnLabelColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_onLabelColor(nativeStruct);
  }
  public Color offLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchOffLabelColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_offLabelColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchAutofocus not supported on web");
    return factories.CupertinoSwitch_readBack_autofocus(nativeStruct);
  }
  public boolean applyTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchApplyTheme not supported on web");
    return factories.CupertinoSwitch_readBack_applyTheme(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSwitchDragStartBehavior not supported on web");
    return factories.CupertinoSwitch_readBack_dragStartBehavior(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchActiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_activeColor(nativeStruct);
  }
  public Color trackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSwitchTrackColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSwitch_readBack_trackColor(nativeStruct);
  }
  @Override
  public CupertinoSwitch build() {
    return this;
  }
}
