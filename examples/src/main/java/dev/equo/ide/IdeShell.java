package dev.equo.ide;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.chrome.MenuBar;
import dev.equo.ide.chrome.StatusBar;
import dev.equo.ide.chrome.Toolbar;
import dev.equo.ide.model.BottomTabId;
import dev.equo.ide.model.ConsoleLine;
import dev.equo.ide.model.EditorTab;
import dev.equo.ide.model.NodeKind;
import dev.equo.ide.model.Problem;
import dev.equo.ide.model.ProjectNode;
import dev.equo.ide.panels.BottomPanel;
import dev.equo.ide.panels.EditorArea;
import dev.equo.ide.panels.OutlinePanel;
import dev.equo.ide.panels.ProjectTree;

/**
 * Owns all mutable UI state and animation controllers for the IDE showcase.
 *
 * State:
 *   – theme mode (dark by default)
 *   – "running" flag (toolbar run/stop button)
 *   – open editor tabs and active index
 *   – active bottom-panel tab (Console/Problems/Terminal)
 *   – expanded folder paths
 *
 * Animation:
 *   – entryCtrl: plays once on mount for the panels-fade-in entrance
 *   – pulseCtrl: repeats forever, drives the run pill / status spinner
 *   – editorCtrl: replays on every tab switch for a crossfade
 */
public class IdeShell extends SubStatefulWidget {

    @Override
    protected State<IdeShell> createState() {
        return new IdeShellState();
    }
}

class IdeShellState extends SubAnimatedState<IdeShell> {

    private boolean dark = true;
    private boolean running = false;
    private final List<EditorTab> tabs = new ArrayList<>();
    private int activeTabIndex = -1;
    private BottomTabId activeBottom = BottomTabId.CONSOLE;
    private final Set<String> expanded = new HashSet<>();

    private final ProjectNode projectRoot = SampleProject.root();
    private final List<Problem> problems = SampleProject.problems();

    private AnimationController entryCtrl;
    private AnimationController pulseCtrl;
    private AnimationController editorCtrl;

    IdeShellState() {
        expanded.add("sample-app");
        expanded.add("sample-app/src");
        tabs.add(new EditorTab("src/Main.java", "Main.java", NodeKind.JAVA));
        tabs.add(new EditorTab("README.md",     "README.md", NodeKind.MARKDOWN));
        activeTabIndex = 0;
    }

    @Override
    public void initState() {
        super.initState();
        entryCtrl  = animationController(Duration().milliseconds(900));
        pulseCtrl  = animationController(Duration().milliseconds(1400));
        editorCtrl = animationController(Duration().milliseconds(280));
        entryCtrl.forward();
        pulseCtrl.repeat();
        editorCtrl.forward();
    }

    // ── Callbacks ────────────────────────────────────────────────────────────

    private void toggleTheme() { setState(() -> dark = !dark); }
    private void toggleRun()   { setState(() -> running = !running); }

    private void toggleFolder(String path) {
        setState(() -> {
            if (!expanded.add(path)) expanded.remove(path);
        });
    }

    private void openFile(ProjectNode node) {
        setState(() -> {
            for (int i = 0; i < tabs.size(); i++) {
                if (tabs.get(i).path().equals(node.path())) {
                    if (activeTabIndex != i) {
                        activeTabIndex = i;
                        editorCtrl.reset();
                        editorCtrl.forward();
                    }
                    return;
                }
            }
            tabs.add(new EditorTab(node.path(), node.name(), node.kind()));
            activeTabIndex = tabs.size() - 1;
            editorCtrl.reset();
            editorCtrl.forward();
        });
    }

    private void selectTab(int i) {
        if (i == activeTabIndex) return;
        setState(() -> {
            activeTabIndex = i;
            editorCtrl.reset();
            editorCtrl.forward();
        });
    }

    private void closeTab(int i) {
        setState(() -> {
            if (i < 0 || i >= tabs.size()) return;
            tabs.remove(i);
            if (tabs.isEmpty()) {
                activeTabIndex = -1;
            } else if (activeTabIndex >= tabs.size()) {
                activeTabIndex = tabs.size() - 1;
            } else if (activeTabIndex > i) {
                activeTabIndex--;
            }
            editorCtrl.reset();
            editorCtrl.forward();
        });
    }

    private void selectBottom(BottomTabId id) {
        setState(() -> activeBottom = id);
    }

    // ── Build ────────────────────────────────────────────────────────────────

    @Override
    public Widget build(BuildContext context) {
        String activePath = activeTabIndex >= 0 && activeTabIndex < tabs.size()
                ? tabs.get(activeTabIndex).path()
                : null;
        String activeFile = activeTabIndex >= 0 && activeTabIndex < tabs.size()
                ? tabs.get(activeTabIndex).fileName()
                : "";
        int errorCount = (int) problems.stream()
                .filter(p -> p.severity() == Problem.Severity.ERROR).count();
        int warnCount = (int) problems.stream()
                .filter(p -> p.severity() == Problem.Severity.WARN).count();
        List<ConsoleLine> console = SampleProject.console(running);

        Widget shell = Column().children(List.of(
                new MenuBar(dark, entryCtrl),
                new Toolbar(dark, running, entryCtrl, pulseCtrl,
                        this::toggleTheme, this::toggleRun),
                Expanded().child(mainRow(activePath)),
                new BottomPanel(dark, activeBottom, running, pulseCtrl, console, problems, this::selectBottom),
                new StatusBar(dark, running, pulseCtrl, errorCount, warnCount, activeFile)
        ));

        return Theme(
                dark ? ThemeData_dark().useMaterial3(true).build()
                     : ThemeData().useMaterial3(true).build(),
                Scaffold()
                        .backgroundColor(IdePalette.bgWindow(dark))
                        .body(FadeTransition(CurvedAnimation(entryCtrl, Curves.easeOut()).build())
                                .child(shell))
        ).build();
    }

    private Widget mainRow(String activePath) {
        return Row()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        new ProjectTree(dark, projectRoot,
                                expanded::contains,
                                p -> p != null && p.equals(activePath),
                                this::toggleFolder,
                                this::openFile),
                        Expanded().child(new EditorArea(dark, List.copyOf(tabs), activeTabIndex,
                                editorCtrl, this::selectTab, this::closeTab)),
                        new OutlinePanel(dark, activePath)
                ));
    }
}
