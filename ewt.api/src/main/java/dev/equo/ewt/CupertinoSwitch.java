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
    return intToBool(CupertinoSwitchObjSt.value(st));
  }
  public Color activeTrackColor() {
    return new Color(CupertinoSwitchObjSt.activeTrackColor(st));
  }
  public Color inactiveTrackColor() {
    return new Color(CupertinoSwitchObjSt.inactiveTrackColor(st));
  }
  public Color thumbColor() {
    return new Color(CupertinoSwitchObjSt.thumbColor(st));
  }
  public Color inactiveThumbColor() {
    return new Color(CupertinoSwitchObjSt.inactiveThumbColor(st));
  }
  public Color focusColor() {
    return new Color(CupertinoSwitchObjSt.focusColor(st));
  }
  public Color onLabelColor() {
    return new Color(CupertinoSwitchObjSt.onLabelColor(st));
  }
  public Color offLabelColor() {
    return new Color(CupertinoSwitchObjSt.offLabelColor(st));
  }
  public boolean autofocus() {
    return intToBool(CupertinoSwitchObjSt.autofocus(st));
  }
  public boolean applyTheme() {
    return intToBool(CupertinoSwitchObjSt.applyTheme(st));
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[CupertinoSwitchObjSt.dragStartBehavior(st)];
  }
  public Color activeColor() {
    return new Color(CupertinoSwitchObjSt.activeColor(st));
  }
  public Color trackColor() {
    return new Color(CupertinoSwitchObjSt.trackColor(st));
  }
  @Override
  public CupertinoSwitch build() {
    return this;
  }
}
