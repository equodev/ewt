package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MaterialButton extends StatelessWidget implements MaterialButtonI {
  protected MaterialButton() {}
  MaterialButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MaterialButton materialButtonMaterialButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHighlightChanged, Optional<ButtonTextTheme> textTheme, Optional<ColorI> textColor, Optional<ColorI> disabledTextColor, Optional<ColorI> color, Optional<ColorI> disabledColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<Brightness> colorBrightness, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DurationI> animationDuration, OptionalDouble minWidth, OptionalDouble height, Optional<Boolean> enableFeedback, Optional<WidgetI> child) {
    int id = factories.materialButtonMaterialButton(onPressed,
      onLongPress,
      onHighlightChanged,
      textTheme,
      textColor.map(ColorI::build),
      disabledTextColor.map(ColorI::build),
      color.map(ColorI::build),
      disabledColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      colorBrightness,
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      padding.map(EdgeInsetsGeometryI::build),
      visualDensity.map(VisualDensityI::build),
      shape.map(ShapeBorderI::build),
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      animationDuration.map(DurationI::build),
      minWidth,
      height,
      enableFeedback,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialButton");
    return new MaterialButton(id);
  }
  public static MaterialButtonMaterialButtonBuilder materialButton() {
    return MaterialButtonMaterialButtonBuilder.materialButtonMaterialButton();
  }
  public ButtonTextTheme textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonTextTheme not supported on web");
    return factories.MaterialButton_readBack_textTheme(nativeStruct);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonTextColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_textColor(nativeStruct);
  }
  public Color disabledTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonDisabledTextColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_disabledTextColor(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_color(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_disabledColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonSplashColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_splashColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonFocusColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonHoverColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_hoverColor(nativeStruct);
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonHighlightColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialButton_readBack_highlightColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonElevation not supported on web");
    return factories.MaterialButton_readBack_elevation(nativeStruct);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonHoverElevation not supported on web");
    return factories.MaterialButton_readBack_hoverElevation(nativeStruct);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonFocusElevation not supported on web");
    return factories.MaterialButton_readBack_focusElevation(nativeStruct);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonHighlightElevation not supported on web");
    return factories.MaterialButton_readBack_highlightElevation(nativeStruct);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonDisabledElevation not supported on web");
    return factories.MaterialButton_readBack_disabledElevation(nativeStruct);
  }
  public Brightness colorBrightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonColorBrightness not supported on web");
    return factories.MaterialButton_readBack_colorBrightness(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonChild not supported on web");
    return factories.MaterialButton_readBack_child(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonPadding not supported on web");
    return factories.MaterialButton_readBack_padding(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.MaterialButton_readBack_visualDensity(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonShape not supported on web");
    return factories.MaterialButton_readBack_shape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonClipBehavior not supported on web");
    return factories.MaterialButton_readBack_clipBehavior(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonAutofocus not supported on web");
    return factories.MaterialButton_readBack_autofocus(nativeStruct);
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.MaterialButton_readBack_animationDuration(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonMaterialTapTargetSize not supported on web");
    return factories.MaterialButton_readBack_materialTapTargetSize(nativeStruct);
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonMinWidth not supported on web");
    return factories.MaterialButton_readBack_minWidth(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonHeight not supported on web");
    return factories.MaterialButton_readBack_height(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonEnableFeedback not supported on web");
    return factories.MaterialButton_readBack_enableFeedback(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonEnabled not supported on web");
    return factories.MaterialButton_readBack_enabled(nativeStruct);
  }
  @Override
  public MaterialButton build() {
    return this;
  }
}
