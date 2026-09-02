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
                                                SwitchListTile(dark).onChanged(v -> onTheme.accept(v))
                                                        .title(Text("Dark theme").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),

                                                sectionCaps("EDITOR"),
                                                SwitchListTile(wordWrap).onChanged(v -> onWordWrap.accept(v))
                                                        .title(Text("Word wrap").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),
                                                CheckboxListTile().value(lineNumbers).onChanged(v -> onLineNumbers.accept(v))
                                                        .title(Text("Line numbers").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),

                                                sectionCaps("PANEL"),
                                                CheckboxListTile().value(panelVisible).onChanged(v -> onPanelVisible.accept(v))
                                                        .title(Text("Show bottom panel").style(IdePalette.ui(dark)))
                                                        .activeColor(IdePalette.accent(dark)),
                                                heightSlider(),

                                                sectionCaps("PROBLEMS FILTER"),
                                                filterRow(),

                                                sectionCaps("LICENSE"),
                                                licenseRow(context),

                                                sectionCaps("ABOUT"),
                                                aboutSection()
                                        ))))
                        )));
    }

    /**
     * Real Material DatePicker demo. Clicking "Change…" calls
     * EWT.showDatePicker with the outer build context — Flutter shows its
     * standard calendar dialog on top of the app.
     */
    private Widget licenseRow(BuildContext ctx) {
        return Padding(EdgeInsets_only().left(16.0).right(8.0).top(4.0).bottom(4.0).build())
                .child(Row().children(List.of(
                        Expanded().child(Text("License expiry: 2027-01-01")
                                .style(IdePalette.uiMuted(dark))),
                        TextButton().onPressed(() -> showDatePicker(
                                        ctx,
                                        DateTime(2026).month(1).day(1).build(),
                                        DateTime(2030).month(12).day(31).build()))
                                .child(Text("Change…").style(TextStyle()
                                        .color(IdePalette.accent(dark))
                                        .fontWeight(FontWeight.w600())))
                )));
    }

    /** Real Material ExpansionTile — replaces a hand-rolled collapsible section. */
    private Widget aboutSection() {
        return ExpansionTile()
                .title(Text("Legal notices").style(IdePalette.ui(dark)))
                .childrenPadding(EdgeInsets_symmetric().horizontal(16.0).vertical(4.0).build())
                .children(List.of(
                        Text("EWT is released under the EPL 2.0.")
                                .style(IdePalette.uiMuted(dark)),
                        SizedBox().height(6.0),
                        Text("© Equo 2026. Bundled Flutter & Dart under BSD-3.")
                                .style(IdePalette.uiMuted(dark))))
                .build();
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
                Checkbox().value(value).onChanged(v -> onChanged.accept(v)).activeColor(color),
                SizedBox().width(4.0),
                Text(label).style(IdePalette.ui(dark))
        ));
    }

    private Widget sectionCaps(String text) {
        return Padding(EdgeInsets_only().left(16.0).top(14.0).bottom(4.0).build())
                .child(Text(text).style(IdePalette.sectionCaps(dark)));
    }
}
