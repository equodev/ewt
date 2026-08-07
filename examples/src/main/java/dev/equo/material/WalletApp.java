package dev.equo.material;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * The Material twin of {@code dev.equo.cupertino.WalletApp}: the same wallet /
 * banking app — same screens, same state, same interactions — built entirely
 * with Material widgets instead of Cupertino ones, so the two can be compared
 * screen by screen.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.material.WalletApp
 *
 * Four tabs behind a bottom bar: Home, Cards, Send and Settings.
 */
public class WalletApp extends SubStatelessWidget {

    public static void main(String[] args) {
        App.runApp(WalletApp::new);
    }

    @Override
    protected Widget build(BuildContext context) {
        return MaterialApp()
                .title("EWT Wallet")
                .debugShowCheckedModeBanner(false)
                .theme(ThemeData_dark())
                .home(new WalletShell());
    }
}
