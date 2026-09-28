package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AppBarTheme extends InheritedTheme implements AppBarThemeI {
  protected AppBarTheme() {}
  AppBarTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AppBarTheme appBarThemeAppBarTheme(Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> centerTitle, OptionalDouble titleSpacing, OptionalDouble leadingWidth, OptionalDouble toolbarHeight, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<AppBarThemeDataI> data, Optional<WidgetI> child) {
    int id = factories.appBarThemeAppBarTheme(color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
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
      actionsPadding.map(EdgeInsetsGeometryI::build),
      data.map(AppBarThemeDataI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarTheme");
    return new AppBarTheme(id);
  }
  public static AppBarThemeAppBarThemeBuilder appBarTheme() {
    return AppBarThemeAppBarThemeBuilder.appBarThemeAppBarTheme();
  }
  public static AppBarThemeData of(BuildContextI context) {
    int id = factories.appBarThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarThemeData");
    return new AppBarThemeData(id);
  }
  public static AppBarTheme lerp(AppBarThemeI a, AppBarThemeI b, double t) {
    int id = factories.appBarThemeLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarTheme");
    return new AppBarTheme(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarTheme_readBack_backgroundColor(nativeStruct);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarTheme_readBack_foregroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeElevation not supported on web");
    return factories.AppBarTheme_readBack_elevation(nativeStruct);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeScrolledUnderElevation not supported on web");
    return factories.AppBarTheme_readBack_scrolledUnderElevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeShadowColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarTheme_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.AppBarTheme_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeShape not supported on web");
    return factories.AppBarTheme_readBack_shape(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.AppBarTheme_readBack_iconTheme(nativeStruct);
  }
  public IconThemeData actionsIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeActionsIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.AppBarTheme_readBack_actionsIconTheme(nativeStruct);
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeCenterTitle not supported on web");
    return factories.AppBarTheme_readBack_centerTitle(nativeStruct);
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeTitleSpacing not supported on web");
    return factories.AppBarTheme_readBack_titleSpacing(nativeStruct);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeLeadingWidth not supported on web");
    return factories.AppBarTheme_readBack_leadingWidth(nativeStruct);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeToolbarHeight not supported on web");
    return factories.AppBarTheme_readBack_toolbarHeight(nativeStruct);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeToolbarTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AppBarTheme_readBack_toolbarTextStyle(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AppBarTheme_readBack_titleTextStyle(nativeStruct);
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeActionsPadding not supported on web");
    return factories.AppBarTheme_readBack_actionsPadding(nativeStruct);
  }
  public AppBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeData", getId());
      return new AppBarThemeData(__nid);
    }
    return factories.AppBarTheme_readBack_data(nativeStruct);
  }
  @Override
  public AppBarTheme build() {
    return this;
  }
}
