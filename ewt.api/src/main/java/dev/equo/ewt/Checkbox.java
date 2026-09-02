package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckboxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Checkbox extends StatefulWidget implements CheckboxI {
  private MemorySegment st;
  protected Checkbox() {}
  Checkbox(MemorySegment st) {
    this.id = CheckboxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Checkbox");
    System.out.println("New Checkbox id:"+id);
  }
  Checkbox(int id) { this.id = id; }
  @Builder.Factory
  static Checkbox checkboxCheckbox(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    var st = factories.checkboxCheckbox(value,
      tristate,
      onChanged,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(OutlinedBorderI::build),
      side.map(BorderSideI::build),
      isError,
      semanticLabel);
    if (st == null) throw new RuntimeException("Failed to created widget Checkbox");
    return new Checkbox(st);
  }
  public static CheckboxCheckboxBuilder checkbox() {
    return CheckboxCheckboxBuilder.checkboxCheckbox();
  }
  @Builder.Factory
  static Checkbox checkboxAdaptive(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    var st = factories.checkboxAdaptive(value,
      tristate,
      onChanged,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(OutlinedBorderI::build),
      side.map(BorderSideI::build),
      isError,
      semanticLabel);
    if (st == null) throw new RuntimeException("Failed to created widget Checkbox");
    return new Checkbox(st);
  }
  public static CheckboxAdaptiveBuilder adaptive() {
    return CheckboxAdaptiveBuilder.checkboxAdaptive();
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxValue not supported on web");
    return intToBool(CheckboxObjSt.value(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxObjSt.activeColor(st));
  }
  public Color checkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxCheckColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxObjSt.checkColor(st));
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxTristate not supported on web");
    return intToBool(CheckboxObjSt.tristate(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[CheckboxObjSt.materialTapTargetSize(st)];
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(CheckboxObjSt.visualDensity(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxObjSt.hoverColor(st));
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxSplashRadius not supported on web");
    return CheckboxObjSt.splashRadius(st);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxAutofocus not supported on web");
    return intToBool(CheckboxObjSt.autofocus(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxShape not supported on web");
    return new OutlinedBorder(CheckboxObjSt.shape(st)) {};
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(CheckboxObjSt.side(st));
  }
  public boolean isError() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxIsError not supported on web");
    return intToBool(CheckboxObjSt.isError(st));
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxSemanticLabel not supported on web");
    return CheckboxObjSt.semanticLabel(st).getString(0);
  }
  public static double width() {
    return 18.0;
  }
  @Override
  public Checkbox build() {
    return this;
  }
}
