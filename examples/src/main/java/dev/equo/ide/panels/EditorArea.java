package dev.equo.ide.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.CodeSamples;
import dev.equo.ide.IdePalette;
import dev.equo.ide.model.EditorTab;
import dev.equo.ide.model.NodeKind;

/**
 * Central editor: tab strip on top, code viewer with gutter below.
 * The viewer fades in on every tab change via {@code editorCtrl}, giving
 * a subtle motion continuity that plain SWT tab folders don't provide.
 */
public class EditorArea extends SubStatelessWidget {

    private final boolean dark;
    private final List<EditorTab> tabs;
    private final int activeIndex;
    private final AnimationController editorCtrl;
    private final Consumer<Integer> onSelectTab;
    private final Consumer<Integer> onCloseTab;

    public EditorArea(boolean dark,
                      List<EditorTab> tabs,
                      int activeIndex,
                      AnimationController editorCtrl,
                      Consumer<Integer> onSelectTab,
                      Consumer<Integer> onCloseTab) {
        this.dark = dark;
        this.tabs = tabs;
        this.activeIndex = activeIndex;
        this.editorCtrl = editorCtrl;
        this.onSelectTab = onSelectTab;
        this.onCloseTab = onCloseTab;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .color(IdePalette.bgEditor(dark))
                .child(Column()
                        .crossAxisAlignment(CrossAxisAlignment.stretch)
                        .children(List.of(tabStrip(), Expanded().child(animatedViewer()))));
    }

    // ── Tab strip ────────────────────────────────────────────────────────────

    private Widget tabStrip() {
        List<WidgetI> tabWidgets = new ArrayList<>();
        for (int i = 0; i < tabs.size(); i++) tabWidgets.add(tabPill(i));
        tabWidgets.add(Expanded().child(SizedBox().height(1.0)));
        return Container()
                .height(38.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().bottom(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Row().children(tabWidgets));
    }

    private Widget tabPill(int i) {
        EditorTab t = tabs.get(i);
        boolean active = i == activeIndex;
        Color bg = active ? IdePalette.bgActiveTab(dark) : IdePalette.bgInactiveTab(dark);
        BorderSideI topBorder = active
                ? BorderSide().color(IdePalette.accent(dark)).width(2.0).build()
                : BorderSide().color(bg).width(2.0).build();

        Widget content = Container()
                .decoration(BoxDecoration()
                        .color(bg)
                        .border(Border()
                                .right(BorderSide().color(IdePalette.divider(dark)).width(1.0).build())
                                .top(topBorder)))
                .padding(EdgeInsets_symmetric().horizontal(14.0).build())
                .child(Row().mainAxisSize(MainAxisSize.min).children(List.of(
                        Icon(fileIcon(t).get())
                                .color(active ? IdePalette.accent(dark) : IdePalette.textMuted(dark))
                                .size(15.0),
                        SizedBox().width(8.0),
                        Text(t.fileName()).style(active
                                ? IdePalette.tabLabelActive(dark)
                                : IdePalette.tabLabelInactive(dark)),
                        SizedBox().width(10.0),
                        closeBtn(i)
                )));

        // TextButton wraps the pill so we get Material hover feedback (an
        // inset overlay) at no cost. onHover is a no-op — the hover paint
        // is entirely driven by the button's built-in Material state.
        return TextButton(() -> onSelectTab.accept(i))
                .onHover(hovering -> {})
                .child(content);
    }

    private Widget closeBtn(int i) {
        return IconButton()
                .icon(Icon(Icons.close_rounded())
                        .color(IdePalette.textMuted(dark)).size(14.0))
                .padding(EdgeInsets_all(2.0))
                .constraints(BoxConstraints().minWidth(20.0).minHeight(20.0).build())
                .hoverColor(IdePalette.accentError())
                .splashRadius(14.0)
                .onPressed(() -> onCloseTab.accept(i));
    }

    private Supplier<IconDataI> fileIcon(EditorTab t) {
        return switch (t.kind()) {
            case JAVA     -> Icons::code_rounded;
            case MARKDOWN -> Icons::description_rounded;
            case RESOURCE -> Icons::insert_drive_file_rounded;
            case FOLDER, PROJECT -> Icons::folder_rounded;
        };
    }

    // ── Code viewer ──────────────────────────────────────────────────────────

    private Widget animatedViewer() {
        return FadeTransition(CurvedAnimation(editorCtrl, Curves.easeOutCubic()).build())
                .child(viewer());
    }

    private Widget viewer() {
        if (tabs.isEmpty() || activeIndex < 0 || activeIndex >= tabs.size()) {
            return emptyState();
        }
        EditorTab active = tabs.get(activeIndex);
        return Container()
                .color(IdePalette.bgEditor(dark))
                .child(SingleChildScrollView()
                        .child(Padding(EdgeInsets_symmetric().vertical(14.0).build())
                                .child(Row()
                                        .crossAxisAlignment(CrossAxisAlignment.start)
                                        .children(List.of(
                                                gutter(active.path()),
                                                SizedBox().width(14.0),
                                                Expanded().child(codeBlock(active.path())),
                                                SizedBox().width(14.0)
                                        )))));
    }

    private Widget gutter(String path) {
        int lines = CodeSamples.lineCount(path);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= lines; i++) {
            sb.append(String.format("%3d%n", i));
        }
        return Container()
                .width(52.0)
                .padding(EdgeInsets_only().left(12.0).right(10.0).build())
                .child(Text(sb.toString()).style(IdePalette.gutter(dark)));
    }

    private Widget codeBlock(String path) {
        return RichText(CodeSamples.span(path, dark))
                .textAlign(TextAlign.left)
                .softWrap(false);
    }

    private Widget emptyState() {
        return Center().child(Column()
                .mainAxisSize(MainAxisSize.min)
                .children(List.of(
                        Icon(Icons.folder_open_rounded())
                                .color(IdePalette.textMuted(dark)).size(48.0),
                        SizedBox().height(12.0),
                        Text("No file open").style(IdePalette.uiMuted(dark)),
                        SizedBox().height(4.0),
                        Text("Pick one from the Explorer to get started.")
                                .style(IdePalette.uiMuted(dark))
                )));
    }
}
