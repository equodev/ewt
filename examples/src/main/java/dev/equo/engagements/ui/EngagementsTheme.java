package dev.equo.engagements.ui;

import dev.equo.ewt.Brightness;
import dev.equo.ewt.Color;
import dev.equo.ewt.ColorI;
import dev.equo.ewt.ColorScheme;
import dev.equo.ewt.Colors;
import dev.equo.ewt.ThemeData;

import static dev.equo.ewt.EWT.Color_fromARGB;
import static dev.equo.ewt.EWT.ColorScheme_fromSeed;
import static dev.equo.ewt.EWT.ThemeData;

/**
 * Warm-neutral palette with a terracotta accent — deliberately not the blue-heavy
 * Vaadin default. Cards render as elevation 0 + hairline (styling applied per-card
 * where used, since ThemeData's CardTheme surface isn't in the current catalog).
 */
public final class EngagementsTheme {

  private EngagementsTheme() {}

  public static Color accent()      { return Color_fromARGB(255, 189, 102, 79).build();  } // terracotta
  public static Color accentDark()  { return Color_fromARGB(255, 220, 140, 118).build(); }
  public static Color hairlineLight(){ return Colors.grey().shade300(); }
  public static Color hairlineDark() { return Color_fromARGB(255, 70, 60, 55).build(); }
  public static Color surfaceLight() { return Colors.grey().shade50(); }
  public static Color surfaceDark()  { return Color_fromARGB(255, 30, 26, 24).build(); }

  public static ColorI hairline(boolean dark) { return dark ? hairlineDark() : hairlineLight(); }
  public static ColorI muted(boolean dark) { return dark ? Colors.grey().shade400() : Colors.grey().shade600(); }
  public static ColorI subtle(boolean dark) { return dark ? Color_fromARGB(255, 45, 38, 34).build() : Colors.grey().shade100(); }

  public static ThemeData light() {
    ColorScheme cs = ColorScheme_fromSeed(accent()).brightness(Brightness.light).build();
    return ThemeData().colorScheme(cs).useMaterial3(true).build();
  }

  public static ThemeData dark() {
    ColorScheme cs = ColorScheme_fromSeed(accent()).brightness(Brightness.dark).build();
    return ThemeData().colorScheme(cs).useMaterial3(true).build();
  }
}
