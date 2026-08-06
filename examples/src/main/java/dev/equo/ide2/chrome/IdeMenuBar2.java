package dev.equo.ide2.chrome;

import java.util.List;
import java.util.function.Consumer;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * v2 menu bar. Where v1 (dev.equo.ide.chrome.MenuBar) hand-rolled the strip
 * as a Row of Text labels with no interaction, v2 uses the real Material
 * {@link MenuBar} + {@link SubmenuButton} + {@link MenuItemButton} —
 * clicking a top-level item opens a real Material menu whose items dispatch
 * to callbacks the shell passes in.
 */
public class IdeMenuBar2 extends SubStatelessWidget {

    private final boolean dark;
    private final AnimationController entryCtrl;
    private final Runnable onToggleTheme;
    private final Runnable onToggleRun;
    private final Runnable onOpenSettings;
    private final Consumer<String> onSelectPerspective;

    public IdeMenuBar2(boolean dark,
                       AnimationController entryCtrl,
                       Runnable onToggleTheme,
                       Runnable onToggleRun,
                       Runnable onOpenSettings,
                       Consumer<String> onSelectPerspective) {
        this.dark = dark;
        this.entryCtrl = entryCtrl;
        this.onToggleTheme = onToggleTheme;
        this.onToggleRun = onToggleRun;
        this.onOpenSettings = onOpenSettings;
        this.onSelectPerspective = onSelectPerspective;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .height(36.0)
                .color(IdePalette.bgMenuBar(dark))
                .padding(EdgeInsets_symmetric().horizontal(8.0).build())
                .child(Row().children(List.of(
                        brand(),
                        SizedBox().width(14.0),
                        Expanded().child(MenuBar()
                                .addAllChildren(List.of(
                                        fileMenu(),
                                        editMenu(),
                                        viewMenu(),
                                        runMenu(),
                                        perspectiveMenu(),
                                        helpMenu()))
                                .build())
                )));
    }

    private Widget brand() {
        Widget logo = Container()
                .width(20.0)
                .height(20.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.accent(dark))
                        .borderRadius(BorderRadius_circular(6.0))
                        .boxShadow(List.of(BoxShadow()
                                .color(IdePalette.glow(dark))
                                .blurRadius(10.0)
                                .offset(Offset(0.0, 2.0)))))
                .alignment(Alignment.center())
                .child(Text("E").style(TextStyle()
                        .fontSize(11.0)
                        .fontWeight(FontWeight.w800())
                        .color(Colors.white())));
        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                RotationTransition(CurvedAnimation(entryCtrl, Curves.easeOutBack()).build())
                        .child(logo),
                SizedBox().width(10.0),
                Text("EWT IDE").style(TextStyle()
                        .fontSize(13.0)
                        .fontWeight(FontWeight.w700())
                        .letterSpacing(0.3)
                        .color(IdePalette.textPrimary(dark)))
        ));
    }

    private Widget fileMenu() {
        return SubmenuButton()
                .addAllMenuChildren(List.of(
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.note_add_rounded()).size(16.0))
                                .child(Text("New File"))
                                .onPressed(() -> {}).build(),
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.folder_open_rounded()).size(16.0))
                                .child(Text("Open…"))
                                .onPressed(() -> {}).build(),
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.save_rounded()).size(16.0))
                                .child(Text("Save"))
                                .onPressed(() -> {}).build(),
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.exit_to_app_rounded()).size(16.0))
                                .child(Text("Exit"))
                                .onPressed(() -> {}).build()))
                .child(topLabel("File")).build();
    }

    private Widget editMenu() {
        return SubmenuButton()
                .addAllMenuChildren(List.of(
                        MenuItemButton().child(Text("Undo")).onPressed(() -> {}).build(),
                        MenuItemButton().child(Text("Redo")).onPressed(() -> {}).build(),
                        MenuItemButton().child(Text("Cut")).onPressed(() -> {}).build(),
                        MenuItemButton().child(Text("Copy")).onPressed(() -> {}).build(),
                        MenuItemButton().child(Text("Paste")).onPressed(() -> {}).build()))
                .child(topLabel("Edit")).build();
    }

    private Widget viewMenu() {
        return SubmenuButton()
                .addAllMenuChildren(List.of(
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.brightness_6_rounded()).size(16.0))
                                .child(Text("Toggle Theme"))
                                .onPressed(onToggleTheme).build(),
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.settings_rounded()).size(16.0))
                                .child(Text("Preferences…"))
                                .onPressed(onOpenSettings).build()))
                .child(topLabel("View")).build();
    }

    private Widget runMenu() {
        return SubmenuButton()
                .addAllMenuChildren(List.of(
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.play_arrow_rounded()).size(16.0))
                                .child(Text("Run / Stop"))
                                .onPressed(onToggleRun).build(),
                        MenuItemButton()
                                .leadingIcon(Icon(Icons.bug_report_rounded()).size(16.0))
                                .child(Text("Debug"))
                                .onPressed(() -> {}).build()))
                .child(topLabel("Run")).build();
    }

    private Widget perspectiveMenu() {
        return SubmenuButton()
                .addAllMenuChildren(List.of(
                        MenuItemButton().child(Text("Development"))
                                .onPressed(() -> onSelectPerspective.accept("Development")).build(),
                        MenuItemButton().child(Text("Debug"))
                                .onPressed(() -> onSelectPerspective.accept("Debug")).build(),
                        MenuItemButton().child(Text("Git"))
                                .onPressed(() -> onSelectPerspective.accept("Git")).build()))
                .child(topLabel("Perspective")).build();
    }

    private Widget helpMenu() {
        return SubmenuButton()
                .addAllMenuChildren(List.of(
                        MenuItemButton().child(Text("Documentation")).onPressed(() -> {}).build(),
                        MenuItemButton().child(Text("About EWT")).onPressed(() -> {}).build()))
                .child(topLabel("Help")).build();
    }

    private Widget topLabel(String label) {
        return Padding(EdgeInsets_symmetric().horizontal(6.0).build())
                .child(Text(label).style(IdePalette.menuItem(dark)));
    }
}
