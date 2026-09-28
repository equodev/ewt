package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RawMaterialButton extends StatefulWidget implements RawMaterialButtonI {
  protected RawMaterialButton() {}
  RawMaterialButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawMaterialButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RawMaterialButton rawMaterialButtonRawMaterialButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHighlightChanged, Optional<TextStyleI> textStyle, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<BoxConstraintsI> constraints, Optional<ShapeBorderI> shape, Optional<DurationI> animationDuration, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<WidgetI> child, Optional<Boolean> enableFeedback) {
    int id = factories.rawMaterialButtonRawMaterialButton(onPressed,
      onLongPress,
      onHighlightChanged,
      textStyle.map(TextStyleI::build),
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      padding.map(EdgeInsetsGeometryI::build),
      visualDensity.map(VisualDensityI::build),
      constraints.map(BoxConstraintsI::build),
      shape.map(ShapeBorderI::build),
      animationDuration.map(DurationI::build),
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      child.map(WidgetI::build),
      enableFeedback);
    if (id <= 0) throw new RuntimeException("Failed to created widget RawMaterialButton");
    return new RawMaterialButton(id);
  }
  public static RawMaterialButtonRawMaterialButtonBuilder rawMaterialButton() {
    return RawMaterialButtonRawMaterialButtonBuilder.rawMaterialButtonRawMaterialButton();
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.RawMaterialButton_readBack_textStyle(nativeStruct);
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonFillColor", getId());
      return new Color(__nid);
    }
    return factories.RawMaterialButton_readBack_fillColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonFocusColor", getId());
      return new Color(__nid);
    }
    return factories.RawMaterialButton_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonHoverColor", getId());
      return new Color(__nid);
    }
    return factories.RawMaterialButton_readBack_hoverColor(nativeStruct);
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonHighlightColor", getId());
      return new Color(__nid);
    }
    return factories.RawMaterialButton_readBack_highlightColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonSplashColor", getId());
      return new Color(__nid);
    }
    return factories.RawMaterialButton_readBack_splashColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonElevation not supported on web");
    return factories.RawMaterialButton_readBack_elevation(nativeStruct);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonHoverElevation not supported on web");
    return factories.RawMaterialButton_readBack_hoverElevation(nativeStruct);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonFocusElevation not supported on web");
    return factories.RawMaterialButton_readBack_focusElevation(nativeStruct);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonHighlightElevation not supported on web");
    return factories.RawMaterialButton_readBack_highlightElevation(nativeStruct);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonDisabledElevation not supported on web");
    return factories.RawMaterialButton_readBack_disabledElevation(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonPadding not supported on web");
    return factories.RawMaterialButton_readBack_padding(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.RawMaterialButton_readBack_visualDensity(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.RawMaterialButton_readBack_constraints(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonShape not supported on web");
    return factories.RawMaterialButton_readBack_shape(nativeStruct);
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.RawMaterialButton_readBack_animationDuration(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonChild not supported on web");
    return factories.RawMaterialButton_readBack_child(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonMaterialTapTargetSize not supported on web");
    return factories.RawMaterialButton_readBack_materialTapTargetSize(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonAutofocus not supported on web");
    return factories.RawMaterialButton_readBack_autofocus(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonClipBehavior not supported on web");
    return factories.RawMaterialButton_readBack_clipBehavior(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonEnableFeedback not supported on web");
    return factories.RawMaterialButton_readBack_enableFeedback(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonEnabled not supported on web");
    return factories.RawMaterialButton_readBack_enabled(nativeStruct);
  }
  @Override
  public RawMaterialButton build() {
    return this;
  }
}
