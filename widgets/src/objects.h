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
  DartObj decoration;
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
  char* semanticsIdentifier;
  int textWidthBasis;
  DartObj selectionColor;
} TextObjSt;

typedef struct {
  int id;
  char* text;
  char* semanticsLabel;
  char* semanticsIdentifier;
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
  DartObj fontWeight;
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
  int isAntiAlias;
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
  double start;
  double y;
} AlignmentDirectionalObjSt;

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
  int left;
  int top;
  int right;
  int bottom;
  EdgeInsetsObjSt minimum;
  int maintainBottomViewPadding;
  DartObj child;
} SafeAreaObjSt;

typedef struct {
  int id;
  AlignmentObjSt alignment;
  int filterQuality;
  DartObj child;
  DartObj animation;
} MatrixTransitionObjSt;

typedef struct {
  int id;
  DartObj turns;
} RotationTransitionObjSt;

typedef struct {
  int id;
  DartObj opacity;
  int alwaysIncludeSemantics;
} FadeTransitionObjSt;

typedef struct {
  int id;
  DartObj scale;
} ScaleTransitionObjSt;

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
  DartObj indicatorColor;
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
  int animateColor;
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
  int automaticallyImplyActions;
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
  int useDefaultSemanticsOrder;
  int clipBehavior;
  DartObj actionsPadding;
  int animateColor;
} AppBarObjSt;

typedef struct {
  int id;
  int extendBody;
  int drawerBarrierDismissible;
  int extendBodyBehindAppBar;
  DartObj appBar;
  DartObj body;
  DartObj floatingActionButton;
  AlignmentDirectionalObjSt persistentFooterAlignment;
  BoxDecorationObjSt persistentFooterDecoration;
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
  int routeDirectionalTraversalEdgeBehavior;
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
  BoxConstraintsObjSt constraints;
  int scrollable;
} AlertDialogObjSt;

typedef struct {
  int id;
  DartObj icon;
  DartObj iconColor;
  DartObj label;
  char* labelText;
  TextStyleObjSt labelStyle;
  TextStyleObjSt floatingLabelStyle;
  DartObj helper;
  char* helperText;
  TextStyleObjSt helperStyle;
  int helperMaxLines;
  char* hintText;
  DartObj hint;
  TextStyleObjSt hintStyle;
  int hintTextDirection;
  int hintMaxLines;
  DartObj hintFadeDuration;
  int maintainHintHeight;
  int maintainHintSize;
  int maintainLabelSize;
  DartObj error;
  char* errorText;
  TextStyleObjSt errorStyle;
  int errorMaxLines;
  int floatingLabelBehavior;
  int isDense;
  DartObj contentPadding;
  int isCollapsed;
  DartObj prefixIcon;
  BoxConstraintsObjSt prefixIconConstraints;
  DartObj prefix;
  char* prefixText;
  TextStyleObjSt prefixStyle;
  DartObj prefixIconColor;
  DartObj suffixIcon;
  DartObj suffix;
  char* suffixText;
  TextStyleObjSt suffixStyle;
  DartObj suffixIconColor;
  BoxConstraintsObjSt suffixIconConstraints;
  char* counterText;
  DartObj counter;
  TextStyleObjSt counterStyle;
  int filled;
  DartObj fillColor;
  DartObj focusColor;
  DartObj hoverColor;
  DartObj errorBorder;
  DartObj focusedBorder;
  DartObj focusedErrorBorder;
  DartObj disabledBorder;
  DartObj enabledBorder;
  DartObj border;
  int enabled;
  char* semanticCounterText;
  int alignLabelWithHint;
  BoxConstraintsObjSt constraints;
  VisualDensityObjSt visualDensity;
} InputDecorationObjSt;

typedef struct {
  int id;
  InputDecorationObjSt decoration;
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
  int selectAllOnFocus;
  int dragStartBehavior;
  int onTapAlwaysCalled;
  int clipBehavior;
  char* restorationId;
  int scribbleEnabled;
  int stylusHandwritingEnabled;
  int enableIMEPersonalizedLearning;
  int enableInlinePrediction;
  int canRequestFocus;
  int selectionEnabled;
} TextFieldObjSt;

typedef struct {
  int id;
  double height;
  double thickness;
  double indent;
  double endIndent;
  DartObj radius;
  DartObj color;
} DividerObjSt;

typedef struct {
  int id;
} FilledButtonObjSt;

typedef struct {
  int id;
  double gapPadding;
  BorderRadiusObjSt borderRadius;
} OutlineInputBorderObjSt;

typedef struct {
  int id;
  DartObj textColor;
  DartObj backgroundColor;
  DartObj disabledTextColor;
  DartObj disabledBackgroundColor;
  char* label;
} SnackBarActionObjSt;

typedef struct {
  int id;
  DartObj content;
  DartObj backgroundColor;
  double elevation;
  DartObj margin;
  DartObj padding;
  double width;
  DartObj shape;
  int hitTestBehavior;
  int behavior;
  SnackBarActionObjSt action;
  double actionOverflowThreshold;
  int showCloseIcon;
  DartObj closeIconColor;
  DartObj duration;
  int persist;
  DartObj animation;
  int dismissDirection;
  int clipBehavior;
} SnackBarObjSt;

typedef struct {
  int id;
  DartObj child;
} ScaffoldMessengerObjSt;

typedef struct {
  int id;
  DartObj color;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  double elevation;
  DartObj shape;
  int borderOnForeground;
  int clipBehavior;
  DartObj margin;
  int semanticContainer;
  DartObj child;
} CardObjSt;

typedef struct {
  int id;
  DartObj avatar;
  DartObj label;
  TextStyleObjSt labelStyle;
  DartObj labelPadding;
  BorderSideObjSt side;
  DartObj shape;
  int clipBehavior;
  int autofocus;
  DartObj backgroundColor;
  DartObj padding;
  VisualDensityObjSt visualDensity;
  DartObj deleteIcon;
  DartObj deleteIconColor;
  char* deleteButtonTooltipMessage;
  int materialTapTargetSize;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  BoxConstraintsObjSt avatarBoxConstraints;
  BoxConstraintsObjSt deleteIconBoxConstraints;
} ChipObjSt;

typedef struct {
  int id;
  DartObj child;
  int behavior;
  int excludeFromSemantics;
  int dragStartBehavior;
  int trackpadScrollCausesScale;
  DartObj trackpadScrollToScaleFactor;
} GestureDetectorObjSt;

typedef struct {
  int id;
  DartObj leading;
  DartObj title;
  DartObj subtitle;
  DartObj trailing;
  int isThreeLine;
  int dense;
  VisualDensityObjSt visualDensity;
  DartObj shape;
  DartObj selectedColor;
  DartObj iconColor;
  DartObj textColor;
  TextStyleObjSt titleTextStyle;
  TextStyleObjSt subtitleTextStyle;
  TextStyleObjSt leadingAndTrailingTextStyle;
  int style;
  DartObj contentPadding;
  int enabled;
  int selected;
  DartObj focusColor;
  DartObj hoverColor;
  DartObj splashColor;
  int autofocus;
  DartObj tileColor;
  DartObj selectedTileColor;
  int enableFeedback;
  double horizontalTitleGap;
  double minVerticalPadding;
  double minLeadingWidth;
  double minTileHeight;
  int titleAlignment;
  int internalAddSemanticForOnTap;
} ListTileObjSt;

typedef struct {
  int id;
  int direction;
  int alignment;
  double spacing;
  int runAlignment;
  double runSpacing;
  int crossAxisAlignment;
  int textDirection;
  int verticalDirection;
  int clipBehavior;
} WrapObjSt;

typedef struct {
  int id;
  int scrollDirection;
  int reverse;
  DartObj padding;
  int primary;
  DartObj child;
  int dragStartBehavior;
  int clipBehavior;
  int hitTestBehavior;
  char* restorationId;
  int keyboardDismissBehavior;
} SingleChildScrollViewObjSt;

typedef struct {
  int id;
  double strokeWidth;
  double strokeAlign;
  int strokeCap;
  BoxConstraintsObjSt constraints;
  double trackGap;
  int year2023;
  DartObj padding;
  DartObj controller;
} CircularProgressIndicatorObjSt;

typedef struct {
  int id;
  double minHeight;
  DartObj borderRadius;
  DartObj stopIndicatorColor;
  double stopIndicatorRadius;
  double trackGap;
  int year2023;
  DartObj controller;
} LinearProgressIndicatorObjSt;

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

typedef struct {
  int id;
} AnimatedWrapperObjSt;

