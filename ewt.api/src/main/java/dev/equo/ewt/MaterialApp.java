package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MaterialApp extends StatefulWidget implements MaterialAppI {
  protected MaterialApp() {}
  MaterialApp(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialApp");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MaterialApp materialAppMaterialApp(Optional<WidgetI> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<ThemeDataI> theme, Optional<ThemeDataI> darkTheme, Optional<ThemeDataI> highContrastTheme, Optional<ThemeDataI> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<DurationI> themeAnimationDuration, Optional<CurveI> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = factories.materialAppMaterialApp(home.map(WidgetI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialApp");
    return new MaterialApp(id);
  }
  public static MaterialAppMaterialAppBuilder materialApp() {
    return MaterialAppMaterialAppBuilder.materialAppMaterialApp();
  }
  @Builder.Factory
  static MaterialApp materialAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<ThemeDataI> theme, Optional<ThemeDataI> darkTheme, Optional<ThemeDataI> highContrastTheme, Optional<ThemeDataI> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<DurationI> themeAnimationDuration, Optional<CurveI> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = factories.materialAppRouter(builder,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialApp");
    return new MaterialApp(id);
  }
  public static MaterialAppRouterBuilder router() {
    return MaterialAppRouterBuilder.materialAppRouter();
  }
  public Widget home() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppHome not supported on web");
    return factories.MaterialApp_readBack_home(nativeStruct);
  }
  public String initialRoute() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppInitialRoute not supported on web");
    return factories.MaterialApp_readBack_initialRoute(nativeStruct);
  }
  public String title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppTitle not supported on web");
    return factories.MaterialApp_readBack_title(nativeStruct);
  }
  public ThemeData theme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppTheme", getId());
      return new ThemeData(__nid);
    }
    return factories.MaterialApp_readBack_theme(nativeStruct);
  }
  public ThemeData darkTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppDarkTheme", getId());
      return new ThemeData(__nid);
    }
    return factories.MaterialApp_readBack_darkTheme(nativeStruct);
  }
  public ThemeData highContrastTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppHighContrastTheme", getId());
      return new ThemeData(__nid);
    }
    return factories.MaterialApp_readBack_highContrastTheme(nativeStruct);
  }
  public ThemeData highContrastDarkTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppHighContrastDarkTheme", getId());
      return new ThemeData(__nid);
    }
    return factories.MaterialApp_readBack_highContrastDarkTheme(nativeStruct);
  }
  public ThemeMode themeMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppThemeMode not supported on web");
    return factories.MaterialApp_readBack_themeMode(nativeStruct);
  }
  public Duration themeAnimationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppThemeAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.MaterialApp_readBack_themeAnimationDuration(nativeStruct);
  }
  public Curve themeAnimationCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppThemeAnimationCurve not supported on web");
    return factories.MaterialApp_readBack_themeAnimationCurve(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAppColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialApp_readBack_color(nativeStruct);
  }
  public boolean showPerformanceOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppShowPerformanceOverlay not supported on web");
    return factories.MaterialApp_readBack_showPerformanceOverlay(nativeStruct);
  }
  public boolean checkerboardRasterCacheImages() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppCheckerboardRasterCacheImages not supported on web");
    return factories.MaterialApp_readBack_checkerboardRasterCacheImages(nativeStruct);
  }
  public boolean checkerboardOffscreenLayers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppCheckerboardOffscreenLayers not supported on web");
    return factories.MaterialApp_readBack_checkerboardOffscreenLayers(nativeStruct);
  }
  public boolean showSemanticsDebugger() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppShowSemanticsDebugger not supported on web");
    return factories.MaterialApp_readBack_showSemanticsDebugger(nativeStruct);
  }
  public boolean debugShowCheckedModeBanner() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppDebugShowCheckedModeBanner not supported on web");
    return factories.MaterialApp_readBack_debugShowCheckedModeBanner(nativeStruct);
  }
  public String restorationScopeId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppRestorationScopeId not supported on web");
    return factories.MaterialApp_readBack_restorationScopeId(nativeStruct);
  }
  public boolean debugShowMaterialGrid() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppDebugShowMaterialGrid not supported on web");
    return factories.MaterialApp_readBack_debugShowMaterialGrid(nativeStruct);
  }
  public boolean useInheritedMediaQuery() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAppUseInheritedMediaQuery not supported on web");
    return factories.MaterialApp_readBack_useInheritedMediaQuery(nativeStruct);
  }
  @Override
  public MaterialApp build() {
    return this;
  }
}
