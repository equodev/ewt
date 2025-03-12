package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class MaterialApp extends StatefulWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  MaterialApp() {}
  @Builder.Constructor
  MaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<String> title, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    id = factories.materialAppMaterialApp(home, initialRoute, title, themeMode, debugShowMaterialGrid, showPerformanceOverlay, checkerboardRasterCacheImages, checkerboardOffscreenLayers, showSemanticsDebugger, debugShowCheckedModeBanner, restorationScopeId, useInheritedMediaQuery);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static MaterialAppBuilder materialApp() {
    return MaterialAppBuilder.MaterialApp();
  }
  @Builder.Factory
  static MaterialApp materialAppRouter(Optional<String> title, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    return new MaterialApp(title, themeMode, debugShowMaterialGrid, showPerformanceOverlay, checkerboardRasterCacheImages, checkerboardOffscreenLayers, showSemanticsDebugger, debugShowCheckedModeBanner, restorationScopeId, useInheritedMediaQuery);
  }
  MaterialApp(Optional<String> title, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    id = factories.materialAppRouter(title, themeMode, debugShowMaterialGrid, showPerformanceOverlay, checkerboardRasterCacheImages, checkerboardOffscreenLayers, showSemanticsDebugger, debugShowCheckedModeBanner, restorationScopeId, useInheritedMediaQuery);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static MaterialAppRouterBuilder router() {
    return MaterialAppRouterBuilder.materialAppRouter();
  }
}
