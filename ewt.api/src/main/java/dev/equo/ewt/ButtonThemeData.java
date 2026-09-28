package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ButtonThemeData extends NativeObj.Base implements ButtonThemeDataI {
  protected ButtonThemeData() {}
  ButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ButtonThemeData buttonThemeDataButtonThemeData(Optional<ButtonTextTheme> textTheme, OptionalDouble minWidth, OptionalDouble height, Optional<EdgeInsetsGeometryI> padding, Optional<ShapeBorderI> shape, Optional<ButtonBarLayoutBehavior> layoutBehavior, Optional<Boolean> alignedDropdown, Optional<ColorI> buttonColor, Optional<ColorI> disabledColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorSchemeI> colorScheme, Optional<MaterialTapTargetSize> materialTapTargetSize) {
    int id = factories.buttonThemeDataButtonThemeData(textTheme,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonThemeData");
    return new ButtonThemeData(id);
  }
  public static ButtonThemeDataButtonThemeDataBuilder buttonThemeData() {
    return ButtonThemeDataButtonThemeDataBuilder.buttonThemeDataButtonThemeData();
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataMinWidth not supported on web");
    return factories.ButtonThemeData_readBack_minWidth(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataHeight not supported on web");
    return factories.ButtonThemeData_readBack_height(nativeStruct);
  }
  public ButtonTextTheme textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataTextTheme not supported on web");
    return factories.ButtonThemeData_readBack_textTheme(nativeStruct);
  }
  public ButtonBarLayoutBehavior layoutBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataLayoutBehavior not supported on web");
    return factories.ButtonThemeData_readBack_layoutBehavior(nativeStruct);
  }
  public boolean alignedDropdown() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataAlignedDropdown not supported on web");
    return factories.ButtonThemeData_readBack_alignedDropdown(nativeStruct);
  }
  public ColorScheme colorScheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("buttonThemeDataColorScheme", getId());
      return new ColorScheme(__nid);
    }
    return factories.ButtonThemeData_readBack_colorScheme(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("buttonThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.ButtonThemeData_readBack_constraints(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataPadding not supported on web");
    return factories.ButtonThemeData_readBack_padding(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonThemeDataShape not supported on web");
    return factories.ButtonThemeData_readBack_shape(nativeStruct);
  }
  @Override
  public ButtonThemeData build() {
    return this;
  }
}
