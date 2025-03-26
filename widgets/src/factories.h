typedef struct {
  struct TextSt {
    int (*text)(char* data, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis, DartObj* selectionColor);
    int (*rich)(DartObj textSpan, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis, DartObj* selectionColor);
  } text;

  struct ColorSt {
    int (*color)(int value);
    int (*from)(double alpha, double red, double green, double blue, int* colorSpace);
    int (*fromARGB)(int a, int r, int g, int b);
    int (*fromRGBO)(int r, int g, int b, double opacity);
    int (*lerp)(DartObj x, DartObj y, double t);
    int (*alphaBlend)(DartObj foreground, DartObj background);
  } color;

  struct CenterSt {
    int (*center)(double* widthFactor, double* heightFactor, DartObj* child);
  } center;

  struct AlignSt {
    int (*align)(double* widthFactor, double* heightFactor, DartObj* child);
  } align;

  struct ColumnSt {
    int (*column)(int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, double* spacing, ArrayC* children);
  } column;

  struct FlexSt {
    int (*flex)(int direction, int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, int* clipBehavior, double* spacing, ArrayC* children);
  } flex;

  struct IconDataSt {
    int (*iconData)(int codePoint, char* fontFamily, char* fontPackage, int* matchTextDirection, char*** fontFamilyFallback);
  } iconData;

  struct IconSt {
    int (*icon)(DartObj icon, double* size, double* fill, double* weight, double* grade, double* opticalSize, DartObj* color, char* semanticLabel, int* textDirection, int* applyTextScaling, int* blendMode);
  } icon;

  struct AppBarSt {
    int (*appBar)(DartObj* leading, int* automaticallyImplyLeading, DartObj* title, ArrayC* actions, DartObj* flexibleSpace, DartObj* bottom, double* elevation, double* scrolledUnderElevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* backgroundColor, DartObj* foregroundColor, int* primary, int* centerTitle, int* excludeHeaderSemantics, double* titleSpacing, double* toolbarOpacity, double* bottomOpacity, double* toolbarHeight, double* leadingWidth, int* forceMaterialTransparency, int* clipBehavior);
  } appBar;

  struct ScaffoldSt {
    int (*scaffold)(DartObj* appBar, DartObj* body, DartObj* floatingActionButton, ArrayC* persistentFooterButtons, DartObj* drawer, DrawerCallbackFFI* onDrawerChanged, DartObj* endDrawer, DrawerCallbackFFI* onEndDrawerChanged, DartObj* bottomNavigationBar, DartObj* bottomSheet, DartObj* backgroundColor, int* resizeToAvoidBottomInset, int* primary, int* drawerDragStartBehavior, int* extendBody, int* extendBodyBehindAppBar, DartObj* drawerScrimColor, double* drawerEdgeDragWidth, int* drawerEnableOpenDragGesture, int* endDrawerEnableOpenDragGesture, char* restorationId);
  } scaffold;

  struct MaterialAppSt {
    int (*materialApp)(DartObj* home, char* initialRoute, TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
    int (*router)(TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
  } materialApp;

  struct ThemeDataSt {
    int (*themeData)(int* applyElevationOverlayColor, int* materialTapTargetSize, int* platform, int* useMaterial3, DartObj* colorScheme, int* brightness, DartObj* colorSchemeSeed, DartObj* canvasColor, DartObj* cardColor, DartObj* disabledColor, DartObj* dividerColor, DartObj* focusColor, DartObj* highlightColor, DartObj* hintColor, DartObj* hoverColor, DartObj* indicatorColor, DartObj* primaryColor, DartObj* primaryColorDark, DartObj* primaryColorLight, DartObj* scaffoldBackgroundColor, DartObj* secondaryHeaderColor, DartObj* shadowColor, DartObj* splashColor, DartObj* unselectedWidgetColor, char* fontFamily, char*** fontFamilyFallback, char* package, DartObj* cardTheme, DartObj* dialogTheme, DartObj* tabBarTheme, DartObj* dialogBackgroundColor);
    int (*from)(DartObj colorScheme, int* useMaterial3);
    int (*light)(int* useMaterial3);
    int (*dark)(int* useMaterial3);
    int (*fallback)(int* useMaterial3);
    int (*estimateBrightnessForColor)(DartObj color);
    int (*lerp)(DartObj a, DartObj b, double t);
  } themeData;

  struct ColorSchemeSt {
    int (*colorScheme)(int brightness, DartObj primary, DartObj onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj secondary, DartObj onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj error, DartObj onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj surface, DartObj onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    int (*fromSeed)(DartObj seedColor, int* brightness, int* dynamicSchemeVariant, double* contrastLevel, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* outline, DartObj* outlineVariant, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* shadow, DartObj* scrim, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    int (*light)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    int (*dark)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    int (*highContrastLight)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    int (*highContrastDark)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    int (*fromSwatch)(DartObj* accentColor, DartObj* cardColor, DartObj* backgroundColor, DartObj* errorColor, int* brightness);
    int (*lerp)(DartObj a, DartObj b, double t);
    int (*of)(DartObj context);
  } colorScheme;

  struct FloatingActionButtonSt {
    int (*floatingActionButton)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* mini, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* isExtended, int* enableFeedback);
    int (*small)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* enableFeedback);
    int (*large)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* enableFeedback);
    int (*extended)(char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, DartObj* splashColor, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* isExtended, int* materialTapTargetSize, int* clipBehavior, int* autofocus, double* extendedIconLabelSpacing, DartObj* icon, DartObj label, int* enableFeedback);
  } floatingActionButton;

  struct ThemeSt {
    int (*theme)(DartObj data, DartObj child);
    int (*of)(DartObj context);
  } theme;

  struct SubStateSt {
    SubStateObjSt (*subState)(DartObjCallbackDartObj buildFn);
  } subState;

  struct SubStatefulWidgetSt {
    SubStatefulWidgetObjSt (*subStatefulWidget)(DartObjCallback createStateFn);
  } subStatefulWidget;

} WidgetFactories;
