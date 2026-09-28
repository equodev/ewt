package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FloatingActionButtonThemeData extends NativeObj.Base implements FloatingActionButtonThemeDataI {
  protected FloatingActionButtonThemeData() {}
  FloatingActionButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FloatingActionButtonThemeData floatingActionButtonThemeDataFloatingActionButtonThemeData(Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble disabledElevation, OptionalDouble highlightElevation, Optional<ShapeBorderI> shape, Optional<Boolean> enableFeedback, OptionalDouble iconSize, Optional<BoxConstraintsI> sizeConstraints, Optional<BoxConstraintsI> smallSizeConstraints, Optional<BoxConstraintsI> largeSizeConstraints, Optional<BoxConstraintsI> extendedSizeConstraints, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometryI> extendedPadding, Optional<TextStyleI> extendedTextStyle) {
    int id = factories.floatingActionButtonThemeDataFloatingActionButtonThemeData(foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      elevation,
      focusElevation,
      hoverElevation,
      disabledElevation,
      highlightElevation,
      shape.map(ShapeBorderI::build),
      enableFeedback,
      iconSize,
      sizeConstraints.map(BoxConstraintsI::build),
      smallSizeConstraints.map(BoxConstraintsI::build),
      largeSizeConstraints.map(BoxConstraintsI::build),
      extendedSizeConstraints.map(BoxConstraintsI::build),
      extendedIconLabelSpacing,
      extendedPadding.map(EdgeInsetsGeometryI::build),
      extendedTextStyle.map(TextStyleI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    return new FloatingActionButtonThemeData(id);
  }
  public static FloatingActionButtonThemeDataFloatingActionButtonThemeDataBuilder floatingActionButtonThemeData() {
    return FloatingActionButtonThemeDataFloatingActionButtonThemeDataBuilder.floatingActionButtonThemeDataFloatingActionButtonThemeData();
  }
  public static FloatingActionButtonThemeData lerp(FloatingActionButtonThemeDataI a, FloatingActionButtonThemeDataI b, double t) {
    int id = factories.floatingActionButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    return new FloatingActionButtonThemeData(id);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_foregroundColor(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataFocusColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataHoverColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_hoverColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataSplashColor", getId());
      return new Color(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_splashColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataElevation not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_elevation(nativeStruct);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataFocusElevation not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_focusElevation(nativeStruct);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataHoverElevation not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_hoverElevation(nativeStruct);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataDisabledElevation not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_disabledElevation(nativeStruct);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataHighlightElevation not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_highlightElevation(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataShape not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_shape(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataEnableFeedback not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_enableFeedback(nativeStruct);
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataIconSize not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_iconSize(nativeStruct);
  }
  public BoxConstraints sizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataSizeConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_sizeConstraints(nativeStruct);
  }
  public BoxConstraints smallSizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataSmallSizeConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_smallSizeConstraints(nativeStruct);
  }
  public BoxConstraints largeSizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataLargeSizeConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_largeSizeConstraints(nativeStruct);
  }
  public BoxConstraints extendedSizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataExtendedSizeConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_extendedSizeConstraints(nativeStruct);
  }
  public double extendedIconLabelSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataExtendedIconLabelSpacing not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_extendedIconLabelSpacing(nativeStruct);
  }
  public EdgeInsetsGeometry extendedPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataExtendedPadding not supported on web");
    return factories.FloatingActionButtonThemeData_readBack_extendedPadding(nativeStruct);
  }
  public TextStyle extendedTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataExtendedTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.FloatingActionButtonThemeData_readBack_extendedTextStyle(nativeStruct);
  }
  @Override
  public FloatingActionButtonThemeData build() {
    return this;
  }
}
