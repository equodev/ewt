typedef struct {
  struct TextStyleSt {
    TextStyleObjSt (*textStyle)(int* inherit, DartObj* color, DartObj* backgroundColor, double* fontSize, int* fontStyle, double* letterSpacing, double* wordSpacing, int* textBaseline, double* height, int* leadingDistribution, ArrayC* shadows, DartObj* decorationColor, int* decorationStyle, double* decorationThickness, char* debugLabel, char* fontFamily, char*** fontFamilyFallback, char* package, int* overflow);
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

  struct TextSt {
    TextObjSt (*text)(char* data, DartObj* style, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis, DartObj* selectionColor);
    TextObjSt (*rich)(DartObj textSpan, DartObj* style, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis, DartObj* selectionColor);
  } text;

  struct CenterSt {
    CenterObjSt (*center)(double* widthFactor, double* heightFactor, DartObj* child);
  } center;

  struct AlignSt {
    AlignObjSt (*align)(DartObj* alignment, double* widthFactor, double* heightFactor, DartObj* child);
  } align;

  struct ColumnSt {
    ColumnObjSt (*column)(int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, double* spacing, ArrayC* children);
  } column;

  struct FlexSt {
    FlexObjSt (*flex)(int direction, int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, int* clipBehavior, double* spacing, ArrayC* children);
  } flex;

  struct RowSt {
    RowObjSt (*row)(int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, double* spacing, ArrayC* children);
  } row;

  struct IconDataSt {
    IconDataObjSt (*iconData)(int codePoint, char* fontFamily, char* fontPackage, int* matchTextDirection, char*** fontFamilyFallback);
  } iconData;

  struct IconSt {
    IconObjSt (*icon)(DartObj icon, double* size, double* fill, double* weight, double* grade, double* opticalSize, DartObj* color, ArrayC* shadows, char* semanticLabel, int* textDirection, int* applyTextScaling, int* blendMode);
  } icon;

  struct TransformSt {
    TransformObjSt (*rotate)(double angle, DartObj* origin, DartObj* alignment, int* transformHitTests, int* filterQuality, DartObj* child);
    TransformObjSt (*translate)(DartObj offset, int* transformHitTests, int* filterQuality, DartObj* child);
    TransformObjSt (*scale)(double* scale, double* scaleX, double* scaleY, DartObj* origin, DartObj* alignment, int* transformHitTests, int* filterQuality, DartObj* child);
    TransformObjSt (*flip)(int* flipX, int* flipY, DartObj* origin, int* transformHitTests, int* filterQuality, DartObj* child);
  } transform;

  struct OffsetSt {
    DartObj (*offset)(double dx, double dy);
    DartObj (*fromDirection)(double direction, double* distance);
    DartObj (*lerp)(DartObj a, DartObj b, double t);
  } offset;

  struct OpacitySt {
    OpacityObjSt (*opacity)(double opacity, int* alwaysIncludeSemantics, DartObj* child);
  } opacity;

  struct StackSt {
    StackObjSt (*stack)(DartObj* alignment, int* textDirection, int* fit, int* clipBehavior, ArrayC* children);
  } stack;

  struct BoxConstraintsSt {
    BoxConstraintsObjSt (*boxConstraints)(double* minWidth, double* maxWidth, double* minHeight, double* maxHeight);
    BoxConstraintsObjSt (*tightFor)(double* width, double* height);
    BoxConstraintsObjSt (*tightForFinite)(double* width, double* height);
    BoxConstraintsObjSt (*expand)(double* width, double* height);
    BoxConstraintsObjSt (*lerp)(DartObj a, DartObj b, double t);
  } boxConstraints;

  struct ContainerSt {
    ContainerObjSt (*container)(DartObj* alignment, DartObj* padding, DartObj* color, DartObj* decoration, DartObj* foregroundDecoration, double* width, double* height, DartObj* constraints, DartObj* margin, DartObj* transformAlignment, DartObj* child, int* clipBehavior);
  } container;

  struct StackParentDataSt {
    DartObj (*stackParentData)(void);
  } stackParentData;

  struct BoxParentDataSt {
    DartObj (*boxParentData)(void);
  } boxParentData;

  struct ParentDataSt {
    DartObj (*parentData)(void);
  } parentData;

  struct PositionedSt {
    PositionedObjSt (*positioned)(double* left, double* top, double* right, double* bottom, double* width, double* height, DartObj child);
    PositionedObjSt (*fill)(double* left, double* top, double* right, double* bottom, DartObj child);
    PositionedObjSt (*directional)(int textDirection, double* start, double* top, double* end, double* bottom, double* width, double* height, DartObj child);
  } positioned;

  struct BoxDecorationSt {
    BoxDecorationObjSt (*boxDecoration)(DartObj* color, DartObj* border, DartObj* borderRadius, ArrayC* boxShadow, int* backgroundBlendMode, int* shape);
    BoxDecorationObjSt (*lerp)(DartObj a, DartObj b, double t);
  } boxDecoration;

  struct RadiusSt {
    DartObj (*circular)(double radius);
    DartObj (*elliptical)(double x, double y);
    DartObj (*lerp)(DartObj a, DartObj b, double t);
  } radius;

  struct BorderRadiusSt {
    BorderRadiusObjSt (*all)(DartObj radius);
    BorderRadiusObjSt (*circular)(double radius);
    BorderRadiusObjSt (*vertical)(DartObj* top, DartObj* bottom);
    BorderRadiusObjSt (*horizontal)(DartObj* left, DartObj* right);
    BorderRadiusObjSt (*only)(DartObj* topLeft, DartObj* topRight, DartObj* bottomLeft, DartObj* bottomRight);
    BorderRadiusObjSt (*lerp)(DartObj a, DartObj b, double t);
  } borderRadius;

  struct BoxShadowSt {
    BoxShadowObjSt (*boxShadow)(DartObj* color, DartObj* offset, double* blurRadius, double* spreadRadius, int* blurStyle);
    BoxShadowObjSt (*lerp)(DartObj a, DartObj b, double t);
  } boxShadow;

  struct ShadowSt {
    DartObj (*shadow)(DartObj* color, DartObj* offset, double* blurRadius);
    DartObj (*lerp)(DartObj a, DartObj b, double t);
  } shadow;

  struct PaddingSt {
    PaddingObjSt (*padding)(DartObj padding, DartObj* child);
  } padding;

  struct EdgeInsetsSt {
    EdgeInsetsObjSt (*fromLTRB)(double left, double top, double right, double bottom);
    EdgeInsetsObjSt (*all)(double value);
    EdgeInsetsObjSt (*only)(double* left, double* top, double* right, double* bottom);
    EdgeInsetsObjSt (*symmetric)(double* vertical, double* horizontal);
    EdgeInsetsObjSt (*lerp)(DartObj a, DartObj b, double t);
  } edgeInsets;

  struct BorderSideSt {
    BorderSideObjSt (*borderSide)(DartObj* color, double* width, int* style, double* strokeAlign);
    BorderSideObjSt (*merge)(DartObj a, DartObj b);
    BorderSideObjSt (*lerp)(DartObj a, DartObj b, double t);
  } borderSide;

  struct BorderSt {
    BorderObjSt (*border)(DartObj* top, DartObj* right, DartObj* bottom, DartObj* left);
    BorderObjSt (*fromBorderSide)(DartObj side);
    BorderObjSt (*symmetric)(DartObj* vertical, DartObj* horizontal);
    BorderObjSt (*all)(DartObj* color, double* width, int* style, double* strokeAlign);
    BorderObjSt (*merge)(DartObj a, DartObj b);
    BorderObjSt (*lerp)(DartObj a, DartObj b, double t);
  } border;

  struct RoundedRectangleBorderSt {
    RoundedRectangleBorderObjSt (*roundedRectangleBorder)(DartObj* side, DartObj* borderRadius);
  } roundedRectangleBorder;

  struct AnimationControllerSt {
    DartObj (*animationController)(double* value, char* debugLabel, double* lowerBound, double* upperBound, int* animationBehavior, DartObj vsync);
    DartObj (*unbounded)(double* value, char* debugLabel, DartObj vsync, int* animationBehavior);
  } animationController;

  struct AnimatedBuilderSt {
    AnimatedBuilderObjSt (*animatedBuilder)(DartObj animation, TransitionBuilderFFI builder, DartObj* child);
  } animatedBuilder;

  struct ListenableBuilderSt {
    ListenableBuilderObjSt (*listenableBuilder)(DartObj listenable, TransitionBuilderFFI builder, DartObj* child);
  } listenableBuilder;

  struct CubicSt {
    CubicObjSt (*cubic)(double a, double b, double c, double d);
  } cubic;

  struct ThreePointCubicSt {
    ThreePointCubicObjSt (*threePointCubic)(DartObj a1, DartObj b1, DartObj midpoint, DartObj a2, DartObj b2);
  } threePointCubic;

  struct ElasticOutCurveSt {
    ElasticOutCurveObjSt (*elasticOutCurve)(double* period);
  } elasticOutCurve;

  struct ElasticInCurveSt {
    ElasticInCurveObjSt (*elasticInCurve)(double* period);
  } elasticInCurve;

  struct ElasticInOutCurveSt {
    ElasticInOutCurveObjSt (*elasticInOutCurve)(double* period);
  } elasticInOutCurve;

  struct CurvedAnimationSt {
    DartObj (*curvedAnimation)(DartObj parent, DartObj curve, DartObj* reverseCurve);
  } curvedAnimation;

  struct SizedBoxSt {
    SizedBoxObjSt (*sizedBox)(double* width, double* height, DartObj* child);
    SizedBoxObjSt (*expand)(DartObj* child);
    SizedBoxObjSt (*shrink)(DartObj* child);
    SizedBoxObjSt (*fromSize)(DartObj* child);
    SizedBoxObjSt (*square)(DartObj* child, double* dimension);
  } sizedBox;

  struct AlignmentSt {
    AlignmentObjSt (*alignment)(double x, double y);
    AlignmentObjSt (*lerp)(DartObj a, DartObj b, double t);
  } alignment;

  struct ColorSchemeSt {
    ColorSchemeObjSt (*colorScheme)(int brightness, DartObj primary, DartObj onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj secondary, DartObj onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj error, DartObj onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj surface, DartObj onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*fromSeed)(DartObj seedColor, int* brightness, int* dynamicSchemeVariant, double* contrastLevel, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* outline, DartObj* outlineVariant, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* shadow, DartObj* scrim, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*light)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*dark)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*highContrastLight)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*highContrastDark)(int* brightness, DartObj* primary, DartObj* onPrimary, DartObj* primaryContainer, DartObj* onPrimaryContainer, DartObj* primaryFixed, DartObj* primaryFixedDim, DartObj* onPrimaryFixed, DartObj* onPrimaryFixedVariant, DartObj* secondary, DartObj* onSecondary, DartObj* secondaryContainer, DartObj* onSecondaryContainer, DartObj* secondaryFixed, DartObj* secondaryFixedDim, DartObj* onSecondaryFixed, DartObj* onSecondaryFixedVariant, DartObj* tertiary, DartObj* onTertiary, DartObj* tertiaryContainer, DartObj* onTertiaryContainer, DartObj* tertiaryFixed, DartObj* tertiaryFixedDim, DartObj* onTertiaryFixed, DartObj* onTertiaryFixedVariant, DartObj* error, DartObj* onError, DartObj* errorContainer, DartObj* onErrorContainer, DartObj* surface, DartObj* onSurface, DartObj* surfaceDim, DartObj* surfaceBright, DartObj* surfaceContainerLowest, DartObj* surfaceContainerLow, DartObj* surfaceContainer, DartObj* surfaceContainerHigh, DartObj* surfaceContainerHighest, DartObj* onSurfaceVariant, DartObj* outline, DartObj* outlineVariant, DartObj* shadow, DartObj* scrim, DartObj* inverseSurface, DartObj* onInverseSurface, DartObj* inversePrimary, DartObj* surfaceTint, DartObj* background, DartObj* onBackground, DartObj* surfaceVariant);
    ColorSchemeObjSt (*fromSwatch)(DartObj* primarySwatch, DartObj* accentColor, DartObj* cardColor, DartObj* backgroundColor, DartObj* errorColor, int* brightness);
    ColorSchemeObjSt (*lerp)(DartObj a, DartObj b, double t);
    ColorSchemeObjSt (*of)(DartObj context);
  } colorScheme;

  struct MaterialColorSt {
    MaterialColorObjSt (*materialColor)(int primary, MapC swatch);
  } materialColor;

  struct ColorSwatchSt {
    ColorSwatchObjSt (*lerp)(DartObj a, DartObj b, double t);
  } colorSwatch;

  struct TextThemeSt {
    TextThemeObjSt (*textTheme)(DartObj* displayLarge, DartObj* displayMedium, DartObj* displaySmall, DartObj* headlineLarge, DartObj* headlineMedium, DartObj* headlineSmall, DartObj* titleLarge, DartObj* titleMedium, DartObj* titleSmall, DartObj* bodyLarge, DartObj* bodyMedium, DartObj* bodySmall, DartObj* labelLarge, DartObj* labelMedium, DartObj* labelSmall);
    TextThemeObjSt (*lerp)(DartObj a, DartObj b, double t);
    TextThemeObjSt (*of)(DartObj context);
    TextThemeObjSt (*primaryOf)(DartObj context);
  } textTheme;

  struct ThemeDataSt {
    ThemeDataObjSt (*themeData)(int* applyElevationOverlayColor, int* materialTapTargetSize, int* platform, int* useMaterial3, DartObj* colorScheme, int* brightness, DartObj* colorSchemeSeed, DartObj* canvasColor, DartObj* cardColor, DartObj* disabledColor, DartObj* dividerColor, DartObj* focusColor, DartObj* highlightColor, DartObj* hintColor, DartObj* hoverColor, DartObj* indicatorColor, DartObj* primaryColor, DartObj* primaryColorDark, DartObj* primaryColorLight, DartObj* primarySwatch, DartObj* scaffoldBackgroundColor, DartObj* secondaryHeaderColor, DartObj* shadowColor, DartObj* splashColor, DartObj* unselectedWidgetColor, char* fontFamily, char*** fontFamilyFallback, char* package, DartObj* primaryTextTheme, DartObj* textTheme, DartObj* cardTheme, DartObj* dialogTheme, DartObj* tabBarTheme, DartObj* dialogBackgroundColor);
    ThemeDataObjSt (*from)(DartObj colorScheme, DartObj* textTheme, int* useMaterial3);
    ThemeDataObjSt (*light)(int* useMaterial3);
    ThemeDataObjSt (*dark)(int* useMaterial3);
    ThemeDataObjSt (*fallback)(int* useMaterial3);
    ThemeDataObjSt (*localize)(DartObj baseTheme, DartObj localTextGeometry);
    int (*estimateBrightnessForColor)(DartObj color);
    ThemeDataObjSt (*lerp)(DartObj a, DartObj b, double t);
  } themeData;

  struct MaterialAccentColorSt {
    MaterialAccentColorObjSt (*materialAccentColor)(int primary, MapC swatch);
  } materialAccentColor;

  struct MaterialSt {
    MaterialObjSt (*material)(int* type, double* elevation, DartObj* color, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* textStyle, DartObj* borderRadius, DartObj* shape, int* borderOnForeground, int* clipBehavior, DartObj* child);
  } material;

  struct IconButtonSt {
    IconButtonObjSt (*iconButton)(double* iconSize, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
    IconButtonObjSt (*filled)(double* iconSize, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
    IconButtonObjSt (*filledTonal)(double* iconSize, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
    IconButtonObjSt (*outlined)(double* iconSize, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
  } iconButton;

  struct AppBarSt {
    AppBarObjSt (*appBar)(DartObj* leading, int* automaticallyImplyLeading, DartObj* title, ArrayC* actions, DartObj* flexibleSpace, DartObj* bottom, double* elevation, double* scrolledUnderElevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* shape, DartObj* backgroundColor, DartObj* foregroundColor, int* primary, int* centerTitle, int* excludeHeaderSemantics, double* titleSpacing, double* toolbarOpacity, double* bottomOpacity, double* toolbarHeight, double* leadingWidth, DartObj* toolbarTextStyle, DartObj* titleTextStyle, int* forceMaterialTransparency, int* clipBehavior, DartObj* actionsPadding);
  } appBar;

  struct ScaffoldSt {
    ScaffoldObjSt (*scaffold)(DartObj* appBar, DartObj* body, DartObj* floatingActionButton, ArrayC* persistentFooterButtons, DartObj* drawer, DrawerCallbackFFI* onDrawerChanged, DartObj* endDrawer, DrawerCallbackFFI* onEndDrawerChanged, DartObj* bottomNavigationBar, DartObj* bottomSheet, DartObj* backgroundColor, int* resizeToAvoidBottomInset, int* primary, int* drawerDragStartBehavior, int* extendBody, int* extendBodyBehindAppBar, DartObj* drawerScrimColor, double* drawerEdgeDragWidth, int* drawerEnableOpenDragGesture, int* endDrawerEnableOpenDragGesture, char* restorationId);
    DartObj (*geometryOf)(DartObj context);
  } scaffold;

  struct MaterialAppSt {
    MaterialAppObjSt (*materialApp)(DartObj* home, char* initialRoute, TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, DartObj* themeAnimationCurve, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
    MaterialAppObjSt (*router)(TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, DartObj* themeAnimationCurve, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
  } materialApp;

  struct FloatingActionButtonSt {
    FloatingActionButtonObjSt (*floatingActionButton)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, int* mini, DartObj* shape, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* isExtended, int* enableFeedback);
    FloatingActionButtonObjSt (*small)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, DartObj* shape, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* enableFeedback);
    FloatingActionButtonObjSt (*large)(DartObj* child, char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, DartObj* shape, int* clipBehavior, int* autofocus, int* materialTapTargetSize, int* enableFeedback);
    FloatingActionButtonObjSt (*extended)(char* tooltip, DartObj* foregroundColor, DartObj* backgroundColor, DartObj* focusColor, DartObj* hoverColor, DartObj* heroTag, double* elevation, double* focusElevation, double* hoverElevation, DartObj* splashColor, double* highlightElevation, double* disabledElevation, VoidCallbackFFI onPressed, DartObj* shape, int* isExtended, int* materialTapTargetSize, int* clipBehavior, int* autofocus, double* extendedIconLabelSpacing, DartObj* extendedPadding, DartObj* extendedTextStyle, DartObj* icon, DartObj label, int* enableFeedback);
  } floatingActionButton;

  struct ThemeSt {
    ThemeObjSt (*theme)(DartObj data, DartObj child);
    ThemeDataObjSt (*of)(DartObj context);
  } theme;

  struct ElevatedButtonSt {
    ElevatedButtonObjSt (*elevatedButton)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj child);
    ElevatedButtonObjSt (*icon)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj* icon, DartObj label, int* iconAlignment);
  } elevatedButton;

  struct OutlinedButtonSt {
    OutlinedButtonObjSt (*outlinedButton)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj child);
    OutlinedButtonObjSt (*icon)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj* icon, DartObj label, int* iconAlignment);
  } outlinedButton;

  struct SubStateSt {
    SubStateObjSt (*subState)(VoidCallbackFFI initStateFn, VoidCallbackDartObjFFI didUpdateWidgetFn, VoidCallbackFFI reassembleFn, VoidCallbackFFI deactivateFn, VoidCallbackFFI activateFn, VoidCallbackFFI disposeFn, DartObjCallbackDartObjFFI buildFn, VoidCallbackFFI didChangeDependenciesFn);
  } subState;

  struct SubStatefulWidgetSt {
    SubStatefulWidgetObjSt (*subStatefulWidget)(DartObjCallbackFFI createStateFn);
  } subStatefulWidget;

  struct SubStatelessWidgetSt {
    SubStatelessWidgetObjSt (*subStatelessWidget)(DartObjCallbackDartObjFFI buildFn);
  } subStatelessWidget;

} WidgetFactories;
