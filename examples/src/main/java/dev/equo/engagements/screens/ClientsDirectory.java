package dev.equo.engagements.screens;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Client;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.engagements.ui.SectionHeader;
import dev.equo.engagements.ui.StatusChip;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.Colors;
import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.EdgeInsets;
import dev.equo.ewt.FontWeight;
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

import static dev.equo.ewt.EWT.AppBar;
import static dev.equo.ewt.EWT.Center;
import static dev.equo.ewt.EWT.CircleAvatar;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Dialog;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.ExpansionTile;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.IconButton;
import static dev.equo.ewt.EWT.ListTile;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.Scaffold;
import static dev.equo.ewt.EWT.SearchBar;
import static dev.equo.ewt.EWT.SingleChildScrollView;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.VerticalDivider;
import static dev.equo.ewt.EWT.showDialog;

/** Full-screen modal: searchable list of clients + detail of the selected one. */
public final class ClientsDirectory {

  private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("MMM d, yyyy");
  private static final double LIST_WIDTH = 340.0;
  private static final double DIALOG_WIDTH = 1000.0;
  private static final double DIALOG_HEIGHT = 640.0;

  private ClientsDirectory() {}

  public static void show(BuildContext context, AppState state) {
    showDialog(context, ctx -> Dialog()
        .insetPadding(EdgeInsets.all(24.0))
        .child(new DirectoryContent(state)));
  }

  // --- SubState -----------------------------------------------------------

  static class DirectoryContent extends SubStatefulWidget {
    final AppState state;
    DirectoryContent(AppState s) { this.state = s; }
    @Override protected State<DirectoryContent> createState() { return new DirState(state); }
  }

  static class DirState extends SubState<DirectoryContent> {
    private final AppState state;
    private String query = "";
    private String selectedId;

    DirState(AppState state) { this.state = state; }

    @Override
    protected void initState() {
      List<Client> all = state.clients();
      selectedId = all.isEmpty() ? null : all.get(0).id();
    }

    @Override
    protected Widget build(BuildContext context) {
      AppState s = state;
      boolean dark = s.darkMode();
      List<Client> matches = filter(s.clients(), query);
      Client detail = pickDetail(matches);

      return SizedBox().width(DIALOG_WIDTH).height(DIALOG_HEIGHT).child(
          Scaffold()
              .appBar(dialogAppBar(context))
              .body(Row().crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
                  leftPane(matches, detail, dark),
                  VerticalDivider().width(1.0).thickness(1.0)
                      .color(EngagementsTheme.hairline(dark)),
                  Expanded().child(detail == null
                      ? Center().child(Text("No clients"))
                      : detailPane(context, s, detail, dark))))));
    }

    private PreferredSizeWidget dialogAppBar(BuildContext ctx) {
      return AppBar().title(Text("Clients directory"))
          .automaticallyImplyLeading(false)
          .actions(List.of(IconButton().icon(Icon(Icons.close()))
              .onPressed(() -> Navigator.pop(ctx)).build()))
          .build();
    }

    // --- left pane: search + list ---------------------------------------

    private WidgetI leftPane(List<Client> matches, Client detail, boolean dark) {
      return SizedBox().width(LIST_WIDTH).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.stretch)
          .children(List.of(searchField(), Expanded().child(clientList(matches, detail, dark)))));
    }

    private WidgetI searchField() {
      return Padding(EdgeInsets_all(12.0)).child(SearchBar()
          .hintText("Search clients")
          .leading(Icon(Icons.search()).size(18.0))
          .onChanged(v -> setState(() -> query = v))
          .build());
    }

    private WidgetI clientList(List<Client> matches, Client detail, boolean dark) {
      String detailId = detail != null ? detail.id() : null;
      return ListView.builder()
          .itemCount(matches.size())
          .itemBuilder((ctx, i) -> clientTile(matches.get(i), detailId, dark))
          .build();
    }

    private Widget clientTile(Client c, String detailId, boolean dark) {
      AppState s = state;
      int engs = s.engagementsForClient(c.id()).size();
      boolean selected = c.id().equals(detailId);
      return ListTile()
          .selected(selected)
          .dense(true)
          .leading(avatar(c.name(), 14.0, 10.0))
          .title(Text(c.name()).style(TextStyle().fontSize(13.0).fontWeight(FontWeight.w600())))
          .subtitle(Text(c.industry() + " · " + engs + " engagements")
              .style(TextStyle().fontSize(11.0).color(EngagementsTheme.muted(dark))))
          .onTap(() -> setState(() -> selectedId = c.id())).build();
    }

    // --- right pane: detail ---------------------------------------------

    private Widget detailPane(BuildContext ctx, AppState s, Client c, boolean dark) {
      return SingleChildScrollView().child(Padding(EdgeInsets_all(24.0)).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.start)
          .children(List.of(
              detailHeader(c),
              SizedBox().height(20.0),
              contactBlocks(c, dark),
              SectionHeader.of("Engagements", dark, null),
              SizedBox().height(6.0),
              engagementList(ctx, s, c, dark)))));
    }

    private WidgetI detailHeader(Client c) {
      return Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
          avatar(c.name(), 28.0, 18.0),
          SizedBox().width(14.0),
          Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
              Text(c.name()).style(TextStyle().fontSize(22.0).fontWeight(FontWeight.w600())),
              SizedBox().height(2.0),
              Text(c.industry()).style(TextStyle().fontSize(12.0)
                  .color(EngagementsTheme.muted(false)))))));
    }

    private WidgetI contactBlocks(Client c, boolean dark) {
      return Row().children(List.of(
          metaBlock("Primary contact", c.primaryContact(), dark),
          SizedBox().width(24.0),
          metaBlock("Email", c.email(), dark)));
    }

    private WidgetI engagementList(BuildContext ctx, AppState s, Client c, boolean dark) {
      List<WidgetI> tiles = new ArrayList<>();
      for (Engagement e : s.engagementsForClient(c.id())) {
        tiles.add(engagementRow(ctx, s, e, dark));
      }
      return Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(tiles);
    }

    private WidgetI engagementRow(BuildContext ctx, AppState s, Engagement e, boolean dark) {
      return ExpansionTile()
          .initiallyExpanded(false)
          .title(Row().children(List.of(
              Expanded().child(Text(e.name())),
              SizedBox().width(8.0),
              StatusChip.forEngagement(e.status()))))
          .subtitle(Text(FMT.format(e.start()) + " → " + FMT.format(e.targetEnd()))
              .style(TextStyle().fontSize(11.0).color(EngagementsTheme.muted(dark))))
          .children(List.of(engagementDetailRow(ctx, s, e, dark)))
          .build();
    }

    private WidgetI engagementDetailRow(BuildContext ctx, AppState s, Engagement e, boolean dark) {
      return Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(4.0).build()).child(Row()
          .children(List.of(
              Text("Team size: " + e.teamPersonIds().size() + " · Budget: "
                  + (int) e.budgetHours() + "h")
                  .style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark))),
              Expanded().child(SizedBox().width(0.0)),
              IconButton().icon(Icon(Icons.arrow_forward()).size(16.0))
                  .tooltip("Open engagement tab")
                  .onPressed(() -> { Navigator.pop(ctx); s.openEngagementTab(e.id()); })
                  .build())));
    }

    // --- shared bits ----------------------------------------------------

    private WidgetI metaBlock(String label, String value, boolean dark) {
      return Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
          Text(label).style(TextStyle()
              .fontSize(11.0).letterSpacing(0.6).fontWeight(FontWeight.w600())
              .color(EngagementsTheme.muted(dark))),
          SizedBox().height(4.0),
          Text(value).style(TextStyle().fontSize(14.0))));
    }

    private WidgetI avatar(String name, double radius, double fontSize) {
      return CircleAvatar().radius(radius).backgroundColor(EngagementsTheme.accent())
          .child(Text(initials(name)).style(TextStyle()
              .fontSize(fontSize).color(Colors.white()).fontWeight(FontWeight.w600())));
    }

    private static List<Client> filter(List<Client> all, String q) {
      if (q.isBlank()) return all;
      String lower = q.toLowerCase();
      return all.stream()
          .filter(c -> c.name().toLowerCase().contains(lower)
              || c.industry().toLowerCase().contains(lower))
          .toList();
    }

    private Client pickDetail(List<Client> matches) {
      return matches.stream().filter(c -> c.id().equals(selectedId))
          .findFirst().orElse(matches.isEmpty() ? null : matches.get(0));
    }

    private static String initials(String name) {
      String[] parts = name.trim().split("\\s+");
      if (parts.length == 1) return parts[0].substring(0, Math.min(2, parts[0].length())).toUpperCase();
      return ("" + parts[0].charAt(0) + parts[parts.length - 1].charAt(0)).toUpperCase();
    }
  }
}
