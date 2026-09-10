package dev.equo.engagements.ui;

import java.util.ArrayList;
import java.util.List;

import dev.equo.ewt.CrossAxisAlignment;
import dev.equo.ewt.FontWeight;
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.Widget;
import dev.equo.ewt.WidgetI;

import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.Divider;
import static dev.equo.ewt.EWT.EdgeInsets_only;
import static dev.equo.ewt.EWT.Expanded;
import static dev.equo.ewt.EWT.Padding;
import static dev.equo.ewt.EWT.Row;
import static dev.equo.ewt.EWT.SizedBox;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;

/** Section title + optional trailing widget + hairline divider. */
public final class SectionHeader {

  private SectionHeader() {}

  public static Widget of(String title, boolean dark) { return of(title, dark, null); }

  public static Widget of(String title, boolean dark, WidgetI trailing) {
    List<WidgetI> row = new ArrayList<>();
    row.add(Expanded().child(Text(title).style(TextStyle()
        .fontSize(16.0).fontWeight(FontWeight.w600())
        .color(EngagementsTheme.muted(dark)))));
    if (trailing != null) row.add(trailing);
    return Padding(EdgeInsets_only().top(16.0).bottom(6.0).build()).child(Column()
        .crossAxisAlignment(CrossAxisAlignment.stretch)
        .children(List.of(
            Row().mainAxisAlignment(MainAxisAlignment.spaceBetween).children(row),
            SizedBox().height(4.0),
            Divider().height(1.0).thickness(1.0).color(EngagementsTheme.hairline(dark)))));
  }
}
