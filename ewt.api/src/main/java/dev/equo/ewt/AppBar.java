package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AppBar extends StatefulWidget implements PreferredSizeWidget, AppBarI {
  protected AppBar() {}
  AppBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AppBar appBarAppBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<Boolean> automaticallyImplyActions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<Boolean> animateColor) {
    int id = factories.appBarAppBar(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      title.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      automaticallyImplyActions,
      flexibleSpace.map(WidgetI::build),
      bottom.map(PreferredSizeWidgetI::build),
      elevation,
      scrolledUnderElevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      iconTheme.map(IconThemeDataI::build),
      actionsIconTheme.map(IconThemeDataI::build),
      primary,
      centerTitle,
      excludeHeaderSemantics,
      titleSpacing,
      toolbarOpacity,
      bottomOpacity,
      toolbarHeight,
      leadingWidth,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      forceMaterialTransparency,
      useDefaultSemanticsOrder,
      clipBehavior,
      actionsPadding.map(EdgeInsetsGeometryI::build),
      animateColor);
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBar");
    return new AppBar(id);
  }
  public static AppBarAppBarBuilder appBar() {
    return AppBarAppBarBuilder.appBarAppBar();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarLeading not supported on web");
    return factories.AppBar_readBack_leading(nativeStruct);
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarAutomaticallyImplyLeading not supported on web");
    return factories.AppBar_readBack_automaticallyImplyLeading(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarTitle not supported on web");
    return factories.AppBar_readBack_title(nativeStruct);
  }
  public boolean automaticallyImplyActions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarAutomaticallyImplyActions not supported on web");
    return factories.AppBar_readBack_automaticallyImplyActions(nativeStruct);
  }
  public Widget flexibleSpace() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarFlexibleSpace not supported on web");
    return factories.AppBar_readBack_flexibleSpace(nativeStruct);
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarBottom not supported on web");
    return factories.AppBar_readBack_bottom(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarElevation not supported on web");
    return factories.AppBar_readBack_elevation(nativeStruct);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarScrolledUnderElevation not supported on web");
    return factories.AppBar_readBack_scrolledUnderElevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarShadowColor", getId());
      return new Color(__nid);
    }
    return factories.AppBar_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.AppBar_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarShape not supported on web");
    return factories.AppBar_readBack_shape(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.AppBar_readBack_backgroundColor(nativeStruct);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.AppBar_readBack_foregroundColor(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.AppBar_readBack_iconTheme(nativeStruct);
  }
  public IconThemeData actionsIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarActionsIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.AppBar_readBack_actionsIconTheme(nativeStruct);
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarPrimary not supported on web");
    return factories.AppBar_readBack_primary(nativeStruct);
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarCenterTitle not supported on web");
    return factories.AppBar_readBack_centerTitle(nativeStruct);
  }
  public boolean excludeHeaderSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarExcludeHeaderSemantics not supported on web");
    return factories.AppBar_readBack_excludeHeaderSemantics(nativeStruct);
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarTitleSpacing not supported on web");
    return factories.AppBar_readBack_titleSpacing(nativeStruct);
  }
  public double toolbarOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarToolbarOpacity not supported on web");
    return factories.AppBar_readBack_toolbarOpacity(nativeStruct);
  }
  public double bottomOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarBottomOpacity not supported on web");
    return factories.AppBar_readBack_bottomOpacity(nativeStruct);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarToolbarHeight not supported on web");
    return factories.AppBar_readBack_toolbarHeight(nativeStruct);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarLeadingWidth not supported on web");
    return factories.AppBar_readBack_leadingWidth(nativeStruct);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarToolbarTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AppBar_readBack_toolbarTextStyle(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AppBar_readBack_titleTextStyle(nativeStruct);
  }
  public boolean forceMaterialTransparency() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarForceMaterialTransparency not supported on web");
    return factories.AppBar_readBack_forceMaterialTransparency(nativeStruct);
  }
  public boolean useDefaultSemanticsOrder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarUseDefaultSemanticsOrder not supported on web");
    return factories.AppBar_readBack_useDefaultSemanticsOrder(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarClipBehavior not supported on web");
    return factories.AppBar_readBack_clipBehavior(nativeStruct);
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarActionsPadding not supported on web");
    return factories.AppBar_readBack_actionsPadding(nativeStruct);
  }
  public boolean animateColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarAnimateColor not supported on web");
    return factories.AppBar_readBack_animateColor(nativeStruct);
  }
  @Override
  public AppBar build() {
    return this;
  }
}
