package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialAppObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialApp extends StatefulWidget implements MaterialAppI {
  private MemorySegment st;
  protected MaterialApp() {}
  MaterialApp(MemorySegment st) {
    this.id = MaterialAppObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialApp");
    System.out.println("New MaterialApp id:"+id);
  }
  MaterialApp(int id) { this.id = id; }
  @Builder.Factory
  static MaterialApp materialAppMaterialApp(Optional<WidgetI> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<ThemeDataI> theme, Optional<ThemeDataI> darkTheme, Optional<ThemeDataI> highContrastTheme, Optional<ThemeDataI> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<DurationI> themeAnimationDuration, Optional<CurveI> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = factories.materialAppMaterialApp(home.map(WidgetI::build),
      initialRoute,
      builder,
      title,
      onGenerateTitle,
      color.map(ColorI::build),
      theme.map(ThemeDataI::build),
      darkTheme.map(ThemeDataI::build),
      highContrastTheme.map(ThemeDataI::build),
      highContrastDarkTheme.map(ThemeDataI::build),
      themeMode,
      themeAnimationDuration.map(DurationI::build),
      themeAnimationCurve.map(CurveI::build),
      debugShowMaterialGrid,
      showPerformanceOverlay,
      checkerboardRasterCacheImages,
      checkerboardOffscreenLayers,
      showSemanticsDebugger,
      debugShowCheckedModeBanner,
      restorationScopeId,
      useInheritedMediaQuery);
    if (st == null) throw new RuntimeException("Failed to created widget MaterialApp");
    return new MaterialApp(st);
  }
  public static MaterialAppMaterialAppBuilder materialApp() {
    return MaterialAppMaterialAppBuilder.materialAppMaterialApp();
  }
  @Builder.Factory
  static MaterialApp materialAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<ThemeDataI> theme, Optional<ThemeDataI> darkTheme, Optional<ThemeDataI> highContrastTheme, Optional<ThemeDataI> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<DurationI> themeAnimationDuration, Optional<CurveI> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = factories.materialAppRouter(builder,
      title,
      onGenerateTitle,
      color.map(ColorI::build),
      theme.map(ThemeDataI::build),
      darkTheme.map(ThemeDataI::build),
      highContrastTheme.map(ThemeDataI::build),
      highContrastDarkTheme.map(ThemeDataI::build),
      themeMode,
      themeAnimationDuration.map(DurationI::build),
      themeAnimationCurve.map(CurveI::build),
      debugShowMaterialGrid,
      showPerformanceOverlay,
      checkerboardRasterCacheImages,
      checkerboardOffscreenLayers,
      showSemanticsDebugger,
      debugShowCheckedModeBanner,
      restorationScopeId,
      useInheritedMediaQuery);
    if (st == null) throw new RuntimeException("Failed to created widget MaterialApp");
    return new MaterialApp(st);
  }
  public static MaterialAppRouterBuilder router() {
    return MaterialAppRouterBuilder.materialAppRouter();
  }
  public Widget home() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppHome not supported on web");
    return new Widget(MaterialAppObjSt.home(st)) {};
  }
  public String initialRoute() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppInitialRoute not supported on web");
    return MaterialAppObjSt.initialRoute(st).getString(0);
  }
  public String title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppTitle not supported on web");
    return MaterialAppObjSt.title(st).getString(0);
  }
  public ThemeData theme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ThemeDataObjSt.id(__st, __nid);
      return new ThemeData(__st);
    }
    return new ThemeData(MaterialAppObjSt.theme(st));
  }
  public ThemeData darkTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppDarkTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ThemeDataObjSt.id(__st, __nid);
      return new ThemeData(__st);
    }
    return new ThemeData(MaterialAppObjSt.darkTheme(st));
  }
  public ThemeData highContrastTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppHighContrastTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ThemeDataObjSt.id(__st, __nid);
      return new ThemeData(__st);
    }
    return new ThemeData(MaterialAppObjSt.highContrastTheme(st));
  }
  public ThemeData highContrastDarkTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppHighContrastDarkTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ThemeDataObjSt.id(__st, __nid);
      return new ThemeData(__st);
    }
    return new ThemeData(MaterialAppObjSt.highContrastDarkTheme(st));
  }
  public ThemeMode themeMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppThemeMode not supported on web");
    return ThemeMode.values()[MaterialAppObjSt.themeMode(st)];
  }
  public Duration themeAnimationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppThemeAnimationDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(MaterialAppObjSt.themeAnimationDuration(st));
  }
  public Curve themeAnimationCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppThemeAnimationCurve not supported on web");
    return new Curve(MaterialAppObjSt.themeAnimationCurve(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialAppObjSt.color(st));
  }
  public boolean showPerformanceOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppShowPerformanceOverlay not supported on web");
    return intToBool(MaterialAppObjSt.showPerformanceOverlay(st));
  }
  public boolean checkerboardRasterCacheImages() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppCheckerboardRasterCacheImages not supported on web");
    return intToBool(MaterialAppObjSt.checkerboardRasterCacheImages(st));
  }
  public boolean checkerboardOffscreenLayers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppCheckerboardOffscreenLayers not supported on web");
    return intToBool(MaterialAppObjSt.checkerboardOffscreenLayers(st));
  }
  public boolean showSemanticsDebugger() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppShowSemanticsDebugger not supported on web");
    return intToBool(MaterialAppObjSt.showSemanticsDebugger(st));
  }
  public boolean debugShowCheckedModeBanner() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppDebugShowCheckedModeBanner not supported on web");
    return intToBool(MaterialAppObjSt.debugShowCheckedModeBanner(st));
  }
  public String restorationScopeId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppRestorationScopeId not supported on web");
    return MaterialAppObjSt.restorationScopeId(st).getString(0);
  }
  public boolean debugShowMaterialGrid() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppDebugShowMaterialGrid not supported on web");
    return intToBool(MaterialAppObjSt.debugShowMaterialGrid(st));
  }
  public boolean useInheritedMediaQuery() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppUseInheritedMediaQuery not supported on web");
    return intToBool(MaterialAppObjSt.useInheritedMediaQuery(st));
  }
  @Override
  public MaterialApp build() {
    return this;
  }
}
