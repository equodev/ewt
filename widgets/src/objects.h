typedef struct {
  int id;
  int inherit;
  DartObj color;
  DartObj backgroundColor;
  char* fontFamily;
  double fontSize;
  DartObj fontWeight;
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
} TextStyleObjSt;

typedef struct {
  int id;
  char* data;
  DartObj textSpan;
  TextStyleObjSt style;
  int textAlign;
  int textDirection;
  int softWrap;
  int overflow;
  double textScaleFactor;
  int maxLines;
  char* semanticsLabel;
  int textWidthBasis;
  DartObj selectionColor;
} TextObjSt;

typedef struct {
  int id;
  char* text;
  char* semanticsLabel;
  int spellOut;
} TextSpanObjSt;

typedef struct {
  int id;
  DartObj text;
  int textAlign;
  int textDirection;
  int softWrap;
  int overflow;
  int maxLines;
  int textWidthBasis;
  DartObj selectionColor;
  double textScaleFactor;
} RichTextObjSt;

typedef struct {
  int id;
} CenterObjSt;

typedef struct {
  int id;
  DartObj alignment;
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
} RowObjSt;

typedef struct {
  int id;
  int codePoint;
  char* fontFamily;
  char* fontPackage;
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
  char* semanticLabel;
  int textDirection;
  int applyTextScaling;
  int blendMode;
} IconObjSt;

typedef struct {
  int id;
  DartObj origin;
  DartObj alignment;
  int transformHitTests;
  int filterQuality;
} TransformObjSt;

typedef struct {
  int id;
  double opacity;
  int alwaysIncludeSemantics;
} OpacityObjSt;

typedef struct {
  int id;
  DartObj alignment;
  int textDirection;
  int fit;
  int clipBehavior;
} StackObjSt;

typedef struct {
  int id;
  double minWidth;
  double maxWidth;
  double minHeight;
  double maxHeight;
  int hasTightWidth;
  int hasTightHeight;
  int hasBoundedWidth;
  int hasBoundedHeight;
  int hasInfiniteWidth;
  int hasInfiniteHeight;
} BoxConstraintsObjSt;

typedef struct {
  int id;
  DartObj child;
  DartObj alignment;
  DartObj padding;
  DartObj color;
  DartObj decoration;
  DartObj foregroundDecoration;
  BoxConstraintsObjSt constraints;
  DartObj margin;
  DartObj transformAlignment;
  int clipBehavior;
} ContainerObjSt;

typedef struct {
  int id;
  double left;
  double top;
  double right;
  double bottom;
  double width;
  double height;
} PositionedObjSt;

typedef struct {
  int id;
  DartObj color;
  DartObj border;
  DartObj borderRadius;
  int backgroundBlendMode;
  int shape;
} BoxDecorationObjSt;

typedef struct {
  int id;
  DartObj topLeft;
  DartObj topRight;
  DartObj bottomLeft;
  DartObj bottomRight;
} BorderRadiusObjSt;

typedef struct {
  int id;
  double spreadRadius;
  int blurStyle;
} BoxShadowObjSt;

typedef struct {
  int id;
  DartObj padding;
} PaddingObjSt;

typedef struct {
  int id;
  double left;
  double top;
  double right;
  double bottom;
  DartObj topLeft;
  DartObj topRight;
  DartObj bottomLeft;
  DartObj bottomRight;
} EdgeInsetsObjSt;

typedef struct {
  int id;
  DartObj color;
  double width;
  int style;
  double strokeAlign;
  double strokeInset;
  double strokeOutset;
  double strokeOffset;
} BorderSideObjSt;

typedef struct {
  int id;
  BorderSideObjSt top;
  BorderSideObjSt right;
  BorderSideObjSt bottom;
  BorderSideObjSt left;
} BorderObjSt;

typedef struct {
  int id;
  DartObj borderRadius;
} RoundedRectangleBorderObjSt;

typedef struct {
  int id;
  DartObj animation;
} AnimatedBuilderObjSt;

typedef struct {
  int id;
  DartObj child;
} ListenableBuilderObjSt;

typedef struct {
  int id;
  double a;
  double b;
  double c;
  double d;
} CubicObjSt;

typedef struct {
  int id;
  DartObj a1;
  DartObj b1;
  DartObj midpoint;
  DartObj a2;
  DartObj b2;
} ThreePointCubicObjSt;

typedef struct {
  int id;
  double period;
} ElasticOutCurveObjSt;

typedef struct {
  int id;
  double period;
} ElasticInCurveObjSt;

typedef struct {
  int id;
  double period;
} ElasticInOutCurveObjSt;

typedef struct {
  int id;
  double width;
  double height;
} SizedBoxObjSt;

typedef struct {
  int id;
  double x;
  double y;
} AlignmentObjSt;

typedef struct {
  int id;
  int opaque;
  int hitTestBehavior;
} MouseRegionObjSt;

typedef struct {
  int id;
} ExpandedObjSt;

typedef struct {
  int id;
  int flex;
  int fit;
} FlexibleObjSt;

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
  double horizontal;
  double vertical;
  DartObj baseSizeAdjustment;
} VisualDensityObjSt;

typedef struct {
  int id;
  int applyElevationOverlayColor;
  int materialTapTargetSize;
  int platform;
  int useMaterial3;
  VisualDensityObjSt visualDensity;
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
  DartObj child;
  int type;
  double elevation;
  DartObj color;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  TextStyleObjSt textStyle;
  DartObj shape;
  int borderOnForeground;
  int clipBehavior;
  DartObj animationDuration;
  DartObj borderRadius;
} MaterialObjSt;

typedef struct {
  int id;
  double iconSize;
  VisualDensityObjSt visualDensity;
  DartObj padding;
  DartObj alignment;
  double splashRadius;
  DartObj icon;
  DartObj focusColor;
  DartObj hoverColor;
  DartObj color;
  DartObj splashColor;
  DartObj highlightColor;
  DartObj disabledColor;
  int autofocus;
  char* tooltip;
  int enableFeedback;
  BoxConstraintsObjSt constraints;
  int isSelected;
  DartObj selectedIcon;
} IconButtonObjSt;

typedef struct {
  int id;
  DartObj leading;
  int automaticallyImplyLeading;
  DartObj title;
  DartObj flexibleSpace;
  DartObj bottom;
  double elevation;
  double scrolledUnderElevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj shape;
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
  DartObj actionsPadding;
} AppBarObjSt;

typedef struct {
  int id;
  int extendBody;
  int extendBodyBehindAppBar;
  DartObj appBar;
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
  char* restorationId;
} ScaffoldObjSt;

typedef struct {
  int id;
  DartObj home;
  char* initialRoute;
  char* title;
  ThemeDataObjSt theme;
  ThemeDataObjSt darkTheme;
  ThemeDataObjSt highContrastTheme;
  ThemeDataObjSt highContrastDarkTheme;
  int themeMode;
  DartObj themeAnimationDuration;
  DartObj themeAnimationCurve;
  DartObj color;
  int showPerformanceOverlay;
  int checkerboardRasterCacheImages;
  int checkerboardOffscreenLayers;
  int showSemanticsDebugger;
  int debugShowCheckedModeBanner;
  char* restorationScopeId;
  int debugShowMaterialGrid;
  int useInheritedMediaQuery;
} MaterialAppObjSt;

typedef struct {
  int id;
  DartObj child;
  char* tooltip;
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
  DartObj shape;
  int clipBehavior;
  int isExtended;
  int autofocus;
  int materialTapTargetSize;
  int enableFeedback;
  double extendedIconLabelSpacing;
  DartObj extendedPadding;
  TextStyleObjSt extendedTextStyle;
} FloatingActionButtonObjSt;

typedef struct {
  int id;
  ThemeDataObjSt data;
  DartObj child;
} ThemeObjSt;

typedef struct {
  int id;
} ElevatedButtonObjSt;

typedef struct {
  int id;
} OutlinedButtonObjSt;

typedef struct {
  int id;
} TextButtonObjSt;

typedef struct {
  int id;
  char* initialRoute;
  char* restorationScopeId;
  int routeTraversalEdgeBehavior;
  int reportsRouteUpdateToEngine;
  int clipBehavior;
  int requestFocus;
} NavigatorObjSt;

typedef struct {
  int id;
  DartObj icon;
  DartObj iconColor;
  DartObj iconPadding;
  DartObj title;
  DartObj titlePadding;
  TextStyleObjSt titleTextStyle;
  DartObj content;
  DartObj contentPadding;
  TextStyleObjSt contentTextStyle;
  DartObj actionsPadding;
  int actionsAlignment;
  int actionsOverflowAlignment;
  int actionsOverflowDirection;
  double actionsOverflowButtonSpacing;
  DartObj buttonPadding;
  DartObj backgroundColor;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  char* semanticLabel;
  EdgeInsetsObjSt insetPadding;
  int clipBehavior;
  DartObj shape;
  DartObj alignment;
  int scrollable;
} AlertDialogObjSt;

typedef struct {
  int id;
  int textInputAction;
  int textCapitalization;
  TextStyleObjSt style;
  int textAlign;
  int textDirection;
  int autofocus;
  char* obscuringCharacter;
  int obscureText;
  int autocorrect;
  int smartDashesType;
  int smartQuotesType;
  int enableSuggestions;
  int maxLines;
  int minLines;
  int expands;
  int readOnly;
  int showCursor;
  int maxLength;
  int maxLengthEnforcement;
  int enabled;
  int ignorePointers;
  double cursorWidth;
  double cursorHeight;
  DartObj cursorRadius;
  int cursorOpacityAnimates;
  DartObj cursorColor;
  DartObj cursorErrorColor;
  int selectionHeightStyle;
  int selectionWidthStyle;
  int keyboardAppearance;
  EdgeInsetsObjSt scrollPadding;
  int enableInteractiveSelection;
  int dragStartBehavior;
  int onTapAlwaysCalled;
  int clipBehavior;
  char* restorationId;
  int scribbleEnabled;
  int stylusHandwritingEnabled;
  int enableIMEPersonalizedLearning;
  int canRequestFocus;
  int selectionEnabled;
} TextFieldObjSt;

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

