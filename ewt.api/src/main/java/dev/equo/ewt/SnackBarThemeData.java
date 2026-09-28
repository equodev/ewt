package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SnackBarThemeData extends NativeObj.Base implements SnackBarThemeDataI {
  protected SnackBarThemeData() {}
  SnackBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SnackBarThemeData snackBarThemeDataSnackBarThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> actionTextColor, Optional<ColorI> disabledActionTextColor, Optional<TextStyleI> contentTextStyle, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<SnackBarBehavior> behavior, OptionalDouble width, Optional<EdgeInsetsI> insetPadding, Optional<Boolean> showCloseIcon, Optional<ColorI> closeIconColor, OptionalDouble actionOverflowThreshold, Optional<ColorI> actionBackgroundColor, Optional<ColorI> disabledActionBackgroundColor, Optional<DismissDirection> dismissDirection) {
    int id = factories.snackBarThemeDataSnackBarThemeData(backgroundColor.map(ColorI::build),
      actionTextColor.map(ColorI::build),
      disabledActionTextColor.map(ColorI::build),
      contentTextStyle.map(TextStyleI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      behavior,
      width,
      insetPadding.map(EdgeInsetsI::build),
      showCloseIcon,
      closeIconColor.map(ColorI::build),
      actionOverflowThreshold,
      actionBackgroundColor.map(ColorI::build),
      disabledActionBackgroundColor.map(ColorI::build),
      dismissDirection);
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    return new SnackBarThemeData(id);
  }
  public static SnackBarThemeDataSnackBarThemeDataBuilder snackBarThemeData() {
    return SnackBarThemeDataSnackBarThemeDataBuilder.snackBarThemeDataSnackBarThemeData();
  }
  public static SnackBarThemeData lerp(SnackBarThemeDataI a, SnackBarThemeDataI b, double t) {
    int id = factories.snackBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    return new SnackBarThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color actionTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataActionTextColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarThemeData_readBack_actionTextColor(nativeStruct);
  }
  public Color disabledActionTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataDisabledActionTextColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarThemeData_readBack_disabledActionTextColor(nativeStruct);
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataContentTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SnackBarThemeData_readBack_contentTextStyle(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataElevation not supported on web");
    return factories.SnackBarThemeData_readBack_elevation(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataShape not supported on web");
    return factories.SnackBarThemeData_readBack_shape(nativeStruct);
  }
  public SnackBarBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataBehavior not supported on web");
    return factories.SnackBarThemeData_readBack_behavior(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataWidth not supported on web");
    return factories.SnackBarThemeData_readBack_width(nativeStruct);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataInsetPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.SnackBarThemeData_readBack_insetPadding(nativeStruct);
  }
  public boolean showCloseIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataShowCloseIcon not supported on web");
    return factories.SnackBarThemeData_readBack_showCloseIcon(nativeStruct);
  }
  public Color closeIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataCloseIconColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarThemeData_readBack_closeIconColor(nativeStruct);
  }
  public double actionOverflowThreshold() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataActionOverflowThreshold not supported on web");
    return factories.SnackBarThemeData_readBack_actionOverflowThreshold(nativeStruct);
  }
  public Color actionBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataActionBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarThemeData_readBack_actionBackgroundColor(nativeStruct);
  }
  public Color disabledActionBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataDisabledActionBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarThemeData_readBack_disabledActionBackgroundColor(nativeStruct);
  }
  public DismissDirection dismissDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataDismissDirection not supported on web");
    return factories.SnackBarThemeData_readBack_dismissDirection(nativeStruct);
  }
  @Override
  public SnackBarThemeData build() {
    return this;
  }
}
