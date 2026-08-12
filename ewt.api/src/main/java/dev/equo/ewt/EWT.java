package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
public class EWT {
  public static Future showDialog(BuildContextI context, Function<BuildContext, Widget> builder) {
    int id = WidgetConstructors.instance.dialogShowDialog(context.build(),
      builder,
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<T?>");
    System.out.println("New Future<T?> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static Future showDatePicker(BuildContextI context, DateTimeI firstDate, DateTimeI lastDate) {
    int id = WidgetConstructors.instance.date_pickerShowDatePicker(context.build(),
      Optional.empty(),
      firstDate.build(),
      lastDate.build(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<DateTime?>");
    System.out.println("New Future<DateTime?> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static Future showTimePicker(BuildContextI context, TimeOfDayI initialTime) {
    int id = WidgetConstructors.instance.time_pickerShowTimePicker(context.build(),
      initialTime.build(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<TimeOfDay?>");
    System.out.println("New Future<TimeOfDay?> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static Future showDateRangePicker(BuildContextI context, DateTimeI firstDate, DateTimeI lastDate) {
    int id = WidgetConstructors.instance.date_pickerShowDateRangePicker(context.build(),
      firstDate.build(),
      lastDate.build(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<DateTimeRange<DateTime>?>");
    System.out.println("New Future<DateTimeRange<DateTime>?> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static TextStyleTextStyleBuilder TextStyle() {
    return TextStyleTextStyleBuilder.textStyleTextStyle();
  }

  public static ColorColorBuilder Color(int value) {
    return ColorColorBuilder.colorColor(value);
  }
  public static ColorFromBuilder Color_from(double alpha, double red, double green, double blue) {
    return ColorFromBuilder.colorFrom(alpha, red, green, blue);
  }
  public static ColorFromARGBBuilder Color_fromARGB(int a, int r, int g, int b) {
    return ColorFromARGBBuilder.colorFromARGB(a, r, g, b);
  }
  public static ColorFromRGBOBuilder Color_fromRGBO(int r, int g, int b, double opacity) {
    return ColorFromRGBOBuilder.colorFromRGBO(r, g, b, opacity);
  }

  public static OffsetOffsetBuilder Offset(double dx, double dy) {
    return OffsetOffsetBuilder.offsetOffset(dx, dy);
  }
  public static OffsetFromDirectionBuilder Offset_fromDirection(double direction) {
    return OffsetFromDirectionBuilder.offsetFromDirection(direction);
  }

  public static DateTimeDateTimeBuilder DateTime(int year) {
    return DateTimeDateTimeBuilder.dateTimeDateTime(year);
  }
  public static DateTimeUtcBuilder DateTime_utc(int year) {
    return DateTimeUtcBuilder.dateTimeUtc(year);
  }
  public static DateTimeNowBuilder DateTime_now() {
    return DateTimeNowBuilder.dateTimeNow();
  }
  public static DateTimeTimestampBuilder DateTime_timestamp() {
    return DateTimeTimestampBuilder.dateTimeTimestamp();
  }
  public static DateTimeFromMillisecondsSinceEpochBuilder DateTime_fromMillisecondsSinceEpoch(int millisecondsSinceEpoch) {
    return DateTimeFromMillisecondsSinceEpochBuilder.dateTimeFromMillisecondsSinceEpoch(millisecondsSinceEpoch);
  }
  public static DateTimeFromMicrosecondsSinceEpochBuilder DateTime_fromMicrosecondsSinceEpoch(int microsecondsSinceEpoch) {
    return DateTimeFromMicrosecondsSinceEpochBuilder.dateTimeFromMicrosecondsSinceEpoch(microsecondsSinceEpoch);
  }

  public static IconIconBuilder Icon(IconDataI icon) {
    return IconIconBuilder.iconIcon(icon);
  }

  public static TimeOfDayTimeOfDayBuilder TimeOfDay(int hour, int minute) {
    return TimeOfDayTimeOfDayBuilder.timeOfDayTimeOfDay(hour, minute);
  }
  public static TimeOfDayFromDateTimeBuilder TimeOfDay_fromDateTime(DateTimeI time) {
    return TimeOfDayFromDateTimeBuilder.timeOfDayFromDateTime(time);
  }
  public static TimeOfDayNowBuilder TimeOfDay_now() {
    return TimeOfDayNowBuilder.timeOfDayNow();
  }

  public static ShadowShadowBuilder Shadow() {
    return ShadowShadowBuilder.shadowShadow();
  }

  public static TextDecorationCombineBuilder TextDecoration_combine(List<TextDecorationI> decorations) {
    return TextDecorationCombineBuilder.textDecorationCombine(decorations);
  }

  public static IconDataIconDataBuilder IconData(int codePoint) {
    return IconDataIconDataBuilder.iconDataIconData(codePoint);
  }

  public static TextTextBuilder Text(String data) {
    return TextTextBuilder.textText(data);
  }
  public static TextRichBuilder Text_rich(InlineSpanI textSpan) {
    return TextRichBuilder.textRich(textSpan);
  }

  public static TextSpanTextSpanBuilder TextSpan() {
    return TextSpanTextSpanBuilder.textSpanTextSpan();
  }

  public static RichTextRichTextBuilder RichText(InlineSpanI text) {
    return RichTextRichTextBuilder.richTextRichText(text);
  }

  public static CenterCenterBuilder Center() {
    return CenterCenterBuilder.centerCenter();
  }

  public static AlignAlignBuilder Align() {
    return AlignAlignBuilder.alignAlign();
  }

  public static ColumnColumnBuilder Column() {
    return ColumnColumnBuilder.columnColumn();
  }

  public static FlexFlexBuilder Flex(Axis direction) {
    return FlexFlexBuilder.flexFlex(direction);
  }

  public static RowRowBuilder Row() {
    return RowRowBuilder.rowRow();
  }

  public static TransformRotateBuilder Transform_rotate(double angle) {
    return TransformRotateBuilder.transformRotate(angle);
  }
  public static TransformTranslateBuilder Transform_translate(OffsetI offset) {
    return TransformTranslateBuilder.transformTranslate(offset);
  }
  public static TransformScaleBuilder Transform_scale() {
    return TransformScaleBuilder.transformScale();
  }
  public static TransformFlipBuilder Transform_flip() {
    return TransformFlipBuilder.transformFlip();
  }

  public static OpacityOpacityBuilder Opacity(double opacity) {
    return OpacityOpacityBuilder.opacityOpacity(opacity);
  }

  public static StackStackBuilder Stack() {
    return StackStackBuilder.stackStack();
  }

  public static BoxConstraintsBoxConstraintsBuilder BoxConstraints() {
    return BoxConstraintsBoxConstraintsBuilder.boxConstraintsBoxConstraints();
  }
  public static BoxConstraintsTightForBuilder BoxConstraints_tightFor() {
    return BoxConstraintsTightForBuilder.boxConstraintsTightFor();
  }
  public static BoxConstraintsTightForFiniteBuilder BoxConstraints_tightForFinite() {
    return BoxConstraintsTightForFiniteBuilder.boxConstraintsTightForFinite();
  }
  public static BoxConstraintsExpandBuilder BoxConstraints_expand() {
    return BoxConstraintsExpandBuilder.boxConstraintsExpand();
  }

  public static ContainerContainerBuilder Container() {
    return ContainerContainerBuilder.containerContainer();
  }

  public static StackParentDataStackParentDataBuilder StackParentData() {
    return StackParentDataStackParentDataBuilder.stackParentDataStackParentData();
  }

  public static BoxParentDataBoxParentDataBuilder BoxParentData() {
    return BoxParentDataBoxParentDataBuilder.boxParentDataBoxParentData();
  }

  public static ParentDataParentDataBuilder ParentData() {
    return ParentDataParentDataBuilder.parentDataParentData();
  }

  public static FlexParentDataFlexParentDataBuilder FlexParentData() {
    return FlexParentDataFlexParentDataBuilder.flexParentDataFlexParentData();
  }

  public static PositionedPositionedBuilder Positioned() {
    return PositionedPositionedBuilder.positionedPositioned();
  }
  public static PositionedFillBuilder Positioned_fill() {
    return PositionedFillBuilder.positionedFill();
  }
  public static PositionedDirectionalBuilder Positioned_directional(TextDirection textDirection) {
    return PositionedDirectionalBuilder.positionedDirectional(textDirection);
  }

  public static BoxDecorationBoxDecorationBuilder BoxDecoration() {
    return BoxDecorationBoxDecorationBuilder.boxDecorationBoxDecoration();
  }

  public static BoxShadowBoxShadowBuilder BoxShadow() {
    return BoxShadowBoxShadowBuilder.boxShadowBoxShadow();
  }

  public static RadiusCircularBuilder Radius_circular(double radius) {
    return RadiusCircularBuilder.radiusCircular(radius);
  }
  public static RadiusEllipticalBuilder Radius_elliptical(double x, double y) {
    return RadiusEllipticalBuilder.radiusElliptical(x, y);
  }

  public static BorderRadiusAllBuilder BorderRadius_all(RadiusI radius) {
    return BorderRadiusAllBuilder.borderRadiusAll(radius);
  }
  public static BorderRadiusCircularBuilder BorderRadius_circular(double radius) {
    return BorderRadiusCircularBuilder.borderRadiusCircular(radius);
  }
  public static BorderRadiusVerticalBuilder BorderRadius_vertical() {
    return BorderRadiusVerticalBuilder.borderRadiusVertical();
  }
  public static BorderRadiusHorizontalBuilder BorderRadius_horizontal() {
    return BorderRadiusHorizontalBuilder.borderRadiusHorizontal();
  }
  public static BorderRadiusOnlyBuilder BorderRadius_only() {
    return BorderRadiusOnlyBuilder.borderRadiusOnly();
  }

  public static PaddingPaddingBuilder Padding(EdgeInsetsGeometryI padding) {
    return PaddingPaddingBuilder.paddingPadding(padding);
  }

  public static EdgeInsetsFromLTRBBuilder EdgeInsets_fromLTRB(double left, double top, double right, double bottom) {
    return EdgeInsetsFromLTRBBuilder.edgeInsetsFromLTRB(left, top, right, bottom);
  }
  public static EdgeInsetsAllBuilder EdgeInsets_all(double value) {
    return EdgeInsetsAllBuilder.edgeInsetsAll(value);
  }
  public static EdgeInsetsOnlyBuilder EdgeInsets_only() {
    return EdgeInsetsOnlyBuilder.edgeInsetsOnly();
  }
  public static EdgeInsetsSymmetricBuilder EdgeInsets_symmetric() {
    return EdgeInsetsSymmetricBuilder.edgeInsetsSymmetric();
  }

  public static BorderSideBorderSideBuilder BorderSide() {
    return BorderSideBorderSideBuilder.borderSideBorderSide();
  }

  public static BorderBorderBuilder Border() {
    return BorderBorderBuilder.borderBorder();
  }
  public static BorderFromBorderSideBuilder Border_fromBorderSide(BorderSideI side) {
    return BorderFromBorderSideBuilder.borderFromBorderSide(side);
  }
  public static BorderSymmetricBuilder Border_symmetric() {
    return BorderSymmetricBuilder.borderSymmetric();
  }
  public static BorderAllBuilder Border_all() {
    return BorderAllBuilder.borderAll();
  }

  public static RoundedRectangleBorderRoundedRectangleBorderBuilder RoundedRectangleBorder() {
    return RoundedRectangleBorderRoundedRectangleBorderBuilder.roundedRectangleBorderRoundedRectangleBorder();
  }

  public static AnimationControllerAnimationControllerBuilder AnimationController() {
    return AnimationControllerAnimationControllerBuilder.animationControllerAnimationController();
  }
  public static AnimationControllerUnboundedBuilder AnimationController_unbounded() {
    return AnimationControllerUnboundedBuilder.animationControllerUnbounded();
  }

  public static DurationDurationBuilder Duration() {
    return DurationDurationBuilder.durationDuration();
  }

  public static AnimatedBuilderAnimatedBuilderBuilder AnimatedBuilder(ListenableI animation, BiFunction<BuildContext, Widget, Widget> builder) {
    return AnimatedBuilderAnimatedBuilderBuilder.animatedBuilderAnimatedBuilder(animation, builder);
  }

  public static ListenableBuilderListenableBuilderBuilder ListenableBuilder(ListenableI listenable, BiFunction<BuildContext, Widget, Widget> builder) {
    return ListenableBuilderListenableBuilderBuilder.listenableBuilderListenableBuilder(listenable, builder);
  }

  public static VelocityVelocityBuilder Velocity(OffsetI pixelsPerSecond) {
    return VelocityVelocityBuilder.velocityVelocity(pixelsPerSecond);
  }

  public static TapDownDetailsTapDownDetailsBuilder TapDownDetails() {
    return TapDownDetailsTapDownDetailsBuilder.tapDownDetailsTapDownDetails();
  }

  public static TapUpDetailsTapUpDetailsBuilder TapUpDetails() {
    return TapUpDetailsTapUpDetailsBuilder.tapUpDetailsTapUpDetails();
  }

  public static TapMoveDetailsTapMoveDetailsBuilder TapMoveDetails(PointerDeviceKind kind) {
    return TapMoveDetailsTapMoveDetailsBuilder.tapMoveDetailsTapMoveDetails(kind);
  }

  public static LongPressDownDetailsLongPressDownDetailsBuilder LongPressDownDetails() {
    return LongPressDownDetailsLongPressDownDetailsBuilder.longPressDownDetailsLongPressDownDetails();
  }

  public static LongPressStartDetailsLongPressStartDetailsBuilder LongPressStartDetails() {
    return LongPressStartDetailsLongPressStartDetailsBuilder.longPressStartDetailsLongPressStartDetails();
  }

  public static LongPressMoveUpdateDetailsLongPressMoveUpdateDetailsBuilder LongPressMoveUpdateDetails() {
    return LongPressMoveUpdateDetailsLongPressMoveUpdateDetailsBuilder.longPressMoveUpdateDetailsLongPressMoveUpdateDetails();
  }

  public static LongPressEndDetailsLongPressEndDetailsBuilder LongPressEndDetails() {
    return LongPressEndDetailsLongPressEndDetailsBuilder.longPressEndDetailsLongPressEndDetails();
  }

  public static DragDownDetailsDragDownDetailsBuilder DragDownDetails() {
    return DragDownDetailsDragDownDetailsBuilder.dragDownDetailsDragDownDetails();
  }

  public static DragStartDetailsDragStartDetailsBuilder DragStartDetails() {
    return DragStartDetailsDragStartDetailsBuilder.dragStartDetailsDragStartDetails();
  }

  public static DragUpdateDetailsDragUpdateDetailsBuilder DragUpdateDetails(OffsetI globalPosition) {
    return DragUpdateDetailsDragUpdateDetailsBuilder.dragUpdateDetailsDragUpdateDetails(globalPosition);
  }

  public static DragEndDetailsDragEndDetailsBuilder DragEndDetails() {
    return DragEndDetailsDragEndDetailsBuilder.dragEndDetailsDragEndDetails();
  }

  public static ScaleStartDetailsScaleStartDetailsBuilder ScaleStartDetails() {
    return ScaleStartDetailsScaleStartDetailsBuilder.scaleStartDetailsScaleStartDetails();
  }

  public static ScaleUpdateDetailsScaleUpdateDetailsBuilder ScaleUpdateDetails() {
    return ScaleUpdateDetailsScaleUpdateDetailsBuilder.scaleUpdateDetailsScaleUpdateDetails();
  }

  public static ScaleEndDetailsScaleEndDetailsBuilder ScaleEndDetails() {
    return ScaleEndDetailsScaleEndDetailsBuilder.scaleEndDetailsScaleEndDetails();
  }

  public static ForcePressDetailsForcePressDetailsBuilder ForcePressDetails(OffsetI globalPosition) {
    return ForcePressDetailsForcePressDetailsBuilder.forcePressDetailsForcePressDetails(globalPosition);
  }

  public static DraggableDetailsDraggableDetailsBuilder DraggableDetails() {
    return DraggableDetailsDraggableDetailsBuilder.draggableDetailsDraggableDetails();
  }

  public static CubicCubicBuilder Cubic(double a, double b, double c, double d) {
    return CubicCubicBuilder.cubicCubic(a, b, c, d);
  }

  public static ThreePointCubicThreePointCubicBuilder ThreePointCubic(OffsetI a1, OffsetI b1, OffsetI midpoint, OffsetI a2, OffsetI b2) {
    return ThreePointCubicThreePointCubicBuilder.threePointCubicThreePointCubic(a1, b1, midpoint, a2, b2);
  }

  public static ElasticOutCurveElasticOutCurveBuilder ElasticOutCurve() {
    return ElasticOutCurveElasticOutCurveBuilder.elasticOutCurveElasticOutCurve();
  }

  public static ElasticInCurveElasticInCurveBuilder ElasticInCurve() {
    return ElasticInCurveElasticInCurveBuilder.elasticInCurveElasticInCurve();
  }

  public static ElasticInOutCurveElasticInOutCurveBuilder ElasticInOutCurve() {
    return ElasticInOutCurveElasticInOutCurveBuilder.elasticInOutCurveElasticInOutCurve();
  }

  public static CurvedAnimationCurvedAnimationBuilder CurvedAnimation(AnimationI parent, CurveI curve) {
    return CurvedAnimationCurvedAnimationBuilder.curvedAnimationCurvedAnimation(parent, curve);
  }

  public static SizedBoxSizedBoxBuilder SizedBox() {
    return SizedBoxSizedBoxBuilder.sizedBoxSizedBox();
  }
  public static SizedBoxExpandBuilder SizedBox_expand() {
    return SizedBoxExpandBuilder.sizedBoxExpand();
  }
  public static SizedBoxShrinkBuilder SizedBox_shrink() {
    return SizedBoxShrinkBuilder.sizedBoxShrink();
  }
  public static SizedBoxFromSizeBuilder SizedBox_fromSize() {
    return SizedBoxFromSizeBuilder.sizedBoxFromSize();
  }
  public static SizedBoxSquareBuilder SizedBox_square() {
    return SizedBoxSquareBuilder.sizedBoxSquare();
  }

  public static AlignmentAlignmentBuilder Alignment(double x, double y) {
    return AlignmentAlignmentBuilder.alignmentAlignment(x, y);
  }

  public static AlignmentDirectionalAlignmentDirectionalBuilder AlignmentDirectional(double start, double y) {
    return AlignmentDirectionalAlignmentDirectionalBuilder.alignmentDirectionalAlignmentDirectional(start, y);
  }

  public static MouseRegionMouseRegionBuilder MouseRegion() {
    return MouseRegionMouseRegionBuilder.mouseRegionMouseRegion();
  }

  public static ExpandedExpandedBuilder Expanded() {
    return ExpandedExpandedBuilder.expandedExpanded();
  }

  public static FlexibleFlexibleBuilder Flexible() {
    return FlexibleFlexibleBuilder.flexibleFlexible();
  }

  public static SafeAreaSafeAreaBuilder SafeArea() {
    return SafeAreaSafeAreaBuilder.safeAreaSafeArea();
  }

  public static RotationTransitionRotationTransitionBuilder RotationTransition(AnimationI turns) {
    return RotationTransitionRotationTransitionBuilder.rotationTransitionRotationTransition(turns);
  }

  public static FadeTransitionFadeTransitionBuilder FadeTransition(AnimationI opacity) {
    return FadeTransitionFadeTransitionBuilder.fadeTransitionFadeTransition(opacity);
  }

  public static ScaleTransitionScaleTransitionBuilder ScaleTransition(AnimationI scale) {
    return ScaleTransitionScaleTransitionBuilder.scaleTransitionScaleTransition(scale);
  }

  public static AspectRatioAspectRatioBuilder AspectRatio(double aspectRatio) {
    return AspectRatioAspectRatioBuilder.aspectRatioAspectRatio(aspectRatio);
  }

  public static ClipOvalClipOvalBuilder ClipOval() {
    return ClipOvalClipOvalBuilder.clipOvalClipOval();
  }

  public static ClipRRectClipRRectBuilder ClipRRect() {
    return ClipRRectClipRRectBuilder.clipRRectClipRRect();
  }

  public static ClipRectClipRectBuilder ClipRect() {
    return ClipRectClipRectBuilder.clipRectClipRect();
  }

  public static ClipRSuperellipseClipRSuperellipseBuilder ClipRSuperellipse() {
    return ClipRSuperellipseClipRSuperellipseBuilder.clipRSuperellipseClipRSuperellipse();
  }

  public static ColoredBoxColoredBoxBuilder ColoredBox(ColorI color) {
    return ColoredBoxColoredBoxBuilder.coloredBoxColoredBox(color);
  }

  public static ConstrainedBoxConstrainedBoxBuilder ConstrainedBox(BoxConstraintsI constraints) {
    return ConstrainedBoxConstrainedBoxBuilder.constrainedBoxConstrainedBox(constraints);
  }

  public static DecoratedBoxDecoratedBoxBuilder DecoratedBox(DecorationI decoration) {
    return DecoratedBoxDecoratedBoxBuilder.decoratedBoxDecoratedBox(decoration);
  }

  public static FittedBoxFittedBoxBuilder FittedBox() {
    return FittedBoxFittedBoxBuilder.fittedBoxFittedBox();
  }

  public static FractionallySizedBoxFractionallySizedBoxBuilder FractionallySizedBox() {
    return FractionallySizedBoxFractionallySizedBoxBuilder.fractionallySizedBoxFractionallySizedBox();
  }

  public static IntrinsicHeightIntrinsicHeightBuilder IntrinsicHeight() {
    return IntrinsicHeightIntrinsicHeightBuilder.intrinsicHeightIntrinsicHeight();
  }

  public static IntrinsicWidthIntrinsicWidthBuilder IntrinsicWidth() {
    return IntrinsicWidthIntrinsicWidthBuilder.intrinsicWidthIntrinsicWidth();
  }

  public static LimitedBoxLimitedBoxBuilder LimitedBox() {
    return LimitedBoxLimitedBoxBuilder.limitedBoxLimitedBox();
  }

  public static PlaceholderPlaceholderBuilder Placeholder() {
    return PlaceholderPlaceholderBuilder.placeholderPlaceholder();
  }

  public static SpacerSpacerBuilder Spacer() {
    return SpacerSpacerBuilder.spacerSpacer();
  }

  public static VisibilityVisibilityBuilder Visibility(WidgetI child) {
    return VisibilityVisibilityBuilder.visibilityVisibility(child);
  }
  public static VisibilityMaintainBuilder Visibility_maintain(WidgetI child) {
    return VisibilityMaintainBuilder.visibilityMaintain(child);
  }

  public static RotatedBoxRotatedBoxBuilder RotatedBox(int quarterTurns) {
    return RotatedBoxRotatedBoxBuilder.rotatedBoxRotatedBox(quarterTurns);
  }

  public static BaselineBaselineBuilder Baseline(double baseline, TextBaseline baselineType) {
    return BaselineBaselineBuilder.baselineBaseline(baseline, baselineType);
  }

  public static DefaultTextStyleDefaultTextStyleBuilder DefaultTextStyle(TextStyleI style) {
    return DefaultTextStyleDefaultTextStyleBuilder.defaultTextStyleDefaultTextStyle(style);
  }
  public static DefaultTextStyleFallbackBuilder DefaultTextStyle_fallback() {
    return DefaultTextStyleFallbackBuilder.defaultTextStyleFallback();
  }

  public static DirectionalityDirectionalityBuilder Directionality(TextDirection textDirection, WidgetI child) {
    return DirectionalityDirectionalityBuilder.directionalityDirectionality(textDirection, child);
  }

  public static OverflowBoxOverflowBoxBuilder OverflowBox() {
    return OverflowBoxOverflowBoxBuilder.overflowBoxOverflowBox();
  }

  public static AbsorbPointerAbsorbPointerBuilder AbsorbPointer() {
    return AbsorbPointerAbsorbPointerBuilder.absorbPointerAbsorbPointer();
  }

  public static IgnorePointerIgnorePointerBuilder IgnorePointer() {
    return IgnorePointerIgnorePointerBuilder.ignorePointerIgnorePointer();
  }

  public static RepaintBoundaryRepaintBoundaryBuilder RepaintBoundary() {
    return RepaintBoundaryRepaintBoundaryBuilder.repaintBoundaryRepaintBoundary();
  }
  public static RepaintBoundaryWrapBuilder RepaintBoundary_wrap(WidgetI child, int childIndex) {
    return RepaintBoundaryWrapBuilder.repaintBoundaryWrap(child, childIndex);
  }

  public static FractionalTranslationFractionalTranslationBuilder FractionalTranslation(OffsetI translation) {
    return FractionalTranslationFractionalTranslationBuilder.fractionalTranslationFractionalTranslation(translation);
  }

  public static UnconstrainedBoxUnconstrainedBoxBuilder UnconstrainedBox() {
    return UnconstrainedBoxUnconstrainedBoxBuilder.unconstrainedBoxUnconstrainedBox();
  }

  public static FlutterLogoFlutterLogoBuilder FlutterLogo() {
    return FlutterLogoFlutterLogoBuilder.flutterLogoFlutterLogo();
  }

  public static PhysicalModelPhysicalModelBuilder PhysicalModel() {
    return PhysicalModelPhysicalModelBuilder.physicalModelPhysicalModel();
  }

  public static BannerBannerBuilder Banner() {
    return BannerBannerBuilder.bannerBanner();
  }

  public static AnimatedContainerAnimatedContainerBuilder AnimatedContainer() {
    return AnimatedContainerAnimatedContainerBuilder.animatedContainerAnimatedContainer();
  }

  public static AnimatedOpacityAnimatedOpacityBuilder AnimatedOpacity() {
    return AnimatedOpacityAnimatedOpacityBuilder.animatedOpacityAnimatedOpacity();
  }

  public static AnimatedPaddingAnimatedPaddingBuilder AnimatedPadding(EdgeInsetsGeometryI padding) {
    return AnimatedPaddingAnimatedPaddingBuilder.animatedPaddingAnimatedPadding(padding);
  }

  public static AnimatedAlignAnimatedAlignBuilder AnimatedAlign(AlignmentGeometryI alignment) {
    return AnimatedAlignAnimatedAlignBuilder.animatedAlignAnimatedAlign(alignment);
  }

  public static ListViewListViewBuilder ListView() {
    return ListViewListViewBuilder.listViewListView();
  }
  public static ListViewBuilderBuilder ListView_builder() {
    return ListViewBuilderBuilder.listViewBuilder();
  }
  public static ListViewSeparatedBuilder ListView_separated() {
    return ListViewSeparatedBuilder.listViewSeparated();
  }

  public static GridViewCountBuilder GridView_count() {
    return GridViewCountBuilder.gridViewCount();
  }
  public static GridViewExtentBuilder GridView_extent() {
    return GridViewExtentBuilder.gridViewExtent();
  }

  public static PageViewPageViewBuilder PageView() {
    return PageViewPageViewBuilder.pageViewPageView();
  }
  public static PageViewBuilderBuilder PageView_builder() {
    return PageViewBuilderBuilder.pageViewBuilder();
  }

  public static ListWheelScrollViewListWheelScrollViewBuilder ListWheelScrollView() {
    return ListWheelScrollViewListWheelScrollViewBuilder.listWheelScrollViewListWheelScrollView();
  }

  public static AnimatedSizeAnimatedSizeBuilder AnimatedSize() {
    return AnimatedSizeAnimatedSizeBuilder.animatedSizeAnimatedSize();
  }

  public static AnimatedScaleAnimatedScaleBuilder AnimatedScale() {
    return AnimatedScaleAnimatedScaleBuilder.animatedScaleAnimatedScale();
  }

  public static AnimatedRotationAnimatedRotationBuilder AnimatedRotation() {
    return AnimatedRotationAnimatedRotationBuilder.animatedRotationAnimatedRotation();
  }

  public static AnimatedSlideAnimatedSlideBuilder AnimatedSlide() {
    return AnimatedSlideAnimatedSlideBuilder.animatedSlideAnimatedSlide();
  }

  public static AnimatedCrossFadeAnimatedCrossFadeBuilder AnimatedCrossFade(WidgetI firstChild, WidgetI secondChild) {
    return AnimatedCrossFadeAnimatedCrossFadeBuilder.animatedCrossFadeAnimatedCrossFade(firstChild, secondChild);
  }

  public static SlideTransitionSlideTransitionBuilder SlideTransition(AnimationI position) {
    return SlideTransitionSlideTransitionBuilder.slideTransitionSlideTransition(position);
  }

  public static SizeTransitionSizeTransitionBuilder SizeTransition() {
    return SizeTransitionSizeTransitionBuilder.sizeTransitionSizeTransition();
  }

  public static IndexedStackIndexedStackBuilder IndexedStack() {
    return IndexedStackIndexedStackBuilder.indexedStackIndexedStack();
  }

  public static InteractiveViewerInteractiveViewerBuilder InteractiveViewer() {
    return InteractiveViewerInteractiveViewerBuilder.interactiveViewerInteractiveViewer();
  }

  public static <T extends NativeObj> DraggableDraggableBuilder<T> Draggable(WidgetI child, WidgetI feedback) {
    return DraggableDraggableBuilder.draggableDraggable(child, feedback);
  }

  public static <T extends NativeObj> DragTargetDragTargetBuilder<T> DragTarget(TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> builder) {
    return DragTargetDragTargetBuilder.dragTargetDragTarget(builder);
  }

  public static HeroHeroBuilder Hero(NativeObj.I tag) {
    return HeroHeroBuilder.heroHero(tag);
  }

  public static AnimatedSwitcherAnimatedSwitcherBuilder AnimatedSwitcher() {
    return AnimatedSwitcherAnimatedSwitcherBuilder.animatedSwitcherAnimatedSwitcher();
  }

  public static ColorFilterModeBuilder ColorFilter_mode(ColorI color, BlendMode blendMode) {
    return ColorFilterModeBuilder.colorFilterMode(color, blendMode);
  }
  public static ColorFilterLinearToSrgbGammaBuilder ColorFilter_linearToSrgbGamma() {
    return ColorFilterLinearToSrgbGammaBuilder.colorFilterLinearToSrgbGamma();
  }
  public static ColorFilterSrgbToLinearGammaBuilder ColorFilter_srgbToLinearGamma() {
    return ColorFilterSrgbToLinearGammaBuilder.colorFilterSrgbToLinearGamma();
  }

  public static BackdropFilterBackdropFilterBuilder BackdropFilter(ImageFilterI filter) {
    return BackdropFilterBackdropFilterBuilder.backdropFilterBackdropFilter(filter);
  }
  public static BackdropFilterGroupedBuilder BackdropFilter_grouped(ImageFilterI filter) {
    return BackdropFilterGroupedBuilder.backdropFilterGrouped(filter);
  }

  public static ImageFilterBlurBuilder ImageFilter_blur() {
    return ImageFilterBlurBuilder.imageFilterBlur();
  }
  public static ImageFilterDilateBuilder ImageFilter_dilate() {
    return ImageFilterDilateBuilder.imageFilterDilate();
  }
  public static ImageFilterErodeBuilder ImageFilter_erode() {
    return ImageFilterErodeBuilder.imageFilterErode();
  }
  public static ImageFilterComposeBuilder ImageFilter_compose(ImageFilterI outer, ImageFilterI inner) {
    return ImageFilterComposeBuilder.imageFilterCompose(outer, inner);
  }

  public static ColorFilteredColorFilteredBuilder ColorFiltered(ColorFilterI colorFilter) {
    return ColorFilteredColorFilteredBuilder.colorFilteredColorFiltered(colorFilter);
  }

  public static ImageFilteredImageFilteredBuilder ImageFiltered(ImageFilterI imageFilter) {
    return ImageFilteredImageFilteredBuilder.imageFilteredImageFiltered(imageFilter);
  }

  public static ColorSchemeColorSchemeBuilder ColorScheme(Brightness brightness, ColorI primary, ColorI onPrimary) {
    return ColorSchemeColorSchemeBuilder.colorSchemeColorScheme(brightness, primary, onPrimary);
  }
  public static ColorSchemeFromSeedBuilder ColorScheme_fromSeed(ColorI seedColor) {
    return ColorSchemeFromSeedBuilder.colorSchemeFromSeed(seedColor);
  }
  public static ColorSchemeLightBuilder ColorScheme_light() {
    return ColorSchemeLightBuilder.colorSchemeLight();
  }
  public static ColorSchemeDarkBuilder ColorScheme_dark() {
    return ColorSchemeDarkBuilder.colorSchemeDark();
  }
  public static ColorSchemeHighContrastLightBuilder ColorScheme_highContrastLight() {
    return ColorSchemeHighContrastLightBuilder.colorSchemeHighContrastLight();
  }
  public static ColorSchemeHighContrastDarkBuilder ColorScheme_highContrastDark() {
    return ColorSchemeHighContrastDarkBuilder.colorSchemeHighContrastDark();
  }
  public static ColorSchemeFromSwatchBuilder ColorScheme_fromSwatch() {
    return ColorSchemeFromSwatchBuilder.colorSchemeFromSwatch();
  }

  public static MaterialColorMaterialColorBuilder MaterialColor(int primary, Map<Integer, Color> swatch) {
    return MaterialColorMaterialColorBuilder.materialColorMaterialColor(primary, swatch);
  }

  public static TextThemeTextThemeBuilder TextTheme() {
    return TextThemeTextThemeBuilder.textThemeTextTheme();
  }

  public static VisualDensityVisualDensityBuilder VisualDensity() {
    return VisualDensityVisualDensityBuilder.visualDensityVisualDensity();
  }

  public static ThemeDataThemeDataBuilder ThemeData() {
    return ThemeDataThemeDataBuilder.themeDataThemeData();
  }
  public static ThemeDataFromBuilder ThemeData_from(ColorSchemeI colorScheme) {
    return ThemeDataFromBuilder.themeDataFrom(colorScheme);
  }
  public static ThemeDataLightBuilder ThemeData_light() {
    return ThemeDataLightBuilder.themeDataLight();
  }
  public static ThemeDataDarkBuilder ThemeData_dark() {
    return ThemeDataDarkBuilder.themeDataDark();
  }
  public static ThemeDataFallbackBuilder ThemeData_fallback() {
    return ThemeDataFallbackBuilder.themeDataFallback();
  }

  public static MaterialAccentColorMaterialAccentColorBuilder MaterialAccentColor(int primary, Map<Integer, Color> swatch) {
    return MaterialAccentColorMaterialAccentColorBuilder.materialAccentColorMaterialAccentColor(primary, swatch);
  }

  public static MaterialMaterialBuilder Material() {
    return MaterialMaterialBuilder.materialMaterial();
  }

  public static IconButtonIconButtonBuilder IconButton() {
    return IconButtonIconButtonBuilder.iconButtonIconButton();
  }
  public static IconButtonFilledBuilder IconButton_filled() {
    return IconButtonFilledBuilder.iconButtonFilled();
  }
  public static IconButtonFilledTonalBuilder IconButton_filledTonal() {
    return IconButtonFilledTonalBuilder.iconButtonFilledTonal();
  }
  public static IconButtonOutlinedBuilder IconButton_outlined() {
    return IconButtonOutlinedBuilder.iconButtonOutlined();
  }

  public static AppBarAppBarBuilder AppBar() {
    return AppBarAppBarBuilder.appBarAppBar();
  }

  public static ScaffoldScaffoldBuilder Scaffold() {
    return ScaffoldScaffoldBuilder.scaffoldScaffold();
  }

  public static MaterialAppMaterialAppBuilder MaterialApp() {
    return MaterialAppMaterialAppBuilder.materialAppMaterialApp();
  }
  public static MaterialAppRouterBuilder MaterialApp_router() {
    return MaterialAppRouterBuilder.materialAppRouter();
  }

  public static FloatingActionButtonFloatingActionButtonBuilder FloatingActionButton() {
    return FloatingActionButtonFloatingActionButtonBuilder.floatingActionButtonFloatingActionButton();
  }
  public static FloatingActionButtonSmallBuilder FloatingActionButton_small() {
    return FloatingActionButtonSmallBuilder.floatingActionButtonSmall();
  }
  public static FloatingActionButtonLargeBuilder FloatingActionButton_large() {
    return FloatingActionButtonLargeBuilder.floatingActionButtonLarge();
  }
  public static FloatingActionButtonExtendedBuilder FloatingActionButton_extended() {
    return FloatingActionButtonExtendedBuilder.floatingActionButtonExtended();
  }

  public static ThemeThemeBuilder Theme(ThemeDataI data, WidgetI child) {
    return ThemeThemeBuilder.themeTheme(data, child);
  }

  public static ElevatedButtonElevatedButtonBuilder ElevatedButton(Runnable onPressed) {
    return ElevatedButtonElevatedButtonBuilder.elevatedButtonElevatedButton(onPressed);
  }
  public static ElevatedButtonIconBuilder ElevatedButton_icon(Runnable onPressed) {
    return ElevatedButtonIconBuilder.elevatedButtonIcon(onPressed);
  }

  public static OutlinedButtonOutlinedButtonBuilder OutlinedButton(Runnable onPressed) {
    return OutlinedButtonOutlinedButtonBuilder.outlinedButtonOutlinedButton(onPressed);
  }
  public static OutlinedButtonIconBuilder OutlinedButton_icon(Runnable onPressed) {
    return OutlinedButtonIconBuilder.outlinedButtonIcon(onPressed);
  }

  public static TextButtonTextButtonBuilder TextButton(Runnable onPressed) {
    return TextButtonTextButtonBuilder.textButtonTextButton(onPressed);
  }
  public static TextButtonIconBuilder TextButton_icon(Runnable onPressed) {
    return TextButtonIconBuilder.textButtonIcon(onPressed);
  }

  public static NavigatorStateNavigatorStateBuilder NavigatorState() {
    return NavigatorStateNavigatorStateBuilder.navigatorStateNavigatorState();
  }

  public static NavigatorNavigatorBuilder Navigator() {
    return NavigatorNavigatorBuilder.navigatorNavigator();
  }

  public static AlertDialogAlertDialogBuilder AlertDialog() {
    return AlertDialogAlertDialogBuilder.alertDialogAlertDialog();
  }
  public static AlertDialogAdaptiveBuilder AlertDialog_adaptive() {
    return AlertDialogAdaptiveBuilder.alertDialogAdaptive();
  }

  public static InputDecorationInputDecorationBuilder InputDecoration() {
    return InputDecorationInputDecorationBuilder.inputDecorationInputDecoration();
  }
  public static InputDecorationCollapsedBuilder InputDecoration_collapsed(String hintText) {
    return InputDecorationCollapsedBuilder.inputDecorationCollapsed(hintText);
  }

  public static TextFieldTextFieldBuilder TextField() {
    return TextFieldTextFieldBuilder.textFieldTextField();
  }

  public static DividerDividerBuilder Divider() {
    return DividerDividerBuilder.dividerDivider();
  }

  public static FilledButtonFilledButtonBuilder FilledButton(Runnable onPressed) {
    return FilledButtonFilledButtonBuilder.filledButtonFilledButton(onPressed);
  }
  public static FilledButtonIconBuilder FilledButton_icon(Runnable onPressed) {
    return FilledButtonIconBuilder.filledButtonIcon(onPressed);
  }
  public static FilledButtonTonalBuilder FilledButton_tonal(Runnable onPressed) {
    return FilledButtonTonalBuilder.filledButtonTonal(onPressed);
  }
  public static FilledButtonTonalIconBuilder FilledButton_tonalIcon(Runnable onPressed) {
    return FilledButtonTonalIconBuilder.filledButtonTonalIcon(onPressed);
  }

  public static OutlineInputBorderOutlineInputBorderBuilder OutlineInputBorder() {
    return OutlineInputBorderOutlineInputBorderBuilder.outlineInputBorderOutlineInputBorder();
  }

  public static SnackBarActionSnackBarActionBuilder SnackBarAction() {
    return SnackBarActionSnackBarActionBuilder.snackBarActionSnackBarAction();
  }

  public static SnackBarSnackBarBuilder SnackBar(WidgetI content) {
    return SnackBarSnackBarBuilder.snackBarSnackBar(content);
  }

  public static ScaffoldMessengerScaffoldMessengerBuilder ScaffoldMessenger(WidgetI child) {
    return ScaffoldMessengerScaffoldMessengerBuilder.scaffoldMessengerScaffoldMessenger(child);
  }

  public static CardCardBuilder Card() {
    return CardCardBuilder.cardCard();
  }
  public static CardFilledBuilder Card_filled() {
    return CardFilledBuilder.cardFilled();
  }
  public static CardOutlinedBuilder Card_outlined() {
    return CardOutlinedBuilder.cardOutlined();
  }

  public static ChipChipBuilder Chip() {
    return ChipChipBuilder.chipChip();
  }

  public static GestureDetectorGestureDetectorBuilder GestureDetector() {
    return GestureDetectorGestureDetectorBuilder.gestureDetectorGestureDetector();
  }

  public static ListTileListTileBuilder ListTile() {
    return ListTileListTileBuilder.listTileListTile();
  }

  public static WrapWrapBuilder Wrap() {
    return WrapWrapBuilder.wrapWrap();
  }

  public static SingleChildScrollViewSingleChildScrollViewBuilder SingleChildScrollView() {
    return SingleChildScrollViewSingleChildScrollViewBuilder.singleChildScrollViewSingleChildScrollView();
  }

  public static CircularProgressIndicatorCircularProgressIndicatorBuilder CircularProgressIndicator() {
    return CircularProgressIndicatorCircularProgressIndicatorBuilder.circularProgressIndicatorCircularProgressIndicator();
  }
  public static CircularProgressIndicatorAdaptiveBuilder CircularProgressIndicator_adaptive() {
    return CircularProgressIndicatorAdaptiveBuilder.circularProgressIndicatorAdaptive();
  }

  public static LinearProgressIndicatorLinearProgressIndicatorBuilder LinearProgressIndicator() {
    return LinearProgressIndicatorLinearProgressIndicatorBuilder.linearProgressIndicatorLinearProgressIndicator();
  }

  public static CheckboxCheckboxBuilder Checkbox(boolean value) {
    return CheckboxCheckboxBuilder.checkboxCheckbox(value);
  }
  public static CheckboxAdaptiveBuilder Checkbox_adaptive(boolean value) {
    return CheckboxAdaptiveBuilder.checkboxAdaptive(value);
  }

  public static Switch_Switch_Builder Switch(boolean value, Consumer<Boolean> onChanged) {
    return Switch_Switch_Builder.switch_Switch_(value, onChanged);
  }
  public static Switch_AdaptiveBuilder Switch_adaptive(boolean value, Consumer<Boolean> onChanged) {
    return Switch_AdaptiveBuilder.switch_Adaptive(value, onChanged);
  }

  public static SliderSliderBuilder Slider(double value) {
    return SliderSliderBuilder.sliderSlider(value);
  }
  public static SliderAdaptiveBuilder Slider_adaptive(double value) {
    return SliderAdaptiveBuilder.sliderAdaptive(value);
  }

  public static DrawerDrawerBuilder Drawer() {
    return DrawerDrawerBuilder.drawerDrawer();
  }

  public static TooltipTooltipBuilder Tooltip() {
    return TooltipTooltipBuilder.tooltipTooltip();
  }

  public static TabTabBuilder Tab() {
    return TabTabBuilder.tabTab();
  }

  public static TabBarTabBarBuilder TabBar(List<WidgetI> tabs) {
    return TabBarTabBarBuilder.tabBarTabBar(tabs);
  }
  public static TabBarSecondaryBuilder TabBar_secondary(List<WidgetI> tabs) {
    return TabBarSecondaryBuilder.tabBarSecondary(tabs);
  }

  public static TabBarViewTabBarViewBuilder TabBarView(List<WidgetI> children) {
    return TabBarViewTabBarViewBuilder.tabBarViewTabBarView(children);
  }

  public static DefaultTabControllerDefaultTabControllerBuilder DefaultTabController(int length) {
    return DefaultTabControllerDefaultTabControllerBuilder.defaultTabControllerDefaultTabController(length);
  }

  public static CheckboxListTileCheckboxListTileBuilder CheckboxListTile(boolean value, Consumer<Boolean> onChanged) {
    return CheckboxListTileCheckboxListTileBuilder.checkboxListTileCheckboxListTile(value, onChanged);
  }
  public static CheckboxListTileAdaptiveBuilder CheckboxListTile_adaptive(boolean value, Consumer<Boolean> onChanged) {
    return CheckboxListTileAdaptiveBuilder.checkboxListTileAdaptive(value, onChanged);
  }

  public static SwitchListTileSwitchListTileBuilder SwitchListTile(boolean value, Consumer<Boolean> onChanged) {
    return SwitchListTileSwitchListTileBuilder.switchListTileSwitchListTile(value, onChanged);
  }
  public static SwitchListTileAdaptiveBuilder SwitchListTile_adaptive(boolean value, Consumer<Boolean> onChanged) {
    return SwitchListTileAdaptiveBuilder.switchListTileAdaptive(value, onChanged);
  }

  public static BadgeBadgeBuilder Badge() {
    return BadgeBadgeBuilder.badgeBadge();
  }
  public static BadgeCountBuilder Badge_count() {
    return BadgeCountBuilder.badgeCount();
  }

  public static SelectableTextSelectableTextBuilder SelectableText(String data) {
    return SelectableTextSelectableTextBuilder.selectableTextSelectableText(data);
  }
  public static SelectableTextRichBuilder SelectableText_rich(TextSpanI textSpan) {
    return SelectableTextRichBuilder.selectableTextRich(textSpan);
  }

  public static InkWellInkWellBuilder InkWell() {
    return InkWellInkWellBuilder.inkWellInkWell();
  }

  public static InkResponseInkResponseBuilder InkResponse() {
    return InkResponseInkResponseBuilder.inkResponseInkResponse();
  }

  public static DataTableDataTableBuilder DataTable(List<DataColumnI> columns) {
    return DataTableDataTableBuilder.dataTableDataTable(columns);
  }

  public static DataColumnDataColumnBuilder DataColumn(WidgetI label) {
    return DataColumnDataColumnBuilder.dataColumnDataColumn(label);
  }

  public static DataRowDataRowBuilder DataRow() {
    return DataRowDataRowBuilder.dataRowDataRow();
  }
  public static DataRowByIndexBuilder DataRow_byIndex() {
    return DataRowByIndexBuilder.dataRowByIndex();
  }

  public static DataCellDataCellBuilder DataCell(WidgetI child) {
    return DataCellDataCellBuilder.dataCellDataCell(child);
  }

  public static <T extends NativeObj> DropdownMenuEntryDropdownMenuEntryBuilder<T> DropdownMenuEntry(NativeObj value, String label) {
    return DropdownMenuEntryDropdownMenuEntryBuilder.dropdownMenuEntryDropdownMenuEntry(value, label);
  }

  public static <T extends NativeObj> RadioRadioBuilder<T> Radio(NativeObj value) {
    return RadioRadioBuilder.radioRadio(value);
  }
  public static <T extends NativeObj> RadioAdaptiveBuilder<T> Radio_adaptive(NativeObj value) {
    return RadioAdaptiveBuilder.radioAdaptive(value);
  }

  public static <T extends NativeObj> RadioListTileRadioListTileBuilder<T> RadioListTile(NativeObj value) {
    return RadioListTileRadioListTileBuilder.radioListTileRadioListTile(value);
  }
  public static <T extends NativeObj> RadioListTileAdaptiveBuilder<T> RadioListTile_adaptive(NativeObj value) {
    return RadioListTileAdaptiveBuilder.radioListTileAdaptive(value);
  }

  public static ExpansionTileExpansionTileBuilder ExpansionTile() {
    return ExpansionTileExpansionTileBuilder.expansionTileExpansionTile();
  }

  public static ExpansionPanelExpansionPanelBuilder ExpansionPanel(BiFunction<BuildContext, Boolean, Widget> headerBuilder, WidgetI body) {
    return ExpansionPanelExpansionPanelBuilder.expansionPanelExpansionPanel(headerBuilder, body);
  }

  public static ExpansionPanelListExpansionPanelListBuilder ExpansionPanelList() {
    return ExpansionPanelListExpansionPanelListBuilder.expansionPanelListExpansionPanelList();
  }
  public static ExpansionPanelListRadioBuilder ExpansionPanelList_radio() {
    return ExpansionPanelListRadioBuilder.expansionPanelListRadio();
  }

  public static ExpansionPanelRadioExpansionPanelRadioBuilder ExpansionPanelRadio(NativeObj.I value, BiFunction<BuildContext, Boolean, Widget> headerBuilder, WidgetI body) {
    return ExpansionPanelRadioExpansionPanelRadioBuilder.expansionPanelRadioExpansionPanelRadio(value, headerBuilder, body);
  }

  public static NavigationRailNavigationRailBuilder NavigationRail() {
    return NavigationRailNavigationRailBuilder.navigationRailNavigationRail();
  }

  public static NavigationRailDestinationNavigationRailDestinationBuilder NavigationRailDestination(WidgetI icon) {
    return NavigationRailDestinationNavigationRailDestinationBuilder.navigationRailDestinationNavigationRailDestination(icon);
  }

  public static NavigationBarNavigationBarBuilder NavigationBar() {
    return NavigationBarNavigationBarBuilder.navigationBarNavigationBar();
  }

  public static NavigationDestinationNavigationDestinationBuilder NavigationDestination(WidgetI icon) {
    return NavigationDestinationNavigationDestinationBuilder.navigationDestinationNavigationDestination(icon);
  }

  public static NavigationDrawerNavigationDrawerBuilder NavigationDrawer(List<WidgetI> children) {
    return NavigationDrawerNavigationDrawerBuilder.navigationDrawerNavigationDrawer(children);
  }

  public static NavigationDrawerDestinationNavigationDrawerDestinationBuilder NavigationDrawerDestination() {
    return NavigationDrawerDestinationNavigationDrawerDestinationBuilder.navigationDrawerDestinationNavigationDrawerDestination();
  }

  public static <T extends NativeObj> PopupMenuButtonPopupMenuButtonBuilder<T> PopupMenuButton(Function<BuildContext, List<PopupMenuEntry>> itemBuilder) {
    return PopupMenuButtonPopupMenuButtonBuilder.popupMenuButtonPopupMenuButton(itemBuilder);
  }

  public static <T extends NativeObj> PopupMenuItemPopupMenuItemBuilder<T> PopupMenuItem() {
    return PopupMenuItemPopupMenuItemBuilder.popupMenuItemPopupMenuItem();
  }

  public static PopupMenuDividerPopupMenuDividerBuilder PopupMenuDivider() {
    return PopupMenuDividerPopupMenuDividerBuilder.popupMenuDividerPopupMenuDivider();
  }

  public static <T extends NativeObj> CheckedPopupMenuItemCheckedPopupMenuItemBuilder<T> CheckedPopupMenuItem() {
    return CheckedPopupMenuItemCheckedPopupMenuItemBuilder.checkedPopupMenuItemCheckedPopupMenuItem();
  }

  public static CircleAvatarCircleAvatarBuilder CircleAvatar() {
    return CircleAvatarCircleAvatarBuilder.circleAvatarCircleAvatar();
  }

  public static ScrollbarScrollbarBuilder Scrollbar(WidgetI child) {
    return ScrollbarScrollbarBuilder.scrollbarScrollbar(child);
  }

  public static MenuBarMenuBarBuilder MenuBar() {
    return MenuBarMenuBarBuilder.menuBarMenuBar();
  }

  public static MenuAnchorMenuAnchorBuilder MenuAnchor() {
    return MenuAnchorMenuAnchorBuilder.menuAnchorMenuAnchor();
  }

  public static SubmenuButtonSubmenuButtonBuilder SubmenuButton() {
    return SubmenuButtonSubmenuButtonBuilder.submenuButtonSubmenuButton();
  }

  public static MenuItemButtonMenuItemButtonBuilder MenuItemButton() {
    return MenuItemButtonMenuItemButtonBuilder.menuItemButtonMenuItemButton();
  }

  public static CheckboxMenuButtonCheckboxMenuButtonBuilder CheckboxMenuButton(boolean value) {
    return CheckboxMenuButtonCheckboxMenuButtonBuilder.checkboxMenuButtonCheckboxMenuButton(value);
  }

  public static <T extends NativeObj> RadioMenuButtonRadioMenuButtonBuilder<T> RadioMenuButton(NativeObj value, NativeObj groupValue, Consumer<NativeObj> onChanged) {
    return RadioMenuButtonRadioMenuButtonBuilder.radioMenuButtonRadioMenuButton(value, groupValue, onChanged);
  }

  public static DatePickerDialogDatePickerDialogBuilder DatePickerDialog() {
    return DatePickerDialogDatePickerDialogBuilder.datePickerDialogDatePickerDialog();
  }

  public static CalendarDatePickerCalendarDatePickerBuilder CalendarDatePicker(DateTimeI initialDate, DateTimeI firstDate, DateTimeI lastDate) {
    return CalendarDatePickerCalendarDatePickerBuilder.calendarDatePickerCalendarDatePicker(initialDate, firstDate, lastDate);
  }

  public static TimePickerDialogTimePickerDialogBuilder TimePickerDialog(TimeOfDayI initialTime) {
    return TimePickerDialogTimePickerDialogBuilder.timePickerDialogTimePickerDialog(initialTime);
  }

  public static DateRangePickerDialogDateRangePickerDialogBuilder DateRangePickerDialog(DateTimeI firstDate, DateTimeI lastDate) {
    return DateRangePickerDialogDateRangePickerDialogBuilder.dateRangePickerDialogDateRangePickerDialog(firstDate, lastDate);
  }

  public static YearPickerYearPickerBuilder YearPicker() {
    return YearPickerYearPickerBuilder.yearPickerYearPicker();
  }

  public static InputDatePickerFormFieldInputDatePickerFormFieldBuilder InputDatePickerFormField() {
    return InputDatePickerFormFieldInputDatePickerFormFieldBuilder.inputDatePickerFormFieldInputDatePickerFormField();
  }

  public static SearchBarSearchBarBuilder SearchBar() {
    return SearchBarSearchBarBuilder.searchBarSearchBar();
  }

  public static CupertinoAppCupertinoAppBuilder CupertinoApp() {
    return CupertinoAppCupertinoAppBuilder.cupertinoAppCupertinoApp();
  }
  public static CupertinoAppRouterBuilder CupertinoApp_router() {
    return CupertinoAppRouterBuilder.cupertinoAppRouter();
  }

  public static CupertinoPageScaffoldCupertinoPageScaffoldBuilder CupertinoPageScaffold() {
    return CupertinoPageScaffoldCupertinoPageScaffoldBuilder.cupertinoPageScaffoldCupertinoPageScaffold();
  }

  public static CupertinoNavigationBarCupertinoNavigationBarBuilder CupertinoNavigationBar() {
    return CupertinoNavigationBarCupertinoNavigationBarBuilder.cupertinoNavigationBarCupertinoNavigationBar();
  }
  public static CupertinoNavigationBarLargeBuilder CupertinoNavigationBar_large() {
    return CupertinoNavigationBarLargeBuilder.cupertinoNavigationBarLarge();
  }

  public static CupertinoSliverNavigationBarCupertinoSliverNavigationBarBuilder CupertinoSliverNavigationBar() {
    return CupertinoSliverNavigationBarCupertinoSliverNavigationBarBuilder.cupertinoSliverNavigationBarCupertinoSliverNavigationBar();
  }
  public static CupertinoSliverNavigationBarSearchBuilder CupertinoSliverNavigationBar_search(WidgetI searchField) {
    return CupertinoSliverNavigationBarSearchBuilder.cupertinoSliverNavigationBarSearch(searchField);
  }

  public static CupertinoTabViewCupertinoTabViewBuilder CupertinoTabView() {
    return CupertinoTabViewCupertinoTabViewBuilder.cupertinoTabViewCupertinoTabView();
  }

  public static CupertinoButtonCupertinoButtonBuilder CupertinoButton(WidgetI child) {
    return CupertinoButtonCupertinoButtonBuilder.cupertinoButtonCupertinoButton(child);
  }
  public static CupertinoButtonTintedBuilder CupertinoButton_tinted(WidgetI child) {
    return CupertinoButtonTintedBuilder.cupertinoButtonTinted(child);
  }
  public static CupertinoButtonFilledBuilder CupertinoButton_filled(WidgetI child) {
    return CupertinoButtonFilledBuilder.cupertinoButtonFilled(child);
  }

  public static CupertinoSwitchCupertinoSwitchBuilder CupertinoSwitch(boolean value, Consumer<Boolean> onChanged) {
    return CupertinoSwitchCupertinoSwitchBuilder.cupertinoSwitchCupertinoSwitch(value, onChanged);
  }

  public static CupertinoSliderCupertinoSliderBuilder CupertinoSlider(double value, Consumer<Double> onChanged) {
    return CupertinoSliderCupertinoSliderBuilder.cupertinoSliderCupertinoSlider(value, onChanged);
  }

  public static CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder CupertinoSearchTextField() {
    return CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder.cupertinoSearchTextFieldCupertinoSearchTextField();
  }

  public static CupertinoActivityIndicatorCupertinoActivityIndicatorBuilder CupertinoActivityIndicator() {
    return CupertinoActivityIndicatorCupertinoActivityIndicatorBuilder.cupertinoActivityIndicatorCupertinoActivityIndicator();
  }
  public static CupertinoActivityIndicatorPartiallyRevealedBuilder CupertinoActivityIndicator_partiallyRevealed() {
    return CupertinoActivityIndicatorPartiallyRevealedBuilder.cupertinoActivityIndicatorPartiallyRevealed();
  }

  public static CupertinoListSectionCupertinoListSectionBuilder CupertinoListSection() {
    return CupertinoListSectionCupertinoListSectionBuilder.cupertinoListSectionCupertinoListSection();
  }
  public static CupertinoListSectionInsetGroupedBuilder CupertinoListSection_insetGrouped() {
    return CupertinoListSectionInsetGroupedBuilder.cupertinoListSectionInsetGrouped();
  }

  public static CupertinoListTileCupertinoListTileBuilder CupertinoListTile(WidgetI title) {
    return CupertinoListTileCupertinoListTileBuilder.cupertinoListTileCupertinoListTile(title);
  }
  public static CupertinoListTileNotchedBuilder CupertinoListTile_notched(WidgetI title) {
    return CupertinoListTileNotchedBuilder.cupertinoListTileNotched(title);
  }

  public static CupertinoListTileChevronCupertinoListTileChevronBuilder CupertinoListTileChevron() {
    return CupertinoListTileChevronCupertinoListTileChevronBuilder.cupertinoListTileChevronCupertinoListTileChevron();
  }

  public static CupertinoFormSectionCupertinoFormSectionBuilder CupertinoFormSection(List<WidgetI> children) {
    return CupertinoFormSectionCupertinoFormSectionBuilder.cupertinoFormSectionCupertinoFormSection(children);
  }
  public static CupertinoFormSectionInsetGroupedBuilder CupertinoFormSection_insetGrouped(List<WidgetI> children) {
    return CupertinoFormSectionInsetGroupedBuilder.cupertinoFormSectionInsetGrouped(children);
  }

  public static CupertinoFormRowCupertinoFormRowBuilder CupertinoFormRow(WidgetI child) {
    return CupertinoFormRowCupertinoFormRowBuilder.cupertinoFormRowCupertinoFormRow(child);
  }

  public static CupertinoPickerCupertinoPickerBuilder CupertinoPicker() {
    return CupertinoPickerCupertinoPickerBuilder.cupertinoPickerCupertinoPicker();
  }
  public static CupertinoPickerBuilderBuilder CupertinoPicker_builder() {
    return CupertinoPickerBuilderBuilder.cupertinoPickerBuilder();
  }

  public static CupertinoAlertDialogCupertinoAlertDialogBuilder CupertinoAlertDialog() {
    return CupertinoAlertDialogCupertinoAlertDialogBuilder.cupertinoAlertDialogCupertinoAlertDialog();
  }

  public static CupertinoActionSheetCupertinoActionSheetBuilder CupertinoActionSheet() {
    return CupertinoActionSheetCupertinoActionSheetBuilder.cupertinoActionSheetCupertinoActionSheet();
  }

  public static CupertinoDialogActionCupertinoDialogActionBuilder CupertinoDialogAction() {
    return CupertinoDialogActionCupertinoDialogActionBuilder.cupertinoDialogActionCupertinoDialogAction();
  }

  public static CupertinoActionSheetActionCupertinoActionSheetActionBuilder CupertinoActionSheetAction(Runnable onPressed) {
    return CupertinoActionSheetActionCupertinoActionSheetActionBuilder.cupertinoActionSheetActionCupertinoActionSheetAction(onPressed);
  }

  public static CupertinoTextFieldCupertinoTextFieldBuilder CupertinoTextField() {
    return CupertinoTextFieldCupertinoTextFieldBuilder.cupertinoTextFieldCupertinoTextField();
  }
  public static CupertinoTextFieldBorderlessBuilder CupertinoTextField_borderless() {
    return CupertinoTextFieldBorderlessBuilder.cupertinoTextFieldBorderless();
  }

  public static CupertinoCheckboxCupertinoCheckboxBuilder CupertinoCheckbox(boolean value) {
    return CupertinoCheckboxCupertinoCheckboxBuilder.cupertinoCheckboxCupertinoCheckbox(value);
  }

  public static CupertinoExpansionTileCupertinoExpansionTileBuilder CupertinoExpansionTile(WidgetI title, WidgetI child) {
    return CupertinoExpansionTileCupertinoExpansionTileBuilder.cupertinoExpansionTileCupertinoExpansionTile(title, child);
  }

  public static CupertinoTimerPickerCupertinoTimerPickerBuilder CupertinoTimerPicker() {
    return CupertinoTimerPickerCupertinoTimerPickerBuilder.cupertinoTimerPickerCupertinoTimerPicker();
  }

  public static CupertinoNavigationBarBackButtonCupertinoNavigationBarBackButtonBuilder CupertinoNavigationBarBackButton() {
    return CupertinoNavigationBarBackButtonCupertinoNavigationBarBackButtonBuilder.cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton();
  }

  public static CupertinoTabBarCupertinoTabBarBuilder CupertinoTabBar(List<BottomNavigationBarItemI> items) {
    return CupertinoTabBarCupertinoTabBarBuilder.cupertinoTabBarCupertinoTabBar(items);
  }

  public static BottomNavigationBarItemBottomNavigationBarItemBuilder BottomNavigationBarItem(WidgetI icon) {
    return BottomNavigationBarItemBottomNavigationBarItemBuilder.bottomNavigationBarItemBottomNavigationBarItem(icon);
  }

  public static CupertinoTabScaffoldCupertinoTabScaffoldBuilder CupertinoTabScaffold(CupertinoTabBarI tabBar, BiFunction<BuildContext, Integer, Widget> tabBuilder) {
    return CupertinoTabScaffoldCupertinoTabScaffoldBuilder.cupertinoTabScaffoldCupertinoTabScaffold(tabBar, tabBuilder);
  }

  public static CupertinoContextMenuCupertinoContextMenuBuilder CupertinoContextMenu(List<WidgetI> actions, WidgetI child) {
    return CupertinoContextMenuCupertinoContextMenuBuilder.cupertinoContextMenuCupertinoContextMenu(actions, child);
  }
  public static CupertinoContextMenuBuilderBuilder CupertinoContextMenu_builder(List<WidgetI> actions, BiFunction<BuildContext, Animation, Widget> builder) {
    return CupertinoContextMenuBuilderBuilder.cupertinoContextMenuBuilder(actions, builder);
  }

  public static CupertinoContextMenuActionCupertinoContextMenuActionBuilder CupertinoContextMenuAction(WidgetI child) {
    return CupertinoContextMenuActionCupertinoContextMenuActionBuilder.cupertinoContextMenuActionCupertinoContextMenuAction(child);
  }

  /** Creates an {@code Animation<Offset>} that interpolates from {@code begin} to {@code end}
   *  driven by {@code parent}. Web-only; see {@link OffsetAnimation}. */
  public static OffsetAnimation OffsetTween(OffsetI begin, OffsetI end, AnimationI parent) {
    return OffsetAnimation.create(begin.build(), end.build(), parent.build());
  }
}
