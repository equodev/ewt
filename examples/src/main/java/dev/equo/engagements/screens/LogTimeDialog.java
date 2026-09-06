package dev.equo.engagements.screens;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.ui.EngagementsTheme;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.FontWeight;
import dev.equo.ewt.MainAxisSize;
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

import static dev.equo.ewt.EWT.AlertDialog;
import static dev.equo.ewt.EWT.Border_all;
import static dev.equo.ewt.EWT.BorderRadius_circular;
import static dev.equo.ewt.EWT.BoxDecoration;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.FilledButton;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.InputDecoration;
import static dev.equo.ewt.EWT.MenuAnchor;
import static dev.equo.ewt.EWT.MenuItemButton;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Slider;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.TextButton;
import static dev.equo.ewt.EWT.TextField;
import static dev.equo.ewt.EWT.showDialog;

/** Modal for logging a time entry against an engagement. */
public final class LogTimeDialog {

  private LogTimeDialog() {}

  public static void show(BuildContext context, AppState state, Engagement engagement) {
    showDialog(context, ctx -> new LogTimeForm(state, engagement));
  }

  static class LogTimeForm extends SubStatefulWidget {
    final AppState state;
    final Engagement engagement;
    LogTimeForm(AppState s, Engagement e) { this.state = s; this.engagement = e; }
    @Override protected State<LogTimeForm> createState() { return new FormState(state, engagement); }
  }

  static class FormState extends SubState<LogTimeForm> {
    private final AppState state;
    private final Engagement engagement;
    private String personId;
    private double hours = 2.0;
    private String note = "";

    FormState(AppState state, Engagement engagement) {
      this.state = state;
      this.engagement = engagement;
      this.personId = engagement.leadPersonId();
    }

    @Override
    protected Widget build(BuildContext context) {
      AppState s = state;
      Engagement e = engagement;
      boolean dark = s.darkMode();

      List<WidgetI> menuChildren = new ArrayList<>();
      for (String pid : e.teamPersonIds()) {
        Person p = s.person(pid);
        if (p == null) continue;
        menuChildren.add(MenuItemButton()
            .onPressed(() -> setState(() -> personId = pid))
            .child(Text(p.name())).build());
      }
      Person selected = s.person(personId);

      return AlertDialog()
          .title(Text("Log time — " + e.name()))
          .content(SizedBox().width(420.0).child(Column()
              .mainAxisSize(MainAxisSize.min)
              .crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(

                  Text("Team member").style(labelStyle(dark)),
                  SizedBox().height(6.0),
                  MenuAnchor().addAllMenuChildren(menuChildren)
                      .consumeOutsideTap(true)
                      .child(Container()
                          .decoration(BoxDecoration()
                              .border(Border_all().color(EngagementsTheme.hairline(dark)).width(1.0).build())
                              .borderRadius(BorderRadius_circular(4.0)))
                          .padding(EdgeInsets_symmetric().horizontal(12.0).vertical(10.0).build())
                          .child(Row().children(List.of(
                              Expanded().child(Text(selected != null ? selected.name() : "Select…")),
                              Icon(Icons.arrow_forward()).size(14.0)))))
                      .build(),

                  SizedBox().height(16.0),
                  Row().children(List.of(
                      Text("Hours").style(labelStyle(dark)),
                      SizedBox().width(8.0),
                      Text(String.format(Locale.ROOT, "%.1f", hours))
                          .style(TextStyle().fontSize(13.0).fontWeight(FontWeight.w600())))),
                  Slider(hours).min(0.5).max(8.0).divisions(15)
                      .label(String.format(Locale.ROOT, "%.1f", hours))
                      .activeColor(EngagementsTheme.accent())
                      .onChanged(v -> setState(() -> hours = v)).build(),

                  SizedBox().height(8.0),
                  Text("Note").style(labelStyle(dark)),
                  SizedBox().height(6.0),
                  TextField().decoration(InputDecoration()
                          .hintText("What did you work on?")
                          .border(dev.equo.ewt.EWT.OutlineInputBorder().build())
                          .isDense(true)
                          .contentPadding(EdgeInsets_symmetric().horizontal(10.0).vertical(10.0).build())
                          .build())
                      .onChanged(v -> note = v)
                      .build()))))
          .actions(List.of(
              TextButton().onPressed(() -> Navigator.pop(context))
                  .child(Text("Cancel")).build(),
              FilledButton().onPressed(() -> {
                    if (personId == null) return;
                    s.logTime(e.id(), personId, LocalDate.now(), hours, note.isBlank() ? "Time" : note);
                    Navigator.pop(context);
                    AppShell.showUndo(context, s, "Logged "
                        + String.format(Locale.ROOT, "%.1f", hours) + "h to " + e.name());
                  })
                  .child(Text("Log")).build()));
    }

    private TextStyle labelStyle(boolean dark) {
      return TextStyle().fontSize(11.0).letterSpacing(0.6).fontWeight(FontWeight.w600())
          .color(EngagementsTheme.muted(dark)).build();
    }
  }
}
