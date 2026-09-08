package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ButtonThemeData extends NativeObj.Base implements ButtonThemeDataI {
  private MemorySegment st;
  protected ButtonThemeData() {}
  ButtonThemeData(MemorySegment st) {
    this.id = ButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonThemeData");
    System.out.println("New ButtonThemeData id:"+id);
  }
  ButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ButtonThemeData buttonThemeDataButtonThemeData(Optional<ButtonTextTheme> textTheme, OptionalDouble minWidth, OptionalDouble height, Optional<EdgeInsetsGeometryI> padding, Optional<ShapeBorderI> shape, Optional<ButtonBarLayoutBehavior> layoutBehavior, Optional<Boolean> alignedDropdown, Optional<ColorI> buttonColor, Optional<ColorI> disabledColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorSchemeI> colorScheme, Optional<MaterialTapTargetSize> materialTapTargetSize) {
    var st = factories.buttonThemeDataButtonThemeData(textTheme,
      minWidth,
      height,
      padding.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      layoutBehavior,
      alignedDropdown,
      buttonColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      colorScheme.map(ColorSchemeI::build),
      materialTapTargetSize);
    if (st == null) throw new RuntimeException("Failed to created widget ButtonThemeData");
    return new ButtonThemeData(st);
  }
  public static ButtonThemeDataButtonThemeDataBuilder buttonThemeData() {
    return ButtonThemeDataButtonThemeDataBuilder.buttonThemeDataButtonThemeData();
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataMinWidth not supported on web");
    return ButtonThemeDataObjSt.minWidth(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataHeight not supported on web");
    return ButtonThemeDataObjSt.height(st);
  }
  public ButtonTextTheme textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataTextTheme not supported on web");
    return ButtonTextTheme.values()[ButtonThemeDataObjSt.textTheme(st)];
  }
  public ButtonBarLayoutBehavior layoutBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataLayoutBehavior not supported on web");
    return ButtonBarLayoutBehavior.values()[ButtonThemeDataObjSt.layoutBehavior(st)];
  }
  public boolean alignedDropdown() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataAlignedDropdown not supported on web");
    return intToBool(ButtonThemeDataObjSt.alignedDropdown(st));
  }
  public ColorScheme colorScheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("buttonThemeDataColorScheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ColorSchemeObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ColorSchemeObjSt.id(__st, __nid);
      return new ColorScheme(__st);
    }
    return new ColorScheme(ButtonThemeDataObjSt.colorScheme(st));
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("buttonThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ButtonThemeDataObjSt.constraints(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(ButtonThemeDataObjSt.padding(st)) {};
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataShape not supported on web");
    return new ShapeBorder(ButtonThemeDataObjSt.shape(st)) {};
  }
  @Override
  public ButtonThemeData build() {
    return this;
  }
}
