package dev.equo.engagements;

import dev.equo.engagements.data.SeedData;
import dev.equo.engagements.screens.AppShell;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.State;
import dev.equo.ewt.SubState;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.Widget;

import static dev.equo.ewt.EWT.Theme;

/**
 * Attach-mode entry (Evolve/web): owns AppState and returns AppShell wrapped
 * in an EWT Theme so the terracotta palette applies to our subtree. Skips
 * MaterialApp because Evolve provides the outer app/theme at its own root.
 */
public class EngagementsAttachPage extends SubStatefulWidget {

  @Override
  protected State<EngagementsAttachPage> createState() {
    return new AttachState();
  }

  static class AttachState extends SubState<EngagementsAttachPage> {
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
      boolean dark = state.darkMode();
      return Theme(
          dark ? EngagementsTheme.dark() : EngagementsTheme.light(),
          new AppShell(state)).build();
    }
  }
}
