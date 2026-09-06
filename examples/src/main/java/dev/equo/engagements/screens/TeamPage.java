package dev.equo.engagements.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.Colors;
import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.EdgeInsets;
import dev.equo.ewt.FontWeight;
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.Navigator;
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
import static dev.equo.ewt.EWT.BorderRadius_circular;
import static dev.equo.ewt.EWT.Border_all;
import static dev.equo.ewt.EWT.BoxDecoration;
import static dev.equo.ewt.EWT.Chip;
import static dev.equo.ewt.EWT.CircleAvatar;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.Dialog;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.IconButton;
import static dev.equo.ewt.EWT.LinearProgressIndicator;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.Scaffold;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.VisualDensity;
import static dev.equo.ewt.EWT.Wrap;
import static dev.equo.ewt.EWT.showDialog;

/** Full-screen modal: grid of team members with weekly utilization + engagements. */
public final class TeamPage {

  private static final double DIALOG_WIDTH = 1000.0;
  private static final double DIALOG_HEIGHT = 640.0;
  private static final int CROSS_AXIS_COUNT = 3;

  private TeamPage() {}

  public static void show(BuildContext context, AppState state) {
    showDialog(context, ctx -> Dialog()
        .insetPadding(EdgeInsets.all(24.0))
        .child(SizedBox().width(DIALOG_WIDTH).height(DIALOG_HEIGHT)
            .child(scaffold(context, state))));
  }

  private static Widget scaffold(BuildContext ctx, AppState state) {
    boolean dark = state.darkMode();
    return Scaffold()
        .appBar(header(ctx))
        .body(grid(ctx, state, dark));
  }

  private static PreferredSizeWidget header(BuildContext ctx) {
    return AppBar().title(Text("Team"))
        .automaticallyImplyLeading(false)
        .actions(List.of(IconButton().icon(Icon(Icons.close()))
            .onPressed(() -> Navigator.pop(ctx)).build()))
        .build();
  }

  private static Widget grid(BuildContext ctx, AppState state, boolean dark) {
    List<Person> people = state.people();
    List<WidgetI> cards = new ArrayList<>();
    for (Person p : people) cards.add(personCard(ctx, state, p, dark));
    return GridView.count()
        .crossAxisCount(CROSS_AXIS_COUNT)
        .padding(EdgeInsets_all(20.0))
        .mainAxisSpacing(16.0)
        .crossAxisSpacing(16.0)
        .childAspectRatio(1.6)
        .children(cards)
        .build();
  }

  // --- one card -----------------------------------------------------------

  private static WidgetI personCard(BuildContext ctx, AppState state, Person p, boolean dark) {
    return Card.outlined()
        .elevation(0.0)
        .color(dark ? EngagementsTheme.subtle(true) : Colors.white())
        .margin(EdgeInsets.zero())
        .child(Padding(EdgeInsets_all(14.0)).child(Column()
            .crossAxisAlignment(CrossAxisAlignment.start)
            .children(List.of(
                cardHeader(p, dark),
                SizedBox().height(12.0),
                utilizationBlock(state, p, dark),
                SizedBox().height(10.0),
                engagementChips(state, p, dark)))))
        .build();
  }

  private static WidgetI cardHeader(Person p, boolean dark) {
    return Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
        CircleAvatar().radius(18.0)
            .backgroundColor(EngagementsTheme.accent())
            .child(Text(p.initials()).style(TextStyle()
                .fontSize(13.0).color(Colors.white()).fontWeight(FontWeight.w600()))),
        SizedBox().width(10.0),
        Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
            Text(p.name()).style(TextStyle().fontSize(14.0).fontWeight(FontWeight.w600())),
            SizedBox().height(2.0),
            Text(p.role()).style(TextStyle()
                .fontSize(11.0).color(EngagementsTheme.muted(dark)))))));
  }

  private static WidgetI utilizationBlock(AppState state, Person p, boolean dark) {
    double all = state.weekHours(p.id(), false);
    double pct = p.weeklyCapacityHours() == 0 ? 0.0
        : Math.min(1.0, all / p.weeklyCapacityHours());
    return Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
        Row().mainAxisAlignment(MainAxisAlignment.spaceBetween).children(List.of(
            Text("Utilization").style(TextStyle().fontSize(11.0)
                .color(EngagementsTheme.muted(dark))),
            Text((int) all + "h / " + p.weeklyCapacityHours() + "h")
                .style(TextStyle().fontSize(11.0)
                    .color(EngagementsTheme.muted(dark))))),
        SizedBox().height(6.0),
        LinearProgressIndicator().value(pct)
            .minHeight(6.0)
            .backgroundColor(EngagementsTheme.subtle(dark))
            .color(pct > 0.9 ? Colors.red().shade400() : EngagementsTheme.accent())
            .build()));
  }

  private static WidgetI engagementChips(AppState state, Person p, boolean dark) {
    Map<String, Double> byEng = state.weekHoursByEngagement(p.id());
    if (byEng.isEmpty()) {
      return Text("No engagements this week").style(TextStyle()
          .fontSize(11.0).color(EngagementsTheme.muted(dark)));
    }
    List<WidgetI> chips = new ArrayList<>();
    for (var entry : byEng.entrySet()) {
      Engagement e = state.engagement(entry.getKey());
      if (e == null) continue;
      chips.add(engagementChip(e.name(), entry.getValue().intValue(), dark));
    }
    return Wrap().spacing(6.0).runSpacing(6.0).children(chips).build();
  }

  private static WidgetI engagementChip(String name, int hours, boolean dark) {
    return Chip()
        .label(Text(name + " · " + hours + "h").style(TextStyle().fontSize(11.0)))
        .backgroundColor(EngagementsTheme.subtle(dark))
        .visualDensity(VisualDensity().horizontal(-3.0).vertical(-3.0).build())
        .padding(EdgeInsets_symmetric().horizontal(6.0).vertical(0.0).build())
        .labelPadding(EdgeInsets_symmetric().horizontal(4.0).build())
        .build();
  }
}
