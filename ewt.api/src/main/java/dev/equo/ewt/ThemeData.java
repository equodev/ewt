package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ThemeData extends NativeObj.Base {
  private MemorySegment st;
  ThemeData(MemorySegment st) {
    this.id = ThemeDataObjSt.id(st);
    this.st = st;
    System.out.println("New ThemeData id:"+id);
  }
  @Builder.Factory
  static ThemeData themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> indicatorColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextTheme> primaryTextTheme, Optional<TextTheme> textTheme, Optional<NativeObj> cardTheme, Optional<NativeObj> dialogTheme, Optional<NativeObj> tabBarTheme, Optional<Color> dialogBackgroundColor) {
    var st = factories.themeDataThemeData(applyElevationOverlayColor,
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
      primaryTextTheme,
      textTheme,
      cardTheme,
      dialogTheme,
      tabBarTheme,
      dialogBackgroundColor);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static ThemeDataThemeDataBuilder themeData() {
    return ThemeDataThemeDataBuilder.themeDataThemeData();
  }
  @Builder.Factory
  static ThemeData themeDataFrom(@Builder.Parameter ColorScheme colorScheme, Optional<TextTheme> textTheme, Optional<Boolean> useMaterial3) {
    var st = factories.themeDataFrom(colorScheme,
      textTheme,
      useMaterial3);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static ThemeDataFromBuilder from(ColorScheme colorScheme) {
    return ThemeDataFromBuilder.themeDataFrom(colorScheme);
  }
  @Builder.Factory
  static ThemeData themeDataLight(Optional<Boolean> useMaterial3) {
    var st = factories.themeDataLight(useMaterial3);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static ThemeDataLightBuilder light() {
    return ThemeDataLightBuilder.themeDataLight();
  }
  @Builder.Factory
  static ThemeData themeDataDark(Optional<Boolean> useMaterial3) {
    var st = factories.themeDataDark(useMaterial3);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static ThemeDataDarkBuilder dark() {
    return ThemeDataDarkBuilder.themeDataDark();
  }
  @Builder.Factory
  static ThemeData themeDataFallback(Optional<Boolean> useMaterial3) {
    var st = factories.themeDataFallback(useMaterial3);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static ThemeDataFallbackBuilder fallback() {
    return ThemeDataFallbackBuilder.themeDataFallback();
  }
  public static ThemeData localize(ThemeData baseTheme, TextTheme localTextGeometry) {
    var st = factories.themeDataLocalize(baseTheme,
      localTextGeometry);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static Brightness estimateBrightnessForColor(Color color) {
    int id = factories.themeDataEstimateBrightnessForColor(color);
    if (id == -1) throw new RuntimeException("Failed to created widget Brightness");
    System.out.println("New Brightness id:"+id);
    return Brightness.values()[id];
  }
  public static ThemeData lerp(ThemeData a, ThemeData b, double t) {
    var st = factories.themeDataLerp(a,
      b,
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public boolean applyElevationOverlayColor() {
    return intToBool(ThemeDataObjSt.applyElevationOverlayColor(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    return MaterialTapTargetSize.values()[ThemeDataObjSt.materialTapTargetSize(st)];
  }
  public TargetPlatform platform() {
    return TargetPlatform.values()[ThemeDataObjSt.platform(st)];
  }
  public boolean useMaterial3() {
    return intToBool(ThemeDataObjSt.useMaterial3(st));
  }
  public Color canvasColor() {
    return new Color(ThemeDataObjSt.canvasColor(st)) {};
  }
  public Color cardColor() {
    return new Color(ThemeDataObjSt.cardColor(st)) {};
  }
  public ColorScheme colorScheme() {
    return new ColorScheme(ThemeDataObjSt.colorScheme(st)) {};
  }
  public Color disabledColor() {
    return new Color(ThemeDataObjSt.disabledColor(st)) {};
  }
  public Color dividerColor() {
    return new Color(ThemeDataObjSt.dividerColor(st)) {};
  }
  public Color focusColor() {
    return new Color(ThemeDataObjSt.focusColor(st)) {};
  }
  public Color highlightColor() {
    return new Color(ThemeDataObjSt.highlightColor(st)) {};
  }
  public Color hintColor() {
    return new Color(ThemeDataObjSt.hintColor(st)) {};
  }
  public Color hoverColor() {
    return new Color(ThemeDataObjSt.hoverColor(st)) {};
  }
  public Color indicatorColor() {
    return new Color(ThemeDataObjSt.indicatorColor(st)) {};
  }
  public Color primaryColor() {
    return new Color(ThemeDataObjSt.primaryColor(st)) {};
  }
  public Color primaryColorDark() {
    return new Color(ThemeDataObjSt.primaryColorDark(st)) {};
  }
  public Color primaryColorLight() {
    return new Color(ThemeDataObjSt.primaryColorLight(st)) {};
  }
  public Color scaffoldBackgroundColor() {
    return new Color(ThemeDataObjSt.scaffoldBackgroundColor(st)) {};
  }
  public Color secondaryHeaderColor() {
    return new Color(ThemeDataObjSt.secondaryHeaderColor(st)) {};
  }
  public Color shadowColor() {
    return new Color(ThemeDataObjSt.shadowColor(st)) {};
  }
  public Color splashColor() {
    return new Color(ThemeDataObjSt.splashColor(st)) {};
  }
  public Color unselectedWidgetColor() {
    return new Color(ThemeDataObjSt.unselectedWidgetColor(st)) {};
  }
  public TextTheme primaryTextTheme() {
    return new TextTheme(ThemeDataObjSt.primaryTextTheme(st)) {};
  }
  public TextTheme textTheme() {
    return new TextTheme(ThemeDataObjSt.textTheme(st)) {};
  }
  public Color dialogBackgroundColor() {
    return new Color(ThemeDataObjSt.dialogBackgroundColor(st)) {};
  }
  public Brightness brightness() {
    return Brightness.values()[ThemeDataObjSt.brightness(st)];
  }
}
