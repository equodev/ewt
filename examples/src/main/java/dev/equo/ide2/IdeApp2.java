package dev.equo.ide2;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Entry point for the EWT IDE showcase — v2.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.ide2.IdeApp2
 *
 * v2 keeps v1 (dev.equo.ide.IdeApp) untouched as the reference, and rebuilds the
 * chrome on top of the widgets added in the coverage push:
 *
 *   - the bottom panel is now a real DefaultTabController + TabBar + Tab +
 *     TabBarView (v1 hand-rolled the tabs with TextButton + manual state)
 *   - the Problems tab count is a Badge (v1 hand-rolled a rounded container)
 *   - a slide-in Settings panel (AnimatedContainer) hosts Switch / SwitchListTile
 *     / CheckboxListTile / Slider, several of which actually drive the editor
 *   - the status bar carries a ClipRRect avatar chip and a Tooltip
 *
 * It reuses v1's data and palette (IdePalette, CodeSamples, SampleProject, model)
 * so the two run side by side for comparison.
 */
public class IdeApp2 extends SubStatelessWidget {

    public static void main(String[] args) {
        App.runApp(IdeApp2::new);
    }

    @Override
    protected Widget build(BuildContext context) {
        return MaterialApp()
                .title("EWT IDE v2")
                .debugShowCheckedModeBanner(false)
                .theme(ThemeData().useMaterial3(true).build())
                .darkTheme(ThemeData_dark().useMaterial3(true).build())
                .themeMode(ThemeMode.dark)
                .home(new IdeShell2());
    }
}
