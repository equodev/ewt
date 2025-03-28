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
  static ThemeData themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> indicatorColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<NativeObj> cardTheme, Optional<NativeObj> dialogTheme, Optional<NativeObj> tabBarTheme, Optional<Color> dialogBackgroundColor) {
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
  static ThemeData themeDataFrom(@Builder.Parameter ColorScheme colorScheme, Optional<Boolean> useMaterial3) {
    var st = factories.themeDataFrom(colorScheme,
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
    boolean fld = intToBool(ThemeDataObjSt.applyElevationOverlayColor(st));
    return fld;
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    MaterialTapTargetSize fld = MaterialTapTargetSize.values()[ThemeDataObjSt.materialTapTargetSize(st)];
    return fld;
  }
  public TargetPlatform platform() {
    TargetPlatform fld = TargetPlatform.values()[ThemeDataObjSt.platform(st)];
    return fld;
  }
  public boolean useMaterial3() {
    boolean fld = intToBool(ThemeDataObjSt.useMaterial3(st));
    return fld;
  }
  public Color canvasColor() {
    Color fld = new Color(ThemeDataObjSt.canvasColor(st)) {};
    return fld;
  }
  public Color cardColor() {
    Color fld = new Color(ThemeDataObjSt.cardColor(st)) {};
    return fld;
  }
  public ColorScheme colorScheme() {
    ColorScheme fld = new ColorScheme(ThemeDataObjSt.colorScheme(st)) {};
    return fld;
  }
  public Color disabledColor() {
    Color fld = new Color(ThemeDataObjSt.disabledColor(st)) {};
    return fld;
  }
  public Color dividerColor() {
    Color fld = new Color(ThemeDataObjSt.dividerColor(st)) {};
    return fld;
  }
  public Color focusColor() {
    Color fld = new Color(ThemeDataObjSt.focusColor(st)) {};
    return fld;
  }
  public Color highlightColor() {
    Color fld = new Color(ThemeDataObjSt.highlightColor(st)) {};
    return fld;
  }
  public Color hintColor() {
    Color fld = new Color(ThemeDataObjSt.hintColor(st)) {};
    return fld;
  }
  public Color hoverColor() {
    Color fld = new Color(ThemeDataObjSt.hoverColor(st)) {};
    return fld;
  }
  public Color indicatorColor() {
    Color fld = new Color(ThemeDataObjSt.indicatorColor(st)) {};
    return fld;
  }
  public Color primaryColor() {
    Color fld = new Color(ThemeDataObjSt.primaryColor(st)) {};
    return fld;
  }
  public Color primaryColorDark() {
    Color fld = new Color(ThemeDataObjSt.primaryColorDark(st)) {};
    return fld;
  }
  public Color primaryColorLight() {
    Color fld = new Color(ThemeDataObjSt.primaryColorLight(st)) {};
    return fld;
  }
  public Color scaffoldBackgroundColor() {
    Color fld = new Color(ThemeDataObjSt.scaffoldBackgroundColor(st)) {};
    return fld;
  }
  public Color secondaryHeaderColor() {
    Color fld = new Color(ThemeDataObjSt.secondaryHeaderColor(st)) {};
    return fld;
  }
  public Color shadowColor() {
    Color fld = new Color(ThemeDataObjSt.shadowColor(st)) {};
    return fld;
  }
  public Color splashColor() {
    Color fld = new Color(ThemeDataObjSt.splashColor(st)) {};
    return fld;
  }
  public Color unselectedWidgetColor() {
    Color fld = new Color(ThemeDataObjSt.unselectedWidgetColor(st)) {};
    return fld;
  }
  public Color dialogBackgroundColor() {
    Color fld = new Color(ThemeDataObjSt.dialogBackgroundColor(st)) {};
    return fld;
  }
  public Brightness brightness() {
    Brightness fld = Brightness.values()[ThemeDataObjSt.brightness(st)];
    return fld;
  }
}
