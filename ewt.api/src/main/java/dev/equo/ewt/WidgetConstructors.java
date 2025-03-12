package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.lang.foreign.*;
class WidgetConstructors {
  static WidgetConstructors instance = new WidgetConstructors();
  private MemorySegment factories;
  private Arena arena = Arena.ofAuto();
  public void set(MemorySegment factories) {
    this.factories = factories;
  }
  int textText(String data, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.text(st);
    return WidgetFactories.TextSt.text.invoke(fn, arena.allocateFrom(data), ptrEnum(textAlign), ptrEnum(textDirection), ptrBool(softWrap), ptrEnum(overflow), ptr(textScaleFactor), ptr(maxLines), ptrStr(semanticsLabel), ptrEnum(textWidthBasis));
  }
  int textRich(InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.rich(st);
    return WidgetFactories.TextSt.rich.invoke(fn, textSpan.getId(), ptrEnum(textAlign), ptrEnum(textDirection), ptrBool(softWrap), ptrEnum(overflow), ptr(textScaleFactor), ptr(maxLines), ptrStr(semanticsLabel), ptrEnum(textWidthBasis));
  }

  int centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.center(factories);
    var fn = WidgetFactories.CenterSt.center(st);
    return WidgetFactories.CenterSt.center.invoke(fn, ptr(widthFactor), ptr(heightFactor), ptrObj(child));
  }

  int alignAlign(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.align(factories);
    var fn = WidgetFactories.AlignSt.align(st);
    return WidgetFactories.AlignSt.align.invoke(fn, ptr(widthFactor), ptr(heightFactor), ptrObj(child));
  }

  int columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.column(factories);
    var fn = WidgetFactories.ColumnSt.column(st);
    return WidgetFactories.ColumnSt.column.invoke(fn, ptrEnum(mainAxisAlignment), ptrEnum(mainAxisSize), ptrEnum(crossAxisAlignment), ptrEnum(textDirection), ptrEnum(verticalDirection), ptrEnum(textBaseline), ptr(spacing), ptrList(children));
  }

  int flexFlex(Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.flex(factories);
    var fn = WidgetFactories.FlexSt.flex(st);
    return WidgetFactories.FlexSt.flex.invoke(fn, direction.ordinal(), ptrEnum(mainAxisAlignment), ptrEnum(mainAxisSize), ptrEnum(crossAxisAlignment), ptrEnum(textDirection), ptrEnum(verticalDirection), ptrEnum(textBaseline), ptrEnum(clipBehavior), ptr(spacing), ptrList(children));
  }

  int appBarAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<Boolean> forceMaterialTransparency, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.appBar(factories);
    var fn = WidgetFactories.AppBarSt.appBar(st);
    return WidgetFactories.AppBarSt.appBar.invoke(fn, ptrObj(leading), ptrBool(automaticallyImplyLeading), ptrObj(title), ptrList(actions), ptrObj(flexibleSpace), ptrObj(bottom), ptr(elevation), ptr(scrolledUnderElevation), ptrBool(primary), ptrBool(centerTitle), ptrBool(excludeHeaderSemantics), ptr(titleSpacing), ptr(toolbarOpacity), ptr(bottomOpacity), ptr(toolbarHeight), ptr(leadingWidth), ptrBool(forceMaterialTransparency), ptrEnum(clipBehavior));
  }

  int scaffoldScaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<Widget> drawer, Optional<Widget> endDrawer, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> extendBodyBehindAppBar, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    var st = WidgetFactories.scaffold(factories);
    var fn = WidgetFactories.ScaffoldSt.scaffold(st);
    return WidgetFactories.ScaffoldSt.scaffold.invoke(fn, ptrObj(appBar), ptrObj(body), ptrObj(floatingActionButton), ptrList(persistentFooterButtons), ptrObj(drawer), ptrObj(endDrawer), ptrObj(bottomNavigationBar), ptrObj(bottomSheet), ptrBool(resizeToAvoidBottomInset), ptrBool(primary), ptrEnum(drawerDragStartBehavior), ptrBool(extendBody), ptrBool(extendBodyBehindAppBar), ptr(drawerEdgeDragWidth), ptrBool(drawerEnableOpenDragGesture), ptrBool(endDrawerEnableOpenDragGesture), ptrStr(restorationId));
  }

  int materialAppMaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<String> title, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.materialApp(st);
    return WidgetFactories.MaterialAppSt.materialApp.invoke(fn, ptrObj(home), ptrStr(initialRoute), ptrStr(title), ptrEnum(themeMode), ptrBool(debugShowMaterialGrid), ptrBool(showPerformanceOverlay), ptrBool(checkerboardRasterCacheImages), ptrBool(checkerboardOffscreenLayers), ptrBool(showSemanticsDebugger), ptrBool(debugShowCheckedModeBanner), ptrStr(restorationScopeId), ptrBool(useInheritedMediaQuery));
  }
  int materialAppRouter(Optional<String> title, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.router(st);
    return WidgetFactories.MaterialAppSt.router.invoke(fn, ptrStr(title), ptrEnum(themeMode), ptrBool(debugShowMaterialGrid), ptrBool(showPerformanceOverlay), ptrBool(checkerboardRasterCacheImages), ptrBool(checkerboardOffscreenLayers), ptrBool(showSemanticsDebugger), ptrBool(debugShowCheckedModeBanner), ptrStr(restorationScopeId), ptrBool(useInheritedMediaQuery));
  }

  MemorySegment ptr(OptionalInt opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.getAsInt()) : MemorySegment.NULL;
  }
  MemorySegment ptr(OptionalDouble opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_DOUBLE, opt.getAsDouble()) : MemorySegment.NULL;
  }
  MemorySegment ptrBool(Optional<Boolean> opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get() ? 1 : 0) : MemorySegment.NULL;
  }
  MemorySegment ptrStr(Optional<String> opt) {
    return opt.isPresent() ? arena.allocateFrom(opt.get()) : MemorySegment.NULL;
  }
  <T extends Enum<?>> MemorySegment ptrEnum(Optional<T> opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().ordinal()) : MemorySegment.NULL;
  }
  <T extends NativeObj> MemorySegment ptrObj(Optional<T> opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().getId()) : MemorySegment.NULL;
  }
  <T extends NativeObj> MemorySegment ptrList(Optional<List<T>> opt) {
    if (opt.isPresent()) {
      MemorySegment struct = ArrayC.allocate(arena);
      ArrayC.size(struct, opt.get().size());
      MemorySegment array = arena.allocateFrom(StarterBridge.C_INT, opt.get().stream().mapToInt(NativeObj::getId).toArray());
      ArrayC.list(struct, array);
      return struct;
    }
    return MemorySegment.NULL
;  }
}
