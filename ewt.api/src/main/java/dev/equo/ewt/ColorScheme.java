package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ColorSchemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ColorScheme extends NativeObj.Base implements ColorSchemeI {
  private MemorySegment st;
  protected ColorScheme() {}
  ColorScheme(MemorySegment st) {
    this.id = ColorSchemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorScheme");
    System.out.println("New ColorScheme id:"+id);
  }
  @Builder.Factory
  static ColorScheme colorSchemeColorScheme(@Builder.Parameter Brightness brightness, @Builder.Parameter ColorI primary, @Builder.Parameter ColorI onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, ColorI secondary, ColorI onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, ColorI error, ColorI onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, ColorI surface, ColorI onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    var st = factories.colorSchemeColorScheme(brightness,
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
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeColorSchemeBuilder colorScheme(Brightness brightness, ColorI primary, ColorI onPrimary) {
    return ColorSchemeColorSchemeBuilder.colorSchemeColorScheme(brightness, primary, onPrimary);
  }
  @Builder.Factory
  static ColorScheme colorSchemeFromSeed(@Builder.Parameter ColorI seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    var st = factories.colorSchemeFromSeed(seedColor.build(),
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
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeFromSeedBuilder fromSeed(ColorI seedColor) {
    return ColorSchemeFromSeedBuilder.colorSchemeFromSeed(seedColor);
  }
  @Builder.Factory
  static ColorScheme colorSchemeLight(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    var st = factories.colorSchemeLight(brightness,
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
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeLightBuilder light() {
    return ColorSchemeLightBuilder.colorSchemeLight();
  }
  @Builder.Factory
  static ColorScheme colorSchemeDark(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    var st = factories.colorSchemeDark(brightness,
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
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeDarkBuilder dark() {
    return ColorSchemeDarkBuilder.colorSchemeDark();
  }
  @Builder.Factory
  static ColorScheme colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    var st = factories.colorSchemeHighContrastLight(brightness,
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
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeHighContrastLightBuilder highContrastLight() {
    return ColorSchemeHighContrastLightBuilder.colorSchemeHighContrastLight();
  }
  @Builder.Factory
  static ColorScheme colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<ColorI> primary, Optional<ColorI> onPrimary, Optional<ColorI> primaryContainer, Optional<ColorI> onPrimaryContainer, Optional<ColorI> primaryFixed, Optional<ColorI> primaryFixedDim, Optional<ColorI> onPrimaryFixed, Optional<ColorI> onPrimaryFixedVariant, Optional<ColorI> secondary, Optional<ColorI> onSecondary, Optional<ColorI> secondaryContainer, Optional<ColorI> onSecondaryContainer, Optional<ColorI> secondaryFixed, Optional<ColorI> secondaryFixedDim, Optional<ColorI> onSecondaryFixed, Optional<ColorI> onSecondaryFixedVariant, Optional<ColorI> tertiary, Optional<ColorI> onTertiary, Optional<ColorI> tertiaryContainer, Optional<ColorI> onTertiaryContainer, Optional<ColorI> tertiaryFixed, Optional<ColorI> tertiaryFixedDim, Optional<ColorI> onTertiaryFixed, Optional<ColorI> onTertiaryFixedVariant, Optional<ColorI> error, Optional<ColorI> onError, Optional<ColorI> errorContainer, Optional<ColorI> onErrorContainer, Optional<ColorI> surface, Optional<ColorI> onSurface, Optional<ColorI> surfaceDim, Optional<ColorI> surfaceBright, Optional<ColorI> surfaceContainerLowest, Optional<ColorI> surfaceContainerLow, Optional<ColorI> surfaceContainer, Optional<ColorI> surfaceContainerHigh, Optional<ColorI> surfaceContainerHighest, Optional<ColorI> onSurfaceVariant, Optional<ColorI> outline, Optional<ColorI> outlineVariant, Optional<ColorI> shadow, Optional<ColorI> scrim, Optional<ColorI> inverseSurface, Optional<ColorI> onInverseSurface, Optional<ColorI> inversePrimary, Optional<ColorI> surfaceTint, Optional<ColorI> background, Optional<ColorI> onBackground, Optional<ColorI> surfaceVariant) {
    var st = factories.colorSchemeHighContrastDark(brightness,
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
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeHighContrastDarkBuilder highContrastDark() {
    return ColorSchemeHighContrastDarkBuilder.colorSchemeHighContrastDark();
  }
  @Builder.Factory
  static ColorScheme colorSchemeFromSwatch(Optional<MaterialColorI> primarySwatch, Optional<ColorI> accentColor, Optional<ColorI> cardColor, Optional<ColorI> backgroundColor, Optional<ColorI> errorColor, Optional<Brightness> brightness) {
    var st = factories.colorSchemeFromSwatch(primarySwatch.map(MaterialColorI::build),
      accentColor.map(ColorI::build),
      cardColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      errorColor.map(ColorI::build),
      brightness);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorSchemeFromSwatchBuilder fromSwatch() {
    return ColorSchemeFromSwatchBuilder.colorSchemeFromSwatch();
  }
  public static ColorScheme lerp(ColorSchemeI a, ColorSchemeI b, double t) {
    var st = factories.colorSchemeLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public static ColorScheme of(BuildContextI context) {
    var st = factories.colorSchemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ColorScheme");
    return new ColorScheme(st);
  }
  public Brightness brightness() {
    return Brightness.values()[ColorSchemeObjSt.brightness(st)];
  }
  public Color primary() {
    return new Color(ColorSchemeObjSt.primary(st));
  }
  public Color onPrimary() {
    return new Color(ColorSchemeObjSt.onPrimary(st));
  }
  public Color secondary() {
    return new Color(ColorSchemeObjSt.secondary(st));
  }
  public Color onSecondary() {
    return new Color(ColorSchemeObjSt.onSecondary(st));
  }
  public Color error() {
    return new Color(ColorSchemeObjSt.error(st));
  }
  public Color onError() {
    return new Color(ColorSchemeObjSt.onError(st));
  }
  public Color surface() {
    return new Color(ColorSchemeObjSt.surface(st));
  }
  public Color onSurface() {
    return new Color(ColorSchemeObjSt.onSurface(st));
  }
  public Color primaryContainer() {
    return new Color(ColorSchemeObjSt.primaryContainer(st));
  }
  public Color onPrimaryContainer() {
    return new Color(ColorSchemeObjSt.onPrimaryContainer(st));
  }
  public Color primaryFixed() {
    return new Color(ColorSchemeObjSt.primaryFixed(st));
  }
  public Color primaryFixedDim() {
    return new Color(ColorSchemeObjSt.primaryFixedDim(st));
  }
  public Color onPrimaryFixed() {
    return new Color(ColorSchemeObjSt.onPrimaryFixed(st));
  }
  public Color onPrimaryFixedVariant() {
    return new Color(ColorSchemeObjSt.onPrimaryFixedVariant(st));
  }
  public Color secondaryContainer() {
    return new Color(ColorSchemeObjSt.secondaryContainer(st));
  }
  public Color onSecondaryContainer() {
    return new Color(ColorSchemeObjSt.onSecondaryContainer(st));
  }
  public Color secondaryFixed() {
    return new Color(ColorSchemeObjSt.secondaryFixed(st));
  }
  public Color secondaryFixedDim() {
    return new Color(ColorSchemeObjSt.secondaryFixedDim(st));
  }
  public Color onSecondaryFixed() {
    return new Color(ColorSchemeObjSt.onSecondaryFixed(st));
  }
  public Color onSecondaryFixedVariant() {
    return new Color(ColorSchemeObjSt.onSecondaryFixedVariant(st));
  }
  public Color tertiary() {
    return new Color(ColorSchemeObjSt.tertiary(st));
  }
  public Color onTertiary() {
    return new Color(ColorSchemeObjSt.onTertiary(st));
  }
  public Color tertiaryContainer() {
    return new Color(ColorSchemeObjSt.tertiaryContainer(st));
  }
  public Color onTertiaryContainer() {
    return new Color(ColorSchemeObjSt.onTertiaryContainer(st));
  }
  public Color tertiaryFixed() {
    return new Color(ColorSchemeObjSt.tertiaryFixed(st));
  }
  public Color tertiaryFixedDim() {
    return new Color(ColorSchemeObjSt.tertiaryFixedDim(st));
  }
  public Color onTertiaryFixed() {
    return new Color(ColorSchemeObjSt.onTertiaryFixed(st));
  }
  public Color onTertiaryFixedVariant() {
    return new Color(ColorSchemeObjSt.onTertiaryFixedVariant(st));
  }
  public Color errorContainer() {
    return new Color(ColorSchemeObjSt.errorContainer(st));
  }
  public Color onErrorContainer() {
    return new Color(ColorSchemeObjSt.onErrorContainer(st));
  }
  public Color surfaceVariant() {
    return new Color(ColorSchemeObjSt.surfaceVariant(st));
  }
  public Color surfaceDim() {
    return new Color(ColorSchemeObjSt.surfaceDim(st));
  }
  public Color surfaceBright() {
    return new Color(ColorSchemeObjSt.surfaceBright(st));
  }
  public Color surfaceContainerLowest() {
    return new Color(ColorSchemeObjSt.surfaceContainerLowest(st));
  }
  public Color surfaceContainerLow() {
    return new Color(ColorSchemeObjSt.surfaceContainerLow(st));
  }
  public Color surfaceContainer() {
    return new Color(ColorSchemeObjSt.surfaceContainer(st));
  }
  public Color surfaceContainerHigh() {
    return new Color(ColorSchemeObjSt.surfaceContainerHigh(st));
  }
  public Color surfaceContainerHighest() {
    return new Color(ColorSchemeObjSt.surfaceContainerHighest(st));
  }
  public Color onSurfaceVariant() {
    return new Color(ColorSchemeObjSt.onSurfaceVariant(st));
  }
  public Color outline() {
    return new Color(ColorSchemeObjSt.outline(st));
  }
  public Color outlineVariant() {
    return new Color(ColorSchemeObjSt.outlineVariant(st));
  }
  public Color shadow() {
    return new Color(ColorSchemeObjSt.shadow(st));
  }
  public Color scrim() {
    return new Color(ColorSchemeObjSt.scrim(st));
  }
  public Color inverseSurface() {
    return new Color(ColorSchemeObjSt.inverseSurface(st));
  }
  public Color onInverseSurface() {
    return new Color(ColorSchemeObjSt.onInverseSurface(st));
  }
  public Color inversePrimary() {
    return new Color(ColorSchemeObjSt.inversePrimary(st));
  }
  public Color surfaceTint() {
    return new Color(ColorSchemeObjSt.surfaceTint(st));
  }
  public Color background() {
    return new Color(ColorSchemeObjSt.background(st));
  }
  public Color onBackground() {
    return new Color(ColorSchemeObjSt.onBackground(st));
  }
  @Override
  public ColorScheme build() {
    return this;
  }
}
