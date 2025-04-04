typedef struct {
  int id;
  int inherit;
  DartObj color;
  DartObj backgroundColor;
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
  int overflow;
} TextStyleObjSt;

typedef struct {
  int id;
  DartObj textSpan;
  TextStyleObjSt style;
  int textAlign;
  int textDirection;
  int softWrap;
  int overflow;
  double textScaleFactor;
  int maxLines;
  int textWidthBasis;
  DartObj selectionColor;
} TextObjSt;

typedef struct {
  int id;
} CenterObjSt;

typedef struct {
  int id;
  double widthFactor;
  double heightFactor;
} AlignObjSt;

typedef struct {
  int id;
} ColumnObjSt;

typedef struct {
  int id;
  int direction;
  int mainAxisAlignment;
  int mainAxisSize;
  int crossAxisAlignment;
  int textDirection;
  int verticalDirection;
  int textBaseline;
  int clipBehavior;
  double spacing;
} FlexObjSt;

typedef struct {
  int id;
  int codePoint;
  int matchTextDirection;
} IconDataObjSt;

typedef struct {
  int id;
  IconDataObjSt icon;
  double size;
  double fill;
  double weight;
  double grade;
  double opticalSize;
  DartObj color;
  int textDirection;
  int applyTextScaling;
  int blendMode;
} IconObjSt;

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
  DartObj shade50;
  DartObj shade100;
  DartObj shade200;
  DartObj shade300;
  DartObj shade400;
  DartObj shade500;
  DartObj shade600;
  DartObj shade700;
  DartObj shade800;
  DartObj shade900;
} MaterialColorObjSt;

typedef struct {
  int id;
} ColorSwatchObjSt;

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
  DartObj shade100;
  DartObj shade200;
  DartObj shade400;
  DartObj shade700;
} MaterialAccentColorObjSt;

typedef struct {
  int id;
  DartObj leading;
  int automaticallyImplyLeading;
  DartObj title;
  DartObj flexibleSpace;
  double elevation;
  double scrolledUnderElevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj backgroundColor;
  DartObj foregroundColor;
  int primary;
  int centerTitle;
  int excludeHeaderSemantics;
  double titleSpacing;
  double toolbarOpacity;
  double bottomOpacity;
  double toolbarHeight;
  double leadingWidth;
  TextStyleObjSt toolbarTextStyle;
  TextStyleObjSt titleTextStyle;
  int forceMaterialTransparency;
  int clipBehavior;
} AppBarObjSt;

typedef struct {
  int id;
  int extendBody;
  int extendBodyBehindAppBar;
  DartObj body;
  DartObj floatingActionButton;
  DartObj drawer;
  DartObj endDrawer;
  DartObj drawerScrimColor;
  DartObj backgroundColor;
  DartObj bottomNavigationBar;
  DartObj bottomSheet;
  int resizeToAvoidBottomInset;
  int primary;
  int drawerDragStartBehavior;
  double drawerEdgeDragWidth;
  int drawerEnableOpenDragGesture;
  int endDrawerEnableOpenDragGesture;
} ScaffoldObjSt;

typedef struct {
  int id;
  DartObj home;
  ThemeDataObjSt theme;
  ThemeDataObjSt darkTheme;
  ThemeDataObjSt highContrastTheme;
  ThemeDataObjSt highContrastDarkTheme;
  int themeMode;
  DartObj color;
  int showPerformanceOverlay;
  int checkerboardRasterCacheImages;
  int checkerboardOffscreenLayers;
  int showSemanticsDebugger;
  int debugShowCheckedModeBanner;
  int debugShowMaterialGrid;
  int useInheritedMediaQuery;
} MaterialAppObjSt;

typedef struct {
  int id;
  DartObj child;
  DartObj foregroundColor;
  DartObj backgroundColor;
  DartObj focusColor;
  DartObj hoverColor;
  DartObj splashColor;
  double elevation;
  double focusElevation;
  double hoverElevation;
  double highlightElevation;
  double disabledElevation;
  int mini;
  int clipBehavior;
  int isExtended;
  int autofocus;
  int materialTapTargetSize;
  int enableFeedback;
  double extendedIconLabelSpacing;
  TextStyleObjSt extendedTextStyle;
} FloatingActionButtonObjSt;

typedef struct {
  int id;
  ThemeDataObjSt data;
  DartObj child;
} ThemeObjSt;

typedef struct {
  int id;
  DartObj (*widget)(void);
  DartObj (*context)(void);
  int (*mounted)(void);
  void (*setState)(VoidCallbackFFI fn);
} SubStateObjSt;

typedef struct {
  int id;
} SubStatefulWidgetObjSt;

typedef struct {
  int id;
} SubStatelessWidgetObjSt;

