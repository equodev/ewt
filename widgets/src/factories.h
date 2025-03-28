typedef struct {
  struct TextSt {
    DartObj (*text)(char* data, DartObj* style, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis, DartObj* selectionColor);
    DartObj (*rich)(DartObj textSpan, DartObj* style, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis, DartObj* selectionColor);
  } text;

  struct TextStyleSt {
    TextStyleObjSt (*textStyle)(int* inherit, DartObj* color, DartObj* backgroundColor, double* fontSize, int* fontStyle, double* letterSpacing, double* wordSpacing, int* textBaseline, double* height, int* leadingDistribution, DartObj* decorationColor, int* decorationStyle, double* decorationThickness, char* debugLabel, char* fontFamily, char*** fontFamilyFallback, char* package, int* overflow);
    TextStyleObjSt (*lerp)(DartObj a, DartObj b, double t);
  } textStyle;

  struct ColorSt {
    DartObj (*color)(int value);
    DartObj (*from)(double alpha, double red, double green, double blue, int* colorSpace);
    DartObj (*fromARGB)(int a, int r, int g, int b);
    DartObj (*fromRGBO)(int r, int g, int b, double opacity);
    DartObj (*lerp)(DartObj x, DartObj y, double t);
    DartObj (*alphaBlend)(DartObj foreground, DartObj background);
  } color;

  struct CenterSt {
    DartObj (*center)(double* widthFactor, double* heightFactor, DartObj* child);
  } center;

  struct AlignSt {
    DartObj (*align)(double* widthFactor, double* heightFactor, DartObj* child);
  } align;

  struct ColumnSt {
    DartObj (*column)(int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, double* spacing, ArrayC* children);
  } column;

  struct FlexSt {
    DartObj (*flex)(int direction, int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, int* clipBehavior, double* spacing, ArrayC* children);
  } flex;

  struct IconDataSt {
    IconDataObjSt (*iconData)(int codePoint, char* fontFamily, char* fontPackage, int* matchTextDirection, char*** fontFamilyFallback);
  } iconData;

  struct IconSt {
    DartObj (*icon)(DartObj icon, double* size, double* fill, double* weight, double* grade, double* opticalSize, DartObj* color, char* semanticLabel, int* textDirection, int* applyTextScaling, int* blendMode);
  } icon;

  struct ColorSchemeSt {
    ColorSchemeObjSt (*colorScheme)(int brightness, DartObj primary, DartObj onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj secondary, DartObj onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj error, DartObj onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj surface, DartObj onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*fromSeed)(DartObj seedColor, int* brightness, int* dynamicSchemeVariant, double* contrastLevel, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* outline, DartObj* outlineVariant, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* shadow, DartObj* scrim, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*light)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*dark)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*highContrastLight)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*highContrastDark)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*fromSwatch)(DartObj* accentColor, DartObj* cardColor, DartObj* backgroundColor, DartObj* errorColor, int* brightness);
    ColorSchemeObjSt (*lerp)(DartObj a, DartObj b, double t);
    ColorSchemeObjSt (*of)(DartObj context);
  } colorScheme;

  struct TextThemeSt {
    TextThemeObjSt (*textTheme)(DartObj* displayLarge, DartObj* displayMedium, DartObj* displaySmall, DartObj* headlineLarge, DartObj* headlineMedium, DartObj* headlineSmall, DartObj* titleLarge, DartObj* titleMedium, DartObj* titleSmall, DartObj* bodyLarge, DartObj* bodyMedium, DartObj* bodySmall, DartObj* labelLarge, DartObj* labelMedium, DartObj* labelSmall);
    TextThemeObjSt (*lerp)(DartObj a, DartObj b, double t);
    TextThemeObjSt (*of)(DartObj context);
    TextThemeObjSt (*primaryOf)(DartObj context);
  } textTheme;

  struct AppBarSt {
    DartObj (*appBar)(DartObj* leading, int* automaticallyImplyLeading, DartObj* title, ArrayC* actions, DartObj* flexibleSpace, DartObj* bottom, double* elevation, double* scrolledUnderElevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* backgroundColor, DartObj* foregroundColor, int* primary, int* centerTitle, int* excludeHeaderSemantics, double* titleSpacing, double* toolbarOpacity, double* bottomOpacity, double* toolbarHeight, double* leadingWidth, DartObj* toolbarTextStyle, DartObj* titleTextStyle, int* forceMaterialTransparency, int* clipBehavior);
  } appBar;

  struct ScaffoldSt {
    DartObj (*scaffold)(DartObj* appBar, DartObj* body, DartObj* floatingActionButton, ArrayC* persistentFooterButtons, DartObj* drawer, DrawerCallbackFFI* onDrawerChanged, DartObj* endDrawer, DrawerCallbackFFI* onEndDrawerChanged, DartObj* bottomNavigationBar, DartObj* bottomSheet, DartObj* backgroundColor, int* resizeToAvoidBottomInset, int* primary, int* drawerDragStartBehavior, int* extendBody, int* extendBodyBehindAppBar, DartObj* drawerScrimColor, double* drawerEdgeDragWidth, int* drawerEnableOpenDragGesture, int* endDrawerEnableOpenDragGesture, char* restorationId);
  } scaffold;

  struct MaterialAppSt {
    DartObj (*materialApp)(DartObj* home, char* initialRoute, TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
    DartObj (*router)(TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
  } materialApp;

  struct ThemeDataSt {
    ThemeDataObjSt (*themeData)(int* applyElevationOverlayColor, int* materialTapTargetSize, int* platform, int* useMaterial3, DartObj* colorScheme, int* brightness, DartObj* colorSchemeSeed, DartObj* canvasColor, DartObj* cardColor, DartObj* disabledColor, DartObj* dividerColor, DartObj* focusColor, DartObj* highlightColor, DartObj* hintColor, DartObj* hoverColor, DartObj* indicatorColor, DartObj* primaryColor, DartObj* primaryColorDark, DartObj* primaryColorLight, DartObj* scaffoldBackgroundColor, DartObj* secondaryHeaderColor, DartObj* shadowColor, DartObj* splashColor, DartObj* unselectedWidgetColor, char* fontFamily, char*** fontFamilyFallback, char* package, DartObj* primaryTextTheme, DartObj* textTheme, DartObj* cardTheme, DartObj* dialogTheme, DartObj* tabBarTheme, DartObj* dialogBackgroundColor);
    ThemeDataObjSt (*from)(DartObj colorScheme, DartObj* textTheme, int* useMaterial3);
    ThemeDataObjSt (*light)(int* useMaterial3);
    ThemeDataObjSt (*dark)(int* useMaterial3);
    ThemeDataObjSt (*fallback)(int* useMaterial3);
    ThemeDataObjSt (*localize)(DartObj baseTheme, DartObj localTextGeometry);
    int (*estimateBrightnessForColor)(DartObj color);
    ThemeDataObjSt (*lerp)(DartObj a, DartObj b, double t);
  } themeData;

  struct FloatingActionButtonSt {
    DartObj (*floatingActionButton)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* mini, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* isExtended, int* enableFeedback);
    DartObj (*small)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* enableFeedback);
    DartObj (*large)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* enableFeedback);
    DartObj (*extended)(char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, DartObj* splashColor, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* isExtended, int* materialTapTargetSize, int* clipBehavior, int* autofocus, double* extendedIconLabelSpacing, DartObj* extendedTextStyle, DartObj* icon, DartObj label, int* enableFeedback);
  } floatingActionButton;

  struct ThemeSt {
    DartObj (*theme)(DartObj data, DartObj child);
    ThemeDataObjSt (*of)(DartObj context);
  } theme;

  struct SubStateSt {
    SubStateObjSt (*subState)(DartObjCallbackDartObj buildFn);
  } subState;

  struct SubStatefulWidgetSt {
    SubStatefulWidgetObjSt (*subStatefulWidget)(DartObjCallback createStateFn);
  } subStatefulWidget;

} WidgetFactories;
