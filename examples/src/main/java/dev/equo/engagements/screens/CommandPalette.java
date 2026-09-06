package dev.equo.engagements.screens;

import java.util.ArrayList;
import java.util.List;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Client;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.Colors;
import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.EdgeInsets;
import dev.equo.ewt.FontWeight;
import dev.equo.ewt.IconDataI;
import dev.equo.ewt.Navigator;
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

import static dev.equo.ewt.EWT.BorderRadius_circular;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.Dialog;
import static dev.equo.ewt.EWT.Divider;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.InputDecoration;
import static dev.equo.ewt.EWT.ListTile;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.TextField;
import static dev.equo.ewt.EWT.showDialog;

/** Search-anywhere dialog: jump to a client, engagement, or team member. */
public final class CommandPalette {

  private static final double WIDTH = 620.0;
  private static final double HEIGHT = 480.0;

  private CommandPalette() {}

  public static void show(BuildContext context, AppState state) {
    showDialog(context, ctx -> Dialog()
        .insetPadding(EdgeInsets.symmetric().horizontal(40.0).vertical(140.0).build())
        .child(new PaletteContent(state)));
  }

  static class PaletteContent extends SubStatefulWidget {
    final AppState state;
    PaletteContent(AppState s) { this.state = s; }
    @Override protected State<PaletteContent> createState() { return new PaletteState(state); }
  }

  static class PaletteState extends SubState<PaletteContent> {
    private final AppState state;
    private String query = "";

    PaletteState(AppState state) { this.state = state; }

    @Override
    protected Widget build(BuildContext context) {
      AppState s = state;
      boolean dark = s.darkMode();
      List<Result> results = search(s, query);
      return SizedBox().width(WIDTH).height(HEIGHT).child(Column().children(List.of(
          searchField(),
          Divider().height(1.0).color(EngagementsTheme.hairline(dark)),
          Expanded().child(resultList(context, s, results, dark)))));
    }

    private WidgetI searchField() {
      return Padding(EdgeInsets_all(12.0)).child(TextField()
          .autofocus(true)
          .decoration(InputDecoration()
              .hintText("Type to jump to a client, engagement, or team member")
              .prefixIcon(Icon(Icons.search()))
              .border(dev.equo.ewt.EWT.OutlineInputBorder().build())
              .isDense(true)
              .contentPadding(EdgeInsets_symmetric().horizontal(10.0).vertical(12.0).build())
              .build())
          .onChanged(v -> setState(() -> query = v))
          .build());
    }

    private WidgetI resultList(BuildContext ctx, AppState s, List<Result> results, boolean dark) {
      if (results.isEmpty()) {
        return Padding(EdgeInsets_all(20.0))
            .child(Text("No matches").style(TextStyle().color(EngagementsTheme.muted(dark))));
      }
      return ListView.builder()
          .itemCount(results.size())
          .itemBuilder((c, i) -> resultTile(ctx, s, results.get(i), dark))
          .build();
    }

    private Widget resultTile(BuildContext ctx, AppState s, Result r, boolean dark) {
      return ListTile()
          .dense(true)
          .leading(Container().width(28.0).height(28.0)
              .decoration(dev.equo.ewt.EWT.BoxDecoration()
                  .color(EngagementsTheme.subtle(dark))
                  .borderRadius(BorderRadius_circular(6.0)))
              .child(Icon(r.icon).size(16.0).color(EngagementsTheme.accent())))
          .title(Text(r.title).style(TextStyle().fontSize(13.0).fontWeight(FontWeight.w600())))
          .subtitle(Text(r.subtitle).style(TextStyle().fontSize(11.0)
              .color(EngagementsTheme.muted(dark))))
          .trailing(Text(r.kind).style(TextStyle().fontSize(10.0).letterSpacing(0.8)
              .color(EngagementsTheme.muted(dark))))
          .onTap(() -> { Navigator.pop(ctx); r.action.run(); })
          .build();
    }

    // --- search ---------------------------------------------------------

    private static List<Result> search(AppState s, String q) {
      List<Result> out = new ArrayList<>();
      addEngagements(s, q, out);
      addClients(s, q, out);
      addPeople(s, q, out);
      return out.stream().limit(30).toList();
    }

    private static void addEngagements(AppState s, String q, List<Result> out) {
      for (Engagement e : s.engagements()) {
        if (!matches(q, e.name())) continue;
        Client c = s.client(e.clientId());
        out.add(new Result(
            "ENG", Icons.assignment(),
            e.name(),
            (c != null ? c.name() : "?") + " · " + e.status().name(),
            () -> s.openEngagementTab(e.id())));
      }
    }

    private static void addClients(AppState s, String q, List<Result> out) {
      for (Client c : s.clients()) {
        if (!matches(q, c.name()) && !matches(q, c.industry())) continue;
        int n = s.engagementsForClient(c.id()).size();
        out.add(new Result(
            "CLIENT", Icons.business(),
            c.name(),
            c.industry() + " · " + n + " engagements",
            () -> {}));
      }
    }

    private static void addPeople(AppState s, String q, List<Result> out) {
      for (Person p : s.people()) {
        if (!matches(q, p.name()) && !matches(q, p.role())) continue;
        out.add(new Result(
            "PERSON", Icons.people(),
            p.name(),
            p.role(),
            () -> {}));
      }
    }

    private static boolean matches(String q, String value) {
      if (q.isBlank()) return true;
      return value.toLowerCase().contains(q.toLowerCase());
    }
  }

  private record Result(String kind, IconDataI icon, String title, String subtitle, Runnable action) {}
}
