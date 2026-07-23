package dev.equo.ide2.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.CodeSamples;
import dev.equo.ide.IdePalette;
import dev.equo.ide.model.EditorTab;

/**
 * v2 editor. Same look as v1's EditorArea, but two things are now driven by the
 * Settings panel so the toggles there are real, not decorative:
 *   - {@code showGutter}  → line-number gutter is shown or hidden
 *   - {@code wordWrap}    → the code viewer wraps long lines instead of scrolling
 */
public class EditorArea2 extends SubStatelessWidget {

    private final boolean dark;
    private final List<EditorTab> tabs;
    private final int activeIndex;
    private final AnimationController editorCtrl;
    private final boolean showGutter;
    private final boolean wordWrap;
    private final Consumer<Integer> onSelectTab;
    private final Consumer<Integer> onCloseTab;

    public EditorArea2(boolean dark,
                       List<EditorTab> tabs,
                       int activeIndex,
                       AnimationController editorCtrl,
                       boolean showGutter,
                       boolean wordWrap,
                       Consumer<Integer> onSelectTab,
                       Consumer<Integer> onCloseTab) {
        this.dark = dark;
        this.tabs = tabs;
        this.activeIndex = activeIndex;
        this.editorCtrl = editorCtrl;
        this.showGutter = showGutter;
        this.wordWrap = wordWrap;
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

    private Widget tabStrip() {
        List<WidgetI> tabWidgets = new ArrayList<>();
        tabWidgets.add(Center().child(homeButton()));
        for (int i = 0; i < tabs.size(); i++) tabWidgets.add(tabPill(i));
        tabWidgets.add(Expanded().child(SizedBox()));
        return Container()
                .height(38.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().bottom(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                // stretch makes each tab fill the strip height, so they sit flush
                // to the bottom instead of floating centered.
                .child(Row().crossAxisAlignment(CrossAxisAlignment.stretch).children(tabWidgets));
    }

    private Widget tabPill(int i) {
        EditorTab t = tabs.get(i);
        boolean active = i == activeIndex;
        Color bg = active ? IdePalette.bgActiveTab(dark) : IdePalette.bgInactiveTab(dark);
        BorderSideI topBorder = active
                ? BorderSide().color(IdePalette.accent(dark)).width(2.0).build()
                : BorderSide().color(bg).width(2.0).build();

        // A plain GestureDetector + full-height Container: no TextButton, so no
        // rounded "pill" hover overlay and no extra side padding. The active tab
        // reads by its editor-colored background and a 2px accent top border.
        return GestureDetector().onTap(() -> onSelectTab.accept(i)).child(Container()
                .decoration(BoxDecoration()
                        .color(bg)
                        .border(Border()
                                .right(BorderSide().color(IdePalette.divider(dark)).width(1.0).build())
                                .top(topBorder)))
                .padding(EdgeInsets_symmetric().horizontal(14.0).build())
                .child(Center().child(Row().mainAxisSize(MainAxisSize.min).children(List.of(
                        Icon(fileIcon(t).get())
                                .color(active ? IdePalette.accent(dark) : IdePalette.textMuted(dark))
                                .size(15.0),
                        SizedBox().width(8.0),
                        Text(t.fileName()).style(active
                                ? IdePalette.tabLabelActive(dark)
                                : IdePalette.tabLabelInactive(dark)),
                        SizedBox().width(10.0),
                        closeBtn(i)
                )))));
    }

    /** Home button — selects the Welcome screen (activeIndex = -1). */
    private Widget homeButton() {
        boolean active = activeIndex < 0;
        return IconButton()
                .icon(Icon(Icons.home_rounded())
                        .color(active ? IdePalette.accent(dark) : IdePalette.textMuted(dark)).size(17.0))
                .tooltip("Welcome")
                .hoverColor(IdePalette.hoverOverlay(dark))
                .onPressed(() -> onSelectTab.accept(-1));
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

    private Widget animatedViewer() {
        return FadeTransition(CurvedAnimation(editorCtrl, Curves.easeOutCubic()).build())
                .child(viewer());
    }

    private Widget viewer() {
        if (tabs.isEmpty() || activeIndex < 0 || activeIndex >= tabs.size()) {
            return new WelcomeScreen2(dark);
        }
        EditorTab active = tabs.get(activeIndex);
        List<WidgetI> row = new ArrayList<>();
        if (showGutter) {
            row.add(gutter(active.path()));
            row.add(SizedBox().width(14.0));
        } else {
            row.add(SizedBox().width(14.0));
        }
        row.add(Expanded().child(codeBlock(active.path())));
        row.add(SizedBox().width(14.0));

        return Container()
                .color(IdePalette.bgEditor(dark))
                .child(SingleChildScrollView()
                        .child(Padding(EdgeInsets_symmetric().vertical(14.0).build())
                                .child(Row()
                                        .crossAxisAlignment(CrossAxisAlignment.start)
                                        .children(row))));
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
        // wordWrap flips softWrap: v1 always scrolls; v2 lets Settings choose.
        return RichText(CodeSamples.span(path, dark))
                .textAlign(TextAlign.left)
                .softWrap(wordWrap);
    }

}
