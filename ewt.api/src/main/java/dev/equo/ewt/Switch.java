package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SwitchObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Switch extends StatelessWidget implements SwitchI {
  private MemorySegment st;
  protected Switch() {}
  Switch(MemorySegment st) {
    this.id = SwitchObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Switch");
    System.out.println("New Switch id:"+id);
  }
  Switch(int id) { this.id = id; }
  @Builder.Factory
  static Switch switch_Switch_(@Builder.Parameter boolean value, @Builder.Parameter Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<IconI> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> padding) {
    var st = factories.switch_Switch_(value,
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
    if (st == null) throw new RuntimeException("Failed to created widget Switch");
    return new Switch(st);
  }
  public static Switch_Switch_Builder switch_(boolean value, Consumer<Boolean> onChanged) {
    return Switch_Switch_Builder.switch_Switch_(value, onChanged);
  }
  @Builder.Factory
  static Switch switch_Adaptive(@Builder.Parameter boolean value, @Builder.Parameter Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<IconI> thumbIcon, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> applyCupertinoTheme) {
    var st = factories.switch_Adaptive(value,
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
    if (st == null) throw new RuntimeException("Failed to created widget Switch");
    return new Switch(st);
  }
  public static Switch_AdaptiveBuilder adaptive(boolean value, Consumer<Boolean> onChanged) {
    return Switch_AdaptiveBuilder.switch_Adaptive(value, onChanged);
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_Value not supported on web");
    return intToBool(SwitchObjSt.value(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_ActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchObjSt.activeColor(st));
  }
  public Color activeThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_ActiveThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchObjSt.activeThumbColor(st));
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_ActiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchObjSt.activeTrackColor(st));
  }
  public Color inactiveThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_InactiveThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchObjSt.inactiveThumbColor(st));
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_InactiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchObjSt.inactiveTrackColor(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_MaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[SwitchObjSt.materialTapTargetSize(st)];
  }
  public boolean applyCupertinoTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_ApplyCupertinoTheme not supported on web");
    return intToBool(SwitchObjSt.applyCupertinoTheme(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_DragStartBehavior not supported on web");
    return DragStartBehavior.values()[SwitchObjSt.dragStartBehavior(st)];
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_FocusColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switch_HoverColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchObjSt.hoverColor(st));
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_SplashRadius not supported on web");
    return SwitchObjSt.splashRadius(st);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_Autofocus not supported on web");
    return intToBool(SwitchObjSt.autofocus(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switch_Padding not supported on web");
    return new EdgeInsetsGeometry(SwitchObjSt.padding(st)) {};
  }
  @Override
  public Switch build() {
    return this;
  }
}
