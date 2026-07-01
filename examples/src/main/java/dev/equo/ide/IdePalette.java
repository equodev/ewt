package dev.equo.ide;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * "Nebula" palette — deliberately not VS Code. Violet chrome, amber accents,
 * teal for the running state, coral for errors. Colors are returned by
 * methods (never stored) because EWT consumes each Color handle on first use.
 */
public final class IdePalette {
    private IdePalette() {}

    // ── Chrome surfaces ──────────────────────────────────────────────────────
    public static Color bgWindow(boolean dark) {
        return dark ? Color_fromARGB(255, 26, 21, 36).build()
                    : Color_fromARGB(255, 248, 245, 242).build();
    }
    public static Color bgPanel(boolean dark) {
        return dark ? Color_fromARGB(255, 34, 28, 48).build()
                    : Color_fromARGB(255, 239, 234, 228).build();
    }
    public static Color bgEditor(boolean dark) {
        return dark ? Color_fromARGB(255, 20, 16, 29).build()
                    : Color_fromARGB(255, 253, 251, 247).build();
    }
    public static Color bgMenuBar(boolean dark) {
        return dark ? Color_fromARGB(255, 44, 36, 61).build()
                    : Color_fromARGB(255, 234, 226, 214).build();
    }
    public static Color bgToolbar(boolean dark) {
        return dark ? Color_fromARGB(255, 37, 30, 53).build()
                    : Color_fromARGB(255, 242, 235, 224).build();
    }
    public static Color bgActiveTab(boolean dark) { return bgEditor(dark); }
    public static Color bgInactiveTab(boolean dark) {
        return dark ? Color_fromARGB(255, 44, 36, 61).build()
                    : Color_fromARGB(255, 233, 224, 208).build();
    }
    public static Color divider(boolean dark) {
        return dark ? Color_fromARGB(255, 58, 48, 80).build()
                    : Color_fromARGB(255, 217, 207, 191).build();
    }
    public static Color hoverOverlay(boolean dark) {
        return dark ? Color_fromRGBO(255, 255, 255, 0.06).build()
                    : Color_fromRGBO(0, 0, 0, 0.05).build();
    }
    public static Color selectionRow(boolean dark) {
        return dark ? Color_fromRGBO(160, 132, 255, 0.20).build()
                    : Color_fromRGBO(109, 63, 219, 0.13).build();
    }

    // ── Accents (Nebula) ─────────────────────────────────────────────────────
    /** Primary violet — the "brand" color of the IDE. */
    public static Color accent(boolean dark) {
        return dark ? Color_fromARGB(255, 160, 132, 255).build()
                    : Color_fromARGB(255, 109, 63, 219).build();
    }
    /** Warm amber for secondary highlights (badges, active bottom-tab underline). */
    public static Color accent2(boolean dark) {
        return dark ? Color_fromARGB(255, 255, 178, 107).build()
                    : Color_fromARGB(255, 232, 134, 43).build();
    }
    /** Teal used for "running" state and success. */
    public static Color accentRunning(boolean dark) {
        return dark ? Color_fromARGB(255, 94, 234, 212).build()
                    : Color_fromARGB(255, 15, 168, 138).build();
    }
    public static Color accentError() { return Color_fromARGB(255, 255, 109, 138).build(); }
    public static Color accentWarn()  { return Color_fromARGB(255, 255, 178, 107).build(); }
    public static Color accentInfo(boolean dark) { return accent(dark); }

    /** Soft "glow" color for haloing the run pill and other active surfaces. */
    public static Color glow(boolean dark) {
        return dark ? Color_fromRGBO(160, 132, 255, 0.45).build()
                    : Color_fromRGBO(109, 63, 219, 0.35).build();
    }
    public static Color glowRunning(boolean dark) {
        return dark ? Color_fromRGBO(94, 234, 212, 0.55).build()
                    : Color_fromRGBO(15, 168, 138, 0.45).build();
    }

    // ── Text ─────────────────────────────────────────────────────────────────
    public static Color textPrimary(boolean dark) {
        return dark ? Color_fromARGB(255, 232, 224, 245).build()
                    : Color_fromARGB(255, 44, 35, 56).build();
    }
    public static Color textMuted(boolean dark) {
        return dark ? Color_fromARGB(255, 143, 131, 168).build()
                    : Color_fromARGB(255, 133, 120, 160).build();
    }
    public static Color textOnAccent() { return Colors.white(); }

    // ── Syntax spans ─────────────────────────────────────────────────────────
    public static Color synKeyword(boolean dark) {
        return dark ? Color_fromARGB(255, 196, 160, 255).build()
                    : Color_fromARGB(255, 109, 63, 219).build();
    }
    public static Color synType(boolean dark) {
        return dark ? Color_fromARGB(255, 94, 234, 212).build()
                    : Color_fromARGB(255, 15, 118, 110).build();
    }
    public static Color synString(boolean dark) {
        return dark ? Color_fromARGB(255, 255, 178, 107).build()
                    : Color_fromARGB(255, 194, 65, 12).build();
    }
    public static Color synComment(boolean dark) {
        return dark ? Color_fromARGB(255, 107, 92, 138).build()
                    : Color_fromARGB(255, 133, 120, 160).build();
    }
    public static Color synNumber(boolean dark) {
        return dark ? Color_fromARGB(255, 247, 141, 167).build()
                    : Color_fromARGB(255, 190, 24, 93).build();
    }
    public static Color synMuted(boolean dark) { return textPrimary(dark); }

    // ── Typography ───────────────────────────────────────────────────────────
    public static TextStyleI ui(boolean dark) {
        return TextStyle().fontSize(13.0).color(textPrimary(dark));
    }
    public static TextStyleI uiMuted(boolean dark) {
        return TextStyle().fontSize(12.0).color(textMuted(dark));
    }
    public static TextStyleI uiStrong(boolean dark) {
        return TextStyle().fontSize(13.0).fontWeight(FontWeight.w600()).color(textPrimary(dark));
    }
    public static TextStyleI menuItem(boolean dark) {
        return TextStyle().fontSize(13.0).color(textPrimary(dark));
    }
    public static TextStyleI tabLabelActive(boolean dark) {
        return TextStyle().fontSize(13.0).fontWeight(FontWeight.w600()).color(textPrimary(dark));
    }
    public static TextStyleI tabLabelInactive(boolean dark) {
        return TextStyle().fontSize(13.0).color(textMuted(dark));
    }
    public static TextStyleI statusBar() {
        return TextStyle().fontSize(12.0).fontWeight(FontWeight.w500()).color(Colors.white());
    }
    public static TextStyleI sectionCaps(boolean dark) {
        return TextStyle()
                .fontSize(11.0)
                .fontWeight(FontWeight.w700())
                .letterSpacing(0.9)
                .color(accent2(dark));
    }
    public static TextStyleI code(boolean dark) {
        return TextStyle()
                .fontFamily("monospace")
                .fontSize(13.5)
                .height(1.5)
                .color(textPrimary(dark));
    }
    public static TextStyleI codeSpan(boolean dark, Color color) {
        return TextStyle()
                .fontFamily("monospace")
                .fontSize(13.5)
                .height(1.5)
                .color(color);
    }
    public static TextStyleI codeSpanBold(boolean dark, Color color) {
        return TextStyle()
                .fontFamily("monospace")
                .fontSize(13.5)
                .height(1.5)
                .fontWeight(FontWeight.w600())
                .color(color);
    }
    public static TextStyleI gutter(boolean dark) {
        return TextStyle()
                .fontFamily("monospace")
                .fontSize(12.5)
                .height(1.5)
                .color(textMuted(dark));
    }
}
