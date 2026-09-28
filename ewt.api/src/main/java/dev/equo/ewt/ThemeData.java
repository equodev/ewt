package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ThemeData extends NativeObj.Base implements ThemeDataI {
  protected ThemeData() {}
  ThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ThemeData themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<NoDefaultCupertinoThemeDataI> cupertinoOverrideTheme, Optional<NativeObj.I> inputDecorationTheme, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<Boolean> useSystemColors, Optional<VisualDensityI> visualDensity, Optional<ColorSchemeI> colorScheme, Optional<Brightness> brightness, Optional<ColorI> colorSchemeSeed, Optional<ColorI> canvasColor, Optional<ColorI> cardColor, Optional<ColorI> disabledColor, Optional<ColorI> dividerColor, Optional<ColorI> focusColor, Optional<ColorI> highlightColor, Optional<ColorI> hintColor, Optional<ColorI> hoverColor, Optional<ColorI> primaryColor, Optional<ColorI> primaryColorDark, Optional<ColorI> primaryColorLight, Optional<MaterialColorI> primarySwatch, Optional<ColorI> scaffoldBackgroundColor, Optional<ColorI> secondaryHeaderColor, Optional<ColorI> shadowColor, Optional<ColorI> splashColor, Optional<ColorI> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<IconThemeDataI> iconTheme, Optional<IconThemeDataI> primaryIconTheme, Optional<TextThemeI> primaryTextTheme, Optional<TextThemeI> textTheme, Optional<ActionIconThemeDataI> actionIconTheme, Optional<NativeObj.I> appBarTheme, Optional<BadgeThemeDataI> badgeTheme, Optional<BottomAppBarThemeDataI> bottomAppBarTheme, Optional<BottomNavigationBarThemeDataI> bottomNavigationBarTheme, Optional<BottomSheetThemeDataI> bottomSheetTheme, Optional<ButtonThemeDataI> buttonTheme, Optional<CardThemeDataI> cardTheme, Optional<CarouselViewThemeDataI> carouselViewTheme, Optional<CheckboxThemeDataI> checkboxTheme, Optional<ChipThemeDataI> chipTheme, Optional<DataTableThemeDataI> dataTableTheme, Optional<DatePickerThemeDataI> datePickerTheme, Optional<DialogThemeDataI> dialogTheme, Optional<DividerThemeDataI> dividerTheme, Optional<DrawerThemeDataI> drawerTheme, Optional<DropdownMenuThemeDataI> dropdownMenuTheme, Optional<ElevatedButtonThemeDataI> elevatedButtonTheme, Optional<ExpansionTileThemeDataI> expansionTileTheme, Optional<FilledButtonThemeDataI> filledButtonTheme, Optional<FloatingActionButtonThemeDataI> floatingActionButtonTheme, Optional<IconButtonThemeDataI> iconButtonTheme, Optional<MenuBarThemeDataI> menuBarTheme, Optional<MenuButtonThemeDataI> menuButtonTheme, Optional<MenuThemeDataI> menuTheme, Optional<NavigationBarThemeDataI> navigationBarTheme, Optional<NavigationDrawerThemeDataI> navigationDrawerTheme, Optional<NavigationRailThemeDataI> navigationRailTheme, Optional<OutlinedButtonThemeDataI> outlinedButtonTheme, Optional<PopupMenuThemeDataI> popupMenuTheme, Optional<ProgressIndicatorThemeDataI> progressIndicatorTheme, Optional<RadioThemeDataI> radioTheme, Optional<SearchBarThemeDataI> searchBarTheme, Optional<SearchViewThemeDataI> searchViewTheme, Optional<SegmentedButtonThemeDataI> segmentedButtonTheme, Optional<SliderThemeDataI> sliderTheme, Optional<SnackBarThemeDataI> snackBarTheme, Optional<SwitchThemeDataI> switchTheme, Optional<TabBarThemeDataI> tabBarTheme, Optional<TextButtonThemeDataI> textButtonTheme, Optional<TextSelectionThemeDataI> textSelectionTheme, Optional<TimePickerThemeDataI> timePickerTheme, Optional<ToggleButtonsThemeDataI> toggleButtonsTheme, Optional<TooltipThemeDataI> tooltipTheme, Optional<ColorI> dialogBackgroundColor, Optional<ColorI> indicatorColor) {
    int id = factories.themeDataThemeData(applyElevationOverlayColor,
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
      actionIconTheme.map(ActionIconThemeDataI::build),
      appBarTheme.map(NativeObj.I::build),
      badgeTheme.map(BadgeThemeDataI::build),
      bottomAppBarTheme.map(BottomAppBarThemeDataI::build),
      bottomNavigationBarTheme.map(BottomNavigationBarThemeDataI::build),
      bottomSheetTheme.map(BottomSheetThemeDataI::build),
      buttonTheme.map(ButtonThemeDataI::build),
      cardTheme.map(CardThemeDataI::build),
      carouselViewTheme.map(CarouselViewThemeDataI::build),
      checkboxTheme.map(CheckboxThemeDataI::build),
      chipTheme.map(ChipThemeDataI::build),
      dataTableTheme.map(DataTableThemeDataI::build),
      datePickerTheme.map(DatePickerThemeDataI::build),
      dialogTheme.map(DialogThemeDataI::build),
      dividerTheme.map(DividerThemeDataI::build),
      drawerTheme.map(DrawerThemeDataI::build),
      dropdownMenuTheme.map(DropdownMenuThemeDataI::build),
      elevatedButtonTheme.map(ElevatedButtonThemeDataI::build),
      expansionTileTheme.map(ExpansionTileThemeDataI::build),
      filledButtonTheme.map(FilledButtonThemeDataI::build),
      floatingActionButtonTheme.map(FloatingActionButtonThemeDataI::build),
      iconButtonTheme.map(IconButtonThemeDataI::build),
      menuBarTheme.map(MenuBarThemeDataI::build),
      menuButtonTheme.map(MenuButtonThemeDataI::build),
      menuTheme.map(MenuThemeDataI::build),
      navigationBarTheme.map(NavigationBarThemeDataI::build),
      navigationDrawerTheme.map(NavigationDrawerThemeDataI::build),
      navigationRailTheme.map(NavigationRailThemeDataI::build),
      outlinedButtonTheme.map(OutlinedButtonThemeDataI::build),
      popupMenuTheme.map(PopupMenuThemeDataI::build),
      progressIndicatorTheme.map(ProgressIndicatorThemeDataI::build),
      radioTheme.map(RadioThemeDataI::build),
      searchBarTheme.map(SearchBarThemeDataI::build),
      searchViewTheme.map(SearchViewThemeDataI::build),
      segmentedButtonTheme.map(SegmentedButtonThemeDataI::build),
      sliderTheme.map(SliderThemeDataI::build),
      snackBarTheme.map(SnackBarThemeDataI::build),
      switchTheme.map(SwitchThemeDataI::build),
      tabBarTheme.map(TabBarThemeDataI::build),
      textButtonTheme.map(TextButtonThemeDataI::build),
      textSelectionTheme.map(TextSelectionThemeDataI::build),
      timePickerTheme.map(TimePickerThemeDataI::build),
      toggleButtonsTheme.map(ToggleButtonsThemeDataI::build),
      tooltipTheme.map(TooltipThemeDataI::build),
      dialogBackgroundColor.map(ColorI::build),
      indicatorColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public static ThemeDataThemeDataBuilder themeData() {
    return ThemeDataThemeDataBuilder.themeDataThemeData();
  }
  @Builder.Factory
  static ThemeData themeDataFrom(@Builder.Parameter ColorSchemeI colorScheme, Optional<TextThemeI> textTheme, Optional<Boolean> useMaterial3) {
    int id = factories.themeDataFrom(colorScheme.build(),
      textTheme.map(TextThemeI::build),
      useMaterial3);
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public static ThemeDataFromBuilder from(ColorSchemeI colorScheme) {
    return ThemeDataFromBuilder.themeDataFrom(colorScheme);
  }
  @Builder.Factory
  static ThemeData themeDataLight(Optional<Boolean> useMaterial3) {
    int id = factories.themeDataLight(useMaterial3);
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public static ThemeDataLightBuilder light() {
    return ThemeDataLightBuilder.themeDataLight();
  }
  @Builder.Factory
  static ThemeData themeDataDark(Optional<Boolean> useMaterial3) {
    int id = factories.themeDataDark(useMaterial3);
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public static ThemeDataDarkBuilder dark() {
    return ThemeDataDarkBuilder.themeDataDark();
  }
  @Builder.Factory
  static ThemeData themeDataFallback(Optional<Boolean> useMaterial3) {
    int id = factories.themeDataFallback(useMaterial3);
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public static ThemeDataFallbackBuilder fallback() {
    return ThemeDataFallbackBuilder.themeDataFallback();
  }
  public static ThemeData localize(ThemeDataI baseTheme, TextThemeI localTextGeometry) {
    int id = factories.themeDataLocalize(baseTheme.build(),
      localTextGeometry.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public static Brightness estimateBrightnessForColor(ColorI color) {
    var id = factories.themeDataEstimateBrightnessForColor(color.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Brightness");
    System.out.println("New Brightness id:"+id);
    return Brightness.values()[id];
  }
  public static ThemeData lerp(ThemeDataI a, ThemeDataI b, double t) {
    int id = factories.themeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(id);
  }
  public boolean applyElevationOverlayColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataApplyElevationOverlayColor not supported on web");
    return factories.ThemeData_readBack_applyElevationOverlayColor(nativeStruct);
  }
  public NoDefaultCupertinoThemeData cupertinoOverrideTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCupertinoOverrideTheme", getId());
      return new NoDefaultCupertinoThemeData(__nid);
    }
    return factories.ThemeData_readBack_cupertinoOverrideTheme(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataMaterialTapTargetSize not supported on web");
    return factories.ThemeData_readBack_materialTapTargetSize(nativeStruct);
  }
  public TargetPlatform platform() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataPlatform not supported on web");
    return factories.ThemeData_readBack_platform(nativeStruct);
  }
  public boolean useMaterial3() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataUseMaterial3 not supported on web");
    return factories.ThemeData_readBack_useMaterial3(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.ThemeData_readBack_visualDensity(nativeStruct);
  }
  public Color canvasColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCanvasColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_canvasColor(nativeStruct);
  }
  public Color cardColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCardColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_cardColor(nativeStruct);
  }
  public ColorScheme colorScheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataColorScheme", getId());
      return new ColorScheme(__nid);
    }
    return factories.ThemeData_readBack_colorScheme(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_disabledColor(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDividerColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_dividerColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataFocusColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_focusColor(nativeStruct);
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataHighlightColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_highlightColor(nativeStruct);
  }
  public Color hintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataHintColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_hintColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataHoverColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_hoverColor(nativeStruct);
  }
  public Color primaryColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_primaryColor(nativeStruct);
  }
  public Color primaryColorDark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryColorDark", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_primaryColorDark(nativeStruct);
  }
  public Color primaryColorLight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryColorLight", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_primaryColorLight(nativeStruct);
  }
  public Color scaffoldBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_scaffoldBackgroundColor(nativeStruct);
  }
  public Color secondaryHeaderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSecondaryHeaderColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_secondaryHeaderColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSplashColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_splashColor(nativeStruct);
  }
  public Color unselectedWidgetColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataUnselectedWidgetColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_unselectedWidgetColor(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.ThemeData_readBack_iconTheme(nativeStruct);
  }
  public IconThemeData primaryIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.ThemeData_readBack_primaryIconTheme(nativeStruct);
  }
  public TextTheme primaryTextTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPrimaryTextTheme", getId());
      return new TextTheme(__nid);
    }
    return factories.ThemeData_readBack_primaryTextTheme(nativeStruct);
  }
  public TextTheme textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTextTheme", getId());
      return new TextTheme(__nid);
    }
    return factories.ThemeData_readBack_textTheme(nativeStruct);
  }
  public ActionIconThemeData actionIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataActionIconTheme", getId());
      return new ActionIconThemeData(__nid);
    }
    return factories.ThemeData_readBack_actionIconTheme(nativeStruct);
  }
  public AppBarThemeData appBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataAppBarTheme", getId());
      return new AppBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_appBarTheme(nativeStruct);
  }
  public BadgeThemeData badgeTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataBadgeTheme", getId());
      return new BadgeThemeData(__nid);
    }
    return factories.ThemeData_readBack_badgeTheme(nativeStruct);
  }
  public BottomAppBarThemeData bottomAppBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataBottomAppBarTheme", getId());
      return new BottomAppBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_bottomAppBarTheme(nativeStruct);
  }
  public BottomNavigationBarThemeData bottomNavigationBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataBottomNavigationBarTheme", getId());
      return new BottomNavigationBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_bottomNavigationBarTheme(nativeStruct);
  }
  public BottomSheetThemeData bottomSheetTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataBottomSheetTheme", getId());
      return new BottomSheetThemeData(__nid);
    }
    return factories.ThemeData_readBack_bottomSheetTheme(nativeStruct);
  }
  public ButtonThemeData buttonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataButtonTheme", getId());
      return new ButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_buttonTheme(nativeStruct);
  }
  public CardThemeData cardTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCardTheme", getId());
      return new CardThemeData(__nid);
    }
    return factories.ThemeData_readBack_cardTheme(nativeStruct);
  }
  public CarouselViewThemeData carouselViewTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCarouselViewTheme", getId());
      return new CarouselViewThemeData(__nid);
    }
    return factories.ThemeData_readBack_carouselViewTheme(nativeStruct);
  }
  public CheckboxThemeData checkboxTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataCheckboxTheme", getId());
      return new CheckboxThemeData(__nid);
    }
    return factories.ThemeData_readBack_checkboxTheme(nativeStruct);
  }
  public ChipThemeData chipTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataChipTheme", getId());
      return new ChipThemeData(__nid);
    }
    return factories.ThemeData_readBack_chipTheme(nativeStruct);
  }
  public DataTableThemeData dataTableTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDataTableTheme", getId());
      return new DataTableThemeData(__nid);
    }
    return factories.ThemeData_readBack_dataTableTheme(nativeStruct);
  }
  public DatePickerThemeData datePickerTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDatePickerTheme", getId());
      return new DatePickerThemeData(__nid);
    }
    return factories.ThemeData_readBack_datePickerTheme(nativeStruct);
  }
  public DialogThemeData dialogTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDialogTheme", getId());
      return new DialogThemeData(__nid);
    }
    return factories.ThemeData_readBack_dialogTheme(nativeStruct);
  }
  public DividerThemeData dividerTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDividerTheme", getId());
      return new DividerThemeData(__nid);
    }
    return factories.ThemeData_readBack_dividerTheme(nativeStruct);
  }
  public DrawerThemeData drawerTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDrawerTheme", getId());
      return new DrawerThemeData(__nid);
    }
    return factories.ThemeData_readBack_drawerTheme(nativeStruct);
  }
  public DropdownMenuThemeData dropdownMenuTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDropdownMenuTheme", getId());
      return new DropdownMenuThemeData(__nid);
    }
    return factories.ThemeData_readBack_dropdownMenuTheme(nativeStruct);
  }
  public ElevatedButtonThemeData elevatedButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataElevatedButtonTheme", getId());
      return new ElevatedButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_elevatedButtonTheme(nativeStruct);
  }
  public ExpansionTileThemeData expansionTileTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataExpansionTileTheme", getId());
      return new ExpansionTileThemeData(__nid);
    }
    return factories.ThemeData_readBack_expansionTileTheme(nativeStruct);
  }
  public FilledButtonThemeData filledButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataFilledButtonTheme", getId());
      return new FilledButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_filledButtonTheme(nativeStruct);
  }
  public FloatingActionButtonThemeData floatingActionButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataFloatingActionButtonTheme", getId());
      return new FloatingActionButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_floatingActionButtonTheme(nativeStruct);
  }
  public IconButtonThemeData iconButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataIconButtonTheme", getId());
      return new IconButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_iconButtonTheme(nativeStruct);
  }
  public MenuBarThemeData menuBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataMenuBarTheme", getId());
      return new MenuBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_menuBarTheme(nativeStruct);
  }
  public MenuButtonThemeData menuButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataMenuButtonTheme", getId());
      return new MenuButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_menuButtonTheme(nativeStruct);
  }
  public MenuThemeData menuTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataMenuTheme", getId());
      return new MenuThemeData(__nid);
    }
    return factories.ThemeData_readBack_menuTheme(nativeStruct);
  }
  public NavigationBarThemeData navigationBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataNavigationBarTheme", getId());
      return new NavigationBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_navigationBarTheme(nativeStruct);
  }
  public NavigationDrawerThemeData navigationDrawerTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataNavigationDrawerTheme", getId());
      return new NavigationDrawerThemeData(__nid);
    }
    return factories.ThemeData_readBack_navigationDrawerTheme(nativeStruct);
  }
  public NavigationRailThemeData navigationRailTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataNavigationRailTheme", getId());
      return new NavigationRailThemeData(__nid);
    }
    return factories.ThemeData_readBack_navigationRailTheme(nativeStruct);
  }
  public OutlinedButtonThemeData outlinedButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataOutlinedButtonTheme", getId());
      return new OutlinedButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_outlinedButtonTheme(nativeStruct);
  }
  public PopupMenuThemeData popupMenuTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataPopupMenuTheme", getId());
      return new PopupMenuThemeData(__nid);
    }
    return factories.ThemeData_readBack_popupMenuTheme(nativeStruct);
  }
  public ProgressIndicatorThemeData progressIndicatorTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataProgressIndicatorTheme", getId());
      return new ProgressIndicatorThemeData(__nid);
    }
    return factories.ThemeData_readBack_progressIndicatorTheme(nativeStruct);
  }
  public RadioThemeData radioTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataRadioTheme", getId());
      return new RadioThemeData(__nid);
    }
    return factories.ThemeData_readBack_radioTheme(nativeStruct);
  }
  public SearchBarThemeData searchBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSearchBarTheme", getId());
      return new SearchBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_searchBarTheme(nativeStruct);
  }
  public SearchViewThemeData searchViewTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSearchViewTheme", getId());
      return new SearchViewThemeData(__nid);
    }
    return factories.ThemeData_readBack_searchViewTheme(nativeStruct);
  }
  public SegmentedButtonThemeData segmentedButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSegmentedButtonTheme", getId());
      return new SegmentedButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_segmentedButtonTheme(nativeStruct);
  }
  public SliderThemeData sliderTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSliderTheme", getId());
      return new SliderThemeData(__nid);
    }
    return factories.ThemeData_readBack_sliderTheme(nativeStruct);
  }
  public SnackBarThemeData snackBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSnackBarTheme", getId());
      return new SnackBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_snackBarTheme(nativeStruct);
  }
  public SwitchThemeData switchTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataSwitchTheme", getId());
      return new SwitchThemeData(__nid);
    }
    return factories.ThemeData_readBack_switchTheme(nativeStruct);
  }
  public TabBarThemeData tabBarTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTabBarTheme", getId());
      return new TabBarThemeData(__nid);
    }
    return factories.ThemeData_readBack_tabBarTheme(nativeStruct);
  }
  public TextButtonThemeData textButtonTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTextButtonTheme", getId());
      return new TextButtonThemeData(__nid);
    }
    return factories.ThemeData_readBack_textButtonTheme(nativeStruct);
  }
  public TextSelectionThemeData textSelectionTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTextSelectionTheme", getId());
      return new TextSelectionThemeData(__nid);
    }
    return factories.ThemeData_readBack_textSelectionTheme(nativeStruct);
  }
  public TimePickerThemeData timePickerTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTimePickerTheme", getId());
      return new TimePickerThemeData(__nid);
    }
    return factories.ThemeData_readBack_timePickerTheme(nativeStruct);
  }
  public ToggleButtonsThemeData toggleButtonsTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataToggleButtonsTheme", getId());
      return new ToggleButtonsThemeData(__nid);
    }
    return factories.ThemeData_readBack_toggleButtonsTheme(nativeStruct);
  }
  public TooltipThemeData tooltipTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataTooltipTheme", getId());
      return new TooltipThemeData(__nid);
    }
    return factories.ThemeData_readBack_tooltipTheme(nativeStruct);
  }
  public Color dialogBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataDialogBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_dialogBackgroundColor(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("themeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.ThemeData_readBack_indicatorColor(nativeStruct);
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("themeDataBrightness not supported on web");
    return factories.ThemeData_readBack_brightness(nativeStruct);
  }
  private static int _localizedThemeDataCacheSize() {
    return 5;
  }
  @Override
  public ThemeData build() {
    return this;
  }
}
