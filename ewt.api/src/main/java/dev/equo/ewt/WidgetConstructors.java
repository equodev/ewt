package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.lang.foreign.*;
import java.util.function.Supplier;
class WidgetConstructors extends WidgetConstructorsBase {
  int textText(String data, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.text(st);
    return WidgetFactories.TextSt.text.invoke(fn, arena.allocateFrom(data),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrStr(semanticsLabel),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }
  int textRich(InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.rich(st);
    return WidgetFactories.TextSt.rich.invoke(fn, textSpan.getId(),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrStr(semanticsLabel),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }

  int colorColor(int value) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.color(st);
    return WidgetFactories.ColorSt.color.invoke(fn, value);
  }
  int colorFrom(double alpha, double red, double green, double blue, Optional<ColorSpace> colorSpace) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.from(st);
    return WidgetFactories.ColorSt.from.invoke(fn, alpha,
      red,
      green,
      blue,
      ptrEnum(colorSpace));
  }
  int colorFromARGB(int a, int r, int g, int b) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.fromARGB(st);
    return WidgetFactories.ColorSt.fromARGB.invoke(fn, a,
      r,
      g,
      b);
  }
  int colorFromRGBO(int r, int g, int b, double opacity) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.fromRGBO(st);
    return WidgetFactories.ColorSt.fromRGBO.invoke(fn, r,
      g,
      b,
      opacity);
  }

  int centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.center(factories);
    var fn = WidgetFactories.CenterSt.center(st);
    return WidgetFactories.CenterSt.center.invoke(fn, ptr(widthFactor),
      ptr(heightFactor),
      ptrObj(child));
  }

  int alignAlign(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.align(factories);
    var fn = WidgetFactories.AlignSt.align(st);
    return WidgetFactories.AlignSt.align.invoke(fn, ptr(widthFactor),
      ptr(heightFactor),
      ptrObj(child));
  }

  int columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.column(factories);
    var fn = WidgetFactories.ColumnSt.column(st);
    return WidgetFactories.ColumnSt.column.invoke(fn, ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptr(spacing),
      ptrList(children));
  }

  int flexFlex(Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.flex(factories);
    var fn = WidgetFactories.FlexSt.flex(st);
    return WidgetFactories.FlexSt.flex.invoke(fn, direction.ordinal(),
      ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptrEnum(clipBehavior),
      ptr(spacing),
      ptrList(children));
  }

  int appBarAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<Boolean> forceMaterialTransparency, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.appBar(factories);
    var fn = WidgetFactories.AppBarSt.appBar(st);
    return WidgetFactories.AppBarSt.appBar.invoke(fn, ptrObj(leading),
      ptrBool(automaticallyImplyLeading),
      ptrObj(title),
      ptrList(actions),
      ptrObj(flexibleSpace),
      ptrObj(bottom),
      ptr(elevation),
      ptr(scrolledUnderElevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(backgroundColor),
      ptrObj(foregroundColor),
      ptrBool(primary),
      ptrBool(centerTitle),
      ptrBool(excludeHeaderSemantics),
      ptr(titleSpacing),
      ptr(toolbarOpacity),
      ptr(bottomOpacity),
      ptr(toolbarHeight),
      ptr(leadingWidth),
      ptrBool(forceMaterialTransparency),
      ptrEnum(clipBehavior));
  }

  int scaffoldScaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<Widget> drawer, Optional<Widget> endDrawer, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> extendBodyBehindAppBar, Optional<Color> drawerScrimColor, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    var st = WidgetFactories.scaffold(factories);
    var fn = WidgetFactories.ScaffoldSt.scaffold(st);
    return WidgetFactories.ScaffoldSt.scaffold.invoke(fn, ptrObj(appBar),
      ptrObj(body),
      ptrObj(floatingActionButton),
      ptrList(persistentFooterButtons),
      ptrObj(drawer),
      ptrObj(endDrawer),
      ptrObj(bottomNavigationBar),
      ptrObj(bottomSheet),
      ptrObj(backgroundColor),
      ptrBool(resizeToAvoidBottomInset),
      ptrBool(primary),
      ptrEnum(drawerDragStartBehavior),
      ptrBool(extendBody),
      ptrBool(extendBodyBehindAppBar),
      ptrObj(drawerScrimColor),
      ptr(drawerEdgeDragWidth),
      ptrBool(drawerEnableOpenDragGesture),
      ptrBool(endDrawerEnableOpenDragGesture),
      ptrStr(restorationId));
  }

  int materialAppMaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<String> title, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.materialApp(st);
    return WidgetFactories.MaterialAppSt.materialApp.invoke(fn, ptrObj(home),
      ptrStr(initialRoute),
      ptrStr(title),
      ptrObj(color),
      ptrObj(theme),
      ptrObj(darkTheme),
      ptrObj(highContrastTheme),
      ptrObj(highContrastDarkTheme),
      ptrEnum(themeMode),
      ptrBool(debugShowMaterialGrid),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }
  int materialAppRouter(Optional<String> title, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.router(st);
    return WidgetFactories.MaterialAppSt.router.invoke(fn, ptrStr(title),
      ptrObj(color),
      ptrObj(theme),
      ptrObj(darkTheme),
      ptrObj(highContrastTheme),
      ptrObj(highContrastDarkTheme),
      ptrEnum(themeMode),
      ptrBool(debugShowMaterialGrid),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }

  int themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> indicatorColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<Color> dialogBackgroundColor) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.themeData(st);
    return WidgetFactories.ThemeDataSt.themeData.invoke(fn, ptrBool(applyElevationOverlayColor),
      ptrEnum(materialTapTargetSize),
      ptrEnum(platform),
      ptrBool(useMaterial3),
      ptrObj(colorScheme),
      ptrEnum(brightness),
      ptrObj(colorSchemeSeed),
      ptrObj(canvasColor),
      ptrObj(cardColor),
      ptrObj(disabledColor),
      ptrObj(dividerColor),
      ptrObj(focusColor),
      ptrObj(highlightColor),
      ptrObj(hintColor),
      ptrObj(hoverColor),
      ptrObj(indicatorColor),
      ptrObj(primaryColor),
      ptrObj(primaryColorDark),
      ptrObj(primaryColorLight),
      ptrObj(scaffoldBackgroundColor),
      ptrObj(secondaryHeaderColor),
      ptrObj(shadowColor),
      ptrObj(splashColor),
      ptrObj(unselectedWidgetColor),
      ptrStr(fontFamily),
      ptrStrList(fontFamilyFallback),
      ptrStr(_package),
      ptrObj(dialogBackgroundColor));
  }
  int themeDataFrom(ColorScheme colorScheme, Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.from(st);
    return WidgetFactories.ThemeDataSt.from.invoke(fn, colorScheme.getId(),
      ptrBool(useMaterial3));
  }
  int themeDataLight(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.light(st);
    return WidgetFactories.ThemeDataSt.light.invoke(fn, ptrBool(useMaterial3));
  }
  int themeDataDark(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.dark(st);
    return WidgetFactories.ThemeDataSt.dark.invoke(fn, ptrBool(useMaterial3));
  }
  int themeDataFallback(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.fallback(st);
    return WidgetFactories.ThemeDataSt.fallback.invoke(fn, ptrBool(useMaterial3));
  }

  int colorSchemeColorScheme(Brightness brightness, Color primary, Color onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Color secondary, Color onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Color error, Color onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Color surface, Color onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.colorScheme(st);
    return WidgetFactories.ColorSchemeSt.colorScheme.invoke(fn, brightness.ordinal(),
      primary.getId(),
      onPrimary.getId(),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      secondary.getId(),
      onSecondary.getId(),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      error.getId(),
      onError.getId(),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      surface.getId(),
      onSurface.getId(),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  int colorSchemeFromSeed(Color seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.fromSeed(st);
    return WidgetFactories.ColorSchemeSt.fromSeed.invoke(fn, seedColor.getId(),
      ptrEnum(brightness),
      ptrEnum(dynamicSchemeVariant),
      ptr(contrastLevel),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  int colorSchemeLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.light(st);
    return WidgetFactories.ColorSchemeSt.light.invoke(fn, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  int colorSchemeDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.dark(st);
    return WidgetFactories.ColorSchemeSt.dark.invoke(fn, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  int colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.highContrastLight(st);
    return WidgetFactories.ColorSchemeSt.highContrastLight.invoke(fn, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  int colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.highContrastDark(st);
    return WidgetFactories.ColorSchemeSt.highContrastDark.invoke(fn, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  int colorSchemeFromSwatch(Optional<Color> accentColor, Optional<Color> cardColor, Optional<Color> backgroundColor, Optional<Color> errorColor, Optional<Brightness> brightness) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.fromSwatch(st);
    return WidgetFactories.ColorSchemeSt.fromSwatch.invoke(fn, ptrObj(accentColor),
      ptrObj(cardColor),
      ptrObj(backgroundColor),
      ptrObj(errorColor),
      ptrEnum(brightness));
  }

  int floatingActionButtonFloatingActionButton(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> mini, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.floatingActionButton(st);
    return WidgetFactories.FloatingActionButtonSt.floatingActionButton.invoke(fn, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrFn(onPressed),
      ptrBool(mini),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(isExtended),
      ptrBool(enableFeedback));
  }
  int floatingActionButtonSmall(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.small(st);
    return WidgetFactories.FloatingActionButtonSt.small.invoke(fn, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrFn(onPressed),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(enableFeedback));
  }
  int floatingActionButtonLarge(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.large(st);
    return WidgetFactories.FloatingActionButtonSt.large.invoke(fn, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrFn(onPressed),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(enableFeedback));
  }
  int floatingActionButtonExtended(Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<Color> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<Widget> icon, Widget label, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.extended(st);
    return WidgetFactories.FloatingActionButtonSt.extended.invoke(fn, ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptrObj(splashColor),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrFn(onPressed),
      ptrBool(isExtended),
      ptrEnum(materialTapTargetSize),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptr(extendedIconLabelSpacing),
      ptrObj(icon),
      label.getId(),
      ptrBool(enableFeedback));
  }

  int iconDataIconData(int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    var st = WidgetFactories.iconData(factories);
    var fn = WidgetFactories.IconDataSt.iconData(st);
    return WidgetFactories.IconDataSt.iconData.invoke(fn, codePoint,
      ptrStr(fontFamily),
      ptrStr(fontPackage),
      ptrBool(matchTextDirection),
      ptrStrList(fontFamilyFallback));
  }

  int iconIcon(IconData icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode) {
    var st = WidgetFactories.icon(factories);
    var fn = WidgetFactories.IconSt.icon(st);
    return WidgetFactories.IconSt.icon.invoke(fn, icon.getId(),
      ptr(size),
      ptr(fill),
      ptr(weight),
      ptr(grade),
      ptr(opticalSize),
      ptrObj(color),
      ptrStr(semanticLabel),
      ptrEnum(textDirection),
      ptrBool(applyTextScaling),
      ptrEnum(blendMode));
  }

  int subStateSubState(Supplier<NativeObj> buildFn) {
    var st = WidgetFactories.subState(factories);
    var fn = WidgetFactories.SubStateSt.subState(st);
    return WidgetFactories.SubStateSt.subState.invoke(fn, ptrFn(buildFn));
  }

  int subStatefulWidgetSubStatefulWidget(Supplier<NativeObj> createStateFn) {
    var st = WidgetFactories.subStatefulWidget(factories);
    var fn = WidgetFactories.SubStatefulWidgetSt.subStatefulWidget(st);
    return WidgetFactories.SubStatefulWidgetSt.subStatefulWidget.invoke(fn, ptrFn(createStateFn));
  }

}
