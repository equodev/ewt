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
  static CupertinoButton cupertinoButtonCupertinoButton(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> foregroundColor, Optional<ColorI> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
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
  static CupertinoButton cupertinoButtonTinted(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> foregroundColor, Optional<ColorI> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
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
  static CupertinoButton cupertinoButtonFilled(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> disabledColor, Optional<ColorI> foregroundColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonChild not supported on web");
    return new Widget(CupertinoButtonObjSt.child(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonPadding not supported on web");
    return new EdgeInsetsGeometry(CupertinoButtonObjSt.padding(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoButtonObjSt.color(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoButtonObjSt.disabledColor(st));
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoButtonObjSt.foregroundColor(st));
  }
  public double minSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonMinSize not supported on web");
    return CupertinoButtonObjSt.minSize(st);
  }
  public double pressedOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonPressedOpacity not supported on web");
    return CupertinoButtonObjSt.pressedOpacity(st);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(CupertinoButtonObjSt.borderRadius(st));
  }
  public CupertinoButtonSize sizeStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonSizeStyle not supported on web");
    return CupertinoButtonSize.values()[CupertinoButtonObjSt.sizeStyle(st)];
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonAlignment not supported on web");
    return new AlignmentGeometry(CupertinoButtonObjSt.alignment(st)) {};
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoButtonObjSt.focusColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonAutofocus not supported on web");
    return intToBool(CupertinoButtonObjSt.autofocus(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonEnabled not supported on web");
    return intToBool(CupertinoButtonObjSt.enabled(st));
  }
  @Override
  public CupertinoButton build() {
    return this;
  }
}
