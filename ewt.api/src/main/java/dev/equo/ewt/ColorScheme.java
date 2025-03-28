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
    return Brightness.values()[ColorSchemeObjSt.brightness(st)];
  }
  public Color primary() {
    return new Color(ColorSchemeObjSt.primary(st)) {};
  }
  public Color onPrimary() {
    return new Color(ColorSchemeObjSt.onPrimary(st)) {};
  }
  public Color secondary() {
    return new Color(ColorSchemeObjSt.secondary(st)) {};
  }
  public Color onSecondary() {
    return new Color(ColorSchemeObjSt.onSecondary(st)) {};
  }
  public Color error() {
    return new Color(ColorSchemeObjSt.error(st)) {};
  }
  public Color onError() {
    return new Color(ColorSchemeObjSt.onError(st)) {};
  }
  public Color surface() {
    return new Color(ColorSchemeObjSt.surface(st)) {};
  }
  public Color onSurface() {
    return new Color(ColorSchemeObjSt.onSurface(st)) {};
  }
  public Color primaryContainer() {
    return new Color(ColorSchemeObjSt.primaryContainer(st)) {};
  }
  public Color onPrimaryContainer() {
    return new Color(ColorSchemeObjSt.onPrimaryContainer(st)) {};
  }
  public Color primaryFixed() {
    return new Color(ColorSchemeObjSt.primaryFixed(st)) {};
  }
  public Color primaryFixedDim() {
    return new Color(ColorSchemeObjSt.primaryFixedDim(st)) {};
  }
  public Color onPrimaryFixed() {
    return new Color(ColorSchemeObjSt.onPrimaryFixed(st)) {};
  }
  public Color onPrimaryFixedVariant() {
    return new Color(ColorSchemeObjSt.onPrimaryFixedVariant(st)) {};
  }
  public Color secondaryContainer() {
    return new Color(ColorSchemeObjSt.secondaryContainer(st)) {};
  }
  public Color onSecondaryContainer() {
    return new Color(ColorSchemeObjSt.onSecondaryContainer(st)) {};
  }
  public Color secondaryFixed() {
    return new Color(ColorSchemeObjSt.secondaryFixed(st)) {};
  }
  public Color secondaryFixedDim() {
    return new Color(ColorSchemeObjSt.secondaryFixedDim(st)) {};
  }
  public Color onSecondaryFixed() {
    return new Color(ColorSchemeObjSt.onSecondaryFixed(st)) {};
  }
  public Color onSecondaryFixedVariant() {
    return new Color(ColorSchemeObjSt.onSecondaryFixedVariant(st)) {};
  }
  public Color tertiary() {
    return new Color(ColorSchemeObjSt.tertiary(st)) {};
  }
  public Color onTertiary() {
    return new Color(ColorSchemeObjSt.onTertiary(st)) {};
  }
  public Color tertiaryContainer() {
    return new Color(ColorSchemeObjSt.tertiaryContainer(st)) {};
  }
  public Color onTertiaryContainer() {
    return new Color(ColorSchemeObjSt.onTertiaryContainer(st)) {};
  }
  public Color tertiaryFixed() {
    return new Color(ColorSchemeObjSt.tertiaryFixed(st)) {};
  }
  public Color tertiaryFixedDim() {
    return new Color(ColorSchemeObjSt.tertiaryFixedDim(st)) {};
  }
  public Color onTertiaryFixed() {
    return new Color(ColorSchemeObjSt.onTertiaryFixed(st)) {};
  }
  public Color onTertiaryFixedVariant() {
    return new Color(ColorSchemeObjSt.onTertiaryFixedVariant(st)) {};
  }
  public Color errorContainer() {
    return new Color(ColorSchemeObjSt.errorContainer(st)) {};
  }
  public Color onErrorContainer() {
    return new Color(ColorSchemeObjSt.onErrorContainer(st)) {};
  }
  public Color surfaceVariant() {
    return new Color(ColorSchemeObjSt.surfaceVariant(st)) {};
  }
  public Color surfaceDim() {
    return new Color(ColorSchemeObjSt.surfaceDim(st)) {};
  }
  public Color surfaceBright() {
    return new Color(ColorSchemeObjSt.surfaceBright(st)) {};
  }
  public Color surfaceContainerLowest() {
    return new Color(ColorSchemeObjSt.surfaceContainerLowest(st)) {};
  }
  public Color surfaceContainerLow() {
    return new Color(ColorSchemeObjSt.surfaceContainerLow(st)) {};
  }
  public Color surfaceContainer() {
    return new Color(ColorSchemeObjSt.surfaceContainer(st)) {};
  }
  public Color surfaceContainerHigh() {
    return new Color(ColorSchemeObjSt.surfaceContainerHigh(st)) {};
  }
  public Color surfaceContainerHighest() {
    return new Color(ColorSchemeObjSt.surfaceContainerHighest(st)) {};
  }
  public Color onSurfaceVariant() {
    return new Color(ColorSchemeObjSt.onSurfaceVariant(st)) {};
  }
  public Color outline() {
    return new Color(ColorSchemeObjSt.outline(st)) {};
  }
  public Color outlineVariant() {
    return new Color(ColorSchemeObjSt.outlineVariant(st)) {};
  }
  public Color shadow() {
    return new Color(ColorSchemeObjSt.shadow(st)) {};
  }
  public Color scrim() {
    return new Color(ColorSchemeObjSt.scrim(st)) {};
  }
  public Color inverseSurface() {
    return new Color(ColorSchemeObjSt.inverseSurface(st)) {};
  }
  public Color onInverseSurface() {
    return new Color(ColorSchemeObjSt.onInverseSurface(st)) {};
  }
  public Color inversePrimary() {
    return new Color(ColorSchemeObjSt.inversePrimary(st)) {};
  }
  public Color surfaceTint() {
    return new Color(ColorSchemeObjSt.surfaceTint(st)) {};
  }
  public Color background() {
    return new Color(ColorSchemeObjSt.background(st)) {};
  }
  public Color onBackground() {
    return new Color(ColorSchemeObjSt.onBackground(st)) {};
  }
}
