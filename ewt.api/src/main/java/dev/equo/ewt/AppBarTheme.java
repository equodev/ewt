package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AppBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AppBarTheme extends InheritedTheme implements AppBarThemeI {
  private MemorySegment st;
  protected AppBarTheme() {}
  AppBarTheme(MemorySegment st) {
    this.id = AppBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarTheme");
    System.out.println("New AppBarTheme id:"+id);
  }
  AppBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static AppBarTheme appBarThemeAppBarTheme(Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<Boolean> centerTitle, OptionalDouble titleSpacing, OptionalDouble leadingWidth, OptionalDouble toolbarHeight, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<WidgetI> child) {
    var st = factories.appBarThemeAppBarTheme(color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      elevation,
      scrolledUnderElevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      centerTitle,
      titleSpacing,
      leadingWidth,
      toolbarHeight,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      actionsPadding.map(EdgeInsetsGeometryI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget AppBarTheme");
    return new AppBarTheme(st);
  }
  public static AppBarThemeAppBarThemeBuilder appBarTheme() {
    return AppBarThemeAppBarThemeBuilder.appBarThemeAppBarTheme();
  }
  public static AppBarTheme lerp(AppBarThemeI a, AppBarThemeI b, double t) {
    var st = factories.appBarThemeLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget AppBarTheme");
    return new AppBarTheme(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeObjSt.backgroundColor(st));
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeObjSt.foregroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeElevation not supported on web");
    return AppBarThemeObjSt.elevation(st);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeScrolledUnderElevation not supported on web");
    return AppBarThemeObjSt.scrolledUnderElevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeShape not supported on web");
    return new ShapeBorder(AppBarThemeObjSt.shape(st)) {};
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeCenterTitle not supported on web");
    return intToBool(AppBarThemeObjSt.centerTitle(st));
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeTitleSpacing not supported on web");
    return AppBarThemeObjSt.titleSpacing(st);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeLeadingWidth not supported on web");
    return AppBarThemeObjSt.leadingWidth(st);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeToolbarHeight not supported on web");
    return AppBarThemeObjSt.toolbarHeight(st);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeToolbarTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AppBarThemeObjSt.toolbarTextStyle(st));
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AppBarThemeObjSt.titleTextStyle(st));
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeActionsPadding not supported on web");
    return new EdgeInsetsGeometry(AppBarThemeObjSt.actionsPadding(st)) {};
  }
  @Override
  public AppBarTheme build() {
    return this;
  }
}
