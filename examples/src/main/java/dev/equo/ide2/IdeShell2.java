package dev.equo.ide2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;
import dev.equo.ide.SampleProject;
import dev.equo.ide.chrome.MenuBar;
import dev.equo.ide.model.ConsoleLine;
import dev.equo.ide.model.EditorTab;
import dev.equo.ide.model.NodeKind;
import dev.equo.ide.model.Problem;
import dev.equo.ide.model.ProjectNode;
import dev.equo.ide.panels.OutlinePanel;
import dev.equo.ide2.chrome.StatusBar2;
import dev.equo.ide2.chrome.Toolbar2;
import dev.equo.ide2.panels.BottomPanel2;
import dev.equo.ide2.panels.EditorArea2;
import dev.equo.ide2.panels.ProjectTree2;
import dev.equo.ide2.panels.SettingsPanel2;

/**
 * v2 shell. Same overall layout as v1, but the bottom tabs are a real
 * TabController now (so no activeBottom / onSelectTab here), and there is a new
 * band of settings state — driven by the slide-in {@link SettingsPanel2} — that
 * actually changes the editor and panel:
 *
 *   settingsOpen  → slides the settings panel in (AnimatedContainer width)
 *   wordWrap      → EditorArea2 wraps long lines
 *   lineNumbers   → EditorArea2 gutter on/off
 *   panelVisible  → bottom panel shown/hidden
 *   panelHeight   → bottom panel height (Slider)
 */
public class IdeShell2 extends SubStatefulWidget {

    @Override
    protected State<IdeShell2> createState() {
        return new IdeShell2State();
    }
}

class IdeShell2State extends SubAnimatedState<IdeShell2> {

    private boolean dark = true;
    private boolean running = false;
    private final List<EditorTab> tabs = new ArrayList<>();
    private int activeTabIndex = -1;
    private final Set<String> expanded = new HashSet<>();

    // v2 settings state
    private boolean settingsOpen = false;
    private boolean wordWrap = false;
    private boolean lineNumbers = true;
    private boolean panelVisible = true;
    private double panelHeight = 210.0;
    private boolean showErrors = true;
    private boolean showWarnings = true;
    private boolean showInfo = true;

    // mutableRoot(): each folder's children list is an ArrayList so the
    // Explorer's drag-and-drop can reorder siblings in place.
    private final ProjectNode projectRoot = SampleProject.mutableRoot();
    private final List<Problem> problems = SampleProject.problems();

    // Drag-and-drop pending state. The Draggable's onDragStarted records
    // the source (tab index / node path); the DragTarget's onAccept fires
    // the actual move using the recorded source. Kept in state — no need
    // to marshal typed payloads across the Draggable/DragTarget generic.
    private int pendingDragTabIdx = -1;
    private String pendingDragNodePath = null;
    private String pendingDragParentPath = null;

    private AnimationController entryCtrl;
    private AnimationController pulseCtrl;
    private AnimationController editorCtrl;

    IdeShell2State() {
        expanded.add("sample-app");
        expanded.add("sample-app/src");
        tabs.add(new EditorTab("src/Main.java", "Main.java", NodeKind.JAVA));
        tabs.add(new EditorTab("README.md", "README.md", NodeKind.MARKDOWN));
        // Start on the Welcome screen (Home button / no active tab).
        activeTabIndex = -1;
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

    // ── Callbacks ──────────────────────────────────────────────────────────────

    private void toggleTheme()      { setState(() -> dark = !dark); }
    private void toggleRun()        { setState(() -> running = !running); }
    private void openSettings()     { setState(() -> settingsOpen = true); }
    private void closeSettings()    { setState(() -> settingsOpen = false); }
    private void setWordWrap(boolean v)     { setState(() -> wordWrap = v); }
    private void setLineNumbers(boolean v)  { setState(() -> lineNumbers = v); }
    private void setPanelVisible(boolean v) { setState(() -> panelVisible = v); }
    private void setPanelHeight(double v)   { setState(() -> panelHeight = v); }
    private void setShowErrors(boolean v)   { setState(() -> showErrors = v); }
    private void setShowWarnings(boolean v) { setState(() -> showWarnings = v); }
    private void setShowInfo(boolean v)     { setState(() -> showInfo = v); }

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

    // ── Drag-and-drop reordering ─────────────────────────────────────────────

    private void beginDragTab(int i) { pendingDragTabIdx = i; }

    private void dropOnTab(int targetIdx) {
        int from = pendingDragTabIdx;
        pendingDragTabIdx = -1;
        if (from < 0 || from == targetIdx || from >= tabs.size()) return;
        setState(() -> {
            EditorTab moving = tabs.remove(from);
            // dropping "on" targetIdx means "before" it — adjust for the removal.
            int insertAt = from < targetIdx ? targetIdx - 1 : targetIdx;
            tabs.add(insertAt, moving);
            if (activeTabIndex == from)                    activeTabIndex = insertAt;
            else if (from < activeTabIndex && activeTabIndex <= insertAt) activeTabIndex--;
            else if (insertAt <= activeTabIndex && activeTabIndex < from) activeTabIndex++;
        });
    }

    private void beginDragNode(ProjectNode node, String parentPath) {
        pendingDragNodePath = node.path();
        pendingDragParentPath = parentPath;
    }

    private void dropOnSibling(ProjectNode target, String parentPath) {
        String movingPath = pendingDragNodePath;
        String movingParent = pendingDragParentPath;
        pendingDragNodePath = null;
        pendingDragParentPath = null;
        // Same-folder reorder only for now — cross-folder moves need a mutable
        // parent-of relationship the record tree doesn't expose.
        if (movingPath == null || movingParent == null || !movingParent.equals(parentPath)) return;
        if (movingPath.equals(target.path())) return;
        List<ProjectNode> siblings = findChildrenOf(parentPath);
        if (siblings == null) return;
        int fromIdx = -1, toIdx = -1;
        for (int i = 0; i < siblings.size(); i++) {
            if (siblings.get(i).path().equals(movingPath)) fromIdx = i;
            if (siblings.get(i).path().equals(target.path())) toIdx = i;
        }
        if (fromIdx < 0 || toIdx < 0 || fromIdx == toIdx) return;
        final int finalFrom = fromIdx;
        final int finalTo = toIdx;
        setState(() -> {
            ProjectNode moving = siblings.remove(finalFrom);
            int insertAt = finalFrom < finalTo ? finalTo - 1 : finalTo;
            siblings.add(insertAt, moving);
        });
    }

    private List<ProjectNode> findChildrenOf(String path) {
        return findByPath(projectRoot, path);
    }

    private static List<ProjectNode> findByPath(ProjectNode node, String path) {
        if (node.path().equals(path)) return node.children();
        if (!node.isBranch()) return null;
        for (ProjectNode c : node.children()) {
            var r = findByPath(c, path);
            if (r != null) return r;
        }
        return null;
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

        // The severity checkboxes in Settings actually filter this list.
        List<Problem> visibleProblems = problems.stream().filter(p -> switch (p.severity()) {
            case ERROR -> showErrors;
            case WARN  -> showWarnings;
            case INFO  -> showInfo;
        }).toList();

        List<WidgetI> shellChildren = new ArrayList<>();
        shellChildren.add(new MenuBar(dark, entryCtrl));
        shellChildren.add(new Toolbar2(dark, running, errorCount, pulseCtrl,
                this::toggleTheme, this::toggleRun, this::openSettings));
        shellChildren.add(Expanded().child(mainRow(activePath)));
        if (panelVisible) {
            shellChildren.add(SizedBox().height(panelHeight).child(
                    new BottomPanel2(dark, running, pulseCtrl, console, visibleProblems)));
        }
        shellChildren.add(new StatusBar2(dark, running, pulseCtrl, errorCount, warnCount, activeFile));

        Widget shell = Column().children(shellChildren);

        // The whole window is a Row: the IDE on the left, the settings panel
        // sliding in on the right via an AnimatedContainer.
        Widget windowRow = Row()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        Expanded().child(FadeTransition(
                                        CurvedAnimation(entryCtrl, Curves.easeOut()).build())
                                .child(shell)),
                        settingsSlide()
                ));

        return Theme(
                dark ? ThemeData_dark().useMaterial3(true).build()
                     : ThemeData().useMaterial3(true).build(),
                Scaffold()
                        .backgroundColor(IdePalette.bgWindow(dark))
                        .body(windowRow)
        ).build();
    }

    private Widget mainRow(String activePath) {
        return Row()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        new ProjectTree2(dark, projectRoot,
                                expanded::contains,
                                p -> p != null && p.equals(activePath),
                                this::toggleFolder,
                                this::openFile,
                                this::beginDragNode,
                                this::dropOnSibling),
                        Expanded().child(new EditorArea2(dark, List.copyOf(tabs), activeTabIndex,
                                editorCtrl, lineNumbers, wordWrap, this::selectTab, this::closeTab,
                                this::beginDragTab, this::dropOnTab)),
                        new OutlinePanel(dark, activePath)
                ));
    }

    /**
     * Settings panel slide-in. The outer AnimatedContainer snaps the row slot
     * open almost instantly (80ms); the inner AnimatedSlide is the star of the
     * show, sliding the panel in from off-screen right over 380ms with an
     * easeOutCubic curve so the slide is clearly visible instead of racing
     * the container growth.
     */
    private Widget settingsSlide() {
        SettingsPanel2 panel = new SettingsPanel2(dark, wordWrap, lineNumbers,
                panelVisible, panelHeight, showErrors, showWarnings, showInfo,
                this::setTheme, this::setWordWrap, this::setLineNumbers,
                this::setPanelVisible, this::setPanelHeight,
                this::setShowErrors, this::setShowWarnings, this::setShowInfo,
                this::closeSettings);
        Widget slidingPanel = AnimatedSlide()
                .duration(Duration().milliseconds(380))
                .curve(Curves.easeOutCubic())
                .offset(Offset(settingsOpen ? 0.0 : 1.0, 0.0))
                .child(panel)
                .build();
        return ClipRect().child(AnimatedContainer()
                .duration(Duration().milliseconds(80))
                .curve(Curves.easeOut())
                .width(settingsOpen ? SettingsPanel2.WIDTH : 0.0)
                .child(OverflowBox()
                        .minWidth(SettingsPanel2.WIDTH)
                        .maxWidth(SettingsPanel2.WIDTH)
                        .alignment(Alignment.centerRight())
                        .child(slidingPanel)));
    }

    private void setTheme(boolean v) { setState(() -> dark = v); }
}
