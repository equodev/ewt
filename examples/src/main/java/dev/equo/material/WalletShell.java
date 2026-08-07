package dev.equo.material;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.material.screens.CardsScreen;
import dev.equo.material.screens.HomeScreen;
import dev.equo.material.screens.SendScreen;
import dev.equo.material.screens.WalletSettingsScreen;

/**
 * App shell. Where the Cupertino twin has to hand-roll its tab bar (CupertinoTabBar
 * is not generated yet), the Material side gets the real thing: a Material 3
 * {@code NavigationBar} in Scaffold's own {@code bottomNavigationBar} slot, which
 * brings the pill indicator and the icon/label transitions for free.
 */
public class WalletShell extends SubStatefulWidget {
    @Override
    protected State<WalletShell> createState() {
        return new WalletShellState();
    }
}

class WalletShellState extends SubState<WalletShell> {

    private int tab = 0;

    @Override
    public Widget build(BuildContext context) {
        Widget body = switch (tab) {
            case 0 -> new HomeScreen();
            case 1 -> new CardsScreen();
            case 2 -> new SendScreen();
            default -> new WalletSettingsScreen();
        };

        return Scaffold()
                .backgroundColor(WalletPalette.background())
                .body(body)
                .bottomNavigationBar(NavigationBar()
                        .selectedIndex(tab)
                        .onDestinationSelected(i -> setState(() -> tab = i))
                        .backgroundColor(WalletPalette.bar())
                        .indicatorColor(WalletPalette.card2())
                        .addAllDestinations(List.of(
                                destination(Icons.home_outlined(), Icons.home(), "Home"),
                                destination(Icons.credit_card(), Icons.credit_card(), "Cards"),
                                destination(Icons.send_outlined(), Icons.send(), "Send"),
                                destination(Icons.settings_outlined(), Icons.settings(), "Settings")
                        )));
    }

    private WidgetI destination(IconDataI icon, IconDataI selected, String label) {
        return NavigationDestination(Icon(icon).color(WalletPalette.secondaryLabel()))
                .selectedIcon(Icon(selected).color(WalletPalette.label()))
                .label(label);
    }
}
