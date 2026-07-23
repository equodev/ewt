package dev.equo.ide2.panels;

import java.util.List;
import java.util.function.Consumer;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * Slide-in settings panel. Every control here is wired to real shell state, so
 * flipping one changes the IDE immediately — the round trip Flutter → C → Java →
 * setState → rebuild is the whole point.
 *
 *   - Dark theme        → SwitchListTile   (repaints the whole shell)
 *   - Word wrap         → SwitchListTile   (EditorArea2.softWrap)
 *   - Line numbers      → CheckboxListTile (EditorArea2 gutter)
 *   - Show bottom panel → CheckboxListTile (BottomPanel2 visibility)
 *   - Panel height      → Slider           (bottom-panel height)
 *
 * The Material Drawer widget would be the natural home for this, but it needs
 * Scaffold.openDrawer()/a ScaffoldState, which the API does not expose yet — so
 * the shell animates this panel in itself with an AnimatedContainer.
 */
public class SettingsPanel2 extends SubStatelessWidget {

    public static final double WIDTH = 300.0;

    private final boolean dark;
    private final boolean wordWrap;
    private final boolean lineNumbers;
    private final boolean panelVisible;
    private final double panelHeight;
    private final boolean showErrors;
    private final boolean showWarnings;
    private final boolean showInfo;
    private final Consumer<Boolean> onTheme;
    private final Consumer<Boolean> onWordWrap;
    private final Consumer<Boolean> onLineNumbers;
    private final Consumer<Boolean> onPanelVisible;
    private final Consumer<Double> onPanelHeight;
    private final Consumer<Boolean> onShowErrors;
    private final Consumer<Boolean> onShowWarnings;
    private final Consumer<Boolean> onShowInfo;
    private final Runnable onClose;

    public SettingsPanel2(boolean dark, boolean wordWrap, boolean lineNumbers,
                          boolean panelVisible, double panelHeight,
                          boolean showErrors, boolean showWarnings, boolean showInfo,
                          Consumer<Boolean> onTheme, Consumer<Boolean> onWordWrap,
                          Consumer<Boolean> onLineNumbers, Consumer<Boolean> onPanelVisible,
                          Consumer<Double> onPanelHeight,
                          Consumer<Boolean> onShowErrors, Consumer<Boolean> onShowWarnings,
                          Consumer<Boolean> onShowInfo, Runnable onClose) {
        this.dark = dark;
        this.wordWrap = wordWrap;
        this.lineNumbers = lineNumbers;
        this.panelVisible = panelVisible;
        this.panelHeight = panelHeight;
        this.showErrors = showErrors;
        this.showWarnings = showWarnings;
        this.showInfo = showInfo;
        this.onTheme = onTheme;
        this.onWordWrap = onWordWrap;
        this.onLineNumbers = onLineNumbers;
        this.onPanelVisible = onPanelVisible;
        this.onPanelHeight = onPanelHeight;
        this.onShowErrors = onShowErrors;
        this.onShowWarnings = onShowWarnings;
        this.onShowInfo = onShowInfo;
        this.onClose = onClose;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .width(WIDTH)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().left(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Column()
                        .crossAxisAlignment(CrossAxisAlignment.stretch)
                        .children(List.of(
                                header(),
                                Expanded().child(SingleChildScrollView().child(Column()
                                        .crossAxisAlignment(CrossAxisAlignment.stretch)
                                        .children(List.of(
                                                sectionCaps("APPEARANCE"),
                                                SwitchListTile(dark, v -> onTheme.accept(v))
                                                        .title(Text("Dark theme").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),

                                                sectionCaps("EDITOR"),
                                                SwitchListTile(wordWrap, v -> onWordWrap.accept(v))
                                                        .title(Text("Word wrap").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),
                                                CheckboxListTile(lineNumbers, v -> onLineNumbers.accept(v))
                                                        .title(Text("Line numbers").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),

                                                sectionCaps("PANEL"),
                                                CheckboxListTile(panelVisible, v -> onPanelVisible.accept(v))
                                                        .title(Text("Show bottom panel").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),
                                                heightSlider(),

                                                sectionCaps("PROBLEMS FILTER"),
                                                filterRow()
                                        ))))
                        )));
    }

    private Widget header() {
        return Container()
                .height(46.0)
                .padding(EdgeInsets_only().left(16.0).right(6.0).build())
                .decoration(BoxDecoration()
                        .color(IdePalette.bgToolbar(dark))
                        .border(Border().bottom(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Row().children(List.of(
                        Icon(Icons.tune_rounded()).color(IdePalette.accent2(dark)).size(18.0),
                        SizedBox().width(10.0),
                        Expanded().child(Text("Settings").style(IdePalette.uiStrong(dark))),
                        Tooltip().message("Close settings").child(IconButton()
                                .icon(Icon(Icons.close_rounded())
                                        .color(IdePalette.textMuted(dark)).size(18.0))
                                .hoverColor(IdePalette.hoverOverlay(dark))
                                .onPressed(onClose))
                )));
    }

    private Widget heightSlider() {
        return Padding(EdgeInsets_symmetric().horizontal(16.0).build())
                .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                        Row().children(List.of(
                                Expanded().child(Text("Panel height").style(IdePalette.uiMuted(dark))),
                                Text(((int) panelHeight) + "px").style(IdePalette.uiMuted(dark)))),
                        Slider(panelHeight).onChanged(v -> onPanelHeight.accept(v))
                                .min(120.0).max(320.0)
                                .activeColor(IdePalette.accent(dark))
                                .inactiveColor(IdePalette.divider(dark))
                )));
    }

    /** Three bare Checkboxes that filter the Problems list by severity. */
    private Widget filterRow() {
        return Padding(EdgeInsets_symmetric().horizontal(8.0).build())
                .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                        filterChip("Errors", showErrors, IdePalette.accentError(), onShowErrors),
                        filterChip("Warnings", showWarnings, IdePalette.accentWarn(), onShowWarnings),
                        filterChip("Info", showInfo, IdePalette.accentInfo(dark), onShowInfo)
                )));
    }

    private Widget filterChip(String label, boolean value, Color color, Consumer<Boolean> onChanged) {
        return Row().children(List.of(
                Checkbox(value).onChanged(v -> onChanged.accept(v)).activeColor(color),
                SizedBox().width(4.0),
                Text(label).style(IdePalette.ui(dark))
        ));
    }

    private Widget sectionCaps(String text) {
        return Padding(EdgeInsets_only().left(16.0).top(14.0).bottom(4.0).build())
                .child(Text(text).style(IdePalette.sectionCaps(dark)));
    }
}
