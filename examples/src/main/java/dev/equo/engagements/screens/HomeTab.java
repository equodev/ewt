package dev.equo.engagements.screens;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Deliverable;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.model.TimeEntry;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.engagements.ui.SectionHeader;
import dev.equo.engagements.ui.StatusChip;
import dev.equo.engagements.ui.UtilizationBar;
import dev.equo.ewt.Axis;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.Colors;
import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.FontWeight;
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.MainAxisSize;
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
import static dev.equo.ewt.EWT.Border_all;
import static dev.equo.ewt.EWT.BoxDecoration;
import static dev.equo.ewt.EWT.Center;
import static dev.equo.ewt.EWT.CircleAvatar;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.Divider;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_only;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.InkWell;
import static dev.equo.ewt.EWT.ListTile;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.SingleChildScrollView;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;

/** Landing tab: this-week rhythm + team utilization + recent activity. */
public class HomeTab extends SubStatefulWidget {

  final AppState state;

  public HomeTab(AppState state) { this.state = state; }

  @Override
  protected State<HomeTab> createState() { return new HomeState(state); }

  static class HomeState extends SubState<HomeTab> {
    private final AppState state;
    private Runnable listener;

    HomeState(AppState state) { this.state = state; }

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
      boolean dark = s.darkMode();
      return SingleChildScrollView().child(Padding(EdgeInsets_all(20.0)).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.stretch)
          .children(List.of(
              greeting(s, dark),
              SectionHeader.of("This week", dark, weekSummary(s, dark)),
              SizedBox().height(10.0),
              thisWeekRhythm(context, s, dark),
              SectionHeader.of("Utilization", dark, capacitySummary(s, dark)),
              SizedBox().height(10.0),
              utilization(s, dark),
              SectionHeader.of("Recent activity", dark, null),
              SizedBox().height(6.0),
              recentActivity(context, s, dark)))));
    }

    private Widget greeting(AppState s, boolean dark) {
      int active = (int) s.engagements().stream().filter(e -> e.status().name().equals("active")).count();
      String t = "Monday briefing — " + active + " active engagements, "
          + s.people().size() + " people on staff";
      return Text(t).style(TextStyle()
          .fontSize(22.0)
          .fontWeight(FontWeight.w600())
          .color(dark ? Colors.white() : Colors.grey().shade900()));
    }

    private Widget weekSummary(AppState s, boolean dark) {
      LocalDate mon = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
      LocalDate sun = mon.plusDays(6);
      int due = s.deliverablesDue(mon, sun).size();
      double hours = s.people().stream().mapToDouble(p -> s.weekHours(p.id(), false)).sum();
      String txt = due + " deliverables due · " + (int) hours + "h logged";
      return Text(txt).style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark)));
    }

    private Widget capacitySummary(AppState s, boolean dark) {
      double cap = s.people().stream().mapToInt(Person::weeklyCapacityHours).sum();
      double allocated = s.people().stream().mapToDouble(p -> s.weekHours(p.id(), false)).sum();
      int pct = cap == 0 ? 0 : (int) Math.round(allocated * 100.0 / cap);
      return Text(pct + "% of team capacity used")
          .style(TextStyle().fontSize(12.0).color(EngagementsTheme.muted(dark)));
    }

    private Widget thisWeekRhythm(BuildContext ctx, AppState s, boolean dark) {
      LocalDate mon = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
      LocalDate sun = mon.plusDays(6);
      List<Deliverable> ds = s.deliverablesDue(mon, sun);
      if (ds.isEmpty()) {
        return Padding(EdgeInsets_symmetric().vertical(20.0).build())
            .child(Text("No deliverables due this week")
                .style(TextStyle().color(EngagementsTheme.muted(dark))));
      }
      List<WidgetI> cards = new ArrayList<>();
      DateTimeFormatter f = DateTimeFormatter.ofPattern("EEE d");
      for (Deliverable d : ds) {
        Engagement e = s.engagement(d.engagementId());
        Person owner = s.person(d.ownerPersonId());
        cards.add(Padding(EdgeInsets_only().right(12.0).build()).child(rhythmCard(dark,
            f.format(d.due()),
            d.title(),
            e != null ? e.name() : "",
            owner != null ? owner.initials() : "?",
            StatusChip.forDeliverable(d.status()),
            () -> { if (e != null) s.openEngagementTab(e.id()); })));
      }
      return SizedBox().height(150.0).child(SingleChildScrollView().scrollDirection(Axis.horizontal)
          .child(Row().crossAxisAlignment(CrossAxisAlignment.start).children(cards)));
    }

    private Widget rhythmCard(boolean dark, String day, String title, String eng, String owner,
                              WidgetI chip, Runnable onTap) {
      return InkWell().onTap(onTap).borderRadius(BorderRadius_circular(8.0))
          .child(Container().width(220.0)
              .padding(EdgeInsets_all(12.0))
              .decoration(BoxDecoration()
                  .color(dark ? EngagementsTheme.subtle(true) : Colors.white())
                  .border(Border_all().color(EngagementsTheme.hairline(dark)).width(1.0).build())
                  .borderRadius(BorderRadius_circular(8.0)))
              .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                  Text(day).style(TextStyle().fontSize(11.0).letterSpacing(0.8)
                      .fontWeight(FontWeight.w600()).color(EngagementsTheme.muted(dark))),
                  SizedBox().height(6.0),
                  Text(title).maxLines(2).style(TextStyle().fontSize(14.0)
                      .fontWeight(FontWeight.w600())),
                  SizedBox().height(4.0),
                  Text(eng).maxLines(1).style(TextStyle().fontSize(12.0)
                      .color(EngagementsTheme.muted(dark))),
                  SizedBox().height(10.0),
                  Row().mainAxisAlignment(MainAxisAlignment.spaceBetween)
                      .crossAxisAlignment(CrossAxisAlignment.center)
                      .children(List.of(
                          chip,
                          CircleAvatar().radius(12.0)
                              .backgroundColor(EngagementsTheme.accent())
                              .child(Text(owner).style(TextStyle()
                                  .fontSize(10.0).color(Colors.white())
                                  .fontWeight(FontWeight.w600())))))))));
    }

    private Widget utilization(AppState s, boolean dark) {
      List<WidgetI> cols = new ArrayList<>();
      for (Person p : s.people()) {
        double billed = s.weekHours(p.id(), true);
        double all = s.weekHours(p.id(), false);
        double unbilled = Math.max(0.0, all - billed);
        cols.add(Expanded().child(Padding(EdgeInsets_symmetric().horizontal(4.0).build())
            .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                Text(p.name()).maxLines(1).style(TextStyle().fontSize(12.0)
                    .fontWeight(FontWeight.w600())),
                SizedBox().height(2.0),
                Text(p.role()).style(TextStyle().fontSize(10.0)
                    .color(EngagementsTheme.muted(dark))),
                SizedBox().height(8.0),
                UtilizationBar.horizontal(billed, unbilled, p.weeklyCapacityHours(), 10.0),
                SizedBox().height(4.0),
                Text((int) all + "h / " + p.weeklyCapacityHours() + "h")
                    .style(TextStyle().fontSize(10.0).color(EngagementsTheme.muted(dark))))))));
      }
      return Row().crossAxisAlignment(CrossAxisAlignment.start).children(cols);
    }

    private Widget recentActivity(BuildContext ctx, AppState s, boolean dark) {
      List<TimeEntry> recent = s.allTimeEntries().stream().limit(12).toList();
      List<WidgetI> tiles = new ArrayList<>();
      DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM d");
      for (TimeEntry t : recent) {
        Person p = s.person(t.personId());
        Engagement e = s.engagement(t.engagementId());
        String title = (p != null ? p.name() : "?") + " · " + (int) t.hours() + "h";
        String subtitle = (e != null ? e.name() : "?") + " — " + t.note();
        tiles.add(Container().decoration(BoxDecoration()
                .border(Border_all().color(EngagementsTheme.hairline(dark)).width(0.0).build()))
            .child(ListTile()
                .dense(true)
                .visualDensity(dev.equo.ewt.EWT.VisualDensity()
                    .horizontal(-2.0).vertical(-4.0).build())
                .leading(CircleAvatar().radius(14.0)
                    .backgroundColor(t.billed() ? Colors.teal().shade400() : Colors.grey().shade400())
                    .child(Text(p != null ? p.initials() : "?").style(TextStyle()
                        .fontSize(10.0).color(Colors.white()).fontWeight(FontWeight.w600()))))
                .title(Text(title).style(TextStyle().fontSize(13.0)))
                .subtitle(Text(subtitle).style(TextStyle()
                    .fontSize(11.0).color(EngagementsTheme.muted(dark))))
                .trailing(Text(f.format(t.day())).style(TextStyle()
                    .fontSize(11.0).color(EngagementsTheme.muted(dark))))
                .onTap(() -> { if (e != null) s.openEngagementTab(e.id()); })
                .build()));
      }
      // Not embedding a scroll ListView inside another SingleChildScrollView;
      // stack tiles as a Column with Dividers so the outer scroll handles it.
      List<WidgetI> withDividers = new ArrayList<>();
      for (int i = 0; i < tiles.size(); i++) {
        withDividers.add(tiles.get(i));
        if (i < tiles.size() - 1) withDividers.add(Divider().height(1.0).thickness(1.0)
            .color(EngagementsTheme.hairline(dark)));
      }
      return Column().crossAxisAlignment(CrossAxisAlignment.stretch)
          .mainAxisSize(MainAxisSize.min).children(withDividers);
    }
  }
}
