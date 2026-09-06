package dev.equo.engagements.screens;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Client;
import dev.equo.engagements.model.Deliverable;
import dev.equo.engagements.model.DeliverableStatus;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.EngagementStatus;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.model.TimeEntry;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.engagements.ui.SectionHeader;
import dev.equo.engagements.ui.StatusChip;
import dev.equo.engagements.ui.UtilizationBar;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.Colors;
import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.DataCellI;
import dev.equo.ewt.DataColumnI;
import dev.equo.ewt.DataRowI;
import dev.equo.ewt.FontWeight;
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.MainAxisSize;
import dev.equo.ewt.Navigator;
import dev.equo.ewt.PopupMenuEntry;
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

import static dev.equo.ewt.EWT.AlertDialog;
import static dev.equo.ewt.EWT.Border_all;
import static dev.equo.ewt.EWT.BoxDecoration;
import static dev.equo.ewt.EWT.Center;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.DataCell;
import static dev.equo.ewt.EWT.DataColumn;
import static dev.equo.ewt.EWT.DataRow;
import static dev.equo.ewt.EWT.DataTable;
import static dev.equo.ewt.EWT.DefaultTabController;
import static dev.equo.ewt.EWT.Divider;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_only;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.ExpansionTile;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.FilledButton;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.IconButton;
import static dev.equo.ewt.EWT.LinearProgressIndicator;
import static dev.equo.ewt.EWT.MenuAnchor;
import static dev.equo.ewt.EWT.MenuItemButton;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.PopupMenuButton;
import static dev.equo.ewt.EWT.PopupMenuItem;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.SingleChildScrollView;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Slider;
import static dev.equo.ewt.EWT.Tab;
import static dev.equo.ewt.EWT.TabBar;
import static dev.equo.ewt.EWT.TabBarView;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.TextButton;
import static dev.equo.ewt.EWT.TextField;
import static dev.equo.ewt.EWT.showDialog;

/** Per-engagement workspace with Overview / Team / Deliverables / Time / Billing sub-tabs. */
public class EngagementTab extends SubStatefulWidget {

  final AppState state;
  final String engagementId;

  public EngagementTab(AppState state, String engagementId) {
    this.state = state;
    this.engagementId = engagementId;
  }

  @Override
  protected State<EngagementTab> createState() { return new EngagementState(state, engagementId); }

  static class EngagementState extends SubState<EngagementTab> {
    private final AppState state;
    private final String engagementId;
    private Runnable listener;
    private static final DateTimeFormatter DAY_FMT = DateTimeFormatter.ofPattern("MMM d");

    EngagementState(AppState state, String engagementId) {
      this.state = state;
      this.engagementId = engagementId;
    }

    @Override
    protected void initState() {
      listener = () -> { if (mounted()) setState(() -> {}); };
      state.addDataListener(listener);
    }

    @Override
    protected void dispose() { state.removeDataListener(listener); }

    @Override
    protected Widget build(BuildContext context) {
      AppState s = state;
      Engagement e = s.engagement(engagementId);
      boolean dark = s.darkMode();
      if (e == null) return Center().child(Text("Engagement not found"));

      return DefaultTabController(5).child(Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
          headerBanner(context, s, e, dark),
          Container()
              .decoration(BoxDecoration()
                  .border(Border_all().color(EngagementsTheme.hairline(dark)).width(0.0).build()))
              .child(TabBar(List.of(
                      Tab().text("Overview"),
                      Tab().text("Team"),
                      Tab().text("Deliverables"),
                      Tab().text("Time"),
                      Tab().text("Billing")))
                  .isScrollable(false)
                  .indicatorColor(EngagementsTheme.accent())
                  .labelColor(EngagementsTheme.accent())
                  .unselectedLabelColor(EngagementsTheme.muted(dark))
                  .build()),
          Divider().height(1.0).color(EngagementsTheme.hairline(dark)),
          Expanded().child(TabBarView(List.of(
              overview(context, s, e, dark),
              teamPanel(s, e, dark),
              deliverablesPanel(context, s, e, dark),
              timePanel(context, s, e, dark),
              billingPanel(context, s, e, dark))).build()))));
    }

    private Widget headerBanner(BuildContext ctx, AppState s, Engagement e, boolean dark) {
      Client c = s.client(e.clientId());
      Person lead = s.person(e.leadPersonId());
      WidgetI leftBlock = Expanded().child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
          Text(c != null ? c.name() : "?").style(TextStyle()
              .fontSize(11.0).letterSpacing(1.2).fontWeight(FontWeight.w600())
              .color(EngagementsTheme.muted(dark))),
          SizedBox().height(4.0),
          Text(e.name()).style(TextStyle().fontSize(20.0).fontWeight(FontWeight.w600())),
          SizedBox().height(6.0),
          Row().mainAxisSize(MainAxisSize.min).children(List.of(
              StatusChip.forEngagement(e.status()),
              SizedBox().width(10.0),
              Text("Lead: " + (lead != null ? lead.name() : "?"))
                  .style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark))),
              SizedBox().width(10.0),
              Text("· " + DAY_FMT.format(e.start()) + " → " + DAY_FMT.format(e.targetEnd()))
                  .style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark))))))));
      WidgetI menu = PopupMenuButton(popupCtx -> engagementStatusMenu(s, e))
          .icon(Icon(Icons.more_vert()))
          .tooltip("Change engagement status")
          .build();
      return Container()
          .padding(EdgeInsets_symmetric().horizontal(20.0).vertical(14.0).build())
          .decoration(BoxDecoration().color(EngagementsTheme.subtle(dark)))
          .child(Row().crossAxisAlignment(CrossAxisAlignment.center)
              .children(List.of(leftBlock, menu)));
    }

    private List<PopupMenuEntry> engagementStatusMenu(AppState s, Engagement e) {
      List<PopupMenuEntry> items = new ArrayList<>();
      for (EngagementStatus st : EngagementStatus.values()) {
        items.add(PopupMenuItem()
            .onTap(() -> s.setEngagementStatus(e.id(), st))
            .child(Text(AppState.titleCase(st))).build());
      }
      return items;
    }

    // --- Overview ---------------------------------------------------------

    private Widget overview(BuildContext ctx, AppState s, Engagement e, boolean dark) {
      Client c = s.client(e.clientId());
      double logged = s.hoursOnEngagement(e.id());
      double billed = s.hoursBilledOn(e.id());
      double pct = e.budgetHours() == 0 ? 0.0 : Math.min(1.0, logged / e.budgetHours());
      return SingleChildScrollView().child(Padding(EdgeInsets_all(20.0)).child(Row()
          .crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
              Expanded().flex(3).child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                  Text("Client").style(labelStyle(dark)),
                  SizedBox().height(4.0),
                  Text(c != null ? c.name() : "?").style(bodyStyle()),
                  SizedBox().height(2.0),
                  Text(c != null ? c.industry() + " · " + c.primaryContact() : "")
                      .style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark))),
                  SizedBox().height(16.0),
                  Text("Status").style(labelStyle(dark)),
                  SizedBox().height(4.0),
                  StatusChip.forEngagement(e.status()),
                  SizedBox().height(16.0),
                  Text("Timeline").style(labelStyle(dark)),
                  SizedBox().height(4.0),
                  Text(DAY_FMT.format(e.start()) + " → " + DAY_FMT.format(e.targetEnd()))
                      .style(bodyStyle()),
                  SizedBox().height(16.0),
                  Text("Team").style(labelStyle(dark)),
                  SizedBox().height(4.0),
                  Text(e.teamPersonIds().stream()
                      .map(s::person).filter(java.util.Objects::nonNull)
                      .map(Person::name).reduce((a, b) -> a + ", " + b).orElse(""))
                      .style(bodyStyle())))),
              SizedBox().width(24.0),
              Expanded().flex(4).child(budgetCard(dark, logged, billed, e.budgetHours(), pct))))));
    }

    private Widget budgetCard(boolean dark, double logged, double billed, double budget, double pct) {
      return Card_outlined_no_shadow(dark, Padding(EdgeInsets_all(16.0)).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
              Text("Budget burnup").style(TextStyle().fontSize(13.0)
                  .fontWeight(FontWeight.w600()).color(EngagementsTheme.muted(dark))),
              SizedBox().height(10.0),
              Text((int) logged + "h logged").style(TextStyle()
                  .fontSize(28.0).fontWeight(FontWeight.w600())),
              Text("of " + (int) budget + "h budgeted · " + (int) billed + "h billed")
                  .style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark))),
              SizedBox().height(14.0),
              LinearProgressIndicator().value(pct)
                  .minHeight(8.0)
                  .backgroundColor(EngagementsTheme.subtle(dark))
                  .color(EngagementsTheme.accent()).build(),
              SizedBox().height(20.0),
              UtilizationBar.horizontal(billed, Math.max(0.0, logged - billed),
                  Math.max(logged, budget), 12.0),
              SizedBox().height(6.0),
              Row().mainAxisAlignment(MainAxisAlignment.spaceBetween).children(List.of(
                  legendDot(Colors.teal().shade400(), "Billed", dark),
                  legendDot(Colors.amber().shade400(), "Unbilled", dark),
                  legendDot(Colors.grey().shade300(), "Free / remaining", dark)))))));
    }

    private Widget legendDot(dev.equo.ewt.ColorI c, String label, boolean dark) {
      return Row().mainAxisSize(MainAxisSize.min).children(List.of(
          Container().width(10.0).height(10.0).decoration(BoxDecoration().color(c)
              .borderRadius(dev.equo.ewt.EWT.BorderRadius_circular(2.0))),
          SizedBox().width(6.0),
          Text(label).style(TextStyle().fontSize(11.0).color(EngagementsTheme.muted(dark)))));
    }

    // --- Team ------------------------------------------------------------

    private Widget teamPanel(AppState s, Engagement e, boolean dark) {
      List<DataColumnI> cols = List.of(
          DataColumn(Text("Person").style(colHeader(dark))).build(),
          DataColumn(Text("Role").style(colHeader(dark))).build(),
          DataColumn(Text("Week hours").style(colHeader(dark))).numeric(true).build(),
          DataColumn(Text("Utilization").style(colHeader(dark))).build());
      List<DataRowI> rows = new ArrayList<>();
      for (String pid : e.teamPersonIds()) {
        Person p = s.person(pid);
        if (p == null) continue;
        double week = s.weekHours(p.id(), false);
        rows.add(DataRow().addAllCells(List.of(
            DataCell(Text(p.name())).build(),
            DataCell(Text(p.role())).build(),
            DataCell(Text((int) week + " / " + p.weeklyCapacityHours())).build(),
            DataCell(SizedBox().width(140.0).child(UtilizationBar.horizontal(
                s.weekHours(p.id(), true), Math.max(0.0, week - s.weekHours(p.id(), true)),
                p.weeklyCapacityHours(), 8.0))).build())).build());
      }
      return SingleChildScrollView().child(Padding(EdgeInsets_all(20.0)).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
              SectionHeader.of("Team allocation", dark, null),
              SizedBox().height(8.0),
              DataTable(cols).addAllRows(rows)
                  .headingRowHeight(36.0)
                  .dataRowMinHeight(40.0)
                  .dataRowMaxHeight(40.0)
                  .horizontalMargin(8.0)
                  .columnSpacing(24.0)
                  .build()))));
    }

    // --- Deliverables ----------------------------------------------------

    private Widget deliverablesPanel(BuildContext ctx, AppState s, Engagement e, boolean dark) {
      List<Deliverable> all = s.deliverablesFor(e.id());
      // Group by ISO week label.
      WeekFields wf = WeekFields.of(Locale.getDefault());
      LinkedHashMap<String, List<Deliverable>> byWeek = new LinkedHashMap<>();
      for (Deliverable d : all) {
        int week = d.due().get(wf.weekOfWeekBasedYear());
        int yr = d.due().get(wf.weekBasedYear());
        String key = "Week " + week + " · " + yr;
        byWeek.computeIfAbsent(key, k -> new ArrayList<>()).add(d);
      }
      List<WidgetI> tiles = new ArrayList<>();
      for (var entry : byWeek.entrySet()) {
        List<WidgetI> children = new ArrayList<>();
        for (Deliverable d : entry.getValue()) children.add(deliverableRow(ctx, s, d, dark));
        tiles.add(ExpansionTile()
            .initiallyExpanded(true)
            .title(Text(entry.getKey()).style(TextStyle()
                .fontSize(13.0).fontWeight(FontWeight.w600())))
            .subtitle(Text(entry.getValue().size() + " deliverables").style(TextStyle()
                .fontSize(11.0).color(EngagementsTheme.muted(dark))))
            .childrenPadding(EdgeInsets_only().bottom(8.0).build())
            .children(children).build());
      }
      if (tiles.isEmpty()) tiles.add(Padding(EdgeInsets_all(20.0))
          .child(Text("No deliverables yet").style(TextStyle().color(EngagementsTheme.muted(dark)))));
      return SingleChildScrollView().child(Padding(EdgeInsets_symmetric().horizontal(12.0).vertical(8.0).build())
          .child(Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(tiles)));
    }

    private Widget deliverableRow(BuildContext ctx, AppState s, Deliverable d, boolean dark) {
      Person owner = s.person(d.ownerPersonId());
      return Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(2.0).build()).child(Row()
          .crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
              SizedBox().width(80.0).child(Text(DAY_FMT.format(d.due()))
                  .style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark)))),
              Expanded().child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                  Text(d.title()).style(TextStyle().fontSize(13.0)),
                  SizedBox().height(2.0),
                  Text("Owner: " + (owner != null ? owner.name() : "?"))
                      .style(TextStyle().fontSize(11.0).color(EngagementsTheme.muted(dark)))))),
              StatusChip.forDeliverable(d.status()),
              SizedBox().width(6.0),
              PopupMenuButton(popupCtx -> deliverableStatusMenu(s, d, ctx))
                  .icon(Icon(Icons.more_vert()).size(18.0))
                  .tooltip("Change status")
                  .build())));
    }

    private List<PopupMenuEntry> deliverableStatusMenu(AppState s, Deliverable d, BuildContext outer) {
      List<PopupMenuEntry> items = new ArrayList<>();
      for (DeliverableStatus st : DeliverableStatus.values()) {
        items.add(PopupMenuItem().onTap(() -> {
          s.setDeliverableStatus(d.id(), st);
          AppShell.showUndo(outer, s, "Marked \"" + d.title() + "\" as " + AppState.titleCase(st));
        }).child(Text(AppState.titleCase(st))).build());
      }
      return items;
    }

    // --- Time ------------------------------------------------------------

    private Widget timePanel(BuildContext ctx, AppState s, Engagement e, boolean dark) {
      List<TimeEntry> entries = s.timeEntriesFor(e.id()).stream().limit(20).toList();
      List<DataColumnI> cols = List.of(
          DataColumn(Text("Day").style(colHeader(dark))).build(),
          DataColumn(Text("Person").style(colHeader(dark))).build(),
          DataColumn(Text("Hours").style(colHeader(dark))).numeric(true).build(),
          DataColumn(Text("Note").style(colHeader(dark))).build(),
          DataColumn(Text("Billed").style(colHeader(dark))).build());
      List<DataRowI> rows = new ArrayList<>();
      for (TimeEntry t : entries) {
        Person p = s.person(t.personId());
        rows.add(DataRow().addAllCells(List.of(
            DataCell(Text(DAY_FMT.format(t.day()))).build(),
            DataCell(Text(p != null ? p.name() : "?")).build(),
            DataCell(Text(String.format(Locale.ROOT, "%.1f", t.hours()))).build(),
            DataCell(Text(t.note())).build(),
            DataCell(Icon(t.billed() ? Icons.check() : Icons.close())
                .size(16.0).color(t.billed() ? Colors.teal().shade600() : Colors.grey().shade400()))
                .build())).build());
      }
      return SingleChildScrollView().child(Padding(EdgeInsets_all(20.0)).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
              Row().mainAxisAlignment(MainAxisAlignment.spaceBetween).children(List.of(
                  Text("Last 20 entries").style(labelStyle(dark)),
                  TextButton().onPressed(() -> LogTimeDialog.show(ctx, s, e))
                      .child(Row().mainAxisSize(MainAxisSize.min).children(List.of(
                          Icon(Icons.add()).size(16.0), SizedBox().width(4.0),
                          Text("Log time"))))
                      .build())),
              SizedBox().height(10.0),
              DataTable(cols).addAllRows(rows)
                  .headingRowHeight(36.0)
                  .dataRowMinHeight(40.0)
                  .dataRowMaxHeight(40.0)
                  .horizontalMargin(8.0)
                  .columnSpacing(20.0)
                  .build()))));
    }

    // --- Billing ---------------------------------------------------------

    private Widget billingPanel(BuildContext ctx, AppState s, Engagement e, boolean dark) {
      double billed = s.hoursBilledOn(e.id());
      double logged = s.hoursOnEngagement(e.id());
      double unbilled = Math.max(0.0, logged - billed);
      double rate = 150.0;
      double amount = unbilled * rate;
      return SingleChildScrollView().child(Padding(EdgeInsets_all(20.0)).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
              SectionHeader.of("Billing summary", dark, null),
              SizedBox().height(12.0),
              stat("Hours logged",   (int) logged + "h", dark),
              stat("Hours billed",   (int) billed + "h", dark),
              stat("Unbilled hours", (int) unbilled + "h", dark),
              stat("Blended rate",   "$" + (int) rate + "/h", dark),
              stat("Unbilled amount","$" + String.format(Locale.ROOT, "%,d", (long) amount), dark),
              SizedBox().height(20.0),
              ElevatedButton.icon().onPressed(() -> {
                AppShell.showUndo(ctx, s, "Invoice draft prepared for $"
                    + String.format(Locale.ROOT, "%,d", (long) amount));
              })
                  .icon(Icon(Icons.assignment()))
                  .label(Text("Generate invoice")).build()))));
    }

    private Widget stat(String label, String value, boolean dark) {
      return Padding(EdgeInsets_symmetric().vertical(6.0).build()).child(Row().children(List.of(
          SizedBox().width(180.0).child(Text(label).style(TextStyle()
              .fontSize(13.0).color(EngagementsTheme.muted(dark)))),
          Text(value).style(TextStyle().fontSize(15.0).fontWeight(FontWeight.w600())))));
    }

    // --- style helpers ---------------------------------------------------

    private static TextStyle labelStyle(boolean dark) {
      return TextStyle().fontSize(11.0).letterSpacing(0.8).fontWeight(FontWeight.w600())
          .color(EngagementsTheme.muted(dark)).build();
    }
    private static TextStyle bodyStyle() {
      return TextStyle().fontSize(14.0).build();
    }
    private static TextStyle colHeader(boolean dark) {
      return TextStyle().fontSize(11.0).letterSpacing(0.6).fontWeight(FontWeight.w600())
          .color(EngagementsTheme.muted(dark)).build();
    }

    private static Widget Card_outlined_no_shadow(boolean dark, Widget body) {
      return Card.outlined()
          .elevation(0.0)
          .color(dark ? EngagementsTheme.subtle(true) : Colors.white())
          .margin(EdgeInsets_all(0.0))
          .child(body).build();
    }
  }
}
