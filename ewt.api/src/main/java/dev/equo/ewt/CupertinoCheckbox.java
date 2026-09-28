package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoCheckbox extends StatefulWidget implements CupertinoCheckboxI {
  protected CupertinoCheckbox() {}
  CupertinoCheckbox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoCheckbox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoCheckbox cupertinoCheckboxCupertinoCheckbox(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<Boolean> autofocus, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<String> semanticLabel) {
    int id = factories.cupertinoCheckboxCupertinoCheckbox(value,
      tristate,
      onChanged,
      activeColor.map(ColorI::build),
      inactiveColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      autofocus,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      semanticLabel);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoCheckbox");
    return new CupertinoCheckbox(id);
  }
  public static CupertinoCheckboxCupertinoCheckboxBuilder cupertinoCheckbox() {
    return CupertinoCheckboxCupertinoCheckboxBuilder.cupertinoCheckboxCupertinoCheckbox();
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxValue not supported on web");
    return factories.CupertinoCheckbox_readBack_value(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxActiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoCheckbox_readBack_activeColor(nativeStruct);
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxInactiveColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoCheckbox_readBack_inactiveColor(nativeStruct);
  }
  public Color checkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxCheckColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoCheckbox_readBack_checkColor(nativeStruct);
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxTristate not supported on web");
    return factories.CupertinoCheckbox_readBack_tristate(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxFocusColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoCheckbox_readBack_focusColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxAutofocus not supported on web");
    return factories.CupertinoCheckbox_readBack_autofocus(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxSide", getId());
      return new BorderSide(__nid);
    }
    return factories.CupertinoCheckbox_readBack_side(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxShape not supported on web");
    return factories.CupertinoCheckbox_readBack_shape(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxSemanticLabel not supported on web");
    return factories.CupertinoCheckbox_readBack_semanticLabel(nativeStruct);
  }
  public static double width() {
    return 14.0;
  }
  @Override
  public CupertinoCheckbox build() {
    return this;
  }
}
