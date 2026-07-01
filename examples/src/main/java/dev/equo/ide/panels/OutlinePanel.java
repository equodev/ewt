package dev.equo.ide.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.CodeSamples;
import dev.equo.ide.IdePalette;
import dev.equo.ide.model.OutlineItem;

/**
 * Right-side outline of the active file. Uses {@link ListTile} so each row
 * gets Material hover feedback for free.
 */
public class OutlinePanel extends SubStatelessWidget {

    private final boolean dark;
    private final String activePath;

    public OutlinePanel(boolean dark, String activePath) {
        this.dark = dark;
        this.activePath = activePath;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .width(268.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.bgPanel(dark))
                        .border(Border().left(BorderSide()
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
                                        .color(IdePalette.accent(dark))
                                        .shape(BoxShape.circle)),
                        SizedBox().width(8.0),
                        Text("OUTLINE").style(IdePalette.sectionCaps(dark)),
                        Expanded().child(SizedBox().height(1.0)),
                        Icon(Icons.filter_list_rounded())
                                .color(IdePalette.textMuted(dark)).size(16.0)
                )));
    }

    private Widget body() {
        List<OutlineItem> items = activePath == null ? List.of() : CodeSamples.outline(activePath);
        if (items.isEmpty()) return emptyState();
        List<WidgetI> rows = new ArrayList<>();
        for (OutlineItem it : items) rows.add(row(it));
        return SingleChildScrollView().child(
                Padding(EdgeInsets_only().top(6.0).bottom(10.0).build())
                        .child(Column()
                                .crossAxisAlignment(CrossAxisAlignment.stretch)
                                .children(rows)));
    }

    private Widget row(OutlineItem item) {
        Supplier<IconDataI> icon = iconFor(item.kind());
        return ListTile()
                .dense(true)
                .hoverColor(IdePalette.hoverOverlay(dark))
                .contentPadding(EdgeInsets_only()
                        .left(12.0 + item.depth() * 14.0).right(10.0).build())
                .minVerticalPadding(0.0)
                .horizontalTitleGap(8.0)
                .minLeadingWidth(20.0)
                .visualDensity(VisualDensity().horizontal(-4.0).vertical(-4.0).build())
                .leading(Icon(icon.get()).color(colorFor(item.kind())).size(15.0))
                .title(Text(item.signature()).style(IdePalette.ui(dark))
                        .overflow(TextOverflow.ellipsis))
                .onTap(() -> {});
    }

    private Supplier<IconDataI> iconFor(OutlineItem.Kind k) {
        return switch (k) {
            case CLASS   -> Icons::class_rounded;
            case METHOD  -> Icons::functions_rounded;
            case FIELD   -> Icons::data_object_rounded;
            case HEADING -> Icons::title_rounded;
        };
    }

    private Color colorFor(OutlineItem.Kind k) {
        return switch (k) {
            case CLASS   -> IdePalette.accent(dark);
            case METHOD  -> IdePalette.accent2(dark);
            case FIELD   -> IdePalette.accentRunning(dark);
            case HEADING -> IdePalette.textMuted(dark);
        };
    }

    private Widget emptyState() {
        return Center().child(Padding(EdgeInsets_all(20.0))
                .child(Text("No outline available.\nOpen a file to see its structure.")
                        .textAlign(TextAlign.center)
                        .style(IdePalette.uiMuted(dark))));
    }
}
