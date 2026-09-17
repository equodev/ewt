package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverAppBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverAppBar extends StatefulWidget implements SliverAppBarI {
  private MemorySegment st;
  protected SliverAppBar() {}
  SliverAppBar(MemorySegment st) {
    this.id = SliverAppBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverAppBar");
    System.out.println("New SliverAppBar id:"+id);
  }
  SliverAppBar(int id) { this.id = id; }
  @Builder.Factory
  static SliverAppBar sliverAppBarSliverAppBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<Boolean> forceElevated, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future>> onStretchTrigger, Optional<ShapeBorderI> shape, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding) {
    var st = factories.sliverAppBarSliverAppBar(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      title.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
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
    if (st == null) throw new RuntimeException("Failed to created widget SliverAppBar");
    return new SliverAppBar(st);
  }
  public static SliverAppBarSliverAppBarBuilder sliverAppBar() {
    return SliverAppBarSliverAppBarBuilder.sliverAppBarSliverAppBar();
  }
  @Builder.Factory
  static SliverAppBar sliverAppBarMedium(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<Boolean> forceElevated, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future>> onStretchTrigger, Optional<ShapeBorderI> shape, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding) {
    var st = factories.sliverAppBarMedium(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      title.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
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
    if (st == null) throw new RuntimeException("Failed to created widget SliverAppBar");
    return new SliverAppBar(st);
  }
  public static SliverAppBarMediumBuilder medium() {
    return SliverAppBarMediumBuilder.sliverAppBarMedium();
  }
  @Builder.Factory
  static SliverAppBar sliverAppBarLarge(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<Boolean> forceElevated, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future>> onStretchTrigger, Optional<ShapeBorderI> shape, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding) {
    var st = factories.sliverAppBarLarge(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      title.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
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
    if (st == null) throw new RuntimeException("Failed to created widget SliverAppBar");
    return new SliverAppBar(st);
  }
  public static SliverAppBarLargeBuilder large() {
    return SliverAppBarLargeBuilder.sliverAppBarLarge();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarLeading not supported on web");
    return new Widget(SliverAppBarObjSt.leading(st)) {};
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarAutomaticallyImplyLeading not supported on web");
    return intToBool(SliverAppBarObjSt.automaticallyImplyLeading(st));
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarTitle not supported on web");
    return new Widget(SliverAppBarObjSt.title(st)) {};
  }
  public Widget flexibleSpace() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarFlexibleSpace not supported on web");
    return new Widget(SliverAppBarObjSt.flexibleSpace(st)) {};
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarBottom not supported on web");
    return new PreferredSizeWidget() { public int getId() { return SliverAppBarObjSt.bottom(st); } };
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarElevation not supported on web");
    return SliverAppBarObjSt.elevation(st);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarScrolledUnderElevation not supported on web");
    return SliverAppBarObjSt.scrolledUnderElevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(SliverAppBarObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(SliverAppBarObjSt.surfaceTintColor(st));
  }
  public boolean forceElevated() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarForceElevated not supported on web");
    return intToBool(SliverAppBarObjSt.forceElevated(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SliverAppBarObjSt.backgroundColor(st));
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SliverAppBarObjSt.foregroundColor(st));
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(SliverAppBarObjSt.iconTheme(st));
  }
  public IconThemeData actionsIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarActionsIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(SliverAppBarObjSt.actionsIconTheme(st));
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarPrimary not supported on web");
    return intToBool(SliverAppBarObjSt.primary(st));
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarCenterTitle not supported on web");
    return intToBool(SliverAppBarObjSt.centerTitle(st));
  }
  public boolean excludeHeaderSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarExcludeHeaderSemantics not supported on web");
    return intToBool(SliverAppBarObjSt.excludeHeaderSemantics(st));
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarTitleSpacing not supported on web");
    return SliverAppBarObjSt.titleSpacing(st);
  }
  public double collapsedHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarCollapsedHeight not supported on web");
    return SliverAppBarObjSt.collapsedHeight(st);
  }
  public double expandedHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarExpandedHeight not supported on web");
    return SliverAppBarObjSt.expandedHeight(st);
  }
  public boolean floating() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarFloating not supported on web");
    return intToBool(SliverAppBarObjSt.floating(st));
  }
  public boolean pinned() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarPinned not supported on web");
    return intToBool(SliverAppBarObjSt.pinned(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarShape not supported on web");
    return new ShapeBorder(SliverAppBarObjSt.shape(st)) {};
  }
  public boolean snap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarSnap not supported on web");
    return intToBool(SliverAppBarObjSt.snap(st));
  }
  public boolean stretch() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarStretch not supported on web");
    return intToBool(SliverAppBarObjSt.stretch(st));
  }
  public double stretchTriggerOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarStretchTriggerOffset not supported on web");
    return SliverAppBarObjSt.stretchTriggerOffset(st);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarToolbarHeight not supported on web");
    return SliverAppBarObjSt.toolbarHeight(st);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarLeadingWidth not supported on web");
    return SliverAppBarObjSt.leadingWidth(st);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarToolbarTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SliverAppBarObjSt.toolbarTextStyle(st));
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliverAppBarTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SliverAppBarObjSt.titleTextStyle(st));
  }
  public boolean forceMaterialTransparency() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarForceMaterialTransparency not supported on web");
    return intToBool(SliverAppBarObjSt.forceMaterialTransparency(st));
  }
  public boolean useDefaultSemanticsOrder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarUseDefaultSemanticsOrder not supported on web");
    return intToBool(SliverAppBarObjSt.useDefaultSemanticsOrder(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarClipBehavior not supported on web");
    return Clip.values()[SliverAppBarObjSt.clipBehavior(st)];
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverAppBarActionsPadding not supported on web");
    return new EdgeInsetsGeometry(SliverAppBarObjSt.actionsPadding(st)) {};
  }
  @Override
  public SliverAppBar build() {
    return this;
  }
}
