package dev.equo.cupertino;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Presentation helpers shared by the Wallet screens. */
public final class WalletKit {
    private WalletKit() {}

    /** A rounded dark card, iOS grouped style, inset from the edges. */
    public static Widget card(Widget child) {
        return Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(6.0).build())
                .child(ClipRRect().borderRadius(BorderRadius_circular(14.0))
                        .child(Container().color(WalletPalette.card()).child(child)));
    }

    /** An uppercase grouped-list section header. */
    public static Widget header(String text) {
        return Padding(EdgeInsets_only().left(30.0).top(18.0).bottom(4.0).build())
                .child(Align().alignment(Alignment.centerLeft())
                        .child(Text(text).style(WalletPalette.sectionHeader())));
    }

    /** A hairline divider inset to the content, like iOS list rows. */
    public static Widget divider() {
        return Padding(EdgeInsets_only().left(60.0).build())
                .child(Container().height(0.5).color(WalletPalette.separator()));
    }

    /** A rounded coloured icon tile. */
    public static Widget iconTile(IconDataI icon, Color color, double size) {
        return Container()
                .width(size).height(size)
                .decoration(BoxDecoration().color(color).borderRadius(BorderRadius_circular(size * 0.28)))
                .child(Center().child(Icon(icon).color(Colors.white()).size(size * 0.55)));
    }

    /** A circular icon button used for the quick actions row. */
    public static Widget circleAction(IconDataI icon, String label, Color color, Runnable onTap) {
        return GestureDetector().onTap(onTap).child(Column().mainAxisSize(MainAxisSize.min).children(List.of(
                Container()
                        .width(52.0).height(52.0)
                        .decoration(BoxDecoration().color(WalletPalette.card2())
                                .borderRadius(BorderRadius_circular(26.0)))
                        .child(Center().child(Icon(icon).color(color).size(22.0))),
                SizedBox().height(6.0),
                Text(label).style(WalletPalette.rowSub())
        )));
    }
}
