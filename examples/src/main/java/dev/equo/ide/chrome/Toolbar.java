package dev.equo.ide.chrome;

import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * Icon-button toolbar with a pulsing pill-shaped Run button in the center.
 *
 * The Run pill uses:
 *   – {@link ScaleTransition} driven by {@code pulseCtrl} for a subtle "breath"
 *   – A halo shadow via {@link BoxShadow} that the eye reads as "alive"
 * These effects — a soft glowing pill that breathes — are essentially
 * unreachable in SWT without heavy custom drawing.
 */
public class Toolbar extends SubStatelessWidget {

    private final boolean dark;
    private final boolean running;
    private final AnimationController entryCtrl;
    private final AnimationController pulseCtrl;
    private final Runnable onToggleTheme;
    private final Runnable onToggleRun;

    public Toolbar(boolean dark,
                   boolean running,
                   AnimationController entryCtrl,
                   AnimationController pulseCtrl,
                   Runnable onToggleTheme,
                   Runnable onToggleRun) {
        this.dark = dark;
        this.running = running;
        this.entryCtrl = entryCtrl;
        this.pulseCtrl = pulseCtrl;
        this.onToggleTheme = onToggleTheme;
        this.onToggleRun = onToggleRun;
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

    // ── Run pill (the piece SWT can't do easily) ─────────────────────────────

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

        // The pill "breathes" (subtle 4% scale wobble) while running.
        return running
                ? ScaleTransition(
                        CurvedAnimation(pulseCtrl, Curves.easeInOut())
                                .build())
                        .child(Transform_scale().scale(1.02).child(pill))
                : pill;
    }

    // ── Right cluster ────────────────────────────────────────────────────────

    private Widget rightCluster() {
        Supplier<IconDataI> themeIcon = dark ? Icons::light_mode_rounded : Icons::dark_mode_rounded;
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                iconBtn(Icons::bug_report_rounded, "Debug"),
                divider(),
                IconButton()
                        .icon(Icon(themeIcon.get()).color(IdePalette.accent2(dark)).size(18.0))
                        .tooltip(dark ? "Switch to light theme" : "Switch to dark theme")
                        .hoverColor(IdePalette.hoverOverlay(dark))
                        .onPressed(onToggleTheme),
                iconBtn(Icons::settings_rounded, "Settings")
        ));
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
