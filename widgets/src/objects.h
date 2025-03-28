typedef struct {
  int id;
  int inherit;
  DartObj color;
  DartObj backgroundColor;
  char* fontFamily;
  double fontSize;
  int fontStyle;
  double letterSpacing;
  double wordSpacing;
  int textBaseline;
  double height;
  int leadingDistribution;
  DartObj decorationColor;
  int decorationStyle;
  double decorationThickness;
  char* debugLabel;
  int overflow;
  char** fontFamilyFallback;
} TextStyleObjSt;

typedef struct {
  int id;
  int codePoint;
  char* fontFamily;
  char* fontPackage;
  int matchTextDirection;
  char** fontFamilyFallback;
} IconDataObjSt;

typedef struct {
  int id;
  int brightness;
  DartObj primary;
  DartObj onPrimary;
  DartObj secondary;
  DartObj onSecondary;
  DartObj error;
  DartObj onError;
  DartObj surface;
  DartObj onSurface;
  DartObj primaryContainer;
  DartObj onPrimaryContainer;
  DartObj primaryFixed;
  DartObj primaryFixedDim;
  DartObj onPrimaryFixed;
  DartObj onPrimaryFixedVariant;
  DartObj secondaryContainer;
  DartObj onSecondaryContainer;
  DartObj secondaryFixed;
  DartObj secondaryFixedDim;
  DartObj onSecondaryFixed;
  DartObj onSecondaryFixedVariant;
  DartObj tertiary;
  DartObj onTertiary;
  DartObj tertiaryContainer;
  DartObj onTertiaryContainer;
  DartObj tertiaryFixed;
  DartObj tertiaryFixedDim;
  DartObj onTertiaryFixed;
  DartObj onTertiaryFixedVariant;
  DartObj errorContainer;
  DartObj onErrorContainer;
  DartObj surfaceVariant;
  DartObj surfaceDim;
  DartObj surfaceBright;
  DartObj surfaceContainerLowest;
  DartObj surfaceContainerLow;
  DartObj surfaceContainer;
  DartObj surfaceContainerHigh;
  DartObj surfaceContainerHighest;
  DartObj onSurfaceVariant;
  DartObj outline;
  DartObj outlineVariant;
  DartObj shadow;
  DartObj scrim;
  DartObj inverseSurface;
  DartObj onInverseSurface;
  DartObj inversePrimary;
  DartObj surfaceTint;
  DartObj background;
  DartObj onBackground;
} ColorSchemeObjSt;

typedef struct {
  int id;
  TextStyleObjSt displayLarge;
  TextStyleObjSt displayMedium;
  TextStyleObjSt displaySmall;
  TextStyleObjSt headlineLarge;
  TextStyleObjSt headlineMedium;
  TextStyleObjSt headlineSmall;
  TextStyleObjSt titleLarge;
  TextStyleObjSt titleMedium;
  TextStyleObjSt titleSmall;
  TextStyleObjSt bodyLarge;
  TextStyleObjSt bodyMedium;
  TextStyleObjSt bodySmall;
  TextStyleObjSt labelLarge;
  TextStyleObjSt labelMedium;
  TextStyleObjSt labelSmall;
} TextThemeObjSt;

typedef struct {
  int id;
  int applyElevationOverlayColor;
  int materialTapTargetSize;
  int platform;
  int useMaterial3;
  DartObj canvasColor;
  DartObj cardColor;
  ColorSchemeObjSt colorScheme;
  DartObj disabledColor;
  DartObj dividerColor;
  DartObj focusColor;
  DartObj highlightColor;
  DartObj hintColor;
  DartObj hoverColor;
  DartObj indicatorColor;
  DartObj primaryColor;
  DartObj primaryColorDark;
  DartObj primaryColorLight;
  DartObj scaffoldBackgroundColor;
  DartObj secondaryHeaderColor;
  DartObj shadowColor;
  DartObj splashColor;
  DartObj unselectedWidgetColor;
  TextThemeObjSt primaryTextTheme;
  TextThemeObjSt textTheme;
  DartObj dialogBackgroundColor;
  int brightness;
} ThemeDataObjSt;

typedef struct {
  int id;
  void (*setState)(VoidCallbackFFI fn);
} SubStateObjSt;

typedef struct {
  int id;
} SubStatefulWidgetObjSt;

