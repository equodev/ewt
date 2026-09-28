package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoApp extends StatefulWidget implements CupertinoAppI {
  protected CupertinoApp() {}
  CupertinoApp(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoApp");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoApp cupertinoAppCupertinoApp(Optional<WidgetI> home, Optional<CupertinoThemeDataI> theme, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = factories.cupertinoAppCupertinoApp(home.map(WidgetI::build),
      theme.map(CupertinoThemeDataI::build),
      initialRoute,
      builder,
      title,
      onGenerateTitle,
      color.map(ColorI::build),
      showPerformanceOverlay,
      checkerboardRasterCacheImages,
      checkerboardOffscreenLayers,
      showSemanticsDebugger,
      debugShowCheckedModeBanner,
      restorationScopeId,
      useInheritedMediaQuery);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoApp");
    return new CupertinoApp(id);
  }
  public static CupertinoAppCupertinoAppBuilder cupertinoApp() {
    return CupertinoAppCupertinoAppBuilder.cupertinoAppCupertinoApp();
  }
  @Builder.Factory
  static CupertinoApp cupertinoAppRouter(Optional<CupertinoThemeDataI> theme, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = factories.cupertinoAppRouter(theme.map(CupertinoThemeDataI::build),
      builder,
      title,
      onGenerateTitle,
      color.map(ColorI::build),
      showPerformanceOverlay,
      checkerboardRasterCacheImages,
      checkerboardOffscreenLayers,
      showSemanticsDebugger,
      debugShowCheckedModeBanner,
      restorationScopeId,
      useInheritedMediaQuery);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoApp");
    return new CupertinoApp(id);
  }
  public static CupertinoAppRouterBuilder router() {
    return CupertinoAppRouterBuilder.cupertinoAppRouter();
  }
  public Widget home() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppHome not supported on web");
    return factories.CupertinoApp_readBack_home(nativeStruct);
  }
  public CupertinoThemeData theme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoAppTheme", getId());
      return new CupertinoThemeData(__nid);
    }
    return factories.CupertinoApp_readBack_theme(nativeStruct);
  }
  public String initialRoute() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppInitialRoute not supported on web");
    return factories.CupertinoApp_readBack_initialRoute(nativeStruct);
  }
  public String title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppTitle not supported on web");
    return factories.CupertinoApp_readBack_title(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoAppColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoApp_readBack_color(nativeStruct);
  }
  public boolean showPerformanceOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppShowPerformanceOverlay not supported on web");
    return factories.CupertinoApp_readBack_showPerformanceOverlay(nativeStruct);
  }
  public boolean checkerboardRasterCacheImages() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppCheckerboardRasterCacheImages not supported on web");
    return factories.CupertinoApp_readBack_checkerboardRasterCacheImages(nativeStruct);
  }
  public boolean checkerboardOffscreenLayers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppCheckerboardOffscreenLayers not supported on web");
    return factories.CupertinoApp_readBack_checkerboardOffscreenLayers(nativeStruct);
  }
  public boolean showSemanticsDebugger() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppShowSemanticsDebugger not supported on web");
    return factories.CupertinoApp_readBack_showSemanticsDebugger(nativeStruct);
  }
  public boolean debugShowCheckedModeBanner() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppDebugShowCheckedModeBanner not supported on web");
    return factories.CupertinoApp_readBack_debugShowCheckedModeBanner(nativeStruct);
  }
  public String restorationScopeId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppRestorationScopeId not supported on web");
    return factories.CupertinoApp_readBack_restorationScopeId(nativeStruct);
  }
  public boolean useInheritedMediaQuery() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAppUseInheritedMediaQuery not supported on web");
    return factories.CupertinoApp_readBack_useInheritedMediaQuery(nativeStruct);
  }
  @Override
  public CupertinoApp build() {
    return this;
  }
}
