package dev.equo.material;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Presentation helpers shared by the Material Wallet screens — the Material
 * counterpart of {@code dev.equo.cupertino.WalletKit}. Same helper set, so the
 * screens read the same in both apps; only the widgets underneath change
 * (Material {@code Card} and {@code Divider} instead of a hand-rolled rounded
 * container and hairline).
 */
public final class WalletKit {
    private WalletKit() {}

    /** An elevated Material card, inset from the edges. */
    public static Widget card(Widget child) {
        return Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(6.0).build())
                .child(Card()
                        .color(WalletPalette.card())
                        .elevation(1.0)
                        .clipBehavior(Clip.antiAlias)
                        .shape(RoundedRectangleBorder().borderRadius(BorderRadius_circular(12.0)))
                        .child(child));
    }

    /** A section header in the Material label style (sentence case, accented). */
    public static Widget header(String text) {
        return Padding(EdgeInsets_only().left(28.0).top(20.0).bottom(6.0).build())
                .child(Align().alignment(Alignment.centerLeft())
                        .child(Text(text).style(WalletPalette.sectionHeader())));
    }

    /** A Material divider between list rows. */
    public static Widget divider() {
        return Divider()
                .height(1.0).thickness(1.0).indent(64.0)
                .color(WalletPalette.separator());
    }

    /** A CircleAvatar, the Material list-leading convention (iOS uses a rounded square). */
    public static Widget iconTile(IconDataI icon, Color color, double size) {
        return CircleAvatar()
                .radius(size / 2)
                .backgroundColor(color)
                .child(Icon(icon).color(WalletPalette.background()).size(size * 0.5));
    }

    /**
     * A quick-action button. InkWell gives it the Material ink ripple on tap —
     * the touch feedback iOS deliberately does not have.
     */
    public static Widget circleAction(IconDataI icon, String label, Color color, Runnable onTap) {
        return InkWell()
                .onTap(onTap)
                .borderRadius(BorderRadius_circular(16.0))
                .child(Padding(EdgeInsets_all(4.0)).child(
                        Column().mainAxisSize(MainAxisSize.min).children(List.of(
                                Container()
                                        .width(56.0).height(56.0)
                                        .decoration(BoxDecoration().color(WalletPalette.card2())
                                                .borderRadius(BorderRadius_circular(16.0)))
                                        .child(Center().child(Icon(icon).color(color).size(24.0))),
                                SizedBox().height(8.0),
                                Text(label).style(WalletPalette.rowSub())
                        ))));
    }
}
