package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoAppObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoApp extends StatefulWidget implements CupertinoAppI {
  private MemorySegment st;
  protected CupertinoApp() {}
  CupertinoApp(MemorySegment st) {
    this.id = CupertinoAppObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoApp");
    System.out.println("New CupertinoApp id:"+id);
  }
  CupertinoApp(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoApp cupertinoAppCupertinoApp(Optional<WidgetI> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = factories.cupertinoAppCupertinoApp(home.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoApp");
    return new CupertinoApp(st);
  }
  public static CupertinoAppCupertinoAppBuilder cupertinoApp() {
    return CupertinoAppCupertinoAppBuilder.cupertinoAppCupertinoApp();
  }
  @Builder.Factory
  static CupertinoApp cupertinoAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<ColorI> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = factories.cupertinoAppRouter(builder,
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoApp");
    return new CupertinoApp(st);
  }
  public static CupertinoAppRouterBuilder router() {
    return CupertinoAppRouterBuilder.cupertinoAppRouter();
  }
  public Widget home() {
    return new Widget(CupertinoAppObjSt.home(st)) {};
  }
  public String initialRoute() {
    return CupertinoAppObjSt.initialRoute(st).getString(0);
  }
  public String title() {
    return CupertinoAppObjSt.title(st).getString(0);
  }
  public Color color() {
    return new Color(CupertinoAppObjSt.color(st));
  }
  public boolean showPerformanceOverlay() {
    return intToBool(CupertinoAppObjSt.showPerformanceOverlay(st));
  }
  public boolean checkerboardRasterCacheImages() {
    return intToBool(CupertinoAppObjSt.checkerboardRasterCacheImages(st));
  }
  public boolean checkerboardOffscreenLayers() {
    return intToBool(CupertinoAppObjSt.checkerboardOffscreenLayers(st));
  }
  public boolean showSemanticsDebugger() {
    return intToBool(CupertinoAppObjSt.showSemanticsDebugger(st));
  }
  public boolean debugShowCheckedModeBanner() {
    return intToBool(CupertinoAppObjSt.debugShowCheckedModeBanner(st));
  }
  public String restorationScopeId() {
    return CupertinoAppObjSt.restorationScopeId(st).getString(0);
  }
  public boolean useInheritedMediaQuery() {
    return intToBool(CupertinoAppObjSt.useInheritedMediaQuery(st));
  }
  @Override
  public CupertinoApp build() {
    return this;
  }
}
