package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ToggleButtonsThemeData extends NativeObj.Base implements ToggleButtonsThemeDataI {
  protected ToggleButtonsThemeData() {}
  ToggleButtonsThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ToggleButtonsThemeData toggleButtonsThemeDataToggleButtonsThemeData(Optional<TextStyleI> textStyle, Optional<BoxConstraintsI> constraints, Optional<ColorI> color, Optional<ColorI> selectedColor, Optional<ColorI> disabledColor, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> highlightColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<ColorI> borderColor, Optional<ColorI> selectedBorderColor, Optional<ColorI> disabledBorderColor, Optional<BorderRadiusI> borderRadius, OptionalDouble borderWidth) {
    int id = factories.toggleButtonsThemeDataToggleButtonsThemeData(textStyle.map(TextStyleI::build),
      constraints.map(BoxConstraintsI::build),
      color.map(ColorI::build),
      selectedColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      borderColor.map(ColorI::build),
      selectedBorderColor.map(ColorI::build),
      disabledBorderColor.map(ColorI::build),
      borderRadius.map(BorderRadiusI::build),
      borderWidth);
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    return new ToggleButtonsThemeData(id);
  }
  public static ToggleButtonsThemeDataToggleButtonsThemeDataBuilder toggleButtonsThemeData() {
    return ToggleButtonsThemeDataToggleButtonsThemeDataBuilder.toggleButtonsThemeDataToggleButtonsThemeData();
  }
  public static ToggleButtonsThemeData lerp(ToggleButtonsThemeDataI a, ToggleButtonsThemeDataI b, double t) {
    int id = factories.toggleButtonsThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    return new ToggleButtonsThemeData(id);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_textStyle(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_constraints(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_color(nativeStruct);
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataSelectedColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_selectedColor(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_disabledColor(nativeStruct);
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataFillColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_fillColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataFocusColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_focusColor(nativeStruct);
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataHighlightColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_highlightColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataSplashColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_splashColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataHoverColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_hoverColor(nativeStruct);
  }
  public Color borderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataBorderColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_borderColor(nativeStruct);
  }
  public Color selectedBorderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataSelectedBorderColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_selectedBorderColor(nativeStruct);
  }
  public Color disabledBorderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataDisabledBorderColor", getId());
      return new Color(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_disabledBorderColor(nativeStruct);
  }
  public double borderWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("toggleButtonsThemeDataBorderWidth not supported on web");
    return factories.ToggleButtonsThemeData_readBack_borderWidth(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.ToggleButtonsThemeData_readBack_borderRadius(nativeStruct);
  }
  @Override
  public ToggleButtonsThemeData build() {
    return this;
  }
}
