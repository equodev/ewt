package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Checkbox extends StatefulWidget implements CheckboxI {
  protected Checkbox() {}
  Checkbox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Checkbox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Checkbox checkboxCheckbox(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    int id = factories.checkboxCheckbox(value,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Checkbox");
    return new Checkbox(id);
  }
  public static CheckboxCheckboxBuilder checkbox() {
    return CheckboxCheckboxBuilder.checkboxCheckbox();
  }
  @Builder.Factory
  static Checkbox checkboxAdaptive(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    int id = factories.checkboxAdaptive(value,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Checkbox");
    return new Checkbox(id);
  }
  public static CheckboxAdaptiveBuilder adaptive() {
    return CheckboxAdaptiveBuilder.checkboxAdaptive();
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxValue not supported on web");
    return factories.Checkbox_readBack_value(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxActiveColor", getId());
      return new Color(__nid);
    }
    return factories.Checkbox_readBack_activeColor(nativeStruct);
  }
  public Color checkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxCheckColor", getId());
      return new Color(__nid);
    }
    return factories.Checkbox_readBack_checkColor(nativeStruct);
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxTristate not supported on web");
    return factories.Checkbox_readBack_tristate(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMaterialTapTargetSize not supported on web");
    return factories.Checkbox_readBack_materialTapTargetSize(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.Checkbox_readBack_visualDensity(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxFocusColor", getId());
      return new Color(__nid);
    }
    return factories.Checkbox_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxHoverColor", getId());
      return new Color(__nid);
    }
    return factories.Checkbox_readBack_hoverColor(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxSplashRadius not supported on web");
    return factories.Checkbox_readBack_splashRadius(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxAutofocus not supported on web");
    return factories.Checkbox_readBack_autofocus(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxShape not supported on web");
    return factories.Checkbox_readBack_shape(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxSide", getId());
      return new BorderSide(__nid);
    }
    return factories.Checkbox_readBack_side(nativeStruct);
  }
  public boolean isError() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxIsError not supported on web");
    return factories.Checkbox_readBack_isError(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxSemanticLabel not supported on web");
    return factories.Checkbox_readBack_semanticLabel(nativeStruct);
  }
  public static double width() {
    return 18.0;
  }
  @Override
  public Checkbox build() {
    return this;
  }
}
