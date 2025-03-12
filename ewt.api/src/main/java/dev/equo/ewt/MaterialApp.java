package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class MaterialApp extends StatefulWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  MaterialApp() {}
  MaterialApp(int id) {
    this.id = id;
  }
  @Builder.Factory
  static MaterialApp materialAppMaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<String> title, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = factories.materialAppMaterialApp(home, initialRoute, title, color, theme, darkTheme, highContrastTheme, highContrastDarkTheme, themeMode, debugShowMaterialGrid, showPerformanceOverlay, checkerboardRasterCacheImages, checkerboardOffscreenLayers, showSemanticsDebugger, debugShowCheckedModeBanner, restorationScopeId, useInheritedMediaQuery);
    if (id == -1) throw new RuntimeException("Failed to created widget MaterialApp");
    System.out.println("New MaterialApp id:"+id);
    return new MaterialApp(id);
  }
  public static MaterialAppMaterialAppBuilder materialApp() {
    return MaterialAppMaterialAppBuilder.materialAppMaterialApp();
  }
  @Builder.Factory
  static MaterialApp materialAppRouter(Optional<String> title, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = factories.materialAppRouter(title, color, theme, darkTheme, highContrastTheme, highContrastDarkTheme, themeMode, debugShowMaterialGrid, showPerformanceOverlay, checkerboardRasterCacheImages, checkerboardOffscreenLayers, showSemanticsDebugger, debugShowCheckedModeBanner, restorationScopeId, useInheritedMediaQuery);
    if (id == -1) throw new RuntimeException("Failed to created widget MaterialApp");
    System.out.println("New MaterialApp id:"+id);
    return new MaterialApp(id);
  }
  public static MaterialAppRouterBuilder router() {
    return MaterialAppRouterBuilder.materialAppRouter();
  }
}
