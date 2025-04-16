package dev.equo.ewt;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.Function;
public class EWT {
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

  public static TextTextBuilder Text(String data) {
    return TextTextBuilder.textText(data);
  }
  public static TextRichBuilder Text_rich(InlineSpanI textSpan) {
    return TextRichBuilder.textRich(textSpan);
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

  public static IconDataIconDataBuilder IconData(int codePoint) {
    return IconDataIconDataBuilder.iconDataIconData(codePoint);
  }

  public static IconIconBuilder Icon(IconDataI icon) {
    return IconIconBuilder.iconIcon(icon);
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

  public static OffsetOffsetBuilder Offset(double dx, double dy) {
    return OffsetOffsetBuilder.offsetOffset(dx, dy);
  }
  public static OffsetFromDirectionBuilder Offset_fromDirection(double direction) {
    return OffsetFromDirectionBuilder.offsetFromDirection(direction);
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

  public static BoxShadowBoxShadowBuilder BoxShadow() {
    return BoxShadowBoxShadowBuilder.boxShadowBoxShadow();
  }

  public static ShadowShadowBuilder Shadow() {
    return ShadowShadowBuilder.shadowShadow();
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

  public static AnimationControllerAnimationControllerBuilder AnimationController() {
    return AnimationControllerAnimationControllerBuilder.animationControllerAnimationController();
  }
  public static AnimationControllerUnboundedBuilder AnimationController_unbounded() {
    return AnimationControllerUnboundedBuilder.animationControllerUnbounded();
  }

  public static AnimatedBuilderAnimatedBuilderBuilder AnimatedBuilder(ListenableI animation, BiFunction<BuildContext, Widget, Widget> builder) {
    return AnimatedBuilderAnimatedBuilderBuilder.animatedBuilderAnimatedBuilder(animation, builder);
  }

  public static ListenableBuilderListenableBuilderBuilder ListenableBuilder(ListenableI listenable, BiFunction<BuildContext, Widget, Widget> builder) {
    return ListenableBuilderListenableBuilderBuilder.listenableBuilderListenableBuilder(listenable, builder);
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




}
