package dev.equo.cupertino;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * An iOS-style Wallet / banking demo (in the spirit of Revolut / Apple Card),
 * built in Java and rendered with Cupertino widgets. The iOS counterpart to the
 * Material demos, so the two looks can be compared from the same kind of code.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.cupertino.WalletApp
 *
 * Four tabs behind a hand-built bottom bar (CupertinoTabBar isn't generated yet):
 * Home, Cards, Send and Settings.
 */
public class WalletApp extends SubStatelessWidget {

    public static void main(String[] args) {
        App.runApp(WalletApp::new);
    }

    @Override
    protected Widget build(BuildContext context) {
        return CupertinoApp()
                .title("EWT Wallet")
                .debugShowCheckedModeBanner(false)
                .home(new WalletShell());
    }
}
