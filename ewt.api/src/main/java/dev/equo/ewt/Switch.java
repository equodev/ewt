package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Switch extends StatelessWidget implements SwitchI {
  protected Switch() {}
  Switch(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Switch");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Switch switch_Switch_(@Builder.Parameter boolean value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<IconI> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> padding) {
    int id = factories.switch_Switch_(value,
      onChanged,
      activeColor.map(ColorI::build),
      activeThumbColor.map(ColorI::build),
      activeTrackColor.map(ColorI::build),
      inactiveThumbColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      thumbColor.map(ColorI::build),
      trackColor.map(ColorI::build),
      trackOutlineColor.map(ColorI::build),
      trackOutlineWidth,
      thumbIcon.map(IconI::build),
      materialTapTargetSize,
      dragStartBehavior,
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      onFocusChange,
      autofocus,
      padding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Switch");
    return new Switch(id);
  }
  public static Switch_Switch_Builder switch_(boolean value) {
    return Switch_Switch_Builder.switch_Switch_(value);
  }
  @Builder.Factory
  static Switch switch_Adaptive(@Builder.Parameter boolean value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<IconI> thumbIcon, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> applyCupertinoTheme) {
    int id = factories.switch_Adaptive(value,
      onChanged,
      activeColor.map(ColorI::build),
      activeThumbColor.map(ColorI::build),
      activeTrackColor.map(ColorI::build),
      inactiveThumbColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      materialTapTargetSize,
      thumbColor.map(ColorI::build),
      trackColor.map(ColorI::build),
      trackOutlineColor.map(ColorI::build),
      trackOutlineWidth,
      thumbIcon.map(IconI::build),
      dragStartBehavior,
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      onFocusChange,
      autofocus,
      padding.map(EdgeInsetsGeometryI::build),
      applyCupertinoTheme);
    if (id <= 0) throw new RuntimeException("Failed to created widget Switch");
    return new Switch(id);
  }
  public static Switch_AdaptiveBuilder adaptive(boolean value) {
    return Switch_AdaptiveBuilder.switch_Adaptive(value);
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_Value not supported on web");
    return factories.Switch_readBack_value(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_ActiveColor", getId());
      return new Color(__nid);
    }
    return factories.Switch_readBack_activeColor(nativeStruct);
  }
  public Color activeThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_ActiveThumbColor", getId());
      return new Color(__nid);
    }
    return factories.Switch_readBack_activeThumbColor(nativeStruct);
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_ActiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.Switch_readBack_activeTrackColor(nativeStruct);
  }
  public Color inactiveThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_InactiveThumbColor", getId());
      return new Color(__nid);
    }
    return factories.Switch_readBack_inactiveThumbColor(nativeStruct);
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_InactiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.Switch_readBack_inactiveTrackColor(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_MaterialTapTargetSize not supported on web");
    return factories.Switch_readBack_materialTapTargetSize(nativeStruct);
  }
  public boolean applyCupertinoTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_ApplyCupertinoTheme not supported on web");
    return factories.Switch_readBack_applyCupertinoTheme(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_DragStartBehavior not supported on web");
    return factories.Switch_readBack_dragStartBehavior(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_FocusColor", getId());
      return new Color(__nid);
    }
    return factories.Switch_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_HoverColor", getId());
      return new Color(__nid);
    }
    return factories.Switch_readBack_hoverColor(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_SplashRadius not supported on web");
    return factories.Switch_readBack_splashRadius(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_Autofocus not supported on web");
    return factories.Switch_readBack_autofocus(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_Padding not supported on web");
    return factories.Switch_readBack_padding(nativeStruct);
  }
  @Override
  public Switch build() {
    return this;
  }
}
