package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RawMaterialButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RawMaterialButton extends StatefulWidget implements RawMaterialButtonI {
  private MemorySegment st;
  protected RawMaterialButton() {}
  RawMaterialButton(MemorySegment st) {
    this.id = RawMaterialButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawMaterialButton");
    System.out.println("New RawMaterialButton id:"+id);
  }
  RawMaterialButton(int id) { this.id = id; }
  @Builder.Factory
  static RawMaterialButton rawMaterialButtonRawMaterialButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHighlightChanged, Optional<TextStyleI> textStyle, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<BoxConstraintsI> constraints, Optional<ShapeBorderI> shape, Optional<DurationI> animationDuration, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<WidgetI> child, Optional<Boolean> enableFeedback) {
    var st = factories.rawMaterialButtonRawMaterialButton(onPressed,
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
    if (st == null) throw new RuntimeException("Failed to created widget RawMaterialButton");
    return new RawMaterialButton(st);
  }
  public static RawMaterialButtonRawMaterialButtonBuilder rawMaterialButton() {
    return RawMaterialButtonRawMaterialButtonBuilder.rawMaterialButtonRawMaterialButton();
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(RawMaterialButtonObjSt.textStyle(st));
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonFillColor", getId());
      return new Color(__nid);
    }
    return new Color(RawMaterialButtonObjSt.fillColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(RawMaterialButtonObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(RawMaterialButtonObjSt.hoverColor(st));
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonHighlightColor", getId());
      return new Color(__nid);
    }
    return new Color(RawMaterialButtonObjSt.highlightColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(RawMaterialButtonObjSt.splashColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonElevation not supported on web");
    return RawMaterialButtonObjSt.elevation(st);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonHoverElevation not supported on web");
    return RawMaterialButtonObjSt.hoverElevation(st);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonFocusElevation not supported on web");
    return RawMaterialButtonObjSt.focusElevation(st);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonHighlightElevation not supported on web");
    return RawMaterialButtonObjSt.highlightElevation(st);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonDisabledElevation not supported on web");
    return RawMaterialButtonObjSt.disabledElevation(st);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonPadding not supported on web");
    return new EdgeInsetsGeometry(RawMaterialButtonObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(RawMaterialButtonObjSt.visualDensity(st));
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(RawMaterialButtonObjSt.constraints(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonShape not supported on web");
    return new ShapeBorder(RawMaterialButtonObjSt.shape(st)) {};
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMaterialButtonAnimationDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(RawMaterialButtonObjSt.animationDuration(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonChild not supported on web");
    return new Widget(RawMaterialButtonObjSt.child(st)) {};
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[RawMaterialButtonObjSt.materialTapTargetSize(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonAutofocus not supported on web");
    return intToBool(RawMaterialButtonObjSt.autofocus(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonClipBehavior not supported on web");
    return Clip.values()[RawMaterialButtonObjSt.clipBehavior(st)];
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonEnableFeedback not supported on web");
    return intToBool(RawMaterialButtonObjSt.enableFeedback(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMaterialButtonEnabled not supported on web");
    return intToBool(RawMaterialButtonObjSt.enabled(st));
  }
  @Override
  public RawMaterialButton build() {
    return this;
  }
}
