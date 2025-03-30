package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class MaterialApp extends StatefulWidget implements MaterialAppI {
  @Override
  public MaterialApp build() {
    return this;
  }
  MaterialApp() {}
  MaterialApp(int id) {
    this.id = id;
  }
  @Builder.Factory
  static MaterialApp materialAppMaterialApp(Optional<WidgetI> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<ThemeDataI> theme, Optional<ThemeDataI> darkTheme, Optional<ThemeDataI> highContrastTheme, Optional<ThemeDataI> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
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
      debugShowMaterialGrid,
      showPerformanceOverlay,
      checkerboardRasterCacheImages,
      checkerboardOffscreenLayers,
      showSemanticsDebugger,
      debugShowCheckedModeBanner,
      restorationScopeId,
      useInheritedMediaQuery);
    if (id == -1) throw new RuntimeException("Failed to created widget MaterialApp");
    System.out.println("New MaterialApp id:"+id);
    return new MaterialApp(id);
  }
  public static MaterialAppMaterialAppBuilder materialApp() {
    return MaterialAppMaterialAppBuilder.materialAppMaterialApp();
  }
  @Builder.Factory
  static MaterialApp materialAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<ThemeDataI> theme, Optional<ThemeDataI> darkTheme, Optional<ThemeDataI> highContrastTheme, Optional<ThemeDataI> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = factories.materialAppRouter(builder,
      title,
      onGenerateTitle,
      color.map(ColorI::build),
      theme.map(ThemeDataI::build),
      darkTheme.map(ThemeDataI::build),
      highContrastTheme.map(ThemeDataI::build),
      highContrastDarkTheme.map(ThemeDataI::build),
      themeMode,
      debugShowMaterialGrid,
      showPerformanceOverlay,
      checkerboardRasterCacheImages,
      checkerboardOffscreenLayers,
      showSemanticsDebugger,
      debugShowCheckedModeBanner,
      restorationScopeId,
      useInheritedMediaQuery);
    if (id == -1) throw new RuntimeException("Failed to created widget MaterialApp");
    System.out.println("New MaterialApp id:"+id);
    return new MaterialApp(id);
  }
  public static MaterialAppRouterBuilder router() {
    return MaterialAppRouterBuilder.materialAppRouter();
  }
}
