package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FloatingActionButton extends StatelessWidget implements FloatingActionButtonI {
  protected FloatingActionButton() {}
  FloatingActionButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonFloatingActionButton(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<Boolean> mini, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonFloatingActionButton(child.map(WidgetI::build),
      tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      onPressed,
      mini,
      shape.map(ShapeBorderI::build),
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      isExtended,
      enableFeedback);
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonFloatingActionButtonBuilder floatingActionButton() {
    return FloatingActionButtonFloatingActionButtonBuilder.floatingActionButtonFloatingActionButton();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonSmall(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonSmall(child.map(WidgetI::build),
      tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      onPressed,
      shape.map(ShapeBorderI::build),
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      enableFeedback);
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonSmallBuilder small() {
    return FloatingActionButtonSmallBuilder.floatingActionButtonSmall();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonLarge(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonLarge(child.map(WidgetI::build),
      tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      onPressed,
      shape.map(ShapeBorderI::build),
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      enableFeedback);
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonLargeBuilder large() {
    return FloatingActionButtonLargeBuilder.floatingActionButtonLarge();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonExtended(Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<ColorI> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorderI> shape, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometryI> extendedPadding, Optional<TextStyleI> extendedTextStyle, Optional<WidgetI> icon, WidgetI label, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonExtended(tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
      elevation,
      focusElevation,
      hoverElevation,
      splashColor.map(ColorI::build),
      highlightElevation,
      disabledElevation,
      onPressed,
      shape.map(ShapeBorderI::build),
      isExtended,
      materialTapTargetSize,
      clipBehavior,
      autofocus,
      extendedIconLabelSpacing,
      extendedPadding.map(EdgeInsetsGeometryI::build),
      extendedTextStyle.map(TextStyleI::build),
      icon.map(WidgetI::build),
      label.build(),
      enableFeedback);
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonExtendedBuilder extended() {
    return FloatingActionButtonExtendedBuilder.floatingActionButtonExtended();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonChild not supported on web");
    return factories.FloatingActionButton_readBack_child(nativeStruct);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonTooltip not supported on web");
    return factories.FloatingActionButton_readBack_tooltip(nativeStruct);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButton_readBack_foregroundColor(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButton_readBack_backgroundColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonFocusColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButton_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonHoverColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButton_readBack_hoverColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonSplashColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButton_readBack_splashColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonElevation not supported on web");
    return factories.FloatingActionButton_readBack_elevation(nativeStruct);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonFocusElevation not supported on web");
    return factories.FloatingActionButton_readBack_focusElevation(nativeStruct);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonHoverElevation not supported on web");
    return factories.FloatingActionButton_readBack_hoverElevation(nativeStruct);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonHighlightElevation not supported on web");
    return factories.FloatingActionButton_readBack_highlightElevation(nativeStruct);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonDisabledElevation not supported on web");
    return factories.FloatingActionButton_readBack_disabledElevation(nativeStruct);
  }
  public boolean mini() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonMini not supported on web");
    return factories.FloatingActionButton_readBack_mini(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonShape not supported on web");
    return factories.FloatingActionButton_readBack_shape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonClipBehavior not supported on web");
    return factories.FloatingActionButton_readBack_clipBehavior(nativeStruct);
  }
  public boolean isExtended() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonIsExtended not supported on web");
    return factories.FloatingActionButton_readBack_isExtended(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonAutofocus not supported on web");
    return factories.FloatingActionButton_readBack_autofocus(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonMaterialTapTargetSize not supported on web");
    return factories.FloatingActionButton_readBack_materialTapTargetSize(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonEnableFeedback not supported on web");
    return factories.FloatingActionButton_readBack_enableFeedback(nativeStruct);
  }
  public double extendedIconLabelSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonExtendedIconLabelSpacing not supported on web");
    return factories.FloatingActionButton_readBack_extendedIconLabelSpacing(nativeStruct);
  }
  public EdgeInsetsGeometry extendedPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonExtendedPadding not supported on web");
    return factories.FloatingActionButton_readBack_extendedPadding(nativeStruct);
  }
  public TextStyle extendedTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonExtendedTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.FloatingActionButton_readBack_extendedTextStyle(nativeStruct);
  }
  @Override
  public FloatingActionButton build() {
    return this;
  }
}
