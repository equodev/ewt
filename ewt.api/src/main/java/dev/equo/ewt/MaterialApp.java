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
    return new Widget(MaterialAppObjSt.home(st)) {};
  }
  public String initialRoute() {
    return MaterialAppObjSt.initialRoute(st).getString(0);
  }
  public String title() {
    return MaterialAppObjSt.title(st).getString(0);
  }
  public ThemeData theme() {
    return new ThemeData(MaterialAppObjSt.theme(st));
  }
  public ThemeData darkTheme() {
    return new ThemeData(MaterialAppObjSt.darkTheme(st));
  }
  public ThemeData highContrastTheme() {
    return new ThemeData(MaterialAppObjSt.highContrastTheme(st));
  }
  public ThemeData highContrastDarkTheme() {
    return new ThemeData(MaterialAppObjSt.highContrastDarkTheme(st));
  }
  public ThemeMode themeMode() {
    return ThemeMode.values()[MaterialAppObjSt.themeMode(st)];
  }
  public Duration themeAnimationDuration() {
    return new Duration(MaterialAppObjSt.themeAnimationDuration(st));
  }
  public Curve themeAnimationCurve() {
    return new Curve(MaterialAppObjSt.themeAnimationCurve(st)) {};
  }
  public Color color() {
    return new Color(MaterialAppObjSt.color(st));
  }
  public boolean showPerformanceOverlay() {
    return intToBool(MaterialAppObjSt.showPerformanceOverlay(st));
  }
  public boolean checkerboardRasterCacheImages() {
    return intToBool(MaterialAppObjSt.checkerboardRasterCacheImages(st));
  }
  public boolean checkerboardOffscreenLayers() {
    return intToBool(MaterialAppObjSt.checkerboardOffscreenLayers(st));
  }
  public boolean showSemanticsDebugger() {
    return intToBool(MaterialAppObjSt.showSemanticsDebugger(st));
  }
  public boolean debugShowCheckedModeBanner() {
    return intToBool(MaterialAppObjSt.debugShowCheckedModeBanner(st));
  }
  public String restorationScopeId() {
    return MaterialAppObjSt.restorationScopeId(st).getString(0);
  }
  public boolean debugShowMaterialGrid() {
    return intToBool(MaterialAppObjSt.debugShowMaterialGrid(st));
  }
  public boolean useInheritedMediaQuery() {
    return intToBool(MaterialAppObjSt.useInheritedMediaQuery(st));
  }
  @Override
  public MaterialApp build() {
    return this;
  }
}
