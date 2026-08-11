typedef struct {
  DartObj (*showDialog)(DartObj context, WidgetBuilderFFI builder, int* barrierDismissible, DartObj* barrierColor, char* barrierLabel, int* useSafeArea, int* useRootNavigator, DartObj* anchorPoint, int* traversalEdgeBehavior, int* fullscreenDialog, int* requestFocus);
  DartObj (*showDatePicker)(DartObj context, DartObj* initialDate, DartObj firstDate, DartObj lastDate, DartObj* currentDate, int* initialEntryMode, SelectableDayPredicateFFI* selectableDayPredicate, char* helpText, char* cancelText, char* confirmText, int* barrierDismissible, DartObj* barrierColor, char* barrierLabel, int* useRootNavigator, int* textDirection, TransitionBuilderFFI* builder, int* initialDatePickerMode, char* errorFormatText, char* errorInvalidText, char* fieldHintText, char* fieldLabelText, DartObj* anchorPoint, ValueChangedForDatePickerEntryModeFFI* onDatePickerModeChange, DartObj* switchToInputEntryModeIcon, DartObj* switchToCalendarEntryModeIcon);
  DartObj (*showTimePicker)(DartObj context, DartObj initialTime, TransitionBuilderFFI* builder, int* barrierDismissible, DartObj* barrierColor, char* barrierLabel, int* useRootNavigator, int* initialEntryMode, char* cancelText, char* confirmText, char* helpText, char* errorInvalidText, char* hourLabelText, char* minuteLabelText, EntryModeChangeCallbackFFI* onEntryModeChanged, DartObj* anchorPoint, int* orientation, DartObj* switchToInputEntryModeIcon, DartObj* switchToTimerEntryModeIcon);
  DartObj (*showDateRangePicker)(DartObj context, DartObj firstDate, DartObj lastDate, DartObj* currentDate, int* initialEntryMode, char* helpText, char* cancelText, char* confirmText, char* saveText, char* errorFormatText, char* errorInvalidText, char* errorInvalidRangeText, char* fieldStartHintText, char* fieldEndHintText, char* fieldStartLabelText, char* fieldEndLabelText, int* barrierDismissible, DartObj* barrierColor, char* barrierLabel, int* useRootNavigator, int* textDirection, TransitionBuilderFFI* builder, DartObj* anchorPoint, DartObj* switchToInputEntryModeIcon, DartObj* switchToCalendarEntryModeIcon, SelectableDayForRangePredicateFFI* selectableDayPredicate);
  struct TextStyleSt {
    TextStyleObjSt (*textStyle)(int* inherit, DartObj* color, DartObj* backgroundColor, double* fontSize, DartObj* fontWeight, int* fontStyle, double* letterSpacing, double* wordSpacing, int* textBaseline, double* height, int* leadingDistribution, ArrayC* shadows, DartObj* decoration, DartObj* decorationColor, int* decorationStyle, double* decorationThickness, char* debugLabel, char* fontFamily, char*** fontFamilyFallback, char* package, int* overflow);
    TextStyleObjSt (*lerp)(DartObj a, DartObj b, double t);
  } textStyle;

  struct ColorSt {
    DartObj (*color)(int value);
    DartObj (*from)(double alpha, double red, double green, double blue, int* colorSpace);
    DartObj (*fromARGB)(int a, int r, int g, int b);
    DartObj (*fromRGBO)(int r, int g, int b, double opacity);
    DartObj (*lerp)(DartObj x, DartObj y, double t);
    DartObj (*alphaBlend)(DartObj foreground, DartObj background);
    int (*getAlphaFromOpacity)(double opacity);
  } color;

  struct OffsetSt {
    DartObj (*offset)(double dx, double dy);
    DartObj (*fromDirection)(double direction, double* distance);
    DartObj (*lerp)(DartObj a, DartObj b, double t);
  } offset;

  struct DateTimeSt {
    DartObj (*dateTime)(int year, int* month, int* day, int* hour, int* minute, int* second, int* millisecond, int* microsecond);
    DartObj (*utc)(int year, int* month, int* day, int* hour, int* minute, int* second, int* millisecond, int* microsecond);
    DartObj (*now)(void);
    DartObj (*timestamp)(void);
    DartObj (*fromMillisecondsSinceEpoch)(int millisecondsSinceEpoch, int* isUtc);
    DartObj (*fromMicrosecondsSinceEpoch)(int microsecondsSinceEpoch, int* isUtc);
    DartObj (*parse)(char* formattedString);
    DartObj (*tryParse)(char* formattedString);
  } dateTime;

  struct IconSt {
    IconObjSt (*icon)(DartObj icon, double* size, double* fill, double* weight, double* grade, double* opticalSize, DartObj* color, ArrayC* shadows, char* semanticLabel, int* textDirection, int* applyTextScaling, int* blendMode, DartObj* fontWeight);
  } icon;

  struct TimeOfDaySt {
    TimeOfDayObjSt (*timeOfDay)(int hour, int minute);
    TimeOfDayObjSt (*fromDateTime)(DartObj time);
    TimeOfDayObjSt (*now)(void);
  } timeOfDay;

  struct FontWeightSt {
    DartObj (*lerp)(DartObj a, DartObj b, double t);
    DartObj w100;
    DartObj w200;
    DartObj w300;
    DartObj w400;
    DartObj w500;
    DartObj w600;
    DartObj w700;
    DartObj w800;
    DartObj w900;
  } fontWeight;

  struct ShadowSt {
    DartObj (*shadow)(DartObj* color, DartObj* offset, double* blurRadius);
    double (*convertRadiusToSigma)(double radius);
    DartObj (*lerp)(DartObj a, DartObj b, double t);
  } shadow;

  struct TextDecorationSt {
    DartObj (*combine)(ArrayC decorations);
    DartObj none;
    DartObj underline;
    DartObj overline;
    DartObj lineThrough;
  } textDecoration;

  struct IconDataSt {
    IconDataObjSt (*iconData)(int codePoint, char* fontFamily, char* fontPackage, int* matchTextDirection, char*** fontFamilyFallback);
  } iconData;

  struct TextSt {
    TextObjSt (*text)(char* data, DartObj* style, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, char* semanticsIdentifier, int* textWidthBasis, DartObj* selectionColor);
    TextObjSt (*rich)(DartObj textSpan, DartObj* style, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, char* semanticsIdentifier, int* textWidthBasis, DartObj* selectionColor);
  } text;

  struct TextSpanSt {
    TextSpanObjSt (*textSpan)(char* text, ArrayC* children, DartObj* style, char* semanticsLabel, char* semanticsIdentifier, int* spellOut);
  } textSpan;

  struct RichTextSt {
    RichTextObjSt (*richText)(DartObj text, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, int* textWidthBasis, DartObj* selectionColor);
  } richText;

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

  struct TransformSt {
    TransformObjSt (*rotate)(double angle, DartObj* origin, DartObj* alignment, int* transformHitTests, int* filterQuality, DartObj* child);
    TransformObjSt (*translate)(DartObj offset, int* transformHitTests, int* filterQuality, DartObj* child);
    TransformObjSt (*scale)(double* scale, double* scaleX, double* scaleY, DartObj* origin, DartObj* alignment, int* transformHitTests, int* filterQuality, DartObj* child);
    TransformObjSt (*flip)(int* flipX, int* flipY, DartObj* origin, int* transformHitTests, int* filterQuality, DartObj* child);
  } transform;

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

  struct EdgeInsetsGeometrySt {
    DartObj infinity;
  } edgeInsetsGeometry;

  struct StackParentDataSt {
    DartObj (*stackParentData)(void);
  } stackParentData;

  struct BoxParentDataSt {
    DartObj (*boxParentData)(void);
  } boxParentData;

  struct ParentDataSt {
    DartObj (*parentData)(void);
  } parentData;

  struct FlexParentDataSt {
    DartObj (*flexParentData)(void);
  } flexParentData;

  struct PositionedSt {
    PositionedObjSt (*positioned)(double* left, double* top, double* right, double* bottom, double* width, double* height, DartObj child);
    PositionedObjSt (*fill)(double* left, double* top, double* right, double* bottom, DartObj child);
    PositionedObjSt (*directional)(int textDirection, double* start, double* top, double* end, double* bottom, double* width, double* height, DartObj child);
  } positioned;

  struct BoxDecorationSt {
    BoxDecorationObjSt (*boxDecoration)(DartObj* color, DartObj* border, DartObj* borderRadius, ArrayC* boxShadow, int* backgroundBlendMode, int* shape);
    BoxDecorationObjSt (*lerp)(DartObj a, DartObj b, double t);
  } boxDecoration;

  struct BoxShadowSt {
    BoxShadowObjSt (*boxShadow)(DartObj* color, DartObj* offset, double* blurRadius, double* spreadRadius, int* blurStyle);
    BoxShadowObjSt (*lerp)(DartObj a, DartObj b, double t);
  } boxShadow;

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
    int (*canMerge)(DartObj a, DartObj b);
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
    DartObj (*animationController)(double* value, DartObj* duration, DartObj* reverseDuration, char* debugLabel, double* lowerBound, double* upperBound, int* animationBehavior, DartObj vsync);
    DartObj (*unbounded)(double* value, DartObj* duration, DartObj* reverseDuration, char* debugLabel, DartObj vsync, int* animationBehavior);
    void (*forward)(DartObj self);
    void (*reverse)(DartObj self);
    void (*stop)(DartObj self);
    void (*repeat)(DartObj self);
    void (*reset)(DartObj self);
    void (*setDuration)(DartObj self, DartObj d);
    void (*setReverseDuration)(DartObj self, DartObj d);
  } animationController;

  struct DurationSt {
    DartObj (*duration)(int* days, int* hours, int* minutes, int* seconds, int* milliseconds, int* microseconds);
  } duration;

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

  struct CurvesSt {
    DartObj linear;
    DartObj decelerate;
    DartObj bounceIn;
    DartObj bounceOut;
    DartObj bounceInOut;
  } curves;

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

  struct AlignmentDirectionalSt {
    AlignmentDirectionalObjSt (*alignmentDirectional)(double start, double y);
    AlignmentDirectionalObjSt (*lerp)(DartObj a, DartObj b, double t);
  } alignmentDirectional;

  struct MouseRegionSt {
    MouseRegionObjSt (*mouseRegion)(int* opaque, int* hitTestBehavior, DartObj* child);
  } mouseRegion;

  struct ExpandedSt {
    ExpandedObjSt (*expanded)(int* flex, DartObj child);
  } expanded;

  struct FlexibleSt {
    FlexibleObjSt (*flexible)(int* flex, int* fit, DartObj child);
  } flexible;

  struct SafeAreaSt {
    SafeAreaObjSt (*safeArea)(int* left, int* top, int* right, int* bottom, DartObj* minimum, int* maintainBottomViewPadding, DartObj child);
  } safeArea;

  struct RotationTransitionSt {
    RotationTransitionObjSt (*rotationTransition)(DartObj turns, DartObj* alignment, int* filterQuality, DartObj* child);
  } rotationTransition;

  struct FadeTransitionSt {
    FadeTransitionObjSt (*fadeTransition)(DartObj opacity, int* alwaysIncludeSemantics, DartObj* child);
  } fadeTransition;

  struct ScaleTransitionSt {
    ScaleTransitionObjSt (*scaleTransition)(DartObj scale, DartObj* alignment, int* filterQuality, DartObj* child);
  } scaleTransition;

  struct AspectRatioSt {
    AspectRatioObjSt (*aspectRatio)(double aspectRatio, DartObj* child);
  } aspectRatio;

  struct ClipOvalSt {
    ClipOvalObjSt (*clipOval)(int* clipBehavior, DartObj* child);
  } clipOval;

  struct ClipRRectSt {
    ClipRRectObjSt (*clipRRect)(DartObj* borderRadius, int* clipBehavior, DartObj* child);
  } clipRRect;

  struct ClipRectSt {
    ClipRectObjSt (*clipRect)(int* clipBehavior, DartObj* child);
  } clipRect;

  struct ClipRSuperellipseSt {
    ClipRSuperellipseObjSt (*clipRSuperellipse)(DartObj* borderRadius, int* clipBehavior, DartObj* child);
  } clipRSuperellipse;

  struct ColoredBoxSt {
    ColoredBoxObjSt (*coloredBox)(DartObj color, DartObj* child);
  } coloredBox;

  struct ConstrainedBoxSt {
    ConstrainedBoxObjSt (*constrainedBox)(DartObj constraints, DartObj* child);
  } constrainedBox;

  struct DecoratedBoxSt {
    DecoratedBoxObjSt (*decoratedBox)(DartObj decoration, int* position, DartObj* child);
  } decoratedBox;

  struct FittedBoxSt {
    FittedBoxObjSt (*fittedBox)(int* fit, DartObj* alignment, int* clipBehavior, DartObj* child);
  } fittedBox;

  struct FractionallySizedBoxSt {
    FractionallySizedBoxObjSt (*fractionallySizedBox)(DartObj* alignment, double* widthFactor, double* heightFactor, DartObj* child);
  } fractionallySizedBox;

  struct IntrinsicHeightSt {
    IntrinsicHeightObjSt (*intrinsicHeight)(DartObj* child);
  } intrinsicHeight;

  struct IntrinsicWidthSt {
    IntrinsicWidthObjSt (*intrinsicWidth)(double* stepWidth, double* stepHeight, DartObj* child);
  } intrinsicWidth;

  struct LimitedBoxSt {
    LimitedBoxObjSt (*limitedBox)(double* maxWidth, double* maxHeight, DartObj* child);
  } limitedBox;

  struct PlaceholderSt {
    PlaceholderObjSt (*placeholder)(DartObj* color, double* strokeWidth, double* fallbackWidth, double* fallbackHeight, DartObj* child);
  } placeholder;

  struct SpacerSt {
    SpacerObjSt (*spacer)(int* flex);
  } spacer;

  struct VisibilitySt {
    VisibilityObjSt (*visibility)(DartObj child, DartObj* replacement, int* visible, int* maintainState, int* maintainAnimation, int* maintainSize, int* maintainSemantics, int* maintainInteractivity, int* maintainFocusability);
    VisibilityObjSt (*maintain)(DartObj child, int* visible);
    int (*of)(DartObj context);
  } visibility;

  struct RotatedBoxSt {
    RotatedBoxObjSt (*rotatedBox)(int quarterTurns, DartObj* child);
  } rotatedBox;

  struct BaselineSt {
    BaselineObjSt (*baseline)(double baseline, int baselineType, DartObj* child);
  } baseline;

  struct DefaultTextStyleSt {
    DefaultTextStyleObjSt (*defaultTextStyle)(DartObj style, int* textAlign, int* softWrap, int* overflow, int* maxLines, int* textWidthBasis, DartObj child);
    DefaultTextStyleObjSt (*fallback)(void);
    DartObj (*merge)(DartObj* style, int* textAlign, int* softWrap, int* overflow, int* maxLines, int* textWidthBasis, DartObj child);
    DefaultTextStyleObjSt (*of)(DartObj context);
  } defaultTextStyle;

  struct DirectionalitySt {
    DirectionalityObjSt (*directionality)(int textDirection, DartObj child);
    int (*of)(DartObj context);
    int (*maybeOf)(DartObj context);
  } directionality;

  struct OverflowBoxSt {
    OverflowBoxObjSt (*overflowBox)(DartObj* alignment, double* minWidth, double* maxWidth, double* minHeight, double* maxHeight, int* fit, DartObj* child);
  } overflowBox;

  struct AbsorbPointerSt {
    AbsorbPointerObjSt (*absorbPointer)(int* absorbing, int* ignoringSemantics, DartObj* child);
  } absorbPointer;

  struct IgnorePointerSt {
    IgnorePointerObjSt (*ignorePointer)(int* ignoring, int* ignoringSemantics, DartObj* child);
  } ignorePointer;

  struct RepaintBoundarySt {
    RepaintBoundaryObjSt (*repaintBoundary)(DartObj* child);
    RepaintBoundaryObjSt (*wrap)(DartObj child, int childIndex);
  } repaintBoundary;

  struct FractionalTranslationSt {
    FractionalTranslationObjSt (*fractionalTranslation)(DartObj translation, int* transformHitTests, DartObj* child);
  } fractionalTranslation;

  struct UnconstrainedBoxSt {
    UnconstrainedBoxObjSt (*unconstrainedBox)(DartObj* child, int* textDirection, DartObj* alignment, int* constrainedAxis, int* clipBehavior);
  } unconstrainedBox;

  struct FlutterLogoSt {
    FlutterLogoObjSt (*flutterLogo)(double* size, DartObj* textColor, int* style, DartObj* duration, DartObj* curve);
  } flutterLogo;

  struct PhysicalModelSt {
    PhysicalModelObjSt (*physicalModel)(int* shape, int* clipBehavior, DartObj* borderRadius, double* elevation, DartObj color, DartObj* shadowColor, DartObj* child);
  } physicalModel;

  struct BannerSt {
    BannerObjSt (*banner)(DartObj* child, char* message, int* textDirection, int location, int* layoutDirection, DartObj* color, DartObj* shadow);
  } banner;

  struct AnimatedContainerSt {
    AnimatedContainerObjSt (*animatedContainer)(DartObj* alignment, DartObj* padding, DartObj* color, DartObj* decoration, DartObj* foregroundDecoration, double* width, double* height, DartObj* constraints, DartObj* margin, DartObj* transformAlignment, DartObj* child, int* clipBehavior, DartObj* curve, DartObj duration, VoidCallbackFFI* onEnd);
  } animatedContainer;

  struct AnimatedOpacitySt {
    AnimatedOpacityObjSt (*animatedOpacity)(DartObj* child, double opacity, DartObj* curve, DartObj duration, VoidCallbackFFI* onEnd, int* alwaysIncludeSemantics);
  } animatedOpacity;

  struct AnimatedPaddingSt {
    AnimatedPaddingObjSt (*animatedPadding)(DartObj padding, DartObj* child, DartObj* curve, DartObj duration, VoidCallbackFFI* onEnd);
  } animatedPadding;

  struct AnimatedAlignSt {
    AnimatedAlignObjSt (*animatedAlign)(DartObj alignment, DartObj* child, double* heightFactor, double* widthFactor, DartObj* curve, DartObj duration, VoidCallbackFFI* onEnd);
  } animatedAlign;

  struct ListViewSt {
    ListViewObjSt (*listView)(int* scrollDirection, int* reverse, int* primary, int* shrinkWrap, DartObj* padding, double* itemExtent, DartObj* prototypeItem, int* addAutomaticKeepAlives, int* addRepaintBoundaries, int* addSemanticIndexes, double* cacheExtent, ArrayC* children, int* semanticChildCount, int* dragStartBehavior, int* keyboardDismissBehavior, char* restorationId, int* clipBehavior, int* hitTestBehavior);
    ListViewObjSt (*builder)(int* scrollDirection, int* reverse, int* primary, int* shrinkWrap, DartObj* padding, double* itemExtent, DartObj* prototypeItem, NullableIndexedWidgetBuilderFFI itemBuilder, int* itemCount, int* addAutomaticKeepAlives, int* addRepaintBoundaries, int* addSemanticIndexes, double* cacheExtent, int* semanticChildCount, int* dragStartBehavior, int* keyboardDismissBehavior, char* restorationId, int* clipBehavior, int* hitTestBehavior);
    ListViewObjSt (*separated)(int* scrollDirection, int* reverse, int* primary, int* shrinkWrap, DartObj* padding, NullableIndexedWidgetBuilderFFI itemBuilder, IndexedWidgetBuilderFFI separatorBuilder, int itemCount, int* addAutomaticKeepAlives, int* addRepaintBoundaries, int* addSemanticIndexes, double* cacheExtent, int* dragStartBehavior, int* keyboardDismissBehavior, char* restorationId, int* clipBehavior, int* hitTestBehavior);
  } listView;

  struct GridViewSt {
    GridViewObjSt (*count)(int* scrollDirection, int* reverse, int* primary, int* shrinkWrap, DartObj* padding, int crossAxisCount, double* mainAxisSpacing, double* crossAxisSpacing, double* childAspectRatio, int* addAutomaticKeepAlives, int* addRepaintBoundaries, int* addSemanticIndexes, double* cacheExtent, ArrayC* children, int* semanticChildCount, int* dragStartBehavior, int* keyboardDismissBehavior, char* restorationId, int* clipBehavior, int* hitTestBehavior);
    GridViewObjSt (*extent)(int* scrollDirection, int* reverse, int* primary, int* shrinkWrap, DartObj* padding, double maxCrossAxisExtent, double* mainAxisSpacing, double* crossAxisSpacing, double* childAspectRatio, int* addAutomaticKeepAlives, int* addRepaintBoundaries, int* addSemanticIndexes, double* cacheExtent, ArrayC* children, int* semanticChildCount, int* dragStartBehavior, int* keyboardDismissBehavior, char* restorationId, int* clipBehavior, int* hitTestBehavior);
  } gridView;

  struct PageViewSt {
    PageViewObjSt (*pageView)(int* scrollDirection, int* reverse, int* pageSnapping, ValueChangedForIntFFI* onPageChanged, ArrayC* children, int* dragStartBehavior, int* allowImplicitScrolling, char* restorationId, int* clipBehavior, int* hitTestBehavior, int* padEnds);
    PageViewObjSt (*builder)(int* scrollDirection, int* reverse, int* pageSnapping, ValueChangedForIntFFI* onPageChanged, NullableIndexedWidgetBuilderFFI itemBuilder, int* itemCount, int* dragStartBehavior, int* allowImplicitScrolling, char* restorationId, int* clipBehavior, int* hitTestBehavior, int* padEnds);
  } pageView;

  struct ListWheelScrollViewSt {
    ListWheelScrollViewObjSt (*listWheelScrollView)(double* diameterRatio, double* perspective, double* offAxisFraction, int* useMagnifier, double* magnification, double* overAndUnderCenterOpacity, double itemExtent, double* squeeze, ValueChangedForIntFFI* onSelectedItemChanged, int* renderChildrenOutsideViewport, int* clipBehavior, int* hitTestBehavior, char* restorationId, int* dragStartBehavior, int* changeReportingBehavior, ArrayC children);
  } listWheelScrollView;

  struct AnimatedSizeSt {
    AnimatedSizeObjSt (*animatedSize)(DartObj* child, DartObj* alignment, DartObj* curve, DartObj duration, DartObj* reverseDuration, int* clipBehavior, VoidCallbackFFI* onEnd);
  } animatedSize;

  struct AnimatedScaleSt {
    AnimatedScaleObjSt (*animatedScale)(DartObj* child, double scale, DartObj* alignment, int* filterQuality, DartObj* curve, DartObj duration, VoidCallbackFFI* onEnd);
  } animatedScale;

  struct AnimatedRotationSt {
    AnimatedRotationObjSt (*animatedRotation)(DartObj* child, double turns, DartObj* alignment, int* filterQuality, DartObj* curve, DartObj duration, VoidCallbackFFI* onEnd);
  } animatedRotation;

  struct AnimatedSlideSt {
    AnimatedSlideObjSt (*animatedSlide)(DartObj* child, DartObj offset, DartObj* curve, DartObj duration, VoidCallbackFFI* onEnd);
  } animatedSlide;

  struct AnimatedCrossFadeSt {
    AnimatedCrossFadeObjSt (*animatedCrossFade)(DartObj firstChild, DartObj secondChild, DartObj* firstCurve, DartObj* secondCurve, DartObj* sizeCurve, DartObj* alignment, int crossFadeState, DartObj duration, DartObj* reverseDuration, int* excludeBottomFocus);
  } animatedCrossFade;

  struct SlideTransitionSt {
    SlideTransitionObjSt (*slideTransition)(DartObj position, int* transformHitTests, int* textDirection, DartObj* child);
  } slideTransition;

  struct SizeTransitionSt {
    SizeTransitionObjSt (*sizeTransition)(int* axis, DartObj sizeFactor, double* axisAlignment, double* fixedCrossAxisSizeFactor, DartObj* child);
  } sizeTransition;

  struct IndexedStackSt {
    IndexedStackObjSt (*indexedStack)(DartObj* alignment, int* textDirection, int* clipBehavior, int* sizing, int* index, ArrayC* children);
  } indexedStack;

  struct InteractiveViewerSt {
    InteractiveViewerObjSt (*interactiveViewer)(int* clipBehavior, int* panAxis, DartObj* boundaryMargin, int* constrained, double* maxScale, double* minScale, double* interactionEndFrictionCoefficient, int* panEnabled, int* scaleEnabled, double* scaleFactor, DartObj* alignment, int* trackpadScrollCausesScale, DartObj child);
  } interactiveViewer;

  struct DraggableSt {
    DraggableObjSt (*draggable)(DartObj child, DartObj feedback, DartObj* data, int* axis, DartObj* childWhenDragging, DartObj* feedbackOffset, DragAnchorStrategyFFI* dragAnchorStrategy, int* affinity, int* maxSimultaneousDrags, VoidCallbackFFI* onDragStarted, VoidCallbackFFI* onDragCompleted, int* ignoringFeedbackSemantics, int* ignoringFeedbackPointer, int* rootOverlay, int* hitTestBehavior, AllowedButtonsFilterFFI* allowedButtonsFilter);
  } draggable;

  struct DragTargetSt {
    DragTargetObjSt (*dragTarget)(DragTargetBuilderForTFFI builder, DragTargetWillAcceptForTFFI* onWillAccept, DragTargetAcceptForTFFI* onAccept, DragTargetLeaveForTFFI* onLeave, int* hitTestBehavior);
  } dragTarget;

  struct HeroSt {
    HeroObjSt (*hero)(DartObj tag, HeroFlightShuttleBuilderFFI* flightShuttleBuilder, int* transitionOnUserGestures, DartObj child);
  } hero;

  struct AnimatedSwitcherSt {
    AnimatedSwitcherObjSt (*animatedSwitcher)(DartObj* child, DartObj duration, DartObj* reverseDuration, DartObj* switchInCurve, DartObj* switchOutCurve, AnimatedSwitcherTransitionBuilderFFI* transitionBuilder, AnimatedSwitcherLayoutBuilderFFI* layoutBuilder);
    DartObj (*defaultTransitionBuilder)(DartObj child, DartObj animation);
    DartObj (*defaultLayoutBuilder)(DartObj currentChild, ArrayC previousChildren);
  } animatedSwitcher;

  struct ColorFilterSt {
    DartObj (*mode)(DartObj color, int blendMode);
    DartObj (*linearToSrgbGamma)(void);
    DartObj (*srgbToLinearGamma)(void);
  } colorFilter;

  struct BackdropFilterSt {
    BackdropFilterObjSt (*backdropFilter)(DartObj filter, DartObj* child, int* blendMode, int* enabled);
    BackdropFilterObjSt (*grouped)(DartObj filter, DartObj* child, int* blendMode, int* enabled);
  } backdropFilter;

  struct ImageFilterSt {
    DartObj (*blur)(double* sigmaX, double* sigmaY, int* tileMode);
    DartObj (*dilate)(double* radiusX, double* radiusY);
    DartObj (*erode)(double* radiusX, double* radiusY);
    DartObj (*compose)(DartObj outer, DartObj inner);
  } imageFilter;

  struct ColorFilteredSt {
    ColorFilteredObjSt (*colorFiltered)(DartObj colorFilter, DartObj* child);
  } colorFiltered;

  struct ImageFilteredSt {
    ImageFilteredObjSt (*imageFiltered)(DartObj imageFilter, DartObj* child, int* enabled);
  } imageFiltered;

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

  struct VisualDensitySt {
    VisualDensityObjSt (*visualDensity)(double* horizontal, double* vertical);
    VisualDensityObjSt (*defaultDensityForPlatform)(int platform);
    VisualDensityObjSt (*lerp)(DartObj a, DartObj b, double t);
  } visualDensity;

  struct ThemeDataSt {
    ThemeDataObjSt (*themeData)(int* applyElevationOverlayColor, DartObj* inputDecorationTheme, int* materialTapTargetSize, int* platform, int* useMaterial3, int* useSystemColors, DartObj* visualDensity, DartObj* colorScheme, int* brightness, DartObj* colorSchemeSeed, DartObj* canvasColor, DartObj* cardColor, DartObj* disabledColor, DartObj* dividerColor, DartObj* focusColor, DartObj* highlightColor, DartObj* hintColor, DartObj* hoverColor, DartObj* primaryColor, DartObj* primaryColorDark, DartObj* primaryColorLight, DartObj* primarySwatch, DartObj* scaffoldBackgroundColor, DartObj* secondaryHeaderColor, DartObj* shadowColor, DartObj* splashColor, DartObj* unselectedWidgetColor, char* fontFamily, char*** fontFamilyFallback, char* package, DartObj* primaryTextTheme, DartObj* textTheme, DartObj* appBarTheme, DartObj* dialogBackgroundColor, DartObj* indicatorColor);
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
    MaterialObjSt (*material)(int* type, double* elevation, DartObj* color, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* textStyle, DartObj* borderRadius, DartObj* shape, int* borderOnForeground, int* clipBehavior, DartObj* animationDuration, DartObj* child, int* animateColor);
  } material;

  struct IconButtonSt {
    IconButtonObjSt (*iconButton)(double* iconSize, DartObj* visualDensity, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
    IconButtonObjSt (*filled)(double* iconSize, DartObj* visualDensity, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
    IconButtonObjSt (*filledTonal)(double* iconSize, DartObj* visualDensity, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
    IconButtonObjSt (*outlined)(double* iconSize, DartObj* visualDensity, DartObj* padding, DartObj* alignment, double* splashRadius, DartObj* color, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, DartObj* disabledColor, VoidCallbackFFI onPressed, ValueChangedForBoolFFI* onHover, VoidCallbackFFI* onLongPress, int* autofocus, char* tooltip, int* enableFeedback, DartObj* constraints, int* isSelected, DartObj* selectedIcon, DartObj icon);
  } iconButton;

  struct AppBarSt {
    AppBarObjSt (*appBar)(DartObj* leading, int* automaticallyImplyLeading, DartObj* title, ArrayC* actions, DartObj* flexibleSpace, DartObj* bottom, double* elevation, double* scrolledUnderElevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* shape, DartObj* backgroundColor, DartObj* foregroundColor, int* primary, int* centerTitle, int* excludeHeaderSemantics, double* titleSpacing, double* toolbarOpacity, double* bottomOpacity, double* toolbarHeight, double* leadingWidth, DartObj* toolbarTextStyle, DartObj* titleTextStyle, int* forceMaterialTransparency, int* useDefaultSemanticsOrder, int* clipBehavior, DartObj* actionsPadding, int* animateColor);
  } appBar;

  struct ScaffoldSt {
    ScaffoldObjSt (*scaffold)(DartObj* appBar, DartObj* body, DartObj* floatingActionButton, ArrayC* persistentFooterButtons, DartObj* persistentFooterAlignment, DartObj* persistentFooterDecoration, DartObj* drawer, DrawerCallbackFFI* onDrawerChanged, DartObj* endDrawer, DrawerCallbackFFI* onEndDrawerChanged, DartObj* bottomNavigationBar, DartObj* bottomSheet, DartObj* backgroundColor, int* resizeToAvoidBottomInset, int* primary, int* drawerDragStartBehavior, int* extendBody, int* drawerBarrierDismissible, int* extendBodyBehindAppBar, DartObj* drawerScrimColor, DartObjCallbackDartObjDartObjFFI* bottomSheetScrimBuilder, double* drawerEdgeDragWidth, int* drawerEnableOpenDragGesture, int* endDrawerEnableOpenDragGesture, char* restorationId);
    DartObj (*geometryOf)(DartObj context);
    int (*hasDrawer)(DartObj context, int* registerForUpdates);
  } scaffold;

  struct MaterialAppSt {
    MaterialAppObjSt (*materialApp)(DartObj* home, char* initialRoute, TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, DartObj* themeAnimationDuration, DartObj* themeAnimationCurve, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
    MaterialAppObjSt (*router)(TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, DartObj* theme, DartObj* darkTheme, DartObj* highContrastTheme, DartObj* highContrastDarkTheme, int* themeMode, DartObj* themeAnimationDuration, DartObj* themeAnimationCurve, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
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
    int (*brightnessOf)(DartObj context);
    int (*maybeBrightnessOf)(DartObj context);
  } theme;

  struct ElevatedButtonSt {
    ElevatedButtonObjSt (*elevatedButton)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj child);
    ElevatedButtonObjSt (*icon)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj* icon, DartObj label, int* iconAlignment);
  } elevatedButton;

  struct OutlinedButtonSt {
    OutlinedButtonObjSt (*outlinedButton)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj child);
    OutlinedButtonObjSt (*icon)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj* icon, DartObj label, int* iconAlignment);
  } outlinedButton;

  struct TextButtonSt {
    TextButtonObjSt (*textButton)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, int* isSemanticButton, DartObj child);
    TextButtonObjSt (*icon)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj* icon, DartObj label, int* iconAlignment);
  } textButton;

  struct NavigatorStateSt {
    DartObj (*navigatorState)(void);
  } navigatorState;

  struct NavigatorSt {
    NavigatorObjSt (*navigator)(char* initialRoute, int* reportsRouteUpdateToEngine, int* clipBehavior, int* requestFocus, char* restorationScopeId, int* routeTraversalEdgeBehavior, int* routeDirectionalTraversalEdgeBehavior);
    DartObj (*pushNamed)(DartObj context, char* routeName, DartObj* arguments);
    char* (*restorablePushNamed)(DartObj context, char* routeName, DartObj* arguments);
    DartObj (*pushReplacementNamed)(DartObj context, char* routeName, DartObj* result, DartObj* arguments);
    char* (*restorablePushReplacementNamed)(DartObj context, char* routeName, DartObj* result, DartObj* arguments);
    DartObj (*popAndPushNamed)(DartObj context, char* routeName, DartObj* result, DartObj* arguments);
    char* (*restorablePopAndPushNamed)(DartObj context, char* routeName, DartObj* result, DartObj* arguments);
    int (*canPop)(DartObj context);
    DartObj (*maybePop)(DartObj context, DartObj* result);
    void (*pop)(DartObj context, DartObj* result);
    DartObj (*of)(DartObj context, int* rootNavigator);
    DartObj (*maybeOf)(DartObj context, int* rootNavigator);
  } navigator;

  struct AlertDialogSt {
    AlertDialogObjSt (*alertDialog)(DartObj* icon, DartObj* iconPadding, DartObj* iconColor, DartObj* title, DartObj* titlePadding, DartObj* titleTextStyle, DartObj* content, DartObj* contentPadding, DartObj* contentTextStyle, ArrayC* actions, DartObj* actionsPadding, int* actionsAlignment, int* actionsOverflowAlignment, int* actionsOverflowDirection, double* actionsOverflowButtonSpacing, DartObj* buttonPadding, DartObj* backgroundColor, double* elevation, DartObj* shadowColor, DartObj* surfaceTintColor, char* semanticLabel, DartObj* insetPadding, int* clipBehavior, DartObj* shape, DartObj* alignment, DartObj* constraints, int* scrollable);
    AlertDialogObjSt (*adaptive)(DartObj* icon, DartObj* iconPadding, DartObj* iconColor, DartObj* title, DartObj* titlePadding, DartObj* titleTextStyle, DartObj* content, DartObj* contentPadding, DartObj* contentTextStyle, ArrayC* actions, DartObj* actionsPadding, int* actionsAlignment, int* actionsOverflowAlignment, int* actionsOverflowDirection, double* actionsOverflowButtonSpacing, DartObj* buttonPadding, DartObj* backgroundColor, double* elevation, DartObj* shadowColor, DartObj* surfaceTintColor, char* semanticLabel, DartObj* insetPadding, int* clipBehavior, DartObj* shape, DartObj* alignment, DartObj* constraints, int* scrollable, DartObj* insetAnimationDuration, DartObj* insetAnimationCurve);
  } alertDialog;

  struct InputDecorationSt {
    InputDecorationObjSt (*inputDecoration)(DartObj* icon, DartObj* iconColor, DartObj* label, char* labelText, DartObj* labelStyle, DartObj* floatingLabelStyle, DartObj* helper, char* helperText, DartObj* helperStyle, int* helperMaxLines, char* hintText, DartObj* hint, DartObj* hintStyle, int* hintTextDirection, int* hintMaxLines, DartObj* hintFadeDuration, int* maintainHintHeight, int* maintainHintSize, DartObj* error, char* errorText, DartObj* errorStyle, int* errorMaxLines, int* floatingLabelBehavior, int* isCollapsed, int* isDense, DartObj* contentPadding, DartObj* prefixIcon, DartObj* prefixIconConstraints, DartObj* prefix, char* prefixText, DartObj* prefixStyle, DartObj* prefixIconColor, DartObj* suffixIcon, DartObj* suffix, char* suffixText, DartObj* suffixStyle, DartObj* suffixIconColor, DartObj* suffixIconConstraints, DartObj* counter, char* counterText, DartObj* counterStyle, int* filled, DartObj* fillColor, DartObj* focusColor, DartObj* hoverColor, DartObj* errorBorder, DartObj* focusedBorder, DartObj* focusedErrorBorder, DartObj* disabledBorder, DartObj* enabledBorder, DartObj* border, int* enabled, char* semanticCounterText, int* alignLabelWithHint, DartObj* constraints, DartObj* visualDensity);
    InputDecorationObjSt (*collapsed)(char* hintText, int* floatingLabelBehavior, DartObj* hintStyle, DartObj* hint, int* hintTextDirection, int* hintMaxLines, DartObj* hintFadeDuration, int* maintainHintHeight, int* maintainHintSize, int* filled, DartObj* fillColor, DartObj* focusColor, DartObj* hoverColor, DartObj* border, int* enabled, DartObj* constraints);
  } inputDecoration;

  struct InputBorderSt {
    DartObj none;
  } inputBorder;

  struct TextFieldSt {
    TextFieldObjSt (*textField)(DartObj* groupId, DartObj* decoration, int* textInputAction, int* textCapitalization, DartObj* style, int* textAlign, int* textDirection, int* readOnly, int* showCursor, int* autofocus, char* obscuringCharacter, int* obscureText, int* autocorrect, int* smartDashesType, int* smartQuotesType, int* enableSuggestions, int* maxLines, int* minLines, int* expands, int* maxLength, int* maxLengthEnforcement, ValueChangedForStringFFI* onChanged, VoidCallbackFFI* onEditingComplete, ValueChangedForStringFFI* onSubmitted, int* enabled, int* ignorePointers, double* cursorWidth, double* cursorHeight, DartObj* cursorRadius, int* cursorOpacityAnimates, DartObj* cursorColor, DartObj* cursorErrorColor, int* selectionHeightStyle, int* selectionWidthStyle, int* keyboardAppearance, DartObj* scrollPadding, int* dragStartBehavior, int* enableInteractiveSelection, int* selectAllOnFocus, GestureTapCallbackFFI* onTap, int* onTapAlwaysCalled, InputCounterWidgetBuilderFFI* buildCounter, int* clipBehavior, char* restorationId, int* scribbleEnabled, int* stylusHandwritingEnabled, int* enableIMEPersonalizedLearning, int* canRequestFocus);
  } textField;

  struct DividerSt {
    DividerObjSt (*divider)(double* height, double* thickness, double* indent, double* endIndent, DartObj* color, DartObj* radius);
    BorderSideObjSt (*createBorderSide)(DartObj context, DartObj* color, double* width);
  } divider;

  struct FilledButtonSt {
    FilledButtonObjSt (*filledButton)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj child);
    FilledButtonObjSt (*icon)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj* icon, DartObj label, int* iconAlignment);
    FilledButtonObjSt (*tonal)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj child);
    FilledButtonObjSt (*tonalIcon)(VoidCallbackFFI onPressed, VoidCallbackFFI* onLongPress, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* clipBehavior, DartObj* icon, DartObj label, int* iconAlignment);
  } filledButton;

  struct OutlineInputBorderSt {
    OutlineInputBorderObjSt (*outlineInputBorder)(DartObj* borderSide, DartObj* borderRadius, double* gapPadding);
  } outlineInputBorder;

  struct SnackBarActionSt {
    SnackBarActionObjSt (*snackBarAction)(DartObj* textColor, DartObj* disabledTextColor, DartObj* backgroundColor, DartObj* disabledBackgroundColor, char* label, VoidCallbackFFI onPressed);
  } snackBarAction;

  struct SnackBarSt {
    SnackBarObjSt (*snackBar)(DartObj content, DartObj* backgroundColor, double* elevation, DartObj* margin, DartObj* padding, double* width, DartObj* shape, int* hitTestBehavior, int* behavior, DartObj* action, double* actionOverflowThreshold, int* showCloseIcon, DartObj* closeIconColor, DartObj* duration, DartObj* animation, VoidCallbackFFI* onVisible, int* dismissDirection, int* clipBehavior);
    DartObj (*createAnimationController)(DartObj vsync, DartObj* duration, DartObj* reverseDuration);
  } snackBar;

  struct ScaffoldMessengerSt {
    ScaffoldMessengerObjSt (*scaffoldMessenger)(DartObj child);
  } scaffoldMessenger;

  struct CardSt {
    CardObjSt (*card)(DartObj* color, DartObj* shadowColor, DartObj* surfaceTintColor, double* elevation, DartObj* shape, int* borderOnForeground, DartObj* margin, int* clipBehavior, DartObj* child, int* semanticContainer);
    CardObjSt (*filled)(DartObj* color, DartObj* shadowColor, DartObj* surfaceTintColor, double* elevation, DartObj* shape, int* borderOnForeground, DartObj* margin, int* clipBehavior, DartObj* child, int* semanticContainer);
    CardObjSt (*outlined)(DartObj* color, DartObj* shadowColor, DartObj* surfaceTintColor, double* elevation, DartObj* shape, int* borderOnForeground, DartObj* margin, int* clipBehavior, DartObj* child, int* semanticContainer);
  } card;

  struct ChipSt {
    ChipObjSt (*chip)(DartObj* avatar, DartObj label, DartObj* labelStyle, DartObj* labelPadding, DartObj* deleteIcon, VoidCallbackFFI* onDeleted, DartObj* deleteIconColor, char* deleteButtonTooltipMessage, DartObj* side, DartObj* shape, int* clipBehavior, int* autofocus, DartObj* backgroundColor, DartObj* padding, DartObj* visualDensity, int* materialTapTargetSize, double* elevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* avatarBoxConstraints, DartObj* deleteIconBoxConstraints);
  } chip;

  struct GestureDetectorSt {
    GestureDetectorObjSt (*gestureDetector)(DartObj* child, GestureTapCallbackFFI* onTap, GestureTapCancelCallbackFFI* onTapCancel, GestureTapCallbackFFI* onSecondaryTap, GestureTapCancelCallbackFFI* onSecondaryTapCancel, GestureTapCancelCallbackFFI* onTertiaryTapCancel, GestureTapCallbackFFI* onDoubleTap, GestureTapCancelCallbackFFI* onDoubleTapCancel, GestureLongPressCancelCallbackFFI* onLongPressCancel, GestureLongPressCallbackFFI* onLongPress, GestureLongPressUpCallbackFFI* onLongPressUp, GestureLongPressCancelCallbackFFI* onSecondaryLongPressCancel, GestureLongPressCallbackFFI* onSecondaryLongPress, GestureLongPressUpCallbackFFI* onSecondaryLongPressUp, GestureLongPressCancelCallbackFFI* onTertiaryLongPressCancel, GestureLongPressCallbackFFI* onTertiaryLongPress, GestureLongPressUpCallbackFFI* onTertiaryLongPressUp, GestureDragCancelCallbackFFI* onVerticalDragCancel, GestureDragCancelCallbackFFI* onHorizontalDragCancel, GestureDragCancelCallbackFFI* onPanCancel, int* behavior, int* excludeFromSemantics, int* dragStartBehavior, int* trackpadScrollCausesScale, DartObj* trackpadScrollToScaleFactor);
  } gestureDetector;

  struct ListTileSt {
    ListTileObjSt (*listTile)(DartObj* leading, DartObj* title, DartObj* subtitle, DartObj* trailing, int* isThreeLine, int* dense, DartObj* visualDensity, DartObj* shape, int* style, DartObj* selectedColor, DartObj* iconColor, DartObj* textColor, DartObj* titleTextStyle, DartObj* subtitleTextStyle, DartObj* leadingAndTrailingTextStyle, DartObj* contentPadding, int* enabled, GestureTapCallbackFFI* onTap, GestureLongPressCallbackFFI* onLongPress, ValueChangedForBoolFFI* onFocusChange, int* selected, DartObj* focusColor, DartObj* hoverColor, DartObj* splashColor, int* autofocus, DartObj* tileColor, DartObj* selectedTileColor, int* enableFeedback, double* horizontalTitleGap, double* minVerticalPadding, double* minLeadingWidth, double* minTileHeight, int* titleAlignment, int* internalAddSemanticForOnTap);
  } listTile;

  struct WrapSt {
    WrapObjSt (*wrap)(int* direction, int* alignment, double* spacing, int* runAlignment, double* runSpacing, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* clipBehavior, ArrayC* children);
  } wrap;

  struct SingleChildScrollViewSt {
    SingleChildScrollViewObjSt (*singleChildScrollView)(int* scrollDirection, int* reverse, DartObj* padding, int* primary, DartObj* child, int* dragStartBehavior, int* clipBehavior, int* hitTestBehavior, char* restorationId, int* keyboardDismissBehavior);
  } singleChildScrollView;

  struct CircularProgressIndicatorSt {
    CircularProgressIndicatorObjSt (*circularProgressIndicator)(double* value, DartObj* backgroundColor, DartObj* color, DartObj* valueColor, double* strokeWidth, double* strokeAlign, char* semanticsLabel, char* semanticsValue, int* strokeCap, DartObj* constraints, double* trackGap, int* year2023, DartObj* padding);
    CircularProgressIndicatorObjSt (*adaptive)(double* value, DartObj* backgroundColor, DartObj* valueColor, double* strokeWidth, char* semanticsLabel, char* semanticsValue, int* strokeCap, double* strokeAlign, DartObj* constraints, double* trackGap, int* year2023, DartObj* padding);
  } circularProgressIndicator;

  struct LinearProgressIndicatorSt {
    LinearProgressIndicatorObjSt (*linearProgressIndicator)(double* value, DartObj* backgroundColor, DartObj* color, DartObj* valueColor, double* minHeight, char* semanticsLabel, char* semanticsValue, DartObj* borderRadius, DartObj* stopIndicatorColor, double* stopIndicatorRadius, double* trackGap, int* year2023);
  } linearProgressIndicator;

  struct CheckboxSt {
    CheckboxObjSt (*checkbox)(int value, int* tristate, ValueChangedForBoolOptFFI onChanged, DartObj* activeColor, DartObj* checkColor, DartObj* focusColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* visualDensity, int* autofocus, DartObj* shape, DartObj* side, int* isError, char* semanticLabel);
    CheckboxObjSt (*adaptive)(int value, int* tristate, ValueChangedForBoolOptFFI onChanged, DartObj* activeColor, DartObj* checkColor, DartObj* focusColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* visualDensity, int* autofocus, DartObj* shape, DartObj* side, int* isError, char* semanticLabel);
  } checkbox;

  struct SwitchSt {
    SwitchObjSt (*switch_)(int value, ValueChangedForBoolFFI onChanged, DartObj* activeColor, DartObj* activeThumbColor, DartObj* activeTrackColor, DartObj* inactiveThumbColor, DartObj* inactiveTrackColor, int* materialTapTargetSize, int* dragStartBehavior, DartObj* focusColor, DartObj* hoverColor, double* splashRadius, ValueChangedForBoolFFI* onFocusChange, int* autofocus, DartObj* padding);
    SwitchObjSt (*adaptive)(int value, ValueChangedForBoolFFI onChanged, DartObj* activeColor, DartObj* activeThumbColor, DartObj* activeTrackColor, DartObj* inactiveThumbColor, DartObj* inactiveTrackColor, int* materialTapTargetSize, int* dragStartBehavior, DartObj* focusColor, DartObj* hoverColor, double* splashRadius, ValueChangedForBoolFFI* onFocusChange, int* autofocus, DartObj* padding, int* applyCupertinoTheme);
  } switch_;

  struct SliderSt {
    SliderObjSt (*slider)(double value, double* secondaryTrackValue, ValueChangedForDoubleFFI onChanged, ValueChangedForDoubleFFI* onChangeStart, ValueChangedForDoubleFFI* onChangeEnd, double* min, double* max, int* divisions, char* label, DartObj* activeColor, DartObj* inactiveColor, DartObj* secondaryActiveColor, DartObj* thumbColor, SemanticFormatterCallbackFFI* semanticFormatterCallback, int* autofocus, int* allowedInteraction, DartObj* padding, int* year2023);
    SliderObjSt (*adaptive)(double value, double* secondaryTrackValue, ValueChangedForDoubleFFI onChanged, ValueChangedForDoubleFFI* onChangeStart, ValueChangedForDoubleFFI* onChangeEnd, double* min, double* max, int* divisions, char* label, DartObj* activeColor, DartObj* inactiveColor, DartObj* secondaryActiveColor, DartObj* thumbColor, SemanticFormatterCallbackFFI* semanticFormatterCallback, int* autofocus, int* allowedInteraction, int* year2023);
  } slider;

  struct DrawerSt {
    DrawerObjSt (*drawer)(DartObj* backgroundColor, double* elevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* shape, double* width, DartObj* child, char* semanticLabel, int* clipBehavior);
  } drawer;

  struct TooltipSt {
    TooltipObjSt (*tooltip)(char* message, DartObj* richMessage, double* height, DartObj* constraints, DartObj* padding, DartObj* margin, double* verticalOffset, int* preferBelow, int* excludeFromSemantics, DartObj* decoration, DartObj* textStyle, int* textAlign, DartObj* waitDuration, DartObj* showDuration, DartObj* exitDuration, int* enableTapToDismiss, int* triggerMode, int* enableFeedback, TooltipTriggeredCallbackFFI* onTriggered, int* ignorePointer, DartObj* child);
    int (*dismissAllToolTips)(void);
  } tooltip;

  struct TabSt {
    TabObjSt (*tab)(char* text, DartObj* icon, DartObj* iconMargin, double* height, DartObj* child);
  } tab;

  struct TabBarSt {
    TabBarObjSt (*tabBar)(ArrayC tabs, int* isScrollable, DartObj* padding, DartObj* indicatorColor, int* automaticIndicatorColorAdjustment, double* indicatorWeight, DartObj* indicatorPadding, DartObj* indicator, int* indicatorSize, DartObj* dividerColor, double* dividerHeight, DartObj* labelColor, DartObj* labelStyle, DartObj* labelPadding, DartObj* unselectedLabelColor, DartObj* unselectedLabelStyle, int* dragStartBehavior, int* enableFeedback, ValueChangedForIntFFI* onTap, TabValueChangedForBoolFFI* onHover, TabValueChangedForBoolFFI* onFocusChange, DartObj* splashBorderRadius, int* tabAlignment, int* indicatorAnimation);
    TabBarObjSt (*secondary)(ArrayC tabs, int* isScrollable, DartObj* padding, DartObj* indicatorColor, int* automaticIndicatorColorAdjustment, double* indicatorWeight, DartObj* indicatorPadding, DartObj* indicator, int* indicatorSize, DartObj* dividerColor, double* dividerHeight, DartObj* labelColor, DartObj* labelStyle, DartObj* labelPadding, DartObj* unselectedLabelColor, DartObj* unselectedLabelStyle, int* dragStartBehavior, int* enableFeedback, ValueChangedForIntFFI* onTap, TabValueChangedForBoolFFI* onHover, TabValueChangedForBoolFFI* onFocusChange, DartObj* splashBorderRadius, int* tabAlignment, int* indicatorAnimation);
  } tabBar;

  struct TabBarViewSt {
    TabBarViewObjSt (*tabBarView)(ArrayC children, int* dragStartBehavior, double* viewportFraction, int* clipBehavior);
  } tabBarView;

  struct DefaultTabControllerSt {
    DefaultTabControllerObjSt (*defaultTabController)(int length, int* initialIndex, DartObj child, DartObj* animationDuration);
  } defaultTabController;

  struct CheckboxListTileSt {
    CheckboxListTileObjSt (*checkboxListTile)(int value, ValueChangedForBoolOptFFI onChanged, DartObj* activeColor, DartObj* checkColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* visualDensity, int* autofocus, DartObj* shape, DartObj* side, int* isError, int* enabled, DartObj* tileColor, DartObj* title, DartObj* subtitle, int* isThreeLine, int* dense, DartObj* secondary, int* selected, int* controlAffinity, DartObj* contentPadding, int* tristate, DartObj* checkboxShape, DartObj* selectedTileColor, ValueChangedForBoolFFI* onFocusChange, int* enableFeedback, char* checkboxSemanticLabel, double* checkboxScaleFactor, int* titleAlignment, int* internalAddSemanticForOnTap);
    CheckboxListTileObjSt (*adaptive)(int value, ValueChangedForBoolOptFFI onChanged, DartObj* activeColor, DartObj* checkColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* visualDensity, int* autofocus, DartObj* shape, DartObj* side, int* isError, int* enabled, DartObj* tileColor, DartObj* title, DartObj* subtitle, int* isThreeLine, int* dense, DartObj* secondary, int* selected, int* controlAffinity, DartObj* contentPadding, int* tristate, DartObj* checkboxShape, DartObj* selectedTileColor, ValueChangedForBoolFFI* onFocusChange, int* enableFeedback, char* checkboxSemanticLabel, double* checkboxScaleFactor, int* titleAlignment, int* internalAddSemanticForOnTap);
  } checkboxListTile;

  struct SwitchListTileSt {
    SwitchListTileObjSt (*switchListTile)(int value, ValueChangedForBoolFFI onChanged, DartObj* activeColor, DartObj* activeThumbColor, DartObj* activeTrackColor, DartObj* inactiveThumbColor, DartObj* inactiveTrackColor, int* materialTapTargetSize, int* dragStartBehavior, double* splashRadius, ValueChangedForBoolFFI* onFocusChange, int* autofocus, DartObj* tileColor, DartObj* title, DartObj* subtitle, int* isThreeLine, int* dense, DartObj* contentPadding, DartObj* secondary, int* selected, int* controlAffinity, DartObj* shape, DartObj* selectedTileColor, DartObj* visualDensity, int* enableFeedback, DartObj* hoverColor, int* internalAddSemanticForOnTap);
    SwitchListTileObjSt (*adaptive)(int value, ValueChangedForBoolFFI onChanged, DartObj* activeColor, DartObj* activeThumbColor, DartObj* activeTrackColor, DartObj* inactiveThumbColor, DartObj* inactiveTrackColor, int* materialTapTargetSize, int* dragStartBehavior, double* splashRadius, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* applyCupertinoTheme, DartObj* tileColor, DartObj* title, DartObj* subtitle, int* isThreeLine, int* dense, DartObj* contentPadding, DartObj* secondary, int* selected, int* controlAffinity, DartObj* shape, DartObj* selectedTileColor, DartObj* visualDensity, int* enableFeedback, DartObj* hoverColor, int* internalAddSemanticForOnTap);
  } switchListTile;

  struct BadgeSt {
    BadgeObjSt (*badge)(DartObj* backgroundColor, DartObj* textColor, double* smallSize, double* largeSize, DartObj* textStyle, DartObj* padding, DartObj* alignment, DartObj* offset, DartObj* label, int* isLabelVisible, DartObj* child);
    BadgeObjSt (*count)(DartObj* backgroundColor, DartObj* textColor, double* smallSize, double* largeSize, DartObj* textStyle, DartObj* padding, DartObj* alignment, DartObj* offset, int count, int* isLabelVisible, DartObj* child);
  } badge;

  struct SelectableTextSt {
    SelectableTextObjSt (*selectableText)(char* data, DartObj* style, int* textAlign, int* textDirection, double* textScaleFactor, int* showCursor, int* autofocus, int* minLines, int* maxLines, double* cursorWidth, double* cursorHeight, DartObj* cursorRadius, DartObj* cursorColor, DartObj* selectionColor, int* selectionHeightStyle, int* selectionWidthStyle, int* dragStartBehavior, int* enableInteractiveSelection, GestureTapCallbackFFI* onTap, char* semanticsLabel, int* textWidthBasis);
    SelectableTextObjSt (*rich)(DartObj textSpan, DartObj* style, int* textAlign, int* textDirection, double* textScaleFactor, int* showCursor, int* autofocus, int* minLines, int* maxLines, double* cursorWidth, double* cursorHeight, DartObj* cursorRadius, DartObj* cursorColor, DartObj* selectionColor, int* selectionHeightStyle, int* selectionWidthStyle, int* dragStartBehavior, int* enableInteractiveSelection, GestureTapCallbackFFI* onTap, char* semanticsLabel, int* textWidthBasis);
  } selectableText;

  struct InkWellSt {
    InkWellObjSt (*inkWell)(DartObj* child, GestureTapCallbackFFI* onTap, GestureTapCallbackFFI* onDoubleTap, GestureLongPressCallbackFFI* onLongPress, GestureTapCallbackFFI* onTapCancel, GestureTapCallbackFFI* onSecondaryTap, GestureTapCallbackFFI* onSecondaryTapCancel, ValueChangedForBoolFFI* onHighlightChanged, ValueChangedForBoolFFI* onHover, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, double* radius, DartObj* borderRadius, DartObj* customBorder, int* enableFeedback, int* excludeFromSemantics, int* canRequestFocus, ValueChangedForBoolFFI* onFocusChange, int* autofocus, DartObj* hoverDuration);
  } inkWell;

  struct InkResponseSt {
    InkResponseObjSt (*inkResponse)(DartObj* child, GestureTapCallbackFFI* onTap, GestureTapCallbackFFI* onTapCancel, GestureTapCallbackFFI* onDoubleTap, GestureLongPressCallbackFFI* onLongPress, GestureTapCallbackFFI* onSecondaryTap, GestureTapCallbackFFI* onSecondaryTapCancel, ValueChangedForBoolFFI* onHighlightChanged, ValueChangedForBoolFFI* onHover, int* containedInkWell, int* highlightShape, double* radius, DartObj* borderRadius, DartObj* customBorder, DartObj* focusColor, DartObj* hoverColor, DartObj* highlightColor, DartObj* splashColor, int* enableFeedback, int* excludeFromSemantics, int* canRequestFocus, ValueChangedForBoolFFI* onFocusChange, int* autofocus, DartObj* hoverDuration);
  } inkResponse;

  struct DataTableSt {
    DataTableObjSt (*dataTable)(ArrayC columns, int* sortColumnIndex, int* sortAscending, ValueSetterForBoolOptFFI* onSelectAll, DartObj* decoration, double* dataRowHeight, double* dataRowMinHeight, double* dataRowMaxHeight, DartObj* dataTextStyle, double* headingRowHeight, DartObj* headingTextStyle, double* horizontalMargin, double* columnSpacing, int* showCheckboxColumn, int* showBottomBorder, double* dividerThickness, ArrayC rows, double* checkboxHorizontalMargin, int* clipBehavior);
  } dataTable;

  struct DataColumnSt {
    DataColumnObjSt (*dataColumn)(DartObj label, char* tooltip, int* numeric, DataColumnSortCallbackFFI* onSort, int* headingRowAlignment);
  } dataColumn;

  struct DataRowSt {
    DataRowObjSt (*dataRow)(int* selected, ValueChangedForBoolOptFFI* onSelectChanged, GestureLongPressCallbackFFI* onLongPress, ArrayC cells);
    DataRowObjSt (*byIndex)(int* index, int* selected, ValueChangedForBoolOptFFI* onSelectChanged, GestureLongPressCallbackFFI* onLongPress, ArrayC cells);
  } dataRow;

  struct DataCellSt {
    DataCellObjSt (*dataCell)(DartObj child, int* placeholder, int* showEditIcon, GestureTapCallbackFFI* onTap, GestureLongPressCallbackFFI* onLongPress, GestureTapCallbackFFI* onDoubleTap, GestureTapCancelCallbackFFI* onTapCancel);
  } dataCell;

  struct DropdownMenuEntrySt {
    DartObj (*dropdownMenuEntry)(DartObj value, char* label, DartObj* labelWidget, DartObj* leadingIcon, DartObj* trailingIcon, int* enabled);
  } dropdownMenuEntry;

  struct RadioSt {
    RadioObjSt (*radio)(DartObj value, DartObj* groupValue, ValueChangedForTOptFFI* onChanged, int* toggleable, DartObj* activeColor, DartObj* focusColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* visualDensity, int* autofocus, int* enabled, DartObj* side);
    RadioObjSt (*adaptive)(DartObj value, DartObj* groupValue, ValueChangedForTOptFFI* onChanged, int* toggleable, DartObj* activeColor, DartObj* focusColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* visualDensity, int* autofocus, int* useCupertinoCheckmarkStyle, int* enabled, DartObj* side);
  } radio;

  struct RadioListTileSt {
    RadioListTileObjSt (*radioListTile)(DartObj value, DartObj* groupValue, ValueChangedForTOptFFI* onChanged, int* toggleable, DartObj* activeColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* title, DartObj* subtitle, int* isThreeLine, int* dense, DartObj* secondary, int* selected, int* controlAffinity, int* autofocus, DartObj* contentPadding, DartObj* shape, DartObj* tileColor, DartObj* selectedTileColor, DartObj* visualDensity, ValueChangedForBoolFFI* onFocusChange, int* enableFeedback, double* radioScaleFactor, int* titleAlignment, int* enabled, int* internalAddSemanticForOnTap, DartObj* radioSide);
    RadioListTileObjSt (*adaptive)(DartObj value, DartObj* groupValue, ValueChangedForTOptFFI* onChanged, int* toggleable, DartObj* activeColor, DartObj* hoverColor, double* splashRadius, int* materialTapTargetSize, DartObj* title, DartObj* subtitle, int* isThreeLine, int* dense, DartObj* secondary, int* selected, int* controlAffinity, int* autofocus, DartObj* contentPadding, DartObj* shape, DartObj* tileColor, DartObj* selectedTileColor, DartObj* visualDensity, ValueChangedForBoolFFI* onFocusChange, int* enableFeedback, double* radioScaleFactor, int* enabled, int* useCupertinoCheckmarkStyle, int* titleAlignment, int* internalAddSemanticForOnTap, DartObj* radioSide);
  } radioListTile;

  struct ExpansionTileSt {
    ExpansionTileObjSt (*expansionTile)(DartObj* leading, DartObj title, DartObj* subtitle, ValueChangedForBoolFFI* onExpansionChanged, ArrayC* children, DartObj* trailing, int* showTrailingIcon, int* initiallyExpanded, int* maintainState, DartObj* tilePadding, int* expandedCrossAxisAlignment, DartObj* expandedAlignment, DartObj* childrenPadding, DartObj* backgroundColor, DartObj* collapsedBackgroundColor, DartObj* textColor, DartObj* collapsedTextColor, DartObj* iconColor, DartObj* collapsedIconColor, DartObj* shape, DartObj* collapsedShape, int* clipBehavior, int* controlAffinity, int* dense, DartObj* visualDensity, double* minTileHeight, int* enableFeedback, int* enabled, int* internalAddSemanticForOnTap);
  } expansionTile;

  struct ExpansionPanelSt {
    DartObj (*expansionPanel)(ExpansionPanelHeaderBuilderFFI headerBuilder, DartObj body, int* isExpanded, int* canTapOnHeader, DartObj* backgroundColor, DartObj* splashColor, DartObj* highlightColor);
  } expansionPanel;

  struct ExpansionPanelListSt {
    ExpansionPanelListObjSt (*expansionPanelList)(ArrayC* children, ExpansionPanelCallbackFFI* expansionCallback, DartObj* animationDuration, DartObj* dividerColor, double* elevation, DartObj* expandIconColor, double* materialGapSize);
    ExpansionPanelListObjSt (*radio)(ArrayC* children, ExpansionPanelCallbackFFI* expansionCallback, DartObj* animationDuration, DartObj* initialOpenPanelValue, DartObj* dividerColor, double* elevation, DartObj* expandIconColor, double* materialGapSize);
  } expansionPanelList;

  struct ExpansionPanelRadioSt {
    DartObj (*expansionPanelRadio)(DartObj value, ExpansionPanelHeaderBuilderFFI headerBuilder, DartObj body, int* canTapOnHeader, DartObj* backgroundColor, DartObj* splashColor, DartObj* highlightColor);
  } expansionPanelRadio;

  struct NavigationRailSt {
    NavigationRailObjSt (*navigationRail)(DartObj* backgroundColor, int* extended, DartObj* leading, DartObj* trailing, ArrayC destinations, int selectedIndex, ValueChangedForIntFFI* onDestinationSelected, double* elevation, double* groupAlignment, int* labelType, DartObj* unselectedLabelTextStyle, DartObj* selectedLabelTextStyle, double* minWidth, double* minExtendedWidth, int* useIndicator, DartObj* indicatorColor, DartObj* indicatorShape, int* leadingAtTop, int* trailingAtBottom, int* scrollable);
    DartObj (*extendedAnimation)(DartObj context);
  } navigationRail;

  struct NavigationRailDestinationSt {
    DartObj (*navigationRailDestination)(DartObj icon, DartObj* selectedIcon, DartObj* indicatorColor, DartObj* indicatorShape, DartObj label, DartObj* padding, int* disabled);
  } navigationRailDestination;

  struct NavigationBarSt {
    NavigationBarObjSt (*navigationBar)(DartObj* animationDuration, int* selectedIndex, ArrayC destinations, ValueChangedForIntFFI* onDestinationSelected, DartObj* backgroundColor, double* elevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* indicatorColor, DartObj* indicatorShape, double* height, int* labelBehavior, DartObj* labelPadding, int* maintainBottomViewPadding);
  } navigationBar;

  struct NavigationDestinationSt {
    NavigationDestinationObjSt (*navigationDestination)(DartObj icon, DartObj* selectedIcon, char* label, char* tooltip, int* enabled);
  } navigationDestination;

  struct NavigationDrawerSt {
    NavigationDrawerObjSt (*navigationDrawer)(ArrayC children, DartObj* header, DartObj* footer, DartObj* backgroundColor, DartObj* shadowColor, DartObj* surfaceTintColor, double* elevation, DartObj* indicatorColor, DartObj* indicatorShape, ValueChangedForIntFFI* onDestinationSelected, int* selectedIndex, DartObj* tilePadding);
  } navigationDrawer;

  struct NavigationDrawerDestinationSt {
    NavigationDrawerDestinationObjSt (*navigationDrawerDestination)(DartObj* backgroundColor, DartObj icon, DartObj* selectedIcon, DartObj label, int* enabled);
  } navigationDrawerDestination;

  struct PopupMenuButtonSt {
    PopupMenuButtonObjSt (*popupMenuButton)(PopupMenuItemBuilderForTFFI itemBuilder, DartObj* initialValue, VoidCallbackFFI* onOpened, PopupMenuItemSelectedForTFFI* onSelected, PopupMenuCanceledFFI* onCanceled, char* tooltip, double* elevation, DartObj* shadowColor, DartObj* surfaceTintColor, DartObj* padding, DartObj* menuPadding, DartObj* child, DartObj* borderRadius, double* splashRadius, DartObj* icon, double* iconSize, DartObj* offset, int* enabled, DartObj* shape, DartObj* color, DartObj* iconColor, int* enableFeedback, DartObj* constraints, int* position, int* clipBehavior, int* useRootNavigator, int* requestFocus);
  } popupMenuButton;

  struct PopupMenuItemSt {
    PopupMenuItemObjSt (*popupMenuItem)(DartObj* value, VoidCallbackFFI* onTap, int* enabled, double* height, DartObj* padding, DartObj* textStyle, DartObj child);
  } popupMenuItem;

  struct PopupMenuDividerSt {
    PopupMenuDividerObjSt (*popupMenuDivider)(double* height, double* thickness, double* indent, double* endIndent, DartObj* radius, DartObj* color);
  } popupMenuDivider;

  struct CheckedPopupMenuItemSt {
    CheckedPopupMenuItemObjSt (*checkedPopupMenuItem)(DartObj* value, int* checked, int* enabled, DartObj* padding, double* height, DartObj* child, VoidCallbackFFI* onTap);
  } checkedPopupMenuItem;

  struct CircleAvatarSt {
    CircleAvatarObjSt (*circleAvatar)(DartObj* child, DartObj* backgroundColor, DartObj* foregroundColor, double* radius, double* minRadius, double* maxRadius);
  } circleAvatar;

  struct ScrollbarSt {
    ScrollbarObjSt (*scrollbar)(DartObj child, int* thumbVisibility, int* trackVisibility, double* thickness, DartObj* radius, int* interactive, int* scrollbarOrientation);
  } scrollbar;

  struct MenuBarSt {
    MenuBarObjSt (*menuBar)(int* clipBehavior, ArrayC children);
  } menuBar;

  struct MenuAnchorSt {
    MenuAnchorObjSt (*menuAnchor)(DartObj* alignmentOffset, int* clipBehavior, int* anchorTapClosesMenu, int* consumeOutsideTap, VoidCallbackFFI* onOpen, VoidCallbackFFI* onClose, int* crossAxisUnconstrained, int* useRootOverlay, ArrayC menuChildren, DartObj* child);
  } menuAnchor;

  struct SubmenuButtonSt {
    SubmenuButtonObjSt (*submenuButton)(ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, VoidCallbackFFI* onOpen, VoidCallbackFFI* onClose, DartObj* alignmentOffset, int* clipBehavior, DartObj* leadingIcon, DartObj* trailingIcon, int* useRootOverlay, ArrayC menuChildren, DartObj child);
  } submenuButton;

  struct MenuItemButtonSt {
    MenuItemButtonObjSt (*menuItemButton)(VoidCallbackFFI* onPressed, ValueChangedForBoolFFI* onHover, int* requestFocusOnHover, ValueChangedForBoolFFI* onFocusChange, int* autofocus, char* semanticsLabel, int* clipBehavior, DartObj* leadingIcon, DartObj* trailingIcon, int* closeOnActivate, int* overflowAxis, DartObj* child);
  } menuItemButton;

  struct CheckboxMenuButtonSt {
    CheckboxMenuButtonObjSt (*checkboxMenuButton)(int value, int* tristate, int* isError, ValueChangedForBoolOptFFI onChanged, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* clipBehavior, DartObj* trailingIcon, int* closeOnActivate, DartObj child);
  } checkboxMenuButton;

  struct RadioMenuButtonSt {
    RadioMenuButtonObjSt (*radioMenuButton)(DartObj value, DartObj groupValue, ValueChangedForTOptFFI onChanged, int* toggleable, ValueChangedForBoolFFI* onHover, ValueChangedForBoolFFI* onFocusChange, int* clipBehavior, DartObj* trailingIcon, int* closeOnActivate, DartObj child);
  } radioMenuButton;

  struct DatePickerDialogSt {
    DatePickerDialogObjSt (*datePickerDialog)(DartObj* initialDate, DartObj firstDate, DartObj lastDate, DartObj* currentDate, int* initialEntryMode, SelectableDayPredicateFFI* selectableDayPredicate, char* cancelText, char* confirmText, char* helpText, int* initialCalendarMode, char* errorFormatText, char* errorInvalidText, char* fieldHintText, char* fieldLabelText, char* restorationId, ValueChangedForDatePickerEntryModeFFI* onDatePickerModeChange, DartObj* switchToInputEntryModeIcon, DartObj* switchToCalendarEntryModeIcon, DartObj* insetPadding);
  } datePickerDialog;

  struct CalendarDatePickerSt {
    CalendarDatePickerObjSt (*calendarDatePicker)(DartObj initialDate, DartObj firstDate, DartObj lastDate, DartObj* currentDate, ValueChangedForDateTimeFFI onDateChanged, ValueChangedForDateTimeFFI* onDisplayedMonthChanged, int* initialCalendarMode, SelectableDayPredicateFFI* selectableDayPredicate);
  } calendarDatePicker;

  struct TimePickerDialogSt {
    TimePickerDialogObjSt (*timePickerDialog)(DartObj initialTime, char* cancelText, char* confirmText, char* helpText, char* errorInvalidText, char* hourLabelText, char* minuteLabelText, char* restorationId, int* initialEntryMode, int* orientation, EntryModeChangeCallbackFFI* onEntryModeChanged, DartObj* switchToInputEntryModeIcon, DartObj* switchToTimerEntryModeIcon);
  } timePickerDialog;

  struct DateRangePickerDialogSt {
    DateRangePickerDialogObjSt (*dateRangePickerDialog)(DartObj firstDate, DartObj lastDate, DartObj* currentDate, int* initialEntryMode, char* helpText, char* cancelText, char* confirmText, char* saveText, char* errorInvalidRangeText, char* errorFormatText, char* errorInvalidText, char* fieldStartHintText, char* fieldEndHintText, char* fieldStartLabelText, char* fieldEndLabelText, char* restorationId, DartObj* switchToInputEntryModeIcon, DartObj* switchToCalendarEntryModeIcon, SelectableDayForRangePredicateFFI* selectableDayPredicate);
  } dateRangePickerDialog;

  struct YearPickerSt {
    YearPickerObjSt (*yearPicker)(DartObj* currentDate, DartObj firstDate, DartObj lastDate, DartObj* initialDate, DartObj selectedDate, ValueChangedForDateTimeFFI onChanged, int* dragStartBehavior);
  } yearPicker;

  struct InputDatePickerFormFieldSt {
    InputDatePickerFormFieldObjSt (*inputDatePickerFormField)(DartObj* initialDate, DartObj firstDate, DartObj lastDate, ValueChangedForDateTimeFFI* onDateSubmitted, ValueChangedForDateTimeFFI* onDateSaved, SelectableDayPredicateFFI* selectableDayPredicate, char* errorFormatText, char* errorInvalidText, char* fieldHintText, char* fieldLabelText, int* autofocus, int* acceptEmptyDate);
  } inputDatePickerFormField;

  struct SearchBarSt {
    SearchBarObjSt (*searchBar)(char* hintText, DartObj* leading, GestureTapCallbackFFI* onTap, ValueChangedForStringFFI* onChanged, ValueChangedForStringFFI* onSubmitted, DartObj* constraints, int* textCapitalization, int* enabled, int* autoFocus, int* textInputAction, DartObj* scrollPadding);
  } searchBar;

  struct CupertinoAppSt {
    CupertinoAppObjSt (*cupertinoApp)(DartObj* home, char* initialRoute, TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
    CupertinoAppObjSt (*router)(TransitionBuilderFFI* builder, char* title, GenerateAppTitleFFI* onGenerateTitle, DartObj* color, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
  } cupertinoApp;

  struct CupertinoPageScaffoldSt {
    CupertinoPageScaffoldObjSt (*cupertinoPageScaffold)(DartObj* navigationBar, DartObj* backgroundColor, int* resizeToAvoidBottomInset, DartObj child);
  } cupertinoPageScaffold;

  struct CupertinoNavigationBarSt {
    CupertinoNavigationBarObjSt (*cupertinoNavigationBar)(DartObj* leading, int* automaticallyImplyLeading, int* automaticallyImplyMiddle, char* previousPageTitle, DartObj* middle, DartObj* trailing, DartObj* border, DartObj* backgroundColor, int* automaticBackgroundVisibility, int* enableBackgroundFilterBlur, int* brightness, int* transitionBetweenRoutes, DartObj* bottom);
    CupertinoNavigationBarObjSt (*large)(DartObj* largeTitle, DartObj* leading, int* automaticallyImplyLeading, int* automaticallyImplyTitle, char* previousPageTitle, DartObj* trailing, DartObj* border, DartObj* backgroundColor, int* automaticBackgroundVisibility, int* enableBackgroundFilterBlur, int* brightness, int* transitionBetweenRoutes, DartObj* bottom);
  } cupertinoNavigationBar;

  struct CupertinoSliverNavigationBarSt {
    CupertinoSliverNavigationBarObjSt (*cupertinoSliverNavigationBar)(DartObj* largeTitle, DartObj* leading, int* automaticallyImplyLeading, int* automaticallyImplyTitle, int* alwaysShowMiddle, char* previousPageTitle, DartObj* middle, DartObj* trailing, DartObj* border, DartObj* backgroundColor, int* automaticBackgroundVisibility, int* enableBackgroundFilterBlur, int* brightness, int* transitionBetweenRoutes, int* stretch, DartObj* bottom, int* bottomMode);
    CupertinoSliverNavigationBarObjSt (*search)(DartObj searchField, DartObj* largeTitle, DartObj* leading, int* automaticallyImplyLeading, int* automaticallyImplyTitle, int* alwaysShowMiddle, char* previousPageTitle, DartObj* middle, DartObj* trailing, DartObj* border, DartObj* backgroundColor, int* automaticBackgroundVisibility, int* enableBackgroundFilterBlur, int* brightness, int* transitionBetweenRoutes, int* stretch, int* bottomMode, ValueChangedForBoolFFI* onSearchableBottomTap);
  } cupertinoSliverNavigationBar;

  struct CupertinoTabViewSt {
    CupertinoTabViewObjSt (*cupertinoTabView)(WidgetBuilderFFI* builder, char* defaultTitle, char* restorationScopeId);
  } cupertinoTabView;

  struct CupertinoButtonSt {
    CupertinoButtonObjSt (*cupertinoButton)(DartObj child, int* sizeStyle, DartObj* padding, DartObj* color, DartObj* foregroundColor, DartObj* disabledColor, double* minSize, double* pressedOpacity, DartObj* borderRadius, DartObj* alignment, DartObj* focusColor, ValueChangedForBoolFFI* onFocusChange, int* autofocus, VoidCallbackFFI* onLongPress, VoidCallbackFFI onPressed);
    CupertinoButtonObjSt (*tinted)(DartObj child, int* sizeStyle, DartObj* padding, DartObj* color, DartObj* foregroundColor, DartObj* disabledColor, double* minSize, double* pressedOpacity, DartObj* borderRadius, DartObj* alignment, DartObj* focusColor, ValueChangedForBoolFFI* onFocusChange, int* autofocus, VoidCallbackFFI* onLongPress, VoidCallbackFFI onPressed);
    CupertinoButtonObjSt (*filled)(DartObj child, int* sizeStyle, DartObj* padding, DartObj* color, DartObj* disabledColor, DartObj* foregroundColor, double* minSize, double* pressedOpacity, DartObj* borderRadius, DartObj* alignment, DartObj* focusColor, ValueChangedForBoolFFI* onFocusChange, int* autofocus, VoidCallbackFFI* onLongPress, VoidCallbackFFI onPressed);
    double (*tapMoveSlop)(void);
  } cupertinoButton;

  struct CupertinoSwitchSt {
    CupertinoSwitchObjSt (*cupertinoSwitch)(int value, ValueChangedForBoolFFI onChanged, DartObj* activeColor, DartObj* trackColor, DartObj* activeTrackColor, DartObj* inactiveTrackColor, DartObj* thumbColor, DartObj* inactiveThumbColor, int* applyTheme, DartObj* focusColor, DartObj* onLabelColor, DartObj* offLabelColor, ValueChangedForBoolFFI* onFocusChange, int* autofocus, int* dragStartBehavior);
  } cupertinoSwitch;

  struct CupertinoSliderSt {
    CupertinoSliderObjSt (*cupertinoSlider)(double value, ValueChangedForDoubleFFI onChanged, ValueChangedForDoubleFFI* onChangeStart, ValueChangedForDoubleFFI* onChangeEnd, double* min, double* max, int* divisions, DartObj* activeColor, DartObj* thumbColor);
  } cupertinoSlider;

  struct CupertinoSearchTextFieldSt {
    CupertinoSearchTextFieldObjSt (*cupertinoSearchTextField)(ValueChangedForStringFFI* onChanged, ValueChangedForStringFFI* onSubmitted, DartObj* style, char* placeholder, DartObj* placeholderStyle, DartObj* decoration, DartObj* backgroundColor, DartObj* borderRadius, DartObj* padding, DartObj* itemColor, double* itemSize, DartObj* prefixInsets, DartObj* prefixIcon, DartObj* suffixInsets, DartObj* suffixIcon, int* suffixMode, VoidCallbackFFI* onSuffixTap, char* restorationId, int* smartQuotesType, int* smartDashesType, int* enableIMEPersonalizedLearning, int* autofocus, VoidCallbackFFI* onTap, int* autocorrect, int* enabled, double* cursorWidth, double* cursorHeight, DartObj* cursorRadius, int* cursorOpacityAnimates, DartObj* cursorColor);
  } cupertinoSearchTextField;

  struct CupertinoActivityIndicatorSt {
    CupertinoActivityIndicatorObjSt (*cupertinoActivityIndicator)(DartObj* color, int* animating, double* radius);
    CupertinoActivityIndicatorObjSt (*partiallyRevealed)(DartObj* color, double* radius, double* progress);
  } cupertinoActivityIndicator;

  struct CupertinoListSectionSt {
    CupertinoListSectionObjSt (*cupertinoListSection)(ArrayC* children, DartObj* header, DartObj* footer, DartObj* margin, DartObj* backgroundColor, DartObj* decoration, int* clipBehavior, double* dividerMargin, double* additionalDividerMargin, double* topMargin, int* hasLeading, DartObj* separatorColor);
    CupertinoListSectionObjSt (*insetGrouped)(ArrayC* children, DartObj* header, DartObj* footer, DartObj* margin, DartObj* backgroundColor, DartObj* decoration, int* clipBehavior, double* dividerMargin, double* additionalDividerMargin, double* topMargin, int* hasLeading, DartObj* separatorColor);
  } cupertinoListSection;

  struct CupertinoListTileSt {
    CupertinoListTileObjSt (*cupertinoListTile)(DartObj title, DartObj* subtitle, DartObj* additionalInfo, DartObj* leading, DartObj* trailing, DartObj* backgroundColor, DartObj* backgroundColorActivated, DartObj* padding, double* leadingSize, double* leadingToTitle);
    CupertinoListTileObjSt (*notched)(DartObj title, DartObj* subtitle, DartObj* additionalInfo, DartObj* leading, DartObj* trailing, DartObj* backgroundColor, DartObj* backgroundColorActivated, DartObj* padding, double* leadingSize, double* leadingToTitle);
  } cupertinoListTile;

  struct CupertinoListTileChevronSt {
    CupertinoListTileChevronObjSt (*cupertinoListTileChevron)(void);
  } cupertinoListTileChevron;

  struct CupertinoFormSectionSt {
    CupertinoFormSectionObjSt (*cupertinoFormSection)(ArrayC children, DartObj* header, DartObj* footer, DartObj* margin, DartObj* backgroundColor, DartObj* decoration, int* clipBehavior);
    CupertinoFormSectionObjSt (*insetGrouped)(ArrayC children, DartObj* header, DartObj* footer, DartObj* margin, DartObj* backgroundColor, DartObj* decoration, int* clipBehavior);
  } cupertinoFormSection;

  struct CupertinoFormRowSt {
    CupertinoFormRowObjSt (*cupertinoFormRow)(DartObj child, DartObj* prefix, DartObj* padding, DartObj* helper, DartObj* error);
  } cupertinoFormRow;

  struct CupertinoPickerSt {
    CupertinoPickerObjSt (*cupertinoPicker)(double* diameterRatio, DartObj* backgroundColor, double* offAxisFraction, int* useMagnifier, double* magnification, double* squeeze, int* changeReportingBehavior, double itemExtent, ValueChangedForIntFFI onSelectedItemChanged, ArrayC children, DartObj* selectionOverlay, int* looping);
    CupertinoPickerObjSt (*builder)(double* diameterRatio, DartObj* backgroundColor, double* offAxisFraction, int* useMagnifier, double* magnification, double* squeeze, int* changeReportingBehavior, double itemExtent, ValueChangedForIntFFI onSelectedItemChanged, NullableIndexedWidgetBuilderFFI itemBuilder, int* childCount, DartObj* selectionOverlay);
  } cupertinoPicker;

  struct CupertinoAlertDialogSt {
    CupertinoAlertDialogObjSt (*cupertinoAlertDialog)(DartObj* title, DartObj* content, ArrayC* actions, DartObj* insetAnimationDuration, DartObj* insetAnimationCurve);
  } cupertinoAlertDialog;

  struct CupertinoActionSheetSt {
    CupertinoActionSheetObjSt (*cupertinoActionSheet)(DartObj* title, DartObj* message, ArrayC* actions, DartObj* cancelButton);
  } cupertinoActionSheet;

  struct CupertinoDialogActionSt {
    CupertinoDialogActionObjSt (*cupertinoDialogAction)(VoidCallbackFFI* onPressed, int* isDefaultAction, int* isDestructiveAction, DartObj* textStyle, DartObj child);
  } cupertinoDialogAction;

  struct CupertinoActionSheetActionSt {
    CupertinoActionSheetActionObjSt (*cupertinoActionSheetAction)(VoidCallbackFFI onPressed, int* isDefaultAction, int* isDestructiveAction, DartObj child);
  } cupertinoActionSheetAction;

  struct CupertinoTextFieldSt {
    CupertinoTextFieldObjSt (*cupertinoTextField)(DartObj* groupId, DartObj* decoration, DartObj* padding, char* placeholder, DartObj* placeholderStyle, DartObj* prefix, int* prefixMode, DartObj* suffix, int* suffixMode, int* crossAxisAlignment, int* clearButtonMode, char* clearButtonSemanticLabel, int* textInputAction, int* textCapitalization, DartObj* style, int* textAlign, int* textDirection, int* readOnly, int* showCursor, int* autofocus, char* obscuringCharacter, int* obscureText, int* autocorrect, int* smartDashesType, int* smartQuotesType, int* enableSuggestions, int* maxLines, int* minLines, int* expands, int* maxLength, int* maxLengthEnforcement, ValueChangedForStringFFI* onChanged, VoidCallbackFFI* onEditingComplete, ValueChangedForStringFFI* onSubmitted, int* enabled, double* cursorWidth, double* cursorHeight, DartObj* cursorRadius, int* cursorOpacityAnimates, DartObj* cursorColor, int* selectionHeightStyle, int* selectionWidthStyle, int* keyboardAppearance, DartObj* scrollPadding, int* dragStartBehavior, int* enableInteractiveSelection, int* selectAllOnFocus, GestureTapCallbackFFI* onTap, int* clipBehavior, char* restorationId, int* scribbleEnabled, int* stylusHandwritingEnabled, int* enableIMEPersonalizedLearning);
    CupertinoTextFieldObjSt (*borderless)(DartObj* groupId, DartObj* decoration, DartObj* padding, char* placeholder, DartObj* placeholderStyle, DartObj* prefix, int* prefixMode, DartObj* suffix, int* suffixMode, int* crossAxisAlignment, int* clearButtonMode, char* clearButtonSemanticLabel, int* textInputAction, int* textCapitalization, DartObj* style, int* textAlign, int* textDirection, int* readOnly, int* showCursor, int* autofocus, char* obscuringCharacter, int* obscureText, int* autocorrect, int* smartDashesType, int* smartQuotesType, int* enableSuggestions, int* maxLines, int* minLines, int* expands, int* maxLength, int* maxLengthEnforcement, ValueChangedForStringFFI* onChanged, VoidCallbackFFI* onEditingComplete, ValueChangedForStringFFI* onSubmitted, int* enabled, double* cursorWidth, double* cursorHeight, DartObj* cursorRadius, int* cursorOpacityAnimates, DartObj* cursorColor, int* selectionHeightStyle, int* selectionWidthStyle, int* keyboardAppearance, DartObj* scrollPadding, int* dragStartBehavior, int* enableInteractiveSelection, int* selectAllOnFocus, GestureTapCallbackFFI* onTap, int* clipBehavior, char* restorationId, int* scribbleEnabled, int* stylusHandwritingEnabled, int* enableIMEPersonalizedLearning);
  } cupertinoTextField;

  struct CupertinoCheckboxSt {
    CupertinoCheckboxObjSt (*cupertinoCheckbox)(int value, int* tristate, ValueChangedForBoolOptFFI onChanged, DartObj* activeColor, DartObj* inactiveColor, DartObj* checkColor, DartObj* focusColor, int* autofocus, DartObj* side, DartObj* shape, char* semanticLabel);
  } cupertinoCheckbox;

  struct CupertinoExpansionTileSt {
    CupertinoExpansionTileObjSt (*cupertinoExpansionTile)(DartObj title, DartObj child, int* transitionMode);
  } cupertinoExpansionTile;

  struct CupertinoTimerPickerSt {
    CupertinoTimerPickerObjSt (*cupertinoTimerPicker)(int* mode, DartObj* initialTimerDuration, int* minuteInterval, int* secondInterval, DartObj* alignment, DartObj* backgroundColor, double* itemExtent, ValueChangedForDurationFFI onTimerDurationChanged, int* changeReportingBehavior, SelectionOverlayBuilderFFI* selectionOverlayBuilder);
  } cupertinoTimerPicker;

  struct CupertinoNavigationBarBackButtonSt {
    CupertinoNavigationBarBackButtonObjSt (*cupertinoNavigationBarBackButton)(DartObj* color, char* previousPageTitle, VoidCallbackFFI* onPressed);
  } cupertinoNavigationBarBackButton;

  struct CupertinoTabBarSt {
    CupertinoTabBarObjSt (*cupertinoTabBar)(ArrayC items, ValueChangedForIntFFI* onTap, int* currentIndex, DartObj* backgroundColor, DartObj* activeColor, DartObj* inactiveColor, double* iconSize, double* height, DartObj* border);
  } cupertinoTabBar;

  struct BottomNavigationBarItemSt {
    DartObj (*bottomNavigationBarItem)(DartObj icon, char* label, DartObj* activeIcon, DartObj* backgroundColor, char* tooltip);
  } bottomNavigationBarItem;

  struct CupertinoTabScaffoldSt {
    CupertinoTabScaffoldObjSt (*cupertinoTabScaffold)(DartObj tabBar, IndexedWidgetBuilderFFI tabBuilder, DartObj* backgroundColor, int* resizeToAvoidBottomInset, char* restorationId);
  } cupertinoTabScaffold;

  struct CupertinoContextMenuSt {
    CupertinoContextMenuObjSt (*cupertinoContextMenu)(ArrayC actions, DartObj child, int* enableHapticFeedback);
    CupertinoContextMenuObjSt (*builder)(ArrayC actions, CupertinoContextMenuBuilderFFI builder, int* enableHapticFeedback);
  } cupertinoContextMenu;

  struct CupertinoContextMenuActionSt {
    CupertinoContextMenuActionObjSt (*cupertinoContextMenuAction)(DartObj child, int* isDefaultAction, int* isDestructiveAction, VoidCallbackFFI* onPressed, DartObj* trailingIcon);
  } cupertinoContextMenuAction;

  struct SubStateSt {
    SubStateObjSt (*subState)(VoidCallbackFFI initStateFn, VoidCallbackDartObjFFI didUpdateWidgetFn, VoidCallbackFFI reassembleFn, VoidCallbackFFI deactivateFn, VoidCallbackFFI activateFn, VoidCallbackFFI disposeFn, DartObjCallbackDartObjFFI buildFn, VoidCallbackFFI didChangeDependenciesFn);
  } subState;

  struct SubStatefulWidgetSt {
    SubStatefulWidgetObjSt (*subStatefulWidget)(DartObjCallbackFFI createStateFn);
  } subStatefulWidget;

  struct SubStatelessWidgetSt {
    SubStatelessWidgetObjSt (*subStatelessWidget)(DartObjCallbackDartObjFFI buildFn);
  } subStatelessWidget;

  struct SubAnimatedStateSt {
    SubAnimatedStateObjSt (*subAnimatedState)(VoidCallbackFFI initStateFn, VoidCallbackDartObjFFI didUpdateWidgetFn, VoidCallbackFFI reassembleFn, VoidCallbackFFI deactivateFn, VoidCallbackFFI activateFn, VoidCallbackFFI disposeFn, DartObjCallbackDartObjFFI buildFn, VoidCallbackFFI didChangeDependenciesFn);
    DartObj (*animationController)(DartObj self, DartObj duration);
  } subAnimatedState;

} WidgetFactories;
