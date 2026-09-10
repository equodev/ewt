package dev.equo.engagements.ui;

import java.util.List;

import dev.equo.ewt.Colors;
import dev.equo.ewt.Widget;
import dev.equo.ewt.WidgetI;

import static dev.equo.ewt.EWT.BorderRadius_circular;
import static dev.equo.ewt.EWT.BoxDecoration;
import static dev.equo.ewt.EWT.ClipRRect;
import static dev.equo.ewt.EWT.Container;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.SizedBox;

/**
 * Horizontal stacked bar: billed / unbilled / free segments proportional to a
 * capacity total. Zero-width segments are omitted so the corners stay clean.
 */
public final class UtilizationBar {

  private UtilizationBar() {}

  public static Widget horizontal(double billed, double unbilled, double capacity, double height) {
    double free = Math.max(0.0, capacity - billed - unbilled);
    var segs = new java.util.ArrayList<WidgetI>();
    if (billed > 0)   segs.add(seg((int) Math.round(billed * 10),   Colors.teal().shade400()));
    if (unbilled > 0) segs.add(seg((int) Math.round(unbilled * 10), Colors.amber().shade400()));
    if (free > 0)     segs.add(seg((int) Math.round(free * 10),     Colors.grey().shade300()));
    if (segs.isEmpty()) segs.add(seg(10, Colors.grey().shade300()));
    return SizedBox().height(height).child(
        ClipRRect().borderRadius(BorderRadius_circular(4.0))
            .child(Row().children(List.of(segs.toArray(WidgetI[]::new)))));
  }

  private static WidgetI seg(int flex, dev.equo.ewt.ColorI color) {
    return Expanded().flex(Math.max(1, flex))
        .child(Container().decoration(BoxDecoration().color(color)));
  }
}
