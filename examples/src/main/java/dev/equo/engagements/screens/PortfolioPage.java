package dev.equo.engagements.screens;

import java.util.ArrayList;
import java.util.List;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.EngagementStatus;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.ewt.AnimationController;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.Card;
import dev.equo.ewt.Colors;
import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.EdgeInsets;
import dev.equo.ewt.FontWeight;
import dev.equo.ewt.Icons;
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.Navigator;
import dev.equo.ewt.State;
import dev.equo.ewt.SubAnimatedState;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.Widget;
import dev.equo.ewt.WidgetI;

import static dev.equo.ewt.EWT.Alignment;
import static dev.equo.ewt.EWT.BorderRadius_circular;
import static dev.equo.ewt.EWT.BoxDecoration;
import static dev.equo.ewt.EWT.Card;
import static dev.equo.ewt.EWT.CircleAvatar;
import static dev.equo.ewt.EWT.ClipRect;
import static dev.equo.ewt.EWT.Color_fromARGB;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.CustomScrollView;
import static dev.equo.ewt.EWT.Dialog;
import static dev.equo.ewt.EWT.Duration;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_only;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.FadeTransition;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.IconButton;
import static dev.equo.ewt.EWT.LinearProgressIndicator;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.SliverAppBar;
import static dev.equo.ewt.EWT.SliverGrid_count;
import static dev.equo.ewt.EWT.SliverList_list;
import static dev.equo.ewt.EWT.SliverPadding;
import static dev.equo.ewt.EWT.SliverToBoxAdapter;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.showDialog;

/**
 * Company-wide portfolio overview built with slivers.
 *
 * <p>Demoes the two things slivers are for:
 * <ol>
 *   <li><b>A collapsing header driven by scroll</b> — {@link dev.equo.ewt.SliverAppBar}
 *       with {@code pinned(true)} and {@code expandedHeight(220)} shrinks from a
 *       large hero into a slim pinned bar as the user scrolls down.</li>
 *   <li><b>Mixed sliver families in one lazy scroll</b> — the header, a KPI row
 *       ({@link dev.equo.ewt.SliverToBoxAdapter}), section titles, an engagement
 *       grid ({@link dev.equo.ewt.SliverGrid}) and a team list
 *       ({@link dev.equo.ewt.SliverList}) all live under a single
 *       {@link dev.equo.ewt.CustomScrollView}, so nothing off-screen is built
 *       until it enters the viewport.</li>
 * </ol>
 *
 * <p>The optional {@link AnimationController} inside the state fades the KPI
 * row in when the dialog opens (a scroll-independent effect, to contrast with
 * the sliver-driven collapse — same page, two different "animation" concepts).
 */
public final class PortfolioPage {

  private static final double DIALOG_WIDTH = 1000.0;
  private static final double DIALOG_HEIGHT = 720.0;

  private PortfolioPage() {}

  public static void show(BuildContext context, AppState state) {
    showDialog(context, ctx -> Dialog()
        .insetPadding(EdgeInsets.all(24.0))
        .child(SizedBox().width(DIALOG_WIDTH).height(DIALOG_HEIGHT)
            .child(new PortfolioContent(state))));
  }

  // -------------------------------------------------------------------------
  // Stateful shell — holds the AnimationController used for the KPI fade-in.
  // -------------------------------------------------------------------------

  static class PortfolioContent extends SubStatefulWidget {
    final AppState state;
    PortfolioContent(AppState state) { this.state = state; }
    @Override
    protected State<PortfolioContent> createState() { return new PortfolioState(state); }
  }

  static class PortfolioState extends SubAnimatedState<PortfolioContent> {
    private final AppState state;
    private AnimationController fadeIn;

    PortfolioState(AppState state) { this.state = state; }

    @Override
    protected void initState() {
      super.initState();
      // 1200ms fade for the KPI row. Bound to the AnimationController so the
      // opacity animates from 0 → 1 the first time the dialog paints, then
      // holds. This is a time-driven animation — totally independent from
      // the scroll-driven collapse of the SliverAppBar below.
      fadeIn = animationController(Duration().milliseconds(1200));
      fadeIn.forward();
    }

    @Override
    protected Widget build(BuildContext context) {
      boolean dark = state.darkMode();
      List<WidgetI> slivers = new ArrayList<>();

      // 1. Collapsing hero header.
      slivers.add(heroHeader(context, dark));

      // 2. KPI row — fades in on open via the AnimationController.
      slivers.add(SliverToBoxAdapter().child(
          FadeTransition(fadeIn).child(kpiRow(dark))).build());

      // 3. "Active engagements" section (title + grid).
      slivers.add(sectionTitle("Active engagements", dark));
      slivers.add(engagementsGrid(dark));

      // 4. "Team utilization" section (title + list).
      slivers.add(sectionTitle("Team utilization", dark));
      slivers.add(teamList(dark));

      // 5. Bottom padding so the last row doesn't kiss the dialog edge.
      slivers.add(SliverToBoxAdapter().child(SizedBox().height(24.0)).build());

      return CustomScrollView().slivers(slivers).build();
    }

    // --- header ------------------------------------------------------------

    private WidgetI heroHeader(BuildContext ctx, boolean dark) {
      // `pinned(true)` keeps the collapsed toolbar visible when scrolled;
      // `expandedHeight` sets how tall it is at rest. The `flexibleSpace`
      // paints the WHOLE bar area — INCLUDING the toolbar strip — so the
      // Container reserves the top TOOLBAR_HEIGHT px as padding, keeping the
      // tagline strictly below the toolbar. As the bar collapses, that inner
      // area shrinks to zero and the ClipRect trims anything that would
      // otherwise slide under the toolbar's own `.title` text.
      final double TOOLBAR_HEIGHT = 56.0; // Flutter's kToolbarHeight
      return SliverAppBar()
          .pinned(true)
          .expandedHeight(240.0)
          .automaticallyImplyLeading(false)
          .backgroundColor(EngagementsTheme.accent())
          .foregroundColor(Colors.white())
          .title(Text("Portfolio").style(TextStyle()
              .fontSize(16.0).fontWeight(FontWeight.w600()).color(Colors.white())))
          .actions(List.of(IconButton().icon(Icon(Icons.close()).color(Colors.white()))
              .onPressed(() -> Navigator.pop(ctx)).build()))
          .flexibleSpace(ClipRect().child(Container()
              .decoration(BoxDecoration().color(EngagementsTheme.accent()))
              .padding(EdgeInsets_only()
                  .top(TOOLBAR_HEIGHT)
                  .left(28.0).right(28.0).bottom(20.0).build())
              .alignment(Alignment(-1.0, 1.0).build())
              .child(Column().mainAxisSize(dev.equo.ewt.MainAxisSize.min)
                  .crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                      Text("OVERVIEW").style(TextStyle().fontSize(11.0)
                          .letterSpacing(1.4).color(Colors.white70())
                          .fontWeight(FontWeight.w600())),
                      SizedBox().height(6.0),
                      Text("All clients, engagements & team at a glance")
                          .style(TextStyle().fontSize(22.0).color(Colors.white())
                              .fontWeight(FontWeight.w600())))))))
          .build();
    }

    // --- KPI row -----------------------------------------------------------

    private Widget kpiRow(boolean dark) {
      int engagements = state.engagements().size();
      long active = state.engagements().stream()
          .filter(e -> e.status() == EngagementStatus.active).count();
      int people = state.people().size();
      double totalBudget = state.engagements().stream()
          .mapToDouble(Engagement::budgetHours).sum();
      double loggedThisWeek = state.people().stream()
          .mapToDouble(p -> state.weekHours(p.id(), false)).sum();
      double utilization = totalWeeklyCapacity() == 0 ? 0.0
          : Math.min(1.0, loggedThisWeek / totalWeeklyCapacity());

      return Padding(EdgeInsets_symmetric().horizontal(20.0).vertical(16.0).build())
          .child(Row().children(List.of(
              kpiCard(String.valueOf(engagements),
                  active + " active", "Engagements", dark),
              SizedBox().width(12.0),
              kpiCard(String.valueOf(people),
                  "across " + state.clients().size() + " clients",
                  "Team", dark),
              SizedBox().width(12.0),
              kpiCard((int) totalBudget + "h",
                  "budgeted", "Portfolio scope", dark),
              SizedBox().width(12.0),
              kpiCard(((int) (utilization * 100)) + "%",
                  (int) loggedThisWeek + "h logged / week",
                  "Utilization", dark))));
    }

    private double totalWeeklyCapacity() {
      return state.people().stream().mapToInt(Person::weeklyCapacityHours).sum();
    }

    private WidgetI kpiCard(String big, String sub, String label, boolean dark) {
      return Expanded().child(Card.outlined()
          .elevation(0.0)
          .color(dark ? EngagementsTheme.subtle(true) : Colors.white())
          .margin(EdgeInsets.zero())
          .child(Padding(EdgeInsets_all(16.0)).child(Column()
              .crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                  Text(label.toUpperCase()).style(TextStyle().fontSize(10.0)
                      .letterSpacing(1.0).color(EngagementsTheme.muted(dark))
                      .fontWeight(FontWeight.w600())),
                  SizedBox().height(10.0),
                  Text(big).style(TextStyle().fontSize(28.0)
                      .fontWeight(FontWeight.w600())),
                  SizedBox().height(2.0),
                  Text(sub).style(TextStyle().fontSize(11.0)
                      .color(EngagementsTheme.muted(dark)))))))
          .build());
    }

    // --- section title -----------------------------------------------------

    /** Small section header. Wrapped in SliverPadding + SliverToBoxAdapter
     *  because {@code CustomScrollView.slivers} accepts sliver-typed children
     *  only — a box (Text/Padding) has to be adapted with SliverToBoxAdapter. */
    private WidgetI sectionTitle(String label, boolean dark) {
      return SliverPadding(EdgeInsets_only().left(20.0).right(20.0)
              .top(24.0).bottom(8.0).build())
          .sliver(SliverToBoxAdapter().child(
              Text(label.toUpperCase()).style(TextStyle().fontSize(11.0)
                  .letterSpacing(1.2).fontWeight(FontWeight.w600())
                  .color(EngagementsTheme.muted(dark)))).build())
          .build();
    }

    // --- engagements grid --------------------------------------------------

    private WidgetI engagementsGrid(boolean dark) {
      List<WidgetI> cards = new ArrayList<>();
      for (Engagement e : state.engagements()) cards.add(engagementCard(e, dark));
      return SliverPadding(EdgeInsets_symmetric().horizontal(20.0).build())
          .sliver(SliverGrid_count(3)
              .mainAxisSpacing(12.0)
              .crossAxisSpacing(12.0)
              .childAspectRatio(2.2)
              .children(cards).build())
          .build();
    }

    private WidgetI engagementCard(Engagement e, boolean dark) {
      return Card.outlined()
          .elevation(0.0)
          .color(dark ? EngagementsTheme.subtle(true) : Colors.white())
          .margin(EdgeInsets.zero())
          .child(Padding(EdgeInsets_all(14.0)).child(Column()
              .crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                  Row().mainAxisAlignment(MainAxisAlignment.spaceBetween).children(List.of(
                      Expanded().child(Text(e.name()).style(TextStyle()
                          .fontSize(13.0).fontWeight(FontWeight.w600()))),
                      statusDot(e.status()))),
                  SizedBox().height(4.0),
                  Text(clientName(e.clientId())).style(TextStyle()
                      .fontSize(11.0).color(EngagementsTheme.muted(dark))),
                  SizedBox().height(10.0),
                  Text((int) e.budgetHours() + "h budgeted · "
                          + e.teamPersonIds().size() + " people")
                      .style(TextStyle().fontSize(11.0)
                          .color(EngagementsTheme.muted(dark)))))))
          .build();
    }

    private WidgetI statusDot(EngagementStatus status) {
      return Container().width(10.0).height(10.0)
          .decoration(BoxDecoration().color(statusColor(status))
              .borderRadius(BorderRadius_circular(5.0)))
          .build();
    }

    private dev.equo.ewt.Color statusColor(EngagementStatus s) {
      return switch (s) {
        case active    -> Color_fromARGB(255,  76, 175,  80).build();
        case proposed  -> Color_fromARGB(255, 255, 179,   0).build();
        case paused    -> Color_fromARGB(255, 158, 158, 158).build();
        case completed -> Color_fromARGB(255, 100, 181, 246).build();
      };
    }

    private String clientName(String id) {
      var c = state.client(id);
      return c != null ? c.name() : id;
    }

    // --- team list ---------------------------------------------------------

    private WidgetI teamList(boolean dark) {
      List<WidgetI> rows = new ArrayList<>();
      for (Person p : state.people()) rows.add(teamRow(p, dark));
      return SliverPadding(EdgeInsets_symmetric().horizontal(20.0).build())
          .sliver(SliverList_list(rows).build())
          .build();
    }

    private WidgetI teamRow(Person p, boolean dark) {
      double logged = state.weekHours(p.id(), false);
      double cap = p.weeklyCapacityHours();
      double pct = cap == 0 ? 0.0 : Math.min(1.0, logged / cap);
      return Padding(EdgeInsets_symmetric().vertical(6.0).build())
          .child(Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
              CircleAvatar().radius(16.0).backgroundColor(EngagementsTheme.accent())
                  .child(Text(p.initials()).style(TextStyle().fontSize(11.0)
                      .color(Colors.white()).fontWeight(FontWeight.w600()))),
              SizedBox().width(12.0),
              Expanded().child(Column().crossAxisAlignment(CrossAxisAlignment.start)
                  .children(List.of(
                      Text(p.name()).style(TextStyle().fontSize(13.0)
                          .fontWeight(FontWeight.w500())),
                      SizedBox().height(2.0),
                      Text(p.role()).style(TextStyle().fontSize(11.0)
                          .color(EngagementsTheme.muted(dark)))))),
              SizedBox().width(16.0),
              SizedBox().width(160.0).child(LinearProgressIndicator().value(pct)
                  .minHeight(6.0)
                  .backgroundColor(EngagementsTheme.subtle(dark))
                  .color(pct > 0.9 ? Colors.red().shade400() : EngagementsTheme.accent())
                  .build()),
              SizedBox().width(12.0),
              SizedBox().width(56.0).child(Text((int) logged + "h / " + (int) cap + "h")
                  .textAlign(dev.equo.ewt.TextAlign.right)
                  .style(TextStyle().fontSize(11.0)
                      .color(EngagementsTheme.muted(dark)))))))
          .build();
    }
  }
}
