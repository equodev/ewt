package dev.equo.ide2.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;
import dev.equo.ide.model.ConsoleLine;
import dev.equo.ide.model.Problem;

/**
 * v2 bottom panel. Where v1 hand-rolled the Console / Problems / Terminal tabs
 * with TextButtons and a parent-owned "active tab" field, v2 uses a real
 * {@link DefaultTabController} that wires a {@link TabBar} to a {@link TabBarView}.
 * The active tab now lives in the controller, so the shell no longer needs any
 * tab state or an onSelectTab callback.
 *
 * The Problems tab shows its count with a {@link Badge} instead of a hand-built
 * rounded container.
 */
public class BottomPanel2 extends SubStatelessWidget {

    private final boolean dark;
    private final boolean running;
    private final AnimationController pulseCtrl;
    private final List<ConsoleLine> console;
    private final List<Problem> problems;

    public BottomPanel2(boolean dark,
                        boolean running,
                        AnimationController pulseCtrl,
                        List<ConsoleLine> console,
                        List<Problem> problems) {
        this.dark = dark;
        this.running = running;
        this.pulseCtrl = pulseCtrl;
        this.console = console;
        this.problems = problems;
    }

    @Override
    protected Widget build(BuildContext context) {
        return DefaultTabController(3).child(Column()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        tabStrip(),
                        Expanded().child(TabBarView(List.of(
                                consoleView(),
                                problemsView(),
                                terminalView())))
                )));
    }

    // ── Tab strip: a real TabBar, plus the panel action icons on the right ─────

    private Widget tabStrip() {
        return Container()
                .height(38.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().bottom(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Row().children(List.of(
                        Expanded().child(TabBar(List.of(
                                        Tab().child(tabLabel("Console", 0)),
                                        Tab().child(tabLabel("Problems", problems.size())),
                                        Tab().child(tabLabel("Terminal", 0))))
                                .isScrollable(true)
                                .indicatorColor(IdePalette.accent2(dark))
                                .indicatorSize(TabBarIndicatorSize.label)
                                .labelColor(IdePalette.textPrimary(dark))
                                .unselectedLabelColor(IdePalette.textMuted(dark))),
                        actions()
                )));
    }

    /** A tab label; the Problems tab carries a Badge with its count. */
    private Widget tabLabel(String text, int count) {
        Widget label = Text(text);
        if (count <= 0) return label;
        return Badge()
                .label(Text(String.valueOf(count)))
                .backgroundColor(IdePalette.accentError())
                .textColor(Colors.white())
                .offset(Offset(10.0, -6.0))
                .child(label);
    }

    private Widget actions() {
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                iconBtn(Icons::block_rounded, "Clear"),
                iconBtn(Icons::vertical_align_bottom_rounded, "Scroll to end"),
                iconBtn(Icons::close_rounded, "Hide panel"),
                SizedBox().width(6.0)
        ));
    }

    private Widget iconBtn(Supplier<IconDataI> icon, String tooltip) {
        return IconButton()
                .icon(Icon(icon.get()).color(IdePalette.textMuted(dark)).size(16.0))
                .tooltip(tooltip)
                .hoverColor(IdePalette.hoverOverlay(dark))
                .onPressed(() -> {});
    }

    // ── Views (ported from v1) ─────────────────────────────────────────────────

    private Widget consoleView() {
        List<WidgetI> rows = new ArrayList<>();
        for (ConsoleLine line : console) rows.add(consoleRow(line));
        return Container()
                .color(IdePalette.bgPanel(dark))
                .child(ListView()
                        .padding(EdgeInsets_symmetric().horizontal(14.0).vertical(10.0).build())
                        .children(rows));
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
            return Container().color(IdePalette.bgPanel(dark)).child(Center().child(Column()
                    .mainAxisSize(MainAxisSize.min)
                    .children(List.of(
                            Icon(Icons.check_circle_rounded())
                                    .color(IdePalette.accentRunning(dark)).size(30.0),
                            SizedBox().height(8.0),
                            Text("No problems found.").style(IdePalette.uiMuted(dark))
                    ))));
        }
        List<WidgetI> rows = new ArrayList<>();
        for (Problem p : problems) rows.add(problemRow(p));
        return Container().color(IdePalette.bgPanel(dark))
                .child(ListView().children(rows));
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
                "$ ./gradlew :examples:run -PmainClass=dev.equo.ide2.IdeApp2",
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
                .color(IdePalette.bgPanel(dark))
                .padding(EdgeInsets_symmetric().horizontal(16.0).vertical(12.0).build())
                .child(SingleChildScrollView().child(Column()
                        .crossAxisAlignment(CrossAxisAlignment.start)
                        .children(rows)));
    }

    private Widget blinkingCaret() {
        return FadeTransition(pulseCtrl)
                .child(Container()
                        .width(9.0).height(16.0)
                        .color(IdePalette.accent2(dark)));
    }
}
