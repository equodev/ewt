part of 'factories.dart';
void _setupText(WidgetFactories f) {
  f.text.text = ffi.Pointer.fromFunction(textText, exception);
  f.text.rich = ffi.Pointer.fromFunction(textRich, exception);
}

int textText(ffi.Pointer<ffi.Char> data, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text(data.cast<Utf8>().toDartString(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      selectionColor: selectionColor.objOrNul());
  return _addWidget(w);
}
int textRich(DartDartObj textSpan, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan,
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      selectionColor: selectionColor.objOrNul());
  return _addWidget(w);
}

void _setupColor(WidgetFactories f) {
  f.color.color = ffi.Pointer.fromFunction(colorColor, exception);
  f.color.from = ffi.Pointer.fromFunction(colorFrom, exception);
  f.color.fromARGB = ffi.Pointer.fromFunction(colorFromARGB, exception);
  f.color.fromRGBO = ffi.Pointer.fromFunction(colorFromRGBO, exception);
}

int colorColor(int value) {
  final w = Color(value);
  return _addWidget(w);
}
int colorFrom(double alpha, double red, double green, double blue, ffi.Pointer<ffi.Int> colorSpace) {
  final w = Color.from(alpha: alpha,
      red: red,
      green: green,
      blue: blue,
      colorSpace: colorSpace.enumOr(ColorSpace.values, ColorSpace.sRGB));
  return _addWidget(w);
}
int colorFromARGB(int a, int r, int g, int b) {
  final w = Color.fromARGB(a,
      r,
      g,
      b);
  return _addWidget(w);
}
int colorFromRGBO(int r, int g, int b, double opacity) {
  final w = Color.fromRGBO(r,
      g,
      b,
      opacity);
  return _addWidget(w);
}









void _setupCenter(WidgetFactories f) {
  f.center.center = ffi.Pointer.fromFunction(centerCenter, exception);
}

int centerCenter(ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Center(widthFactor: widthFactor.doubleOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      child: child.objOrNul());
  return _addWidget(w);
}

void _setupAlign(WidgetFactories f) {
  f.align.align = ffi.Pointer.fromFunction(alignAlign, exception);
}

int alignAlign(ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Align(widthFactor: widthFactor.doubleOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      child: child.objOrNul());
  return _addWidget(w);
}





void _setupColumn(WidgetFactories f) {
  f.column.column = ffi.Pointer.fromFunction(columnColumn, exception);
}

int columnColumn(ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Column(mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      spacing: spacing.doubleOr(0.0),
      children: children.orEmpty());
  return _addWidget(w);
}

void _setupFlex(WidgetFactories f) {
  f.flex.flex = ffi.Pointer.fromFunction(flexFlex, exception);
}

int flexFlex(int direction, ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Flex(direction: _widgetsMap[direction]! as Axis,
      mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      spacing: spacing.doubleOr(0.0),
      children: children.orEmpty());
  return _addWidget(w);
}



void _setupAppBar(WidgetFactories f) {
  f.appBar.appBar = ffi.Pointer.fromFunction(appBarAppBar, exception);
}

int appBarAppBar(ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<DartObj> title, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> flexibleSpace, ffi.Pointer<DartObj> bottom, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> scrolledUnderElevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> centerTitle, ffi.Pointer<ffi.Int> excludeHeaderSemantics, ffi.Pointer<ffi.Double> titleSpacing, ffi.Pointer<ffi.Double> toolbarOpacity, ffi.Pointer<ffi.Double> bottomOpacity, ffi.Pointer<ffi.Double> toolbarHeight, ffi.Pointer<ffi.Double> leadingWidth, ffi.Pointer<ffi.Int> forceMaterialTransparency, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = AppBar(leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      title: title.objOrNul(),
      actions: actions.orEmpty(),
      flexibleSpace: flexibleSpace.objOrNul(),
      bottom: bottom.objOrNul(),
      elevation: elevation.doubleOrNul(),
      scrolledUnderElevation: scrolledUnderElevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      primary: primary.boolOr(true),
      centerTitle: centerTitle.boolOrNul(),
      excludeHeaderSemantics: excludeHeaderSemantics.boolOr(false),
      titleSpacing: titleSpacing.doubleOrNul(),
      toolbarOpacity: toolbarOpacity.doubleOr(1.0),
      bottomOpacity: bottomOpacity.doubleOr(1.0),
      toolbarHeight: toolbarHeight.doubleOrNul(),
      leadingWidth: leadingWidth.doubleOrNul(),
      forceMaterialTransparency: forceMaterialTransparency.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values));
  return _addWidget(w);
}





void _setupScaffold(WidgetFactories f) {
  f.scaffold.scaffold = ffi.Pointer.fromFunction(scaffoldScaffold, exception);
}

int scaffoldScaffold(ffi.Pointer<DartObj> appBar, ffi.Pointer<DartObj> body, ffi.Pointer<DartObj> floatingActionButton, ffi.Pointer<ArrayC> persistentFooterButtons, ffi.Pointer<DartObj> drawer, ffi.Pointer<DartObj> endDrawer, ffi.Pointer<DartObj> bottomNavigationBar, ffi.Pointer<DartObj> bottomSheet, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> resizeToAvoidBottomInset, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> drawerDragStartBehavior, ffi.Pointer<ffi.Int> extendBody, ffi.Pointer<ffi.Int> extendBodyBehindAppBar, ffi.Pointer<DartObj> drawerScrimColor, ffi.Pointer<ffi.Double> drawerEdgeDragWidth, ffi.Pointer<ffi.Int> drawerEnableOpenDragGesture, ffi.Pointer<ffi.Int> endDrawerEnableOpenDragGesture, ffi.Pointer<ffi.Char> restorationId) {
  final w = Scaffold(appBar: appBar.objOrNul(),
      body: body.objOrNul(),
      floatingActionButton: floatingActionButton.objOrNul(),
      persistentFooterButtons: persistentFooterButtons.orEmpty(),
      drawer: drawer.objOrNul(),
      endDrawer: endDrawer.objOrNul(),
      bottomNavigationBar: bottomNavigationBar.objOrNul(),
      bottomSheet: bottomSheet.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      resizeToAvoidBottomInset: resizeToAvoidBottomInset.boolOrNul(),
      primary: primary.boolOr(true),
      drawerDragStartBehavior: drawerDragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      extendBody: extendBody.boolOr(false),
      extendBodyBehindAppBar: extendBodyBehindAppBar.boolOr(false),
      drawerScrimColor: drawerScrimColor.objOrNul(),
      drawerEdgeDragWidth: drawerEdgeDragWidth.doubleOrNul(),
      drawerEnableOpenDragGesture: drawerEnableOpenDragGesture.boolOr(true),
      endDrawerEnableOpenDragGesture: endDrawerEnableOpenDragGesture.boolOr(true),
      restorationId: restorationId.strOrNul());
  return _addWidget(w);
}

void _setupMaterialApp(WidgetFactories f) {
  f.materialApp.materialApp = ffi.Pointer.fromFunction(materialAppMaterialApp, exception);
  f.materialApp.router = ffi.Pointer.fromFunction(materialAppRouter, exception);
}

int materialAppMaterialApp(ffi.Pointer<DartObj> home, ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<ffi.Char> title, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp(home: home.objOrNul(),
      initialRoute: initialRoute.strOrNul(),
      title: title.strOrNul(),
      color: color.objOrNul(),
      theme: theme.objOrNul(),
      darkTheme: darkTheme.objOrNul(),
      highContrastTheme: highContrastTheme.objOrNul(),
      highContrastDarkTheme: highContrastDarkTheme.objOrNul(),
      themeMode: themeMode.enumOrNul(ThemeMode.values),
      debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _addWidget(w);
}
int materialAppRouter(ffi.Pointer<ffi.Char> title, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp.router(title: title.strOrNul(),
      color: color.objOrNul(),
      theme: theme.objOrNul(),
      darkTheme: darkTheme.objOrNul(),
      highContrastTheme: highContrastTheme.objOrNul(),
      highContrastDarkTheme: highContrastDarkTheme.objOrNul(),
      themeMode: themeMode.enumOrNul(ThemeMode.values),
      debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _addWidget(w);
}

void _setupThemeData(WidgetFactories f) {
  f.themeData.themeData = ffi.Pointer.fromFunction(themeDataThemeData, exception);
  f.themeData.from = ffi.Pointer.fromFunction(themeDataFrom, exception);
  f.themeData.light = ffi.Pointer.fromFunction(themeDataLight, exception);
  f.themeData.dark = ffi.Pointer.fromFunction(themeDataDark, exception);
  f.themeData.fallback = ffi.Pointer.fromFunction(themeDataFallback, exception);
}

int themeDataThemeData(ffi.Pointer<ffi.Int> applyElevationOverlayColor, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> platform, ffi.Pointer<ffi.Int> useMaterial3, ffi.Pointer<DartObj> colorScheme, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> colorSchemeSeed, ffi.Pointer<DartObj> canvasColor, ffi.Pointer<DartObj> cardColor, ffi.Pointer<DartObj> dialogBackgroundColor, ffi.Pointer<DartObj> disabledColor, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> hintColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<DartObj> primaryColor, ffi.Pointer<DartObj> primaryColorDark, ffi.Pointer<DartObj> primaryColorLight, ffi.Pointer<DartObj> scaffoldBackgroundColor, ffi.Pointer<DartObj> secondaryHeaderColor, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> unselectedWidgetColor, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback, ffi.Pointer<ffi.Char> package) {
  final w = ThemeData(applyElevationOverlayColor: applyElevationOverlayColor.boolOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      platform: platform.enumOrNul(TargetPlatform.values),
      useMaterial3: useMaterial3.boolOrNul(),
      colorScheme: colorScheme.objOrNul(),
      brightness: brightness.enumOrNul(Brightness.values),
      colorSchemeSeed: colorSchemeSeed.objOrNul(),
      canvasColor: canvasColor.objOrNul(),
      cardColor: cardColor.objOrNul(),
      dialogBackgroundColor: dialogBackgroundColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      dividerColor: dividerColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      hintColor: hintColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      primaryColor: primaryColor.objOrNul(),
      primaryColorDark: primaryColorDark.objOrNul(),
      primaryColorLight: primaryColorLight.objOrNul(),
      scaffoldBackgroundColor: scaffoldBackgroundColor.objOrNul(),
      secondaryHeaderColor: secondaryHeaderColor.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      unselectedWidgetColor: unselectedWidgetColor.objOrNul(),
      fontFamily: fontFamily.strOrNul(),
      fontFamilyFallback: fontFamilyFallback.orEmpty(),
      package: package.strOrNul());
  return _addWidget(w);
}
int themeDataFrom(DartDartObj colorScheme, ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.from(colorScheme: _widgetsMap[colorScheme]! as ColorScheme,
      useMaterial3: useMaterial3.boolOrNul());
  return _addWidget(w);
}
int themeDataLight(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.light(useMaterial3: useMaterial3.boolOrNul());
  return _addWidget(w);
}
int themeDataDark(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.dark(useMaterial3: useMaterial3.boolOrNul());
  return _addWidget(w);
}
int themeDataFallback(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.fallback(useMaterial3: useMaterial3.boolOrNul());
  return _addWidget(w);
}

void _setupColorScheme(WidgetFactories f) {
  f.colorScheme.colorScheme = ffi.Pointer.fromFunction(colorSchemeColorScheme, exception);
  f.colorScheme.fromSeed = ffi.Pointer.fromFunction(colorSchemeFromSeed, exception);
  f.colorScheme.light = ffi.Pointer.fromFunction(colorSchemeLight, exception);
  f.colorScheme.dark = ffi.Pointer.fromFunction(colorSchemeDark, exception);
  f.colorScheme.highContrastLight = ffi.Pointer.fromFunction(colorSchemeHighContrastLight, exception);
  f.colorScheme.highContrastDark = ffi.Pointer.fromFunction(colorSchemeHighContrastDark, exception);
  f.colorScheme.fromSwatch = ffi.Pointer.fromFunction(colorSchemeFromSwatch, exception);
}

int colorSchemeColorScheme(int brightness, DartDartObj primary, DartDartObj onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, DartDartObj secondary, DartDartObj onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, DartDartObj error, DartDartObj onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, DartDartObj surface, DartDartObj onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme(brightness: _widgetsMap[brightness]! as Brightness,
      primary: _widgetsMap[primary]! as Color,
      onPrimary: _widgetsMap[onPrimary]! as Color,
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: _widgetsMap[secondary]! as Color,
      onSecondary: _widgetsMap[onSecondary]! as Color,
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: _widgetsMap[error]! as Color,
      onError: _widgetsMap[onError]! as Color,
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: _widgetsMap[surface]! as Color,
      onSurface: _widgetsMap[onSurface]! as Color,
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _addWidget(w);
}
int colorSchemeFromSeed(DartDartObj seedColor, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<ffi.Int> dynamicSchemeVariant, ffi.Pointer<ffi.Double> contrastLevel, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.fromSeed(seedColor: _widgetsMap[seedColor]! as Color,
      brightness: brightness.enumOr(Brightness.values, Brightness.light),
      dynamicSchemeVariant: dynamicSchemeVariant.enumOr(DynamicSchemeVariant.values, DynamicSchemeVariant.tonalSpot),
      contrastLevel: contrastLevel.doubleOr(0.0),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _addWidget(w);
}
int colorSchemeLight(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.light(brightness: brightness.enumOr(Brightness.values, Brightness.light),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _addWidget(w);
}
int colorSchemeDark(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.dark(brightness: brightness.enumOr(Brightness.values, Brightness.dark),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _addWidget(w);
}
int colorSchemeHighContrastLight(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.highContrastLight(brightness: brightness.enumOr(Brightness.values, Brightness.light),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _addWidget(w);
}
int colorSchemeHighContrastDark(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.highContrastDark(brightness: brightness.enumOr(Brightness.values, Brightness.dark),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _addWidget(w);
}
int colorSchemeFromSwatch(ffi.Pointer<DartObj> accentColor, ffi.Pointer<DartObj> cardColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> errorColor, ffi.Pointer<ffi.Int> brightness) {
  final w = ColorScheme.fromSwatch(accentColor: accentColor.objOrNul(),
      cardColor: cardColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      errorColor: errorColor.objOrNul(),
      brightness: brightness.enumOr(Brightness.values, Brightness.light));
  return _addWidget(w);
}

void _setupFloatingActionButton(WidgetFactories f) {
  f.floatingActionButton.floatingActionButton = ffi.Pointer.fromFunction(floatingActionButtonFloatingActionButton, exception);
  f.floatingActionButton.small = ffi.Pointer.fromFunction(floatingActionButtonSmall, exception);
  f.floatingActionButton.large = ffi.Pointer.fromFunction(floatingActionButtonLarge, exception);
  f.floatingActionButton.extended = ffi.Pointer.fromFunction(floatingActionButtonExtended, exception);
}

int floatingActionButtonFloatingActionButton(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallback onPressed, ffi.Pointer<ffi.Int> mini, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> isExtended, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.asFunction(),
      mini: mini.boolOr(false),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      isExtended: isExtended.boolOr(false),
      enableFeedback: enableFeedback.boolOrNul());
  return _addWidget(w);
}
int floatingActionButtonSmall(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallback onPressed, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.small(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.asFunction(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      enableFeedback: enableFeedback.boolOrNul());
  return _addWidget(w);
}
int floatingActionButtonLarge(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallback onPressed, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.large(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.asFunction(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      enableFeedback: enableFeedback.boolOrNul());
  return _addWidget(w);
}
int floatingActionButtonExtended(ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallback onPressed, ffi.Pointer<ffi.Int> isExtended, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Double> extendedIconLabelSpacing, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.extended(tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      splashColor: splashColor.objOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.asFunction(),
      isExtended: isExtended.boolOr(true),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      extendedIconLabelSpacing: extendedIconLabelSpacing.doubleOrNul(),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      enableFeedback: enableFeedback.boolOrNul());
  return _addWidget(w);
}

WidgetFactories _setupFactories() {
  final WidgetFactories f = ffi.Struct.create();
  _setupText(f);
  _setupCenter(f);
  _setupColumn(f);
  _setupAppBar(f);
  _setupScaffold(f);
  _setupMaterialApp(f);
  _setupFloatingActionButton(f);
  _setupColor(f);
  _setupAlign(f);
  _setupFlex(f);
  _setupThemeData(f);
  _setupColorScheme(f);
  _setupColorScheme(f);
  return f;
}
