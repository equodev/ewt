package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverAppBar extends StatefulWidget implements SliverAppBarI {
  protected SliverAppBar() {}
  SliverAppBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAppBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverAppBar sliverAppBarSliverAppBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<Boolean> automaticallyImplyActions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<Boolean> forceElevated, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future<Void>>> onStretchTrigger, Optional<ShapeBorderI> shape, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding) {
    int id = factories.sliverAppBarSliverAppBar(leading.map(WidgetI::build),
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
      forceElevated,
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      iconTheme.map(IconThemeDataI::build),
      actionsIconTheme.map(IconThemeDataI::build),
      primary,
      centerTitle,
      excludeHeaderSemantics,
      titleSpacing,
      collapsedHeight,
      expandedHeight,
      floating,
      pinned,
      snap,
      stretch,
      stretchTriggerOffset,
      onStretchTrigger,
      shape.map(ShapeBorderI::build),
      toolbarHeight,
      leadingWidth,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      forceMaterialTransparency,
      useDefaultSemanticsOrder,
      clipBehavior,
      actionsPadding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAppBar");
    return new SliverAppBar(id);
  }
  public static SliverAppBarSliverAppBarBuilder sliverAppBar() {
    return SliverAppBarSliverAppBarBuilder.sliverAppBarSliverAppBar();
  }
  @Builder.Factory
  static SliverAppBar sliverAppBarMedium(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<Boolean> automaticallyImplyActions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<Boolean> forceElevated, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future<Void>>> onStretchTrigger, Optional<ShapeBorderI> shape, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding) {
    int id = factories.sliverAppBarMedium(leading.map(WidgetI::build),
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
      forceElevated,
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      iconTheme.map(IconThemeDataI::build),
      actionsIconTheme.map(IconThemeDataI::build),
      primary,
      centerTitle,
      excludeHeaderSemantics,
      titleSpacing,
      collapsedHeight,
      expandedHeight,
      floating,
      pinned,
      snap,
      stretch,
      stretchTriggerOffset,
      onStretchTrigger,
      shape.map(ShapeBorderI::build),
      leadingWidth,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      forceMaterialTransparency,
      useDefaultSemanticsOrder,
      clipBehavior,
      actionsPadding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAppBar");
    return new SliverAppBar(id);
  }
  public static SliverAppBarMediumBuilder medium() {
    return SliverAppBarMediumBuilder.sliverAppBarMedium();
  }
  @Builder.Factory
  static SliverAppBar sliverAppBarLarge(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<Boolean> automaticallyImplyActions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<Boolean> forceElevated, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future<Void>>> onStretchTrigger, Optional<ShapeBorderI> shape, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding) {
    int id = factories.sliverAppBarLarge(leading.map(WidgetI::build),
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
      forceElevated,
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      iconTheme.map(IconThemeDataI::build),
      actionsIconTheme.map(IconThemeDataI::build),
      primary,
      centerTitle,
      excludeHeaderSemantics,
      titleSpacing,
      collapsedHeight,
      expandedHeight,
      floating,
      pinned,
      snap,
      stretch,
      stretchTriggerOffset,
      onStretchTrigger,
      shape.map(ShapeBorderI::build),
      leadingWidth,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      forceMaterialTransparency,
      useDefaultSemanticsOrder,
      clipBehavior,
      actionsPadding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAppBar");
    return new SliverAppBar(id);
  }
  public static SliverAppBarLargeBuilder large() {
    return SliverAppBarLargeBuilder.sliverAppBarLarge();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarLeading not supported on web");
    return factories.SliverAppBar_readBack_leading(nativeStruct);
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarAutomaticallyImplyLeading not supported on web");
    return factories.SliverAppBar_readBack_automaticallyImplyLeading(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarTitle not supported on web");
    return factories.SliverAppBar_readBack_title(nativeStruct);
  }
  public boolean automaticallyImplyActions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarAutomaticallyImplyActions not supported on web");
    return factories.SliverAppBar_readBack_automaticallyImplyActions(nativeStruct);
  }
  public Widget flexibleSpace() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarFlexibleSpace not supported on web");
    return factories.SliverAppBar_readBack_flexibleSpace(nativeStruct);
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarBottom not supported on web");
    return factories.SliverAppBar_readBack_bottom(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarElevation not supported on web");
    return factories.SliverAppBar_readBack_elevation(nativeStruct);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarScrolledUnderElevation not supported on web");
    return factories.SliverAppBar_readBack_scrolledUnderElevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarShadowColor", getId());
      return new Color(__nid);
    }
    return factories.SliverAppBar_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.SliverAppBar_readBack_surfaceTintColor(nativeStruct);
  }
  public boolean forceElevated() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarForceElevated not supported on web");
    return factories.SliverAppBar_readBack_forceElevated(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SliverAppBar_readBack_backgroundColor(nativeStruct);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.SliverAppBar_readBack_foregroundColor(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.SliverAppBar_readBack_iconTheme(nativeStruct);
  }
  public IconThemeData actionsIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarActionsIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.SliverAppBar_readBack_actionsIconTheme(nativeStruct);
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarPrimary not supported on web");
    return factories.SliverAppBar_readBack_primary(nativeStruct);
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarCenterTitle not supported on web");
    return factories.SliverAppBar_readBack_centerTitle(nativeStruct);
  }
  public boolean excludeHeaderSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarExcludeHeaderSemantics not supported on web");
    return factories.SliverAppBar_readBack_excludeHeaderSemantics(nativeStruct);
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarTitleSpacing not supported on web");
    return factories.SliverAppBar_readBack_titleSpacing(nativeStruct);
  }
  public double collapsedHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarCollapsedHeight not supported on web");
    return factories.SliverAppBar_readBack_collapsedHeight(nativeStruct);
  }
  public double expandedHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarExpandedHeight not supported on web");
    return factories.SliverAppBar_readBack_expandedHeight(nativeStruct);
  }
  public boolean floating() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarFloating not supported on web");
    return factories.SliverAppBar_readBack_floating(nativeStruct);
  }
  public boolean pinned() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarPinned not supported on web");
    return factories.SliverAppBar_readBack_pinned(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarShape not supported on web");
    return factories.SliverAppBar_readBack_shape(nativeStruct);
  }
  public boolean snap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarSnap not supported on web");
    return factories.SliverAppBar_readBack_snap(nativeStruct);
  }
  public boolean stretch() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarStretch not supported on web");
    return factories.SliverAppBar_readBack_stretch(nativeStruct);
  }
  public double stretchTriggerOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarStretchTriggerOffset not supported on web");
    return factories.SliverAppBar_readBack_stretchTriggerOffset(nativeStruct);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarToolbarHeight not supported on web");
    return factories.SliverAppBar_readBack_toolbarHeight(nativeStruct);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarLeadingWidth not supported on web");
    return factories.SliverAppBar_readBack_leadingWidth(nativeStruct);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarToolbarTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SliverAppBar_readBack_toolbarTextStyle(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SliverAppBar_readBack_titleTextStyle(nativeStruct);
  }
  public boolean forceMaterialTransparency() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarForceMaterialTransparency not supported on web");
    return factories.SliverAppBar_readBack_forceMaterialTransparency(nativeStruct);
  }
  public boolean useDefaultSemanticsOrder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarUseDefaultSemanticsOrder not supported on web");
    return factories.SliverAppBar_readBack_useDefaultSemanticsOrder(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarClipBehavior not supported on web");
    return factories.SliverAppBar_readBack_clipBehavior(nativeStruct);
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarActionsPadding not supported on web");
    return factories.SliverAppBar_readBack_actionsPadding(nativeStruct);
  }
  @Override
  public SliverAppBar build() {
    return this;
  }
}
