package dev.equo.ide2.panels;

import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * The "Welcome" surface shown in the editor when no file is open — a swipeable
 * {@link PageView} of three pages, the middle one a {@link GridView} of
 * quick-start cards. It is stateful only to light up the page dots as you swipe
 * (driven by {@link PageView}'s onPageChanged).
 */
public class WelcomeScreen2 extends SubStatefulWidget {

    private final boolean dark;

    public WelcomeScreen2(boolean dark) {
        this.dark = dark;
    }

    @Override
    protected State<WelcomeScreen2> createState() {
        return new WelcomeState(dark);
    }
}

class WelcomeState extends SubState<WelcomeScreen2> {

    private final boolean dark;
    private int page = 0;

    WelcomeState(boolean dark) {
        this.dark = dark;
    }

    @Override
    public Widget build(BuildContext context) {
        return Container()
                .color(IdePalette.bgEditor(dark))
                .child(Column().children(List.of(
                        Expanded().child(PageView()
                                .children(List.of(heroPage(), actionsPage(), tipsPage()))
                                .onPageChanged(i -> setState(() -> page = i))),
                        dots()
                )));
    }

    // ── Page 1: hero ───────────────────────────────────────────────────────────

    private Widget heroPage() {
        return Center().child(Column()
                .mainAxisSize(MainAxisSize.min)
                .children(List.of(
                        Icon(Icons.rocket_launch_rounded()).color(IdePalette.accent(dark)).size(64.0),
                        SizedBox().height(18.0),
                        Text("Welcome to EWT IDE v2").style(TextStyle()
                                .fontSize(24.0).fontWeight(FontWeight.w700())
                                .color(IdePalette.textPrimary(dark))),
                        SizedBox().height(8.0),
                        Text("Built in Java, rendered by Flutter.").style(IdePalette.uiMuted(dark)),
                        SizedBox().height(24.0),
                        Row().mainAxisSize(MainAxisSize.min).children(List.of(
                                Text("Swipe to explore ").style(IdePalette.uiMuted(dark)),
                                Icon(Icons.arrow_forward_rounded())
                                        .color(IdePalette.accent2(dark)).size(16.0)
                        ))
                )));
    }

    // ── Page 2: quick-start grid ─────────────────────────────────────────────────

    private Widget actionsPage() {
        // The grid is capped in width and centered so the cards stay a sensible
        // size instead of stretching across the whole (wide) editor area.
        return Center().child(ConstrainedBox(BoxConstraints().maxWidth(560.0).build())
                .child(Padding(EdgeInsets_all(28.0)).child(Column()
                        .mainAxisSize(MainAxisSize.min)
                        .crossAxisAlignment(CrossAxisAlignment.start)
                        .children(List.of(
                                Text("Quick start").style(TextStyle()
                                        .fontSize(18.0).fontWeight(FontWeight.w700())
                                        .color(IdePalette.textPrimary(dark))),
                                SizedBox().height(16.0),
                                GridView_count()
                                        .crossAxisCount(2)
                                        .mainAxisSpacing(12.0)
                                        .crossAxisSpacing(12.0)
                                        .childAspectRatio(3.4)
                                        .shrinkWrap(true)
                                        .children(List.of(
                                                card(Icons::note_add_rounded, "New File", IdePalette.accent(dark)),
                                                card(Icons::folder_open_rounded, "Open Folder", IdePalette.accent2(dark)),
                                                card(Icons::cloud_download_rounded, "Clone Repo", IdePalette.accentRunning(dark)),
                                                card(Icons::terminal_rounded, "New Terminal", IdePalette.accent(dark))
                                        ))
                        )))));
    }

    private Widget card(Supplier<IconDataI> icon, String label, Color accent) {
        // GestureDetector, not TextButton — the card's own rounded border is the
        // whole look, with no oversized pill overlay on hover.
        return GestureDetector().onTap(() -> {}).child(Container()
                .padding(EdgeInsets_symmetric().horizontal(16.0).build())
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .borderRadius(BorderRadius_circular(10.0))
                        .border(Border_all().color(IdePalette.divider(dark)).width(1.0).build()))
                .child(Row().children(List.of(
                        Icon(icon.get()).color(accent).size(22.0),
                        SizedBox().width(12.0),
                        Expanded().child(Text(label).style(IdePalette.uiStrong(dark)))
                ))));
    }

    // ── Page 3: tips ─────────────────────────────────────────────────────────────

    private Widget tipsPage() {
        return Padding(EdgeInsets_all(28.0)).child(Column()
                .crossAxisAlignment(CrossAxisAlignment.start)
                .mainAxisAlignment(MainAxisAlignment.center)
                .children(List.of(
                        Text("Tips").style(TextStyle()
                                .fontSize(18.0).fontWeight(FontWeight.w700())
                                .color(IdePalette.textPrimary(dark))),
                        SizedBox().height(16.0),
                        tip(Icons::tune_rounded, "Open Settings (⚙) to toggle word wrap, line numbers and panel height."),
                        tip(Icons::tab_rounded, "The bottom panel is a real TabBar — Console, Problems, Terminal."),
                        tip(Icons::palette_rounded, "Switch light/dark from the toolbar or the Settings panel.")
                )));
    }

    private Widget tip(Supplier<IconDataI> icon, String text) {
        return Padding(EdgeInsets_only().bottom(12.0).build()).child(Row()
                .crossAxisAlignment(CrossAxisAlignment.start)
                .children(List.of(
                        Icon(icon.get()).color(IdePalette.accent2(dark)).size(16.0),
                        SizedBox().width(10.0),
                        Expanded().child(Text(text).style(IdePalette.ui(dark)))
                )));
    }

    // ── Page dots ────────────────────────────────────────────────────────────────

    private Widget dots() {
        return Padding(EdgeInsets_only().bottom(20.0).top(4.0).build())
                .child(Row().mainAxisAlignment(MainAxisAlignment.center).children(List.of(
                        dot(0), dot(1), dot(2)
                )));
    }

    private Widget dot(int i) {
        boolean on = i == page;
        return AnimatedContainer()
                .duration(Duration().milliseconds(200))
                .width(on ? 20.0 : 7.0).height(7.0)
                .margin(EdgeInsets_symmetric().horizontal(3.0).build())
                .decoration(BoxDecoration()
                        .color(on ? IdePalette.accent(dark) : IdePalette.divider(dark))
                        .borderRadius(BorderRadius_circular(4.0)));
    }
}
