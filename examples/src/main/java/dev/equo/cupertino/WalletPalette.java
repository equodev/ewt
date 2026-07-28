package dev.equo.cupertino;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Dark palette for the Wallet demo. Every surface sets its colour explicitly so
 * the look stays consistent regardless of the host's brightness (without
 * CupertinoTheme the Cupertino widgets would otherwise follow the OS).
 */
public final class WalletPalette {
    private WalletPalette() {}

    public static Color background() { return Color_fromARGB(255, 0, 0, 0).build(); }
    public static Color card()       { return Color_fromARGB(255, 28, 28, 30).build(); }
    public static Color card2()      { return Color_fromARGB(255, 44, 44, 46).build(); }
    public static Color bar()        { return Color_fromARGB(255, 22, 22, 24).build(); }
    public static Color separator()  { return Color_fromARGB(255, 56, 56, 58).build(); }

    // Accents
    public static Color blue()   { return Color_fromARGB(255, 10, 132, 255).build(); }
    public static Color green()  { return Color_fromARGB(255, 48, 209, 88).build(); }
    public static Color red()    { return Color_fromARGB(255, 255, 69, 58).build(); }
    public static Color orange() { return Color_fromARGB(255, 255, 159, 10).build(); }
    public static Color indigo() { return Color_fromARGB(255, 94, 92, 230).build(); }
    public static Color teal()   { return Color_fromARGB(255, 64, 200, 224).build(); }
    public static Color pink()   { return Color_fromARGB(255, 255, 55, 95).build(); }

    // Payment-card face colours (solid, no gradient available yet)
    public static Color cardViolet() { return Color_fromARGB(255, 90, 60, 200).build(); }
    public static Color cardSlate()  { return Color_fromARGB(255, 38, 42, 56).build(); }
    public static Color cardTeal()   { return Color_fromARGB(255, 20, 110, 120).build(); }

    public static Color label()          { return Color_fromARGB(255, 255, 255, 255).build(); }
    public static Color secondaryLabel() { return Color_fromARGB(255, 152, 152, 159).build(); }
    public static Color onCardMuted()    { return Color_fromARGB(220, 255, 255, 255).build(); }

    public static TextStyleI navTitle() {
        return TextStyle().fontSize(17.0).fontWeight(FontWeight.w600()).color(label());
    }
    public static TextStyleI sectionHeader() {
        return TextStyle().fontSize(13.0).fontWeight(FontWeight.w600()).color(secondaryLabel());
    }
    public static TextStyleI rowTitle() {
        return TextStyle().fontSize(16.0).color(label());
    }
    public static TextStyleI rowSub() {
        return TextStyle().fontSize(13.0).color(secondaryLabel());
    }
    public static TextStyleI amount(Color c) {
        return TextStyle().fontSize(16.0).fontWeight(FontWeight.w600()).color(c);
    }
    public static TextStyleI tabLabel(boolean active) {
        return TextStyle().fontSize(10.0).color(active ? blue() : secondaryLabel());
    }
}
