package dev.equo.ide.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;
import dev.equo.ide.model.NodeKind;
import dev.equo.ide.model.ProjectNode;

/**
 * Left navigation. Rows are {@link ListTile}s so we get real Material
 * hover feedback (hoverColor, splash, focus) for free — impossible to
 * reproduce with SWT's native item widgets.
 *
 * The folder chevron rotates via {@link Transform}, giving expand/collapse
 * a visual pivot instead of an icon swap.
 */
public class ProjectTree extends SubStatelessWidget {

    private final boolean dark;
    private final ProjectNode root;
    private final Predicate<String> isExpanded;
    private final Predicate<String> isActive;
    private final Consumer<String> onToggleFolder;
    private final Consumer<ProjectNode> onOpenFile;

    public ProjectTree(boolean dark,
                       ProjectNode root,
                       Predicate<String> isExpanded,
                       Predicate<String> isActive,
                       Consumer<String> onToggleFolder,
                       Consumer<ProjectNode> onOpenFile) {
        this.dark = dark;
        this.root = root;
        this.isExpanded = isExpanded;
        this.isActive = isActive;
        this.onToggleFolder = onToggleFolder;
        this.onOpenFile = onOpenFile;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .width(268.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().right(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Column()
                        .crossAxisAlignment(CrossAxisAlignment.stretch)
                        .children(List.of(header(), Expanded().child(body()))));
    }

    private Widget header() {
        return Container()
                .height(36.0)
                .padding(EdgeInsets_symmetric().horizontal(14.0).build())
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().bottom(BorderSide()
                                .color(IdePalette.divider(dark)).width(1.0).build())))
                .child(Row().children(List.of(
                        Container()
                                .width(6.0).height(6.0)
                                .decoration(BoxDecoration()
                                        .color(IdePalette.accent2(dark))
                                        .shape(BoxShape.circle)),
                        SizedBox().width(8.0),
                        Text("EXPLORER").style(IdePalette.sectionCaps(dark)),
                        Expanded().child(SizedBox().height(1.0)),
                        Icon(Icons.more_horiz_rounded())
                                .color(IdePalette.textMuted(dark)).size(16.0)
                )));
    }

    private Widget body() {
        return SingleChildScrollView().child(
                Padding(EdgeInsets_only().top(6.0).bottom(10.0).build())
                        .child(Column()
                                .crossAxisAlignment(CrossAxisAlignment.stretch)
                                .children(rows(root, 0))));
    }

    private List<WidgetI> rows(ProjectNode node, int depth) {
        List<WidgetI> out = new ArrayList<>();
        out.add(row(node, depth));
        if (node.isBranch() && isExpanded.test(node.path())) {
            for (ProjectNode child : node.children()) {
                out.addAll(rows(child, depth + 1));
            }
        }
        return out;
    }

    private Widget row(ProjectNode node, int depth) {
        boolean active = isActive.test(node.path()) && !node.isBranch();
        Runnable onTap = node.isBranch()
                ? () -> onToggleFolder.accept(node.path())
                : () -> onOpenFile.accept(node);

        Widget leadingRow = Row().mainAxisSize(MainAxisSize.min).children(List.of(
                caret(node),
                SizedBox().width(4.0),
                Icon(iconFor(node).get()).color(iconColor(node)).size(16.0)
        ));

        return ListTile()
                .dense(true)
                .selected(active)
                .selectedTileColor(IdePalette.selectionRow(dark))
                .hoverColor(IdePalette.hoverOverlay(dark))
                .contentPadding(EdgeInsets_only()
                        .left(10.0 + depth * 14.0).right(10.0).build())
                .minVerticalPadding(0.0)
                .horizontalTitleGap(8.0)
                .minLeadingWidth(38.0)
                .visualDensity(VisualDensity().horizontal(-4.0).vertical(-4.0).build())
                .leading(leadingRow)
                .title(Text(node.name())
                        .style(active ? IdePalette.uiStrong(dark) : IdePalette.ui(dark))
                        .overflow(TextOverflow.ellipsis))
                .onTap(onTap);
    }

    /** A single chevron rotated based on expansion state — reused per row. */
    private Widget caret(ProjectNode node) {
        if (!node.isBranch()) return SizedBox().width(12.0);
        boolean open = isExpanded.test(node.path());
        double turns = open ? 0.25 : 0.0;
        return Transform_rotate(turns * 2.0 * Math.PI)
                .child(Icon(Icons.chevron_right_rounded())
                        .color(IdePalette.textMuted(dark)).size(16.0));
    }

    private Supplier<IconDataI> iconFor(ProjectNode node) {
        return switch (node.kind()) {
            case PROJECT  -> Icons::inventory_2_rounded;
            case FOLDER   -> isExpanded.test(node.path())
                                ? Icons::folder_open_rounded
                                : Icons::folder_rounded;
            case JAVA     -> Icons::code_rounded;
            case MARKDOWN -> Icons::description_rounded;
            case RESOURCE -> Icons::insert_drive_file_rounded;
        };
    }

    private Color iconColor(ProjectNode node) {
        return switch (node.kind()) {
            case PROJECT  -> IdePalette.accent(dark);
            case FOLDER   -> IdePalette.accent2(dark);
            case JAVA     -> IdePalette.accent(dark);
            case MARKDOWN -> IdePalette.textMuted(dark);
            case RESOURCE -> IdePalette.textMuted(dark);
        };
    }
}
