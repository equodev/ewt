package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FloatingActionButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FloatingActionButton extends StatelessWidget implements FloatingActionButtonI {
  private MemorySegment st;
  protected FloatingActionButton() {}
  FloatingActionButton(MemorySegment st) {
    this.id = FloatingActionButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButton");
    System.out.println("New FloatingActionButton id:"+id);
  }
  FloatingActionButton(int id) { this.id = id; }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonFloatingActionButton(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> mini, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonFloatingActionButton(child.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonFloatingActionButtonBuilder floatingActionButton() {
    return FloatingActionButtonFloatingActionButtonBuilder.floatingActionButtonFloatingActionButton();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonSmall(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonSmall(child.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonSmallBuilder small() {
    return FloatingActionButtonSmallBuilder.floatingActionButtonSmall();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonLarge(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonLarge(child.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonLargeBuilder large() {
    return FloatingActionButtonLargeBuilder.floatingActionButtonLarge();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonExtended(Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<ColorI> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorderI> shape, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometryI> extendedPadding, Optional<TextStyleI> extendedTextStyle, Optional<WidgetI> icon, WidgetI label, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonExtended(tooltip,
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
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonExtendedBuilder extended() {
    return FloatingActionButtonExtendedBuilder.floatingActionButtonExtended();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonChild not supported on web");
    return new Widget(FloatingActionButtonObjSt.child(st)) {};
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonTooltip not supported on web");
    return FloatingActionButtonObjSt.tooltip(st).getString(0);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonObjSt.foregroundColor(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonObjSt.backgroundColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonObjSt.hoverColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonObjSt.splashColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonElevation not supported on web");
    return FloatingActionButtonObjSt.elevation(st);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonFocusElevation not supported on web");
    return FloatingActionButtonObjSt.focusElevation(st);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonHoverElevation not supported on web");
    return FloatingActionButtonObjSt.hoverElevation(st);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonHighlightElevation not supported on web");
    return FloatingActionButtonObjSt.highlightElevation(st);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonDisabledElevation not supported on web");
    return FloatingActionButtonObjSt.disabledElevation(st);
  }
  public boolean mini() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonMini not supported on web");
    return intToBool(FloatingActionButtonObjSt.mini(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonShape not supported on web");
    return new ShapeBorder(FloatingActionButtonObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonClipBehavior not supported on web");
    return Clip.values()[FloatingActionButtonObjSt.clipBehavior(st)];
  }
  public boolean isExtended() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonIsExtended not supported on web");
    return intToBool(FloatingActionButtonObjSt.isExtended(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonAutofocus not supported on web");
    return intToBool(FloatingActionButtonObjSt.autofocus(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[FloatingActionButtonObjSt.materialTapTargetSize(st)];
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonEnableFeedback not supported on web");
    return intToBool(FloatingActionButtonObjSt.enableFeedback(st));
  }
  public double extendedIconLabelSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonExtendedIconLabelSpacing not supported on web");
    return FloatingActionButtonObjSt.extendedIconLabelSpacing(st);
  }
  public EdgeInsetsGeometry extendedPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonExtendedPadding not supported on web");
    return new EdgeInsetsGeometry(FloatingActionButtonObjSt.extendedPadding(st)) {};
  }
  public TextStyle extendedTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonExtendedTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(FloatingActionButtonObjSt.extendedTextStyle(st));
  }
  @Override
  public FloatingActionButton build() {
    return this;
  }
}
