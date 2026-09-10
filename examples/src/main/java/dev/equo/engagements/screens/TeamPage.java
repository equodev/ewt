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
import static dev.equo.ewt.EWT.Color_fromARGB;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.Dialog;
import static dev.equo.ewt.EWT.Divider;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_only;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.IconButton;
import static dev.equo.ewt.EWT.LinearProgressIndicator;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.Scaffold;
import static dev.equo.ewt.EWT.SingleChildScrollView;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.VisualDensity;
import static dev.equo.ewt.EWT.Wrap;
import static dev.equo.ewt.EWT.showDialog;

/** Full-screen modal: grid of team members with weekly utilization + engagements. */
public final class TeamPage {

  private static final double DIALOG_WIDTH = 1000.0;
  private static final double DIALOG_HEIGHT = 720.0;
  private static final int CROSS_AXIS_COUNT = 3;

  private static final String[] WEEKDAYS = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
  private static final double CELL_SIZE = 34.0;
  private static final double NAME_COL = 130.0;

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
        .body(Column().children(List.of(
            heatmap(state, dark),
            Divider().height(1.0).color(EngagementsTheme.hairline(dark)),
            Expanded().child(grid(ctx, state, dark)))));
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

  // --- weekly hours heatmap ----------------------------------------------

  private static Widget heatmap(AppState state, boolean dark) {
    List<Person> people = state.people();
    List<WidgetI> rows = new ArrayList<>();
    rows.add(weekdayHeader(dark));
    for (Person p : people) rows.add(heatmapRow(state, p, dark));
    return Padding(EdgeInsets_symmetric().horizontal(20.0).vertical(14.0).build())
        .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
            Text("Hours this week").style(TextStyle().fontSize(11.0).letterSpacing(0.8)
                .fontWeight(FontWeight.w600()).color(EngagementsTheme.muted(dark))),
            SizedBox().height(8.0),
            SingleChildScrollView().scrollDirection(dev.equo.ewt.Axis.horizontal)
                .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(rows))
                .build())));
  }

  private static WidgetI weekdayHeader(boolean dark) {
    List<WidgetI> cells = new ArrayList<>();
    cells.add(SizedBox().width(NAME_COL).height(20.0));
    for (String d : WEEKDAYS) cells.add(headerCell(d, dark));
    return Row().children(cells);
  }

  private static WidgetI headerCell(String label, boolean dark) {
    return Container().width(CELL_SIZE).height(20.0)
        .alignment(dev.equo.ewt.Alignment.center())
        .padding(EdgeInsets_only().left(2.0).right(2.0).build())
        .child(Text(label).style(TextStyle().fontSize(10.0).letterSpacing(0.6)
            .color(EngagementsTheme.muted(dark))))
        .build();
  }

  private static WidgetI heatmapRow(AppState state, Person p, boolean dark) {
    double[] hours = state.weeklyHoursPerDay(p.id());
    double weekly = p.weeklyCapacityHours();
    double dailyCap = weekly > 0 ? weekly / 5.0 : 8.0;
    List<WidgetI> cells = new ArrayList<>();
    cells.add(nameCell(p, dark));
    for (int i = 0; i < 7; i++) cells.add(heatCell(hours[i], dailyCap, dark));
    return Padding(EdgeInsets_only().top(4.0).build())
        .child(Row().crossAxisAlignment(CrossAxisAlignment.center).children(cells))
        .build();
  }

  private static WidgetI nameCell(Person p, boolean dark) {
    return SizedBox().width(NAME_COL).height(CELL_SIZE - 4.0).child(Row()
        .crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
            CircleAvatar().radius(11.0).backgroundColor(EngagementsTheme.accent())
                .child(Text(p.initials()).style(TextStyle().fontSize(10.0)
                    .color(Colors.white()).fontWeight(FontWeight.w600()))),
            SizedBox().width(8.0),
            Expanded().child(Text(p.name()).style(TextStyle().fontSize(12.0)
                .fontWeight(FontWeight.w500()))))).build());
  }

  private static WidgetI heatCell(double h, double dailyCap, boolean dark) {
    double intensity = dailyCap == 0 ? 0.0 : Math.min(1.0, h / dailyCap);
    int alpha = (int) (30 + intensity * 210);
    int r = 189, g = 102, b = 79; // terracotta accent
    return Padding(EdgeInsets_only().left(2.0).right(2.0).build())
        .child(Container().width(CELL_SIZE - 4.0).height(CELL_SIZE - 4.0)
            .alignment(dev.equo.ewt.Alignment.center())
            .decoration(BoxDecoration()
                .color(h == 0
                    ? EngagementsTheme.subtle(dark)
                    : Color_fromARGB(alpha, r, g, b).build())
                .borderRadius(BorderRadius_circular(4.0)))
            .child(h == 0
                ? SizedBox()
                : Text(formatHours(h)).style(TextStyle().fontSize(10.0)
                    .fontWeight(FontWeight.w600())
                    .color(intensity > 0.55 ? Colors.white()
                        : (dark ? Colors.white() : Colors.black87())))))
        .build();
  }

  private static String formatHours(double h) {
    if (h == Math.floor(h)) return String.valueOf((int) h);
    return String.format(java.util.Locale.ROOT, "%.1f", h);
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
