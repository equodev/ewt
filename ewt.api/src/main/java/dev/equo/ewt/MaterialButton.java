package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialButton extends StatelessWidget implements MaterialButtonI {
  private MemorySegment st;
  protected MaterialButton() {}
  MaterialButton(MemorySegment st) {
    this.id = MaterialButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialButton");
    System.out.println("New MaterialButton id:"+id);
  }
  MaterialButton(int id) { this.id = id; }
  @Builder.Factory
  static MaterialButton materialButtonMaterialButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHighlightChanged, Optional<ButtonTextTheme> textTheme, Optional<ColorI> textColor, Optional<ColorI> disabledTextColor, Optional<ColorI> color, Optional<ColorI> disabledColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<Brightness> colorBrightness, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DurationI> animationDuration, OptionalDouble minWidth, OptionalDouble height, Optional<Boolean> enableFeedback, Optional<WidgetI> child) {
    var st = factories.materialButtonMaterialButton(onPressed,
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
    if (st == null) throw new RuntimeException("Failed to created widget MaterialButton");
    return new MaterialButton(st);
  }
  public static MaterialButtonMaterialButtonBuilder materialButton() {
    return MaterialButtonMaterialButtonBuilder.materialButtonMaterialButton();
  }
  public ButtonTextTheme textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonTextTheme not supported on web");
    return ButtonTextTheme.values()[MaterialButtonObjSt.textTheme(st)];
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonTextColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.textColor(st));
  }
  public Color disabledTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonDisabledTextColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.disabledTextColor(st));
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.color(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.disabledColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.splashColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.hoverColor(st));
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonHighlightColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialButtonObjSt.highlightColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonElevation not supported on web");
    return MaterialButtonObjSt.elevation(st);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonHoverElevation not supported on web");
    return MaterialButtonObjSt.hoverElevation(st);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonFocusElevation not supported on web");
    return MaterialButtonObjSt.focusElevation(st);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonHighlightElevation not supported on web");
    return MaterialButtonObjSt.highlightElevation(st);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonDisabledElevation not supported on web");
    return MaterialButtonObjSt.disabledElevation(st);
  }
  public Brightness colorBrightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonColorBrightness not supported on web");
    return Brightness.values()[MaterialButtonObjSt.colorBrightness(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonChild not supported on web");
    return new Widget(MaterialButtonObjSt.child(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonPadding not supported on web");
    return new EdgeInsetsGeometry(MaterialButtonObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(MaterialButtonObjSt.visualDensity(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonShape not supported on web");
    return new ShapeBorder(MaterialButtonObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonClipBehavior not supported on web");
    return Clip.values()[MaterialButtonObjSt.clipBehavior(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonAutofocus not supported on web");
    return intToBool(MaterialButtonObjSt.autofocus(st));
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialButtonAnimationDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(MaterialButtonObjSt.animationDuration(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[MaterialButtonObjSt.materialTapTargetSize(st)];
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonMinWidth not supported on web");
    return MaterialButtonObjSt.minWidth(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonHeight not supported on web");
    return MaterialButtonObjSt.height(st);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonEnableFeedback not supported on web");
    return intToBool(MaterialButtonObjSt.enableFeedback(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialButtonEnabled not supported on web");
    return intToBool(MaterialButtonObjSt.enabled(st));
  }
  @Override
  public MaterialButton build() {
    return this;
  }
}
