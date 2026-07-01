package dev.equo.showcase;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

class ShowcaseApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
        return MaterialApp()
                .title("EWT Widget Showcase")
                .theme(ThemeData()
                        .colorScheme(ColorScheme_fromSeed(Palette.seed()))
                        .useMaterial3(true))
                .home(new ShowcaseShell());
    }
}
