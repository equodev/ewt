package dev.equo.engagements.screens;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;

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
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.MainAxisSize;
import dev.equo.ewt.Navigator;
import dev.equo.ewt.State;
import dev.equo.ewt.StepI;
import dev.equo.ewt.StepState;
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
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.Dialog;
import static dev.equo.ewt.EWT.EdgeInsets_all;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.FilledButton;
import static dev.equo.ewt.EWT.FilterChip;
import static dev.equo.ewt.EWT.Icon;
import static dev.equo.ewt.EWT.InputDecoration;
import static dev.equo.ewt.EWT.OutlineInputBorder;
import static dev.equo.ewt.EWT.PopupMenuButton;
import static dev.equo.ewt.EWT.PopupMenuDivider;
import static dev.equo.ewt.EWT.PopupMenuItem;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.SingleChildScrollView;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Slider;
import static dev.equo.ewt.EWT.Step;
import static dev.equo.ewt.EWT.Stepper;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.TextButton;
import static dev.equo.ewt.EWT.TextField;
import static dev.equo.ewt.EWT.Wrap;
import static dev.equo.ewt.EWT.showDialog;

/** Three-step wizard: client → scope → team. Emits {@link AppState#createEngagement}. */
public final class NewEngagementWizard {

  private static final double DIALOG_WIDTH = 720.0;
  private static final double DIALOG_HEIGHT = 640.0;

  private NewEngagementWizard() {}

  public static void show(BuildContext context, AppState state, Consumer<Engagement> onCreated) {
    showDialog(context, ctx -> Dialog()
        .insetPadding(EdgeInsets.all(40.0))
        .child(new WizardContent(state, onCreated)));
  }

  // --- SubState -----------------------------------------------------------

  static class WizardContent extends SubStatefulWidget {
    final AppState state;
    final Consumer<Engagement> onCreated;
    WizardContent(AppState s, Consumer<Engagement> onCreated) {
      this.state = s;
      this.onCreated = onCreated;
    }
    @Override protected State<WizardContent> createState() { return new WizState(state, onCreated); }
  }

  static class WizState extends SubState<WizardContent> {
    private final AppState state;
    private final Consumer<Engagement> onCreated;
    private int currentStep = 0;
    private String clientId;
    private String name = "";
    private LocalDate start = LocalDate.now();
    private LocalDate targetEnd = LocalDate.now().plusDays(60);
    private double budgetHours = 120.0;
    private final Set<String> teamIds = new LinkedHashSet<>();
    private String leadId;

    WizState(AppState state, Consumer<Engagement> onCreated) {
      this.state = state;
      this.onCreated = onCreated;
    }

    @Override
    protected Widget build(BuildContext context) {
      AppState s = state;
      boolean dark = s.darkMode();
      return SizedBox().width(DIALOG_WIDTH).height(DIALOG_HEIGHT).child(Column().children(List.of(
          header(dark),
          Expanded().child(stepper(context, s, dark))
      )));
    }

    // --- header ---------------------------------------------------------

    private WidgetI header(boolean dark) {
      return Container()
          .padding(EdgeInsets_symmetric().horizontal(24.0).vertical(18.0).build())
          .decoration(BoxDecoration().color(EngagementsTheme.subtle(dark)))
          .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
              Text("NEW ENGAGEMENT").style(TextStyle()
                  .fontSize(11.0).letterSpacing(1.5).fontWeight(FontWeight.w600())
                  .color(EngagementsTheme.muted(dark))),
              SizedBox().height(4.0),
              Text("Set up scope and staffing")
                  .style(TextStyle().fontSize(20.0).fontWeight(FontWeight.w600())))));
    }

    // --- stepper --------------------------------------------------------

    private WidgetI stepper(BuildContext ctx, AppState s, boolean dark) {
      List<StepI> steps = List.of(
          stepClient(s, dark),
          stepScope(dark),
          stepTeam(s, dark));
      return Stepper(steps)
          .currentStep(currentStep)
          .onStepContinue(() -> advance(ctx, s))
          .onStepCancel(() -> setState(() -> currentStep = Math.max(0, currentStep - 1)))
          .onStepTapped(i -> setState(() -> currentStep = i))
          .build();
    }

    private void advance(BuildContext ctx, AppState s) {
      if (currentStep < 2) {
        setState(() -> currentStep++);
        return;
      }
      if (clientId == null || name.isBlank() || teamIds.isEmpty()) return;
      Engagement e = s.createEngagement(clientId, name, start, targetEnd,
          leadId != null ? leadId : teamIds.iterator().next(),
          new ArrayList<>(teamIds), budgetHours);
      s.openEngagementTab(e.id());
      Navigator.pop(ctx);
      onCreated.accept(e);
    }

    // --- step: client ---------------------------------------------------

    private StepI stepClient(AppState s, boolean dark) {
      Client selected = clientId != null ? s.client(clientId) : null;
      return Step(Text("Choose client"))
          .subtitle(Text(selected != null ? selected.name() : "None selected"))
          .state(selected != null ? StepState.complete : StepState.indexed)
          .isActive(currentStep == 0)
          .content(clientMenu(s, selected, dark))
          .build();
    }

    private WidgetI clientMenu(AppState s, Client selected, boolean dark) {
      String label = selected != null
          ? selected.name() + " · " + selected.industry()
          : "Pick a client…";
      return Padding(EdgeInsets_symmetric().vertical(8.0).build())
          .child(PopupMenuButton(ctx -> clientMenuItems(s))
              .tooltip("Choose a client")
              .child(pickerBox(label, dark))
              .build());
    }

    private List<dev.equo.ewt.PopupMenuEntry> clientMenuItems(AppState s) {
      List<dev.equo.ewt.PopupMenuEntry> items = new ArrayList<>();
      for (Client c : s.clients()) {
        final String id = c.id();
        items.add(PopupMenuItem()
            .onTap(() -> setState(() -> clientId = id))
            .child(Text(c.name() + " — " + c.industry())).build());
      }
      return items;
    }

    // --- step: scope ----------------------------------------------------

    private StepI stepScope(boolean dark) {
      return Step(Text("Scope"))
          .subtitle(Text(scopeSummary()))
          .state(name.isBlank() ? StepState.indexed : StepState.complete)
          .isActive(currentStep == 1)
          .content(Padding(EdgeInsets_symmetric().vertical(8.0).build()).child(Column()
              .crossAxisAlignment(CrossAxisAlignment.stretch)
              .children(List.of(
                  nameField(),
                  SizedBox().height(14.0),
                  dateRow(),
                  SizedBox().height(14.0),
                  budgetSlider(dark)))))
          .build();
    }

    private String scopeSummary() {
      if (name.isBlank()) return "Untitled";
      return name + " · " + (int) budgetHours + "h";
    }

    private WidgetI nameField() {
      return TextField()
          .decoration(InputDecoration()
              .labelText("Engagement name")
              .border(OutlineInputBorder().build())
              .isDense(true)
              .contentPadding(EdgeInsets_symmetric().horizontal(12.0).vertical(12.0).build())
              .build())
          .onChanged(v -> name = v)
          .build();
    }

    private WidgetI dateRow() {
      return Row().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
          Expanded().child(datePicker("Starts", start,
              startPresets(), d -> setState(() -> start = d))),
          SizedBox().width(12.0),
          Expanded().child(datePicker("Target end", targetEnd,
              targetEndPresets(), d -> setState(() -> targetEnd = d)))));
    }

    private WidgetI datePicker(String label, LocalDate current,
                               List<DatePreset> presets, Consumer<LocalDate> onPick) {
      boolean dark = state.darkMode();
      return Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
          Text(label).style(TextStyle().fontSize(11.0).letterSpacing(0.6)
              .fontWeight(FontWeight.w600()).color(EngagementsTheme.muted(dark))),
          SizedBox().height(6.0),
          PopupMenuButton(ctx -> datePresetItems(presets, onPick))
              .tooltip("Pick " + label.toLowerCase())
              .child(pickerBox(current.toString(), dark))
              .build()));
    }

    private List<dev.equo.ewt.PopupMenuEntry> datePresetItems(
        List<DatePreset> presets, Consumer<LocalDate> onPick) {
      List<dev.equo.ewt.PopupMenuEntry> items = new ArrayList<>();
      for (DatePreset p : presets) {
        final LocalDate d = p.date();
        items.add(PopupMenuItem()
            .onTap(() -> onPick.accept(d))
            .child(Row().children(List.of(
                Expanded().child(Text(p.label())),
                SizedBox().width(12.0),
                Text(d.toString()).style(TextStyle().fontSize(11.0)
                    .color(EngagementsTheme.muted(state.darkMode())))))).build());
      }
      return items;
    }

    private List<DatePreset> startPresets() {
      LocalDate today = LocalDate.now();
      return List.of(
          new DatePreset("Today", today),
          new DatePreset("In 1 week", today.plusWeeks(1)),
          new DatePreset("In 2 weeks", today.plusWeeks(2)),
          new DatePreset("In 1 month", today.plusMonths(1)));
    }

    private List<DatePreset> targetEndPresets() {
      LocalDate today = LocalDate.now();
      return List.of(
          new DatePreset("In 1 month", today.plusMonths(1)),
          new DatePreset("In 3 months", today.plusMonths(3)),
          new DatePreset("In 6 months", today.plusMonths(6)),
          new DatePreset("In 1 year", today.plusYears(1)));
    }

    private record DatePreset(String label, LocalDate date) {}

    private WidgetI budgetSlider(boolean dark) {
      return Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
          Row().mainAxisAlignment(MainAxisAlignment.spaceBetween).children(List.of(
              Text("Budget hours").style(TextStyle().fontSize(12.0)
                  .color(EngagementsTheme.muted(dark))),
              Text(String.format(Locale.ROOT, "%.0fh", budgetHours))
                  .style(TextStyle().fontSize(13.0).fontWeight(FontWeight.w600())))),
          Slider(budgetHours).min(40.0).max(600.0).divisions(28)
              .activeColor(EngagementsTheme.accent())
              .label(String.format(Locale.ROOT, "%.0f", budgetHours))
              .onChanged(v -> setState(() -> budgetHours = v))
              .build()));
    }

    // --- step: team -----------------------------------------------------

    private StepI stepTeam(AppState s, boolean dark) {
      return Step(Text("Staffing"))
          .subtitle(Text(teamIds.size() + " selected"))
          .state(teamIds.isEmpty() ? StepState.indexed : StepState.complete)
          .isActive(currentStep == 2)
          .content(teamPicker(s, dark))
          .build();
    }

    private WidgetI teamPicker(AppState s, boolean dark) {
      List<WidgetI> chips = new ArrayList<>();
      for (Person p : s.people()) chips.add(personChip(p, dark));
      return Padding(EdgeInsets_symmetric().vertical(8.0).build()).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
              Text("Tap chips to add / remove; the lead is highlighted.")
                  .style(TextStyle().fontSize(11.0).color(EngagementsTheme.muted(dark))),
              SizedBox().height(10.0),
              Wrap().spacing(8.0).runSpacing(8.0).children(chips).build())));
    }

    private WidgetI personChip(Person p, boolean dark) {
      boolean selected = teamIds.contains(p.id());
      boolean isLead = p.id().equals(leadId);
      return FilterChip()
          .selected(selected)
          .label(Text(p.name() + " · " + p.role()))
          .avatar(Icon(isLead ? Icons.star() : Icons.people()).size(14.0))
          .selectedColor(EngagementsTheme.accent())
          .checkmarkColor(Colors.white())
          .onSelected(v -> setState(() -> togglePerson(p.id(), v)))
          .build();
    }

    private void togglePerson(String pid, boolean selected) {
      if (selected) {
        teamIds.add(pid);
        if (leadId == null) leadId = pid;
      } else {
        teamIds.remove(pid);
        if (pid.equals(leadId)) leadId = teamIds.isEmpty() ? null : teamIds.iterator().next();
      }
    }

    // --- shared bits ----------------------------------------------------

    private WidgetI pickerBox(String text, boolean dark) {
      return Container()
          .decoration(BoxDecoration()
              .border(Border_all().color(EngagementsTheme.hairline(dark)).width(1.0).build())
              .borderRadius(BorderRadius_circular(4.0)))
          .padding(EdgeInsets_symmetric().horizontal(12.0).vertical(12.0).build())
          .child(Row().children(List.of(
              Expanded().child(Text(text)),
              Icon(Icons.arrow_forward()).size(14.0))));
    }
  }
}
