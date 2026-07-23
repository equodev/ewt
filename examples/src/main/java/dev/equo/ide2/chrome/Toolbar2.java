package dev.equo.ide2.chrome;

import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * v2 toolbar. Same pulsing Run pill as v1, plus two additions from the new
 * widgets: the Debug icon carries a {@link Badge} with the live error count, and
 * a Settings button opens the slide-in settings panel.
 */
public class Toolbar2 extends SubStatelessWidget {

    private final boolean dark;
    private final boolean running;
    private final int errorCount;
    private final AnimationController pulseCtrl;
    private final Runnable onToggleTheme;
    private final Runnable onToggleRun;
    private final Runnable onOpenSettings;

    public Toolbar2(boolean dark, boolean running, int errorCount,
                    AnimationController pulseCtrl,
                    Runnable onToggleTheme, Runnable onToggleRun, Runnable onOpenSettings) {
        this.dark = dark;
        this.running = running;
        this.errorCount = errorCount;
        this.pulseCtrl = pulseCtrl;
        this.onToggleTheme = onToggleTheme;
        this.onToggleRun = onToggleRun;
        this.onOpenSettings = onOpenSettings;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .height(46.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgToolbar(dark))
                        .border(Border().bottom(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .padding(EdgeInsets_symmetric().horizontal(10.0).build())
                .child(Row().children(List.of(
                        leftCluster(),
                        Expanded().child(Center().child(runPill())),
                        rightCluster()
                )));
    }

    private Widget leftCluster() {
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                iconBtn(Icons::menu_rounded, "Explorer"),
                iconBtn(Icons::search_rounded, "Search"),
                divider(),
                iconBtn(Icons::save_rounded, "Save"),
                iconBtn(Icons::refresh_rounded, "Refresh")
        ));
    }

    private Widget runPill() {
        Color color = running ? IdePalette.accentRunning(dark) : IdePalette.accent(dark);
        Color glow  = running ? IdePalette.glowRunning(dark)   : IdePalette.glow(dark);
        Supplier<IconDataI> icon = running ? Icons::stop_rounded : Icons::play_arrow_rounded;
        String label = running ? "Stop" : "Run";

        Widget pill = GestureDetector().onTap(onToggleRun).child(
                Container()
                        .height(32.0)
                        .padding(EdgeInsets_symmetric().horizontal(18.0).build())
                        .decoration(BoxDecoration()
                                .color(color)
                                .borderRadius(BorderRadius_circular(16.0))
                                .boxShadow(List.of(
                                        BoxShadow()
                                                .color(glow)
                                                .blurRadius(running ? 22.0 : 14.0)
                                                .spreadRadius(running ? 2.0 : 0.0)
                                                .offset(Offset(0.0, 4.0))
                                )))
                        .child(Row().mainAxisSize(MainAxisSize.min).children(List.of(
                                running
                                        ? RotationTransition(pulseCtrl).child(
                                                Icon(Icons.autorenew_rounded())
                                                        .color(Colors.white()).size(16.0))
                                        : Icon(icon.get()).color(Colors.white()).size(16.0),
                                SizedBox().width(8.0),
                                Text(label).style(TextStyle()
                                        .fontSize(13.0)
                                        .fontWeight(FontWeight.w700())
                                        .letterSpacing(0.3)
                                        .color(Colors.white()))
                        ))));

        return running
                ? ScaleTransition(CurvedAnimation(pulseCtrl, Curves.easeInOut()).build())
                        .child(Transform_scale().scale(1.02).child(pill))
                : pill;
    }

    private Widget rightCluster() {
        Supplier<IconDataI> themeIcon = dark ? Icons::light_mode_rounded : Icons::dark_mode_rounded;
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                debugButton(),
                divider(),
                IconButton()
                        .icon(Icon(themeIcon.get()).color(IdePalette.accent2(dark)).size(18.0))
                        .tooltip(dark ? "Switch to light theme" : "Switch to dark theme")
                        .hoverColor(IdePalette.hoverOverlay(dark))
                        .onPressed(onToggleTheme),
                IconButton()
                        .icon(Icon(Icons.tune_rounded()).color(IdePalette.accent(dark)).size(18.0))
                        .tooltip("Settings")
                        .hoverColor(IdePalette.hoverOverlay(dark))
                        .onPressed(onOpenSettings)
        ));
    }

    /** The Debug icon with a Badge carrying the live error count. */
    private Widget debugButton() {
        Widget button = IconButton()
                .icon(Icon(Icons.bug_report_rounded()).color(IdePalette.textPrimary(dark)).size(18.0))
                .tooltip(errorCount + " problem(s)")
                .hoverColor(IdePalette.hoverOverlay(dark))
                .onPressed(() -> {});
        if (errorCount <= 0) return button;
        return Badge()
                .label(Text(String.valueOf(errorCount)))
                .backgroundColor(IdePalette.accentError())
                .textColor(Colors.white())
                .child(button);
    }

    private Widget iconBtn(Supplier<IconDataI> icon, String tooltip) {
        return IconButton()
                .icon(Icon(icon.get()).color(IdePalette.textPrimary(dark)).size(18.0))
                .tooltip(tooltip)
                .hoverColor(IdePalette.hoverOverlay(dark))
                .onPressed(() -> {});
    }

    private Widget divider() {
        return Container()
                .width(1.0)
                .height(22.0)
                .margin(EdgeInsets_symmetric().horizontal(6.0).build())
                .color(IdePalette.divider(dark));
    }
}
