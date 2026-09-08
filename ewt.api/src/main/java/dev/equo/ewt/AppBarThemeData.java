package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AppBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AppBarThemeData extends NativeObj.Base implements AppBarThemeDataI {
  private MemorySegment st;
  protected AppBarThemeData() {}
  AppBarThemeData(MemorySegment st) {
    this.id = AppBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AppBarThemeData");
    System.out.println("New AppBarThemeData id:"+id);
  }
  AppBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static AppBarThemeData appBarThemeDataAppBarThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<ColorI> color, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> actionsIconTheme, Optional<Boolean> centerTitle, OptionalDouble titleSpacing, OptionalDouble leadingWidth, OptionalDouble toolbarHeight, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding) {
    var st = factories.appBarThemeDataAppBarThemeData(backgroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget AppBarThemeData");
    return new AppBarThemeData(st);
  }
  public static AppBarThemeDataAppBarThemeDataBuilder appBarThemeData() {
    return AppBarThemeDataAppBarThemeDataBuilder.appBarThemeDataAppBarThemeData();
  }
  public static AppBarThemeData lerp(AppBarThemeDataI a, AppBarThemeDataI b, double t) {
    var st = factories.appBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget AppBarThemeData");
    return new AppBarThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeDataObjSt.backgroundColor(st));
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeDataObjSt.foregroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataElevation not supported on web");
    return AppBarThemeDataObjSt.elevation(st);
  }
  public double scrolledUnderElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataScrolledUnderElevation not supported on web");
    return AppBarThemeDataObjSt.scrolledUnderElevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(AppBarThemeDataObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataShape not supported on web");
    return new ShapeBorder(AppBarThemeDataObjSt.shape(st)) {};
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(AppBarThemeDataObjSt.iconTheme(st));
  }
  public IconThemeData actionsIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataActionsIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(AppBarThemeDataObjSt.actionsIconTheme(st));
  }
  public boolean centerTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataCenterTitle not supported on web");
    return intToBool(AppBarThemeDataObjSt.centerTitle(st));
  }
  public double titleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataTitleSpacing not supported on web");
    return AppBarThemeDataObjSt.titleSpacing(st);
  }
  public double leadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataLeadingWidth not supported on web");
    return AppBarThemeDataObjSt.leadingWidth(st);
  }
  public double toolbarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataToolbarHeight not supported on web");
    return AppBarThemeDataObjSt.toolbarHeight(st);
  }
  public TextStyle toolbarTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataToolbarTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AppBarThemeDataObjSt.toolbarTextStyle(st));
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("appBarThemeDataTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AppBarThemeDataObjSt.titleTextStyle(st));
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("appBarThemeDataActionsPadding not supported on web");
    return new EdgeInsetsGeometry(AppBarThemeDataObjSt.actionsPadding(st)) {};
  }
  @Override
  public AppBarThemeData build() {
    return this;
  }
}
