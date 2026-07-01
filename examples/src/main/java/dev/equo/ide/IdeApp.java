package dev.equo.ide;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Entry point for the EWT IDE showcase. */
public class IdeApp extends SubStatelessWidget {

    public static void main(String[] args) {
        App.runApp(IdeApp::new);
    }

    @Override
    protected Widget build(BuildContext context) {
        return MaterialApp()
                .title("EWT IDE")
                .debugShowCheckedModeBanner(false)
                .theme(ThemeData().useMaterial3(true).build())
                .darkTheme(ThemeData_dark().useMaterial3(true).build())
                .themeMode(ThemeMode.dark)
                .home(new IdeShell());
    }
}
