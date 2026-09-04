package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    System.out.println("New ThemeData id:"+id);
  }
  ThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ThemeData themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<NoDefaultCupertinoThemeDataI> cupertinoOverrideTheme, Optional<NativeObj.I> inputDecorationTheme, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<Boolean> useSystemColors, Optional<VisualDensityI> visualDensity, Optional<ColorSchemeI> colorScheme, Optional<Brightness> brightness, Optional<ColorI> colorSchemeSeed, Optional<ColorI> canvasColor, Optional<ColorI> cardColor, Optional<ColorI> disabledColor, Optional<ColorI> dividerColor, Optional<ColorI> focusColor, Optional<ColorI> highlightColor, Optional<ColorI> hintColor, Optional<ColorI> hoverColor, Optional<ColorI> primaryColor, Optional<ColorI> primaryColorDark, Optional<ColorI> primaryColorLight, Optional<MaterialColorI> primarySwatch, Optional<ColorI> scaffoldBackgroundColor, Optional<ColorI> secondaryHeaderColor, Optional<ColorI> shadowColor, Optional<ColorI> splashColor, Optional<ColorI> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> primaryIconTheme, Optional<TextThemeI> primaryTextTheme, Optional<TextThemeI> textTheme, Optional<NativeObj.I> appBarTheme, Optional<BadgeThemeDataI> badgeTheme, Optional<CardThemeDataI> cardTheme, Optional<CheckboxThemeDataI> checkboxTheme, Optional<ChipThemeDataI> chipTheme, Optional<DialogThemeDataI> dialogTheme, Optional<DividerThemeDataI> dividerTheme, Optional<MenuBarThemeDataI> menuBarTheme, Optional<MenuThemeDataI> menuTheme, Optional<PopupMenuThemeDataI> popupMenuTheme, Optional<RadioThemeDataI> radioTheme, Optional<SliderThemeDataI> sliderTheme, Optional<SnackBarThemeDataI> snackBarTheme, Optional<SwitchThemeDataI> switchTheme, Optional<TabBarThemeDataI> tabBarTheme, Optional<TooltipThemeDataI> tooltipTheme, Optional<ColorI> dialogBackgroundColor, Optional<ColorI> indicatorColor) {
    var st = factories.themeDataThemeData(applyElevationOverlayColor,
      cupertinoOverrideTheme.map(NoDefaultCupertinoThemeDataI::build),
      inputDecorationTheme.map(NativeObj.I::build),
      materialTapTargetSize,
      platform,
      useMaterial3,
      useSystemColors,
      visualDensity.map(VisualDensityI::build),
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
      iconTheme.map(IconThemeDataI::build),
      primaryIconTheme.map(IconThemeDataI::build),
      primaryTextTheme.map(TextThemeI::build),
      textTheme.map(TextThemeI::build),
      appBarTheme.map(NativeObj.I::build),
      badgeTheme.map(BadgeThemeDataI::build),
      cardTheme.map(CardThemeDataI::build),
      checkboxTheme.map(CheckboxThemeDataI::build),
      chipTheme.map(ChipThemeDataI::build),
      dialogTheme.map(DialogThemeDataI::build),
      dividerTheme.map(DividerThemeDataI::build),
      menuBarTheme.map(MenuBarThemeDataI::build),
      menuTheme.map(MenuThemeDataI::build),
      popupMenuTheme.map(PopupMenuThemeDataI::build),
      radioTheme.map(RadioThemeDataI::build),
      sliderTheme.map(SliderThemeDataI::build),
      snackBarTheme.map(SnackBarThemeDataI::build),
      switchTheme.map(SwitchThemeDataI::build),
      tabBarTheme.map(TabBarThemeDataI::build),
      tooltipTheme.map(TooltipThemeDataI::build),
      dialogBackgroundColor.map(ColorI::build),
      indicatorColor.map(ColorI::build));
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Brightness");
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataApplyElevationOverlayColor not supported on web");
    return intToBool(ThemeDataObjSt.applyElevationOverlayColor(st));
  }
  public NoDefaultCupertinoThemeData cupertinoOverrideTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCupertinoOverrideTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.NoDefaultCupertinoThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.NoDefaultCupertinoThemeDataObjSt.id(__st, __nid);
      return new NoDefaultCupertinoThemeData(__st);
    }
    return new NoDefaultCupertinoThemeData(ThemeDataObjSt.cupertinoOverrideTheme(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[ThemeDataObjSt.materialTapTargetSize(st)];
  }
  public TargetPlatform platform() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataPlatform not supported on web");
    return TargetPlatform.values()[ThemeDataObjSt.platform(st)];
  }
  public boolean useMaterial3() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataUseMaterial3 not supported on web");
    return intToBool(ThemeDataObjSt.useMaterial3(st));
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(ThemeDataObjSt.visualDensity(st));
  }
  public Color canvasColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCanvasColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.canvasColor(st));
  }
  public Color cardColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCardColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.cardColor(st));
  }
  public ColorScheme colorScheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataColorScheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ColorSchemeObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ColorSchemeObjSt.id(__st, __nid);
      return new ColorScheme(__st);
    }
    return new ColorScheme(ThemeDataObjSt.colorScheme(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.disabledColor(st));
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.dividerColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.focusColor(st));
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataHighlightColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.highlightColor(st));
  }
  public Color hintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataHintColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.hintColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.hoverColor(st));
  }
  public Color primaryColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.primaryColor(st));
  }
  public Color primaryColorDark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryColorDark", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.primaryColorDark(st));
  }
  public Color primaryColorLight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryColorLight", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.primaryColorLight(st));
  }
  public Color scaffoldBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.scaffoldBackgroundColor(st));
  }
  public Color secondaryHeaderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSecondaryHeaderColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.secondaryHeaderColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.shadowColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.splashColor(st));
  }
  public Color unselectedWidgetColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataUnselectedWidgetColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.unselectedWidgetColor(st));
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(ThemeDataObjSt.iconTheme(st));
  }
  public IconThemeData primaryIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(ThemeDataObjSt.primaryIconTheme(st));
  }
  public TextTheme primaryTextTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryTextTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextThemeObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextThemeObjSt.id(__st, __nid);
      return new TextTheme(__st);
    }
    return new TextTheme(ThemeDataObjSt.primaryTextTheme(st));
  }
  public TextTheme textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTextTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextThemeObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextThemeObjSt.id(__st, __nid);
      return new TextTheme(__st);
    }
    return new TextTheme(ThemeDataObjSt.textTheme(st));
  }
  public BadgeThemeData badgeTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataBadgeTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BadgeThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BadgeThemeDataObjSt.id(__st, __nid);
      return new BadgeThemeData(__st);
    }
    return new BadgeThemeData(ThemeDataObjSt.badgeTheme(st));
  }
  public CardThemeData cardTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCardTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.CardThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.CardThemeDataObjSt.id(__st, __nid);
      return new CardThemeData(__st);
    }
    return new CardThemeData(ThemeDataObjSt.cardTheme(st));
  }
  public CheckboxThemeData checkboxTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCheckboxTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.CheckboxThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.CheckboxThemeDataObjSt.id(__st, __nid);
      return new CheckboxThemeData(__st);
    }
    return new CheckboxThemeData(ThemeDataObjSt.checkboxTheme(st));
  }
  public ChipThemeData chipTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataChipTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ChipThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ChipThemeDataObjSt.id(__st, __nid);
      return new ChipThemeData(__st);
    }
    return new ChipThemeData(ThemeDataObjSt.chipTheme(st));
  }
  public DialogThemeData dialogTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDialogTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.DialogThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.DialogThemeDataObjSt.id(__st, __nid);
      return new DialogThemeData(__st);
    }
    return new DialogThemeData(ThemeDataObjSt.dialogTheme(st));
  }
  public DividerThemeData dividerTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDividerTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.DividerThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.DividerThemeDataObjSt.id(__st, __nid);
      return new DividerThemeData(__st);
    }
    return new DividerThemeData(ThemeDataObjSt.dividerTheme(st));
  }
  public MenuBarThemeData menuBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataMenuBarTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.MenuBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.MenuBarThemeDataObjSt.id(__st, __nid);
      return new MenuBarThemeData(__st);
    }
    return new MenuBarThemeData(ThemeDataObjSt.menuBarTheme(st));
  }
  public MenuThemeData menuTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataMenuTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.MenuThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.MenuThemeDataObjSt.id(__st, __nid);
      return new MenuThemeData(__st);
    }
    return new MenuThemeData(ThemeDataObjSt.menuTheme(st));
  }
  public PopupMenuThemeData popupMenuTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPopupMenuTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.PopupMenuThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.PopupMenuThemeDataObjSt.id(__st, __nid);
      return new PopupMenuThemeData(__st);
    }
    return new PopupMenuThemeData(ThemeDataObjSt.popupMenuTheme(st));
  }
  public RadioThemeData radioTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataRadioTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.RadioThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.RadioThemeDataObjSt.id(__st, __nid);
      return new RadioThemeData(__st);
    }
    return new RadioThemeData(ThemeDataObjSt.radioTheme(st));
  }
  public SliderThemeData sliderTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSliderTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SliderThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SliderThemeDataObjSt.id(__st, __nid);
      return new SliderThemeData(__st);
    }
    return new SliderThemeData(ThemeDataObjSt.sliderTheme(st));
  }
  public SnackBarThemeData snackBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSnackBarTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SnackBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SnackBarThemeDataObjSt.id(__st, __nid);
      return new SnackBarThemeData(__st);
    }
    return new SnackBarThemeData(ThemeDataObjSt.snackBarTheme(st));
  }
  public SwitchThemeData switchTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSwitchTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SwitchThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SwitchThemeDataObjSt.id(__st, __nid);
      return new SwitchThemeData(__st);
    }
    return new SwitchThemeData(ThemeDataObjSt.switchTheme(st));
  }
  public TabBarThemeData tabBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTabBarTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TabBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TabBarThemeDataObjSt.id(__st, __nid);
      return new TabBarThemeData(__st);
    }
    return new TabBarThemeData(ThemeDataObjSt.tabBarTheme(st));
  }
  public TooltipThemeData tooltipTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTooltipTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TooltipThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TooltipThemeDataObjSt.id(__st, __nid);
      return new TooltipThemeData(__st);
    }
    return new TooltipThemeData(ThemeDataObjSt.tooltipTheme(st));
  }
  public Color dialogBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDialogBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.dialogBackgroundColor(st));
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(ThemeDataObjSt.indicatorColor(st));
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataBrightness not supported on web");
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
