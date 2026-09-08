package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ToggleButtonsThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ToggleButtonsThemeData extends NativeObj.Base implements ToggleButtonsThemeDataI {
  private MemorySegment st;
  protected ToggleButtonsThemeData() {}
  ToggleButtonsThemeData(MemorySegment st) {
    this.id = ToggleButtonsThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    System.out.println("New ToggleButtonsThemeData id:"+id);
  }
  ToggleButtonsThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ToggleButtonsThemeData toggleButtonsThemeDataToggleButtonsThemeData(Optional<TextStyleI> textStyle, Optional<BoxConstraintsI> constraints, Optional<ColorI> color, Optional<ColorI> selectedColor, Optional<ColorI> disabledColor, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> highlightColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<ColorI> borderColor, Optional<ColorI> selectedBorderColor, Optional<ColorI> disabledBorderColor, Optional<BorderRadiusI> borderRadius, OptionalDouble borderWidth) {
    var st = factories.toggleButtonsThemeDataToggleButtonsThemeData(textStyle.map(TextStyleI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    return new ToggleButtonsThemeData(st);
  }
  public static ToggleButtonsThemeDataToggleButtonsThemeDataBuilder toggleButtonsThemeData() {
    return ToggleButtonsThemeDataToggleButtonsThemeDataBuilder.toggleButtonsThemeDataToggleButtonsThemeData();
  }
  public static ToggleButtonsThemeData lerp(ToggleButtonsThemeDataI a, ToggleButtonsThemeDataI b, double t) {
    var st = factories.toggleButtonsThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    return new ToggleButtonsThemeData(st);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ToggleButtonsThemeDataObjSt.textStyle(st));
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ToggleButtonsThemeDataObjSt.constraints(st));
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.color(st));
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.selectedColor(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.disabledColor(st));
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataFillColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.fillColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.focusColor(st));
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataHighlightColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.highlightColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.splashColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.hoverColor(st));
  }
  public Color borderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataBorderColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.borderColor(st));
  }
  public Color selectedBorderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataSelectedBorderColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.selectedBorderColor(st));
  }
  public Color disabledBorderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataDisabledBorderColor", getId());
      return new Color(__nid);
    }
    return new Color(ToggleButtonsThemeDataObjSt.disabledBorderColor(st));
  }
  public double borderWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("toggleButtonsThemeDataBorderWidth not supported on web");
    return ToggleButtonsThemeDataObjSt.borderWidth(st);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeDataBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(ToggleButtonsThemeDataObjSt.borderRadius(st));
  }
  @Override
  public ToggleButtonsThemeData build() {
    return this;
  }
}
