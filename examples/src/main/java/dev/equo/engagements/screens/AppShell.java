package dev.equo.engagements.screens;

import java.util.ArrayList;
import java.util.List;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.Colors;
import dev.equo.ewt.EdgeInsets;
import dev.equo.ewt.MainAxisSize;
import dev.equo.ewt.ScaffoldMessenger;
import dev.equo.ewt.State;
import dev.equo.ewt.SubState;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.Widget;
import dev.equo.ewt.WidgetI;
import dev.equo.ewt.Card;
import dev.equo.ewt.ElevatedButton;
import dev.equo.ewt.GridView;
import dev.equo.ewt.IconDataI;
import dev.equo.ewt.Icons;
import dev.equo.ewt.ListView;
import dev.equo.ewt.PreferredSizeWidget;
import dev.equo.ewt.TextStyle;

import static dev.equo.ewt.EWT.AppBar;
import static dev.equo.ewt.EWT.DefaultTabController;
import static dev.equo.ewt.EWT.Duration;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.IconButton;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.Scaffold;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.SnackBar;
import static dev.equo.ewt.EWT.SnackBarAction;
import static dev.equo.ewt.EWT.Tab;
import static dev.equo.ewt.EWT.TabBar;
import static dev.equo.ewt.EWT.TabBarView;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.Tooltip;
import static dev.equo.ewt.EWT.VisualDensity;

/** Root Scaffold. Owns the top tab bar and wires the AppBar action buttons. */
public class AppShell extends SubStatefulWidget {

  final AppState state;

  public AppShell(AppState state) { this.state = state; }

  @Override
  protected State<AppShell> createState() { return new ShellState(state); }

  static class ShellState extends SubState<AppShell> {
    private final AppState state;
    private Runnable structural;

    ShellState(AppState state) { this.state = state; }

    @Override
    protected void initState() {
      structural = () -> { if (mounted()) setState(() -> {}); };
      state.addStructuralListener(structural);
    }

    @Override
    protected void dispose() { state.removeStructuralListener(structural); }

    @Override
    protected Widget build(BuildContext context) {
      AppState s = state;
      boolean dark = s.darkMode();
      List<String> engIds = s.openEngagementIds();
      int length = 1 + engIds.size();
      int active = Math.max(0, Math.min(s.activeTabIndex(), length - 1));

      return DefaultTabController(length)
          .initialIndex(active)
          .child(Scaffold()
              .appBar(topAppBar(context, s, engIds, dark))
              .backgroundColor(dark ? EngagementsTheme.surfaceDark() : EngagementsTheme.surfaceLight())
              .body(TabBarView(pages(s, engIds)).build()));
    }

    // --- AppBar --------------------------------------------------------

    private PreferredSizeWidget topAppBar(BuildContext ctx, AppState s, List<String> engIds, boolean dark) {
      return AppBar()
          .title(Text("Engagements Console"))
          .actions(actionButtons(ctx, s, dark))
          .bottom(tabBar(s, engIds, dark))
          .build();
    }

    private List<WidgetI> actionButtons(BuildContext ctx, AppState s, boolean dark) {
      List<WidgetI> actions = new ArrayList<>();
      actions.add(iconAction(Icons.search(), "Command palette",
          () -> CommandPalette.show(ctx, s)));
      actions.add(iconAction(Icons.add(), "New engagement",
          () -> NewEngagementWizard.show(ctx, s,
              e -> showUndo(ctx, s, "Engagement \"" + e.name() + "\" created"))));
      actions.add(iconAction(Icons.people(), "Clients directory",
          () -> ClientsDirectory.show(ctx, s)));
      actions.add(iconAction(Icons.group(), "Team",
          () -> TeamPage.show(ctx, s)));
      actions.add(iconAction(dark ? Icons.light_mode() : Icons.dark_mode(),
          dark ? "Switch to light" : "Switch to dark",
          s::toggleDarkMode));
      s.peekUndoLabel().ifPresent(lbl ->
          actions.add(iconAction(Icons.undo(), "Undo last: " + lbl, s::undoLast)));
      actions.add(SizedBox().width(6.0));
      return actions;
    }

    private WidgetI iconAction(dev.equo.ewt.IconDataI icon, String tip, Runnable onTap) {
      return Tooltip().message(tip).child(
          IconButton().icon(Icon(icon)).onPressed(onTap).build());
    }

    // --- Tab strip -----------------------------------------------------

    private dev.equo.ewt.PreferredSizeWidget tabBar(AppState s, List<String> engIds, boolean dark) {
      List<WidgetI> tabs = new ArrayList<>();
      tabs.add(homeTab());
      for (String id : engIds) tabs.add(engagementTab(s, id));
      return TabBar(tabs).isScrollable(true)
          .indicatorColor(dark ? EngagementsTheme.accentDark() : EngagementsTheme.accent())
          .labelColor(dark ? Colors.white() : EngagementsTheme.accent())
          .unselectedLabelColor(EngagementsTheme.muted(dark))
          .padding(EdgeInsets_symmetric().horizontal(12.0).build())
          .build();
    }

    private WidgetI homeTab() {
      return Tab().text("Home").icon(Icon(Icons.home()).size(18.0));
    }

    private WidgetI engagementTab(AppState s, String id) {
      Engagement e = s.engagement(id);
      String label = e != null ? e.name() : id;
      return Tab().child(Row().mainAxisSize(MainAxisSize.min).children(List.of(
          Text(label),
          SizedBox().width(6.0),
          closeTabButton(s, id))));
    }

    private WidgetI closeTabButton(AppState s, String id) {
      return IconButton().icon(Icon(Icons.close()).size(14.0))
          .padding(EdgeInsets.zero())
          .visualDensity(VisualDensity().horizontal(-4.0).vertical(-4.0).build())
          .iconSize(14.0)
          .tooltip("Close tab")
          .onPressed(() -> s.closeEngagementTab(id))
          .build();
    }

    // --- Tab pages -----------------------------------------------------

    private List<WidgetI> pages(AppState s, List<String> engIds) {
      List<WidgetI> pages = new ArrayList<>();
      pages.add(new HomeTab(s));
      for (String id : engIds) pages.add(new EngagementTab(s, id));
      return pages;
    }
  }

  /** SnackBar with an "Undo" action bound to the last mutation. */
  public static void showUndo(BuildContext context, AppState state, String message) {
    ScaffoldMessenger.showSnackBar(context,
        SnackBar(Text(message))
            .duration(Duration().seconds(4).build())
            .action(SnackBarAction().label("Undo").onPressed(state::undoLast).build())
            .build());
  }
}
