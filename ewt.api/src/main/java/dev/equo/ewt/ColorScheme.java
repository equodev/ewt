package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ColorScheme extends NativeObj.Base implements ColorSchemeI {
  protected ColorScheme() {}
  ColorScheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ColorScheme colorSchemeColorScheme(@Builder.Parameter Brightness brightness, @Builder.Parameter ColorI primary, @Builder.Parameter ColorI onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, ColorI secondary, ColorI onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, ColorI error, ColorI onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, ColorI surface, ColorI onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    int id = factories.colorSchemeColorScheme(brightness,
      primary.build(),
      onPrimary.build(),
      primaryContainer.map(ColorI::build),
      onPrimaryContainer.map(ColorI::build),
      primaryFixed.map(ColorI::build),
      primaryFixedDim.map(ColorI::build),
      onPrimaryFixed.map(ColorI::build),
      onPrimaryFixedVariant.map(ColorI::build),
      secondary.build(),
      onSecondary.build(),
      secondaryContainer.map(ColorI::build),
      onSecondaryContainer.map(ColorI::build),
      secondaryFixed.map(ColorI::build),
      secondaryFixedDim.map(ColorI::build),
      onSecondaryFixed.map(ColorI::build),
      onSecondaryFixedVariant.map(ColorI::build),
      tertiary.map(ColorI::build),
      onTertiary.map(ColorI::build),
      tertiaryContainer.map(ColorI::build),
      onTertiaryContainer.map(ColorI::build),
      tertiaryFixed.map(ColorI::build),
      tertiaryFixedDim.map(ColorI::build),
      onTertiaryFixed.map(ColorI::build),
      onTertiaryFixedVariant.map(ColorI::build),
      error.build(),
      onError.build(),
      errorContainer.map(ColorI::build),
      onErrorContainer.map(ColorI::build),
      surface.build(),
      onSurface.build(),
      surfaceDim.map(ColorI::build),
      surfaceBright.map(ColorI::build),
      surfaceContainerLowest.map(ColorI::build),
      surfaceContainerLow.map(ColorI::build),
      surfaceContainer.map(ColorI::build),
      surfaceContainerHigh.map(ColorI::build),
      surfaceContainerHighest.map(ColorI::build),
      onSurfaceVariant.map(ColorI::build),
      outline.map(ColorI::build),
      outlineVariant.map(ColorI::build),
      shadow.map(ColorI::build),
      scrim.map(ColorI::build),
      inverseSurface.map(ColorI::build),
      onInverseSurface.map(ColorI::build),
      inversePrimary.map(ColorI::build),
      surfaceTint.map(ColorI::build),
      background.map(ColorI::build),
      onBackground.map(ColorI::build),
      surfaceVariant.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorSchemeColorSchemeBuilder colorScheme(Brightness brightness, ColorI primary, ColorI onPrimary) {
    return ColorSchemeColorSchemeBuilder.colorSchemeColorScheme(brightness, primary, onPrimary);
  }
  @Builder.Factory
  static ColorScheme colorSchemeFromSeed(@Builder.Parameter ColorI seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    int id = factories.colorSchemeFromSeed(seedColor.build(),
      brightness,
      dynamicSchemeVariant,
      contrastLevel,
      primary.map(ColorI::build),
      onPrimary.map(ColorI::build),
      primaryContainer.map(ColorI::build),
      onPrimaryContainer.map(ColorI::build),
      primaryFixed.map(ColorI::build),
      primaryFixedDim.map(ColorI::build),
      onPrimaryFixed.map(ColorI::build),
      onPrimaryFixedVariant.map(ColorI::build),
      secondary.map(ColorI::build),
      onSecondary.map(ColorI::build),
      secondaryContainer.map(ColorI::build),
      onSecondaryContainer.map(ColorI::build),
      secondaryFixed.map(ColorI::build),
      secondaryFixedDim.map(ColorI::build),
      onSecondaryFixed.map(ColorI::build),
      onSecondaryFixedVariant.map(ColorI::build),
      tertiary.map(ColorI::build),
      onTertiary.map(ColorI::build),
      tertiaryContainer.map(ColorI::build),
      onTertiaryContainer.map(ColorI::build),
      tertiaryFixed.map(ColorI::build),
      tertiaryFixedDim.map(ColorI::build),
      onTertiaryFixed.map(ColorI::build),
      onTertiaryFixedVariant.map(ColorI::build),
      error.map(ColorI::build),
      onError.map(ColorI::build),
      errorContainer.map(ColorI::build),
      onErrorContainer.map(ColorI::build),
      outline.map(ColorI::build),
      outlineVariant.map(ColorI::build),
      surface.map(ColorI::build),
      onSurface.map(ColorI::build),
      surfaceDim.map(ColorI::build),
      surfaceBright.map(ColorI::build),
      surfaceContainerLowest.map(ColorI::build),
      surfaceContainerLow.map(ColorI::build),
      surfaceContainer.map(ColorI::build),
      surfaceContainerHigh.map(ColorI::build),
      surfaceContainerHighest.map(ColorI::build),
      onSurfaceVariant.map(ColorI::build),
      inverseSurface.map(ColorI::build),
      onInverseSurface.map(ColorI::build),
      inversePrimary.map(ColorI::build),
      shadow.map(ColorI::build),
      scrim.map(ColorI::build),
      surfaceTint.map(ColorI::build),
      background.map(ColorI::build),
      onBackground.map(ColorI::build),
      surfaceVariant.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorSchemeFromSeedBuilder fromSeed(ColorI seedColor) {
    return ColorSchemeFromSeedBuilder.colorSchemeFromSeed(seedColor);
  }
  @Builder.Factory
  static ColorScheme colorSchemeLight(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    int id = factories.colorSchemeLight(brightness,
      primary.map(ColorI::build),
      onPrimary.map(ColorI::build),
      primaryContainer.map(ColorI::build),
      onPrimaryContainer.map(ColorI::build),
      primaryFixed.map(ColorI::build),
      primaryFixedDim.map(ColorI::build),
      onPrimaryFixed.map(ColorI::build),
      onPrimaryFixedVariant.map(ColorI::build),
      secondary.map(ColorI::build),
      onSecondary.map(ColorI::build),
      secondaryContainer.map(ColorI::build),
      onSecondaryContainer.map(ColorI::build),
      secondaryFixed.map(ColorI::build),
      secondaryFixedDim.map(ColorI::build),
      onSecondaryFixed.map(ColorI::build),
      onSecondaryFixedVariant.map(ColorI::build),
      tertiary.map(ColorI::build),
      onTertiary.map(ColorI::build),
      tertiaryContainer.map(ColorI::build),
      onTertiaryContainer.map(ColorI::build),
      tertiaryFixed.map(ColorI::build),
      tertiaryFixedDim.map(ColorI::build),
      onTertiaryFixed.map(ColorI::build),
      onTertiaryFixedVariant.map(ColorI::build),
      error.map(ColorI::build),
      onError.map(ColorI::build),
      errorContainer.map(ColorI::build),
      onErrorContainer.map(ColorI::build),
      surface.map(ColorI::build),
      onSurface.map(ColorI::build),
      surfaceDim.map(ColorI::build),
      surfaceBright.map(ColorI::build),
      surfaceContainerLowest.map(ColorI::build),
      surfaceContainerLow.map(ColorI::build),
      surfaceContainer.map(ColorI::build),
      surfaceContainerHigh.map(ColorI::build),
      surfaceContainerHighest.map(ColorI::build),
      onSurfaceVariant.map(ColorI::build),
      outline.map(ColorI::build),
      outlineVariant.map(ColorI::build),
      shadow.map(ColorI::build),
      scrim.map(ColorI::build),
      inverseSurface.map(ColorI::build),
      onInverseSurface.map(ColorI::build),
      inversePrimary.map(ColorI::build),
      surfaceTint.map(ColorI::build),
      background.map(ColorI::build),
      onBackground.map(ColorI::build),
      surfaceVariant.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorSchemeLightBuilder light() {
    return ColorSchemeLightBuilder.colorSchemeLight();
  }
  @Builder.Factory
  static ColorScheme colorSchemeDark(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    int id = factories.colorSchemeDark(brightness,
      primary.map(ColorI::build),
      onPrimary.map(ColorI::build),
      primaryContainer.map(ColorI::build),
      onPrimaryContainer.map(ColorI::build),
      primaryFixed.map(ColorI::build),
      primaryFixedDim.map(ColorI::build),
      onPrimaryFixed.map(ColorI::build),
      onPrimaryFixedVariant.map(ColorI::build),
      secondary.map(ColorI::build),
      onSecondary.map(ColorI::build),
      secondaryContainer.map(ColorI::build),
      onSecondaryContainer.map(ColorI::build),
      secondaryFixed.map(ColorI::build),
      secondaryFixedDim.map(ColorI::build),
      onSecondaryFixed.map(ColorI::build),
      onSecondaryFixedVariant.map(ColorI::build),
      tertiary.map(ColorI::build),
      onTertiary.map(ColorI::build),
      tertiaryContainer.map(ColorI::build),
      onTertiaryContainer.map(ColorI::build),
      tertiaryFixed.map(ColorI::build),
      tertiaryFixedDim.map(ColorI::build),
      onTertiaryFixed.map(ColorI::build),
      onTertiaryFixedVariant.map(ColorI::build),
      error.map(ColorI::build),
      onError.map(ColorI::build),
      errorContainer.map(ColorI::build),
      onErrorContainer.map(ColorI::build),
      surface.map(ColorI::build),
      onSurface.map(ColorI::build),
      surfaceDim.map(ColorI::build),
      surfaceBright.map(ColorI::build),
      surfaceContainerLowest.map(ColorI::build),
      surfaceContainerLow.map(ColorI::build),
      surfaceContainer.map(ColorI::build),
      surfaceContainerHigh.map(ColorI::build),
      surfaceContainerHighest.map(ColorI::build),
      onSurfaceVariant.map(ColorI::build),
      outline.map(ColorI::build),
      outlineVariant.map(ColorI::build),
      shadow.map(ColorI::build),
      scrim.map(ColorI::build),
      inverseSurface.map(ColorI::build),
      onInverseSurface.map(ColorI::build),
      inversePrimary.map(ColorI::build),
      surfaceTint.map(ColorI::build),
      background.map(ColorI::build),
      onBackground.map(ColorI::build),
      surfaceVariant.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorSchemeDarkBuilder dark() {
    return ColorSchemeDarkBuilder.colorSchemeDark();
  }
  @Builder.Factory
  static ColorScheme colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    int id = factories.colorSchemeHighContrastLight(brightness,
      primary.map(ColorI::build),
      onPrimary.map(ColorI::build),
      primaryContainer.map(ColorI::build),
      onPrimaryContainer.map(ColorI::build),
      primaryFixed.map(ColorI::build),
      primaryFixedDim.map(ColorI::build),
      onPrimaryFixed.map(ColorI::build),
      onPrimaryFixedVariant.map(ColorI::build),
      secondary.map(ColorI::build),
      onSecondary.map(ColorI::build),
      secondaryContainer.map(ColorI::build),
      onSecondaryContainer.map(ColorI::build),
      secondaryFixed.map(ColorI::build),
      secondaryFixedDim.map(ColorI::build),
      onSecondaryFixed.map(ColorI::build),
      onSecondaryFixedVariant.map(ColorI::build),
      tertiary.map(ColorI::build),
      onTertiary.map(ColorI::build),
      tertiaryContainer.map(ColorI::build),
      onTertiaryContainer.map(ColorI::build),
      tertiaryFixed.map(ColorI::build),
      tertiaryFixedDim.map(ColorI::build),
      onTertiaryFixed.map(ColorI::build),
      onTertiaryFixedVariant.map(ColorI::build),
      error.map(ColorI::build),
      onError.map(ColorI::build),
      errorContainer.map(ColorI::build),
      onErrorContainer.map(ColorI::build),
      surface.map(ColorI::build),
      onSurface.map(ColorI::build),
      surfaceDim.map(ColorI::build),
      surfaceBright.map(ColorI::build),
      surfaceContainerLowest.map(ColorI::build),
      surfaceContainerLow.map(ColorI::build),
      surfaceContainer.map(ColorI::build),
      surfaceContainerHigh.map(ColorI::build),
      surfaceContainerHighest.map(ColorI::build),
      onSurfaceVariant.map(ColorI::build),
      outline.map(ColorI::build),
      outlineVariant.map(ColorI::build),
      shadow.map(ColorI::build),
      scrim.map(ColorI::build),
      inverseSurface.map(ColorI::build),
      onInverseSurface.map(ColorI::build),
      inversePrimary.map(ColorI::build),
      surfaceTint.map(ColorI::build),
      background.map(ColorI::build),
      onBackground.map(ColorI::build),
      surfaceVariant.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorSchemeHighContrastLightBuilder highContrastLight() {
    return ColorSchemeHighContrastLightBuilder.colorSchemeHighContrastLight();
  }
  @Builder.Factory
  static ColorScheme colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    int id = factories.colorSchemeHighContrastDark(brightness,
      primary.map(ColorI::build),
      onPrimary.map(ColorI::build),
      primaryContainer.map(ColorI::build),
      onPrimaryContainer.map(ColorI::build),
      primaryFixed.map(ColorI::build),
      primaryFixedDim.map(ColorI::build),
      onPrimaryFixed.map(ColorI::build),
      onPrimaryFixedVariant.map(ColorI::build),
      secondary.map(ColorI::build),
      onSecondary.map(ColorI::build),
      secondaryContainer.map(ColorI::build),
      onSecondaryContainer.map(ColorI::build),
      secondaryFixed.map(ColorI::build),
      secondaryFixedDim.map(ColorI::build),
      onSecondaryFixed.map(ColorI::build),
      onSecondaryFixedVariant.map(ColorI::build),
      tertiary.map(ColorI::build),
      onTertiary.map(ColorI::build),
      tertiaryContainer.map(ColorI::build),
      onTertiaryContainer.map(ColorI::build),
      tertiaryFixed.map(ColorI::build),
      tertiaryFixedDim.map(ColorI::build),
      onTertiaryFixed.map(ColorI::build),
      onTertiaryFixedVariant.map(ColorI::build),
      error.map(ColorI::build),
      onError.map(ColorI::build),
      errorContainer.map(ColorI::build),
      onErrorContainer.map(ColorI::build),
      surface.map(ColorI::build),
      onSurface.map(ColorI::build),
      surfaceDim.map(ColorI::build),
      surfaceBright.map(ColorI::build),
      surfaceContainerLowest.map(ColorI::build),
      surfaceContainerLow.map(ColorI::build),
      surfaceContainer.map(ColorI::build),
      surfaceContainerHigh.map(ColorI::build),
      surfaceContainerHighest.map(ColorI::build),
      onSurfaceVariant.map(ColorI::build),
      outline.map(ColorI::build),
      outlineVariant.map(ColorI::build),
      shadow.map(ColorI::build),
      scrim.map(ColorI::build),
      inverseSurface.map(ColorI::build),
      onInverseSurface.map(ColorI::build),
      inversePrimary.map(ColorI::build),
      surfaceTint.map(ColorI::build),
      background.map(ColorI::build),
      onBackground.map(ColorI::build),
      surfaceVariant.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorSchemeHighContrastDarkBuilder highContrastDark() {
    return ColorSchemeHighContrastDarkBuilder.colorSchemeHighContrastDark();
  }
  @Builder.Factory
  static ColorScheme colorSchemeFromSwatch(Optional<MaterialColorI> primarySwatch, Optional<ColorI> accentColor, Optional<ColorI> cardColor, Optional<ColorI> backgroundColor, Optional<ColorI> errorColor, Optional<Brightness> brightness) {
    int id = factories.colorSchemeFromSwatch(primarySwatch.map(MaterialColorI::build),
      accentColor.map(ColorI::build),
      cardColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      errorColor.map(ColorI::build),
      brightness);
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorSchemeFromSwatchBuilder fromSwatch() {
    return ColorSchemeFromSwatchBuilder.colorSchemeFromSwatch();
  }
  public static ColorScheme lerp(ColorSchemeI a, ColorSchemeI b, double t) {
    int id = factories.colorSchemeLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public static ColorScheme of(BuildContextI context) {
    int id = factories.colorSchemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(id);
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("colorSchemeBrightness not supported on web");
    return factories.ColorScheme_readBack_brightness(nativeStruct);
  }
  public Color primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemePrimary", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_primary(nativeStruct);
  }
  public Color onPrimary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnPrimary", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onPrimary(nativeStruct);
  }
  public Color secondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSecondary", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_secondary(nativeStruct);
  }
  public Color onSecondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnSecondary", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onSecondary(nativeStruct);
  }
  public Color error() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeError", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_error(nativeStruct);
  }
  public Color onError() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnError", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onError(nativeStruct);
  }
  public Color surface() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurface", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surface(nativeStruct);
  }
  public Color onSurface() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnSurface", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onSurface(nativeStruct);
  }
  public Color primaryContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemePrimaryContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_primaryContainer(nativeStruct);
  }
  public Color onPrimaryContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnPrimaryContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onPrimaryContainer(nativeStruct);
  }
  public Color primaryFixed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemePrimaryFixed", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_primaryFixed(nativeStruct);
  }
  public Color primaryFixedDim() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemePrimaryFixedDim", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_primaryFixedDim(nativeStruct);
  }
  public Color onPrimaryFixed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnPrimaryFixed", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onPrimaryFixed(nativeStruct);
  }
  public Color onPrimaryFixedVariant() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnPrimaryFixedVariant", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onPrimaryFixedVariant(nativeStruct);
  }
  public Color secondaryContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSecondaryContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_secondaryContainer(nativeStruct);
  }
  public Color onSecondaryContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnSecondaryContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onSecondaryContainer(nativeStruct);
  }
  public Color secondaryFixed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSecondaryFixed", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_secondaryFixed(nativeStruct);
  }
  public Color secondaryFixedDim() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSecondaryFixedDim", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_secondaryFixedDim(nativeStruct);
  }
  public Color onSecondaryFixed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnSecondaryFixed", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onSecondaryFixed(nativeStruct);
  }
  public Color onSecondaryFixedVariant() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnSecondaryFixedVariant", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onSecondaryFixedVariant(nativeStruct);
  }
  public Color tertiary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeTertiary", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_tertiary(nativeStruct);
  }
  public Color onTertiary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnTertiary", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onTertiary(nativeStruct);
  }
  public Color tertiaryContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeTertiaryContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_tertiaryContainer(nativeStruct);
  }
  public Color onTertiaryContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnTertiaryContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onTertiaryContainer(nativeStruct);
  }
  public Color tertiaryFixed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeTertiaryFixed", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_tertiaryFixed(nativeStruct);
  }
  public Color tertiaryFixedDim() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeTertiaryFixedDim", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_tertiaryFixedDim(nativeStruct);
  }
  public Color onTertiaryFixed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnTertiaryFixed", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onTertiaryFixed(nativeStruct);
  }
  public Color onTertiaryFixedVariant() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnTertiaryFixedVariant", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onTertiaryFixedVariant(nativeStruct);
  }
  public Color errorContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeErrorContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_errorContainer(nativeStruct);
  }
  public Color onErrorContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnErrorContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onErrorContainer(nativeStruct);
  }
  public Color surfaceVariant() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceVariant", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceVariant(nativeStruct);
  }
  public Color surfaceDim() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceDim", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceDim(nativeStruct);
  }
  public Color surfaceBright() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceBright", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceBright(nativeStruct);
  }
  public Color surfaceContainerLowest() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceContainerLowest", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceContainerLowest(nativeStruct);
  }
  public Color surfaceContainerLow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceContainerLow", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceContainerLow(nativeStruct);
  }
  public Color surfaceContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceContainer", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceContainer(nativeStruct);
  }
  public Color surfaceContainerHigh() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceContainerHigh", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceContainerHigh(nativeStruct);
  }
  public Color surfaceContainerHighest() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceContainerHighest", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceContainerHighest(nativeStruct);
  }
  public Color onSurfaceVariant() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnSurfaceVariant", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onSurfaceVariant(nativeStruct);
  }
  public Color outline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOutline", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_outline(nativeStruct);
  }
  public Color outlineVariant() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOutlineVariant", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_outlineVariant(nativeStruct);
  }
  public Color shadow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeShadow", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_shadow(nativeStruct);
  }
  public Color scrim() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeScrim", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_scrim(nativeStruct);
  }
  public Color inverseSurface() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeInverseSurface", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_inverseSurface(nativeStruct);
  }
  public Color onInverseSurface() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnInverseSurface", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onInverseSurface(nativeStruct);
  }
  public Color inversePrimary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeInversePrimary", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_inversePrimary(nativeStruct);
  }
  public Color surfaceTint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeSurfaceTint", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_surfaceTint(nativeStruct);
  }
  public Color background() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeBackground", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_background(nativeStruct);
  }
  public Color onBackground() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorSchemeOnBackground", getId());
      return new Color(__nid);
    }
    return factories.ColorScheme_readBack_onBackground(nativeStruct);
  }
  @Override
  public ColorScheme build() {
    return this;
  }
}
