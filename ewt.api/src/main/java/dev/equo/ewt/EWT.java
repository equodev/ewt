package dev.equo.ewt;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
public class EWT {
  public static TextTextBuilder Text(String data) {
    return TextTextBuilder.textText(data);
  }
  public static TextRichBuilder Text_rich(InlineSpan textSpan) {
    return TextRichBuilder.textRich(textSpan);
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

  public static ThemeDataThemeDataBuilder ThemeData() {
    return ThemeDataThemeDataBuilder.themeDataThemeData();
  }
  public static ThemeDataFromBuilder ThemeData_from(ColorScheme colorScheme) {
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

  public static ColorSchemeColorSchemeBuilder ColorScheme(Brightness brightness, Color primary, Color onPrimary) {
    return ColorSchemeColorSchemeBuilder.colorSchemeColorScheme(brightness, primary, onPrimary);
  }
  public static ColorSchemeFromSeedBuilder ColorScheme_fromSeed(Color seedColor) {
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

  public static IconDataIconDataBuilder IconData(int codePoint) {
    return IconDataIconDataBuilder.iconDataIconData(codePoint);
  }

  public static IconIconBuilder Icon(IconData icon) {
    return IconIconBuilder.iconIcon(icon);
  }



}
