package dev.equo.cupertino;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.cupertino.screens.CardsScreen;
import dev.equo.cupertino.screens.HomeScreen;
import dev.equo.cupertino.screens.SendScreen;
import dev.equo.cupertino.screens.WalletSettingsScreen;

/**
 * App shell. CupertinoTabBar isn't generated yet, so the bottom tab bar is
 * hand-built: a row of tappable icon+label items over a bordered bar, with the
 * body swapping between the four screens by index.
 */
public class WalletShell extends SubStatefulWidget {
    @Override
    protected State<WalletShell> createState() {
        return new WalletShellState();
    }
}

class WalletShellState extends SubState<WalletShell> {

    private int tab = 0;

    private void select(int i) {
        setState(() -> tab = i);
    }

    @Override
    public Widget build(BuildContext context) {
        Widget body = switch (tab) {
            case 0 -> new HomeScreen();
            case 1 -> new CardsScreen();
            case 2 -> new SendScreen();
            default -> new WalletSettingsScreen();
        };

        return Container()
                .color(WalletPalette.background())
                .child(Column().children(List.of(
                        Expanded().child(body),
                        tabBar()
                )));
    }

    private Widget tabBar() {
        return Container()
                .decoration(BoxDecoration()
                        .color(WalletPalette.bar())
                        .border(Border().top(BorderSide()
                                .color(WalletPalette.separator()).width(0.5).build())))
                .padding(EdgeInsets_only().top(8.0).bottom(20.0).build())
                .child(Row()
                        .mainAxisAlignment(MainAxisAlignment.spaceAround)
                        .children(List.of(
                                item(0, CupertinoIcons.house_fill(), "Home"),
                                item(1, CupertinoIcons.creditcard_fill(), "Cards"),
                                item(2, CupertinoIcons.paperplane_fill(), "Send"),
                                item(3, CupertinoIcons.gear_alt_fill(), "Settings")
                        )));
    }

    private Widget item(int i, IconDataI icon, String label) {
        boolean active = tab == i;
        Color color = active ? WalletPalette.blue() : WalletPalette.secondaryLabel();
        return GestureDetector().onTap(() -> select(i)).child(Container()
                .color(Color_fromARGB(0, 0, 0, 0).build())
                .padding(EdgeInsets_symmetric().horizontal(16.0).build())
                .child(Column().mainAxisSize(MainAxisSize.min).children(List.of(
                        Icon(icon).color(color).size(25.0),
                        SizedBox().height(3.0),
                        Text(label).style(WalletPalette.tabLabel(active))
                ))));
    }
}
