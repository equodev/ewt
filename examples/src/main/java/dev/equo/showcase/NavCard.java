package dev.equo.showcase;

import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Vivid navigation card used on the home page. Renders a leading icon, a
 * title + subtitle, and a trailing arrow. The whole card is tappable.
 *
 * The icon is received as a {@link Supplier} (not a pre-built IconData)
 * because EWT consumes a widget's native handle when the parent tree is
 * realized, and storing pre-built handles in fields makes them stale by
 * the time this child's build() is called. Calling the supplier inline
 * inside build() produces a fresh handle on every render.
 */
public class NavCard extends SubStatelessWidget {
    private final String title;
    private final String subtitle;
    private final Supplier<IconDataI> iconSupplier;
    private final Supplier<Color> colorSupplier;
    private final Runnable onTap;

    public NavCard(String title,
                   String subtitle,
                   Supplier<IconDataI> iconSupplier,
                   Supplier<Color> colorSupplier,
                   Runnable onTap) {
        this.title = title;
        this.subtitle = subtitle;
        this.iconSupplier = iconSupplier;
        this.colorSupplier = colorSupplier;
        this.onTap = onTap;
    }

    @Override
    protected Widget build(BuildContext context) {
        return GestureDetector()
                .onTap(onTap)
                .child(Container()
                        .decoration(BoxDecoration()
                                .color(colorSupplier.get())
                                .borderRadius(BorderRadius_circular(22.0))
                                .boxShadow(List.of(Palette.softShadow())))
                        .padding(EdgeInsets_symmetric().horizontal(20.0).vertical(18.0))
                        .child(Row()
                                .children(List.of(
                                        Icon(iconSupplier.get()).color(Colors.white()).size(36.0),
                                        SizedBox().width(18.0),
                                        Expanded().child(textColumn()),
                                        Icon(Icons.arrow_forward_rounded())
                                                .color(Colors.white())
                                                .size(22.0)
                                ))));
    }

    private Widget textColumn() {
        return Column()
                .crossAxisAlignment(CrossAxisAlignment.start)
                .mainAxisSize(MainAxisSize.min)
                .children(List.of(
                        Text(title).style(Palette.navTitle()),
                        SizedBox().height(2.0),
                        Text(subtitle).style(Palette.navSubtitle())
                ));
    }
}
