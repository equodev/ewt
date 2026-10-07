package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoButton extends StatefulWidget implements CupertinoButtonI {
  protected CupertinoButton() {}
  CupertinoButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoButton cupertinoButtonCupertinoButton(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> foregroundColor, Optional<ColorI> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    int id = factories.cupertinoButtonCupertinoButton(child.build(),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoButton");
    return new CupertinoButton(id);
  }
  public static CupertinoButtonCupertinoButtonBuilder cupertinoButton(WidgetI child) {
    return CupertinoButtonCupertinoButtonBuilder.cupertinoButtonCupertinoButton(child);
  }
  @Builder.Factory
  static CupertinoButton cupertinoButtonTinted(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> foregroundColor, Optional<ColorI> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    int id = factories.cupertinoButtonTinted(child.build(),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoButton");
    return new CupertinoButton(id);
  }
  public static CupertinoButtonTintedBuilder tinted(WidgetI child) {
    return CupertinoButtonTintedBuilder.cupertinoButtonTinted(child);
  }
  @Builder.Factory
  static CupertinoButton cupertinoButtonFilled(@Builder.Parameter WidgetI child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> disabledColor, Optional<ColorI> foregroundColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadiusI> borderRadius, Optional<AlignmentGeometryI> alignment, Optional<ColorI> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    int id = factories.cupertinoButtonFilled(child.build(),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoButton");
    return new CupertinoButton(id);
  }
  public static CupertinoButtonFilledBuilder filled(WidgetI child) {
    return CupertinoButtonFilledBuilder.cupertinoButtonFilled(child);
  }
  public static double tapMoveSlop() {
    var id = factories.cupertinoButtonTapMoveSlop();
    return id;
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonChild not supported on web");
    return factories.CupertinoButton_readBack_child(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonPadding not supported on web");
    return factories.CupertinoButton_readBack_padding(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoButton_readBack_color(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoButton_readBack_disabledColor(nativeStruct);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoButton_readBack_foregroundColor(nativeStruct);
  }
  public double minSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonMinSize not supported on web");
    return factories.CupertinoButton_readBack_minSize(nativeStruct);
  }
  public double pressedOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonPressedOpacity not supported on web");
    return factories.CupertinoButton_readBack_pressedOpacity(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.CupertinoButton_readBack_borderRadius(nativeStruct);
  }
  public CupertinoButtonSize sizeStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonSizeStyle not supported on web");
    return factories.CupertinoButton_readBack_sizeStyle(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonAlignment not supported on web");
    return factories.CupertinoButton_readBack_alignment(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoButtonFocusColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoButton_readBack_focusColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonAutofocus not supported on web");
    return factories.CupertinoButton_readBack_autofocus(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoButtonEnabled not supported on web");
    return factories.CupertinoButton_readBack_enabled(nativeStruct);
  }
  @Override
  public CupertinoButton build() {
    return this;
  }
}
