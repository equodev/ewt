package dev.equo.ide.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;
import dev.equo.ide.model.BottomTabId;
import dev.equo.ide.model.ConsoleLine;
import dev.equo.ide.model.Problem;

/**
 * Bottom panel with Console / Problems / Terminal tabs. Tab buttons use
 * {@link TextButton} so Material's built-in hover overlay lights them up
 * as the pointer moves over them.
 *
 * The terminal caret blinks via a {@link FadeTransition} tied to the shell's
 * pulse controller.
 */
public class BottomPanel extends SubStatelessWidget {

    private final boolean dark;
    private final BottomTabId active;
    private final boolean running;
    private final AnimationController pulseCtrl;
    private final List<ConsoleLine> console;
    private final List<Problem> problems;
    private final Consumer<BottomTabId> onSelectTab;

    public BottomPanel(boolean dark,
                       BottomTabId active,
                       boolean running,
                       AnimationController pulseCtrl,
                       List<ConsoleLine> console,
                       List<Problem> problems,
                       Consumer<BottomTabId> onSelectTab) {
        this.dark = dark;
        this.active = active;
        this.running = running;
        this.pulseCtrl = pulseCtrl;
        this.console = console;
        this.problems = problems;
        this.onSelectTab = onSelectTab;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .height(210.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().top(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Column()
                        .crossAxisAlignment(CrossAxisAlignment.stretch)
                        .children(List.of(tabStrip(), Expanded().child(body()))));
    }

    // ── Tab strip ────────────────────────────────────────────────────────────

    private Widget tabStrip() {
        List<WidgetI> tabs = new ArrayList<>();
        for (BottomTabId id : BottomTabId.values()) tabs.add(tab(id));
        tabs.add(Expanded().child(SizedBox().height(1.0)));
        tabs.add(actions());
        return Container()
                .height(34.0)
                .padding(EdgeInsets_symmetric().horizontal(8.0).build())
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().bottom(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Row().children(tabs));
    }

    private Widget tab(BottomTabId id) {
        boolean sel = id == active;
        int count = id == BottomTabId.PROBLEMS ? problems.size() : 0;

        Widget label = Container()
                .padding(EdgeInsets_symmetric().horizontal(10.0).build())
                .decoration(BoxDecoration()
                        .border(Border().bottom(BorderSide()
                                .color(sel ? IdePalette.accent2(dark) : IdePalette.bgPanel(dark))
                                .width(2.0).build())))
                .child(Center().child(Row().mainAxisSize(MainAxisSize.min).children(List.of(
                        Text(id.label()).style(sel
                                ? IdePalette.tabLabelActive(dark)
                                : IdePalette.tabLabelInactive(dark)),
                        count > 0 ? badge(count) : SizedBox().width(0.0)
                ))));

        return TextButton(() -> onSelectTab.accept(id))
                .onHover(hovering -> {})
                .child(label);
    }

    private Widget badge(int count) {
        return Padding(EdgeInsets_only().left(6.0).build())
                .child(Container()
                        .padding(EdgeInsets_symmetric().horizontal(6.0).vertical(1.0).build())
                        .decoration(BoxDecoration()
                                .color(IdePalette.accentError())
                                .borderRadius(BorderRadius_circular(8.0)))
                        .child(Text(String.valueOf(count)).style(TextStyle()
                                .fontSize(10.0)
                                .fontWeight(FontWeight.w700())
                                .color(Colors.white()))));
    }

    private Widget actions() {
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                iconBtn(Icons::block_rounded, "Clear"),
                iconBtn(Icons::vertical_align_bottom_rounded, "Scroll to end"),
                iconBtn(Icons::close_rounded, "Hide panel")
        ));
    }

    private Widget iconBtn(Supplier<IconDataI> icon, String tooltip) {
        return IconButton()
                .icon(Icon(icon.get()).color(IdePalette.textMuted(dark)).size(16.0))
                .tooltip(tooltip)
                .hoverColor(IdePalette.hoverOverlay(dark))
                .onPressed(() -> {});
    }

    // ── Body ─────────────────────────────────────────────────────────────────

    private Widget body() {
        return switch (active) {
            case CONSOLE  -> consoleView();
            case PROBLEMS -> problemsView();
            case TERMINAL -> terminalView();
        };
    }

    private Widget consoleView() {
        List<WidgetI> rows = new ArrayList<>();
        for (ConsoleLine line : console) rows.add(consoleRow(line));
        return Container()
                .padding(EdgeInsets_symmetric().horizontal(14.0).vertical(10.0).build())
                .child(SingleChildScrollView()
                        .child(Column()
                                .crossAxisAlignment(CrossAxisAlignment.start)
                                .children(rows)));
    }

    private Widget consoleRow(ConsoleLine line) {
        Color color = switch (line.level()) {
            case ERROR -> IdePalette.accentError();
            case WARN  -> IdePalette.accentWarn();
            case INFO  -> IdePalette.accent(dark);
        };
        String tag = switch (line.level()) {
            case ERROR -> "[error]";
            case WARN  -> "[warn ]";
            case INFO  -> "[info ]";
        };
        return Padding(EdgeInsets_only().bottom(4.0).build())
                .child(Row().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                        Text(line.timestamp() + " ").style(IdePalette.codeSpan(dark, IdePalette.textMuted(dark))),
                        Text(tag + " ").style(IdePalette.codeSpanBold(dark, color)),
                        Expanded().child(Text(line.text())
                                .style(IdePalette.codeSpan(dark, IdePalette.textPrimary(dark))))
                )));
    }

    private Widget problemsView() {
        if (problems.isEmpty()) {
            return Center().child(Column()
                    .mainAxisSize(MainAxisSize.min)
                    .children(List.of(
                            Icon(Icons.check_circle_rounded())
                                    .color(IdePalette.accentRunning(dark)).size(30.0),
                            SizedBox().height(8.0),
                            Text("No problems found.").style(IdePalette.uiMuted(dark))
                    )));
        }
        List<WidgetI> rows = new ArrayList<>();
        for (Problem p : problems) rows.add(problemRow(p));
        return SingleChildScrollView().child(Column()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(rows));
    }

    private Widget problemRow(Problem p) {
        Color color = switch (p.severity()) {
            case ERROR -> IdePalette.accentError();
            case WARN  -> IdePalette.accentWarn();
            case INFO  -> IdePalette.accentInfo(dark);
        };
        Supplier<IconDataI> icon = switch (p.severity()) {
            case ERROR -> Icons::error_outline_rounded;
            case WARN  -> Icons::warning_amber_rounded;
            case INFO  -> Icons::info_outline_rounded;
        };
        return ListTile()
                .dense(true)
                .hoverColor(IdePalette.hoverOverlay(dark))
                .contentPadding(EdgeInsets_symmetric().horizontal(14.0).build())
                .minVerticalPadding(4.0)
                .horizontalTitleGap(8.0)
                .minLeadingWidth(24.0)
                .visualDensity(VisualDensity().horizontal(-4.0).vertical(-2.0).build())
                .leading(Icon(icon.get()).color(color).size(16.0))
                .title(Text(p.message()).style(IdePalette.ui(dark)))
                .subtitle(Text(p.file() + ":" + p.line()).style(IdePalette.uiMuted(dark)))
                .onTap(() -> {});
    }

    private Widget terminalView() {
        String prompt = "sample-app › ";
        List<String> lines = List.of(
                "$ ./gradlew :examples:run -PmainClass=dev.equo.ide.IdeApp",
                "> Task :ewt.api:compileJava UP-TO-DATE",
                "> Task :examples:classes",
                "> Task :examples:run",
                running ? "Application started..." : ""
        );
        List<WidgetI> rows = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) continue;
            rows.add(Text(line).style(IdePalette.code(dark)));
            rows.add(SizedBox().height(2.0));
        }
        rows.add(Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                Text(prompt).style(IdePalette.codeSpanBold(dark, IdePalette.accent2(dark))),
                blinkingCaret()
        )));
        return Container()
                .padding(EdgeInsets_symmetric().horizontal(16.0).vertical(12.0).build())
                .child(SingleChildScrollView().child(Column()
                        .crossAxisAlignment(CrossAxisAlignment.start)
                        .children(rows)));
    }

    /** A block caret that blinks in sync with the shell's pulse controller. */
    private Widget blinkingCaret() {
        return FadeTransition(pulseCtrl)
                .child(Container()
                        .width(9.0).height(16.0)
                        .color(IdePalette.accent2(dark)));
    }
}
