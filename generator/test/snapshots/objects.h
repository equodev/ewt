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
  int hour;
  int minute;
  int period;
  int hourOfPeriod;
  int periodOffset;
} TimeOfDayObjSt;
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
} PointerEnterEventObjSt;
typedef struct {
  int id;
} PointerExitEventObjSt;
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
  double spreadRadius;
  int blurStyle;
} BoxShadowObjSt;
typedef struct {
  int id;
  DartObj topLeft;
  DartObj topRight;
  DartObj bottomLeft;
  DartObj bottomRight;
} BorderRadiusObjSt;
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
  DartObj pixelsPerSecond;
} VelocityObjSt;
typedef struct {
  int id;
} PointerDownEventObjSt;
typedef struct {
  int id;
} PointerUpEventObjSt;
typedef struct {
  int id;
} PointerHoverEventObjSt;
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
  double aspectRatio;
} AspectRatioObjSt;
typedef struct {
  int id;
  int clipBehavior;
} ClipOvalObjSt;
typedef struct {
  int id;
  DartObj borderRadius;
  int clipBehavior;
} ClipRRectObjSt;
typedef struct {
  int id;
  int clipBehavior;
} ClipRectObjSt;
typedef struct {
  int id;
  DartObj borderRadius;
  int clipBehavior;
} ClipRSuperellipseObjSt;
typedef struct {
  int id;
  DartObj color;
} ColoredBoxObjSt;
typedef struct {
  int id;
  BoxConstraintsObjSt constraints;
} ConstrainedBoxObjSt;
typedef struct {
  int id;
  DartObj decoration;
  int position;
} DecoratedBoxObjSt;
typedef struct {
  int id;
  int fit;
  DartObj alignment;
  int clipBehavior;
} FittedBoxObjSt;
typedef struct {
  int id;
  double widthFactor;
  double heightFactor;
  DartObj alignment;
} FractionallySizedBoxObjSt;
typedef struct {
  int id;
} IntrinsicHeightObjSt;
typedef struct {
  int id;
  double stepWidth;
  double stepHeight;
} IntrinsicWidthObjSt;
typedef struct {
  int id;
  double maxWidth;
  double maxHeight;
} LimitedBoxObjSt;
typedef struct {
  int id;
  DartObj color;
  double strokeWidth;
  double fallbackWidth;
  double fallbackHeight;
  DartObj child;
} PlaceholderObjSt;
typedef struct {
  int id;
  int flex;
} SpacerObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj replacement;
  int visible;
  int maintainState;
  int maintainAnimation;
  int maintainSize;
  int maintainSemantics;
  int maintainInteractivity;
  int maintainFocusability;
} VisibilityObjSt;
typedef struct {
  int id;
  int quarterTurns;
} RotatedBoxObjSt;
typedef struct {
  int id;
  double baseline;
  int baselineType;
} BaselineObjSt;
typedef struct {
  int id;
  TextStyleObjSt style;
  int textAlign;
  int softWrap;
  int overflow;
  int maxLines;
  int textWidthBasis;
} DefaultTextStyleObjSt;
typedef struct {
  int id;
  int textDirection;
} DirectionalityObjSt;
typedef struct {
  int id;
  DartObj alignment;
  double minWidth;
  double maxWidth;
  double minHeight;
  double maxHeight;
  int fit;
} OverflowBoxObjSt;
typedef struct {
  int id;
  int absorbing;
  int ignoringSemantics;
} AbsorbPointerObjSt;
typedef struct {
  int id;
  int ignoring;
  int ignoringSemantics;
} IgnorePointerObjSt;
typedef struct {
  int id;
} RepaintBoundaryObjSt;
typedef struct {
  int id;
  DartObj translation;
  int transformHitTests;
} FractionalTranslationObjSt;
typedef struct {
  int id;
  int textDirection;
  DartObj alignment;
  int constrainedAxis;
  int clipBehavior;
  DartObj child;
} UnconstrainedBoxObjSt;
typedef struct {
  int id;
  double size;
  DartObj textColor;
  int style;
  DartObj duration;
  DartObj curve;
} FlutterLogoObjSt;
typedef struct {
  int id;
  int shape;
  int clipBehavior;
  BorderRadiusObjSt borderRadius;
  double elevation;
  DartObj color;
  DartObj shadowColor;
} PhysicalModelObjSt;
typedef struct {
  int id;
  DartObj child;
  char* message;
  int textDirection;
  int location;
  int layoutDirection;
  DartObj color;
  TextStyleObjSt textStyle;
  BoxShadowObjSt shadow;
} BannerObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj alignment;
  DartObj padding;
  DartObj decoration;
  DartObj foregroundDecoration;
  BoxConstraintsObjSt constraints;
  DartObj margin;
  DartObj transformAlignment;
  int clipBehavior;
} AnimatedContainerObjSt;
typedef struct {
  int id;
  DartObj child;
  double opacity;
  int alwaysIncludeSemantics;
} AnimatedOpacityObjSt;
typedef struct {
  int id;
  DartObj padding;
  DartObj child;
} AnimatedPaddingObjSt;
typedef struct {
  int id;
  DartObj alignment;
  DartObj child;
  double heightFactor;
  double widthFactor;
} AnimatedAlignObjSt;
typedef struct {
  int id;
  double itemExtent;
  DartObj prototypeItem;
} ListViewObjSt;
typedef struct {
  int id;
} GridViewObjSt;
typedef struct {
  int id;
  int allowImplicitScrolling;
  char* restorationId;
  int scrollDirection;
  int reverse;
  int pageSnapping;
  int dragStartBehavior;
  int clipBehavior;
  int hitTestBehavior;
  int padEnds;
} PageViewObjSt;
typedef struct {
  int id;
  double diameterRatio;
  double perspective;
  double offAxisFraction;
  int useMagnifier;
  double magnification;
  double overAndUnderCenterOpacity;
  double itemExtent;
  double squeeze;
  int renderChildrenOutsideViewport;
  int clipBehavior;
  int hitTestBehavior;
  char* restorationId;
  int dragStartBehavior;
  int changeReportingBehavior;
} ListWheelScrollViewObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj alignment;
  DartObj curve;
  DartObj duration;
  DartObj reverseDuration;
  int clipBehavior;
} AnimatedSizeObjSt;
typedef struct {
  int id;
  DartObj child;
  double scale;
  AlignmentObjSt alignment;
  int filterQuality;
} AnimatedScaleObjSt;
typedef struct {
  int id;
  DartObj child;
  double turns;
  AlignmentObjSt alignment;
  int filterQuality;
} AnimatedRotationObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj offset;
} AnimatedSlideObjSt;
typedef struct {
  int id;
  DartObj firstChild;
  DartObj secondChild;
  int crossFadeState;
  DartObj duration;
  DartObj reverseDuration;
  DartObj firstCurve;
  DartObj secondCurve;
  DartObj sizeCurve;
  DartObj alignment;
  int excludeBottomFocus;
} AnimatedCrossFadeObjSt;
typedef struct {
  int id;
  int textDirection;
  int transformHitTests;
  DartObj child;
  DartObj position;
} SlideTransitionObjSt;
typedef struct {
  int id;
  int axis;
  double axisAlignment;
  double fixedCrossAxisSizeFactor;
  DartObj child;
  DartObj sizeFactor;
} SizeTransitionObjSt;
typedef struct {
  int id;
  DartObj alignment;
  int textDirection;
  int clipBehavior;
  int sizing;
  int index;
} IndexedStackObjSt;
typedef struct {
  int id;
  AlignmentObjSt alignment;
  int clipBehavior;
  int panAxis;
  EdgeInsetsObjSt boundaryMargin;
  DartObj child;
  int constrained;
  int panEnabled;
  int scaleEnabled;
  int trackpadScrollCausesScale;
  double scaleFactor;
  double maxScale;
  double minScale;
  double interactionEndFrictionCoefficient;
} InteractiveViewerObjSt;
typedef struct {
  int id;
  int axis;
  DartObj child;
  DartObj childWhenDragging;
  DartObj feedback;
  DartObj feedbackOffset;
  int ignoringFeedbackSemantics;
  int ignoringFeedbackPointer;
  int affinity;
  int maxSimultaneousDrags;
  int rootOverlay;
  int hitTestBehavior;
} DraggableObjSt;
typedef struct {
  int id;
  int hitTestBehavior;
} DragTargetObjSt;
typedef struct {
  int id;
  DartObj child;
  int transitionOnUserGestures;
} HeroObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj duration;
  DartObj reverseDuration;
  DartObj switchInCurve;
  DartObj switchOutCurve;
} AnimatedSwitcherObjSt;
typedef struct {
  int id;
  DartObj filter;
  int blendMode;
  int enabled;
} BackdropFilterObjSt;
typedef struct {
  int id;
  DartObj colorFilter;
} ColorFilteredObjSt;
typedef struct {
  int id;
  DartObj imageFilter;
  int enabled;
} ImageFilteredObjSt;
typedef struct {
  int id;
  DartObj child;
  int enabled;
} HeroModeObjSt;
typedef struct {
  int id;
  int blocking;
} BlockSemanticsObjSt;
typedef struct {
  int id;
} MergeSemanticsObjSt;
typedef struct {
  int id;
  int excluding;
} ExcludeSemanticsObjSt;
typedef struct {
  int id;
  int index;
} IndexedSemanticsObjSt;
typedef struct {
  int id;
  DartObj child;
} AutomaticKeepAliveObjSt;
typedef struct {
  int id;
} SliverToBoxAdapterObjSt;
typedef struct {
  int id;
  int mainAxis;
  int reverse;
} ListBodyObjSt;
typedef struct {
  int id;
  DartObj color;
  double interval;
  int divisions;
  int subdivisions;
  DartObj child;
} GridPaperObjSt;
typedef struct {
  int id;
  DartObj leading;
  DartObj middle;
  DartObj trailing;
  int centerMiddle;
  double middleSpacing;
} NavigationToolbarObjSt;
typedef struct {
  int id;
  DartObj child;
} CheckedModeBannerObjSt;
typedef struct {
  int id;
} IgnoreBaselineObjSt;
typedef struct {
  int id;
  int enabled;
  DartObj child;
} TickerModeObjSt;
typedef struct {
  int id;
} TapRegionSurfaceObjSt;
typedef struct {
  int id;
} LookupBoundaryObjSt;
typedef struct {
  int id;
  DartObj child;
  TextStyleObjSt labelStyle;
} SemanticsDebuggerObjSt;
typedef struct {
  int id;
  int excluding;
  DartObj child;
} ExcludeFocusObjSt;
typedef struct {
  int id;
  int excluding;
  DartObj child;
} ExcludeFocusTraversalObjSt;
typedef struct {
  int id;
  DartObj child;
  int onDisposeAction;
} AutofillGroupObjSt;
typedef struct {
  int id;
  double start;
  double top;
  double end;
  double bottom;
  double width;
  double height;
  DartObj child;
} PositionedDirectionalObjSt;
typedef struct {
  int id;
  double width;
  double thickness;
  double indent;
  double endIndent;
  DartObj color;
  DartObj radius;
} VerticalDividerObjSt;
typedef struct {
  int id;
  int isExpanded;
  double size;
  DartObj padding;
  DartObj color;
  DartObj disabledColor;
  DartObj expandedColor;
  DartObj splashColor;
  DartObj highlightColor;
} ExpandIconObjSt;
typedef struct {
  int id;
  DartObj padding;
} SliverPaddingObjSt;
typedef struct {
  int id;
  double opacity;
  int alwaysIncludeSemantics;
} SliverOpacityObjSt;
typedef struct {
  int id;
  int ignoring;
  int ignoringSemantics;
} SliverIgnorePointerObjSt;
typedef struct {
  int id;
  int offstage;
} SliverOffstageObjSt;
typedef struct {
  int id;
  int left;
  int top;
  int right;
  int bottom;
  EdgeInsetsObjSt minimum;
  DartObj sliver;
} SliverSafeAreaObjSt;
typedef struct {
  int id;
  DartObj sliver;
  DartObj replacementSliver;
  int visible;
  int maintainState;
  int maintainAnimation;
  int maintainSize;
  int maintainSemantics;
  int maintainInteractivity;
} SliverVisibilityObjSt;
typedef struct {
  int id;
} SliverMainAxisGroupObjSt;
typedef struct {
  int id;
} SliverCrossAxisGroupObjSt;
typedef struct {
  int id;
  DartObj child;
  int hasScrollBody;
  int fillOverscroll;
} SliverFillRemainingObjSt;
typedef struct {
  int id;
} SliverEnsureSemanticsObjSt;
typedef struct {
  int id;
  double maxExtent;
  DartObj sliver;
} SliverConstrainedCrossAxisObjSt;
typedef struct {
  int id;
} CustomScrollViewObjSt;
typedef struct {
  int id;
  DartObj decoration;
  DartObj padding;
  DartObj margin;
  DartObj duration;
  DartObj curve;
  DartObj child;
} DrawerHeaderObjSt;
typedef struct {
  int id;
  DartObj child;
} SelectionAreaObjSt;
typedef struct {
  int id;
} SizeChangedLayoutNotifierObjSt;
typedef struct {
  int id;
  DartObj child;
} DraggableScrollableActuatorObjSt;
typedef struct {
  int id;
  DartObj child;
} ScrollNotificationObserverObjSt;
typedef struct {
  int id;
  DartObj color;
  int dismissible;
  int barrierSemanticsDismissible;
  char* semanticsLabel;
  char* semanticsOnTapHint;
} ModalBarrierObjSt;
typedef struct {
  int id;
  int behavior;
} ListenerObjSt;
typedef struct {
  int id;
  double spacing;
  int alignment;
  double overflowSpacing;
  int overflowAlignment;
  int overflowDirection;
  int textDirection;
} OverflowBarObjSt;
typedef struct {
  int id;
  DartObj cursorColor;
  DartObj selectionColor;
} DefaultSelectionStyleObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj padding;
  DartObj decoration;
  double width;
  double height;
} InkObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj padding;
  DartObj color;
  double elevation;
  int clipBehavior;
  double notchMargin;
  DartObj surfaceTintColor;
  DartObj shadowColor;
  double height;
} BottomAppBarObjSt;
typedef struct {
  int id;
  double horizontal;
  double vertical;
  DartObj baseSizeAdjustment;
} VisualDensityObjSt;
typedef struct {
  int id;
  DartObj avatar;
  DartObj label;
  TextStyleObjSt labelStyle;
  DartObj labelPadding;
  double pressElevation;
  int selected;
  DartObj disabledColor;
  DartObj selectedColor;
  char* tooltip;
  BorderSideObjSt side;
  DartObj shape;
  int clipBehavior;
  int autofocus;
  DartObj backgroundColor;
  DartObj padding;
  VisualDensityObjSt visualDensity;
  int materialTapTargetSize;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj selectedShadowColor;
  int showCheckmark;
  DartObj checkmarkColor;
  DartObj avatarBorder;
  BoxConstraintsObjSt avatarBoxConstraints;
} ChoiceChipObjSt;
typedef struct {
  int id;
  DartObj avatar;
  DartObj label;
  TextStyleObjSt labelStyle;
  DartObj labelPadding;
  int selected;
  DartObj deleteIcon;
  DartObj deleteIconColor;
  char* deleteButtonTooltipMessage;
  double pressElevation;
  DartObj disabledColor;
  DartObj selectedColor;
  char* tooltip;
  BorderSideObjSt side;
  DartObj shape;
  int clipBehavior;
  int autofocus;
  DartObj backgroundColor;
  DartObj padding;
  VisualDensityObjSt visualDensity;
  int materialTapTargetSize;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj selectedShadowColor;
  int showCheckmark;
  DartObj checkmarkColor;
  DartObj avatarBorder;
  BoxConstraintsObjSt avatarBoxConstraints;
  BoxConstraintsObjSt deleteIconBoxConstraints;
} FilterChipObjSt;
typedef struct {
  int id;
  DartObj avatar;
  DartObj label;
  TextStyleObjSt labelStyle;
  DartObj labelPadding;
  double pressElevation;
  char* tooltip;
  BorderSideObjSt side;
  DartObj shape;
  int clipBehavior;
  int autofocus;
  DartObj backgroundColor;
  DartObj disabledColor;
  DartObj padding;
  VisualDensityObjSt visualDensity;
  int materialTapTargetSize;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  BoxConstraintsObjSt avatarBoxConstraints;
} ActionChipObjSt;
typedef struct {
  int id;
  DartObj title;
  DartObj titlePadding;
  TextStyleObjSt titleTextStyle;
  DartObj contentPadding;
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
} SimpleDialogObjSt;
typedef struct {
  int id;
  DartObj child;
  EdgeInsetsObjSt padding;
} SimpleDialogOptionObjSt;
typedef struct {
  int id;
  double eccentricity;
} CircleBorderObjSt;
typedef struct {
  int id;
} StadiumBorderObjSt;
typedef struct {
  int id;
  DartObj borderRadius;
} BeveledRectangleBorderObjSt;
typedef struct {
  int id;
  DartObj borderRadius;
} ContinuousRectangleBorderObjSt;
typedef struct {
  int id;
} LinearBorderObjSt;
typedef struct {
  int id;
  double points;
  double pointRounding;
  double valleyRounding;
  double squash;
  double innerRadiusRatio;
  double rotation;
} StarBorderObjSt;
typedef struct {
  int id;
  DartObj content;
  TextStyleObjSt contentTextStyle;
  double elevation;
  DartObj leading;
  double minActionBarHeight;
  DartObj backgroundColor;
  DartObj surfaceTintColor;
  DartObj shadowColor;
  DartObj dividerColor;
  DartObj padding;
  DartObj margin;
  DartObj leadingPadding;
  int forceActionsBelow;
  int overflowAlignment;
  DartObj animation;
} MaterialBannerObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  DartObj borderColor;
  double size;
  int borderStyle;
} TabPageSelectorIndicatorObjSt;
typedef struct {
  int id;
  DartObj child;
  int index;
  int enabled;
} ReorderableDragStartListenerObjSt;
typedef struct {
  int id;
} ReorderableDelayedDragStartListenerObjSt;
typedef struct {
  int id;
  DartObj icon;
  DartObj child;
  char* applicationName;
  char* applicationVersion;
  DartObj applicationIcon;
  char* applicationLegalese;
  int dense;
} AboutListTileObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj insetAnimationDuration;
  DartObj insetAnimationCurve;
  EdgeInsetsObjSt insetPadding;
  int clipBehavior;
  DartObj shape;
  DartObj alignment;
  DartObj child;
  int semanticsRole;
  BoxConstraintsObjSt constraints;
} DialogObjSt;
typedef struct {
  int id;
  DartObj header;
  DartObj footer;
  DartObj child;
} GridTileObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  DartObj leading;
  DartObj title;
  DartObj subtitle;
  DartObj trailing;
} GridTileBarObjSt;
typedef struct {
  int id;
  double elevation;
  DartObj indicatorMargin;
  DartObj indicatorPadding;
} RefreshProgressIndicatorObjSt;
typedef struct {
  int id;
  double strokeWidth;
  double strokeAlign;
  int strokeCap;
  BoxConstraintsObjSt constraints;
  double trackGap;
  int year2023;
  DartObj padding;
} CircularProgressIndicatorObjSt;
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
  TextStyleObjSt baseStyle;
  int textAlign;
  int isFocused;
  int isHovering;
  int expands;
  int isEmpty;
  DartObj child;
} InputDecoratorObjSt;
typedef struct {
  int id;
  DartObj decoration;
  DartObj margin;
  DartObj currentAccountPicture;
  DartObj accountName;
  DartObj accountEmail;
  DartObj arrowColor;
} UserAccountsDrawerHeaderObjSt;
typedef struct {
  int id;
  DartObj avatar;
  DartObj label;
  TextStyleObjSt labelStyle;
  DartObj labelPadding;
  int selected;
  int isEnabled;
  DartObj deleteIcon;
  DartObj deleteIconColor;
  char* deleteButtonTooltipMessage;
  double pressElevation;
  DartObj disabledColor;
  DartObj selectedColor;
  char* tooltip;
  BorderSideObjSt side;
  DartObj shape;
  int clipBehavior;
  int autofocus;
  DartObj backgroundColor;
  DartObj padding;
  VisualDensityObjSt visualDensity;
  int materialTapTargetSize;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj selectedShadowColor;
  int showCheckmark;
  DartObj checkmarkColor;
  DartObj avatarBorder;
  BoxConstraintsObjSt avatarBoxConstraints;
  BoxConstraintsObjSt deleteIconBoxConstraints;
} InputChipObjSt;
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
  double minHeight;
  DartObj borderRadius;
  DartObj stopIndicatorColor;
  double stopIndicatorRadius;
  double trackGap;
  int year2023;
} LinearProgressIndicatorObjSt;
typedef struct {
  int id;
  int value;
  DartObj activeColor;
  DartObj checkColor;
  int tristate;
  int materialTapTargetSize;
  VisualDensityObjSt visualDensity;
  DartObj focusColor;
  DartObj hoverColor;
  double splashRadius;
  int autofocus;
  DartObj shape;
  BorderSideObjSt side;
  int isError;
  char* semanticLabel;
} CheckboxObjSt;
typedef struct {
  int id;
  int value;
  DartObj activeColor;
  DartObj activeThumbColor;
  DartObj activeTrackColor;
  DartObj inactiveThumbColor;
  DartObj inactiveTrackColor;
  int materialTapTargetSize;
  int applyCupertinoTheme;
  int dragStartBehavior;
  DartObj focusColor;
  DartObj hoverColor;
  double splashRadius;
  int autofocus;
  DartObj padding;
} SwitchObjSt;
typedef struct {
  int id;
  double value;
  double secondaryTrackValue;
  double min;
  double max;
  int divisions;
  char* label;
  DartObj activeColor;
  DartObj inactiveColor;
  DartObj secondaryActiveColor;
  DartObj thumbColor;
  int autofocus;
  int allowedInteraction;
  DartObj padding;
  int year2023;
} SliderObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj shape;
  double width;
  DartObj child;
  char* semanticLabel;
  int clipBehavior;
} DrawerObjSt;
typedef struct {
  int id;
  char* message;
  DartObj richMessage;
  double height;
  BoxConstraintsObjSt constraints;
  DartObj padding;
  DartObj margin;
  double verticalOffset;
  int preferBelow;
  int excludeFromSemantics;
  DartObj child;
  DartObj decoration;
  TextStyleObjSt textStyle;
  int textAlign;
  DartObj waitDuration;
  DartObj showDuration;
  DartObj exitDuration;
  int enableTapToDismiss;
  int triggerMode;
  int enableFeedback;
  int ignorePointer;
} TooltipObjSt;
typedef struct {
  int id;
  char* text;
  DartObj child;
  DartObj icon;
  DartObj iconMargin;
  double height;
} TabObjSt;
typedef struct {
  int id;
  int isScrollable;
  DartObj padding;
  DartObj indicatorColor;
  double indicatorWeight;
  DartObj indicatorPadding;
  DartObj indicator;
  int automaticIndicatorColorAdjustment;
  int indicatorSize;
  DartObj dividerColor;
  double dividerHeight;
  DartObj labelColor;
  DartObj unselectedLabelColor;
  TextStyleObjSt labelStyle;
  TextStyleObjSt unselectedLabelStyle;
  DartObj labelPadding;
  int dragStartBehavior;
  int enableFeedback;
  BorderRadiusObjSt splashBorderRadius;
  int tabAlignment;
  int indicatorAnimation;
  int tabHasTextAndIcon;
} TabBarObjSt;
typedef struct {
  int id;
  int dragStartBehavior;
  double viewportFraction;
  int clipBehavior;
} TabBarViewObjSt;
typedef struct {
  int id;
  int length;
  int initialIndex;
  DartObj animationDuration;
  DartObj child;
} DefaultTabControllerObjSt;
typedef struct {
  int id;
  int value;
  DartObj activeColor;
  DartObj checkColor;
  DartObj hoverColor;
  double splashRadius;
  int materialTapTargetSize;
  VisualDensityObjSt visualDensity;
  int autofocus;
  DartObj shape;
  BorderSideObjSt side;
  int isError;
  DartObj tileColor;
  DartObj title;
  DartObj subtitle;
  DartObj secondary;
  int isThreeLine;
  int dense;
  int selected;
  int controlAffinity;
  DartObj contentPadding;
  int tristate;
  DartObj checkboxShape;
  DartObj selectedTileColor;
  int enableFeedback;
  int enabled;
  int titleAlignment;
  int internalAddSemanticForOnTap;
  double checkboxScaleFactor;
  char* checkboxSemanticLabel;
} CheckboxListTileObjSt;
typedef struct {
  int id;
  int value;
  DartObj activeColor;
  DartObj activeThumbColor;
  DartObj activeTrackColor;
  DartObj inactiveThumbColor;
  DartObj inactiveTrackColor;
  int materialTapTargetSize;
  int dragStartBehavior;
  double splashRadius;
  int autofocus;
  DartObj tileColor;
  DartObj title;
  DartObj subtitle;
  DartObj secondary;
  int isThreeLine;
  int dense;
  DartObj contentPadding;
  int selected;
  int controlAffinity;
  DartObj shape;
  DartObj selectedTileColor;
  VisualDensityObjSt visualDensity;
  int enableFeedback;
  DartObj hoverColor;
  int applyCupertinoTheme;
  int internalAddSemanticForOnTap;
} SwitchListTileObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  DartObj textColor;
  double smallSize;
  double largeSize;
  TextStyleObjSt textStyle;
  DartObj padding;
  DartObj alignment;
  DartObj offset;
  DartObj label;
  int isLabelVisible;
  DartObj child;
} BadgeObjSt;
typedef struct {
  int id;
  char* data;
  TextSpanObjSt textSpan;
  TextStyleObjSt style;
  int textAlign;
  int textDirection;
  double textScaleFactor;
  int autofocus;
  int minLines;
  int maxLines;
  int showCursor;
  double cursorWidth;
  double cursorHeight;
  DartObj cursorRadius;
  DartObj cursorColor;
  DartObj selectionColor;
  int selectionHeightStyle;
  int selectionWidthStyle;
  int enableInteractiveSelection;
  int dragStartBehavior;
  char* semanticsLabel;
  int textWidthBasis;
  int selectionEnabled;
} SelectableTextObjSt;
typedef struct {
  int id;
} InkWellObjSt;
typedef struct {
  int id;
  DartObj child;
  int containedInkWell;
  int highlightShape;
  double radius;
  BorderRadiusObjSt borderRadius;
  DartObj customBorder;
  DartObj focusColor;
  DartObj hoverColor;
  DartObj highlightColor;
  DartObj splashColor;
  int enableFeedback;
  int excludeFromSemantics;
  int autofocus;
  int canRequestFocus;
  DartObj hoverDuration;
} InkResponseObjSt;
typedef struct {
  int id;
  int sortColumnIndex;
  int sortAscending;
  DartObj decoration;
  double dataRowMinHeight;
  double dataRowMaxHeight;
  TextStyleObjSt dataTextStyle;
  double headingRowHeight;
  TextStyleObjSt headingTextStyle;
  double horizontalMargin;
  double columnSpacing;
  int showCheckboxColumn;
  double dividerThickness;
  int showBottomBorder;
  double checkboxHorizontalMargin;
  int clipBehavior;
  double dataRowHeight;
} DataTableObjSt;
typedef struct {
  int id;
  DartObj label;
  char* tooltip;
  int numeric;
  int headingRowAlignment;
} DataColumnObjSt;
typedef struct {
  int id;
  int selected;
} DataRowObjSt;
typedef struct {
  int id;
  DartObj child;
  int placeholder;
  int showEditIcon;
} DataCellObjSt;
typedef struct {
  int id;
  int toggleable;
  DartObj activeColor;
  int materialTapTargetSize;
  VisualDensityObjSt visualDensity;
  DartObj focusColor;
  DartObj hoverColor;
  double splashRadius;
  int autofocus;
  int useCupertinoCheckmarkStyle;
  int enabled;
  BorderSideObjSt side;
} RadioObjSt;
typedef struct {
  int id;
  int toggleable;
  DartObj activeColor;
  int materialTapTargetSize;
  DartObj hoverColor;
  double splashRadius;
  DartObj title;
  DartObj subtitle;
  DartObj secondary;
  int isThreeLine;
  int dense;
  int selected;
  int controlAffinity;
  int autofocus;
  DartObj contentPadding;
  DartObj shape;
  DartObj tileColor;
  DartObj selectedTileColor;
  VisualDensityObjSt visualDensity;
  int enableFeedback;
  int titleAlignment;
  int internalAddSemanticForOnTap;
  int useCupertinoCheckmarkStyle;
  double radioScaleFactor;
  int enabled;
  BorderSideObjSt radioSide;
  int checked;
} RadioListTileObjSt;
typedef struct {
  int id;
  DartObj leading;
  DartObj title;
  DartObj subtitle;
  DartObj backgroundColor;
  DartObj collapsedBackgroundColor;
  DartObj trailing;
  int showTrailingIcon;
  int initiallyExpanded;
  int maintainState;
  DartObj tilePadding;
  AlignmentObjSt expandedAlignment;
  int expandedCrossAxisAlignment;
  DartObj childrenPadding;
  DartObj iconColor;
  DartObj collapsedIconColor;
  DartObj textColor;
  DartObj collapsedTextColor;
  DartObj shape;
  DartObj collapsedShape;
  int clipBehavior;
  int controlAffinity;
  int dense;
  VisualDensityObjSt visualDensity;
  double minTileHeight;
  int enableFeedback;
  int enabled;
  int internalAddSemanticForOnTap;
} ExpansionTileObjSt;
typedef struct {
  int id;
  DartObj animationDuration;
  EdgeInsetsObjSt expandedHeaderPadding;
  DartObj dividerColor;
  double elevation;
  DartObj expandIconColor;
  double materialGapSize;
} ExpansionPanelListObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  int extended;
  DartObj leading;
  DartObj trailing;
  int selectedIndex;
  double elevation;
  double groupAlignment;
  int labelType;
  TextStyleObjSt unselectedLabelTextStyle;
  TextStyleObjSt selectedLabelTextStyle;
  double minWidth;
  double minExtendedWidth;
  int useIndicator;
  DartObj indicatorColor;
  DartObj indicatorShape;
  int leadingAtTop;
  int trailingAtBottom;
  int scrollable;
} NavigationRailObjSt;
typedef struct {
  int id;
  DartObj animationDuration;
  int selectedIndex;
  DartObj backgroundColor;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj indicatorColor;
  DartObj indicatorShape;
  double height;
  int labelBehavior;
  DartObj labelPadding;
  int maintainBottomViewPadding;
} NavigationBarObjSt;
typedef struct {
  int id;
  DartObj icon;
  DartObj selectedIcon;
  char* label;
  char* tooltip;
  int enabled;
} NavigationDestinationObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  double elevation;
  DartObj indicatorColor;
  DartObj indicatorShape;
  DartObj header;
  DartObj footer;
  int selectedIndex;
  DartObj tilePadding;
} NavigationDrawerObjSt;
typedef struct {
  int id;
  DartObj backgroundColor;
  DartObj icon;
  DartObj selectedIcon;
  DartObj label;
  int enabled;
} NavigationDrawerDestinationObjSt;
typedef struct {
  int id;
  char* tooltip;
  double elevation;
  DartObj shadowColor;
  DartObj surfaceTintColor;
  DartObj padding;
  DartObj menuPadding;
  double splashRadius;
  DartObj child;
  BorderRadiusObjSt borderRadius;
  DartObj icon;
  DartObj offset;
  int enabled;
  DartObj shape;
  DartObj color;
  DartObj iconColor;
  int enableFeedback;
  double iconSize;
  BoxConstraintsObjSt constraints;
  int position;
  int clipBehavior;
  int useRootNavigator;
  int requestFocus;
} PopupMenuButtonObjSt;
typedef struct {
  int id;
  int enabled;
  double height;
  EdgeInsetsObjSt padding;
  TextStyleObjSt textStyle;
  DartObj child;
} PopupMenuItemObjSt;
typedef struct {
  int id;
  double height;
  double thickness;
  double indent;
  double endIndent;
  DartObj radius;
  DartObj color;
} PopupMenuDividerObjSt;
typedef struct {
  int id;
  int checked;
} CheckedPopupMenuItemObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj backgroundColor;
  DartObj foregroundColor;
  double radius;
  double minRadius;
  double maxRadius;
} CircleAvatarObjSt;
typedef struct {
  int id;
  DartObj child;
  int thumbVisibility;
  int trackVisibility;
  double thickness;
  DartObj radius;
  int interactive;
  int scrollbarOrientation;
} ScrollbarObjSt;
typedef struct {
  int id;
  int clipBehavior;
} MenuBarObjSt;
typedef struct {
  int id;
  DartObj alignmentOffset;
  int clipBehavior;
  int anchorTapClosesMenu;
  int consumeOutsideTap;
  int crossAxisUnconstrained;
  int useRootOverlay;
  DartObj child;
} MenuAnchorObjSt;
typedef struct {
  int id;
  DartObj alignmentOffset;
  int clipBehavior;
  DartObj leadingIcon;
  DartObj trailingIcon;
  int useRootOverlay;
  DartObj child;
} SubmenuButtonObjSt;
typedef struct {
  int id;
  int requestFocusOnHover;
  int autofocus;
  char* semanticsLabel;
  int clipBehavior;
  DartObj leadingIcon;
  DartObj trailingIcon;
  int closeOnActivate;
  int overflowAxis;
  DartObj child;
  int enabled;
} MenuItemButtonObjSt;
typedef struct {
  int id;
  int value;
  int tristate;
  int isError;
  int clipBehavior;
  DartObj trailingIcon;
  int closeOnActivate;
  DartObj child;
  int enabled;
} CheckboxMenuButtonObjSt;
typedef struct {
  int id;
  int toggleable;
  int clipBehavior;
  DartObj trailingIcon;
  int closeOnActivate;
  DartObj child;
  int enabled;
} RadioMenuButtonObjSt;
typedef struct {
  int id;
  DartObj initialDate;
  DartObj firstDate;
  DartObj lastDate;
  DartObj currentDate;
  int initialEntryMode;
  char* cancelText;
  char* confirmText;
  char* helpText;
  int initialCalendarMode;
  char* errorFormatText;
  char* errorInvalidText;
  char* fieldHintText;
  char* fieldLabelText;
  char* restorationId;
  IconObjSt switchToInputEntryModeIcon;
  IconObjSt switchToCalendarEntryModeIcon;
  EdgeInsetsObjSt insetPadding;
} DatePickerDialogObjSt;
typedef struct {
  int id;
  DartObj initialDate;
  DartObj firstDate;
  DartObj lastDate;
  DartObj currentDate;
  int initialCalendarMode;
} CalendarDatePickerObjSt;
typedef struct {
  int id;
  TimeOfDayObjSt initialTime;
  char* cancelText;
  char* confirmText;
  char* helpText;
  char* errorInvalidText;
  char* hourLabelText;
  char* minuteLabelText;
  char* restorationId;
  int initialEntryMode;
  int orientation;
  IconObjSt switchToInputEntryModeIcon;
  IconObjSt switchToTimerEntryModeIcon;
} TimePickerDialogObjSt;
typedef struct {
  int id;
  DartObj firstDate;
  DartObj lastDate;
  DartObj currentDate;
  int initialEntryMode;
  char* cancelText;
  char* confirmText;
  char* saveText;
  char* helpText;
  char* errorInvalidRangeText;
  char* errorFormatText;
  char* errorInvalidText;
  char* fieldStartHintText;
  char* fieldEndHintText;
  char* fieldStartLabelText;
  char* fieldEndLabelText;
  char* restorationId;
  IconObjSt switchToInputEntryModeIcon;
  IconObjSt switchToCalendarEntryModeIcon;
} DateRangePickerDialogObjSt;
typedef struct {
  int id;
  DartObj currentDate;
  DartObj firstDate;
  DartObj lastDate;
  DartObj selectedDate;
  int dragStartBehavior;
} YearPickerObjSt;
typedef struct {
  int id;
  DartObj initialDate;
  DartObj firstDate;
  DartObj lastDate;
  char* errorFormatText;
  char* errorInvalidText;
  char* fieldHintText;
  char* fieldLabelText;
  int autofocus;
  int acceptEmptyDate;
} InputDatePickerFormFieldObjSt;
typedef struct {
  int id;
  char* hintText;
  DartObj leading;
  BoxConstraintsObjSt constraints;
  int textCapitalization;
  int enabled;
  int autoFocus;
  int textInputAction;
  EdgeInsetsObjSt scrollPadding;
} SearchBarObjSt;
typedef struct {
  int id;
  DartObj home;
  char* initialRoute;
  char* title;
  DartObj color;
  int showPerformanceOverlay;
  int checkerboardRasterCacheImages;
  int checkerboardOffscreenLayers;
  int showSemanticsDebugger;
  int debugShowCheckedModeBanner;
  char* restorationScopeId;
  int useInheritedMediaQuery;
} CupertinoAppObjSt;
typedef struct {
  int id;
  DartObj navigationBar;
  DartObj child;
  DartObj backgroundColor;
  int resizeToAvoidBottomInset;
} CupertinoPageScaffoldObjSt;
typedef struct {
  int id;
  DartObj largeTitle;
  DartObj leading;
  int automaticallyImplyLeading;
  int automaticallyImplyMiddle;
  char* previousPageTitle;
  DartObj middle;
  DartObj trailing;
  DartObj backgroundColor;
  int automaticBackgroundVisibility;
  int brightness;
  BorderObjSt border;
  int transitionBetweenRoutes;
  int enableBackgroundFilterBlur;
  DartObj bottom;
} CupertinoNavigationBarObjSt;
typedef struct {
  int id;
  DartObj largeTitle;
  DartObj leading;
  int automaticallyImplyLeading;
  int automaticallyImplyTitle;
  int alwaysShowMiddle;
  char* previousPageTitle;
  DartObj middle;
  DartObj trailing;
  DartObj backgroundColor;
  int automaticBackgroundVisibility;
  int enableBackgroundFilterBlur;
  int brightness;
  BorderObjSt border;
  int transitionBetweenRoutes;
  DartObj bottom;
  int bottomMode;
  int stretch;
  DartObj searchField;
  int opaque;
} CupertinoSliverNavigationBarObjSt;
typedef struct {
  int id;
  char* defaultTitle;
  char* restorationScopeId;
} CupertinoTabViewObjSt;
typedef struct {
  int id;
  DartObj child;
  DartObj padding;
  DartObj color;
  DartObj disabledColor;
  DartObj foregroundColor;
  double minSize;
  double pressedOpacity;
  BorderRadiusObjSt borderRadius;
  int sizeStyle;
  DartObj alignment;
  DartObj focusColor;
  int autofocus;
  int enabled;
} CupertinoButtonObjSt;
typedef struct {
  int id;
  int value;
  DartObj activeTrackColor;
  DartObj inactiveTrackColor;
  DartObj thumbColor;
  DartObj inactiveThumbColor;
  DartObj focusColor;
  DartObj onLabelColor;
  DartObj offLabelColor;
  int autofocus;
  int applyTheme;
  int dragStartBehavior;
  DartObj activeColor;
  DartObj trackColor;
} CupertinoSwitchObjSt;
typedef struct {
  int id;
  double value;
  double min;
  double max;
  int divisions;
  DartObj activeColor;
  DartObj thumbColor;
} CupertinoSliderObjSt;
typedef struct {
  int id;
  TextStyleObjSt style;
  char* placeholder;
  TextStyleObjSt placeholderStyle;
  BoxDecorationObjSt decoration;
  DartObj backgroundColor;
  BorderRadiusObjSt borderRadius;
  DartObj padding;
  DartObj itemColor;
  double itemSize;
  DartObj prefixInsets;
  DartObj prefixIcon;
  DartObj suffixInsets;
  IconObjSt suffixIcon;
  int suffixMode;
  char* restorationId;
  int autofocus;
  int autocorrect;
  int smartQuotesType;
  int smartDashesType;
  int enableIMEPersonalizedLearning;
  int enabled;
  double cursorWidth;
  double cursorHeight;
  DartObj cursorRadius;
  int cursorOpacityAnimates;
  DartObj cursorColor;
} CupertinoSearchTextFieldObjSt;
typedef struct {
  int id;
  DartObj color;
  int animating;
  double radius;
  double progress;
} CupertinoActivityIndicatorObjSt;
typedef struct {
  int id;
  int type;
  DartObj header;
  DartObj footer;
  DartObj margin;
  BoxDecorationObjSt decoration;
  DartObj backgroundColor;
  int clipBehavior;
  double dividerMargin;
  double additionalDividerMargin;
  double topMargin;
  DartObj separatorColor;
} CupertinoListSectionObjSt;
typedef struct {
  int id;
  DartObj title;
  DartObj subtitle;
  DartObj additionalInfo;
  DartObj leading;
  DartObj trailing;
  DartObj backgroundColor;
  DartObj backgroundColorActivated;
  DartObj padding;
  double leadingSize;
  double leadingToTitle;
} CupertinoListTileObjSt;
typedef struct {
  int id;
} CupertinoListTileChevronObjSt;
typedef struct {
  int id;
  DartObj header;
  DartObj footer;
  DartObj margin;
  BoxDecorationObjSt decoration;
  DartObj backgroundColor;
  int clipBehavior;
} CupertinoFormSectionObjSt;
typedef struct {
  int id;
  DartObj prefix;
  DartObj padding;
  DartObj helper;
  DartObj error;
  DartObj child;
} CupertinoFormRowObjSt;
typedef struct {
  int id;
  double diameterRatio;
  DartObj backgroundColor;
  double offAxisFraction;
  int useMagnifier;
  double magnification;
  double itemExtent;
  double squeeze;
  int changeReportingBehavior;
  DartObj selectionOverlay;
} CupertinoPickerObjSt;
typedef struct {
  int id;
  DartObj title;
  DartObj content;
  DartObj insetAnimationDuration;
  DartObj insetAnimationCurve;
} CupertinoAlertDialogObjSt;
typedef struct {
  int id;
  DartObj title;
  DartObj message;
  DartObj cancelButton;
} CupertinoActionSheetObjSt;
typedef struct {
  int id;
  int isDefaultAction;
  int isDestructiveAction;
  TextStyleObjSt textStyle;
  DartObj child;
} CupertinoDialogActionObjSt;
typedef struct {
  int id;
  int isDefaultAction;
  int isDestructiveAction;
  DartObj child;
} CupertinoActionSheetActionObjSt;
typedef struct {
  int id;
  BoxDecorationObjSt decoration;
  DartObj padding;
  char* placeholder;
  TextStyleObjSt placeholderStyle;
  DartObj prefix;
  int prefixMode;
  DartObj suffix;
  int suffixMode;
  int crossAxisAlignment;
  int clearButtonMode;
  char* clearButtonSemanticLabel;
  int textInputAction;
  int textCapitalization;
  TextStyleObjSt style;
  int textAlign;
  int textDirection;
  int readOnly;
  int showCursor;
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
  int maxLength;
  int maxLengthEnforcement;
  int enabled;
  double cursorWidth;
  double cursorHeight;
  DartObj cursorRadius;
  int cursorOpacityAnimates;
  DartObj cursorColor;
  int selectionHeightStyle;
  int selectionWidthStyle;
  int keyboardAppearance;
  EdgeInsetsObjSt scrollPadding;
  int enableInteractiveSelection;
  int selectAllOnFocus;
  int dragStartBehavior;
  int clipBehavior;
  char* restorationId;
  int scribbleEnabled;
  int stylusHandwritingEnabled;
  int enableIMEPersonalizedLearning;
  int selectionEnabled;
} CupertinoTextFieldObjSt;
typedef struct {
  int id;
  int value;
  DartObj activeColor;
  DartObj inactiveColor;
  DartObj checkColor;
  int tristate;
  DartObj focusColor;
  int autofocus;
  BorderSideObjSt side;
  DartObj shape;
  char* semanticLabel;
} CupertinoCheckboxObjSt;
typedef struct {
  int id;
  DartObj title;
  DartObj child;
  int transitionMode;
} CupertinoExpansionTileObjSt;
typedef struct {
  int id;
  int mode;
  DartObj initialTimerDuration;
  int minuteInterval;
  int secondInterval;
  DartObj alignment;
  DartObj backgroundColor;
  double itemExtent;
  int changeReportingBehavior;
} CupertinoTimerPickerObjSt;
typedef struct {
  int id;
  DartObj color;
  char* previousPageTitle;
} CupertinoNavigationBarBackButtonObjSt;
typedef struct {
  int id;
  int currentIndex;
  DartObj backgroundColor;
  DartObj activeColor;
  DartObj inactiveColor;
  double iconSize;
  double height;
  BorderObjSt border;
} CupertinoTabBarObjSt;
typedef struct {
  int id;
  CupertinoTabBarObjSt tabBar;
  DartObj backgroundColor;
  int resizeToAvoidBottomInset;
  char* restorationId;
} CupertinoTabScaffoldObjSt;
typedef struct {
  int id;
  DartObj child;
  int enableHapticFeedback;
} CupertinoContextMenuObjSt;
typedef struct {
  int id;
  DartObj child;
  int isDefaultAction;
  int isDestructiveAction;
  IconDataObjSt trailingIcon;
} CupertinoContextMenuActionObjSt;
typedef struct {
  int id;
  DartObj (*context)(void);
  int (*mounted)(void);
  void (*setState)(VoidCallbackFFI fn);
  DartObj (*widget)(void);
} SubStateObjSt;
typedef struct {
  int id;
} SubStatefulWidgetObjSt;
typedef struct {
  int id;
} SubStatelessWidgetObjSt;
typedef struct {
  int id;
  DartObj (*context)(void);
  int (*mounted)(void);
  void (*setState)(VoidCallbackFFI fn);
  DartObj (*widget)(void);
} SubAnimatedStateObjSt;
