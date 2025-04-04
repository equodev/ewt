package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ThemeData extends NativeObj.Base implements ThemeDataI {
  private MemorySegment st;
  protected ThemeData() {}
  ThemeData(MemorySegment st) {
    this.id = ThemeDataObjSt.id(st);
    this.st = st;
    System.out.println("New ThemeData id:"+id);
  }
  @Builder.Factory
  static ThemeData themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<ColorSchemeI> colorScheme, Optional<Brightness> brightness, Optional<ColorI> colorSchemeSeed, Optional<ColorI> canvasColor, Optional<ColorI> cardColor, Optional<ColorI> disabledColor, Optional<ColorI> dividerColor, Optional<ColorI> focusColor, Optional<ColorI> highlightColor, Optional<ColorI> hintColor, Optional<ColorI> hoverColor, Optional<ColorI> indicatorColor, Optional<ColorI> primaryColor, Optional<ColorI> primaryColorDark, Optional<ColorI> primaryColorLight, Optional<MaterialColorI> primarySwatch, Optional<ColorI> scaffoldBackgroundColor, Optional<ColorI> secondaryHeaderColor, Optional<ColorI> shadowColor, Optional<ColorI> splashColor, Optional<ColorI> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextThemeI> primaryTextTheme, Optional<TextThemeI> textTheme, Optional<NativeObj.I> cardTheme, Optional<NativeObj.I> dialogTheme, Optional<NativeObj.I> tabBarTheme, Optional<ColorI> dialogBackgroundColor) {
    var st = factories.themeDataThemeData(applyElevationOverlayColor,
      materialTapTargetSize,
      platform,
      useMaterial3,
      colorScheme.map(ColorSchemeI::build),
      brightness,
      colorSchemeSeed.map(ColorI::build),
      canvasColor.map(ColorI::build),
      cardColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      dividerColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      hintColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      indicatorColor.map(ColorI::build),
      primaryColor.map(ColorI::build),
      primaryColorDark.map(ColorI::build),
      primaryColorLight.map(ColorI::build),
      primarySwatch.map(MaterialColorI::build),
      scaffoldBackgroundColor.map(ColorI::build),
      secondaryHeaderColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      unselectedWidgetColor.map(ColorI::build),
      fontFamily,
      fontFamilyFallback,
      _package,
      primaryTextTheme.map(TextThemeI::build),
      textTheme.map(TextThemeI::build),
      cardTheme.map(NativeObj.I::build),
      dialogTheme.map(NativeObj.I::build),
      tabBarTheme.map(NativeObj.I::build),
      dialogBackgroundColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static ThemeDataThemeDataBuilder themeData() {
    return ThemeDataThemeDataBuilder.themeDataThemeData();
  }
  @Builder.Factory
  static ThemeData themeDataFrom(@Builder.Parameter ColorSchemeI colorScheme, Optional<TextThemeI> textTheme, Optional<Boolean> useMaterial3) {
    var st = factories.themeDataFrom(colorScheme.build(),
      textTheme.map(TextThemeI::build),
      useMaterial3);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static ThemeDataFromBuilder from(ColorSchemeI colorScheme) {
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
  public static ThemeData localize(ThemeDataI baseTheme, TextThemeI localTextGeometry) {
    var st = factories.themeDataLocalize(baseTheme.build(),
      localTextGeometry.build());
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static Brightness estimateBrightnessForColor(ColorI color) {
    int id = factories.themeDataEstimateBrightnessForColor(color.build());
    if (id == -1) throw new RuntimeException("Failed to created widget Brightness");
    System.out.println("New Brightness id:"+id);
    return Brightness.values()[id];
  }
  public static ThemeData lerp(ThemeDataI a, ThemeDataI b, double t) {
    var st = factories.themeDataLerp(a.build(),
      b.build(),
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
  private static int _localizedThemeDataCacheSize() {
    return 5;
  }
  @Override
  public ThemeData build() {
    return this;
  }
}
