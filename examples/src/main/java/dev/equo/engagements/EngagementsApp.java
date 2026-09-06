package dev.equo.engagements;

import dev.equo.engagements.data.SeedData;
import dev.equo.engagements.screens.AppShell;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.ewt.App;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.State;
import dev.equo.ewt.SubState;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.ThemeMode;
import dev.equo.ewt.Widget;

import static dev.equo.ewt.EWT.MaterialApp;

/**
 * Root of the Engagements Console. Owns the AppState and wraps it in a
 * MaterialApp with a themeMode driven by {@link AppState#darkMode()}.
 */
public class EngagementsApp extends SubStatefulWidget {

  public static void main(String[] args) {
    App.runApp(EngagementsApp::new);
  }

  @Override
  protected State<EngagementsApp> createState() {
    return new AppRoot();
  }

  static class AppRoot extends SubState<EngagementsApp> {
    private final AppState state = SeedData.build();
    private Runnable listener;

    @Override
    protected void initState() {
      listener = () -> { if (mounted()) setState(() -> {}); };
      state.addStructuralListener(listener);
    }

    @Override
    protected void dispose() {
      state.removeStructuralListener(listener);
    }

    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("Engagements Console")
          .theme(EngagementsTheme.light())
          .darkTheme(EngagementsTheme.dark())
          .themeMode(state.darkMode() ? ThemeMode.dark : ThemeMode.light)
          .home(new AppShell(state));
    }
  }
}
