package dev.equo.ide2.chrome;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * v2 status bar. Same running-state animation as v1, plus a rounded account
 * chip on the right built with {@link ClipRRect} (a circular avatar) wrapped in
 * a {@link Tooltip}.
 */
public class StatusBar2 extends SubStatelessWidget {

    private final boolean dark;
    private final boolean running;
    private final AnimationController pulseCtrl;
    private final int problemCount;
    private final int warningCount;
    private final String activeFile;

    public StatusBar2(boolean dark, boolean running, AnimationController pulseCtrl,
                      int problemCount, int warningCount, String activeFile) {
        this.dark = dark;
        this.running = running;
        this.pulseCtrl = pulseCtrl;
        this.problemCount = problemCount;
        this.warningCount = warningCount;
        this.activeFile = activeFile;
    }

    @Override
    protected Widget build(BuildContext context) {
        Color bg = running ? IdePalette.accentRunning(dark) : IdePalette.accent(dark);
        return Container()
                .height(26.0)
                .color(bg)
                .padding(EdgeInsets_only().left(12.0).right(8.0).build())
                .child(Row().children(List.of(
                        leftCluster(),
                        Expanded().child(SizedBox().height(1.0)),
                        rightCluster()
                )));
    }

    private Widget leftCluster() {
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                statusItem(Icons.call_split_rounded(), "main"),
                gap(),
                statusItem(Icons.error_outline_rounded(), String.valueOf(problemCount)),
                gap(),
                statusItem(Icons.warning_amber_rounded(), String.valueOf(warningCount)),
                gap(),
                running ? spinner() : Icon(Icons.check_circle_rounded())
                        .color(Colors.white()).size(13.0),
                SizedBox().width(6.0),
                Text(running ? "Running..." : "Ready").style(IdePalette.statusBar())
        ));
    }

    private Widget rightCluster() {
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                Text(activeFile.isEmpty() ? "—" : activeFile).style(IdePalette.statusBar()),
                gap(),
                Text("UTF-8").style(IdePalette.statusBar()),
                gap(),
                Text("Java 23").style(IdePalette.statusBar()),
                SizedBox().width(12.0),
                avatarChip()
        ));
    }

    /** A circular avatar (ClipRRect) with initials, inside a Tooltip. */
    private Widget avatarChip() {
        Widget avatar = ClipRRect()
                .borderRadius(BorderRadius_circular(9.0))
                .child(Container()
                        .width(18.0).height(18.0)
                        .color(IdePalette.accent2(dark))
                        .child(Center().child(Text("EG").style(TextStyle()
                                .fontSize(9.0)
                                .fontWeight(FontWeight.w700())
                                .color(Colors.white())))));
        return Tooltip().message("Signed in as EstebanGL").child(avatar);
    }

    private Widget spinner() {
        return RotationTransition(pulseCtrl)
                .child(Icon(Icons.settings_rounded()).color(Colors.white()).size(13.0));
    }

    private Widget statusItem(IconDataI icon, String text) {
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                Icon(icon).color(Colors.white()).size(13.0),
                SizedBox().width(4.0),
                Text(text).style(IdePalette.statusBar())
        ));
    }

    private Widget gap() {
        return SizedBox().width(14.0);
    }
}
