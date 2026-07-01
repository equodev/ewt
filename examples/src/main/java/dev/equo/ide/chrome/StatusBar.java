package dev.equo.ide.chrome;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * Bottom status bar. When {@code running} is true the accent flips to
 * teal, a spinner rotates and the "Ready" text becomes "Running..." —
 * all driven by the shared pulse controller.
 */
public class StatusBar extends SubStatelessWidget {

    private final boolean dark;
    private final boolean running;
    private final AnimationController pulseCtrl;
    private final int problemCount;
    private final int warningCount;
    private final String activeFile;

    public StatusBar(boolean dark,
                     boolean running,
                     AnimationController pulseCtrl,
                     int problemCount,
                     int warningCount,
                     String activeFile) {
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
                .padding(EdgeInsets_symmetric().horizontal(12.0).build())
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
                Text("Ln 1, Col 1").style(IdePalette.statusBar()),
                gap(),
                Text("UTF-8").style(IdePalette.statusBar()),
                gap(),
                Row().mainAxisSize(MainAxisSize.min).children(List.of(
                        Icon(Icons.coffee_rounded()).color(Colors.white()).size(13.0),
                        SizedBox().width(4.0),
                        Text("Java 21").style(IdePalette.statusBar())
                ))
        ));
    }

    /** The spinning gear icon shown when the fake app is "running". */
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
