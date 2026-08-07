package dev.equo.material;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Dark palette for the Material Wallet demo — the Material counterpart of
 * {@code dev.equo.cupertino.WalletPalette}.
 *
 * The roles are the same (background, card, accents, label styles) so the two
 * apps can be compared side by side, but the values follow Material 3 dark
 * surfaces (elevated greys tinted towards the primary) instead of the iOS
 * grouped-list blacks, and the accent is the Material purple rather than the
 * system blue.
 */
public final class WalletPalette {
    private WalletPalette() {}

    // Material 3 dark surfaces: never pure black, each level a bit lighter.
    public static Color background() { return Color_fromARGB(255, 20, 18, 24).build(); }
    public static Color card()       { return Color_fromARGB(255, 33, 31, 38).build(); }
    public static Color card2()      { return Color_fromARGB(255, 46, 44, 52).build(); }
    public static Color bar()        { return Color_fromARGB(255, 28, 26, 33).build(); }
    public static Color separator()  { return Color_fromARGB(255, 73, 69, 79).build(); }

    // Accents — Material palette (primary is the M3 purple, not the iOS blue).
    public static Color primary() { return Color_fromARGB(255, 208, 188, 255).build(); }
    public static Color blue()    { return Color_fromARGB(255, 124, 156, 255).build(); }
    public static Color green()   { return Color_fromARGB(255, 129, 201, 149).build(); }
    public static Color red()     { return Color_fromARGB(255, 242, 184, 181).build(); }
    public static Color orange()  { return Color_fromARGB(255, 255, 183, 122).build(); }
    public static Color indigo()  { return Color_fromARGB(255, 154, 146, 255).build(); }
    public static Color teal()    { return Color_fromARGB(255, 128, 209, 197).build(); }
    public static Color pink()    { return Color_fromARGB(255, 240, 160, 200).build(); }

    // Payment-card face colours (solid, no gradient available yet).
    public static Color cardViolet() { return Color_fromARGB(255, 79, 55, 139).build(); }
    public static Color cardSlate()  { return Color_fromARGB(255, 45, 45, 58).build(); }
    public static Color cardTeal()   { return Color_fromARGB(255, 30, 105, 110).build(); }

    public static Color label()          { return Color_fromARGB(255, 230, 224, 233).build(); }
    public static Color secondaryLabel() { return Color_fromARGB(255, 202, 196, 208).build(); }
    public static Color onCardMuted()    { return Color_fromARGB(220, 255, 255, 255).build(); }

    // Material type scale: titleLarge for the app bar, labelLarge for sections.
    public static TextStyleI navTitle() {
        return TextStyle().fontSize(22.0).fontWeight(FontWeight.w400()).color(label());
    }
    public static TextStyleI sectionHeader() {
        return TextStyle().fontSize(14.0).fontWeight(FontWeight.w500())
                .letterSpacing(0.1).color(primary());
    }
    public static TextStyleI rowTitle() {
        return TextStyle().fontSize(16.0).color(label());
    }
    public static TextStyleI rowSub() {
        return TextStyle().fontSize(14.0).color(secondaryLabel());
    }
    public static TextStyleI amount(Color c) {
        return TextStyle().fontSize(16.0).fontWeight(FontWeight.w500()).color(c);
    }
    public static TextStyleI tabLabel(boolean active) {
        return TextStyle().fontSize(12.0)
                .fontWeight(active ? FontWeight.w600() : FontWeight.w400())
                .color(active ? label() : secondaryLabel());
    }
}
