package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AppBarThemeData extends NativeObj.Base implements AppBarThemeDataI {
  protected AppBarThemeData() {}
  AppBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AppBarThemeData appBarThemeDataAppBarThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<ColorI> color, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> centerTitle, OptionalDouble titleSpacing, OptionalDouble leadingWidth, OptionalDouble toolbarHeight, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding) {
    int id = factories.appBarThemeDataAppBarThemeData(backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      color.map(ColorI::build),
      elevation,
      scrolledUnderElevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      iconTheme.map(IconThemeDataI::build),
      actionsIconTheme.map(IconThemeDataI::build),
      centerTitle,
      titleSpacing,
      leadingWidth,
      toolbarHeight,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      actionsPadding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarThemeData");
    return new AppBarThemeData(id);
  }
  public static AppBarThemeDataAppBarThemeDataBuilder appBarThemeData() {
    return AppBarThemeDataAppBarThemeDataBuilder.appBarThemeDataAppBarThemeData();
  }
  public static AppBarThemeData lerp(AppBarThemeDataI a, AppBarThemeDataI b, double t) {
    int id = factories.appBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarThemeData");
    return new AppBarThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarThemeData_readBack_foregroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataElevation not supported on web");
    return factories.AppBarThemeData_readBack_elevation(nativeStruct);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataScrolledUnderElevation not supported on web");
    return factories.AppBarThemeData_readBack_scrolledUnderElevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataShape not supported on web");
    return factories.AppBarThemeData_readBack_shape(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.AppBarThemeData_readBack_iconTheme(nativeStruct);
  }
  public IconThemeData actionsIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataActionsIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.AppBarThemeData_readBack_actionsIconTheme(nativeStruct);
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataCenterTitle not supported on web");
    return factories.AppBarThemeData_readBack_centerTitle(nativeStruct);
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataTitleSpacing not supported on web");
    return factories.AppBarThemeData_readBack_titleSpacing(nativeStruct);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataLeadingWidth not supported on web");
    return factories.AppBarThemeData_readBack_leadingWidth(nativeStruct);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataToolbarHeight not supported on web");
    return factories.AppBarThemeData_readBack_toolbarHeight(nativeStruct);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataToolbarTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AppBarThemeData_readBack_toolbarTextStyle(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AppBarThemeData_readBack_titleTextStyle(nativeStruct);
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataActionsPadding not supported on web");
    return factories.AppBarThemeData_readBack_actionsPadding(nativeStruct);
  }
  @Override
  public AppBarThemeData build() {
    return this;
  }
}
