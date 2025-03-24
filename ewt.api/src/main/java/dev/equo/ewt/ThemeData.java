package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class ThemeData extends NativeObj.Base {
  ThemeData() {}
  ThemeData(int id) {
    this.id = id;
  }
  @Builder.Factory
  static ThemeData themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> indicatorColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<NativeObj> cardTheme, Optional<NativeObj> dialogTheme, Optional<NativeObj> tabBarTheme, Optional<Color> dialogBackgroundColor) {
    int id = factories.themeDataThemeData(applyElevationOverlayColor,
      materialTapTargetSize,
      platform,
      useMaterial3,
      colorScheme,
      brightness,
      colorSchemeSeed,
      canvasColor,
      cardColor,
      disabledColor,
      dividerColor,
      focusColor,
      highlightColor,
      hintColor,
      hoverColor,
      indicatorColor,
      primaryColor,
      primaryColorDark,
      primaryColorLight,
      scaffoldBackgroundColor,
      secondaryHeaderColor,
      shadowColor,
      splashColor,
      unselectedWidgetColor,
      fontFamily,
      fontFamilyFallback,
      _package,
      cardTheme,
      dialogTheme,
      tabBarTheme,
      dialogBackgroundColor);
    if (id == -1) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
    return new ThemeData(id);
  }
  public static ThemeDataThemeDataBuilder themeData() {
    return ThemeDataThemeDataBuilder.themeDataThemeData();
  }
  @Builder.Factory
  static ThemeData themeDataFrom(@Builder.Parameter ColorScheme colorScheme, Optional<Boolean> useMaterial3) {
    int id = factories.themeDataFrom(colorScheme,
      useMaterial3);
    if (id == -1) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
    return new ThemeData(id);
  }
  public static ThemeDataFromBuilder from(ColorScheme colorScheme) {
    return ThemeDataFromBuilder.themeDataFrom(colorScheme);
  }
  @Builder.Factory
  static ThemeData themeDataLight(Optional<Boolean> useMaterial3) {
    int id = factories.themeDataLight(useMaterial3);
    if (id == -1) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
    return new ThemeData(id);
  }
  public static ThemeDataLightBuilder light() {
    return ThemeDataLightBuilder.themeDataLight();
  }
  @Builder.Factory
  static ThemeData themeDataDark(Optional<Boolean> useMaterial3) {
    int id = factories.themeDataDark(useMaterial3);
    if (id == -1) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
    return new ThemeData(id);
  }
  public static ThemeDataDarkBuilder dark() {
    return ThemeDataDarkBuilder.themeDataDark();
  }
  @Builder.Factory
  static ThemeData themeDataFallback(Optional<Boolean> useMaterial3) {
    int id = factories.themeDataFallback(useMaterial3);
    if (id == -1) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
    return new ThemeData(id);
  }
  public static ThemeDataFallbackBuilder fallback() {
    return ThemeDataFallbackBuilder.themeDataFallback();
  }
  @Builder.Factory
  static ThemeData themeDataEstimateBrightnessForColor(@Builder.Parameter Color color) {
    int id = factories.themeDataEstimateBrightnessForColor(color);
    if (id == -1) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
    return new ThemeData(id);
  }
  public static ThemeDataEstimateBrightnessForColorBuilder estimateBrightnessForColor(Color color) {
    return ThemeDataEstimateBrightnessForColorBuilder.themeDataEstimateBrightnessForColor(color);
  }
  @Builder.Factory
  static ThemeData themeDataLerp(@Builder.Parameter ThemeData a, @Builder.Parameter ThemeData b, @Builder.Parameter double t) {
    int id = factories.themeDataLerp(a,
      b,
      t);
    if (id == -1) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
    return new ThemeData(id);
  }
  public static ThemeDataLerpBuilder lerp(ThemeData a, ThemeData b, double t) {
    return ThemeDataLerpBuilder.themeDataLerp(a, b, t);
  }
}
