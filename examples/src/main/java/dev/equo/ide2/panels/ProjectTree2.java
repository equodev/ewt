package dev.equo.ide2.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;
import dev.equo.ide.model.ProjectNode;

/**
 * v2 Explorer. The folder chevron is a single {@code chevron_right} glyph wrapped
 * in an {@link AnimatedRotation}: it rotates a quarter turn as folders open and
 * close instead of jumping between two icons.
 */
public class ProjectTree2 extends SubStatelessWidget {

    private final boolean dark;
    private final ProjectNode root;
    private final Predicate<String> isExpanded;
    private final Predicate<String> isActive;
    private final Consumer<String> onToggleFolder;
    private final Consumer<ProjectNode> onOpenFile;
    private final BiConsumer<ProjectNode, String> onBeginDragNode;
    private final BiConsumer<ProjectNode, String> onDropOnSibling;
    private final Runnable onCollapseAll;

    public ProjectTree2(boolean dark,
                        ProjectNode root,
                        Predicate<String> isExpanded,
                        Predicate<String> isActive,
                        Consumer<String> onToggleFolder,
                        Consumer<ProjectNode> onOpenFile,
                        BiConsumer<ProjectNode, String> onBeginDragNode,
                        BiConsumer<ProjectNode, String> onDropOnSibling,
                        Runnable onCollapseAll) {
        this.dark = dark;
        this.root = root;
        this.isExpanded = isExpanded;
        this.isActive = isActive;
        this.onToggleFolder = onToggleFolder;
        this.onOpenFile = onOpenFile;
        this.onBeginDragNode = onBeginDragNode;
        this.onDropOnSibling = onDropOnSibling;
        this.onCollapseAll = onCollapseAll;
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
                        // Real Material PopupMenuButton — click the trailing icon
                        // to open a context menu with Explorer-scope actions.
                        PopupMenuButton(ctx -> List.of(
                                        PopupMenuItem().child(Text("Refresh")).build(),
                                        PopupMenuItem().child(Text("New Folder…")).build(),
                                        PopupMenuItem()
                                                .onTap(onCollapseAll)
                                                .child(Text("Collapse All")).build(),
                                        PopupMenuDivider().build(),
                                        PopupMenuItem().child(Text("Filter…")).build()))
                                .icon(Icon(Icons.more_horiz_rounded())
                                        .color(IdePalette.textMuted(dark)).size(16.0))
                                .tooltip("Explorer actions")
                                .padding(EdgeInsets_all(0.0).build())
                                .build()
                )));
    }

    private Widget body() {
        return SingleChildScrollView().child(
                Padding(EdgeInsets_only().top(6.0).bottom(10.0).build())
                        .child(Column()
                                .crossAxisAlignment(CrossAxisAlignment.stretch)
                                // Root node has no parent to reorder within → null parentPath.
                                .children(rows(root, 0, null))));
    }

    private List<WidgetI> rows(ProjectNode node, int depth, String parentPath) {
        List<WidgetI> out = new ArrayList<>();
        out.add(draggableRow(node, depth, parentPath));
        if (node.isBranch() && isExpanded.test(node.path())) {
            for (ProjectNode child : node.children()) {
                out.addAll(rows(child, depth + 1, node.path()));
            }
        }
        return out;
    }

    /**
     * Wraps {@link #row} in a {@link EWT#Draggable} (so the user can drag a
     * node) and a {@link EWT#DragTarget} (so dropping one node onto another
     * within the same parent triggers a reorder). Root itself and the top-level
     * project row are non-reorderable (parentPath == null).
     */
    private Widget draggableRow(ProjectNode node, int depth, String parentPath) {
        if (parentPath == null) {
            return row(node, depth, false);
        }
        return DragTarget((ctx, candidateData, rejectedData) -> {
            boolean hovering = !candidateData.isEmpty();
            Widget r = row(node, depth, hovering);
            return Draggable(r, rowFeedback(node))
                    .onDragStarted(() -> onBeginDragNode.accept(node, parentPath))
                    .maxSimultaneousDrags(1)
                    .build();
        }).onAccept(_data -> onDropOnSibling.accept(node, parentPath)).build();
    }

    /** Compact ghost shown at the drag pointer. */
    private Widget rowFeedback(ProjectNode node) {
        return Material().color(Colors.transparent()).child(Container()
                .padding(EdgeInsets_symmetric().horizontal(10.0).vertical(4.0).build())
                .decoration(BoxDecoration()
                        .color(IdePalette.selectionRow(dark))
                        .borderRadius(BorderRadius_circular(4.0))
                        .boxShadow(List.of(BoxShadow()
                                .color(Color.fromARGB(120, 0, 0, 0))
                                .blurRadius(8.0).offset(Offset(0.0, 2.0)))))
                .child(Row().mainAxisSize(MainAxisSize.min).children(List.of(
                        Icon(iconFor(node).get()).color(iconColor(node)).size(14.0),
                        SizedBox().width(6.0),
                        Text(node.name()).style(IdePalette.uiStrong(dark))
                ))));
    }

    private Widget row(ProjectNode node, int depth, boolean dropHover) {
        boolean active = isActive.test(node.path()) && !node.isBranch();
        Runnable onTap = node.isBranch()
                ? () -> onToggleFolder.accept(node.path())
                : () -> onOpenFile.accept(node);

        Widget leadingRow = Row().mainAxisSize(MainAxisSize.min).children(List.of(
                caret(node),
                SizedBox().width(4.0),
                Icon(iconFor(node).get()).color(iconColor(node)).size(16.0)
        ));

        // dropHover highlight: a thin accent line at the top of the row shows
        // where a dropped sibling will land.
        Color hoverColor = dropHover ? IdePalette.accent(dark) : IdePalette.hoverOverlay(dark);
        return Container()
                .decoration(dropHover
                        ? BoxDecoration().border(Border().top(BorderSide()
                                .color(IdePalette.accent(dark)).width(2.0).build()))
                        : BoxDecoration())
                .child(ListTile()
                        .dense(true)
                        .selected(active)
                        .selectedTileColor(IdePalette.selectionRow(dark))
                        .hoverColor(hoverColor)
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
                        .onTap(onTap));
    }

    /** Rotating chevron with a satisfying bounce on open/close. */
    private Widget caret(ProjectNode node) {
        if (!node.isBranch()) return SizedBox().width(16.0);
        boolean open = isExpanded.test(node.path());
        return AnimatedRotation()
                .turns(open ? 0.25 : 0.0)
                .duration(Duration().milliseconds(320))
                .curve(Curves.easeOutBack())
                .child(Icon(Icons.chevron_right_rounded())
                        .color(IdePalette.textMuted(dark)).size(16.0))
                .build();
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
