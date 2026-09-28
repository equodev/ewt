package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PopupMenuThemeData extends NativeObj.Base implements PopupMenuThemeDataI {
  protected PopupMenuThemeData() {}
  PopupMenuThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PopupMenuThemeData popupMenuThemeDataPopupMenuThemeData(Optional<ColorI> color, Optional<ShapeBorderI> shape, Optional<EdgeInsetsGeometryI> menuPadding, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<TextStyleI> textStyle, Optional<TextStyleI> labelTextStyle, Optional<Boolean> enableFeedback, Optional<PopupMenuPosition> position, Optional<ColorI> iconColor, OptionalDouble iconSize) {
    int id = factories.popupMenuThemeDataPopupMenuThemeData(color.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      menuPadding.map(EdgeInsetsGeometryI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      textStyle.map(TextStyleI::build),
      labelTextStyle.map(TextStyleI::build),
      enableFeedback,
      position,
      iconColor.map(ColorI::build),
      iconSize);
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    return new PopupMenuThemeData(id);
  }
  public static PopupMenuThemeDataPopupMenuThemeDataBuilder popupMenuThemeData() {
    return PopupMenuThemeDataPopupMenuThemeDataBuilder.popupMenuThemeDataPopupMenuThemeData();
  }
  public static PopupMenuThemeData lerp(PopupMenuThemeDataI a, PopupMenuThemeDataI b, double t) {
    int id = factories.popupMenuThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    return new PopupMenuThemeData(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuThemeData_readBack_color(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataShape not supported on web");
    return factories.PopupMenuThemeData_readBack_shape(nativeStruct);
  }
  public EdgeInsetsGeometry menuPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataMenuPadding not supported on web");
    return factories.PopupMenuThemeData_readBack_menuPadding(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataElevation not supported on web");
    return factories.PopupMenuThemeData_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.PopupMenuThemeData_readBack_textStyle(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataEnableFeedback not supported on web");
    return factories.PopupMenuThemeData_readBack_enableFeedback(nativeStruct);
  }
  public PopupMenuPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataPosition not supported on web");
    return factories.PopupMenuThemeData_readBack_position(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataIconColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuThemeData_readBack_iconColor(nativeStruct);
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataIconSize not supported on web");
    return factories.PopupMenuThemeData_readBack_iconSize(nativeStruct);
  }
  @Override
  public PopupMenuThemeData build() {
    return this;
  }
}
