package dev.equo.showcase;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Shared color and typography tokens for the showcase.
 *
 * Important: colors are returned by methods (not stored in static fields).
 * EWT consumes a Color's native handle on first use, so reusing the same
 * Color instance across multiple widgets in one render fails. Each call
 * here returns a fresh instance, matching the inline {@code Colors.X()}
 * pattern used in the existing demos.
 */
final class Palette {
    private Palette() {}

    static MaterialColor seed()         { return Colors.deepPurple(); }

    static Color bgHome()      { return Colors.deepPurple().shade50(); }
    static Color bgLab()       { return Colors.pink().shade50(); }
    static Color bgInteract()  { return Colors.teal().shade50(); }
    static Color bgGallery()   { return Colors.amber().shade50(); }

    static Color accentPurple()  { return Colors.deepPurple().shade400(); }
    static Color accentPink()    { return Colors.pink().shade400(); }
    static Color accentTeal()    { return Colors.teal().shade400(); }
    static Color accentAmber()   { return Colors.amber().shade700(); }
    static Color accentCyan()    { return Colors.cyan().shade400(); }
    static Color accentOrange()  { return Colors.deepOrange().shade400(); }
    static Color accentIndigo()  { return Colors.indigo().shade400(); }

    static TextStyleI display() {
        return TextStyle()
                .fontSize(34.0)
                .fontWeight(FontWeight.w800())
                .color(accentPurple())
                .letterSpacing(-0.5);
    }

    static TextStyleI sectionTitle() {
        return TextStyle()
                .fontSize(20.0)
                .fontWeight(FontWeight.w700())
                .color(Colors.black87());
    }

    static TextStyleI subtitle() {
        return TextStyle()
                .fontSize(15.0)
                .color(Colors.black54())
                .height(1.4);
    }

    static TextStyleI caption() {
        return TextStyle()
                .fontSize(13.0)
                .color(Colors.black54());
    }

    static TextStyleI navTitle() {
        return TextStyle()
                .fontSize(20.0)
                .fontWeight(FontWeight.w700())
                .color(Colors.white());
    }

    static TextStyleI navSubtitle() {
        return TextStyle()
                .fontSize(13.0)
                .color(Colors.white());
    }

    static BoxShadowI softShadow() {
        return BoxShadow()
                .color(Color_fromRGBO(0, 0, 0, 0.18))
                .blurRadius(18.0)
                .offset(Offset(0.0, 8.0));
    }
}
