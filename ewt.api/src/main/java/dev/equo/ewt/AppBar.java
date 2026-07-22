package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AppBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AppBar extends StatefulWidget implements PreferredSizeWidget, AppBarI {
  private MemorySegment st;
  protected AppBar() {}
  AppBar(MemorySegment st) {
    this.id = AppBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBar");
    System.out.println("New AppBar id:"+id);
  }
  AppBar(int id) { this.id = id; }
  @Builder.Factory
  static AppBar appBarAppBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<Boolean> animateColor) {
    var st = factories.appBarAppBar(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      title.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
      flexibleSpace.map(WidgetI::build),
      bottom.map(PreferredSizeWidgetI::build),
      elevation,
      scrolledUnderElevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget AppBar");
    return new AppBar(st);
  }
  public static AppBarAppBarBuilder appBar() {
    return AppBarAppBarBuilder.appBarAppBar();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarLeading not supported on web");
    return new Widget(AppBarObjSt.leading(st)) {};
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarAutomaticallyImplyLeading not supported on web");
    return intToBool(AppBarObjSt.automaticallyImplyLeading(st));
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarTitle not supported on web");
    return new Widget(AppBarObjSt.title(st)) {};
  }
  public Widget flexibleSpace() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarFlexibleSpace not supported on web");
    return new Widget(AppBarObjSt.flexibleSpace(st)) {};
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarBottom not supported on web");
    return new PreferredSizeWidget() { public int getId() { return AppBarObjSt.bottom(st); } };
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarElevation not supported on web");
    return AppBarObjSt.elevation(st);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarScrolledUnderElevation not supported on web");
    return AppBarObjSt.scrolledUnderElevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarShape not supported on web");
    return new ShapeBorder(AppBarObjSt.shape(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarObjSt.backgroundColor(st));
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarObjSt.foregroundColor(st));
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarPrimary not supported on web");
    return intToBool(AppBarObjSt.primary(st));
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarCenterTitle not supported on web");
    return intToBool(AppBarObjSt.centerTitle(st));
  }
  public boolean excludeHeaderSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarExcludeHeaderSemantics not supported on web");
    return intToBool(AppBarObjSt.excludeHeaderSemantics(st));
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarTitleSpacing not supported on web");
    return AppBarObjSt.titleSpacing(st);
  }
  public double toolbarOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarToolbarOpacity not supported on web");
    return AppBarObjSt.toolbarOpacity(st);
  }
  public double bottomOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarBottomOpacity not supported on web");
    return AppBarObjSt.bottomOpacity(st);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarToolbarHeight not supported on web");
    return AppBarObjSt.toolbarHeight(st);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarLeadingWidth not supported on web");
    return AppBarObjSt.leadingWidth(st);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarToolbarTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AppBarObjSt.toolbarTextStyle(st));
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AppBarObjSt.titleTextStyle(st));
  }
  public boolean forceMaterialTransparency() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarForceMaterialTransparency not supported on web");
    return intToBool(AppBarObjSt.forceMaterialTransparency(st));
  }
  public boolean useDefaultSemanticsOrder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarUseDefaultSemanticsOrder not supported on web");
    return intToBool(AppBarObjSt.useDefaultSemanticsOrder(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarClipBehavior not supported on web");
    return Clip.values()[AppBarObjSt.clipBehavior(st)];
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarActionsPadding not supported on web");
    return new EdgeInsetsGeometry(AppBarObjSt.actionsPadding(st)) {};
  }
  public boolean animateColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarAnimateColor not supported on web");
    return intToBool(AppBarObjSt.animateColor(st));
  }
  @Override
  public AppBar build() {
    return this;
  }
}
