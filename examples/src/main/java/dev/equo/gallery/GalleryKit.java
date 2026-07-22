package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;

/**
 * Presentation scaffolding shared by the widget galleries. Kept out of the
 * galleries themselves so each one reads as a list of the widgets it shows.
 */
public final class GalleryKit {

  private GalleryKit() {}

  /** A labelled row: the widget on the left, its name on the right. */
  public static Widget tile(String label, Widget demo) {
    return Padding(EdgeInsets_symmetric().vertical(8.0))
        .child(Row().children(List.of(
            SizedBox().width(96.0).height(72.0).child(Center().child(demo)),
            SizedBox().width(16.0),
            Text(label))));
  }

  /**
   * A visible bordered box of a fixed size. Widgets that align or size their
   * child (Align, FractionallySizedBox, AnimatedPadding...) need a parent with
   * definite bounds, and you need to see those bounds to judge the effect.
   */
  public static Widget stage(double w, double h, Widget child) {
    return Container()
        .width(w).height(h)
        .decoration(BoxDecoration()
            .color(Colors.white())
            .border(Border_all().color(Colors.grey()).width(1.0)))
        .child(child);
  }

  /** A filled rectangle of a definite size — safe to put inside any box. */
  public static Widget rect(double w, double h, ColorI c) {
    return SizedBox().width(w).height(h).child(ColoredBox(c));
  }

  /** A small filled square, for showing position. */
  public static Widget dot(ColorI c) {
    return rect(16.0, 16.0, c);
  }

  /** Standard page shell: themed MaterialApp + Scaffold + scrolling body. */
  public static Widget page(BuildContext ctx, String title, ColorI seed, List<WidgetI> children) {
    return Scaffold()
        .appBar(AppBar()
            .backgroundColor(Theme.of(ctx).colorScheme().inversePrimary())
            .title(Text(title)))
        .body(SingleChildScrollView()
            .child(Padding(EdgeInsets_all(20.0))
                .child(Column()
                    .crossAxisAlignment(CrossAxisAlignment.start)
                    .children(children))));
  }
}
