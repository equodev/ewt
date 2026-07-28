package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoButton extends StatefulWidget implements CupertinoButtonI {
  private MemorySegment st;
  protected CupertinoButton() {}
  CupertinoButton(MemorySegment st) {
    this.id = CupertinoButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoButton");
    System.out.println("New CupertinoButton id:"+id);
  }
  CupertinoButton(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoButton cupertinoButtonCupertinoButton(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> foregroundColor, Optional<ColorI> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Runnable onPressed) {
    var st = factories.cupertinoButtonCupertinoButton(child.build(),
      sizeStyle,
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      minSize,
      pressedOpacity,
      borderRadius.map(BorderRadiusI::build),
      alignment.map(AlignmentGeometryI::build),
      focusColor.map(ColorI::build),
      onFocusChange,
      autofocus,
      onLongPress,
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoButton");
    return new CupertinoButton(st);
  }
  public static CupertinoButtonCupertinoButtonBuilder cupertinoButton(WidgetI child) {
    return CupertinoButtonCupertinoButtonBuilder.cupertinoButtonCupertinoButton(child);
  }
  @Builder.Factory
  static CupertinoButton cupertinoButtonTinted(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> foregroundColor, Optional<ColorI> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Runnable onPressed) {
    var st = factories.cupertinoButtonTinted(child.build(),
      sizeStyle,
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      minSize,
      pressedOpacity,
      borderRadius.map(BorderRadiusI::build),
      alignment.map(AlignmentGeometryI::build),
      focusColor.map(ColorI::build),
      onFocusChange,
      autofocus,
      onLongPress,
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoButton");
    return new CupertinoButton(st);
  }
  public static CupertinoButtonTintedBuilder tinted(WidgetI child) {
    return CupertinoButtonTintedBuilder.cupertinoButtonTinted(child);
  }
  @Builder.Factory
  static CupertinoButton cupertinoButtonFilled(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> disabledColor, Optional<ColorI> foregroundColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Runnable onPressed) {
    var st = factories.cupertinoButtonFilled(child.build(),
      sizeStyle,
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      disabledColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      minSize,
      pressedOpacity,
      borderRadius.map(BorderRadiusI::build),
      alignment.map(AlignmentGeometryI::build),
      focusColor.map(ColorI::build),
      onFocusChange,
      autofocus,
      onLongPress,
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoButton");
    return new CupertinoButton(st);
  }
  public static CupertinoButtonFilledBuilder filled(WidgetI child) {
    return CupertinoButtonFilledBuilder.cupertinoButtonFilled(child);
  }
  public static double tapMoveSlop() {
    double id = factories.cupertinoButtonTapMoveSlop();
    System.out.println("New double id:"+id);
    return id;
  }
  public Widget child() {
    return new Widget(CupertinoButtonObjSt.child(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(CupertinoButtonObjSt.padding(st)) {};
  }
  public Color color() {
    return new Color(CupertinoButtonObjSt.color(st));
  }
  public Color disabledColor() {
    return new Color(CupertinoButtonObjSt.disabledColor(st));
  }
  public Color foregroundColor() {
    return new Color(CupertinoButtonObjSt.foregroundColor(st));
  }
  public double minSize() {
    return CupertinoButtonObjSt.minSize(st);
  }
  public double pressedOpacity() {
    return CupertinoButtonObjSt.pressedOpacity(st);
  }
  public BorderRadius borderRadius() {
    return new BorderRadius(CupertinoButtonObjSt.borderRadius(st));
  }
  public CupertinoButtonSize sizeStyle() {
    return CupertinoButtonSize.values()[CupertinoButtonObjSt.sizeStyle(st)];
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(CupertinoButtonObjSt.alignment(st)) {};
  }
  public Color focusColor() {
    return new Color(CupertinoButtonObjSt.focusColor(st));
  }
  public boolean autofocus() {
    return intToBool(CupertinoButtonObjSt.autofocus(st));
  }
  public boolean enabled() {
    return intToBool(CupertinoButtonObjSt.enabled(st));
  }
  @Override
  public CupertinoButton build() {
    return this;
  }
}
