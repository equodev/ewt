package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ColorSchemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ColorScheme extends NativeObj.Base {
  private MemorySegment st;
  ColorScheme(MemorySegment st) {
    this.id = ColorSchemeObjSt.id(st);
    this.st = st;
    System.out.println("New ColorScheme id:"+id);
  }
  @Builder.Factory
  static ColorScheme colorSchemeColorScheme(@Builder.Parameter Brightness brightness, @Builder.Parameter Color primary, @Builder.Parameter Color onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Color secondary, Color onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Color error, Color onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Color surface, Color onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = factories.colorSchemeColorScheme(brightness,
      primary,
      onPrimary,
      primaryContainer,
      onPrimaryContainer,
      primaryFixed,
      primaryFixedDim,
      onPrimaryFixed,
      onPrimaryFixedVariant,
      secondary,
      onSecondary,
      secondaryContainer,
      onSecondaryContainer,
      secondaryFixed,
      secondaryFixedDim,
      onSecondaryFixed,
      onSecondaryFixedVariant,
      tertiary,
      onTertiary,
      tertiaryContainer,
      onTertiaryContainer,
      tertiaryFixed,
      tertiaryFixedDim,
      onTertiaryFixed,
      onTertiaryFixedVariant,
      error,
      onError,
      errorContainer,
      onErrorContainer,
      surface,
      onSurface,
      surfaceDim,
      surfaceBright,
      surfaceContainerLowest,
      surfaceContainerLow,
      surfaceContainer,
      surfaceContainerHigh,
      surfaceContainerHighest,
      onSurfaceVariant,
      outline,
      outlineVariant,
      shadow,
      scrim,
      inverseSurface,
      onInverseSurface,
      inversePrimary,
      surfaceTint,
      background,
      onBackground,
      surfaceVariant);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeColorSchemeBuilder colorScheme(Brightness brightness, Color primary, Color onPrimary) {
    return ColorSchemeColorSchemeBuilder.colorSchemeColorScheme(brightness, primary, onPrimary);
  }
  @Builder.Factory
  static ColorScheme colorSchemeFromSeed(@Builder.Parameter Color seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = factories.colorSchemeFromSeed(seedColor,
      brightness,
      dynamicSchemeVariant,
      contrastLevel,
      primary,
      onPrimary,
      primaryContainer,
      onPrimaryContainer,
      primaryFixed,
      primaryFixedDim,
      onPrimaryFixed,
      onPrimaryFixedVariant,
      secondary,
      onSecondary,
      secondaryContainer,
      onSecondaryContainer,
      secondaryFixed,
      secondaryFixedDim,
      onSecondaryFixed,
      onSecondaryFixedVariant,
      tertiary,
      onTertiary,
      tertiaryContainer,
      onTertiaryContainer,
      tertiaryFixed,
      tertiaryFixedDim,
      onTertiaryFixed,
      onTertiaryFixedVariant,
      error,
      onError,
      errorContainer,
      onErrorContainer,
      outline,
      outlineVariant,
      surface,
      onSurface,
      surfaceDim,
      surfaceBright,
      surfaceContainerLowest,
      surfaceContainerLow,
      surfaceContainer,
      surfaceContainerHigh,
      surfaceContainerHighest,
      onSurfaceVariant,
      inverseSurface,
      onInverseSurface,
      inversePrimary,
      shadow,
      scrim,
      surfaceTint,
      background,
      onBackground,
      surfaceVariant);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeFromSeedBuilder fromSeed(Color seedColor) {
    return ColorSchemeFromSeedBuilder.colorSchemeFromSeed(seedColor);
  }
  @Builder.Factory
  static ColorScheme colorSchemeLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = factories.colorSchemeLight(brightness,
      primary,
      onPrimary,
      primaryContainer,
      onPrimaryContainer,
      primaryFixed,
      primaryFixedDim,
      onPrimaryFixed,
      onPrimaryFixedVariant,
      secondary,
      onSecondary,
      secondaryContainer,
      onSecondaryContainer,
      secondaryFixed,
      secondaryFixedDim,
      onSecondaryFixed,
      onSecondaryFixedVariant,
      tertiary,
      onTertiary,
      tertiaryContainer,
      onTertiaryContainer,
      tertiaryFixed,
      tertiaryFixedDim,
      onTertiaryFixed,
      onTertiaryFixedVariant,
      error,
      onError,
      errorContainer,
      onErrorContainer,
      surface,
      onSurface,
      surfaceDim,
      surfaceBright,
      surfaceContainerLowest,
      surfaceContainerLow,
      surfaceContainer,
      surfaceContainerHigh,
      surfaceContainerHighest,
      onSurfaceVariant,
      outline,
      outlineVariant,
      shadow,
      scrim,
      inverseSurface,
      onInverseSurface,
      inversePrimary,
      surfaceTint,
      background,
      onBackground,
      surfaceVariant);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeLightBuilder light() {
    return ColorSchemeLightBuilder.colorSchemeLight();
  }
  @Builder.Factory
  static ColorScheme colorSchemeDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = factories.colorSchemeDark(brightness,
      primary,
      onPrimary,
      primaryContainer,
      onPrimaryContainer,
      primaryFixed,
      primaryFixedDim,
      onPrimaryFixed,
      onPrimaryFixedVariant,
      secondary,
      onSecondary,
      secondaryContainer,
      onSecondaryContainer,
      secondaryFixed,
      secondaryFixedDim,
      onSecondaryFixed,
      onSecondaryFixedVariant,
      tertiary,
      onTertiary,
      tertiaryContainer,
      onTertiaryContainer,
      tertiaryFixed,
      tertiaryFixedDim,
      onTertiaryFixed,
      onTertiaryFixedVariant,
      error,
      onError,
      errorContainer,
      onErrorContainer,
      surface,
      onSurface,
      surfaceDim,
      surfaceBright,
      surfaceContainerLowest,
      surfaceContainerLow,
      surfaceContainer,
      surfaceContainerHigh,
      surfaceContainerHighest,
      onSurfaceVariant,
      outline,
      outlineVariant,
      shadow,
      scrim,
      inverseSurface,
      onInverseSurface,
      inversePrimary,
      surfaceTint,
      background,
      onBackground,
      surfaceVariant);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeDarkBuilder dark() {
    return ColorSchemeDarkBuilder.colorSchemeDark();
  }
  @Builder.Factory
  static ColorScheme colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = factories.colorSchemeHighContrastLight(brightness,
      primary,
      onPrimary,
      primaryContainer,
      onPrimaryContainer,
      primaryFixed,
      primaryFixedDim,
      onPrimaryFixed,
      onPrimaryFixedVariant,
      secondary,
      onSecondary,
      secondaryContainer,
      onSecondaryContainer,
      secondaryFixed,
      secondaryFixedDim,
      onSecondaryFixed,
      onSecondaryFixedVariant,
      tertiary,
      onTertiary,
      tertiaryContainer,
      onTertiaryContainer,
      tertiaryFixed,
      tertiaryFixedDim,
      onTertiaryFixed,
      onTertiaryFixedVariant,
      error,
      onError,
      errorContainer,
      onErrorContainer,
      surface,
      onSurface,
      surfaceDim,
      surfaceBright,
      surfaceContainerLowest,
      surfaceContainerLow,
      surfaceContainer,
      surfaceContainerHigh,
      surfaceContainerHighest,
      onSurfaceVariant,
      outline,
      outlineVariant,
      shadow,
      scrim,
      inverseSurface,
      onInverseSurface,
      inversePrimary,
      surfaceTint,
      background,
      onBackground,
      surfaceVariant);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeHighContrastLightBuilder highContrastLight() {
    return ColorSchemeHighContrastLightBuilder.colorSchemeHighContrastLight();
  }
  @Builder.Factory
  static ColorScheme colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = factories.colorSchemeHighContrastDark(brightness,
      primary,
      onPrimary,
      primaryContainer,
      onPrimaryContainer,
      primaryFixed,
      primaryFixedDim,
      onPrimaryFixed,
      onPrimaryFixedVariant,
      secondary,
      onSecondary,
      secondaryContainer,
      onSecondaryContainer,
      secondaryFixed,
      secondaryFixedDim,
      onSecondaryFixed,
      onSecondaryFixedVariant,
      tertiary,
      onTertiary,
      tertiaryContainer,
      onTertiaryContainer,
      tertiaryFixed,
      tertiaryFixedDim,
      onTertiaryFixed,
      onTertiaryFixedVariant,
      error,
      onError,
      errorContainer,
      onErrorContainer,
      surface,
      onSurface,
      surfaceDim,
      surfaceBright,
      surfaceContainerLowest,
      surfaceContainerLow,
      surfaceContainer,
      surfaceContainerHigh,
      surfaceContainerHighest,
      onSurfaceVariant,
      outline,
      outlineVariant,
      shadow,
      scrim,
      inverseSurface,
      onInverseSurface,
      inversePrimary,
      surfaceTint,
      background,
      onBackground,
      surfaceVariant);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeHighContrastDarkBuilder highContrastDark() {
    return ColorSchemeHighContrastDarkBuilder.colorSchemeHighContrastDark();
  }
  @Builder.Factory
  static ColorScheme colorSchemeFromSwatch(Optional<Color> accentColor, Optional<Color> cardColor, Optional<Color> backgroundColor, Optional<Color> errorColor, Optional<Brightness> brightness) {
    var st = factories.colorSchemeFromSwatch(accentColor,
      cardColor,
      backgroundColor,
      errorColor,
      brightness);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeFromSwatchBuilder fromSwatch() {
    return ColorSchemeFromSwatchBuilder.colorSchemeFromSwatch();
  }
  public static ColorScheme lerp(ColorScheme a, ColorScheme b, double t) {
    var st = factories.colorSchemeLerp(a,
      b,
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorScheme of(BuildContext context) {
    var st = factories.colorSchemeOf(context);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public Brightness brightness() {
    Brightness fld = Brightness.values()[ColorSchemeObjSt.brightness(st)];
    return fld;
  }
  public Color primary() {
    Color fld = new Color(ColorSchemeObjSt.primary(st)) {};
    return fld;
  }
  public Color onPrimary() {
    Color fld = new Color(ColorSchemeObjSt.onPrimary(st)) {};
    return fld;
  }
  public Color secondary() {
    Color fld = new Color(ColorSchemeObjSt.secondary(st)) {};
    return fld;
  }
  public Color onSecondary() {
    Color fld = new Color(ColorSchemeObjSt.onSecondary(st)) {};
    return fld;
  }
  public Color error() {
    Color fld = new Color(ColorSchemeObjSt.error(st)) {};
    return fld;
  }
  public Color onError() {
    Color fld = new Color(ColorSchemeObjSt.onError(st)) {};
    return fld;
  }
  public Color surface() {
    Color fld = new Color(ColorSchemeObjSt.surface(st)) {};
    return fld;
  }
  public Color onSurface() {
    Color fld = new Color(ColorSchemeObjSt.onSurface(st)) {};
    return fld;
  }
  public Color primaryContainer() {
    Color fld = new Color(ColorSchemeObjSt.primaryContainer(st)) {};
    return fld;
  }
  public Color onPrimaryContainer() {
    Color fld = new Color(ColorSchemeObjSt.onPrimaryContainer(st)) {};
    return fld;
  }
  public Color primaryFixed() {
    Color fld = new Color(ColorSchemeObjSt.primaryFixed(st)) {};
    return fld;
  }
  public Color primaryFixedDim() {
    Color fld = new Color(ColorSchemeObjSt.primaryFixedDim(st)) {};
    return fld;
  }
  public Color onPrimaryFixed() {
    Color fld = new Color(ColorSchemeObjSt.onPrimaryFixed(st)) {};
    return fld;
  }
  public Color onPrimaryFixedVariant() {
    Color fld = new Color(ColorSchemeObjSt.onPrimaryFixedVariant(st)) {};
    return fld;
  }
  public Color secondaryContainer() {
    Color fld = new Color(ColorSchemeObjSt.secondaryContainer(st)) {};
    return fld;
  }
  public Color onSecondaryContainer() {
    Color fld = new Color(ColorSchemeObjSt.onSecondaryContainer(st)) {};
    return fld;
  }
  public Color secondaryFixed() {
    Color fld = new Color(ColorSchemeObjSt.secondaryFixed(st)) {};
    return fld;
  }
  public Color secondaryFixedDim() {
    Color fld = new Color(ColorSchemeObjSt.secondaryFixedDim(st)) {};
    return fld;
  }
  public Color onSecondaryFixed() {
    Color fld = new Color(ColorSchemeObjSt.onSecondaryFixed(st)) {};
    return fld;
  }
  public Color onSecondaryFixedVariant() {
    Color fld = new Color(ColorSchemeObjSt.onSecondaryFixedVariant(st)) {};
    return fld;
  }
  public Color tertiary() {
    Color fld = new Color(ColorSchemeObjSt.tertiary(st)) {};
    return fld;
  }
  public Color onTertiary() {
    Color fld = new Color(ColorSchemeObjSt.onTertiary(st)) {};
    return fld;
  }
  public Color tertiaryContainer() {
    Color fld = new Color(ColorSchemeObjSt.tertiaryContainer(st)) {};
    return fld;
  }
  public Color onTertiaryContainer() {
    Color fld = new Color(ColorSchemeObjSt.onTertiaryContainer(st)) {};
    return fld;
  }
  public Color tertiaryFixed() {
    Color fld = new Color(ColorSchemeObjSt.tertiaryFixed(st)) {};
    return fld;
  }
  public Color tertiaryFixedDim() {
    Color fld = new Color(ColorSchemeObjSt.tertiaryFixedDim(st)) {};
    return fld;
  }
  public Color onTertiaryFixed() {
    Color fld = new Color(ColorSchemeObjSt.onTertiaryFixed(st)) {};
    return fld;
  }
  public Color onTertiaryFixedVariant() {
    Color fld = new Color(ColorSchemeObjSt.onTertiaryFixedVariant(st)) {};
    return fld;
  }
  public Color errorContainer() {
    Color fld = new Color(ColorSchemeObjSt.errorContainer(st)) {};
    return fld;
  }
  public Color onErrorContainer() {
    Color fld = new Color(ColorSchemeObjSt.onErrorContainer(st)) {};
    return fld;
  }
  public Color surfaceVariant() {
    Color fld = new Color(ColorSchemeObjSt.surfaceVariant(st)) {};
    return fld;
  }
  public Color surfaceDim() {
    Color fld = new Color(ColorSchemeObjSt.surfaceDim(st)) {};
    return fld;
  }
  public Color surfaceBright() {
    Color fld = new Color(ColorSchemeObjSt.surfaceBright(st)) {};
    return fld;
  }
  public Color surfaceContainerLowest() {
    Color fld = new Color(ColorSchemeObjSt.surfaceContainerLowest(st)) {};
    return fld;
  }
  public Color surfaceContainerLow() {
    Color fld = new Color(ColorSchemeObjSt.surfaceContainerLow(st)) {};
    return fld;
  }
  public Color surfaceContainer() {
    Color fld = new Color(ColorSchemeObjSt.surfaceContainer(st)) {};
    return fld;
  }
  public Color surfaceContainerHigh() {
    Color fld = new Color(ColorSchemeObjSt.surfaceContainerHigh(st)) {};
    return fld;
  }
  public Color surfaceContainerHighest() {
    Color fld = new Color(ColorSchemeObjSt.surfaceContainerHighest(st)) {};
    return fld;
  }
  public Color onSurfaceVariant() {
    Color fld = new Color(ColorSchemeObjSt.onSurfaceVariant(st)) {};
    return fld;
  }
  public Color outline() {
    Color fld = new Color(ColorSchemeObjSt.outline(st)) {};
    return fld;
  }
  public Color outlineVariant() {
    Color fld = new Color(ColorSchemeObjSt.outlineVariant(st)) {};
    return fld;
  }
  public Color shadow() {
    Color fld = new Color(ColorSchemeObjSt.shadow(st)) {};
    return fld;
  }
  public Color scrim() {
    Color fld = new Color(ColorSchemeObjSt.scrim(st)) {};
    return fld;
  }
  public Color inverseSurface() {
    Color fld = new Color(ColorSchemeObjSt.inverseSurface(st)) {};
    return fld;
  }
  public Color onInverseSurface() {
    Color fld = new Color(ColorSchemeObjSt.onInverseSurface(st)) {};
    return fld;
  }
  public Color inversePrimary() {
    Color fld = new Color(ColorSchemeObjSt.inversePrimary(st)) {};
    return fld;
  }
  public Color surfaceTint() {
    Color fld = new Color(ColorSchemeObjSt.surfaceTint(st)) {};
    return fld;
  }
  public Color background() {
    Color fld = new Color(ColorSchemeObjSt.background(st)) {};
    return fld;
  }
  public Color onBackground() {
    Color fld = new Color(ColorSchemeObjSt.onBackground(st)) {};
    return fld;
  }
}
